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

package com.sambaash.platform.srv.spvoting.service.persistence;

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

import com.sambaash.platform.srv.spvoting.NoSuchSPVotingException;
import com.sambaash.platform.srv.spvoting.model.SPVoting;
import com.sambaash.platform.srv.spvoting.model.impl.SPVotingImpl;
import com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p voting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPVotingPersistence
 * @see SPVotingUtil
 * @generated
 */
public class SPVotingPersistenceImpl extends BasePersistenceImpl<SPVoting>
	implements SPVotingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPVotingUtil} to access the s p voting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPVotingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPVotingModelImpl.UUID_COLUMN_BITMASK |
			SPVotingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p votings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p votings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @return the range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p votings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid(String uuid, int start, int end,
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

		List<SPVoting> list = (List<SPVoting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPVoting spVoting : list) {
				if (!Validator.equals(uuid, spVoting.getUuid())) {
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

			query.append(_SQL_SELECT_SPVOTING_WHERE);

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
				query.append(SPVotingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPVoting>(list);
				}
				else {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p voting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByUuid_First(uuid, orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the first s p voting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPVoting> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p voting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByUuid_Last(uuid, orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the last s p voting in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPVoting> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63;.
	 *
	 * @param spVotingId the primary key of the current s p voting
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting[] findByUuid_PrevAndNext(long spVotingId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByPrimaryKey(spVotingId);

		Session session = null;

		try {
			session = openSession();

			SPVoting[] array = new SPVotingImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spVoting, uuid,
					orderByComparator, true);

			array[1] = spVoting;

			array[2] = getByUuid_PrevAndNext(session, spVoting, uuid,
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

	protected SPVoting getByUuid_PrevAndNext(Session session,
		SPVoting spVoting, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPVOTING_WHERE);

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
			query.append(SPVotingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spVoting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPVoting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p votings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPVoting spVoting : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spVoting);
		}
	}

	/**
	 * Returns the number of s p votings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p votings
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

			query.append(_SQL_COUNT_SPVOTING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spVoting.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spVoting.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spVoting.uuid IS NULL OR spVoting.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPVotingModelImpl.UUID_COLUMN_BITMASK |
			SPVotingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p voting where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByUUID_G(String uuid, long groupId)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByUUID_G(uuid, groupId);

		if (spVoting == null) {
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

			throw new NoSuchSPVotingException(msg.toString());
		}

		return spVoting;
	}

	/**
	 * Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p voting where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPVoting) {
			SPVoting spVoting = (SPVoting)result;

			if (!Validator.equals(uuid, spVoting.getUuid()) ||
					(groupId != spVoting.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPVOTING_WHERE);

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

				List<SPVoting> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPVoting spVoting = list.get(0);

					result = spVoting;

					cacheResult(spVoting);

					if ((spVoting.getUuid() == null) ||
							!spVoting.getUuid().equals(uuid) ||
							(spVoting.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spVoting);
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
			return (SPVoting)result;
		}
	}

	/**
	 * Removes the s p voting where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p voting that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByUUID_G(uuid, groupId);

		return remove(spVoting);
	}

	/**
	 * Returns the number of s p votings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p votings
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

			query.append(_SQL_COUNT_SPVOTING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spVoting.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spVoting.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spVoting.uuid IS NULL OR spVoting.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spVoting.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPVotingModelImpl.UUID_COLUMN_BITMASK |
			SPVotingModelImpl.COMPANYID_COLUMN_BITMASK |
			SPVotingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p votings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p votings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @return the range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p votings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByUuid_C(String uuid, long companyId, int start,
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

		List<SPVoting> list = (List<SPVoting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPVoting spVoting : list) {
				if (!Validator.equals(uuid, spVoting.getUuid()) ||
						(companyId != spVoting.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPVOTING_WHERE);

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
				query.append(SPVotingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPVoting>(list);
				}
				else {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the first s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPVoting> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the last s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPVoting> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p votings before and after the current s p voting in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spVotingId the primary key of the current s p voting
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting[] findByUuid_C_PrevAndNext(long spVotingId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByPrimaryKey(spVotingId);

		Session session = null;

		try {
			session = openSession();

			SPVoting[] array = new SPVotingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spVoting, uuid,
					companyId, orderByComparator, true);

			array[1] = spVoting;

			array[2] = getByUuid_C_PrevAndNext(session, spVoting, uuid,
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

	protected SPVoting getByUuid_C_PrevAndNext(Session session,
		SPVoting spVoting, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPVOTING_WHERE);

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
			query.append(SPVotingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spVoting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPVoting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p votings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPVoting spVoting : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spVoting);
		}
	}

	/**
	 * Returns the number of s p votings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p votings
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

			query.append(_SQL_COUNT_SPVOTING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spVoting.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spVoting.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spVoting.uuid IS NULL OR spVoting.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spVoting.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTRYANDUSERID = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEntryAndUserId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			SPVotingModelImpl.CLASSNAME_COLUMN_BITMASK |
			SPVotingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPVotingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTRYANDUSERID = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryAndUserId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param userId the user ID
	 * @return the matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByEntryAndUserId(String className, long classPK,
		long userId) throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByEntryAndUserId(className, classPK, userId);

		if (spVoting == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPVotingException(msg.toString());
		}

		return spVoting;
	}

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param userId the user ID
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntryAndUserId(String className, long classPK,
		long userId) throws SystemException {
		return fetchByEntryAndUserId(className, classPK, userId, true);
	}

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntryAndUserId(String className, long classPK,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { className, classPK, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
					finderArgs, this);
		}

		if (result instanceof SPVoting) {
			SPVoting spVoting = (SPVoting)result;

			if (!Validator.equals(className, spVoting.getClassName()) ||
					(classPK != spVoting.getClassPK()) ||
					(userId != spVoting.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSPK_2);

			query.append(_FINDER_COLUMN_ENTRYANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				qPos.add(userId);

				List<SPVoting> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPVotingPersistenceImpl.fetchByEntryAndUserId(String, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPVoting spVoting = list.get(0);

					result = spVoting;

					cacheResult(spVoting);

					if ((spVoting.getClassName() == null) ||
							!spVoting.getClassName().equals(className) ||
							(spVoting.getClassPK() != classPK) ||
							(spVoting.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
							finderArgs, spVoting);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
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
			return (SPVoting)result;
		}
	}

	/**
	 * Removes the s p voting where className = &#63; and classPK = &#63; and userId = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param userId the user ID
	 * @return the s p voting that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting removeByEntryAndUserId(String className, long classPK,
		long userId) throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByEntryAndUserId(className, classPK, userId);

		return remove(spVoting);
	}

	/**
	 * Returns the number of s p votings where className = &#63; and classPK = &#63; and userId = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param userId the user ID
	 * @return the number of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntryAndUserId(String className, long classPK, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTRYANDUSERID;

		Object[] finderArgs = new Object[] { className, classPK, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRYANDUSERID_CLASSPK_2);

			query.append(_FINDER_COLUMN_ENTRYANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_1 = "spVoting.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_2 = "spVoting.className = ? AND ";
	private static final String _FINDER_COLUMN_ENTRYANDUSERID_CLASSNAME_3 = "(spVoting.className IS NULL OR spVoting.className = '') AND ";
	private static final String _FINDER_COLUMN_ENTRYANDUSERID_CLASSPK_2 = "spVoting.classPK = ? AND ";
	private static final String _FINDER_COLUMN_ENTRYANDUSERID_USERID_2 = "spVoting.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTRYANDIP = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEntryAndIp",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			SPVotingModelImpl.CLASSNAME_COLUMN_BITMASK |
			SPVotingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPVotingModelImpl.IP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTRYANDIP = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntryAndIp",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param ip the ip
	 * @return the matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByEntryAndIp(String className, long classPK, String ip)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByEntryAndIp(className, classPK, ip);

		if (spVoting == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("className=");
			msg.append(className);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", ip=");
			msg.append(ip);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPVotingException(msg.toString());
		}

		return spVoting;
	}

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param ip the ip
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntryAndIp(String className, long classPK, String ip)
		throws SystemException {
		return fetchByEntryAndIp(className, classPK, ip, true);
	}

	/**
	 * Returns the s p voting where className = &#63; and classPK = &#63; and ip = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param ip the ip
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntryAndIp(String className, long classPK,
		String ip, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { className, classPK, ip };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
					finderArgs, this);
		}

		if (result instanceof SPVoting) {
			SPVoting spVoting = (SPVoting)result;

			if (!Validator.equals(className, spVoting.getClassName()) ||
					(classPK != spVoting.getClassPK()) ||
					!Validator.equals(ip, spVoting.getIp())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSPK_2);

			boolean bindIp = false;

			if (ip == null) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_1);
			}
			else if (ip.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_3);
			}
			else {
				bindIp = true;

				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindIp) {
					qPos.add(ip);
				}

				List<SPVoting> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPVotingPersistenceImpl.fetchByEntryAndIp(String, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPVoting spVoting = list.get(0);

					result = spVoting;

					cacheResult(spVoting);

					if ((spVoting.getClassName() == null) ||
							!spVoting.getClassName().equals(className) ||
							(spVoting.getClassPK() != classPK) ||
							(spVoting.getIp() == null) ||
							!spVoting.getIp().equals(ip)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
							finderArgs, spVoting);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
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
			return (SPVoting)result;
		}
	}

	/**
	 * Removes the s p voting where className = &#63; and classPK = &#63; and ip = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param ip the ip
	 * @return the s p voting that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting removeByEntryAndIp(String className, long classPK, String ip)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByEntryAndIp(className, classPK, ip);

		return remove(spVoting);
	}

	/**
	 * Returns the number of s p votings where className = &#63; and classPK = &#63; and ip = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param ip the ip
	 * @return the number of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntryAndIp(String className, long classPK, String ip)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTRYANDIP;

		Object[] finderArgs = new Object[] { className, classPK, ip };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRYANDIP_CLASSPK_2);

			boolean bindIp = false;

			if (ip == null) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_1);
			}
			else if (ip.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_3);
			}
			else {
				bindIp = true;

				query.append(_FINDER_COLUMN_ENTRYANDIP_IP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (bindIp) {
					qPos.add(ip);
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

	private static final String _FINDER_COLUMN_ENTRYANDIP_CLASSNAME_1 = "spVoting.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ENTRYANDIP_CLASSNAME_2 = "spVoting.className = ? AND ";
	private static final String _FINDER_COLUMN_ENTRYANDIP_CLASSNAME_3 = "(spVoting.className IS NULL OR spVoting.className = '') AND ";
	private static final String _FINDER_COLUMN_ENTRYANDIP_CLASSPK_2 = "spVoting.classPK = ? AND ";
	private static final String _FINDER_COLUMN_ENTRYANDIP_IP_1 = "spVoting.ip IS NULL";
	private static final String _FINDER_COLUMN_ENTRYANDIP_IP_2 = "spVoting.ip = ?";
	private static final String _FINDER_COLUMN_ENTRYANDIP_IP_3 = "(spVoting.ip IS NULL OR spVoting.ip = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRY = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntry",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, SPVotingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEntry",
			new String[] { String.class.getName(), Long.class.getName() },
			SPVotingModelImpl.CLASSNAME_COLUMN_BITMASK |
			SPVotingModelImpl.CLASSPK_COLUMN_BITMASK |
			SPVotingModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTRY = new FinderPath(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntry",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p votings where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByEntry(String className, long classPK)
		throws SystemException {
		return findByEntry(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p votings where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @return the range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByEntry(String className, long classPK,
		int start, int end) throws SystemException {
		return findByEntry(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p votings where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findByEntry(String className, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY;
			finderArgs = new Object[] { className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTRY;
			finderArgs = new Object[] {
					className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<SPVoting> list = (List<SPVoting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPVoting spVoting : list) {
				if (!Validator.equals(className, spVoting.getClassName()) ||
						(classPK != spVoting.getClassPK())) {
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

			query.append(_SQL_SELECT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRY_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPVotingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPVoting>(list);
				}
				else {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByEntry_First(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByEntry_First(className, classPK,
				orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the first s p voting in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntry_First(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPVoting> list = findByEntry(className, classPK, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByEntry_Last(String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByEntry_Last(className, classPK,
				orderByComparator);

		if (spVoting != null) {
			return spVoting;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPVotingException(msg.toString());
	}

	/**
	 * Returns the last s p voting in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p voting, or <code>null</code> if a matching s p voting could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByEntry_Last(String className, long classPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEntry(className, classPK);

		if (count == 0) {
			return null;
		}

		List<SPVoting> list = findByEntry(className, classPK, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p votings before and after the current s p voting in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param spVotingId the primary key of the current s p voting
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting[] findByEntry_PrevAndNext(long spVotingId,
		String className, long classPK, OrderByComparator orderByComparator)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = findByPrimaryKey(spVotingId);

		Session session = null;

		try {
			session = openSession();

			SPVoting[] array = new SPVotingImpl[3];

			array[0] = getByEntry_PrevAndNext(session, spVoting, className,
					classPK, orderByComparator, true);

			array[1] = spVoting;

			array[2] = getByEntry_PrevAndNext(session, spVoting, className,
					classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPVoting getByEntry_PrevAndNext(Session session,
		SPVoting spVoting, String className, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPVOTING_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_ENTRY_CLASSPK_2);

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
			query.append(SPVotingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spVoting);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPVoting> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p votings where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEntry(String className, long classPK)
		throws SystemException {
		for (SPVoting spVoting : findByEntry(className, classPK,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spVoting);
		}
	}

	/**
	 * Returns the number of s p votings where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntry(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTRY;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPVOTING_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_ENTRY_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_ENTRY_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_ENTRY_CLASSNAME_1 = "spVoting.className IS NULL AND ";
	private static final String _FINDER_COLUMN_ENTRY_CLASSNAME_2 = "spVoting.className = ? AND ";
	private static final String _FINDER_COLUMN_ENTRY_CLASSNAME_3 = "(spVoting.className IS NULL OR spVoting.className = '') AND ";
	private static final String _FINDER_COLUMN_ENTRY_CLASSPK_2 = "spVoting.classPK = ?";

	public SPVotingPersistenceImpl() {
		setModelClass(SPVoting.class);
	}

	/**
	 * Caches the s p voting in the entity cache if it is enabled.
	 *
	 * @param spVoting the s p voting
	 */
	@Override
	public void cacheResult(SPVoting spVoting) {
		EntityCacheUtil.putResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingImpl.class, spVoting.getPrimaryKey(), spVoting);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spVoting.getUuid(), spVoting.getGroupId() }, spVoting);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
			new Object[] {
				spVoting.getClassName(), spVoting.getClassPK(),
				spVoting.getUserId()
			}, spVoting);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
			new Object[] {
				spVoting.getClassName(), spVoting.getClassPK(), spVoting.getIp()
			}, spVoting);

		spVoting.resetOriginalValues();
	}

	/**
	 * Caches the s p votings in the entity cache if it is enabled.
	 *
	 * @param spVotings the s p votings
	 */
	@Override
	public void cacheResult(List<SPVoting> spVotings) {
		for (SPVoting spVoting : spVotings) {
			if (EntityCacheUtil.getResult(
						SPVotingModelImpl.ENTITY_CACHE_ENABLED,
						SPVotingImpl.class, spVoting.getPrimaryKey()) == null) {
				cacheResult(spVoting);
			}
			else {
				spVoting.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p votings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPVotingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPVotingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p voting.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPVoting spVoting) {
		EntityCacheUtil.removeResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingImpl.class, spVoting.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spVoting);
	}

	@Override
	public void clearCache(List<SPVoting> spVotings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPVoting spVoting : spVotings) {
			EntityCacheUtil.removeResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
				SPVotingImpl.class, spVoting.getPrimaryKey());

			clearUniqueFindersCache(spVoting);
		}
	}

	protected void cacheUniqueFindersCache(SPVoting spVoting) {
		if (spVoting.isNew()) {
			Object[] args = new Object[] {
					spVoting.getUuid(), spVoting.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spVoting);

			args = new Object[] {
					spVoting.getClassName(), spVoting.getClassPK(),
					spVoting.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRYANDUSERID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
				args, spVoting);

			args = new Object[] {
					spVoting.getClassName(), spVoting.getClassPK(),
					spVoting.getIp()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRYANDIP, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDIP, args,
				spVoting);
		}
		else {
			SPVotingModelImpl spVotingModelImpl = (SPVotingModelImpl)spVoting;

			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spVoting.getUuid(), spVoting.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spVoting);
			}

			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTRYANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spVoting.getClassName(), spVoting.getClassPK(),
						spVoting.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRYANDUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
					args, spVoting);
			}

			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTRYANDIP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spVoting.getClassName(), spVoting.getClassPK(),
						spVoting.getIp()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTRYANDIP,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTRYANDIP,
					args, spVoting);
			}
		}
	}

	protected void clearUniqueFindersCache(SPVoting spVoting) {
		SPVotingModelImpl spVotingModelImpl = (SPVotingModelImpl)spVoting;

		Object[] args = new Object[] { spVoting.getUuid(), spVoting.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spVotingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spVotingModelImpl.getOriginalUuid(),
					spVotingModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spVoting.getClassName(), spVoting.getClassPK(),
				spVoting.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYANDUSERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID, args);

		if ((spVotingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTRYANDUSERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spVotingModelImpl.getOriginalClassName(),
					spVotingModelImpl.getOriginalClassPK(),
					spVotingModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYANDUSERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDUSERID,
				args);
		}

		args = new Object[] {
				spVoting.getClassName(), spVoting.getClassPK(), spVoting.getIp()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYANDIP, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDIP, args);

		if ((spVotingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTRYANDIP.getColumnBitmask()) != 0) {
			args = new Object[] {
					spVotingModelImpl.getOriginalClassName(),
					spVotingModelImpl.getOriginalClassPK(),
					spVotingModelImpl.getOriginalIp()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRYANDIP, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTRYANDIP, args);
		}
	}

	/**
	 * Creates a new s p voting with the primary key. Does not add the s p voting to the database.
	 *
	 * @param spVotingId the primary key for the new s p voting
	 * @return the new s p voting
	 */
	@Override
	public SPVoting create(long spVotingId) {
		SPVoting spVoting = new SPVotingImpl();

		spVoting.setNew(true);
		spVoting.setPrimaryKey(spVotingId);

		String uuid = PortalUUIDUtil.generate();

		spVoting.setUuid(uuid);

		return spVoting;
	}

	/**
	 * Removes the s p voting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spVotingId the primary key of the s p voting
	 * @return the s p voting that was removed
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting remove(long spVotingId)
		throws NoSuchSPVotingException, SystemException {
		return remove((Serializable)spVotingId);
	}

	/**
	 * Removes the s p voting with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p voting
	 * @return the s p voting that was removed
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting remove(Serializable primaryKey)
		throws NoSuchSPVotingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPVoting spVoting = (SPVoting)session.get(SPVotingImpl.class,
					primaryKey);

			if (spVoting == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPVotingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spVoting);
		}
		catch (NoSuchSPVotingException nsee) {
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
	protected SPVoting removeImpl(SPVoting spVoting) throws SystemException {
		spVoting = toUnwrappedModel(spVoting);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spVoting)) {
				spVoting = (SPVoting)session.get(SPVotingImpl.class,
						spVoting.getPrimaryKeyObj());
			}

			if (spVoting != null) {
				session.delete(spVoting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spVoting != null) {
			clearCache(spVoting);
		}

		return spVoting;
	}

	@Override
	public SPVoting updateImpl(
		com.sambaash.platform.srv.spvoting.model.SPVoting spVoting)
		throws SystemException {
		spVoting = toUnwrappedModel(spVoting);

		boolean isNew = spVoting.isNew();

		SPVotingModelImpl spVotingModelImpl = (SPVotingModelImpl)spVoting;

		if (Validator.isNull(spVoting.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spVoting.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spVoting.isNew()) {
				session.save(spVoting);

				spVoting.setNew(false);
			}
			else {
				session.merge(spVoting);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPVotingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spVotingModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spVotingModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spVotingModelImpl.getOriginalUuid(),
						spVotingModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spVotingModelImpl.getUuid(),
						spVotingModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spVotingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spVotingModelImpl.getOriginalClassName(),
						spVotingModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY,
					args);

				args = new Object[] {
						spVotingModelImpl.getClassName(),
						spVotingModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTRY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
			SPVotingImpl.class, spVoting.getPrimaryKey(), spVoting);

		clearUniqueFindersCache(spVoting);
		cacheUniqueFindersCache(spVoting);

		return spVoting;
	}

	protected SPVoting toUnwrappedModel(SPVoting spVoting) {
		if (spVoting instanceof SPVotingImpl) {
			return spVoting;
		}

		SPVotingImpl spVotingImpl = new SPVotingImpl();

		spVotingImpl.setNew(spVoting.isNew());
		spVotingImpl.setPrimaryKey(spVoting.getPrimaryKey());

		spVotingImpl.setUuid(spVoting.getUuid());
		spVotingImpl.setSpVotingId(spVoting.getSpVotingId());
		spVotingImpl.setGroupId(spVoting.getGroupId());
		spVotingImpl.setCompanyId(spVoting.getCompanyId());
		spVotingImpl.setUserId(spVoting.getUserId());
		spVotingImpl.setUserName(spVoting.getUserName());
		spVotingImpl.setCreateDate(spVoting.getCreateDate());
		spVotingImpl.setModifiedDate(spVoting.getModifiedDate());
		spVotingImpl.setClassName(spVoting.getClassName());
		spVotingImpl.setClassPK(spVoting.getClassPK());
		spVotingImpl.setIp(spVoting.getIp());

		return spVotingImpl;
	}

	/**
	 * Returns the s p voting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p voting
	 * @return the s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPVotingException, SystemException {
		SPVoting spVoting = fetchByPrimaryKey(primaryKey);

		if (spVoting == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPVotingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spVoting;
	}

	/**
	 * Returns the s p voting with the primary key or throws a {@link com.sambaash.platform.srv.spvoting.NoSuchSPVotingException} if it could not be found.
	 *
	 * @param spVotingId the primary key of the s p voting
	 * @return the s p voting
	 * @throws com.sambaash.platform.srv.spvoting.NoSuchSPVotingException if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting findByPrimaryKey(long spVotingId)
		throws NoSuchSPVotingException, SystemException {
		return findByPrimaryKey((Serializable)spVotingId);
	}

	/**
	 * Returns the s p voting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p voting
	 * @return the s p voting, or <code>null</code> if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPVoting spVoting = (SPVoting)EntityCacheUtil.getResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
				SPVotingImpl.class, primaryKey);

		if (spVoting == _nullSPVoting) {
			return null;
		}

		if (spVoting == null) {
			Session session = null;

			try {
				session = openSession();

				spVoting = (SPVoting)session.get(SPVotingImpl.class, primaryKey);

				if (spVoting != null) {
					cacheResult(spVoting);
				}
				else {
					EntityCacheUtil.putResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
						SPVotingImpl.class, primaryKey, _nullSPVoting);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPVotingModelImpl.ENTITY_CACHE_ENABLED,
					SPVotingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spVoting;
	}

	/**
	 * Returns the s p voting with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spVotingId the primary key of the s p voting
	 * @return the s p voting, or <code>null</code> if a s p voting with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPVoting fetchByPrimaryKey(long spVotingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spVotingId);
	}

	/**
	 * Returns all the s p votings.
	 *
	 * @return the s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p votings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @return the range of s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p votings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spvoting.model.impl.SPVotingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p votings
	 * @param end the upper bound of the range of s p votings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p votings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPVoting> findAll(int start, int end,
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

		List<SPVoting> list = (List<SPVoting>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPVOTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPVOTING;

				if (pagination) {
					sql = sql.concat(SPVotingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPVoting>(list);
				}
				else {
					list = (List<SPVoting>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p votings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPVoting spVoting : findAll()) {
			remove(spVoting);
		}
	}

	/**
	 * Returns the number of s p votings.
	 *
	 * @return the number of s p votings
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

				Query q = session.createQuery(_SQL_COUNT_SPVOTING);

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
	 * Initializes the s p voting persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spvoting.model.SPVoting")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPVoting>> listenersList = new ArrayList<ModelListener<SPVoting>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPVoting>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPVotingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPVOTING = "SELECT spVoting FROM SPVoting spVoting";
	private static final String _SQL_SELECT_SPVOTING_WHERE = "SELECT spVoting FROM SPVoting spVoting WHERE ";
	private static final String _SQL_COUNT_SPVOTING = "SELECT COUNT(spVoting) FROM SPVoting spVoting";
	private static final String _SQL_COUNT_SPVOTING_WHERE = "SELECT COUNT(spVoting) FROM SPVoting spVoting WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spVoting.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPVoting exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPVoting exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPVotingPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPVoting _nullSPVoting = new SPVotingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPVoting> toCacheModel() {
				return _nullSPVotingCacheModel;
			}
		};

	private static CacheModel<SPVoting> _nullSPVotingCacheModel = new CacheModel<SPVoting>() {
			@Override
			public SPVoting toEntityModel() {
				return _nullSPVoting;
			}
		};
}