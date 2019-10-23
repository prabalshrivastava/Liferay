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

import com.sambaash.platform.srv.NoSuchProductCourseException;
import com.sambaash.platform.srv.model.ProductCourse;
import com.sambaash.platform.srv.model.impl.ProductCourseImpl;
import com.sambaash.platform.srv.model.impl.ProductCourseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the product course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductCoursePersistence
 * @see ProductCourseUtil
 * @generated
 */
public class ProductCoursePersistenceImpl extends BasePersistenceImpl<ProductCourse>
	implements ProductCoursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductCourseUtil} to access the product course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductCourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			ProductCourseModelImpl.GROUPID_COLUMN_BITMASK |
			ProductCourseModelImpl.SPPRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the product courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @return the range of matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByGroupId(long groupId, int start, int end,
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

		List<ProductCourse> list = (List<ProductCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductCourse productCourse : list) {
				if ((groupId != productCourse.getGroupId())) {
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

			query.append(_SQL_SELECT_PRODUCTCOURSE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProductCourse>(list);
				}
				else {
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByGroupId_First(groupId,
				orderByComparator);

		if (productCourse != null) {
			return productCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductCourseException(msg.toString());
	}

	/**
	 * Returns the first product course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProductCourse> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (productCourse != null) {
			return productCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductCourseException(msg.toString());
	}

	/**
	 * Returns the last product course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ProductCourse> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product courses before and after the current product course in the ordered set where groupId = &#63;.
	 *
	 * @param spProductCourseId the primary key of the current product course
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse[] findByGroupId_PrevAndNext(long spProductCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = findByPrimaryKey(spProductCourseId);

		Session session = null;

		try {
			session = openSession();

			ProductCourse[] array = new ProductCourseImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, productCourse,
					groupId, orderByComparator, true);

			array[1] = productCourse;

			array[2] = getByGroupId_PrevAndNext(session, productCourse,
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

	protected ProductCourse getByGroupId_PrevAndNext(Session session,
		ProductCourse productCourse, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTCOURSE_WHERE);

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
			query.append(ProductCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productCourse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductCourse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product courses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ProductCourse productCourse : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(productCourse);
		}
	}

	/**
	 * Returns the number of product courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching product courses
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

			query.append(_SQL_COUNT_PRODUCTCOURSE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "productCourse.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByProductIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProductCourseModelImpl.SPPRODUCTID_COLUMN_BITMASK |
			ProductCourseModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the product course where spProductId = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchProductCourseException} if it could not be found.
	 *
	 * @param spProductId the sp product ID
	 * @param groupId the group ID
	 * @return the matching product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByProductIdAndGroupId(long spProductId,
		long groupId) throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByProductIdAndGroupId(spProductId,
				groupId);

		if (productCourse == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spProductId=");
			msg.append(spProductId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProductCourseException(msg.toString());
		}

		return productCourse;
	}

	/**
	 * Returns the product course where spProductId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spProductId the sp product ID
	 * @param groupId the group ID
	 * @return the matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByProductIdAndGroupId(long spProductId,
		long groupId) throws SystemException {
		return fetchByProductIdAndGroupId(spProductId, groupId, true);
	}

	/**
	 * Returns the product course where spProductId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spProductId the sp product ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByProductIdAndGroupId(long spProductId,
		long groupId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spProductId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
					finderArgs, this);
		}

		if (result instanceof ProductCourse) {
			ProductCourse productCourse = (ProductCourse)result;

			if ((spProductId != productCourse.getSpProductId()) ||
					(groupId != productCourse.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PRODUCTCOURSE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDANDGROUPID_SPPRODUCTID_2);

			query.append(_FINDER_COLUMN_PRODUCTIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spProductId);

				qPos.add(groupId);

				List<ProductCourse> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProductCoursePersistenceImpl.fetchByProductIdAndGroupId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ProductCourse productCourse = list.get(0);

					result = productCourse;

					cacheResult(productCourse);

					if ((productCourse.getSpProductId() != spProductId) ||
							(productCourse.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
							finderArgs, productCourse);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
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
			return (ProductCourse)result;
		}
	}

	/**
	 * Removes the product course where spProductId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spProductId the sp product ID
	 * @param groupId the group ID
	 * @return the product course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse removeByProductIdAndGroupId(long spProductId,
		long groupId) throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = findByProductIdAndGroupId(spProductId,
				groupId);

		return remove(productCourse);
	}

	/**
	 * Returns the number of product courses where spProductId = &#63; and groupId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @param groupId the group ID
	 * @return the number of matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductIdAndGroupId(long spProductId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID;

		Object[] finderArgs = new Object[] { spProductId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCTCOURSE_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDANDGROUPID_SPPRODUCTID_2);

			query.append(_FINDER_COLUMN_PRODUCTIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spProductId);

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

	private static final String _FINDER_COLUMN_PRODUCTIDANDGROUPID_SPPRODUCTID_2 =
		"productCourse.spProductId = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTIDANDGROUPID_GROUPID_2 = "productCourse.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED,
			ProductCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProductCourseModelImpl.SPCOURSEID_COLUMN_BITMASK |
			ProductCourseModelImpl.GROUPID_COLUMN_BITMASK |
			ProductCourseModelImpl.SPPRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the product courses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product courses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @return the range of matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the product courses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findByCourseIdAndGroupId(long spCourseId,
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

		List<ProductCourse> list = (List<ProductCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProductCourse productCourse : list) {
				if ((spCourseId != productCourse.getSpCourseId()) ||
						(groupId != productCourse.getGroupId())) {
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

			query.append(_SQL_SELECT_PRODUCTCOURSE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductCourseModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProductCourse>(list);
				}
				else {
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product course in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (productCourse != null) {
			return productCourse;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductCourseException(msg.toString());
	}

	/**
	 * Returns the first product course in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProductCourse> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product course in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (productCourse != null) {
			return productCourse;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductCourseException(msg.toString());
	}

	/**
	 * Returns the last product course in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product course, or <code>null</code> if a matching product course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<ProductCourse> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product courses before and after the current product course in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spProductCourseId the primary key of the current product course
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse[] findByCourseIdAndGroupId_PrevAndNext(
		long spProductCourseId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = findByPrimaryKey(spProductCourseId);

		Session session = null;

		try {
			session = openSession();

			ProductCourse[] array = new ProductCourseImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					productCourse, spCourseId, groupId, orderByComparator, true);

			array[1] = productCourse;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					productCourse, spCourseId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductCourse getByCourseIdAndGroupId_PrevAndNext(
		Session session, ProductCourse productCourse, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCTCOURSE_WHERE);

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
			query.append(ProductCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(productCourse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProductCourse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product courses where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (ProductCourse productCourse : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(productCourse);
		}
	}

	/**
	 * Returns the number of product courses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching product courses
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

			query.append(_SQL_COUNT_PRODUCTCOURSE_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "productCourse.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "productCourse.groupId = ?";

	public ProductCoursePersistenceImpl() {
		setModelClass(ProductCourse.class);
	}

	/**
	 * Caches the product course in the entity cache if it is enabled.
	 *
	 * @param productCourse the product course
	 */
	@Override
	public void cacheResult(ProductCourse productCourse) {
		EntityCacheUtil.putResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseImpl.class, productCourse.getPrimaryKey(),
			productCourse);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
			new Object[] {
				productCourse.getSpProductId(), productCourse.getGroupId()
			}, productCourse);

		productCourse.resetOriginalValues();
	}

	/**
	 * Caches the product courses in the entity cache if it is enabled.
	 *
	 * @param productCourses the product courses
	 */
	@Override
	public void cacheResult(List<ProductCourse> productCourses) {
		for (ProductCourse productCourse : productCourses) {
			if (EntityCacheUtil.getResult(
						ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
						ProductCourseImpl.class, productCourse.getPrimaryKey()) == null) {
				cacheResult(productCourse);
			}
			else {
				productCourse.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all product courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductCourseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductCourseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product course.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductCourse productCourse) {
		EntityCacheUtil.removeResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseImpl.class, productCourse.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(productCourse);
	}

	@Override
	public void clearCache(List<ProductCourse> productCourses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductCourse productCourse : productCourses) {
			EntityCacheUtil.removeResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
				ProductCourseImpl.class, productCourse.getPrimaryKey());

			clearUniqueFindersCache(productCourse);
		}
	}

	protected void cacheUniqueFindersCache(ProductCourse productCourse) {
		if (productCourse.isNew()) {
			Object[] args = new Object[] {
					productCourse.getSpProductId(), productCourse.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
				args, productCourse);
		}
		else {
			ProductCourseModelImpl productCourseModelImpl = (ProductCourseModelImpl)productCourse;

			if ((productCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productCourse.getSpProductId(),
						productCourse.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
					args, productCourse);
			}
		}
	}

	protected void clearUniqueFindersCache(ProductCourse productCourse) {
		ProductCourseModelImpl productCourseModelImpl = (ProductCourseModelImpl)productCourse;

		Object[] args = new Object[] {
				productCourse.getSpProductId(), productCourse.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
			args);

		if ((productCourseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					productCourseModelImpl.getOriginalSpProductId(),
					productCourseModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDANDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTIDANDGROUPID,
				args);
		}
	}

	/**
	 * Creates a new product course with the primary key. Does not add the product course to the database.
	 *
	 * @param spProductCourseId the primary key for the new product course
	 * @return the new product course
	 */
	@Override
	public ProductCourse create(long spProductCourseId) {
		ProductCourse productCourse = new ProductCourseImpl();

		productCourse.setNew(true);
		productCourse.setPrimaryKey(spProductCourseId);

		return productCourse;
	}

	/**
	 * Removes the product course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spProductCourseId the primary key of the product course
	 * @return the product course that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse remove(long spProductCourseId)
		throws NoSuchProductCourseException, SystemException {
		return remove((Serializable)spProductCourseId);
	}

	/**
	 * Removes the product course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product course
	 * @return the product course that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse remove(Serializable primaryKey)
		throws NoSuchProductCourseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductCourse productCourse = (ProductCourse)session.get(ProductCourseImpl.class,
					primaryKey);

			if (productCourse == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productCourse);
		}
		catch (NoSuchProductCourseException nsee) {
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
	protected ProductCourse removeImpl(ProductCourse productCourse)
		throws SystemException {
		productCourse = toUnwrappedModel(productCourse);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productCourse)) {
				productCourse = (ProductCourse)session.get(ProductCourseImpl.class,
						productCourse.getPrimaryKeyObj());
			}

			if (productCourse != null) {
				session.delete(productCourse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (productCourse != null) {
			clearCache(productCourse);
		}

		return productCourse;
	}

	@Override
	public ProductCourse updateImpl(
		com.sambaash.platform.srv.model.ProductCourse productCourse)
		throws SystemException {
		productCourse = toUnwrappedModel(productCourse);

		boolean isNew = productCourse.isNew();

		ProductCourseModelImpl productCourseModelImpl = (ProductCourseModelImpl)productCourse;

		Session session = null;

		try {
			session = openSession();

			if (productCourse.isNew()) {
				session.save(productCourse);

				productCourse.setNew(false);
			}
			else {
				session.merge(productCourse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductCourseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productCourseModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { productCourseModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((productCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productCourseModelImpl.getOriginalSpCourseId(),
						productCourseModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						productCourseModelImpl.getSpCourseId(),
						productCourseModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
			ProductCourseImpl.class, productCourse.getPrimaryKey(),
			productCourse);

		clearUniqueFindersCache(productCourse);
		cacheUniqueFindersCache(productCourse);

		return productCourse;
	}

	protected ProductCourse toUnwrappedModel(ProductCourse productCourse) {
		if (productCourse instanceof ProductCourseImpl) {
			return productCourse;
		}

		ProductCourseImpl productCourseImpl = new ProductCourseImpl();

		productCourseImpl.setNew(productCourse.isNew());
		productCourseImpl.setPrimaryKey(productCourse.getPrimaryKey());

		productCourseImpl.setSpProductCourseId(productCourse.getSpProductCourseId());
		productCourseImpl.setGroupId(productCourse.getGroupId());
		productCourseImpl.setCompanyId(productCourse.getCompanyId());
		productCourseImpl.setUserId(productCourse.getUserId());
		productCourseImpl.setUserName(productCourse.getUserName());
		productCourseImpl.setCreateDate(productCourse.getCreateDate());
		productCourseImpl.setModifiedDate(productCourse.getModifiedDate());
		productCourseImpl.setSpProductId(productCourse.getSpProductId());
		productCourseImpl.setSpCourseId(productCourse.getSpCourseId());

		return productCourseImpl;
	}

	/**
	 * Returns the product course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product course
	 * @return the product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductCourseException, SystemException {
		ProductCourse productCourse = fetchByPrimaryKey(primaryKey);

		if (productCourse == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return productCourse;
	}

	/**
	 * Returns the product course with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProductCourseException} if it could not be found.
	 *
	 * @param spProductCourseId the primary key of the product course
	 * @return the product course
	 * @throws com.sambaash.platform.srv.NoSuchProductCourseException if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse findByPrimaryKey(long spProductCourseId)
		throws NoSuchProductCourseException, SystemException {
		return findByPrimaryKey((Serializable)spProductCourseId);
	}

	/**
	 * Returns the product course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product course
	 * @return the product course, or <code>null</code> if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProductCourse productCourse = (ProductCourse)EntityCacheUtil.getResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
				ProductCourseImpl.class, primaryKey);

		if (productCourse == _nullProductCourse) {
			return null;
		}

		if (productCourse == null) {
			Session session = null;

			try {
				session = openSession();

				productCourse = (ProductCourse)session.get(ProductCourseImpl.class,
						primaryKey);

				if (productCourse != null) {
					cacheResult(productCourse);
				}
				else {
					EntityCacheUtil.putResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
						ProductCourseImpl.class, primaryKey, _nullProductCourse);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProductCourseModelImpl.ENTITY_CACHE_ENABLED,
					ProductCourseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return productCourse;
	}

	/**
	 * Returns the product course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spProductCourseId the primary key of the product course
	 * @return the product course, or <code>null</code> if a product course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductCourse fetchByPrimaryKey(long spProductCourseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spProductCourseId);
	}

	/**
	 * Returns all the product courses.
	 *
	 * @return the product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @return the range of product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of product courses
	 * @param end the upper bound of the range of product courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProductCourse> findAll(int start, int end,
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

		List<ProductCourse> list = (List<ProductCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTCOURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTCOURSE;

				if (pagination) {
					sql = sql.concat(ProductCourseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProductCourse>(list);
				}
				else {
					list = (List<ProductCourse>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the product courses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProductCourse productCourse : findAll()) {
			remove(productCourse);
		}
	}

	/**
	 * Returns the number of product courses.
	 *
	 * @return the number of product courses
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

				Query q = session.createQuery(_SQL_COUNT_PRODUCTCOURSE);

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
	 * Initializes the product course persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ProductCourse")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductCourse>> listenersList = new ArrayList<ModelListener<ProductCourse>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductCourse>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductCourseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRODUCTCOURSE = "SELECT productCourse FROM ProductCourse productCourse";
	private static final String _SQL_SELECT_PRODUCTCOURSE_WHERE = "SELECT productCourse FROM ProductCourse productCourse WHERE ";
	private static final String _SQL_COUNT_PRODUCTCOURSE = "SELECT COUNT(productCourse) FROM ProductCourse productCourse";
	private static final String _SQL_COUNT_PRODUCTCOURSE_WHERE = "SELECT COUNT(productCourse) FROM ProductCourse productCourse WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productCourse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductCourse exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProductCourse exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductCoursePersistenceImpl.class);
	private static ProductCourse _nullProductCourse = new ProductCourseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductCourse> toCacheModel() {
				return _nullProductCourseCacheModel;
			}
		};

	private static CacheModel<ProductCourse> _nullProductCourseCacheModel = new CacheModel<ProductCourse>() {
			@Override
			public ProductCourse toEntityModel() {
				return _nullProductCourse;
			}
		};
}