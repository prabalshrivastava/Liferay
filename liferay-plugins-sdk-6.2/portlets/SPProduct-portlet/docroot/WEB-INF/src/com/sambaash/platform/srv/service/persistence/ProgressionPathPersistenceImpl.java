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

package com.sambaash.platform.srv.service.persistence;

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

import com.sambaash.platform.srv.NoSuchProgressionPathException;
import com.sambaash.platform.srv.model.ProgressionPath;
import com.sambaash.platform.srv.model.impl.ProgressionPathImpl;
import com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the progression path service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProgressionPathPersistence
 * @see ProgressionPathUtil
 * @generated
 */
public class ProgressionPathPersistenceImpl extends BasePersistenceImpl<ProgressionPath>
	implements ProgressionPathPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProgressionPathUtil} to access the progression path persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProgressionPathImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ProgressionPathModelImpl.GROUPID_COLUMN_BITMASK |
			ProgressionPathModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the progression paths where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progression paths where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @return the range of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progression paths where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ProgressionPath> list = (List<ProgressionPath>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProgressionPath progressionPath : list) {
				if ((groupId != progressionPath.getGroupId())) {
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

			query.append(_SQL_SELECT_PROGRESSIONPATH_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProgressionPathModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ProgressionPath>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProgressionPath>(list);
				}
				else {
					list = (List<ProgressionPath>)QueryUtil.list(q,
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
	 * Returns the first progression path in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = fetchByGroupId_First(groupId,
				orderByComparator);

		if (progressionPath != null) {
			return progressionPath;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressionPathException(msg.toString());
	}

	/**
	 * Returns the first progression path in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progression path, or <code>null</code> if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProgressionPath> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progression path in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (progressionPath != null) {
			return progressionPath;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressionPathException(msg.toString());
	}

	/**
	 * Returns the last progression path in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progression path, or <code>null</code> if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ProgressionPath> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progression paths before and after the current progression path in the ordered set where groupId = &#63;.
	 *
	 * @param spProgressionPathId the primary key of the current progression path
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath[] findByGroupId_PrevAndNext(
		long spProgressionPathId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = findByPrimaryKey(spProgressionPathId);

		Session session = null;

		try {
			session = openSession();

			ProgressionPath[] array = new ProgressionPathImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, progressionPath,
					groupId, orderByComparator, true);

			array[1] = progressionPath;

			array[2] = getByGroupId_PrevAndNext(session, progressionPath,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgressionPath getByGroupId_PrevAndNext(Session session,
		ProgressionPath progressionPath, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROGRESSIONPATH_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ProgressionPathModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(progressionPath);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProgressionPath> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progression paths where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ProgressionPath progressionPath : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(progressionPath);
		}
	}

	/**
	 * Returns the number of progression paths where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROGRESSIONPATH_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "progressionPath.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED,
			ProgressionPathImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProgressionPathModelImpl.SPCOURSEID_COLUMN_BITMASK |
			ProgressionPathModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the progression paths where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progression paths where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @return the range of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the progression paths where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] { spCourseId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] {
					spCourseId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ProgressionPath> list = (List<ProgressionPath>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProgressionPath progressionPath : list) {
				if ((spCourseId != progressionPath.getSpCourseId()) ||
						(groupId != progressionPath.getGroupId())) {
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

			query.append(_SQL_SELECT_PROGRESSIONPATH_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProgressionPathModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ProgressionPath>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProgressionPath>(list);
				}
				else {
					list = (List<ProgressionPath>)QueryUtil.list(q,
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
	 * Returns the first progression path in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (progressionPath != null) {
			return progressionPath;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressionPathException(msg.toString());
	}

	/**
	 * Returns the first progression path in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching progression path, or <code>null</code> if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProgressionPath> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last progression path in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (progressionPath != null) {
			return progressionPath;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProgressionPathException(msg.toString());
	}

	/**
	 * Returns the last progression path in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching progression path, or <code>null</code> if a matching progression path could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<ProgressionPath> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the progression paths before and after the current progression path in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spProgressionPathId the primary key of the current progression path
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath[] findByCourseIdAndGroupId_PrevAndNext(
		long spProgressionPathId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = findByPrimaryKey(spProgressionPathId);

		Session session = null;

		try {
			session = openSession();

			ProgressionPath[] array = new ProgressionPathImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					progressionPath, spCourseId, groupId, orderByComparator,
					true);

			array[1] = progressionPath;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					progressionPath, spCourseId, groupId, orderByComparator,
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

	protected ProgressionPath getByCourseIdAndGroupId_PrevAndNext(
		Session session, ProgressionPath progressionPath, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROGRESSIONPATH_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

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
			query.append(ProgressionPathModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(progressionPath);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProgressionPath> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the progression paths where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (ProgressionPath progressionPath : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(progressionPath);
		}
	}

	/**
	 * Returns the number of progression paths where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCourseId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROGRESSIONPATH_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "progressionPath.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "progressionPath.groupId = ?";

	public ProgressionPathPersistenceImpl() {
		setModelClass(ProgressionPath.class);
	}

	/**
	 * Caches the progression path in the entity cache if it is enabled.
	 *
	 * @param progressionPath the progression path
	 */
	@Override
	public void cacheResult(ProgressionPath progressionPath) {
		EntityCacheUtil.putResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathImpl.class, progressionPath.getPrimaryKey(),
			progressionPath);

		progressionPath.resetOriginalValues();
	}

	/**
	 * Caches the progression paths in the entity cache if it is enabled.
	 *
	 * @param progressionPaths the progression paths
	 */
	@Override
	public void cacheResult(List<ProgressionPath> progressionPaths) {
		for (ProgressionPath progressionPath : progressionPaths) {
			if (EntityCacheUtil.getResult(
						ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
						ProgressionPathImpl.class,
						progressionPath.getPrimaryKey()) == null) {
				cacheResult(progressionPath);
			}
			else {
				progressionPath.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all progression paths.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProgressionPathImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProgressionPathImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the progression path.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgressionPath progressionPath) {
		EntityCacheUtil.removeResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathImpl.class, progressionPath.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProgressionPath> progressionPaths) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProgressionPath progressionPath : progressionPaths) {
			EntityCacheUtil.removeResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
				ProgressionPathImpl.class, progressionPath.getPrimaryKey());
		}
	}

	/**
	 * Creates a new progression path with the primary key. Does not add the progression path to the database.
	 *
	 * @param spProgressionPathId the primary key for the new progression path
	 * @return the new progression path
	 */
	@Override
	public ProgressionPath create(long spProgressionPathId) {
		ProgressionPath progressionPath = new ProgressionPathImpl();

		progressionPath.setNew(true);
		progressionPath.setPrimaryKey(spProgressionPathId);

		return progressionPath;
	}

	/**
	 * Removes the progression path with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spProgressionPathId the primary key of the progression path
	 * @return the progression path that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath remove(long spProgressionPathId)
		throws NoSuchProgressionPathException, SystemException {
		return remove((Serializable)spProgressionPathId);
	}

	/**
	 * Removes the progression path with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the progression path
	 * @return the progression path that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath remove(Serializable primaryKey)
		throws NoSuchProgressionPathException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProgressionPath progressionPath = (ProgressionPath)session.get(ProgressionPathImpl.class,
					primaryKey);

			if (progressionPath == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgressionPathException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(progressionPath);
		}
		catch (NoSuchProgressionPathException nsee) {
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
	protected ProgressionPath removeImpl(ProgressionPath progressionPath)
		throws SystemException {
		progressionPath = toUnwrappedModel(progressionPath);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(progressionPath)) {
				progressionPath = (ProgressionPath)session.get(ProgressionPathImpl.class,
						progressionPath.getPrimaryKeyObj());
			}

			if (progressionPath != null) {
				session.delete(progressionPath);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (progressionPath != null) {
			clearCache(progressionPath);
		}

		return progressionPath;
	}

	@Override
	public ProgressionPath updateImpl(
		com.sambaash.platform.srv.model.ProgressionPath progressionPath)
		throws SystemException {
		progressionPath = toUnwrappedModel(progressionPath);

		boolean isNew = progressionPath.isNew();

		ProgressionPathModelImpl progressionPathModelImpl = (ProgressionPathModelImpl)progressionPath;

		Session session = null;

		try {
			session = openSession();

			if (progressionPath.isNew()) {
				session.save(progressionPath);

				progressionPath.setNew(false);
			}
			else {
				session.merge(progressionPath);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProgressionPathModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((progressionPathModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						progressionPathModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { progressionPathModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((progressionPathModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						progressionPathModelImpl.getOriginalSpCourseId(),
						progressionPathModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						progressionPathModelImpl.getSpCourseId(),
						progressionPathModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
			ProgressionPathImpl.class, progressionPath.getPrimaryKey(),
			progressionPath);

		return progressionPath;
	}

	protected ProgressionPath toUnwrappedModel(ProgressionPath progressionPath) {
		if (progressionPath instanceof ProgressionPathImpl) {
			return progressionPath;
		}

		ProgressionPathImpl progressionPathImpl = new ProgressionPathImpl();

		progressionPathImpl.setNew(progressionPath.isNew());
		progressionPathImpl.setPrimaryKey(progressionPath.getPrimaryKey());

		progressionPathImpl.setSpProgressionPathId(progressionPath.getSpProgressionPathId());
		progressionPathImpl.setGroupId(progressionPath.getGroupId());
		progressionPathImpl.setCompanyId(progressionPath.getCompanyId());
		progressionPathImpl.setUserId(progressionPath.getUserId());
		progressionPathImpl.setUserName(progressionPath.getUserName());
		progressionPathImpl.setCreateDate(progressionPath.getCreateDate());
		progressionPathImpl.setModifiedDate(progressionPath.getModifiedDate());
		progressionPathImpl.setCareerLevel(progressionPath.getCareerLevel());
		progressionPathImpl.setLevel(progressionPath.getLevel());
		progressionPathImpl.setProgressionType(progressionPath.getProgressionType());
		progressionPathImpl.setProgressionCategory(progressionPath.getProgressionCategory());
		progressionPathImpl.setStartMonth(progressionPath.getStartMonth());
		progressionPathImpl.setEndMonth(progressionPath.getEndMonth());
		progressionPathImpl.setDuration(progressionPath.getDuration());
		progressionPathImpl.setOptionalMandatory(progressionPath.getOptionalMandatory());
		progressionPathImpl.setSpCourseId(progressionPath.getSpCourseId());

		return progressionPathImpl;
	}

	/**
	 * Returns the progression path with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the progression path
	 * @return the progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgressionPathException, SystemException {
		ProgressionPath progressionPath = fetchByPrimaryKey(primaryKey);

		if (progressionPath == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgressionPathException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return progressionPath;
	}

	/**
	 * Returns the progression path with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProgressionPathException} if it could not be found.
	 *
	 * @param spProgressionPathId the primary key of the progression path
	 * @return the progression path
	 * @throws com.sambaash.platform.srv.NoSuchProgressionPathException if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath findByPrimaryKey(long spProgressionPathId)
		throws NoSuchProgressionPathException, SystemException {
		return findByPrimaryKey((Serializable)spProgressionPathId);
	}

	/**
	 * Returns the progression path with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the progression path
	 * @return the progression path, or <code>null</code> if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProgressionPath progressionPath = (ProgressionPath)EntityCacheUtil.getResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
				ProgressionPathImpl.class, primaryKey);

		if (progressionPath == _nullProgressionPath) {
			return null;
		}

		if (progressionPath == null) {
			Session session = null;

			try {
				session = openSession();

				progressionPath = (ProgressionPath)session.get(ProgressionPathImpl.class,
						primaryKey);

				if (progressionPath != null) {
					cacheResult(progressionPath);
				}
				else {
					EntityCacheUtil.putResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
						ProgressionPathImpl.class, primaryKey,
						_nullProgressionPath);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProgressionPathModelImpl.ENTITY_CACHE_ENABLED,
					ProgressionPathImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return progressionPath;
	}

	/**
	 * Returns the progression path with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spProgressionPathId the primary key of the progression path
	 * @return the progression path, or <code>null</code> if a progression path with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProgressionPath fetchByPrimaryKey(long spProgressionPathId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spProgressionPathId);
	}

	/**
	 * Returns all the progression paths.
	 *
	 * @return the progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the progression paths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @return the range of progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the progression paths.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProgressionPathModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of progression paths
	 * @param end the upper bound of the range of progression paths (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of progression paths
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProgressionPath> findAll(int start, int end,
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

		List<ProgressionPath> list = (List<ProgressionPath>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROGRESSIONPATH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRESSIONPATH;

				if (pagination) {
					sql = sql.concat(ProgressionPathModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProgressionPath>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProgressionPath>(list);
				}
				else {
					list = (List<ProgressionPath>)QueryUtil.list(q,
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
	 * Removes all the progression paths from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProgressionPath progressionPath : findAll()) {
			remove(progressionPath);
		}
	}

	/**
	 * Returns the number of progression paths.
	 *
	 * @return the number of progression paths
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

				Query q = session.createQuery(_SQL_COUNT_PROGRESSIONPATH);

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
	 * Initializes the progression path persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ProgressionPath")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProgressionPath>> listenersList = new ArrayList<ModelListener<ProgressionPath>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProgressionPath>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProgressionPathImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROGRESSIONPATH = "SELECT progressionPath FROM ProgressionPath progressionPath";
	private static final String _SQL_SELECT_PROGRESSIONPATH_WHERE = "SELECT progressionPath FROM ProgressionPath progressionPath WHERE ";
	private static final String _SQL_COUNT_PROGRESSIONPATH = "SELECT COUNT(progressionPath) FROM ProgressionPath progressionPath";
	private static final String _SQL_COUNT_PROGRESSIONPATH_WHERE = "SELECT COUNT(progressionPath) FROM ProgressionPath progressionPath WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "progressionPath.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProgressionPath exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProgressionPath exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProgressionPathPersistenceImpl.class);
	private static ProgressionPath _nullProgressionPath = new ProgressionPathImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProgressionPath> toCacheModel() {
				return _nullProgressionPathCacheModel;
			}
		};

	private static CacheModel<ProgressionPath> _nullProgressionPathCacheModel = new CacheModel<ProgressionPath>() {
			@Override
			public ProgressionPath toEntityModel() {
				return _nullProgressionPath;
			}
		};
}