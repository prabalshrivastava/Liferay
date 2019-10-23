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

import com.sambaash.platform.srv.processbuilder.NoSuchPERuleException;
import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.model.impl.PERuleImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PERulePersistence
 * @see PERuleUtil
 * @generated
 */
public class PERulePersistenceImpl extends BasePersistenceImpl<PERule>
	implements PERulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PERuleUtil} to access the p e rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PERuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PERuleModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @return the range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e rules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid(String uuid, int start, int end,
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

		List<PERule> list = (List<PERule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PERule peRule : list) {
				if (!Validator.equals(uuid, peRule.getUuid())) {
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

			query.append(_SQL_SELECT_PERULE_WHERE);

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
				query.append(PERuleModelImpl.ORDER_BY_JPQL);
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
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PERule>(list);
				}
				else {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first p e rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByUuid_First(uuid, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the first p e rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PERule> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByUuid_Last(uuid, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the last p e rule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PERule> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e rules before and after the current p e rule in the ordered set where uuid = &#63;.
	 *
	 * @param spPERuleId the primary key of the current p e rule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule[] findByUuid_PrevAndNext(long spPERuleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = findByPrimaryKey(spPERuleId);

		Session session = null;

		try {
			session = openSession();

			PERule[] array = new PERuleImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peRule, uuid,
					orderByComparator, true);

			array[1] = peRule;

			array[2] = getByUuid_PrevAndNext(session, peRule, uuid,
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

	protected PERule getByUuid_PrevAndNext(Session session, PERule peRule,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERULE_WHERE);

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
			query.append(PERuleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PERule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e rules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PERule peRule : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peRule);
		}
	}

	/**
	 * Returns the number of p e rules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e rules
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

			query.append(_SQL_COUNT_PERULE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peRule.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peRule.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peRule.uuid IS NULL OR peRule.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PERuleModelImpl.UUID_COLUMN_BITMASK |
			PERuleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e rule where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByUUID_G(String uuid, long groupId)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByUUID_G(uuid, groupId);

		if (peRule == null) {
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

			throw new NoSuchPERuleException(msg.toString());
		}

		return peRule;
	}

	/**
	 * Returns the p e rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e rule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PERule) {
			PERule peRule = (PERule)result;

			if (!Validator.equals(uuid, peRule.getUuid()) ||
					(groupId != peRule.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PERULE_WHERE);

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

				List<PERule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PERule peRule = list.get(0);

					result = peRule;

					cacheResult(peRule);

					if ((peRule.getUuid() == null) ||
							!peRule.getUuid().equals(uuid) ||
							(peRule.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peRule);
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
			return (PERule)result;
		}
	}

	/**
	 * Removes the p e rule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e rule that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule removeByUUID_G(String uuid, long groupId)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = findByUUID_G(uuid, groupId);

		return remove(peRule);
	}

	/**
	 * Returns the number of p e rules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e rules
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

			query.append(_SQL_COUNT_PERULE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peRule.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peRule.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peRule.uuid IS NULL OR peRule.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peRule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PERuleModelImpl.UUID_COLUMN_BITMASK |
			PERuleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @return the range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e rules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByUuid_C(String uuid, long companyId, int start,
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

		List<PERule> list = (List<PERule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PERule peRule : list) {
				if (!Validator.equals(uuid, peRule.getUuid()) ||
						(companyId != peRule.getCompanyId())) {
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

			query.append(_SQL_SELECT_PERULE_WHERE);

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
				query.append(PERuleModelImpl.ORDER_BY_JPQL);
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
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PERule>(list);
				}
				else {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the first p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PERule> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the last p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PERule> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e rules before and after the current p e rule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPERuleId the primary key of the current p e rule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule[] findByUuid_C_PrevAndNext(long spPERuleId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = findByPrimaryKey(spPERuleId);

		Session session = null;

		try {
			session = openSession();

			PERule[] array = new PERuleImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peRule, uuid,
					companyId, orderByComparator, true);

			array[1] = peRule;

			array[2] = getByUuid_C_PrevAndNext(session, peRule, uuid,
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

	protected PERule getByUuid_C_PrevAndNext(Session session, PERule peRule,
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

		query.append(_SQL_SELECT_PERULE_WHERE);

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
			query.append(PERuleModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PERule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e rules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PERule peRule : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peRule);
		}
	}

	/**
	 * Returns the number of p e rules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e rules
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

			query.append(_SQL_COUNT_PERULE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peRule.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peRule.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peRule.uuid IS NULL OR peRule.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peRule.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RULESETID =
		new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleSetId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULESETID =
		new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, PERuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleSetId",
			new String[] { Long.class.getName() },
			PERuleModelImpl.SPPERULESETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULESETID = new FinderPath(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleSetId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e rules where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @return the matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByRuleSetId(long spPERuleSetId)
		throws SystemException {
		return findByRuleSetId(spPERuleSetId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e rules where spPERuleSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @return the range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByRuleSetId(long spPERuleSetId, int start, int end)
		throws SystemException {
		return findByRuleSetId(spPERuleSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e rules where spPERuleSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findByRuleSetId(long spPERuleSetId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULESETID;
			finderArgs = new Object[] { spPERuleSetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RULESETID;
			finderArgs = new Object[] {
					spPERuleSetId,
					
					start, end, orderByComparator
				};
		}

		List<PERule> list = (List<PERule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PERule peRule : list) {
				if ((spPERuleSetId != peRule.getSpPERuleSetId())) {
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

			query.append(_SQL_SELECT_PERULE_WHERE);

			query.append(_FINDER_COLUMN_RULESETID_SPPERULESETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PERuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPERuleSetId);

				if (!pagination) {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PERule>(list);
				}
				else {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first p e rule in the ordered set where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByRuleSetId_First(long spPERuleSetId,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByRuleSetId_First(spPERuleSetId, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPERuleSetId=");
		msg.append(spPERuleSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the first p e rule in the ordered set where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByRuleSetId_First(long spPERuleSetId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PERule> list = findByRuleSetId(spPERuleSetId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e rule in the ordered set where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByRuleSetId_Last(long spPERuleSetId,
		OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByRuleSetId_Last(spPERuleSetId, orderByComparator);

		if (peRule != null) {
			return peRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPERuleSetId=");
		msg.append(spPERuleSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPERuleException(msg.toString());
	}

	/**
	 * Returns the last p e rule in the ordered set where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e rule, or <code>null</code> if a matching p e rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByRuleSetId_Last(long spPERuleSetId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRuleSetId(spPERuleSetId);

		if (count == 0) {
			return null;
		}

		List<PERule> list = findByRuleSetId(spPERuleSetId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e rules before and after the current p e rule in the ordered set where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleId the primary key of the current p e rule
	 * @param spPERuleSetId the sp p e rule set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule[] findByRuleSetId_PrevAndNext(long spPERuleId,
		long spPERuleSetId, OrderByComparator orderByComparator)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = findByPrimaryKey(spPERuleId);

		Session session = null;

		try {
			session = openSession();

			PERule[] array = new PERuleImpl[3];

			array[0] = getByRuleSetId_PrevAndNext(session, peRule,
					spPERuleSetId, orderByComparator, true);

			array[1] = peRule;

			array[2] = getByRuleSetId_PrevAndNext(session, peRule,
					spPERuleSetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PERule getByRuleSetId_PrevAndNext(Session session, PERule peRule,
		long spPERuleSetId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERULE_WHERE);

		query.append(_FINDER_COLUMN_RULESETID_SPPERULESETID_2);

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
			query.append(PERuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPERuleSetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PERule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e rules where spPERuleSetId = &#63; from the database.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRuleSetId(long spPERuleSetId) throws SystemException {
		for (PERule peRule : findByRuleSetId(spPERuleSetId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peRule);
		}
	}

	/**
	 * Returns the number of p e rules where spPERuleSetId = &#63;.
	 *
	 * @param spPERuleSetId the sp p e rule set ID
	 * @return the number of matching p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRuleSetId(long spPERuleSetId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RULESETID;

		Object[] finderArgs = new Object[] { spPERuleSetId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERULE_WHERE);

			query.append(_FINDER_COLUMN_RULESETID_SPPERULESETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPERuleSetId);

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

	private static final String _FINDER_COLUMN_RULESETID_SPPERULESETID_2 = "peRule.spPERuleSetId = ?";

	public PERulePersistenceImpl() {
		setModelClass(PERule.class);
	}

	/**
	 * Caches the p e rule in the entity cache if it is enabled.
	 *
	 * @param peRule the p e rule
	 */
	@Override
	public void cacheResult(PERule peRule) {
		EntityCacheUtil.putResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleImpl.class, peRule.getPrimaryKey(), peRule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peRule.getUuid(), peRule.getGroupId() }, peRule);

		peRule.resetOriginalValues();
	}

	/**
	 * Caches the p e rules in the entity cache if it is enabled.
	 *
	 * @param peRules the p e rules
	 */
	@Override
	public void cacheResult(List<PERule> peRules) {
		for (PERule peRule : peRules) {
			if (EntityCacheUtil.getResult(
						PERuleModelImpl.ENTITY_CACHE_ENABLED, PERuleImpl.class,
						peRule.getPrimaryKey()) == null) {
				cacheResult(peRule);
			}
			else {
				peRule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PERuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PERuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PERule peRule) {
		EntityCacheUtil.removeResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleImpl.class, peRule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peRule);
	}

	@Override
	public void clearCache(List<PERule> peRules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PERule peRule : peRules) {
			EntityCacheUtil.removeResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
				PERuleImpl.class, peRule.getPrimaryKey());

			clearUniqueFindersCache(peRule);
		}
	}

	protected void cacheUniqueFindersCache(PERule peRule) {
		if (peRule.isNew()) {
			Object[] args = new Object[] { peRule.getUuid(), peRule.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, peRule);
		}
		else {
			PERuleModelImpl peRuleModelImpl = (PERuleModelImpl)peRule;

			if ((peRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peRule.getUuid(), peRule.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peRule);
			}
		}
	}

	protected void clearUniqueFindersCache(PERule peRule) {
		PERuleModelImpl peRuleModelImpl = (PERuleModelImpl)peRule;

		Object[] args = new Object[] { peRule.getUuid(), peRule.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peRuleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peRuleModelImpl.getOriginalUuid(),
					peRuleModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new p e rule with the primary key. Does not add the p e rule to the database.
	 *
	 * @param spPERuleId the primary key for the new p e rule
	 * @return the new p e rule
	 */
	@Override
	public PERule create(long spPERuleId) {
		PERule peRule = new PERuleImpl();

		peRule.setNew(true);
		peRule.setPrimaryKey(spPERuleId);

		String uuid = PortalUUIDUtil.generate();

		peRule.setUuid(uuid);

		return peRule;
	}

	/**
	 * Removes the p e rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPERuleId the primary key of the p e rule
	 * @return the p e rule that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule remove(long spPERuleId)
		throws NoSuchPERuleException, SystemException {
		return remove((Serializable)spPERuleId);
	}

	/**
	 * Removes the p e rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e rule
	 * @return the p e rule that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule remove(Serializable primaryKey)
		throws NoSuchPERuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PERule peRule = (PERule)session.get(PERuleImpl.class, primaryKey);

			if (peRule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPERuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peRule);
		}
		catch (NoSuchPERuleException nsee) {
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
	protected PERule removeImpl(PERule peRule) throws SystemException {
		peRule = toUnwrappedModel(peRule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peRule)) {
				peRule = (PERule)session.get(PERuleImpl.class,
						peRule.getPrimaryKeyObj());
			}

			if (peRule != null) {
				session.delete(peRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peRule != null) {
			clearCache(peRule);
		}

		return peRule;
	}

	@Override
	public PERule updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PERule peRule)
		throws SystemException {
		peRule = toUnwrappedModel(peRule);

		boolean isNew = peRule.isNew();

		PERuleModelImpl peRuleModelImpl = (PERuleModelImpl)peRule;

		if (Validator.isNull(peRule.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peRule.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peRule.isNew()) {
				session.save(peRule);

				peRule.setNew(false);
			}
			else {
				session.merge(peRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PERuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { peRuleModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peRuleModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peRuleModelImpl.getOriginalUuid(),
						peRuleModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peRuleModelImpl.getUuid(),
						peRuleModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULESETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peRuleModelImpl.getOriginalSpPERuleSetId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULESETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULESETID,
					args);

				args = new Object[] { peRuleModelImpl.getSpPERuleSetId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULESETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULESETID,
					args);
			}
		}

		EntityCacheUtil.putResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
			PERuleImpl.class, peRule.getPrimaryKey(), peRule);

		clearUniqueFindersCache(peRule);
		cacheUniqueFindersCache(peRule);

		return peRule;
	}

	protected PERule toUnwrappedModel(PERule peRule) {
		if (peRule instanceof PERuleImpl) {
			return peRule;
		}

		PERuleImpl peRuleImpl = new PERuleImpl();

		peRuleImpl.setNew(peRule.isNew());
		peRuleImpl.setPrimaryKey(peRule.getPrimaryKey());

		peRuleImpl.setUuid(peRule.getUuid());
		peRuleImpl.setSpPERuleId(peRule.getSpPERuleId());
		peRuleImpl.setGroupId(peRule.getGroupId());
		peRuleImpl.setCompanyId(peRule.getCompanyId());
		peRuleImpl.setUserId(peRule.getUserId());
		peRuleImpl.setUserName(peRule.getUserName());
		peRuleImpl.setCreateDate(peRule.getCreateDate());
		peRuleImpl.setModifiedDate(peRule.getModifiedDate());
		peRuleImpl.setSpPERuleSetId(peRule.getSpPERuleSetId());
		peRuleImpl.setName(peRule.getName());
		peRuleImpl.setType(peRule.getType());
		peRuleImpl.setDefinition(peRule.getDefinition());
		peRuleImpl.setSequenceNO(peRule.getSequenceNO());

		return peRuleImpl;
	}

	/**
	 * Returns the p e rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e rule
	 * @return the p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPERuleException, SystemException {
		PERule peRule = fetchByPrimaryKey(primaryKey);

		if (peRule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPERuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peRule;
	}

	/**
	 * Returns the p e rule with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleException} if it could not be found.
	 *
	 * @param spPERuleId the primary key of the p e rule
	 * @return the p e rule
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleException if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule findByPrimaryKey(long spPERuleId)
		throws NoSuchPERuleException, SystemException {
		return findByPrimaryKey((Serializable)spPERuleId);
	}

	/**
	 * Returns the p e rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e rule
	 * @return the p e rule, or <code>null</code> if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PERule peRule = (PERule)EntityCacheUtil.getResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
				PERuleImpl.class, primaryKey);

		if (peRule == _nullPERule) {
			return null;
		}

		if (peRule == null) {
			Session session = null;

			try {
				session = openSession();

				peRule = (PERule)session.get(PERuleImpl.class, primaryKey);

				if (peRule != null) {
					cacheResult(peRule);
				}
				else {
					EntityCacheUtil.putResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
						PERuleImpl.class, primaryKey, _nullPERule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PERuleModelImpl.ENTITY_CACHE_ENABLED,
					PERuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peRule;
	}

	/**
	 * Returns the p e rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPERuleId the primary key of the p e rule
	 * @return the p e rule, or <code>null</code> if a p e rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PERule fetchByPrimaryKey(long spPERuleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spPERuleId);
	}

	/**
	 * Returns all the p e rules.
	 *
	 * @return the p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @return the range of p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e rules
	 * @param end the upper bound of the range of p e rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PERule> findAll(int start, int end,
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

		List<PERule> list = (List<PERule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERULE;

				if (pagination) {
					sql = sql.concat(PERuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PERule>(list);
				}
				else {
					list = (List<PERule>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the p e rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PERule peRule : findAll()) {
			remove(peRule);
		}
	}

	/**
	 * Returns the number of p e rules.
	 *
	 * @return the number of p e rules
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

				Query q = session.createQuery(_SQL_COUNT_PERULE);

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
	 * Initializes the p e rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PERule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PERule>> listenersList = new ArrayList<ModelListener<PERule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PERule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PERuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PERULE = "SELECT peRule FROM PERule peRule";
	private static final String _SQL_SELECT_PERULE_WHERE = "SELECT peRule FROM PERule peRule WHERE ";
	private static final String _SQL_COUNT_PERULE = "SELECT COUNT(peRule) FROM PERule peRule";
	private static final String _SQL_COUNT_PERULE_WHERE = "SELECT COUNT(peRule) FROM PERule peRule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peRule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PERule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PERule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PERulePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
	private static PERule _nullPERule = new PERuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PERule> toCacheModel() {
				return _nullPERuleCacheModel;
			}
		};

	private static CacheModel<PERule> _nullPERuleCacheModel = new CacheModel<PERule>() {
			@Override
			public PERule toEntityModel() {
				return _nullPERule;
			}
		};
}