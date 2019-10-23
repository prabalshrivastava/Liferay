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

package com.sambaash.platform.srv.sprating.service.persistence;

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

import com.sambaash.platform.srv.sprating.NoSuchRatingComponentException;
import com.sambaash.platform.srv.sprating.model.RatingComponent;
import com.sambaash.platform.srv.sprating.model.impl.RatingComponentImpl;
import com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rating component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see RatingComponentPersistence
 * @see RatingComponentUtil
 * @generated
 */
public class RatingComponentPersistenceImpl extends BasePersistenceImpl<RatingComponent>
	implements RatingComponentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RatingComponentUtil} to access the rating component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RatingComponentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			RatingComponentModelImpl.UUID_COLUMN_BITMASK |
			RatingComponentModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rating components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @return the range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid(String uuid, int start, int end,
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

		List<RatingComponent> list = (List<RatingComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingComponent ratingComponent : list) {
				if (!Validator.equals(uuid, ratingComponent.getUuid())) {
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

			query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

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
				query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
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
					list = (List<RatingComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingComponent>(list);
				}
				else {
					list = (List<RatingComponent>)QueryUtil.list(q,
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
	 * Returns the first rating component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByUuid_First(uuid,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the first rating component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingComponent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByUuid_Last(uuid,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the last rating component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RatingComponent> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating components before and after the current rating component in the ordered set where uuid = &#63;.
	 *
	 * @param spRatingComponentId the primary key of the current rating component
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent[] findByUuid_PrevAndNext(long spRatingComponentId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = findByPrimaryKey(spRatingComponentId);

		Session session = null;

		try {
			session = openSession();

			RatingComponent[] array = new RatingComponentImpl[3];

			array[0] = getByUuid_PrevAndNext(session, ratingComponent, uuid,
					orderByComparator, true);

			array[1] = ratingComponent;

			array[2] = getByUuid_PrevAndNext(session, ratingComponent, uuid,
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

	protected RatingComponent getByUuid_PrevAndNext(Session session,
		RatingComponent ratingComponent, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

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
			query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ratingComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating components where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (RatingComponent ratingComponent : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingComponent);
		}
	}

	/**
	 * Returns the number of rating components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rating components
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

			query.append(_SQL_COUNT_RATINGCOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "ratingComponent.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ratingComponent.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(ratingComponent.uuid IS NULL OR ratingComponent.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			RatingComponentModelImpl.UUID_COLUMN_BITMASK |
			RatingComponentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the rating component where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingComponentException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByUUID_G(String uuid, long groupId)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByUUID_G(uuid, groupId);

		if (ratingComponent == null) {
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

			throw new NoSuchRatingComponentException(msg.toString());
		}

		return ratingComponent;
	}

	/**
	 * Returns the rating component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rating component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof RatingComponent) {
			RatingComponent ratingComponent = (RatingComponent)result;

			if (!Validator.equals(uuid, ratingComponent.getUuid()) ||
					(groupId != ratingComponent.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

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

				List<RatingComponent> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					RatingComponent ratingComponent = list.get(0);

					result = ratingComponent;

					cacheResult(ratingComponent);

					if ((ratingComponent.getUuid() == null) ||
							!ratingComponent.getUuid().equals(uuid) ||
							(ratingComponent.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, ratingComponent);
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
			return (RatingComponent)result;
		}
	}

	/**
	 * Removes the rating component where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rating component that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent removeByUUID_G(String uuid, long groupId)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = findByUUID_G(uuid, groupId);

		return remove(ratingComponent);
	}

	/**
	 * Returns the number of rating components where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rating components
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

			query.append(_SQL_COUNT_RATINGCOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "ratingComponent.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "ratingComponent.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(ratingComponent.uuid IS NULL OR ratingComponent.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "ratingComponent.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			RatingComponentModelImpl.UUID_COLUMN_BITMASK |
			RatingComponentModelImpl.COMPANYID_COLUMN_BITMASK |
			RatingComponentModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rating components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @return the range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByUuid_C(String uuid, long companyId,
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

		List<RatingComponent> list = (List<RatingComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingComponent ratingComponent : list) {
				if (!Validator.equals(uuid, ratingComponent.getUuid()) ||
						(companyId != ratingComponent.getCompanyId())) {
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

			query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

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
				query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
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
					list = (List<RatingComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingComponent>(list);
				}
				else {
					list = (List<RatingComponent>)QueryUtil.list(q,
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
	 * Returns the first rating component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the first rating component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingComponent> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the last rating component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RatingComponent> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating components before and after the current rating component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spRatingComponentId the primary key of the current rating component
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent[] findByUuid_C_PrevAndNext(
		long spRatingComponentId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = findByPrimaryKey(spRatingComponentId);

		Session session = null;

		try {
			session = openSession();

			RatingComponent[] array = new RatingComponentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, ratingComponent, uuid,
					companyId, orderByComparator, true);

			array[1] = ratingComponent;

			array[2] = getByUuid_C_PrevAndNext(session, ratingComponent, uuid,
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

	protected RatingComponent getByUuid_C_PrevAndNext(Session session,
		RatingComponent ratingComponent, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

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
			query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ratingComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating components where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (RatingComponent ratingComponent : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingComponent);
		}
	}

	/**
	 * Returns the number of rating components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rating components
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

			query.append(_SQL_COUNT_RATINGCOMPONENT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "ratingComponent.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "ratingComponent.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(ratingComponent.uuid IS NULL OR ratingComponent.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "ratingComponent.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED,
			RatingComponentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			RatingComponentModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the rating components where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByName(String name)
		throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating components where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @return the range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating components where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<RatingComponent> list = (List<RatingComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RatingComponent ratingComponent : list) {
				if (!Validator.equals(name, ratingComponent.getName())) {
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

			query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (!pagination) {
					list = (List<RatingComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingComponent>(list);
				}
				else {
					list = (List<RatingComponent>)QueryUtil.list(q,
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
	 * Returns the first rating component in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByName_First(name,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the first rating component in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<RatingComponent> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rating component in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByName_Last(name,
				orderByComparator);

		if (ratingComponent != null) {
			return ratingComponent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRatingComponentException(msg.toString());
	}

	/**
	 * Returns the last rating component in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating component, or <code>null</code> if a matching rating component could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<RatingComponent> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rating components before and after the current rating component in the ordered set where name = &#63;.
	 *
	 * @param spRatingComponentId the primary key of the current rating component
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent[] findByName_PrevAndNext(long spRatingComponentId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = findByPrimaryKey(spRatingComponentId);

		Session session = null;

		try {
			session = openSession();

			RatingComponent[] array = new RatingComponentImpl[3];

			array[0] = getByName_PrevAndNext(session, ratingComponent, name,
					orderByComparator, true);

			array[1] = ratingComponent;

			array[2] = getByName_PrevAndNext(session, ratingComponent, name,
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

	protected RatingComponent getByName_PrevAndNext(Session session,
		RatingComponent ratingComponent, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGCOMPONENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(RatingComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingComponent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingComponent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rating components where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (RatingComponent ratingComponent : findByName(name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ratingComponent);
		}
	}

	/**
	 * Returns the number of rating components where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGCOMPONENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name.toLowerCase());
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "ratingComponent.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "lower(ratingComponent.name) = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(ratingComponent.name IS NULL OR ratingComponent.name = '')";

	public RatingComponentPersistenceImpl() {
		setModelClass(RatingComponent.class);
	}

	/**
	 * Caches the rating component in the entity cache if it is enabled.
	 *
	 * @param ratingComponent the rating component
	 */
	@Override
	public void cacheResult(RatingComponent ratingComponent) {
		EntityCacheUtil.putResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentImpl.class, ratingComponent.getPrimaryKey(),
			ratingComponent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { ratingComponent.getUuid(), ratingComponent.getGroupId() },
			ratingComponent);

		ratingComponent.resetOriginalValues();
	}

	/**
	 * Caches the rating components in the entity cache if it is enabled.
	 *
	 * @param ratingComponents the rating components
	 */
	@Override
	public void cacheResult(List<RatingComponent> ratingComponents) {
		for (RatingComponent ratingComponent : ratingComponents) {
			if (EntityCacheUtil.getResult(
						RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
						RatingComponentImpl.class,
						ratingComponent.getPrimaryKey()) == null) {
				cacheResult(ratingComponent);
			}
			else {
				ratingComponent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rating components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RatingComponentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RatingComponentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rating component.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RatingComponent ratingComponent) {
		EntityCacheUtil.removeResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentImpl.class, ratingComponent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ratingComponent);
	}

	@Override
	public void clearCache(List<RatingComponent> ratingComponents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RatingComponent ratingComponent : ratingComponents) {
			EntityCacheUtil.removeResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
				RatingComponentImpl.class, ratingComponent.getPrimaryKey());

			clearUniqueFindersCache(ratingComponent);
		}
	}

	protected void cacheUniqueFindersCache(RatingComponent ratingComponent) {
		if (ratingComponent.isNew()) {
			Object[] args = new Object[] {
					ratingComponent.getUuid(), ratingComponent.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				ratingComponent);
		}
		else {
			RatingComponentModelImpl ratingComponentModelImpl = (RatingComponentModelImpl)ratingComponent;

			if ((ratingComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingComponent.getUuid(), ratingComponent.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					ratingComponent);
			}
		}
	}

	protected void clearUniqueFindersCache(RatingComponent ratingComponent) {
		RatingComponentModelImpl ratingComponentModelImpl = (RatingComponentModelImpl)ratingComponent;

		Object[] args = new Object[] {
				ratingComponent.getUuid(), ratingComponent.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((ratingComponentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					ratingComponentModelImpl.getOriginalUuid(),
					ratingComponentModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new rating component with the primary key. Does not add the rating component to the database.
	 *
	 * @param spRatingComponentId the primary key for the new rating component
	 * @return the new rating component
	 */
	@Override
	public RatingComponent create(long spRatingComponentId) {
		RatingComponent ratingComponent = new RatingComponentImpl();

		ratingComponent.setNew(true);
		ratingComponent.setPrimaryKey(spRatingComponentId);

		String uuid = PortalUUIDUtil.generate();

		ratingComponent.setUuid(uuid);

		return ratingComponent;
	}

	/**
	 * Removes the rating component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spRatingComponentId the primary key of the rating component
	 * @return the rating component that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent remove(long spRatingComponentId)
		throws NoSuchRatingComponentException, SystemException {
		return remove((Serializable)spRatingComponentId);
	}

	/**
	 * Removes the rating component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rating component
	 * @return the rating component that was removed
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent remove(Serializable primaryKey)
		throws NoSuchRatingComponentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RatingComponent ratingComponent = (RatingComponent)session.get(RatingComponentImpl.class,
					primaryKey);

			if (ratingComponent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRatingComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ratingComponent);
		}
		catch (NoSuchRatingComponentException nsee) {
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
	protected RatingComponent removeImpl(RatingComponent ratingComponent)
		throws SystemException {
		ratingComponent = toUnwrappedModel(ratingComponent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ratingComponent)) {
				ratingComponent = (RatingComponent)session.get(RatingComponentImpl.class,
						ratingComponent.getPrimaryKeyObj());
			}

			if (ratingComponent != null) {
				session.delete(ratingComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ratingComponent != null) {
			clearCache(ratingComponent);
		}

		return ratingComponent;
	}

	@Override
	public RatingComponent updateImpl(
		com.sambaash.platform.srv.sprating.model.RatingComponent ratingComponent)
		throws SystemException {
		ratingComponent = toUnwrappedModel(ratingComponent);

		boolean isNew = ratingComponent.isNew();

		RatingComponentModelImpl ratingComponentModelImpl = (RatingComponentModelImpl)ratingComponent;

		if (Validator.isNull(ratingComponent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ratingComponent.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (ratingComponent.isNew()) {
				session.save(ratingComponent);

				ratingComponent.setNew(false);
			}
			else {
				session.merge(ratingComponent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RatingComponentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ratingComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingComponentModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { ratingComponentModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((ratingComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingComponentModelImpl.getOriginalUuid(),
						ratingComponentModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						ratingComponentModelImpl.getUuid(),
						ratingComponentModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((ratingComponentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingComponentModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { ratingComponentModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
			RatingComponentImpl.class, ratingComponent.getPrimaryKey(),
			ratingComponent);

		clearUniqueFindersCache(ratingComponent);
		cacheUniqueFindersCache(ratingComponent);

		return ratingComponent;
	}

	protected RatingComponent toUnwrappedModel(RatingComponent ratingComponent) {
		if (ratingComponent instanceof RatingComponentImpl) {
			return ratingComponent;
		}

		RatingComponentImpl ratingComponentImpl = new RatingComponentImpl();

		ratingComponentImpl.setNew(ratingComponent.isNew());
		ratingComponentImpl.setPrimaryKey(ratingComponent.getPrimaryKey());

		ratingComponentImpl.setUuid(ratingComponent.getUuid());
		ratingComponentImpl.setSpRatingComponentId(ratingComponent.getSpRatingComponentId());
		ratingComponentImpl.setGroupId(ratingComponent.getGroupId());
		ratingComponentImpl.setCompanyId(ratingComponent.getCompanyId());
		ratingComponentImpl.setUserId(ratingComponent.getUserId());
		ratingComponentImpl.setUserName(ratingComponent.getUserName());
		ratingComponentImpl.setCreateDate(ratingComponent.getCreateDate());
		ratingComponentImpl.setModifiedDate(ratingComponent.getModifiedDate());
		ratingComponentImpl.setName(ratingComponent.getName());
		ratingComponentImpl.setClassNameId(ratingComponent.getClassNameId());

		return ratingComponentImpl;
	}

	/**
	 * Returns the rating component with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating component
	 * @return the rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRatingComponentException, SystemException {
		RatingComponent ratingComponent = fetchByPrimaryKey(primaryKey);

		if (ratingComponent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRatingComponentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ratingComponent;
	}

	/**
	 * Returns the rating component with the primary key or throws a {@link com.sambaash.platform.srv.sprating.NoSuchRatingComponentException} if it could not be found.
	 *
	 * @param spRatingComponentId the primary key of the rating component
	 * @return the rating component
	 * @throws com.sambaash.platform.srv.sprating.NoSuchRatingComponentException if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent findByPrimaryKey(long spRatingComponentId)
		throws NoSuchRatingComponentException, SystemException {
		return findByPrimaryKey((Serializable)spRatingComponentId);
	}

	/**
	 * Returns the rating component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating component
	 * @return the rating component, or <code>null</code> if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RatingComponent ratingComponent = (RatingComponent)EntityCacheUtil.getResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
				RatingComponentImpl.class, primaryKey);

		if (ratingComponent == _nullRatingComponent) {
			return null;
		}

		if (ratingComponent == null) {
			Session session = null;

			try {
				session = openSession();

				ratingComponent = (RatingComponent)session.get(RatingComponentImpl.class,
						primaryKey);

				if (ratingComponent != null) {
					cacheResult(ratingComponent);
				}
				else {
					EntityCacheUtil.putResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
						RatingComponentImpl.class, primaryKey,
						_nullRatingComponent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RatingComponentModelImpl.ENTITY_CACHE_ENABLED,
					RatingComponentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ratingComponent;
	}

	/**
	 * Returns the rating component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spRatingComponentId the primary key of the rating component
	 * @return the rating component, or <code>null</code> if a rating component with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingComponent fetchByPrimaryKey(long spRatingComponentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spRatingComponentId);
	}

	/**
	 * Returns all the rating components.
	 *
	 * @return the rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @return the range of rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sprating.model.impl.RatingComponentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating components
	 * @param end the upper bound of the range of rating components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rating components
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RatingComponent> findAll(int start, int end,
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

		List<RatingComponent> list = (List<RatingComponent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RATINGCOMPONENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATINGCOMPONENT;

				if (pagination) {
					sql = sql.concat(RatingComponentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RatingComponent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RatingComponent>(list);
				}
				else {
					list = (List<RatingComponent>)QueryUtil.list(q,
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
	 * Removes all the rating components from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RatingComponent ratingComponent : findAll()) {
			remove(ratingComponent);
		}
	}

	/**
	 * Returns the number of rating components.
	 *
	 * @return the number of rating components
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

				Query q = session.createQuery(_SQL_COUNT_RATINGCOMPONENT);

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
	 * Initializes the rating component persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sprating.model.RatingComponent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RatingComponent>> listenersList = new ArrayList<ModelListener<RatingComponent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RatingComponent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RatingComponentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RATINGCOMPONENT = "SELECT ratingComponent FROM RatingComponent ratingComponent";
	private static final String _SQL_SELECT_RATINGCOMPONENT_WHERE = "SELECT ratingComponent FROM RatingComponent ratingComponent WHERE ";
	private static final String _SQL_COUNT_RATINGCOMPONENT = "SELECT COUNT(ratingComponent) FROM RatingComponent ratingComponent";
	private static final String _SQL_COUNT_RATINGCOMPONENT_WHERE = "SELECT COUNT(ratingComponent) FROM RatingComponent ratingComponent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ratingComponent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RatingComponent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RatingComponent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RatingComponentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static RatingComponent _nullRatingComponent = new RatingComponentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RatingComponent> toCacheModel() {
				return _nullRatingComponentCacheModel;
			}
		};

	private static CacheModel<RatingComponent> _nullRatingComponentCacheModel = new CacheModel<RatingComponent>() {
			@Override
			public RatingComponent toEntityModel() {
				return _nullRatingComponent;
			}
		};
}