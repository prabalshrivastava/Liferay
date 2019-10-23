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

import com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.model.impl.SPUserTypeImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p user type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserTypePersistence
 * @see SPUserTypeUtil
 * @generated
 */
public class SPUserTypePersistenceImpl extends BasePersistenceImpl<SPUserType>
	implements SPUserTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPUserTypeUtil} to access the s p user type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPUserTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPUserTypeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p user types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid(String uuid, int start, int end,
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

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserType spUserType : list) {
				if (!Validator.equals(uuid, spUserType.getUuid())) {
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

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

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
				query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p user type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByUuid_First(uuid, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the first s p user type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByUuid_Last(uuid, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the last s p user type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPUserType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user types before and after the current s p user type in the ordered set where uuid = &#63;.
	 *
	 * @param spUserTypeId the primary key of the current s p user type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType[] findByUuid_PrevAndNext(long spUserTypeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByPrimaryKey(spUserTypeId);

		Session session = null;

		try {
			session = openSession();

			SPUserType[] array = new SPUserTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spUserType, uuid,
					orderByComparator, true);

			array[1] = spUserType;

			array[2] = getByUuid_PrevAndNext(session, spUserType, uuid,
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

	protected SPUserType getByUuid_PrevAndNext(Session session,
		SPUserType spUserType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

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
			query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spUserType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPUserType spUserType : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p user types
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

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spUserType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spUserType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spUserType.uuid IS NULL OR spUserType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPUserTypeModelImpl.UUID_COLUMN_BITMASK |
			SPUserTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p user type where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByUUID_G(String uuid, long groupId)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByUUID_G(uuid, groupId);

		if (spUserType == null) {
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

			throw new NoSuchSPUserTypeException(msg.toString());
		}

		return spUserType;
	}

	/**
	 * Returns the s p user type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p user type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPUserType) {
			SPUserType spUserType = (SPUserType)result;

			if (!Validator.equals(uuid, spUserType.getUuid()) ||
					(groupId != spUserType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

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

				List<SPUserType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPUserType spUserType = list.get(0);

					result = spUserType;

					cacheResult(spUserType);

					if ((spUserType.getUuid() == null) ||
							!spUserType.getUuid().equals(uuid) ||
							(spUserType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spUserType);
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
			return (SPUserType)result;
		}
	}

	/**
	 * Removes the s p user type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p user type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByUUID_G(uuid, groupId);

		return remove(spUserType);
	}

	/**
	 * Returns the number of s p user types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p user types
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

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spUserType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spUserType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spUserType.uuid IS NULL OR spUserType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spUserType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPUserTypeModelImpl.UUID_COLUMN_BITMASK |
			SPUserTypeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p user types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findByUuid_C(String uuid, long companyId,
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

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserType spUserType : list) {
				if (!Validator.equals(uuid, spUserType.getUuid()) ||
						(companyId != spUserType.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

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
				query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the first s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the last s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPUserType> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user types before and after the current s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spUserTypeId the primary key of the current s p user type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType[] findByUuid_C_PrevAndNext(long spUserTypeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByPrimaryKey(spUserTypeId);

		Session session = null;

		try {
			session = openSession();

			SPUserType[] array = new SPUserTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spUserType, uuid,
					companyId, orderByComparator, true);

			array[1] = spUserType;

			array[2] = getByUuid_C_PrevAndNext(session, spUserType, uuid,
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

	protected SPUserType getByUuid_C_PrevAndNext(Session session,
		SPUserType spUserType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

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
			query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spUserType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPUserType spUserType : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p user types
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

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spUserType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spUserType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spUserType.uuid IS NULL OR spUserType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spUserType.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpSiteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpSiteId",
			new String[] { Long.class.getName() },
			SPUserTypeModelImpl.SPSITEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPSITEID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpSiteId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p user types where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @return the matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteId(long spSiteId)
		throws SystemException {
		return findBySpSiteId(spSiteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p user types where spSiteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteId(long spSiteId, int start, int end)
		throws SystemException {
		return findBySpSiteId(spSiteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user types where spSiteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteId(long spSiteId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEID;
			finderArgs = new Object[] { spSiteId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEID;
			finderArgs = new Object[] { spSiteId, start, end, orderByComparator };
		}

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserType spUserType : list) {
				if ((spSiteId != spUserType.getSpSiteId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEID_SPSITEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				if (!pagination) {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p user type in the ordered set where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteId_First(long spSiteId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteId_First(spSiteId,
				orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the first s p user type in the ordered set where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteId_First(long spSiteId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserType> list = findBySpSiteId(spSiteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteId_Last(long spSiteId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteId_Last(spSiteId, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteId_Last(long spSiteId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySpSiteId(spSiteId);

		if (count == 0) {
			return null;
		}

		List<SPUserType> list = findBySpSiteId(spSiteId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63;.
	 *
	 * @param spUserTypeId the primary key of the current s p user type
	 * @param spSiteId the sp site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType[] findBySpSiteId_PrevAndNext(long spUserTypeId,
		long spSiteId, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByPrimaryKey(spUserTypeId);

		Session session = null;

		try {
			session = openSession();

			SPUserType[] array = new SPUserTypeImpl[3];

			array[0] = getBySpSiteId_PrevAndNext(session, spUserType, spSiteId,
					orderByComparator, true);

			array[1] = spUserType;

			array[2] = getBySpSiteId_PrevAndNext(session, spUserType, spSiteId,
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

	protected SPUserType getBySpSiteId_PrevAndNext(Session session,
		SPUserType spUserType, long spSiteId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

		query.append(_FINDER_COLUMN_SPSITEID_SPSITEID_2);

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
			query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spSiteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user types where spSiteId = &#63; from the database.
	 *
	 * @param spSiteId the sp site ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpSiteId(long spSiteId) throws SystemException {
		for (SPUserType spUserType : findBySpSiteId(spSiteId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types where spSiteId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @return the number of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpSiteId(long spSiteId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPSITEID;

		Object[] finderArgs = new Object[] { spSiteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEID_SPSITEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

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

	private static final String _FINDER_COLUMN_SPSITEID_SPSITEID_2 = "spUserType.spSiteId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySpSiteIdAndUserIdAndUserTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPUserTypeModelImpl.SPSITEID_COLUMN_BITMASK |
			SPUserTypeModelImpl.USERID_COLUMN_BITMASK |
			SPUserTypeModelImpl.USERTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpSiteIdAndUserIdAndUserTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param userTypeId the user type ID
	 * @return the matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteIdAndUserIdAndUserTypeId(spSiteId,
				userId, userTypeId);

		if (spUserType == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spSiteId=");
			msg.append(spSiteId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", userTypeId=");
			msg.append(userTypeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPUserTypeException(msg.toString());
		}

		return spUserType;
	}

	/**
	 * Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param userTypeId the user type ID
	 * @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId) throws SystemException {
		return fetchBySpSiteIdAndUserIdAndUserTypeId(spSiteId, userId,
			userTypeId, true);
	}

	/**
	 * Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param userTypeId the user type ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spSiteId, userId, userTypeId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
					finderArgs, this);
		}

		if (result instanceof SPUserType) {
			SPUserType spUserType = (SPUserType)result;

			if ((spSiteId != spUserType.getSpSiteId()) ||
					(userId != spUserType.getUserId()) ||
					(userTypeId != spUserType.getUserTypeId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				qPos.add(userId);

				qPos.add(userTypeId);

				List<SPUserType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
						finderArgs, list);
				}
				else {
					SPUserType spUserType = list.get(0);

					result = spUserType;

					cacheResult(spUserType);

					if ((spUserType.getSpSiteId() != spSiteId) ||
							(spUserType.getUserId() != userId) ||
							(spUserType.getUserTypeId() != userTypeId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
							finderArgs, spUserType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
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
			return (SPUserType)result;
		}
	}

	/**
	 * Removes the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; from the database.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param userTypeId the user type ID
	 * @return the s p user type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType removeBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findBySpSiteIdAndUserIdAndUserTypeId(spSiteId,
				userId, userTypeId);

		return remove(spUserType);
	}

	/**
	 * Returns the number of s p user types where spSiteId = &#63; and userId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param userTypeId the user type ID
	 * @return the number of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID;

		Object[] finderArgs = new Object[] { spSiteId, userId, userTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				qPos.add(userId);

				qPos.add(userTypeId);

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

	private static final String _FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_SPSITEID_2 =
		"spUserType.spSiteId = ? AND ";
	private static final String _FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERID_2 =
		"spUserType.userId = ? AND ";
	private static final String _FINDER_COLUMN_SPSITEIDANDUSERIDANDUSERTYPEID_USERTYPEID_2 =
		"spUserType.userTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEIDANDUSERID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpSiteIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySpSiteIdAndUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPUserTypeModelImpl.SPSITEID_COLUMN_BITMASK |
			SPUserTypeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPSITEIDANDUSERID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpSiteIdAndUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p user types where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @return the matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserId(long spSiteId, long userId)
		throws SystemException {
		return findBySpSiteIdAndUserId(spSiteId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user types where spSiteId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserId(long spSiteId, long userId,
		int start, int end) throws SystemException {
		return findBySpSiteIdAndUserId(spSiteId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user types where spSiteId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserId(long spSiteId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERID;
			finderArgs = new Object[] { spSiteId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEIDANDUSERID;
			finderArgs = new Object[] {
					spSiteId, userId,
					
					start, end, orderByComparator
				};
		}

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserType spUserType : list) {
				if ((spSiteId != spUserType.getSpSiteId()) ||
						(userId != spUserType.getUserId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteIdAndUserId_First(long spSiteId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteIdAndUserId_First(spSiteId,
				userId, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the first s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserId_First(long spSiteId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPUserType> list = findBySpSiteIdAndUserId(spSiteId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteIdAndUserId_Last(long spSiteId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteIdAndUserId_Last(spSiteId, userId,
				orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserId_Last(long spSiteId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySpSiteIdAndUserId(spSiteId, userId);

		if (count == 0) {
			return null;
		}

		List<SPUserType> list = findBySpSiteIdAndUserId(spSiteId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spUserTypeId the primary key of the current s p user type
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType[] findBySpSiteIdAndUserId_PrevAndNext(long spUserTypeId,
		long spSiteId, long userId, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByPrimaryKey(spUserTypeId);

		Session session = null;

		try {
			session = openSession();

			SPUserType[] array = new SPUserTypeImpl[3];

			array[0] = getBySpSiteIdAndUserId_PrevAndNext(session, spUserType,
					spSiteId, userId, orderByComparator, true);

			array[1] = spUserType;

			array[2] = getBySpSiteIdAndUserId_PrevAndNext(session, spUserType,
					spSiteId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPUserType getBySpSiteIdAndUserId_PrevAndNext(Session session,
		SPUserType spUserType, long spSiteId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

		query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_SPSITEID_2);

		query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_USERID_2);

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
			query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spSiteId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user types where spSiteId = &#63; and userId = &#63; from the database.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpSiteIdAndUserId(long spSiteId, long userId)
		throws SystemException {
		for (SPUserType spUserType : findBySpSiteIdAndUserId(spSiteId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types where spSiteId = &#63; and userId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userId the user ID
	 * @return the number of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpSiteIdAndUserId(long spSiteId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPSITEIDANDUSERID;

		Object[] finderArgs = new Object[] { spSiteId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

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

	private static final String _FINDER_COLUMN_SPSITEIDANDUSERID_SPSITEID_2 = "spUserType.spSiteId = ? AND ";
	private static final String _FINDER_COLUMN_SPSITEIDANDUSERID_USERID_2 = "spUserType.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySpSiteIdAndUserTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID =
		new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, SPUserTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySpSiteIdAndUserTypeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPUserTypeModelImpl.SPSITEID_COLUMN_BITMASK |
			SPUserTypeModelImpl.USERTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPSITEIDANDUSERTYPEID = new FinderPath(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpSiteIdAndUserTypeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @return the matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserTypeId(long spSiteId,
		long userTypeId) throws SystemException {
		return findBySpSiteIdAndUserTypeId(spSiteId, userTypeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserTypeId(long spSiteId,
		long userTypeId, int start, int end) throws SystemException {
		return findBySpSiteIdAndUserTypeId(spSiteId, userTypeId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findBySpSiteIdAndUserTypeId(long spSiteId,
		long userTypeId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID;
			finderArgs = new Object[] { spSiteId, userTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID;
			finderArgs = new Object[] {
					spSiteId, userTypeId,
					
					start, end, orderByComparator
				};
		}

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserType spUserType : list) {
				if ((spSiteId != spUserType.getSpSiteId()) ||
						(userTypeId != spUserType.getUserTypeId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_USERTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				qPos.add(userTypeId);

				if (!pagination) {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteIdAndUserTypeId_First(long spSiteId,
		long userTypeId, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteIdAndUserTypeId_First(spSiteId,
				userTypeId, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(", userTypeId=");
		msg.append(userTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the first s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserTypeId_First(long spSiteId,
		long userTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPUserType> list = findBySpSiteIdAndUserTypeId(spSiteId,
				userTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findBySpSiteIdAndUserTypeId_Last(long spSiteId,
		long userTypeId, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchBySpSiteIdAndUserTypeId_Last(spSiteId,
				userTypeId, orderByComparator);

		if (spUserType != null) {
			return spUserType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spSiteId=");
		msg.append(spSiteId);

		msg.append(", userTypeId=");
		msg.append(userTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeException(msg.toString());
	}

	/**
	 * Returns the last s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchBySpSiteIdAndUserTypeId_Last(long spSiteId,
		long userTypeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySpSiteIdAndUserTypeId(spSiteId, userTypeId);

		if (count == 0) {
			return null;
		}

		List<SPUserType> list = findBySpSiteIdAndUserTypeId(spSiteId,
				userTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spUserTypeId the primary key of the current s p user type
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType[] findBySpSiteIdAndUserTypeId_PrevAndNext(
		long spUserTypeId, long spSiteId, long userTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = findByPrimaryKey(spUserTypeId);

		Session session = null;

		try {
			session = openSession();

			SPUserType[] array = new SPUserTypeImpl[3];

			array[0] = getBySpSiteIdAndUserTypeId_PrevAndNext(session,
					spUserType, spSiteId, userTypeId, orderByComparator, true);

			array[1] = spUserType;

			array[2] = getBySpSiteIdAndUserTypeId_PrevAndNext(session,
					spUserType, spSiteId, userTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPUserType getBySpSiteIdAndUserTypeId_PrevAndNext(
		Session session, SPUserType spUserType, long spSiteId, long userTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPE_WHERE);

		query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_SPSITEID_2);

		query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_USERTYPEID_2);

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
			query.append(SPUserTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spSiteId);

		qPos.add(userTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user types where spSiteId = &#63; and userTypeId = &#63; from the database.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpSiteIdAndUserTypeId(long spSiteId, long userTypeId)
		throws SystemException {
		for (SPUserType spUserType : findBySpSiteIdAndUserTypeId(spSiteId,
				userTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types where spSiteId = &#63; and userTypeId = &#63;.
	 *
	 * @param spSiteId the sp site ID
	 * @param userTypeId the user type ID
	 * @return the number of matching s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpSiteIdAndUserTypeId(long spSiteId, long userTypeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPSITEIDANDUSERTYPEID;

		Object[] finderArgs = new Object[] { spSiteId, userTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPUSERTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_SPSITEID_2);

			query.append(_FINDER_COLUMN_SPSITEIDANDUSERTYPEID_USERTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spSiteId);

				qPos.add(userTypeId);

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

	private static final String _FINDER_COLUMN_SPSITEIDANDUSERTYPEID_SPSITEID_2 = "spUserType.spSiteId = ? AND ";
	private static final String _FINDER_COLUMN_SPSITEIDANDUSERTYPEID_USERTYPEID_2 =
		"spUserType.userTypeId = ?";

	public SPUserTypePersistenceImpl() {
		setModelClass(SPUserType.class);
	}

	/**
	 * Caches the s p user type in the entity cache if it is enabled.
	 *
	 * @param spUserType the s p user type
	 */
	@Override
	public void cacheResult(SPUserType spUserType) {
		EntityCacheUtil.putResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeImpl.class, spUserType.getPrimaryKey(), spUserType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spUserType.getUuid(), spUserType.getGroupId() },
			spUserType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
			new Object[] {
				spUserType.getSpSiteId(), spUserType.getUserId(),
				spUserType.getUserTypeId()
			}, spUserType);

		spUserType.resetOriginalValues();
	}

	/**
	 * Caches the s p user types in the entity cache if it is enabled.
	 *
	 * @param spUserTypes the s p user types
	 */
	@Override
	public void cacheResult(List<SPUserType> spUserTypes) {
		for (SPUserType spUserType : spUserTypes) {
			if (EntityCacheUtil.getResult(
						SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPUserTypeImpl.class, spUserType.getPrimaryKey()) == null) {
				cacheResult(spUserType);
			}
			else {
				spUserType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p user types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPUserTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPUserTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p user type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPUserType spUserType) {
		EntityCacheUtil.removeResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeImpl.class, spUserType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spUserType);
	}

	@Override
	public void clearCache(List<SPUserType> spUserTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPUserType spUserType : spUserTypes) {
			EntityCacheUtil.removeResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPUserTypeImpl.class, spUserType.getPrimaryKey());

			clearUniqueFindersCache(spUserType);
		}
	}

	protected void cacheUniqueFindersCache(SPUserType spUserType) {
		if (spUserType.isNew()) {
			Object[] args = new Object[] {
					spUserType.getUuid(), spUserType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spUserType);

			args = new Object[] {
					spUserType.getSpSiteId(), spUserType.getUserId(),
					spUserType.getUserTypeId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
				args, spUserType);
		}
		else {
			SPUserTypeModelImpl spUserTypeModelImpl = (SPUserTypeModelImpl)spUserType;

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserType.getUuid(), spUserType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spUserType);
			}

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserType.getSpSiteId(), spUserType.getUserId(),
						spUserType.getUserTypeId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
					args, spUserType);
			}
		}
	}

	protected void clearUniqueFindersCache(SPUserType spUserType) {
		SPUserTypeModelImpl spUserTypeModelImpl = (SPUserTypeModelImpl)spUserType;

		Object[] args = new Object[] {
				spUserType.getUuid(), spUserType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spUserTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserTypeModelImpl.getOriginalUuid(),
					spUserTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spUserType.getSpSiteId(), spUserType.getUserId(),
				spUserType.getUserTypeId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
			args);

		if ((spUserTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserTypeModelImpl.getOriginalSpSiteId(),
					spUserTypeModelImpl.getOriginalUserId(),
					spUserTypeModelImpl.getOriginalUserTypeId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SPSITEIDANDUSERIDANDUSERTYPEID,
				args);
		}
	}

	/**
	 * Creates a new s p user type with the primary key. Does not add the s p user type to the database.
	 *
	 * @param spUserTypeId the primary key for the new s p user type
	 * @return the new s p user type
	 */
	@Override
	public SPUserType create(long spUserTypeId) {
		SPUserType spUserType = new SPUserTypeImpl();

		spUserType.setNew(true);
		spUserType.setPrimaryKey(spUserTypeId);

		String uuid = PortalUUIDUtil.generate();

		spUserType.setUuid(uuid);

		return spUserType;
	}

	/**
	 * Removes the s p user type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spUserTypeId the primary key of the s p user type
	 * @return the s p user type that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType remove(long spUserTypeId)
		throws NoSuchSPUserTypeException, SystemException {
		return remove((Serializable)spUserTypeId);
	}

	/**
	 * Removes the s p user type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p user type
	 * @return the s p user type that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType remove(Serializable primaryKey)
		throws NoSuchSPUserTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPUserType spUserType = (SPUserType)session.get(SPUserTypeImpl.class,
					primaryKey);

			if (spUserType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPUserTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spUserType);
		}
		catch (NoSuchSPUserTypeException nsee) {
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
	protected SPUserType removeImpl(SPUserType spUserType)
		throws SystemException {
		spUserType = toUnwrappedModel(spUserType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spUserType)) {
				spUserType = (SPUserType)session.get(SPUserTypeImpl.class,
						spUserType.getPrimaryKeyObj());
			}

			if (spUserType != null) {
				session.delete(spUserType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spUserType != null) {
			clearCache(spUserType);
		}

		return spUserType;
	}

	@Override
	public SPUserType updateImpl(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws SystemException {
		spUserType = toUnwrappedModel(spUserType);

		boolean isNew = spUserType.isNew();

		SPUserTypeModelImpl spUserTypeModelImpl = (SPUserTypeModelImpl)spUserType;

		if (Validator.isNull(spUserType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spUserType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spUserType.isNew()) {
				session.save(spUserType);

				spUserType.setNew(false);
			}
			else {
				session.merge(spUserType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPUserTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spUserTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeModelImpl.getOriginalUuid(),
						spUserTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spUserTypeModelImpl.getUuid(),
						spUserTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeModelImpl.getOriginalSpSiteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEID,
					args);

				args = new Object[] { spUserTypeModelImpl.getSpSiteId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEID,
					args);
			}

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeModelImpl.getOriginalSpSiteId(),
						spUserTypeModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERID,
					args);

				args = new Object[] {
						spUserTypeModelImpl.getSpSiteId(),
						spUserTypeModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERID,
					args);
			}

			if ((spUserTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeModelImpl.getOriginalSpSiteId(),
						spUserTypeModelImpl.getOriginalUserTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID,
					args);

				args = new Object[] {
						spUserTypeModelImpl.getSpSiteId(),
						spUserTypeModelImpl.getUserTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPSITEIDANDUSERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPSITEIDANDUSERTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeImpl.class, spUserType.getPrimaryKey(), spUserType);

		clearUniqueFindersCache(spUserType);
		cacheUniqueFindersCache(spUserType);

		return spUserType;
	}

	protected SPUserType toUnwrappedModel(SPUserType spUserType) {
		if (spUserType instanceof SPUserTypeImpl) {
			return spUserType;
		}

		SPUserTypeImpl spUserTypeImpl = new SPUserTypeImpl();

		spUserTypeImpl.setNew(spUserType.isNew());
		spUserTypeImpl.setPrimaryKey(spUserType.getPrimaryKey());

		spUserTypeImpl.setUuid(spUserType.getUuid());
		spUserTypeImpl.setSpUserTypeId(spUserType.getSpUserTypeId());
		spUserTypeImpl.setSpSiteId(spUserType.getSpSiteId());
		spUserTypeImpl.setUserId(spUserType.getUserId());
		spUserTypeImpl.setUserTypeId(spUserType.getUserTypeId());
		spUserTypeImpl.setUserStatusId(spUserType.getUserStatusId());
		spUserTypeImpl.setDeclarationCompleted(spUserType.isDeclarationCompleted());
		spUserTypeImpl.setDeclarationDate(spUserType.getDeclarationDate());
		spUserTypeImpl.setDeclarationStorageId(spUserType.getDeclarationStorageId());
		spUserTypeImpl.setPdpaCompleted(spUserType.isPdpaCompleted());
		spUserTypeImpl.setPdpaCompletionDate(spUserType.getPdpaCompletionDate());
		spUserTypeImpl.setGroupId(spUserType.getGroupId());
		spUserTypeImpl.setCompanyId(spUserType.getCompanyId());
		spUserTypeImpl.setCreatedBy(spUserType.getCreatedBy());
		spUserTypeImpl.setModifiedBy(spUserType.getModifiedBy());
		spUserTypeImpl.setCreatedDate(spUserType.getCreatedDate());
		spUserTypeImpl.setModifiedDate(spUserType.getModifiedDate());

		return spUserTypeImpl;
	}

	/**
	 * Returns the s p user type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p user type
	 * @return the s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPUserTypeException, SystemException {
		SPUserType spUserType = fetchByPrimaryKey(primaryKey);

		if (spUserType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPUserTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spUserType;
	}

	/**
	 * Returns the s p user type with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	 *
	 * @param spUserTypeId the primary key of the s p user type
	 * @return the s p user type
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType findByPrimaryKey(long spUserTypeId)
		throws NoSuchSPUserTypeException, SystemException {
		return findByPrimaryKey((Serializable)spUserTypeId);
	}

	/**
	 * Returns the s p user type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p user type
	 * @return the s p user type, or <code>null</code> if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPUserType spUserType = (SPUserType)EntityCacheUtil.getResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPUserTypeImpl.class, primaryKey);

		if (spUserType == _nullSPUserType) {
			return null;
		}

		if (spUserType == null) {
			Session session = null;

			try {
				session = openSession();

				spUserType = (SPUserType)session.get(SPUserTypeImpl.class,
						primaryKey);

				if (spUserType != null) {
					cacheResult(spUserType);
				}
				else {
					EntityCacheUtil.putResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPUserTypeImpl.class, primaryKey, _nullSPUserType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPUserTypeModelImpl.ENTITY_CACHE_ENABLED,
					SPUserTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spUserType;
	}

	/**
	 * Returns the s p user type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spUserTypeId the primary key of the s p user type
	 * @return the s p user type, or <code>null</code> if a s p user type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserType fetchByPrimaryKey(long spUserTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spUserTypeId);
	}

	/**
	 * Returns all the s p user types.
	 *
	 * @return the s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @return the range of s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p user types
	 * @param end the upper bound of the range of s p user types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p user types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserType> findAll(int start, int end,
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

		List<SPUserType> list = (List<SPUserType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPUSERTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPUSERTYPE;

				if (pagination) {
					sql = sql.concat(SPUserTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserType>(list);
				}
				else {
					list = (List<SPUserType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p user types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPUserType spUserType : findAll()) {
			remove(spUserType);
		}
	}

	/**
	 * Returns the number of s p user types.
	 *
	 * @return the number of s p user types
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

				Query q = session.createQuery(_SQL_COUNT_SPUSERTYPE);

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
	 * Initializes the s p user type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPUserType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPUserType>> listenersList = new ArrayList<ModelListener<SPUserType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPUserType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPUserTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPUSERTYPE = "SELECT spUserType FROM SPUserType spUserType";
	private static final String _SQL_SELECT_SPUSERTYPE_WHERE = "SELECT spUserType FROM SPUserType spUserType WHERE ";
	private static final String _SQL_COUNT_SPUSERTYPE = "SELECT COUNT(spUserType) FROM SPUserType spUserType";
	private static final String _SQL_COUNT_SPUSERTYPE_WHERE = "SELECT COUNT(spUserType) FROM SPUserType spUserType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spUserType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPUserType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPUserType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPUserTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPUserType _nullSPUserType = new SPUserTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPUserType> toCacheModel() {
				return _nullSPUserTypeCacheModel;
			}
		};

	private static CacheModel<SPUserType> _nullSPUserTypeCacheModel = new CacheModel<SPUserType>() {
			@Override
			public SPUserType toEntityModel() {
				return _nullSPUserType;
			}
		};
}