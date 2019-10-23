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

import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e process status type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStatusTypePersistence
 * @see PEProcessStatusTypeUtil
 * @generated
 */
public class PEProcessStatusTypePersistenceImpl extends BasePersistenceImpl<PEProcessStatusType>
	implements PEProcessStatusTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEProcessStatusTypeUtil} to access the p e process status type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEProcessStatusTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PEProcessStatusTypeModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e process status types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStatusType peProcessStatusType : list) {
				if (!Validator.equals(uuid, peProcessStatusType.getUuid())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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
				query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
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
	 * Returns the first p e process status type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByUuid_First(uuid,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the first p e process status type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStatusType> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process status type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByUuid_Last(uuid,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the last p e process status type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEProcessStatusType> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process status types before and after the current p e process status type in the ordered set where uuid = &#63;.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the current p e process status type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType[] findByUuid_PrevAndNext(
		long spPEProcessStatusTypeId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = findByPrimaryKey(spPEProcessStatusTypeId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStatusType[] array = new PEProcessStatusTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peProcessStatusType,
					uuid, orderByComparator, true);

			array[1] = peProcessStatusType;

			array[2] = getByUuid_PrevAndNext(session, peProcessStatusType,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessStatusType getByUuid_PrevAndNext(Session session,
		PEProcessStatusType peProcessStatusType, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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
			query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStatusType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStatusType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process status types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEProcessStatusType peProcessStatusType : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStatusType);
		}
	}

	/**
	 * Returns the number of p e process status types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e process status types
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

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peProcessStatusType.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peProcessStatusType.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peProcessStatusType.uuid IS NULL OR peProcessStatusType.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStatusTypeModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e process status type where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByUUID_G(uuid, groupId);

		if (peProcessStatusType == null) {
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

			throw new NoSuchPEProcessStatusTypeException(msg.toString());
		}

		return peProcessStatusType;
	}

	/**
	 * Returns the p e process status type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e process status type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEProcessStatusType) {
			PEProcessStatusType peProcessStatusType = (PEProcessStatusType)result;

			if (!Validator.equals(uuid, peProcessStatusType.getUuid()) ||
					(groupId != peProcessStatusType.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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

				List<PEProcessStatusType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEProcessStatusType peProcessStatusType = list.get(0);

					result = peProcessStatusType;

					cacheResult(peProcessStatusType);

					if ((peProcessStatusType.getUuid() == null) ||
							!peProcessStatusType.getUuid().equals(uuid) ||
							(peProcessStatusType.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peProcessStatusType);
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
			return (PEProcessStatusType)result;
		}
	}

	/**
	 * Removes the p e process status type where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e process status type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = findByUUID_G(uuid, groupId);

		return remove(peProcessStatusType);
	}

	/**
	 * Returns the number of p e process status types where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e process status types
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

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peProcessStatusType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peProcessStatusType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peProcessStatusType.uuid IS NULL OR peProcessStatusType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peProcessStatusType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStatusTypeModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.COMPANYID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process status types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByUuid_C(String uuid, long companyId,
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

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStatusType peProcessStatusType : list) {
				if (!Validator.equals(uuid, peProcessStatusType.getUuid()) ||
						(companyId != peProcessStatusType.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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
				query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
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
	 * Returns the first p e process status type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the first p e process status type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStatusType> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process status type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the last p e process status type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEProcessStatusType> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process status types before and after the current p e process status type in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the current p e process status type
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType[] findByUuid_C_PrevAndNext(
		long spPEProcessStatusTypeId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = findByPrimaryKey(spPEProcessStatusTypeId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStatusType[] array = new PEProcessStatusTypeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peProcessStatusType,
					uuid, companyId, orderByComparator, true);

			array[1] = peProcessStatusType;

			array[2] = getByUuid_C_PrevAndNext(session, peProcessStatusType,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessStatusType getByUuid_C_PrevAndNext(Session session,
		PEProcessStatusType peProcessStatusType, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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
			query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStatusType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStatusType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process status types where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEProcessStatusType peProcessStatusType : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStatusType);
		}
	}

	/**
	 * Returns the number of p e process status types where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e process status types
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

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peProcessStatusType.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peProcessStatusType.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peProcessStatusType.uuid IS NULL OR peProcessStatusType.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peProcessStatusType.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSID =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByspPEProcessId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSID =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByspPEProcessId",
			new String[] { Long.class.getName() },
			PEProcessStatusTypeModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPPEPROCESSID = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspPEProcessId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e process status types where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessId(long spPEProcessId)
		throws SystemException {
		return findByspPEProcessId(spPEProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessId(long spPEProcessId,
		int start, int end) throws SystemException {
		return findByspPEProcessId(spPEProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessId(long spPEProcessId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSID;
			finderArgs = new Object[] { spPEProcessId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSID;
			finderArgs = new Object[] {
					spPEProcessId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStatusType peProcessStatusType : list) {
				if ((spPEProcessId != peProcessStatusType.getSpPEProcessId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPPEPROCESSID_SPPEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				if (!pagination) {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
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
	 * Returns the first p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByspPEProcessId_First(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByspPEProcessId_First(spPEProcessId,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the first p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByspPEProcessId_First(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStatusType> list = findByspPEProcessId(spPEProcessId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByspPEProcessId_Last(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByspPEProcessId_Last(spPEProcessId,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the last p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByspPEProcessId_Last(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByspPEProcessId(spPEProcessId);

		if (count == 0) {
			return null;
		}

		List<PEProcessStatusType> list = findByspPEProcessId(spPEProcessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process status types before and after the current p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the current p e process status type
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType[] findByspPEProcessId_PrevAndNext(
		long spPEProcessStatusTypeId, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = findByPrimaryKey(spPEProcessStatusTypeId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStatusType[] array = new PEProcessStatusTypeImpl[3];

			array[0] = getByspPEProcessId_PrevAndNext(session,
					peProcessStatusType, spPEProcessId, orderByComparator, true);

			array[1] = peProcessStatusType;

			array[2] = getByspPEProcessId_PrevAndNext(session,
					peProcessStatusType, spPEProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessStatusType getByspPEProcessId_PrevAndNext(
		Session session, PEProcessStatusType peProcessStatusType,
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

		query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

		query.append(_FINDER_COLUMN_SPPEPROCESSID_SPPEPROCESSID_2);

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
			query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStatusType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStatusType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process status types where spPEProcessId = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByspPEProcessId(long spPEProcessId)
		throws SystemException {
		for (PEProcessStatusType peProcessStatusType : findByspPEProcessId(
				spPEProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStatusType);
		}
	}

	/**
	 * Returns the number of p e process status types where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the number of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByspPEProcessId(long spPEProcessId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPPEPROCESSID;

		Object[] finderArgs = new Object[] { spPEProcessId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPPEPROCESSID_SPPEPROCESSID_2);

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

	private static final String _FINDER_COLUMN_SPPEPROCESSID_SPPEPROCESSID_2 = "peProcessStatusType.spPEProcessId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByspPEProcessIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByspPEProcessIds",
			new String[] { Long.class.getName() },
			PEProcessStatusTypeModelImpl.SPPEPROCESSID_COLUMN_BITMASK |
			PEProcessStatusTypeModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPPEPROCESSIDS = new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspPEProcessIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SPPEPROCESSIDS =
		new FinderPath(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByspPEProcessIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e process status types where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(long spPEProcessId)
		throws SystemException {
		return findByspPEProcessIds(spPEProcessId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(long spPEProcessId,
		int start, int end) throws SystemException {
		return findByspPEProcessIds(spPEProcessId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types where spPEProcessId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(long spPEProcessId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStatusType peProcessStatusType : list) {
				if ((spPEProcessId != peProcessStatusType.getSpPEProcessId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

			query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessId);

				if (!pagination) {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
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
	 * Returns the first p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByspPEProcessIds_First(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByspPEProcessIds_First(spPEProcessId,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the first p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByspPEProcessIds_First(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStatusType> list = findByspPEProcessIds(spPEProcessId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByspPEProcessIds_Last(long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByspPEProcessIds_Last(spPEProcessId,
				orderByComparator);

		if (peProcessStatusType != null) {
			return peProcessStatusType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessId=");
		msg.append(spPEProcessId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStatusTypeException(msg.toString());
	}

	/**
	 * Returns the last p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process status type, or <code>null</code> if a matching p e process status type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByspPEProcessIds_Last(long spPEProcessId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByspPEProcessIds(spPEProcessId);

		if (count == 0) {
			return null;
		}

		List<PEProcessStatusType> list = findByspPEProcessIds(spPEProcessId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process status types before and after the current p e process status type in the ordered set where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the current p e process status type
	 * @param spPEProcessId the sp p e process ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType[] findByspPEProcessIds_PrevAndNext(
		long spPEProcessStatusTypeId, long spPEProcessId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = findByPrimaryKey(spPEProcessStatusTypeId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStatusType[] array = new PEProcessStatusTypeImpl[3];

			array[0] = getByspPEProcessIds_PrevAndNext(session,
					peProcessStatusType, spPEProcessId, orderByComparator, true);

			array[1] = peProcessStatusType;

			array[2] = getByspPEProcessIds_PrevAndNext(session,
					peProcessStatusType, spPEProcessId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessStatusType getByspPEProcessIds_PrevAndNext(
		Session session, PEProcessStatusType peProcessStatusType,
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

		query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

		query.append(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2);

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
			query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStatusType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStatusType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the p e process status types where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @return the matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(long[] spPEProcessIds)
		throws SystemException {
		return findByspPEProcessIds(spPEProcessIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(
		long[] spPEProcessIds, int start, int end) throws SystemException {
		return findByspPEProcessIds(spPEProcessIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types where spPEProcessId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findByspPEProcessIds(
		long[] spPEProcessIds, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_SPPEPROCESSIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStatusType peProcessStatusType : list) {
				if (!ArrayUtil.contains(spPEProcessIds,
							peProcessStatusType.getSpPEProcessId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE);

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
				query.append(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the p e process status types where spPEProcessId = &#63; from the database.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByspPEProcessIds(long spPEProcessId)
		throws SystemException {
		for (PEProcessStatusType peProcessStatusType : findByspPEProcessIds(
				spPEProcessId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStatusType);
		}
	}

	/**
	 * Returns the number of p e process status types where spPEProcessId = &#63;.
	 *
	 * @param spPEProcessId the sp p e process ID
	 * @return the number of matching p e process status types
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

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

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
	 * Returns the number of p e process status types where spPEProcessId = any &#63;.
	 *
	 * @param spPEProcessIds the sp p e process IDs
	 * @return the number of matching p e process status types
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

			query.append(_SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2 = "peProcessStatusType.spPEProcessId = ?";
	private static final String _FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_SPPEPROCESSIDS_SPPEPROCESSID_2) + ")";

	public PEProcessStatusTypePersistenceImpl() {
		setModelClass(PEProcessStatusType.class);
	}

	/**
	 * Caches the p e process status type in the entity cache if it is enabled.
	 *
	 * @param peProcessStatusType the p e process status type
	 */
	@Override
	public void cacheResult(PEProcessStatusType peProcessStatusType) {
		EntityCacheUtil.putResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class, peProcessStatusType.getPrimaryKey(),
			peProcessStatusType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				peProcessStatusType.getUuid(), peProcessStatusType.getGroupId()
			}, peProcessStatusType);

		peProcessStatusType.resetOriginalValues();
	}

	/**
	 * Caches the p e process status types in the entity cache if it is enabled.
	 *
	 * @param peProcessStatusTypes the p e process status types
	 */
	@Override
	public void cacheResult(List<PEProcessStatusType> peProcessStatusTypes) {
		for (PEProcessStatusType peProcessStatusType : peProcessStatusTypes) {
			if (EntityCacheUtil.getResult(
						PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStatusTypeImpl.class,
						peProcessStatusType.getPrimaryKey()) == null) {
				cacheResult(peProcessStatusType);
			}
			else {
				peProcessStatusType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e process status types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEProcessStatusTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEProcessStatusTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e process status type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEProcessStatusType peProcessStatusType) {
		EntityCacheUtil.removeResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class, peProcessStatusType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peProcessStatusType);
	}

	@Override
	public void clearCache(List<PEProcessStatusType> peProcessStatusTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEProcessStatusType peProcessStatusType : peProcessStatusTypes) {
			EntityCacheUtil.removeResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStatusTypeImpl.class,
				peProcessStatusType.getPrimaryKey());

			clearUniqueFindersCache(peProcessStatusType);
		}
	}

	protected void cacheUniqueFindersCache(
		PEProcessStatusType peProcessStatusType) {
		if (peProcessStatusType.isNew()) {
			Object[] args = new Object[] {
					peProcessStatusType.getUuid(),
					peProcessStatusType.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peProcessStatusType);
		}
		else {
			PEProcessStatusTypeModelImpl peProcessStatusTypeModelImpl = (PEProcessStatusTypeModelImpl)peProcessStatusType;

			if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStatusType.getUuid(),
						peProcessStatusType.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peProcessStatusType);
			}
		}
	}

	protected void clearUniqueFindersCache(
		PEProcessStatusType peProcessStatusType) {
		PEProcessStatusTypeModelImpl peProcessStatusTypeModelImpl = (PEProcessStatusTypeModelImpl)peProcessStatusType;

		Object[] args = new Object[] {
				peProcessStatusType.getUuid(), peProcessStatusType.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessStatusTypeModelImpl.getOriginalUuid(),
					peProcessStatusTypeModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new p e process status type with the primary key. Does not add the p e process status type to the database.
	 *
	 * @param spPEProcessStatusTypeId the primary key for the new p e process status type
	 * @return the new p e process status type
	 */
	@Override
	public PEProcessStatusType create(long spPEProcessStatusTypeId) {
		PEProcessStatusType peProcessStatusType = new PEProcessStatusTypeImpl();

		peProcessStatusType.setNew(true);
		peProcessStatusType.setPrimaryKey(spPEProcessStatusTypeId);

		String uuid = PortalUUIDUtil.generate();

		peProcessStatusType.setUuid(uuid);

		return peProcessStatusType;
	}

	/**
	 * Removes the p e process status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the p e process status type
	 * @return the p e process status type that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType remove(long spPEProcessStatusTypeId)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		return remove((Serializable)spPEProcessStatusTypeId);
	}

	/**
	 * Removes the p e process status type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e process status type
	 * @return the p e process status type that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType remove(Serializable primaryKey)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEProcessStatusType peProcessStatusType = (PEProcessStatusType)session.get(PEProcessStatusTypeImpl.class,
					primaryKey);

			if (peProcessStatusType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEProcessStatusTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peProcessStatusType);
		}
		catch (NoSuchPEProcessStatusTypeException nsee) {
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
	protected PEProcessStatusType removeImpl(
		PEProcessStatusType peProcessStatusType) throws SystemException {
		peProcessStatusType = toUnwrappedModel(peProcessStatusType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peProcessStatusType)) {
				peProcessStatusType = (PEProcessStatusType)session.get(PEProcessStatusTypeImpl.class,
						peProcessStatusType.getPrimaryKeyObj());
			}

			if (peProcessStatusType != null) {
				session.delete(peProcessStatusType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peProcessStatusType != null) {
			clearCache(peProcessStatusType);
		}

		return peProcessStatusType;
	}

	@Override
	public PEProcessStatusType updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType peProcessStatusType)
		throws SystemException {
		peProcessStatusType = toUnwrappedModel(peProcessStatusType);

		boolean isNew = peProcessStatusType.isNew();

		PEProcessStatusTypeModelImpl peProcessStatusTypeModelImpl = (PEProcessStatusTypeModelImpl)peProcessStatusType;

		if (Validator.isNull(peProcessStatusType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peProcessStatusType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peProcessStatusType.isNew()) {
				session.save(peProcessStatusType);

				peProcessStatusType.setNew(false);
			}
			else {
				session.merge(peProcessStatusType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEProcessStatusTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStatusTypeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peProcessStatusTypeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStatusTypeModelImpl.getOriginalUuid(),
						peProcessStatusTypeModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peProcessStatusTypeModelImpl.getUuid(),
						peProcessStatusTypeModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStatusTypeModelImpl.getOriginalSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSID,
					args);

				args = new Object[] {
						peProcessStatusTypeModelImpl.getSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSID,
					args);
			}

			if ((peProcessStatusTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStatusTypeModelImpl.getOriginalSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS,
					args);

				args = new Object[] {
						peProcessStatusTypeModelImpl.getSpPEProcessId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPPEPROCESSIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPPEPROCESSIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStatusTypeImpl.class, peProcessStatusType.getPrimaryKey(),
			peProcessStatusType);

		clearUniqueFindersCache(peProcessStatusType);
		cacheUniqueFindersCache(peProcessStatusType);

		return peProcessStatusType;
	}

	protected PEProcessStatusType toUnwrappedModel(
		PEProcessStatusType peProcessStatusType) {
		if (peProcessStatusType instanceof PEProcessStatusTypeImpl) {
			return peProcessStatusType;
		}

		PEProcessStatusTypeImpl peProcessStatusTypeImpl = new PEProcessStatusTypeImpl();

		peProcessStatusTypeImpl.setNew(peProcessStatusType.isNew());
		peProcessStatusTypeImpl.setPrimaryKey(peProcessStatusType.getPrimaryKey());

		peProcessStatusTypeImpl.setUuid(peProcessStatusType.getUuid());
		peProcessStatusTypeImpl.setSpPEProcessStatusTypeId(peProcessStatusType.getSpPEProcessStatusTypeId());
		peProcessStatusTypeImpl.setGroupId(peProcessStatusType.getGroupId());
		peProcessStatusTypeImpl.setCompanyId(peProcessStatusType.getCompanyId());
		peProcessStatusTypeImpl.setUserId(peProcessStatusType.getUserId());
		peProcessStatusTypeImpl.setUserName(peProcessStatusType.getUserName());
		peProcessStatusTypeImpl.setCreateDate(peProcessStatusType.getCreateDate());
		peProcessStatusTypeImpl.setModifiedDate(peProcessStatusType.getModifiedDate());
		peProcessStatusTypeImpl.setSpPEProcessId(peProcessStatusType.getSpPEProcessId());
		peProcessStatusTypeImpl.setStatusName(peProcessStatusType.getStatusName());
		peProcessStatusTypeImpl.setSeqNo(peProcessStatusType.getSeqNo());
		peProcessStatusTypeImpl.setApproveTemplateId(peProcessStatusType.getApproveTemplateId());
		peProcessStatusTypeImpl.setRejectTemplateId(peProcessStatusType.getRejectTemplateId());
		peProcessStatusTypeImpl.setSpPEProcessStageId(peProcessStatusType.getSpPEProcessStageId());

		return peProcessStatusTypeImpl;
	}

	/**
	 * Returns the p e process status type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process status type
	 * @return the p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		PEProcessStatusType peProcessStatusType = fetchByPrimaryKey(primaryKey);

		if (peProcessStatusType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEProcessStatusTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peProcessStatusType;
	}

	/**
	 * Returns the p e process status type with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException} if it could not be found.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the p e process status type
	 * @return the p e process status type
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStatusTypeException if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType findByPrimaryKey(long spPEProcessStatusTypeId)
		throws NoSuchPEProcessStatusTypeException, SystemException {
		return findByPrimaryKey((Serializable)spPEProcessStatusTypeId);
	}

	/**
	 * Returns the p e process status type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process status type
	 * @return the p e process status type, or <code>null</code> if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEProcessStatusType peProcessStatusType = (PEProcessStatusType)EntityCacheUtil.getResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStatusTypeImpl.class, primaryKey);

		if (peProcessStatusType == _nullPEProcessStatusType) {
			return null;
		}

		if (peProcessStatusType == null) {
			Session session = null;

			try {
				session = openSession();

				peProcessStatusType = (PEProcessStatusType)session.get(PEProcessStatusTypeImpl.class,
						primaryKey);

				if (peProcessStatusType != null) {
					cacheResult(peProcessStatusType);
				}
				else {
					EntityCacheUtil.putResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStatusTypeImpl.class, primaryKey,
						_nullPEProcessStatusType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEProcessStatusTypeModelImpl.ENTITY_CACHE_ENABLED,
					PEProcessStatusTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peProcessStatusType;
	}

	/**
	 * Returns the p e process status type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEProcessStatusTypeId the primary key of the p e process status type
	 * @return the p e process status type, or <code>null</code> if a p e process status type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStatusType fetchByPrimaryKey(long spPEProcessStatusTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEProcessStatusTypeId);
	}

	/**
	 * Returns all the p e process status types.
	 *
	 * @return the p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @return the range of p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process status types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStatusTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process status types
	 * @param end the upper bound of the range of p e process status types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e process status types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStatusType> findAll(int start, int end,
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

		List<PEProcessStatusType> list = (List<PEProcessStatusType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEPROCESSSTATUSTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEPROCESSSTATUSTYPE;

				if (pagination) {
					sql = sql.concat(PEProcessStatusTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStatusType>(list);
				}
				else {
					list = (List<PEProcessStatusType>)QueryUtil.list(q,
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
	 * Removes all the p e process status types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEProcessStatusType peProcessStatusType : findAll()) {
			remove(peProcessStatusType);
		}
	}

	/**
	 * Returns the number of p e process status types.
	 *
	 * @return the number of p e process status types
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

				Query q = session.createQuery(_SQL_COUNT_PEPROCESSSTATUSTYPE);

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
	 * Initializes the p e process status type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEProcessStatusType>> listenersList = new ArrayList<ModelListener<PEProcessStatusType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEProcessStatusType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEProcessStatusTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEPROCESSSTATUSTYPE = "SELECT peProcessStatusType FROM PEProcessStatusType peProcessStatusType";
	private static final String _SQL_SELECT_PEPROCESSSTATUSTYPE_WHERE = "SELECT peProcessStatusType FROM PEProcessStatusType peProcessStatusType WHERE ";
	private static final String _SQL_COUNT_PEPROCESSSTATUSTYPE = "SELECT COUNT(peProcessStatusType) FROM PEProcessStatusType peProcessStatusType";
	private static final String _SQL_COUNT_PEPROCESSSTATUSTYPE_WHERE = "SELECT COUNT(peProcessStatusType) FROM PEProcessStatusType peProcessStatusType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peProcessStatusType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEProcessStatusType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEProcessStatusType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEProcessStatusTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PEProcessStatusType _nullPEProcessStatusType = new PEProcessStatusTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEProcessStatusType> toCacheModel() {
				return _nullPEProcessStatusTypeCacheModel;
			}
		};

	private static CacheModel<PEProcessStatusType> _nullPEProcessStatusTypeCacheModel =
		new CacheModel<PEProcessStatusType>() {
			@Override
			public PEProcessStatusType toEntityModel() {
				return _nullPEProcessStatusType;
			}
		};
}