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

import com.sambaash.platform.srv.mail.NoSuchBlackListException;
import com.sambaash.platform.srv.mail.model.SPMailBlackList;
import com.sambaash.platform.srv.mail.model.impl.SPMailBlackListImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail black list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailBlackListPersistence
 * @see SPMailBlackListUtil
 * @generated
 */
public class SPMailBlackListPersistenceImpl extends BasePersistenceImpl<SPMailBlackList>
	implements SPMailBlackListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailBlackListUtil} to access the s p mail black list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailBlackListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndBounced",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndBounced",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SPMailBlackListModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailBlackListModelImpl.BOUNCED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCED = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndBounced",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @return the matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced) throws SystemException {
		return findByCampaignIdAndBounced(spMailCampaignId, bounced,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @return the range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end)
		throws SystemException {
		return findByCampaignIdAndBounced(spMailCampaignId, bounced, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBounced(
		long spMailCampaignId, boolean bounced, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED;
			finderArgs = new Object[] { spMailCampaignId, bounced };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED;
			finderArgs = new Object[] {
					spMailCampaignId, bounced,
					
					start, end, orderByComparator
				};
		}

		List<SPMailBlackList> list = (List<SPMailBlackList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailBlackList spMailBlackList : list) {
				if ((spMailCampaignId != spMailBlackList.getSpMailCampaignId()) ||
						(bounced != spMailBlackList.getBounced())) {
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

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_BOUNCED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(bounced);

				if (!pagination) {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailBlackList>(list);
				}
				else {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
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
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndBounced_First(spMailCampaignId,
				bounced, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", bounced=");
		msg.append(bounced);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndBounced_First(
		long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailBlackList> list = findByCampaignIdAndBounced(spMailCampaignId,
				bounced, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndBounced_Last(spMailCampaignId,
				bounced, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", bounced=");
		msg.append(bounced);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndBounced_Last(
		long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndBounced(spMailCampaignId, bounced);

		if (count == 0) {
			return null;
		}

		List<SPMailBlackList> list = findByCampaignIdAndBounced(spMailCampaignId,
				bounced, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailBlackListId the primary key of the current s p mail black list
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList[] findByCampaignIdAndBounced_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByPrimaryKey(spMailBlackListId);

		Session session = null;

		try {
			session = openSession();

			SPMailBlackList[] array = new SPMailBlackListImpl[3];

			array[0] = getByCampaignIdAndBounced_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, bounced,
					orderByComparator, true);

			array[1] = spMailBlackList;

			array[2] = getByCampaignIdAndBounced_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, bounced,
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

	protected SPMailBlackList getByCampaignIdAndBounced_PrevAndNext(
		Session session, SPMailBlackList spMailBlackList,
		long spMailCampaignId, boolean bounced,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_BOUNCED_2);

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
			query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(bounced);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailBlackList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailBlackList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail black lists where spMailCampaignId = &#63; and bounced = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced) throws SystemException {
		for (SPMailBlackList spMailBlackList : findByCampaignIdAndBounced(
				spMailCampaignId, bounced, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailBlackList);
		}
	}

	/**
	 * Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounced = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounced the bounced
	 * @return the number of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndBounced(long spMailCampaignId,
		boolean bounced) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCED;

		Object[] finderArgs = new Object[] { spMailCampaignId, bounced };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_BOUNCED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(bounced);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_SPMAILCAMPAIGNID_2 =
		"spMailBlackList.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDBOUNCED_BOUNCED_2 = "spMailBlackList.bounced = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndComplain",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndComplain",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SPMailBlackListModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailBlackListModelImpl.COMPLAIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDCOMPLAIN = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndComplain",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @return the matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain) throws SystemException {
		return findByCampaignIdAndComplain(spMailCampaignId, complain,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @return the range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end)
		throws SystemException {
		return findByCampaignIdAndComplain(spMailCampaignId, complain, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndComplain(
		long spMailCampaignId, boolean complain, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN;
			finderArgs = new Object[] { spMailCampaignId, complain };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN;
			finderArgs = new Object[] {
					spMailCampaignId, complain,
					
					start, end, orderByComparator
				};
		}

		List<SPMailBlackList> list = (List<SPMailBlackList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailBlackList spMailBlackList : list) {
				if ((spMailCampaignId != spMailBlackList.getSpMailCampaignId()) ||
						(complain != spMailBlackList.getComplain())) {
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

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_COMPLAIN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(complain);

				if (!pagination) {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailBlackList>(list);
				}
				else {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
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
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndComplain_First(spMailCampaignId,
				complain, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", complain=");
		msg.append(complain);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndComplain_First(
		long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailBlackList> list = findByCampaignIdAndComplain(spMailCampaignId,
				complain, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndComplain_Last(spMailCampaignId,
				complain, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", complain=");
		msg.append(complain);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndComplain_Last(
		long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndComplain(spMailCampaignId, complain);

		if (count == 0) {
			return null;
		}

		List<SPMailBlackList> list = findByCampaignIdAndComplain(spMailCampaignId,
				complain, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailBlackListId the primary key of the current s p mail black list
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList[] findByCampaignIdAndComplain_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByPrimaryKey(spMailBlackListId);

		Session session = null;

		try {
			session = openSession();

			SPMailBlackList[] array = new SPMailBlackListImpl[3];

			array[0] = getByCampaignIdAndComplain_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, complain,
					orderByComparator, true);

			array[1] = spMailBlackList;

			array[2] = getByCampaignIdAndComplain_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, complain,
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

	protected SPMailBlackList getByCampaignIdAndComplain_PrevAndNext(
		Session session, SPMailBlackList spMailBlackList,
		long spMailCampaignId, boolean complain,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_COMPLAIN_2);

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
			query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(complain);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailBlackList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailBlackList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail black lists where spMailCampaignId = &#63; and complain = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain) throws SystemException {
		for (SPMailBlackList spMailBlackList : findByCampaignIdAndComplain(
				spMailCampaignId, complain, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailBlackList);
		}
	}

	/**
	 * Returns the number of s p mail black lists where spMailCampaignId = &#63; and complain = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param complain the complain
	 * @return the number of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndComplain(long spMailCampaignId,
		boolean complain) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDCOMPLAIN;

		Object[] finderArgs = new Object[] { spMailCampaignId, complain };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_COMPLAIN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(complain);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_SPMAILCAMPAIGNID_2 =
		"spMailBlackList.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDCOMPLAIN_COMPLAIN_2 = "spMailBlackList.complain = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignIdAndBouncedSoft",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCampaignIdAndBouncedSoft",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SPMailBlackListModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailBlackListModelImpl.BOUNCE_SOFT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCEDSOFT =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdAndBouncedSoft",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @return the matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft) throws SystemException {
		return findByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @return the range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end)
		throws SystemException {
		return findByCampaignIdAndBouncedSoft(spMailCampaignId, bounce_soft,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignIdAndBouncedSoft(
		long spMailCampaignId, boolean bounce_soft, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT;
			finderArgs = new Object[] { spMailCampaignId, bounce_soft };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT;
			finderArgs = new Object[] {
					spMailCampaignId, bounce_soft,
					
					start, end, orderByComparator
				};
		}

		List<SPMailBlackList> list = (List<SPMailBlackList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailBlackList spMailBlackList : list) {
				if ((spMailCampaignId != spMailBlackList.getSpMailCampaignId()) ||
						(bounce_soft != spMailBlackList.getBounce_soft())) {
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

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_BOUNCE_SOFT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(bounce_soft);

				if (!pagination) {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailBlackList>(list);
				}
				else {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
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
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndBouncedSoft_First(spMailCampaignId,
				bounce_soft, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", bounce_soft=");
		msg.append(bounce_soft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndBouncedSoft_First(
		long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailBlackList> list = findByCampaignIdAndBouncedSoft(spMailCampaignId,
				bounce_soft, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignIdAndBouncedSoft_Last(spMailCampaignId,
				bounce_soft, orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(", bounce_soft=");
		msg.append(bounce_soft);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignIdAndBouncedSoft_Last(
		long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignIdAndBouncedSoft(spMailCampaignId,
				bounce_soft);

		if (count == 0) {
			return null;
		}

		List<SPMailBlackList> list = findByCampaignIdAndBouncedSoft(spMailCampaignId,
				bounce_soft, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailBlackListId the primary key of the current s p mail black list
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList[] findByCampaignIdAndBouncedSoft_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByPrimaryKey(spMailBlackListId);

		Session session = null;

		try {
			session = openSession();

			SPMailBlackList[] array = new SPMailBlackListImpl[3];

			array[0] = getByCampaignIdAndBouncedSoft_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, bounce_soft,
					orderByComparator, true);

			array[1] = spMailBlackList;

			array[2] = getByCampaignIdAndBouncedSoft_PrevAndNext(session,
					spMailBlackList, spMailCampaignId, bounce_soft,
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

	protected SPMailBlackList getByCampaignIdAndBouncedSoft_PrevAndNext(
		Session session, SPMailBlackList spMailBlackList,
		long spMailCampaignId, boolean bounce_soft,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_SPMAILCAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_BOUNCE_SOFT_2);

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
			query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		qPos.add(bounce_soft);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailBlackList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailBlackList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft) throws SystemException {
		for (SPMailBlackList spMailBlackList : findByCampaignIdAndBouncedSoft(
				spMailCampaignId, bounce_soft, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spMailBlackList);
		}
	}

	/**
	 * Returns the number of s p mail black lists where spMailCampaignId = &#63; and bounce_soft = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param bounce_soft the bounce_soft
	 * @return the number of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdAndBouncedSoft(long spMailCampaignId,
		boolean bounce_soft) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCEDSOFT;

		Object[] finderArgs = new Object[] { spMailCampaignId, bounce_soft };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_BOUNCE_SOFT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(bounce_soft);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_SPMAILCAMPAIGNID_2 =
		"spMailBlackList.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDANDBOUNCEDSOFT_BOUNCE_SOFT_2 =
		"spMailBlackList.bounce_soft = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailAddress", new String[] { String.class.getName() },
			SPMailBlackListModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns the s p mail black list where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByEmailAddress(String emailAddress)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByEmailAddress(emailAddress);

		if (spMailBlackList == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBlackListException(msg.toString());
		}

		return spMailBlackList;
	}

	/**
	 * Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByEmailAddress(String emailAddress)
		throws SystemException {
		return fetchByEmailAddress(emailAddress, true);
	}

	/**
	 * Returns the s p mail black list where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByEmailAddress(String emailAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					finderArgs, this);
		}

		if (result instanceof SPMailBlackList) {
			SPMailBlackList spMailBlackList = (SPMailBlackList)result;

			if (!Validator.equals(emailAddress,
						spMailBlackList.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

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
					qPos.add(emailAddress);
				}

				List<SPMailBlackList> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
						finderArgs, list);
				}
				else {
					SPMailBlackList spMailBlackList = list.get(0);

					result = spMailBlackList;

					cacheResult(spMailBlackList);

					if ((spMailBlackList.getEmailAddress() == null) ||
							!spMailBlackList.getEmailAddress()
												.equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
							finderArgs, spMailBlackList);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
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
			return (SPMailBlackList)result;
		}
	}

	/**
	 * Removes the s p mail black list where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the s p mail black list that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList removeByEmailAddress(String emailAddress)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByEmailAddress(emailAddress);

		return remove(spMailBlackList);
	}

	/**
	 * Returns the number of s p mail black lists where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching s p mail black lists
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

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

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
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "spMailBlackList.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "spMailBlackList.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(spMailBlackList.emailAddress IS NULL OR spMailBlackList.emailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			SPMailBlackListModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail black lists where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignId(long spMailCampaignId)
		throws SystemException {
		return findByCampaignId(spMailCampaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail black lists where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @return the range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignId(long spMailCampaignId,
		int start, int end) throws SystemException {
		return findByCampaignId(spMailCampaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail black lists where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findByCampaignId(long spMailCampaignId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<SPMailBlackList> list = (List<SPMailBlackList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailBlackList spMailBlackList : list) {
				if ((spMailCampaignId != spMailBlackList.getSpMailCampaignId())) {
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

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (!pagination) {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailBlackList>(list);
				}
				else {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
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
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignId_First(long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignId_First(spMailCampaignId,
				orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the first s p mail black list in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignId_First(long spMailCampaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailBlackList> list = findByCampaignId(spMailCampaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByCampaignId_Last(long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByCampaignId_Last(spMailCampaignId,
				orderByComparator);

		if (spMailBlackList != null) {
			return spMailBlackList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBlackListException(msg.toString());
	}

	/**
	 * Returns the last s p mail black list in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByCampaignId_Last(long spMailCampaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(spMailCampaignId);

		if (count == 0) {
			return null;
		}

		List<SPMailBlackList> list = findByCampaignId(spMailCampaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail black lists before and after the current s p mail black list in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailBlackListId the primary key of the current s p mail black list
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList[] findByCampaignId_PrevAndNext(
		long spMailBlackListId, long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByPrimaryKey(spMailBlackListId);

		Session session = null;

		try {
			session = openSession();

			SPMailBlackList[] array = new SPMailBlackListImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, spMailBlackList,
					spMailCampaignId, orderByComparator, true);

			array[1] = spMailBlackList;

			array[2] = getByCampaignId_PrevAndNext(session, spMailBlackList,
					spMailCampaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailBlackList getByCampaignId_PrevAndNext(Session session,
		SPMailBlackList spMailBlackList, long spMailCampaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

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
			query.append(SPMailBlackListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailBlackList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailBlackList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail black lists where spMailCampaignId = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long spMailCampaignId)
		throws SystemException {
		for (SPMailBlackList spMailBlackList : findByCampaignId(
				spMailCampaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailBlackList);
		}
	}

	/**
	 * Returns the number of s p mail black lists where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the number of matching s p mail black lists
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

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2 = "spMailBlackList.spMailCampaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MESSAGEID = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED,
			SPMailBlackListImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMessageId", new String[] { String.class.getName() },
			SPMailBlackListModelImpl.MESSAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessageId",
			new String[] { String.class.getName() });

	/**
	 * Returns the s p mail black list where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	 *
	 * @param messageId the message ID
	 * @return the matching s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByMessageId(String messageId)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByMessageId(messageId);

		if (spMailBlackList == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBlackListException(msg.toString());
		}

		return spMailBlackList;
	}

	/**
	 * Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param messageId the message ID
	 * @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByMessageId(String messageId)
		throws SystemException {
		return fetchByMessageId(messageId, true);
	}

	/**
	 * Returns the s p mail black list where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param messageId the message ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail black list, or <code>null</code> if a matching s p mail black list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByMessageId(String messageId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { messageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MESSAGEID,
					finderArgs, this);
		}

		if (result instanceof SPMailBlackList) {
			SPMailBlackList spMailBlackList = (SPMailBlackList)result;

			if (!Validator.equals(messageId, spMailBlackList.getMessageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILBLACKLIST_WHERE);

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

				List<SPMailBlackList> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
						finderArgs, list);
				}
				else {
					SPMailBlackList spMailBlackList = list.get(0);

					result = spMailBlackList;

					cacheResult(spMailBlackList);

					if ((spMailBlackList.getMessageId() == null) ||
							!spMailBlackList.getMessageId().equals(messageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
							finderArgs, spMailBlackList);
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
			return (SPMailBlackList)result;
		}
	}

	/**
	 * Removes the s p mail black list where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @return the s p mail black list that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList removeByMessageId(String messageId)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = findByMessageId(messageId);

		return remove(spMailBlackList);
	}

	/**
	 * Returns the number of s p mail black lists where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching s p mail black lists
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

			query.append(_SQL_COUNT_SPMAILBLACKLIST_WHERE);

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

	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_1 = "spMailBlackList.messageId IS NULL";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "spMailBlackList.messageId = ?";
	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_3 = "(spMailBlackList.messageId IS NULL OR spMailBlackList.messageId = '')";

	public SPMailBlackListPersistenceImpl() {
		setModelClass(SPMailBlackList.class);
	}

	/**
	 * Caches the s p mail black list in the entity cache if it is enabled.
	 *
	 * @param spMailBlackList the s p mail black list
	 */
	@Override
	public void cacheResult(SPMailBlackList spMailBlackList) {
		EntityCacheUtil.putResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListImpl.class, spMailBlackList.getPrimaryKey(),
			spMailBlackList);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
			new Object[] { spMailBlackList.getEmailAddress() }, spMailBlackList);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID,
			new Object[] { spMailBlackList.getMessageId() }, spMailBlackList);

		spMailBlackList.resetOriginalValues();
	}

	/**
	 * Caches the s p mail black lists in the entity cache if it is enabled.
	 *
	 * @param spMailBlackLists the s p mail black lists
	 */
	@Override
	public void cacheResult(List<SPMailBlackList> spMailBlackLists) {
		for (SPMailBlackList spMailBlackList : spMailBlackLists) {
			if (EntityCacheUtil.getResult(
						SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
						SPMailBlackListImpl.class,
						spMailBlackList.getPrimaryKey()) == null) {
				cacheResult(spMailBlackList);
			}
			else {
				spMailBlackList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail black lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailBlackListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailBlackListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail black list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailBlackList spMailBlackList) {
		EntityCacheUtil.removeResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListImpl.class, spMailBlackList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailBlackList);
	}

	@Override
	public void clearCache(List<SPMailBlackList> spMailBlackLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailBlackList spMailBlackList : spMailBlackLists) {
			EntityCacheUtil.removeResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
				SPMailBlackListImpl.class, spMailBlackList.getPrimaryKey());

			clearUniqueFindersCache(spMailBlackList);
		}
	}

	protected void cacheUniqueFindersCache(SPMailBlackList spMailBlackList) {
		if (spMailBlackList.isNew()) {
			Object[] args = new Object[] { spMailBlackList.getEmailAddress() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args,
				spMailBlackList);

			args = new Object[] { spMailBlackList.getMessageId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID, args,
				spMailBlackList);
		}
		else {
			SPMailBlackListModelImpl spMailBlackListModelImpl = (SPMailBlackListModelImpl)spMailBlackList;

			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailBlackList.getEmailAddress() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					args, spMailBlackList);
			}

			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailBlackList.getMessageId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MESSAGEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MESSAGEID, args,
					spMailBlackList);
			}
		}
	}

	protected void clearUniqueFindersCache(SPMailBlackList spMailBlackList) {
		SPMailBlackListModelImpl spMailBlackListModelImpl = (SPMailBlackListModelImpl)spMailBlackList;

		Object[] args = new Object[] { spMailBlackList.getEmailAddress() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);

		if ((spMailBlackListModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailBlackListModelImpl.getOriginalEmailAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);
		}

		args = new Object[] { spMailBlackList.getMessageId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID, args);

		if ((spMailBlackListModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MESSAGEID.getColumnBitmask()) != 0) {
			args = new Object[] { spMailBlackListModelImpl.getOriginalMessageId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MESSAGEID, args);
		}
	}

	/**
	 * Creates a new s p mail black list with the primary key. Does not add the s p mail black list to the database.
	 *
	 * @param spMailBlackListId the primary key for the new s p mail black list
	 * @return the new s p mail black list
	 */
	@Override
	public SPMailBlackList create(long spMailBlackListId) {
		SPMailBlackList spMailBlackList = new SPMailBlackListImpl();

		spMailBlackList.setNew(true);
		spMailBlackList.setPrimaryKey(spMailBlackListId);

		return spMailBlackList;
	}

	/**
	 * Removes the s p mail black list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailBlackListId the primary key of the s p mail black list
	 * @return the s p mail black list that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList remove(long spMailBlackListId)
		throws NoSuchBlackListException, SystemException {
		return remove((Serializable)spMailBlackListId);
	}

	/**
	 * Removes the s p mail black list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail black list
	 * @return the s p mail black list that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList remove(Serializable primaryKey)
		throws NoSuchBlackListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailBlackList spMailBlackList = (SPMailBlackList)session.get(SPMailBlackListImpl.class,
					primaryKey);

			if (spMailBlackList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBlackListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailBlackList);
		}
		catch (NoSuchBlackListException nsee) {
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
	protected SPMailBlackList removeImpl(SPMailBlackList spMailBlackList)
		throws SystemException {
		spMailBlackList = toUnwrappedModel(spMailBlackList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailBlackList)) {
				spMailBlackList = (SPMailBlackList)session.get(SPMailBlackListImpl.class,
						spMailBlackList.getPrimaryKeyObj());
			}

			if (spMailBlackList != null) {
				session.delete(spMailBlackList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailBlackList != null) {
			clearCache(spMailBlackList);
		}

		return spMailBlackList;
	}

	@Override
	public SPMailBlackList updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailBlackList spMailBlackList)
		throws SystemException {
		spMailBlackList = toUnwrappedModel(spMailBlackList);

		boolean isNew = spMailBlackList.isNew();

		SPMailBlackListModelImpl spMailBlackListModelImpl = (SPMailBlackListModelImpl)spMailBlackList;

		Session session = null;

		try {
			session = openSession();

			if (spMailBlackList.isNew()) {
				session.save(spMailBlackList);

				spMailBlackList.setNew(false);
			}
			else {
				session.merge(spMailBlackList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailBlackListModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailBlackListModelImpl.getOriginalSpMailCampaignId(),
						spMailBlackListModelImpl.getOriginalBounced()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED,
					args);

				args = new Object[] {
						spMailBlackListModelImpl.getSpMailCampaignId(),
						spMailBlackListModelImpl.getBounced()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCED,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCED,
					args);
			}

			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailBlackListModelImpl.getOriginalSpMailCampaignId(),
						spMailBlackListModelImpl.getOriginalComplain()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDCOMPLAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN,
					args);

				args = new Object[] {
						spMailBlackListModelImpl.getSpMailCampaignId(),
						spMailBlackListModelImpl.getComplain()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDCOMPLAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDCOMPLAIN,
					args);
			}

			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailBlackListModelImpl.getOriginalSpMailCampaignId(),
						spMailBlackListModelImpl.getOriginalBounce_soft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCEDSOFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT,
					args);

				args = new Object[] {
						spMailBlackListModelImpl.getSpMailCampaignId(),
						spMailBlackListModelImpl.getBounce_soft()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDANDBOUNCEDSOFT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNIDANDBOUNCEDSOFT,
					args);
			}

			if ((spMailBlackListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailBlackListModelImpl.getOriginalSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						spMailBlackListModelImpl.getSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
			SPMailBlackListImpl.class, spMailBlackList.getPrimaryKey(),
			spMailBlackList);

		clearUniqueFindersCache(spMailBlackList);
		cacheUniqueFindersCache(spMailBlackList);

		return spMailBlackList;
	}

	protected SPMailBlackList toUnwrappedModel(SPMailBlackList spMailBlackList) {
		if (spMailBlackList instanceof SPMailBlackListImpl) {
			return spMailBlackList;
		}

		SPMailBlackListImpl spMailBlackListImpl = new SPMailBlackListImpl();

		spMailBlackListImpl.setNew(spMailBlackList.isNew());
		spMailBlackListImpl.setPrimaryKey(spMailBlackList.getPrimaryKey());

		spMailBlackListImpl.setSpMailBlackListId(spMailBlackList.getSpMailBlackListId());
		spMailBlackListImpl.setSpMailCampaignId(spMailBlackList.getSpMailCampaignId());
		spMailBlackListImpl.setUserId(spMailBlackList.getUserId());
		spMailBlackListImpl.setEmailAddress(spMailBlackList.getEmailAddress());
		spMailBlackListImpl.setBounced(spMailBlackList.isBounced());
		spMailBlackListImpl.setBounce_soft(spMailBlackList.isBounce_soft());
		spMailBlackListImpl.setComplain(spMailBlackList.isComplain());
		spMailBlackListImpl.setCreateDate(spMailBlackList.getCreateDate());
		spMailBlackListImpl.setMessage(spMailBlackList.getMessage());
		spMailBlackListImpl.setMessageId(spMailBlackList.getMessageId());

		return spMailBlackListImpl;
	}

	/**
	 * Returns the s p mail black list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail black list
	 * @return the s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBlackListException, SystemException {
		SPMailBlackList spMailBlackList = fetchByPrimaryKey(primaryKey);

		if (spMailBlackList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBlackListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailBlackList;
	}

	/**
	 * Returns the s p mail black list with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchBlackListException} if it could not be found.
	 *
	 * @param spMailBlackListId the primary key of the s p mail black list
	 * @return the s p mail black list
	 * @throws com.sambaash.platform.srv.mail.NoSuchBlackListException if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList findByPrimaryKey(long spMailBlackListId)
		throws NoSuchBlackListException, SystemException {
		return findByPrimaryKey((Serializable)spMailBlackListId);
	}

	/**
	 * Returns the s p mail black list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail black list
	 * @return the s p mail black list, or <code>null</code> if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailBlackList spMailBlackList = (SPMailBlackList)EntityCacheUtil.getResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
				SPMailBlackListImpl.class, primaryKey);

		if (spMailBlackList == _nullSPMailBlackList) {
			return null;
		}

		if (spMailBlackList == null) {
			Session session = null;

			try {
				session = openSession();

				spMailBlackList = (SPMailBlackList)session.get(SPMailBlackListImpl.class,
						primaryKey);

				if (spMailBlackList != null) {
					cacheResult(spMailBlackList);
				}
				else {
					EntityCacheUtil.putResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
						SPMailBlackListImpl.class, primaryKey,
						_nullSPMailBlackList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailBlackListModelImpl.ENTITY_CACHE_ENABLED,
					SPMailBlackListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailBlackList;
	}

	/**
	 * Returns the s p mail black list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailBlackListId the primary key of the s p mail black list
	 * @return the s p mail black list, or <code>null</code> if a s p mail black list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailBlackList fetchByPrimaryKey(long spMailBlackListId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailBlackListId);
	}

	/**
	 * Returns all the s p mail black lists.
	 *
	 * @return the s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail black lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @return the range of s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail black lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailBlackListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail black lists
	 * @param end the upper bound of the range of s p mail black lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail black lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailBlackList> findAll(int start, int end,
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

		List<SPMailBlackList> list = (List<SPMailBlackList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILBLACKLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILBLACKLIST;

				if (pagination) {
					sql = sql.concat(SPMailBlackListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailBlackList>(list);
				}
				else {
					list = (List<SPMailBlackList>)QueryUtil.list(q,
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
	 * Removes all the s p mail black lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailBlackList spMailBlackList : findAll()) {
			remove(spMailBlackList);
		}
	}

	/**
	 * Returns the number of s p mail black lists.
	 *
	 * @return the number of s p mail black lists
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILBLACKLIST);

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
	 * Initializes the s p mail black list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailBlackList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailBlackList>> listenersList = new ArrayList<ModelListener<SPMailBlackList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailBlackList>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailBlackListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILBLACKLIST = "SELECT spMailBlackList FROM SPMailBlackList spMailBlackList";
	private static final String _SQL_SELECT_SPMAILBLACKLIST_WHERE = "SELECT spMailBlackList FROM SPMailBlackList spMailBlackList WHERE ";
	private static final String _SQL_COUNT_SPMAILBLACKLIST = "SELECT COUNT(spMailBlackList) FROM SPMailBlackList spMailBlackList";
	private static final String _SQL_COUNT_SPMAILBLACKLIST_WHERE = "SELECT COUNT(spMailBlackList) FROM SPMailBlackList spMailBlackList WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailBlackList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailBlackList exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailBlackList exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailBlackListPersistenceImpl.class);
	private static SPMailBlackList _nullSPMailBlackList = new SPMailBlackListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailBlackList> toCacheModel() {
				return _nullSPMailBlackListCacheModel;
			}
		};

	private static CacheModel<SPMailBlackList> _nullSPMailBlackListCacheModel = new CacheModel<SPMailBlackList>() {
			@Override
			public SPMailBlackList toEntityModel() {
				return _nullSPMailBlackList;
			}
		};
}