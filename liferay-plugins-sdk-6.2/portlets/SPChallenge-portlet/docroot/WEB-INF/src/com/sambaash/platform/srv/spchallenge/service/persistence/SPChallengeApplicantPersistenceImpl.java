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

package com.sambaash.platform.srv.spchallenge.service.persistence;

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

import com.sambaash.platform.srv.spchallenge.NoSuchApplicantException;
import com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantImpl;
import com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p challenge applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPChallengeApplicantPersistence
 * @see SPChallengeApplicantUtil
 * @generated
 */
public class SPChallengeApplicantPersistenceImpl extends BasePersistenceImpl<SPChallengeApplicant>
	implements SPChallengeApplicantPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPChallengeApplicantUtil} to access the s p challenge applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPChallengeApplicantImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPChallengeApplicantModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p challenge applicants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenge applicants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @return the range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenge applicants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid(String uuid, int start,
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

		List<SPChallengeApplicant> list = (List<SPChallengeApplicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallengeApplicant spChallengeApplicant : list) {
				if (!Validator.equals(uuid, spChallengeApplicant.getUuid())) {
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

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

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
				query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallengeApplicant>(list);
				}
				else {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
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
	 * Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByUuid_First(uuid,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first s p challenge applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPChallengeApplicant> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByUuid_Last(uuid,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPChallengeApplicant> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63;.
	 *
	 * @param spChallengeApplicantId the primary key of the current s p challenge applicant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant[] findByUuid_PrevAndNext(
		long spChallengeApplicantId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByPrimaryKey(spChallengeApplicantId);

		Session session = null;

		try {
			session = openSession();

			SPChallengeApplicant[] array = new SPChallengeApplicantImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spChallengeApplicant,
					uuid, orderByComparator, true);

			array[1] = spChallengeApplicant;

			array[2] = getByUuid_PrevAndNext(session, spChallengeApplicant,
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

	protected SPChallengeApplicant getByUuid_PrevAndNext(Session session,
		SPChallengeApplicant spChallengeApplicant, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

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
			query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spChallengeApplicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallengeApplicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenge applicants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPChallengeApplicant spChallengeApplicant : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spChallengeApplicant);
		}
	}

	/**
	 * Returns the number of s p challenge applicants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p challenge applicants
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

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spChallengeApplicant.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spChallengeApplicant.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spChallengeApplicant.uuid IS NULL OR spChallengeApplicant.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPChallengeApplicantModelImpl.UUID_COLUMN_BITMASK |
			SPChallengeApplicantModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByUUID_G(String uuid, long groupId)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByUUID_G(uuid, groupId);

		if (spChallengeApplicant == null) {
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

			throw new NoSuchApplicantException(msg.toString());
		}

		return spChallengeApplicant;
	}

	/**
	 * Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p challenge applicant where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPChallengeApplicant) {
			SPChallengeApplicant spChallengeApplicant = (SPChallengeApplicant)result;

			if (!Validator.equals(uuid, spChallengeApplicant.getUuid()) ||
					(groupId != spChallengeApplicant.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

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

				List<SPChallengeApplicant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPChallengeApplicant spChallengeApplicant = list.get(0);

					result = spChallengeApplicant;

					cacheResult(spChallengeApplicant);

					if ((spChallengeApplicant.getUuid() == null) ||
							!spChallengeApplicant.getUuid().equals(uuid) ||
							(spChallengeApplicant.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spChallengeApplicant);
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
			return (SPChallengeApplicant)result;
		}
	}

	/**
	 * Removes the s p challenge applicant where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p challenge applicant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant removeByUUID_G(String uuid, long groupId)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByUUID_G(uuid, groupId);

		return remove(spChallengeApplicant);
	}

	/**
	 * Returns the number of s p challenge applicants where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p challenge applicants
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

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spChallengeApplicant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spChallengeApplicant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spChallengeApplicant.uuid IS NULL OR spChallengeApplicant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spChallengeApplicant.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPChallengeApplicantModelImpl.UUID_COLUMN_BITMASK |
			SPChallengeApplicantModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @return the range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenge applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByUuid_C(String uuid, long companyId,
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

		List<SPChallengeApplicant> list = (List<SPChallengeApplicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallengeApplicant spChallengeApplicant : list) {
				if (!Validator.equals(uuid, spChallengeApplicant.getUuid()) ||
						(companyId != spChallengeApplicant.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

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
				query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallengeApplicant>(list);
				}
				else {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
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
	 * Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPChallengeApplicant> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPChallengeApplicant> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spChallengeApplicantId the primary key of the current s p challenge applicant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant[] findByUuid_C_PrevAndNext(
		long spChallengeApplicantId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByPrimaryKey(spChallengeApplicantId);

		Session session = null;

		try {
			session = openSession();

			SPChallengeApplicant[] array = new SPChallengeApplicantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spChallengeApplicant,
					uuid, companyId, orderByComparator, true);

			array[1] = spChallengeApplicant;

			array[2] = getByUuid_C_PrevAndNext(session, spChallengeApplicant,
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

	protected SPChallengeApplicant getByUuid_C_PrevAndNext(Session session,
		SPChallengeApplicant spChallengeApplicant, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

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
			query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spChallengeApplicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallengeApplicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenge applicants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPChallengeApplicant spChallengeApplicant : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spChallengeApplicant);
		}
	}

	/**
	 * Returns the number of s p challenge applicants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p challenge applicants
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

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spChallengeApplicant.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spChallengeApplicant.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spChallengeApplicant.uuid IS NULL OR spChallengeApplicant.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spChallengeApplicant.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTREFID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantRefId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREFID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApplicantRefId",
			new String[] { Long.class.getName() },
			SPChallengeApplicantModelImpl.APPLICANTREFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTREFID = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApplicantRefId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p challenge applicants where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @return the matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByApplicantRefId(long applicantRefId)
		throws SystemException {
		return findByApplicantRefId(applicantRefId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenge applicants where applicantRefId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @return the range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end) throws SystemException {
		return findByApplicantRefId(applicantRefId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenge applicants where applicantRefId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findByApplicantRefId(
		long applicantRefId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREFID;
			finderArgs = new Object[] { applicantRefId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTREFID;
			finderArgs = new Object[] {
					applicantRefId,
					
					start, end, orderByComparator
				};
		}

		List<SPChallengeApplicant> list = (List<SPChallengeApplicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallengeApplicant spChallengeApplicant : list) {
				if ((applicantRefId != spChallengeApplicant.getApplicantRefId())) {
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

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTREFID_APPLICANTREFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicantRefId);

				if (!pagination) {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallengeApplicant>(list);
				}
				else {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
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
	 * Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByApplicantRefId_First(
		long applicantRefId, OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByApplicantRefId_First(applicantRefId,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantRefId=");
		msg.append(applicantRefId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first s p challenge applicant in the ordered set where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByApplicantRefId_First(
		long applicantRefId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPChallengeApplicant> list = findByApplicantRefId(applicantRefId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByApplicantRefId_Last(long applicantRefId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByApplicantRefId_Last(applicantRefId,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantRefId=");
		msg.append(applicantRefId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByApplicantRefId_Last(
		long applicantRefId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByApplicantRefId(applicantRefId);

		if (count == 0) {
			return null;
		}

		List<SPChallengeApplicant> list = findByApplicantRefId(applicantRefId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where applicantRefId = &#63;.
	 *
	 * @param spChallengeApplicantId the primary key of the current s p challenge applicant
	 * @param applicantRefId the applicant ref ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant[] findByApplicantRefId_PrevAndNext(
		long spChallengeApplicantId, long applicantRefId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByPrimaryKey(spChallengeApplicantId);

		Session session = null;

		try {
			session = openSession();

			SPChallengeApplicant[] array = new SPChallengeApplicantImpl[3];

			array[0] = getByApplicantRefId_PrevAndNext(session,
					spChallengeApplicant, applicantRefId, orderByComparator,
					true);

			array[1] = spChallengeApplicant;

			array[2] = getByApplicantRefId_PrevAndNext(session,
					spChallengeApplicant, applicantRefId, orderByComparator,
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

	protected SPChallengeApplicant getByApplicantRefId_PrevAndNext(
		Session session, SPChallengeApplicant spChallengeApplicant,
		long applicantRefId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

		query.append(_FINDER_COLUMN_APPLICANTREFID_APPLICANTREFID_2);

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
			query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicantRefId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spChallengeApplicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallengeApplicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenge applicants where applicantRefId = &#63; from the database.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApplicantRefId(long applicantRefId)
		throws SystemException {
		for (SPChallengeApplicant spChallengeApplicant : findByApplicantRefId(
				applicantRefId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spChallengeApplicant);
		}
	}

	/**
	 * Returns the number of s p challenge applicants where applicantRefId = &#63;.
	 *
	 * @param applicantRefId the applicant ref ID
	 * @return the number of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApplicantRefId(long applicantRefId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICANTREFID;

		Object[] finderArgs = new Object[] { applicantRefId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_APPLICANTREFID_APPLICANTREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicantRefId);

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

	private static final String _FINDER_COLUMN_APPLICANTREFID_APPLICANTREFID_2 = "spChallengeApplicant.applicantRefId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCHALLENGEID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySPChallengeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCHALLENGEID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySPChallengeId",
			new String[] { Long.class.getName() },
			SPChallengeApplicantModelImpl.SPCHALLENGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPCHALLENGEID = new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySPChallengeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p challenge applicants where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @return the matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findBySPChallengeId(long spChallengeId)
		throws SystemException {
		return findBySPChallengeId(spChallengeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenge applicants where spChallengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @return the range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findBySPChallengeId(long spChallengeId,
		int start, int end) throws SystemException {
		return findBySPChallengeId(spChallengeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenge applicants where spChallengeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findBySPChallengeId(long spChallengeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCHALLENGEID;
			finderArgs = new Object[] { spChallengeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPCHALLENGEID;
			finderArgs = new Object[] {
					spChallengeId,
					
					start, end, orderByComparator
				};
		}

		List<SPChallengeApplicant> list = (List<SPChallengeApplicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPChallengeApplicant spChallengeApplicant : list) {
				if ((spChallengeId != spChallengeApplicant.getSpChallengeId())) {
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

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_SPCHALLENGEID_SPCHALLENGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spChallengeId);

				if (!pagination) {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallengeApplicant>(list);
				}
				else {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
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
	 * Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findBySPChallengeId_First(long spChallengeId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchBySPChallengeId_First(spChallengeId,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spChallengeId=");
		msg.append(spChallengeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the first s p challenge applicant in the ordered set where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchBySPChallengeId_First(long spChallengeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPChallengeApplicant> list = findBySPChallengeId(spChallengeId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findBySPChallengeId_Last(long spChallengeId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchBySPChallengeId_Last(spChallengeId,
				orderByComparator);

		if (spChallengeApplicant != null) {
			return spChallengeApplicant;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spChallengeId=");
		msg.append(spChallengeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantException(msg.toString());
	}

	/**
	 * Returns the last s p challenge applicant in the ordered set where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchBySPChallengeId_Last(long spChallengeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySPChallengeId(spChallengeId);

		if (count == 0) {
			return null;
		}

		List<SPChallengeApplicant> list = findBySPChallengeId(spChallengeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p challenge applicants before and after the current s p challenge applicant in the ordered set where spChallengeId = &#63;.
	 *
	 * @param spChallengeApplicantId the primary key of the current s p challenge applicant
	 * @param spChallengeId the sp challenge ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant[] findBySPChallengeId_PrevAndNext(
		long spChallengeApplicantId, long spChallengeId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByPrimaryKey(spChallengeApplicantId);

		Session session = null;

		try {
			session = openSession();

			SPChallengeApplicant[] array = new SPChallengeApplicantImpl[3];

			array[0] = getBySPChallengeId_PrevAndNext(session,
					spChallengeApplicant, spChallengeId, orderByComparator, true);

			array[1] = spChallengeApplicant;

			array[2] = getBySPChallengeId_PrevAndNext(session,
					spChallengeApplicant, spChallengeId, orderByComparator,
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

	protected SPChallengeApplicant getBySPChallengeId_PrevAndNext(
		Session session, SPChallengeApplicant spChallengeApplicant,
		long spChallengeId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

		query.append(_FINDER_COLUMN_SPCHALLENGEID_SPCHALLENGEID_2);

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
			query.append(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spChallengeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spChallengeApplicant);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPChallengeApplicant> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p challenge applicants where spChallengeId = &#63; from the database.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySPChallengeId(long spChallengeId)
		throws SystemException {
		for (SPChallengeApplicant spChallengeApplicant : findBySPChallengeId(
				spChallengeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spChallengeApplicant);
		}
	}

	/**
	 * Returns the number of s p challenge applicants where spChallengeId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @return the number of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPChallengeId(long spChallengeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPCHALLENGEID;

		Object[] finderArgs = new Object[] { spChallengeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_SPCHALLENGEID_SPCHALLENGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spChallengeId);

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

	private static final String _FINDER_COLUMN_SPCHALLENGEID_SPCHALLENGEID_2 = "spChallengeApplicant.spChallengeId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED,
			SPChallengeApplicantImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByChallengeIdApplicantRefId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPChallengeApplicantModelImpl.SPCHALLENGEID_COLUMN_BITMASK |
			SPChallengeApplicantModelImpl.APPLICANTREFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID =
		new FinderPath(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChallengeIdApplicantRefId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param applicantRefId the applicant ref ID
	 * @return the matching s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByChallengeIdApplicantRefId(spChallengeId,
				applicantRefId);

		if (spChallengeApplicant == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spChallengeId=");
			msg.append(spChallengeId);

			msg.append(", applicantRefId=");
			msg.append(applicantRefId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchApplicantException(msg.toString());
		}

		return spChallengeApplicant;
	}

	/**
	 * Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param applicantRefId the applicant ref ID
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId) throws SystemException {
		return fetchByChallengeIdApplicantRefId(spChallengeId, applicantRefId,
			true);
	}

	/**
	 * Returns the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param applicantRefId the applicant ref ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p challenge applicant, or <code>null</code> if a matching s p challenge applicant could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spChallengeId, applicantRefId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
					finderArgs, this);
		}

		if (result instanceof SPChallengeApplicant) {
			SPChallengeApplicant spChallengeApplicant = (SPChallengeApplicant)result;

			if ((spChallengeId != spChallengeApplicant.getSpChallengeId()) ||
					(applicantRefId != spChallengeApplicant.getApplicantRefId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_SPCHALLENGEID_2);

			query.append(_FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_APPLICANTREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spChallengeId);

				qPos.add(applicantRefId);

				List<SPChallengeApplicant> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPChallengeApplicantPersistenceImpl.fetchByChallengeIdApplicantRefId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPChallengeApplicant spChallengeApplicant = list.get(0);

					result = spChallengeApplicant;

					cacheResult(spChallengeApplicant);

					if ((spChallengeApplicant.getSpChallengeId() != spChallengeId) ||
							(spChallengeApplicant.getApplicantRefId() != applicantRefId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
							finderArgs, spChallengeApplicant);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
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
			return (SPChallengeApplicant)result;
		}
	}

	/**
	 * Removes the s p challenge applicant where spChallengeId = &#63; and applicantRefId = &#63; from the database.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param applicantRefId the applicant ref ID
	 * @return the s p challenge applicant that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant removeByChallengeIdApplicantRefId(
		long spChallengeId, long applicantRefId)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = findByChallengeIdApplicantRefId(spChallengeId,
				applicantRefId);

		return remove(spChallengeApplicant);
	}

	/**
	 * Returns the number of s p challenge applicants where spChallengeId = &#63; and applicantRefId = &#63;.
	 *
	 * @param spChallengeId the sp challenge ID
	 * @param applicantRefId the applicant ref ID
	 * @return the number of matching s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByChallengeIdApplicantRefId(long spChallengeId,
		long applicantRefId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID;

		Object[] finderArgs = new Object[] { spChallengeId, applicantRefId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE);

			query.append(_FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_SPCHALLENGEID_2);

			query.append(_FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_APPLICANTREFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spChallengeId);

				qPos.add(applicantRefId);

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

	private static final String _FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_SPCHALLENGEID_2 =
		"spChallengeApplicant.spChallengeId = ? AND ";
	private static final String _FINDER_COLUMN_CHALLENGEIDAPPLICANTREFID_APPLICANTREFID_2 =
		"spChallengeApplicant.applicantRefId = ? AND spChallengeApplicant.active = 1 ";

	public SPChallengeApplicantPersistenceImpl() {
		setModelClass(SPChallengeApplicant.class);
	}

	/**
	 * Caches the s p challenge applicant in the entity cache if it is enabled.
	 *
	 * @param spChallengeApplicant the s p challenge applicant
	 */
	@Override
	public void cacheResult(SPChallengeApplicant spChallengeApplicant) {
		EntityCacheUtil.putResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			spChallengeApplicant.getPrimaryKey(), spChallengeApplicant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				spChallengeApplicant.getUuid(),
				spChallengeApplicant.getGroupId()
			}, spChallengeApplicant);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
			new Object[] {
				spChallengeApplicant.getSpChallengeId(),
				spChallengeApplicant.getApplicantRefId()
			}, spChallengeApplicant);

		spChallengeApplicant.resetOriginalValues();
	}

	/**
	 * Caches the s p challenge applicants in the entity cache if it is enabled.
	 *
	 * @param spChallengeApplicants the s p challenge applicants
	 */
	@Override
	public void cacheResult(List<SPChallengeApplicant> spChallengeApplicants) {
		for (SPChallengeApplicant spChallengeApplicant : spChallengeApplicants) {
			if (EntityCacheUtil.getResult(
						SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
						SPChallengeApplicantImpl.class,
						spChallengeApplicant.getPrimaryKey()) == null) {
				cacheResult(spChallengeApplicant);
			}
			else {
				spChallengeApplicant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p challenge applicants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPChallengeApplicantImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPChallengeApplicantImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p challenge applicant.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPChallengeApplicant spChallengeApplicant) {
		EntityCacheUtil.removeResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantImpl.class, spChallengeApplicant.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spChallengeApplicant);
	}

	@Override
	public void clearCache(List<SPChallengeApplicant> spChallengeApplicants) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPChallengeApplicant spChallengeApplicant : spChallengeApplicants) {
			EntityCacheUtil.removeResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
				SPChallengeApplicantImpl.class,
				spChallengeApplicant.getPrimaryKey());

			clearUniqueFindersCache(spChallengeApplicant);
		}
	}

	protected void cacheUniqueFindersCache(
		SPChallengeApplicant spChallengeApplicant) {
		if (spChallengeApplicant.isNew()) {
			Object[] args = new Object[] {
					spChallengeApplicant.getUuid(),
					spChallengeApplicant.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spChallengeApplicant);

			args = new Object[] {
					spChallengeApplicant.getSpChallengeId(),
					spChallengeApplicant.getApplicantRefId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
				args, spChallengeApplicant);
		}
		else {
			SPChallengeApplicantModelImpl spChallengeApplicantModelImpl = (SPChallengeApplicantModelImpl)spChallengeApplicant;

			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicant.getUuid(),
						spChallengeApplicant.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spChallengeApplicant);
			}

			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicant.getSpChallengeId(),
						spChallengeApplicant.getApplicantRefId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
					args, spChallengeApplicant);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SPChallengeApplicant spChallengeApplicant) {
		SPChallengeApplicantModelImpl spChallengeApplicantModelImpl = (SPChallengeApplicantModelImpl)spChallengeApplicant;

		Object[] args = new Object[] {
				spChallengeApplicant.getUuid(),
				spChallengeApplicant.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spChallengeApplicantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spChallengeApplicantModelImpl.getOriginalUuid(),
					spChallengeApplicantModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				spChallengeApplicant.getSpChallengeId(),
				spChallengeApplicant.getApplicantRefId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
			args);

		if ((spChallengeApplicantModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spChallengeApplicantModelImpl.getOriginalSpChallengeId(),
					spChallengeApplicantModelImpl.getOriginalApplicantRefId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHALLENGEIDAPPLICANTREFID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CHALLENGEIDAPPLICANTREFID,
				args);
		}
	}

	/**
	 * Creates a new s p challenge applicant with the primary key. Does not add the s p challenge applicant to the database.
	 *
	 * @param spChallengeApplicantId the primary key for the new s p challenge applicant
	 * @return the new s p challenge applicant
	 */
	@Override
	public SPChallengeApplicant create(long spChallengeApplicantId) {
		SPChallengeApplicant spChallengeApplicant = new SPChallengeApplicantImpl();

		spChallengeApplicant.setNew(true);
		spChallengeApplicant.setPrimaryKey(spChallengeApplicantId);

		String uuid = PortalUUIDUtil.generate();

		spChallengeApplicant.setUuid(uuid);

		return spChallengeApplicant;
	}

	/**
	 * Removes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spChallengeApplicantId the primary key of the s p challenge applicant
	 * @return the s p challenge applicant that was removed
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant remove(long spChallengeApplicantId)
		throws NoSuchApplicantException, SystemException {
		return remove((Serializable)spChallengeApplicantId);
	}

	/**
	 * Removes the s p challenge applicant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p challenge applicant
	 * @return the s p challenge applicant that was removed
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant remove(Serializable primaryKey)
		throws NoSuchApplicantException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPChallengeApplicant spChallengeApplicant = (SPChallengeApplicant)session.get(SPChallengeApplicantImpl.class,
					primaryKey);

			if (spChallengeApplicant == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spChallengeApplicant);
		}
		catch (NoSuchApplicantException nsee) {
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
	protected SPChallengeApplicant removeImpl(
		SPChallengeApplicant spChallengeApplicant) throws SystemException {
		spChallengeApplicant = toUnwrappedModel(spChallengeApplicant);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spChallengeApplicant)) {
				spChallengeApplicant = (SPChallengeApplicant)session.get(SPChallengeApplicantImpl.class,
						spChallengeApplicant.getPrimaryKeyObj());
			}

			if (spChallengeApplicant != null) {
				session.delete(spChallengeApplicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spChallengeApplicant != null) {
			clearCache(spChallengeApplicant);
		}

		return spChallengeApplicant;
	}

	@Override
	public SPChallengeApplicant updateImpl(
		com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant spChallengeApplicant)
		throws SystemException {
		spChallengeApplicant = toUnwrappedModel(spChallengeApplicant);

		boolean isNew = spChallengeApplicant.isNew();

		SPChallengeApplicantModelImpl spChallengeApplicantModelImpl = (SPChallengeApplicantModelImpl)spChallengeApplicant;

		if (Validator.isNull(spChallengeApplicant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spChallengeApplicant.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spChallengeApplicant.isNew()) {
				session.save(spChallengeApplicant);

				spChallengeApplicant.setNew(false);
			}
			else {
				session.merge(spChallengeApplicant);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPChallengeApplicantModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicantModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spChallengeApplicantModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicantModelImpl.getOriginalUuid(),
						spChallengeApplicantModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spChallengeApplicantModelImpl.getUuid(),
						spChallengeApplicantModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicantModelImpl.getOriginalApplicantRefId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICANTREFID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREFID,
					args);

				args = new Object[] {
						spChallengeApplicantModelImpl.getApplicantRefId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPLICANTREFID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICANTREFID,
					args);
			}

			if ((spChallengeApplicantModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCHALLENGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spChallengeApplicantModelImpl.getOriginalSpChallengeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCHALLENGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCHALLENGEID,
					args);

				args = new Object[] {
						spChallengeApplicantModelImpl.getSpChallengeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPCHALLENGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPCHALLENGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
			SPChallengeApplicantImpl.class,
			spChallengeApplicant.getPrimaryKey(), spChallengeApplicant);

		clearUniqueFindersCache(spChallengeApplicant);
		cacheUniqueFindersCache(spChallengeApplicant);

		return spChallengeApplicant;
	}

	protected SPChallengeApplicant toUnwrappedModel(
		SPChallengeApplicant spChallengeApplicant) {
		if (spChallengeApplicant instanceof SPChallengeApplicantImpl) {
			return spChallengeApplicant;
		}

		SPChallengeApplicantImpl spChallengeApplicantImpl = new SPChallengeApplicantImpl();

		spChallengeApplicantImpl.setNew(spChallengeApplicant.isNew());
		spChallengeApplicantImpl.setPrimaryKey(spChallengeApplicant.getPrimaryKey());

		spChallengeApplicantImpl.setUuid(spChallengeApplicant.getUuid());
		spChallengeApplicantImpl.setSpChallengeApplicantId(spChallengeApplicant.getSpChallengeApplicantId());
		spChallengeApplicantImpl.setGroupId(spChallengeApplicant.getGroupId());
		spChallengeApplicantImpl.setCompanyId(spChallengeApplicant.getCompanyId());
		spChallengeApplicantImpl.setUserId(spChallengeApplicant.getUserId());
		spChallengeApplicantImpl.setUserName(spChallengeApplicant.getUserName());
		spChallengeApplicantImpl.setCreateDate(spChallengeApplicant.getCreateDate());
		spChallengeApplicantImpl.setModifiedDate(spChallengeApplicant.getModifiedDate());
		spChallengeApplicantImpl.setApplicantRefId(spChallengeApplicant.getApplicantRefId());
		spChallengeApplicantImpl.setApplicantType(spChallengeApplicant.getApplicantType());
		spChallengeApplicantImpl.setSpChallengeId(spChallengeApplicant.getSpChallengeId());
		spChallengeApplicantImpl.setQ1(spChallengeApplicant.getQ1());
		spChallengeApplicantImpl.setQ2(spChallengeApplicant.getQ2());
		spChallengeApplicantImpl.setQ3(spChallengeApplicant.getQ3());
		spChallengeApplicantImpl.setQ4(spChallengeApplicant.getQ4());
		spChallengeApplicantImpl.setQ5(spChallengeApplicant.getQ5());
		spChallengeApplicantImpl.setQ6(spChallengeApplicant.getQ6());
		spChallengeApplicantImpl.setQ7(spChallengeApplicant.getQ7());
		spChallengeApplicantImpl.setQ8(spChallengeApplicant.getQ8());
		spChallengeApplicantImpl.setQ9(spChallengeApplicant.getQ9());
		spChallengeApplicantImpl.setQ10(spChallengeApplicant.getQ10());
		spChallengeApplicantImpl.setQ11(spChallengeApplicant.getQ11());
		spChallengeApplicantImpl.setQ12(spChallengeApplicant.getQ12());
		spChallengeApplicantImpl.setQ13(spChallengeApplicant.getQ13());
		spChallengeApplicantImpl.setQ14(spChallengeApplicant.getQ14());
		spChallengeApplicantImpl.setQ15(spChallengeApplicant.getQ15());
		spChallengeApplicantImpl.setQ16(spChallengeApplicant.getQ16());
		spChallengeApplicantImpl.setQ17(spChallengeApplicant.getQ17());
		spChallengeApplicantImpl.setQ18(spChallengeApplicant.getQ18());
		spChallengeApplicantImpl.setQ19(spChallengeApplicant.getQ19());
		spChallengeApplicantImpl.setQ20(spChallengeApplicant.getQ20());
		spChallengeApplicantImpl.setCustomStatus1(spChallengeApplicant.isCustomStatus1());
		spChallengeApplicantImpl.setCustomStatus2(spChallengeApplicant.isCustomStatus2());
		spChallengeApplicantImpl.setActive(spChallengeApplicant.isActive());
		spChallengeApplicantImpl.setApplicationStatus(spChallengeApplicant.getApplicationStatus());
		spChallengeApplicantImpl.setNotificationStatus(spChallengeApplicant.getNotificationStatus());

		return spChallengeApplicantImpl;
	}

	/**
	 * Returns the s p challenge applicant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p challenge applicant
	 * @return the s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicantException, SystemException {
		SPChallengeApplicant spChallengeApplicant = fetchByPrimaryKey(primaryKey);

		if (spChallengeApplicant == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spChallengeApplicant;
	}

	/**
	 * Returns the s p challenge applicant with the primary key or throws a {@link com.sambaash.platform.srv.spchallenge.NoSuchApplicantException} if it could not be found.
	 *
	 * @param spChallengeApplicantId the primary key of the s p challenge applicant
	 * @return the s p challenge applicant
	 * @throws com.sambaash.platform.srv.spchallenge.NoSuchApplicantException if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant findByPrimaryKey(long spChallengeApplicantId)
		throws NoSuchApplicantException, SystemException {
		return findByPrimaryKey((Serializable)spChallengeApplicantId);
	}

	/**
	 * Returns the s p challenge applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p challenge applicant
	 * @return the s p challenge applicant, or <code>null</code> if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPChallengeApplicant spChallengeApplicant = (SPChallengeApplicant)EntityCacheUtil.getResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
				SPChallengeApplicantImpl.class, primaryKey);

		if (spChallengeApplicant == _nullSPChallengeApplicant) {
			return null;
		}

		if (spChallengeApplicant == null) {
			Session session = null;

			try {
				session = openSession();

				spChallengeApplicant = (SPChallengeApplicant)session.get(SPChallengeApplicantImpl.class,
						primaryKey);

				if (spChallengeApplicant != null) {
					cacheResult(spChallengeApplicant);
				}
				else {
					EntityCacheUtil.putResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
						SPChallengeApplicantImpl.class, primaryKey,
						_nullSPChallengeApplicant);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPChallengeApplicantModelImpl.ENTITY_CACHE_ENABLED,
					SPChallengeApplicantImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spChallengeApplicant;
	}

	/**
	 * Returns the s p challenge applicant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spChallengeApplicantId the primary key of the s p challenge applicant
	 * @return the s p challenge applicant, or <code>null</code> if a s p challenge applicant with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPChallengeApplicant fetchByPrimaryKey(long spChallengeApplicantId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spChallengeApplicantId);
	}

	/**
	 * Returns all the s p challenge applicants.
	 *
	 * @return the s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p challenge applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @return the range of s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p challenge applicants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spchallenge.model.impl.SPChallengeApplicantModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p challenge applicants
	 * @param end the upper bound of the range of s p challenge applicants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p challenge applicants
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPChallengeApplicant> findAll(int start, int end,
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

		List<SPChallengeApplicant> list = (List<SPChallengeApplicant>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCHALLENGEAPPLICANT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCHALLENGEAPPLICANT;

				if (pagination) {
					sql = sql.concat(SPChallengeApplicantModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPChallengeApplicant>(list);
				}
				else {
					list = (List<SPChallengeApplicant>)QueryUtil.list(q,
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
	 * Removes all the s p challenge applicants from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPChallengeApplicant spChallengeApplicant : findAll()) {
			remove(spChallengeApplicant);
		}
	}

	/**
	 * Returns the number of s p challenge applicants.
	 *
	 * @return the number of s p challenge applicants
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

				Query q = session.createQuery(_SQL_COUNT_SPCHALLENGEAPPLICANT);

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
	 * Initializes the s p challenge applicant persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spchallenge.model.SPChallengeApplicant")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPChallengeApplicant>> listenersList = new ArrayList<ModelListener<SPChallengeApplicant>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPChallengeApplicant>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPChallengeApplicantImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCHALLENGEAPPLICANT = "SELECT spChallengeApplicant FROM SPChallengeApplicant spChallengeApplicant";
	private static final String _SQL_SELECT_SPCHALLENGEAPPLICANT_WHERE = "SELECT spChallengeApplicant FROM SPChallengeApplicant spChallengeApplicant WHERE ";
	private static final String _SQL_COUNT_SPCHALLENGEAPPLICANT = "SELECT COUNT(spChallengeApplicant) FROM SPChallengeApplicant spChallengeApplicant";
	private static final String _SQL_COUNT_SPCHALLENGEAPPLICANT_WHERE = "SELECT COUNT(spChallengeApplicant) FROM SPChallengeApplicant spChallengeApplicant WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spChallengeApplicant.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPChallengeApplicant exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPChallengeApplicant exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPChallengeApplicantPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "active"
			});
	private static SPChallengeApplicant _nullSPChallengeApplicant = new SPChallengeApplicantImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPChallengeApplicant> toCacheModel() {
				return _nullSPChallengeApplicantCacheModel;
			}
		};

	private static CacheModel<SPChallengeApplicant> _nullSPChallengeApplicantCacheModel =
		new CacheModel<SPChallengeApplicant>() {
			@Override
			public SPChallengeApplicant toEntityModel() {
				return _nullSPChallengeApplicant;
			}
		};
}