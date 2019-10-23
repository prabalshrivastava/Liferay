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

package com.sambaash.platform.srv.spchallenge.service.persistence;

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

import com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException;
import com.sambaash.platform.srv.spchallenge.model.SPChallenge;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeImpl;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p challenge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPChallengePersistence
 * @see SPChallengeUtil
 * @generated
 */
public class SPChallengePersistenceImpl extends BasePersistenceImpl<SPChallenge>
	implements SPChallengePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPChallengeUtil} to access the s p challenge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPChallengeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPChallengeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @return the range of matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid(String uuid, int start, int end,
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

		List<SPChallenge> list = (List<SPChallenge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallenge spChallenge : list) {
				if (!Validator.equals(uuid, spChallenge.getUuid())) {
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

			query.append(_SQL_SELECT_SPCHALLENGE_WHERE);

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
				query.append(SPChallengeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallenge>(list);
				}
				else {
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByUuid_First(uuid, orderByComparator);

		if (spChallenge != null) {
			return spChallenge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPChallengeException(msg.toString());
	}

	/**
	 * Returns the first s p challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPChallenge> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByUuid_Last(uuid, orderByComparator);

		if (spChallenge != null) {
			return spChallenge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPChallengeException(msg.toString());
	}

	/**
	 * Returns the last s p challenge in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPChallenge> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenges before and after the current s p challenge in the ordered set where uuid = &#63;.
	 *
	 * @param spChallengeId the primary key of the current s p challenge
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge[] findByUuid_PrevAndNext(long spChallengeId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = findByPrimaryKey(spChallengeId);

		Session session = null;

		try {
			session = openSession();

			SPChallenge[] array = new SPChallengeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spChallenge, uuid,
					orderByComparator, true);

			array[1] = spChallenge;

			array[2] = getByUuid_PrevAndNext(session, spChallenge, uuid,
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

	protected SPChallenge getByUuid_PrevAndNext(Session session,
		SPChallenge spChallenge, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGE_WHERE);

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
			query.append(SPChallengeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spChallenge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallenge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPChallenge spChallenge : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spChallenge);
		}
	}

	/**
	 * Returns the number of s p challenges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p challenges
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

			query.append(_SQL_COUNT_SPCHALLENGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spChallenge.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spChallenge.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spChallenge.uuid IS NULL OR spChallenge.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPChallengeModelImpl.UUID_COLUMN_BITMASK |
			SPChallengeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p challenge where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByUUID_G(String uuid, long groupId)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByUUID_G(uuid, groupId);

		if (spChallenge == null) {
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

			throw new NoSuchSPChallengeException(msg.toString());
		}

		return spChallenge;
	}

	/**
	 * Returns the s p challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p challenge where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPChallenge) {
			SPChallenge spChallenge = (SPChallenge)result;

			if (!Validator.equals(uuid, spChallenge.getUuid()) ||
					(groupId != spChallenge.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCHALLENGE_WHERE);

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

				List<SPChallenge> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPChallenge spChallenge = list.get(0);

					result = spChallenge;

					cacheResult(spChallenge);

					if ((spChallenge.getUuid() == null) ||
							!spChallenge.getUuid().equals(uuid) ||
							(spChallenge.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spChallenge);
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
			return (SPChallenge)result;
		}
	}

	/**
	 * Removes the s p challenge where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p challenge that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = findByUUID_G(uuid, groupId);

		return remove(spChallenge);
	}

	/**
	 * Returns the number of s p challenges where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p challenges
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

			query.append(_SQL_COUNT_SPCHALLENGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spChallenge.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spChallenge.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spChallenge.uuid IS NULL OR spChallenge.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spChallenge.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, SPChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPChallengeModelImpl.UUID_COLUMN_BITMASK |
			SPChallengeModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @return the range of matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findByUuid_C(String uuid, long companyId,
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

		List<SPChallenge> list = (List<SPChallenge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallenge spChallenge : list) {
				if (!Validator.equals(uuid, spChallenge.getUuid()) ||
						(companyId != spChallenge.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPCHALLENGE_WHERE);

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
				query.append(SPChallengeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallenge>(list);
				}
				else {
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spChallenge != null) {
			return spChallenge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPChallengeException(msg.toString());
	}

	/**
	 * Returns the first s p challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPChallenge> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spChallenge != null) {
			return spChallenge;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPChallengeException(msg.toString());
	}

	/**
	 * Returns the last s p challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge, or <code>null</code> if a matching s p challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPChallenge> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenges before and after the current s p challenge in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spChallengeId the primary key of the current s p challenge
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge[] findByUuid_C_PrevAndNext(long spChallengeId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = findByPrimaryKey(spChallengeId);

		Session session = null;

		try {
			session = openSession();

			SPChallenge[] array = new SPChallengeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spChallenge, uuid,
					companyId, orderByComparator, true);

			array[1] = spChallenge;

			array[2] = getByUuid_C_PrevAndNext(session, spChallenge, uuid,
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

	protected SPChallenge getByUuid_C_PrevAndNext(Session session,
		SPChallenge spChallenge, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGE_WHERE);

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
			query.append(SPChallengeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spChallenge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallenge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenges where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPChallenge spChallenge : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spChallenge);
		}
	}

	/**
	 * Returns the number of s p challenges where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p challenges
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

			query.append(_SQL_COUNT_SPCHALLENGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spChallenge.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spChallenge.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spChallenge.uuid IS NULL OR spChallenge.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spChallenge.companyId = ?";

	public SPChallengePersistenceImpl() {
		setModelClass(SPChallenge.class);
	}

	/**
	 * Caches the s p challenge in the entity cache if it is enabled.
	 *
	 * @param spChallenge the s p challenge
	 */
	@Override
	public void cacheResult(SPChallenge spChallenge) {
		EntityCacheUtil.putResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeImpl.class, spChallenge.getPrimaryKey(), spChallenge);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spChallenge.getUuid(), spChallenge.getGroupId() },
			spChallenge);

		spChallenge.resetOriginalValues();
	}

	/**
	 * Caches the s p challenges in the entity cache if it is enabled.
	 *
	 * @param spChallenges the s p challenges
	 */
	@Override
	public void cacheResult(List<SPChallenge> spChallenges) {
		for (SPChallenge spChallenge : spChallenges) {
			if (EntityCacheUtil.getResult(
						SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
						SPChallengeImpl.class, spChallenge.getPrimaryKey()) == null) {
				cacheResult(spChallenge);
			}
			else {
				spChallenge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p challenges.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPChallengeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPChallengeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p challenge.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPChallenge spChallenge) {
		EntityCacheUtil.removeResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeImpl.class, spChallenge.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spChallenge);
	}

	@Override
	public void clearCache(List<SPChallenge> spChallenges) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPChallenge spChallenge : spChallenges) {
			EntityCacheUtil.removeResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
				SPChallengeImpl.class, spChallenge.getPrimaryKey());

			clearUniqueFindersCache(spChallenge);
		}
	}

	protected void cacheUniqueFindersCache(SPChallenge spChallenge) {
		if (spChallenge.isNew()) {
			Object[] args = new Object[] {
					spChallenge.getUuid(), spChallenge.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spChallenge);
		}
		else {
			SPChallengeModelImpl spChallengeModelImpl = (SPChallengeModelImpl)spChallenge;

			if ((spChallengeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallenge.getUuid(), spChallenge.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spChallenge);
			}
		}
	}

	protected void clearUniqueFindersCache(SPChallenge spChallenge) {
		SPChallengeModelImpl spChallengeModelImpl = (SPChallengeModelImpl)spChallenge;

		Object[] args = new Object[] {
				spChallenge.getUuid(), spChallenge.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spChallengeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spChallengeModelImpl.getOriginalUuid(),
					spChallengeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p challenge with the primary key. Does not add the s p challenge to the database.
	 *
	 * @param spChallengeId the primary key for the new s p challenge
	 * @return the new s p challenge
	 */
	@Override
	public SPChallenge create(long spChallengeId) {
		SPChallenge spChallenge = new SPChallengeImpl();

		spChallenge.setNew(true);
		spChallenge.setPrimaryKey(spChallengeId);

		String uuid = PortalUUIDUtil.generate();

		spChallenge.setUuid(uuid);

		return spChallenge;
	}

	/**
	 * Removes the s p challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeId the primary key of the s p challenge
	 * @return the s p challenge that was removed
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge remove(long spChallengeId)
		throws NoSuchSPChallengeException, SystemException {
		return remove((Serializable)spChallengeId);
	}

	/**
	 * Removes the s p challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p challenge
	 * @return the s p challenge that was removed
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge remove(Serializable primaryKey)
		throws NoSuchSPChallengeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPChallenge spChallenge = (SPChallenge)session.get(SPChallengeImpl.class,
					primaryKey);

			if (spChallenge == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPChallengeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spChallenge);
		}
		catch (NoSuchSPChallengeException nsee) {
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
	protected SPChallenge removeImpl(SPChallenge spChallenge)
		throws SystemException {
		spChallenge = toUnwrappedModel(spChallenge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spChallenge)) {
				spChallenge = (SPChallenge)session.get(SPChallengeImpl.class,
						spChallenge.getPrimaryKeyObj());
			}

			if (spChallenge != null) {
				session.delete(spChallenge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spChallenge != null) {
			clearCache(spChallenge);
		}

		return spChallenge;
	}

	@Override
	public SPChallenge updateImpl(
		com.sambaash.platform.srv.spchallenge.model.SPChallenge spChallenge)
		throws SystemException {
		spChallenge = toUnwrappedModel(spChallenge);

		boolean isNew = spChallenge.isNew();

		SPChallengeModelImpl spChallengeModelImpl = (SPChallengeModelImpl)spChallenge;

		if (Validator.isNull(spChallenge.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spChallenge.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spChallenge.isNew()) {
				session.save(spChallenge);

				spChallenge.setNew(false);
			}
			else {
				session.merge(spChallenge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPChallengeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spChallengeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spChallengeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spChallengeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeModelImpl.getOriginalUuid(),
						spChallengeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spChallengeModelImpl.getUuid(),
						spChallengeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeImpl.class, spChallenge.getPrimaryKey(), spChallenge);

		clearUniqueFindersCache(spChallenge);
		cacheUniqueFindersCache(spChallenge);

		return spChallenge;
	}

	protected SPChallenge toUnwrappedModel(SPChallenge spChallenge) {
		if (spChallenge instanceof SPChallengeImpl) {
			return spChallenge;
		}

		SPChallengeImpl spChallengeImpl = new SPChallengeImpl();

		spChallengeImpl.setNew(spChallenge.isNew());
		spChallengeImpl.setPrimaryKey(spChallenge.getPrimaryKey());

		spChallengeImpl.setUuid(spChallenge.getUuid());
		spChallengeImpl.setSpChallengeId(spChallenge.getSpChallengeId());
		spChallengeImpl.setGroupId(spChallenge.getGroupId());
		spChallengeImpl.setCompanyId(spChallenge.getCompanyId());
		spChallengeImpl.setUserId(spChallenge.getUserId());
		spChallengeImpl.setUserName(spChallenge.getUserName());
		spChallengeImpl.setCreateDate(spChallenge.getCreateDate());
		spChallengeImpl.setModifiedDate(spChallenge.getModifiedDate());
		spChallengeImpl.setName(spChallenge.getName());
		spChallengeImpl.setOpenTo(spChallenge.getOpenTo());
		spChallengeImpl.setType(spChallenge.getType());
		spChallengeImpl.setBackground(spChallenge.getBackground());
		spChallengeImpl.setDescription(spChallenge.getDescription());
		spChallengeImpl.setScope(spChallenge.getScope());
		spChallengeImpl.setBenefits(spChallenge.getBenefits());
		spChallengeImpl.setBudget(spChallenge.getBudget());
		spChallengeImpl.setStartDate(spChallenge.getStartDate());
		spChallengeImpl.setEndDate(spChallenge.getEndDate());
		spChallengeImpl.setApplyBy(spChallenge.getApplyBy());
		spChallengeImpl.setExtras(spChallenge.getExtras());
		spChallengeImpl.setActive(spChallenge.isActive());
		spChallengeImpl.setNotifyTo(spChallenge.getNotifyTo());
		spChallengeImpl.setScout(spChallenge.getScout());
		spChallengeImpl.setLogoId(spChallenge.getLogoId());
		spChallengeImpl.setDraft(spChallenge.isDraft());
		spChallengeImpl.setBudgetCcySign(spChallenge.getBudgetCcySign());
		spChallengeImpl.setBrand(spChallenge.getBrand());
		spChallengeImpl.setVpApprover(spChallenge.getVpApprover());
		spChallengeImpl.setBudgetApprover(spChallenge.getBudgetApprover());

		return spChallengeImpl;
	}

	/**
	 * Returns the s p challenge with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p challenge
	 * @return the s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPChallengeException, SystemException {
		SPChallenge spChallenge = fetchByPrimaryKey(primaryKey);

		if (spChallenge == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPChallengeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spChallenge;
	}

	/**
	 * Returns the s p challenge with the primary key or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException} if it could not be found.
	 *
	 * @param spChallengeId the primary key of the s p challenge
	 * @return the s p challenge
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchSPChallengeException if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge findByPrimaryKey(long spChallengeId)
		throws NoSuchSPChallengeException, SystemException {
		return findByPrimaryKey((Serializable)spChallengeId);
	}

	/**
	 * Returns the s p challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p challenge
	 * @return the s p challenge, or <code>null</code> if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPChallenge spChallenge = (SPChallenge)EntityCacheUtil.getResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
				SPChallengeImpl.class, primaryKey);

		if (spChallenge == _nullSPChallenge) {
			return null;
		}

		if (spChallenge == null) {
			Session session = null;

			try {
				session = openSession();

				spChallenge = (SPChallenge)session.get(SPChallengeImpl.class,
						primaryKey);

				if (spChallenge != null) {
					cacheResult(spChallenge);
				}
				else {
					EntityCacheUtil.putResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
						SPChallengeImpl.class, primaryKey, _nullSPChallenge);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPChallengeModelImpl.ENTITY_CACHE_ENABLED,
					SPChallengeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spChallenge;
	}

	/**
	 * Returns the s p challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spChallengeId the primary key of the s p challenge
	 * @return the s p challenge, or <code>null</code> if a s p challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallenge fetchByPrimaryKey(long spChallengeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spChallengeId);
	}

	/**
	 * Returns all the s p challenges.
	 *
	 * @return the s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @return the range of s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p challenges
	 * @param end the upper bound of the range of s p challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallenge> findAll(int start, int end,
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

		List<SPChallenge> list = (List<SPChallenge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCHALLENGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCHALLENGE;

				if (pagination) {
					sql = sql.concat(SPChallengeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallenge>(list);
				}
				else {
					list = (List<SPChallenge>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p challenges from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPChallenge spChallenge : findAll()) {
			remove(spChallenge);
		}
	}

	/**
	 * Returns the number of s p challenges.
	 *
	 * @return the number of s p challenges
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

				Query q = session.createQuery(_SQL_COUNT_SPCHALLENGE);

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
	 * Initializes the s p challenge persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spchallenge.model.SPChallenge")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPChallenge>> listenersList = new ArrayList<ModelListener<SPChallenge>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPChallenge>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPChallengeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCHALLENGE = "SELECT spChallenge FROM SPChallenge spChallenge";
	private static final String _SQL_SELECT_SPCHALLENGE_WHERE = "SELECT spChallenge FROM SPChallenge spChallenge WHERE ";
	private static final String _SQL_COUNT_SPCHALLENGE = "SELECT COUNT(spChallenge) FROM SPChallenge spChallenge";
	private static final String _SQL_COUNT_SPCHALLENGE_WHERE = "SELECT COUNT(spChallenge) FROM SPChallenge spChallenge WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spChallenge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPChallenge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPChallenge exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPChallengePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type", "active"
			});
	private static SPChallenge _nullSPChallenge = new SPChallengeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPChallenge> toCacheModel() {
				return _nullSPChallengeCacheModel;
			}
		};

	private static CacheModel<SPChallenge> _nullSPChallengeCacheModel = new CacheModel<SPChallenge>() {
			@Override
			public SPChallenge toEntityModel() {
				return _nullSPChallenge;
			}
		};
}