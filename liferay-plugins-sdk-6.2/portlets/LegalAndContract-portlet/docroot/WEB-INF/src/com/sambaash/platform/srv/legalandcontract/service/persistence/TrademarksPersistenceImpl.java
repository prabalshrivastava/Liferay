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

import com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksImpl;
import com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the trademarks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see TrademarksPersistence
 * @see TrademarksUtil
 * @generated
 */
public class TrademarksPersistenceImpl extends BasePersistenceImpl<Trademarks>
	implements TrademarksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TrademarksUtil} to access the trademarks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TrademarksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TrademarksModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the trademarkses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trademarkses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @return the range of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trademarkses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid(String uuid, int start, int end,
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

		List<Trademarks> list = (List<Trademarks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Trademarks trademarks : list) {
				if (!Validator.equals(uuid, trademarks.getUuid())) {
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

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

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
				query.append(TrademarksModelImpl.ORDER_BY_JPQL);
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
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Trademarks>(list);
				}
				else {
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trademarks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByUuid_First(uuid, orderByComparator);

		if (trademarks != null) {
			return trademarks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrademarksException(msg.toString());
	}

	/**
	 * Returns the first trademarks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Trademarks> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trademarks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByUuid_Last(uuid, orderByComparator);

		if (trademarks != null) {
			return trademarks;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrademarksException(msg.toString());
	}

	/**
	 * Returns the last trademarks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Trademarks> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trademarkses before and after the current trademarks in the ordered set where uuid = &#63;.
	 *
	 * @param spTrademarksId the primary key of the current trademarks
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks[] findByUuid_PrevAndNext(long spTrademarksId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByPrimaryKey(spTrademarksId);

		Session session = null;

		try {
			session = openSession();

			Trademarks[] array = new TrademarksImpl[3];

			array[0] = getByUuid_PrevAndNext(session, trademarks, uuid,
					orderByComparator, true);

			array[1] = trademarks;

			array[2] = getByUuid_PrevAndNext(session, trademarks, uuid,
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

	protected Trademarks getByUuid_PrevAndNext(Session session,
		Trademarks trademarks, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRADEMARKS_WHERE);

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
			query.append(TrademarksModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(trademarks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Trademarks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trademarkses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Trademarks trademarks : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(trademarks);
		}
	}

	/**
	 * Returns the number of trademarkses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trademarkses
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

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "trademarks.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "trademarks.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(trademarks.uuid IS NULL OR trademarks.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			TrademarksModelImpl.UUID_COLUMN_BITMASK |
			TrademarksModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the trademarks where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByUUID_G(String uuid, long groupId)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByUUID_G(uuid, groupId);

		if (trademarks == null) {
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

			throw new NoSuchTrademarksException(msg.toString());
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trademarks where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Trademarks) {
			Trademarks trademarks = (Trademarks)result;

			if (!Validator.equals(uuid, trademarks.getUuid()) ||
					(groupId != trademarks.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

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

				List<Trademarks> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Trademarks trademarks = list.get(0);

					result = trademarks;

					cacheResult(trademarks);

					if ((trademarks.getUuid() == null) ||
							!trademarks.getUuid().equals(uuid) ||
							(trademarks.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, trademarks);
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
			return (Trademarks)result;
		}
	}

	/**
	 * Removes the trademarks where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trademarks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks removeByUUID_G(String uuid, long groupId)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByUUID_G(uuid, groupId);

		return remove(trademarks);
	}

	/**
	 * Returns the number of trademarkses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trademarkses
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

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "trademarks.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "trademarks.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(trademarks.uuid IS NULL OR trademarks.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "trademarks.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			TrademarksModelImpl.UUID_COLUMN_BITMASK |
			TrademarksModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the trademarkses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trademarkses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @return the range of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trademarkses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findByUuid_C(String uuid, long companyId,
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

		List<Trademarks> list = (List<Trademarks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Trademarks trademarks : list) {
				if (!Validator.equals(uuid, trademarks.getUuid()) ||
						(companyId != trademarks.getCompanyId())) {
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

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

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
				query.append(TrademarksModelImpl.ORDER_BY_JPQL);
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
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Trademarks>(list);
				}
				else {
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (trademarks != null) {
			return trademarks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrademarksException(msg.toString());
	}

	/**
	 * Returns the first trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Trademarks> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (trademarks != null) {
			return trademarks;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrademarksException(msg.toString());
	}

	/**
	 * Returns the last trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Trademarks> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trademarkses before and after the current trademarks in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spTrademarksId the primary key of the current trademarks
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks[] findByUuid_C_PrevAndNext(long spTrademarksId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByPrimaryKey(spTrademarksId);

		Session session = null;

		try {
			session = openSession();

			Trademarks[] array = new TrademarksImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, trademarks, uuid,
					companyId, orderByComparator, true);

			array[1] = trademarks;

			array[2] = getByUuid_C_PrevAndNext(session, trademarks, uuid,
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

	protected Trademarks getByUuid_C_PrevAndNext(Session session,
		Trademarks trademarks, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TRADEMARKS_WHERE);

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
			query.append(TrademarksModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(trademarks);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Trademarks> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trademarkses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Trademarks trademarks : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(trademarks);
		}
	}

	/**
	 * Returns the number of trademarkses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trademarkses
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

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "trademarks.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "trademarks.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(trademarks.uuid IS NULL OR trademarks.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "trademarks.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY =
		new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRegistrationNumberCountry",
			new String[] { String.class.getName(), String.class.getName() },
			TrademarksModelImpl.REGISTRATIONNUMBER_COLUMN_BITMASK |
			TrademarksModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY =
		new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRegistrationNumberCountry",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the trademarks where registrationNumber = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	 *
	 * @param registrationNumber the registration number
	 * @param country the country
	 * @return the matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByRegistrationNumberCountry(
		String registrationNumber, String country)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByRegistrationNumberCountry(registrationNumber,
				country);

		if (trademarks == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("registrationNumber=");
			msg.append(registrationNumber);

			msg.append(", country=");
			msg.append(country);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrademarksException(msg.toString());
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks where registrationNumber = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param registrationNumber the registration number
	 * @param country the country
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByRegistrationNumberCountry(
		String registrationNumber, String country) throws SystemException {
		return fetchByRegistrationNumberCountry(registrationNumber, country,
			true);
	}

	/**
	 * Returns the trademarks where registrationNumber = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param registrationNumber the registration number
	 * @param country the country
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByRegistrationNumberCountry(
		String registrationNumber, String country, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { registrationNumber, country };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
					finderArgs, this);
		}

		if (result instanceof Trademarks) {
			Trademarks trademarks = (Trademarks)result;

			if (!Validator.equals(registrationNumber,
						trademarks.getRegistrationNumber()) ||
					!Validator.equals(country, trademarks.getCountry())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

			boolean bindRegistrationNumber = false;

			if (registrationNumber == null) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_1);
			}
			else if (registrationNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_3);
			}
			else {
				bindRegistrationNumber = true;

				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegistrationNumber) {
					qPos.add(registrationNumber);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				List<Trademarks> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TrademarksPersistenceImpl.fetchByRegistrationNumberCountry(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Trademarks trademarks = list.get(0);

					result = trademarks;

					cacheResult(trademarks);

					if ((trademarks.getRegistrationNumber() == null) ||
							!trademarks.getRegistrationNumber()
										   .equals(registrationNumber) ||
							(trademarks.getCountry() == null) ||
							!trademarks.getCountry().equals(country)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
							finderArgs, trademarks);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
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
			return (Trademarks)result;
		}
	}

	/**
	 * Removes the trademarks where registrationNumber = &#63; and country = &#63; from the database.
	 *
	 * @param registrationNumber the registration number
	 * @param country the country
	 * @return the trademarks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks removeByRegistrationNumberCountry(
		String registrationNumber, String country)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByRegistrationNumberCountry(registrationNumber,
				country);

		return remove(trademarks);
	}

	/**
	 * Returns the number of trademarkses where registrationNumber = &#63; and country = &#63;.
	 *
	 * @param registrationNumber the registration number
	 * @param country the country
	 * @return the number of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegistrationNumberCountry(String registrationNumber,
		String country) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY;

		Object[] finderArgs = new Object[] { registrationNumber, country };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

			boolean bindRegistrationNumber = false;

			if (registrationNumber == null) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_1);
			}
			else if (registrationNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_3);
			}
			else {
				bindRegistrationNumber = true;

				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegistrationNumber) {
					qPos.add(registrationNumber);
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

	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_1 =
		"trademarks.registrationNumber IS NULL AND ";
	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_2 =
		"trademarks.registrationNumber = ? AND ";
	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_REGISTRATIONNUMBER_3 =
		"(trademarks.registrationNumber IS NULL OR trademarks.registrationNumber = '') AND ";
	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_1 =
		"trademarks.country IS NULL";
	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_2 =
		"trademarks.country = ?";
	private static final String _FINDER_COLUMN_REGISTRATIONNUMBERCOUNTRY_COUNTRY_3 =
		"(trademarks.country IS NULL OR trademarks.country = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNoCountry",
			new String[] { String.class.getName(), String.class.getName() },
			TrademarksModelImpl.APPLICATIONNO_COLUMN_BITMASK |
			TrademarksModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY = new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNoCountry",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @return the matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByApplicationNoCountry(String applicationNo,
		String country) throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByApplicationNoCountry(applicationNo,
				country);

		if (trademarks == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("applicationNo=");
			msg.append(applicationNo);

			msg.append(", country=");
			msg.append(country);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrademarksException(msg.toString());
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByApplicationNoCountry(String applicationNo,
		String country) throws SystemException {
		return fetchByApplicationNoCountry(applicationNo, country, true);
	}

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByApplicationNoCountry(String applicationNo,
		String country, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { applicationNo, country };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
					finderArgs, this);
		}

		if (result instanceof Trademarks) {
			Trademarks trademarks = (Trademarks)result;

			if (!Validator.equals(applicationNo, trademarks.getApplicationNo()) ||
					!Validator.equals(country, trademarks.getCountry())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_1);
			}
			else if (applicationNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationNo) {
					qPos.add(applicationNo);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				List<Trademarks> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TrademarksPersistenceImpl.fetchByApplicationNoCountry(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Trademarks trademarks = list.get(0);

					result = trademarks;

					cacheResult(trademarks);

					if ((trademarks.getApplicationNo() == null) ||
							!trademarks.getApplicationNo().equals(applicationNo) ||
							(trademarks.getCountry() == null) ||
							!trademarks.getCountry().equals(country)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
							finderArgs, trademarks);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
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
			return (Trademarks)result;
		}
	}

	/**
	 * Removes the trademarks where applicationNo = &#63; and country = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @return the trademarks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks removeByApplicationNoCountry(String applicationNo,
		String country) throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByApplicationNoCountry(applicationNo,
				country);

		return remove(trademarks);
	}

	/**
	 * Returns the number of trademarkses where applicationNo = &#63; and country = &#63;.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @return the number of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApplicationNoCountry(String applicationNo, String country)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY;

		Object[] finderArgs = new Object[] { applicationNo, country };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_1);
			}
			else if (applicationNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationNo) {
					qPos.add(applicationNo);
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

	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_1 =
		"trademarks.applicationNo IS NULL AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_2 =
		"trademarks.applicationNo = ? AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_APPLICATIONNO_3 =
		"(trademarks.applicationNo IS NULL OR trademarks.applicationNo = '') AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_1 = "trademarks.country IS NULL";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_2 = "trademarks.country = ?";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRY_COUNTRY_3 = "(trademarks.country IS NULL OR trademarks.country = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION =
		new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, TrademarksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByApplicationNoCountryVersion",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			TrademarksModelImpl.APPLICATIONNO_COLUMN_BITMASK |
			TrademarksModelImpl.COUNTRY_COLUMN_BITMASK |
			TrademarksModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION =
		new FinderPath(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationNoCountryVersion",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param version the version
	 * @return the matching trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByApplicationNoCountryVersion(String applicationNo,
		String country, String version)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByApplicationNoCountryVersion(applicationNo,
				country, version);

		if (trademarks == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("applicationNo=");
			msg.append(applicationNo);

			msg.append(", country=");
			msg.append(country);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTrademarksException(msg.toString());
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param version the version
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByApplicationNoCountryVersion(String applicationNo,
		String country, String version) throws SystemException {
		return fetchByApplicationNoCountryVersion(applicationNo, country,
			version, true);
	}

	/**
	 * Returns the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param version the version
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching trademarks, or <code>null</code> if a matching trademarks could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByApplicationNoCountryVersion(String applicationNo,
		String country, String version, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { applicationNo, country, version };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
					finderArgs, this);
		}

		if (result instanceof Trademarks) {
			Trademarks trademarks = (Trademarks)result;

			if (!Validator.equals(applicationNo, trademarks.getApplicationNo()) ||
					!Validator.equals(country, trademarks.getCountry()) ||
					!Validator.equals(version, trademarks.getVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TRADEMARKS_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_1);
			}
			else if (applicationNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationNo) {
					qPos.add(applicationNo);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				if (bindVersion) {
					qPos.add(version);
				}

				List<Trademarks> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
						finderArgs, list);
				}
				else {
					Trademarks trademarks = list.get(0);

					result = trademarks;

					cacheResult(trademarks);

					if ((trademarks.getApplicationNo() == null) ||
							!trademarks.getApplicationNo().equals(applicationNo) ||
							(trademarks.getCountry() == null) ||
							!trademarks.getCountry().equals(country) ||
							(trademarks.getVersion() == null) ||
							!trademarks.getVersion().equals(version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
							finderArgs, trademarks);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
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
			return (Trademarks)result;
		}
	}

	/**
	 * Removes the trademarks where applicationNo = &#63; and country = &#63; and version = &#63; from the database.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param version the version
	 * @return the trademarks that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks removeByApplicationNoCountryVersion(
		String applicationNo, String country, String version)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = findByApplicationNoCountryVersion(applicationNo,
				country, version);

		return remove(trademarks);
	}

	/**
	 * Returns the number of trademarkses where applicationNo = &#63; and country = &#63; and version = &#63;.
	 *
	 * @param applicationNo the application no
	 * @param country the country
	 * @param version the version
	 * @return the number of matching trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApplicationNoCountryVersion(String applicationNo,
		String country, String version) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION;

		Object[] finderArgs = new Object[] { applicationNo, country, version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TRADEMARKS_WHERE);

			boolean bindApplicationNo = false;

			if (applicationNo == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_1);
			}
			else if (applicationNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_3);
			}
			else {
				bindApplicationNo = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationNo) {
					qPos.add(applicationNo);
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

	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_1 =
		"trademarks.applicationNo IS NULL AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_2 =
		"trademarks.applicationNo = ? AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_APPLICATIONNO_3 =
		"(trademarks.applicationNo IS NULL OR trademarks.applicationNo = '') AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_1 =
		"trademarks.country IS NULL AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_2 =
		"trademarks.country = ? AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_COUNTRY_3 =
		"(trademarks.country IS NULL OR trademarks.country = '') AND ";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_1 =
		"trademarks.version IS NULL";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_2 =
		"trademarks.version = ?";
	private static final String _FINDER_COLUMN_APPLICATIONNOCOUNTRYVERSION_VERSION_3 =
		"(trademarks.version IS NULL OR trademarks.version = '')";

	public TrademarksPersistenceImpl() {
		setModelClass(Trademarks.class);
	}

	/**
	 * Caches the trademarks in the entity cache if it is enabled.
	 *
	 * @param trademarks the trademarks
	 */
	@Override
	public void cacheResult(Trademarks trademarks) {
		EntityCacheUtil.putResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksImpl.class, trademarks.getPrimaryKey(), trademarks);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { trademarks.getUuid(), trademarks.getGroupId() },
			trademarks);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
			new Object[] {
				trademarks.getRegistrationNumber(), trademarks.getCountry()
			}, trademarks);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
			new Object[] { trademarks.getApplicationNo(), trademarks.getCountry() },
			trademarks);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
			new Object[] {
				trademarks.getApplicationNo(), trademarks.getCountry(),
				trademarks.getVersion()
			}, trademarks);

		trademarks.resetOriginalValues();
	}

	/**
	 * Caches the trademarkses in the entity cache if it is enabled.
	 *
	 * @param trademarkses the trademarkses
	 */
	@Override
	public void cacheResult(List<Trademarks> trademarkses) {
		for (Trademarks trademarks : trademarkses) {
			if (EntityCacheUtil.getResult(
						TrademarksModelImpl.ENTITY_CACHE_ENABLED,
						TrademarksImpl.class, trademarks.getPrimaryKey()) == null) {
				cacheResult(trademarks);
			}
			else {
				trademarks.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all trademarkses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TrademarksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TrademarksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the trademarks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Trademarks trademarks) {
		EntityCacheUtil.removeResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksImpl.class, trademarks.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(trademarks);
	}

	@Override
	public void clearCache(List<Trademarks> trademarkses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Trademarks trademarks : trademarkses) {
			EntityCacheUtil.removeResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
				TrademarksImpl.class, trademarks.getPrimaryKey());

			clearUniqueFindersCache(trademarks);
		}
	}

	protected void cacheUniqueFindersCache(Trademarks trademarks) {
		if (trademarks.isNew()) {
			Object[] args = new Object[] {
					trademarks.getUuid(), trademarks.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				trademarks);

			args = new Object[] {
					trademarks.getRegistrationNumber(), trademarks.getCountry()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
				args, trademarks);

			args = new Object[] {
					trademarks.getApplicationNo(), trademarks.getCountry()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
				args, trademarks);

			args = new Object[] {
					trademarks.getApplicationNo(), trademarks.getCountry(),
					trademarks.getVersion()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
				args, trademarks);
		}
		else {
			TrademarksModelImpl trademarksModelImpl = (TrademarksModelImpl)trademarks;

			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarks.getUuid(), trademarks.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					trademarks);
			}

			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarks.getRegistrationNumber(),
						trademarks.getCountry()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
					args, trademarks);
			}

			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarks.getApplicationNo(), trademarks.getCountry()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
					args, trademarks);
			}

			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarks.getApplicationNo(), trademarks.getCountry(),
						trademarks.getVersion()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
					args, trademarks);
			}
		}
	}

	protected void clearUniqueFindersCache(Trademarks trademarks) {
		TrademarksModelImpl trademarksModelImpl = (TrademarksModelImpl)trademarks;

		Object[] args = new Object[] {
				trademarks.getUuid(), trademarks.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((trademarksModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					trademarksModelImpl.getOriginalUuid(),
					trademarksModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				trademarks.getRegistrationNumber(), trademarks.getCountry()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
			args);

		if ((trademarksModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					trademarksModelImpl.getOriginalRegistrationNumber(),
					trademarksModelImpl.getOriginalCountry()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGISTRATIONNUMBERCOUNTRY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGISTRATIONNUMBERCOUNTRY,
				args);
		}

		args = new Object[] {
				trademarks.getApplicationNo(), trademarks.getCountry()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
			args);

		if ((trademarksModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					trademarksModelImpl.getOriginalApplicationNo(),
					trademarksModelImpl.getOriginalCountry()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRY,
				args);
		}

		args = new Object[] {
				trademarks.getApplicationNo(), trademarks.getCountry(),
				trademarks.getVersion()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
			args);

		if ((trademarksModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION.getColumnBitmask()) != 0) {
			args = new Object[] {
					trademarksModelImpl.getOriginalApplicationNo(),
					trademarksModelImpl.getOriginalCountry(),
					trademarksModelImpl.getOriginalVersion()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNOCOUNTRYVERSION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNOCOUNTRYVERSION,
				args);
		}
	}

	/**
	 * Creates a new trademarks with the primary key. Does not add the trademarks to the database.
	 *
	 * @param spTrademarksId the primary key for the new trademarks
	 * @return the new trademarks
	 */
	@Override
	public Trademarks create(long spTrademarksId) {
		Trademarks trademarks = new TrademarksImpl();

		trademarks.setNew(true);
		trademarks.setPrimaryKey(spTrademarksId);

		String uuid = PortalUUIDUtil.generate();

		trademarks.setUuid(uuid);

		return trademarks;
	}

	/**
	 * Removes the trademarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTrademarksId the primary key of the trademarks
	 * @return the trademarks that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks remove(long spTrademarksId)
		throws NoSuchTrademarksException, SystemException {
		return remove((Serializable)spTrademarksId);
	}

	/**
	 * Removes the trademarks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trademarks
	 * @return the trademarks that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks remove(Serializable primaryKey)
		throws NoSuchTrademarksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Trademarks trademarks = (Trademarks)session.get(TrademarksImpl.class,
					primaryKey);

			if (trademarks == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrademarksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(trademarks);
		}
		catch (NoSuchTrademarksException nsee) {
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
	protected Trademarks removeImpl(Trademarks trademarks)
		throws SystemException {
		trademarks = toUnwrappedModel(trademarks);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(trademarks)) {
				trademarks = (Trademarks)session.get(TrademarksImpl.class,
						trademarks.getPrimaryKeyObj());
			}

			if (trademarks != null) {
				session.delete(trademarks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (trademarks != null) {
			clearCache(trademarks);
		}

		return trademarks;
	}

	@Override
	public Trademarks updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.Trademarks trademarks)
		throws SystemException {
		trademarks = toUnwrappedModel(trademarks);

		boolean isNew = trademarks.isNew();

		TrademarksModelImpl trademarksModelImpl = (TrademarksModelImpl)trademarks;

		if (Validator.isNull(trademarks.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			trademarks.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (trademarks.isNew()) {
				session.save(trademarks);

				trademarks.setNew(false);
			}
			else {
				session.merge(trademarks);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TrademarksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarksModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { trademarksModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((trademarksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						trademarksModelImpl.getOriginalUuid(),
						trademarksModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						trademarksModelImpl.getUuid(),
						trademarksModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
			TrademarksImpl.class, trademarks.getPrimaryKey(), trademarks);

		clearUniqueFindersCache(trademarks);
		cacheUniqueFindersCache(trademarks);

		return trademarks;
	}

	protected Trademarks toUnwrappedModel(Trademarks trademarks) {
		if (trademarks instanceof TrademarksImpl) {
			return trademarks;
		}

		TrademarksImpl trademarksImpl = new TrademarksImpl();

		trademarksImpl.setNew(trademarks.isNew());
		trademarksImpl.setPrimaryKey(trademarks.getPrimaryKey());

		trademarksImpl.setUuid(trademarks.getUuid());
		trademarksImpl.setSpTrademarksId(trademarks.getSpTrademarksId());
		trademarksImpl.setGroupId(trademarks.getGroupId());
		trademarksImpl.setCompanyId(trademarks.getCompanyId());
		trademarksImpl.setUserId(trademarks.getUserId());
		trademarksImpl.setUserName(trademarks.getUserName());
		trademarksImpl.setCreateDate(trademarks.getCreateDate());
		trademarksImpl.setModifiedDate(trademarks.getModifiedDate());
		trademarksImpl.setRegistrationNumber(trademarks.getRegistrationNumber());
		trademarksImpl.setApplicationNo(trademarks.getApplicationNo());
		trademarksImpl.setCountry(trademarks.getCountry());
		trademarksImpl.setTrademark(trademarks.getTrademark());
		trademarksImpl.setTrademarkLocalized(trademarks.getTrademarkLocalized());
		trademarksImpl.setRegisteredOwner(trademarks.getRegisteredOwner());
		trademarksImpl.setApplicationDate(trademarks.getApplicationDate());
		trademarksImpl.setFirstRegistrationDate(trademarks.getFirstRegistrationDate());
		trademarksImpl.setRenewalDate(trademarks.getRenewalDate());
		trademarksImpl.setGoodsServices(trademarks.getGoodsServices());
		trademarksImpl.setPendingComments(trademarks.getPendingComments());
		trademarksImpl.setSpAgencyId(trademarks.getSpAgencyId());
		trademarksImpl.setClassDescription(trademarks.getClassDescription());
		trademarksImpl.setLegalConfRemarks(trademarks.getLegalConfRemarks());
		trademarksImpl.setWorkflowStatus(trademarks.getWorkflowStatus());
		trademarksImpl.setCustomField1(trademarks.getCustomField1());
		trademarksImpl.setCustomField2(trademarks.getCustomField2());
		trademarksImpl.setCustomField3(trademarks.getCustomField3());
		trademarksImpl.setCustomDate1(trademarks.getCustomDate1());
		trademarksImpl.setCustomDate2(trademarks.getCustomDate2());
		trademarksImpl.setCustomDate3(trademarks.getCustomDate3());
		trademarksImpl.setClassCodes(trademarks.getClassCodes());
		trademarksImpl.setVersion(trademarks.getVersion());
		trademarksImpl.setTrademarkType(trademarks.getTrademarkType());
		trademarksImpl.setRootSpTrademarksId(trademarks.getRootSpTrademarksId());

		return trademarksImpl;
	}

	/**
	 * Returns the trademarks with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the trademarks
	 * @return the trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrademarksException, SystemException {
		Trademarks trademarks = fetchByPrimaryKey(primaryKey);

		if (trademarks == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrademarksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException} if it could not be found.
	 *
	 * @param spTrademarksId the primary key of the trademarks
	 * @return the trademarks
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchTrademarksException if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks findByPrimaryKey(long spTrademarksId)
		throws NoSuchTrademarksException, SystemException {
		return findByPrimaryKey((Serializable)spTrademarksId);
	}

	/**
	 * Returns the trademarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trademarks
	 * @return the trademarks, or <code>null</code> if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Trademarks trademarks = (Trademarks)EntityCacheUtil.getResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
				TrademarksImpl.class, primaryKey);

		if (trademarks == _nullTrademarks) {
			return null;
		}

		if (trademarks == null) {
			Session session = null;

			try {
				session = openSession();

				trademarks = (Trademarks)session.get(TrademarksImpl.class,
						primaryKey);

				if (trademarks != null) {
					cacheResult(trademarks);
				}
				else {
					EntityCacheUtil.putResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
						TrademarksImpl.class, primaryKey, _nullTrademarks);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TrademarksModelImpl.ENTITY_CACHE_ENABLED,
					TrademarksImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return trademarks;
	}

	/**
	 * Returns the trademarks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spTrademarksId the primary key of the trademarks
	 * @return the trademarks, or <code>null</code> if a trademarks with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Trademarks fetchByPrimaryKey(long spTrademarksId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spTrademarksId);
	}

	/**
	 * Returns all the trademarkses.
	 *
	 * @return the trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trademarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @return the range of trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trademarkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.TrademarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trademarkses
	 * @param end the upper bound of the range of trademarkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trademarkses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Trademarks> findAll(int start, int end,
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

		List<Trademarks> list = (List<Trademarks>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TRADEMARKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TRADEMARKS;

				if (pagination) {
					sql = sql.concat(TrademarksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Trademarks>(list);
				}
				else {
					list = (List<Trademarks>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the trademarkses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Trademarks trademarks : findAll()) {
			remove(trademarks);
		}
	}

	/**
	 * Returns the number of trademarkses.
	 *
	 * @return the number of trademarkses
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

				Query q = session.createQuery(_SQL_COUNT_TRADEMARKS);

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
	 * Initializes the trademarks persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.legalandcontract.model.Trademarks")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Trademarks>> listenersList = new ArrayList<ModelListener<Trademarks>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Trademarks>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TrademarksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TRADEMARKS = "SELECT trademarks FROM Trademarks trademarks";
	private static final String _SQL_SELECT_TRADEMARKS_WHERE = "SELECT trademarks FROM Trademarks trademarks WHERE ";
	private static final String _SQL_COUNT_TRADEMARKS = "SELECT COUNT(trademarks) FROM Trademarks trademarks";
	private static final String _SQL_COUNT_TRADEMARKS_WHERE = "SELECT COUNT(trademarks) FROM Trademarks trademarks WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "trademarks.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Trademarks exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Trademarks exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TrademarksPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Trademarks _nullTrademarks = new TrademarksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Trademarks> toCacheModel() {
				return _nullTrademarksCacheModel;
			}
		};

	private static CacheModel<Trademarks> _nullTrademarksCacheModel = new CacheModel<Trademarks>() {
			@Override
			public Trademarks toEntityModel() {
				return _nullTrademarks;
			}
		};
}