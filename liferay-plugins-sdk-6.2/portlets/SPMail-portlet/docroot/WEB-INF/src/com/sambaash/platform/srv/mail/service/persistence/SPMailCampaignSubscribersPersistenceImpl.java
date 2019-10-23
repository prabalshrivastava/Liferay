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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;
import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail campaign subscribers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersPersistence
 * @see SPMailCampaignSubscribersUtil
 * @generated
 */
public class SPMailCampaignSubscribersPersistenceImpl
	extends BasePersistenceImpl<SPMailCampaignSubscribers>
	implements SPMailCampaignSubscribersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailCampaignSubscribersUtil} to access the s p mail campaign subscribers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailCampaignSubscribersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId) throws SystemException {
		return findByCampaignId(spMailCampaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end) throws SystemException {
		return findByCampaignId(spMailCampaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { spMailCampaignId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] {
					spMailCampaignId,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignId_First(
		long spMailCampaignId, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignId_First(spMailCampaignId,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignId_First(
		long spMailCampaignId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignId(spMailCampaignId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignId_Last(
		long spMailCampaignId, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignId_Last(spMailCampaignId,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignId_Last(
		long spMailCampaignId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCampaignId(spMailCampaignId);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignId(spMailCampaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignId_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignId_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId,
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

	protected SPMailCampaignSubscribers getByCampaignId_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long spMailCampaignId)
		throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignId(
				spMailCampaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignId(long spMailCampaignId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { spMailCampaignId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2 = "spMailCampaignSubscribers.spMailCampaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SPMailCampaignSubscribersModelImpl.USERID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((userId != spMailCampaignSubscribers.getUserId())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByUserId_First(userId,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByUserId_Last(userId,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where userId = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByUserId_PrevAndNext(
		long spMailCampaignSubscribersId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByUserId_PrevAndNext(session,
					spMailCampaignSubscribers, userId, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByUserId_PrevAndNext(session,
					spMailCampaignSubscribers, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByUserId_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByUserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p mail campaign subscriberses
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

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spMailCampaignSubscribers.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndOpened",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndOpened",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SPMailCampaignSubscribersModelImpl.USERID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDOPENED = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndOpened",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserIdAndOpened(long userId,
		boolean opened) throws SystemException {
		return findByUserIdAndOpened(userId, opened, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserIdAndOpened(long userId,
		boolean opened, int start, int end) throws SystemException {
		return findByUserIdAndOpened(userId, opened, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByUserIdAndOpened(long userId,
		boolean opened, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDOPENED;
			finderArgs = new Object[] { userId, opened };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDOPENED;
			finderArgs = new Object[] {
					userId, opened,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((userId != spMailCampaignSubscribers.getUserId()) ||
						(opened != spMailCampaignSubscribers.getOpened())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDOPENED_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDOPENED_OPENED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(opened);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByUserIdAndOpened_First(long userId,
		boolean opened, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByUserIdAndOpened_First(userId,
				opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByUserIdAndOpened_First(long userId,
		boolean opened, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailCampaignSubscribers> list = findByUserIdAndOpened(userId,
				opened, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByUserIdAndOpened_Last(long userId,
		boolean opened, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByUserIdAndOpened_Last(userId,
				opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByUserIdAndOpened_Last(long userId,
		boolean opened, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndOpened(userId, opened);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByUserIdAndOpened(userId,
				opened, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param userId the user ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByUserIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long userId, boolean opened,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByUserIdAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, userId, opened,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByUserIdAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, userId, opened,
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

	protected SPMailCampaignSubscribers getByUserIdAndOpened_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long userId, boolean opened, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDOPENED_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDOPENED_OPENED_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(opened);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where userId = &#63; and opened = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndOpened(long userId, boolean opened)
		throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByUserIdAndOpened(
				userId, opened, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	 *
	 * @param userId the user ID
	 * @param opened the opened
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndOpened(long userId, boolean opened)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDOPENED;

		Object[] finderArgs = new Object[] { userId, opened };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDOPENED_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDOPENED_OPENED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(opened);

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

	private static final String _FINDER_COLUMN_USERIDANDOPENED_USERID_2 = "spMailCampaignSubscribers.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDOPENED_OPENED_2 = "spMailCampaignSubscribers.opened = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndMailType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndMailType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDMAILTYPE = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndMailType",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType) throws SystemException {
		return findByCampaignIdAndMailType(spMailCampaignId, spMailType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end)
		throws SystemException {
		return findByCampaignIdAndMailType(spMailCampaignId, spMailType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE;
			finderArgs = new Object[] { spMailCampaignId, spMailType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndMailType_First(spMailCampaignId,
				spMailType, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdAndMailType(spMailCampaignId,
				spMailType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndMailType_Last(spMailCampaignId,
				spMailType, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndMailType(spMailCampaignId, spMailType);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdAndMailType(spMailCampaignId,
				spMailType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdAndMailType_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdAndMailType_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdAndMailType_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
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

	protected SPMailCampaignSubscribers getByCampaignIdAndMailType_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILTYPE_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdAndMailType(
				spMailCampaignId, spMailType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDMAILTYPE;

		Object[] finderArgs = new Object[] { spMailCampaignId, spMailType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDMAILTYPE_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.STATUS_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDSTATUS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws SystemException {
		return findByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
			status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end)
		throws SystemException {
		return findByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
			status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS;
			finderArgs = new Object[] { spMailCampaignId, spMailType, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, status,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						(status != spMailCampaignSubscribers.getStatus())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndStatus_First(spMailCampaignId,
				spMailType, status, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndStatus(spMailCampaignId,
				spMailType, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndStatus_Last(spMailCampaignId,
				spMailType, status, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdMailTypeAndStatus(spMailCampaignId,
				spMailType, status);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndStatus(spMailCampaignId,
				spMailType, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndStatus_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, int status, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeAndStatus_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					status, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeAndStatus_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeAndStatus_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILTYPE_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_STATUS_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeAndStatus(long spMailCampaignId,
		int spMailType, int status) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeAndStatus(
				spMailCampaignId, spMailType, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param status the status
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeAndStatus(long spMailCampaignId,
		int spMailType, int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDSTATUS;

		Object[] finderArgs = new Object[] { spMailCampaignId, spMailType, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDSTATUS_STATUS_2 =
		"spMailCampaignSubscribers.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeAndOpened",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeAndOpened",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeAndOpened",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws SystemException {
		return findByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
			opened, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end) throws SystemException {
		return findByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
			opened, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED;
			finderArgs = new Object[] { spMailCampaignId, spMailType, opened };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						(opened != spMailCampaignSubscribers.getOpened())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_OPENED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndOpened_First(spMailCampaignId,
				spMailType, opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndOpened(spMailCampaignId,
				spMailType, opened, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndOpened_Last(spMailCampaignId,
				spMailType, opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdMailTypeAndOpened(spMailCampaignId,
				spMailType, opened);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndOpened(spMailCampaignId,
				spMailType, opened, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeAndOpened_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, boolean opened,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILTYPE_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_OPENED_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		qPos.add(opened);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeAndOpened(long spMailCampaignId,
		int spMailType, boolean opened) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeAndOpened(
				spMailCampaignId, spMailType, opened, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeAndOpened(long spMailCampaignId,
		int spMailType, boolean opened) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDOPENED;

		Object[] finderArgs = new Object[] { spMailCampaignId, spMailType, opened };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_OPENED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDOPENED_OPENED_2 =
		"spMailCampaignSubscribers.opened = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCampaignIdMailTypeAndEmailAddress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeAndEmailAddress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, String emailAddress)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
				spMailType, emailAddress);

		if (spMailCampaignSubscribers == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spMailCampaignId=");
			msg.append(spMailCampaignId);

			msg.append(", spMailType=");
			msg.append(spMailType);

			msg.append(", emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignSubscribersException(msg.toString());
		}

		return spMailCampaignSubscribers;
	}

	/**
	 * Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, String emailAddress)
		throws SystemException {
		return fetchByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress, true);
	}

	/**
	 * Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, String emailAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, emailAddress
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
					finderArgs, this);
		}

		if (result instanceof SPMailCampaignSubscribers) {
			SPMailCampaignSubscribers spMailCampaignSubscribers = (SPMailCampaignSubscribers)result;

			if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
					(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
					!Validator.equals(emailAddress,
						spMailCampaignSubscribers.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILTYPE_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
				}

				List<SPMailCampaignSubscribers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
						finderArgs, list);
				}
				else {
					SPMailCampaignSubscribers spMailCampaignSubscribers = list.get(0);

					result = spMailCampaignSubscribers;

					cacheResult(spMailCampaignSubscribers);

					if ((spMailCampaignSubscribers.getSpMailCampaignId() != spMailCampaignId) ||
							(spMailCampaignSubscribers.getSpMailType() != spMailType) ||
							(spMailCampaignSubscribers.getEmailAddress() == null) ||
							!spMailCampaignSubscribers.getEmailAddress()
														  .equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
							finderArgs, spMailCampaignSubscribers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
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
			return (SPMailCampaignSubscribers)result;
		}
	}

	/**
	 * Removes the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param emailAddress the email address
	 * @return the s p mail campaign subscribers that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers removeByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, String emailAddress)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
				spMailType, emailAddress);

		return remove(spMailCampaignSubscribers);
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param emailAddress the email address
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeAndEmailAddress(long spMailCampaignId,
		int spMailType, String emailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, emailAddress
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILTYPE_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_1 =
		"spMailCampaignSubscribers.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_2 =
		"lower(spMailCampaignSubscribers.emailAddress) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDEMAILADDRESS_EMAILADDRESS_3 =
		"(spMailCampaignSubscribers.emailAddress IS NULL OR spMailCampaignSubscribers.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndEmailAddress",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndEmailAddress",
			new String[] { Long.class.getName(), String.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndEmailAddress",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, String emailAddress) throws SystemException {
		return findByCampaignIdAndEmailAddress(spMailCampaignId, emailAddress,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, String emailAddress, int start, int end)
		throws SystemException {
		return findByCampaignIdAndEmailAddress(spMailCampaignId, emailAddress,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, String emailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS;
			finderArgs = new Object[] { spMailCampaignId, emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS;
			finderArgs = new Object[] {
					spMailCampaignId, emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						!Validator.equals(emailAddress,
							spMailCampaignSubscribers.getEmailAddress())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndEmailAddress_First(spMailCampaignId,
				emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdAndEmailAddress(spMailCampaignId,
				emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndEmailAddress_Last(spMailCampaignId,
				emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndEmailAddress(spMailCampaignId,
				emailAddress);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdAndEmailAddress(spMailCampaignId,
				emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, emailAddress,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, emailAddress,
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

	protected SPMailCampaignSubscribers getByCampaignIdAndEmailAddress_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (bindEmailAddress) {
			qPos.add(emailAddress.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndEmailAddress(long spMailCampaignId,
		String emailAddress) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdAndEmailAddress(
				spMailCampaignId, emailAddress, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param emailAddress the email address
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndEmailAddress(long spMailCampaignId,
		String emailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDEMAILADDRESS;

		Object[] finderArgs = new Object[] { spMailCampaignId, emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_1 =
		"spMailCampaignSubscribers.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_2 =
		"lower(spMailCampaignSubscribers.emailAddress) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDEMAILADDRESS_EMAILADDRESS_3 =
		"(spMailCampaignSubscribers.emailAddress IS NULL OR spMailCampaignSubscribers.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress) throws SystemException {
		return findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, int start, int end) throws SystemException {
		return findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, emailAddress
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(emailAddress,
							spMailCampaignSubscribers.getEmailAddress())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_OPENED_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndEmailAddress_First(spMailCampaignId,
				spMailType, opened, emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
				spMailType, opened, emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndEmailAddress_Last(spMailCampaignId,
				spMailType, opened, emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
				spMailType, opened, emailAddress);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
				spMailType, opened, emailAddress, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, emailAddress, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILTYPE_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_OPENED_2);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		qPos.add(opened);

		if (bindEmailAddress) {
			qPos.add(emailAddress.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeOpenedAndEmailAddress(
				spMailCampaignId, spMailType, opened, emailAddress,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		String emailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, opened, emailAddress
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_OPENED_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_1 =
		"spMailCampaignSubscribers.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_2 =
		"lower(spMailCampaignSubscribers.emailAddress) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS_EMAILADDRESS_3 =
		"(spMailCampaignSubscribers.emailAddress IS NULL OR spMailCampaignSubscribers.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdOpenedAndEmailAddress",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, String emailAddress)
		throws SystemException {
		return findByCampaignIdOpenedAndEmailAddress(spMailCampaignId, opened,
			emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, String emailAddress, int start,
		int end) throws SystemException {
		return findByCampaignIdOpenedAndEmailAddress(spMailCampaignId, opened,
			emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, String emailAddress, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS;
			finderArgs = new Object[] { spMailCampaignId, opened, emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS;
			finderArgs = new Object[] {
					spMailCampaignId, opened, emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(emailAddress,
							spMailCampaignSubscribers.getEmailAddress())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_OPENED_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndEmailAddress_First(spMailCampaignId,
				opened, emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
				opened, emailAddress, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndEmailAddress_Last(spMailCampaignId,
				opened, emailAddress, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
				opened, emailAddress);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
				opened, emailAddress, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdOpenedAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					emailAddress, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdOpenedAndEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdOpenedAndEmailAddress_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, boolean opened, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_OPENED_2);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(opened);

		if (bindEmailAddress) {
			qPos.add(emailAddress.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdOpenedAndEmailAddress(long spMailCampaignId,
		boolean opened, String emailAddress) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdOpenedAndEmailAddress(
				spMailCampaignId, opened, emailAddress, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param emailAddress the email address
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdOpenedAndEmailAddress(long spMailCampaignId,
		boolean opened, String emailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, opened, emailAddress
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_OPENED_2);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_1 =
		"spMailCampaignSubscribers.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_2 =
		"lower(spMailCampaignSubscribers.emailAddress) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDEMAILADDRESS_EMAILADDRESS_3 =
		"(spMailCampaignSubscribers.emailAddress IS NULL OR spMailCampaignSubscribers.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.FIRSTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened, String firstName)
		throws SystemException {
		return findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, int start, int end) throws SystemException {
		return findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, firstName
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, firstName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(firstName,
							spMailCampaignSubscribers.getFirstName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_OPENED_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndFirstName_First(spMailCampaignId,
				spMailType, opened, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
				spMailType, opened, firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndFirstName_Last(spMailCampaignId,
				spMailType, opened, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
				spMailType, opened, firstName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
				spMailType, opened, firstName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, firstName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, firstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, boolean opened,
		String firstName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILTYPE_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_OPENED_2);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		qPos.add(opened);

		if (bindFirstName) {
			qPos.add(firstName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened, String firstName)
		throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeOpenedAndFirstName(
				spMailCampaignId, spMailType, opened, firstName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param firstName the first name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened, String firstName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, opened, firstName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_OPENED_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_1 =
		"spMailCampaignSubscribers.firstName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_2 =
		"lower(spMailCampaignSubscribers.firstName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME_FIRSTNAME_3 =
		"(spMailCampaignSubscribers.firstName IS NULL OR spMailCampaignSubscribers.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.FIRSTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeAndFirstName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, String firstName)
		throws SystemException {
		return findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, String firstName, int start,
		int end) throws SystemException {
		return findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, String firstName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME;
			finderArgs = new Object[] { spMailCampaignId, spMailType, firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, firstName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						!Validator.equals(firstName,
							spMailCampaignSubscribers.getFirstName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILTYPE_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndFirstName_First(spMailCampaignId,
				spMailType, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
				spMailType, firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndFirstName_Last(spMailCampaignId,
				spMailType, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdMailTypeAndFirstName(spMailCampaignId,
				spMailType, firstName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
				spMailType, firstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, String firstName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					firstName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					firstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeAndFirstName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, String firstName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILTYPE_2);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		if (bindFirstName) {
			qPos.add(firstName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeAndFirstName(long spMailCampaignId,
		int spMailType, String firstName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeAndFirstName(
				spMailCampaignId, spMailType, firstName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param firstName the first name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeAndFirstName(long spMailCampaignId,
		int spMailType, String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, firstName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILTYPE_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_1 =
		"spMailCampaignSubscribers.firstName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_2 =
		"lower(spMailCampaignSubscribers.firstName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDFIRSTNAME_FIRSTNAME_3 =
		"(spMailCampaignSubscribers.firstName IS NULL OR spMailCampaignSubscribers.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.FIRSTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdOpenedAndFirstName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, String firstName)
		throws SystemException {
		return findByCampaignIdOpenedAndFirstName(spMailCampaignId, opened,
			firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, String firstName, int start,
		int end) throws SystemException {
		return findByCampaignIdOpenedAndFirstName(spMailCampaignId, opened,
			firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, String firstName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME;
			finderArgs = new Object[] { spMailCampaignId, opened, firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, opened, firstName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(firstName,
							spMailCampaignSubscribers.getFirstName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_OPENED_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndFirstName_First(spMailCampaignId,
				opened, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndFirstName(spMailCampaignId,
				opened, firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndFirstName_Last(spMailCampaignId,
				opened, firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdOpenedAndFirstName(spMailCampaignId,
				opened, firstName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndFirstName(spMailCampaignId,
				opened, firstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, String firstName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdOpenedAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					firstName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdOpenedAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					firstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdOpenedAndFirstName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, boolean opened, String firstName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_OPENED_2);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(opened);

		if (bindFirstName) {
			qPos.add(firstName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdOpenedAndFirstName(long spMailCampaignId,
		boolean opened, String firstName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdOpenedAndFirstName(
				spMailCampaignId, opened, firstName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param firstName the first name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdOpenedAndFirstName(long spMailCampaignId,
		boolean opened, String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDFIRSTNAME;

		Object[] finderArgs = new Object[] { spMailCampaignId, opened, firstName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_OPENED_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_1 =
		"spMailCampaignSubscribers.firstName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_2 =
		"lower(spMailCampaignSubscribers.firstName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDFIRSTNAME_FIRSTNAME_3 =
		"(spMailCampaignSubscribers.firstName IS NULL OR spMailCampaignSubscribers.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndFirstName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndFirstName",
			new String[] { Long.class.getName(), String.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.FIRSTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDFIRSTNAME = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndFirstName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, String firstName) throws SystemException {
		return findByCampaignIdAndFirstName(spMailCampaignId, firstName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, String firstName, int start, int end)
		throws SystemException {
		return findByCampaignIdAndFirstName(spMailCampaignId, firstName, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, String firstName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME;
			finderArgs = new Object[] { spMailCampaignId, firstName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, firstName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						!Validator.equals(firstName,
							spMailCampaignSubscribers.getFirstName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndFirstName_First(
		long spMailCampaignId, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndFirstName_First(spMailCampaignId,
				firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_First(
		long spMailCampaignId, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdAndFirstName(spMailCampaignId,
				firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndFirstName_Last(
		long spMailCampaignId, String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndFirstName_Last(spMailCampaignId,
				firstName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_Last(
		long spMailCampaignId, String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndFirstName(spMailCampaignId, firstName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdAndFirstName(spMailCampaignId,
				firstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		String firstName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, firstName,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdAndFirstName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, firstName,
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

	protected SPMailCampaignSubscribers getByCampaignIdAndFirstName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, String firstName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (bindFirstName) {
			qPos.add(firstName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndFirstName(long spMailCampaignId,
		String firstName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdAndFirstName(
				spMailCampaignId, firstName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param firstName the first name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndFirstName(long spMailCampaignId,
		String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDFIRSTNAME;

		Object[] finderArgs = new Object[] { spMailCampaignId, firstName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_SPMAILCAMPAIGNID_2);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindFirstName) {
					qPos.add(firstName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_1 =
		"spMailCampaignSubscribers.firstName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_2 =
		"lower(spMailCampaignSubscribers.firstName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDFIRSTNAME_FIRSTNAME_3 =
		"(spMailCampaignSubscribers.firstName IS NULL OR spMailCampaignSubscribers.firstName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeOpenedAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.LASTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeOpenedAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened, String lastName)
		throws SystemException {
		return findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		int start, int end) throws SystemException {
		return findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, lastName
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, opened, lastName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(lastName,
							spMailCampaignSubscribers.getLastName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_OPENED_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndLastName_First(spMailCampaignId,
				spMailType, opened, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
				spMailType, opened, lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeOpenedAndLastName_Last(spMailCampaignId,
				spMailType, opened, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
				spMailType, opened, lastName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
				spMailType, opened, lastName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, lastName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					opened, lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, boolean opened, String lastName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILTYPE_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_OPENED_2);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		qPos.add(opened);

		if (bindLastName) {
			qPos.add(lastName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened, String lastName)
		throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeOpenedAndLastName(
				spMailCampaignId, spMailType, opened, lastName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param opened the opened
	 * @param lastName the last name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened, String lastName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, opened, lastName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILTYPE_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_OPENED_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				qPos.add(opened);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_1 =
		"spMailCampaignSubscribers.lastName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_2 =
		"lower(spMailCampaignSubscribers.lastName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME_LASTNAME_3 =
		"(spMailCampaignSubscribers.lastName IS NULL OR spMailCampaignSubscribers.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdMailTypeAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdMailTypeAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.SPMAILTYPE_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.LASTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailTypeAndLastName",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, String lastName)
		throws SystemException {
		return findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, String lastName, int start,
		int end) throws SystemException {
		return findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, String lastName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME;
			finderArgs = new Object[] { spMailCampaignId, spMailType, lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, spMailType, lastName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(spMailType != spMailCampaignSubscribers.getSpMailType()) ||
						!Validator.equals(lastName,
							spMailCampaignSubscribers.getLastName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILTYPE_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndLastName_First(spMailCampaignId,
				spMailType, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndLastName(spMailCampaignId,
				spMailType, lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdMailTypeAndLastName_Last(spMailCampaignId,
				spMailType, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", spMailType=");
		msg.append(spMailType);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdMailTypeAndLastName(spMailCampaignId,
				spMailType, lastName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdMailTypeAndLastName(spMailCampaignId,
				spMailType, lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, String lastName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdMailTypeAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					lastName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdMailTypeAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, spMailType,
					lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdMailTypeAndLastName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, int spMailType, String lastName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILTYPE_2);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(spMailType);

		if (bindLastName) {
			qPos.add(lastName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdMailTypeAndLastName(long spMailCampaignId,
		int spMailType, String lastName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdMailTypeAndLastName(
				spMailCampaignId, spMailType, lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param spMailType the sp mail type
	 * @param lastName the last name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailTypeAndLastName(long spMailCampaignId,
		int spMailType, String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDLASTNAME;

		Object[] finderArgs = new Object[] {
				spMailCampaignId, spMailType, lastName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILTYPE_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(spMailType);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_SPMAILTYPE_2 =
		"spMailCampaignSubscribers.spMailType = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_1 =
		"spMailCampaignSubscribers.lastName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_2 =
		"lower(spMailCampaignSubscribers.lastName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPEANDLASTNAME_LASTNAME_3 =
		"(spMailCampaignSubscribers.lastName IS NULL OR spMailCampaignSubscribers.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdOpenedAndLastName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdOpenedAndLastName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.LASTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdOpenedAndLastName",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, String lastName)
		throws SystemException {
		return findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, String lastName, int start,
		int end) throws SystemException {
		return findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, String lastName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME;
			finderArgs = new Object[] { spMailCampaignId, opened, lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, opened, lastName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(opened != spMailCampaignSubscribers.getOpened()) ||
						!Validator.equals(lastName,
							spMailCampaignSubscribers.getLastName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_OPENED_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndLastName_First(spMailCampaignId,
				opened, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndLastName(spMailCampaignId,
				opened, lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdOpenedAndLastName_Last(spMailCampaignId,
				opened, lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdOpenedAndLastName(spMailCampaignId,
				opened, lastName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdOpenedAndLastName(spMailCampaignId,
				opened, lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, String lastName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdOpenedAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					lastName, orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdOpenedAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					lastName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaignSubscribers getByCampaignIdOpenedAndLastName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, boolean opened, String lastName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_OPENED_2);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(opened);

		if (bindLastName) {
			qPos.add(lastName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdOpenedAndLastName(long spMailCampaignId,
		boolean opened, String lastName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdOpenedAndLastName(
				spMailCampaignId, opened, lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param lastName the last name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdOpenedAndLastName(long spMailCampaignId,
		boolean opened, String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDLASTNAME;

		Object[] finderArgs = new Object[] { spMailCampaignId, opened, lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_OPENED_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_OPENED_2 =
		"spMailCampaignSubscribers.opened = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_1 =
		"spMailCampaignSubscribers.lastName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_2 =
		"lower(spMailCampaignSubscribers.lastName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDOPENEDANDLASTNAME_LASTNAME_3 =
		"(spMailCampaignSubscribers.lastName IS NULL OR spMailCampaignSubscribers.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndLastName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndLastName",
			new String[] { Long.class.getName(), String.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.LASTNAME_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDLASTNAME = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndLastName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, String lastName) throws SystemException {
		return findByCampaignIdAndLastName(spMailCampaignId, lastName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, String lastName, int start, int end)
		throws SystemException {
		return findByCampaignIdAndLastName(spMailCampaignId, lastName, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, String lastName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME;
			finderArgs = new Object[] { spMailCampaignId, lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME;
			finderArgs = new Object[] {
					spMailCampaignId, lastName,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						!Validator.equals(lastName,
							spMailCampaignSubscribers.getLastName())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_SPMAILCAMPAIGNID_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndLastName_First(
		long spMailCampaignId, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndLastName_First(spMailCampaignId,
				lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndLastName_First(
		long spMailCampaignId, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdAndLastName(spMailCampaignId,
				lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndLastName_Last(
		long spMailCampaignId, String lastName,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndLastName_Last(spMailCampaignId,
				lastName, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", lastName=");
		msg.append(lastName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndLastName_Last(
		long spMailCampaignId, String lastName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndLastName(spMailCampaignId, lastName);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdAndLastName(spMailCampaignId,
				lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		String lastName, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, lastName,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdAndLastName_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, lastName,
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

	protected SPMailCampaignSubscribers getByCampaignIdAndLastName_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, String lastName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_SPMAILCAMPAIGNID_2);

		boolean bindLastName = false;

		if (lastName == null) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_1);
		}
		else if (lastName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (bindLastName) {
			qPos.add(lastName.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndLastName(long spMailCampaignId,
		String lastName) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdAndLastName(
				spMailCampaignId, lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param lastName the last name
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndLastName(long spMailCampaignId,
		String lastName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDLASTNAME;

		Object[] finderArgs = new Object[] { spMailCampaignId, lastName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_SPMAILCAMPAIGNID_2);

			boolean bindLastName = false;

			if (lastName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_1);
			}
			else if (lastName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (bindLastName) {
					qPos.add(lastName.toLowerCase());
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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_1 = "spMailCampaignSubscribers.lastName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_2 = "lower(spMailCampaignSubscribers.lastName) = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDLASTNAME_LASTNAME_3 = "(spMailCampaignSubscribers.lastName IS NULL OR spMailCampaignSubscribers.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailAddress",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailAddress",
			new String[] { String.class.getName() },
			SPMailCampaignSubscribersModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAddress", new String[] { String.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByEmailAddress(
		String emailAddress) throws SystemException {
		return findByEmailAddress(emailAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByEmailAddress(
		String emailAddress, int start, int end) throws SystemException {
		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByEmailAddress(
		String emailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] { emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] {
					emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if (!Validator.equals(emailAddress,
							spMailCampaignSubscribers.getEmailAddress())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
				}

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByEmailAddress_First(
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByEmailAddress_First(emailAddress,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByEmailAddress_First(
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPMailCampaignSubscribers> list = findByEmailAddress(emailAddress,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByEmailAddress_Last(
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByEmailAddress_Last(emailAddress,
				orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByEmailAddress_Last(
		String emailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByEmailAddress(emailAddress,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, emailAddress, orderByComparator,
					true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByEmailAddress_PrevAndNext(session,
					spMailCampaignSubscribers, emailAddress, orderByComparator,
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

	protected SPMailCampaignSubscribers getByEmailAddress_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		String emailAddress, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailAddress(String emailAddress)
		throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByEmailAddress(
				emailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress.toLowerCase());
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "spMailCampaignSubscribers.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "lower(spMailCampaignSubscribers.emailAddress) = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(spMailCampaignSubscribers.emailAddress IS NULL OR spMailCampaignSubscribers.emailAddress = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MESSAGEID = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMessageId", new String[] { String.class.getName() },
			SPMailCampaignSubscribersModelImpl.MESSAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMessageId", new String[] { String.class.getName() });

	/**
	 * Returns the s p mail campaign subscribers where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	 *
	 * @param messageId the message ID
	 * @return the matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByMessageId(String messageId)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByMessageId(messageId);

		if (spMailCampaignSubscribers == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignSubscribersException(msg.toString());
		}

		return spMailCampaignSubscribers;
	}

	/**
	 * Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param messageId the message ID
	 * @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByMessageId(String messageId)
		throws SystemException {
		return fetchByMessageId(messageId, true);
	}

	/**
	 * Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param messageId the message ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByMessageId(String messageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { messageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MESSAGEID,
					finderArgs, this);
		}

		if (result instanceof SPMailCampaignSubscribers) {
			SPMailCampaignSubscribers spMailCampaignSubscribers = (SPMailCampaignSubscribers)result;

			if (!Validator.equals(messageId,
						spMailCampaignSubscribers.getMessageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			boolean bindMessageId = false;

			if (messageId == null) {
				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_1);
			}
			else if (messageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_3);
			}
			else {
				bindMessageId = true;

				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMessageId) {
					qPos.add(messageId);
				}

				List<SPMailCampaignSubscribers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailCampaignSubscribersPersistenceImpl.fetchByMessageId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailCampaignSubscribers spMailCampaignSubscribers = list.get(0);

					result = spMailCampaignSubscribers;

					cacheResult(spMailCampaignSubscribers);

					if ((spMailCampaignSubscribers.getMessageId() == null) ||
							!spMailCampaignSubscribers.getMessageId()
														  .equals(messageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
							finderArgs, spMailCampaignSubscribers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID,
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
			return (SPMailCampaignSubscribers)result;
		}
	}

	/**
	 * Removes the s p mail campaign subscribers where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @return the s p mail campaign subscribers that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers removeByMessageId(String messageId)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByMessageId(messageId);

		return remove(spMailCampaignSubscribers);
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMessageId(String messageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MESSAGEID;

		Object[] finderArgs = new Object[] { messageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			boolean bindMessageId = false;

			if (messageId == null) {
				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_1);
			}
			else if (messageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_3);
			}
			else {
				bindMessageId = true;

				query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMessageId) {
					qPos.add(messageId);
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

	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_1 = "spMailCampaignSubscribers.messageId IS NULL";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "spMailCampaignSubscribers.messageId = ?";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_3 = "(spMailCampaignSubscribers.messageId IS NULL OR spMailCampaignSubscribers.messageId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndOpened",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED =
		new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndOpened",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SPMailCampaignSubscribersModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.OPENED_COLUMN_BITMASK |
			SPMailCampaignSubscribersModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDOPENED = new FinderPath(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndOpened",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @return the matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened) throws SystemException {
		return findByCampaignIdAndOpened(spMailCampaignId, opened,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end)
		throws SystemException {
		return findByCampaignIdAndOpened(spMailCampaignId, opened, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED;
			finderArgs = new Object[] { spMailCampaignId, opened };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED;
			finderArgs = new Object[] {
					spMailCampaignId, opened,
					
					start, end, orderByComparator
				};
		}

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignSubscribers spMailCampaignSubscribers : list) {
				if ((spMailCampaignId != spMailCampaignSubscribers.getSpMailCampaignId()) ||
						(opened != spMailCampaignSubscribers.getOpened())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_OPENED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndOpened_First(spMailCampaignId,
				opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignSubscribers> list = findByCampaignIdAndOpened(spMailCampaignId,
				opened, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByCampaignIdAndOpened_Last(spMailCampaignId,
				opened, orderByComparator);

		if (spMailCampaignSubscribers != null) {
			return spMailCampaignSubscribers;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", opened=");
		msg.append(opened);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignSubscribersException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndOpened(spMailCampaignId, opened);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignSubscribers> list = findByCampaignIdAndOpened(spMailCampaignId,
				opened, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers[] findByCampaignIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, OrderByComparator orderByComparator)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = findByPrimaryKey(spMailCampaignSubscribersId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers[] array = new SPMailCampaignSubscribersImpl[3];

			array[0] = getByCampaignIdAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
					orderByComparator, true);

			array[1] = spMailCampaignSubscribers;

			array[2] = getByCampaignIdAndOpened_PrevAndNext(session,
					spMailCampaignSubscribers, spMailCampaignId, opened,
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

	protected SPMailCampaignSubscribers getByCampaignIdAndOpened_PrevAndNext(
		Session session, SPMailCampaignSubscribers spMailCampaignSubscribers,
		long spMailCampaignId, boolean opened,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_OPENED_2);

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
			query.append(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(opened);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignSubscribers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignSubscribers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndOpened(long spMailCampaignId,
		boolean opened) throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findByCampaignIdAndOpened(
				spMailCampaignId, opened, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param opened the opened
	 * @return the number of matching s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndOpened(long spMailCampaignId, boolean opened)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDOPENED;

		Object[] finderArgs = new Object[] { spMailCampaignId, opened };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDOPENED_OPENED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(opened);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDOPENED_SPMAILCAMPAIGNID_2 =
		"spMailCampaignSubscribers.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDOPENED_OPENED_2 = "spMailCampaignSubscribers.opened = ?";

	public SPMailCampaignSubscribersPersistenceImpl() {
		setModelClass(SPMailCampaignSubscribers.class);
	}

	/**
	 * Caches the s p mail campaign subscribers in the entity cache if it is enabled.
	 *
	 * @param spMailCampaignSubscribers the s p mail campaign subscribers
	 */
	@Override
	public void cacheResult(SPMailCampaignSubscribers spMailCampaignSubscribers) {
		EntityCacheUtil.putResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			spMailCampaignSubscribers.getPrimaryKey(), spMailCampaignSubscribers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
			new Object[] {
				spMailCampaignSubscribers.getSpMailCampaignId(),
				spMailCampaignSubscribers.getSpMailType(),
				spMailCampaignSubscribers.getEmailAddress()
			}, spMailCampaignSubscribers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
			new Object[] { spMailCampaignSubscribers.getMessageId() },
			spMailCampaignSubscribers);

		spMailCampaignSubscribers.resetOriginalValues();
	}

	/**
	 * Caches the s p mail campaign subscriberses in the entity cache if it is enabled.
	 *
	 * @param spMailCampaignSubscriberses the s p mail campaign subscriberses
	 */
	@Override
	public void cacheResult(
		List<SPMailCampaignSubscribers> spMailCampaignSubscriberses) {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : spMailCampaignSubscriberses) {
			if (EntityCacheUtil.getResult(
						SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignSubscribersImpl.class,
						spMailCampaignSubscribers.getPrimaryKey()) == null) {
				cacheResult(spMailCampaignSubscribers);
			}
			else {
				spMailCampaignSubscribers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail campaign subscriberses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailCampaignSubscribersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailCampaignSubscribersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail campaign subscribers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailCampaignSubscribers spMailCampaignSubscribers) {
		EntityCacheUtil.removeResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			spMailCampaignSubscribers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailCampaignSubscribers);
	}

	@Override
	public void clearCache(
		List<SPMailCampaignSubscribers> spMailCampaignSubscriberses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailCampaignSubscribers spMailCampaignSubscribers : spMailCampaignSubscriberses) {
			EntityCacheUtil.removeResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignSubscribersImpl.class,
				spMailCampaignSubscribers.getPrimaryKey());

			clearUniqueFindersCache(spMailCampaignSubscribers);
		}
	}

	protected void cacheUniqueFindersCache(
		SPMailCampaignSubscribers spMailCampaignSubscribers) {
		if (spMailCampaignSubscribers.isNew()) {
			Object[] args = new Object[] {
					spMailCampaignSubscribers.getSpMailCampaignId(),
					spMailCampaignSubscribers.getSpMailType(),
					spMailCampaignSubscribers.getEmailAddress()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
				args, spMailCampaignSubscribers);

			args = new Object[] { spMailCampaignSubscribers.getMessageId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID, args,
				spMailCampaignSubscribers);
		}
		else {
			SPMailCampaignSubscribersModelImpl spMailCampaignSubscribersModelImpl =
				(SPMailCampaignSubscribersModelImpl)spMailCampaignSubscribers;

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribers.getSpMailCampaignId(),
						spMailCampaignSubscribers.getSpMailType(),
						spMailCampaignSubscribers.getEmailAddress()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
					args, spMailCampaignSubscribers);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribers.getMessageId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID, args,
					spMailCampaignSubscribers);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SPMailCampaignSubscribers spMailCampaignSubscribers) {
		SPMailCampaignSubscribersModelImpl spMailCampaignSubscribersModelImpl = (SPMailCampaignSubscribersModelImpl)spMailCampaignSubscribers;

		Object[] args = new Object[] {
				spMailCampaignSubscribers.getSpMailCampaignId(),
				spMailCampaignSubscribers.getSpMailType(),
				spMailCampaignSubscribers.getEmailAddress()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
			args);

		if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
					spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
					spMailCampaignSubscribersModelImpl.getOriginalEmailAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPEANDEMAILADDRESS,
				args);
		}

		args = new Object[] { spMailCampaignSubscribers.getMessageId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID, args);

		if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MESSAGEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailCampaignSubscribersModelImpl.getOriginalMessageId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID, args);
		}
	}

	/**
	 * Creates a new s p mail campaign subscribers with the primary key. Does not add the s p mail campaign subscribers to the database.
	 *
	 * @param spMailCampaignSubscribersId the primary key for the new s p mail campaign subscribers
	 * @return the new s p mail campaign subscribers
	 */
	@Override
	public SPMailCampaignSubscribers create(long spMailCampaignSubscribersId) {
		SPMailCampaignSubscribers spMailCampaignSubscribers = new SPMailCampaignSubscribersImpl();

		spMailCampaignSubscribers.setNew(true);
		spMailCampaignSubscribers.setPrimaryKey(spMailCampaignSubscribersId);

		return spMailCampaignSubscribers;
	}

	/**
	 * Removes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers remove(long spMailCampaignSubscribersId)
		throws NoSuchCampaignSubscribersException, SystemException {
		return remove((Serializable)spMailCampaignSubscribersId);
	}

	/**
	 * Removes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers remove(Serializable primaryKey)
		throws NoSuchCampaignSubscribersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailCampaignSubscribers spMailCampaignSubscribers = (SPMailCampaignSubscribers)session.get(SPMailCampaignSubscribersImpl.class,
					primaryKey);

			if (spMailCampaignSubscribers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignSubscribersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailCampaignSubscribers);
		}
		catch (NoSuchCampaignSubscribersException nsee) {
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
	protected SPMailCampaignSubscribers removeImpl(
		SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws SystemException {
		spMailCampaignSubscribers = toUnwrappedModel(spMailCampaignSubscribers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailCampaignSubscribers)) {
				spMailCampaignSubscribers = (SPMailCampaignSubscribers)session.get(SPMailCampaignSubscribersImpl.class,
						spMailCampaignSubscribers.getPrimaryKeyObj());
			}

			if (spMailCampaignSubscribers != null) {
				session.delete(spMailCampaignSubscribers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailCampaignSubscribers != null) {
			clearCache(spMailCampaignSubscribers);
		}

		return spMailCampaignSubscribers;
	}

	@Override
	public SPMailCampaignSubscribers updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws SystemException {
		spMailCampaignSubscribers = toUnwrappedModel(spMailCampaignSubscribers);

		boolean isNew = spMailCampaignSubscribers.isNew();

		SPMailCampaignSubscribersModelImpl spMailCampaignSubscribersModelImpl = (SPMailCampaignSubscribersModelImpl)spMailCampaignSubscribers;

		Session session = null;

		try {
			session = openSession();

			if (spMailCampaignSubscribers.isNew()) {
				session.save(spMailCampaignSubscribers);

				spMailCampaignSubscribers.setNew(false);
			}
			else {
				session.merge(spMailCampaignSubscribers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!SPMailCampaignSubscribersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDOPENED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalUserId(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDOPENED,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getUserId(),
						spMailCampaignSubscribersModelImpl.getOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDOPENED,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDMAILTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDMAILTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDMAILTYPE,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDSTATUS,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDOPENED,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDEMAILADDRESS,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDEMAILADDRESS,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDEMAILADDRESS,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDFIRSTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDFIRSTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDFIRSTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getFirstName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDFIRSTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDFIRSTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEOPENEDANDLASTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalSpMailType(),
						spMailCampaignSubscribersModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getSpMailType(),
						spMailCampaignSubscribersModelImpl.getLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPEANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDMAILTYPEANDLASTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened(),
						spMailCampaignSubscribersModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOpened(),
						spMailCampaignSubscribersModelImpl.getLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDOPENEDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDOPENEDANDLASTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getLastName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDLASTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDLASTNAME,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);
			}

			if ((spMailCampaignSubscribersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignSubscribersModelImpl.getOriginalSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOriginalOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED,
					args);

				args = new Object[] {
						spMailCampaignSubscribersModelImpl.getSpMailCampaignId(),
						spMailCampaignSubscribersModelImpl.getOpened()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDOPENED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDOPENED,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignSubscribersImpl.class,
			spMailCampaignSubscribers.getPrimaryKey(), spMailCampaignSubscribers);

		clearUniqueFindersCache(spMailCampaignSubscribers);
		cacheUniqueFindersCache(spMailCampaignSubscribers);

		return spMailCampaignSubscribers;
	}

	protected SPMailCampaignSubscribers toUnwrappedModel(
		SPMailCampaignSubscribers spMailCampaignSubscribers) {
		if (spMailCampaignSubscribers instanceof SPMailCampaignSubscribersImpl) {
			return spMailCampaignSubscribers;
		}

		SPMailCampaignSubscribersImpl spMailCampaignSubscribersImpl = new SPMailCampaignSubscribersImpl();

		spMailCampaignSubscribersImpl.setNew(spMailCampaignSubscribers.isNew());
		spMailCampaignSubscribersImpl.setPrimaryKey(spMailCampaignSubscribers.getPrimaryKey());

		spMailCampaignSubscribersImpl.setSpMailCampaignSubscribersId(spMailCampaignSubscribers.getSpMailCampaignSubscribersId());
		spMailCampaignSubscribersImpl.setSpMailCampaignId(spMailCampaignSubscribers.getSpMailCampaignId());
		spMailCampaignSubscribersImpl.setUserId(spMailCampaignSubscribers.getUserId());
		spMailCampaignSubscribersImpl.setParentSubscriberId(spMailCampaignSubscribers.getParentSubscriberId());
		spMailCampaignSubscribersImpl.setEmailAddress(spMailCampaignSubscribers.getEmailAddress());
		spMailCampaignSubscribersImpl.setFirstName(spMailCampaignSubscribers.getFirstName());
		spMailCampaignSubscribersImpl.setLastName(spMailCampaignSubscribers.getLastName());
		spMailCampaignSubscribersImpl.setSpMailType(spMailCampaignSubscribers.getSpMailType());
		spMailCampaignSubscribersImpl.setMessageId(spMailCampaignSubscribers.getMessageId());
		spMailCampaignSubscribersImpl.setOpened(spMailCampaignSubscribers.isOpened());
		spMailCampaignSubscribersImpl.setCountryName(spMailCampaignSubscribers.getCountryName());
		spMailCampaignSubscribersImpl.setCity(spMailCampaignSubscribers.getCity());
		spMailCampaignSubscribersImpl.setRegionName(spMailCampaignSubscribers.getRegionName());
		spMailCampaignSubscribersImpl.setAreaCode(spMailCampaignSubscribers.getAreaCode());
		spMailCampaignSubscribersImpl.setLatitude(spMailCampaignSubscribers.getLatitude());
		spMailCampaignSubscribersImpl.setLongitude(spMailCampaignSubscribers.getLongitude());
		spMailCampaignSubscribersImpl.setIpAddress(spMailCampaignSubscribers.getIpAddress());
		spMailCampaignSubscribersImpl.setWebVersion(spMailCampaignSubscribers.isWebVersion());
		spMailCampaignSubscribersImpl.setOpenedDate(spMailCampaignSubscribers.getOpenedDate());
		spMailCampaignSubscribersImpl.setCreateBy(spMailCampaignSubscribers.getCreateBy());
		spMailCampaignSubscribersImpl.setCreateDate(spMailCampaignSubscribers.getCreateDate());
		spMailCampaignSubscribersImpl.setModifiedBy(spMailCampaignSubscribers.getModifiedBy());
		spMailCampaignSubscribersImpl.setModifiedDate(spMailCampaignSubscribers.getModifiedDate());
		spMailCampaignSubscribersImpl.setStatus(spMailCampaignSubscribers.getStatus());

		return spMailCampaignSubscribersImpl;
	}

	/**
	 * Returns the s p mail campaign subscribers with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignSubscribersException, SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = fetchByPrimaryKey(primaryKey);

		if (spMailCampaignSubscribers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignSubscribersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailCampaignSubscribers;
	}

	/**
	 * Returns the s p mail campaign subscribers with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers findByPrimaryKey(
		long spMailCampaignSubscribersId)
		throws NoSuchCampaignSubscribersException, SystemException {
		return findByPrimaryKey((Serializable)spMailCampaignSubscribersId);
	}

	/**
	 * Returns the s p mail campaign subscribers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers, or <code>null</code> if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailCampaignSubscribers spMailCampaignSubscribers = (SPMailCampaignSubscribers)EntityCacheUtil.getResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignSubscribersImpl.class, primaryKey);

		if (spMailCampaignSubscribers == _nullSPMailCampaignSubscribers) {
			return null;
		}

		if (spMailCampaignSubscribers == null) {
			Session session = null;

			try {
				session = openSession();

				spMailCampaignSubscribers = (SPMailCampaignSubscribers)session.get(SPMailCampaignSubscribersImpl.class,
						primaryKey);

				if (spMailCampaignSubscribers != null) {
					cacheResult(spMailCampaignSubscribers);
				}
				else {
					EntityCacheUtil.putResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignSubscribersImpl.class, primaryKey,
						_nullSPMailCampaignSubscribers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailCampaignSubscribersModelImpl.ENTITY_CACHE_ENABLED,
					SPMailCampaignSubscribersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailCampaignSubscribers;
	}

	/**
	 * Returns the s p mail campaign subscribers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	 * @return the s p mail campaign subscribers, or <code>null</code> if a s p mail campaign subscribers with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignSubscribers fetchByPrimaryKey(
		long spMailCampaignSubscribersId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailCampaignSubscribersId);
	}

	/**
	 * Returns all the s p mail campaign subscriberses.
	 *
	 * @return the s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign subscriberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @return the range of s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign subscriberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaign subscriberses
	 * @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail campaign subscriberses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignSubscribers> findAll(int start, int end,
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

		List<SPMailCampaignSubscribers> list = (List<SPMailCampaignSubscribers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS;

				if (pagination) {
					sql = sql.concat(SPMailCampaignSubscribersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignSubscribers>(list);
				}
				else {
					list = (List<SPMailCampaignSubscribers>)QueryUtil.list(q,
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
	 * Removes all the s p mail campaign subscriberses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailCampaignSubscribers spMailCampaignSubscribers : findAll()) {
			remove(spMailCampaignSubscribers);
		}
	}

	/**
	 * Returns the number of s p mail campaign subscriberses.
	 *
	 * @return the number of s p mail campaign subscriberses
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS);

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
	 * Initializes the s p mail campaign subscribers persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailCampaignSubscribers>> listenersList = new ArrayList<ModelListener<SPMailCampaignSubscribers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailCampaignSubscribers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailCampaignSubscribersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS = "SELECT spMailCampaignSubscribers FROM SPMailCampaignSubscribers spMailCampaignSubscribers";
	private static final String _SQL_SELECT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE = "SELECT spMailCampaignSubscribers FROM SPMailCampaignSubscribers spMailCampaignSubscribers WHERE ";
	private static final String _SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS = "SELECT COUNT(spMailCampaignSubscribers) FROM SPMailCampaignSubscribers spMailCampaignSubscribers";
	private static final String _SQL_COUNT_SPMAILCAMPAIGNSUBSCRIBERS_WHERE = "SELECT COUNT(spMailCampaignSubscribers) FROM SPMailCampaignSubscribers spMailCampaignSubscribers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailCampaignSubscribers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailCampaignSubscribers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailCampaignSubscribers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignSubscribersPersistenceImpl.class);
	private static SPMailCampaignSubscribers _nullSPMailCampaignSubscribers = new SPMailCampaignSubscribersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailCampaignSubscribers> toCacheModel() {
				return _nullSPMailCampaignSubscribersCacheModel;
			}
		};

	private static CacheModel<SPMailCampaignSubscribers> _nullSPMailCampaignSubscribersCacheModel =
		new CacheModel<SPMailCampaignSubscribers>() {
			@Override
			public SPMailCampaignSubscribers toEntityModel() {
				return _nullSPMailCampaignSubscribers;
			}
		};
}