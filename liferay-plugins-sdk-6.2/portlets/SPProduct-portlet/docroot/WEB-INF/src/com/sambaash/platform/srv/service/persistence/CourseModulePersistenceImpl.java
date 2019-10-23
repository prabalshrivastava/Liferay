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

import com.sambaash.platform.srv.NoSuchCourseModuleException;
import com.sambaash.platform.srv.model.CourseModule;
import com.sambaash.platform.srv.model.impl.CourseModuleImpl;
import com.sambaash.platform.srv.model.impl.CourseModuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseModulePersistence
 * @see CourseModuleUtil
 * @generated
 */
public class CourseModulePersistenceImpl extends BasePersistenceImpl<CourseModule>
	implements CourseModulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseModuleUtil} to access the course module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseModuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CourseModuleModelImpl.GROUPID_COLUMN_BITMASK |
			CourseModuleModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course modules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course modules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @return the range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course modules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<CourseModule> list = (List<CourseModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseModule courseModule : list) {
				if ((groupId != courseModule.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSEMODULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseModule>(list);
				}
				else {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first course module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByGroupId_First(groupId,
				orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the first course module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseModule> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the last course module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CourseModule> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course modules before and after the current course module in the ordered set where groupId = &#63;.
	 *
	 * @param spCourseModuleId the primary key of the current course module
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule[] findByGroupId_PrevAndNext(long spCourseModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = findByPrimaryKey(spCourseModuleId);

		Session session = null;

		try {
			session = openSession();

			CourseModule[] array = new CourseModuleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, courseModule, groupId,
					orderByComparator, true);

			array[1] = courseModule;

			array[2] = getByGroupId_PrevAndNext(session, courseModule, groupId,
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

	protected CourseModule getByGroupId_PrevAndNext(Session session,
		CourseModule courseModule, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEMODULE_WHERE);

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
			query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseModule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseModule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course modules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (CourseModule courseModule : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseModule);
		}
	}

	/**
	 * Returns the number of course modules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching course modules
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

			query.append(_SQL_COUNT_COURSEMODULE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "courseModule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModuleIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseModuleModelImpl.SPMODULEID_COLUMN_BITMASK |
			CourseModuleModelImpl.GROUPID_COLUMN_BITMASK |
			CourseModuleModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course modules where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByModuleIdAndGroupId(long spModuleId,
		long groupId) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course modules where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @return the range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course modules where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] { spModuleId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] {
					spModuleId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CourseModule> list = (List<CourseModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseModule courseModule : list) {
				if ((spModuleId != courseModule.getSpModuleId()) ||
						(groupId != courseModule.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSEMODULE_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseModule>(list);
				}
				else {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByModuleIdAndGroupId_First(spModuleId,
				groupId, orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the first course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseModule> list = findByModuleIdAndGroupId(spModuleId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByModuleIdAndGroupId_Last(spModuleId,
				groupId, orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the last course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByModuleIdAndGroupId(spModuleId, groupId);

		if (count == 0) {
			return null;
		}

		List<CourseModule> list = findByModuleIdAndGroupId(spModuleId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course modules before and after the current course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseModuleId the primary key of the current course module
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule[] findByModuleIdAndGroupId_PrevAndNext(
		long spCourseModuleId, long spModuleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = findByPrimaryKey(spCourseModuleId);

		Session session = null;

		try {
			session = openSession();

			CourseModule[] array = new CourseModuleImpl[3];

			array[0] = getByModuleIdAndGroupId_PrevAndNext(session,
					courseModule, spModuleId, groupId, orderByComparator, true);

			array[1] = courseModule;

			array[2] = getByModuleIdAndGroupId_PrevAndNext(session,
					courseModule, spModuleId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseModule getByModuleIdAndGroupId_PrevAndNext(
		Session session, CourseModule courseModule, long spModuleId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEMODULE_WHERE);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

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
			query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spModuleId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseModule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseModule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course modules where spModuleId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		for (CourseModule courseModule : findByModuleIdAndGroupId(spModuleId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseModule);
		}
	}

	/**
	 * Returns the number of course modules where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the number of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spModuleId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEMODULE_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

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

	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2 = "courseModule.spModuleId = ? AND ";
	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2 = "courseModule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, CourseModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseModuleModelImpl.SPCOURSEID_COLUMN_BITMASK |
			CourseModuleModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course modules where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course modules where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @return the range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course modules where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findByCourseIdAndGroupId(long spCourseId,
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

		List<CourseModule> list = (List<CourseModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseModule courseModule : list) {
				if ((spCourseId != courseModule.getSpCourseId()) ||
						(groupId != courseModule.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSEMODULE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
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
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseModule>(list);
				}
				else {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the first course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseModule> list = findByCourseIdAndGroupId(spCourseId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (courseModule != null) {
			return courseModule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseModuleException(msg.toString());
	}

	/**
	 * Returns the last course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course module, or <code>null</code> if a matching course module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<CourseModule> list = findByCourseIdAndGroupId(spCourseId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course modules before and after the current course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseModuleId the primary key of the current course module
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule[] findByCourseIdAndGroupId_PrevAndNext(
		long spCourseModuleId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = findByPrimaryKey(spCourseModuleId);

		Session session = null;

		try {
			session = openSession();

			CourseModule[] array = new CourseModuleImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseModule, spCourseId, groupId, orderByComparator, true);

			array[1] = courseModule;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseModule, spCourseId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseModule getByCourseIdAndGroupId_PrevAndNext(
		Session session, CourseModule courseModule, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEMODULE_WHERE);

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
			query.append(CourseModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseModule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseModule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course modules where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (CourseModule courseModule : findByCourseIdAndGroupId(spCourseId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseModule);
		}
	}

	/**
	 * Returns the number of course modules where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching course modules
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

			query.append(_SQL_COUNT_COURSEMODULE_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "courseModule.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "courseModule.groupId = ?";

	public CourseModulePersistenceImpl() {
		setModelClass(CourseModule.class);
	}

	/**
	 * Caches the course module in the entity cache if it is enabled.
	 *
	 * @param courseModule the course module
	 */
	@Override
	public void cacheResult(CourseModule courseModule) {
		EntityCacheUtil.putResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleImpl.class, courseModule.getPrimaryKey(), courseModule);

		courseModule.resetOriginalValues();
	}

	/**
	 * Caches the course modules in the entity cache if it is enabled.
	 *
	 * @param courseModules the course modules
	 */
	@Override
	public void cacheResult(List<CourseModule> courseModules) {
		for (CourseModule courseModule : courseModules) {
			if (EntityCacheUtil.getResult(
						CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
						CourseModuleImpl.class, courseModule.getPrimaryKey()) == null) {
				cacheResult(courseModule);
			}
			else {
				courseModule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course modules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseModuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseModuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course module.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseModule courseModule) {
		EntityCacheUtil.removeResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleImpl.class, courseModule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseModule> courseModules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseModule courseModule : courseModules) {
			EntityCacheUtil.removeResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
				CourseModuleImpl.class, courseModule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course module with the primary key. Does not add the course module to the database.
	 *
	 * @param spCourseModuleId the primary key for the new course module
	 * @return the new course module
	 */
	@Override
	public CourseModule create(long spCourseModuleId) {
		CourseModule courseModule = new CourseModuleImpl();

		courseModule.setNew(true);
		courseModule.setPrimaryKey(spCourseModuleId);

		return courseModule;
	}

	/**
	 * Removes the course module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseModuleId the primary key of the course module
	 * @return the course module that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule remove(long spCourseModuleId)
		throws NoSuchCourseModuleException, SystemException {
		return remove((Serializable)spCourseModuleId);
	}

	/**
	 * Removes the course module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course module
	 * @return the course module that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule remove(Serializable primaryKey)
		throws NoSuchCourseModuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseModule courseModule = (CourseModule)session.get(CourseModuleImpl.class,
					primaryKey);

			if (courseModule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseModule);
		}
		catch (NoSuchCourseModuleException nsee) {
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
	protected CourseModule removeImpl(CourseModule courseModule)
		throws SystemException {
		courseModule = toUnwrappedModel(courseModule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseModule)) {
				courseModule = (CourseModule)session.get(CourseModuleImpl.class,
						courseModule.getPrimaryKeyObj());
			}

			if (courseModule != null) {
				session.delete(courseModule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseModule != null) {
			clearCache(courseModule);
		}

		return courseModule;
	}

	@Override
	public CourseModule updateImpl(
		com.sambaash.platform.srv.model.CourseModule courseModule)
		throws SystemException {
		courseModule = toUnwrappedModel(courseModule);

		boolean isNew = courseModule.isNew();

		CourseModuleModelImpl courseModuleModelImpl = (CourseModuleModelImpl)courseModule;

		Session session = null;

		try {
			session = openSession();

			if (courseModule.isNew()) {
				session.save(courseModule);

				courseModule.setNew(false);
			}
			else {
				session.merge(courseModule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseModuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseModuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModuleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { courseModuleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((courseModuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModuleModelImpl.getOriginalSpModuleId(),
						courseModuleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);

				args = new Object[] {
						courseModuleModelImpl.getSpModuleId(),
						courseModuleModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);
			}

			if ((courseModuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseModuleModelImpl.getOriginalSpCourseId(),
						courseModuleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						courseModuleModelImpl.getSpCourseId(),
						courseModuleModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
			CourseModuleImpl.class, courseModule.getPrimaryKey(), courseModule);

		return courseModule;
	}

	protected CourseModule toUnwrappedModel(CourseModule courseModule) {
		if (courseModule instanceof CourseModuleImpl) {
			return courseModule;
		}

		CourseModuleImpl courseModuleImpl = new CourseModuleImpl();

		courseModuleImpl.setNew(courseModule.isNew());
		courseModuleImpl.setPrimaryKey(courseModule.getPrimaryKey());

		courseModuleImpl.setSpCourseModuleId(courseModule.getSpCourseModuleId());
		courseModuleImpl.setGroupId(courseModule.getGroupId());
		courseModuleImpl.setCompanyId(courseModule.getCompanyId());
		courseModuleImpl.setUserId(courseModule.getUserId());
		courseModuleImpl.setUserName(courseModule.getUserName());
		courseModuleImpl.setCreateDate(courseModule.getCreateDate());
		courseModuleImpl.setModifiedDate(courseModule.getModifiedDate());
		courseModuleImpl.setSpCourseId(courseModule.getSpCourseId());
		courseModuleImpl.setSpModuleId(courseModule.getSpModuleId());

		return courseModuleImpl;
	}

	/**
	 * Returns the course module with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course module
	 * @return the course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseModuleException, SystemException {
		CourseModule courseModule = fetchByPrimaryKey(primaryKey);

		if (courseModule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseModule;
	}

	/**
	 * Returns the course module with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseModuleException} if it could not be found.
	 *
	 * @param spCourseModuleId the primary key of the course module
	 * @return the course module
	 * @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule findByPrimaryKey(long spCourseModuleId)
		throws NoSuchCourseModuleException, SystemException {
		return findByPrimaryKey((Serializable)spCourseModuleId);
	}

	/**
	 * Returns the course module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course module
	 * @return the course module, or <code>null</code> if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseModule courseModule = (CourseModule)EntityCacheUtil.getResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
				CourseModuleImpl.class, primaryKey);

		if (courseModule == _nullCourseModule) {
			return null;
		}

		if (courseModule == null) {
			Session session = null;

			try {
				session = openSession();

				courseModule = (CourseModule)session.get(CourseModuleImpl.class,
						primaryKey);

				if (courseModule != null) {
					cacheResult(courseModule);
				}
				else {
					EntityCacheUtil.putResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
						CourseModuleImpl.class, primaryKey, _nullCourseModule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseModuleModelImpl.ENTITY_CACHE_ENABLED,
					CourseModuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseModule;
	}

	/**
	 * Returns the course module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseModuleId the primary key of the course module
	 * @return the course module, or <code>null</code> if a course module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseModule fetchByPrimaryKey(long spCourseModuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseModuleId);
	}

	/**
	 * Returns all the course modules.
	 *
	 * @return the course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @return the range of course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course modules
	 * @param end the upper bound of the range of course modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseModule> findAll(int start, int end,
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

		List<CourseModule> list = (List<CourseModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEMODULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEMODULE;

				if (pagination) {
					sql = sql.concat(CourseModuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseModule>(list);
				}
				else {
					list = (List<CourseModule>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the course modules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseModule courseModule : findAll()) {
			remove(courseModule);
		}
	}

	/**
	 * Returns the number of course modules.
	 *
	 * @return the number of course modules
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

				Query q = session.createQuery(_SQL_COUNT_COURSEMODULE);

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
	 * Initializes the course module persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseModule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseModule>> listenersList = new ArrayList<ModelListener<CourseModule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseModule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseModuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEMODULE = "SELECT courseModule FROM CourseModule courseModule";
	private static final String _SQL_SELECT_COURSEMODULE_WHERE = "SELECT courseModule FROM CourseModule courseModule WHERE ";
	private static final String _SQL_COUNT_COURSEMODULE = "SELECT COUNT(courseModule) FROM CourseModule courseModule";
	private static final String _SQL_COUNT_COURSEMODULE_WHERE = "SELECT COUNT(courseModule) FROM CourseModule courseModule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseModule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseModule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseModule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseModulePersistenceImpl.class);
	private static CourseModule _nullCourseModule = new CourseModuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseModule> toCacheModel() {
				return _nullCourseModuleCacheModel;
			}
		};

	private static CacheModel<CourseModule> _nullCourseModuleCacheModel = new CacheModel<CourseModule>() {
			@Override
			public CourseModule toEntityModel() {
				return _nullCourseModule;
			}
		};
}