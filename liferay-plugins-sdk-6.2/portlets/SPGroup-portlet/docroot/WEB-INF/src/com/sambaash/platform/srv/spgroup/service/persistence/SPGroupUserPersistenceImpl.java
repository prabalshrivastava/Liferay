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

package com.sambaash.platform.srv.spgroup.service.persistence;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spgroup.NoSuchUserException;
import com.sambaash.platform.srv.spgroup.model.SPGroupUser;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserImpl;
import com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupUserPersistence
 * @see SPGroupUserUtil
 * @generated
 */
public class SPGroupUserPersistenceImpl extends BasePersistenceImpl<SPGroupUser>
	implements SPGroupUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPGroupUserUtil} to access the s p group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPGroupUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPID =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySPGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPID =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySPGroupId",
			new String[] { Long.class.getName() },
			SPGroupUserModelImpl.SPGROUPID_COLUMN_BITMASK |
			SPGroupUserModelImpl.JOINDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPGROUPID = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySPGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p group users where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @return the matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupId(long spGroupId)
		throws SystemException {
		return findBySPGroupId(spGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p group users where spGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupId(long spGroupId, int start, int end)
		throws SystemException {
		return findBySPGroupId(spGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users where spGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupId(long spGroupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPID;
			finderArgs = new Object[] { spGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPID;
			finderArgs = new Object[] { spGroupId, start, end, orderByComparator };
		}

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroupUser spGroupUser : list) {
				if ((spGroupId != spGroupUser.getSpGroupId())) {
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

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPID_SPGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group user in the ordered set where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupId_First(long spGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupId_First(spGroupId,
				orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first s p group user in the ordered set where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupId_First(long spGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroupUser> list = findBySPGroupId(spGroupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupId_Last(long spGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupId_Last(spGroupId,
				orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupId_Last(long spGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySPGroupId(spGroupId);

		if (count == 0) {
			return null;
		}

		List<SPGroupUser> list = findBySPGroupId(spGroupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63;.
	 *
	 * @param spGroupUserPK the primary key of the current s p group user
	 * @param spGroupId the sp group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser[] findBySPGroupId_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByPrimaryKey(spGroupUserPK);

		Session session = null;

		try {
			session = openSession();

			SPGroupUser[] array = new SPGroupUserImpl[3];

			array[0] = getBySPGroupId_PrevAndNext(session, spGroupUser,
					spGroupId, orderByComparator, true);

			array[1] = spGroupUser;

			array[2] = getBySPGroupId_PrevAndNext(session, spGroupUser,
					spGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroupUser getBySPGroupId_PrevAndNext(Session session,
		SPGroupUser spGroupUser, long spGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

		query.append(_FINDER_COLUMN_SPGROUPID_SPGROUPID_2);

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
			query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroupUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p group users where spGroupId = &#63; from the database.
	 *
	 * @param spGroupId the sp group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySPGroupId(long spGroupId) throws SystemException {
		for (SPGroupUser spGroupUser : findBySPGroupId(spGroupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users where spGroupId = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @return the number of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPGroupId(long spGroupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPGROUPID;

		Object[] finderArgs = new Object[] { spGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPID_SPGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

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

	private static final String _FINDER_COLUMN_SPGROUPID_SPGROUPID_2 = "spGroupUser.id.spGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySPGroupIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySPGroupIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPGroupUserModelImpl.SPGROUPID_COLUMN_BITMASK |
			SPGroupUserModelImpl.STATUS_COLUMN_BITMASK |
			SPGroupUserModelImpl.JOINDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPGROUPIDANDSTATUS = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySPGroupIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p group users where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId, int status)
		throws SystemException {
		return findBySPGroupIdAndStatus(spGroupId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group users where spGroupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId,
		int status, int start, int end) throws SystemException {
		return findBySPGroupIdAndStatus(spGroupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users where spGroupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndStatus(long spGroupId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS;
			finderArgs = new Object[] { spGroupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS;
			finderArgs = new Object[] {
					spGroupId, status,
					
					start, end, orderByComparator
				};
		}

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroupUser spGroupUser : list) {
				if ((spGroupId != spGroupUser.getSpGroupId()) ||
						(status != spGroupUser.getStatus())) {
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

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_SPGROUPID_2);

			query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupIdAndStatus_First(long spGroupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupIdAndStatus_First(spGroupId,
				status, orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupIdAndStatus_First(long spGroupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPGroupUser> list = findBySPGroupIdAndStatus(spGroupId, status, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupIdAndStatus_Last(long spGroupId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupIdAndStatus_Last(spGroupId,
				status, orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupIdAndStatus_Last(long spGroupId,
		int status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySPGroupIdAndStatus(spGroupId, status);

		if (count == 0) {
			return null;
		}

		List<SPGroupUser> list = findBySPGroupIdAndStatus(spGroupId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupUserPK the primary key of the current s p group user
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser[] findBySPGroupIdAndStatus_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByPrimaryKey(spGroupUserPK);

		Session session = null;

		try {
			session = openSession();

			SPGroupUser[] array = new SPGroupUserImpl[3];

			array[0] = getBySPGroupIdAndStatus_PrevAndNext(session,
					spGroupUser, spGroupId, status, orderByComparator, true);

			array[1] = spGroupUser;

			array[2] = getBySPGroupIdAndStatus_PrevAndNext(session,
					spGroupUser, spGroupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroupUser getBySPGroupIdAndStatus_PrevAndNext(Session session,
		SPGroupUser spGroupUser, long spGroupId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

		query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_SPGROUPID_2);

		query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_STATUS_2);

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
			query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spGroupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroupUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p group users where spGroupId = &#63; and status = &#63; from the database.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySPGroupIdAndStatus(long spGroupId, int status)
		throws SystemException {
		for (SPGroupUser spGroupUser : findBySPGroupIdAndStatus(spGroupId,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users where spGroupId = &#63; and status = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the number of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPGroupIdAndStatus(long spGroupId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPGROUPIDANDSTATUS;

		Object[] finderArgs = new Object[] { spGroupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_SPGROUPID_2);

			query.append(_FINDER_COLUMN_SPGROUPIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

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

	private static final String _FINDER_COLUMN_SPGROUPIDANDSTATUS_SPGROUPID_2 = "spGroupUser.id.spGroupId = ? AND ";
	private static final String _FINDER_COLUMN_SPGROUPIDANDSTATUS_STATUS_2 = "spGroupUser.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SPGroupUserModelImpl.USERID_COLUMN_BITMASK |
			SPGroupUserModelImpl.JOINDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p group users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroupUser spGroupUser : list) {
				if ((userId != spGroupUser.getUserId())) {
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

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByUserId_First(userId, orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first s p group user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroupUser> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByUserId_Last(userId, orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last s p group user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPGroupUser> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p group users before and after the current s p group user in the ordered set where userId = &#63;.
	 *
	 * @param spGroupUserPK the primary key of the current s p group user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser[] findByUserId_PrevAndNext(SPGroupUserPK spGroupUserPK,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByPrimaryKey(spGroupUserPK);

		Session session = null;

		try {
			session = openSession();

			SPGroupUser[] array = new SPGroupUserImpl[3];

			array[0] = getByUserId_PrevAndNext(session, spGroupUser, userId,
					orderByComparator, true);

			array[1] = spGroupUser;

			array[2] = getByUserId_PrevAndNext(session, spGroupUser, userId,
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

	protected SPGroupUser getByUserId_PrevAndNext(Session session,
		SPGroupUser spGroupUser, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

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
			query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroupUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p group users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SPGroupUser spGroupUser : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p group users
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

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spGroupUser.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPGroupUserModelImpl.USERID_COLUMN_BITMASK |
			SPGroupUserModelImpl.STATUS_COLUMN_BITMASK |
			SPGroupUserModelImpl.JOINDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDSTATUS = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p group users where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status)
		throws SystemException {
		return findByUserIdAndStatus(userId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group users where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status,
		int start, int end) throws SystemException {
		return findByUserIdAndStatus(userId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findByUserIdAndStatus(long userId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS;
			finderArgs = new Object[] { userId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSTATUS;
			finderArgs = new Object[] {
					userId, status,
					
					start, end, orderByComparator
				};
		}

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroupUser spGroupUser : list) {
				if ((userId != spGroupUser.getUserId()) ||
						(status != spGroupUser.getStatus())) {
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

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group user in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByUserIdAndStatus_First(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByUserIdAndStatus_First(userId, status,
				orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first s p group user in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserIdAndStatus_First(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroupUser> list = findByUserIdAndStatus(userId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group user in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByUserIdAndStatus_Last(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByUserIdAndStatus_Last(userId, status,
				orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last s p group user in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserIdAndStatus_Last(long userId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdAndStatus(userId, status);

		if (count == 0) {
			return null;
		}

		List<SPGroupUser> list = findByUserIdAndStatus(userId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p group users before and after the current s p group user in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param spGroupUserPK the primary key of the current s p group user
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser[] findByUserIdAndStatus_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByPrimaryKey(spGroupUserPK);

		Session session = null;

		try {
			session = openSession();

			SPGroupUser[] array = new SPGroupUserImpl[3];

			array[0] = getByUserIdAndStatus_PrevAndNext(session, spGroupUser,
					userId, status, orderByComparator, true);

			array[1] = spGroupUser;

			array[2] = getByUserIdAndStatus_PrevAndNext(session, spGroupUser,
					userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroupUser getByUserIdAndStatus_PrevAndNext(Session session,
		SPGroupUser spGroupUser, long userId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

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
			query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroupUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p group users where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndStatus(long userId, int status)
		throws SystemException {
		for (SPGroupUser spGroupUser : findByUserIdAndStatus(userId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndStatus(long userId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDSTATUS;

		Object[] finderArgs = new Object[] { userId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDANDSTATUS_USERID_2 = "spGroupUser.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSTATUS_STATUS_2 = "spGroupUser.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPIDANDROLE =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySPGroupIdAndRole",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDROLE =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySPGroupIdAndRole",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPGroupUserModelImpl.SPGROUPID_COLUMN_BITMASK |
			SPGroupUserModelImpl.ROLE_COLUMN_BITMASK |
			SPGroupUserModelImpl.JOINDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPGROUPIDANDROLE = new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySPGroupIdAndRole",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p group users where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @return the matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role)
		throws SystemException {
		return findBySPGroupIdAndRole(spGroupId, role, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group users where spGroupId = &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role,
		int start, int end) throws SystemException {
		return findBySPGroupIdAndRole(spGroupId, role, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users where spGroupId = &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findBySPGroupIdAndRole(long spGroupId, int role,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDROLE;
			finderArgs = new Object[] { spGroupId, role };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPGROUPIDANDROLE;
			finderArgs = new Object[] {
					spGroupId, role,
					
					start, end, orderByComparator
				};
		}

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPGroupUser spGroupUser : list) {
				if ((spGroupId != spGroupUser.getSpGroupId()) ||
						(role != spGroupUser.getRole())) {
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

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_SPGROUPID_2);

			query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_ROLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

				qPos.add(role);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupIdAndRole_First(long spGroupId, int role,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupIdAndRole_First(spGroupId,
				role, orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(", role=");
		msg.append(role);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the first s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupIdAndRole_First(long spGroupId, int role,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPGroupUser> list = findBySPGroupIdAndRole(spGroupId, role, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findBySPGroupIdAndRole_Last(long spGroupId, int role,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchBySPGroupIdAndRole_Last(spGroupId, role,
				orderByComparator);

		if (spGroupUser != null) {
			return spGroupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spGroupId=");
		msg.append(spGroupId);

		msg.append(", role=");
		msg.append(role);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserException(msg.toString());
	}

	/**
	 * Returns the last s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchBySPGroupIdAndRole_Last(long spGroupId, int role,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySPGroupIdAndRole(spGroupId, role);

		if (count == 0) {
			return null;
		}

		List<SPGroupUser> list = findBySPGroupIdAndRole(spGroupId, role,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p group users before and after the current s p group user in the ordered set where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupUserPK the primary key of the current s p group user
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser[] findBySPGroupIdAndRole_PrevAndNext(
		SPGroupUserPK spGroupUserPK, long spGroupId, int role,
		OrderByComparator orderByComparator)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByPrimaryKey(spGroupUserPK);

		Session session = null;

		try {
			session = openSession();

			SPGroupUser[] array = new SPGroupUserImpl[3];

			array[0] = getBySPGroupIdAndRole_PrevAndNext(session, spGroupUser,
					spGroupId, role, orderByComparator, true);

			array[1] = spGroupUser;

			array[2] = getBySPGroupIdAndRole_PrevAndNext(session, spGroupUser,
					spGroupId, role, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPGroupUser getBySPGroupIdAndRole_PrevAndNext(Session session,
		SPGroupUser spGroupUser, long spGroupId, int role,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

		query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_SPGROUPID_2);

		query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_ROLE_2);

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
			query.append(SPGroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spGroupId);

		qPos.add(role);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spGroupUser);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPGroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p group users where spGroupId = &#63; and role = &#63; from the database.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySPGroupIdAndRole(long spGroupId, int role)
		throws SystemException {
		for (SPGroupUser spGroupUser : findBySPGroupIdAndRole(spGroupId, role,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users where spGroupId = &#63; and role = &#63;.
	 *
	 * @param spGroupId the sp group ID
	 * @param role the role
	 * @return the number of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySPGroupIdAndRole(long spGroupId, int role)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPGROUPIDANDROLE;

		Object[] finderArgs = new Object[] { spGroupId, role };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_SPGROUPID_2);

			query.append(_FINDER_COLUMN_SPGROUPIDANDROLE_ROLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spGroupId);

				qPos.add(role);

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

	private static final String _FINDER_COLUMN_SPGROUPIDANDROLE_SPGROUPID_2 = "spGroupUser.id.spGroupId = ? AND ";
	private static final String _FINDER_COLUMN_SPGROUPIDANDROLE_ROLE_2 = "spGroupUser.role = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, SPGroupUserImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdAndGroupIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SPGroupUserModelImpl.USERID_COLUMN_BITMASK |
			SPGroupUserModelImpl.SPGROUPID_COLUMN_BITMASK |
			SPGroupUserModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS =
		new FinderPath(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndGroupIdAndStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchUserException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the matching s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByUserIdAndGroupIdAndStatus(long userId,
		long spGroupId, int status) throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status);

		if (spGroupUser == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", spGroupId=");
			msg.append(spGroupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserException(msg.toString());
		}

		return spGroupUser;
	}

	/**
	 * Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserIdAndGroupIdAndStatus(long userId,
		long spGroupId, int status) throws SystemException {
		return fetchByUserIdAndGroupIdAndStatus(userId, spGroupId, status, true);
	}

	/**
	 * Returns the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p group user, or <code>null</code> if a matching s p group user could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByUserIdAndGroupIdAndStatus(long userId,
		long spGroupId, int status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, spGroupId, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
					finderArgs, this);
		}

		if (result instanceof SPGroupUser) {
			SPGroupUser spGroupUser = (SPGroupUser)result;

			if ((userId != spGroupUser.getUserId()) ||
					(spGroupId != spGroupUser.getSpGroupId()) ||
					(status != spGroupUser.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_SPGROUPID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(spGroupId);

				qPos.add(status);

				List<SPGroupUser> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
						finderArgs, list);
				}
				else {
					SPGroupUser spGroupUser = list.get(0);

					result = spGroupUser;

					cacheResult(spGroupUser);

					if ((spGroupUser.getUserId() != userId) ||
							(spGroupUser.getSpGroupId() != spGroupId) ||
							(spGroupUser.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
							finderArgs, spGroupUser);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
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
			return (SPGroupUser)result;
		}
	}

	/**
	 * Removes the s p group user where userId = &#63; and spGroupId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the s p group user that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser removeByUserIdAndGroupIdAndStatus(long userId,
		long spGroupId, int status) throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = findByUserIdAndGroupIdAndStatus(userId,
				spGroupId, status);

		return remove(spGroupUser);
	}

	/**
	 * Returns the number of s p group users where userId = &#63; and spGroupId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param spGroupId the sp group ID
	 * @param status the status
	 * @return the number of matching s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndGroupIdAndStatus(long userId, long spGroupId,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS;

		Object[] finderArgs = new Object[] { userId, spGroupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPGROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_SPGROUPID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(spGroupId);

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

	private static final String _FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_USERID_2 =
		"spGroupUser.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_SPGROUPID_2 =
		"spGroupUser.id.spGroupId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDGROUPIDANDSTATUS_STATUS_2 =
		"spGroupUser.status = ?";

	public SPGroupUserPersistenceImpl() {
		setModelClass(SPGroupUser.class);
	}

	/**
	 * Caches the s p group user in the entity cache if it is enabled.
	 *
	 * @param spGroupUser the s p group user
	 */
	@Override
	public void cacheResult(SPGroupUser spGroupUser) {
		EntityCacheUtil.putResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserImpl.class, spGroupUser.getPrimaryKey(), spGroupUser);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
			new Object[] {
				spGroupUser.getUserId(), spGroupUser.getSpGroupId(),
				spGroupUser.getStatus()
			}, spGroupUser);

		spGroupUser.resetOriginalValues();
	}

	/**
	 * Caches the s p group users in the entity cache if it is enabled.
	 *
	 * @param spGroupUsers the s p group users
	 */
	@Override
	public void cacheResult(List<SPGroupUser> spGroupUsers) {
		for (SPGroupUser spGroupUser : spGroupUsers) {
			if (EntityCacheUtil.getResult(
						SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupUserImpl.class, spGroupUser.getPrimaryKey()) == null) {
				cacheResult(spGroupUser);
			}
			else {
				spGroupUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p group users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPGroupUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPGroupUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p group user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPGroupUser spGroupUser) {
		EntityCacheUtil.removeResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserImpl.class, spGroupUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spGroupUser);
	}

	@Override
	public void clearCache(List<SPGroupUser> spGroupUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPGroupUser spGroupUser : spGroupUsers) {
			EntityCacheUtil.removeResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupUserImpl.class, spGroupUser.getPrimaryKey());

			clearUniqueFindersCache(spGroupUser);
		}
	}

	protected void cacheUniqueFindersCache(SPGroupUser spGroupUser) {
		if (spGroupUser.isNew()) {
			Object[] args = new Object[] {
					spGroupUser.getUserId(), spGroupUser.getSpGroupId(),
					spGroupUser.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
				args, spGroupUser);
		}
		else {
			SPGroupUserModelImpl spGroupUserModelImpl = (SPGroupUserModelImpl)spGroupUser;

			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUser.getUserId(), spGroupUser.getSpGroupId(),
						spGroupUser.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
					args, spGroupUser);
			}
		}
	}

	protected void clearUniqueFindersCache(SPGroupUser spGroupUser) {
		SPGroupUserModelImpl spGroupUserModelImpl = (SPGroupUserModelImpl)spGroupUser;

		Object[] args = new Object[] {
				spGroupUser.getUserId(), spGroupUser.getSpGroupId(),
				spGroupUser.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
			args);

		if ((spGroupUserModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS.getColumnBitmask()) != 0) {
			args = new Object[] {
					spGroupUserModelImpl.getOriginalUserId(),
					spGroupUserModelImpl.getOriginalSpGroupId(),
					spGroupUserModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPIDANDSTATUS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPIDANDSTATUS,
				args);
		}
	}

	/**
	 * Creates a new s p group user with the primary key. Does not add the s p group user to the database.
	 *
	 * @param spGroupUserPK the primary key for the new s p group user
	 * @return the new s p group user
	 */
	@Override
	public SPGroupUser create(SPGroupUserPK spGroupUserPK) {
		SPGroupUser spGroupUser = new SPGroupUserImpl();

		spGroupUser.setNew(true);
		spGroupUser.setPrimaryKey(spGroupUserPK);

		return spGroupUser;
	}

	/**
	 * Removes the s p group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGroupUserPK the primary key of the s p group user
	 * @return the s p group user that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser remove(SPGroupUserPK spGroupUserPK)
		throws NoSuchUserException, SystemException {
		return remove((Serializable)spGroupUserPK);
	}

	/**
	 * Removes the s p group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p group user
	 * @return the s p group user that was removed
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser remove(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPGroupUser spGroupUser = (SPGroupUser)session.get(SPGroupUserImpl.class,
					primaryKey);

			if (spGroupUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spGroupUser);
		}
		catch (NoSuchUserException nsee) {
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
	protected SPGroupUser removeImpl(SPGroupUser spGroupUser)
		throws SystemException {
		spGroupUser = toUnwrappedModel(spGroupUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spGroupUser)) {
				spGroupUser = (SPGroupUser)session.get(SPGroupUserImpl.class,
						spGroupUser.getPrimaryKeyObj());
			}

			if (spGroupUser != null) {
				session.delete(spGroupUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spGroupUser != null) {
			clearCache(spGroupUser);
		}

		return spGroupUser;
	}

	@Override
	public SPGroupUser updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser)
		throws SystemException {
		spGroupUser = toUnwrappedModel(spGroupUser);

		boolean isNew = spGroupUser.isNew();

		SPGroupUserModelImpl spGroupUserModelImpl = (SPGroupUserModelImpl)spGroupUser;

		Session session = null;

		try {
			session = openSession();

			if (spGroupUser.isNew()) {
				session.save(spGroupUser);

				spGroupUser.setNew(false);
			}
			else {
				session.merge(spGroupUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPGroupUserModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUserModelImpl.getOriginalSpGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPID,
					args);

				args = new Object[] { spGroupUserModelImpl.getSpGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPID,
					args);
			}

			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUserModelImpl.getOriginalSpGroupId(),
						spGroupUserModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS,
					args);

				args = new Object[] {
						spGroupUserModelImpl.getSpGroupId(),
						spGroupUserModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDSTATUS,
					args);
			}

			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUserModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { spGroupUserModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUserModelImpl.getOriginalUserId(),
						spGroupUserModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS,
					args);

				args = new Object[] {
						spGroupUserModelImpl.getUserId(),
						spGroupUserModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSTATUS,
					args);
			}

			if ((spGroupUserModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spGroupUserModelImpl.getOriginalSpGroupId(),
						spGroupUserModelImpl.getOriginalRole()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPIDANDROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDROLE,
					args);

				args = new Object[] {
						spGroupUserModelImpl.getSpGroupId(),
						spGroupUserModelImpl.getRole()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPGROUPIDANDROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPGROUPIDANDROLE,
					args);
			}
		}

		EntityCacheUtil.putResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
			SPGroupUserImpl.class, spGroupUser.getPrimaryKey(), spGroupUser);

		clearUniqueFindersCache(spGroupUser);
		cacheUniqueFindersCache(spGroupUser);

		return spGroupUser;
	}

	protected SPGroupUser toUnwrappedModel(SPGroupUser spGroupUser) {
		if (spGroupUser instanceof SPGroupUserImpl) {
			return spGroupUser;
		}

		SPGroupUserImpl spGroupUserImpl = new SPGroupUserImpl();

		spGroupUserImpl.setNew(spGroupUser.isNew());
		spGroupUserImpl.setPrimaryKey(spGroupUser.getPrimaryKey());

		spGroupUserImpl.setSpGroupId(spGroupUser.getSpGroupId());
		spGroupUserImpl.setUserId(spGroupUser.getUserId());
		spGroupUserImpl.setGroupId(spGroupUser.getGroupId());
		spGroupUserImpl.setCompanyId(spGroupUser.getCompanyId());
		spGroupUserImpl.setUserName(spGroupUser.getUserName());
		spGroupUserImpl.setCreateDate(spGroupUser.getCreateDate());
		spGroupUserImpl.setModifiedDate(spGroupUser.getModifiedDate());
		spGroupUserImpl.setJoinDate(spGroupUser.getJoinDate());
		spGroupUserImpl.setRole(spGroupUser.getRole());
		spGroupUserImpl.setStatus(spGroupUser.getStatus());

		return spGroupUserImpl;
	}

	/**
	 * Returns the s p group user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group user
	 * @return the s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserException, SystemException {
		SPGroupUser spGroupUser = fetchByPrimaryKey(primaryKey);

		if (spGroupUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spGroupUser;
	}

	/**
	 * Returns the s p group user with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchUserException} if it could not be found.
	 *
	 * @param spGroupUserPK the primary key of the s p group user
	 * @return the s p group user
	 * @throws com.sambaash.platform.srv.spgroup.NoSuchUserException if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser findByPrimaryKey(SPGroupUserPK spGroupUserPK)
		throws NoSuchUserException, SystemException {
		return findByPrimaryKey((Serializable)spGroupUserPK);
	}

	/**
	 * Returns the s p group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p group user
	 * @return the s p group user, or <code>null</code> if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPGroupUser spGroupUser = (SPGroupUser)EntityCacheUtil.getResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
				SPGroupUserImpl.class, primaryKey);

		if (spGroupUser == _nullSPGroupUser) {
			return null;
		}

		if (spGroupUser == null) {
			Session session = null;

			try {
				session = openSession();

				spGroupUser = (SPGroupUser)session.get(SPGroupUserImpl.class,
						primaryKey);

				if (spGroupUser != null) {
					cacheResult(spGroupUser);
				}
				else {
					EntityCacheUtil.putResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
						SPGroupUserImpl.class, primaryKey, _nullSPGroupUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPGroupUserModelImpl.ENTITY_CACHE_ENABLED,
					SPGroupUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spGroupUser;
	}

	/**
	 * Returns the s p group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spGroupUserPK the primary key of the s p group user
	 * @return the s p group user, or <code>null</code> if a s p group user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPGroupUser fetchByPrimaryKey(SPGroupUserPK spGroupUserPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spGroupUserPK);
	}

	/**
	 * Returns all the s p group users.
	 *
	 * @return the s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @return the range of s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p group users
	 * @param end the upper bound of the range of s p group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p group users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPGroupUser> findAll(int start, int end,
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

		List<SPGroupUser> list = (List<SPGroupUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPGROUPUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPGROUPUSER;

				if (pagination) {
					sql = sql.concat(SPGroupUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPGroupUser>(list);
				}
				else {
					list = (List<SPGroupUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p group users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPGroupUser spGroupUser : findAll()) {
			remove(spGroupUser);
		}
	}

	/**
	 * Returns the number of s p group users.
	 *
	 * @return the number of s p group users
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

				Query q = session.createQuery(_SQL_COUNT_SPGROUPUSER);

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

	/**
	 * Initializes the s p group user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spgroup.model.SPGroupUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPGroupUser>> listenersList = new ArrayList<ModelListener<SPGroupUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPGroupUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPGroupUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPGROUPUSER = "SELECT spGroupUser FROM SPGroupUser spGroupUser";
	private static final String _SQL_SELECT_SPGROUPUSER_WHERE = "SELECT spGroupUser FROM SPGroupUser spGroupUser WHERE ";
	private static final String _SQL_COUNT_SPGROUPUSER = "SELECT COUNT(spGroupUser) FROM SPGroupUser spGroupUser";
	private static final String _SQL_COUNT_SPGROUPUSER_WHERE = "SELECT COUNT(spGroupUser) FROM SPGroupUser spGroupUser WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spGroupUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPGroupUser exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPGroupUser exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPGroupUserPersistenceImpl.class);
	private static SPGroupUser _nullSPGroupUser = new SPGroupUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPGroupUser> toCacheModel() {
				return _nullSPGroupUserCacheModel;
			}
		};

	private static CacheModel<SPGroupUser> _nullSPGroupUserCacheModel = new CacheModel<SPGroupUser>() {
			@Override
			public SPGroupUser toEntityModel() {
				return _nullSPGroupUser;
			}
		};
}