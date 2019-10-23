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

package com.sambaash.platform.srv.processbuilder.service.persistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e process state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatePersistence
 * @see PEProcessStateUtil
 * @generated
 */
public class PEProcessStatePersistenceImpl extends BasePersistenceImpl<PEProcessState>
	implements PEProcessStatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEProcessStateUtil} to access the p e process state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEProcessStateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PEProcessStateModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e process states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid(String uuid, int start, int end,
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

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if (!Validator.equals(uuid, peProcessState.getUuid())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

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
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByUuid_First(uuid,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByUuid_Last(uuid, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByUuid_PrevAndNext(long spPEProcessStateId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peProcessState, uuid,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByUuid_PrevAndNext(session, peProcessState, uuid,
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

	protected PEProcessState getByUuid_PrevAndNext(Session session,
		PEProcessState peProcessState, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEProcessState peProcessState : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e process states
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

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peProcessState.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peProcessState.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peProcessState.uuid IS NULL OR peProcessState.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e process state where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByUUID_G(uuid, groupId);

		if (peProcessState == null) {
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

			throw new NoSuchPEProcessStateException(msg.toString());
		}

		return peProcessState;
	}

	/**
	 * Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e process state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEProcessState) {
			PEProcessState peProcessState = (PEProcessState)result;

			if (!Validator.equals(uuid, peProcessState.getUuid()) ||
					(groupId != peProcessState.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

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

				List<PEProcessState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEProcessState peProcessState = list.get(0);

					result = peProcessState;

					cacheResult(peProcessState);

					if ((peProcessState.getUuid() == null) ||
							!peProcessState.getUuid().equals(uuid) ||
							(peProcessState.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peProcessState);
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
			return (PEProcessState)result;
		}
	}

	/**
	 * Removes the p e process state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e process state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByUUID_G(uuid, groupId);

		return remove(peProcessState);
	}

	/**
	 * Returns the number of p e process states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e process states
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

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peProcessState.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peProcessState.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peProcessState.uuid IS NULL OR peProcessState.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peProcessState.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStateModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByUuid_C(String uuid, long companyId,
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

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if (!Validator.equals(uuid, peProcessState.getUuid()) ||
						(companyId != peProcessState.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

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
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByUuid_C_PrevAndNext(long spPEProcessStateId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peProcessState, uuid,
					companyId, orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByUuid_C_PrevAndNext(session, peProcessState, uuid,
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

	protected PEProcessState getByUuid_C_PrevAndNext(Session session,
		PEProcessState peProcessState, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEProcessState peProcessState : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e process states
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

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peProcessState.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peProcessState.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peProcessState.uuid IS NULL OR peProcessState.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peProcessState.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcess",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserIdProcess",
			new String[] { Long.class.getName() },
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESS = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserIdProcess",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e process states where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcess(long userIdProcess)
		throws SystemException {
		return findByuserIdProcess(userIdProcess, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcess(long userIdProcess,
		int start, int end) throws SystemException {
		return findByuserIdProcess(userIdProcess, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcess(long userIdProcess,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESS;
			finderArgs = new Object[] { userIdProcess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESS;
			finderArgs = new Object[] {
					userIdProcess,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESS_USERIDPROCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcess_First(long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcess_First(userIdProcess,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcess_First(long userIdProcess,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByuserIdProcess(userIdProcess, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcess_Last(long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcess_Last(userIdProcess,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcess_Last(long userIdProcess,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserIdProcess(userIdProcess);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcess(userIdProcess,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcess_PrevAndNext(
		long spPEProcessStateId, long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcess_PrevAndNext(session, peProcessState,
					userIdProcess, orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcess_PrevAndNext(session, peProcessState,
					userIdProcess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessState getByuserIdProcess_PrevAndNext(Session session,
		PEProcessState peProcessState, long userIdProcess,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESS_USERIDPROCESS_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcess(long userIdProcess)
		throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcess(
				userIdProcess, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcess(long userIdProcess)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESS;

		Object[] finderArgs = new Object[] { userIdProcess };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESS_USERIDPROCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

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

	private static final String _FINDER_COLUMN_USERIDPROCESS_USERIDPROCESS_2 = "peProcessState.userIdProcess = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcessPEProcessId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserIdProcessPEProcessId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdProcessPEProcessId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId) throws SystemException {
		return findByuserIdProcessPEProcessId(userIdProcess, spPEProcessId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end)
		throws SystemException {
		return findByuserIdProcessPEProcessId(userIdProcess, spPEProcessId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessId(
		long userIdProcess, long spPEProcessId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID;
			finderArgs = new Object[] { userIdProcess, spPEProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess()) ||
						(spPEProcessId != peProcessState.getSpPEProcessId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_SPPEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessId_First(userIdProcess,
				spPEProcessId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessId_First(
		long userIdProcess, long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByuserIdProcessPEProcessId(userIdProcess,
				spPEProcessId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessId_Last(userIdProcess,
				spPEProcessId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessId_Last(
		long userIdProcess, long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserIdProcessPEProcessId(userIdProcess, spPEProcessId);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcessPEProcessId(userIdProcess,
				spPEProcessId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcessPEProcessId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcessPEProcessId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcessPEProcessId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
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

	protected PEProcessState getByuserIdProcessPEProcessId_PrevAndNext(
		Session session, PEProcessState peProcessState, long userIdProcess,
		long spPEProcessId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_USERIDPROCESS_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_SPPEPROCESSID_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		qPos.add(spPEProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId) throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcessPEProcessId(
				userIdProcess, spPEProcessId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcessPEProcessId(long userIdProcess,
		long spPEProcessId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSID;

		Object[] finderArgs = new Object[] { userIdProcess, spPEProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSID_SPPEPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

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

	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSID_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSID_SPPEPROCESSID_2 =
		"peProcessState.spPEProcessId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPEProcessId",
			new String[] { Long.class.getName() },
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSID = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPEProcessId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e process states where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByPEProcessId(long spPEProcessId)
		throws SystemException {
		return findByPEProcessId(spPEProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByPEProcessId(long spPEProcessId,
		int start, int end) throws SystemException {
		return findByPEProcessId(spPEProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByPEProcessId(long spPEProcessId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSID;
			finderArgs = new Object[] { spPEProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSID;
			finderArgs = new Object[] {
					spPEProcessId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((spPEProcessId != peProcessState.getSpPEProcessId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSID_SPPEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByPEProcessId_First(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByPEProcessId_First(spPEProcessId,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByPEProcessId_First(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByPEProcessId(spPEProcessId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByPEProcessId_Last(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByPEProcessId_Last(spPEProcessId,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByPEProcessId_Last(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPEProcessId(spPEProcessId);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByPEProcessId(spPEProcessId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByPEProcessId_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByPEProcessId_PrevAndNext(session, peProcessState,
					spPEProcessId, orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByPEProcessId_PrevAndNext(session, peProcessState,
					spPEProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessState getByPEProcessId_PrevAndNext(Session session,
		PEProcessState peProcessState, long spPEProcessId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_PEPROCESSID_SPPEPROCESSID_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where spPEProcessId = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessId(long spPEProcessId)
		throws SystemException {
		for (PEProcessState peProcessState : findByPEProcessId(spPEProcessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessId(long spPEProcessId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSID;

		Object[] finderArgs = new Object[] { spPEProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSID_SPPEPROCESSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

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

	private static final String _FINDER_COLUMN_PEPROCESSID_SPPEPROCESSID_2 = "peProcessState.spPEProcessId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcessPEProcessIClassId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserIdProcessPEProcessIClassId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ENTITYCLASSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSICLASSID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdProcessPEProcessIClassId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId)
		throws SystemException {
		return findByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end) throws SystemException {
		return findByuserIdProcessPEProcessIClassId(userIdProcess,
			spPEProcessId, entityClassId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIClassId(
		long userIdProcess, long spPEProcessId, long entityClassId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, entityClassId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, entityClassId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess()) ||
						(spPEProcessId != peProcessState.getSpPEProcessId()) ||
						(entityClassId != peProcessState.getEntityClassId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_ENTITYCLASSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityClassId);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessIClassId_First(userIdProcess,
				spPEProcessId, entityClassId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessIClassId_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByuserIdProcessPEProcessIClassId(userIdProcess,
				spPEProcessId, entityClassId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessIClassId_Last(userIdProcess,
				spPEProcessId, entityClassId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessIClassId_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserIdProcessPEProcessIClassId(userIdProcess,
				spPEProcessId, entityClassId);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcessPEProcessIClassId(userIdProcess,
				spPEProcessId, entityClassId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcessPEProcessIClassId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcessPEProcessIClassId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					entityClassId, orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcessPEProcessIClassId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					entityClassId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessState getByuserIdProcessPEProcessIClassId_PrevAndNext(
		Session session, PEProcessState peProcessState, long userIdProcess,
		long spPEProcessId, long entityClassId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_USERIDPROCESS_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_SPPEPROCESSID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_ENTITYCLASSID_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		qPos.add(spPEProcessId);

		qPos.add(entityClassId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcessPEProcessIClassId(long userIdProcess,
		long spPEProcessId, long entityClassId) throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcessPEProcessIClassId(
				userIdProcess, spPEProcessId, entityClassId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcessPEProcessIClassId(long userIdProcess,
		long spPEProcessId, long entityClassId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSICLASSID;

		Object[] finderArgs = new Object[] {
				userIdProcess, spPEProcessId, entityClassId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_ENTITYCLASSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityClassId);

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

	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_SPPEPROCESSID_2 =
		"peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSICLASSID_ENTITYCLASSID_2 =
		"peProcessState.entityClassId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ENTITYCLASSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ENTITYID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ACTIVESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus) throws SystemException {
		return findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end)
		throws SystemException {
		return findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
			spPEProcessId, entityClassId, entityId, activeStatus, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, entityClassId, entityId,
					activeStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, entityClassId, entityId,
					activeStatus,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess()) ||
						(spPEProcessId != peProcessState.getSpPEProcessId()) ||
						(entityClassId != peProcessState.getEntityClassId()) ||
						(entityId != peProcessState.getEntityId()) ||
						(activeStatus != peProcessState.getActiveStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ACTIVESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(activeStatus);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(userIdProcess,
				spPEProcessId, entityClassId, entityId, activeStatus,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_First(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessState> list = findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
				spPEProcessId, entityClassId, entityId, activeStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(userIdProcess,
				spPEProcessId, entityClassId, entityId, activeStatus,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", entityClassId=");
		msg.append(entityClassId);

		msg.append(", entityId=");
		msg.append(entityId);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
				spPEProcessId, entityClassId, entityId, activeStatus);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(userIdProcess,
				spPEProcessId, entityClassId, entityId, activeStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long entityClassId, long entityId, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					entityClassId, entityId, activeStatus, orderByComparator,
					true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					entityClassId, entityId, activeStatus, orderByComparator,
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

	protected PEProcessState getByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus_PrevAndNext(
		Session session, PEProcessState peProcessState, long userIdProcess,
		long spPEProcessId, long entityClassId, long entityId,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_USERIDPROCESS_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_SPPEPROCESSID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYCLASSID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ACTIVESTATUS_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		qPos.add(spPEProcessId);

		qPos.add(entityClassId);

		qPos.add(entityId);

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus) throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
				userIdProcess, spPEProcessId, entityClassId, entityId,
				activeStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityClassId = &#63; and entityId = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityClassId the entity class ID
	 * @param entityId the entity ID
	 * @param activeStatus the active status
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcessPEProcessIdEntityClassIdEntityIdActiveStatus(
		long userIdProcess, long spPEProcessId, long entityClassId,
		long entityId, int activeStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS;

		Object[] finderArgs = new Object[] {
				userIdProcess, spPEProcessId, entityClassId, entityId,
				activeStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYCLASSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ACTIVESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityClassId);

				qPos.add(entityId);

				qPos.add(activeStatus);

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

	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_SPPEPROCESSID_2 =
		"peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYCLASSID_2 =
		"peProcessState.entityClassId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ENTITYID_2 =
		"peProcessState.entityId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS_ACTIVESTATUS_2 =
		"peProcessState.activeStatus = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSSTATEPK = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByprocessStatePK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ENTITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEPK = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprocessStatePK",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityId the entity ID
	 * @return the matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByprocessStatePK(long userIdProcess,
		long spPEProcessId, long entityId)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByprocessStatePK(userIdProcess,
				spPEProcessId, entityId);

		if (peProcessState == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userIdProcess=");
			msg.append(userIdProcess);

			msg.append(", spPEProcessId=");
			msg.append(spPEProcessId);

			msg.append(", entityId=");
			msg.append(entityId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPEProcessStateException(msg.toString());
		}

		return peProcessState;
	}

	/**
	 * Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityId the entity ID
	 * @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByprocessStatePK(long userIdProcess,
		long spPEProcessId, long entityId) throws SystemException {
		return fetchByprocessStatePK(userIdProcess, spPEProcessId, entityId,
			true);
	}

	/**
	 * Returns the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityId the entity ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByprocessStatePK(long userIdProcess,
		long spPEProcessId, long entityId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				userIdProcess, spPEProcessId, entityId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
					finderArgs, this);
		}

		if (result instanceof PEProcessState) {
			PEProcessState peProcessState = (PEProcessState)result;

			if ((userIdProcess != peProcessState.getUserIdProcess()) ||
					(spPEProcessId != peProcessState.getSpPEProcessId()) ||
					(entityId != peProcessState.getEntityId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_ENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityId);

				List<PEProcessState> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PEProcessStatePersistenceImpl.fetchByprocessStatePK(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PEProcessState peProcessState = list.get(0);

					result = peProcessState;

					cacheResult(peProcessState);

					if ((peProcessState.getUserIdProcess() != userIdProcess) ||
							(peProcessState.getSpPEProcessId() != spPEProcessId) ||
							(peProcessState.getEntityId() != entityId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
							finderArgs, peProcessState);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
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
			return (PEProcessState)result;
		}
	}

	/**
	 * Removes the p e process state where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityId the entity ID
	 * @return the p e process state that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState removeByprocessStatePK(long userIdProcess,
		long spPEProcessId, long entityId)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByprocessStatePK(userIdProcess,
				spPEProcessId, entityId);

		return remove(peProcessState);
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and entityId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param entityId the entity ID
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprocessStatePK(long userIdProcess, long spPEProcessId,
		long entityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEPK;

		Object[] finderArgs = new Object[] {
				userIdProcess, spPEProcessId, entityId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEPK_ENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(entityId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEPK_USERIDPROCESS_2 = "peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEPK_SPPEPROCESSID_2 = "peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEPK_ENTITYID_2 = "peProcessState.entityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATELEAD =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateLead",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATELEAD =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateLead",
			new String[] { Long.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATELEAD = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateLead",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATELEAD =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByProcessStateLead",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long spPEProcessId,
		long userIdProcess) throws SystemException {
		return findByProcessStateLead(spPEProcessId, userIdProcess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long spPEProcessId,
		long userIdProcess, int start, int end) throws SystemException {
		return findByProcessStateLead(spPEProcessId, userIdProcess, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long spPEProcessId,
		long userIdProcess, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATELEAD;
			finderArgs = new Object[] { spPEProcessId, userIdProcess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATELEAD;
			finderArgs = new Object[] {
					spPEProcessId, userIdProcess,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((spPEProcessId != peProcessState.getSpPEProcessId()) ||
						(userIdProcess != peProcessState.getUserIdProcess())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				qPos.add(userIdProcess);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByProcessStateLead_First(long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByProcessStateLead_First(spPEProcessId,
				userIdProcess, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByProcessStateLead_First(long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessState> list = findByProcessStateLead(spPEProcessId,
				userIdProcess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByProcessStateLead_Last(long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByProcessStateLead_Last(spPEProcessId,
				userIdProcess, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByProcessStateLead_Last(long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByProcessStateLead(spPEProcessId, userIdProcess);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByProcessStateLead(spPEProcessId,
				userIdProcess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByProcessStateLead_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByProcessStateLead_PrevAndNext(session,
					peProcessState, spPEProcessId, userIdProcess,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByProcessStateLead_PrevAndNext(session,
					peProcessState, spPEProcessId, userIdProcess,
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

	protected PEProcessState getByProcessStateLead_PrevAndNext(
		Session session, PEProcessState peProcessState, long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessId);

		qPos.add(userIdProcess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long[] spPEProcessIds,
		long userIdProcess) throws SystemException {
		return findByProcessStateLead(spPEProcessIds, userIdProcess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long[] spPEProcessIds,
		long userIdProcess, int start, int end) throws SystemException {
		return findByProcessStateLead(spPEProcessIds, userIdProcess, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateLead(long[] spPEProcessIds,
		long userIdProcess, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((spPEProcessIds != null) && (spPEProcessIds.length == 1)) {
			return findByProcessStateLead(spPEProcessIds[0], userIdProcess,
				start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(spPEProcessIds), userIdProcess
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(spPEProcessIds), userIdProcess,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATELEAD,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if (!ArrayUtil.contains(spPEProcessIds,
							peProcessState.getSpPEProcessId()) ||
						(userIdProcess != peProcessState.getUserIdProcess())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(
				"peProcessState.closedStageId = 0 and (peProcessState.convertedToProcessStateId != null or peProcessState.convertedToProcessStateId = 0) and peProcessState.status != 'Rejected'");

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEProcessIds != null) {
					qPos.add(spPEProcessIds);
				}

				qPos.add(userIdProcess);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATELEAD,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATELEAD,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateLead(long spPEProcessId, long userIdProcess)
		throws SystemException {
		for (PEProcessState peProcessState : findByProcessStateLead(
				spPEProcessId, userIdProcess, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateLead(long spPEProcessId, long userIdProcess)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATELEAD;

		Object[] finderArgs = new Object[] { spPEProcessId, userIdProcess };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				qPos.add(userIdProcess);

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

	/**
	 * Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateLead(long[] spPEProcessIds, long userIdProcess)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(spPEProcessIds), userIdProcess
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATELEAD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(
				"peProcessState.closedStageId = 0 and (peProcessState.convertedToProcessStateId != null or peProcessState.convertedToProcessStateId = 0) and peProcessState.status != 'Rejected'");

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEProcessIds != null) {
					qPos.add(spPEProcessIds);
				}

				qPos.add(userIdProcess);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATELEAD,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATELEAD,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_2 = "peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTATELEAD_SPPEPROCESSID_2) +
		")";
	private static final String _FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_2 = "peProcessState.userIdProcess = ? AND peProcessState.closedStageId = 0 and (peProcessState.convertedToProcessStateId != null or peProcessState.convertedToProcessStateId = 0) and peProcessState.status != 'Rejected'";
	private static final String _FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_5 = "(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTATELEAD_USERIDPROCESS_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateOpportunity",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateOpportunity",
			new String[] { Long.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEOPPORTUNITY = new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateOpportunity",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATEOPPORTUNITY =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByProcessStateOpportunity",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess) throws SystemException {
		return findByProcessStateOpportunity(spPEProcessId, userIdProcess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end)
		throws SystemException {
		return findByProcessStateOpportunity(spPEProcessId, userIdProcess,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long spPEProcessId, long userIdProcess, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY;
			finderArgs = new Object[] { spPEProcessId, userIdProcess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY;
			finderArgs = new Object[] {
					spPEProcessId, userIdProcess,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((spPEProcessId != peProcessState.getSpPEProcessId()) ||
						(userIdProcess != peProcessState.getUserIdProcess())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				qPos.add(userIdProcess);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByProcessStateOpportunity_First(spPEProcessId,
				userIdProcess, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByProcessStateOpportunity_First(
		long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByProcessStateOpportunity(spPEProcessId,
				userIdProcess, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByProcessStateOpportunity_Last(spPEProcessId,
				userIdProcess, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", userIdProcess=");
		msg.append(userIdProcess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByProcessStateOpportunity_Last(
		long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProcessStateOpportunity(spPEProcessId, userIdProcess);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByProcessStateOpportunity(spPEProcessId,
				userIdProcess, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByProcessStateOpportunity_PrevAndNext(
		long spPEProcessStateId, long spPEProcessId, long userIdProcess,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByProcessStateOpportunity_PrevAndNext(session,
					peProcessState, spPEProcessId, userIdProcess,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByProcessStateOpportunity_PrevAndNext(session,
					peProcessState, spPEProcessId, userIdProcess,
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

	protected PEProcessState getByProcessStateOpportunity_PrevAndNext(
		Session session, PEProcessState peProcessState, long spPEProcessId,
		long userIdProcess, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessId);

		qPos.add(userIdProcess);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess) throws SystemException {
		return findByProcessStateOpportunity(spPEProcessIds, userIdProcess,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end)
		throws SystemException {
		return findByProcessStateOpportunity(spPEProcessIds, userIdProcess,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByProcessStateOpportunity(
		long[] spPEProcessIds, long userIdProcess, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((spPEProcessIds != null) && (spPEProcessIds.length == 1)) {
			return findByProcessStateOpportunity(spPEProcessIds[0],
				userIdProcess, start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(spPEProcessIds), userIdProcess
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(spPEProcessIds), userIdProcess,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if (!ArrayUtil.contains(spPEProcessIds,
							peProcessState.getSpPEProcessId()) ||
						(userIdProcess != peProcessState.getUserIdProcess())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(
				"peProcessState.closedStageId = 0 and peProcessState.status != 'Rejected'");

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEProcessIds != null) {
					qPos.add(spPEProcessIds);
				}

				qPos.add(userIdProcess);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p e process states where spPEProcessId = &#63; and userIdProcess = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess) throws SystemException {
		for (PEProcessState peProcessState : findByProcessStateOpportunity(
				spPEProcessId, userIdProcess, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where spPEProcessId = &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param userIdProcess the user ID process
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateOpportunity(long spPEProcessId,
		long userIdProcess) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEOPPORTUNITY;

		Object[] finderArgs = new Object[] { spPEProcessId, userIdProcess };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				qPos.add(userIdProcess);

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

	/**
	 * Returns the number of p e process states where spPEProcessId = any &#63; and userIdProcess = &#63;.
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param userIdProcess the user ID process
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateOpportunity(long[] spPEProcessIds,
		long userIdProcess) throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(spPEProcessIds), userIdProcess
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATEOPPORTUNITY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(
				"peProcessState.closedStageId = 0 and peProcessState.status != 'Rejected'");

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEProcessIds != null) {
					qPos.add(spPEProcessIds);
				}

				qPos.add(userIdProcess);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATEOPPORTUNITY,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PROCESSSTATEOPPORTUNITY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_2 =
		"peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_SPPEPROCESSID_2) +
		")";
	private static final String _FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND peProcessState.closedStageId = 0 and peProcessState.status != 'Rejected'";
	private static final String _FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_PROCESSSTATEOPPORTUNITY_USERIDPROCESS_2) +
		")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcessPEProcessStageId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserIdProcessPEProcessStageId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSSTAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSSTAGEID =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdProcessPEProcessStageId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId) throws SystemException {
		return findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end)
		throws SystemException {
		return findByuserIdProcessPEProcessStageId(userIdProcess,
			spPEProcessStageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessPEProcessStageId(
		long userIdProcess, long spPEProcessStageId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID;
			finderArgs = new Object[] { userIdProcess, spPEProcessStageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessStageId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess()) ||
						(spPEProcessStageId != peProcessState.getSpPEProcessStageId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_SPPEPROCESSSTAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessStageId);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessStageId_First(userIdProcess,
				spPEProcessStageId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessStageId=");
		msg.append(spPEProcessStageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessStageId_First(
		long userIdProcess, long spPEProcessStageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByuserIdProcessPEProcessStageId(userIdProcess,
				spPEProcessStageId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessPEProcessStageId_Last(userIdProcess,
				spPEProcessStageId, orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessStageId=");
		msg.append(spPEProcessStageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessPEProcessStageId_Last(
		long userIdProcess, long spPEProcessStageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserIdProcessPEProcessStageId(userIdProcess,
				spPEProcessStageId);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcessPEProcessStageId(userIdProcess,
				spPEProcessStageId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcessPEProcessStageId_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessStageId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcessPEProcessStageId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessStageId,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcessPEProcessStageId_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessStageId,
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

	protected PEProcessState getByuserIdProcessPEProcessStageId_PrevAndNext(
		Session session, PEProcessState peProcessState, long userIdProcess,
		long spPEProcessStageId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_USERIDPROCESS_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_SPPEPROCESSSTAGEID_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		qPos.add(spPEProcessStageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcessPEProcessStageId(long userIdProcess,
		long spPEProcessStageId) throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcessPEProcessStageId(
				userIdProcess, spPEProcessStageId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessStageId = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessStageId the sp p e process stage ID
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcessPEProcessStageId(long userIdProcess,
		long spPEProcessStageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSSTAGEID;

		Object[] finderArgs = new Object[] { userIdProcess, spPEProcessStageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_SPPEPROCESSSTAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessStageId);

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

	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSPEPROCESSSTAGEID_SPPEPROCESSSTAGEID_2 =
		"peProcessState.spPEProcessStageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			},
			PEProcessStateModelImpl.USERIDPROCESS_COLUMN_BITMASK |
			PEProcessStateModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.SOURCECLASSID_COLUMN_BITMASK |
			PEProcessStateModelImpl.SOURCEENTITYID_COLUMN_BITMASK |
			PEProcessStateModelImpl.ACTIVESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS =
		new FinderPath(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName()
			});

	/**
	 * Returns all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @return the matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus) throws SystemException {
		return findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end)
		throws SystemException {
		return findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
			spPEProcessId, sourceClassId, sourceEntityID, activeStatus, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, sourceClassId, sourceEntityID,
					activeStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS;
			finderArgs = new Object[] {
					userIdProcess, spPEProcessId, sourceClassId, sourceEntityID,
					activeStatus,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessState peProcessState : list) {
				if ((userIdProcess != peProcessState.getUserIdProcess()) ||
						(spPEProcessId != peProcessState.getSpPEProcessId()) ||
						(sourceClassId != peProcessState.getSourceClassId()) ||
						(sourceEntityID != peProcessState.getSourceEntityID()) ||
						(activeStatus != peProcessState.getActiveStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCECLASSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCEENTITYID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_ACTIVESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(sourceClassId);

				qPos.add(sourceEntityID);

				qPos.add(activeStatus);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(userIdProcess,
				spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", sourceClassId=");
		msg.append(sourceClassId);

		msg.append(", sourceEntityID=");
		msg.append(sourceEntityID);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the first p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_First(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessState> list = findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
				spPEProcessId, sourceClassId, sourceEntityID, activeStatus, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(userIdProcess,
				spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
				orderByComparator);

		if (peProcessState != null) {
			return peProcessState;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userIdProcess=");
		msg.append(userIdProcess);

		msg.append(", spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(", sourceClassId=");
		msg.append(sourceClassId);

		msg.append(", sourceEntityID=");
		msg.append(sourceEntityID);

		msg.append(", activeStatus=");
		msg.append(activeStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStateException(msg.toString());
	}

	/**
	 * Returns the last p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process state, or <code>null</code> if a matching p e process state could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_Last(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
				spPEProcessId, sourceClassId, sourceEntityID, activeStatus);

		if (count == 0) {
			return null;
		}

		List<PEProcessState> list = findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(userIdProcess,
				spPEProcessId, sourceClassId, sourceEntityID, activeStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process states before and after the current p e process state in the ordered set where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param spPEProcessStateId the primary key of the current p e process state
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState[] findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(
		long spPEProcessStateId, long userIdProcess, long spPEProcessId,
		long sourceClassId, long sourceEntityID, int activeStatus,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = findByPrimaryKey(spPEProcessStateId);

		Session session = null;

		try {
			session = openSession();

			PEProcessState[] array = new PEProcessStateImpl[3];

			array[0] = getByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					sourceClassId, sourceEntityID, activeStatus,
					orderByComparator, true);

			array[1] = peProcessState;

			array[2] = getByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(session,
					peProcessState, userIdProcess, spPEProcessId,
					sourceClassId, sourceEntityID, activeStatus,
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

	protected PEProcessState getByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus_PrevAndNext(
		Session session, PEProcessState peProcessState, long userIdProcess,
		long spPEProcessId, long sourceClassId, long sourceEntityID,
		int activeStatus, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATE_WHERE);

		query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_USERIDPROCESS_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SPPEPROCESSID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCECLASSID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCEENTITYID_2);

		query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_ACTIVESTATUS_2);

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
			query.append(PEProcessStateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdProcess);

		qPos.add(spPEProcessId);

		qPos.add(sourceClassId);

		qPos.add(sourceEntityID);

		qPos.add(activeStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessState);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessState> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63; from the database.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus) throws SystemException {
		for (PEProcessState peProcessState : findByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
				userIdProcess, spPEProcessId, sourceClassId, sourceEntityID,
				activeStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states where userIdProcess = &#63; and spPEProcessId = &#63; and sourceClassId = &#63; and sourceEntityID = &#63; and activeStatus = &#63;.
	 *
	 * @param userIdProcess the user ID process
	 * @param spPEProcessId the sp p e process ID
	 * @param sourceClassId the source class ID
	 * @param sourceEntityID the source entity i d
	 * @param activeStatus the active status
	 * @return the number of matching p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserIdProcessAndPEProcessIdAndSourceClassIdAndSourceEntityIDAndActiveStatus(
		long userIdProcess, long spPEProcessId, long sourceClassId,
		long sourceEntityID, int activeStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS;

		Object[] finderArgs = new Object[] {
				userIdProcess, spPEProcessId, sourceClassId, sourceEntityID,
				activeStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_PEPROCESSSTATE_WHERE);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_USERIDPROCESS_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SPPEPROCESSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCECLASSID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCEENTITYID_2);

			query.append(_FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_ACTIVESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdProcess);

				qPos.add(spPEProcessId);

				qPos.add(sourceClassId);

				qPos.add(sourceEntityID);

				qPos.add(activeStatus);

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

	private static final String _FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_USERIDPROCESS_2 =
		"peProcessState.userIdProcess = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SPPEPROCESSID_2 =
		"peProcessState.spPEProcessId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCECLASSID_2 =
		"peProcessState.sourceClassId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_SOURCEENTITYID_2 =
		"peProcessState.sourceEntityID = ? AND ";
	private static final String _FINDER_COLUMN_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS_ACTIVESTATUS_2 =
		"peProcessState.activeStatus = ?";

	public PEProcessStatePersistenceImpl() {
		setModelClass(PEProcessState.class);
	}

	/**
	 * Caches the p e process state in the entity cache if it is enabled.
	 *
	 * @param peProcessState the p e process state
	 */
	@Override
	public void cacheResult(PEProcessState peProcessState) {
		EntityCacheUtil.putResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateImpl.class, peProcessState.getPrimaryKey(),
			peProcessState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peProcessState.getUuid(), peProcessState.getGroupId() },
			peProcessState);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
			new Object[] {
				peProcessState.getUserIdProcess(),
				peProcessState.getSpPEProcessId(), peProcessState.getEntityId()
			}, peProcessState);

		peProcessState.resetOriginalValues();
	}

	/**
	 * Caches the p e process states in the entity cache if it is enabled.
	 *
	 * @param peProcessStates the p e process states
	 */
	@Override
	public void cacheResult(List<PEProcessState> peProcessStates) {
		for (PEProcessState peProcessState : peProcessStates) {
			if (EntityCacheUtil.getResult(
						PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStateImpl.class, peProcessState.getPrimaryKey()) == null) {
				cacheResult(peProcessState);
			}
			else {
				peProcessState.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e process states.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEProcessStateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEProcessStateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e process state.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEProcessState peProcessState) {
		EntityCacheUtil.removeResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateImpl.class, peProcessState.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peProcessState);
	}

	@Override
	public void clearCache(List<PEProcessState> peProcessStates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEProcessState peProcessState : peProcessStates) {
			EntityCacheUtil.removeResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStateImpl.class, peProcessState.getPrimaryKey());

			clearUniqueFindersCache(peProcessState);
		}
	}

	protected void cacheUniqueFindersCache(PEProcessState peProcessState) {
		if (peProcessState.isNew()) {
			Object[] args = new Object[] {
					peProcessState.getUuid(), peProcessState.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peProcessState);

			args = new Object[] {
					peProcessState.getUserIdProcess(),
					peProcessState.getSpPEProcessId(),
					peProcessState.getEntityId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
				args, peProcessState);
		}
		else {
			PEProcessStateModelImpl peProcessStateModelImpl = (PEProcessStateModelImpl)peProcessState;

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessState.getUuid(), peProcessState.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peProcessState);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROCESSSTATEPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessState.getUserIdProcess(),
						peProcessState.getSpPEProcessId(),
						peProcessState.getEntityId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
					args, peProcessState);
			}
		}
	}

	protected void clearUniqueFindersCache(PEProcessState peProcessState) {
		PEProcessStateModelImpl peProcessStateModelImpl = (PEProcessStateModelImpl)peProcessState;

		Object[] args = new Object[] {
				peProcessState.getUuid(), peProcessState.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peProcessStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessStateModelImpl.getOriginalUuid(),
					peProcessStateModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				peProcessState.getUserIdProcess(),
				peProcessState.getSpPEProcessId(), peProcessState.getEntityId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEPK, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK, args);

		if ((peProcessStateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSSTATEPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessStateModelImpl.getOriginalUserIdProcess(),
					peProcessStateModelImpl.getOriginalSpPEProcessId(),
					peProcessStateModelImpl.getOriginalEntityId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEPK,
				args);
		}
	}

	/**
	 * Creates a new p e process state with the primary key. Does not add the p e process state to the database.
	 *
	 * @param spPEProcessStateId the primary key for the new p e process state
	 * @return the new p e process state
	 */
	@Override
	public PEProcessState create(long spPEProcessStateId) {
		PEProcessState peProcessState = new PEProcessStateImpl();

		peProcessState.setNew(true);
		peProcessState.setPrimaryKey(spPEProcessStateId);

		String uuid = PortalUUIDUtil.generate();

		peProcessState.setUuid(uuid);

		return peProcessState;
	}

	/**
	 * Removes the p e process state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessStateId the primary key of the p e process state
	 * @return the p e process state that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState remove(long spPEProcessStateId)
		throws NoSuchPEProcessStateException, SystemException {
		return remove((Serializable)spPEProcessStateId);
	}

	/**
	 * Removes the p e process state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e process state
	 * @return the p e process state that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState remove(Serializable primaryKey)
		throws NoSuchPEProcessStateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEProcessState peProcessState = (PEProcessState)session.get(PEProcessStateImpl.class,
					primaryKey);

			if (peProcessState == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEProcessStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peProcessState);
		}
		catch (NoSuchPEProcessStateException nsee) {
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
	protected PEProcessState removeImpl(PEProcessState peProcessState)
		throws SystemException {
		peProcessState = toUnwrappedModel(peProcessState);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peProcessState)) {
				peProcessState = (PEProcessState)session.get(PEProcessStateImpl.class,
						peProcessState.getPrimaryKeyObj());
			}

			if (peProcessState != null) {
				session.delete(peProcessState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peProcessState != null) {
			clearCache(peProcessState);
		}

		return peProcessState;
	}

	@Override
	public PEProcessState updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState)
		throws SystemException {
		peProcessState = toUnwrappedModel(peProcessState);

		boolean isNew = peProcessState.isNew();

		PEProcessStateModelImpl peProcessStateModelImpl = (PEProcessStateModelImpl)peProcessState;

		if (Validator.isNull(peProcessState.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peProcessState.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peProcessState.isNew()) {
				session.save(peProcessState);

				peProcessState.setNew(false);
			}
			else {
				session.merge(peProcessState);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEProcessStateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peProcessStateModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUuid(),
						peProcessStateModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUuid(),
						peProcessStateModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESS,
					args);

				args = new Object[] { peProcessStateModelImpl.getUserIdProcess() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESS,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess(),
						peProcessStateModelImpl.getOriginalSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUserIdProcess(),
						peProcessStateModelImpl.getSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSID,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSID,
					args);

				args = new Object[] { peProcessStateModelImpl.getSpPEProcessId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSID,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess(),
						peProcessStateModelImpl.getOriginalSpPEProcessId(),
						peProcessStateModelImpl.getOriginalEntityClassId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSICLASSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUserIdProcess(),
						peProcessStateModelImpl.getSpPEProcessId(),
						peProcessStateModelImpl.getEntityClassId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSICLASSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSICLASSID,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess(),
						peProcessStateModelImpl.getOriginalSpPEProcessId(),
						peProcessStateModelImpl.getOriginalEntityClassId(),
						peProcessStateModelImpl.getOriginalEntityId(),
						peProcessStateModelImpl.getOriginalActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUserIdProcess(),
						peProcessStateModelImpl.getSpPEProcessId(),
						peProcessStateModelImpl.getEntityClassId(),
						peProcessStateModelImpl.getEntityId(),
						peProcessStateModelImpl.getActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSIDENTITYCLASSIDENTITYIDACTIVESTATUS,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATELEAD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalSpPEProcessId(),
						peProcessStateModelImpl.getOriginalUserIdProcess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATELEAD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATELEAD,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getSpPEProcessId(),
						peProcessStateModelImpl.getUserIdProcess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATELEAD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATELEAD,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalSpPEProcessId(),
						peProcessStateModelImpl.getOriginalUserIdProcess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEOPPORTUNITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getSpPEProcessId(),
						peProcessStateModelImpl.getUserIdProcess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEOPPORTUNITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEOPPORTUNITY,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess(),
						peProcessStateModelImpl.getOriginalSpPEProcessStageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSSTAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUserIdProcess(),
						peProcessStateModelImpl.getSpPEProcessStageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSPEPROCESSSTAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSPEPROCESSSTAGEID,
					args);
			}

			if ((peProcessStateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStateModelImpl.getOriginalUserIdProcess(),
						peProcessStateModelImpl.getOriginalSpPEProcessId(),
						peProcessStateModelImpl.getOriginalSourceClassId(),
						peProcessStateModelImpl.getOriginalSourceEntityID(),
						peProcessStateModelImpl.getOriginalActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS,
					args);

				args = new Object[] {
						peProcessStateModelImpl.getUserIdProcess(),
						peProcessStateModelImpl.getSpPEProcessId(),
						peProcessStateModelImpl.getSourceClassId(),
						peProcessStateModelImpl.getSourceEntityID(),
						peProcessStateModelImpl.getActiveStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPROCESSANDPEPROCESSIDANDSOURCECLASSIDANDSOURCEENTITYIDANDACTIVESTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStateImpl.class, peProcessState.getPrimaryKey(),
			peProcessState);

		clearUniqueFindersCache(peProcessState);
		cacheUniqueFindersCache(peProcessState);

		return peProcessState;
	}

	protected PEProcessState toUnwrappedModel(PEProcessState peProcessState) {
		if (peProcessState instanceof PEProcessStateImpl) {
			return peProcessState;
		}

		PEProcessStateImpl peProcessStateImpl = new PEProcessStateImpl();

		peProcessStateImpl.setNew(peProcessState.isNew());
		peProcessStateImpl.setPrimaryKey(peProcessState.getPrimaryKey());

		peProcessStateImpl.setUuid(peProcessState.getUuid());
		peProcessStateImpl.setSpPEProcessStateId(peProcessState.getSpPEProcessStateId());
		peProcessStateImpl.setGroupId(peProcessState.getGroupId());
		peProcessStateImpl.setCompanyId(peProcessState.getCompanyId());
		peProcessStateImpl.setUserId(peProcessState.getUserId());
		peProcessStateImpl.setUserName(peProcessState.getUserName());
		peProcessStateImpl.setCreateDate(peProcessState.getCreateDate());
		peProcessStateImpl.setModifiedDate(peProcessState.getModifiedDate());
		peProcessStateImpl.setSpPEProcessId(peProcessState.getSpPEProcessId());
		peProcessStateImpl.setEntityClassId(peProcessState.getEntityClassId());
		peProcessStateImpl.setEntityId(peProcessState.getEntityId());
		peProcessStateImpl.setUserIdProcess(peProcessState.getUserIdProcess());
		peProcessStateImpl.setUserIdCreator(peProcessState.getUserIdCreator());
		peProcessStateImpl.setStatusTypeId(peProcessState.getStatusTypeId());
		peProcessStateImpl.setSpPEProcessStageId(peProcessState.getSpPEProcessStageId());
		peProcessStateImpl.setStatus(peProcessState.getStatus());
		peProcessStateImpl.setNodeId(peProcessState.getNodeId());
		peProcessStateImpl.setNodeIdLastProcessed(peProcessState.getNodeIdLastProcessed());
		peProcessStateImpl.setNodeIdLastDisplayed(peProcessState.getNodeIdLastDisplayed());
		peProcessStateImpl.setNodeIdLastDataSubmitted(peProcessState.getNodeIdLastDataSubmitted());
		peProcessStateImpl.setData(peProcessState.getData());
		peProcessStateImpl.setLastErrorCode(peProcessState.getLastErrorCode());
		peProcessStateImpl.setLastErrorMsg(peProcessState.getLastErrorMsg());
		peProcessStateImpl.setLastErrorDate(peProcessState.getLastErrorDate());
		peProcessStateImpl.setCurrentStatusTypeApprovers(peProcessState.getCurrentStatusTypeApprovers());
		peProcessStateImpl.setCurrentNodeSubmitters(peProcessState.getCurrentNodeSubmitters());
		peProcessStateImpl.setLock(peProcessState.getLock());
		peProcessStateImpl.setLockDate(peProcessState.getLockDate());
		peProcessStateImpl.setUserIdSupervisor(peProcessState.getUserIdSupervisor());
		peProcessStateImpl.setUserIdAgent(peProcessState.getUserIdAgent());
		peProcessStateImpl.setClosedStageId(peProcessState.getClosedStageId());
		peProcessStateImpl.setClosedDate(peProcessState.getClosedDate());
		peProcessStateImpl.setClosedReasonCatId(peProcessState.getClosedReasonCatId());
		peProcessStateImpl.setClosedDescription(peProcessState.getClosedDescription());
		peProcessStateImpl.setConvertedFromProcessStateId(peProcessState.getConvertedFromProcessStateId());
		peProcessStateImpl.setConvertedToProcessStateId(peProcessState.getConvertedToProcessStateId());
		peProcessStateImpl.setActiveStatus(peProcessState.getActiveStatus());
		peProcessStateImpl.setAmount(peProcessState.getAmount());
		peProcessStateImpl.setSourceClassId(peProcessState.getSourceClassId());
		peProcessStateImpl.setSourceEntityID(peProcessState.getSourceEntityID());

		return peProcessStateImpl;
	}

	/**
	 * Returns the p e process state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process state
	 * @return the p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEProcessStateException, SystemException {
		PEProcessState peProcessState = fetchByPrimaryKey(primaryKey);

		if (peProcessState == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEProcessStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peProcessState;
	}

	/**
	 * Returns the p e process state with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException} if it could not be found.
	 *
	 * @param spPEProcessStateId the primary key of the p e process state
	 * @return the p e process state
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStateException if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState findByPrimaryKey(long spPEProcessStateId)
		throws NoSuchPEProcessStateException, SystemException {
		return findByPrimaryKey((Serializable)spPEProcessStateId);
	}

	/**
	 * Returns the p e process state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process state
	 * @return the p e process state, or <code>null</code> if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEProcessState peProcessState = (PEProcessState)EntityCacheUtil.getResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStateImpl.class, primaryKey);

		if (peProcessState == _nullPEProcessState) {
			return null;
		}

		if (peProcessState == null) {
			Session session = null;

			try {
				session = openSession();

				peProcessState = (PEProcessState)session.get(PEProcessStateImpl.class,
						primaryKey);

				if (peProcessState != null) {
					cacheResult(peProcessState);
				}
				else {
					EntityCacheUtil.putResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStateImpl.class, primaryKey,
						_nullPEProcessState);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEProcessStateModelImpl.ENTITY_CACHE_ENABLED,
					PEProcessStateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peProcessState;
	}

	/**
	 * Returns the p e process state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEProcessStateId the primary key of the p e process state
	 * @return the p e process state, or <code>null</code> if a p e process state with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessState fetchByPrimaryKey(long spPEProcessStateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEProcessStateId);
	}

	/**
	 * Returns all the p e process states.
	 *
	 * @return the p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @return the range of p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process states
	 * @param end the upper bound of the range of p e process states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e process states
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessState> findAll(int start, int end,
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

		List<PEProcessState> list = (List<PEProcessState>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEPROCESSSTATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEPROCESSSTATE;

				if (pagination) {
					sql = sql.concat(PEProcessStateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEProcessState>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessState>(list);
				}
				else {
					list = (List<PEProcessState>)QueryUtil.list(q,
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
	 * Removes all the p e process states from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEProcessState peProcessState : findAll()) {
			remove(peProcessState);
		}
	}

	/**
	 * Returns the number of p e process states.
	 *
	 * @return the number of p e process states
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

				Query q = session.createQuery(_SQL_COUNT_PEPROCESSSTATE);

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
	 * Initializes the p e process state persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEProcessState")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEProcessState>> listenersList = new ArrayList<ModelListener<PEProcessState>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEProcessState>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEProcessStateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEPROCESSSTATE = "SELECT peProcessState FROM PEProcessState peProcessState";
	private static final String _SQL_SELECT_PEPROCESSSTATE_WHERE = "SELECT peProcessState FROM PEProcessState peProcessState WHERE ";
	private static final String _SQL_COUNT_PEPROCESSSTATE = "SELECT COUNT(peProcessState) FROM PEProcessState peProcessState";
	private static final String _SQL_COUNT_PEPROCESSSTATE_WHERE = "SELECT COUNT(peProcessState) FROM PEProcessState peProcessState WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peProcessState.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEProcessState exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEProcessState exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEProcessStatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "data", "lock"
			});
	private static PEProcessState _nullPEProcessState = new PEProcessStateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEProcessState> toCacheModel() {
				return _nullPEProcessStateCacheModel;
			}
		};

	private static CacheModel<PEProcessState> _nullPEProcessStateCacheModel = new CacheModel<PEProcessState>() {
			@Override
			public PEProcessState toEntityModel() {
				return _nullPEProcessState;
			}
		};
}