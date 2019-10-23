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

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the social profile view audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileViewAuditPersistence
 * @see SocialProfileViewAuditUtil
 * @generated
 */
public class SocialProfileViewAuditPersistenceImpl extends BasePersistenceImpl<SocialProfileViewAudit>
	implements SocialProfileViewAuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfileViewAuditUtil} to access the social profile view audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfileViewAuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SocialProfileViewAuditModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the social profile view audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile view audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profile view audits
	 * @param end the upper bound of the range of social profile view audits (not inclusive)
	 * @return the range of matching social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile view audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social profile view audits
	 * @param end the upper bound of the range of social profile view audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findByUuid(String uuid, int start,
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

		List<SocialProfileViewAudit> list = (List<SocialProfileViewAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileViewAudit socialProfileViewAudit : list) {
				if (!Validator.equals(uuid, socialProfileViewAudit.getUuid())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEVIEWAUDIT_WHERE);

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
				query.append(SocialProfileViewAuditModelImpl.ORDER_BY_JPQL);
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
					list = (List<SocialProfileViewAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileViewAudit>(list);
				}
				else {
					list = (List<SocialProfileViewAudit>)QueryUtil.list(q,
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
	 * Returns the first social profile view audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = fetchByUuid_First(uuid,
				orderByComparator);

		if (socialProfileViewAudit != null) {
			return socialProfileViewAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileViewAuditException(msg.toString());
	}

	/**
	 * Returns the first social profile view audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileViewAudit> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile view audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = fetchByUuid_Last(uuid,
				orderByComparator);

		if (socialProfileViewAudit != null) {
			return socialProfileViewAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileViewAuditException(msg.toString());
	}

	/**
	 * Returns the last social profile view audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialProfileViewAudit> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile view audits before and after the current social profile view audit in the ordered set where uuid = &#63;.
	 *
	 * @param socialProfileViewAuditId the primary key of the current social profile view audit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit[] findByUuid_PrevAndNext(
		long socialProfileViewAuditId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = findByPrimaryKey(socialProfileViewAuditId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileViewAudit[] array = new SocialProfileViewAuditImpl[3];

			array[0] = getByUuid_PrevAndNext(session, socialProfileViewAudit,
					uuid, orderByComparator, true);

			array[1] = socialProfileViewAudit;

			array[2] = getByUuid_PrevAndNext(session, socialProfileViewAudit,
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

	protected SocialProfileViewAudit getByUuid_PrevAndNext(Session session,
		SocialProfileViewAudit socialProfileViewAudit, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEVIEWAUDIT_WHERE);

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
			query.append(SocialProfileViewAuditModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileViewAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileViewAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile view audits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SocialProfileViewAudit socialProfileViewAudit : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfileViewAudit);
		}
	}

	/**
	 * Returns the number of social profile view audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social profile view audits
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

			query.append(_SQL_COUNT_SOCIALPROFILEVIEWAUDIT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "socialProfileViewAudit.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "socialProfileViewAudit.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(socialProfileViewAudit.uuid IS NULL OR socialProfileViewAudit.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID =
		new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLoggedInUserIdAndProfileUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SocialProfileViewAuditModelImpl.LOGGEDINUSERID_COLUMN_BITMASK |
			SocialProfileViewAuditModelImpl.PROFILEUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID =
		new FinderPath(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLoggedInUserIdAndProfileUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	 *
	 * @param loggedInUserId the logged in user ID
	 * @param profileUserId the profile user ID
	 * @return the matching social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit findByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = fetchByLoggedInUserIdAndProfileUserId(loggedInUserId,
				profileUserId);

		if (socialProfileViewAudit == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("loggedInUserId=");
			msg.append(loggedInUserId);

			msg.append(", profileUserId=");
			msg.append(profileUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileViewAuditException(msg.toString());
		}

		return socialProfileViewAudit;
	}

	/**
	 * Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param loggedInUserId the logged in user ID
	 * @param profileUserId the profile user ID
	 * @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId) throws SystemException {
		return fetchByLoggedInUserIdAndProfileUserId(loggedInUserId,
			profileUserId, true);
	}

	/**
	 * Returns the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param loggedInUserId the logged in user ID
	 * @param profileUserId the profile user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile view audit, or <code>null</code> if a matching social profile view audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { loggedInUserId, profileUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
					finderArgs, this);
		}

		if (result instanceof SocialProfileViewAudit) {
			SocialProfileViewAudit socialProfileViewAudit = (SocialProfileViewAudit)result;

			if ((loggedInUserId != socialProfileViewAudit.getLoggedInUserId()) ||
					(profileUserId != socialProfileViewAudit.getProfileUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SOCIALPROFILEVIEWAUDIT_WHERE);

			query.append(_FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_LOGGEDINUSERID_2);

			query.append(_FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_PROFILEUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loggedInUserId);

				qPos.add(profileUserId);

				List<SocialProfileViewAudit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
						finderArgs, list);
				}
				else {
					SocialProfileViewAudit socialProfileViewAudit = list.get(0);

					result = socialProfileViewAudit;

					cacheResult(socialProfileViewAudit);

					if ((socialProfileViewAudit.getLoggedInUserId() != loggedInUserId) ||
							(socialProfileViewAudit.getProfileUserId() != profileUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
							finderArgs, socialProfileViewAudit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
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
			return (SocialProfileViewAudit)result;
		}
	}

	/**
	 * Removes the social profile view audit where loggedInUserId = &#63; and profileUserId = &#63; from the database.
	 *
	 * @param loggedInUserId the logged in user ID
	 * @param profileUserId the profile user ID
	 * @return the social profile view audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit removeByLoggedInUserIdAndProfileUserId(
		long loggedInUserId, long profileUserId)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = findByLoggedInUserIdAndProfileUserId(loggedInUserId,
				profileUserId);

		return remove(socialProfileViewAudit);
	}

	/**
	 * Returns the number of social profile view audits where loggedInUserId = &#63; and profileUserId = &#63;.
	 *
	 * @param loggedInUserId the logged in user ID
	 * @param profileUserId the profile user ID
	 * @return the number of matching social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLoggedInUserIdAndProfileUserId(long loggedInUserId,
		long profileUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID;

		Object[] finderArgs = new Object[] { loggedInUserId, profileUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILEVIEWAUDIT_WHERE);

			query.append(_FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_LOGGEDINUSERID_2);

			query.append(_FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_PROFILEUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(loggedInUserId);

				qPos.add(profileUserId);

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

	private static final String _FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_LOGGEDINUSERID_2 =
		"socialProfileViewAudit.loggedInUserId = ? AND ";
	private static final String _FINDER_COLUMN_LOGGEDINUSERIDANDPROFILEUSERID_PROFILEUSERID_2 =
		"socialProfileViewAudit.profileUserId = ?";

	public SocialProfileViewAuditPersistenceImpl() {
		setModelClass(SocialProfileViewAudit.class);
	}

	/**
	 * Caches the social profile view audit in the entity cache if it is enabled.
	 *
	 * @param socialProfileViewAudit the social profile view audit
	 */
	@Override
	public void cacheResult(SocialProfileViewAudit socialProfileViewAudit) {
		EntityCacheUtil.putResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			socialProfileViewAudit.getPrimaryKey(), socialProfileViewAudit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
			new Object[] {
				socialProfileViewAudit.getLoggedInUserId(),
				socialProfileViewAudit.getProfileUserId()
			}, socialProfileViewAudit);

		socialProfileViewAudit.resetOriginalValues();
	}

	/**
	 * Caches the social profile view audits in the entity cache if it is enabled.
	 *
	 * @param socialProfileViewAudits the social profile view audits
	 */
	@Override
	public void cacheResult(
		List<SocialProfileViewAudit> socialProfileViewAudits) {
		for (SocialProfileViewAudit socialProfileViewAudit : socialProfileViewAudits) {
			if (EntityCacheUtil.getResult(
						SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileViewAuditImpl.class,
						socialProfileViewAudit.getPrimaryKey()) == null) {
				cacheResult(socialProfileViewAudit);
			}
			else {
				socialProfileViewAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profile view audits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfileViewAuditImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfileViewAuditImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile view audit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfileViewAudit socialProfileViewAudit) {
		EntityCacheUtil.removeResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			socialProfileViewAudit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfileViewAudit);
	}

	@Override
	public void clearCache(List<SocialProfileViewAudit> socialProfileViewAudits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfileViewAudit socialProfileViewAudit : socialProfileViewAudits) {
			EntityCacheUtil.removeResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileViewAuditImpl.class,
				socialProfileViewAudit.getPrimaryKey());

			clearUniqueFindersCache(socialProfileViewAudit);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialProfileViewAudit socialProfileViewAudit) {
		if (socialProfileViewAudit.isNew()) {
			Object[] args = new Object[] {
					socialProfileViewAudit.getLoggedInUserId(),
					socialProfileViewAudit.getProfileUserId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
				args, socialProfileViewAudit);
		}
		else {
			SocialProfileViewAuditModelImpl socialProfileViewAuditModelImpl = (SocialProfileViewAuditModelImpl)socialProfileViewAudit;

			if ((socialProfileViewAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileViewAudit.getLoggedInUserId(),
						socialProfileViewAudit.getProfileUserId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
					args, socialProfileViewAudit);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SocialProfileViewAudit socialProfileViewAudit) {
		SocialProfileViewAuditModelImpl socialProfileViewAuditModelImpl = (SocialProfileViewAuditModelImpl)socialProfileViewAudit;

		Object[] args = new Object[] {
				socialProfileViewAudit.getLoggedInUserId(),
				socialProfileViewAudit.getProfileUserId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
			args);

		if ((socialProfileViewAuditModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileViewAuditModelImpl.getOriginalLoggedInUserId(),
					socialProfileViewAuditModelImpl.getOriginalProfileUserId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOGGEDINUSERIDANDPROFILEUSERID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGGEDINUSERIDANDPROFILEUSERID,
				args);
		}
	}

	/**
	 * Creates a new social profile view audit with the primary key. Does not add the social profile view audit to the database.
	 *
	 * @param socialProfileViewAuditId the primary key for the new social profile view audit
	 * @return the new social profile view audit
	 */
	@Override
	public SocialProfileViewAudit create(long socialProfileViewAuditId) {
		SocialProfileViewAudit socialProfileViewAudit = new SocialProfileViewAuditImpl();

		socialProfileViewAudit.setNew(true);
		socialProfileViewAudit.setPrimaryKey(socialProfileViewAuditId);

		String uuid = PortalUUIDUtil.generate();

		socialProfileViewAudit.setUuid(uuid);

		return socialProfileViewAudit;
	}

	/**
	 * Removes the social profile view audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialProfileViewAuditId the primary key of the social profile view audit
	 * @return the social profile view audit that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit remove(long socialProfileViewAuditId)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		return remove((Serializable)socialProfileViewAuditId);
	}

	/**
	 * Removes the social profile view audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile view audit
	 * @return the social profile view audit that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit remove(Serializable primaryKey)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfileViewAudit socialProfileViewAudit = (SocialProfileViewAudit)session.get(SocialProfileViewAuditImpl.class,
					primaryKey);

			if (socialProfileViewAudit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfileViewAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfileViewAudit);
		}
		catch (NoSuchSocialProfileViewAuditException nsee) {
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
	protected SocialProfileViewAudit removeImpl(
		SocialProfileViewAudit socialProfileViewAudit)
		throws SystemException {
		socialProfileViewAudit = toUnwrappedModel(socialProfileViewAudit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfileViewAudit)) {
				socialProfileViewAudit = (SocialProfileViewAudit)session.get(SocialProfileViewAuditImpl.class,
						socialProfileViewAudit.getPrimaryKeyObj());
			}

			if (socialProfileViewAudit != null) {
				session.delete(socialProfileViewAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfileViewAudit != null) {
			clearCache(socialProfileViewAudit);
		}

		return socialProfileViewAudit;
	}

	@Override
	public SocialProfileViewAudit updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit socialProfileViewAudit)
		throws SystemException {
		socialProfileViewAudit = toUnwrappedModel(socialProfileViewAudit);

		boolean isNew = socialProfileViewAudit.isNew();

		SocialProfileViewAuditModelImpl socialProfileViewAuditModelImpl = (SocialProfileViewAuditModelImpl)socialProfileViewAudit;

		if (Validator.isNull(socialProfileViewAudit.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			socialProfileViewAudit.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (socialProfileViewAudit.isNew()) {
				session.save(socialProfileViewAudit);

				socialProfileViewAudit.setNew(false);
			}
			else {
				session.merge(socialProfileViewAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfileViewAuditModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((socialProfileViewAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileViewAuditModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { socialProfileViewAuditModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileViewAuditImpl.class,
			socialProfileViewAudit.getPrimaryKey(), socialProfileViewAudit);

		clearUniqueFindersCache(socialProfileViewAudit);
		cacheUniqueFindersCache(socialProfileViewAudit);

		return socialProfileViewAudit;
	}

	protected SocialProfileViewAudit toUnwrappedModel(
		SocialProfileViewAudit socialProfileViewAudit) {
		if (socialProfileViewAudit instanceof SocialProfileViewAuditImpl) {
			return socialProfileViewAudit;
		}

		SocialProfileViewAuditImpl socialProfileViewAuditImpl = new SocialProfileViewAuditImpl();

		socialProfileViewAuditImpl.setNew(socialProfileViewAudit.isNew());
		socialProfileViewAuditImpl.setPrimaryKey(socialProfileViewAudit.getPrimaryKey());

		socialProfileViewAuditImpl.setUuid(socialProfileViewAudit.getUuid());
		socialProfileViewAuditImpl.setSocialProfileViewAuditId(socialProfileViewAudit.getSocialProfileViewAuditId());
		socialProfileViewAuditImpl.setLoggedInUserId(socialProfileViewAudit.getLoggedInUserId());
		socialProfileViewAuditImpl.setProfileUserId(socialProfileViewAudit.getProfileUserId());
		socialProfileViewAuditImpl.setLastViewDate(socialProfileViewAudit.getLastViewDate());

		return socialProfileViewAuditImpl;
	}

	/**
	 * Returns the social profile view audit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile view audit
	 * @return the social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		SocialProfileViewAudit socialProfileViewAudit = fetchByPrimaryKey(primaryKey);

		if (socialProfileViewAudit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfileViewAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfileViewAudit;
	}

	/**
	 * Returns the social profile view audit with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException} if it could not be found.
	 *
	 * @param socialProfileViewAuditId the primary key of the social profile view audit
	 * @return the social profile view audit
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileViewAuditException if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit findByPrimaryKey(
		long socialProfileViewAuditId)
		throws NoSuchSocialProfileViewAuditException, SystemException {
		return findByPrimaryKey((Serializable)socialProfileViewAuditId);
	}

	/**
	 * Returns the social profile view audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile view audit
	 * @return the social profile view audit, or <code>null</code> if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfileViewAudit socialProfileViewAudit = (SocialProfileViewAudit)EntityCacheUtil.getResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileViewAuditImpl.class, primaryKey);

		if (socialProfileViewAudit == _nullSocialProfileViewAudit) {
			return null;
		}

		if (socialProfileViewAudit == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfileViewAudit = (SocialProfileViewAudit)session.get(SocialProfileViewAuditImpl.class,
						primaryKey);

				if (socialProfileViewAudit != null) {
					cacheResult(socialProfileViewAudit);
				}
				else {
					EntityCacheUtil.putResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileViewAuditImpl.class, primaryKey,
						_nullSocialProfileViewAudit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfileViewAuditModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfileViewAuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfileViewAudit;
	}

	/**
	 * Returns the social profile view audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialProfileViewAuditId the primary key of the social profile view audit
	 * @return the social profile view audit, or <code>null</code> if a social profile view audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileViewAudit fetchByPrimaryKey(
		long socialProfileViewAuditId) throws SystemException {
		return fetchByPrimaryKey((Serializable)socialProfileViewAuditId);
	}

	/**
	 * Returns all the social profile view audits.
	 *
	 * @return the social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile view audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile view audits
	 * @param end the upper bound of the range of social profile view audits (not inclusive)
	 * @return the range of social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile view audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileViewAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile view audits
	 * @param end the upper bound of the range of social profile view audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profile view audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileViewAudit> findAll(int start, int end,
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

		List<SocialProfileViewAudit> list = (List<SocialProfileViewAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILEVIEWAUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILEVIEWAUDIT;

				if (pagination) {
					sql = sql.concat(SocialProfileViewAuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfileViewAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileViewAudit>(list);
				}
				else {
					list = (List<SocialProfileViewAudit>)QueryUtil.list(q,
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
	 * Removes all the social profile view audits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfileViewAudit socialProfileViewAudit : findAll()) {
			remove(socialProfileViewAudit);
		}
	}

	/**
	 * Returns the number of social profile view audits.
	 *
	 * @return the number of social profile view audits
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILEVIEWAUDIT);

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
	 * Initializes the social profile view audit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfileViewAudit>> listenersList = new ArrayList<ModelListener<SocialProfileViewAudit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfileViewAudit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfileViewAuditImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILEVIEWAUDIT = "SELECT socialProfileViewAudit FROM SocialProfileViewAudit socialProfileViewAudit";
	private static final String _SQL_SELECT_SOCIALPROFILEVIEWAUDIT_WHERE = "SELECT socialProfileViewAudit FROM SocialProfileViewAudit socialProfileViewAudit WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILEVIEWAUDIT = "SELECT COUNT(socialProfileViewAudit) FROM SocialProfileViewAudit socialProfileViewAudit";
	private static final String _SQL_COUNT_SOCIALPROFILEVIEWAUDIT_WHERE = "SELECT COUNT(socialProfileViewAudit) FROM SocialProfileViewAudit socialProfileViewAudit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfileViewAudit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfileViewAudit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfileViewAudit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfileViewAuditPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "socialProfileViewAuditId"
			});
	private static SocialProfileViewAudit _nullSocialProfileViewAudit = new SocialProfileViewAuditImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfileViewAudit> toCacheModel() {
				return _nullSocialProfileViewAuditCacheModel;
			}
		};

	private static CacheModel<SocialProfileViewAudit> _nullSocialProfileViewAuditCacheModel =
		new CacheModel<SocialProfileViewAudit>() {
			@Override
			public SocialProfileViewAudit toEntityModel() {
				return _nullSocialProfileViewAudit;
			}
		};
}