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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import com.sambaash.platform.srv.NoSuchProductException;
import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.impl.ProductImpl;
import com.sambaash.platform.srv.model.impl.ProductModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductPersistence
 * @see ProductUtil
 * @generated
 */
public class ProductPersistenceImpl extends BasePersistenceImpl<Product>
	implements ProductPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ProductModelImpl.GROUPID_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the products where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupId(long groupId, int start, int end,
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

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if ((groupId != product.getGroupId())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupId_First(groupId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Product> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupId_Last(groupId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the products before and after the current product in the ordered set where groupId = &#63;.
	 *
	 * @param spProductId the primary key of the current product
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product[] findByGroupId_PrevAndNext(long spProductId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = findByPrimaryKey(spProductId);

		Session session = null;

		try {
			session = openSession();

			Product[] array = new ProductImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, product, groupId,
					orderByComparator, true);

			array[1] = product;

			array[2] = getByGroupId_PrevAndNext(session, product, groupId,
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

	protected Product getByGroupId_PrevAndNext(Session session,
		Product product, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCT_WHERE);

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
			query.append(ProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(product);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Product> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the products where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Product product : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching products
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

			query.append(_SQL_COUNT_PRODUCT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "product.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountryId",
			new String[] { String.class.getName() },
			ProductModelImpl.COUNTRYID_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the products where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByCountryId(String countryId)
		throws SystemException {
		return findByCountryId(countryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the products where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByCountryId(String countryId, int start, int end)
		throws SystemException {
		return findByCountryId(countryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByCountryId(String countryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID;
			finderArgs = new Object[] { countryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYID;
			finderArgs = new Object[] { countryId, start, end, orderByComparator };
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if (!Validator.equals(countryId, product.getCountryId())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByCountryId_First(String countryId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByCountryId_First(countryId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByCountryId_First(String countryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Product> list = findByCountryId(countryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByCountryId_Last(String countryId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByCountryId_Last(countryId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByCountryId_Last(String countryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryId(countryId);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByCountryId(countryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the products before and after the current product in the ordered set where countryId = &#63;.
	 *
	 * @param spProductId the primary key of the current product
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product[] findByCountryId_PrevAndNext(long spProductId,
		String countryId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = findByPrimaryKey(spProductId);

		Session session = null;

		try {
			session = openSession();

			Product[] array = new ProductImpl[3];

			array[0] = getByCountryId_PrevAndNext(session, product, countryId,
					orderByComparator, true);

			array[1] = product;

			array[2] = getByCountryId_PrevAndNext(session, product, countryId,
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

	protected Product getByCountryId_PrevAndNext(Session session,
		Product product, String countryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCT_WHERE);

		boolean bindCountryId = false;

		if (countryId == null) {
			query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_1);
		}
		else if (countryId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_3);
		}
		else {
			bindCountryId = true;

			query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);
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
			query.append(ProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCountryId) {
			qPos.add(countryId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(product);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Product> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the products where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryId(String countryId) throws SystemException {
		for (Product product : findByCountryId(countryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryId(String countryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYID;

		Object[] finderArgs = new Object[] { countryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
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

	private static final String _FINDER_COLUMN_COUNTRYID_COUNTRYID_1 = "product.countryId IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYID_COUNTRYID_2 = "product.countryId = ?";
	private static final String _FINDER_COLUMN_COUNTRYID_COUNTRYID_3 = "(product.countryId IS NULL OR product.countryId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndCountryId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndCountryId",
			new String[] { Long.class.getName(), String.class.getName() },
			ProductModelImpl.GROUPID_COLUMN_BITMASK |
			ProductModelImpl.COUNTRYID_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDCOUNTRYID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndCountryId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the products where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCountryId(long groupId,
		String countryId) throws SystemException {
		return findByGroupIdAndCountryId(groupId, countryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where groupId = &#63; and countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCountryId(long groupId,
		String countryId, int start, int end) throws SystemException {
		return findByGroupIdAndCountryId(groupId, countryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where groupId = &#63; and countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCountryId(long groupId,
		String countryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID;
			finderArgs = new Object[] { groupId, countryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID;
			finderArgs = new Object[] {
					groupId, countryId,
					
					start, end, orderByComparator
				};
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if ((groupId != product.getGroupId()) ||
						!Validator.equals(countryId, product.getCountryId())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_GROUPID_2);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupIdAndCountryId_First(long groupId,
		String countryId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupIdAndCountryId_First(groupId, countryId,
				orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryId=");
		msg.append(countryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupIdAndCountryId_First(long groupId,
		String countryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Product> list = findByGroupIdAndCountryId(groupId, countryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupIdAndCountryId_Last(long groupId,
		String countryId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupIdAndCountryId_Last(groupId, countryId,
				orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", countryId=");
		msg.append(countryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupIdAndCountryId_Last(long groupId,
		String countryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndCountryId(groupId, countryId);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByGroupIdAndCountryId(groupId, countryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the products before and after the current product in the ordered set where groupId = &#63; and countryId = &#63;.
	 *
	 * @param spProductId the primary key of the current product
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product[] findByGroupIdAndCountryId_PrevAndNext(long spProductId,
		long groupId, String countryId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = findByPrimaryKey(spProductId);

		Session session = null;

		try {
			session = openSession();

			Product[] array = new ProductImpl[3];

			array[0] = getByGroupIdAndCountryId_PrevAndNext(session, product,
					groupId, countryId, orderByComparator, true);

			array[1] = product;

			array[2] = getByGroupIdAndCountryId_PrevAndNext(session, product,
					groupId, countryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Product getByGroupIdAndCountryId_PrevAndNext(Session session,
		Product product, long groupId, String countryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_GROUPID_2);

		boolean bindCountryId = false;

		if (countryId == null) {
			query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_1);
		}
		else if (countryId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_3);
		}
		else {
			bindCountryId = true;

			query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_2);
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
			query.append(ProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindCountryId) {
			qPos.add(countryId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(product);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Product> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the products where groupId = &#63; and countryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndCountryId(long groupId, String countryId)
		throws SystemException {
		for (Product product : findByGroupIdAndCountryId(groupId, countryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where groupId = &#63; and countryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param countryId the country ID
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndCountryId(long groupId, String countryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDCOUNTRYID;

		Object[] finderArgs = new Object[] { groupId, countryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_GROUPID_2);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindCountryId) {
					qPos.add(countryId);
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

	private static final String _FINDER_COLUMN_GROUPIDANDCOUNTRYID_GROUPID_2 = "product.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_1 = "product.countryId IS NULL";
	private static final String _FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_2 = "product.countryId = ?";
	private static final String _FINDER_COLUMN_GROUPIDANDCOUNTRYID_COUNTRYID_3 = "(product.countryId IS NULL OR product.countryId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByProductNameCounryId",
			new String[] { String.class.getName(), String.class.getName() },
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK |
			ProductModelImpl.COUNTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProductNameCounryId",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the product where productName = &#63; and countryId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchProductException} if it could not be found.
	 *
	 * @param productName the product name
	 * @param countryId the country ID
	 * @return the matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByProductNameCounryId(String productName,
		String countryId) throws NoSuchProductException, SystemException {
		Product product = fetchByProductNameCounryId(productName, countryId);

		if (product == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("productName=");
			msg.append(productName);

			msg.append(", countryId=");
			msg.append(countryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProductException(msg.toString());
		}

		return product;
	}

	/**
	 * Returns the product where productName = &#63; and countryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productName the product name
	 * @param countryId the country ID
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByProductNameCounryId(String productName,
		String countryId) throws SystemException {
		return fetchByProductNameCounryId(productName, countryId, true);
	}

	/**
	 * Returns the product where productName = &#63; and countryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productName the product name
	 * @param countryId the country ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByProductNameCounryId(String productName,
		String countryId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { productName, countryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
					finderArgs, this);
		}

		if (result instanceof Product) {
			Product product = (Product)result;

			if (!Validator.equals(productName, product.getProductName()) ||
					!Validator.equals(countryId, product.getCountryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_2);
			}

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductName) {
					qPos.add(productName.toLowerCase());
				}

				if (bindCountryId) {
					qPos.add(countryId.toLowerCase());
				}

				List<Product> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProductPersistenceImpl.fetchByProductNameCounryId(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Product product = list.get(0);

					result = product;

					cacheResult(product);

					if ((product.getProductName() == null) ||
							!product.getProductName().equals(productName) ||
							(product.getCountryId() == null) ||
							!product.getCountryId().equals(countryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
							finderArgs, product);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
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
			return (Product)result;
		}
	}

	/**
	 * Removes the product where productName = &#63; and countryId = &#63; from the database.
	 *
	 * @param productName the product name
	 * @param countryId the country ID
	 * @return the product that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product removeByProductNameCounryId(String productName,
		String countryId) throws NoSuchProductException, SystemException {
		Product product = findByProductNameCounryId(productName, countryId);

		return remove(product);
	}

	/**
	 * Returns the number of products where productName = &#63; and countryId = &#63;.
	 *
	 * @param productName the product name
	 * @param countryId the country ID
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProductNameCounryId(String productName, String countryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID;

		Object[] finderArgs = new Object[] { productName, countryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			boolean bindProductName = false;

			if (productName == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_1);
			}
			else if (productName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_3);
			}
			else {
				bindProductName = true;

				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_2);
			}

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProductName) {
					qPos.add(productName.toLowerCase());
				}

				if (bindCountryId) {
					qPos.add(countryId.toLowerCase());
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

	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_1 =
		"product.productName IS NULL AND ";
	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_2 =
		"lower(product.productName) = ? AND ";
	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_PRODUCTNAME_3 =
		"(product.productName IS NULL OR product.productName = '') AND ";
	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_1 = "product.countryId IS NULL";
	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_2 = "lower(product.countryId) = ?";
	private static final String _FINDER_COLUMN_PRODUCTNAMECOUNRYID_COUNTRYID_3 = "(product.countryId IS NULL OR product.countryId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ProductModelImpl.STATUS_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the products where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if ((status != product.getStatus())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByStatus_First(status, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<Product> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByStatus_Last(status, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the products before and after the current product in the ordered set where status = &#63;.
	 *
	 * @param spProductId the primary key of the current product
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product[] findByStatus_PrevAndNext(long spProductId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = findByPrimaryKey(spProductId);

		Session session = null;

		try {
			session = openSession();

			Product[] array = new ProductImpl[3];

			array[0] = getByStatus_PrevAndNext(session, product, status,
					orderByComparator, true);

			array[1] = product;

			array[2] = getByStatus_PrevAndNext(session, product, status,
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

	protected Product getByStatus_PrevAndNext(Session session, Product product,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCT_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(ProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(product);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Product> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the products where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (Product product : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "product.status = ? AND product.status = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTIDS =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproductIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTIDS =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproductIds",
			new String[] { Long.class.getName() },
			ProductModelImpl.SPPRODUCTID_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRODUCTIDS = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRODUCTIDS =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByproductIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the products where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long spProductId)
		throws SystemException {
		return findByproductIds(spProductId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where spProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spProductId the sp product ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long spProductId, int start, int end)
		throws SystemException {
		return findByproductIds(spProductId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where spProductId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spProductId the sp product ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long spProductId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTIDS;
			finderArgs = new Object[] { spProductId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTIDS;
			finderArgs = new Object[] { spProductId, start, end, orderByComparator };
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if ((spProductId != product.getSpProductId())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spProductId);

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByproductIds_First(long spProductId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByproductIds_First(spProductId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spProductId=");
		msg.append(spProductId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByproductIds_First(long spProductId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Product> list = findByproductIds(spProductId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByproductIds_Last(long spProductId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByproductIds_Last(spProductId, orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spProductId=");
		msg.append(spProductId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByproductIds_Last(long spProductId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByproductIds(spProductId);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByproductIds(spProductId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the products where spProductId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spProductIds the sp product IDs
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long[] spProductIds)
		throws SystemException {
		return findByproductIds(spProductIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where spProductId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spProductIds the sp product IDs
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long[] spProductIds, int start,
		int end) throws SystemException {
		return findByproductIds(spProductIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where spProductId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spProductIds the sp product IDs
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByproductIds(long[] spProductIds, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((spProductIds != null) && (spProductIds.length == 1)) {
			return findByproductIds(spProductIds[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(spProductIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(spProductIds),
					
					start, end, orderByComparator
				};
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if (!ArrayUtil.contains(spProductIds, product.getSpProductId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			boolean conjunctionable = false;

			if ((spProductIds == null) || (spProductIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spProductIds.length; i++) {
					query.append(_FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_5);

					if ((i + 1) < spProductIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spProductIds != null) {
					qPos.add(spProductIds);
				}

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_PRODUCTIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the products where spProductId = &#63; from the database.
	 *
	 * @param spProductId the sp product ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByproductIds(long spProductId) throws SystemException {
		for (Product product : findByproductIds(spProductId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where spProductId = &#63;.
	 *
	 * @param spProductId the sp product ID
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByproductIds(long spProductId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRODUCTIDS;

		Object[] finderArgs = new Object[] { spProductId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spProductId);

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

	/**
	 * Returns the number of products where spProductId = any &#63;.
	 *
	 * @param spProductIds the sp product IDs
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByproductIds(long[] spProductIds) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(spProductIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRODUCTIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			boolean conjunctionable = false;

			if ((spProductIds == null) || (spProductIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spProductIds.length; i++) {
					query.append(_FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_5);

					if ((i + 1) < spProductIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spProductIds != null) {
					qPos.add(spProductIds);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRODUCTIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_PRODUCTIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_2 = "product.spProductId = ?";
	private static final String _FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_PRODUCTIDS_SPPRODUCTID_2) + ")";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOURSEID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndCourseId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOURSEID =
		new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, ProductImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndCourseId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProductModelImpl.GROUPID_COLUMN_BITMASK |
			ProductModelImpl.SPCOURSEID_COLUMN_BITMASK |
			ProductModelImpl.PRODUCTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDCOURSEID = new FinderPath(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndCourseId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the products where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @return the matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCourseId(long groupId, long spCourseId)
		throws SystemException {
		return findByGroupIdAndCourseId(groupId, spCourseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products where groupId = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCourseId(long groupId,
		long spCourseId, int start, int end) throws SystemException {
		return findByGroupIdAndCourseId(groupId, spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the products where groupId = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findByGroupIdAndCourseId(long groupId,
		long spCourseId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOURSEID;
			finderArgs = new Object[] { groupId, spCourseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOURSEID;
			finderArgs = new Object[] {
					groupId, spCourseId,
					
					start, end, orderByComparator
				};
		}

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Product product : list) {
				if ((groupId != product.getGroupId()) ||
						(spCourseId != product.getSpCourseId())) {
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

			query.append(_SQL_SELECT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProductModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupIdAndCourseId_First(long groupId,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupIdAndCourseId_First(groupId, spCourseId,
				orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the first product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupIdAndCourseId_First(long groupId,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Product> list = findByGroupIdAndCourseId(groupId, spCourseId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByGroupIdAndCourseId_Last(long groupId, long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = fetchByGroupIdAndCourseId_Last(groupId, spCourseId,
				orderByComparator);

		if (product != null) {
			return product;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProductException(msg.toString());
	}

	/**
	 * Returns the last product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product, or <code>null</code> if a matching product could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByGroupIdAndCourseId_Last(long groupId,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndCourseId(groupId, spCourseId);

		if (count == 0) {
			return null;
		}

		List<Product> list = findByGroupIdAndCourseId(groupId, spCourseId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the products before and after the current product in the ordered set where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param spProductId the primary key of the current product
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product[] findByGroupIdAndCourseId_PrevAndNext(long spProductId,
		long groupId, long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchProductException, SystemException {
		Product product = findByPrimaryKey(spProductId);

		Session session = null;

		try {
			session = openSession();

			Product[] array = new ProductImpl[3];

			array[0] = getByGroupIdAndCourseId_PrevAndNext(session, product,
					groupId, spCourseId, orderByComparator, true);

			array[1] = product;

			array[2] = getByGroupIdAndCourseId_PrevAndNext(session, product,
					groupId, spCourseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Product getByGroupIdAndCourseId_PrevAndNext(Session session,
		Product product, long groupId, long spCourseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCT_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_SPCOURSEID_2);

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
			query.append(ProductModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(product);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Product> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the products where groupId = &#63; and spCourseId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndCourseId(long groupId, long spCourseId)
		throws SystemException {
		for (Product product : findByGroupIdAndCourseId(groupId, spCourseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products where groupId = &#63; and spCourseId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCourseId the sp course ID
	 * @return the number of matching products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndCourseId(long groupId, long spCourseId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDCOURSEID;

		Object[] finderArgs = new Object[] { groupId, spCourseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDCOURSEID_GROUPID_2 = "product.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDCOURSEID_SPCOURSEID_2 = "product.spCourseId = ?";

	public ProductPersistenceImpl() {
		setModelClass(Product.class);
	}

	/**
	 * Caches the product in the entity cache if it is enabled.
	 *
	 * @param product the product
	 */
	@Override
	public void cacheResult(Product product) {
		EntityCacheUtil.putResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductImpl.class, product.getPrimaryKey(), product);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
			new Object[] { product.getProductName(), product.getCountryId() },
			product);

		product.resetOriginalValues();
	}

	/**
	 * Caches the products in the entity cache if it is enabled.
	 *
	 * @param products the products
	 */
	@Override
	public void cacheResult(List<Product> products) {
		for (Product product : products) {
			if (EntityCacheUtil.getResult(
						ProductModelImpl.ENTITY_CACHE_ENABLED,
						ProductImpl.class, product.getPrimaryKey()) == null) {
				cacheResult(product);
			}
			else {
				product.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all products.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Product product) {
		EntityCacheUtil.removeResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductImpl.class, product.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(product);
	}

	@Override
	public void clearCache(List<Product> products) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Product product : products) {
			EntityCacheUtil.removeResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
				ProductImpl.class, product.getPrimaryKey());

			clearUniqueFindersCache(product);
		}
	}

	protected void cacheUniqueFindersCache(Product product) {
		if (product.isNew()) {
			Object[] args = new Object[] {
					product.getProductName(), product.getCountryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
				args, product);
		}
		else {
			ProductModelImpl productModelImpl = (ProductModelImpl)product;

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						product.getProductName(), product.getCountryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
					args, product);
			}
		}
	}

	protected void clearUniqueFindersCache(Product product) {
		ProductModelImpl productModelImpl = (ProductModelImpl)product;

		Object[] args = new Object[] {
				product.getProductName(), product.getCountryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
			args);

		if ((productModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					productModelImpl.getOriginalProductName(),
					productModelImpl.getOriginalCountryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTNAMECOUNRYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PRODUCTNAMECOUNRYID,
				args);
		}
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param spProductId the primary key for the new product
	 * @return the new product
	 */
	@Override
	public Product create(long spProductId) {
		Product product = new ProductImpl();

		product.setNew(true);
		product.setPrimaryKey(spProductId);

		return product;
	}

	/**
	 * Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spProductId the primary key of the product
	 * @return the product that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product remove(long spProductId)
		throws NoSuchProductException, SystemException {
		return remove((Serializable)spProductId);
	}

	/**
	 * Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product
	 * @return the product that was removed
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product remove(Serializable primaryKey)
		throws NoSuchProductException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Product product = (Product)session.get(ProductImpl.class, primaryKey);

			if (product == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(product);
		}
		catch (NoSuchProductException nsee) {
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
	protected Product removeImpl(Product product) throws SystemException {
		product = toUnwrappedModel(product);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(product)) {
				product = (Product)session.get(ProductImpl.class,
						product.getPrimaryKeyObj());
			}

			if (product != null) {
				session.delete(product);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (product != null) {
			clearCache(product);
		}

		return product;
	}

	@Override
	public Product updateImpl(com.sambaash.platform.srv.model.Product product)
		throws SystemException {
		product = toUnwrappedModel(product);

		boolean isNew = product.isNew();

		ProductModelImpl productModelImpl = (ProductModelImpl)product;

		Session session = null;

		try {
			session = openSession();

			if (product.isNew()) {
				session.save(product);

				product.setNew(false);
			}
			else {
				session.merge(product);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProductModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { productModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalCountryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);

				args = new Object[] { productModelImpl.getCountryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYID,
					args);
			}

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalGroupId(),
						productModelImpl.getOriginalCountryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID,
					args);

				args = new Object[] {
						productModelImpl.getGroupId(),
						productModelImpl.getCountryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOUNTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOUNTRYID,
					args);
			}

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { productModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalSpProductId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTIDS,
					args);

				args = new Object[] { productModelImpl.getSpProductId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRODUCTIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRODUCTIDS,
					args);
			}

			if ((productModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						productModelImpl.getOriginalGroupId(),
						productModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOURSEID,
					args);

				args = new Object[] {
						productModelImpl.getGroupId(),
						productModelImpl.getSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOURSEID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
			ProductImpl.class, product.getPrimaryKey(), product);

		clearUniqueFindersCache(product);
		cacheUniqueFindersCache(product);

		return product;
	}

	protected Product toUnwrappedModel(Product product) {
		if (product instanceof ProductImpl) {
			return product;
		}

		ProductImpl productImpl = new ProductImpl();

		productImpl.setNew(product.isNew());
		productImpl.setPrimaryKey(product.getPrimaryKey());

		productImpl.setSpProductId(product.getSpProductId());
		productImpl.setGroupId(product.getGroupId());
		productImpl.setCompanyId(product.getCompanyId());
		productImpl.setUserId(product.getUserId());
		productImpl.setUserName(product.getUserName());
		productImpl.setCreateDate(product.getCreateDate());
		productImpl.setModifiedDate(product.getModifiedDate());
		productImpl.setCountryId(product.getCountryId());
		productImpl.setProductCode(product.getProductCode());
		productImpl.setProductName(product.getProductName());
		productImpl.setProductDesc(product.getProductDesc());
		productImpl.setProductImageId(product.getProductImageId());
		productImpl.setSpCourseId(product.getSpCourseId());
		productImpl.setProductBrochuresFolderId(product.getProductBrochuresFolderId());
		productImpl.setProductVideoFolderId(product.getProductVideoFolderId());
		productImpl.setStatus(product.getStatus());
		productImpl.setCreditValues(product.getCreditValues());
		productImpl.setPEProcessId(product.getPEProcessId());
		productImpl.setProductTemplateName(product.getProductTemplateName());
		productImpl.setProductTemplateLanguage(product.getProductTemplateLanguage());
		productImpl.setRegistrationEnabled(product.getRegistrationEnabled());
		productImpl.setSamePageRegistration(product.getSamePageRegistration());
		productImpl.setProductFormImageId(product.getProductFormImageId());
		productImpl.setProductFormName(product.getProductFormName());
		productImpl.setProductFormButtonName(product.getProductFormButtonName());
		productImpl.setProductFormUrl(product.getProductFormUrl());
		productImpl.setProductBannerImageId(product.getProductBannerImageId());
		productImpl.setHasInventory(product.isHasInventory());
		productImpl.setBannerDetailsEnabled(product.getBannerDetailsEnabled());

		return productImpl;
	}

	/**
	 * Returns the product with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the product
	 * @return the product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductException, SystemException {
		Product product = fetchByPrimaryKey(primaryKey);

		if (product == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return product;
	}

	/**
	 * Returns the product with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchProductException} if it could not be found.
	 *
	 * @param spProductId the primary key of the product
	 * @return the product
	 * @throws com.sambaash.platform.srv.NoSuchProductException if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product findByPrimaryKey(long spProductId)
		throws NoSuchProductException, SystemException {
		return findByPrimaryKey((Serializable)spProductId);
	}

	/**
	 * Returns the product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product
	 * @return the product, or <code>null</code> if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Product product = (Product)EntityCacheUtil.getResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
				ProductImpl.class, primaryKey);

		if (product == _nullProduct) {
			return null;
		}

		if (product == null) {
			Session session = null;

			try {
				session = openSession();

				product = (Product)session.get(ProductImpl.class, primaryKey);

				if (product != null) {
					cacheResult(product);
				}
				else {
					EntityCacheUtil.putResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
						ProductImpl.class, primaryKey, _nullProduct);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProductModelImpl.ENTITY_CACHE_ENABLED,
					ProductImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return product;
	}

	/**
	 * Returns the product with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spProductId the primary key of the product
	 * @return the product, or <code>null</code> if a product with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Product fetchByPrimaryKey(long spProductId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spProductId);
	}

	/**
	 * Returns all the products.
	 *
	 * @return the products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of products
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Product> findAll(int start, int end,
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

		List<Product> list = (List<Product>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCT;

				if (pagination) {
					sql = sql.concat(ProductModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Product>(list);
				}
				else {
					list = (List<Product>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the products from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Product product : findAll()) {
			remove(product);
		}
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
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

				Query q = session.createQuery(_SQL_COUNT_PRODUCT);

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
	 * Initializes the product persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Product")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Product>> listenersList = new ArrayList<ModelListener<Product>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Product>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRODUCT = "SELECT product FROM Product product";
	private static final String _SQL_SELECT_PRODUCT_WHERE = "SELECT product FROM Product product WHERE ";
	private static final String _SQL_COUNT_PRODUCT = "SELECT COUNT(product) FROM Product product";
	private static final String _SQL_COUNT_PRODUCT_WHERE = "SELECT COUNT(product) FROM Product product WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "product.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Product exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Product exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductPersistenceImpl.class);
	private static Product _nullProduct = new ProductImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Product> toCacheModel() {
				return _nullProductCacheModel;
			}
		};

	private static CacheModel<Product> _nullProductCacheModel = new CacheModel<Product>() {
			@Override
			public Product toEntityModel() {
				return _nullProduct;
			}
		};
}