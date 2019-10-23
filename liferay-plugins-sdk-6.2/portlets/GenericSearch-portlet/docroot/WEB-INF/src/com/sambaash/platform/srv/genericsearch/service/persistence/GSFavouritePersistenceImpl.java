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

package com.sambaash.platform.srv.genericsearch.service.persistence;

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

import com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException;
import com.sambaash.platform.srv.genericsearch.model.GSFavourite;
import com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteImpl;
import com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the g s favourite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see GSFavouritePersistence
 * @see GSFavouriteUtil
 * @generated
 */
public class GSFavouritePersistenceImpl extends BasePersistenceImpl<GSFavourite>
	implements GSFavouritePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GSFavouriteUtil} to access the g s favourite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GSFavouriteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreatedBy",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreatedBy",
			new String[] { Long.class.getName() },
			GSFavouriteModelImpl.CREATEDBY_COLUMN_BITMASK |
			GSFavouriteModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBY = new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreatedBy",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g s favourites where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedBy(long createdBy)
		throws SystemException {
		return findBycreatedBy(createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the g s favourites where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @return the range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedBy(long createdBy, int start, int end)
		throws SystemException {
		return findBycreatedBy(createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g s favourites where createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedBy(long createdBy, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY;
			finderArgs = new Object[] { createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBY;
			finderArgs = new Object[] { createdBy, start, end, orderByComparator };
		}

		List<GSFavourite> list = (List<GSFavourite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GSFavourite gsFavourite : list) {
				if ((createdBy != gsFavourite.getCreatedBy())) {
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

			query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				if (!pagination) {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GSFavourite>(list);
				}
				else {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g s favourite in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findBycreatedBy_First(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchBycreatedBy_First(createdBy,
				orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the first g s favourite in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchBycreatedBy_First(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		List<GSFavourite> list = findBycreatedBy(createdBy, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g s favourite in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findBycreatedBy_Last(long createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchBycreatedBy_Last(createdBy,
				orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the last g s favourite in the ordered set where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchBycreatedBy_Last(long createdBy,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreatedBy(createdBy);

		if (count == 0) {
			return null;
		}

		List<GSFavourite> list = findBycreatedBy(createdBy, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g s favourites before and after the current g s favourite in the ordered set where createdBy = &#63;.
	 *
	 * @param SPGSFavouriteId the primary key of the current g s favourite
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite[] findBycreatedBy_PrevAndNext(long SPGSFavouriteId,
		long createdBy, OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = findByPrimaryKey(SPGSFavouriteId);

		Session session = null;

		try {
			session = openSession();

			GSFavourite[] array = new GSFavouriteImpl[3];

			array[0] = getBycreatedBy_PrevAndNext(session, gsFavourite,
					createdBy, orderByComparator, true);

			array[1] = gsFavourite;

			array[2] = getBycreatedBy_PrevAndNext(session, gsFavourite,
					createdBy, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GSFavourite getBycreatedBy_PrevAndNext(Session session,
		GSFavourite gsFavourite, long createdBy,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

		query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

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
			query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gsFavourite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GSFavourite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g s favourites where createdBy = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycreatedBy(long createdBy) throws SystemException {
		for (GSFavourite gsFavourite : findBycreatedBy(createdBy,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gsFavourite);
		}
	}

	/**
	 * Returns the number of g s favourites where createdBy = &#63;.
	 *
	 * @param createdBy the created by
	 * @return the number of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycreatedBy(long createdBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDBY;

		Object[] finderArgs = new Object[] { createdBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBY_CREATEDBY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

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

	private static final String _FINDER_COLUMN_CREATEDBY_CREATEDBY_2 = "gsFavourite.createdBy = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycreatedByLayoutIdPermissionType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycreatedByLayoutIdPermissionType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			GSFavouriteModelImpl.CREATEDBY_COLUMN_BITMASK |
			GSFavouriteModelImpl.LAYOUTID_COLUMN_BITMASK |
			GSFavouriteModelImpl.PERMISSIONTYPE_COLUMN_BITMASK |
			GSFavouriteModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycreatedByLayoutIdPermissionType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @return the matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType)
		throws SystemException {
		return findBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @return the range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end)
		throws SystemException {
		return findBycreatedByLayoutIdPermissionType(createdBy, layoutId,
			permissionType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findBycreatedByLayoutIdPermissionType(
		long createdBy, long layoutId, int permissionType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE;
			finderArgs = new Object[] { createdBy, layoutId, permissionType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE;
			finderArgs = new Object[] {
					createdBy, layoutId, permissionType,
					
					start, end, orderByComparator
				};
		}

		List<GSFavourite> list = (List<GSFavourite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GSFavourite gsFavourite : list) {
				if ((createdBy != gsFavourite.getCreatedBy()) ||
						(layoutId != gsFavourite.getLayoutId()) ||
						(permissionType != gsFavourite.getPermissionType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_CREATEDBY_2);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				qPos.add(layoutId);

				qPos.add(permissionType);

				if (!pagination) {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GSFavourite>(list);
				}
				else {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchBycreatedByLayoutIdPermissionType_First(createdBy,
				layoutId, permissionType, orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", layoutId=");
		msg.append(layoutId);

		msg.append(", permissionType=");
		msg.append(permissionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the first g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchBycreatedByLayoutIdPermissionType_First(
		long createdBy, long layoutId, int permissionType,
		OrderByComparator orderByComparator) throws SystemException {
		List<GSFavourite> list = findBycreatedByLayoutIdPermissionType(createdBy,
				layoutId, permissionType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchBycreatedByLayoutIdPermissionType_Last(createdBy,
				layoutId, permissionType, orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createdBy=");
		msg.append(createdBy);

		msg.append(", layoutId=");
		msg.append(layoutId);

		msg.append(", permissionType=");
		msg.append(permissionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the last g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchBycreatedByLayoutIdPermissionType_Last(
		long createdBy, long layoutId, int permissionType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreatedByLayoutIdPermissionType(createdBy, layoutId,
				permissionType);

		if (count == 0) {
			return null;
		}

		List<GSFavourite> list = findBycreatedByLayoutIdPermissionType(createdBy,
				layoutId, permissionType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g s favourites before and after the current g s favourite in the ordered set where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param SPGSFavouriteId the primary key of the current g s favourite
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite[] findBycreatedByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long createdBy, long layoutId,
		int permissionType, OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = findByPrimaryKey(SPGSFavouriteId);

		Session session = null;

		try {
			session = openSession();

			GSFavourite[] array = new GSFavouriteImpl[3];

			array[0] = getBycreatedByLayoutIdPermissionType_PrevAndNext(session,
					gsFavourite, createdBy, layoutId, permissionType,
					orderByComparator, true);

			array[1] = gsFavourite;

			array[2] = getBycreatedByLayoutIdPermissionType_PrevAndNext(session,
					gsFavourite, createdBy, layoutId, permissionType,
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

	protected GSFavourite getBycreatedByLayoutIdPermissionType_PrevAndNext(
		Session session, GSFavourite gsFavourite, long createdBy,
		long layoutId, int permissionType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

		query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_CREATEDBY_2);

		query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

		query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

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
			query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(createdBy);

		qPos.add(layoutId);

		qPos.add(permissionType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gsFavourite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GSFavourite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63; from the database.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType) throws SystemException {
		for (GSFavourite gsFavourite : findBycreatedByLayoutIdPermissionType(
				createdBy, layoutId, permissionType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gsFavourite);
		}
	}

	/**
	 * Returns the number of g s favourites where createdBy = &#63; and layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param createdBy the created by
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @return the number of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycreatedByLayoutIdPermissionType(long createdBy,
		long layoutId, int permissionType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE;

		Object[] finderArgs = new Object[] { createdBy, layoutId, permissionType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_CREATEDBY_2);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

			query.append(_FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(createdBy);

				qPos.add(layoutId);

				qPos.add(permissionType);

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

	private static final String _FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_CREATEDBY_2 =
		"gsFavourite.createdBy = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_LAYOUTID_2 =
		"gsFavourite.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDBYLAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2 =
		"gsFavourite.permissionType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLayoutIdPermissionType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE =
		new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, GSFavouriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLayoutIdPermissionType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			GSFavouriteModelImpl.LAYOUTID_COLUMN_BITMASK |
			GSFavouriteModelImpl.PERMISSIONTYPE_COLUMN_BITMASK |
			GSFavouriteModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTIDPERMISSIONTYPE = new FinderPath(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLayoutIdPermissionType",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @return the matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findByLayoutIdPermissionType(long layoutId,
		int permissionType) throws SystemException {
		return findByLayoutIdPermissionType(layoutId, permissionType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @return the range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findByLayoutIdPermissionType(long layoutId,
		int permissionType, int start, int end) throws SystemException {
		return findByLayoutIdPermissionType(layoutId, permissionType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the g s favourites where layoutId = &#63; and permissionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findByLayoutIdPermissionType(long layoutId,
		int permissionType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE;
			finderArgs = new Object[] { layoutId, permissionType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE;
			finderArgs = new Object[] {
					layoutId, permissionType,
					
					start, end, orderByComparator
				};
		}

		List<GSFavourite> list = (List<GSFavourite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GSFavourite gsFavourite : list) {
				if ((layoutId != gsFavourite.getLayoutId()) ||
						(permissionType != gsFavourite.getPermissionType())) {
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

			query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

			query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				qPos.add(permissionType);

				if (!pagination) {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GSFavourite>(list);
				}
				else {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findByLayoutIdPermissionType_First(long layoutId,
		int permissionType, OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchByLayoutIdPermissionType_First(layoutId,
				permissionType, orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layoutId=");
		msg.append(layoutId);

		msg.append(", permissionType=");
		msg.append(permissionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the first g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchByLayoutIdPermissionType_First(long layoutId,
		int permissionType, OrderByComparator orderByComparator)
		throws SystemException {
		List<GSFavourite> list = findByLayoutIdPermissionType(layoutId,
				permissionType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findByLayoutIdPermissionType_Last(long layoutId,
		int permissionType, OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchByLayoutIdPermissionType_Last(layoutId,
				permissionType, orderByComparator);

		if (gsFavourite != null) {
			return gsFavourite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layoutId=");
		msg.append(layoutId);

		msg.append(", permissionType=");
		msg.append(permissionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGSFavouriteException(msg.toString());
	}

	/**
	 * Returns the last g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g s favourite, or <code>null</code> if a matching g s favourite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchByLayoutIdPermissionType_Last(long layoutId,
		int permissionType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByLayoutIdPermissionType(layoutId, permissionType);

		if (count == 0) {
			return null;
		}

		List<GSFavourite> list = findByLayoutIdPermissionType(layoutId,
				permissionType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g s favourites before and after the current g s favourite in the ordered set where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param SPGSFavouriteId the primary key of the current g s favourite
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite[] findByLayoutIdPermissionType_PrevAndNext(
		long SPGSFavouriteId, long layoutId, int permissionType,
		OrderByComparator orderByComparator)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = findByPrimaryKey(SPGSFavouriteId);

		Session session = null;

		try {
			session = openSession();

			GSFavourite[] array = new GSFavouriteImpl[3];

			array[0] = getByLayoutIdPermissionType_PrevAndNext(session,
					gsFavourite, layoutId, permissionType, orderByComparator,
					true);

			array[1] = gsFavourite;

			array[2] = getByLayoutIdPermissionType_PrevAndNext(session,
					gsFavourite, layoutId, permissionType, orderByComparator,
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

	protected GSFavourite getByLayoutIdPermissionType_PrevAndNext(
		Session session, GSFavourite gsFavourite, long layoutId,
		int permissionType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GSFAVOURITE_WHERE);

		query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

		query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

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
			query.append(GSFavouriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(layoutId);

		qPos.add(permissionType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gsFavourite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GSFavourite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g s favourites where layoutId = &#63; and permissionType = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLayoutIdPermissionType(long layoutId, int permissionType)
		throws SystemException {
		for (GSFavourite gsFavourite : findByLayoutIdPermissionType(layoutId,
				permissionType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gsFavourite);
		}
	}

	/**
	 * Returns the number of g s favourites where layoutId = &#63; and permissionType = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param permissionType the permission type
	 * @return the number of matching g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLayoutIdPermissionType(long layoutId, int permissionType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYOUTIDPERMISSIONTYPE;

		Object[] finderArgs = new Object[] { layoutId, permissionType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GSFAVOURITE_WHERE);

			query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_LAYOUTID_2);

			query.append(_FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(layoutId);

				qPos.add(permissionType);

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

	private static final String _FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_LAYOUTID_2 =
		"gsFavourite.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPERMISSIONTYPE_PERMISSIONTYPE_2 =
		"gsFavourite.permissionType = ?";

	public GSFavouritePersistenceImpl() {
		setModelClass(GSFavourite.class);
	}

	/**
	 * Caches the g s favourite in the entity cache if it is enabled.
	 *
	 * @param gsFavourite the g s favourite
	 */
	@Override
	public void cacheResult(GSFavourite gsFavourite) {
		EntityCacheUtil.putResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteImpl.class, gsFavourite.getPrimaryKey(), gsFavourite);

		gsFavourite.resetOriginalValues();
	}

	/**
	 * Caches the g s favourites in the entity cache if it is enabled.
	 *
	 * @param gsFavourites the g s favourites
	 */
	@Override
	public void cacheResult(List<GSFavourite> gsFavourites) {
		for (GSFavourite gsFavourite : gsFavourites) {
			if (EntityCacheUtil.getResult(
						GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
						GSFavouriteImpl.class, gsFavourite.getPrimaryKey()) == null) {
				cacheResult(gsFavourite);
			}
			else {
				gsFavourite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g s favourites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GSFavouriteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GSFavouriteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g s favourite.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GSFavourite gsFavourite) {
		EntityCacheUtil.removeResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteImpl.class, gsFavourite.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GSFavourite> gsFavourites) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GSFavourite gsFavourite : gsFavourites) {
			EntityCacheUtil.removeResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
				GSFavouriteImpl.class, gsFavourite.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g s favourite with the primary key. Does not add the g s favourite to the database.
	 *
	 * @param SPGSFavouriteId the primary key for the new g s favourite
	 * @return the new g s favourite
	 */
	@Override
	public GSFavourite create(long SPGSFavouriteId) {
		GSFavourite gsFavourite = new GSFavouriteImpl();

		gsFavourite.setNew(true);
		gsFavourite.setPrimaryKey(SPGSFavouriteId);

		return gsFavourite;
	}

	/**
	 * Removes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SPGSFavouriteId the primary key of the g s favourite
	 * @return the g s favourite that was removed
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite remove(long SPGSFavouriteId)
		throws NoSuchGSFavouriteException, SystemException {
		return remove((Serializable)SPGSFavouriteId);
	}

	/**
	 * Removes the g s favourite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g s favourite
	 * @return the g s favourite that was removed
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite remove(Serializable primaryKey)
		throws NoSuchGSFavouriteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GSFavourite gsFavourite = (GSFavourite)session.get(GSFavouriteImpl.class,
					primaryKey);

			if (gsFavourite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGSFavouriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gsFavourite);
		}
		catch (NoSuchGSFavouriteException nsee) {
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
	protected GSFavourite removeImpl(GSFavourite gsFavourite)
		throws SystemException {
		gsFavourite = toUnwrappedModel(gsFavourite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gsFavourite)) {
				gsFavourite = (GSFavourite)session.get(GSFavouriteImpl.class,
						gsFavourite.getPrimaryKeyObj());
			}

			if (gsFavourite != null) {
				session.delete(gsFavourite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gsFavourite != null) {
			clearCache(gsFavourite);
		}

		return gsFavourite;
	}

	@Override
	public GSFavourite updateImpl(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite)
		throws SystemException {
		gsFavourite = toUnwrappedModel(gsFavourite);

		boolean isNew = gsFavourite.isNew();

		GSFavouriteModelImpl gsFavouriteModelImpl = (GSFavouriteModelImpl)gsFavourite;

		Session session = null;

		try {
			session = openSession();

			if (gsFavourite.isNew()) {
				session.save(gsFavourite);

				gsFavourite.setNew(false);
			}
			else {
				session.merge(gsFavourite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GSFavouriteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gsFavouriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gsFavouriteModelImpl.getOriginalCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);

				args = new Object[] { gsFavouriteModelImpl.getCreatedBy() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBY,
					args);
			}

			if ((gsFavouriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gsFavouriteModelImpl.getOriginalCreatedBy(),
						gsFavouriteModelImpl.getOriginalLayoutId(),
						gsFavouriteModelImpl.getOriginalPermissionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE,
					args);

				args = new Object[] {
						gsFavouriteModelImpl.getCreatedBy(),
						gsFavouriteModelImpl.getLayoutId(),
						gsFavouriteModelImpl.getPermissionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDBYLAYOUTIDPERMISSIONTYPE,
					args);
			}

			if ((gsFavouriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gsFavouriteModelImpl.getOriginalLayoutId(),
						gsFavouriteModelImpl.getOriginalPermissionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDPERMISSIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE,
					args);

				args = new Object[] {
						gsFavouriteModelImpl.getLayoutId(),
						gsFavouriteModelImpl.getPermissionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDPERMISSIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDPERMISSIONTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
			GSFavouriteImpl.class, gsFavourite.getPrimaryKey(), gsFavourite);

		return gsFavourite;
	}

	protected GSFavourite toUnwrappedModel(GSFavourite gsFavourite) {
		if (gsFavourite instanceof GSFavouriteImpl) {
			return gsFavourite;
		}

		GSFavouriteImpl gsFavouriteImpl = new GSFavouriteImpl();

		gsFavouriteImpl.setNew(gsFavourite.isNew());
		gsFavouriteImpl.setPrimaryKey(gsFavourite.getPrimaryKey());

		gsFavouriteImpl.setSPGSFavouriteId(gsFavourite.getSPGSFavouriteId());
		gsFavouriteImpl.setGroupId(gsFavourite.getGroupId());
		gsFavouriteImpl.setCompanyId(gsFavourite.getCompanyId());
		gsFavouriteImpl.setUserId(gsFavourite.getUserId());
		gsFavouriteImpl.setUserName(gsFavourite.getUserName());
		gsFavouriteImpl.setCreateDate(gsFavourite.getCreateDate());
		gsFavouriteImpl.setModifiedDate(gsFavourite.getModifiedDate());
		gsFavouriteImpl.setName(gsFavourite.getName());
		gsFavouriteImpl.setCreatedBy(gsFavourite.getCreatedBy());
		gsFavouriteImpl.setLayoutId(gsFavourite.getLayoutId());
		gsFavouriteImpl.setPortletInstanceId(gsFavourite.getPortletInstanceId());
		gsFavouriteImpl.setConfig(gsFavourite.getConfig());
		gsFavouriteImpl.setPermissionType(gsFavourite.getPermissionType());

		return gsFavouriteImpl;
	}

	/**
	 * Returns the g s favourite with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g s favourite
	 * @return the g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGSFavouriteException, SystemException {
		GSFavourite gsFavourite = fetchByPrimaryKey(primaryKey);

		if (gsFavourite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGSFavouriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gsFavourite;
	}

	/**
	 * Returns the g s favourite with the primary key or throws a {@link com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException} if it could not be found.
	 *
	 * @param SPGSFavouriteId the primary key of the g s favourite
	 * @return the g s favourite
	 * @throws com.sambaash.platform.srv.genericsearch.NoSuchGSFavouriteException if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite findByPrimaryKey(long SPGSFavouriteId)
		throws NoSuchGSFavouriteException, SystemException {
		return findByPrimaryKey((Serializable)SPGSFavouriteId);
	}

	/**
	 * Returns the g s favourite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g s favourite
	 * @return the g s favourite, or <code>null</code> if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GSFavourite gsFavourite = (GSFavourite)EntityCacheUtil.getResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
				GSFavouriteImpl.class, primaryKey);

		if (gsFavourite == _nullGSFavourite) {
			return null;
		}

		if (gsFavourite == null) {
			Session session = null;

			try {
				session = openSession();

				gsFavourite = (GSFavourite)session.get(GSFavouriteImpl.class,
						primaryKey);

				if (gsFavourite != null) {
					cacheResult(gsFavourite);
				}
				else {
					EntityCacheUtil.putResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
						GSFavouriteImpl.class, primaryKey, _nullGSFavourite);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GSFavouriteModelImpl.ENTITY_CACHE_ENABLED,
					GSFavouriteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gsFavourite;
	}

	/**
	 * Returns the g s favourite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SPGSFavouriteId the primary key of the g s favourite
	 * @return the g s favourite, or <code>null</code> if a g s favourite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GSFavourite fetchByPrimaryKey(long SPGSFavouriteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)SPGSFavouriteId);
	}

	/**
	 * Returns all the g s favourites.
	 *
	 * @return the g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g s favourites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @return the range of g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g s favourites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.genericsearch.model.impl.GSFavouriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g s favourites
	 * @param end the upper bound of the range of g s favourites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g s favourites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GSFavourite> findAll(int start, int end,
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

		List<GSFavourite> list = (List<GSFavourite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GSFAVOURITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GSFAVOURITE;

				if (pagination) {
					sql = sql.concat(GSFavouriteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GSFavourite>(list);
				}
				else {
					list = (List<GSFavourite>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g s favourites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GSFavourite gsFavourite : findAll()) {
			remove(gsFavourite);
		}
	}

	/**
	 * Returns the number of g s favourites.
	 *
	 * @return the number of g s favourites
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

				Query q = session.createQuery(_SQL_COUNT_GSFAVOURITE);

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
	 * Initializes the g s favourite persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.genericsearch.model.GSFavourite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GSFavourite>> listenersList = new ArrayList<ModelListener<GSFavourite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GSFavourite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GSFavouriteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GSFAVOURITE = "SELECT gsFavourite FROM GSFavourite gsFavourite";
	private static final String _SQL_SELECT_GSFAVOURITE_WHERE = "SELECT gsFavourite FROM GSFavourite gsFavourite WHERE ";
	private static final String _SQL_COUNT_GSFAVOURITE = "SELECT COUNT(gsFavourite) FROM GSFavourite gsFavourite";
	private static final String _SQL_COUNT_GSFAVOURITE_WHERE = "SELECT COUNT(gsFavourite) FROM GSFavourite gsFavourite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gsFavourite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GSFavourite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GSFavourite exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GSFavouritePersistenceImpl.class);
	private static GSFavourite _nullGSFavourite = new GSFavouriteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GSFavourite> toCacheModel() {
				return _nullGSFavouriteCacheModel;
			}
		};

	private static CacheModel<GSFavourite> _nullGSFavouriteCacheModel = new CacheModel<GSFavourite>() {
			@Override
			public GSFavourite toEntityModel() {
				return _nullGSFavourite;
			}
		};
}