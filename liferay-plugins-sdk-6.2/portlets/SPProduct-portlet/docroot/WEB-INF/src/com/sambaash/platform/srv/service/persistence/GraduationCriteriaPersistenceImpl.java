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

import com.sambaash.platform.srv.NoSuchGraduationCriteriaException;
import com.sambaash.platform.srv.model.GraduationCriteria;
import com.sambaash.platform.srv.model.impl.GraduationCriteriaImpl;
import com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the graduation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see GraduationCriteriaPersistence
 * @see GraduationCriteriaUtil
 * @generated
 */
public class GraduationCriteriaPersistenceImpl extends BasePersistenceImpl<GraduationCriteria>
	implements GraduationCriteriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GraduationCriteriaUtil} to access the graduation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GraduationCriteriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			GraduationCriteriaModelImpl.GROUPID_COLUMN_BITMASK |
			GraduationCriteriaModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the graduation criterias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the graduation criterias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @return the range of matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the graduation criterias where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByGroupId(long groupId, int start,
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

		List<GraduationCriteria> list = (List<GraduationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GraduationCriteria graduationCriteria : list) {
				if ((groupId != graduationCriteria.getGroupId())) {
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

			query.append(_SQL_SELECT_GRADUATIONCRITERIA_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GraduationCriteriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<GraduationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GraduationCriteria>(list);
				}
				else {
					list = (List<GraduationCriteria>)QueryUtil.list(q,
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
	 * Returns the first graduation criteria in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = fetchByGroupId_First(groupId,
				orderByComparator);

		if (graduationCriteria != null) {
			return graduationCriteria;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGraduationCriteriaException(msg.toString());
	}

	/**
	 * Returns the first graduation criteria in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GraduationCriteria> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last graduation criteria in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (graduationCriteria != null) {
			return graduationCriteria;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGraduationCriteriaException(msg.toString());
	}

	/**
	 * Returns the last graduation criteria in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<GraduationCriteria> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the graduation criterias before and after the current graduation criteria in the ordered set where groupId = &#63;.
	 *
	 * @param spGraduationCriteriaId the primary key of the current graduation criteria
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria[] findByGroupId_PrevAndNext(
		long spGraduationCriteriaId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = findByPrimaryKey(spGraduationCriteriaId);

		Session session = null;

		try {
			session = openSession();

			GraduationCriteria[] array = new GraduationCriteriaImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, graduationCriteria,
					groupId, orderByComparator, true);

			array[1] = graduationCriteria;

			array[2] = getByGroupId_PrevAndNext(session, graduationCriteria,
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

	protected GraduationCriteria getByGroupId_PrevAndNext(Session session,
		GraduationCriteria graduationCriteria, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GRADUATIONCRITERIA_WHERE);

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
			query.append(GraduationCriteriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(graduationCriteria);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GraduationCriteria> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the graduation criterias where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (GraduationCriteria graduationCriteria : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(graduationCriteria);
		}
	}

	/**
	 * Returns the number of graduation criterias where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching graduation criterias
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

			query.append(_SQL_COUNT_GRADUATIONCRITERIA_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "graduationCriteria.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			GraduationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			GraduationCriteriaModelImpl.SPCOURSEID_COLUMN_BITMASK |
			GraduationCriteriaModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @return the range of matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the graduation criterias where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findByCourseIdAndGroupId(long spCourseId,
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

		List<GraduationCriteria> list = (List<GraduationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GraduationCriteria graduationCriteria : list) {
				if ((spCourseId != graduationCriteria.getSpCourseId()) ||
						(groupId != graduationCriteria.getGroupId())) {
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

			query.append(_SQL_SELECT_GRADUATIONCRITERIA_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GraduationCriteriaModelImpl.ORDER_BY_JPQL);
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
					list = (List<GraduationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GraduationCriteria>(list);
				}
				else {
					list = (List<GraduationCriteria>)QueryUtil.list(q,
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
	 * Returns the first graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (graduationCriteria != null) {
			return graduationCriteria;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGraduationCriteriaException(msg.toString());
	}

	/**
	 * Returns the first graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GraduationCriteria> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (graduationCriteria != null) {
			return graduationCriteria;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGraduationCriteriaException(msg.toString());
	}

	/**
	 * Returns the last graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching graduation criteria, or <code>null</code> if a matching graduation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<GraduationCriteria> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the graduation criterias before and after the current graduation criteria in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spGraduationCriteriaId the primary key of the current graduation criteria
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria[] findByCourseIdAndGroupId_PrevAndNext(
		long spGraduationCriteriaId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = findByPrimaryKey(spGraduationCriteriaId);

		Session session = null;

		try {
			session = openSession();

			GraduationCriteria[] array = new GraduationCriteriaImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					graduationCriteria, spCourseId, groupId, orderByComparator,
					true);

			array[1] = graduationCriteria;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					graduationCriteria, spCourseId, groupId, orderByComparator,
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

	protected GraduationCriteria getByCourseIdAndGroupId_PrevAndNext(
		Session session, GraduationCriteria graduationCriteria,
		long spCourseId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GRADUATIONCRITERIA_WHERE);

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
			query.append(GraduationCriteriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(graduationCriteria);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GraduationCriteria> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the graduation criterias where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (GraduationCriteria graduationCriteria : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(graduationCriteria);
		}
	}

	/**
	 * Returns the number of graduation criterias where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching graduation criterias
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

			query.append(_SQL_COUNT_GRADUATIONCRITERIA_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "graduationCriteria.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "graduationCriteria.groupId = ?";

	public GraduationCriteriaPersistenceImpl() {
		setModelClass(GraduationCriteria.class);
	}

	/**
	 * Caches the graduation criteria in the entity cache if it is enabled.
	 *
	 * @param graduationCriteria the graduation criteria
	 */
	@Override
	public void cacheResult(GraduationCriteria graduationCriteria) {
		EntityCacheUtil.putResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaImpl.class, graduationCriteria.getPrimaryKey(),
			graduationCriteria);

		graduationCriteria.resetOriginalValues();
	}

	/**
	 * Caches the graduation criterias in the entity cache if it is enabled.
	 *
	 * @param graduationCriterias the graduation criterias
	 */
	@Override
	public void cacheResult(List<GraduationCriteria> graduationCriterias) {
		for (GraduationCriteria graduationCriteria : graduationCriterias) {
			if (EntityCacheUtil.getResult(
						GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						GraduationCriteriaImpl.class,
						graduationCriteria.getPrimaryKey()) == null) {
				cacheResult(graduationCriteria);
			}
			else {
				graduationCriteria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all graduation criterias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GraduationCriteriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GraduationCriteriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the graduation criteria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GraduationCriteria graduationCriteria) {
		EntityCacheUtil.removeResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaImpl.class, graduationCriteria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GraduationCriteria> graduationCriterias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GraduationCriteria graduationCriteria : graduationCriterias) {
			EntityCacheUtil.removeResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				GraduationCriteriaImpl.class, graduationCriteria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new graduation criteria with the primary key. Does not add the graduation criteria to the database.
	 *
	 * @param spGraduationCriteriaId the primary key for the new graduation criteria
	 * @return the new graduation criteria
	 */
	@Override
	public GraduationCriteria create(long spGraduationCriteriaId) {
		GraduationCriteria graduationCriteria = new GraduationCriteriaImpl();

		graduationCriteria.setNew(true);
		graduationCriteria.setPrimaryKey(spGraduationCriteriaId);

		return graduationCriteria;
	}

	/**
	 * Removes the graduation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spGraduationCriteriaId the primary key of the graduation criteria
	 * @return the graduation criteria that was removed
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria remove(long spGraduationCriteriaId)
		throws NoSuchGraduationCriteriaException, SystemException {
		return remove((Serializable)spGraduationCriteriaId);
	}

	/**
	 * Removes the graduation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the graduation criteria
	 * @return the graduation criteria that was removed
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria remove(Serializable primaryKey)
		throws NoSuchGraduationCriteriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GraduationCriteria graduationCriteria = (GraduationCriteria)session.get(GraduationCriteriaImpl.class,
					primaryKey);

			if (graduationCriteria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGraduationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(graduationCriteria);
		}
		catch (NoSuchGraduationCriteriaException nsee) {
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
	protected GraduationCriteria removeImpl(
		GraduationCriteria graduationCriteria) throws SystemException {
		graduationCriteria = toUnwrappedModel(graduationCriteria);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(graduationCriteria)) {
				graduationCriteria = (GraduationCriteria)session.get(GraduationCriteriaImpl.class,
						graduationCriteria.getPrimaryKeyObj());
			}

			if (graduationCriteria != null) {
				session.delete(graduationCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (graduationCriteria != null) {
			clearCache(graduationCriteria);
		}

		return graduationCriteria;
	}

	@Override
	public GraduationCriteria updateImpl(
		com.sambaash.platform.srv.model.GraduationCriteria graduationCriteria)
		throws SystemException {
		graduationCriteria = toUnwrappedModel(graduationCriteria);

		boolean isNew = graduationCriteria.isNew();

		GraduationCriteriaModelImpl graduationCriteriaModelImpl = (GraduationCriteriaModelImpl)graduationCriteria;

		Session session = null;

		try {
			session = openSession();

			if (graduationCriteria.isNew()) {
				session.save(graduationCriteria);

				graduationCriteria.setNew(false);
			}
			else {
				session.merge(graduationCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GraduationCriteriaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((graduationCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						graduationCriteriaModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { graduationCriteriaModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((graduationCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						graduationCriteriaModelImpl.getOriginalSpCourseId(),
						graduationCriteriaModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						graduationCriteriaModelImpl.getSpCourseId(),
						graduationCriteriaModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			GraduationCriteriaImpl.class, graduationCriteria.getPrimaryKey(),
			graduationCriteria);

		return graduationCriteria;
	}

	protected GraduationCriteria toUnwrappedModel(
		GraduationCriteria graduationCriteria) {
		if (graduationCriteria instanceof GraduationCriteriaImpl) {
			return graduationCriteria;
		}

		GraduationCriteriaImpl graduationCriteriaImpl = new GraduationCriteriaImpl();

		graduationCriteriaImpl.setNew(graduationCriteria.isNew());
		graduationCriteriaImpl.setPrimaryKey(graduationCriteria.getPrimaryKey());

		graduationCriteriaImpl.setSpGraduationCriteriaId(graduationCriteria.getSpGraduationCriteriaId());
		graduationCriteriaImpl.setGroupId(graduationCriteria.getGroupId());
		graduationCriteriaImpl.setCompanyId(graduationCriteria.getCompanyId());
		graduationCriteriaImpl.setUserId(graduationCriteria.getUserId());
		graduationCriteriaImpl.setUserName(graduationCriteria.getUserName());
		graduationCriteriaImpl.setCreateDate(graduationCriteria.getCreateDate());
		graduationCriteriaImpl.setModifiedDate(graduationCriteria.getModifiedDate());
		graduationCriteriaImpl.setCriteriaType(graduationCriteria.getCriteriaType());
		graduationCriteriaImpl.setCriteriaLevel(graduationCriteria.getCriteriaLevel());
		graduationCriteriaImpl.setCriteriaValueRange(graduationCriteria.getCriteriaValueRange());
		graduationCriteriaImpl.setCriteriaDesc(graduationCriteria.getCriteriaDesc());
		graduationCriteriaImpl.setSpCourseId(graduationCriteria.getSpCourseId());

		return graduationCriteriaImpl;
	}

	/**
	 * Returns the graduation criteria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the graduation criteria
	 * @return the graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGraduationCriteriaException, SystemException {
		GraduationCriteria graduationCriteria = fetchByPrimaryKey(primaryKey);

		if (graduationCriteria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGraduationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return graduationCriteria;
	}

	/**
	 * Returns the graduation criteria with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchGraduationCriteriaException} if it could not be found.
	 *
	 * @param spGraduationCriteriaId the primary key of the graduation criteria
	 * @return the graduation criteria
	 * @throws com.sambaash.platform.srv.NoSuchGraduationCriteriaException if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria findByPrimaryKey(long spGraduationCriteriaId)
		throws NoSuchGraduationCriteriaException, SystemException {
		return findByPrimaryKey((Serializable)spGraduationCriteriaId);
	}

	/**
	 * Returns the graduation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the graduation criteria
	 * @return the graduation criteria, or <code>null</code> if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GraduationCriteria graduationCriteria = (GraduationCriteria)EntityCacheUtil.getResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				GraduationCriteriaImpl.class, primaryKey);

		if (graduationCriteria == _nullGraduationCriteria) {
			return null;
		}

		if (graduationCriteria == null) {
			Session session = null;

			try {
				session = openSession();

				graduationCriteria = (GraduationCriteria)session.get(GraduationCriteriaImpl.class,
						primaryKey);

				if (graduationCriteria != null) {
					cacheResult(graduationCriteria);
				}
				else {
					EntityCacheUtil.putResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						GraduationCriteriaImpl.class, primaryKey,
						_nullGraduationCriteria);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GraduationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
					GraduationCriteriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return graduationCriteria;
	}

	/**
	 * Returns the graduation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spGraduationCriteriaId the primary key of the graduation criteria
	 * @return the graduation criteria, or <code>null</code> if a graduation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GraduationCriteria fetchByPrimaryKey(long spGraduationCriteriaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spGraduationCriteriaId);
	}

	/**
	 * Returns all the graduation criterias.
	 *
	 * @return the graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the graduation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @return the range of graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the graduation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.GraduationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduation criterias
	 * @param end the upper bound of the range of graduation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of graduation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GraduationCriteria> findAll(int start, int end,
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

		List<GraduationCriteria> list = (List<GraduationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GRADUATIONCRITERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GRADUATIONCRITERIA;

				if (pagination) {
					sql = sql.concat(GraduationCriteriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GraduationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GraduationCriteria>(list);
				}
				else {
					list = (List<GraduationCriteria>)QueryUtil.list(q,
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
	 * Removes all the graduation criterias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GraduationCriteria graduationCriteria : findAll()) {
			remove(graduationCriteria);
		}
	}

	/**
	 * Returns the number of graduation criterias.
	 *
	 * @return the number of graduation criterias
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

				Query q = session.createQuery(_SQL_COUNT_GRADUATIONCRITERIA);

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
	 * Initializes the graduation criteria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.GraduationCriteria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GraduationCriteria>> listenersList = new ArrayList<ModelListener<GraduationCriteria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GraduationCriteria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GraduationCriteriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GRADUATIONCRITERIA = "SELECT graduationCriteria FROM GraduationCriteria graduationCriteria";
	private static final String _SQL_SELECT_GRADUATIONCRITERIA_WHERE = "SELECT graduationCriteria FROM GraduationCriteria graduationCriteria WHERE ";
	private static final String _SQL_COUNT_GRADUATIONCRITERIA = "SELECT COUNT(graduationCriteria) FROM GraduationCriteria graduationCriteria";
	private static final String _SQL_COUNT_GRADUATIONCRITERIA_WHERE = "SELECT COUNT(graduationCriteria) FROM GraduationCriteria graduationCriteria WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "graduationCriteria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GraduationCriteria exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GraduationCriteria exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GraduationCriteriaPersistenceImpl.class);
	private static GraduationCriteria _nullGraduationCriteria = new GraduationCriteriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GraduationCriteria> toCacheModel() {
				return _nullGraduationCriteriaCacheModel;
			}
		};

	private static CacheModel<GraduationCriteria> _nullGraduationCriteriaCacheModel =
		new CacheModel<GraduationCriteria>() {
			@Override
			public GraduationCriteria toEntityModel() {
				return _nullGraduationCriteria;
			}
		};
}