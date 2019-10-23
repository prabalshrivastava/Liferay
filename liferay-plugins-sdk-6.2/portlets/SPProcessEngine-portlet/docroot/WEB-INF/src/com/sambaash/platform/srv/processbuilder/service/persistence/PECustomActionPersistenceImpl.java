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

import com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException;
import com.sambaash.platform.srv.processbuilder.model.PECustomAction;
import com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e custom action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PECustomActionPersistence
 * @see PECustomActionUtil
 * @generated
 */
public class PECustomActionPersistenceImpl extends BasePersistenceImpl<PECustomAction>
	implements PECustomActionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PECustomActionUtil} to access the p e custom action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PECustomActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PECustomActionModelImpl.UUID_COLUMN_BITMASK |
			PECustomActionModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e custom actions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e custom actions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @return the range of matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e custom actions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid(String uuid, int start, int end,
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

		List<PECustomAction> list = (List<PECustomAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PECustomAction peCustomAction : list) {
				if (!Validator.equals(uuid, peCustomAction.getUuid())) {
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

			query.append(_SQL_SELECT_PECUSTOMACTION_WHERE);

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
				query.append(PECustomActionModelImpl.ORDER_BY_JPQL);
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
					list = (List<PECustomAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PECustomAction>(list);
				}
				else {
					list = (List<PECustomAction>)QueryUtil.list(q,
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
	 * Returns the first p e custom action in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByUuid_First(uuid,
				orderByComparator);

		if (peCustomAction != null) {
			return peCustomAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPECustomActionException(msg.toString());
	}

	/**
	 * Returns the first p e custom action in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PECustomAction> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e custom action in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByUuid_Last(uuid, orderByComparator);

		if (peCustomAction != null) {
			return peCustomAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPECustomActionException(msg.toString());
	}

	/**
	 * Returns the last p e custom action in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PECustomAction> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e custom actions before and after the current p e custom action in the ordered set where uuid = &#63;.
	 *
	 * @param spPEActionId the primary key of the current p e custom action
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction[] findByUuid_PrevAndNext(long spPEActionId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = findByPrimaryKey(spPEActionId);

		Session session = null;

		try {
			session = openSession();

			PECustomAction[] array = new PECustomActionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peCustomAction, uuid,
					orderByComparator, true);

			array[1] = peCustomAction;

			array[2] = getByUuid_PrevAndNext(session, peCustomAction, uuid,
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

	protected PECustomAction getByUuid_PrevAndNext(Session session,
		PECustomAction peCustomAction, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PECUSTOMACTION_WHERE);

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
			query.append(PECustomActionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peCustomAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PECustomAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e custom actions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PECustomAction peCustomAction : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peCustomAction);
		}
	}

	/**
	 * Returns the number of p e custom actions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e custom actions
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

			query.append(_SQL_COUNT_PECUSTOMACTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peCustomAction.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peCustomAction.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peCustomAction.uuid IS NULL OR peCustomAction.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PECustomActionModelImpl.UUID_COLUMN_BITMASK |
			PECustomActionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e custom action where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByUUID_G(String uuid, long groupId)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByUUID_G(uuid, groupId);

		if (peCustomAction == null) {
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

			throw new NoSuchPECustomActionException(msg.toString());
		}

		return peCustomAction;
	}

	/**
	 * Returns the p e custom action where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e custom action where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PECustomAction) {
			PECustomAction peCustomAction = (PECustomAction)result;

			if (!Validator.equals(uuid, peCustomAction.getUuid()) ||
					(groupId != peCustomAction.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PECUSTOMACTION_WHERE);

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

				List<PECustomAction> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PECustomAction peCustomAction = list.get(0);

					result = peCustomAction;

					cacheResult(peCustomAction);

					if ((peCustomAction.getUuid() == null) ||
							!peCustomAction.getUuid().equals(uuid) ||
							(peCustomAction.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peCustomAction);
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
			return (PECustomAction)result;
		}
	}

	/**
	 * Removes the p e custom action where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e custom action that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction removeByUUID_G(String uuid, long groupId)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = findByUUID_G(uuid, groupId);

		return remove(peCustomAction);
	}

	/**
	 * Returns the number of p e custom actions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e custom actions
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

			query.append(_SQL_COUNT_PECUSTOMACTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peCustomAction.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peCustomAction.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peCustomAction.uuid IS NULL OR peCustomAction.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peCustomAction.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED,
			PECustomActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PECustomActionModelImpl.UUID_COLUMN_BITMASK |
			PECustomActionModelImpl.COMPANYID_COLUMN_BITMASK |
			PECustomActionModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e custom actions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e custom actions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @return the range of matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e custom actions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findByUuid_C(String uuid, long companyId,
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

		List<PECustomAction> list = (List<PECustomAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PECustomAction peCustomAction : list) {
				if (!Validator.equals(uuid, peCustomAction.getUuid()) ||
						(companyId != peCustomAction.getCompanyId())) {
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

			query.append(_SQL_SELECT_PECUSTOMACTION_WHERE);

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
				query.append(PECustomActionModelImpl.ORDER_BY_JPQL);
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
					list = (List<PECustomAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PECustomAction>(list);
				}
				else {
					list = (List<PECustomAction>)QueryUtil.list(q,
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
	 * Returns the first p e custom action in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peCustomAction != null) {
			return peCustomAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPECustomActionException(msg.toString());
	}

	/**
	 * Returns the first p e custom action in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PECustomAction> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e custom action in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peCustomAction != null) {
			return peCustomAction;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPECustomActionException(msg.toString());
	}

	/**
	 * Returns the last p e custom action in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e custom action, or <code>null</code> if a matching p e custom action could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PECustomAction> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e custom actions before and after the current p e custom action in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEActionId the primary key of the current p e custom action
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction[] findByUuid_C_PrevAndNext(long spPEActionId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = findByPrimaryKey(spPEActionId);

		Session session = null;

		try {
			session = openSession();

			PECustomAction[] array = new PECustomActionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peCustomAction, uuid,
					companyId, orderByComparator, true);

			array[1] = peCustomAction;

			array[2] = getByUuid_C_PrevAndNext(session, peCustomAction, uuid,
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

	protected PECustomAction getByUuid_C_PrevAndNext(Session session,
		PECustomAction peCustomAction, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PECUSTOMACTION_WHERE);

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
			query.append(PECustomActionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peCustomAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PECustomAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e custom actions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PECustomAction peCustomAction : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peCustomAction);
		}
	}

	/**
	 * Returns the number of p e custom actions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e custom actions
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

			query.append(_SQL_COUNT_PECUSTOMACTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peCustomAction.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peCustomAction.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peCustomAction.uuid IS NULL OR peCustomAction.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peCustomAction.companyId = ?";

	public PECustomActionPersistenceImpl() {
		setModelClass(PECustomAction.class);
	}

	/**
	 * Caches the p e custom action in the entity cache if it is enabled.
	 *
	 * @param peCustomAction the p e custom action
	 */
	@Override
	public void cacheResult(PECustomAction peCustomAction) {
		EntityCacheUtil.putResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionImpl.class, peCustomAction.getPrimaryKey(),
			peCustomAction);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peCustomAction.getUuid(), peCustomAction.getGroupId() },
			peCustomAction);

		peCustomAction.resetOriginalValues();
	}

	/**
	 * Caches the p e custom actions in the entity cache if it is enabled.
	 *
	 * @param peCustomActions the p e custom actions
	 */
	@Override
	public void cacheResult(List<PECustomAction> peCustomActions) {
		for (PECustomAction peCustomAction : peCustomActions) {
			if (EntityCacheUtil.getResult(
						PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
						PECustomActionImpl.class, peCustomAction.getPrimaryKey()) == null) {
				cacheResult(peCustomAction);
			}
			else {
				peCustomAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e custom actions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PECustomActionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PECustomActionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e custom action.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PECustomAction peCustomAction) {
		EntityCacheUtil.removeResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionImpl.class, peCustomAction.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peCustomAction);
	}

	@Override
	public void clearCache(List<PECustomAction> peCustomActions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PECustomAction peCustomAction : peCustomActions) {
			EntityCacheUtil.removeResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
				PECustomActionImpl.class, peCustomAction.getPrimaryKey());

			clearUniqueFindersCache(peCustomAction);
		}
	}

	protected void cacheUniqueFindersCache(PECustomAction peCustomAction) {
		if (peCustomAction.isNew()) {
			Object[] args = new Object[] {
					peCustomAction.getUuid(), peCustomAction.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peCustomAction);
		}
		else {
			PECustomActionModelImpl peCustomActionModelImpl = (PECustomActionModelImpl)peCustomAction;

			if ((peCustomActionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peCustomAction.getUuid(), peCustomAction.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peCustomAction);
			}
		}
	}

	protected void clearUniqueFindersCache(PECustomAction peCustomAction) {
		PECustomActionModelImpl peCustomActionModelImpl = (PECustomActionModelImpl)peCustomAction;

		Object[] args = new Object[] {
				peCustomAction.getUuid(), peCustomAction.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peCustomActionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peCustomActionModelImpl.getOriginalUuid(),
					peCustomActionModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new p e custom action with the primary key. Does not add the p e custom action to the database.
	 *
	 * @param spPEActionId the primary key for the new p e custom action
	 * @return the new p e custom action
	 */
	@Override
	public PECustomAction create(long spPEActionId) {
		PECustomAction peCustomAction = new PECustomActionImpl();

		peCustomAction.setNew(true);
		peCustomAction.setPrimaryKey(spPEActionId);

		String uuid = PortalUUIDUtil.generate();

		peCustomAction.setUuid(uuid);

		return peCustomAction;
	}

	/**
	 * Removes the p e custom action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEActionId the primary key of the p e custom action
	 * @return the p e custom action that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction remove(long spPEActionId)
		throws NoSuchPECustomActionException, SystemException {
		return remove((Serializable)spPEActionId);
	}

	/**
	 * Removes the p e custom action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e custom action
	 * @return the p e custom action that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction remove(Serializable primaryKey)
		throws NoSuchPECustomActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PECustomAction peCustomAction = (PECustomAction)session.get(PECustomActionImpl.class,
					primaryKey);

			if (peCustomAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPECustomActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peCustomAction);
		}
		catch (NoSuchPECustomActionException nsee) {
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
	protected PECustomAction removeImpl(PECustomAction peCustomAction)
		throws SystemException {
		peCustomAction = toUnwrappedModel(peCustomAction);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peCustomAction)) {
				peCustomAction = (PECustomAction)session.get(PECustomActionImpl.class,
						peCustomAction.getPrimaryKeyObj());
			}

			if (peCustomAction != null) {
				session.delete(peCustomAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peCustomAction != null) {
			clearCache(peCustomAction);
		}

		return peCustomAction;
	}

	@Override
	public PECustomAction updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PECustomAction peCustomAction)
		throws SystemException {
		peCustomAction = toUnwrappedModel(peCustomAction);

		boolean isNew = peCustomAction.isNew();

		PECustomActionModelImpl peCustomActionModelImpl = (PECustomActionModelImpl)peCustomAction;

		if (Validator.isNull(peCustomAction.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peCustomAction.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peCustomAction.isNew()) {
				session.save(peCustomAction);

				peCustomAction.setNew(false);
			}
			else {
				session.merge(peCustomAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PECustomActionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peCustomActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peCustomActionModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peCustomActionModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peCustomActionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peCustomActionModelImpl.getOriginalUuid(),
						peCustomActionModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peCustomActionModelImpl.getUuid(),
						peCustomActionModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
			PECustomActionImpl.class, peCustomAction.getPrimaryKey(),
			peCustomAction);

		clearUniqueFindersCache(peCustomAction);
		cacheUniqueFindersCache(peCustomAction);

		return peCustomAction;
	}

	protected PECustomAction toUnwrappedModel(PECustomAction peCustomAction) {
		if (peCustomAction instanceof PECustomActionImpl) {
			return peCustomAction;
		}

		PECustomActionImpl peCustomActionImpl = new PECustomActionImpl();

		peCustomActionImpl.setNew(peCustomAction.isNew());
		peCustomActionImpl.setPrimaryKey(peCustomAction.getPrimaryKey());

		peCustomActionImpl.setUuid(peCustomAction.getUuid());
		peCustomActionImpl.setSpPEActionId(peCustomAction.getSpPEActionId());
		peCustomActionImpl.setGroupId(peCustomAction.getGroupId());
		peCustomActionImpl.setCompanyId(peCustomAction.getCompanyId());
		peCustomActionImpl.setUserId(peCustomAction.getUserId());
		peCustomActionImpl.setUserName(peCustomAction.getUserName());
		peCustomActionImpl.setCreateDate(peCustomAction.getCreateDate());
		peCustomActionImpl.setModifiedDate(peCustomAction.getModifiedDate());
		peCustomActionImpl.setActionClassName(peCustomAction.getActionClassName());
		peCustomActionImpl.setTitle(peCustomAction.getTitle());
		peCustomActionImpl.setDefaultConfiguration(peCustomAction.getDefaultConfiguration());

		return peCustomActionImpl;
	}

	/**
	 * Returns the p e custom action with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e custom action
	 * @return the p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPECustomActionException, SystemException {
		PECustomAction peCustomAction = fetchByPrimaryKey(primaryKey);

		if (peCustomAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPECustomActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peCustomAction;
	}

	/**
	 * Returns the p e custom action with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException} if it could not be found.
	 *
	 * @param spPEActionId the primary key of the p e custom action
	 * @return the p e custom action
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPECustomActionException if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction findByPrimaryKey(long spPEActionId)
		throws NoSuchPECustomActionException, SystemException {
		return findByPrimaryKey((Serializable)spPEActionId);
	}

	/**
	 * Returns the p e custom action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e custom action
	 * @return the p e custom action, or <code>null</code> if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PECustomAction peCustomAction = (PECustomAction)EntityCacheUtil.getResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
				PECustomActionImpl.class, primaryKey);

		if (peCustomAction == _nullPECustomAction) {
			return null;
		}

		if (peCustomAction == null) {
			Session session = null;

			try {
				session = openSession();

				peCustomAction = (PECustomAction)session.get(PECustomActionImpl.class,
						primaryKey);

				if (peCustomAction != null) {
					cacheResult(peCustomAction);
				}
				else {
					EntityCacheUtil.putResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
						PECustomActionImpl.class, primaryKey,
						_nullPECustomAction);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PECustomActionModelImpl.ENTITY_CACHE_ENABLED,
					PECustomActionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peCustomAction;
	}

	/**
	 * Returns the p e custom action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEActionId the primary key of the p e custom action
	 * @return the p e custom action, or <code>null</code> if a p e custom action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PECustomAction fetchByPrimaryKey(long spPEActionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEActionId);
	}

	/**
	 * Returns all the p e custom actions.
	 *
	 * @return the p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e custom actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @return the range of p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e custom actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PECustomActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e custom actions
	 * @param end the upper bound of the range of p e custom actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e custom actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PECustomAction> findAll(int start, int end,
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

		List<PECustomAction> list = (List<PECustomAction>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PECUSTOMACTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PECUSTOMACTION;

				if (pagination) {
					sql = sql.concat(PECustomActionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PECustomAction>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PECustomAction>(list);
				}
				else {
					list = (List<PECustomAction>)QueryUtil.list(q,
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
	 * Removes all the p e custom actions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PECustomAction peCustomAction : findAll()) {
			remove(peCustomAction);
		}
	}

	/**
	 * Returns the number of p e custom actions.
	 *
	 * @return the number of p e custom actions
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

				Query q = session.createQuery(_SQL_COUNT_PECUSTOMACTION);

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
	 * Initializes the p e custom action persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PECustomAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PECustomAction>> listenersList = new ArrayList<ModelListener<PECustomAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PECustomAction>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PECustomActionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PECUSTOMACTION = "SELECT peCustomAction FROM PECustomAction peCustomAction";
	private static final String _SQL_SELECT_PECUSTOMACTION_WHERE = "SELECT peCustomAction FROM PECustomAction peCustomAction WHERE ";
	private static final String _SQL_COUNT_PECUSTOMACTION = "SELECT COUNT(peCustomAction) FROM PECustomAction peCustomAction";
	private static final String _SQL_COUNT_PECUSTOMACTION_WHERE = "SELECT COUNT(peCustomAction) FROM PECustomAction peCustomAction WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peCustomAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PECustomAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PECustomAction exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PECustomActionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PECustomAction _nullPECustomAction = new PECustomActionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PECustomAction> toCacheModel() {
				return _nullPECustomActionCacheModel;
			}
		};

	private static CacheModel<PECustomAction> _nullPECustomActionCacheModel = new CacheModel<PECustomAction>() {
			@Override
			public PECustomAction toEntityModel() {
				return _nullPECustomAction;
			}
		};
}