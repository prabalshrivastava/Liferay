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

package com.sambaash.platform.srv.spsocialsharing.service.persistence;

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

import com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException;
import com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing;
import com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingImpl;
import com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p social sharing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSocialSharingPersistence
 * @see SPSocialSharingUtil
 * @generated
 */
public class SPSocialSharingPersistenceImpl extends BasePersistenceImpl<SPSocialSharing>
	implements SPSocialSharingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPSocialSharingUtil} to access the s p social sharing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPSocialSharingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPSocialSharingModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p social sharings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p social sharings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @return the range of matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p social sharings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid(String uuid, int start, int end,
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

		List<SPSocialSharing> list = (List<SPSocialSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSocialSharing spSocialSharing : list) {
				if (!Validator.equals(uuid, spSocialSharing.getUuid())) {
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

			query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

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
				query.append(SPSocialSharingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSocialSharing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSocialSharing>(list);
				}
				else {
					list = (List<SPSocialSharing>)QueryUtil.list(q,
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
	 * Returns the first s p social sharing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByUuid_First(uuid,
				orderByComparator);

		if (spSocialSharing != null) {
			return spSocialSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSocialSharingException(msg.toString());
	}

	/**
	 * Returns the first s p social sharing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSocialSharing> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p social sharing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByUuid_Last(uuid,
				orderByComparator);

		if (spSocialSharing != null) {
			return spSocialSharing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSocialSharingException(msg.toString());
	}

	/**
	 * Returns the last s p social sharing in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPSocialSharing> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p social sharings before and after the current s p social sharing in the ordered set where uuid = &#63;.
	 *
	 * @param spSocialSharingId the primary key of the current s p social sharing
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing[] findByUuid_PrevAndNext(long spSocialSharingId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = findByPrimaryKey(spSocialSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSocialSharing[] array = new SPSocialSharingImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spSocialSharing, uuid,
					orderByComparator, true);

			array[1] = spSocialSharing;

			array[2] = getByUuid_PrevAndNext(session, spSocialSharing, uuid,
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

	protected SPSocialSharing getByUuid_PrevAndNext(Session session,
		SPSocialSharing spSocialSharing, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

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
			query.append(SPSocialSharingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSocialSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSocialSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p social sharings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPSocialSharing spSocialSharing : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSocialSharing);
		}
	}

	/**
	 * Returns the number of s p social sharings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p social sharings
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

			query.append(_SQL_COUNT_SPSOCIALSHARING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spSocialSharing.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spSocialSharing.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spSocialSharing.uuid IS NULL OR spSocialSharing.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSocialSharingModelImpl.UUID_COLUMN_BITMASK |
			SPSocialSharingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p social sharing where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByUUID_G(String uuid, long groupId)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByUUID_G(uuid, groupId);

		if (spSocialSharing == null) {
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

			throw new NoSuchSPSocialSharingException(msg.toString());
		}

		return spSocialSharing;
	}

	/**
	 * Returns the s p social sharing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p social sharing where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPSocialSharing) {
			SPSocialSharing spSocialSharing = (SPSocialSharing)result;

			if (!Validator.equals(uuid, spSocialSharing.getUuid()) ||
					(groupId != spSocialSharing.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

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

				List<SPSocialSharing> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPSocialSharing spSocialSharing = list.get(0);

					result = spSocialSharing;

					cacheResult(spSocialSharing);

					if ((spSocialSharing.getUuid() == null) ||
							!spSocialSharing.getUuid().equals(uuid) ||
							(spSocialSharing.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spSocialSharing);
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
			return (SPSocialSharing)result;
		}
	}

	/**
	 * Removes the s p social sharing where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p social sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = findByUUID_G(uuid, groupId);

		return remove(spSocialSharing);
	}

	/**
	 * Returns the number of s p social sharings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p social sharings
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

			query.append(_SQL_COUNT_SPSOCIALSHARING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spSocialSharing.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spSocialSharing.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spSocialSharing.uuid IS NULL OR spSocialSharing.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spSocialSharing.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPSocialSharingModelImpl.UUID_COLUMN_BITMASK |
			SPSocialSharingModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p social sharings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p social sharings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @return the range of matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p social sharings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findByUuid_C(String uuid, long companyId,
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

		List<SPSocialSharing> list = (List<SPSocialSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPSocialSharing spSocialSharing : list) {
				if (!Validator.equals(uuid, spSocialSharing.getUuid()) ||
						(companyId != spSocialSharing.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

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
				query.append(SPSocialSharingModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPSocialSharing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSocialSharing>(list);
				}
				else {
					list = (List<SPSocialSharing>)QueryUtil.list(q,
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
	 * Returns the first s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spSocialSharing != null) {
			return spSocialSharing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSocialSharingException(msg.toString());
	}

	/**
	 * Returns the first s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPSocialSharing> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spSocialSharing != null) {
			return spSocialSharing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPSocialSharingException(msg.toString());
	}

	/**
	 * Returns the last s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPSocialSharing> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p social sharings before and after the current s p social sharing in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spSocialSharingId the primary key of the current s p social sharing
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing[] findByUuid_C_PrevAndNext(long spSocialSharingId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = findByPrimaryKey(spSocialSharingId);

		Session session = null;

		try {
			session = openSession();

			SPSocialSharing[] array = new SPSocialSharingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spSocialSharing, uuid,
					companyId, orderByComparator, true);

			array[1] = spSocialSharing;

			array[2] = getByUuid_C_PrevAndNext(session, spSocialSharing, uuid,
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

	protected SPSocialSharing getByUuid_C_PrevAndNext(Session session,
		SPSocialSharing spSocialSharing, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

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
			query.append(SPSocialSharingModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spSocialSharing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPSocialSharing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p social sharings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPSocialSharing spSocialSharing : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spSocialSharing);
		}
	}

	/**
	 * Returns the number of s p social sharings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p social sharings
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

			query.append(_SQL_COUNT_SPSOCIALSHARING_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spSocialSharing.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spSocialSharing.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spSocialSharing.uuid IS NULL OR spSocialSharing.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spSocialSharing.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED,
			SPSocialSharingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByclassNameIdAndClassPK",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPSocialSharingModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			SPSocialSharingModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK = new FinderPath(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByclassNameIdAndClassPK",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByclassNameIdAndClassPK(long classNameId,
		long classPK) throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByclassNameIdAndClassPK(classNameId,
				classPK);

		if (spSocialSharing == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPSocialSharingException(msg.toString());
		}

		return spSocialSharing;
	}

	/**
	 * Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByclassNameIdAndClassPK(long classNameId,
		long classPK) throws SystemException {
		return fetchByclassNameIdAndClassPK(classNameId, classPK, true);
	}

	/**
	 * Returns the s p social sharing where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p social sharing, or <code>null</code> if a matching s p social sharing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByclassNameIdAndClassPK(long classNameId,
		long classPK, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
					finderArgs, this);
		}

		if (result instanceof SPSocialSharing) {
			SPSocialSharing spSocialSharing = (SPSocialSharing)result;

			if ((classNameId != spSocialSharing.getClassNameId()) ||
					(classPK != spSocialSharing.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPSOCIALSHARING_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<SPSocialSharing> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
						finderArgs, list);
				}
				else {
					SPSocialSharing spSocialSharing = list.get(0);

					result = spSocialSharing;

					cacheResult(spSocialSharing);

					if ((spSocialSharing.getClassNameId() != classNameId) ||
							(spSocialSharing.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
							finderArgs, spSocialSharing);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
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
			return (SPSocialSharing)result;
		}
	}

	/**
	 * Removes the s p social sharing where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the s p social sharing that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing removeByclassNameIdAndClassPK(long classNameId,
		long classPK) throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = findByclassNameIdAndClassPK(classNameId,
				classPK);

		return remove(spSocialSharing);
	}

	/**
	 * Returns the number of s p social sharings where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class p k
	 * @return the number of matching s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByclassNameIdAndClassPK(long classNameId, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSOCIALSHARING_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSNAMEID_2 =
		"spSocialSharing.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEIDANDCLASSPK_CLASSPK_2 = "spSocialSharing.classPK = ?";

	public SPSocialSharingPersistenceImpl() {
		setModelClass(SPSocialSharing.class);
	}

	/**
	 * Caches the s p social sharing in the entity cache if it is enabled.
	 *
	 * @param spSocialSharing the s p social sharing
	 */
	@Override
	public void cacheResult(SPSocialSharing spSocialSharing) {
		EntityCacheUtil.putResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingImpl.class, spSocialSharing.getPrimaryKey(),
			spSocialSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spSocialSharing.getUuid(), spSocialSharing.getGroupId() },
			spSocialSharing);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
			new Object[] {
				spSocialSharing.getClassNameId(), spSocialSharing.getClassPK()
			}, spSocialSharing);

		spSocialSharing.resetOriginalValues();
	}

	/**
	 * Caches the s p social sharings in the entity cache if it is enabled.
	 *
	 * @param spSocialSharings the s p social sharings
	 */
	@Override
	public void cacheResult(List<SPSocialSharing> spSocialSharings) {
		for (SPSocialSharing spSocialSharing : spSocialSharings) {
			if (EntityCacheUtil.getResult(
						SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
						SPSocialSharingImpl.class,
						spSocialSharing.getPrimaryKey()) == null) {
				cacheResult(spSocialSharing);
			}
			else {
				spSocialSharing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p social sharings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPSocialSharingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPSocialSharingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p social sharing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPSocialSharing spSocialSharing) {
		EntityCacheUtil.removeResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingImpl.class, spSocialSharing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spSocialSharing);
	}

	@Override
	public void clearCache(List<SPSocialSharing> spSocialSharings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPSocialSharing spSocialSharing : spSocialSharings) {
			EntityCacheUtil.removeResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
				SPSocialSharingImpl.class, spSocialSharing.getPrimaryKey());

			clearUniqueFindersCache(spSocialSharing);
		}
	}

	protected void cacheUniqueFindersCache(SPSocialSharing spSocialSharing) {
		if (spSocialSharing.isNew()) {
			Object[] args = new Object[] {
					spSocialSharing.getUuid(), spSocialSharing.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spSocialSharing);

			args = new Object[] {
					spSocialSharing.getClassNameId(),
					spSocialSharing.getClassPK()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
				args, spSocialSharing);
		}
		else {
			SPSocialSharingModelImpl spSocialSharingModelImpl = (SPSocialSharingModelImpl)spSocialSharing;

			if ((spSocialSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSocialSharing.getUuid(), spSocialSharing.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spSocialSharing);
			}

			if ((spSocialSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSocialSharing.getClassNameId(),
						spSocialSharing.getClassPK()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
					args, spSocialSharing);
			}
		}
	}

	protected void clearUniqueFindersCache(SPSocialSharing spSocialSharing) {
		SPSocialSharingModelImpl spSocialSharingModelImpl = (SPSocialSharingModelImpl)spSocialSharing;

		Object[] args = new Object[] {
				spSocialSharing.getUuid(), spSocialSharing.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spSocialSharingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSocialSharingModelImpl.getOriginalUuid(),
					spSocialSharingModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spSocialSharing.getClassNameId(), spSocialSharing.getClassPK()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
			args);

		if ((spSocialSharingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK.getColumnBitmask()) != 0) {
			args = new Object[] {
					spSocialSharingModelImpl.getOriginalClassNameId(),
					spSocialSharingModelImpl.getOriginalClassPK()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEIDANDCLASSPK,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEIDANDCLASSPK,
				args);
		}
	}

	/**
	 * Creates a new s p social sharing with the primary key. Does not add the s p social sharing to the database.
	 *
	 * @param spSocialSharingId the primary key for the new s p social sharing
	 * @return the new s p social sharing
	 */
	@Override
	public SPSocialSharing create(long spSocialSharingId) {
		SPSocialSharing spSocialSharing = new SPSocialSharingImpl();

		spSocialSharing.setNew(true);
		spSocialSharing.setPrimaryKey(spSocialSharingId);

		String uuid = PortalUUIDUtil.generate();

		spSocialSharing.setUuid(uuid);

		return spSocialSharing;
	}

	/**
	 * Removes the s p social sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spSocialSharingId the primary key of the s p social sharing
	 * @return the s p social sharing that was removed
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing remove(long spSocialSharingId)
		throws NoSuchSPSocialSharingException, SystemException {
		return remove((Serializable)spSocialSharingId);
	}

	/**
	 * Removes the s p social sharing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p social sharing
	 * @return the s p social sharing that was removed
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing remove(Serializable primaryKey)
		throws NoSuchSPSocialSharingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPSocialSharing spSocialSharing = (SPSocialSharing)session.get(SPSocialSharingImpl.class,
					primaryKey);

			if (spSocialSharing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPSocialSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spSocialSharing);
		}
		catch (NoSuchSPSocialSharingException nsee) {
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
	protected SPSocialSharing removeImpl(SPSocialSharing spSocialSharing)
		throws SystemException {
		spSocialSharing = toUnwrappedModel(spSocialSharing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spSocialSharing)) {
				spSocialSharing = (SPSocialSharing)session.get(SPSocialSharingImpl.class,
						spSocialSharing.getPrimaryKeyObj());
			}

			if (spSocialSharing != null) {
				session.delete(spSocialSharing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spSocialSharing != null) {
			clearCache(spSocialSharing);
		}

		return spSocialSharing;
	}

	@Override
	public SPSocialSharing updateImpl(
		com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing spSocialSharing)
		throws SystemException {
		spSocialSharing = toUnwrappedModel(spSocialSharing);

		boolean isNew = spSocialSharing.isNew();

		SPSocialSharingModelImpl spSocialSharingModelImpl = (SPSocialSharingModelImpl)spSocialSharing;

		if (Validator.isNull(spSocialSharing.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spSocialSharing.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spSocialSharing.isNew()) {
				session.save(spSocialSharing);

				spSocialSharing.setNew(false);
			}
			else {
				session.merge(spSocialSharing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPSocialSharingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spSocialSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSocialSharingModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spSocialSharingModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spSocialSharingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spSocialSharingModelImpl.getOriginalUuid(),
						spSocialSharingModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spSocialSharingModelImpl.getUuid(),
						spSocialSharingModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
			SPSocialSharingImpl.class, spSocialSharing.getPrimaryKey(),
			spSocialSharing);

		clearUniqueFindersCache(spSocialSharing);
		cacheUniqueFindersCache(spSocialSharing);

		return spSocialSharing;
	}

	protected SPSocialSharing toUnwrappedModel(SPSocialSharing spSocialSharing) {
		if (spSocialSharing instanceof SPSocialSharingImpl) {
			return spSocialSharing;
		}

		SPSocialSharingImpl spSocialSharingImpl = new SPSocialSharingImpl();

		spSocialSharingImpl.setNew(spSocialSharing.isNew());
		spSocialSharingImpl.setPrimaryKey(spSocialSharing.getPrimaryKey());

		spSocialSharingImpl.setUuid(spSocialSharing.getUuid());
		spSocialSharingImpl.setSpSocialSharingId(spSocialSharing.getSpSocialSharingId());
		spSocialSharingImpl.setGroupId(spSocialSharing.getGroupId());
		spSocialSharingImpl.setCompanyId(spSocialSharing.getCompanyId());
		spSocialSharingImpl.setUserId(spSocialSharing.getUserId());
		spSocialSharingImpl.setUserName(spSocialSharing.getUserName());
		spSocialSharingImpl.setCreateDate(spSocialSharing.getCreateDate());
		spSocialSharingImpl.setModifiedDate(spSocialSharing.getModifiedDate());
		spSocialSharingImpl.setClassNameId(spSocialSharing.getClassNameId());
		spSocialSharingImpl.setClassPK(spSocialSharing.getClassPK());
		spSocialSharingImpl.setFacebook(spSocialSharing.getFacebook());
		spSocialSharingImpl.setTwitter(spSocialSharing.getTwitter());
		spSocialSharingImpl.setLinkedin(spSocialSharing.getLinkedin());
		spSocialSharingImpl.setYahoo(spSocialSharing.getYahoo());
		spSocialSharingImpl.setGoogle(spSocialSharing.getGoogle());
		spSocialSharingImpl.setFacebookPage(spSocialSharing.getFacebookPage());

		return spSocialSharingImpl;
	}

	/**
	 * Returns the s p social sharing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p social sharing
	 * @return the s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPSocialSharingException, SystemException {
		SPSocialSharing spSocialSharing = fetchByPrimaryKey(primaryKey);

		if (spSocialSharing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPSocialSharingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spSocialSharing;
	}

	/**
	 * Returns the s p social sharing with the primary key or throws a {@link com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException} if it could not be found.
	 *
	 * @param spSocialSharingId the primary key of the s p social sharing
	 * @return the s p social sharing
	 * @throws com.sambaash.platform.srv.spsocialsharing.NoSuchSPSocialSharingException if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing findByPrimaryKey(long spSocialSharingId)
		throws NoSuchSPSocialSharingException, SystemException {
		return findByPrimaryKey((Serializable)spSocialSharingId);
	}

	/**
	 * Returns the s p social sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p social sharing
	 * @return the s p social sharing, or <code>null</code> if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPSocialSharing spSocialSharing = (SPSocialSharing)EntityCacheUtil.getResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
				SPSocialSharingImpl.class, primaryKey);

		if (spSocialSharing == _nullSPSocialSharing) {
			return null;
		}

		if (spSocialSharing == null) {
			Session session = null;

			try {
				session = openSession();

				spSocialSharing = (SPSocialSharing)session.get(SPSocialSharingImpl.class,
						primaryKey);

				if (spSocialSharing != null) {
					cacheResult(spSocialSharing);
				}
				else {
					EntityCacheUtil.putResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
						SPSocialSharingImpl.class, primaryKey,
						_nullSPSocialSharing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPSocialSharingModelImpl.ENTITY_CACHE_ENABLED,
					SPSocialSharingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spSocialSharing;
	}

	/**
	 * Returns the s p social sharing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spSocialSharingId the primary key of the s p social sharing
	 * @return the s p social sharing, or <code>null</code> if a s p social sharing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPSocialSharing fetchByPrimaryKey(long spSocialSharingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spSocialSharingId);
	}

	/**
	 * Returns all the s p social sharings.
	 *
	 * @return the s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p social sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @return the range of s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p social sharings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialsharing.model.impl.SPSocialSharingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p social sharings
	 * @param end the upper bound of the range of s p social sharings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p social sharings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPSocialSharing> findAll(int start, int end,
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

		List<SPSocialSharing> list = (List<SPSocialSharing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSOCIALSHARING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSOCIALSHARING;

				if (pagination) {
					sql = sql.concat(SPSocialSharingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPSocialSharing>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPSocialSharing>(list);
				}
				else {
					list = (List<SPSocialSharing>)QueryUtil.list(q,
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
	 * Removes all the s p social sharings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPSocialSharing spSocialSharing : findAll()) {
			remove(spSocialSharing);
		}
	}

	/**
	 * Returns the number of s p social sharings.
	 *
	 * @return the number of s p social sharings
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

				Query q = session.createQuery(_SQL_COUNT_SPSOCIALSHARING);

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
	 * Initializes the s p social sharing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPSocialSharing>> listenersList = new ArrayList<ModelListener<SPSocialSharing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPSocialSharing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPSocialSharingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSOCIALSHARING = "SELECT spSocialSharing FROM SPSocialSharing spSocialSharing";
	private static final String _SQL_SELECT_SPSOCIALSHARING_WHERE = "SELECT spSocialSharing FROM SPSocialSharing spSocialSharing WHERE ";
	private static final String _SQL_COUNT_SPSOCIALSHARING = "SELECT COUNT(spSocialSharing) FROM SPSocialSharing spSocialSharing";
	private static final String _SQL_COUNT_SPSOCIALSHARING_WHERE = "SELECT COUNT(spSocialSharing) FROM SPSocialSharing spSocialSharing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spSocialSharing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPSocialSharing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPSocialSharing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPSocialSharingPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPSocialSharing _nullSPSocialSharing = new SPSocialSharingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPSocialSharing> toCacheModel() {
				return _nullSPSocialSharingCacheModel;
			}
		};

	private static CacheModel<SPSocialSharing> _nullSPSocialSharingCacheModel = new CacheModel<SPSocialSharing>() {
			@Override
			public SPSocialSharing toEntityModel() {
				return _nullSPSocialSharing;
			}
		};
}