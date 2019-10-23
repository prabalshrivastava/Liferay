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

import com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.impl.LitigationImpl;
import com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the litigation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see LitigationPersistence
 * @see LitigationUtil
 * @generated
 */
public class LitigationPersistenceImpl extends BasePersistenceImpl<Litigation>
	implements LitigationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LitigationUtil} to access the litigation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LitigationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LitigationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the litigations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the litigations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @return the range of matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the litigations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid(String uuid, int start, int end,
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

		List<Litigation> list = (List<Litigation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Litigation litigation : list) {
				if (!Validator.equals(uuid, litigation.getUuid())) {
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

			query.append(_SQL_SELECT_LITIGATION_WHERE);

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
				query.append(LitigationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Litigation>(list);
				}
				else {
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first litigation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByUuid_First(uuid, orderByComparator);

		if (litigation != null) {
			return litigation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLitigationException(msg.toString());
	}

	/**
	 * Returns the first litigation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Litigation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last litigation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByUuid_Last(uuid, orderByComparator);

		if (litigation != null) {
			return litigation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLitigationException(msg.toString());
	}

	/**
	 * Returns the last litigation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Litigation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the litigations before and after the current litigation in the ordered set where uuid = &#63;.
	 *
	 * @param spLitigationId the primary key of the current litigation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation[] findByUuid_PrevAndNext(long spLitigationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = findByPrimaryKey(spLitigationId);

		Session session = null;

		try {
			session = openSession();

			Litigation[] array = new LitigationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, litigation, uuid,
					orderByComparator, true);

			array[1] = litigation;

			array[2] = getByUuid_PrevAndNext(session, litigation, uuid,
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

	protected Litigation getByUuid_PrevAndNext(Session session,
		Litigation litigation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LITIGATION_WHERE);

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
			query.append(LitigationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(litigation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Litigation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the litigations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Litigation litigation : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(litigation);
		}
	}

	/**
	 * Returns the number of litigations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching litigations
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

			query.append(_SQL_COUNT_LITIGATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "litigation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "litigation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(litigation.uuid IS NULL OR litigation.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LitigationModelImpl.UUID_COLUMN_BITMASK |
			LitigationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the litigation where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByUUID_G(String uuid, long groupId)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByUUID_G(uuid, groupId);

		if (litigation == null) {
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

			throw new NoSuchLitigationException(msg.toString());
		}

		return litigation;
	}

	/**
	 * Returns the litigation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the litigation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Litigation) {
			Litigation litigation = (Litigation)result;

			if (!Validator.equals(uuid, litigation.getUuid()) ||
					(groupId != litigation.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LITIGATION_WHERE);

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

				List<Litigation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Litigation litigation = list.get(0);

					result = litigation;

					cacheResult(litigation);

					if ((litigation.getUuid() == null) ||
							!litigation.getUuid().equals(uuid) ||
							(litigation.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, litigation);
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
			return (Litigation)result;
		}
	}

	/**
	 * Removes the litigation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the litigation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation removeByUUID_G(String uuid, long groupId)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = findByUUID_G(uuid, groupId);

		return remove(litigation);
	}

	/**
	 * Returns the number of litigations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching litigations
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

			query.append(_SQL_COUNT_LITIGATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "litigation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "litigation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(litigation.uuid IS NULL OR litigation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "litigation.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, LitigationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LitigationModelImpl.UUID_COLUMN_BITMASK |
			LitigationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the litigations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the litigations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @return the range of matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the litigations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findByUuid_C(String uuid, long companyId,
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

		List<Litigation> list = (List<Litigation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Litigation litigation : list) {
				if (!Validator.equals(uuid, litigation.getUuid()) ||
						(companyId != litigation.getCompanyId())) {
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

			query.append(_SQL_SELECT_LITIGATION_WHERE);

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
				query.append(LitigationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Litigation>(list);
				}
				else {
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (litigation != null) {
			return litigation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLitigationException(msg.toString());
	}

	/**
	 * Returns the first litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Litigation> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (litigation != null) {
			return litigation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLitigationException(msg.toString());
	}

	/**
	 * Returns the last litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching litigation, or <code>null</code> if a matching litigation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Litigation> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the litigations before and after the current litigation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spLitigationId the primary key of the current litigation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation[] findByUuid_C_PrevAndNext(long spLitigationId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = findByPrimaryKey(spLitigationId);

		Session session = null;

		try {
			session = openSession();

			Litigation[] array = new LitigationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, litigation, uuid,
					companyId, orderByComparator, true);

			array[1] = litigation;

			array[2] = getByUuid_C_PrevAndNext(session, litigation, uuid,
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

	protected Litigation getByUuid_C_PrevAndNext(Session session,
		Litigation litigation, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LITIGATION_WHERE);

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
			query.append(LitigationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(litigation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Litigation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the litigations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Litigation litigation : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(litigation);
		}
	}

	/**
	 * Returns the number of litigations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching litigations
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

			query.append(_SQL_COUNT_LITIGATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "litigation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "litigation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(litigation.uuid IS NULL OR litigation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "litigation.companyId = ?";

	public LitigationPersistenceImpl() {
		setModelClass(Litigation.class);
	}

	/**
	 * Caches the litigation in the entity cache if it is enabled.
	 *
	 * @param litigation the litigation
	 */
	@Override
	public void cacheResult(Litigation litigation) {
		EntityCacheUtil.putResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationImpl.class, litigation.getPrimaryKey(), litigation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { litigation.getUuid(), litigation.getGroupId() },
			litigation);

		litigation.resetOriginalValues();
	}

	/**
	 * Caches the litigations in the entity cache if it is enabled.
	 *
	 * @param litigations the litigations
	 */
	@Override
	public void cacheResult(List<Litigation> litigations) {
		for (Litigation litigation : litigations) {
			if (EntityCacheUtil.getResult(
						LitigationModelImpl.ENTITY_CACHE_ENABLED,
						LitigationImpl.class, litigation.getPrimaryKey()) == null) {
				cacheResult(litigation);
			}
			else {
				litigation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all litigations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LitigationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LitigationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the litigation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Litigation litigation) {
		EntityCacheUtil.removeResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationImpl.class, litigation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(litigation);
	}

	@Override
	public void clearCache(List<Litigation> litigations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Litigation litigation : litigations) {
			EntityCacheUtil.removeResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
				LitigationImpl.class, litigation.getPrimaryKey());

			clearUniqueFindersCache(litigation);
		}
	}

	protected void cacheUniqueFindersCache(Litigation litigation) {
		if (litigation.isNew()) {
			Object[] args = new Object[] {
					litigation.getUuid(), litigation.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				litigation);
		}
		else {
			LitigationModelImpl litigationModelImpl = (LitigationModelImpl)litigation;

			if ((litigationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						litigation.getUuid(), litigation.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					litigation);
			}
		}
	}

	protected void clearUniqueFindersCache(Litigation litigation) {
		LitigationModelImpl litigationModelImpl = (LitigationModelImpl)litigation;

		Object[] args = new Object[] {
				litigation.getUuid(), litigation.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((litigationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					litigationModelImpl.getOriginalUuid(),
					litigationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new litigation with the primary key. Does not add the litigation to the database.
	 *
	 * @param spLitigationId the primary key for the new litigation
	 * @return the new litigation
	 */
	@Override
	public Litigation create(long spLitigationId) {
		Litigation litigation = new LitigationImpl();

		litigation.setNew(true);
		litigation.setPrimaryKey(spLitigationId);

		String uuid = PortalUUIDUtil.generate();

		litigation.setUuid(uuid);

		return litigation;
	}

	/**
	 * Removes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spLitigationId the primary key of the litigation
	 * @return the litigation that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation remove(long spLitigationId)
		throws NoSuchLitigationException, SystemException {
		return remove((Serializable)spLitigationId);
	}

	/**
	 * Removes the litigation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the litigation
	 * @return the litigation that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation remove(Serializable primaryKey)
		throws NoSuchLitigationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Litigation litigation = (Litigation)session.get(LitigationImpl.class,
					primaryKey);

			if (litigation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLitigationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(litigation);
		}
		catch (NoSuchLitigationException nsee) {
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
	protected Litigation removeImpl(Litigation litigation)
		throws SystemException {
		litigation = toUnwrappedModel(litigation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(litigation)) {
				litigation = (Litigation)session.get(LitigationImpl.class,
						litigation.getPrimaryKeyObj());
			}

			if (litigation != null) {
				session.delete(litigation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (litigation != null) {
			clearCache(litigation);
		}

		return litigation;
	}

	@Override
	public Litigation updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Litigation litigation)
		throws SystemException {
		litigation = toUnwrappedModel(litigation);

		boolean isNew = litigation.isNew();

		LitigationModelImpl litigationModelImpl = (LitigationModelImpl)litigation;

		if (Validator.isNull(litigation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			litigation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (litigation.isNew()) {
				session.save(litigation);

				litigation.setNew(false);
			}
			else {
				session.merge(litigation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LitigationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((litigationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						litigationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { litigationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((litigationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						litigationModelImpl.getOriginalUuid(),
						litigationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						litigationModelImpl.getUuid(),
						litigationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
			LitigationImpl.class, litigation.getPrimaryKey(), litigation);

		clearUniqueFindersCache(litigation);
		cacheUniqueFindersCache(litigation);

		return litigation;
	}

	protected Litigation toUnwrappedModel(Litigation litigation) {
		if (litigation instanceof LitigationImpl) {
			return litigation;
		}

		LitigationImpl litigationImpl = new LitigationImpl();

		litigationImpl.setNew(litigation.isNew());
		litigationImpl.setPrimaryKey(litigation.getPrimaryKey());

		litigationImpl.setUuid(litigation.getUuid());
		litigationImpl.setSpLitigationId(litigation.getSpLitigationId());
		litigationImpl.setGroupId(litigation.getGroupId());
		litigationImpl.setCompanyId(litigation.getCompanyId());
		litigationImpl.setUserId(litigation.getUserId());
		litigationImpl.setUserName(litigation.getUserName());
		litigationImpl.setCreateDate(litigation.getCreateDate());
		litigationImpl.setModifiedDate(litigation.getModifiedDate());
		litigationImpl.setCountry(litigation.getCountry());
		litigationImpl.setFiledBy(litigation.getFiledBy());
		litigationImpl.setFiledOn(litigation.getFiledOn());
		litigationImpl.setFiledAtCountry(litigation.getFiledAtCountry());
		litigationImpl.setClaimsRemarks(litigation.getClaimsRemarks());
		litigationImpl.setResponseDeadline(litigation.getResponseDeadline());
		litigationImpl.setActualResponseDate(litigation.getActualResponseDate());
		litigationImpl.setStatus(litigation.getStatus());
		litigationImpl.setCustomField1(litigation.getCustomField1());
		litigationImpl.setCustomField2(litigation.getCustomField2());
		litigationImpl.setCustomField3(litigation.getCustomField3());
		litigationImpl.setCustomDate1(litigation.getCustomDate1());
		litigationImpl.setCustomDate2(litigation.getCustomDate2());
		litigationImpl.setCustomDate3(litigation.getCustomDate3());
		litigationImpl.setLegalConfRemarks(litigation.getLegalConfRemarks());
		litigationImpl.setVersion(litigation.getVersion());
		litigationImpl.setSpTrademarksId(litigation.getSpTrademarksId());
		litigationImpl.setRootSpLitigationId(litigation.getRootSpLitigationId());

		return litigationImpl;
	}

	/**
	 * Returns the litigation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the litigation
	 * @return the litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLitigationException, SystemException {
		Litigation litigation = fetchByPrimaryKey(primaryKey);

		if (litigation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLitigationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return litigation;
	}

	/**
	 * Returns the litigation with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException} if it could not be found.
	 *
	 * @param spLitigationId the primary key of the litigation
	 * @return the litigation
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchLitigationException if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation findByPrimaryKey(long spLitigationId)
		throws NoSuchLitigationException, SystemException {
		return findByPrimaryKey((Serializable)spLitigationId);
	}

	/**
	 * Returns the litigation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the litigation
	 * @return the litigation, or <code>null</code> if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Litigation litigation = (Litigation)EntityCacheUtil.getResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
				LitigationImpl.class, primaryKey);

		if (litigation == _nullLitigation) {
			return null;
		}

		if (litigation == null) {
			Session session = null;

			try {
				session = openSession();

				litigation = (Litigation)session.get(LitigationImpl.class,
						primaryKey);

				if (litigation != null) {
					cacheResult(litigation);
				}
				else {
					EntityCacheUtil.putResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
						LitigationImpl.class, primaryKey, _nullLitigation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LitigationModelImpl.ENTITY_CACHE_ENABLED,
					LitigationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return litigation;
	}

	/**
	 * Returns the litigation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spLitigationId the primary key of the litigation
	 * @return the litigation, or <code>null</code> if a litigation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Litigation fetchByPrimaryKey(long spLitigationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spLitigationId);
	}

	/**
	 * Returns all the litigations.
	 *
	 * @return the litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the litigations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @return the range of litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the litigations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.LitigationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of litigations
	 * @param end the upper bound of the range of litigations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of litigations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Litigation> findAll(int start, int end,
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

		List<Litigation> list = (List<Litigation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LITIGATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LITIGATION;

				if (pagination) {
					sql = sql.concat(LitigationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Litigation>(list);
				}
				else {
					list = (List<Litigation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the litigations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Litigation litigation : findAll()) {
			remove(litigation);
		}
	}

	/**
	 * Returns the number of litigations.
	 *
	 * @return the number of litigations
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

				Query q = session.createQuery(_SQL_COUNT_LITIGATION);

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
	 * Initializes the litigation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.legalandcontract.model.Litigation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Litigation>> listenersList = new ArrayList<ModelListener<Litigation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Litigation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LitigationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LITIGATION = "SELECT litigation FROM Litigation litigation";
	private static final String _SQL_SELECT_LITIGATION_WHERE = "SELECT litigation FROM Litigation litigation WHERE ";
	private static final String _SQL_COUNT_LITIGATION = "SELECT COUNT(litigation) FROM Litigation litigation";
	private static final String _SQL_COUNT_LITIGATION_WHERE = "SELECT COUNT(litigation) FROM Litigation litigation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "litigation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Litigation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Litigation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LitigationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Litigation _nullLitigation = new LitigationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Litigation> toCacheModel() {
				return _nullLitigationCacheModel;
			}
		};

	private static CacheModel<Litigation> _nullLitigationCacheModel = new CacheModel<Litigation>() {
			@Override
			public Litigation toEntityModel() {
				return _nullLitigation;
			}
		};
}