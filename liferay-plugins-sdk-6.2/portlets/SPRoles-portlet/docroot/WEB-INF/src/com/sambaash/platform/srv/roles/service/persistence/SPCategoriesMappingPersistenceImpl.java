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

import com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException;
import com.sambaash.platform.srv.roles.model.SPCategoriesMapping;
import com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingImpl;
import com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p categories mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPCategoriesMappingPersistence
 * @see SPCategoriesMappingUtil
 * @generated
 */
public class SPCategoriesMappingPersistenceImpl extends BasePersistenceImpl<SPCategoriesMapping>
	implements SPCategoriesMappingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCategoriesMappingUtil} to access the s p categories mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCategoriesMappingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPCategoriesMappingModelImpl.UUID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.MAINCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p categories mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p categories mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @return the range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p categories mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid(String uuid, int start,
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

		List<SPCategoriesMapping> list = (List<SPCategoriesMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCategoriesMapping spCategoriesMapping : list) {
				if (!Validator.equals(uuid, spCategoriesMapping.getUuid())) {
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

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

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
				query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCategoriesMapping>(list);
				}
				else {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
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
	 * Returns the first s p categories mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByUuid_First(uuid,
				orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the first s p categories mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCategoriesMapping> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByUuid_Last(uuid,
				orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPCategoriesMapping> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where uuid = &#63;.
	 *
	 * @param spCategoryMappingId the primary key of the current s p categories mapping
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping[] findByUuid_PrevAndNext(
		long spCategoryMappingId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByPrimaryKey(spCategoryMappingId);

		Session session = null;

		try {
			session = openSession();

			SPCategoriesMapping[] array = new SPCategoriesMappingImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spCategoriesMapping,
					uuid, orderByComparator, true);

			array[1] = spCategoriesMapping;

			array[2] = getByUuid_PrevAndNext(session, spCategoriesMapping,
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

	protected SPCategoriesMapping getByUuid_PrevAndNext(Session session,
		SPCategoriesMapping spCategoriesMapping, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

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
			query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spCategoriesMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCategoriesMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p categories mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPCategoriesMapping spCategoriesMapping : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCategoriesMapping);
		}
	}

	/**
	 * Returns the number of s p categories mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p categories mappings
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

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spCategoriesMapping.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spCategoriesMapping.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spCategoriesMapping.uuid IS NULL OR spCategoriesMapping.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPCategoriesMappingModelImpl.UUID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByUUID_G(String uuid, long groupId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByUUID_G(uuid, groupId);

		if (spCategoriesMapping == null) {
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

			throw new NoSuchSPCategoriesMappingException(msg.toString());
		}

		return spCategoriesMapping;
	}

	/**
	 * Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p categories mapping where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPCategoriesMapping) {
			SPCategoriesMapping spCategoriesMapping = (SPCategoriesMapping)result;

			if (!Validator.equals(uuid, spCategoriesMapping.getUuid()) ||
					(groupId != spCategoriesMapping.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

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

				List<SPCategoriesMapping> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPCategoriesMapping spCategoriesMapping = list.get(0);

					result = spCategoriesMapping;

					cacheResult(spCategoriesMapping);

					if ((spCategoriesMapping.getUuid() == null) ||
							!spCategoriesMapping.getUuid().equals(uuid) ||
							(spCategoriesMapping.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spCategoriesMapping);
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
			return (SPCategoriesMapping)result;
		}
	}

	/**
	 * Removes the s p categories mapping where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p categories mapping that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByUUID_G(uuid, groupId);

		return remove(spCategoriesMapping);
	}

	/**
	 * Returns the number of s p categories mappings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p categories mappings
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

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spCategoriesMapping.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spCategoriesMapping.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spCategoriesMapping.uuid IS NULL OR spCategoriesMapping.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spCategoriesMapping.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPCategoriesMappingModelImpl.UUID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.COMPANYID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.MAINCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @return the range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p categories mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByUuid_C(String uuid, long companyId,
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

		List<SPCategoriesMapping> list = (List<SPCategoriesMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCategoriesMapping spCategoriesMapping : list) {
				if (!Validator.equals(uuid, spCategoriesMapping.getUuid()) ||
						(companyId != spCategoriesMapping.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

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
				query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCategoriesMapping>(list);
				}
				else {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
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
	 * Returns the first s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the first s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCategoriesMapping> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPCategoriesMapping> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spCategoryMappingId the primary key of the current s p categories mapping
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping[] findByUuid_C_PrevAndNext(
		long spCategoryMappingId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByPrimaryKey(spCategoryMappingId);

		Session session = null;

		try {
			session = openSession();

			SPCategoriesMapping[] array = new SPCategoriesMappingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spCategoriesMapping,
					uuid, companyId, orderByComparator, true);

			array[1] = spCategoriesMapping;

			array[2] = getByUuid_C_PrevAndNext(session, spCategoriesMapping,
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

	protected SPCategoriesMapping getByUuid_C_PrevAndNext(Session session,
		SPCategoriesMapping spCategoriesMapping, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

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
			query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spCategoriesMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCategoriesMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p categories mappings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPCategoriesMapping spCategoriesMapping : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCategoriesMapping);
		}
	}

	/**
	 * Returns the number of s p categories mappings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p categories mappings
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

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spCategoriesMapping.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spCategoriesMapping.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spCategoriesMapping.uuid IS NULL OR spCategoriesMapping.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spCategoriesMapping.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDVOCABULARYID =
		new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedVocabularyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDVOCABULARYID =
		new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreatedVocabularyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPCategoriesMappingModelImpl.GROUPID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.CREATEDVOCABULARYID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.MAINCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDVOCABULARYID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreatedVocabularyId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @return the matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByCreatedVocabularyId(long groupId,
		long createdVocabularyId) throws SystemException {
		return findByCreatedVocabularyId(groupId, createdVocabularyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @return the range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByCreatedVocabularyId(long groupId,
		long createdVocabularyId, int start, int end) throws SystemException {
		return findByCreatedVocabularyId(groupId, createdVocabularyId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByCreatedVocabularyId(long groupId,
		long createdVocabularyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDVOCABULARYID;
			finderArgs = new Object[] { groupId, createdVocabularyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDVOCABULARYID;
			finderArgs = new Object[] {
					groupId, createdVocabularyId,
					
					start, end, orderByComparator
				};
		}

		List<SPCategoriesMapping> list = (List<SPCategoriesMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCategoriesMapping spCategoriesMapping : list) {
				if ((groupId != spCategoriesMapping.getGroupId()) ||
						(createdVocabularyId != spCategoriesMapping.getCreatedVocabularyId())) {
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

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_GROUPID_2);

			query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_CREATEDVOCABULARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdVocabularyId);

				if (!pagination) {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCategoriesMapping>(list);
				}
				else {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
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
	 * Returns the first s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByCreatedVocabularyId_First(long groupId,
		long createdVocabularyId, OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByCreatedVocabularyId_First(groupId,
				createdVocabularyId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdVocabularyId=");
		msg.append(createdVocabularyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the first s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByCreatedVocabularyId_First(long groupId,
		long createdVocabularyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPCategoriesMapping> list = findByCreatedVocabularyId(groupId,
				createdVocabularyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByCreatedVocabularyId_Last(long groupId,
		long createdVocabularyId, OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByCreatedVocabularyId_Last(groupId,
				createdVocabularyId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", createdVocabularyId=");
		msg.append(createdVocabularyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByCreatedVocabularyId_Last(long groupId,
		long createdVocabularyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCreatedVocabularyId(groupId, createdVocabularyId);

		if (count == 0) {
			return null;
		}

		List<SPCategoriesMapping> list = findByCreatedVocabularyId(groupId,
				createdVocabularyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param spCategoryMappingId the primary key of the current s p categories mapping
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping[] findByCreatedVocabularyId_PrevAndNext(
		long spCategoryMappingId, long groupId, long createdVocabularyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByPrimaryKey(spCategoryMappingId);

		Session session = null;

		try {
			session = openSession();

			SPCategoriesMapping[] array = new SPCategoriesMappingImpl[3];

			array[0] = getByCreatedVocabularyId_PrevAndNext(session,
					spCategoriesMapping, groupId, createdVocabularyId,
					orderByComparator, true);

			array[1] = spCategoriesMapping;

			array[2] = getByCreatedVocabularyId_PrevAndNext(session,
					spCategoriesMapping, groupId, createdVocabularyId,
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

	protected SPCategoriesMapping getByCreatedVocabularyId_PrevAndNext(
		Session session, SPCategoriesMapping spCategoriesMapping, long groupId,
		long createdVocabularyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

		query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_GROUPID_2);

		query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_CREATEDVOCABULARYID_2);

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
			query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(createdVocabularyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCategoriesMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCategoriesMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p categories mappings where groupId = &#63; and createdVocabularyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreatedVocabularyId(long groupId,
		long createdVocabularyId) throws SystemException {
		for (SPCategoriesMapping spCategoriesMapping : findByCreatedVocabularyId(
				groupId, createdVocabularyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spCategoriesMapping);
		}
	}

	/**
	 * Returns the number of s p categories mappings where groupId = &#63; and createdVocabularyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param createdVocabularyId the created vocabulary ID
	 * @return the number of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreatedVocabularyId(long groupId, long createdVocabularyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDVOCABULARYID;

		Object[] finderArgs = new Object[] { groupId, createdVocabularyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_GROUPID_2);

			query.append(_FINDER_COLUMN_CREATEDVOCABULARYID_CREATEDVOCABULARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(createdVocabularyId);

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

	private static final String _FINDER_COLUMN_CREATEDVOCABULARYID_GROUPID_2 = "spCategoriesMapping.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDVOCABULARYID_CREATEDVOCABULARYID_2 =
		"spCategoriesMapping.createdVocabularyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAINCATEGORYID =
		new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMainCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINCATEGORYID =
		new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMainCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPCategoriesMappingModelImpl.GROUPID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.MAINCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAINCATEGORYID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMainCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @return the matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByMainCategoryId(long groupId,
		long mainCategoryId) throws SystemException {
		return findByMainCategoryId(groupId, mainCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @return the range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByMainCategoryId(long groupId,
		long mainCategoryId, int start, int end) throws SystemException {
		return findByMainCategoryId(groupId, mainCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findByMainCategoryId(long groupId,
		long mainCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINCATEGORYID;
			finderArgs = new Object[] { groupId, mainCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAINCATEGORYID;
			finderArgs = new Object[] {
					groupId, mainCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<SPCategoriesMapping> list = (List<SPCategoriesMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCategoriesMapping spCategoriesMapping : list) {
				if ((groupId != spCategoriesMapping.getGroupId()) ||
						(mainCategoryId != spCategoriesMapping.getMainCategoryId())) {
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

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MAINCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_MAINCATEGORYID_MAINCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mainCategoryId);

				if (!pagination) {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCategoriesMapping>(list);
				}
				else {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
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
	 * Returns the first s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByMainCategoryId_First(long groupId,
		long mainCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByMainCategoryId_First(groupId,
				mainCategoryId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", mainCategoryId=");
		msg.append(mainCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the first s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByMainCategoryId_First(long groupId,
		long mainCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPCategoriesMapping> list = findByMainCategoryId(groupId,
				mainCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByMainCategoryId_Last(long groupId,
		long mainCategoryId, OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByMainCategoryId_Last(groupId,
				mainCategoryId, orderByComparator);

		if (spCategoriesMapping != null) {
			return spCategoriesMapping;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", mainCategoryId=");
		msg.append(mainCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCategoriesMappingException(msg.toString());
	}

	/**
	 * Returns the last s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByMainCategoryId_Last(long groupId,
		long mainCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMainCategoryId(groupId, mainCategoryId);

		if (count == 0) {
			return null;
		}

		List<SPCategoriesMapping> list = findByMainCategoryId(groupId,
				mainCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p categories mappings before and after the current s p categories mapping in the ordered set where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param spCategoryMappingId the primary key of the current s p categories mapping
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping[] findByMainCategoryId_PrevAndNext(
		long spCategoryMappingId, long groupId, long mainCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByPrimaryKey(spCategoryMappingId);

		Session session = null;

		try {
			session = openSession();

			SPCategoriesMapping[] array = new SPCategoriesMappingImpl[3];

			array[0] = getByMainCategoryId_PrevAndNext(session,
					spCategoriesMapping, groupId, mainCategoryId,
					orderByComparator, true);

			array[1] = spCategoriesMapping;

			array[2] = getByMainCategoryId_PrevAndNext(session,
					spCategoriesMapping, groupId, mainCategoryId,
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

	protected SPCategoriesMapping getByMainCategoryId_PrevAndNext(
		Session session, SPCategoriesMapping spCategoriesMapping, long groupId,
		long mainCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

		query.append(_FINDER_COLUMN_MAINCATEGORYID_GROUPID_2);

		query.append(_FINDER_COLUMN_MAINCATEGORYID_MAINCATEGORYID_2);

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
			query.append(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(mainCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCategoriesMapping);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCategoriesMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p categories mappings where groupId = &#63; and mainCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMainCategoryId(long groupId, long mainCategoryId)
		throws SystemException {
		for (SPCategoriesMapping spCategoriesMapping : findByMainCategoryId(
				groupId, mainCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spCategoriesMapping);
		}
	}

	/**
	 * Returns the number of s p categories mappings where groupId = &#63; and mainCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @return the number of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMainCategoryId(long groupId, long mainCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAINCATEGORYID;

		Object[] finderArgs = new Object[] { groupId, mainCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MAINCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_MAINCATEGORYID_MAINCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mainCategoryId);

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

	private static final String _FINDER_COLUMN_MAINCATEGORYID_GROUPID_2 = "spCategoriesMapping.groupId = ? AND ";
	private static final String _FINDER_COLUMN_MAINCATEGORYID_MAINCATEGORYID_2 = "spCategoriesMapping.mainCategoryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED,
			SPCategoriesMappingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMainAndSubCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPCategoriesMappingModelImpl.GROUPID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.MAINCATEGORYID_COLUMN_BITMASK |
			SPCategoriesMappingModelImpl.SUBCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID = new FinderPath(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMainAndSubCategoryId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param subCategoryId the sub category ID
	 * @return the matching s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByMainAndSubCategoryId(long groupId,
		long mainCategoryId, long subCategoryId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByMainAndSubCategoryId(groupId,
				mainCategoryId, subCategoryId);

		if (spCategoriesMapping == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", mainCategoryId=");
			msg.append(mainCategoryId);

			msg.append(", subCategoryId=");
			msg.append(subCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPCategoriesMappingException(msg.toString());
		}

		return spCategoriesMapping;
	}

	/**
	 * Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param subCategoryId the sub category ID
	 * @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByMainAndSubCategoryId(long groupId,
		long mainCategoryId, long subCategoryId) throws SystemException {
		return fetchByMainAndSubCategoryId(groupId, mainCategoryId,
			subCategoryId, true);
	}

	/**
	 * Returns the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param subCategoryId the sub category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p categories mapping, or <code>null</code> if a matching s p categories mapping could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByMainAndSubCategoryId(long groupId,
		long mainCategoryId, long subCategoryId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId, mainCategoryId, subCategoryId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof SPCategoriesMapping) {
			SPCategoriesMapping spCategoriesMapping = (SPCategoriesMapping)result;

			if ((groupId != spCategoriesMapping.getGroupId()) ||
					(mainCategoryId != spCategoriesMapping.getMainCategoryId()) ||
					(subCategoryId != spCategoriesMapping.getSubCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_MAINCATEGORYID_2);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_SUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mainCategoryId);

				qPos.add(subCategoryId);

				List<SPCategoriesMapping> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPCategoriesMappingPersistenceImpl.fetchByMainAndSubCategoryId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPCategoriesMapping spCategoriesMapping = list.get(0);

					result = spCategoriesMapping;

					cacheResult(spCategoriesMapping);

					if ((spCategoriesMapping.getGroupId() != groupId) ||
							(spCategoriesMapping.getMainCategoryId() != mainCategoryId) ||
							(spCategoriesMapping.getSubCategoryId() != subCategoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
							finderArgs, spCategoriesMapping);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
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
			return (SPCategoriesMapping)result;
		}
	}

	/**
	 * Removes the s p categories mapping where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param subCategoryId the sub category ID
	 * @return the s p categories mapping that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping removeByMainAndSubCategoryId(long groupId,
		long mainCategoryId, long subCategoryId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = findByMainAndSubCategoryId(groupId,
				mainCategoryId, subCategoryId);

		return remove(spCategoriesMapping);
	}

	/**
	 * Returns the number of s p categories mappings where groupId = &#63; and mainCategoryId = &#63; and subCategoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param mainCategoryId the main category ID
	 * @param subCategoryId the sub category ID
	 * @return the number of matching s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMainAndSubCategoryId(long groupId, long mainCategoryId,
		long subCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID;

		Object[] finderArgs = new Object[] {
				groupId, mainCategoryId, subCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPCATEGORIESMAPPING_WHERE);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_GROUPID_2);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_MAINCATEGORYID_2);

			query.append(_FINDER_COLUMN_MAINANDSUBCATEGORYID_SUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(mainCategoryId);

				qPos.add(subCategoryId);

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

	private static final String _FINDER_COLUMN_MAINANDSUBCATEGORYID_GROUPID_2 = "spCategoriesMapping.groupId = ? AND ";
	private static final String _FINDER_COLUMN_MAINANDSUBCATEGORYID_MAINCATEGORYID_2 =
		"spCategoriesMapping.mainCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_MAINANDSUBCATEGORYID_SUBCATEGORYID_2 =
		"spCategoriesMapping.subCategoryId = ?";

	public SPCategoriesMappingPersistenceImpl() {
		setModelClass(SPCategoriesMapping.class);
	}

	/**
	 * Caches the s p categories mapping in the entity cache if it is enabled.
	 *
	 * @param spCategoriesMapping the s p categories mapping
	 */
	@Override
	public void cacheResult(SPCategoriesMapping spCategoriesMapping) {
		EntityCacheUtil.putResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingImpl.class, spCategoriesMapping.getPrimaryKey(),
			spCategoriesMapping);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				spCategoriesMapping.getUuid(), spCategoriesMapping.getGroupId()
			}, spCategoriesMapping);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
			new Object[] {
				spCategoriesMapping.getGroupId(),
				spCategoriesMapping.getMainCategoryId(),
				spCategoriesMapping.getSubCategoryId()
			}, spCategoriesMapping);

		spCategoriesMapping.resetOriginalValues();
	}

	/**
	 * Caches the s p categories mappings in the entity cache if it is enabled.
	 *
	 * @param spCategoriesMappings the s p categories mappings
	 */
	@Override
	public void cacheResult(List<SPCategoriesMapping> spCategoriesMappings) {
		for (SPCategoriesMapping spCategoriesMapping : spCategoriesMappings) {
			if (EntityCacheUtil.getResult(
						SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
						SPCategoriesMappingImpl.class,
						spCategoriesMapping.getPrimaryKey()) == null) {
				cacheResult(spCategoriesMapping);
			}
			else {
				spCategoriesMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p categories mappings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCategoriesMappingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCategoriesMappingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p categories mapping.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCategoriesMapping spCategoriesMapping) {
		EntityCacheUtil.removeResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingImpl.class, spCategoriesMapping.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spCategoriesMapping);
	}

	@Override
	public void clearCache(List<SPCategoriesMapping> spCategoriesMappings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCategoriesMapping spCategoriesMapping : spCategoriesMappings) {
			EntityCacheUtil.removeResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
				SPCategoriesMappingImpl.class,
				spCategoriesMapping.getPrimaryKey());

			clearUniqueFindersCache(spCategoriesMapping);
		}
	}

	protected void cacheUniqueFindersCache(
		SPCategoriesMapping spCategoriesMapping) {
		if (spCategoriesMapping.isNew()) {
			Object[] args = new Object[] {
					spCategoriesMapping.getUuid(),
					spCategoriesMapping.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spCategoriesMapping);

			args = new Object[] {
					spCategoriesMapping.getGroupId(),
					spCategoriesMapping.getMainCategoryId(),
					spCategoriesMapping.getSubCategoryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
				args, spCategoriesMapping);
		}
		else {
			SPCategoriesMappingModelImpl spCategoriesMappingModelImpl = (SPCategoriesMappingModelImpl)spCategoriesMapping;

			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMapping.getUuid(),
						spCategoriesMapping.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spCategoriesMapping);
			}

			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMapping.getGroupId(),
						spCategoriesMapping.getMainCategoryId(),
						spCategoriesMapping.getSubCategoryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
					args, spCategoriesMapping);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SPCategoriesMapping spCategoriesMapping) {
		SPCategoriesMappingModelImpl spCategoriesMappingModelImpl = (SPCategoriesMappingModelImpl)spCategoriesMapping;

		Object[] args = new Object[] {
				spCategoriesMapping.getUuid(), spCategoriesMapping.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spCategoriesMappingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spCategoriesMappingModelImpl.getOriginalUuid(),
					spCategoriesMappingModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spCategoriesMapping.getGroupId(),
				spCategoriesMapping.getMainCategoryId(),
				spCategoriesMapping.getSubCategoryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
			args);

		if ((spCategoriesMappingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spCategoriesMappingModelImpl.getOriginalGroupId(),
					spCategoriesMappingModelImpl.getOriginalMainCategoryId(),
					spCategoriesMappingModelImpl.getOriginalSubCategoryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINANDSUBCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAINANDSUBCATEGORYID,
				args);
		}
	}

	/**
	 * Creates a new s p categories mapping with the primary key. Does not add the s p categories mapping to the database.
	 *
	 * @param spCategoryMappingId the primary key for the new s p categories mapping
	 * @return the new s p categories mapping
	 */
	@Override
	public SPCategoriesMapping create(long spCategoryMappingId) {
		SPCategoriesMapping spCategoriesMapping = new SPCategoriesMappingImpl();

		spCategoriesMapping.setNew(true);
		spCategoriesMapping.setPrimaryKey(spCategoryMappingId);

		String uuid = PortalUUIDUtil.generate();

		spCategoriesMapping.setUuid(uuid);

		return spCategoriesMapping;
	}

	/**
	 * Removes the s p categories mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCategoryMappingId the primary key of the s p categories mapping
	 * @return the s p categories mapping that was removed
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping remove(long spCategoryMappingId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		return remove((Serializable)spCategoryMappingId);
	}

	/**
	 * Removes the s p categories mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p categories mapping
	 * @return the s p categories mapping that was removed
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping remove(Serializable primaryKey)
		throws NoSuchSPCategoriesMappingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCategoriesMapping spCategoriesMapping = (SPCategoriesMapping)session.get(SPCategoriesMappingImpl.class,
					primaryKey);

			if (spCategoriesMapping == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCategoriesMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCategoriesMapping);
		}
		catch (NoSuchSPCategoriesMappingException nsee) {
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
	protected SPCategoriesMapping removeImpl(
		SPCategoriesMapping spCategoriesMapping) throws SystemException {
		spCategoriesMapping = toUnwrappedModel(spCategoriesMapping);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCategoriesMapping)) {
				spCategoriesMapping = (SPCategoriesMapping)session.get(SPCategoriesMappingImpl.class,
						spCategoriesMapping.getPrimaryKeyObj());
			}

			if (spCategoriesMapping != null) {
				session.delete(spCategoriesMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCategoriesMapping != null) {
			clearCache(spCategoriesMapping);
		}

		return spCategoriesMapping;
	}

	@Override
	public SPCategoriesMapping updateImpl(
		com.sambaash.platform.srv.roles.model.SPCategoriesMapping spCategoriesMapping)
		throws SystemException {
		spCategoriesMapping = toUnwrappedModel(spCategoriesMapping);

		boolean isNew = spCategoriesMapping.isNew();

		SPCategoriesMappingModelImpl spCategoriesMappingModelImpl = (SPCategoriesMappingModelImpl)spCategoriesMapping;

		if (Validator.isNull(spCategoriesMapping.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spCategoriesMapping.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spCategoriesMapping.isNew()) {
				session.save(spCategoriesMapping);

				spCategoriesMapping.setNew(false);
			}
			else {
				session.merge(spCategoriesMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPCategoriesMappingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMappingModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spCategoriesMappingModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMappingModelImpl.getOriginalUuid(),
						spCategoriesMappingModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spCategoriesMappingModelImpl.getUuid(),
						spCategoriesMappingModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDVOCABULARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMappingModelImpl.getOriginalGroupId(),
						spCategoriesMappingModelImpl.getOriginalCreatedVocabularyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDVOCABULARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDVOCABULARYID,
					args);

				args = new Object[] {
						spCategoriesMappingModelImpl.getGroupId(),
						spCategoriesMappingModelImpl.getCreatedVocabularyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDVOCABULARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDVOCABULARYID,
					args);
			}

			if ((spCategoriesMappingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCategoriesMappingModelImpl.getOriginalGroupId(),
						spCategoriesMappingModelImpl.getOriginalMainCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINCATEGORYID,
					args);

				args = new Object[] {
						spCategoriesMappingModelImpl.getGroupId(),
						spCategoriesMappingModelImpl.getMainCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAINCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MAINCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
			SPCategoriesMappingImpl.class, spCategoriesMapping.getPrimaryKey(),
			spCategoriesMapping);

		clearUniqueFindersCache(spCategoriesMapping);
		cacheUniqueFindersCache(spCategoriesMapping);

		return spCategoriesMapping;
	}

	protected SPCategoriesMapping toUnwrappedModel(
		SPCategoriesMapping spCategoriesMapping) {
		if (spCategoriesMapping instanceof SPCategoriesMappingImpl) {
			return spCategoriesMapping;
		}

		SPCategoriesMappingImpl spCategoriesMappingImpl = new SPCategoriesMappingImpl();

		spCategoriesMappingImpl.setNew(spCategoriesMapping.isNew());
		spCategoriesMappingImpl.setPrimaryKey(spCategoriesMapping.getPrimaryKey());

		spCategoriesMappingImpl.setUuid(spCategoriesMapping.getUuid());
		spCategoriesMappingImpl.setSpCategoryMappingId(spCategoriesMapping.getSpCategoryMappingId());
		spCategoriesMappingImpl.setGroupId(spCategoriesMapping.getGroupId());
		spCategoriesMappingImpl.setCompanyId(spCategoriesMapping.getCompanyId());
		spCategoriesMappingImpl.setUserId(spCategoriesMapping.getUserId());
		spCategoriesMappingImpl.setUserName(spCategoriesMapping.getUserName());
		spCategoriesMappingImpl.setCreateDate(spCategoriesMapping.getCreateDate());
		spCategoriesMappingImpl.setModifiedDate(spCategoriesMapping.getModifiedDate());
		spCategoriesMappingImpl.setCreatedVocabularyId(spCategoriesMapping.getCreatedVocabularyId());
		spCategoriesMappingImpl.setMainCategoryId(spCategoriesMapping.getMainCategoryId());
		spCategoriesMappingImpl.setSubCategoryId(spCategoriesMapping.getSubCategoryId());

		return spCategoriesMappingImpl;
	}

	/**
	 * Returns the s p categories mapping with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p categories mapping
	 * @return the s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCategoriesMappingException, SystemException {
		SPCategoriesMapping spCategoriesMapping = fetchByPrimaryKey(primaryKey);

		if (spCategoriesMapping == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCategoriesMappingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCategoriesMapping;
	}

	/**
	 * Returns the s p categories mapping with the primary key or throws a {@link com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException} if it could not be found.
	 *
	 * @param spCategoryMappingId the primary key of the s p categories mapping
	 * @return the s p categories mapping
	 * @throws com.sambaash.platform.srv.roles.NoSuchSPCategoriesMappingException if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping findByPrimaryKey(long spCategoryMappingId)
		throws NoSuchSPCategoriesMappingException, SystemException {
		return findByPrimaryKey((Serializable)spCategoryMappingId);
	}

	/**
	 * Returns the s p categories mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p categories mapping
	 * @return the s p categories mapping, or <code>null</code> if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCategoriesMapping spCategoriesMapping = (SPCategoriesMapping)EntityCacheUtil.getResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
				SPCategoriesMappingImpl.class, primaryKey);

		if (spCategoriesMapping == _nullSPCategoriesMapping) {
			return null;
		}

		if (spCategoriesMapping == null) {
			Session session = null;

			try {
				session = openSession();

				spCategoriesMapping = (SPCategoriesMapping)session.get(SPCategoriesMappingImpl.class,
						primaryKey);

				if (spCategoriesMapping != null) {
					cacheResult(spCategoriesMapping);
				}
				else {
					EntityCacheUtil.putResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
						SPCategoriesMappingImpl.class, primaryKey,
						_nullSPCategoriesMapping);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCategoriesMappingModelImpl.ENTITY_CACHE_ENABLED,
					SPCategoriesMappingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCategoriesMapping;
	}

	/**
	 * Returns the s p categories mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCategoryMappingId the primary key of the s p categories mapping
	 * @return the s p categories mapping, or <code>null</code> if a s p categories mapping with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCategoriesMapping fetchByPrimaryKey(long spCategoryMappingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCategoryMappingId);
	}

	/**
	 * Returns all the s p categories mappings.
	 *
	 * @return the s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p categories mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @return the range of s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p categories mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.roles.model.impl.SPCategoriesMappingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p categories mappings
	 * @param end the upper bound of the range of s p categories mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p categories mappings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCategoriesMapping> findAll(int start, int end,
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

		List<SPCategoriesMapping> list = (List<SPCategoriesMapping>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCATEGORIESMAPPING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCATEGORIESMAPPING;

				if (pagination) {
					sql = sql.concat(SPCategoriesMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCategoriesMapping>(list);
				}
				else {
					list = (List<SPCategoriesMapping>)QueryUtil.list(q,
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
	 * Removes all the s p categories mappings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCategoriesMapping spCategoriesMapping : findAll()) {
			remove(spCategoriesMapping);
		}
	}

	/**
	 * Returns the number of s p categories mappings.
	 *
	 * @return the number of s p categories mappings
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

				Query q = session.createQuery(_SQL_COUNT_SPCATEGORIESMAPPING);

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
	 * Initializes the s p categories mapping persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.roles.model.SPCategoriesMapping")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCategoriesMapping>> listenersList = new ArrayList<ModelListener<SPCategoriesMapping>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCategoriesMapping>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCategoriesMappingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCATEGORIESMAPPING = "SELECT spCategoriesMapping FROM SPCategoriesMapping spCategoriesMapping";
	private static final String _SQL_SELECT_SPCATEGORIESMAPPING_WHERE = "SELECT spCategoriesMapping FROM SPCategoriesMapping spCategoriesMapping WHERE ";
	private static final String _SQL_COUNT_SPCATEGORIESMAPPING = "SELECT COUNT(spCategoriesMapping) FROM SPCategoriesMapping spCategoriesMapping";
	private static final String _SQL_COUNT_SPCATEGORIESMAPPING_WHERE = "SELECT COUNT(spCategoriesMapping) FROM SPCategoriesMapping spCategoriesMapping WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCategoriesMapping.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCategoriesMapping exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPCategoriesMapping exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCategoriesMappingPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPCategoriesMapping _nullSPCategoriesMapping = new SPCategoriesMappingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCategoriesMapping> toCacheModel() {
				return _nullSPCategoriesMappingCacheModel;
			}
		};

	private static CacheModel<SPCategoriesMapping> _nullSPCategoriesMappingCacheModel =
		new CacheModel<SPCategoriesMapping>() {
			@Override
			public SPCategoriesMapping toEntityModel() {
				return _nullSPCategoriesMapping;
			}
		};
}