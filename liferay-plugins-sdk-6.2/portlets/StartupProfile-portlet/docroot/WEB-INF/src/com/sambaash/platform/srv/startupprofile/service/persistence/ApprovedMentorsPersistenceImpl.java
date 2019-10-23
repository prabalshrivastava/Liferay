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

package com.sambaash.platform.srv.startupprofile.service.persistence;

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

import com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException;
import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;
import com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the approved mentors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ApprovedMentorsPersistence
 * @see ApprovedMentorsUtil
 * @generated
 */
public class ApprovedMentorsPersistenceImpl extends BasePersistenceImpl<ApprovedMentors>
	implements ApprovedMentorsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApprovedMentorsUtil} to access the approved mentors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApprovedMentorsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ApprovedMentorsModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the approved mentorses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUuid(String uuid, int start, int end,
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

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if (!Validator.equals(uuid, approvedMentors.getUuid())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

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
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByUuid_First(uuid,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ApprovedMentors> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByUuid_Last(uuid,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where uuid = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByUuid_PrevAndNext(long mentorId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, approvedMentors, uuid,
					orderByComparator, true);

			array[1] = approvedMentors;

			array[2] = getByUuid_PrevAndNext(session, approvedMentors, uuid,
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

	protected ApprovedMentors getByUuid_PrevAndNext(Session session,
		ApprovedMentors approvedMentors, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ApprovedMentors approvedMentors : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching approved mentorses
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

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "approvedMentors.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "approvedMentors.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(approvedMentors.uuid IS NULL OR approvedMentors.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { String.class.getName() },
			ApprovedMentorsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the approved mentorses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUserId(String userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUserId(String userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByUserId(String userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if (!Validator.equals(userId, approvedMentors.getUserId())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_USERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserId) {
					qPos.add(userId);
				}

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByUserId_First(String userId,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByUserId_First(userId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByUserId_First(String userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ApprovedMentors> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByUserId_Last(String userId,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByUserId_Last(userId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByUserId_Last(String userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where userId = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByUserId_PrevAndNext(long mentorId,
		String userId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByUserId_PrevAndNext(session, approvedMentors,
					userId, orderByComparator, true);

			array[1] = approvedMentors;

			array[2] = getByUserId_PrevAndNext(session, approvedMentors,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApprovedMentors getByUserId_PrevAndNext(Session session,
		ApprovedMentors approvedMentors, String userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

		boolean bindUserId = false;

		if (userId == null) {
			query.append(_FINDER_COLUMN_USERID_USERID_1);
		}
		else if (userId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERID_USERID_3);
		}
		else {
			bindUserId = true;

			query.append(_FINDER_COLUMN_USERID_USERID_2);
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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserId) {
			qPos.add(userId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(String userId) throws SystemException {
		for (ApprovedMentors approvedMentors : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(String userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_USERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_USERID_USERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserId) {
					qPos.add(userId);
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

	private static final String _FINDER_COLUMN_USERID_USERID_1 = "approvedMentors.userId IS NULL";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "approvedMentors.userId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_3 = "(approvedMentors.userId IS NULL OR approvedMentors.userId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			ApprovedMentorsModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the approved mentorses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationId(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if ((organizationId != approvedMentors.getOrganizationId())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ApprovedMentors> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByOrganizationId_PrevAndNext(long mentorId,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session,
					approvedMentors, organizationId, orderByComparator, true);

			array[1] = approvedMentors;

			array[2] = getByOrganizationId_PrevAndNext(session,
					approvedMentors, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApprovedMentors getByOrganizationId_PrevAndNext(Session session,
		ApprovedMentors approvedMentors, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (ApprovedMentors approvedMentors : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "approvedMentors.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ApprovedMentorsModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the approved mentorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByStatus(int status, int start, int end,
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

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if ((status != approvedMentors.getStatus())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByStatus_First(status,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ApprovedMentors> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByStatus_Last(status,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where status = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByStatus_PrevAndNext(long mentorId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByStatus_PrevAndNext(session, approvedMentors,
					status, orderByComparator, true);

			array[1] = approvedMentors;

			array[2] = getByStatus_PrevAndNext(session, approvedMentors,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApprovedMentors getByStatus_PrevAndNext(Session session,
		ApprovedMentors approvedMentors, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (ApprovedMentors approvedMentors : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "approvedMentors.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationAndUserId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationAndUserId",
			new String[] { Long.class.getName(), String.class.getName() },
			ApprovedMentorsModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ApprovedMentorsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONANDUSERID = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationAndUserId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the approved mentorses where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, String userId) throws SystemException {
		return findByOrganizationAndUserId(organizationId, userId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where organizationId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, String userId, int start, int end)
		throws SystemException {
		return findByOrganizationAndUserId(organizationId, userId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where organizationId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationAndUserId(
		long organizationId, String userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID;
			finderArgs = new Object[] { organizationId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID;
			finderArgs = new Object[] {
					organizationId, userId,
					
					start, end, orderByComparator
				};
		}

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if ((organizationId != approvedMentors.getOrganizationId()) ||
						!Validator.equals(userId, approvedMentors.getUserId())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_ORGANIZATIONID_2);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindUserId) {
					qPos.add(userId);
				}

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationAndUserId_First(
		long organizationId, String userId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationAndUserId_First(organizationId,
				userId, orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationAndUserId_First(
		long organizationId, String userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ApprovedMentors> list = findByOrganizationAndUserId(organizationId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationAndUserId_Last(
		long organizationId, String userId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationAndUserId_Last(organizationId,
				userId, orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationAndUserId_Last(
		long organizationId, String userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganizationAndUserId(organizationId, userId);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByOrganizationAndUserId(organizationId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63; and userId = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByOrganizationAndUserId_PrevAndNext(
		long mentorId, long organizationId, String userId,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByOrganizationAndUserId_PrevAndNext(session,
					approvedMentors, organizationId, userId, orderByComparator,
					true);

			array[1] = approvedMentors;

			array[2] = getByOrganizationAndUserId_PrevAndNext(session,
					approvedMentors, organizationId, userId, orderByComparator,
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

	protected ApprovedMentors getByOrganizationAndUserId_PrevAndNext(
		Session session, ApprovedMentors approvedMentors, long organizationId,
		String userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_ORGANIZATIONID_2);

		boolean bindUserId = false;

		if (userId == null) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_1);
		}
		else if (userId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_3);
		}
		else {
			bindUserId = true;

			query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_2);
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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (bindUserId) {
			qPos.add(userId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where organizationId = &#63; and userId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationAndUserId(long organizationId, String userId)
		throws SystemException {
		for (ApprovedMentors approvedMentors : findByOrganizationAndUserId(
				organizationId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where organizationId = &#63; and userId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param userId the user ID
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationAndUserId(long organizationId, String userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONANDUSERID;

		Object[] finderArgs = new Object[] { organizationId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_ORGANIZATIONID_2);

			boolean bindUserId = false;

			if (userId == null) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_1);
			}
			else if (userId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_3);
			}
			else {
				bindUserId = true;

				query.append(_FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (bindUserId) {
					qPos.add(userId);
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

	private static final String _FINDER_COLUMN_ORGANIZATIONANDUSERID_ORGANIZATIONID_2 =
		"approvedMentors.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_1 = "approvedMentors.userId IS NULL";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_2 = "approvedMentors.userId = ?";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDUSERID_USERID_3 = "(approvedMentors.userId IS NULL OR approvedMentors.userId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationIdApprovedMentors",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationIdApprovedMentors",
			new String[] { Long.class.getName() },
			ApprovedMentorsModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONIDAPPROVEDMENTORS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationIdApprovedMentors",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the approved mentorses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId) throws SystemException {
		return findByOrganizationIdApprovedMentors(organizationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId, int start, int end) throws SystemException {
		return findByOrganizationIdApprovedMentors(organizationId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdApprovedMentors(
		long organizationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if ((organizationId != approvedMentors.getOrganizationId())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDAPPROVEDMENTORS_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationIdApprovedMentors_First(
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationIdApprovedMentors_First(organizationId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationIdApprovedMentors_First(
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ApprovedMentors> list = findByOrganizationIdApprovedMentors(organizationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationIdApprovedMentors_Last(
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationIdApprovedMentors_Last(organizationId,
				orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationIdApprovedMentors_Last(
		long organizationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganizationIdApprovedMentors(organizationId);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByOrganizationIdApprovedMentors(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByOrganizationIdApprovedMentors_PrevAndNext(
		long mentorId, long organizationId, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByOrganizationIdApprovedMentors_PrevAndNext(session,
					approvedMentors, organizationId, orderByComparator, true);

			array[1] = approvedMentors;

			array[2] = getByOrganizationIdApprovedMentors_PrevAndNext(session,
					approvedMentors, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApprovedMentors getByOrganizationIdApprovedMentors_PrevAndNext(
		Session session, ApprovedMentors approvedMentors, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONIDAPPROVEDMENTORS_ORGANIZATIONID_2);

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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationIdApprovedMentors(long organizationId)
		throws SystemException {
		for (ApprovedMentors approvedMentors : findByOrganizationIdApprovedMentors(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationIdApprovedMentors(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONIDAPPROVEDMENTORS;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDAPPROVEDMENTORS_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONIDAPPROVEDMENTORS_ORGANIZATIONID_2 =
		"approvedMentors.organizationId = ? AND approvedMentors.status = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationIdStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS =
		new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED,
			ApprovedMentorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationIdStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ApprovedMentorsModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			ApprovedMentorsModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONIDSTATUS = new FinderPath(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationIdStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the approved mentorses where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @return the matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status) throws SystemException {
		return findByOrganizationIdStatus(organizationId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses where organizationId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status, int start, int end)
		throws SystemException {
		return findByOrganizationIdStatus(organizationId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses where organizationId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findByOrganizationIdStatus(
		long organizationId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS;
			finderArgs = new Object[] { organizationId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS;
			finderArgs = new Object[] {
					organizationId, status,
					
					start, end, orderByComparator
				};
		}

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApprovedMentors approvedMentors : list) {
				if ((organizationId != approvedMentors.getOrganizationId()) ||
						(status != approvedMentors.getStatus())) {
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

			query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(status);

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Returns the first approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationIdStatus_First(
		long organizationId, int status, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationIdStatus_First(organizationId,
				status, orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the first approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationIdStatus_First(
		long organizationId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<ApprovedMentors> list = findByOrganizationIdStatus(organizationId,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByOrganizationIdStatus_Last(
		long organizationId, int status, OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByOrganizationIdStatus_Last(organizationId,
				status, orderByComparator);

		if (approvedMentors != null) {
			return approvedMentors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovedMentorsException(msg.toString());
	}

	/**
	 * Returns the last approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approved mentors, or <code>null</code> if a matching approved mentors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByOrganizationIdStatus_Last(
		long organizationId, int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOrganizationIdStatus(organizationId, status);

		if (count == 0) {
			return null;
		}

		List<ApprovedMentors> list = findByOrganizationIdStatus(organizationId,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approved mentorses before and after the current approved mentors in the ordered set where organizationId = &#63; and status = &#63;.
	 *
	 * @param mentorId the primary key of the current approved mentors
	 * @param organizationId the organization ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors[] findByOrganizationIdStatus_PrevAndNext(
		long mentorId, long organizationId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = findByPrimaryKey(mentorId);

		Session session = null;

		try {
			session = openSession();

			ApprovedMentors[] array = new ApprovedMentorsImpl[3];

			array[0] = getByOrganizationIdStatus_PrevAndNext(session,
					approvedMentors, organizationId, status, orderByComparator,
					true);

			array[1] = approvedMentors;

			array[2] = getByOrganizationIdStatus_PrevAndNext(session,
					approvedMentors, organizationId, status, orderByComparator,
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

	protected ApprovedMentors getByOrganizationIdStatus_PrevAndNext(
		Session session, ApprovedMentors approvedMentors, long organizationId,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVEDMENTORS_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_STATUS_2);

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
			query.append(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvedMentors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApprovedMentors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approved mentorses where organizationId = &#63; and status = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationIdStatus(long organizationId, int status)
		throws SystemException {
		for (ApprovedMentors approvedMentors : findByOrganizationIdStatus(
				organizationId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses where organizationId = &#63; and status = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param status the status
	 * @return the number of matching approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationIdStatus(long organizationId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONIDSTATUS;

		Object[] finderArgs = new Object[] { organizationId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPROVEDMENTORS_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONIDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONIDSTATUS_ORGANIZATIONID_2 =
		"approvedMentors.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONIDSTATUS_STATUS_2 = "approvedMentors.status = ?";

	public ApprovedMentorsPersistenceImpl() {
		setModelClass(ApprovedMentors.class);
	}

	/**
	 * Caches the approved mentors in the entity cache if it is enabled.
	 *
	 * @param approvedMentors the approved mentors
	 */
	@Override
	public void cacheResult(ApprovedMentors approvedMentors) {
		EntityCacheUtil.putResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsImpl.class, approvedMentors.getPrimaryKey(),
			approvedMentors);

		approvedMentors.resetOriginalValues();
	}

	/**
	 * Caches the approved mentorses in the entity cache if it is enabled.
	 *
	 * @param approvedMentorses the approved mentorses
	 */
	@Override
	public void cacheResult(List<ApprovedMentors> approvedMentorses) {
		for (ApprovedMentors approvedMentors : approvedMentorses) {
			if (EntityCacheUtil.getResult(
						ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
						ApprovedMentorsImpl.class,
						approvedMentors.getPrimaryKey()) == null) {
				cacheResult(approvedMentors);
			}
			else {
				approvedMentors.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all approved mentorses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ApprovedMentorsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ApprovedMentorsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the approved mentors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApprovedMentors approvedMentors) {
		EntityCacheUtil.removeResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsImpl.class, approvedMentors.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ApprovedMentors> approvedMentorses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApprovedMentors approvedMentors : approvedMentorses) {
			EntityCacheUtil.removeResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
				ApprovedMentorsImpl.class, approvedMentors.getPrimaryKey());
		}
	}

	/**
	 * Creates a new approved mentors with the primary key. Does not add the approved mentors to the database.
	 *
	 * @param mentorId the primary key for the new approved mentors
	 * @return the new approved mentors
	 */
	@Override
	public ApprovedMentors create(long mentorId) {
		ApprovedMentors approvedMentors = new ApprovedMentorsImpl();

		approvedMentors.setNew(true);
		approvedMentors.setPrimaryKey(mentorId);

		String uuid = PortalUUIDUtil.generate();

		approvedMentors.setUuid(uuid);

		return approvedMentors;
	}

	/**
	 * Removes the approved mentors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mentorId the primary key of the approved mentors
	 * @return the approved mentors that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors remove(long mentorId)
		throws NoSuchApprovedMentorsException, SystemException {
		return remove((Serializable)mentorId);
	}

	/**
	 * Removes the approved mentors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the approved mentors
	 * @return the approved mentors that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors remove(Serializable primaryKey)
		throws NoSuchApprovedMentorsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ApprovedMentors approvedMentors = (ApprovedMentors)session.get(ApprovedMentorsImpl.class,
					primaryKey);

			if (approvedMentors == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApprovedMentorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(approvedMentors);
		}
		catch (NoSuchApprovedMentorsException nsee) {
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
	protected ApprovedMentors removeImpl(ApprovedMentors approvedMentors)
		throws SystemException {
		approvedMentors = toUnwrappedModel(approvedMentors);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(approvedMentors)) {
				approvedMentors = (ApprovedMentors)session.get(ApprovedMentorsImpl.class,
						approvedMentors.getPrimaryKeyObj());
			}

			if (approvedMentors != null) {
				session.delete(approvedMentors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (approvedMentors != null) {
			clearCache(approvedMentors);
		}

		return approvedMentors;
	}

	@Override
	public ApprovedMentors updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors)
		throws SystemException {
		approvedMentors = toUnwrappedModel(approvedMentors);

		boolean isNew = approvedMentors.isNew();

		ApprovedMentorsModelImpl approvedMentorsModelImpl = (ApprovedMentorsModelImpl)approvedMentors;

		if (Validator.isNull(approvedMentors.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			approvedMentors.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (approvedMentors.isNew()) {
				session.save(approvedMentors);

				approvedMentors.setNew(false);
			}
			else {
				session.merge(approvedMentors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApprovedMentorsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { approvedMentorsModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { approvedMentorsModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { approvedMentorsModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { approvedMentorsModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalOrganizationId(),
						approvedMentorsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID,
					args);

				args = new Object[] {
						approvedMentorsModelImpl.getOrganizationId(),
						approvedMentorsModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDUSERID,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONIDAPPROVEDMENTORS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS,
					args);

				args = new Object[] { approvedMentorsModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONIDAPPROVEDMENTORS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDAPPROVEDMENTORS,
					args);
			}

			if ((approvedMentorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvedMentorsModelImpl.getOriginalOrganizationId(),
						approvedMentorsModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS,
					args);

				args = new Object[] {
						approvedMentorsModelImpl.getOrganizationId(),
						approvedMentorsModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONIDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
			ApprovedMentorsImpl.class, approvedMentors.getPrimaryKey(),
			approvedMentors);

		return approvedMentors;
	}

	protected ApprovedMentors toUnwrappedModel(ApprovedMentors approvedMentors) {
		if (approvedMentors instanceof ApprovedMentorsImpl) {
			return approvedMentors;
		}

		ApprovedMentorsImpl approvedMentorsImpl = new ApprovedMentorsImpl();

		approvedMentorsImpl.setNew(approvedMentors.isNew());
		approvedMentorsImpl.setPrimaryKey(approvedMentors.getPrimaryKey());

		approvedMentorsImpl.setUuid(approvedMentors.getUuid());
		approvedMentorsImpl.setMentorId(approvedMentors.getMentorId());
		approvedMentorsImpl.setOrganizationId(approvedMentors.getOrganizationId());
		approvedMentorsImpl.setUserId(approvedMentors.getUserId());
		approvedMentorsImpl.setCreateDate(approvedMentors.getCreateDate());
		approvedMentorsImpl.setApprovedDate(approvedMentors.getApprovedDate());
		approvedMentorsImpl.setRemarks(approvedMentors.getRemarks());
		approvedMentorsImpl.setStatus(approvedMentors.getStatus());

		return approvedMentorsImpl;
	}

	/**
	 * Returns the approved mentors with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the approved mentors
	 * @return the approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApprovedMentorsException, SystemException {
		ApprovedMentors approvedMentors = fetchByPrimaryKey(primaryKey);

		if (approvedMentors == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApprovedMentorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return approvedMentors;
	}

	/**
	 * Returns the approved mentors with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException} if it could not be found.
	 *
	 * @param mentorId the primary key of the approved mentors
	 * @return the approved mentors
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchApprovedMentorsException if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors findByPrimaryKey(long mentorId)
		throws NoSuchApprovedMentorsException, SystemException {
		return findByPrimaryKey((Serializable)mentorId);
	}

	/**
	 * Returns the approved mentors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the approved mentors
	 * @return the approved mentors, or <code>null</code> if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ApprovedMentors approvedMentors = (ApprovedMentors)EntityCacheUtil.getResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
				ApprovedMentorsImpl.class, primaryKey);

		if (approvedMentors == _nullApprovedMentors) {
			return null;
		}

		if (approvedMentors == null) {
			Session session = null;

			try {
				session = openSession();

				approvedMentors = (ApprovedMentors)session.get(ApprovedMentorsImpl.class,
						primaryKey);

				if (approvedMentors != null) {
					cacheResult(approvedMentors);
				}
				else {
					EntityCacheUtil.putResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
						ApprovedMentorsImpl.class, primaryKey,
						_nullApprovedMentors);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ApprovedMentorsModelImpl.ENTITY_CACHE_ENABLED,
					ApprovedMentorsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return approvedMentors;
	}

	/**
	 * Returns the approved mentors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mentorId the primary key of the approved mentors
	 * @return the approved mentors, or <code>null</code> if a approved mentors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApprovedMentors fetchByPrimaryKey(long mentorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mentorId);
	}

	/**
	 * Returns all the approved mentorses.
	 *
	 * @return the approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approved mentorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @return the range of approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the approved mentorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of approved mentorses
	 * @param end the upper bound of the range of approved mentorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of approved mentorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApprovedMentors> findAll(int start, int end,
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

		List<ApprovedMentors> list = (List<ApprovedMentors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_APPROVEDMENTORS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPROVEDMENTORS;

				if (pagination) {
					sql = sql.concat(ApprovedMentorsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApprovedMentors>(list);
				}
				else {
					list = (List<ApprovedMentors>)QueryUtil.list(q,
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
	 * Removes all the approved mentorses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ApprovedMentors approvedMentors : findAll()) {
			remove(approvedMentors);
		}
	}

	/**
	 * Returns the number of approved mentorses.
	 *
	 * @return the number of approved mentorses
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

				Query q = session.createQuery(_SQL_COUNT_APPROVEDMENTORS);

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
	 * Initializes the approved mentors persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.ApprovedMentors")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ApprovedMentors>> listenersList = new ArrayList<ModelListener<ApprovedMentors>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ApprovedMentors>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ApprovedMentorsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_APPROVEDMENTORS = "SELECT approvedMentors FROM ApprovedMentors approvedMentors";
	private static final String _SQL_SELECT_APPROVEDMENTORS_WHERE = "SELECT approvedMentors FROM ApprovedMentors approvedMentors WHERE ";
	private static final String _SQL_COUNT_APPROVEDMENTORS = "SELECT COUNT(approvedMentors) FROM ApprovedMentors approvedMentors";
	private static final String _SQL_COUNT_APPROVEDMENTORS_WHERE = "SELECT COUNT(approvedMentors) FROM ApprovedMentors approvedMentors WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "approvedMentors.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApprovedMentors exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApprovedMentors exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ApprovedMentorsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ApprovedMentors _nullApprovedMentors = new ApprovedMentorsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApprovedMentors> toCacheModel() {
				return _nullApprovedMentorsCacheModel;
			}
		};

	private static CacheModel<ApprovedMentors> _nullApprovedMentorsCacheModel = new CacheModel<ApprovedMentors>() {
			@Override
			public ApprovedMentors toEntityModel() {
				return _nullApprovedMentors;
			}
		};
}