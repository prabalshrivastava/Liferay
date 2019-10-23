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

import com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupImpl;
import com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p site setup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSiteSetupPersistence
 * @see SPSiteSetupUtil
 * @generated
 */
public class SPSiteSetupPersistenceImpl extends BasePersistenceImpl<SPSiteSetup>
	implements SPSiteSetupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSiteSetupUtil} to access the s p site setup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSiteSetupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPSiteSetupModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p site setups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid(String uuid, int start, int end,
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

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if (!Validator.equals(uuid, spSiteSetup.getUuid())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByUuid_First(uuid, orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByUuid_Last(uuid, orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where uuid = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByUuid_PrevAndNext(long spSiteSetupId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spSiteSetup, uuid,
					orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getByUuid_PrevAndNext(session, spSiteSetup, uuid,
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

	protected SPSiteSetup getByUuid_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPSiteSetup spSiteSetup : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p site setups
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

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spSiteSetup.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spSiteSetup.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spSiteSetup.uuid IS NULL OR spSiteSetup.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSiteSetupModelImpl.UUID_COLUMN_BITMASK |
			SPSiteSetupModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p site setup where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByUUID_G(String uuid, long groupId)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByUUID_G(uuid, groupId);

		if (spSiteSetup == null) {
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

			throw new NoSuchSPSiteSetupException(msg.toString());
		}

		return spSiteSetup;
	}

	/**
	 * Returns the s p site setup where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p site setup where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPSiteSetup) {
			SPSiteSetup spSiteSetup = (SPSiteSetup)result;

			if (!Validator.equals(uuid, spSiteSetup.getUuid()) ||
					(groupId != spSiteSetup.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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

				List<SPSiteSetup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPSiteSetup spSiteSetup = list.get(0);

					result = spSiteSetup;

					cacheResult(spSiteSetup);

					if ((spSiteSetup.getUuid() == null) ||
							!spSiteSetup.getUuid().equals(uuid) ||
							(spSiteSetup.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spSiteSetup);
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
			return (SPSiteSetup)result;
		}
	}

	/**
	 * Removes the s p site setup where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p site setup that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByUUID_G(uuid, groupId);

		return remove(spSiteSetup);
	}

	/**
	 * Returns the number of s p site setups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p site setups
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

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spSiteSetup.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spSiteSetup.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spSiteSetup.uuid IS NULL OR spSiteSetup.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spSiteSetup.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSiteSetupModelImpl.UUID_COLUMN_BITMASK |
			SPSiteSetupModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p site setups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByUuid_C(String uuid, long companyId,
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

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if (!Validator.equals(uuid, spSiteSetup.getUuid()) ||
						(companyId != spSiteSetup.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByUuid_C_PrevAndNext(long spSiteSetupId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spSiteSetup, uuid,
					companyId, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getByUuid_C_PrevAndNext(session, spSiteSetup, uuid,
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

	protected SPSiteSetup getByUuid_C_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p site setups
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

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spSiteSetup.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spSiteSetup.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spSiteSetup.uuid IS NULL OR spSiteSetup.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spSiteSetup.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductId",
			new String[] { Long.class.getName() },
			SPSiteSetupModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p site setups where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductId(long productId)
		throws SystemException {
		return findByProductId(productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p site setups where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductId(long productId, int start, int end)
		throws SystemException {
		return findByProductId(productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productId the product ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductId(long productId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTID;
			finderArgs = new Object[] { productId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTID;
			finderArgs = new Object[] { productId, start, end, orderByComparator };
		}

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if ((productId != spSiteSetup.getProductId())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByProductId_First(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByProductId_First(productId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductId_First(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findByProductId(productId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByProductId_Last(long productId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByProductId_Last(productId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductId_Last(long productId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProductId(productId);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByProductId(productId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where productId = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByProductId_PrevAndNext(long spSiteSetupId,
		long productId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByProductId_PrevAndNext(session, spSiteSetup,
					productId, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getByProductId_PrevAndNext(session, spSiteSetup,
					productId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getByProductId_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, long productId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

		query.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where productId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProductId(long productId) throws SystemException {
		for (SPSiteSetup spSiteSetup : findByProductId(productId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where productId = &#63;.
	 *
	 * @param productId the product ID
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductId(long productId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTID;

		Object[] finderArgs = new Object[] { productId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTID_PRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

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

	private static final String _FINDER_COLUMN_PRODUCTID_PRODUCTID_2 = "spSiteSetup.productId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTNAME =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductName",
			new String[] { String.class.getName() },
			SPSiteSetupModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTNAME = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p site setups where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductName(String productName)
		throws SystemException {
		return findByProductName(productName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productName the product name
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductName(String productName, int start,
		int end) throws SystemException {
		return findByProductName(productName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where productName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param productName the product name
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByProductName(String productName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME;
			finderArgs = new Object[] { productName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTNAME;
			finderArgs = new Object[] { productName, start, end, orderByComparator };
		}

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if (!Validator.equals(productName, spSiteSetup.getProductName())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductName) {
					qPos.add(productName);
				}

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByProductName_First(String productName,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByProductName_First(productName,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductName_First(String productName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findByProductName(productName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByProductName_Last(String productName,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByProductName_Last(productName,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("productName=");
		msg.append(productName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where productName = &#63;.
	 *
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductName_Last(String productName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProductName(productName);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByProductName(productName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where productName = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param productName the product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByProductName_PrevAndNext(long spSiteSetupId,
		String productName, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByProductName_PrevAndNext(session, spSiteSetup,
					productName, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getByProductName_PrevAndNext(session, spSiteSetup,
					productName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getByProductName_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, String productName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

		boolean bindProductName = false;

		if (productName == null) {
			query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
		}
		else if (productName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
		}
		else {
			bindProductName = true;

			query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindProductName) {
			qPos.add(productName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where productName = &#63; from the database.
	 *
	 * @param productName the product name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProductName(String productName)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findByProductName(productName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where productName = &#63;.
	 *
	 * @param productName the product name
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductName(String productName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTNAME;

		Object[] finderArgs = new Object[] { productName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductName) {
					qPos.add(productName);
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

	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_1 = "spSiteSetup.productName IS NULL";
	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_2 = "spSiteSetup.productName = ?";
	private static final String _FINDER_COLUMN_PRODUCTNAME_PRODUCTNAME_3 = "(spSiteSetup.productName IS NULL OR spSiteSetup.productName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBPRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubProductId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubProductId",
			new String[] { Long.class.getName() },
			SPSiteSetupModelImpl.SUBPRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBPRODUCTID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubProductId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p site setups where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductId(long subProductId)
		throws SystemException {
		return findBySubProductId(subProductId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where subProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subProductId the sub product ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductId(long subProductId, int start,
		int end) throws SystemException {
		return findBySubProductId(subProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where subProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subProductId the sub product ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductId(long subProductId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTID;
			finderArgs = new Object[] { subProductId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBPRODUCTID;
			finderArgs = new Object[] {
					subProductId,
					
					start, end, orderByComparator
				};
		}

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if ((subProductId != spSiteSetup.getSubProductId())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_SUBPRODUCTID_SUBPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subProductId);

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findBySubProductId_First(long subProductId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchBySubProductId_First(subProductId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subProductId=");
		msg.append(subProductId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchBySubProductId_First(long subProductId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findBySubProductId(subProductId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findBySubProductId_Last(long subProductId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchBySubProductId_Last(subProductId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subProductId=");
		msg.append(subProductId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchBySubProductId_Last(long subProductId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySubProductId(subProductId);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findBySubProductId(subProductId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where subProductId = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param subProductId the sub product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findBySubProductId_PrevAndNext(long spSiteSetupId,
		long subProductId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getBySubProductId_PrevAndNext(session, spSiteSetup,
					subProductId, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getBySubProductId_PrevAndNext(session, spSiteSetup,
					subProductId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getBySubProductId_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, long subProductId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

		query.append(_FINDER_COLUMN_SUBPRODUCTID_SUBPRODUCTID_2);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(subProductId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where subProductId = &#63; from the database.
	 *
	 * @param subProductId the sub product ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySubProductId(long subProductId)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findBySubProductId(subProductId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where subProductId = &#63;.
	 *
	 * @param subProductId the sub product ID
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySubProductId(long subProductId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBPRODUCTID;

		Object[] finderArgs = new Object[] { subProductId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_SUBPRODUCTID_SUBPRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(subProductId);

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

	private static final String _FINDER_COLUMN_SUBPRODUCTID_SUBPRODUCTID_2 = "spSiteSetup.subProductId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBPRODUCTNAME =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubProductName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTNAME =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubProductName",
			new String[] { String.class.getName() },
			SPSiteSetupModelImpl.SUBPRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBPRODUCTNAME = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubProductName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p site setups where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductName(String subProductName)
		throws SystemException {
		return findBySubProductName(subProductName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where subProductName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subProductName the sub product name
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductName(String subProductName,
		int start, int end) throws SystemException {
		return findBySubProductName(subProductName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where subProductName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param subProductName the sub product name
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findBySubProductName(String subProductName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTNAME;
			finderArgs = new Object[] { subProductName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBPRODUCTNAME;
			finderArgs = new Object[] {
					subProductName,
					
					start, end, orderByComparator
				};
		}

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if (!Validator.equals(subProductName,
							spSiteSetup.getSubProductName())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			boolean bindSubProductName = false;

			if (subProductName == null) {
				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_1);
			}
			else if (subProductName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_3);
			}
			else {
				bindSubProductName = true;

				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSubProductName) {
					qPos.add(subProductName);
				}

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findBySubProductName_First(String subProductName,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchBySubProductName_First(subProductName,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subProductName=");
		msg.append(subProductName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchBySubProductName_First(String subProductName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findBySubProductName(subProductName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findBySubProductName_Last(String subProductName,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchBySubProductName_Last(subProductName,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("subProductName=");
		msg.append(subProductName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchBySubProductName_Last(String subProductName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySubProductName(subProductName);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findBySubProductName(subProductName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where subProductName = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param subProductName the sub product name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findBySubProductName_PrevAndNext(long spSiteSetupId,
		String subProductName, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getBySubProductName_PrevAndNext(session, spSiteSetup,
					subProductName, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getBySubProductName_PrevAndNext(session, spSiteSetup,
					subProductName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getBySubProductName_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, String subProductName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

		boolean bindSubProductName = false;

		if (subProductName == null) {
			query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_1);
		}
		else if (subProductName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_3);
		}
		else {
			bindSubProductName = true;

			query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_2);
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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSubProductName) {
			qPos.add(subProductName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where subProductName = &#63; from the database.
	 *
	 * @param subProductName the sub product name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySubProductName(String subProductName)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findBySubProductName(subProductName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where subProductName = &#63;.
	 *
	 * @param subProductName the sub product name
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySubProductName(String subProductName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUBPRODUCTNAME;

		Object[] finderArgs = new Object[] { subProductName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			boolean bindSubProductName = false;

			if (subProductName == null) {
				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_1);
			}
			else if (subProductName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_3);
			}
			else {
				bindSubProductName = true;

				query.append(_FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSubProductName) {
					qPos.add(subProductName);
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

	private static final String _FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_1 = "spSiteSetup.subProductName IS NULL";
	private static final String _FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_2 = "spSiteSetup.subProductName = ?";
	private static final String _FINDER_COLUMN_SUBPRODUCTNAME_SUBPRODUCTNAME_3 = "(spSiteSetup.subProductName IS NULL OR spSiteSetup.subProductName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByProductIdAndSubProductId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSiteSetupModelImpl.PRODUCTID_COLUMN_BITMASK |
			SPSiteSetupModelImpl.SUBPRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductIdAndSubProductId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p site setup where productId = &#63; and subProductId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	 *
	 * @param productId the product ID
	 * @param subProductId the sub product ID
	 * @return the matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByProductIdAndSubProductId(long productId,
		long subProductId) throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByProductIdAndSubProductId(productId,
				subProductId);

		if (spSiteSetup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("productId=");
			msg.append(productId);

			msg.append(", subProductId=");
			msg.append(subProductId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSiteSetupException(msg.toString());
		}

		return spSiteSetup;
	}

	/**
	 * Returns the s p site setup where productId = &#63; and subProductId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productId the product ID
	 * @param subProductId the sub product ID
	 * @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductIdAndSubProductId(long productId,
		long subProductId) throws SystemException {
		return fetchByProductIdAndSubProductId(productId, subProductId, true);
	}

	/**
	 * Returns the s p site setup where productId = &#63; and subProductId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productId the product ID
	 * @param subProductId the sub product ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByProductIdAndSubProductId(long productId,
		long subProductId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { productId, subProductId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
					finderArgs, this);
		}

		if (result instanceof SPSiteSetup) {
			SPSiteSetup spSiteSetup = (SPSiteSetup)result;

			if ((productId != spSiteSetup.getProductId()) ||
					(subProductId != spSiteSetup.getSubProductId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_PRODUCTID_2);

			query.append(_FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_SUBPRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				qPos.add(subProductId);

				List<SPSiteSetup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
						finderArgs, list);
				}
				else {
					SPSiteSetup spSiteSetup = list.get(0);

					result = spSiteSetup;

					cacheResult(spSiteSetup);

					if ((spSiteSetup.getProductId() != productId) ||
							(spSiteSetup.getSubProductId() != subProductId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
							finderArgs, spSiteSetup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
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
			return (SPSiteSetup)result;
		}
	}

	/**
	 * Removes the s p site setup where productId = &#63; and subProductId = &#63; from the database.
	 *
	 * @param productId the product ID
	 * @param subProductId the sub product ID
	 * @return the s p site setup that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup removeByProductIdAndSubProductId(long productId,
		long subProductId) throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByProductIdAndSubProductId(productId,
				subProductId);

		return remove(spSiteSetup);
	}

	/**
	 * Returns the number of s p site setups where productId = &#63; and subProductId = &#63;.
	 *
	 * @param productId the product ID
	 * @param subProductId the sub product ID
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductIdAndSubProductId(long productId, long subProductId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID;

		Object[] finderArgs = new Object[] { productId, subProductId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_PRODUCTID_2);

			query.append(_FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_SUBPRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(productId);

				qPos.add(subProductId);

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

	private static final String _FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_PRODUCTID_2 =
		"spSiteSetup.productId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTIDANDSUBPRODUCTID_SUBPRODUCTID_2 =
		"spSiteSetup.subProductId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIRTUALHOSTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVirtualHostId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVirtualHostId",
			new String[] { Long.class.getName() },
			SPSiteSetupModelImpl.VIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIRTUALHOSTID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVirtualHostId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p site setups where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByVirtualHostId(long virtualHostId)
		throws SystemException {
		return findByVirtualHostId(virtualHostId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByVirtualHostId(long virtualHostId, int start,
		int end) throws SystemException {
		return findByVirtualHostId(virtualHostId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where virtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualHostId the virtual host ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByVirtualHostId(long virtualHostId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if ((virtualHostId != spSiteSetup.getVirtualHostId())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(virtualHostId);

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByVirtualHostId_First(long virtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByVirtualHostId_First(virtualHostId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByVirtualHostId_First(long virtualHostId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSiteSetup> list = findByVirtualHostId(virtualHostId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByVirtualHostId_Last(long virtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByVirtualHostId_Last(virtualHostId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualHostId=");
		msg.append(virtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByVirtualHostId_Last(long virtualHostId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVirtualHostId(virtualHostId);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByVirtualHostId(virtualHostId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where virtualHostId = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param virtualHostId the virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByVirtualHostId_PrevAndNext(long spSiteSetupId,
		long virtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByVirtualHostId_PrevAndNext(session, spSiteSetup,
					virtualHostId, orderByComparator, true);

			array[1] = spSiteSetup;

			array[2] = getByVirtualHostId_PrevAndNext(session, spSiteSetup,
					virtualHostId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getByVirtualHostId_PrevAndNext(Session session,
		SPSiteSetup spSiteSetup, long virtualHostId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(virtualHostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where virtualHostId = &#63; from the database.
	 *
	 * @param virtualHostId the virtual host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVirtualHostId(long virtualHostId)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findByVirtualHostId(virtualHostId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where virtualHostId = &#63;.
	 *
	 * @param virtualHostId the virtual host ID
	 * @return the number of matching s p site setups
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

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

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

	private static final String _FINDER_COLUMN_VIRTUALHOSTID_VIRTUALHOSTID_2 = "spSiteSetup.virtualHostId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBackOfficeVirtualHostId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID =
		new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, SPSiteSetupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBackOfficeVirtualHostId",
			new String[] { Long.class.getName() },
			SPSiteSetupModelImpl.BACKOFFICEVIRTUALHOSTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BACKOFFICEVIRTUALHOSTID = new FinderPath(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBackOfficeVirtualHostId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p site setups where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @return the matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId) throws SystemException {
		return findByBackOfficeVirtualHostId(backOfficeVirtualHostId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups where backOfficeVirtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId, int start, int end)
		throws SystemException {
		return findByBackOfficeVirtualHostId(backOfficeVirtualHostId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups where backOfficeVirtualHostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findByBackOfficeVirtualHostId(
		long backOfficeVirtualHostId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID;
			finderArgs = new Object[] { backOfficeVirtualHostId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID;
			finderArgs = new Object[] {
					backOfficeVirtualHostId,
					
					start, end, orderByComparator
				};
		}

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSiteSetup spSiteSetup : list) {
				if ((backOfficeVirtualHostId != spSiteSetup.getBackOfficeVirtualHostId())) {
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

			query.append(_SQL_SELECT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_BACKOFFICEVIRTUALHOSTID_BACKOFFICEVIRTUALHOSTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(backOfficeVirtualHostId);

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByBackOfficeVirtualHostId_First(
		long backOfficeVirtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByBackOfficeVirtualHostId_First(backOfficeVirtualHostId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("backOfficeVirtualHostId=");
		msg.append(backOfficeVirtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the first s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByBackOfficeVirtualHostId_First(
		long backOfficeVirtualHostId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPSiteSetup> list = findByBackOfficeVirtualHostId(backOfficeVirtualHostId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByBackOfficeVirtualHostId_Last(
		long backOfficeVirtualHostId, OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByBackOfficeVirtualHostId_Last(backOfficeVirtualHostId,
				orderByComparator);

		if (spSiteSetup != null) {
			return spSiteSetup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("backOfficeVirtualHostId=");
		msg.append(backOfficeVirtualHostId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSiteSetupException(msg.toString());
	}

	/**
	 * Returns the last s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p site setup, or <code>null</code> if a matching s p site setup could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByBackOfficeVirtualHostId_Last(
		long backOfficeVirtualHostId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBackOfficeVirtualHostId(backOfficeVirtualHostId);

		if (count == 0) {
			return null;
		}

		List<SPSiteSetup> list = findByBackOfficeVirtualHostId(backOfficeVirtualHostId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p site setups before and after the current s p site setup in the ordered set where backOfficeVirtualHostId = &#63;.
	 *
	 * @param spSiteSetupId the primary key of the current s p site setup
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup[] findByBackOfficeVirtualHostId_PrevAndNext(
		long spSiteSetupId, long backOfficeVirtualHostId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = findByPrimaryKey(spSiteSetupId);

		Session session = null;

		try {
			session = openSession();

			SPSiteSetup[] array = new SPSiteSetupImpl[3];

			array[0] = getByBackOfficeVirtualHostId_PrevAndNext(session,
					spSiteSetup, backOfficeVirtualHostId, orderByComparator,
					true);

			array[1] = spSiteSetup;

			array[2] = getByBackOfficeVirtualHostId_PrevAndNext(session,
					spSiteSetup, backOfficeVirtualHostId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPSiteSetup getByBackOfficeVirtualHostId_PrevAndNext(
		Session session, SPSiteSetup spSiteSetup, long backOfficeVirtualHostId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSITESETUP_WHERE);

		query.append(_FINDER_COLUMN_BACKOFFICEVIRTUALHOSTID_BACKOFFICEVIRTUALHOSTID_2);

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
			query.append(SPSiteSetupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(backOfficeVirtualHostId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spSiteSetup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSiteSetup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p site setups where backOfficeVirtualHostId = &#63; from the database.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBackOfficeVirtualHostId(long backOfficeVirtualHostId)
		throws SystemException {
		for (SPSiteSetup spSiteSetup : findByBackOfficeVirtualHostId(
				backOfficeVirtualHostId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups where backOfficeVirtualHostId = &#63;.
	 *
	 * @param backOfficeVirtualHostId the back office virtual host ID
	 * @return the number of matching s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBackOfficeVirtualHostId(long backOfficeVirtualHostId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BACKOFFICEVIRTUALHOSTID;

		Object[] finderArgs = new Object[] { backOfficeVirtualHostId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPSITESETUP_WHERE);

			query.append(_FINDER_COLUMN_BACKOFFICEVIRTUALHOSTID_BACKOFFICEVIRTUALHOSTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(backOfficeVirtualHostId);

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

	private static final String _FINDER_COLUMN_BACKOFFICEVIRTUALHOSTID_BACKOFFICEVIRTUALHOSTID_2 =
		"spSiteSetup.backOfficeVirtualHostId = ?";

	public SPSiteSetupPersistenceImpl() {
		setModelClass(SPSiteSetup.class);
	}

	/**
	 * Caches the s p site setup in the entity cache if it is enabled.
	 *
	 * @param spSiteSetup the s p site setup
	 */
	@Override
	public void cacheResult(SPSiteSetup spSiteSetup) {
		EntityCacheUtil.putResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupImpl.class, spSiteSetup.getPrimaryKey(), spSiteSetup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spSiteSetup.getUuid(), spSiteSetup.getGroupId() },
			spSiteSetup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
			new Object[] {
				spSiteSetup.getProductId(), spSiteSetup.getSubProductId()
			}, spSiteSetup);

		spSiteSetup.resetOriginalValues();
	}

	/**
	 * Caches the s p site setups in the entity cache if it is enabled.
	 *
	 * @param spSiteSetups the s p site setups
	 */
	@Override
	public void cacheResult(List<SPSiteSetup> spSiteSetups) {
		for (SPSiteSetup spSiteSetup : spSiteSetups) {
			if (EntityCacheUtil.getResult(
						SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
						SPSiteSetupImpl.class, spSiteSetup.getPrimaryKey()) == null) {
				cacheResult(spSiteSetup);
			}
			else {
				spSiteSetup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p site setups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSiteSetupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSiteSetupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p site setup.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSiteSetup spSiteSetup) {
		EntityCacheUtil.removeResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupImpl.class, spSiteSetup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSiteSetup);
	}

	@Override
	public void clearCache(List<SPSiteSetup> spSiteSetups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSiteSetup spSiteSetup : spSiteSetups) {
			EntityCacheUtil.removeResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
				SPSiteSetupImpl.class, spSiteSetup.getPrimaryKey());

			clearUniqueFindersCache(spSiteSetup);
		}
	}

	protected void cacheUniqueFindersCache(SPSiteSetup spSiteSetup) {
		if (spSiteSetup.isNew()) {
			Object[] args = new Object[] {
					spSiteSetup.getUuid(), spSiteSetup.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spSiteSetup);

			args = new Object[] {
					spSiteSetup.getProductId(), spSiteSetup.getSubProductId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
				args, spSiteSetup);
		}
		else {
			SPSiteSetupModelImpl spSiteSetupModelImpl = (SPSiteSetupModelImpl)spSiteSetup;

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetup.getUuid(), spSiteSetup.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spSiteSetup);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetup.getProductId(),
						spSiteSetup.getSubProductId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
					args, spSiteSetup);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSiteSetup spSiteSetup) {
		SPSiteSetupModelImpl spSiteSetupModelImpl = (SPSiteSetupModelImpl)spSiteSetup;

		Object[] args = new Object[] {
				spSiteSetup.getUuid(), spSiteSetup.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spSiteSetupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSiteSetupModelImpl.getOriginalUuid(),
					spSiteSetupModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spSiteSetup.getProductId(), spSiteSetup.getSubProductId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
			args);

		if ((spSiteSetupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSiteSetupModelImpl.getOriginalProductId(),
					spSiteSetupModelImpl.getOriginalSubProductId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDSUBPRODUCTID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDSUBPRODUCTID,
				args);
		}
	}

	/**
	 * Creates a new s p site setup with the primary key. Does not add the s p site setup to the database.
	 *
	 * @param spSiteSetupId the primary key for the new s p site setup
	 * @return the new s p site setup
	 */
	@Override
	public SPSiteSetup create(long spSiteSetupId) {
		SPSiteSetup spSiteSetup = new SPSiteSetupImpl();

		spSiteSetup.setNew(true);
		spSiteSetup.setPrimaryKey(spSiteSetupId);

		String uuid = PortalUUIDUtil.generate();

		spSiteSetup.setUuid(uuid);

		return spSiteSetup;
	}

	/**
	 * Removes the s p site setup with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSiteSetupId the primary key of the s p site setup
	 * @return the s p site setup that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup remove(long spSiteSetupId)
		throws NoSuchSPSiteSetupException, SystemException {
		return remove((Serializable)spSiteSetupId);
	}

	/**
	 * Removes the s p site setup with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p site setup
	 * @return the s p site setup that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup remove(Serializable primaryKey)
		throws NoSuchSPSiteSetupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSiteSetup spSiteSetup = (SPSiteSetup)session.get(SPSiteSetupImpl.class,
					primaryKey);

			if (spSiteSetup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSiteSetupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSiteSetup);
		}
		catch (NoSuchSPSiteSetupException nsee) {
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
	protected SPSiteSetup removeImpl(SPSiteSetup spSiteSetup)
		throws SystemException {
		spSiteSetup = toUnwrappedModel(spSiteSetup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSiteSetup)) {
				spSiteSetup = (SPSiteSetup)session.get(SPSiteSetupImpl.class,
						spSiteSetup.getPrimaryKeyObj());
			}

			if (spSiteSetup != null) {
				session.delete(spSiteSetup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSiteSetup != null) {
			clearCache(spSiteSetup);
		}

		return spSiteSetup;
	}

	@Override
	public SPSiteSetup updateImpl(
		com.sambaash.platform.srv.spservices.model.SPSiteSetup spSiteSetup)
		throws SystemException {
		spSiteSetup = toUnwrappedModel(spSiteSetup);

		boolean isNew = spSiteSetup.isNew();

		SPSiteSetupModelImpl spSiteSetupModelImpl = (SPSiteSetupModelImpl)spSiteSetup;

		if (Validator.isNull(spSiteSetup.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spSiteSetup.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spSiteSetup.isNew()) {
				session.save(spSiteSetup);

				spSiteSetup.setNew(false);
			}
			else {
				session.merge(spSiteSetup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSiteSetupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spSiteSetupModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalUuid(),
						spSiteSetupModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spSiteSetupModelImpl.getUuid(),
						spSiteSetupModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalProductId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTID,
					args);

				args = new Object[] { spSiteSetupModelImpl.getProductId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTID,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalProductName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME,
					args);

				args = new Object[] { spSiteSetupModelImpl.getProductName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTNAME,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalSubProductId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBPRODUCTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTID,
					args);

				args = new Object[] { spSiteSetupModelImpl.getSubProductId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBPRODUCTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTID,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalSubProductName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBPRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTNAME,
					args);

				args = new Object[] { spSiteSetupModelImpl.getSubProductName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBPRODUCTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBPRODUCTNAME,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID,
					args);

				args = new Object[] { spSiteSetupModelImpl.getVirtualHostId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIRTUALHOSTID,
					args);
			}

			if ((spSiteSetupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSiteSetupModelImpl.getOriginalBackOfficeVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKOFFICEVIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID,
					args);

				args = new Object[] {
						spSiteSetupModelImpl.getBackOfficeVirtualHostId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BACKOFFICEVIRTUALHOSTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BACKOFFICEVIRTUALHOSTID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
			SPSiteSetupImpl.class, spSiteSetup.getPrimaryKey(), spSiteSetup);

		clearUniqueFindersCache(spSiteSetup);
		cacheUniqueFindersCache(spSiteSetup);

		return spSiteSetup;
	}

	protected SPSiteSetup toUnwrappedModel(SPSiteSetup spSiteSetup) {
		if (spSiteSetup instanceof SPSiteSetupImpl) {
			return spSiteSetup;
		}

		SPSiteSetupImpl spSiteSetupImpl = new SPSiteSetupImpl();

		spSiteSetupImpl.setNew(spSiteSetup.isNew());
		spSiteSetupImpl.setPrimaryKey(spSiteSetup.getPrimaryKey());

		spSiteSetupImpl.setUuid(spSiteSetup.getUuid());
		spSiteSetupImpl.setSpSiteSetupId(spSiteSetup.getSpSiteSetupId());
		spSiteSetupImpl.setGroupId(spSiteSetup.getGroupId());
		spSiteSetupImpl.setProductId(spSiteSetup.getProductId());
		spSiteSetupImpl.setProductName(spSiteSetup.getProductName());
		spSiteSetupImpl.setSubProductId(spSiteSetup.getSubProductId());
		spSiteSetupImpl.setSubProductName(spSiteSetup.getSubProductName());
		spSiteSetupImpl.setVirtualHostId(spSiteSetup.getVirtualHostId());
		spSiteSetupImpl.setBackOfficeVirtualHostId(spSiteSetup.getBackOfficeVirtualHostId());
		spSiteSetupImpl.setCompanyId(spSiteSetup.getCompanyId());
		spSiteSetupImpl.setCreatedBy(spSiteSetup.getCreatedBy());
		spSiteSetupImpl.setModifiedBy(spSiteSetup.getModifiedBy());
		spSiteSetupImpl.setCreatedDate(spSiteSetup.getCreatedDate());
		spSiteSetupImpl.setModifiedDate(spSiteSetup.getModifiedDate());

		return spSiteSetupImpl;
	}

	/**
	 * Returns the s p site setup with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p site setup
	 * @return the s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSiteSetupException, SystemException {
		SPSiteSetup spSiteSetup = fetchByPrimaryKey(primaryKey);

		if (spSiteSetup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSiteSetupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSiteSetup;
	}

	/**
	 * Returns the s p site setup with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException} if it could not be found.
	 *
	 * @param spSiteSetupId the primary key of the s p site setup
	 * @return the s p site setup
	 * @throws com.sambaash.platform.srv.spservices.NoSuchSPSiteSetupException if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup findByPrimaryKey(long spSiteSetupId)
		throws NoSuchSPSiteSetupException, SystemException {
		return findByPrimaryKey((Serializable)spSiteSetupId);
	}

	/**
	 * Returns the s p site setup with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p site setup
	 * @return the s p site setup, or <code>null</code> if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSiteSetup spSiteSetup = (SPSiteSetup)EntityCacheUtil.getResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
				SPSiteSetupImpl.class, primaryKey);

		if (spSiteSetup == _nullSPSiteSetup) {
			return null;
		}

		if (spSiteSetup == null) {
			Session session = null;

			try {
				session = openSession();

				spSiteSetup = (SPSiteSetup)session.get(SPSiteSetupImpl.class,
						primaryKey);

				if (spSiteSetup != null) {
					cacheResult(spSiteSetup);
				}
				else {
					EntityCacheUtil.putResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
						SPSiteSetupImpl.class, primaryKey, _nullSPSiteSetup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSiteSetupModelImpl.ENTITY_CACHE_ENABLED,
					SPSiteSetupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSiteSetup;
	}

	/**
	 * Returns the s p site setup with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSiteSetupId the primary key of the s p site setup
	 * @return the s p site setup, or <code>null</code> if a s p site setup with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSiteSetup fetchByPrimaryKey(long spSiteSetupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSiteSetupId);
	}

	/**
	 * Returns all the s p site setups.
	 *
	 * @return the s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p site setups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @return the range of s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p site setups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPSiteSetupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p site setups
	 * @param end the upper bound of the range of s p site setups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p site setups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSiteSetup> findAll(int start, int end,
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

		List<SPSiteSetup> list = (List<SPSiteSetup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSITESETUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSITESETUP;

				if (pagination) {
					sql = sql.concat(SPSiteSetupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSiteSetup>(list);
				}
				else {
					list = (List<SPSiteSetup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p site setups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSiteSetup spSiteSetup : findAll()) {
			remove(spSiteSetup);
		}
	}

	/**
	 * Returns the number of s p site setups.
	 *
	 * @return the number of s p site setups
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

				Query q = session.createQuery(_SQL_COUNT_SPSITESETUP);

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
	 * Initializes the s p site setup persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.SPSiteSetup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSiteSetup>> listenersList = new ArrayList<ModelListener<SPSiteSetup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSiteSetup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSiteSetupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSITESETUP = "SELECT spSiteSetup FROM SPSiteSetup spSiteSetup";
	private static final String _SQL_SELECT_SPSITESETUP_WHERE = "SELECT spSiteSetup FROM SPSiteSetup spSiteSetup WHERE ";
	private static final String _SQL_COUNT_SPSITESETUP = "SELECT COUNT(spSiteSetup) FROM SPSiteSetup spSiteSetup";
	private static final String _SQL_COUNT_SPSITESETUP_WHERE = "SELECT COUNT(spSiteSetup) FROM SPSiteSetup spSiteSetup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSiteSetup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSiteSetup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSiteSetup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSiteSetupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPSiteSetup _nullSPSiteSetup = new SPSiteSetupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSiteSetup> toCacheModel() {
				return _nullSPSiteSetupCacheModel;
			}
		};

	private static CacheModel<SPSiteSetup> _nullSPSiteSetupCacheModel = new CacheModel<SPSiteSetup>() {
			@Override
			public SPSiteSetup toEntityModel() {
				return _nullSPSiteSetup;
			}
		};
}