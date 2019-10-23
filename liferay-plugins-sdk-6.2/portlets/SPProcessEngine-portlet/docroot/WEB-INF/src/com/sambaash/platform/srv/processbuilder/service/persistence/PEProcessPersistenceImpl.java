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

import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException;
import com.sambaash.platform.srv.processbuilder.model.PEProcess;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e process service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessPersistence
 * @see PEProcessUtil
 * @generated
 */
public class PEProcessPersistenceImpl extends BasePersistenceImpl<PEProcess>
	implements PEProcessPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEProcessUtil} to access the p e process persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEProcessImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PEProcessModelImpl.UUID_COLUMN_BITMASK |
			PEProcessModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid(String uuid, int start, int end,
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

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcess peProcess : list) {
				if (!Validator.equals(uuid, peProcess.getUuid())) {
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

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

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
				query.append(PEProcessModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByUuid_First(uuid, orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the first p e process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcess> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByUuid_Last(uuid, orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the last p e process in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEProcess> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e processes before and after the current p e process in the ordered set where uuid = &#63;.
	 *
	 * @param spPEProcessId the primary key of the current p e process
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess[] findByUuid_PrevAndNext(long spPEProcessId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = findByPrimaryKey(spPEProcessId);

		Session session = null;

		try {
			session = openSession();

			PEProcess[] array = new PEProcessImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peProcess, uuid,
					orderByComparator, true);

			array[1] = peProcess;

			array[2] = getByUuid_PrevAndNext(session, peProcess, uuid,
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

	protected PEProcess getByUuid_PrevAndNext(Session session,
		PEProcess peProcess, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESS_WHERE);

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
			query.append(PEProcessModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e processes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEProcess peProcess : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcess);
		}
	}

	/**
	 * Returns the number of p e processes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e processes
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

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peProcess.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peProcess.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peProcess.uuid IS NULL OR peProcess.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessModelImpl.UUID_COLUMN_BITMASK |
			PEProcessModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e process where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByUUID_G(uuid, groupId);

		if (peProcess == null) {
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

			throw new NoSuchPEProcessException(msg.toString());
		}

		return peProcess;
	}

	/**
	 * Returns the p e process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e process where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEProcess) {
			PEProcess peProcess = (PEProcess)result;

			if (!Validator.equals(uuid, peProcess.getUuid()) ||
					(groupId != peProcess.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

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

				List<PEProcess> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEProcess peProcess = list.get(0);

					result = peProcess;

					cacheResult(peProcess);

					if ((peProcess.getUuid() == null) ||
							!peProcess.getUuid().equals(uuid) ||
							(peProcess.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peProcess);
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
			return (PEProcess)result;
		}
	}

	/**
	 * Removes the p e process where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e process that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = findByUUID_G(uuid, groupId);

		return remove(peProcess);
	}

	/**
	 * Returns the number of p e processes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e processes
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

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peProcess.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peProcess.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peProcess.uuid IS NULL OR peProcess.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peProcess.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessModelImpl.UUID_COLUMN_BITMASK |
			PEProcessModelImpl.COMPANYID_COLUMN_BITMASK |
			PEProcessModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByUuid_C(String uuid, long companyId, int start,
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

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcess peProcess : list) {
				if (!Validator.equals(uuid, peProcess.getUuid()) ||
						(companyId != peProcess.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

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
				query.append(PEProcessModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the first p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcess> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the last p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEProcess> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e processes before and after the current p e process in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEProcessId the primary key of the current p e process
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess[] findByUuid_C_PrevAndNext(long spPEProcessId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = findByPrimaryKey(spPEProcessId);

		Session session = null;

		try {
			session = openSession();

			PEProcess[] array = new PEProcessImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peProcess, uuid,
					companyId, orderByComparator, true);

			array[1] = peProcess;

			array[2] = getByUuid_C_PrevAndNext(session, peProcess, uuid,
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

	protected PEProcess getByUuid_C_PrevAndNext(Session session,
		PEProcess peProcess, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESS_WHERE);

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
			query.append(PEProcessModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e processes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEProcess peProcess : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcess);
		}
	}

	/**
	 * Returns the number of p e processes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e processes
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

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peProcess.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peProcess.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peProcess.uuid IS NULL OR peProcess.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peProcess.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Integer.class.getName() },
			PEProcessModelImpl.STATUS_COLUMN_BITMASK |
			PEProcessModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the p e processes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findBystatus(int status) throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findBystatus(int status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findBystatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcess peProcess : list) {
				if ((status != peProcess.getStatus())) {
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

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findBystatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchBystatus_First(status, orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the first p e process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchBystatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcess> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findBystatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchBystatus_Last(status, orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the last p e process in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchBystatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<PEProcess> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e processes before and after the current p e process in the ordered set where status = &#63;.
	 *
	 * @param spPEProcessId the primary key of the current p e process
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess[] findBystatus_PrevAndNext(long spPEProcessId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = findByPrimaryKey(spPEProcessId);

		Session session = null;

		try {
			session = openSession();

			PEProcess[] array = new PEProcessImpl[3];

			array[0] = getBystatus_PrevAndNext(session, peProcess, status,
					orderByComparator, true);

			array[1] = peProcess;

			array[2] = getBystatus_PrevAndNext(session, peProcess, status,
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

	protected PEProcess getBystatus_PrevAndNext(Session session,
		PEProcess peProcess, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESS_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(PEProcessModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcess);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcess> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e processes where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(int status) throws SystemException {
		for (PEProcess peProcess : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcess);
		}
	}

	/**
	 * Returns the number of p e processes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "peProcess.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByspPEProcessIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByspPEProcessIds",
			new String[] { Long.class.getName() },
			PEProcessModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPPEPROCESSIDS = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspPEProcessIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByspPEProcessIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e processes where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long spPEProcessId)
		throws SystemException {
		return findByspPEProcessIds(spPEProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long spPEProcessId, int start,
		int end) throws SystemException {
		return findByspPEProcessIds(spPEProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long spPEProcessId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS;
			finderArgs = new Object[] { spPEProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS;
			finderArgs = new Object[] {
					spPEProcessId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcess peProcess : list) {
				if ((spPEProcessId != peProcess.getSpPEProcessId())) {
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

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				if (!pagination) {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e process in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByspPEProcessIds_First(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByspPEProcessIds_First(spPEProcessId,
				orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the first p e process in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByspPEProcessIds_First(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcess> list = findByspPEProcessIds(spPEProcessId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByspPEProcessIds_Last(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByspPEProcessIds_Last(spPEProcessId,
				orderByComparator);

		if (peProcess != null) {
			return peProcess;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessException(msg.toString());
	}

	/**
	 * Returns the last p e process in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByspPEProcessIds_Last(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByspPEProcessIds(spPEProcessId);

		if (count == 0) {
			return null;
		}

		List<PEProcess> list = findByspPEProcessIds(spPEProcessId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the p e processes where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @return the matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long[] spPEProcessIds)
		throws SystemException {
		return findByspPEProcessIds(spPEProcessIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long[] spPEProcessIds,
		int start, int end) throws SystemException {
		return findByspPEProcessIds(spPEProcessIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findByspPEProcessIds(long[] spPEProcessIds,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((spPEProcessIds != null) && (spPEProcessIds.length == 1)) {
			return findByspPEProcessIds(spPEProcessIds[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(spPEProcessIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(spPEProcessIds),
					
					start, end, orderByComparator
				};
		}

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcess peProcess : list) {
				if (!ArrayUtil.contains(spPEProcessIds,
							peProcess.getSpPEProcessId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS,
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
	 * Removes all the p e processes where spPEProcessId = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByspPEProcessIds(long spPEProcessId)
		throws SystemException {
		for (PEProcess peProcess : findByspPEProcessIds(spPEProcessId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcess);
		}
	}

	/**
	 * Returns the number of p e processes where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the number of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByspPEProcessIds(long spPEProcessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPPEPROCESSIDS;

		Object[] finderArgs = new Object[] { spPEProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

			query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2);

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

	/**
	 * Returns the number of p e processes where spPEProcessId = any &#63;.
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @return the number of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByspPEProcessIds(long[] spPEProcessIds)
		throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(spPEProcessIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SPPEPROCESSIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

			boolean conjunctionable = false;

			if ((spPEProcessIds == null) || (spPEProcessIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEProcessIds.length; i++) {
					query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_5);

					if ((i + 1) < spPEProcessIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
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

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SPPEPROCESSIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_SPPEPROCESSIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2 = "peProcess.spPEProcessId = ?";
	private static final String _FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2) + ")";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSNAME = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, PEProcessImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByProcessName",
			new String[] { String.class.getName() },
			PEProcessModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSNAME = new FinderPath(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProcessName",
			new String[] { String.class.getName() });

	/**
	 * Returns the p e process where name = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByProcessName(String name)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByProcessName(name);

		if (peProcess == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPEProcessException(msg.toString());
		}

		return peProcess;
	}

	/**
	 * Returns the p e process where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByProcessName(String name) throws SystemException {
		return fetchByProcessName(name, true);
	}

	/**
	 * Returns the p e process where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process, or <code>null</code> if a matching p e process could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByProcessName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
					finderArgs, this);
		}

		if (result instanceof PEProcess) {
			PEProcess peProcess = (PEProcess)result;

			if (!Validator.equals(name, peProcess.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PEPROCESS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<PEProcess> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PEProcessPersistenceImpl.fetchByProcessName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PEProcess peProcess = list.get(0);

					result = peProcess;

					cacheResult(peProcess);

					if ((peProcess.getName() == null) ||
							!peProcess.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
							finderArgs, peProcess);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
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
			return (PEProcess)result;
		}
	}

	/**
	 * Removes the p e process where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the p e process that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess removeByProcessName(String name)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = findByProcessName(name);

		return remove(peProcess);
	}

	/**
	 * Returns the number of p e processes where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_PROCESSNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_PROCESSNAME_NAME_1 = "peProcess.name IS NULL";
	private static final String _FINDER_COLUMN_PROCESSNAME_NAME_2 = "peProcess.name = ?";
	private static final String _FINDER_COLUMN_PROCESSNAME_NAME_3 = "(peProcess.name IS NULL OR peProcess.name = '')";

	public PEProcessPersistenceImpl() {
		setModelClass(PEProcess.class);
	}

	/**
	 * Caches the p e process in the entity cache if it is enabled.
	 *
	 * @param peProcess the p e process
	 */
	@Override
	public void cacheResult(PEProcess peProcess) {
		EntityCacheUtil.putResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessImpl.class, peProcess.getPrimaryKey(), peProcess);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peProcess.getUuid(), peProcess.getGroupId() },
			peProcess);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
			new Object[] { peProcess.getName() }, peProcess);

		peProcess.resetOriginalValues();
	}

	/**
	 * Caches the p e processes in the entity cache if it is enabled.
	 *
	 * @param peProcesses the p e processes
	 */
	@Override
	public void cacheResult(List<PEProcess> peProcesses) {
		for (PEProcess peProcess : peProcesses) {
			if (EntityCacheUtil.getResult(
						PEProcessModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessImpl.class, peProcess.getPrimaryKey()) == null) {
				cacheResult(peProcess);
			}
			else {
				peProcess.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e processes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEProcessImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEProcessImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e process.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEProcess peProcess) {
		EntityCacheUtil.removeResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessImpl.class, peProcess.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peProcess);
	}

	@Override
	public void clearCache(List<PEProcess> peProcesses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEProcess peProcess : peProcesses) {
			EntityCacheUtil.removeResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessImpl.class, peProcess.getPrimaryKey());

			clearUniqueFindersCache(peProcess);
		}
	}

	protected void cacheUniqueFindersCache(PEProcess peProcess) {
		if (peProcess.isNew()) {
			Object[] args = new Object[] {
					peProcess.getUuid(), peProcess.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peProcess);

			args = new Object[] { peProcess.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSNAME, args,
				peProcess);
		}
		else {
			PEProcessModelImpl peProcessModelImpl = (PEProcessModelImpl)peProcess;

			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcess.getUuid(), peProcess.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peProcess);
			}

			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROCESSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { peProcess.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSNAME,
					args, peProcess);
			}
		}
	}

	protected void clearUniqueFindersCache(PEProcess peProcess) {
		PEProcessModelImpl peProcessModelImpl = (PEProcessModelImpl)peProcess;

		Object[] args = new Object[] { peProcess.getUuid(), peProcess.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peProcessModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessModelImpl.getOriginalUuid(),
					peProcessModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { peProcess.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSNAME, args);

		if ((peProcessModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSNAME.getColumnBitmask()) != 0) {
			args = new Object[] { peProcessModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSNAME, args);
		}
	}

	/**
	 * Creates a new p e process with the primary key. Does not add the p e process to the database.
	 *
	 * @param spPEProcessId the primary key for the new p e process
	 * @return the new p e process
	 */
	@Override
	public PEProcess create(long spPEProcessId) {
		PEProcess peProcess = new PEProcessImpl();

		peProcess.setNew(true);
		peProcess.setPrimaryKey(spPEProcessId);

		String uuid = PortalUUIDUtil.generate();

		peProcess.setUuid(uuid);

		return peProcess;
	}

	/**
	 * Removes the p e process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessId the primary key of the p e process
	 * @return the p e process that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess remove(long spPEProcessId)
		throws NoSuchPEProcessException, SystemException {
		return remove((Serializable)spPEProcessId);
	}

	/**
	 * Removes the p e process with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e process
	 * @return the p e process that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess remove(Serializable primaryKey)
		throws NoSuchPEProcessException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEProcess peProcess = (PEProcess)session.get(PEProcessImpl.class,
					primaryKey);

			if (peProcess == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peProcess);
		}
		catch (NoSuchPEProcessException nsee) {
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
	protected PEProcess removeImpl(PEProcess peProcess)
		throws SystemException {
		peProcess = toUnwrappedModel(peProcess);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peProcess)) {
				peProcess = (PEProcess)session.get(PEProcessImpl.class,
						peProcess.getPrimaryKeyObj());
			}

			if (peProcess != null) {
				session.delete(peProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peProcess != null) {
			clearCache(peProcess);
		}

		return peProcess;
	}

	@Override
	public PEProcess updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess)
		throws SystemException {
		peProcess = toUnwrappedModel(peProcess);

		boolean isNew = peProcess.isNew();

		PEProcessModelImpl peProcessModelImpl = (PEProcessModelImpl)peProcess;

		if (Validator.isNull(peProcess.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peProcess.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peProcess.isNew()) {
				session.save(peProcess);

				peProcess.setNew(false);
			}
			else {
				session.merge(peProcess);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEProcessModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peProcessModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessModelImpl.getOriginalUuid(),
						peProcessModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peProcessModelImpl.getUuid(),
						peProcessModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { peProcessModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((peProcessModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessModelImpl.getOriginalSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS,
					args);

				args = new Object[] { peProcessModelImpl.getSpPEProcessId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessImpl.class, peProcess.getPrimaryKey(), peProcess);

		clearUniqueFindersCache(peProcess);
		cacheUniqueFindersCache(peProcess);

		return peProcess;
	}

	protected PEProcess toUnwrappedModel(PEProcess peProcess) {
		if (peProcess instanceof PEProcessImpl) {
			return peProcess;
		}

		PEProcessImpl peProcessImpl = new PEProcessImpl();

		peProcessImpl.setNew(peProcess.isNew());
		peProcessImpl.setPrimaryKey(peProcess.getPrimaryKey());

		peProcessImpl.setUuid(peProcess.getUuid());
		peProcessImpl.setSpPEProcessId(peProcess.getSpPEProcessId());
		peProcessImpl.setGroupId(peProcess.getGroupId());
		peProcessImpl.setCompanyId(peProcess.getCompanyId());
		peProcessImpl.setUserId(peProcess.getUserId());
		peProcessImpl.setUserName(peProcess.getUserName());
		peProcessImpl.setCreateDate(peProcess.getCreateDate());
		peProcessImpl.setModifiedDate(peProcess.getModifiedDate());
		peProcessImpl.setName(peProcess.getName());
		peProcessImpl.setDefiniton(peProcess.getDefiniton());
		peProcessImpl.setEntityClassId(peProcess.getEntityClassId());
		peProcessImpl.setAgentEnabled(peProcess.isAgentEnabled());
		peProcessImpl.setAgentRoleIds(peProcess.getAgentRoleIds());
		peProcessImpl.setApproveRoleIds(peProcess.getApproveRoleIds());
		peProcessImpl.setMiscData(peProcess.getMiscData());
		peProcessImpl.setDiagramData(peProcess.getDiagramData());
		peProcessImpl.setEntityTitle(peProcess.getEntityTitle());
		peProcessImpl.setApproverPageName(peProcess.getApproverPageName());
		peProcessImpl.setUserPageName(peProcess.getUserPageName());
		peProcessImpl.setAgentPageName(peProcess.getAgentPageName());
		peProcessImpl.setStatus(peProcess.getStatus());
		peProcessImpl.setApplicantRoleId(peProcess.getApplicantRoleId());
		peProcessImpl.setSupervisorRoleIds(peProcess.getSupervisorRoleIds());
		peProcessImpl.setSupervisorPageName(peProcess.getSupervisorPageName());
		peProcessImpl.setClosedReasonVocId(peProcess.getClosedReasonVocId());
		peProcessImpl.setAccountCreationEmailEnabled(peProcess.isAccountCreationEmailEnabled());
		peProcessImpl.setEnableAssignment(peProcess.isEnableAssignment());
		peProcessImpl.setEditFeeDetails(peProcess.isEditFeeDetails());
		peProcessImpl.setScheduleModelId(peProcess.getScheduleModelId());
		peProcessImpl.setEnableSingleSubmission(peProcess.isEnableSingleSubmission());
		peProcessImpl.setOrientation(peProcess.getOrientation());
		peProcessImpl.setShowHeader(peProcess.isShowHeader());
		peProcessImpl.setEnableFirstStepProgress(peProcess.isEnableFirstStepProgress());
		peProcessImpl.setSubProductTypeId(peProcess.getSubProductTypeId());
		peProcessImpl.setProductTypeId(peProcess.getProductTypeId());
		peProcessImpl.setSingleSubmissionErrorMsg(peProcess.getSingleSubmissionErrorMsg());

		return peProcessImpl;
	}

	/**
	 * Returns the p e process with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process
	 * @return the p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEProcessException, SystemException {
		PEProcess peProcess = fetchByPrimaryKey(primaryKey);

		if (peProcess == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEProcessException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peProcess;
	}

	/**
	 * Returns the p e process with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException} if it could not be found.
	 *
	 * @param spPEProcessId the primary key of the p e process
	 * @return the p e process
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessException if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess findByPrimaryKey(long spPEProcessId)
		throws NoSuchPEProcessException, SystemException {
		return findByPrimaryKey((Serializable)spPEProcessId);
	}

	/**
	 * Returns the p e process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process
	 * @return the p e process, or <code>null</code> if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEProcess peProcess = (PEProcess)EntityCacheUtil.getResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessImpl.class, primaryKey);

		if (peProcess == _nullPEProcess) {
			return null;
		}

		if (peProcess == null) {
			Session session = null;

			try {
				session = openSession();

				peProcess = (PEProcess)session.get(PEProcessImpl.class,
						primaryKey);

				if (peProcess != null) {
					cacheResult(peProcess);
				}
				else {
					EntityCacheUtil.putResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessImpl.class, primaryKey, _nullPEProcess);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEProcessModelImpl.ENTITY_CACHE_ENABLED,
					PEProcessImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peProcess;
	}

	/**
	 * Returns the p e process with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEProcessId the primary key of the p e process
	 * @return the p e process, or <code>null</code> if a p e process with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcess fetchByPrimaryKey(long spPEProcessId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEProcessId);
	}

	/**
	 * Returns all the p e processes.
	 *
	 * @return the p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @return the range of p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e processes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e processes
	 * @param end the upper bound of the range of p e processes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e processes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcess> findAll(int start, int end,
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

		List<PEProcess> list = (List<PEProcess>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEPROCESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEPROCESS;

				if (pagination) {
					sql = sql.concat(PEProcessModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcess>(list);
				}
				else {
					list = (List<PEProcess>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the p e processes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEProcess peProcess : findAll()) {
			remove(peProcess);
		}
	}

	/**
	 * Returns the number of p e processes.
	 *
	 * @return the number of p e processes
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

				Query q = session.createQuery(_SQL_COUNT_PEPROCESS);

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
	 * Initializes the p e process persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEProcess")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEProcess>> listenersList = new ArrayList<ModelListener<PEProcess>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEProcess>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEProcessImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEPROCESS = "SELECT peProcess FROM PEProcess peProcess";
	private static final String _SQL_SELECT_PEPROCESS_WHERE = "SELECT peProcess FROM PEProcess peProcess WHERE ";
	private static final String _SQL_COUNT_PEPROCESS = "SELECT COUNT(peProcess) FROM PEProcess peProcess";
	private static final String _SQL_COUNT_PEPROCESS_WHERE = "SELECT COUNT(peProcess) FROM PEProcess peProcess WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peProcess.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEProcess exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEProcess exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEProcessPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PEProcess _nullPEProcess = new PEProcessImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEProcess> toCacheModel() {
				return _nullPEProcessCacheModel;
			}
		};

	private static CacheModel<PEProcess> _nullPEProcessCacheModel = new CacheModel<PEProcess>() {
			@Override
			public PEProcess toEntityModel() {
				return _nullPEProcess;
			}
		};
}