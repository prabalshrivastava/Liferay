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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchFrameworkException;
import com.sambaash.platform.srv.model.Framework;
import com.sambaash.platform.srv.model.impl.FrameworkImpl;
import com.sambaash.platform.srv.model.impl.FrameworkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the framework service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FrameworkPersistence
 * @see FrameworkUtil
 * @generated
 */
public class FrameworkPersistenceImpl extends BasePersistenceImpl<Framework>
	implements FrameworkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FrameworkUtil} to access the framework persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FrameworkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FrameworkModelImpl.GROUPID_COLUMN_BITMASK |
			FrameworkModelImpl.FRAMEWORKNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the frameworks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the frameworks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @return the range of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the frameworks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByGroupId(long groupId, int start, int end,
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

		List<Framework> list = (List<Framework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Framework framework : list) {
				if ((groupId != framework.getGroupId())) {
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

			query.append(_SQL_SELECT_FRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FrameworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Framework>(list);
				}
				else {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByGroupId_First(groupId, orderByComparator);

		if (framework != null) {
			return framework;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFrameworkException(msg.toString());
	}

	/**
	 * Returns the first framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Framework> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByGroupId_Last(groupId, orderByComparator);

		if (framework != null) {
			return framework;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFrameworkException(msg.toString());
	}

	/**
	 * Returns the last framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Framework> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the frameworks before and after the current framework in the ordered set where groupId = &#63;.
	 *
	 * @param spFrameworkId the primary key of the current framework
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework[] findByGroupId_PrevAndNext(long spFrameworkId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = findByPrimaryKey(spFrameworkId);

		Session session = null;

		try {
			session = openSession();

			Framework[] array = new FrameworkImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, framework, groupId,
					orderByComparator, true);

			array[1] = framework;

			array[2] = getByGroupId_PrevAndNext(session, framework, groupId,
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

	protected Framework getByGroupId_PrevAndNext(Session session,
		Framework framework, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FRAMEWORK_WHERE);

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
			query.append(FrameworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(framework);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Framework> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the frameworks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Framework framework : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(framework);
		}
	}

	/**
	 * Returns the number of frameworks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching frameworks
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

			query.append(_SQL_COUNT_FRAMEWORK_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "framework.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FrameworkModelImpl.COUNTRYID_COLUMN_BITMASK |
			FrameworkModelImpl.GROUPID_COLUMN_BITMASK |
			FrameworkModelImpl.FRAMEWORKNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the frameworks where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByCountryIdAndGroupId(long countryId,
		long groupId) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the frameworks where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @return the range of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the frameworks where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findByCountryIdAndGroupId(long countryId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] { countryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] {
					countryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Framework> list = (List<Framework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Framework framework : list) {
				if ((countryId != framework.getCountryId()) ||
						(groupId != framework.getGroupId())) {
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

			query.append(_SQL_SELECT_FRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FrameworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Framework>(list);
				}
				else {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first framework in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByCountryIdAndGroupId_First(countryId,
				groupId, orderByComparator);

		if (framework != null) {
			return framework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFrameworkException(msg.toString());
	}

	/**
	 * Returns the first framework in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Framework> list = findByCountryIdAndGroupId(countryId, groupId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last framework in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByCountryIdAndGroupId_Last(countryId,
				groupId, orderByComparator);

		if (framework != null) {
			return framework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFrameworkException(msg.toString());
	}

	/**
	 * Returns the last framework in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByCountryIdAndGroupId_Last(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryIdAndGroupId(countryId, groupId);

		if (count == 0) {
			return null;
		}

		List<Framework> list = findByCountryIdAndGroupId(countryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the frameworks before and after the current framework in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the primary key of the current framework
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework[] findByCountryIdAndGroupId_PrevAndNext(
		long spFrameworkId, long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = findByPrimaryKey(spFrameworkId);

		Session session = null;

		try {
			session = openSession();

			Framework[] array = new FrameworkImpl[3];

			array[0] = getByCountryIdAndGroupId_PrevAndNext(session, framework,
					countryId, groupId, orderByComparator, true);

			array[1] = framework;

			array[2] = getByCountryIdAndGroupId_PrevAndNext(session, framework,
					countryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Framework getByCountryIdAndGroupId_PrevAndNext(Session session,
		Framework framework, long countryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FRAMEWORK_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

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
			query.append(FrameworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(framework);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Framework> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the frameworks where countryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		for (Framework framework : findByCountryIdAndGroupId(countryId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(framework);
		}
	}

	/**
	 * Returns the number of frameworks where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the number of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID;

		Object[] finderArgs = new Object[] { countryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2 = "framework.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2 = "framework.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDGROUPID = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameAndGroupId",
			new String[] { String.class.getName(), Long.class.getName() },
			FrameworkModelImpl.FRAMEWORKNAME_COLUMN_BITMASK |
			FrameworkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDGROUPID = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameAndGroupId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the framework where frameworkName = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	 *
	 * @param frameworkName the framework name
	 * @param groupId the group ID
	 * @return the matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByNameAndGroupId(String frameworkName, long groupId)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByNameAndGroupId(frameworkName, groupId);

		if (framework == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("frameworkName=");
			msg.append(frameworkName);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFrameworkException(msg.toString());
		}

		return framework;
	}

	/**
	 * Returns the framework where frameworkName = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param frameworkName the framework name
	 * @param groupId the group ID
	 * @return the matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByNameAndGroupId(String frameworkName, long groupId)
		throws SystemException {
		return fetchByNameAndGroupId(frameworkName, groupId, true);
	}

	/**
	 * Returns the framework where frameworkName = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param frameworkName the framework name
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByNameAndGroupId(String frameworkName, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { frameworkName, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
					finderArgs, this);
		}

		if (result instanceof Framework) {
			Framework framework = (Framework)result;

			if (!Validator.equals(frameworkName, framework.getFrameworkName()) ||
					(groupId != framework.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FRAMEWORK_WHERE);

			boolean bindFrameworkName = false;

			if (frameworkName == null) {
				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_1);
			}
			else if (frameworkName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_3);
			}
			else {
				bindFrameworkName = true;

				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFrameworkName) {
					qPos.add(frameworkName.toLowerCase());
				}

				qPos.add(groupId);

				List<Framework> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FrameworkPersistenceImpl.fetchByNameAndGroupId(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Framework framework = list.get(0);

					result = framework;

					cacheResult(framework);

					if ((framework.getFrameworkName() == null) ||
							!framework.getFrameworkName().equals(frameworkName) ||
							(framework.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
							finderArgs, framework);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
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
			return (Framework)result;
		}
	}

	/**
	 * Removes the framework where frameworkName = &#63; and groupId = &#63; from the database.
	 *
	 * @param frameworkName the framework name
	 * @param groupId the group ID
	 * @return the framework that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework removeByNameAndGroupId(String frameworkName, long groupId)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = findByNameAndGroupId(frameworkName, groupId);

		return remove(framework);
	}

	/**
	 * Returns the number of frameworks where frameworkName = &#63; and groupId = &#63;.
	 *
	 * @param frameworkName the framework name
	 * @param groupId the group ID
	 * @return the number of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndGroupId(String frameworkName, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDGROUPID;

		Object[] finderArgs = new Object[] { frameworkName, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FRAMEWORK_WHERE);

			boolean bindFrameworkName = false;

			if (frameworkName == null) {
				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_1);
			}
			else if (frameworkName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_3);
			}
			else {
				bindFrameworkName = true;

				query.append(_FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFrameworkName) {
					qPos.add(frameworkName.toLowerCase());
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

	private static final String _FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_1 = "framework.frameworkName IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_2 = "lower(framework.frameworkName) = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDGROUPID_FRAMEWORKNAME_3 = "(framework.frameworkName IS NULL OR framework.frameworkName = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2 = "framework.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FRAMEWORKCODE = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, FrameworkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFrameworkCode",
			new String[] { String.class.getName() },
			FrameworkModelImpl.FRAMEWORKCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FRAMEWORKCODE = new FinderPath(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFrameworkCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the framework where frameworkCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	 *
	 * @param frameworkCode the framework code
	 * @return the matching framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByFrameworkCode(String frameworkCode)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByFrameworkCode(frameworkCode);

		if (framework == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("frameworkCode=");
			msg.append(frameworkCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFrameworkException(msg.toString());
		}

		return framework;
	}

	/**
	 * Returns the framework where frameworkCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param frameworkCode the framework code
	 * @return the matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByFrameworkCode(String frameworkCode)
		throws SystemException {
		return fetchByFrameworkCode(frameworkCode, true);
	}

	/**
	 * Returns the framework where frameworkCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param frameworkCode the framework code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching framework, or <code>null</code> if a matching framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByFrameworkCode(String frameworkCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { frameworkCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
					finderArgs, this);
		}

		if (result instanceof Framework) {
			Framework framework = (Framework)result;

			if (!Validator.equals(frameworkCode, framework.getFrameworkCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FRAMEWORK_WHERE);

			boolean bindFrameworkCode = false;

			if (frameworkCode == null) {
				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_1);
			}
			else if (frameworkCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_3);
			}
			else {
				bindFrameworkCode = true;

				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFrameworkCode) {
					qPos.add(frameworkCode.toLowerCase());
				}

				List<Framework> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FrameworkPersistenceImpl.fetchByFrameworkCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Framework framework = list.get(0);

					result = framework;

					cacheResult(framework);

					if ((framework.getFrameworkCode() == null) ||
							!framework.getFrameworkCode().equals(frameworkCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
							finderArgs, framework);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
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
			return (Framework)result;
		}
	}

	/**
	 * Removes the framework where frameworkCode = &#63; from the database.
	 *
	 * @param frameworkCode the framework code
	 * @return the framework that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework removeByFrameworkCode(String frameworkCode)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = findByFrameworkCode(frameworkCode);

		return remove(framework);
	}

	/**
	 * Returns the number of frameworks where frameworkCode = &#63;.
	 *
	 * @param frameworkCode the framework code
	 * @return the number of matching frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFrameworkCode(String frameworkCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FRAMEWORKCODE;

		Object[] finderArgs = new Object[] { frameworkCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FRAMEWORK_WHERE);

			boolean bindFrameworkCode = false;

			if (frameworkCode == null) {
				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_1);
			}
			else if (frameworkCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_3);
			}
			else {
				bindFrameworkCode = true;

				query.append(_FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFrameworkCode) {
					qPos.add(frameworkCode.toLowerCase());
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

	private static final String _FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_1 = "framework.frameworkCode IS NULL";
	private static final String _FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_2 = "lower(framework.frameworkCode) = ?";
	private static final String _FINDER_COLUMN_FRAMEWORKCODE_FRAMEWORKCODE_3 = "(framework.frameworkCode IS NULL OR framework.frameworkCode = '')";

	public FrameworkPersistenceImpl() {
		setModelClass(Framework.class);
	}

	/**
	 * Caches the framework in the entity cache if it is enabled.
	 *
	 * @param framework the framework
	 */
	@Override
	public void cacheResult(Framework framework) {
		EntityCacheUtil.putResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkImpl.class, framework.getPrimaryKey(), framework);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
			new Object[] { framework.getFrameworkName(), framework.getGroupId() },
			framework);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
			new Object[] { framework.getFrameworkCode() }, framework);

		framework.resetOriginalValues();
	}

	/**
	 * Caches the frameworks in the entity cache if it is enabled.
	 *
	 * @param frameworks the frameworks
	 */
	@Override
	public void cacheResult(List<Framework> frameworks) {
		for (Framework framework : frameworks) {
			if (EntityCacheUtil.getResult(
						FrameworkModelImpl.ENTITY_CACHE_ENABLED,
						FrameworkImpl.class, framework.getPrimaryKey()) == null) {
				cacheResult(framework);
			}
			else {
				framework.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all frameworks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FrameworkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FrameworkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the framework.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Framework framework) {
		EntityCacheUtil.removeResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkImpl.class, framework.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(framework);
	}

	@Override
	public void clearCache(List<Framework> frameworks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Framework framework : frameworks) {
			EntityCacheUtil.removeResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
				FrameworkImpl.class, framework.getPrimaryKey());

			clearUniqueFindersCache(framework);
		}
	}

	protected void cacheUniqueFindersCache(Framework framework) {
		if (framework.isNew()) {
			Object[] args = new Object[] {
					framework.getFrameworkName(), framework.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
				args, framework);

			args = new Object[] { framework.getFrameworkCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FRAMEWORKCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE, args,
				framework);
		}
		else {
			FrameworkModelImpl frameworkModelImpl = (FrameworkModelImpl)framework;

			if ((frameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						framework.getFrameworkName(), framework.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
					args, framework);
			}

			if ((frameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FRAMEWORKCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { framework.getFrameworkCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FRAMEWORKCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
					args, framework);
			}
		}
	}

	protected void clearUniqueFindersCache(Framework framework) {
		FrameworkModelImpl frameworkModelImpl = (FrameworkModelImpl)framework;

		Object[] args = new Object[] {
				framework.getFrameworkName(), framework.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID, args);

		if ((frameworkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					frameworkModelImpl.getOriginalFrameworkName(),
					frameworkModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
				args);
		}

		args = new Object[] { framework.getFrameworkCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FRAMEWORKCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE, args);

		if ((frameworkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FRAMEWORKCODE.getColumnBitmask()) != 0) {
			args = new Object[] { frameworkModelImpl.getOriginalFrameworkCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FRAMEWORKCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FRAMEWORKCODE,
				args);
		}
	}

	/**
	 * Creates a new framework with the primary key. Does not add the framework to the database.
	 *
	 * @param spFrameworkId the primary key for the new framework
	 * @return the new framework
	 */
	@Override
	public Framework create(long spFrameworkId) {
		Framework framework = new FrameworkImpl();

		framework.setNew(true);
		framework.setPrimaryKey(spFrameworkId);

		return framework;
	}

	/**
	 * Removes the framework with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFrameworkId the primary key of the framework
	 * @return the framework that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework remove(long spFrameworkId)
		throws NoSuchFrameworkException, SystemException {
		return remove((Serializable)spFrameworkId);
	}

	/**
	 * Removes the framework with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the framework
	 * @return the framework that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework remove(Serializable primaryKey)
		throws NoSuchFrameworkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Framework framework = (Framework)session.get(FrameworkImpl.class,
					primaryKey);

			if (framework == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFrameworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(framework);
		}
		catch (NoSuchFrameworkException nsee) {
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
	protected Framework removeImpl(Framework framework)
		throws SystemException {
		framework = toUnwrappedModel(framework);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(framework)) {
				framework = (Framework)session.get(FrameworkImpl.class,
						framework.getPrimaryKeyObj());
			}

			if (framework != null) {
				session.delete(framework);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (framework != null) {
			clearCache(framework);
		}

		return framework;
	}

	@Override
	public Framework updateImpl(
		com.sambaash.platform.srv.model.Framework framework)
		throws SystemException {
		framework = toUnwrappedModel(framework);

		boolean isNew = framework.isNew();

		FrameworkModelImpl frameworkModelImpl = (FrameworkModelImpl)framework;

		Session session = null;

		try {
			session = openSession();

			if (framework.isNew()) {
				session.save(framework);

				framework.setNew(false);
			}
			else {
				session.merge(framework);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FrameworkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((frameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						frameworkModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { frameworkModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((frameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						frameworkModelImpl.getOriginalCountryId(),
						frameworkModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);

				args = new Object[] {
						frameworkModelImpl.getCountryId(),
						frameworkModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
			FrameworkImpl.class, framework.getPrimaryKey(), framework);

		clearUniqueFindersCache(framework);
		cacheUniqueFindersCache(framework);

		return framework;
	}

	protected Framework toUnwrappedModel(Framework framework) {
		if (framework instanceof FrameworkImpl) {
			return framework;
		}

		FrameworkImpl frameworkImpl = new FrameworkImpl();

		frameworkImpl.setNew(framework.isNew());
		frameworkImpl.setPrimaryKey(framework.getPrimaryKey());

		frameworkImpl.setSpFrameworkId(framework.getSpFrameworkId());
		frameworkImpl.setGroupId(framework.getGroupId());
		frameworkImpl.setCompanyId(framework.getCompanyId());
		frameworkImpl.setUserId(framework.getUserId());
		frameworkImpl.setUserName(framework.getUserName());
		frameworkImpl.setCreateDate(framework.getCreateDate());
		frameworkImpl.setModifiedDate(framework.getModifiedDate());
		frameworkImpl.setCountryId(framework.getCountryId());
		frameworkImpl.setFrameworkCode(framework.getFrameworkCode());
		frameworkImpl.setFrameworkName(framework.getFrameworkName());
		frameworkImpl.setFrameworkImageId(framework.getFrameworkImageId());

		return frameworkImpl;
	}

	/**
	 * Returns the framework with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the framework
	 * @return the framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFrameworkException, SystemException {
		Framework framework = fetchByPrimaryKey(primaryKey);

		if (framework == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFrameworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return framework;
	}

	/**
	 * Returns the framework with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFrameworkException} if it could not be found.
	 *
	 * @param spFrameworkId the primary key of the framework
	 * @return the framework
	 * @throws com.sambaash.platform.srv.NoSuchFrameworkException if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework findByPrimaryKey(long spFrameworkId)
		throws NoSuchFrameworkException, SystemException {
		return findByPrimaryKey((Serializable)spFrameworkId);
	}

	/**
	 * Returns the framework with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the framework
	 * @return the framework, or <code>null</code> if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Framework framework = (Framework)EntityCacheUtil.getResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
				FrameworkImpl.class, primaryKey);

		if (framework == _nullFramework) {
			return null;
		}

		if (framework == null) {
			Session session = null;

			try {
				session = openSession();

				framework = (Framework)session.get(FrameworkImpl.class,
						primaryKey);

				if (framework != null) {
					cacheResult(framework);
				}
				else {
					EntityCacheUtil.putResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
						FrameworkImpl.class, primaryKey, _nullFramework);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FrameworkModelImpl.ENTITY_CACHE_ENABLED,
					FrameworkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return framework;
	}

	/**
	 * Returns the framework with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFrameworkId the primary key of the framework
	 * @return the framework, or <code>null</code> if a framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Framework fetchByPrimaryKey(long spFrameworkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFrameworkId);
	}

	/**
	 * Returns all the frameworks.
	 *
	 * @return the frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the frameworks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @return the range of frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the frameworks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of frameworks
	 * @param end the upper bound of the range of frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Framework> findAll(int start, int end,
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

		List<Framework> list = (List<Framework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FRAMEWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FRAMEWORK;

				if (pagination) {
					sql = sql.concat(FrameworkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Framework>(list);
				}
				else {
					list = (List<Framework>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the frameworks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Framework framework : findAll()) {
			remove(framework);
		}
	}

	/**
	 * Returns the number of frameworks.
	 *
	 * @return the number of frameworks
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

				Query q = session.createQuery(_SQL_COUNT_FRAMEWORK);

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
	 * Initializes the framework persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Framework")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Framework>> listenersList = new ArrayList<ModelListener<Framework>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Framework>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FrameworkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FRAMEWORK = "SELECT framework FROM Framework framework";
	private static final String _SQL_SELECT_FRAMEWORK_WHERE = "SELECT framework FROM Framework framework WHERE ";
	private static final String _SQL_COUNT_FRAMEWORK = "SELECT COUNT(framework) FROM Framework framework";
	private static final String _SQL_COUNT_FRAMEWORK_WHERE = "SELECT COUNT(framework) FROM Framework framework WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "framework.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Framework exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Framework exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FrameworkPersistenceImpl.class);
	private static Framework _nullFramework = new FrameworkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Framework> toCacheModel() {
				return _nullFrameworkCacheModel;
			}
		};

	private static CacheModel<Framework> _nullFrameworkCacheModel = new CacheModel<Framework>() {
			@Override
			public Framework toEntityModel() {
				return _nullFramework;
			}
		};
}