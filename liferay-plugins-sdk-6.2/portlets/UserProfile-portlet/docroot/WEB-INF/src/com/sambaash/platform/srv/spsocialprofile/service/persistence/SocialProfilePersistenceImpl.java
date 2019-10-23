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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

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

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the social profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePersistence
 * @see SocialProfileUtil
 * @generated
 */
public class SocialProfilePersistenceImpl extends BasePersistenceImpl<SocialProfile>
	implements SocialProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfileUtil} to access the social profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			SocialProfileModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the social profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @return the range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profiles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid(String uuid, int start, int end,
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

		List<SocialProfile> list = (List<SocialProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfile socialProfile : list) {
				if (!Validator.equals(uuid, socialProfile.getUuid())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

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
				query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
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
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfile>(list);
				}
				else {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first social profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUuid_First(uuid, orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the first social profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfile> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUuid_Last(uuid, orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the last social profile in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialProfile> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profiles before and after the current social profile in the ordered set where uuid = &#63;.
	 *
	 * @param userId the primary key of the current social profile
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile[] findByUuid_PrevAndNext(long userId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			SocialProfile[] array = new SocialProfileImpl[3];

			array[0] = getByUuid_PrevAndNext(session, socialProfile, uuid,
					orderByComparator, true);

			array[1] = socialProfile;

			array[2] = getByUuid_PrevAndNext(session, socialProfile, uuid,
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

	protected SocialProfile getByUuid_PrevAndNext(Session session,
		SocialProfile socialProfile, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

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
			query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profiles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SocialProfile socialProfile : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(socialProfile);
		}
	}

	/**
	 * Returns the number of social profiles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social profiles
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

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "socialProfile.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "socialProfile.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(socialProfile.uuid IS NULL OR socialProfile.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileModelImpl.UUID_COLUMN_BITMASK |
			SocialProfileModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUUID_G(uuid, groupId);

		if (socialProfile == null) {
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

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the social profile where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if (!Validator.equals(uuid, socialProfile.getUuid()) ||
					(groupId != socialProfile.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

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

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getUuid() == null) ||
							!socialProfile.getUuid().equals(uuid) ||
							(socialProfile.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, socialProfile);
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByUUID_G(uuid, groupId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social profiles
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

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "socialProfile.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "socialProfile.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(socialProfile.uuid IS NULL OR socialProfile.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "socialProfile.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileModelImpl.UUID_COLUMN_BITMASK |
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the social profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @return the range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUuid_C(String uuid, long companyId,
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

		List<SocialProfile> list = (List<SocialProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfile socialProfile : list) {
				if (!Validator.equals(uuid, socialProfile.getUuid()) ||
						(companyId != socialProfile.getCompanyId())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

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
				query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
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
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfile>(list);
				}
				else {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the first social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfile> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the last social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SocialProfile> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profiles before and after the current social profile in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userId the primary key of the current social profile
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile[] findByUuid_C_PrevAndNext(long userId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			SocialProfile[] array = new SocialProfileImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, socialProfile, uuid,
					companyId, orderByComparator, true);

			array[1] = socialProfile;

			array[2] = getByUuid_C_PrevAndNext(session, socialProfile, uuid,
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

	protected SocialProfile getByUuid_C_PrevAndNext(Session session,
		SocialProfile socialProfile, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

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
			query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profiles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SocialProfile socialProfile : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfile);
		}
	}

	/**
	 * Returns the number of social profiles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social profiles
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

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "socialProfile.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "socialProfile.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(socialProfile.uuid IS NULL OR socialProfile.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "socialProfile.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndCompanyId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUserIdAndCompanyId(long companyId, long userId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUserIdAndCompanyId(companyId,
				userId);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserIdAndCompanyId(long companyId, long userId)
		throws SystemException {
		return fetchByUserIdAndCompanyId(companyId, userId, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserIdAndCompanyId(long companyId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					(userId != socialProfile.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByUserIdAndCompanyId(long companyId, long userId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByUserIdAndCompanyId(companyId, userId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndCompanyId(long companyId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID;

		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_COMPANYID_2 = "socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDCOMPANYID_USERID_2 = "socialProfile.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdCompIdAndRegStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.USERID_COLUMN_BITMASK |
			SocialProfileModelImpl.USERREGISTRATIONSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdCompIdAndRegStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param userRegistrationStatus the user registration status
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUserIdCompIdAndRegStatus(long companyId,
		long userId, String userRegistrationStatus)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUserIdCompIdAndRegStatus(companyId,
				userId, userRegistrationStatus);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", userRegistrationStatus=");
			msg.append(userRegistrationStatus);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param userRegistrationStatus the user registration status
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserIdCompIdAndRegStatus(long companyId,
		long userId, String userRegistrationStatus) throws SystemException {
		return fetchByUserIdCompIdAndRegStatus(companyId, userId,
			userRegistrationStatus, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param userRegistrationStatus the user registration status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserIdCompIdAndRegStatus(long companyId,
		long userId, String userRegistrationStatus, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, userId, userRegistrationStatus
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					(userId != socialProfile.getUserId()) ||
					!Validator.equals(userRegistrationStatus,
						socialProfile.getUserRegistrationStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERID_2);

			boolean bindUserRegistrationStatus = false;

			if (userRegistrationStatus == null) {
				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_1);
			}
			else if (userRegistrationStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_3);
			}
			else {
				bindUserRegistrationStatus = true;

				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				if (bindUserRegistrationStatus) {
					qPos.add(userRegistrationStatus);
				}

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getUserId() != userId) ||
							(socialProfile.getUserRegistrationStatus() == null) ||
							!socialProfile.getUserRegistrationStatus()
											  .equals(userRegistrationStatus)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param userRegistrationStatus the user registration status
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByUserIdCompIdAndRegStatus(long companyId,
		long userId, String userRegistrationStatus)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByUserIdCompIdAndRegStatus(companyId,
				userId, userRegistrationStatus);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and userId = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @param userRegistrationStatus the user registration status
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdCompIdAndRegStatus(long companyId, long userId,
		String userRegistrationStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS;

		Object[] finderArgs = new Object[] {
				companyId, userId, userRegistrationStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERID_2);

			boolean bindUserRegistrationStatus = false;

			if (userRegistrationStatus == null) {
				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_1);
			}
			else if (userRegistrationStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_3);
			}
			else {
				bindUserRegistrationStatus = true;

				query.append(_FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				if (bindUserRegistrationStatus) {
					qPos.add(userRegistrationStatus);
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

	private static final String _FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_COMPANYID_2 =
		"socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERID_2 =
		"socialProfile.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_1 =
		"socialProfile.userRegistrationStatus IS NULL";
	private static final String _FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_2 =
		"socialProfile.userRegistrationStatus = ?";
	private static final String _FINDER_COLUMN_USERIDCOMPIDANDREGSTATUS_USERREGISTRATIONSTATUS_3 =
		"(socialProfile.userRegistrationStatus IS NULL OR socialProfile.userRegistrationStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERPACKAGEID =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMemberPackageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERPACKAGEID =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMemberPackageId", new String[] { Long.class.getName() },
			SocialProfileModelImpl.MEMBERPACKAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERPACKAGEID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMemberPackageId", new String[] { Long.class.getName() });

	/**
	 * Returns all the social profiles where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @return the matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByMemberPackageId(long memberPackage)
		throws SystemException {
		return findByMemberPackageId(memberPackage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profiles where memberPackage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param memberPackage the member package
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @return the range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByMemberPackageId(long memberPackage,
		int start, int end) throws SystemException {
		return findByMemberPackageId(memberPackage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profiles where memberPackage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param memberPackage the member package
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByMemberPackageId(long memberPackage,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERPACKAGEID;
			finderArgs = new Object[] { memberPackage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERPACKAGEID;
			finderArgs = new Object[] {
					memberPackage,
					
					start, end, orderByComparator
				};
		}

		List<SocialProfile> list = (List<SocialProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfile socialProfile : list) {
				if ((memberPackage != socialProfile.getMemberPackage())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MEMBERPACKAGEID_MEMBERPACKAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberPackage);

				if (!pagination) {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfile>(list);
				}
				else {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first social profile in the ordered set where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByMemberPackageId_First(long memberPackage,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByMemberPackageId_First(memberPackage,
				orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("memberPackage=");
		msg.append(memberPackage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the first social profile in the ordered set where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByMemberPackageId_First(long memberPackage,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfile> list = findByMemberPackageId(memberPackage, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile in the ordered set where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByMemberPackageId_Last(long memberPackage,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByMemberPackageId_Last(memberPackage,
				orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("memberPackage=");
		msg.append(memberPackage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the last social profile in the ordered set where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByMemberPackageId_Last(long memberPackage,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMemberPackageId(memberPackage);

		if (count == 0) {
			return null;
		}

		List<SocialProfile> list = findByMemberPackageId(memberPackage,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profiles before and after the current social profile in the ordered set where memberPackage = &#63;.
	 *
	 * @param userId the primary key of the current social profile
	 * @param memberPackage the member package
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile[] findByMemberPackageId_PrevAndNext(long userId,
		long memberPackage, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			SocialProfile[] array = new SocialProfileImpl[3];

			array[0] = getByMemberPackageId_PrevAndNext(session, socialProfile,
					memberPackage, orderByComparator, true);

			array[1] = socialProfile;

			array[2] = getByMemberPackageId_PrevAndNext(session, socialProfile,
					memberPackage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialProfile getByMemberPackageId_PrevAndNext(Session session,
		SocialProfile socialProfile, long memberPackage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

		query.append(_FINDER_COLUMN_MEMBERPACKAGEID_MEMBERPACKAGE_2);

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
			query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(memberPackage);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profiles where memberPackage = &#63; from the database.
	 *
	 * @param memberPackage the member package
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMemberPackageId(long memberPackage)
		throws SystemException {
		for (SocialProfile socialProfile : findByMemberPackageId(
				memberPackage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfile);
		}
	}

	/**
	 * Returns the number of social profiles where memberPackage = &#63;.
	 *
	 * @param memberPackage the member package
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMemberPackageId(long memberPackage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERPACKAGEID;

		Object[] finderArgs = new Object[] { memberPackage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_MEMBERPACKAGEID_MEMBERPACKAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(memberPackage);

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

	private static final String _FINDER_COLUMN_MEMBERPACKAGEID_MEMBERPACKAGE_2 = "socialProfile.memberPackage = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserTypeAndRegStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS =
		new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserTypeAndRegStatus",
			new String[] { String.class.getName(), String.class.getName() },
			SocialProfileModelImpl.USERTYPE_COLUMN_BITMASK |
			SocialProfileModelImpl.USERREGISTRATIONSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERTYPEANDREGSTATUS = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserTypeAndRegStatus",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @return the matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUserTypeAndRegStatus(String userType,
		String userRegistrationStatus) throws SystemException {
		return findByUserTypeAndRegStatus(userType, userRegistrationStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @return the range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUserTypeAndRegStatus(String userType,
		String userRegistrationStatus, int start, int end)
		throws SystemException {
		return findByUserTypeAndRegStatus(userType, userRegistrationStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findByUserTypeAndRegStatus(String userType,
		String userRegistrationStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS;
			finderArgs = new Object[] { userType, userRegistrationStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS;
			finderArgs = new Object[] {
					userType, userRegistrationStatus,
					
					start, end, orderByComparator
				};
		}

		List<SocialProfile> list = (List<SocialProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfile socialProfile : list) {
				if (!Validator.equals(userType, socialProfile.getUserType()) ||
						!Validator.equals(userRegistrationStatus,
							socialProfile.getUserRegistrationStatus())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			boolean bindUserType = false;

			if (userType == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_1);
			}
			else if (userType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_3);
			}
			else {
				bindUserType = true;

				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_2);
			}

			boolean bindUserRegistrationStatus = false;

			if (userRegistrationStatus == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_1);
			}
			else if (userRegistrationStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_3);
			}
			else {
				bindUserRegistrationStatus = true;

				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserType) {
					qPos.add(userType);
				}

				if (bindUserRegistrationStatus) {
					qPos.add(userRegistrationStatus);
				}

				if (!pagination) {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfile>(list);
				}
				else {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUserTypeAndRegStatus_First(String userType,
		String userRegistrationStatus, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUserTypeAndRegStatus_First(userType,
				userRegistrationStatus, orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userType=");
		msg.append(userType);

		msg.append(", userRegistrationStatus=");
		msg.append(userRegistrationStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the first social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserTypeAndRegStatus_First(String userType,
		String userRegistrationStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<SocialProfile> list = findByUserTypeAndRegStatus(userType,
				userRegistrationStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByUserTypeAndRegStatus_Last(String userType,
		String userRegistrationStatus, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByUserTypeAndRegStatus_Last(userType,
				userRegistrationStatus, orderByComparator);

		if (socialProfile != null) {
			return socialProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userType=");
		msg.append(userType);

		msg.append(", userRegistrationStatus=");
		msg.append(userRegistrationStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileException(msg.toString());
	}

	/**
	 * Returns the last social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByUserTypeAndRegStatus_Last(String userType,
		String userRegistrationStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserTypeAndRegStatus(userType, userRegistrationStatus);

		if (count == 0) {
			return null;
		}

		List<SocialProfile> list = findByUserTypeAndRegStatus(userType,
				userRegistrationStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profiles before and after the current social profile in the ordered set where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userId the primary key of the current social profile
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile[] findByUserTypeAndRegStatus_PrevAndNext(long userId,
		String userType, String userRegistrationStatus,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			SocialProfile[] array = new SocialProfileImpl[3];

			array[0] = getByUserTypeAndRegStatus_PrevAndNext(session,
					socialProfile, userType, userRegistrationStatus,
					orderByComparator, true);

			array[1] = socialProfile;

			array[2] = getByUserTypeAndRegStatus_PrevAndNext(session,
					socialProfile, userType, userRegistrationStatus,
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

	protected SocialProfile getByUserTypeAndRegStatus_PrevAndNext(
		Session session, SocialProfile socialProfile, String userType,
		String userRegistrationStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

		boolean bindUserType = false;

		if (userType == null) {
			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_1);
		}
		else if (userType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_3);
		}
		else {
			bindUserType = true;

			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_2);
		}

		boolean bindUserRegistrationStatus = false;

		if (userRegistrationStatus == null) {
			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_1);
		}
		else if (userRegistrationStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_3);
		}
		else {
			bindUserRegistrationStatus = true;

			query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_2);
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
			query.append(SocialProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserType) {
			qPos.add(userType);
		}

		if (bindUserRegistrationStatus) {
			qPos.add(userRegistrationStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profiles where userType = &#63; and userRegistrationStatus = &#63; from the database.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserTypeAndRegStatus(String userType,
		String userRegistrationStatus) throws SystemException {
		for (SocialProfile socialProfile : findByUserTypeAndRegStatus(
				userType, userRegistrationStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(socialProfile);
		}
	}

	/**
	 * Returns the number of social profiles where userType = &#63; and userRegistrationStatus = &#63;.
	 *
	 * @param userType the user type
	 * @param userRegistrationStatus the user registration status
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserTypeAndRegStatus(String userType,
		String userRegistrationStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERTYPEANDREGSTATUS;

		Object[] finderArgs = new Object[] { userType, userRegistrationStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			boolean bindUserType = false;

			if (userType == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_1);
			}
			else if (userType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_3);
			}
			else {
				bindUserType = true;

				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_2);
			}

			boolean bindUserRegistrationStatus = false;

			if (userRegistrationStatus == null) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_1);
			}
			else if (userRegistrationStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_3);
			}
			else {
				bindUserRegistrationStatus = true;

				query.append(_FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserType) {
					qPos.add(userType);
				}

				if (bindUserRegistrationStatus) {
					qPos.add(userRegistrationStatus);
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

	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_1 = "socialProfile.userType IS NULL AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_2 = "socialProfile.userType = ? AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERTYPE_3 = "(socialProfile.userType IS NULL OR socialProfile.userType = '') AND ";
	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_1 =
		"socialProfile.userRegistrationStatus IS NULL";
	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_2 =
		"socialProfile.userRegistrationStatus = ?";
	private static final String _FINDER_COLUMN_USERTYPEANDREGSTATUS_USERREGISTRATIONSTATUS_3 =
		"(socialProfile.userRegistrationStatus IS NULL OR socialProfile.userRegistrationStatus = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TWITTERID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTwitterId",
			new String[] { Long.class.getName(), String.class.getName() },
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.TWITTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TWITTERID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTwitterId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the social profile where companyId = &#63; and twitterId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param twitterId the twitter ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByTwitterId(long companyId, String twitterId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByTwitterId(companyId, twitterId);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", twitterId=");
			msg.append(twitterId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param twitterId the twitter ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByTwitterId(long companyId, String twitterId)
		throws SystemException {
		return fetchByTwitterId(companyId, twitterId, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and twitterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param twitterId the twitter ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByTwitterId(long companyId, String twitterId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, twitterId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TWITTERID,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					!Validator.equals(twitterId, socialProfile.getTwitterId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_TWITTERID_COMPANYID_2);

			boolean bindTwitterId = false;

			if (twitterId == null) {
				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_1);
			}
			else if (twitterId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_3);
			}
			else {
				bindTwitterId = true;

				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindTwitterId) {
					qPos.add(twitterId);
				}

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERID,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getTwitterId() == null) ||
							!socialProfile.getTwitterId().equals(twitterId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERID,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERID,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and twitterId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param twitterId the twitter ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByTwitterId(long companyId, String twitterId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByTwitterId(companyId, twitterId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and twitterId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param twitterId the twitter ID
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTwitterId(long companyId, String twitterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TWITTERID;

		Object[] finderArgs = new Object[] { companyId, twitterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_TWITTERID_COMPANYID_2);

			boolean bindTwitterId = false;

			if (twitterId == null) {
				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_1);
			}
			else if (twitterId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_3);
			}
			else {
				bindTwitterId = true;

				query.append(_FINDER_COLUMN_TWITTERID_TWITTERID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindTwitterId) {
					qPos.add(twitterId);
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

	private static final String _FINDER_COLUMN_TWITTERID_COMPANYID_2 = "socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_TWITTERID_TWITTERID_1 = "socialProfile.twitterId IS NULL";
	private static final String _FINDER_COLUMN_TWITTERID_TWITTERID_2 = "socialProfile.twitterId = ?";
	private static final String _FINDER_COLUMN_TWITTERID_TWITTERID_3 = "(socialProfile.twitterId IS NULL OR socialProfile.twitterId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LINKEDINID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLinkedinId",
			new String[] { Long.class.getName(), String.class.getName() },
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.LINKEDINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LINKEDINID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLinkedinId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the social profile where companyId = &#63; and linkedinId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param linkedinId the linkedin ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByLinkedinId(long companyId, String linkedinId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByLinkedinId(companyId, linkedinId);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", linkedinId=");
			msg.append(linkedinId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param linkedinId the linkedin ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByLinkedinId(long companyId, String linkedinId)
		throws SystemException {
		return fetchByLinkedinId(companyId, linkedinId, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and linkedinId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param linkedinId the linkedin ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByLinkedinId(long companyId, String linkedinId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, linkedinId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LINKEDINID,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					!Validator.equals(linkedinId, socialProfile.getLinkedinId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_LINKEDINID_COMPANYID_2);

			boolean bindLinkedinId = false;

			if (linkedinId == null) {
				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_1);
			}
			else if (linkedinId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_3);
			}
			else {
				bindLinkedinId = true;

				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindLinkedinId) {
					qPos.add(linkedinId);
				}

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LINKEDINID,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getLinkedinId() == null) ||
							!socialProfile.getLinkedinId().equals(linkedinId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LINKEDINID,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LINKEDINID,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and linkedinId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param linkedinId the linkedin ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByLinkedinId(long companyId, String linkedinId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByLinkedinId(companyId, linkedinId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and linkedinId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param linkedinId the linkedin ID
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLinkedinId(long companyId, String linkedinId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LINKEDINID;

		Object[] finderArgs = new Object[] { companyId, linkedinId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_LINKEDINID_COMPANYID_2);

			boolean bindLinkedinId = false;

			if (linkedinId == null) {
				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_1);
			}
			else if (linkedinId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_3);
			}
			else {
				bindLinkedinId = true;

				query.append(_FINDER_COLUMN_LINKEDINID_LINKEDINID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindLinkedinId) {
					qPos.add(linkedinId);
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

	private static final String _FINDER_COLUMN_LINKEDINID_COMPANYID_2 = "socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_LINKEDINID_LINKEDINID_1 = "socialProfile.linkedinId IS NULL";
	private static final String _FINDER_COLUMN_LINKEDINID_LINKEDINID_2 = "socialProfile.linkedinId = ?";
	private static final String _FINDER_COLUMN_LINKEDINID_LINKEDINID_3 = "(socialProfile.linkedinId IS NULL OR socialProfile.linkedinId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_YAHOOID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByYahooId",
			new String[] { Long.class.getName(), String.class.getName() },
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.YAHOOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YAHOOID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYahooId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the social profile where companyId = &#63; and yahooId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param yahooId the yahoo ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByYahooId(long companyId, String yahooId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByYahooId(companyId, yahooId);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", yahooId=");
			msg.append(yahooId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param yahooId the yahoo ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByYahooId(long companyId, String yahooId)
		throws SystemException {
		return fetchByYahooId(companyId, yahooId, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and yahooId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param yahooId the yahoo ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByYahooId(long companyId, String yahooId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, yahooId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_YAHOOID,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					!Validator.equals(yahooId, socialProfile.getYahooId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_YAHOOID_COMPANYID_2);

			boolean bindYahooId = false;

			if (yahooId == null) {
				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_1);
			}
			else if (yahooId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_3);
			}
			else {
				bindYahooId = true;

				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindYahooId) {
					qPos.add(yahooId);
				}

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_YAHOOID,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getYahooId() == null) ||
							!socialProfile.getYahooId().equals(yahooId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_YAHOOID,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_YAHOOID,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and yahooId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param yahooId the yahoo ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByYahooId(long companyId, String yahooId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByYahooId(companyId, yahooId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and yahooId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param yahooId the yahoo ID
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYahooId(long companyId, String yahooId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YAHOOID;

		Object[] finderArgs = new Object[] { companyId, yahooId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_YAHOOID_COMPANYID_2);

			boolean bindYahooId = false;

			if (yahooId == null) {
				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_1);
			}
			else if (yahooId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_3);
			}
			else {
				bindYahooId = true;

				query.append(_FINDER_COLUMN_YAHOOID_YAHOOID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindYahooId) {
					qPos.add(yahooId);
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

	private static final String _FINDER_COLUMN_YAHOOID_COMPANYID_2 = "socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_YAHOOID_YAHOOID_1 = "socialProfile.yahooId IS NULL";
	private static final String _FINDER_COLUMN_YAHOOID_YAHOOID_2 = "socialProfile.yahooId = ?";
	private static final String _FINDER_COLUMN_YAHOOID_YAHOOID_3 = "(socialProfile.yahooId IS NULL OR socialProfile.yahooId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GOOGLEID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGoogleId",
			new String[] { Long.class.getName(), String.class.getName() },
			SocialProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileModelImpl.GOOGLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GOOGLEID = new FinderPath(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGoogleId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the social profile where companyId = &#63; and googleId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the matching social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByGoogleId(long companyId, String googleId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByGoogleId(companyId, googleId);

		if (socialProfile == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", googleId=");
			msg.append(googleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileException(msg.toString());
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByGoogleId(long companyId, String googleId)
		throws SystemException {
		return fetchByGoogleId(companyId, googleId, true);
	}

	/**
	 * Returns the social profile where companyId = &#63; and googleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile, or <code>null</code> if a matching social profile could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByGoogleId(long companyId, String googleId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyId, googleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GOOGLEID,
					finderArgs, this);
		}

		if (result instanceof SocialProfile) {
			SocialProfile socialProfile = (SocialProfile)result;

			if ((companyId != socialProfile.getCompanyId()) ||
					!Validator.equals(googleId, socialProfile.getGoogleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_GOOGLEID_COMPANYID_2);

			boolean bindGoogleId = false;

			if (googleId == null) {
				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_1);
			}
			else if (googleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_3);
			}
			else {
				bindGoogleId = true;

				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindGoogleId) {
					qPos.add(googleId);
				}

				List<SocialProfile> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOOGLEID,
						finderArgs, list);
				}
				else {
					SocialProfile socialProfile = list.get(0);

					result = socialProfile;

					cacheResult(socialProfile);

					if ((socialProfile.getCompanyId() != companyId) ||
							(socialProfile.getGoogleId() == null) ||
							!socialProfile.getGoogleId().equals(googleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOOGLEID,
							finderArgs, socialProfile);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOOGLEID,
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
			return (SocialProfile)result;
		}
	}

	/**
	 * Removes the social profile where companyId = &#63; and googleId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the social profile that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile removeByGoogleId(long companyId, String googleId)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = findByGoogleId(companyId, googleId);

		return remove(socialProfile);
	}

	/**
	 * Returns the number of social profiles where companyId = &#63; and googleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the number of matching social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGoogleId(long companyId, String googleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GOOGLEID;

		Object[] finderArgs = new Object[] { companyId, googleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILE_WHERE);

			query.append(_FINDER_COLUMN_GOOGLEID_COMPANYID_2);

			boolean bindGoogleId = false;

			if (googleId == null) {
				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_1);
			}
			else if (googleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_3);
			}
			else {
				bindGoogleId = true;

				query.append(_FINDER_COLUMN_GOOGLEID_GOOGLEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindGoogleId) {
					qPos.add(googleId);
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

	private static final String _FINDER_COLUMN_GOOGLEID_COMPANYID_2 = "socialProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_GOOGLEID_GOOGLEID_1 = "socialProfile.googleId IS NULL";
	private static final String _FINDER_COLUMN_GOOGLEID_GOOGLEID_2 = "socialProfile.googleId = ?";
	private static final String _FINDER_COLUMN_GOOGLEID_GOOGLEID_3 = "(socialProfile.googleId IS NULL OR socialProfile.googleId = '')";

	public SocialProfilePersistenceImpl() {
		setModelClass(SocialProfile.class);
	}

	/**
	 * Caches the social profile in the entity cache if it is enabled.
	 *
	 * @param socialProfile the social profile
	 */
	@Override
	public void cacheResult(SocialProfile socialProfile) {
		EntityCacheUtil.putResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileImpl.class, socialProfile.getPrimaryKey(),
			socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { socialProfile.getUuid(), socialProfile.getGroupId() },
			socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
			new Object[] { socialProfile.getCompanyId(), socialProfile.getUserId() },
			socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
			new Object[] {
				socialProfile.getCompanyId(), socialProfile.getUserId(),
				socialProfile.getUserRegistrationStatus()
			}, socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERID,
			new Object[] {
				socialProfile.getCompanyId(), socialProfile.getTwitterId()
			}, socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LINKEDINID,
			new Object[] {
				socialProfile.getCompanyId(), socialProfile.getLinkedinId()
			}, socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_YAHOOID,
			new Object[] {
				socialProfile.getCompanyId(), socialProfile.getYahooId()
			}, socialProfile);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOOGLEID,
			new Object[] {
				socialProfile.getCompanyId(), socialProfile.getGoogleId()
			}, socialProfile);

		socialProfile.resetOriginalValues();
	}

	/**
	 * Caches the social profiles in the entity cache if it is enabled.
	 *
	 * @param socialProfiles the social profiles
	 */
	@Override
	public void cacheResult(List<SocialProfile> socialProfiles) {
		for (SocialProfile socialProfile : socialProfiles) {
			if (EntityCacheUtil.getResult(
						SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileImpl.class, socialProfile.getPrimaryKey()) == null) {
				cacheResult(socialProfile);
			}
			else {
				socialProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfile socialProfile) {
		EntityCacheUtil.removeResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileImpl.class, socialProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfile);
	}

	@Override
	public void clearCache(List<SocialProfile> socialProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfile socialProfile : socialProfiles) {
			EntityCacheUtil.removeResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileImpl.class, socialProfile.getPrimaryKey());

			clearUniqueFindersCache(socialProfile);
		}
	}

	protected void cacheUniqueFindersCache(SocialProfile socialProfile) {
		if (socialProfile.isNew()) {
			Object[] args = new Object[] {
					socialProfile.getUuid(), socialProfile.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
				args, socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getUserId(),
					socialProfile.getUserRegistrationStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
				args, socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getTwitterId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TWITTERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERID, args,
				socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getLinkedinId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LINKEDINID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LINKEDINID, args,
				socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getYahooId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YAHOOID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_YAHOOID, args,
				socialProfile);

			args = new Object[] {
					socialProfile.getCompanyId(), socialProfile.getGoogleId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GOOGLEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOOGLEID, args,
				socialProfile);
		}
		else {
			SocialProfileModelImpl socialProfileModelImpl = (SocialProfileModelImpl)socialProfile;

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getUuid(), socialProfile.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(), socialProfile.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
					args, socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(), socialProfile.getUserId(),
						socialProfile.getUserRegistrationStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
					args, socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TWITTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(),
						socialProfile.getTwitterId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TWITTERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TWITTERID, args,
					socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LINKEDINID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(),
						socialProfile.getLinkedinId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LINKEDINID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LINKEDINID,
					args, socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_YAHOOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(), socialProfile.getYahooId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YAHOOID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_YAHOOID, args,
					socialProfile);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GOOGLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfile.getCompanyId(),
						socialProfile.getGoogleId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GOOGLEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GOOGLEID, args,
					socialProfile);
			}
		}
	}

	protected void clearUniqueFindersCache(SocialProfile socialProfile) {
		SocialProfileModelImpl socialProfileModelImpl = (SocialProfileModelImpl)socialProfile;

		Object[] args = new Object[] {
				socialProfile.getUuid(), socialProfile.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalUuid(),
					socialProfileModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
			args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYID,
				args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getUserId(),
				socialProfile.getUserRegistrationStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
			args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalUserId(),
					socialProfileModelImpl.getOriginalUserRegistrationStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOMPIDANDREGSTATUS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDCOMPIDANDREGSTATUS,
				args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getTwitterId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TWITTERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERID, args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TWITTERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalTwitterId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TWITTERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TWITTERID, args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getLinkedinId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKEDINID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LINKEDINID, args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LINKEDINID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalLinkedinId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKEDINID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LINKEDINID, args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getYahooId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YAHOOID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_YAHOOID, args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_YAHOOID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalYahooId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YAHOOID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_YAHOOID, args);
		}

		args = new Object[] {
				socialProfile.getCompanyId(), socialProfile.getGoogleId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GOOGLEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOOGLEID, args);

		if ((socialProfileModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GOOGLEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileModelImpl.getOriginalCompanyId(),
					socialProfileModelImpl.getOriginalGoogleId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GOOGLEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GOOGLEID, args);
		}
	}

	/**
	 * Creates a new social profile with the primary key. Does not add the social profile to the database.
	 *
	 * @param userId the primary key for the new social profile
	 * @return the new social profile
	 */
	@Override
	public SocialProfile create(long userId) {
		SocialProfile socialProfile = new SocialProfileImpl();

		socialProfile.setNew(true);
		socialProfile.setPrimaryKey(userId);

		String uuid = PortalUUIDUtil.generate();

		socialProfile.setUuid(uuid);

		return socialProfile;
	}

	/**
	 * Removes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the social profile
	 * @return the social profile that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile remove(long userId)
		throws NoSuchSocialProfileException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the social profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile
	 * @return the social profile that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile remove(Serializable primaryKey)
		throws NoSuchSocialProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfile socialProfile = (SocialProfile)session.get(SocialProfileImpl.class,
					primaryKey);

			if (socialProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfile);
		}
		catch (NoSuchSocialProfileException nsee) {
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
	protected SocialProfile removeImpl(SocialProfile socialProfile)
		throws SystemException {
		socialProfile = toUnwrappedModel(socialProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfile)) {
				socialProfile = (SocialProfile)session.get(SocialProfileImpl.class,
						socialProfile.getPrimaryKeyObj());
			}

			if (socialProfile != null) {
				session.delete(socialProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfile != null) {
			clearCache(socialProfile);
		}

		return socialProfile;
	}

	@Override
	public SocialProfile updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile)
		throws SystemException {
		socialProfile = toUnwrappedModel(socialProfile);

		boolean isNew = socialProfile.isNew();

		SocialProfileModelImpl socialProfileModelImpl = (SocialProfileModelImpl)socialProfile;

		if (Validator.isNull(socialProfile.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			socialProfile.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (socialProfile.isNew()) {
				session.save(socialProfile);

				socialProfile.setNew(false);
			}
			else {
				session.merge(socialProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { socialProfileModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileModelImpl.getOriginalUuid(),
						socialProfileModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						socialProfileModelImpl.getUuid(),
						socialProfileModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERPACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileModelImpl.getOriginalMemberPackage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERPACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERPACKAGEID,
					args);

				args = new Object[] { socialProfileModelImpl.getMemberPackage() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERPACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERPACKAGEID,
					args);
			}

			if ((socialProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileModelImpl.getOriginalUserType(),
						socialProfileModelImpl.getOriginalUserRegistrationStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEANDREGSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS,
					args);

				args = new Object[] {
						socialProfileModelImpl.getUserType(),
						socialProfileModelImpl.getUserRegistrationStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERTYPEANDREGSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERTYPEANDREGSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileImpl.class, socialProfile.getPrimaryKey(),
			socialProfile);

		clearUniqueFindersCache(socialProfile);
		cacheUniqueFindersCache(socialProfile);

		return socialProfile;
	}

	protected SocialProfile toUnwrappedModel(SocialProfile socialProfile) {
		if (socialProfile instanceof SocialProfileImpl) {
			return socialProfile;
		}

		SocialProfileImpl socialProfileImpl = new SocialProfileImpl();

		socialProfileImpl.setNew(socialProfile.isNew());
		socialProfileImpl.setPrimaryKey(socialProfile.getPrimaryKey());

		socialProfileImpl.setUuid(socialProfile.getUuid());
		socialProfileImpl.setUserId(socialProfile.getUserId());
		socialProfileImpl.setGroupId(socialProfile.getGroupId());
		socialProfileImpl.setCompanyId(socialProfile.getCompanyId());
		socialProfileImpl.setCreateDate(socialProfile.getCreateDate());
		socialProfileImpl.setModifiedDate(socialProfile.getModifiedDate());
		socialProfileImpl.setUserType(socialProfile.getUserType());
		socialProfileImpl.setMemberPackage(socialProfile.getMemberPackage());
		socialProfileImpl.setUserRegistrationStatus(socialProfile.getUserRegistrationStatus());
		socialProfileImpl.setClassPK(socialProfile.getClassPK());
		socialProfileImpl.setLocation(socialProfile.getLocation());
		socialProfileImpl.setProfileViewCount(socialProfile.getProfileViewCount());
		socialProfileImpl.setInterest(socialProfile.getInterest());
		socialProfileImpl.setHonors(socialProfile.getHonors());
		socialProfileImpl.setGroupAssociation(socialProfile.getGroupAssociation());
		socialProfileImpl.setSkillsQualification(socialProfile.getSkillsQualification());
		socialProfileImpl.setTitle(socialProfile.getTitle());
		socialProfileImpl.setTrainingEducation(socialProfile.getTrainingEducation());
		socialProfileImpl.setAbout(socialProfile.getAbout());
		socialProfileImpl.setDocumentId(socialProfile.getDocumentId());
		socialProfileImpl.setUserInfo(socialProfile.getUserInfo());
		socialProfileImpl.setStatus(socialProfile.getStatus());
		socialProfileImpl.setTwitterId(socialProfile.getTwitterId());
		socialProfileImpl.setLinkedinId(socialProfile.getLinkedinId());
		socialProfileImpl.setYahooId(socialProfile.getYahooId());
		socialProfileImpl.setGoogleId(socialProfile.getGoogleId());
		socialProfileImpl.setFacebookAuthToken(socialProfile.getFacebookAuthToken());
		socialProfileImpl.setOpenIdAuthToken(socialProfile.getOpenIdAuthToken());
		socialProfileImpl.setTwitterAuthToken(socialProfile.getTwitterAuthToken());
		socialProfileImpl.setLinkedinAuthToken(socialProfile.getLinkedinAuthToken());
		socialProfileImpl.setYahooAuthToken(socialProfile.getYahooAuthToken());
		socialProfileImpl.setGoogleAuthToken(socialProfile.getGoogleAuthToken());
		socialProfileImpl.setFacebookAuthSecret(socialProfile.getFacebookAuthSecret());
		socialProfileImpl.setOpenIdAuthSecret(socialProfile.getOpenIdAuthSecret());
		socialProfileImpl.setTwitterAuthSecret(socialProfile.getTwitterAuthSecret());
		socialProfileImpl.setLinkedinAuthSecret(socialProfile.getLinkedinAuthSecret());
		socialProfileImpl.setYahooAuthSecret(socialProfile.getYahooAuthSecret());
		socialProfileImpl.setGoogleAuthSecret(socialProfile.getGoogleAuthSecret());
		socialProfileImpl.setLoginCount(socialProfile.getLoginCount());
		socialProfileImpl.setUpdateInterestsStatus(socialProfile.getUpdateInterestsStatus());

		return socialProfileImpl;
	}

	/**
	 * Returns the social profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile
	 * @return the social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfileException, SystemException {
		SocialProfile socialProfile = fetchByPrimaryKey(primaryKey);

		if (socialProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException} if it could not be found.
	 *
	 * @param userId the primary key of the social profile
	 * @return the social profile
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileException if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile findByPrimaryKey(long userId)
		throws NoSuchSocialProfileException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the social profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile
	 * @return the social profile, or <code>null</code> if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfile socialProfile = (SocialProfile)EntityCacheUtil.getResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileImpl.class, primaryKey);

		if (socialProfile == _nullSocialProfile) {
			return null;
		}

		if (socialProfile == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfile = (SocialProfile)session.get(SocialProfileImpl.class,
						primaryKey);

				if (socialProfile != null) {
					cacheResult(socialProfile);
				}
				else {
					EntityCacheUtil.putResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileImpl.class, primaryKey, _nullSocialProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfileModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfile;
	}

	/**
	 * Returns the social profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the social profile
	 * @return the social profile, or <code>null</code> if a social profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfile fetchByPrimaryKey(long userId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the social profiles.
	 *
	 * @return the social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @return the range of social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profiles
	 * @param end the upper bound of the range of social profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfile> findAll(int start, int end,
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

		List<SocialProfile> list = (List<SocialProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILE;

				if (pagination) {
					sql = sql.concat(SocialProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfile>(list);
				}
				else {
					list = (List<SocialProfile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the social profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfile socialProfile : findAll()) {
			remove(socialProfile);
		}
	}

	/**
	 * Returns the number of social profiles.
	 *
	 * @return the number of social profiles
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILE);

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
	 * Initializes the social profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfile>> listenersList = new ArrayList<ModelListener<SocialProfile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILE = "SELECT socialProfile FROM SocialProfile socialProfile";
	private static final String _SQL_SELECT_SOCIALPROFILE_WHERE = "SELECT socialProfile FROM SocialProfile socialProfile WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILE = "SELECT COUNT(socialProfile) FROM SocialProfile socialProfile";
	private static final String _SQL_COUNT_SOCIALPROFILE_WHERE = "SELECT COUNT(socialProfile) FROM SocialProfile socialProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfilePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SocialProfile _nullSocialProfile = new SocialProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfile> toCacheModel() {
				return _nullSocialProfileCacheModel;
			}
		};

	private static CacheModel<SocialProfile> _nullSocialProfileCacheModel = new CacheModel<SocialProfile>() {
			@Override
			public SocialProfile toEntityModel() {
				return _nullSocialProfile;
			}
		};
}