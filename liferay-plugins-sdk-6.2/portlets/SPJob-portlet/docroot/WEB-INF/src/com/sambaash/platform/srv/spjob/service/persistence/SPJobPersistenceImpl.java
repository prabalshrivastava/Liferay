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

package com.sambaash.platform.srv.spjob.service.persistence;

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

import com.sambaash.platform.srv.spjob.NoSuchSPJobException;
import com.sambaash.platform.srv.spjob.model.SPJob;
import com.sambaash.platform.srv.spjob.model.impl.SPJobImpl;
import com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobPersistence
 * @see SPJobUtil
 * @generated
 */
public class SPJobPersistenceImpl extends BasePersistenceImpl<SPJob>
	implements SPJobPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPJobUtil} to access the s p job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPJobImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPJobModelImpl.UUID_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid(String uuid, int start, int end,
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

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(uuid, spJob.getUuid())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

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
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByUuid_First(uuid, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByUuid_Last(uuid, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where uuid = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByUuid_PrevAndNext(long spJobId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spJob, uuid,
					orderByComparator, true);

			array[1] = spJob;

			array[2] = getByUuid_PrevAndNext(session, spJob, uuid,
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

	protected SPJob getByUuid_PrevAndNext(Session session, SPJob spJob,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPJob spJob : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p jobs
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

			query.append(_SQL_COUNT_SPJOB_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spJob.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spJob.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spJob.uuid IS NULL OR spJob.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPJobModelImpl.UUID_COLUMN_BITMASK |
			SPJobModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p job where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByUUID_G(String uuid, long groupId)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByUUID_G(uuid, groupId);

		if (spJob == null) {
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

			throw new NoSuchSPJobException(msg.toString());
		}

		return spJob;
	}

	/**
	 * Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPJob) {
			SPJob spJob = (SPJob)result;

			if (!Validator.equals(uuid, spJob.getUuid()) ||
					(groupId != spJob.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPJOB_WHERE);

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

				List<SPJob> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPJob spJob = list.get(0);

					result = spJob;

					cacheResult(spJob);

					if ((spJob.getUuid() == null) ||
							!spJob.getUuid().equals(uuid) ||
							(spJob.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spJob);
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
			return (SPJob)result;
		}
	}

	/**
	 * Removes the s p job where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p job that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByUUID_G(uuid, groupId);

		return remove(spJob);
	}

	/**
	 * Returns the number of s p jobs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p jobs
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

			query.append(_SQL_COUNT_SPJOB_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spJob.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spJob.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spJob.uuid IS NULL OR spJob.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spJob.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPJobModelImpl.UUID_COLUMN_BITMASK |
			SPJobModelImpl.COMPANYID_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByUuid_C(String uuid, long companyId, int start,
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

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(uuid, spJob.getUuid()) ||
						(companyId != spJob.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

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
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByUuid_C_PrevAndNext(long spJobId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spJob, uuid, companyId,
					orderByComparator, true);

			array[1] = spJob;

			array[2] = getByUuid_C_PrevAndNext(session, spJob, uuid, companyId,
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

	protected SPJob getByUuid_C_PrevAndNext(Session session, SPJob spJob,
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

		query.append(_SQL_SELECT_SPJOB_WHERE);

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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPJob spJob : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p jobs
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

			query.append(_SQL_COUNT_SPJOB_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spJob.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spJob.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spJob.uuid IS NULL OR spJob.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spJob.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllJobsByCommunityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllJobsByCommunityId",
			new String[] { Long.class.getName() },
			SPJobModelImpl.GROUPID_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYCOMMUNITYID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByCommunityId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCommunityId(long groupId)
		throws SystemException {
		return findByAllJobsByCommunityId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCommunityId(long groupId, int start,
		int end) throws SystemException {
		return findByAllJobsByCommunityId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCommunityId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if ((groupId != spJob.getGroupId())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYCOMMUNITYID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCommunityId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCommunityId_First(groupId,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCommunityId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByCommunityId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCommunityId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCommunityId_Last(groupId,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCommunityId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByCommunityId(groupId);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByCommunityId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where groupId = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByCommunityId_PrevAndNext(long spJobId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByCommunityId_PrevAndNext(session, spJob,
					groupId, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByCommunityId_PrevAndNext(session, spJob,
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

	protected SPJob getByAllJobsByCommunityId_PrevAndNext(Session session,
		SPJob spJob, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		query.append(_FINDER_COLUMN_ALLJOBSBYCOMMUNITYID_GROUPID_2);

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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByCommunityId(long groupId)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByCommunityId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByCommunityId(long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYCOMMUNITYID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYCOMMUNITYID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ALLJOBSBYCOMMUNITYID_GROUPID_2 = "spJob.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYTITLE =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllJobsByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTITLE =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAllJobsByTitle",
			new String[] { String.class.getName() },
			SPJobModelImpl.JOBTITLE_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYTITLE = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAllJobsByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByTitle(String jobTitle)
		throws SystemException {
		return findByAllJobsByTitle(jobTitle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where jobTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobTitle the job title
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByTitle(String jobTitle, int start, int end)
		throws SystemException {
		return findByAllJobsByTitle(jobTitle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where jobTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobTitle the job title
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByTitle(String jobTitle, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTITLE;
			finderArgs = new Object[] { jobTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYTITLE;
			finderArgs = new Object[] { jobTitle, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(jobTitle, spJob.getJobTitle())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			boolean bindJobTitle = false;

			if (jobTitle == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_1);
			}
			else if (jobTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_3);
			}
			else {
				bindJobTitle = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobTitle) {
					qPos.add(jobTitle);
				}

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByTitle_First(String jobTitle,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByTitle_First(jobTitle, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobTitle=");
		msg.append(jobTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByTitle_First(String jobTitle,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByTitle(jobTitle, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByTitle_Last(String jobTitle,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByTitle_Last(jobTitle, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobTitle=");
		msg.append(jobTitle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByTitle_Last(String jobTitle,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByTitle(jobTitle);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByTitle(jobTitle, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where jobTitle = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param jobTitle the job title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByTitle_PrevAndNext(long spJobId,
		String jobTitle, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByTitle_PrevAndNext(session, spJob,
					jobTitle, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByTitle_PrevAndNext(session, spJob,
					jobTitle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJob getByAllJobsByTitle_PrevAndNext(Session session,
		SPJob spJob, String jobTitle, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		boolean bindJobTitle = false;

		if (jobTitle == null) {
			query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_1);
		}
		else if (jobTitle.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_3);
		}
		else {
			bindJobTitle = true;

			query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_2);
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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobTitle) {
			qPos.add(jobTitle);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where jobTitle = &#63; from the database.
	 *
	 * @param jobTitle the job title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByTitle(String jobTitle)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByTitle(jobTitle, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where jobTitle = &#63;.
	 *
	 * @param jobTitle the job title
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByTitle(String jobTitle) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYTITLE;

		Object[] finderArgs = new Object[] { jobTitle };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			boolean bindJobTitle = false;

			if (jobTitle == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_1);
			}
			else if (jobTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_3);
			}
			else {
				bindJobTitle = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobTitle) {
					qPos.add(jobTitle);
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

	private static final String _FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_1 = "spJob.jobTitle IS NULL";
	private static final String _FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_2 = "spJob.jobTitle = ?";
	private static final String _FINDER_COLUMN_ALLJOBSBYTITLE_JOBTITLE_3 = "(spJob.jobTitle IS NULL OR spJob.jobTitle = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYTYPE =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllJobsByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTYPE =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAllJobsByType",
			new String[] { String.class.getName() },
			SPJobModelImpl.JOBTYPE_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYTYPE = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAllJobsByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByType(String jobType)
		throws SystemException {
		return findByAllJobsByType(jobType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByType(String jobType, int start, int end)
		throws SystemException {
		return findByAllJobsByType(jobType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByType(String jobType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTYPE;
			finderArgs = new Object[] { jobType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYTYPE;
			finderArgs = new Object[] { jobType, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(jobType, spJob.getJobType())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByType_First(String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByType_First(jobType, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByType_First(String jobType,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByType(jobType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByType_Last(String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByType_Last(jobType, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByType_Last(String jobType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByType(jobType);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByType(jobType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where jobType = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByType_PrevAndNext(long spJobId,
		String jobType, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByType_PrevAndNext(session, spJob, jobType,
					orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByType_PrevAndNext(session, spJob, jobType,
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

	protected SPJob getByAllJobsByType_PrevAndNext(Session session,
		SPJob spJob, String jobType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		boolean bindJobType = false;

		if (jobType == null) {
			query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_1);
		}
		else if (jobType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_3);
		}
		else {
			bindJobType = true;

			query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_2);
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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobType) {
			qPos.add(jobType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where jobType = &#63; from the database.
	 *
	 * @param jobType the job type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByType(String jobType) throws SystemException {
		for (SPJob spJob : findByAllJobsByType(jobType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByType(String jobType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYTYPE;

		Object[] finderArgs = new Object[] { jobType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
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

	private static final String _FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_1 = "spJob.jobType IS NULL";
	private static final String _FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_2 = "spJob.jobType = ?";
	private static final String _FINDER_COLUMN_ALLJOBSBYTYPE_JOBTYPE_3 = "(spJob.jobType IS NULL OR spJob.jobType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYLOCATION =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllJobsByLocation",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYLOCATION =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllJobsByLocation", new String[] { String.class.getName() },
			SPJobModelImpl.JOBLOCATION_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYLOCATION = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByLocation", new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByLocation(String jobLocation)
		throws SystemException {
		return findByAllJobsByLocation(jobLocation, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where jobLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobLocation the job location
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByLocation(String jobLocation, int start,
		int end) throws SystemException {
		return findByAllJobsByLocation(jobLocation, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where jobLocation = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobLocation the job location
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByLocation(String jobLocation, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYLOCATION;
			finderArgs = new Object[] { jobLocation };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYLOCATION;
			finderArgs = new Object[] { jobLocation, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(jobLocation, spJob.getJobLocation())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			boolean bindJobLocation = false;

			if (jobLocation == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_1);
			}
			else if (jobLocation.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_3);
			}
			else {
				bindJobLocation = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobLocation) {
					qPos.add(jobLocation);
				}

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByLocation_First(String jobLocation,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByLocation_First(jobLocation,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobLocation=");
		msg.append(jobLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByLocation_First(String jobLocation,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByLocation(jobLocation, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByLocation_Last(String jobLocation,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByLocation_Last(jobLocation,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobLocation=");
		msg.append(jobLocation);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByLocation_Last(String jobLocation,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByLocation(jobLocation);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByLocation(jobLocation, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where jobLocation = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param jobLocation the job location
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByLocation_PrevAndNext(long spJobId,
		String jobLocation, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByLocation_PrevAndNext(session, spJob,
					jobLocation, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByLocation_PrevAndNext(session, spJob,
					jobLocation, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJob getByAllJobsByLocation_PrevAndNext(Session session,
		SPJob spJob, String jobLocation, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		boolean bindJobLocation = false;

		if (jobLocation == null) {
			query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_1);
		}
		else if (jobLocation.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_3);
		}
		else {
			bindJobLocation = true;

			query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_2);
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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobLocation) {
			qPos.add(jobLocation);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where jobLocation = &#63; from the database.
	 *
	 * @param jobLocation the job location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByLocation(String jobLocation)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByLocation(jobLocation,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where jobLocation = &#63;.
	 *
	 * @param jobLocation the job location
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByLocation(String jobLocation)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYLOCATION;

		Object[] finderArgs = new Object[] { jobLocation };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			boolean bindJobLocation = false;

			if (jobLocation == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_1);
			}
			else if (jobLocation.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_3);
			}
			else {
				bindJobLocation = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobLocation) {
					qPos.add(jobLocation);
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

	private static final String _FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_1 = "spJob.jobLocation IS NULL";
	private static final String _FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_2 = "spJob.jobLocation = ?";
	private static final String _FINDER_COLUMN_ALLJOBSBYLOCATION_JOBLOCATION_3 = "(spJob.jobLocation IS NULL OR spJob.jobLocation = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllJobsByJobStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllJobsByJobStatus",
			new String[] { String.class.getName() },
			SPJobModelImpl.STATUS_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYJOBSTATUS = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByJobStatus", new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByJobStatus(String status)
		throws SystemException {
		return findByAllJobsByJobStatus(status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByJobStatus(String status, int start,
		int end) throws SystemException {
		return findByAllJobsByJobStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByJobStatus(String status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(status, spJob.getStatus())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByJobStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByJobStatus_First(status, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByJobStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByJobStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByJobStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByJobStatus_Last(status, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByJobStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByJobStatus(status);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByJobStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where status = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByJobStatus_PrevAndNext(long spJobId,
		String status, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByJobStatus_PrevAndNext(session, spJob,
					status, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByJobStatus_PrevAndNext(session, spJob,
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

	protected SPJob getByAllJobsByJobStatus_PrevAndNext(Session session,
		SPJob spJob, String status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_2);
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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByJobStatus(String status)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByJobStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByJobStatus(String status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYJOBSTATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_1 = "spJob.status IS NULL";
	private static final String _FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_2 = "spJob.status = ?";
	private static final String _FINDER_COLUMN_ALLJOBSBYJOBSTATUS_STATUS_3 = "(spJob.status IS NULL OR spJob.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllJobsByCompanyName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllJobsByCompanyName",
			new String[] { String.class.getName() },
			SPJobModelImpl.CORPORATENAME_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYCOMPANYNAME = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByCompanyName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p jobs where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCompanyName(String corporateName)
		throws SystemException {
		return findByAllJobsByCompanyName(corporateName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where corporateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corporateName the corporate name
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCompanyName(String corporateName,
		int start, int end) throws SystemException {
		return findByAllJobsByCompanyName(corporateName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where corporateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corporateName the corporate name
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCompanyName(String corporateName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME;
			finderArgs = new Object[] { corporateName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME;
			finderArgs = new Object[] {
					corporateName,
					
					start, end, orderByComparator
				};
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if (!Validator.equals(corporateName, spJob.getCorporateName())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			boolean bindCorporateName = false;

			if (corporateName == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_1);
			}
			else if (corporateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_3);
			}
			else {
				bindCorporateName = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCorporateName) {
					qPos.add(corporateName);
				}

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCompanyName_First(String corporateName,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCompanyName_First(corporateName,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corporateName=");
		msg.append(corporateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCompanyName_First(String corporateName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByCompanyName(corporateName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCompanyName_Last(String corporateName,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCompanyName_Last(corporateName,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corporateName=");
		msg.append(corporateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCompanyName_Last(String corporateName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByCompanyName(corporateName);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByCompanyName(corporateName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where corporateName = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param corporateName the corporate name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByCompanyName_PrevAndNext(long spJobId,
		String corporateName, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByCompanyName_PrevAndNext(session, spJob,
					corporateName, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByCompanyName_PrevAndNext(session, spJob,
					corporateName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJob getByAllJobsByCompanyName_PrevAndNext(Session session,
		SPJob spJob, String corporateName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		boolean bindCorporateName = false;

		if (corporateName == null) {
			query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_1);
		}
		else if (corporateName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_3);
		}
		else {
			bindCorporateName = true;

			query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_2);
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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCorporateName) {
			qPos.add(corporateName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where corporateName = &#63; from the database.
	 *
	 * @param corporateName the corporate name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByCompanyName(String corporateName)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByCompanyName(corporateName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where corporateName = &#63;.
	 *
	 * @param corporateName the corporate name
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByCompanyName(String corporateName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYCOMPANYNAME;

		Object[] finderArgs = new Object[] { corporateName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			boolean bindCorporateName = false;

			if (corporateName == null) {
				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_1);
			}
			else if (corporateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_3);
			}
			else {
				bindCorporateName = true;

				query.append(_FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCorporateName) {
					qPos.add(corporateName);
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

	private static final String _FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_1 =
		"spJob.corporateName IS NULL";
	private static final String _FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_2 =
		"spJob.corporateName = ?";
	private static final String _FINDER_COLUMN_ALLJOBSBYCOMPANYNAME_CORPORATENAME_3 =
		"(spJob.corporateName IS NULL OR spJob.corporateName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYUSERID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllJobsByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYUSERID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAllJobsByUserId",
			new String[] { Long.class.getName() },
			SPJobModelImpl.CREATEDBY_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYUSERID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p jobs where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByUserId(long createdBy)
		throws SystemException {
		return findByAllJobsByUserId(createdBy, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByUserId(long createdBy, int start, int end)
		throws SystemException {
		return findByAllJobsByUserId(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByUserId(long createdBy, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYUSERID;
			finderArgs = new Object[] { createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYUSERID;
			finderArgs = new Object[] { createdBy, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if ((createdBy != spJob.getCreatedBy())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYUSERID_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByUserId_First(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByUserId_First(createdBy, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByUserId_First(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByUserId(createdBy, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByUserId_Last(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByUserId_Last(createdBy, orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByUserId_Last(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByUserId(createdBy);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByUserId(createdBy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where createdBy = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByUserId_PrevAndNext(long spJobId,
		long createdBy, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByUserId_PrevAndNext(session, spJob,
					createdBy, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByUserId_PrevAndNext(session, spJob,
					createdBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJob getByAllJobsByUserId_PrevAndNext(Session session,
		SPJob spJob, long createdBy, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		query.append(_FINDER_COLUMN_ALLJOBSBYUSERID_CREATEDBY_2);

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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByUserId(long createdBy)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByUserId(createdBy, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByUserId(long createdBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYUSERID;

		Object[] finderArgs = new Object[] { createdBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYUSERID_CREATEDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

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

	private static final String _FINDER_COLUMN_ALLJOBSBYUSERID_CREATEDBY_2 = "spJob.createdBy = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllJobsByCorporateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID =
		new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, SPJobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllJobsByCorporateId",
			new String[] { Long.class.getName() },
			SPJobModelImpl.CORPORATEID_COLUMN_BITMASK |
			SPJobModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLJOBSBYCORPORATEID = new FinderPath(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllJobsByCorporateId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p jobs where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @return the matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCorporateId(long corporateId)
		throws SystemException {
		return findByAllJobsByCorporateId(corporateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs where corporateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corporateId the corporate ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCorporateId(long corporateId, int start,
		int end) throws SystemException {
		return findByAllJobsByCorporateId(corporateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs where corporateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corporateId the corporate ID
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findByAllJobsByCorporateId(long corporateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID;
			finderArgs = new Object[] { corporateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID;
			finderArgs = new Object[] { corporateId, start, end, orderByComparator };
		}

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJob spJob : list) {
				if ((corporateId != spJob.getCorporateId())) {
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

			query.append(_SQL_SELECT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYCORPORATEID_CORPORATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corporateId);

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first s p job in the ordered set where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCorporateId_First(long corporateId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCorporateId_First(corporateId,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corporateId=");
		msg.append(corporateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the first s p job in the ordered set where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCorporateId_First(long corporateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJob> list = findByAllJobsByCorporateId(corporateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job in the ordered set where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByAllJobsByCorporateId_Last(long corporateId,
		OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByAllJobsByCorporateId_Last(corporateId,
				orderByComparator);

		if (spJob != null) {
			return spJob;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corporateId=");
		msg.append(corporateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPJobException(msg.toString());
	}

	/**
	 * Returns the last s p job in the ordered set where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByAllJobsByCorporateId_Last(long corporateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllJobsByCorporateId(corporateId);

		if (count == 0) {
			return null;
		}

		List<SPJob> list = findByAllJobsByCorporateId(corporateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p jobs before and after the current s p job in the ordered set where corporateId = &#63;.
	 *
	 * @param spJobId the primary key of the current s p job
	 * @param corporateId the corporate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob[] findByAllJobsByCorporateId_PrevAndNext(long spJobId,
		long corporateId, OrderByComparator orderByComparator)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = findByPrimaryKey(spJobId);

		Session session = null;

		try {
			session = openSession();

			SPJob[] array = new SPJobImpl[3];

			array[0] = getByAllJobsByCorporateId_PrevAndNext(session, spJob,
					corporateId, orderByComparator, true);

			array[1] = spJob;

			array[2] = getByAllJobsByCorporateId_PrevAndNext(session, spJob,
					corporateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJob getByAllJobsByCorporateId_PrevAndNext(Session session,
		SPJob spJob, long corporateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOB_WHERE);

		query.append(_FINDER_COLUMN_ALLJOBSBYCORPORATEID_CORPORATEID_2);

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
			query.append(SPJobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corporateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJob);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJob> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p jobs where corporateId = &#63; from the database.
	 *
	 * @param corporateId the corporate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllJobsByCorporateId(long corporateId)
		throws SystemException {
		for (SPJob spJob : findByAllJobsByCorporateId(corporateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs where corporateId = &#63;.
	 *
	 * @param corporateId the corporate ID
	 * @return the number of matching s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllJobsByCorporateId(long corporateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLJOBSBYCORPORATEID;

		Object[] finderArgs = new Object[] { corporateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOB_WHERE);

			query.append(_FINDER_COLUMN_ALLJOBSBYCORPORATEID_CORPORATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corporateId);

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

	private static final String _FINDER_COLUMN_ALLJOBSBYCORPORATEID_CORPORATEID_2 =
		"spJob.corporateId = ?";

	public SPJobPersistenceImpl() {
		setModelClass(SPJob.class);
	}

	/**
	 * Caches the s p job in the entity cache if it is enabled.
	 *
	 * @param spJob the s p job
	 */
	@Override
	public void cacheResult(SPJob spJob) {
		EntityCacheUtil.putResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobImpl.class, spJob.getPrimaryKey(), spJob);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spJob.getUuid(), spJob.getGroupId() }, spJob);

		spJob.resetOriginalValues();
	}

	/**
	 * Caches the s p jobs in the entity cache if it is enabled.
	 *
	 * @param spJobs the s p jobs
	 */
	@Override
	public void cacheResult(List<SPJob> spJobs) {
		for (SPJob spJob : spJobs) {
			if (EntityCacheUtil.getResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
						SPJobImpl.class, spJob.getPrimaryKey()) == null) {
				cacheResult(spJob);
			}
			else {
				spJob.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p jobs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPJobImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPJobImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p job.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPJob spJob) {
		EntityCacheUtil.removeResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobImpl.class, spJob.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spJob);
	}

	@Override
	public void clearCache(List<SPJob> spJobs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPJob spJob : spJobs) {
			EntityCacheUtil.removeResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
				SPJobImpl.class, spJob.getPrimaryKey());

			clearUniqueFindersCache(spJob);
		}
	}

	protected void cacheUniqueFindersCache(SPJob spJob) {
		if (spJob.isNew()) {
			Object[] args = new Object[] { spJob.getUuid(), spJob.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, spJob);
		}
		else {
			SPJobModelImpl spJobModelImpl = (SPJobModelImpl)spJob;

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJob.getUuid(), spJob.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spJob);
			}
		}
	}

	protected void clearUniqueFindersCache(SPJob spJob) {
		SPJobModelImpl spJobModelImpl = (SPJobModelImpl)spJob;

		Object[] args = new Object[] { spJob.getUuid(), spJob.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spJobModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spJobModelImpl.getOriginalUuid(),
					spJobModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p job with the primary key. Does not add the s p job to the database.
	 *
	 * @param spJobId the primary key for the new s p job
	 * @return the new s p job
	 */
	@Override
	public SPJob create(long spJobId) {
		SPJob spJob = new SPJobImpl();

		spJob.setNew(true);
		spJob.setPrimaryKey(spJobId);

		String uuid = PortalUUIDUtil.generate();

		spJob.setUuid(uuid);

		return spJob;
	}

	/**
	 * Removes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobId the primary key of the s p job
	 * @return the s p job that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob remove(long spJobId)
		throws NoSuchSPJobException, SystemException {
		return remove((Serializable)spJobId);
	}

	/**
	 * Removes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p job
	 * @return the s p job that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob remove(Serializable primaryKey)
		throws NoSuchSPJobException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPJob spJob = (SPJob)session.get(SPJobImpl.class, primaryKey);

			if (spJob == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spJob);
		}
		catch (NoSuchSPJobException nsee) {
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
	protected SPJob removeImpl(SPJob spJob) throws SystemException {
		spJob = toUnwrappedModel(spJob);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spJob)) {
				spJob = (SPJob)session.get(SPJobImpl.class,
						spJob.getPrimaryKeyObj());
			}

			if (spJob != null) {
				session.delete(spJob);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spJob != null) {
			clearCache(spJob);
		}

		return spJob;
	}

	@Override
	public SPJob updateImpl(com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws SystemException {
		spJob = toUnwrappedModel(spJob);

		boolean isNew = spJob.isNew();

		SPJobModelImpl spJobModelImpl = (SPJobModelImpl)spJob;

		if (Validator.isNull(spJob.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spJob.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spJob.isNew()) {
				session.save(spJob);

				spJob.setNew(false);
			}
			else {
				session.merge(spJob);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPJobModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJobModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spJobModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalUuid(),
						spJobModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spJobModelImpl.getUuid(), spJobModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJobModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCOMMUNITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID,
					args);

				args = new Object[] { spJobModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCOMMUNITYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMMUNITYID,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalJobTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYTITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTITLE,
					args);

				args = new Object[] { spJobModelImpl.getJobTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYTITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTITLE,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJobModelImpl.getOriginalJobType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTYPE,
					args);

				args = new Object[] { spJobModelImpl.getJobType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYTYPE,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYLOCATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalJobLocation()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYLOCATION,
					args);

				args = new Object[] { spJobModelImpl.getJobLocation() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYLOCATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYLOCATION,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spJobModelImpl.getOriginalStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYJOBSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS,
					args);

				args = new Object[] { spJobModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYJOBSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYJOBSTATUS,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalCorporateName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCOMPANYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME,
					args);

				args = new Object[] { spJobModelImpl.getCorporateName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCOMPANYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCOMPANYNAME,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYUSERID,
					args);

				args = new Object[] { spJobModelImpl.getCreatedBy() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYUSERID,
					args);
			}

			if ((spJobModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobModelImpl.getOriginalCorporateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCORPORATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID,
					args);

				args = new Object[] { spJobModelImpl.getCorporateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLJOBSBYCORPORATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLJOBSBYCORPORATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
			SPJobImpl.class, spJob.getPrimaryKey(), spJob);

		clearUniqueFindersCache(spJob);
		cacheUniqueFindersCache(spJob);

		return spJob;
	}

	protected SPJob toUnwrappedModel(SPJob spJob) {
		if (spJob instanceof SPJobImpl) {
			return spJob;
		}

		SPJobImpl spJobImpl = new SPJobImpl();

		spJobImpl.setNew(spJob.isNew());
		spJobImpl.setPrimaryKey(spJob.getPrimaryKey());

		spJobImpl.setUuid(spJob.getUuid());
		spJobImpl.setSpJobId(spJob.getSpJobId());
		spJobImpl.setGroupId(spJob.getGroupId());
		spJobImpl.setCompanyId(spJob.getCompanyId());
		spJobImpl.setUserId(spJob.getUserId());
		spJobImpl.setCreatedBy(spJob.getCreatedBy());
		spJobImpl.setCreateDate(spJob.getCreateDate());
		spJobImpl.setModifiedDate(spJob.getModifiedDate());
		spJobImpl.setUpdatedBy(spJob.getUpdatedBy());
		spJobImpl.setYearsOfExperience(spJob.getYearsOfExperience());
		spJobImpl.setCorporateName(spJob.getCorporateName());
		spJobImpl.setCorporateId(spJob.getCorporateId());
		spJobImpl.setJobTitle(spJob.getJobTitle());
		spJobImpl.setJobType(spJob.getJobType());
		spJobImpl.setJobLocation(spJob.getJobLocation());
		spJobImpl.setJobDescription(spJob.getJobDescription());
		spJobImpl.setStatus(spJob.getStatus());
		spJobImpl.setAutoMatch(spJob.isAutoMatch());
		spJobImpl.setCurrency(spJob.getCurrency());
		spJobImpl.setSalary(spJob.getSalary());
		spJobImpl.setRate(spJob.getRate());
		spJobImpl.setStartDate(spJob.getStartDate());
		spJobImpl.setEndDate(spJob.getEndDate());
		spJobImpl.setClosingDate(spJob.getClosingDate());
		spJobImpl.setExtra1(spJob.getExtra1());
		spJobImpl.setExtra2(spJob.getExtra2());
		spJobImpl.setExtra3(spJob.getExtra3());
		spJobImpl.setExtra4(spJob.getExtra4());
		spJobImpl.setExtra5(spJob.getExtra5());
		spJobImpl.setNotefto(spJob.getNotefto());

		return spJobImpl;
	}

	/**
	 * Returns the s p job with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job
	 * @return the s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPJobException, SystemException {
		SPJob spJob = fetchByPrimaryKey(primaryKey);

		if (spJob == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPJobException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spJob;
	}

	/**
	 * Returns the s p job with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	 *
	 * @param spJobId the primary key of the s p job
	 * @return the s p job
	 * @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob findByPrimaryKey(long spJobId)
		throws NoSuchSPJobException, SystemException {
		return findByPrimaryKey((Serializable)spJobId);
	}

	/**
	 * Returns the s p job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job
	 * @return the s p job, or <code>null</code> if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPJob spJob = (SPJob)EntityCacheUtil.getResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
				SPJobImpl.class, primaryKey);

		if (spJob == _nullSPJob) {
			return null;
		}

		if (spJob == null) {
			Session session = null;

			try {
				session = openSession();

				spJob = (SPJob)session.get(SPJobImpl.class, primaryKey);

				if (spJob != null) {
					cacheResult(spJob);
				}
				else {
					EntityCacheUtil.putResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
						SPJobImpl.class, primaryKey, _nullSPJob);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPJobModelImpl.ENTITY_CACHE_ENABLED,
					SPJobImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spJob;
	}

	/**
	 * Returns the s p job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spJobId the primary key of the s p job
	 * @return the s p job, or <code>null</code> if a s p job with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJob fetchByPrimaryKey(long spJobId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spJobId);
	}

	/**
	 * Returns all the s p jobs.
	 *
	 * @return the s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @return the range of s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p jobs
	 * @param end the upper bound of the range of s p jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p jobs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJob> findAll(int start, int end,
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

		List<SPJob> list = (List<SPJob>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPJOB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPJOB;

				if (pagination) {
					sql = sql.concat(SPJobModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJob>(list);
				}
				else {
					list = (List<SPJob>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the s p jobs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPJob spJob : findAll()) {
			remove(spJob);
		}
	}

	/**
	 * Returns the number of s p jobs.
	 *
	 * @return the number of s p jobs
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

				Query q = session.createQuery(_SQL_COUNT_SPJOB);

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
	 * Initializes the s p job persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spjob.model.SPJob")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPJob>> listenersList = new ArrayList<ModelListener<SPJob>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPJob>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPJobImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPJOB = "SELECT spJob FROM SPJob spJob";
	private static final String _SQL_SELECT_SPJOB_WHERE = "SELECT spJob FROM SPJob spJob WHERE ";
	private static final String _SQL_COUNT_SPJOB = "SELECT COUNT(spJob) FROM SPJob spJob";
	private static final String _SQL_COUNT_SPJOB_WHERE = "SELECT COUNT(spJob) FROM SPJob spJob WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spJob.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPJob exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPJob exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPJobPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "spJobId", "yearsOfExperience"
			});
	private static SPJob _nullSPJob = new SPJobImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPJob> toCacheModel() {
				return _nullSPJobCacheModel;
			}
		};

	private static CacheModel<SPJob> _nullSPJobCacheModel = new CacheModel<SPJob>() {
			@Override
			public SPJob toEntityModel() {
				return _nullSPJob;
			}
		};
}