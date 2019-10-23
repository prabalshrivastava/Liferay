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

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the social profile detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileDetailPersistence
 * @see SocialProfileDetailUtil
 * @generated
 */
public class SocialProfileDetailPersistenceImpl extends BasePersistenceImpl<SocialProfileDetail>
	implements SocialProfileDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfileDetailUtil} to access the social profile detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfileDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SocialProfileDetailModelImpl.UUID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the social profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @return the range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid(String uuid, int start,
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

		List<SocialProfileDetail> list = (List<SocialProfileDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileDetail socialProfileDetail : list) {
				if (!Validator.equals(uuid, socialProfileDetail.getUuid())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

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
				query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileDetail>(list);
				}
				else {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
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
	 * Returns the first social profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUuid_First(uuid,
				orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the first social profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileDetail> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUuid_Last(uuid,
				orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the last social profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialProfileDetail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile details before and after the current social profile detail in the ordered set where uuid = &#63;.
	 *
	 * @param socialProfileDetailId the primary key of the current social profile detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail[] findByUuid_PrevAndNext(
		long socialProfileDetailId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByPrimaryKey(socialProfileDetailId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileDetail[] array = new SocialProfileDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, socialProfileDetail,
					uuid, orderByComparator, true);

			array[1] = socialProfileDetail;

			array[2] = getByUuid_PrevAndNext(session, socialProfileDetail,
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

	protected SocialProfileDetail getByUuid_PrevAndNext(Session session,
		SocialProfileDetail socialProfileDetail, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

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
			query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SocialProfileDetail socialProfileDetail : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfileDetail);
		}
	}

	/**
	 * Returns the number of social profile details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social profile details
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

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "socialProfileDetail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "socialProfileDetail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(socialProfileDetail.uuid IS NULL OR socialProfileDetail.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileDetailModelImpl.UUID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile detail where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUUID_G(uuid, groupId);

		if (socialProfileDetail == null) {
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

			throw new NoSuchSocialProfileDetailException(msg.toString());
		}

		return socialProfileDetail;
	}

	/**
	 * Returns the social profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the social profile detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SocialProfileDetail) {
			SocialProfileDetail socialProfileDetail = (SocialProfileDetail)result;

			if (!Validator.equals(uuid, socialProfileDetail.getUuid()) ||
					(groupId != socialProfileDetail.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

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

				List<SocialProfileDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SocialProfileDetail socialProfileDetail = list.get(0);

					result = socialProfileDetail;

					cacheResult(socialProfileDetail);

					if ((socialProfileDetail.getUuid() == null) ||
							!socialProfileDetail.getUuid().equals(uuid) ||
							(socialProfileDetail.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, socialProfileDetail);
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
			return (SocialProfileDetail)result;
		}
	}

	/**
	 * Removes the social profile detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social profile detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByUUID_G(uuid, groupId);

		return remove(socialProfileDetail);
	}

	/**
	 * Returns the number of social profile details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social profile details
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

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "socialProfileDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "socialProfileDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(socialProfileDetail.uuid IS NULL OR socialProfileDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "socialProfileDetail.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileDetailModelImpl.UUID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the social profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @return the range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUuid_C(String uuid, long companyId,
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

		List<SocialProfileDetail> list = (List<SocialProfileDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileDetail socialProfileDetail : list) {
				if (!Validator.equals(uuid, socialProfileDetail.getUuid()) ||
						(companyId != socialProfileDetail.getCompanyId())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

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
				query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
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
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileDetail>(list);
				}
				else {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
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
	 * Returns the first social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the first social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileDetail> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the last social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SocialProfileDetail> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile details before and after the current social profile detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialProfileDetailId the primary key of the current social profile detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail[] findByUuid_C_PrevAndNext(
		long socialProfileDetailId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByPrimaryKey(socialProfileDetailId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileDetail[] array = new SocialProfileDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, socialProfileDetail,
					uuid, companyId, orderByComparator, true);

			array[1] = socialProfileDetail;

			array[2] = getByUuid_C_PrevAndNext(session, socialProfileDetail,
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

	protected SocialProfileDetail getByUuid_C_PrevAndNext(Session session,
		SocialProfileDetail socialProfileDetail, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

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
			query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SocialProfileDetail socialProfileDetail : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfileDetail);
		}
	}

	/**
	 * Returns the number of social profile details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social profile details
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

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "socialProfileDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "socialProfileDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(socialProfileDetail.uuid IS NULL OR socialProfileDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "socialProfileDetail.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SocialProfileDetailModelImpl.USERID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the social profile details where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile details where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @return the range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile details where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findByUserId(long userId, int start,
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

		List<SocialProfileDetail> list = (List<SocialProfileDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileDetail socialProfileDetail : list) {
				if ((userId != socialProfileDetail.getUserId())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileDetail>(list);
				}
				else {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
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
	 * Returns the first social profile detail in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUserId_First(userId,
				orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the first social profile detail in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileDetail> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile detail in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUserId_Last(userId,
				orderByComparator);

		if (socialProfileDetail != null) {
			return socialProfileDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileDetailException(msg.toString());
	}

	/**
	 * Returns the last social profile detail in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SocialProfileDetail> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile details before and after the current social profile detail in the ordered set where userId = &#63;.
	 *
	 * @param socialProfileDetailId the primary key of the current social profile detail
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail[] findByUserId_PrevAndNext(
		long socialProfileDetailId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByPrimaryKey(socialProfileDetailId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileDetail[] array = new SocialProfileDetailImpl[3];

			array[0] = getByUserId_PrevAndNext(session, socialProfileDetail,
					userId, orderByComparator, true);

			array[1] = socialProfileDetail;

			array[2] = getByUserId_PrevAndNext(session, socialProfileDetail,
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

	protected SocialProfileDetail getByUserId_PrevAndNext(Session session,
		SocialProfileDetail socialProfileDetail, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile details where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SocialProfileDetail socialProfileDetail : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfileDetail);
		}
	}

	/**
	 * Returns the number of social profile details where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "socialProfileDetail.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndUserJobId",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileDetailModelImpl.USERJOBID_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndUserJobId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile detail where userJobId = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	 *
	 * @param userJobId the user job ID
	 * @param userId the user ID
	 * @return the matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUserIdAndUserJobId(String userJobId,
		long userId) throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUserIdAndUserJobId(userJobId,
				userId);

		if (socialProfileDetail == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userJobId=");
			msg.append(userJobId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileDetailException(msg.toString());
		}

		return socialProfileDetail;
	}

	/**
	 * Returns the social profile detail where userJobId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userJobId the user job ID
	 * @param userId the user ID
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserIdAndUserJobId(String userJobId,
		long userId) throws SystemException {
		return fetchByUserIdAndUserJobId(userJobId, userId, true);
	}

	/**
	 * Returns the social profile detail where userJobId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userJobId the user job ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserIdAndUserJobId(String userJobId,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userJobId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
					finderArgs, this);
		}

		if (result instanceof SocialProfileDetail) {
			SocialProfileDetail socialProfileDetail = (SocialProfileDetail)result;

			if (!Validator.equals(userJobId, socialProfileDetail.getUserJobId()) ||
					(userId != socialProfileDetail.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

			boolean bindUserJobId = false;

			if (userJobId == null) {
				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_1);
			}
			else if (userJobId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_3);
			}
			else {
				bindUserJobId = true;

				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_2);
			}

			query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserJobId) {
					qPos.add(userJobId);
				}

				qPos.add(userId);

				List<SocialProfileDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
						finderArgs, list);
				}
				else {
					SocialProfileDetail socialProfileDetail = list.get(0);

					result = socialProfileDetail;

					cacheResult(socialProfileDetail);

					if ((socialProfileDetail.getUserJobId() == null) ||
							!socialProfileDetail.getUserJobId().equals(userJobId) ||
							(socialProfileDetail.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
							finderArgs, socialProfileDetail);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
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
			return (SocialProfileDetail)result;
		}
	}

	/**
	 * Removes the social profile detail where userJobId = &#63; and userId = &#63; from the database.
	 *
	 * @param userJobId the user job ID
	 * @param userId the user ID
	 * @return the social profile detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail removeByUserIdAndUserJobId(String userJobId,
		long userId) throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByUserIdAndUserJobId(userJobId,
				userId);

		return remove(socialProfileDetail);
	}

	/**
	 * Returns the number of social profile details where userJobId = &#63; and userId = &#63;.
	 *
	 * @param userJobId the user job ID
	 * @param userId the user ID
	 * @return the number of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndUserJobId(String userJobId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID;

		Object[] finderArgs = new Object[] { userJobId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

			boolean bindUserJobId = false;

			if (userJobId == null) {
				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_1);
			}
			else if (userJobId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_3);
			}
			else {
				bindUserJobId = true;

				query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_2);
			}

			query.append(_FINDER_COLUMN_USERIDANDUSERJOBID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserJobId) {
					qPos.add(userJobId);
				}

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

	private static final String _FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_1 = "socialProfileDetail.userJobId IS NULL AND ";
	private static final String _FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_2 = "socialProfileDetail.userJobId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDUSERJOBID_USERJOBID_3 = "(socialProfileDetail.userJobId IS NULL OR socialProfileDetail.userJobId = '') AND ";
	private static final String _FINDER_COLUMN_USERIDANDUSERJOBID_USERID_2 = "socialProfileDetail.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndCompanyName",
			new String[] { String.class.getName(), Long.class.getName() },
			SocialProfileDetailModelImpl.COMPANYNAME_COLUMN_BITMASK |
			SocialProfileDetailModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME = new FinderPath(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndCompanyName",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile detail where companyName = &#63; and userId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	 *
	 * @param companyName the company name
	 * @param userId the user ID
	 * @return the matching social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByUserIdAndCompanyName(String companyName,
		long userId) throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByUserIdAndCompanyName(companyName,
				userId);

		if (socialProfileDetail == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyName=");
			msg.append(companyName);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileDetailException(msg.toString());
		}

		return socialProfileDetail;
	}

	/**
	 * Returns the social profile detail where companyName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyName the company name
	 * @param userId the user ID
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserIdAndCompanyName(String companyName,
		long userId) throws SystemException {
		return fetchByUserIdAndCompanyName(companyName, userId, true);
	}

	/**
	 * Returns the social profile detail where companyName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyName the company name
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile detail, or <code>null</code> if a matching social profile detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByUserIdAndCompanyName(String companyName,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { companyName, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
					finderArgs, this);
		}

		if (result instanceof SocialProfileDetail) {
			SocialProfileDetail socialProfileDetail = (SocialProfileDetail)result;

			if (!Validator.equals(companyName,
						socialProfileDetail.getCompanyName()) ||
					(userId != socialProfileDetail.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILEDETAIL_WHERE);

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_2);
			}

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompanyName) {
					qPos.add(companyName);
				}

				qPos.add(userId);

				List<SocialProfileDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
						finderArgs, list);
				}
				else {
					SocialProfileDetail socialProfileDetail = list.get(0);

					result = socialProfileDetail;

					cacheResult(socialProfileDetail);

					if ((socialProfileDetail.getCompanyName() == null) ||
							!socialProfileDetail.getCompanyName()
													.equals(companyName) ||
							(socialProfileDetail.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
							finderArgs, socialProfileDetail);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
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
			return (SocialProfileDetail)result;
		}
	}

	/**
	 * Removes the social profile detail where companyName = &#63; and userId = &#63; from the database.
	 *
	 * @param companyName the company name
	 * @param userId the user ID
	 * @return the social profile detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail removeByUserIdAndCompanyName(
		String companyName, long userId)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = findByUserIdAndCompanyName(companyName,
				userId);

		return remove(socialProfileDetail);
	}

	/**
	 * Returns the number of social profile details where companyName = &#63; and userId = &#63;.
	 *
	 * @param companyName the company name
	 * @param userId the user ID
	 * @return the number of matching social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndCompanyName(String companyName, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME;

		Object[] finderArgs = new Object[] { companyName, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILEDETAIL_WHERE);

			boolean bindCompanyName = false;

			if (companyName == null) {
				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_1);
			}
			else if (companyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_3);
			}
			else {
				bindCompanyName = true;

				query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_2);
			}

			query.append(_FINDER_COLUMN_USERIDANDCOMPANYNAME_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCompanyName) {
					qPos.add(companyName);
				}

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

	private static final String _FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_1 =
		"socialProfileDetail.companyName IS NULL AND ";
	private static final String _FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_2 =
		"socialProfileDetail.companyName = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDCOMPANYNAME_COMPANYNAME_3 =
		"(socialProfileDetail.companyName IS NULL OR socialProfileDetail.companyName = '') AND ";
	private static final String _FINDER_COLUMN_USERIDANDCOMPANYNAME_USERID_2 = "socialProfileDetail.userId = ?";

	public SocialProfileDetailPersistenceImpl() {
		setModelClass(SocialProfileDetail.class);
	}

	/**
	 * Caches the social profile detail in the entity cache if it is enabled.
	 *
	 * @param socialProfileDetail the social profile detail
	 */
	@Override
	public void cacheResult(SocialProfileDetail socialProfileDetail) {
		EntityCacheUtil.putResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailImpl.class, socialProfileDetail.getPrimaryKey(),
			socialProfileDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				socialProfileDetail.getUuid(), socialProfileDetail.getGroupId()
			}, socialProfileDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
			new Object[] {
				socialProfileDetail.getUserJobId(),
				socialProfileDetail.getUserId()
			}, socialProfileDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
			new Object[] {
				socialProfileDetail.getCompanyName(),
				socialProfileDetail.getUserId()
			}, socialProfileDetail);

		socialProfileDetail.resetOriginalValues();
	}

	/**
	 * Caches the social profile details in the entity cache if it is enabled.
	 *
	 * @param socialProfileDetails the social profile details
	 */
	@Override
	public void cacheResult(List<SocialProfileDetail> socialProfileDetails) {
		for (SocialProfileDetail socialProfileDetail : socialProfileDetails) {
			if (EntityCacheUtil.getResult(
						SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileDetailImpl.class,
						socialProfileDetail.getPrimaryKey()) == null) {
				cacheResult(socialProfileDetail);
			}
			else {
				socialProfileDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profile details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfileDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfileDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfileDetail socialProfileDetail) {
		EntityCacheUtil.removeResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailImpl.class, socialProfileDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfileDetail);
	}

	@Override
	public void clearCache(List<SocialProfileDetail> socialProfileDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfileDetail socialProfileDetail : socialProfileDetails) {
			EntityCacheUtil.removeResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileDetailImpl.class,
				socialProfileDetail.getPrimaryKey());

			clearUniqueFindersCache(socialProfileDetail);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialProfileDetail socialProfileDetail) {
		if (socialProfileDetail.isNew()) {
			Object[] args = new Object[] {
					socialProfileDetail.getUuid(),
					socialProfileDetail.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				socialProfileDetail);

			args = new Object[] {
					socialProfileDetail.getUserJobId(),
					socialProfileDetail.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
				args, socialProfileDetail);

			args = new Object[] {
					socialProfileDetail.getCompanyName(),
					socialProfileDetail.getUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
				args, socialProfileDetail);
		}
		else {
			SocialProfileDetailModelImpl socialProfileDetailModelImpl = (SocialProfileDetailModelImpl)socialProfileDetail;

			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetail.getUuid(),
						socialProfileDetail.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					socialProfileDetail);
			}

			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetail.getUserJobId(),
						socialProfileDetail.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
					args, socialProfileDetail);
			}

			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetail.getCompanyName(),
						socialProfileDetail.getUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
					args, socialProfileDetail);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SocialProfileDetail socialProfileDetail) {
		SocialProfileDetailModelImpl socialProfileDetailModelImpl = (SocialProfileDetailModelImpl)socialProfileDetail;

		Object[] args = new Object[] {
				socialProfileDetail.getUuid(), socialProfileDetail.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((socialProfileDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileDetailModelImpl.getOriginalUuid(),
					socialProfileDetailModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				socialProfileDetail.getUserJobId(),
				socialProfileDetail.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
			args);

		if ((socialProfileDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileDetailModelImpl.getOriginalUserJobId(),
					socialProfileDetailModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDUSERJOBID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDUSERJOBID,
				args);
		}

		args = new Object[] {
				socialProfileDetail.getCompanyName(),
				socialProfileDetail.getUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
			args);

		if ((socialProfileDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileDetailModelImpl.getOriginalCompanyName(),
					socialProfileDetailModelImpl.getOriginalUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCOMPANYNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCOMPANYNAME,
				args);
		}
	}

	/**
	 * Creates a new social profile detail with the primary key. Does not add the social profile detail to the database.
	 *
	 * @param socialProfileDetailId the primary key for the new social profile detail
	 * @return the new social profile detail
	 */
	@Override
	public SocialProfileDetail create(long socialProfileDetailId) {
		SocialProfileDetail socialProfileDetail = new SocialProfileDetailImpl();

		socialProfileDetail.setNew(true);
		socialProfileDetail.setPrimaryKey(socialProfileDetailId);

		String uuid = PortalUUIDUtil.generate();

		socialProfileDetail.setUuid(uuid);

		return socialProfileDetail;
	}

	/**
	 * Removes the social profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialProfileDetailId the primary key of the social profile detail
	 * @return the social profile detail that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail remove(long socialProfileDetailId)
		throws NoSuchSocialProfileDetailException, SystemException {
		return remove((Serializable)socialProfileDetailId);
	}

	/**
	 * Removes the social profile detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile detail
	 * @return the social profile detail that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail remove(Serializable primaryKey)
		throws NoSuchSocialProfileDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfileDetail socialProfileDetail = (SocialProfileDetail)session.get(SocialProfileDetailImpl.class,
					primaryKey);

			if (socialProfileDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfileDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfileDetail);
		}
		catch (NoSuchSocialProfileDetailException nsee) {
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
	protected SocialProfileDetail removeImpl(
		SocialProfileDetail socialProfileDetail) throws SystemException {
		socialProfileDetail = toUnwrappedModel(socialProfileDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfileDetail)) {
				socialProfileDetail = (SocialProfileDetail)session.get(SocialProfileDetailImpl.class,
						socialProfileDetail.getPrimaryKeyObj());
			}

			if (socialProfileDetail != null) {
				session.delete(socialProfileDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfileDetail != null) {
			clearCache(socialProfileDetail);
		}

		return socialProfileDetail;
	}

	@Override
	public SocialProfileDetail updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail socialProfileDetail)
		throws SystemException {
		socialProfileDetail = toUnwrappedModel(socialProfileDetail);

		boolean isNew = socialProfileDetail.isNew();

		SocialProfileDetailModelImpl socialProfileDetailModelImpl = (SocialProfileDetailModelImpl)socialProfileDetail;

		if (Validator.isNull(socialProfileDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			socialProfileDetail.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (socialProfileDetail.isNew()) {
				session.save(socialProfileDetail);

				socialProfileDetail.setNew(false);
			}
			else {
				session.merge(socialProfileDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfileDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetailModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { socialProfileDetailModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetailModelImpl.getOriginalUuid(),
						socialProfileDetailModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						socialProfileDetailModelImpl.getUuid(),
						socialProfileDetailModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((socialProfileDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileDetailModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { socialProfileDetailModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileDetailImpl.class, socialProfileDetail.getPrimaryKey(),
			socialProfileDetail);

		clearUniqueFindersCache(socialProfileDetail);
		cacheUniqueFindersCache(socialProfileDetail);

		return socialProfileDetail;
	}

	protected SocialProfileDetail toUnwrappedModel(
		SocialProfileDetail socialProfileDetail) {
		if (socialProfileDetail instanceof SocialProfileDetailImpl) {
			return socialProfileDetail;
		}

		SocialProfileDetailImpl socialProfileDetailImpl = new SocialProfileDetailImpl();

		socialProfileDetailImpl.setNew(socialProfileDetail.isNew());
		socialProfileDetailImpl.setPrimaryKey(socialProfileDetail.getPrimaryKey());

		socialProfileDetailImpl.setUuid(socialProfileDetail.getUuid());
		socialProfileDetailImpl.setSocialProfileDetailId(socialProfileDetail.getSocialProfileDetailId());
		socialProfileDetailImpl.setGroupId(socialProfileDetail.getGroupId());
		socialProfileDetailImpl.setCompanyId(socialProfileDetail.getCompanyId());
		socialProfileDetailImpl.setUserId(socialProfileDetail.getUserId());
		socialProfileDetailImpl.setUserName(socialProfileDetail.getUserName());
		socialProfileDetailImpl.setCreateDate(socialProfileDetail.getCreateDate());
		socialProfileDetailImpl.setModifiedDate(socialProfileDetail.getModifiedDate());
		socialProfileDetailImpl.setUserJobId(socialProfileDetail.getUserJobId());
		socialProfileDetailImpl.setCompanyName(socialProfileDetail.getCompanyName());

		return socialProfileDetailImpl;
	}

	/**
	 * Returns the social profile detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile detail
	 * @return the social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfileDetailException, SystemException {
		SocialProfileDetail socialProfileDetail = fetchByPrimaryKey(primaryKey);

		if (socialProfileDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfileDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfileDetail;
	}

	/**
	 * Returns the social profile detail with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException} if it could not be found.
	 *
	 * @param socialProfileDetailId the primary key of the social profile detail
	 * @return the social profile detail
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileDetailException if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail findByPrimaryKey(long socialProfileDetailId)
		throws NoSuchSocialProfileDetailException, SystemException {
		return findByPrimaryKey((Serializable)socialProfileDetailId);
	}

	/**
	 * Returns the social profile detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile detail
	 * @return the social profile detail, or <code>null</code> if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfileDetail socialProfileDetail = (SocialProfileDetail)EntityCacheUtil.getResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileDetailImpl.class, primaryKey);

		if (socialProfileDetail == _nullSocialProfileDetail) {
			return null;
		}

		if (socialProfileDetail == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfileDetail = (SocialProfileDetail)session.get(SocialProfileDetailImpl.class,
						primaryKey);

				if (socialProfileDetail != null) {
					cacheResult(socialProfileDetail);
				}
				else {
					EntityCacheUtil.putResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileDetailImpl.class, primaryKey,
						_nullSocialProfileDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfileDetailModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfileDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfileDetail;
	}

	/**
	 * Returns the social profile detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialProfileDetailId the primary key of the social profile detail
	 * @return the social profile detail, or <code>null</code> if a social profile detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileDetail fetchByPrimaryKey(long socialProfileDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)socialProfileDetailId);
	}

	/**
	 * Returns all the social profile details.
	 *
	 * @return the social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @return the range of social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile details
	 * @param end the upper bound of the range of social profile details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profile details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileDetail> findAll(int start, int end,
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

		List<SocialProfileDetail> list = (List<SocialProfileDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILEDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILEDETAIL;

				if (pagination) {
					sql = sql.concat(SocialProfileDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileDetail>(list);
				}
				else {
					list = (List<SocialProfileDetail>)QueryUtil.list(q,
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
	 * Removes all the social profile details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfileDetail socialProfileDetail : findAll()) {
			remove(socialProfileDetail);
		}
	}

	/**
	 * Returns the number of social profile details.
	 *
	 * @return the number of social profile details
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILEDETAIL);

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
	 * Initializes the social profile detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfileDetail>> listenersList = new ArrayList<ModelListener<SocialProfileDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfileDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfileDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILEDETAIL = "SELECT socialProfileDetail FROM SocialProfileDetail socialProfileDetail";
	private static final String _SQL_SELECT_SOCIALPROFILEDETAIL_WHERE = "SELECT socialProfileDetail FROM SocialProfileDetail socialProfileDetail WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILEDETAIL = "SELECT COUNT(socialProfileDetail) FROM SocialProfileDetail socialProfileDetail";
	private static final String _SQL_COUNT_SOCIALPROFILEDETAIL_WHERE = "SELECT COUNT(socialProfileDetail) FROM SocialProfileDetail socialProfileDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfileDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfileDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfileDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfileDetailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "socialProfileDetailId"
			});
	private static SocialProfileDetail _nullSocialProfileDetail = new SocialProfileDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfileDetail> toCacheModel() {
				return _nullSocialProfileDetailCacheModel;
			}
		};

	private static CacheModel<SocialProfileDetail> _nullSocialProfileDetailCacheModel =
		new CacheModel<SocialProfileDetail>() {
			@Override
			public SocialProfileDetail toEntityModel() {
				return _nullSocialProfileDetail;
			}
		};
}