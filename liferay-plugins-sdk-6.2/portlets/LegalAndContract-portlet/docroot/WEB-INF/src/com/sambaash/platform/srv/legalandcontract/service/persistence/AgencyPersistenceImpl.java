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

package com.sambaash.platform.srv.legalandcontract.service.persistence;

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

import com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.model.impl.AgencyImpl;
import com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the agency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see AgencyPersistence
 * @see AgencyUtil
 * @generated
 */
public class AgencyPersistenceImpl extends BasePersistenceImpl<Agency>
	implements AgencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AgencyUtil} to access the agency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AgencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			AgencyModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the agencies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agencies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agencies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid(String uuid, int start, int end,
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

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Agency agency : list) {
				if (!Validator.equals(uuid, agency.getUuid())) {
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

			query.append(_SQL_SELECT_AGENCY_WHERE);

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
				query.append(AgencyModelImpl.ORDER_BY_JPQL);
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
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first agency in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByUuid_First(uuid, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the first agency in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Agency> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agency in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByUuid_Last(uuid, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the last agency in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Agency> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agencies before and after the current agency in the ordered set where uuid = &#63;.
	 *
	 * @param spAgencyId the primary key of the current agency
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency[] findByUuid_PrevAndNext(long spAgencyId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByPrimaryKey(spAgencyId);

		Session session = null;

		try {
			session = openSession();

			Agency[] array = new AgencyImpl[3];

			array[0] = getByUuid_PrevAndNext(session, agency, uuid,
					orderByComparator, true);

			array[1] = agency;

			array[2] = getByUuid_PrevAndNext(session, agency, uuid,
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

	protected Agency getByUuid_PrevAndNext(Session session, Agency agency,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AGENCY_WHERE);

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
			query.append(AgencyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(agency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Agency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agencies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Agency agency : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching agencies
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

			query.append(_SQL_COUNT_AGENCY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "agency.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "agency.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(agency.uuid IS NULL OR agency.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			AgencyModelImpl.UUID_COLUMN_BITMASK |
			AgencyModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the agency where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByUUID_G(String uuid, long groupId)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByUUID_G(uuid, groupId);

		if (agency == null) {
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

			throw new NoSuchAgencyException(msg.toString());
		}

		return agency;
	}

	/**
	 * Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the agency where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Agency) {
			Agency agency = (Agency)result;

			if (!Validator.equals(uuid, agency.getUuid()) ||
					(groupId != agency.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_AGENCY_WHERE);

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

				List<Agency> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Agency agency = list.get(0);

					result = agency;

					cacheResult(agency);

					if ((agency.getUuid() == null) ||
							!agency.getUuid().equals(uuid) ||
							(agency.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, agency);
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
			return (Agency)result;
		}
	}

	/**
	 * Removes the agency where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the agency that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency removeByUUID_G(String uuid, long groupId)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByUUID_G(uuid, groupId);

		return remove(agency);
	}

	/**
	 * Returns the number of agencies where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching agencies
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

			query.append(_SQL_COUNT_AGENCY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "agency.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "agency.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(agency.uuid IS NULL OR agency.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "agency.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			AgencyModelImpl.UUID_COLUMN_BITMASK |
			AgencyModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the agencies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agencies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agencies where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findByUuid_C(String uuid, long companyId, int start,
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

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Agency agency : list) {
				if (!Validator.equals(uuid, agency.getUuid()) ||
						(companyId != agency.getCompanyId())) {
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

			query.append(_SQL_SELECT_AGENCY_WHERE);

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
				query.append(AgencyModelImpl.ORDER_BY_JPQL);
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
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first agency in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the first agency in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Agency> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agency in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (agency != null) {
			return agency;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAgencyException(msg.toString());
	}

	/**
	 * Returns the last agency in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Agency> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agencies before and after the current agency in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spAgencyId the primary key of the current agency
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency[] findByUuid_C_PrevAndNext(long spAgencyId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByPrimaryKey(spAgencyId);

		Session session = null;

		try {
			session = openSession();

			Agency[] array = new AgencyImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, agency, uuid,
					companyId, orderByComparator, true);

			array[1] = agency;

			array[2] = getByUuid_C_PrevAndNext(session, agency, uuid,
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

	protected Agency getByUuid_C_PrevAndNext(Session session, Agency agency,
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

		query.append(_SQL_SELECT_AGENCY_WHERE);

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
			query.append(AgencyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(agency);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Agency> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agencies where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Agency agency : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching agencies
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

			query.append(_SQL_COUNT_AGENCY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "agency.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "agency.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(agency.uuid IS NULL OR agency.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "agency.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNumberCountryVersion",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			AgencyModelImpl.NUMBER_COLUMN_BITMASK |
			AgencyModelImpl.COUNTRY_COLUMN_BITMASK |
			AgencyModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNumberCountryVersion",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the agency where number = &#63; and country = &#63; and version = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	 *
	 * @param number the number
	 * @param country the country
	 * @param version the version
	 * @return the matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByNumberCountryVersion(String number, String country,
		String version) throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByNumberCountryVersion(number, country, version);

		if (agency == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("number=");
			msg.append(number);

			msg.append(", country=");
			msg.append(country);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAgencyException(msg.toString());
		}

		return agency;
	}

	/**
	 * Returns the agency where number = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param number the number
	 * @param country the country
	 * @param version the version
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByNumberCountryVersion(String number, String country,
		String version) throws SystemException {
		return fetchByNumberCountryVersion(number, country, version, true);
	}

	/**
	 * Returns the agency where number = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param number the number
	 * @param country the country
	 * @param version the version
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByNumberCountryVersion(String number, String country,
		String version, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { number, country, version };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
					finderArgs, this);
		}

		if (result instanceof Agency) {
			Agency agency = (Agency)result;

			if (!Validator.equals(number, agency.getNumber()) ||
					!Validator.equals(country, agency.getCountry()) ||
					!Validator.equals(version, agency.getVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_AGENCY_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				if (bindVersion) {
					qPos.add(version);
				}

				List<Agency> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
						finderArgs, list);
				}
				else {
					Agency agency = list.get(0);

					result = agency;

					cacheResult(agency);

					if ((agency.getNumber() == null) ||
							!agency.getNumber().equals(number) ||
							(agency.getCountry() == null) ||
							!agency.getCountry().equals(country) ||
							(agency.getVersion() == null) ||
							!agency.getVersion().equals(version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
							finderArgs, agency);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
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
			return (Agency)result;
		}
	}

	/**
	 * Removes the agency where number = &#63; and country = &#63; and version = &#63; from the database.
	 *
	 * @param number the number
	 * @param country the country
	 * @param version the version
	 * @return the agency that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency removeByNumberCountryVersion(String number, String country,
		String version) throws NoSuchAgencyException, SystemException {
		Agency agency = findByNumberCountryVersion(number, country, version);

		return remove(agency);
	}

	/**
	 * Returns the number of agencies where number = &#63; and country = &#63; and version = &#63;.
	 *
	 * @param number the number
	 * @param country the country
	 * @param version the version
	 * @return the number of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNumberCountryVersion(String number, String country,
		String version) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION;

		Object[] finderArgs = new Object[] { number, country, version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_AGENCY_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				if (bindVersion) {
					qPos.add(version);
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

	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_1 = "agency.number IS NULL AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_2 = "agency.number = ? AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_NUMBER_3 = "(agency.number IS NULL OR agency.number = '') AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_1 = "agency.country IS NULL AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_2 = "agency.country = ? AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_COUNTRY_3 = "(agency.country IS NULL OR agency.country = '') AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_1 = "agency.version IS NULL";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_2 = "agency.version = ?";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRYVERSION_VERSION_3 = "(agency.version IS NULL OR agency.version = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NUMBERCOUNTRY = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, AgencyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNumberCountry",
			new String[] { String.class.getName(), String.class.getName() },
			AgencyModelImpl.NUMBER_COLUMN_BITMASK |
			AgencyModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERCOUNTRY = new FinderPath(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumberCountry",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the agency where number = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	 *
	 * @param number the number
	 * @param country the country
	 * @return the matching agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByNumberCountry(String number, String country)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByNumberCountry(number, country);

		if (agency == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("number=");
			msg.append(number);

			msg.append(", country=");
			msg.append(country);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchAgencyException(msg.toString());
		}

		return agency;
	}

	/**
	 * Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param number the number
	 * @param country the country
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByNumberCountry(String number, String country)
		throws SystemException {
		return fetchByNumberCountry(number, country, true);
	}

	/**
	 * Returns the agency where number = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param number the number
	 * @param country the country
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching agency, or <code>null</code> if a matching agency could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByNumberCountry(String number, String country,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { number, country };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
					finderArgs, this);
		}

		if (result instanceof Agency) {
			Agency agency = (Agency)result;

			if (!Validator.equals(number, agency.getNumber()) ||
					!Validator.equals(country, agency.getCountry())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_AGENCY_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				List<Agency> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AgencyPersistenceImpl.fetchByNumberCountry(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Agency agency = list.get(0);

					result = agency;

					cacheResult(agency);

					if ((agency.getNumber() == null) ||
							!agency.getNumber().equals(number) ||
							(agency.getCountry() == null) ||
							!agency.getCountry().equals(country)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
							finderArgs, agency);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
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
			return (Agency)result;
		}
	}

	/**
	 * Removes the agency where number = &#63; and country = &#63; from the database.
	 *
	 * @param number the number
	 * @param country the country
	 * @return the agency that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency removeByNumberCountry(String number, String country)
		throws NoSuchAgencyException, SystemException {
		Agency agency = findByNumberCountry(number, country);

		return remove(agency);
	}

	/**
	 * Returns the number of agencies where number = &#63; and country = &#63;.
	 *
	 * @param number the number
	 * @param country the country
	 * @return the number of matching agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNumberCountry(String number, String country)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBERCOUNTRY;

		Object[] finderArgs = new Object[] { number, country };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AGENCY_WHERE);

			boolean bindNumber = false;

			if (number == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_1);
			}
			else if (number.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_3);
			}
			else {
				bindNumber = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNumber) {
					qPos.add(number);
				}

				if (bindCountry) {
					qPos.add(country);
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

	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_1 = "agency.number IS NULL AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_2 = "agency.number = ? AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_NUMBER_3 = "(agency.number IS NULL OR agency.number = '') AND ";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_1 = "agency.country IS NULL";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_2 = "agency.country = ?";
	private static final String _FINDER_COLUMN_NUMBERCOUNTRY_COUNTRY_3 = "(agency.country IS NULL OR agency.country = '')";

	public AgencyPersistenceImpl() {
		setModelClass(Agency.class);
	}

	/**
	 * Caches the agency in the entity cache if it is enabled.
	 *
	 * @param agency the agency
	 */
	@Override
	public void cacheResult(Agency agency) {
		EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey(), agency);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { agency.getUuid(), agency.getGroupId() }, agency);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
			new Object[] {
				agency.getNumber(), agency.getCountry(), agency.getVersion()
			}, agency);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
			new Object[] { agency.getNumber(), agency.getCountry() }, agency);

		agency.resetOriginalValues();
	}

	/**
	 * Caches the agencies in the entity cache if it is enabled.
	 *
	 * @param agencies the agencies
	 */
	@Override
	public void cacheResult(List<Agency> agencies) {
		for (Agency agency : agencies) {
			if (EntityCacheUtil.getResult(
						AgencyModelImpl.ENTITY_CACHE_ENABLED, AgencyImpl.class,
						agency.getPrimaryKey()) == null) {
				cacheResult(agency);
			}
			else {
				agency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all agencies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AgencyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AgencyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agency.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Agency agency) {
		EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(agency);
	}

	@Override
	public void clearCache(List<Agency> agencies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Agency agency : agencies) {
			EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
				AgencyImpl.class, agency.getPrimaryKey());

			clearUniqueFindersCache(agency);
		}
	}

	protected void cacheUniqueFindersCache(Agency agency) {
		if (agency.isNew()) {
			Object[] args = new Object[] { agency.getUuid(), agency.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, agency);

			args = new Object[] {
					agency.getNumber(), agency.getCountry(), agency.getVersion()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
				args, agency);

			args = new Object[] { agency.getNumber(), agency.getCountry() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY, args,
				agency);
		}
		else {
			AgencyModelImpl agencyModelImpl = (AgencyModelImpl)agency;

			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						agency.getUuid(), agency.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					agency);
			}

			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						agency.getNumber(), agency.getCountry(),
						agency.getVersion()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
					args, agency);
			}

			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NUMBERCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						agency.getNumber(), agency.getCountry()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
					args, agency);
			}
		}
	}

	protected void clearUniqueFindersCache(Agency agency) {
		AgencyModelImpl agencyModelImpl = (AgencyModelImpl)agency;

		Object[] args = new Object[] { agency.getUuid(), agency.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((agencyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					agencyModelImpl.getOriginalUuid(),
					agencyModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				agency.getNumber(), agency.getCountry(), agency.getVersion()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
			args);

		if ((agencyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION.getColumnBitmask()) != 0) {
			args = new Object[] {
					agencyModelImpl.getOriginalNumber(),
					agencyModelImpl.getOriginalCountry(),
					agencyModelImpl.getOriginalVersion()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRYVERSION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRYVERSION,
				args);
		}

		args = new Object[] { agency.getNumber(), agency.getCountry() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY, args);

		if ((agencyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NUMBERCOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					agencyModelImpl.getOriginalNumber(),
					agencyModelImpl.getOriginalCountry()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBERCOUNTRY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBERCOUNTRY,
				args);
		}
	}

	/**
	 * Creates a new agency with the primary key. Does not add the agency to the database.
	 *
	 * @param spAgencyId the primary key for the new agency
	 * @return the new agency
	 */
	@Override
	public Agency create(long spAgencyId) {
		Agency agency = new AgencyImpl();

		agency.setNew(true);
		agency.setPrimaryKey(spAgencyId);

		String uuid = PortalUUIDUtil.generate();

		agency.setUuid(uuid);

		return agency;
	}

	/**
	 * Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAgencyId the primary key of the agency
	 * @return the agency that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency remove(long spAgencyId)
		throws NoSuchAgencyException, SystemException {
		return remove((Serializable)spAgencyId);
	}

	/**
	 * Removes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency remove(Serializable primaryKey)
		throws NoSuchAgencyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Agency agency = (Agency)session.get(AgencyImpl.class, primaryKey);

			if (agency == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(agency);
		}
		catch (NoSuchAgencyException nsee) {
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
	protected Agency removeImpl(Agency agency) throws SystemException {
		agency = toUnwrappedModel(agency);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agency)) {
				agency = (Agency)session.get(AgencyImpl.class,
						agency.getPrimaryKeyObj());
			}

			if (agency != null) {
				session.delete(agency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (agency != null) {
			clearCache(agency);
		}

		return agency;
	}

	@Override
	public Agency updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Agency agency)
		throws SystemException {
		agency = toUnwrappedModel(agency);

		boolean isNew = agency.isNew();

		AgencyModelImpl agencyModelImpl = (AgencyModelImpl)agency;

		if (Validator.isNull(agency.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			agency.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (agency.isNew()) {
				session.save(agency);

				agency.setNew(false);
			}
			else {
				session.merge(agency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AgencyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { agencyModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { agencyModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((agencyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						agencyModelImpl.getOriginalUuid(),
						agencyModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						agencyModelImpl.getUuid(),
						agencyModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
			AgencyImpl.class, agency.getPrimaryKey(), agency);

		clearUniqueFindersCache(agency);
		cacheUniqueFindersCache(agency);

		return agency;
	}

	protected Agency toUnwrappedModel(Agency agency) {
		if (agency instanceof AgencyImpl) {
			return agency;
		}

		AgencyImpl agencyImpl = new AgencyImpl();

		agencyImpl.setNew(agency.isNew());
		agencyImpl.setPrimaryKey(agency.getPrimaryKey());

		agencyImpl.setUuid(agency.getUuid());
		agencyImpl.setSpAgencyId(agency.getSpAgencyId());
		agencyImpl.setGroupId(agency.getGroupId());
		agencyImpl.setCompanyId(agency.getCompanyId());
		agencyImpl.setUserId(agency.getUserId());
		agencyImpl.setUserName(agency.getUserName());
		agencyImpl.setCreateDate(agency.getCreateDate());
		agencyImpl.setModifiedDate(agency.getModifiedDate());
		agencyImpl.setNumber(agency.getNumber());
		agencyImpl.setCountry(agency.getCountry());
		agencyImpl.setName(agency.getName());
		agencyImpl.setReference(agency.getReference());
		agencyImpl.setStartDate(agency.getStartDate());
		agencyImpl.setEndDate(agency.getEndDate());
		agencyImpl.setAddress(agency.getAddress());
		agencyImpl.setRemarks(agency.getRemarks());
		agencyImpl.setStatus(agency.getStatus());
		agencyImpl.setCustomField1(agency.getCustomField1());
		agencyImpl.setCustomField2(agency.getCustomField2());
		agencyImpl.setCustomField3(agency.getCustomField3());
		agencyImpl.setCustomDate1(agency.getCustomDate1());
		agencyImpl.setCustomDate2(agency.getCustomDate2());
		agencyImpl.setCustomDate3(agency.getCustomDate3());
		agencyImpl.setVersion(agency.getVersion());
		agencyImpl.setRootSpAgencyId(agency.getRootSpAgencyId());

		return agencyImpl;
	}

	/**
	 * Returns the agency with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgencyException, SystemException {
		Agency agency = fetchByPrimaryKey(primaryKey);

		if (agency == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return agency;
	}

	/**
	 * Returns the agency with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException} if it could not be found.
	 *
	 * @param spAgencyId the primary key of the agency
	 * @return the agency
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchAgencyException if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency findByPrimaryKey(long spAgencyId)
		throws NoSuchAgencyException, SystemException {
		return findByPrimaryKey((Serializable)spAgencyId);
	}

	/**
	 * Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agency
	 * @return the agency, or <code>null</code> if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Agency agency = (Agency)EntityCacheUtil.getResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
				AgencyImpl.class, primaryKey);

		if (agency == _nullAgency) {
			return null;
		}

		if (agency == null) {
			Session session = null;

			try {
				session = openSession();

				agency = (Agency)session.get(AgencyImpl.class, primaryKey);

				if (agency != null) {
					cacheResult(agency);
				}
				else {
					EntityCacheUtil.putResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
						AgencyImpl.class, primaryKey, _nullAgency);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AgencyModelImpl.ENTITY_CACHE_ENABLED,
					AgencyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return agency;
	}

	/**
	 * Returns the agency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAgencyId the primary key of the agency
	 * @return the agency, or <code>null</code> if a agency with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Agency fetchByPrimaryKey(long spAgencyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spAgencyId);
	}

	/**
	 * Returns all the agencies.
	 *
	 * @return the agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.AgencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agencies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Agency> findAll(int start, int end,
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

		List<Agency> list = (List<Agency>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AGENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AGENCY;

				if (pagination) {
					sql = sql.concat(AgencyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Agency>(list);
				}
				else {
					list = (List<Agency>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the agencies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Agency agency : findAll()) {
			remove(agency);
		}
	}

	/**
	 * Returns the number of agencies.
	 *
	 * @return the number of agencies
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

				Query q = session.createQuery(_SQL_COUNT_AGENCY);

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
	 * Initializes the agency persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.legalandcontract.model.Agency")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Agency>> listenersList = new ArrayList<ModelListener<Agency>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Agency>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AgencyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_AGENCY = "SELECT agency FROM Agency agency";
	private static final String _SQL_SELECT_AGENCY_WHERE = "SELECT agency FROM Agency agency WHERE ";
	private static final String _SQL_COUNT_AGENCY = "SELECT COUNT(agency) FROM Agency agency";
	private static final String _SQL_COUNT_AGENCY_WHERE = "SELECT COUNT(agency) FROM Agency agency WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "agency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Agency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Agency exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AgencyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "number"
			});
	private static Agency _nullAgency = new AgencyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Agency> toCacheModel() {
				return _nullAgencyCacheModel;
			}
		};

	private static CacheModel<Agency> _nullAgencyCacheModel = new CacheModel<Agency>() {
			@Override
			public Agency toEntityModel() {
				return _nullAgency;
			}
		};
}