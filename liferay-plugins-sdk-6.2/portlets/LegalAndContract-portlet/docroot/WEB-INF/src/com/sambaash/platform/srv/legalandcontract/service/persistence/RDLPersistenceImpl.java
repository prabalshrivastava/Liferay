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

import com.sambaash.platform.srv.legalandcontract.NoSuchRDLException;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.model.impl.RDLImpl;
import com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the r d l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see RDLPersistence
 * @see RDLUtil
 * @generated
 */
public class RDLPersistenceImpl extends BasePersistenceImpl<RDL>
	implements RDLPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDLUtil} to access the r d l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDLImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RDLModelImpl.UUID_COLUMN_BITMASK |
			RDLModelImpl.RESPONSEDEADLINE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the r d ls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d ls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @return the range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d ls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid(String uuid, int start, int end,
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

		List<RDL> list = (List<RDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDL rdl : list) {
				if (!Validator.equals(uuid, rdl.getUuid())) {
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

			query.append(_SQL_SELECT_RDL_WHERE);

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
				query.append(RDLModelImpl.ORDER_BY_JPQL);
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
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDL>(list);
				}
				else {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first r d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByUuid_First(String uuid, OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByUuid_First(uuid, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the first r d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RDL> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByUuid_Last(uuid, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the last r d l in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RDL> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d ls before and after the current r d l in the ordered set where uuid = &#63;.
	 *
	 * @param spRdlId the primary key of the current r d l
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL[] findByUuid_PrevAndNext(long spRdlId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = findByPrimaryKey(spRdlId);

		Session session = null;

		try {
			session = openSession();

			RDL[] array = new RDLImpl[3];

			array[0] = getByUuid_PrevAndNext(session, rdl, uuid,
					orderByComparator, true);

			array[1] = rdl;

			array[2] = getByUuid_PrevAndNext(session, rdl, uuid,
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

	protected RDL getByUuid_PrevAndNext(Session session, RDL rdl, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDL_WHERE);

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
			query.append(RDLModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rdl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDL> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d ls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RDL rdl : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(rdl);
		}
	}

	/**
	 * Returns the number of r d ls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching r d ls
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

			query.append(_SQL_COUNT_RDL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "rdl.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "rdl.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(rdl.uuid IS NULL OR rdl.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RDLModelImpl.UUID_COLUMN_BITMASK |
			RDLModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the r d l where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByUUID_G(String uuid, long groupId)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByUUID_G(uuid, groupId);

		if (rdl == null) {
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

			throw new NoSuchRDLException(msg.toString());
		}

		return rdl;
	}

	/**
	 * Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the r d l where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RDL) {
			RDL rdl = (RDL)result;

			if (!Validator.equals(uuid, rdl.getUuid()) ||
					(groupId != rdl.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RDL_WHERE);

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

				List<RDL> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RDL rdl = list.get(0);

					result = rdl;

					cacheResult(rdl);

					if ((rdl.getUuid() == null) || !rdl.getUuid().equals(uuid) ||
							(rdl.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, rdl);
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
			return (RDL)result;
		}
	}

	/**
	 * Removes the r d l where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the r d l that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL removeByUUID_G(String uuid, long groupId)
		throws NoSuchRDLException, SystemException {
		RDL rdl = findByUUID_G(uuid, groupId);

		return remove(rdl);
	}

	/**
	 * Returns the number of r d ls where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching r d ls
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

			query.append(_SQL_COUNT_RDL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "rdl.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "rdl.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(rdl.uuid IS NULL OR rdl.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "rdl.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RDLModelImpl.UUID_COLUMN_BITMASK |
			RDLModelImpl.COMPANYID_COLUMN_BITMASK |
			RDLModelImpl.RESPONSEDEADLINE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the r d ls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d ls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @return the range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d ls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findByUuid_C(String uuid, long companyId, int start,
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

		List<RDL> list = (List<RDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDL rdl : list) {
				if (!Validator.equals(uuid, rdl.getUuid()) ||
						(companyId != rdl.getCompanyId())) {
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

			query.append(_SQL_SELECT_RDL_WHERE);

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
				query.append(RDLModelImpl.ORDER_BY_JPQL);
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
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDL>(list);
				}
				else {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the first r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RDL> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the last r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RDL> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d ls before and after the current r d l in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spRdlId the primary key of the current r d l
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL[] findByUuid_C_PrevAndNext(long spRdlId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = findByPrimaryKey(spRdlId);

		Session session = null;

		try {
			session = openSession();

			RDL[] array = new RDLImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, rdl, uuid, companyId,
					orderByComparator, true);

			array[1] = rdl;

			array[2] = getByUuid_C_PrevAndNext(session, rdl, uuid, companyId,
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

	protected RDL getByUuid_C_PrevAndNext(Session session, RDL rdl,
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

		query.append(_SQL_SELECT_RDL_WHERE);

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
			query.append(RDLModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(rdl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDL> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d ls where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RDL rdl : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rdl);
		}
	}

	/**
	 * Returns the number of r d ls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching r d ls
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

			query.append(_SQL_COUNT_RDL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "rdl.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "rdl.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(rdl.uuid IS NULL OR rdl.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "rdl.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRdlIdLitigationId",
			new String[] { Long.class.getName(), Long.class.getName() },
			RDLModelImpl.SPRDLID_COLUMN_BITMASK |
			RDLModelImpl.SPLITIGATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRdlIdLitigationId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	 *
	 * @param spRdlId the sp rdl ID
	 * @param spLitigationId the sp litigation ID
	 * @return the matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByRdlIdLitigationId(spRdlId, spLitigationId);

		if (rdl == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spRdlId=");
			msg.append(spRdlId);

			msg.append(", spLitigationId=");
			msg.append(spLitigationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRDLException(msg.toString());
		}

		return rdl;
	}

	/**
	 * Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spRdlId the sp rdl ID
	 * @param spLitigationId the sp litigation ID
	 * @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws SystemException {
		return fetchByRdlIdLitigationId(spRdlId, spLitigationId, true);
	}

	/**
	 * Returns the r d l where spRdlId = &#63; and spLitigationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spRdlId the sp rdl ID
	 * @param spLitigationId the sp litigation ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByRdlIdLitigationId(long spRdlId, long spLitigationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spRdlId, spLitigationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
					finderArgs, this);
		}

		if (result instanceof RDL) {
			RDL rdl = (RDL)result;

			if ((spRdlId != rdl.getSpRdlId()) ||
					(spLitigationId != rdl.getSpLitigationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RDL_WHERE);

			query.append(_FINDER_COLUMN_RDLIDLITIGATIONID_SPRDLID_2);

			query.append(_FINDER_COLUMN_RDLIDLITIGATIONID_SPLITIGATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spRdlId);

				qPos.add(spLitigationId);

				List<RDL> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RDLPersistenceImpl.fetchByRdlIdLitigationId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					RDL rdl = list.get(0);

					result = rdl;

					cacheResult(rdl);

					if ((rdl.getSpRdlId() != spRdlId) ||
							(rdl.getSpLitigationId() != spLitigationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
							finderArgs, rdl);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
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
			return (RDL)result;
		}
	}

	/**
	 * Removes the r d l where spRdlId = &#63; and spLitigationId = &#63; from the database.
	 *
	 * @param spRdlId the sp rdl ID
	 * @param spLitigationId the sp litigation ID
	 * @return the r d l that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL removeByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws NoSuchRDLException, SystemException {
		RDL rdl = findByRdlIdLitigationId(spRdlId, spLitigationId);

		return remove(rdl);
	}

	/**
	 * Returns the number of r d ls where spRdlId = &#63; and spLitigationId = &#63;.
	 *
	 * @param spRdlId the sp rdl ID
	 * @param spLitigationId the sp litigation ID
	 * @return the number of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRdlIdLitigationId(long spRdlId, long spLitigationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID;

		Object[] finderArgs = new Object[] { spRdlId, spLitigationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RDL_WHERE);

			query.append(_FINDER_COLUMN_RDLIDLITIGATIONID_SPRDLID_2);

			query.append(_FINDER_COLUMN_RDLIDLITIGATIONID_SPLITIGATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spRdlId);

				qPos.add(spLitigationId);

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

	private static final String _FINDER_COLUMN_RDLIDLITIGATIONID_SPRDLID_2 = "rdl.spRdlId = ? AND ";
	private static final String _FINDER_COLUMN_RDLIDLITIGATIONID_SPLITIGATIONID_2 =
		"rdl.spLitigationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LITIGATIONID =
		new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylitigationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LITIGATIONID =
		new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, RDLImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylitigationId",
			new String[] { Long.class.getName() },
			RDLModelImpl.SPLITIGATIONID_COLUMN_BITMASK |
			RDLModelImpl.RESPONSEDEADLINE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LITIGATIONID = new FinderPath(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylitigationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the r d ls where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @return the matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findBylitigationId(long spLitigationId)
		throws SystemException {
		return findBylitigationId(spLitigationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d ls where spLitigationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @return the range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findBylitigationId(long spLitigationId, int start, int end)
		throws SystemException {
		return findBylitigationId(spLitigationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d ls where spLitigationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findBylitigationId(long spLitigationId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LITIGATIONID;
			finderArgs = new Object[] { spLitigationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LITIGATIONID;
			finderArgs = new Object[] {
					spLitigationId,
					
					start, end, orderByComparator
				};
		}

		List<RDL> list = (List<RDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RDL rdl : list) {
				if ((spLitigationId != rdl.getSpLitigationId())) {
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

			query.append(_SQL_SELECT_RDL_WHERE);

			query.append(_FINDER_COLUMN_LITIGATIONID_SPLITIGATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RDLModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spLitigationId);

				if (!pagination) {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDL>(list);
				}
				else {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first r d l in the ordered set where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findBylitigationId_First(long spLitigationId,
		OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchBylitigationId_First(spLitigationId, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spLitigationId=");
		msg.append(spLitigationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the first r d l in the ordered set where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchBylitigationId_First(long spLitigationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RDL> list = findBylitigationId(spLitigationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last r d l in the ordered set where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findBylitigationId_Last(long spLitigationId,
		OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchBylitigationId_Last(spLitigationId, orderByComparator);

		if (rdl != null) {
			return rdl;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spLitigationId=");
		msg.append(spLitigationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRDLException(msg.toString());
	}

	/**
	 * Returns the last r d l in the ordered set where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching r d l, or <code>null</code> if a matching r d l could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchBylitigationId_Last(long spLitigationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylitigationId(spLitigationId);

		if (count == 0) {
			return null;
		}

		List<RDL> list = findBylitigationId(spLitigationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the r d ls before and after the current r d l in the ordered set where spLitigationId = &#63;.
	 *
	 * @param spRdlId the primary key of the current r d l
	 * @param spLitigationId the sp litigation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL[] findBylitigationId_PrevAndNext(long spRdlId,
		long spLitigationId, OrderByComparator orderByComparator)
		throws NoSuchRDLException, SystemException {
		RDL rdl = findByPrimaryKey(spRdlId);

		Session session = null;

		try {
			session = openSession();

			RDL[] array = new RDLImpl[3];

			array[0] = getBylitigationId_PrevAndNext(session, rdl,
					spLitigationId, orderByComparator, true);

			array[1] = rdl;

			array[2] = getBylitigationId_PrevAndNext(session, rdl,
					spLitigationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RDL getBylitigationId_PrevAndNext(Session session, RDL rdl,
		long spLitigationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RDL_WHERE);

		query.append(_FINDER_COLUMN_LITIGATIONID_SPLITIGATIONID_2);

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
			query.append(RDLModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spLitigationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rdl);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RDL> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the r d ls where spLitigationId = &#63; from the database.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylitigationId(long spLitigationId)
		throws SystemException {
		for (RDL rdl : findBylitigationId(spLitigationId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rdl);
		}
	}

	/**
	 * Returns the number of r d ls where spLitigationId = &#63;.
	 *
	 * @param spLitigationId the sp litigation ID
	 * @return the number of matching r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylitigationId(long spLitigationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LITIGATIONID;

		Object[] finderArgs = new Object[] { spLitigationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RDL_WHERE);

			query.append(_FINDER_COLUMN_LITIGATIONID_SPLITIGATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spLitigationId);

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

	private static final String _FINDER_COLUMN_LITIGATIONID_SPLITIGATIONID_2 = "rdl.spLitigationId = ?";

	public RDLPersistenceImpl() {
		setModelClass(RDL.class);
	}

	/**
	 * Caches the r d l in the entity cache if it is enabled.
	 *
	 * @param rdl the r d l
	 */
	@Override
	public void cacheResult(RDL rdl) {
		EntityCacheUtil.putResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLImpl.class, rdl.getPrimaryKey(), rdl);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { rdl.getUuid(), rdl.getGroupId() }, rdl);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
			new Object[] { rdl.getSpRdlId(), rdl.getSpLitigationId() }, rdl);

		rdl.resetOriginalValues();
	}

	/**
	 * Caches the r d ls in the entity cache if it is enabled.
	 *
	 * @param rdls the r d ls
	 */
	@Override
	public void cacheResult(List<RDL> rdls) {
		for (RDL rdl : rdls) {
			if (EntityCacheUtil.getResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
						RDLImpl.class, rdl.getPrimaryKey()) == null) {
				cacheResult(rdl);
			}
			else {
				rdl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d ls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDLImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDLImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d l.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RDL rdl) {
		EntityCacheUtil.removeResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLImpl.class, rdl.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rdl);
	}

	@Override
	public void clearCache(List<RDL> rdls) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDL rdl : rdls) {
			EntityCacheUtil.removeResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
				RDLImpl.class, rdl.getPrimaryKey());

			clearUniqueFindersCache(rdl);
		}
	}

	protected void cacheUniqueFindersCache(RDL rdl) {
		if (rdl.isNew()) {
			Object[] args = new Object[] { rdl.getUuid(), rdl.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, rdl);

			args = new Object[] { rdl.getSpRdlId(), rdl.getSpLitigationId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
				args, rdl);
		}
		else {
			RDLModelImpl rdlModelImpl = (RDLModelImpl)rdl;

			if ((rdlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rdl.getUuid(), rdl.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, rdl);
			}

			if ((rdlModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdl.getSpRdlId(), rdl.getSpLitigationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
					args, rdl);
			}
		}
	}

	protected void clearUniqueFindersCache(RDL rdl) {
		RDLModelImpl rdlModelImpl = (RDLModelImpl)rdl;

		Object[] args = new Object[] { rdl.getUuid(), rdl.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((rdlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					rdlModelImpl.getOriginalUuid(),
					rdlModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { rdl.getSpRdlId(), rdl.getSpLitigationId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
			args);

		if ((rdlModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID.getColumnBitmask()) != 0) {
			args = new Object[] {
					rdlModelImpl.getOriginalSpRdlId(),
					rdlModelImpl.getOriginalSpLitigationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RDLIDLITIGATIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RDLIDLITIGATIONID,
				args);
		}
	}

	/**
	 * Creates a new r d l with the primary key. Does not add the r d l to the database.
	 *
	 * @param spRdlId the primary key for the new r d l
	 * @return the new r d l
	 */
	@Override
	public RDL create(long spRdlId) {
		RDL rdl = new RDLImpl();

		rdl.setNew(true);
		rdl.setPrimaryKey(spRdlId);

		String uuid = PortalUUIDUtil.generate();

		rdl.setUuid(uuid);

		return rdl;
	}

	/**
	 * Removes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRdlId the primary key of the r d l
	 * @return the r d l that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL remove(long spRdlId) throws NoSuchRDLException, SystemException {
		return remove((Serializable)spRdlId);
	}

	/**
	 * Removes the r d l with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d l
	 * @return the r d l that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL remove(Serializable primaryKey)
		throws NoSuchRDLException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDL rdl = (RDL)session.get(RDLImpl.class, primaryKey);

			if (rdl == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdl);
		}
		catch (NoSuchRDLException nsee) {
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
	protected RDL removeImpl(RDL rdl) throws SystemException {
		rdl = toUnwrappedModel(rdl);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdl)) {
				rdl = (RDL)session.get(RDLImpl.class, rdl.getPrimaryKeyObj());
			}

			if (rdl != null) {
				session.delete(rdl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdl != null) {
			clearCache(rdl);
		}

		return rdl;
	}

	@Override
	public RDL updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.RDL rdl)
		throws SystemException {
		rdl = toUnwrappedModel(rdl);

		boolean isNew = rdl.isNew();

		RDLModelImpl rdlModelImpl = (RDLModelImpl)rdl;

		if (Validator.isNull(rdl.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			rdl.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (rdl.isNew()) {
				session.save(rdl);

				rdl.setNew(false);
			}
			else {
				session.merge(rdl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RDLModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rdlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rdlModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { rdlModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((rdlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdlModelImpl.getOriginalUuid(),
						rdlModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						rdlModelImpl.getUuid(), rdlModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((rdlModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LITIGATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rdlModelImpl.getOriginalSpLitigationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LITIGATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LITIGATIONID,
					args);

				args = new Object[] { rdlModelImpl.getSpLitigationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LITIGATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LITIGATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
			RDLImpl.class, rdl.getPrimaryKey(), rdl);

		clearUniqueFindersCache(rdl);
		cacheUniqueFindersCache(rdl);

		return rdl;
	}

	protected RDL toUnwrappedModel(RDL rdl) {
		if (rdl instanceof RDLImpl) {
			return rdl;
		}

		RDLImpl rdlImpl = new RDLImpl();

		rdlImpl.setNew(rdl.isNew());
		rdlImpl.setPrimaryKey(rdl.getPrimaryKey());

		rdlImpl.setUuid(rdl.getUuid());
		rdlImpl.setSpRdlId(rdl.getSpRdlId());
		rdlImpl.setSpLitigationId(rdl.getSpLitigationId());
		rdlImpl.setGroupId(rdl.getGroupId());
		rdlImpl.setCompanyId(rdl.getCompanyId());
		rdlImpl.setUserId(rdl.getUserId());
		rdlImpl.setUserName(rdl.getUserName());
		rdlImpl.setCreateDate(rdl.getCreateDate());
		rdlImpl.setModifiedDate(rdl.getModifiedDate());
		rdlImpl.setResponseDeadline(rdl.getResponseDeadline());
		rdlImpl.setClaimsRemarks(rdl.getClaimsRemarks());
		rdlImpl.setAlertBefore(rdl.getAlertBefore());

		return rdlImpl;
	}

	/**
	 * Returns the r d l with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d l
	 * @return the r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDLException, SystemException {
		RDL rdl = fetchByPrimaryKey(primaryKey);

		if (rdl == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDLException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdl;
	}

	/**
	 * Returns the r d l with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchRDLException} if it could not be found.
	 *
	 * @param spRdlId the primary key of the r d l
	 * @return the r d l
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchRDLException if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL findByPrimaryKey(long spRdlId)
		throws NoSuchRDLException, SystemException {
		return findByPrimaryKey((Serializable)spRdlId);
	}

	/**
	 * Returns the r d l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d l
	 * @return the r d l, or <code>null</code> if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDL rdl = (RDL)EntityCacheUtil.getResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
				RDLImpl.class, primaryKey);

		if (rdl == _nullRDL) {
			return null;
		}

		if (rdl == null) {
			Session session = null;

			try {
				session = openSession();

				rdl = (RDL)session.get(RDLImpl.class, primaryKey);

				if (rdl != null) {
					cacheResult(rdl);
				}
				else {
					EntityCacheUtil.putResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
						RDLImpl.class, primaryKey, _nullRDL);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDLModelImpl.ENTITY_CACHE_ENABLED,
					RDLImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdl;
	}

	/**
	 * Returns the r d l with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spRdlId the primary key of the r d l
	 * @return the r d l, or <code>null</code> if a r d l with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDL fetchByPrimaryKey(long spRdlId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spRdlId);
	}

	/**
	 * Returns all the r d ls.
	 *
	 * @return the r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @return the range of r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d ls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.RDLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d ls
	 * @param end the upper bound of the range of r d ls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d ls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDL> findAll(int start, int end,
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

		List<RDL> list = (List<RDL>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDL;

				if (pagination) {
					sql = sql.concat(RDLModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDL>(list);
				}
				else {
					list = (List<RDL>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the r d ls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDL rdl : findAll()) {
			remove(rdl);
		}
	}

	/**
	 * Returns the number of r d ls.
	 *
	 * @return the number of r d ls
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

				Query q = session.createQuery(_SQL_COUNT_RDL);

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
	 * Initializes the r d l persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.legalandcontract.model.RDL")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDL>> listenersList = new ArrayList<ModelListener<RDL>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDL>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDLImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDL = "SELECT rdl FROM RDL rdl";
	private static final String _SQL_SELECT_RDL_WHERE = "SELECT rdl FROM RDL rdl WHERE ";
	private static final String _SQL_COUNT_RDL = "SELECT COUNT(rdl) FROM RDL rdl";
	private static final String _SQL_COUNT_RDL_WHERE = "SELECT COUNT(rdl) FROM RDL rdl WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdl.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDL exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RDL exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDLPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RDL _nullRDL = new RDLImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDL> toCacheModel() {
				return _nullRDLCacheModel;
			}
		};

	private static CacheModel<RDL> _nullRDLCacheModel = new CacheModel<RDL>() {
			@Override
			public RDL toEntityModel() {
				return _nullRDL;
			}
		};
}