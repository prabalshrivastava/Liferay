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

package com.sambaash.platform.srv.mail.service.persistence;

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

import com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;
import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;
import com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail link tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTrackingPersistence
 * @see SPMailLinkTrackingUtil
 * @generated
 */
public class SPMailLinkTrackingPersistenceImpl extends BasePersistenceImpl<SPMailLinkTracking>
	implements SPMailLinkTrackingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailLinkTrackingUtil} to access the s p mail link tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailLinkTrackingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID =
		new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndSubscribersId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID =
		new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndSubscribersId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPMailLinkTrackingModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailLinkTrackingModelImpl.SPMAILCAMPAIGNSUBSCRIBERSID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID =
		new FinderPath(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndSubscribersId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the matching s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws SystemException {
		return findByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param start the lower bound of the range of s p mail link trackings
	 * @param end the upper bound of the range of s p mail link trackings (not inclusive)
	 * @return the range of matching s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end) throws SystemException {
		return findByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param start the lower bound of the range of s p mail link trackings
	 * @param end the upper bound of the range of s p mail link trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID;
			finderArgs = new Object[] {
					spMailCampaignId, spMailCampaignSubscribersId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID;
			finderArgs = new Object[] {
					spMailCampaignId, spMailCampaignSubscribersId,
					
					start, end, orderByComparator
				};
		}

		List<SPMailLinkTracking> list = (List<SPMailLinkTracking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailLinkTracking spMailLinkTracking : list) {
				if ((spMailCampaignId != spMailLinkTracking.getSpMailCampaignId()) ||
						(spMailCampaignSubscribersId != spMailLinkTracking.getSpMailCampaignSubscribersId())) {
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

			query.append(_SQL_SELECT_SPMAILLINKTRACKING_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailLinkTrackingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailCampaignSubscribersId);

				if (!pagination) {
					list = (List<SPMailLinkTracking>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailLinkTracking>(list);
				}
				else {
					list = (List<SPMailLinkTracking>)QueryUtil.list(q,
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
	 * Returns the first s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail link tracking
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a matching s p mail link tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking findByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkTrackingException, SystemException {
		SPMailLinkTracking spMailLinkTracking = fetchByCampaignIdAndSubscribersId_First(spMailCampaignId,
				spMailCampaignSubscribersId, orderByComparator);

		if (spMailLinkTracking != null) {
			return spMailLinkTracking;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailCampaignSubscribersId=");
		msg.append(spMailCampaignSubscribersId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkTrackingException(msg.toString());
	}

	/**
	 * Returns the first s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking fetchByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailLinkTracking> list = findByCampaignIdAndSubscribersId(spMailCampaignId,
				spMailCampaignSubscribersId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail link tracking
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a matching s p mail link tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking findByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		OrderByComparator orderByComparator)
		throws NoSuchLinkTrackingException, SystemException {
		SPMailLinkTracking spMailLinkTracking = fetchByCampaignIdAndSubscribersId_Last(spMailCampaignId,
				spMailCampaignSubscribersId, orderByComparator);

		if (spMailLinkTracking != null) {
			return spMailLinkTracking;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailCampaignSubscribersId=");
		msg.append(spMailCampaignSubscribersId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkTrackingException(msg.toString());
	}

	/**
	 * Returns the last s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking fetchByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndSubscribersId(spMailCampaignId,
				spMailCampaignSubscribersId);

		if (count == 0) {
			return null;
		}

		List<SPMailLinkTracking> list = findByCampaignIdAndSubscribersId(spMailCampaignId,
				spMailCampaignSubscribersId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail link trackings before and after the current s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailLinkTrackingId the primary key of the current s p mail link tracking
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail link tracking
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking[] findByCampaignIdAndSubscribersId_PrevAndNext(
		long spMailLinkTrackingId, long spMailCampaignId,
		long spMailCampaignSubscribersId, OrderByComparator orderByComparator)
		throws NoSuchLinkTrackingException, SystemException {
		SPMailLinkTracking spMailLinkTracking = findByPrimaryKey(spMailLinkTrackingId);

		Session session = null;

		try {
			session = openSession();

			SPMailLinkTracking[] array = new SPMailLinkTrackingImpl[3];

			array[0] = getByCampaignIdAndSubscribersId_PrevAndNext(session,
					spMailLinkTracking, spMailCampaignId,
					spMailCampaignSubscribersId, orderByComparator, true);

			array[1] = spMailLinkTracking;

			array[2] = getByCampaignIdAndSubscribersId_PrevAndNext(session,
					spMailLinkTracking, spMailCampaignId,
					spMailCampaignSubscribersId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailLinkTracking getByCampaignIdAndSubscribersId_PrevAndNext(
		Session session, SPMailLinkTracking spMailLinkTracking,
		long spMailCampaignId, long spMailCampaignSubscribersId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILLINKTRACKING_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2);

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
			query.append(SPMailLinkTrackingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailCampaignSubscribersId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailLinkTracking);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailLinkTracking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId) throws SystemException {
		for (SPMailLinkTracking spMailLinkTracking : findByCampaignIdAndSubscribersId(
				spMailCampaignId, spMailCampaignSubscribersId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailLinkTracking);
		}
	}

	/**
	 * Returns the number of s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	 * @return the number of matching s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailCampaignSubscribersId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILLINKTRACKING_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailCampaignSubscribersId);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNID_2 =
		"spMailLinkTracking.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDSUBSCRIBERSID_SPMAILCAMPAIGNSUBSCRIBERSID_2 =
		"spMailLinkTracking.spMailCampaignSubscribersId = ?";

	public SPMailLinkTrackingPersistenceImpl() {
		setModelClass(SPMailLinkTracking.class);
	}

	/**
	 * Caches the s p mail link tracking in the entity cache if it is enabled.
	 *
	 * @param spMailLinkTracking the s p mail link tracking
	 */
	@Override
	public void cacheResult(SPMailLinkTracking spMailLinkTracking) {
		EntityCacheUtil.putResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class, spMailLinkTracking.getPrimaryKey(),
			spMailLinkTracking);

		spMailLinkTracking.resetOriginalValues();
	}

	/**
	 * Caches the s p mail link trackings in the entity cache if it is enabled.
	 *
	 * @param spMailLinkTrackings the s p mail link trackings
	 */
	@Override
	public void cacheResult(List<SPMailLinkTracking> spMailLinkTrackings) {
		for (SPMailLinkTracking spMailLinkTracking : spMailLinkTrackings) {
			if (EntityCacheUtil.getResult(
						SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
						SPMailLinkTrackingImpl.class,
						spMailLinkTracking.getPrimaryKey()) == null) {
				cacheResult(spMailLinkTracking);
			}
			else {
				spMailLinkTracking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail link trackings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailLinkTrackingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailLinkTrackingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail link tracking.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailLinkTracking spMailLinkTracking) {
		EntityCacheUtil.removeResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class, spMailLinkTracking.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPMailLinkTracking> spMailLinkTrackings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailLinkTracking spMailLinkTracking : spMailLinkTrackings) {
			EntityCacheUtil.removeResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
				SPMailLinkTrackingImpl.class, spMailLinkTracking.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p mail link tracking with the primary key. Does not add the s p mail link tracking to the database.
	 *
	 * @param spMailLinkTrackingId the primary key for the new s p mail link tracking
	 * @return the new s p mail link tracking
	 */
	@Override
	public SPMailLinkTracking create(long spMailLinkTrackingId) {
		SPMailLinkTracking spMailLinkTracking = new SPMailLinkTrackingImpl();

		spMailLinkTracking.setNew(true);
		spMailLinkTracking.setPrimaryKey(spMailLinkTrackingId);

		return spMailLinkTracking;
	}

	/**
	 * Removes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailLinkTrackingId the primary key of the s p mail link tracking
	 * @return the s p mail link tracking that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking remove(long spMailLinkTrackingId)
		throws NoSuchLinkTrackingException, SystemException {
		return remove((Serializable)spMailLinkTrackingId);
	}

	/**
	 * Removes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail link tracking
	 * @return the s p mail link tracking that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking remove(Serializable primaryKey)
		throws NoSuchLinkTrackingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailLinkTracking spMailLinkTracking = (SPMailLinkTracking)session.get(SPMailLinkTrackingImpl.class,
					primaryKey);

			if (spMailLinkTracking == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailLinkTracking);
		}
		catch (NoSuchLinkTrackingException nsee) {
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
	protected SPMailLinkTracking removeImpl(
		SPMailLinkTracking spMailLinkTracking) throws SystemException {
		spMailLinkTracking = toUnwrappedModel(spMailLinkTracking);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailLinkTracking)) {
				spMailLinkTracking = (SPMailLinkTracking)session.get(SPMailLinkTrackingImpl.class,
						spMailLinkTracking.getPrimaryKeyObj());
			}

			if (spMailLinkTracking != null) {
				session.delete(spMailLinkTracking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailLinkTracking != null) {
			clearCache(spMailLinkTracking);
		}

		return spMailLinkTracking;
	}

	@Override
	public SPMailLinkTracking updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws SystemException {
		spMailLinkTracking = toUnwrappedModel(spMailLinkTracking);

		boolean isNew = spMailLinkTracking.isNew();

		SPMailLinkTrackingModelImpl spMailLinkTrackingModelImpl = (SPMailLinkTrackingModelImpl)spMailLinkTracking;

		Session session = null;

		try {
			session = openSession();

			if (spMailLinkTracking.isNew()) {
				session.save(spMailLinkTracking);

				spMailLinkTracking.setNew(false);
			}
			else {
				session.merge(spMailLinkTracking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailLinkTrackingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailLinkTrackingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailLinkTrackingModelImpl.getOriginalSpMailCampaignId(),
						spMailLinkTrackingModelImpl.getOriginalSpMailCampaignSubscribersId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args);

				args = new Object[] {
						spMailLinkTrackingModelImpl.getSpMailCampaignId(),
						spMailLinkTrackingModelImpl.getSpMailCampaignSubscribersId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDSUBSCRIBERSID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
			SPMailLinkTrackingImpl.class, spMailLinkTracking.getPrimaryKey(),
			spMailLinkTracking);

		return spMailLinkTracking;
	}

	protected SPMailLinkTracking toUnwrappedModel(
		SPMailLinkTracking spMailLinkTracking) {
		if (spMailLinkTracking instanceof SPMailLinkTrackingImpl) {
			return spMailLinkTracking;
		}

		SPMailLinkTrackingImpl spMailLinkTrackingImpl = new SPMailLinkTrackingImpl();

		spMailLinkTrackingImpl.setNew(spMailLinkTracking.isNew());
		spMailLinkTrackingImpl.setPrimaryKey(spMailLinkTracking.getPrimaryKey());

		spMailLinkTrackingImpl.setSpMailLinkTrackingId(spMailLinkTracking.getSpMailLinkTrackingId());
		spMailLinkTrackingImpl.setSpMailCampaignId(spMailLinkTracking.getSpMailCampaignId());
		spMailLinkTrackingImpl.setSpMailCampaignEDMId(spMailLinkTracking.getSpMailCampaignEDMId());
		spMailLinkTrackingImpl.setSpMailCampaignSubscribersId(spMailLinkTracking.getSpMailCampaignSubscribersId());
		spMailLinkTrackingImpl.setLabel(spMailLinkTracking.getLabel());
		spMailLinkTrackingImpl.setLink(spMailLinkTracking.getLink());
		spMailLinkTrackingImpl.setEncryptedlink(spMailLinkTracking.getEncryptedlink());
		spMailLinkTrackingImpl.setStatus(spMailLinkTracking.isStatus());
		spMailLinkTrackingImpl.setOpenedDate(spMailLinkTracking.getOpenedDate());
		spMailLinkTrackingImpl.setCreateDate(spMailLinkTracking.getCreateDate());

		return spMailLinkTrackingImpl;
	}

	/**
	 * Returns the s p mail link tracking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail link tracking
	 * @return the s p mail link tracking
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinkTrackingException, SystemException {
		SPMailLinkTracking spMailLinkTracking = fetchByPrimaryKey(primaryKey);

		if (spMailLinkTracking == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinkTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailLinkTracking;
	}

	/**
	 * Returns the s p mail link tracking with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchLinkTrackingException} if it could not be found.
	 *
	 * @param spMailLinkTrackingId the primary key of the s p mail link tracking
	 * @return the s p mail link tracking
	 * @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking findByPrimaryKey(long spMailLinkTrackingId)
		throws NoSuchLinkTrackingException, SystemException {
		return findByPrimaryKey((Serializable)spMailLinkTrackingId);
	}

	/**
	 * Returns the s p mail link tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail link tracking
	 * @return the s p mail link tracking, or <code>null</code> if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailLinkTracking spMailLinkTracking = (SPMailLinkTracking)EntityCacheUtil.getResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
				SPMailLinkTrackingImpl.class, primaryKey);

		if (spMailLinkTracking == _nullSPMailLinkTracking) {
			return null;
		}

		if (spMailLinkTracking == null) {
			Session session = null;

			try {
				session = openSession();

				spMailLinkTracking = (SPMailLinkTracking)session.get(SPMailLinkTrackingImpl.class,
						primaryKey);

				if (spMailLinkTracking != null) {
					cacheResult(spMailLinkTracking);
				}
				else {
					EntityCacheUtil.putResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
						SPMailLinkTrackingImpl.class, primaryKey,
						_nullSPMailLinkTracking);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailLinkTrackingModelImpl.ENTITY_CACHE_ENABLED,
					SPMailLinkTrackingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailLinkTracking;
	}

	/**
	 * Returns the s p mail link tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailLinkTrackingId the primary key of the s p mail link tracking
	 * @return the s p mail link tracking, or <code>null</code> if a s p mail link tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailLinkTracking fetchByPrimaryKey(long spMailLinkTrackingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailLinkTrackingId);
	}

	/**
	 * Returns all the s p mail link trackings.
	 *
	 * @return the s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail link trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail link trackings
	 * @param end the upper bound of the range of s p mail link trackings (not inclusive)
	 * @return the range of s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail link trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail link trackings
	 * @param end the upper bound of the range of s p mail link trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail link trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailLinkTracking> findAll(int start, int end,
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

		List<SPMailLinkTracking> list = (List<SPMailLinkTracking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILLINKTRACKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILLINKTRACKING;

				if (pagination) {
					sql = sql.concat(SPMailLinkTrackingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailLinkTracking>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailLinkTracking>(list);
				}
				else {
					list = (List<SPMailLinkTracking>)QueryUtil.list(q,
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
	 * Removes all the s p mail link trackings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailLinkTracking spMailLinkTracking : findAll()) {
			remove(spMailLinkTracking);
		}
	}

	/**
	 * Returns the number of s p mail link trackings.
	 *
	 * @return the number of s p mail link trackings
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILLINKTRACKING);

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
	 * Initializes the s p mail link tracking persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailLinkTracking")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailLinkTracking>> listenersList = new ArrayList<ModelListener<SPMailLinkTracking>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailLinkTracking>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailLinkTrackingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILLINKTRACKING = "SELECT spMailLinkTracking FROM SPMailLinkTracking spMailLinkTracking";
	private static final String _SQL_SELECT_SPMAILLINKTRACKING_WHERE = "SELECT spMailLinkTracking FROM SPMailLinkTracking spMailLinkTracking WHERE ";
	private static final String _SQL_COUNT_SPMAILLINKTRACKING = "SELECT COUNT(spMailLinkTracking) FROM SPMailLinkTracking spMailLinkTracking";
	private static final String _SQL_COUNT_SPMAILLINKTRACKING_WHERE = "SELECT COUNT(spMailLinkTracking) FROM SPMailLinkTracking spMailLinkTracking WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailLinkTracking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailLinkTracking exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailLinkTracking exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailLinkTrackingPersistenceImpl.class);
	private static SPMailLinkTracking _nullSPMailLinkTracking = new SPMailLinkTrackingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailLinkTracking> toCacheModel() {
				return _nullSPMailLinkTrackingCacheModel;
			}
		};

	private static CacheModel<SPMailLinkTracking> _nullSPMailLinkTrackingCacheModel =
		new CacheModel<SPMailLinkTracking>() {
			@Override
			public SPMailLinkTracking toEntityModel() {
				return _nullSPMailLinkTracking;
			}
		};
}