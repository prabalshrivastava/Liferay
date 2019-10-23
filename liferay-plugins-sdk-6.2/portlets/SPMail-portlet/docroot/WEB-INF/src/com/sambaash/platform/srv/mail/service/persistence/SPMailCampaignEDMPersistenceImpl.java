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

import com.sambaash.platform.srv.mail.NoSuchCampaignEDMException;
import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail campaign e d m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignEDMPersistence
 * @see SPMailCampaignEDMUtil
 * @generated
 */
public class SPMailCampaignEDMPersistenceImpl extends BasePersistenceImpl<SPMailCampaignEDM>
	implements SPMailCampaignEDMPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailCampaignEDMUtil} to access the s p mail campaign e d m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailCampaignEDMImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName() },
			SPMailCampaignEDMModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignEDMModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the matching s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findByCampaignId(long spMailCampaignId)
		throws SystemException {
		return findByCampaignId(spMailCampaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail campaign e d ms
	 * @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	 * @return the range of matching s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findByCampaignId(long spMailCampaignId,
		int start, int end) throws SystemException {
		return findByCampaignId(spMailCampaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign e d ms where spMailCampaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param start the lower bound of the range of s p mail campaign e d ms
	 * @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findByCampaignId(long spMailCampaignId,
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

		List<SPMailCampaignEDM> list = (List<SPMailCampaignEDM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaignEDM spMailCampaignEDM : list) {
				if ((spMailCampaignId != spMailCampaignEDM.getSpMailCampaignId())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGNEDM_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignEDMModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				if (!pagination) {
					list = (List<SPMailCampaignEDM>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignEDM>(list);
				}
				else {
					list = (List<SPMailCampaignEDM>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM findByCampaignId_First(long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = fetchByCampaignId_First(spMailCampaignId,
				orderByComparator);

		if (spMailCampaignEDM != null) {
			return spMailCampaignEDM;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEDMException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByCampaignId_First(long spMailCampaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaignEDM> list = findByCampaignId(spMailCampaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM findByCampaignId_Last(long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = fetchByCampaignId_Last(spMailCampaignId,
				orderByComparator);

		if (spMailCampaignEDM != null) {
			return spMailCampaignEDM;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spMailCampaignId=");
		msg.append(spMailCampaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEDMException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByCampaignId_Last(long spMailCampaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCampaignId(spMailCampaignId);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaignEDM> list = findByCampaignId(spMailCampaignId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaign e d ms before and after the current s p mail campaign e d m in the ordered set where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignEDMId the primary key of the current s p mail campaign e d m
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM[] findByCampaignId_PrevAndNext(
		long spMailCampaignEDMId, long spMailCampaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = findByPrimaryKey(spMailCampaignEDMId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaignEDM[] array = new SPMailCampaignEDMImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, spMailCampaignEDM,
					spMailCampaignId, orderByComparator, true);

			array[1] = spMailCampaignEDM;

			array[2] = getByCampaignId_PrevAndNext(session, spMailCampaignEDM,
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

	protected SPMailCampaignEDM getByCampaignId_PrevAndNext(Session session,
		SPMailCampaignEDM spMailCampaignEDM, long spMailCampaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGNEDM_WHERE);

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
			query.append(SPMailCampaignEDMModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spMailCampaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaignEDM);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaignEDM> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaign e d ms where spMailCampaignId = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCampaignId(long spMailCampaignId)
		throws SystemException {
		for (SPMailCampaignEDM spMailCampaignEDM : findByCampaignId(
				spMailCampaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaignEDM);
		}
	}

	/**
	 * Returns the number of s p mail campaign e d ms where spMailCampaignId = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @return the number of matching s p mail campaign e d ms
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

			query.append(_SQL_COUNT_SPMAILCAMPAIGNEDM_WHERE);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_SPMAILCAMPAIGNID_2 = "spMailCampaignEDM.spMailCampaignId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCampaignIdMailType",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SPMailCampaignEDMModelImpl.SPMAILCAMPAIGNID_COLUMN_BITMASK |
			SPMailCampaignEDMModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE = new FinderPath(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCampaignIdMailType",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignEDMException} if it could not be found.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param seqNo the seq no
	 * @return the matching s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM findByCampaignIdMailType(long spMailCampaignId,
		int seqNo) throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = fetchByCampaignIdMailType(spMailCampaignId,
				seqNo);

		if (spMailCampaignEDM == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spMailCampaignId=");
			msg.append(spMailCampaignId);

			msg.append(", seqNo=");
			msg.append(seqNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignEDMException(msg.toString());
		}

		return spMailCampaignEDM;
	}

	/**
	 * Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param seqNo the seq no
	 * @return the matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByCampaignIdMailType(long spMailCampaignId,
		int seqNo) throws SystemException {
		return fetchByCampaignIdMailType(spMailCampaignId, seqNo, true);
	}

	/**
	 * Returns the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param seqNo the seq no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail campaign e d m, or <code>null</code> if a matching s p mail campaign e d m could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByCampaignIdMailType(long spMailCampaignId,
		int seqNo, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spMailCampaignId, seqNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
					finderArgs, this);
		}

		if (result instanceof SPMailCampaignEDM) {
			SPMailCampaignEDM spMailCampaignEDM = (SPMailCampaignEDM)result;

			if ((spMailCampaignId != spMailCampaignEDM.getSpMailCampaignId()) ||
					(seqNo != spMailCampaignEDM.getSeqNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPMAILCAMPAIGNEDM_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SEQNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(seqNo);

				List<SPMailCampaignEDM> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailCampaignEDMPersistenceImpl.fetchByCampaignIdMailType(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailCampaignEDM spMailCampaignEDM = list.get(0);

					result = spMailCampaignEDM;

					cacheResult(spMailCampaignEDM);

					if ((spMailCampaignEDM.getSpMailCampaignId() != spMailCampaignId) ||
							(spMailCampaignEDM.getSeqNo() != seqNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
							finderArgs, spMailCampaignEDM);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
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
			return (SPMailCampaignEDM)result;
		}
	}

	/**
	 * Removes the s p mail campaign e d m where spMailCampaignId = &#63; and seqNo = &#63; from the database.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param seqNo the seq no
	 * @return the s p mail campaign e d m that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM removeByCampaignIdMailType(long spMailCampaignId,
		int seqNo) throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = findByCampaignIdMailType(spMailCampaignId,
				seqNo);

		return remove(spMailCampaignEDM);
	}

	/**
	 * Returns the number of s p mail campaign e d ms where spMailCampaignId = &#63; and seqNo = &#63;.
	 *
	 * @param spMailCampaignId the sp mail campaign ID
	 * @param seqNo the seq no
	 * @return the number of matching s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignIdMailType(long spMailCampaignId, int seqNo)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE;

		Object[] finderArgs = new Object[] { spMailCampaignId, seqNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILCAMPAIGNEDM_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SPMAILCAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SEQNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spMailCampaignId);

				qPos.add(seqNo);

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

	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SPMAILCAMPAIGNID_2 =
		"spMailCampaignEDM.spMailCampaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNIDMAILTYPE_SEQNO_2 = "spMailCampaignEDM.seqNo = ?";

	public SPMailCampaignEDMPersistenceImpl() {
		setModelClass(SPMailCampaignEDM.class);
	}

	/**
	 * Caches the s p mail campaign e d m in the entity cache if it is enabled.
	 *
	 * @param spMailCampaignEDM the s p mail campaign e d m
	 */
	@Override
	public void cacheResult(SPMailCampaignEDM spMailCampaignEDM) {
		EntityCacheUtil.putResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class, spMailCampaignEDM.getPrimaryKey(),
			spMailCampaignEDM);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
			new Object[] {
				spMailCampaignEDM.getSpMailCampaignId(),
				spMailCampaignEDM.getSeqNo()
			}, spMailCampaignEDM);

		spMailCampaignEDM.resetOriginalValues();
	}

	/**
	 * Caches the s p mail campaign e d ms in the entity cache if it is enabled.
	 *
	 * @param spMailCampaignEDMs the s p mail campaign e d ms
	 */
	@Override
	public void cacheResult(List<SPMailCampaignEDM> spMailCampaignEDMs) {
		for (SPMailCampaignEDM spMailCampaignEDM : spMailCampaignEDMs) {
			if (EntityCacheUtil.getResult(
						SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignEDMImpl.class,
						spMailCampaignEDM.getPrimaryKey()) == null) {
				cacheResult(spMailCampaignEDM);
			}
			else {
				spMailCampaignEDM.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail campaign e d ms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailCampaignEDMImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailCampaignEDMImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail campaign e d m.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailCampaignEDM spMailCampaignEDM) {
		EntityCacheUtil.removeResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class, spMailCampaignEDM.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailCampaignEDM);
	}

	@Override
	public void clearCache(List<SPMailCampaignEDM> spMailCampaignEDMs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailCampaignEDM spMailCampaignEDM : spMailCampaignEDMs) {
			EntityCacheUtil.removeResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignEDMImpl.class, spMailCampaignEDM.getPrimaryKey());

			clearUniqueFindersCache(spMailCampaignEDM);
		}
	}

	protected void cacheUniqueFindersCache(SPMailCampaignEDM spMailCampaignEDM) {
		if (spMailCampaignEDM.isNew()) {
			Object[] args = new Object[] {
					spMailCampaignEDM.getSpMailCampaignId(),
					spMailCampaignEDM.getSeqNo()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
				args, spMailCampaignEDM);
		}
		else {
			SPMailCampaignEDMModelImpl spMailCampaignEDMModelImpl = (SPMailCampaignEDMModelImpl)spMailCampaignEDM;

			if ((spMailCampaignEDMModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignEDM.getSpMailCampaignId(),
						spMailCampaignEDM.getSeqNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
					args, spMailCampaignEDM);
			}
		}
	}

	protected void clearUniqueFindersCache(SPMailCampaignEDM spMailCampaignEDM) {
		SPMailCampaignEDMModelImpl spMailCampaignEDMModelImpl = (SPMailCampaignEDMModelImpl)spMailCampaignEDM;

		Object[] args = new Object[] {
				spMailCampaignEDM.getSpMailCampaignId(),
				spMailCampaignEDM.getSeqNo()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
			args);

		if ((spMailCampaignEDMModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailCampaignEDMModelImpl.getOriginalSpMailCampaignId(),
					spMailCampaignEDMModelImpl.getOriginalSeqNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNIDMAILTYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNIDMAILTYPE,
				args);
		}
	}

	/**
	 * Creates a new s p mail campaign e d m with the primary key. Does not add the s p mail campaign e d m to the database.
	 *
	 * @param spMailCampaignEDMId the primary key for the new s p mail campaign e d m
	 * @return the new s p mail campaign e d m
	 */
	@Override
	public SPMailCampaignEDM create(long spMailCampaignEDMId) {
		SPMailCampaignEDM spMailCampaignEDM = new SPMailCampaignEDMImpl();

		spMailCampaignEDM.setNew(true);
		spMailCampaignEDM.setPrimaryKey(spMailCampaignEDMId);

		return spMailCampaignEDM;
	}

	/**
	 * Removes the s p mail campaign e d m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM remove(long spMailCampaignEDMId)
		throws NoSuchCampaignEDMException, SystemException {
		return remove((Serializable)spMailCampaignEDMId);
	}

	/**
	 * Removes the s p mail campaign e d m with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM remove(Serializable primaryKey)
		throws NoSuchCampaignEDMException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailCampaignEDM spMailCampaignEDM = (SPMailCampaignEDM)session.get(SPMailCampaignEDMImpl.class,
					primaryKey);

			if (spMailCampaignEDM == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignEDMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailCampaignEDM);
		}
		catch (NoSuchCampaignEDMException nsee) {
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
	protected SPMailCampaignEDM removeImpl(SPMailCampaignEDM spMailCampaignEDM)
		throws SystemException {
		spMailCampaignEDM = toUnwrappedModel(spMailCampaignEDM);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailCampaignEDM)) {
				spMailCampaignEDM = (SPMailCampaignEDM)session.get(SPMailCampaignEDMImpl.class,
						spMailCampaignEDM.getPrimaryKeyObj());
			}

			if (spMailCampaignEDM != null) {
				session.delete(spMailCampaignEDM);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailCampaignEDM != null) {
			clearCache(spMailCampaignEDM);
		}

		return spMailCampaignEDM;
	}

	@Override
	public SPMailCampaignEDM updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaignEDM spMailCampaignEDM)
		throws SystemException {
		spMailCampaignEDM = toUnwrappedModel(spMailCampaignEDM);

		boolean isNew = spMailCampaignEDM.isNew();

		SPMailCampaignEDMModelImpl spMailCampaignEDMModelImpl = (SPMailCampaignEDMModelImpl)spMailCampaignEDM;

		Session session = null;

		try {
			session = openSession();

			if (spMailCampaignEDM.isNew()) {
				session.save(spMailCampaignEDM);

				spMailCampaignEDM.setNew(false);
			}
			else {
				session.merge(spMailCampaignEDM);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailCampaignEDMModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailCampaignEDMModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignEDMModelImpl.getOriginalSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						spMailCampaignEDMModelImpl.getSpMailCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignEDMImpl.class, spMailCampaignEDM.getPrimaryKey(),
			spMailCampaignEDM);

		clearUniqueFindersCache(spMailCampaignEDM);
		cacheUniqueFindersCache(spMailCampaignEDM);

		return spMailCampaignEDM;
	}

	protected SPMailCampaignEDM toUnwrappedModel(
		SPMailCampaignEDM spMailCampaignEDM) {
		if (spMailCampaignEDM instanceof SPMailCampaignEDMImpl) {
			return spMailCampaignEDM;
		}

		SPMailCampaignEDMImpl spMailCampaignEDMImpl = new SPMailCampaignEDMImpl();

		spMailCampaignEDMImpl.setNew(spMailCampaignEDM.isNew());
		spMailCampaignEDMImpl.setPrimaryKey(spMailCampaignEDM.getPrimaryKey());

		spMailCampaignEDMImpl.setSpMailCampaignEDMId(spMailCampaignEDM.getSpMailCampaignEDMId());
		spMailCampaignEDMImpl.setGroupId(spMailCampaignEDM.getGroupId());
		spMailCampaignEDMImpl.setCompanyId(spMailCampaignEDM.getCompanyId());
		spMailCampaignEDMImpl.setUserId(spMailCampaignEDM.getUserId());
		spMailCampaignEDMImpl.setUserName(spMailCampaignEDM.getUserName());
		spMailCampaignEDMImpl.setCreateDate(spMailCampaignEDM.getCreateDate());
		spMailCampaignEDMImpl.setModifiedDate(spMailCampaignEDM.getModifiedDate());
		spMailCampaignEDMImpl.setName(spMailCampaignEDM.getName());
		spMailCampaignEDMImpl.setSpMailCampaignId(spMailCampaignEDM.getSpMailCampaignId());
		spMailCampaignEDMImpl.setSpMailTemplateId(spMailCampaignEDM.getSpMailTemplateId());
		spMailCampaignEDMImpl.setSeqNo(spMailCampaignEDM.getSeqNo());
		spMailCampaignEDMImpl.setDayOfWeek(spMailCampaignEDM.getDayOfWeek());
		spMailCampaignEDMImpl.setDayOfMonth(spMailCampaignEDM.getDayOfMonth());
		spMailCampaignEDMImpl.setDelayUnit(spMailCampaignEDM.getDelayUnit());
		spMailCampaignEDMImpl.setStatus(spMailCampaignEDM.getStatus());
		spMailCampaignEDMImpl.setDelayAmount(spMailCampaignEDM.getDelayAmount());
		spMailCampaignEDMImpl.setCroneType(spMailCampaignEDM.getCroneType());
		spMailCampaignEDMImpl.setNextScheduleDateTime(spMailCampaignEDM.getNextScheduleDateTime());

		return spMailCampaignEDMImpl;
	}

	/**
	 * Returns the s p mail campaign e d m with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignEDMException, SystemException {
		SPMailCampaignEDM spMailCampaignEDM = fetchByPrimaryKey(primaryKey);

		if (spMailCampaignEDM == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignEDMException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailCampaignEDM;
	}

	/**
	 * Returns the s p mail campaign e d m with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignEDMException} if it could not be found.
	 *
	 * @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignEDMException if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM findByPrimaryKey(long spMailCampaignEDMId)
		throws NoSuchCampaignEDMException, SystemException {
		return findByPrimaryKey((Serializable)spMailCampaignEDMId);
	}

	/**
	 * Returns the s p mail campaign e d m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m, or <code>null</code> if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailCampaignEDM spMailCampaignEDM = (SPMailCampaignEDM)EntityCacheUtil.getResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignEDMImpl.class, primaryKey);

		if (spMailCampaignEDM == _nullSPMailCampaignEDM) {
			return null;
		}

		if (spMailCampaignEDM == null) {
			Session session = null;

			try {
				session = openSession();

				spMailCampaignEDM = (SPMailCampaignEDM)session.get(SPMailCampaignEDMImpl.class,
						primaryKey);

				if (spMailCampaignEDM != null) {
					cacheResult(spMailCampaignEDM);
				}
				else {
					EntityCacheUtil.putResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignEDMImpl.class, primaryKey,
						_nullSPMailCampaignEDM);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailCampaignEDMModelImpl.ENTITY_CACHE_ENABLED,
					SPMailCampaignEDMImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailCampaignEDM;
	}

	/**
	 * Returns the s p mail campaign e d m with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailCampaignEDMId the primary key of the s p mail campaign e d m
	 * @return the s p mail campaign e d m, or <code>null</code> if a s p mail campaign e d m with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaignEDM fetchByPrimaryKey(long spMailCampaignEDMId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailCampaignEDMId);
	}

	/**
	 * Returns all the s p mail campaign e d ms.
	 *
	 * @return the s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaign e d ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaign e d ms
	 * @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	 * @return the range of s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaign e d ms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignEDMModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaign e d ms
	 * @param end the upper bound of the range of s p mail campaign e d ms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail campaign e d ms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaignEDM> findAll(int start, int end,
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

		List<SPMailCampaignEDM> list = (List<SPMailCampaignEDM>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILCAMPAIGNEDM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILCAMPAIGNEDM;

				if (pagination) {
					sql = sql.concat(SPMailCampaignEDMModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailCampaignEDM>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaignEDM>(list);
				}
				else {
					list = (List<SPMailCampaignEDM>)QueryUtil.list(q,
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
	 * Removes all the s p mail campaign e d ms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailCampaignEDM spMailCampaignEDM : findAll()) {
			remove(spMailCampaignEDM);
		}
	}

	/**
	 * Returns the number of s p mail campaign e d ms.
	 *
	 * @return the number of s p mail campaign e d ms
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILCAMPAIGNEDM);

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
	 * Initializes the s p mail campaign e d m persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailCampaignEDM")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailCampaignEDM>> listenersList = new ArrayList<ModelListener<SPMailCampaignEDM>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailCampaignEDM>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailCampaignEDMImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILCAMPAIGNEDM = "SELECT spMailCampaignEDM FROM SPMailCampaignEDM spMailCampaignEDM";
	private static final String _SQL_SELECT_SPMAILCAMPAIGNEDM_WHERE = "SELECT spMailCampaignEDM FROM SPMailCampaignEDM spMailCampaignEDM WHERE ";
	private static final String _SQL_COUNT_SPMAILCAMPAIGNEDM = "SELECT COUNT(spMailCampaignEDM) FROM SPMailCampaignEDM spMailCampaignEDM";
	private static final String _SQL_COUNT_SPMAILCAMPAIGNEDM_WHERE = "SELECT COUNT(spMailCampaignEDM) FROM SPMailCampaignEDM spMailCampaignEDM WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailCampaignEDM.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailCampaignEDM exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailCampaignEDM exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignEDMPersistenceImpl.class);
	private static SPMailCampaignEDM _nullSPMailCampaignEDM = new SPMailCampaignEDMImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailCampaignEDM> toCacheModel() {
				return _nullSPMailCampaignEDMCacheModel;
			}
		};

	private static CacheModel<SPMailCampaignEDM> _nullSPMailCampaignEDMCacheModel =
		new CacheModel<SPMailCampaignEDM>() {
			@Override
			public SPMailCampaignEDM toEntityModel() {
				return _nullSPMailCampaignEDM;
			}
		};
}