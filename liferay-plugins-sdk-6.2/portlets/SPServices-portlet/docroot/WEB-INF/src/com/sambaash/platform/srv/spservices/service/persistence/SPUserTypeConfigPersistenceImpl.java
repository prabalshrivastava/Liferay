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

import com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;
import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;
import com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p user type config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserTypeConfigPersistence
 * @see SPUserTypeConfigUtil
 * @generated
 */
public class SPUserTypeConfigPersistenceImpl extends BasePersistenceImpl<SPUserTypeConfig>
	implements SPUserTypeConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPUserTypeConfigUtil} to access the s p user type config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPUserTypeConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPUserTypeConfigModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p user type configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user type configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @return the range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user type configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid(String uuid, int start, int end,
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

		List<SPUserTypeConfig> list = (List<SPUserTypeConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserTypeConfig spUserTypeConfig : list) {
				if (!Validator.equals(uuid, spUserTypeConfig.getUuid())) {
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

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

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
				query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserTypeConfig>(list);
				}
				else {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
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
	 * Returns the first s p user type config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUuid_First(uuid,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the first s p user type config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserTypeConfig> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUuid_Last(uuid,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the last s p user type config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPUserTypeConfig> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user type configs before and after the current s p user type config in the ordered set where uuid = &#63;.
	 *
	 * @param spUserTypeConfigId the primary key of the current s p user type config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig[] findByUuid_PrevAndNext(long spUserTypeConfigId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByPrimaryKey(spUserTypeConfigId);

		Session session = null;

		try {
			session = openSession();

			SPUserTypeConfig[] array = new SPUserTypeConfigImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spUserTypeConfig, uuid,
					orderByComparator, true);

			array[1] = spUserTypeConfig;

			array[2] = getByUuid_PrevAndNext(session, spUserTypeConfig, uuid,
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

	protected SPUserTypeConfig getByUuid_PrevAndNext(Session session,
		SPUserTypeConfig spUserTypeConfig, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

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
			query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spUserTypeConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserTypeConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user type configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPUserTypeConfig spUserTypeConfig : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserTypeConfig);
		}
	}

	/**
	 * Returns the number of s p user type configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p user type configs
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

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spUserTypeConfig.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spUserTypeConfig.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spUserTypeConfig.uuid IS NULL OR spUserTypeConfig.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPUserTypeConfigModelImpl.UUID_COLUMN_BITMASK |
			SPUserTypeConfigModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p user type config where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUUID_G(String uuid, long groupId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUUID_G(uuid, groupId);

		if (spUserTypeConfig == null) {
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

			throw new NoSuchSPUserTypeConfigException(msg.toString());
		}

		return spUserTypeConfig;
	}

	/**
	 * Returns the s p user type config where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p user type config where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPUserTypeConfig) {
			SPUserTypeConfig spUserTypeConfig = (SPUserTypeConfig)result;

			if (!Validator.equals(uuid, spUserTypeConfig.getUuid()) ||
					(groupId != spUserTypeConfig.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

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

				List<SPUserTypeConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPUserTypeConfig spUserTypeConfig = list.get(0);

					result = spUserTypeConfig;

					cacheResult(spUserTypeConfig);

					if ((spUserTypeConfig.getUuid() == null) ||
							!spUserTypeConfig.getUuid().equals(uuid) ||
							(spUserTypeConfig.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spUserTypeConfig);
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
			return (SPUserTypeConfig)result;
		}
	}

	/**
	 * Removes the s p user type config where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p user type config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByUUID_G(uuid, groupId);

		return remove(spUserTypeConfig);
	}

	/**
	 * Returns the number of s p user type configs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p user type configs
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

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spUserTypeConfig.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spUserTypeConfig.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spUserTypeConfig.uuid IS NULL OR spUserTypeConfig.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spUserTypeConfig.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPUserTypeConfigModelImpl.UUID_COLUMN_BITMASK |
			SPUserTypeConfigModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p user type configs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user type configs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @return the range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user type configs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUuid_C(String uuid, long companyId,
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

		List<SPUserTypeConfig> list = (List<SPUserTypeConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserTypeConfig spUserTypeConfig : list) {
				if (!Validator.equals(uuid, spUserTypeConfig.getUuid()) ||
						(companyId != spUserTypeConfig.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

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
				query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserTypeConfig>(list);
				}
				else {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
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
	 * Returns the first s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the first s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserTypeConfig> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the last s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPUserTypeConfig> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user type configs before and after the current s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spUserTypeConfigId the primary key of the current s p user type config
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig[] findByUuid_C_PrevAndNext(
		long spUserTypeConfigId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByPrimaryKey(spUserTypeConfigId);

		Session session = null;

		try {
			session = openSession();

			SPUserTypeConfig[] array = new SPUserTypeConfigImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spUserTypeConfig, uuid,
					companyId, orderByComparator, true);

			array[1] = spUserTypeConfig;

			array[2] = getByUuid_C_PrevAndNext(session, spUserTypeConfig, uuid,
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

	protected SPUserTypeConfig getByUuid_C_PrevAndNext(Session session,
		SPUserTypeConfig spUserTypeConfig, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

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
			query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spUserTypeConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserTypeConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user type configs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPUserTypeConfig spUserTypeConfig : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserTypeConfig);
		}
	}

	/**
	 * Returns the number of s p user type configs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p user type configs
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

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spUserTypeConfig.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spUserTypeConfig.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spUserTypeConfig.uuid IS NULL OR spUserTypeConfig.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spUserTypeConfig.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserTypeAndVirtualHostId",
			new String[] { String.class.getName(), Long.class.getName() },
			SPUserTypeConfigModelImpl.USERTYPE_COLUMN_BITMASK |
			SPUserTypeConfigModelImpl.VIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserTypeAndVirtualHostId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	 *
	 * @param userType the user type
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUserTypeAndVirtualHostId(String userType,
		long virtualHostId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUserTypeAndVirtualHostId(userType,
				virtualHostId);

		if (spUserTypeConfig == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userType=");
			msg.append(userType);

			msg.append(", virtualHostId=");
			msg.append(virtualHostId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPUserTypeConfigException(msg.toString());
		}

		return spUserTypeConfig;
	}

	/**
	 * Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userType the user type
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeAndVirtualHostId(String userType,
		long virtualHostId) throws SystemException {
		return fetchByUserTypeAndVirtualHostId(userType, virtualHostId, true);
	}

	/**
	 * Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userType the user type
	 * @param virtualHostId the virtual host ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeAndVirtualHostId(String userType,
		long virtualHostId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userType, virtualHostId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
					finderArgs, this);
		}

		if (result instanceof SPUserTypeConfig) {
			SPUserTypeConfig spUserTypeConfig = (SPUserTypeConfig)result;

			if (!Validator.equals(userType, spUserTypeConfig.getUserType()) ||
					(virtualHostId != spUserTypeConfig.getVirtualHostId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

			boolean bindUserType = false;

			if (userType == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_1);
			}
			else if (userType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_3);
			}
			else {
				bindUserType = true;

				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserType) {
					qPos.add(userType);
				}

				qPos.add(virtualHostId);

				List<SPUserTypeConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
						finderArgs, list);
				}
				else {
					SPUserTypeConfig spUserTypeConfig = list.get(0);

					result = spUserTypeConfig;

					cacheResult(spUserTypeConfig);

					if ((spUserTypeConfig.getUserType() == null) ||
							!spUserTypeConfig.getUserType().equals(userType) ||
							(spUserTypeConfig.getVirtualHostId() != virtualHostId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
							finderArgs, spUserTypeConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
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
			return (SPUserTypeConfig)result;
		}
	}

	/**
	 * Removes the s p user type config where userType = &#63; and virtualHostId = &#63; from the database.
	 *
	 * @param userType the user type
	 * @param virtualHostId the virtual host ID
	 * @return the s p user type config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig removeByUserTypeAndVirtualHostId(String userType,
		long virtualHostId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByUserTypeAndVirtualHostId(userType,
				virtualHostId);

		return remove(spUserTypeConfig);
	}

	/**
	 * Returns the number of s p user type configs where userType = &#63; and virtualHostId = &#63;.
	 *
	 * @param userType the user type
	 * @param virtualHostId the virtual host ID
	 * @return the number of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserTypeAndVirtualHostId(String userType,
		long virtualHostId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID;

		Object[] finderArgs = new Object[] { userType, virtualHostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

			boolean bindUserType = false;

			if (userType == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_1);
			}
			else if (userType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_3);
			}
			else {
				bindUserType = true;

				query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserType) {
					qPos.add(userType);
				}

				qPos.add(virtualHostId);

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

	private static final String _FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_1 =
		"spUserTypeConfig.userType IS NULL AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_2 =
		"spUserTypeConfig.userType = ? AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_USERTYPE_3 =
		"(spUserTypeConfig.userType IS NULL OR spUserTypeConfig.userType = '') AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDVIRTUALHOSTID_VIRTUALHOSTID_2 =
		"spUserTypeConfig.virtualHostId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserTypeIdAndVirtualHostId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPUserTypeConfigModelImpl.USERTYPEID_COLUMN_BITMASK |
			SPUserTypeConfigModelImpl.VIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserTypeIdAndVirtualHostId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	 *
	 * @param userTypeId the user type ID
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUserTypeIdAndVirtualHostId(long userTypeId,
		long virtualHostId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUserTypeIdAndVirtualHostId(userTypeId,
				virtualHostId);

		if (spUserTypeConfig == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userTypeId=");
			msg.append(userTypeId);

			msg.append(", virtualHostId=");
			msg.append(virtualHostId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPUserTypeConfigException(msg.toString());
		}

		return spUserTypeConfig;
	}

	/**
	 * Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userTypeId the user type ID
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeIdAndVirtualHostId(long userTypeId,
		long virtualHostId) throws SystemException {
		return fetchByUserTypeIdAndVirtualHostId(userTypeId, virtualHostId, true);
	}

	/**
	 * Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userTypeId the user type ID
	 * @param virtualHostId the virtual host ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeIdAndVirtualHostId(long userTypeId,
		long virtualHostId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userTypeId, virtualHostId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
					finderArgs, this);
		}

		if (result instanceof SPUserTypeConfig) {
			SPUserTypeConfig spUserTypeConfig = (SPUserTypeConfig)result;

			if ((userTypeId != spUserTypeConfig.getUserTypeId()) ||
					(virtualHostId != spUserTypeConfig.getVirtualHostId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_USERTYPEID_2);

			query.append(_FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userTypeId);

				qPos.add(virtualHostId);

				List<SPUserTypeConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
						finderArgs, list);
				}
				else {
					SPUserTypeConfig spUserTypeConfig = list.get(0);

					result = spUserTypeConfig;

					cacheResult(spUserTypeConfig);

					if ((spUserTypeConfig.getUserTypeId() != userTypeId) ||
							(spUserTypeConfig.getVirtualHostId() != virtualHostId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
							finderArgs, spUserTypeConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
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
			return (SPUserTypeConfig)result;
		}
	}

	/**
	 * Removes the s p user type config where userTypeId = &#63; and virtualHostId = &#63; from the database.
	 *
	 * @param userTypeId the user type ID
	 * @param virtualHostId the virtual host ID
	 * @return the s p user type config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig removeByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByUserTypeIdAndVirtualHostId(userTypeId,
				virtualHostId);

		return remove(spUserTypeConfig);
	}

	/**
	 * Returns the number of s p user type configs where userTypeId = &#63; and virtualHostId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @param virtualHostId the virtual host ID
	 * @return the number of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserTypeIdAndVirtualHostId(long userTypeId,
		long virtualHostId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID;

		Object[] finderArgs = new Object[] { userTypeId, virtualHostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_USERTYPEID_2);

			query.append(_FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userTypeId);

				qPos.add(virtualHostId);

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

	private static final String _FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_USERTYPEID_2 =
		"spUserTypeConfig.userTypeId = ? AND ";
	private static final String _FINDER_COLUMN_USERTYPEIDANDVIRTUALHOSTID_VIRTUALHOSTID_2 =
		"spUserTypeConfig.virtualHostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVirtualHostId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVirtualHostId",
			new String[] { Long.class.getName() },
			SPUserTypeConfigModelImpl.VIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIRTUALHOSTID = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVirtualHostId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p user type configs where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByVirtualHostId(long virtualHostId)
		throws SystemException {
		return findByVirtualHostId(virtualHostId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user type configs where virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @return the range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByVirtualHostId(long virtualHostId,
		int start, int end) throws SystemException {
		return findByVirtualHostId(virtualHostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user type configs where virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByVirtualHostId(long virtualHostId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID;
			finderArgs = new Object[] { virtualHostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIRTUALHOSTID;
			finderArgs = new Object[] {
					virtualHostId,
					
					start, end, orderByComparator
				};
		}

		List<SPUserTypeConfig> list = (List<SPUserTypeConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserTypeConfig spUserTypeConfig : list) {
				if ((virtualHostId != spUserTypeConfig.getVirtualHostId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(virtualHostId);

				if (!pagination) {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserTypeConfig>(list);
				}
				else {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
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
	 * Returns the first s p user type config in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByVirtualHostId_First(long virtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByVirtualHostId_First(virtualHostId,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the first s p user type config in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByVirtualHostId_First(long virtualHostId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserTypeConfig> list = findByVirtualHostId(virtualHostId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type config in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByVirtualHostId_Last(long virtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByVirtualHostId_Last(virtualHostId,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the last s p user type config in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByVirtualHostId_Last(long virtualHostId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVirtualHostId(virtualHostId);

		if (count == 0) {
			return null;
		}

		List<SPUserTypeConfig> list = findByVirtualHostId(virtualHostId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user type configs before and after the current s p user type config in the ordered set where virtualHostId = &#63;.
	 *
	 * @param spUserTypeConfigId the primary key of the current s p user type config
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig[] findByVirtualHostId_PrevAndNext(
		long spUserTypeConfigId, long virtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByPrimaryKey(spUserTypeConfigId);

		Session session = null;

		try {
			session = openSession();

			SPUserTypeConfig[] array = new SPUserTypeConfigImpl[3];

			array[0] = getByVirtualHostId_PrevAndNext(session,
					spUserTypeConfig, virtualHostId, orderByComparator, true);

			array[1] = spUserTypeConfig;

			array[2] = getByVirtualHostId_PrevAndNext(session,
					spUserTypeConfig, virtualHostId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPUserTypeConfig getByVirtualHostId_PrevAndNext(Session session,
		SPUserTypeConfig spUserTypeConfig, long virtualHostId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

		query.append(_FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2);

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
			query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(virtualHostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserTypeConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserTypeConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user type configs where virtualHostId = &#63; from the database.
	 *
	 * @param virtualHostId the virtual host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVirtualHostId(long virtualHostId)
		throws SystemException {
		for (SPUserTypeConfig spUserTypeConfig : findByVirtualHostId(
				virtualHostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserTypeConfig);
		}
	}

	/**
	 * Returns the number of s p user type configs where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @return the number of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVirtualHostId(long virtualHostId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIRTUALHOSTID;

		Object[] finderArgs = new Object[] { virtualHostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(virtualHostId);

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

	private static final String _FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2 = "spUserTypeConfig.virtualHostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEID =
		new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED,
			SPUserTypeConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserTypeId",
			new String[] { Long.class.getName() },
			SPUserTypeConfigModelImpl.USERTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERTYPEID = new FinderPath(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p user type configs where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @return the matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUserTypeId(long userTypeId)
		throws SystemException {
		return findByUserTypeId(userTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user type configs where userTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userTypeId the user type ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @return the range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUserTypeId(long userTypeId, int start,
		int end) throws SystemException {
		return findByUserTypeId(userTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user type configs where userTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userTypeId the user type ID
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findByUserTypeId(long userTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEID;
			finderArgs = new Object[] { userTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEID;
			finderArgs = new Object[] { userTypeId, start, end, orderByComparator };
		}

		List<SPUserTypeConfig> list = (List<SPUserTypeConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPUserTypeConfig spUserTypeConfig : list) {
				if ((userTypeId != spUserTypeConfig.getUserTypeId())) {
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

			query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEID_USERTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userTypeId);

				if (!pagination) {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserTypeConfig>(list);
				}
				else {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
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
	 * Returns the first s p user type config in the ordered set where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUserTypeId_First(long userTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUserTypeId_First(userTypeId,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userTypeId=");
		msg.append(userTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the first s p user type config in the ordered set where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeId_First(long userTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPUserTypeConfig> list = findByUserTypeId(userTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p user type config in the ordered set where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByUserTypeId_Last(long userTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByUserTypeId_Last(userTypeId,
				orderByComparator);

		if (spUserTypeConfig != null) {
			return spUserTypeConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userTypeId=");
		msg.append(userTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPUserTypeConfigException(msg.toString());
	}

	/**
	 * Returns the last s p user type config in the ordered set where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByUserTypeId_Last(long userTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserTypeId(userTypeId);

		if (count == 0) {
			return null;
		}

		List<SPUserTypeConfig> list = findByUserTypeId(userTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p user type configs before and after the current s p user type config in the ordered set where userTypeId = &#63;.
	 *
	 * @param spUserTypeConfigId the primary key of the current s p user type config
	 * @param userTypeId the user type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig[] findByUserTypeId_PrevAndNext(
		long spUserTypeConfigId, long userTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = findByPrimaryKey(spUserTypeConfigId);

		Session session = null;

		try {
			session = openSession();

			SPUserTypeConfig[] array = new SPUserTypeConfigImpl[3];

			array[0] = getByUserTypeId_PrevAndNext(session, spUserTypeConfig,
					userTypeId, orderByComparator, true);

			array[1] = spUserTypeConfig;

			array[2] = getByUserTypeId_PrevAndNext(session, spUserTypeConfig,
					userTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPUserTypeConfig getByUserTypeId_PrevAndNext(Session session,
		SPUserTypeConfig spUserTypeConfig, long userTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPUSERTYPECONFIG_WHERE);

		query.append(_FINDER_COLUMN_USERTYPEID_USERTYPEID_2);

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
			query.append(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spUserTypeConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPUserTypeConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p user type configs where userTypeId = &#63; from the database.
	 *
	 * @param userTypeId the user type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserTypeId(long userTypeId) throws SystemException {
		for (SPUserTypeConfig spUserTypeConfig : findByUserTypeId(userTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spUserTypeConfig);
		}
	}

	/**
	 * Returns the number of s p user type configs where userTypeId = &#63;.
	 *
	 * @param userTypeId the user type ID
	 * @return the number of matching s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserTypeId(long userTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERTYPEID;

		Object[] finderArgs = new Object[] { userTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPUSERTYPECONFIG_WHERE);

			query.append(_FINDER_COLUMN_USERTYPEID_USERTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USERTYPEID_USERTYPEID_2 = "spUserTypeConfig.userTypeId = ?";

	public SPUserTypeConfigPersistenceImpl() {
		setModelClass(SPUserTypeConfig.class);
	}

	/**
	 * Caches the s p user type config in the entity cache if it is enabled.
	 *
	 * @param spUserTypeConfig the s p user type config
	 */
	@Override
	public void cacheResult(SPUserTypeConfig spUserTypeConfig) {
		EntityCacheUtil.putResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, spUserTypeConfig.getPrimaryKey(),
			spUserTypeConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				spUserTypeConfig.getUuid(), spUserTypeConfig.getGroupId()
			}, spUserTypeConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
			new Object[] {
				spUserTypeConfig.getUserType(),
				spUserTypeConfig.getVirtualHostId()
			}, spUserTypeConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
			new Object[] {
				spUserTypeConfig.getUserTypeId(),
				spUserTypeConfig.getVirtualHostId()
			}, spUserTypeConfig);

		spUserTypeConfig.resetOriginalValues();
	}

	/**
	 * Caches the s p user type configs in the entity cache if it is enabled.
	 *
	 * @param spUserTypeConfigs the s p user type configs
	 */
	@Override
	public void cacheResult(List<SPUserTypeConfig> spUserTypeConfigs) {
		for (SPUserTypeConfig spUserTypeConfig : spUserTypeConfigs) {
			if (EntityCacheUtil.getResult(
						SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
						SPUserTypeConfigImpl.class,
						spUserTypeConfig.getPrimaryKey()) == null) {
				cacheResult(spUserTypeConfig);
			}
			else {
				spUserTypeConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p user type configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPUserTypeConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPUserTypeConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p user type config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPUserTypeConfig spUserTypeConfig) {
		EntityCacheUtil.removeResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, spUserTypeConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spUserTypeConfig);
	}

	@Override
	public void clearCache(List<SPUserTypeConfig> spUserTypeConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPUserTypeConfig spUserTypeConfig : spUserTypeConfigs) {
			EntityCacheUtil.removeResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
				SPUserTypeConfigImpl.class, spUserTypeConfig.getPrimaryKey());

			clearUniqueFindersCache(spUserTypeConfig);
		}
	}

	protected void cacheUniqueFindersCache(SPUserTypeConfig spUserTypeConfig) {
		if (spUserTypeConfig.isNew()) {
			Object[] args = new Object[] {
					spUserTypeConfig.getUuid(), spUserTypeConfig.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spUserTypeConfig);

			args = new Object[] {
					spUserTypeConfig.getUserType(),
					spUserTypeConfig.getVirtualHostId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
				args, spUserTypeConfig);

			args = new Object[] {
					spUserTypeConfig.getUserTypeId(),
					spUserTypeConfig.getVirtualHostId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
				args, spUserTypeConfig);
		}
		else {
			SPUserTypeConfigModelImpl spUserTypeConfigModelImpl = (SPUserTypeConfigModelImpl)spUserTypeConfig;

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfig.getUuid(),
						spUserTypeConfig.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spUserTypeConfig);
			}

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfig.getUserType(),
						spUserTypeConfig.getVirtualHostId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
					args, spUserTypeConfig);
			}

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfig.getUserTypeId(),
						spUserTypeConfig.getVirtualHostId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
					args, spUserTypeConfig);
			}
		}
	}

	protected void clearUniqueFindersCache(SPUserTypeConfig spUserTypeConfig) {
		SPUserTypeConfigModelImpl spUserTypeConfigModelImpl = (SPUserTypeConfigModelImpl)spUserTypeConfig;

		Object[] args = new Object[] {
				spUserTypeConfig.getUuid(), spUserTypeConfig.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spUserTypeConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserTypeConfigModelImpl.getOriginalUuid(),
					spUserTypeConfigModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spUserTypeConfig.getUserType(),
				spUserTypeConfig.getVirtualHostId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
			args);

		if ((spUserTypeConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserTypeConfigModelImpl.getOriginalUserType(),
					spUserTypeConfigModelImpl.getOriginalVirtualHostId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEANDVIRTUALHOSTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEANDVIRTUALHOSTID,
				args);
		}

		args = new Object[] {
				spUserTypeConfig.getUserTypeId(),
				spUserTypeConfig.getVirtualHostId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
			args);

		if ((spUserTypeConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spUserTypeConfigModelImpl.getOriginalUserTypeId(),
					spUserTypeConfigModelImpl.getOriginalVirtualHostId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEIDANDVIRTUALHOSTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERTYPEIDANDVIRTUALHOSTID,
				args);
		}
	}

	/**
	 * Creates a new s p user type config with the primary key. Does not add the s p user type config to the database.
	 *
	 * @param spUserTypeConfigId the primary key for the new s p user type config
	 * @return the new s p user type config
	 */
	@Override
	public SPUserTypeConfig create(long spUserTypeConfigId) {
		SPUserTypeConfig spUserTypeConfig = new SPUserTypeConfigImpl();

		spUserTypeConfig.setNew(true);
		spUserTypeConfig.setPrimaryKey(spUserTypeConfigId);

		String uuid = PortalUUIDUtil.generate();

		spUserTypeConfig.setUuid(uuid);

		return spUserTypeConfig;
	}

	/**
	 * Removes the s p user type config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spUserTypeConfigId the primary key of the s p user type config
	 * @return the s p user type config that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig remove(long spUserTypeConfigId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		return remove((Serializable)spUserTypeConfigId);
	}

	/**
	 * Removes the s p user type config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p user type config
	 * @return the s p user type config that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig remove(Serializable primaryKey)
		throws NoSuchSPUserTypeConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPUserTypeConfig spUserTypeConfig = (SPUserTypeConfig)session.get(SPUserTypeConfigImpl.class,
					primaryKey);

			if (spUserTypeConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPUserTypeConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spUserTypeConfig);
		}
		catch (NoSuchSPUserTypeConfigException nsee) {
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
	protected SPUserTypeConfig removeImpl(SPUserTypeConfig spUserTypeConfig)
		throws SystemException {
		spUserTypeConfig = toUnwrappedModel(spUserTypeConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spUserTypeConfig)) {
				spUserTypeConfig = (SPUserTypeConfig)session.get(SPUserTypeConfigImpl.class,
						spUserTypeConfig.getPrimaryKeyObj());
			}

			if (spUserTypeConfig != null) {
				session.delete(spUserTypeConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spUserTypeConfig != null) {
			clearCache(spUserTypeConfig);
		}

		return spUserTypeConfig;
	}

	@Override
	public SPUserTypeConfig updateImpl(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig)
		throws SystemException {
		spUserTypeConfig = toUnwrappedModel(spUserTypeConfig);

		boolean isNew = spUserTypeConfig.isNew();

		SPUserTypeConfigModelImpl spUserTypeConfigModelImpl = (SPUserTypeConfigModelImpl)spUserTypeConfig;

		if (Validator.isNull(spUserTypeConfig.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spUserTypeConfig.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spUserTypeConfig.isNew()) {
				session.save(spUserTypeConfig);

				spUserTypeConfig.setNew(false);
			}
			else {
				session.merge(spUserTypeConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPUserTypeConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfigModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spUserTypeConfigModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfigModelImpl.getOriginalUuid(),
						spUserTypeConfigModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spUserTypeConfigModelImpl.getUuid(),
						spUserTypeConfigModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfigModelImpl.getOriginalVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID,
					args);

				args = new Object[] { spUserTypeConfigModelImpl.getVirtualHostId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID,
					args);
			}

			if ((spUserTypeConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spUserTypeConfigModelImpl.getOriginalUserTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEID,
					args);

				args = new Object[] { spUserTypeConfigModelImpl.getUserTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPUserTypeConfigImpl.class, spUserTypeConfig.getPrimaryKey(),
			spUserTypeConfig);

		clearUniqueFindersCache(spUserTypeConfig);
		cacheUniqueFindersCache(spUserTypeConfig);

		return spUserTypeConfig;
	}

	protected SPUserTypeConfig toUnwrappedModel(
		SPUserTypeConfig spUserTypeConfig) {
		if (spUserTypeConfig instanceof SPUserTypeConfigImpl) {
			return spUserTypeConfig;
		}

		SPUserTypeConfigImpl spUserTypeConfigImpl = new SPUserTypeConfigImpl();

		spUserTypeConfigImpl.setNew(spUserTypeConfig.isNew());
		spUserTypeConfigImpl.setPrimaryKey(spUserTypeConfig.getPrimaryKey());

		spUserTypeConfigImpl.setUuid(spUserTypeConfig.getUuid());
		spUserTypeConfigImpl.setSpUserTypeConfigId(spUserTypeConfig.getSpUserTypeConfigId());
		spUserTypeConfigImpl.setUserType(spUserTypeConfig.getUserType());
		spUserTypeConfigImpl.setUserTypeId(spUserTypeConfig.getUserTypeId());
		spUserTypeConfigImpl.setVirtualHostId(spUserTypeConfig.getVirtualHostId());
		spUserTypeConfigImpl.setDeclarationId(spUserTypeConfig.getDeclarationId());
		spUserTypeConfigImpl.setDeclarationYearly(spUserTypeConfig.isDeclarationYearly());
		spUserTypeConfigImpl.setDeclarationFixedDate(spUserTypeConfig.getDeclarationFixedDate());
		spUserTypeConfigImpl.setPdpaId(spUserTypeConfig.getPdpaId());
		spUserTypeConfigImpl.setAccountCreationTemplateName(spUserTypeConfig.getAccountCreationTemplateName());
		spUserTypeConfigImpl.setWelcomeTemplateName(spUserTypeConfig.getWelcomeTemplateName());
		spUserTypeConfigImpl.setPasswordChangeTemplateName(spUserTypeConfig.getPasswordChangeTemplateName());
		spUserTypeConfigImpl.setPasswordResetTemplateName(spUserTypeConfig.getPasswordResetTemplateName());
		spUserTypeConfigImpl.setEmailVerificationTemplateName(spUserTypeConfig.getEmailVerificationTemplateName());
		spUserTypeConfigImpl.setDefauleRoleIds(spUserTypeConfig.getDefauleRoleIds());
		spUserTypeConfigImpl.setValidations(spUserTypeConfig.getValidations());
		spUserTypeConfigImpl.setGroupId(spUserTypeConfig.getGroupId());
		spUserTypeConfigImpl.setCompanyId(spUserTypeConfig.getCompanyId());
		spUserTypeConfigImpl.setCreatedBy(spUserTypeConfig.getCreatedBy());
		spUserTypeConfigImpl.setModifiedBy(spUserTypeConfig.getModifiedBy());
		spUserTypeConfigImpl.setCreatedDate(spUserTypeConfig.getCreatedDate());
		spUserTypeConfigImpl.setModifiedDate(spUserTypeConfig.getModifiedDate());

		return spUserTypeConfigImpl;
	}

	/**
	 * Returns the s p user type config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p user type config
	 * @return the s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPUserTypeConfigException, SystemException {
		SPUserTypeConfig spUserTypeConfig = fetchByPrimaryKey(primaryKey);

		if (spUserTypeConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPUserTypeConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spUserTypeConfig;
	}

	/**
	 * Returns the s p user type config with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	 *
	 * @param spUserTypeConfigId the primary key of the s p user type config
	 * @return the s p user type config
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig findByPrimaryKey(long spUserTypeConfigId)
		throws NoSuchSPUserTypeConfigException, SystemException {
		return findByPrimaryKey((Serializable)spUserTypeConfigId);
	}

	/**
	 * Returns the s p user type config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p user type config
	 * @return the s p user type config, or <code>null</code> if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPUserTypeConfig spUserTypeConfig = (SPUserTypeConfig)EntityCacheUtil.getResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
				SPUserTypeConfigImpl.class, primaryKey);

		if (spUserTypeConfig == _nullSPUserTypeConfig) {
			return null;
		}

		if (spUserTypeConfig == null) {
			Session session = null;

			try {
				session = openSession();

				spUserTypeConfig = (SPUserTypeConfig)session.get(SPUserTypeConfigImpl.class,
						primaryKey);

				if (spUserTypeConfig != null) {
					cacheResult(spUserTypeConfig);
				}
				else {
					EntityCacheUtil.putResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
						SPUserTypeConfigImpl.class, primaryKey,
						_nullSPUserTypeConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPUserTypeConfigModelImpl.ENTITY_CACHE_ENABLED,
					SPUserTypeConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spUserTypeConfig;
	}

	/**
	 * Returns the s p user type config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spUserTypeConfigId the primary key of the s p user type config
	 * @return the s p user type config, or <code>null</code> if a s p user type config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPUserTypeConfig fetchByPrimaryKey(long spUserTypeConfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spUserTypeConfigId);
	}

	/**
	 * Returns all the s p user type configs.
	 *
	 * @return the s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p user type configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @return the range of s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p user type configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p user type configs
	 * @param end the upper bound of the range of s p user type configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p user type configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPUserTypeConfig> findAll(int start, int end,
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

		List<SPUserTypeConfig> list = (List<SPUserTypeConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPUSERTYPECONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPUSERTYPECONFIG;

				if (pagination) {
					sql = sql.concat(SPUserTypeConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPUserTypeConfig>(list);
				}
				else {
					list = (List<SPUserTypeConfig>)QueryUtil.list(q,
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
	 * Removes all the s p user type configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPUserTypeConfig spUserTypeConfig : findAll()) {
			remove(spUserTypeConfig);
		}
	}

	/**
	 * Returns the number of s p user type configs.
	 *
	 * @return the number of s p user type configs
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

				Query q = session.createQuery(_SQL_COUNT_SPUSERTYPECONFIG);

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
	 * Initializes the s p user type config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPUserTypeConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPUserTypeConfig>> listenersList = new ArrayList<ModelListener<SPUserTypeConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPUserTypeConfig>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPUserTypeConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPUSERTYPECONFIG = "SELECT spUserTypeConfig FROM SPUserTypeConfig spUserTypeConfig";
	private static final String _SQL_SELECT_SPUSERTYPECONFIG_WHERE = "SELECT spUserTypeConfig FROM SPUserTypeConfig spUserTypeConfig WHERE ";
	private static final String _SQL_COUNT_SPUSERTYPECONFIG = "SELECT COUNT(spUserTypeConfig) FROM SPUserTypeConfig spUserTypeConfig";
	private static final String _SQL_COUNT_SPUSERTYPECONFIG_WHERE = "SELECT COUNT(spUserTypeConfig) FROM SPUserTypeConfig spUserTypeConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spUserTypeConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPUserTypeConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPUserTypeConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPUserTypeConfigPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPUserTypeConfig _nullSPUserTypeConfig = new SPUserTypeConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPUserTypeConfig> toCacheModel() {
				return _nullSPUserTypeConfigCacheModel;
			}
		};

	private static CacheModel<SPUserTypeConfig> _nullSPUserTypeConfigCacheModel = new CacheModel<SPUserTypeConfig>() {
			@Override
			public SPUserTypeConfig toEntityModel() {
				return _nullSPUserTypeConfig;
			}
		};
}