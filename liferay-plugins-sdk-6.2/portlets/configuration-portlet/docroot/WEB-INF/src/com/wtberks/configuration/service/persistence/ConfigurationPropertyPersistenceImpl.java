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

package com.wtberks.configuration.service.persistence;

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

import com.wtberks.configuration.NoSuchConfigurationPropertyException;
import com.wtberks.configuration.model.ConfigurationProperty;
import com.wtberks.configuration.model.impl.ConfigurationPropertyImpl;
import com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the configuration property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see ConfigurationPropertyPersistence
 * @see ConfigurationPropertyUtil
 * @generated
 */
public class ConfigurationPropertyPersistenceImpl extends BasePersistenceImpl<ConfigurationProperty>
	implements ConfigurationPropertyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConfigurationPropertyUtil} to access the configuration property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConfigurationPropertyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ConfigurationPropertyModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the configuration properties where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration properties where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @return the range of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration properties where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ConfigurationProperty> list = (List<ConfigurationProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConfigurationProperty configurationProperty : list) {
				if (!Validator.equals(uuid, configurationProperty.getUuid())) {
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

			query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

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
				query.append(ConfigurationPropertyModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConfigurationProperty>(list);
				}
				else {
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
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
	 * Returns the first configuration property in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUuid_First(uuid,
				orderByComparator);

		if (configurationProperty != null) {
			return configurationProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationPropertyException(msg.toString());
	}

	/**
	 * Returns the first configuration property in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConfigurationProperty> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration property in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUuid_Last(uuid,
				orderByComparator);

		if (configurationProperty != null) {
			return configurationProperty;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationPropertyException(msg.toString());
	}

	/**
	 * Returns the last configuration property in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ConfigurationProperty> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configuration properties before and after the current configuration property in the ordered set where uuid = &#63;.
	 *
	 * @param configurationPropertyId the primary key of the current configuration property
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty[] findByUuid_PrevAndNext(
		long configurationPropertyId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = findByPrimaryKey(configurationPropertyId);

		Session session = null;

		try {
			session = openSession();

			ConfigurationProperty[] array = new ConfigurationPropertyImpl[3];

			array[0] = getByUuid_PrevAndNext(session, configurationProperty,
					uuid, orderByComparator, true);

			array[1] = configurationProperty;

			array[2] = getByUuid_PrevAndNext(session, configurationProperty,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConfigurationProperty getByUuid_PrevAndNext(Session session,
		ConfigurationProperty configurationProperty, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

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
			query.append(ConfigurationPropertyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(configurationProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConfigurationProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configuration properties where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ConfigurationProperty configurationProperty : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(configurationProperty);
		}
	}

	/**
	 * Returns the number of configuration properties where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching configuration properties
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

			query.append(_SQL_COUNT_CONFIGURATIONPROPERTY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "configurationProperty.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "configurationProperty.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(configurationProperty.uuid IS NULL OR configurationProperty.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ConfigurationPropertyModelImpl.UUID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the configuration property where uuid = &#63; and groupId = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUUID_G(String uuid, long groupId)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUUID_G(uuid,
				groupId);

		if (configurationProperty == null) {
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

			throw new NoSuchConfigurationPropertyException(msg.toString());
		}

		return configurationProperty;
	}

	/**
	 * Returns the configuration property where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the configuration property where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ConfigurationProperty) {
			ConfigurationProperty configurationProperty = (ConfigurationProperty)result;

			if (!Validator.equals(uuid, configurationProperty.getUuid()) ||
					(groupId != configurationProperty.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

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

				List<ConfigurationProperty> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ConfigurationProperty configurationProperty = list.get(0);

					result = configurationProperty;

					cacheResult(configurationProperty);

					if ((configurationProperty.getUuid() == null) ||
							!configurationProperty.getUuid().equals(uuid) ||
							(configurationProperty.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, configurationProperty);
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
			return (ConfigurationProperty)result;
		}
	}

	/**
	 * Removes the configuration property where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the configuration property that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty removeByUUID_G(String uuid, long groupId)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = findByUUID_G(uuid, groupId);

		return remove(configurationProperty);
	}

	/**
	 * Returns the number of configuration properties where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching configuration properties
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

			query.append(_SQL_COUNT_CONFIGURATIONPROPERTY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "configurationProperty.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "configurationProperty.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(configurationProperty.uuid IS NULL OR configurationProperty.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "configurationProperty.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ConfigurationPropertyModelImpl.UUID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the configuration properties where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration properties where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @return the range of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration properties where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
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

		List<ConfigurationProperty> list = (List<ConfigurationProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConfigurationProperty configurationProperty : list) {
				if (!Validator.equals(uuid, configurationProperty.getUuid()) ||
						(companyId != configurationProperty.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

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
				query.append(ConfigurationPropertyModelImpl.ORDER_BY_JPQL);
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
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConfigurationProperty>(list);
				}
				else {
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
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
	 * Returns the first configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (configurationProperty != null) {
			return configurationProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationPropertyException(msg.toString());
	}

	/**
	 * Returns the first configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConfigurationProperty> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (configurationProperty != null) {
			return configurationProperty;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConfigurationPropertyException(msg.toString());
	}

	/**
	 * Returns the last configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ConfigurationProperty> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the configuration properties before and after the current configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param configurationPropertyId the primary key of the current configuration property
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty[] findByUuid_C_PrevAndNext(
		long configurationPropertyId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = findByPrimaryKey(configurationPropertyId);

		Session session = null;

		try {
			session = openSession();

			ConfigurationProperty[] array = new ConfigurationPropertyImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, configurationProperty,
					uuid, companyId, orderByComparator, true);

			array[1] = configurationProperty;

			array[2] = getByUuid_C_PrevAndNext(session, configurationProperty,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConfigurationProperty getByUuid_C_PrevAndNext(Session session,
		ConfigurationProperty configurationProperty, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

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
			query.append(ConfigurationPropertyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(configurationProperty);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConfigurationProperty> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the configuration properties where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ConfigurationProperty configurationProperty : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(configurationProperty);
		}
	}

	/**
	 * Returns the number of configuration properties where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching configuration properties
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

			query.append(_SQL_COUNT_CONFIGURATIONPROPERTY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "configurationProperty.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "configurationProperty.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(configurationProperty.uuid IS NULL OR configurationProperty.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "configurationProperty.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByKey",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ConfigurationPropertyModelImpl.COMPANYID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.GROUPID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByKey(long companyId, long groupId,
		String key)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByKey(companyId,
				groupId, key);

		if (configurationProperty == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConfigurationPropertyException(msg.toString());
		}

		return configurationProperty;
	}

	/**
	 * Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByKey(long companyId, long groupId,
		String key) throws SystemException {
		return fetchByKey(companyId, groupId, key, true);
	}

	/**
	 * Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByKey(long companyId, long groupId,
		String key, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, groupId, key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs, this);
		}

		if (result instanceof ConfigurationProperty) {
			ConfigurationProperty configurationProperty = (ConfigurationProperty)result;

			if ((companyId != configurationProperty.getCompanyId()) ||
					(groupId != configurationProperty.getGroupId()) ||
					!Validator.equals(key, configurationProperty.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_KEY_COMPANYID_2);

			query.append(_FINDER_COLUMN_KEY_GROUPID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindKey) {
					qPos.add(key);
				}

				List<ConfigurationProperty> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConfigurationPropertyPersistenceImpl.fetchByKey(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ConfigurationProperty configurationProperty = list.get(0);

					result = configurationProperty;

					cacheResult(configurationProperty);

					if ((configurationProperty.getCompanyId() != companyId) ||
							(configurationProperty.getGroupId() != groupId) ||
							(configurationProperty.getKey() == null) ||
							!configurationProperty.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
							finderArgs, configurationProperty);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
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
			return (ConfigurationProperty)result;
		}
	}

	/**
	 * Removes the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the configuration property that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty removeByKey(long companyId, long groupId,
		String key)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = findByKey(companyId,
				groupId, key);

		return remove(configurationProperty);
	}

	/**
	 * Returns the number of configuration properties where companyId = &#63; and groupId = &#63; and key = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the number of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKey(long companyId, long groupId, String key)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

		Object[] finderArgs = new Object[] { companyId, groupId, key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CONFIGURATIONPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_KEY_COMPANYID_2);

			query.append(_FINDER_COLUMN_KEY_GROUPID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_KEY_COMPANYID_2 = "configurationProperty.companyId = ? AND ";
	private static final String _FINDER_COLUMN_KEY_GROUPID_2 = "configurationProperty.groupId = ? AND ";
	private static final String _FINDER_COLUMN_KEY_KEY_1 = "configurationProperty.key IS NULL";
	private static final String _FINDER_COLUMN_KEY_KEY_2 = "configurationProperty.key = ?";
	private static final String _FINDER_COLUMN_KEY_KEY_3 = "(configurationProperty.key IS NULL OR configurationProperty.key = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDKEY = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED,
			ConfigurationPropertyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndKey",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ConfigurationPropertyModelImpl.USERID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.COMPANYID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.GROUPID_COLUMN_BITMASK |
			ConfigurationPropertyModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDKEY = new FinderPath(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdAndKey",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the matching configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByUserIdAndKey(long userId,
		long companyId, long groupId, String key)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByUserIdAndKey(userId,
				companyId, groupId, key);

		if (configurationProperty == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConfigurationPropertyException(msg.toString());
		}

		return configurationProperty;
	}

	/**
	 * Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUserIdAndKey(long userId,
		long companyId, long groupId, String key) throws SystemException {
		return fetchByUserIdAndKey(userId, companyId, groupId, key, true);
	}

	/**
	 * Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByUserIdAndKey(long userId,
		long companyId, long groupId, String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, companyId, groupId, key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
					finderArgs, this);
		}

		if (result instanceof ConfigurationProperty) {
			ConfigurationProperty configurationProperty = (ConfigurationProperty)result;

			if ((userId != configurationProperty.getUserId()) ||
					(companyId != configurationProperty.getCompanyId()) ||
					(groupId != configurationProperty.getGroupId()) ||
					!Validator.equals(key, configurationProperty.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_CONFIGURATIONPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDKEY_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDKEY_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDKEY_GROUPID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindKey) {
					qPos.add(key);
				}

				List<ConfigurationProperty> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConfigurationPropertyPersistenceImpl.fetchByUserIdAndKey(long, long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ConfigurationProperty configurationProperty = list.get(0);

					result = configurationProperty;

					cacheResult(configurationProperty);

					if ((configurationProperty.getUserId() != userId) ||
							(configurationProperty.getCompanyId() != companyId) ||
							(configurationProperty.getGroupId() != groupId) ||
							(configurationProperty.getKey() == null) ||
							!configurationProperty.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
							finderArgs, configurationProperty);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
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
			return (ConfigurationProperty)result;
		}
	}

	/**
	 * Removes the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the configuration property that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty removeByUserIdAndKey(long userId,
		long companyId, long groupId, String key)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = findByUserIdAndKey(userId,
				companyId, groupId, key);

		return remove(configurationProperty);
	}

	/**
	 * Returns the number of configuration properties where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param key the key
	 * @return the number of matching configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndKey(long userId, long companyId, long groupId,
		String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDKEY;

		Object[] finderArgs = new Object[] { userId, companyId, groupId, key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CONFIGURATIONPROPERTY_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDKEY_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDKEY_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDKEY_GROUPID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_USERIDANDKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(companyId);

				qPos.add(groupId);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_USERIDANDKEY_USERID_2 = "configurationProperty.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDKEY_COMPANYID_2 = "configurationProperty.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDKEY_GROUPID_2 = "configurationProperty.groupId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDKEY_KEY_1 = "configurationProperty.key IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDKEY_KEY_2 = "configurationProperty.key = ?";
	private static final String _FINDER_COLUMN_USERIDANDKEY_KEY_3 = "(configurationProperty.key IS NULL OR configurationProperty.key = '')";

	public ConfigurationPropertyPersistenceImpl() {
		setModelClass(ConfigurationProperty.class);
	}

	/**
	 * Caches the configuration property in the entity cache if it is enabled.
	 *
	 * @param configurationProperty the configuration property
	 */
	@Override
	public void cacheResult(ConfigurationProperty configurationProperty) {
		EntityCacheUtil.putResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			configurationProperty.getPrimaryKey(), configurationProperty);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				configurationProperty.getUuid(),
				configurationProperty.getGroupId()
			}, configurationProperty);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
			new Object[] {
				configurationProperty.getCompanyId(),
				configurationProperty.getGroupId(),
				configurationProperty.getKey()
			}, configurationProperty);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
			new Object[] {
				configurationProperty.getUserId(),
				configurationProperty.getCompanyId(),
				configurationProperty.getGroupId(),
				configurationProperty.getKey()
			}, configurationProperty);

		configurationProperty.resetOriginalValues();
	}

	/**
	 * Caches the configuration properties in the entity cache if it is enabled.
	 *
	 * @param configurationProperties the configuration properties
	 */
	@Override
	public void cacheResult(List<ConfigurationProperty> configurationProperties) {
		for (ConfigurationProperty configurationProperty : configurationProperties) {
			if (EntityCacheUtil.getResult(
						ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationPropertyImpl.class,
						configurationProperty.getPrimaryKey()) == null) {
				cacheResult(configurationProperty);
			}
			else {
				configurationProperty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all configuration properties.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConfigurationPropertyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConfigurationPropertyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the configuration property.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConfigurationProperty configurationProperty) {
		EntityCacheUtil.removeResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			configurationProperty.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(configurationProperty);
	}

	@Override
	public void clearCache(List<ConfigurationProperty> configurationProperties) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConfigurationProperty configurationProperty : configurationProperties) {
			EntityCacheUtil.removeResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationPropertyImpl.class,
				configurationProperty.getPrimaryKey());

			clearUniqueFindersCache(configurationProperty);
		}
	}

	protected void cacheUniqueFindersCache(
		ConfigurationProperty configurationProperty) {
		if (configurationProperty.isNew()) {
			Object[] args = new Object[] {
					configurationProperty.getUuid(),
					configurationProperty.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				configurationProperty);

			args = new Object[] {
					configurationProperty.getCompanyId(),
					configurationProperty.getGroupId(),
					configurationProperty.getKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
				configurationProperty);

			args = new Object[] {
					configurationProperty.getUserId(),
					configurationProperty.getCompanyId(),
					configurationProperty.getGroupId(),
					configurationProperty.getKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDKEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDKEY, args,
				configurationProperty);
		}
		else {
			ConfigurationPropertyModelImpl configurationPropertyModelImpl = (ConfigurationPropertyModelImpl)configurationProperty;

			if ((configurationPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationProperty.getUuid(),
						configurationProperty.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					configurationProperty);
			}

			if ((configurationPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationProperty.getCompanyId(),
						configurationProperty.getGroupId(),
						configurationProperty.getKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
					configurationProperty);
			}

			if ((configurationPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationProperty.getUserId(),
						configurationProperty.getCompanyId(),
						configurationProperty.getGroupId(),
						configurationProperty.getKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDKEY,
					args, configurationProperty);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ConfigurationProperty configurationProperty) {
		ConfigurationPropertyModelImpl configurationPropertyModelImpl = (ConfigurationPropertyModelImpl)configurationProperty;

		Object[] args = new Object[] {
				configurationProperty.getUuid(),
				configurationProperty.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((configurationPropertyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					configurationPropertyModelImpl.getOriginalUuid(),
					configurationPropertyModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				configurationProperty.getCompanyId(),
				configurationProperty.getGroupId(),
				configurationProperty.getKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

		if ((configurationPropertyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					configurationPropertyModelImpl.getOriginalCompanyId(),
					configurationPropertyModelImpl.getOriginalGroupId(),
					configurationPropertyModelImpl.getOriginalKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
		}

		args = new Object[] {
				configurationProperty.getUserId(),
				configurationProperty.getCompanyId(),
				configurationProperty.getGroupId(),
				configurationProperty.getKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDKEY, args);

		if ((configurationPropertyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					configurationPropertyModelImpl.getOriginalUserId(),
					configurationPropertyModelImpl.getOriginalCompanyId(),
					configurationPropertyModelImpl.getOriginalGroupId(),
					configurationPropertyModelImpl.getOriginalKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDKEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDKEY, args);
		}
	}

	/**
	 * Creates a new configuration property with the primary key. Does not add the configuration property to the database.
	 *
	 * @param configurationPropertyId the primary key for the new configuration property
	 * @return the new configuration property
	 */
	@Override
	public ConfigurationProperty create(long configurationPropertyId) {
		ConfigurationProperty configurationProperty = new ConfigurationPropertyImpl();

		configurationProperty.setNew(true);
		configurationProperty.setPrimaryKey(configurationPropertyId);

		String uuid = PortalUUIDUtil.generate();

		configurationProperty.setUuid(uuid);

		return configurationProperty;
	}

	/**
	 * Removes the configuration property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configurationPropertyId the primary key of the configuration property
	 * @return the configuration property that was removed
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty remove(long configurationPropertyId)
		throws NoSuchConfigurationPropertyException, SystemException {
		return remove((Serializable)configurationPropertyId);
	}

	/**
	 * Removes the configuration property with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuration property
	 * @return the configuration property that was removed
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty remove(Serializable primaryKey)
		throws NoSuchConfigurationPropertyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConfigurationProperty configurationProperty = (ConfigurationProperty)session.get(ConfigurationPropertyImpl.class,
					primaryKey);

			if (configurationProperty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfigurationPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(configurationProperty);
		}
		catch (NoSuchConfigurationPropertyException nsee) {
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
	protected ConfigurationProperty removeImpl(
		ConfigurationProperty configurationProperty) throws SystemException {
		configurationProperty = toUnwrappedModel(configurationProperty);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(configurationProperty)) {
				configurationProperty = (ConfigurationProperty)session.get(ConfigurationPropertyImpl.class,
						configurationProperty.getPrimaryKeyObj());
			}

			if (configurationProperty != null) {
				session.delete(configurationProperty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (configurationProperty != null) {
			clearCache(configurationProperty);
		}

		return configurationProperty;
	}

	@Override
	public ConfigurationProperty updateImpl(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws SystemException {
		configurationProperty = toUnwrappedModel(configurationProperty);

		boolean isNew = configurationProperty.isNew();

		ConfigurationPropertyModelImpl configurationPropertyModelImpl = (ConfigurationPropertyModelImpl)configurationProperty;

		if (Validator.isNull(configurationProperty.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			configurationProperty.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (configurationProperty.isNew()) {
				session.save(configurationProperty);

				configurationProperty.setNew(false);
			}
			else {
				session.merge(configurationProperty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConfigurationPropertyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((configurationPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationPropertyModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { configurationPropertyModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((configurationPropertyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						configurationPropertyModelImpl.getOriginalUuid(),
						configurationPropertyModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						configurationPropertyModelImpl.getUuid(),
						configurationPropertyModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
			ConfigurationPropertyImpl.class,
			configurationProperty.getPrimaryKey(), configurationProperty);

		clearUniqueFindersCache(configurationProperty);
		cacheUniqueFindersCache(configurationProperty);

		return configurationProperty;
	}

	protected ConfigurationProperty toUnwrappedModel(
		ConfigurationProperty configurationProperty) {
		if (configurationProperty instanceof ConfigurationPropertyImpl) {
			return configurationProperty;
		}

		ConfigurationPropertyImpl configurationPropertyImpl = new ConfigurationPropertyImpl();

		configurationPropertyImpl.setNew(configurationProperty.isNew());
		configurationPropertyImpl.setPrimaryKey(configurationProperty.getPrimaryKey());

		configurationPropertyImpl.setUuid(configurationProperty.getUuid());
		configurationPropertyImpl.setConfigurationPropertyId(configurationProperty.getConfigurationPropertyId());
		configurationPropertyImpl.setGroupId(configurationProperty.getGroupId());
		configurationPropertyImpl.setCompanyId(configurationProperty.getCompanyId());
		configurationPropertyImpl.setUserId(configurationProperty.getUserId());
		configurationPropertyImpl.setUserName(configurationProperty.getUserName());
		configurationPropertyImpl.setCreateDate(configurationProperty.getCreateDate());
		configurationPropertyImpl.setModifiedDate(configurationProperty.getModifiedDate());
		configurationPropertyImpl.setKey(configurationProperty.getKey());
		configurationPropertyImpl.setValue(configurationProperty.getValue());

		return configurationPropertyImpl;
	}

	/**
	 * Returns the configuration property with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration property
	 * @return the configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConfigurationPropertyException, SystemException {
		ConfigurationProperty configurationProperty = fetchByPrimaryKey(primaryKey);

		if (configurationProperty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConfigurationPropertyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return configurationProperty;
	}

	/**
	 * Returns the configuration property with the primary key or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	 *
	 * @param configurationPropertyId the primary key of the configuration property
	 * @return the configuration property
	 * @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty findByPrimaryKey(long configurationPropertyId)
		throws NoSuchConfigurationPropertyException, SystemException {
		return findByPrimaryKey((Serializable)configurationPropertyId);
	}

	/**
	 * Returns the configuration property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuration property
	 * @return the configuration property, or <code>null</code> if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConfigurationProperty configurationProperty = (ConfigurationProperty)EntityCacheUtil.getResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
				ConfigurationPropertyImpl.class, primaryKey);

		if (configurationProperty == _nullConfigurationProperty) {
			return null;
		}

		if (configurationProperty == null) {
			Session session = null;

			try {
				session = openSession();

				configurationProperty = (ConfigurationProperty)session.get(ConfigurationPropertyImpl.class,
						primaryKey);

				if (configurationProperty != null) {
					cacheResult(configurationProperty);
				}
				else {
					EntityCacheUtil.putResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
						ConfigurationPropertyImpl.class, primaryKey,
						_nullConfigurationProperty);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConfigurationPropertyModelImpl.ENTITY_CACHE_ENABLED,
					ConfigurationPropertyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return configurationProperty;
	}

	/**
	 * Returns the configuration property with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configurationPropertyId the primary key of the configuration property
	 * @return the configuration property, or <code>null</code> if a configuration property with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfigurationProperty fetchByPrimaryKey(long configurationPropertyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)configurationPropertyId);
	}

	/**
	 * Returns all the configuration properties.
	 *
	 * @return the configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuration properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @return the range of configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuration properties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuration properties
	 * @param end the upper bound of the range of configuration properties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configuration properties
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConfigurationProperty> findAll(int start, int end,
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

		List<ConfigurationProperty> list = (List<ConfigurationProperty>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONFIGURATIONPROPERTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURATIONPROPERTY;

				if (pagination) {
					sql = sql.concat(ConfigurationPropertyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConfigurationProperty>(list);
				}
				else {
					list = (List<ConfigurationProperty>)QueryUtil.list(q,
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
	 * Removes all the configuration properties from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConfigurationProperty configurationProperty : findAll()) {
			remove(configurationProperty);
		}
	}

	/**
	 * Returns the number of configuration properties.
	 *
	 * @return the number of configuration properties
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

				Query q = session.createQuery(_SQL_COUNT_CONFIGURATIONPROPERTY);

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
	 * Initializes the configuration property persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.wtberks.configuration.model.ConfigurationProperty")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConfigurationProperty>> listenersList = new ArrayList<ModelListener<ConfigurationProperty>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConfigurationProperty>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConfigurationPropertyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONFIGURATIONPROPERTY = "SELECT configurationProperty FROM ConfigurationProperty configurationProperty";
	private static final String _SQL_SELECT_CONFIGURATIONPROPERTY_WHERE = "SELECT configurationProperty FROM ConfigurationProperty configurationProperty WHERE ";
	private static final String _SQL_COUNT_CONFIGURATIONPROPERTY = "SELECT COUNT(configurationProperty) FROM ConfigurationProperty configurationProperty";
	private static final String _SQL_COUNT_CONFIGURATIONPROPERTY_WHERE = "SELECT COUNT(configurationProperty) FROM ConfigurationProperty configurationProperty WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configurationProperty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConfigurationProperty exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConfigurationProperty exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfigurationPropertyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "key"
			});
	private static ConfigurationProperty _nullConfigurationProperty = new ConfigurationPropertyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConfigurationProperty> toCacheModel() {
				return _nullConfigurationPropertyCacheModel;
			}
		};

	private static CacheModel<ConfigurationProperty> _nullConfigurationPropertyCacheModel =
		new CacheModel<ConfigurationProperty>() {
			@Override
			public ConfigurationProperty toEntityModel() {
				return _nullConfigurationProperty;
			}
		};
}