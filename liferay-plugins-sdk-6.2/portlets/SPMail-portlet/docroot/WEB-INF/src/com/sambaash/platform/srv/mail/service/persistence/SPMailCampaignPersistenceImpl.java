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

import com.sambaash.platform.srv.mail.NoSuchCampaignException;
import com.sambaash.platform.srv.mail.model.SPMailCampaign;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignPersistence
 * @see SPMailCampaignUtil
 * @generated
 */
public class SPMailCampaignPersistenceImpl extends BasePersistenceImpl<SPMailCampaign>
	implements SPMailCampaignPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailCampaignUtil} to access the s p mail campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailCampaignImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARCHIVE = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByArchive",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE =
		new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArchive",
			new String[] { Boolean.class.getName() },
			SPMailCampaignModelImpl.ARCHIVE_COLUMN_BITMASK |
			SPMailCampaignModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARCHIVE = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArchive",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p mail campaigns where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findByArchive(boolean archive)
		throws SystemException {
		return findByArchive(archive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaigns where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of s p mail campaigns
	 * @param end the upper bound of the range of s p mail campaigns (not inclusive)
	 * @return the range of matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findByArchive(boolean archive, int start,
		int end) throws SystemException {
		return findByArchive(archive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaigns where archive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param archive the archive
	 * @param start the lower bound of the range of s p mail campaigns
	 * @param end the upper bound of the range of s p mail campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findByArchive(boolean archive, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE;
			finderArgs = new Object[] { archive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARCHIVE;
			finderArgs = new Object[] { archive, start, end, orderByComparator };
		}

		List<SPMailCampaign> list = (List<SPMailCampaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPMailCampaign spMailCampaign : list) {
				if ((archive != spMailCampaign.getArchive())) {
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

			query.append(_SQL_SELECT_SPMAILCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPMailCampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(archive);

				if (!pagination) {
					list = (List<SPMailCampaign>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaign>(list);
				}
				else {
					list = (List<SPMailCampaign>)QueryUtil.list(q,
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
	 * Returns the first s p mail campaign in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByArchive_First(boolean archive,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = fetchByArchive_First(archive,
				orderByComparator);

		if (spMailCampaign != null) {
			return spMailCampaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the first s p mail campaign in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByArchive_First(boolean archive,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPMailCampaign> list = findByArchive(archive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p mail campaign in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByArchive_Last(boolean archive,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = fetchByArchive_Last(archive,
				orderByComparator);

		if (spMailCampaign != null) {
			return spMailCampaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("archive=");
		msg.append(archive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the last s p mail campaign in the ordered set where archive = &#63;.
	 *
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByArchive_Last(boolean archive,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByArchive(archive);

		if (count == 0) {
			return null;
		}

		List<SPMailCampaign> list = findByArchive(archive, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p mail campaigns before and after the current s p mail campaign in the ordered set where archive = &#63;.
	 *
	 * @param spMailCampaignId the primary key of the current s p mail campaign
	 * @param archive the archive
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign[] findByArchive_PrevAndNext(long spMailCampaignId,
		boolean archive, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = findByPrimaryKey(spMailCampaignId);

		Session session = null;

		try {
			session = openSession();

			SPMailCampaign[] array = new SPMailCampaignImpl[3];

			array[0] = getByArchive_PrevAndNext(session, spMailCampaign,
					archive, orderByComparator, true);

			array[1] = spMailCampaign;

			array[2] = getByArchive_PrevAndNext(session, spMailCampaign,
					archive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPMailCampaign getByArchive_PrevAndNext(Session session,
		SPMailCampaign spMailCampaign, boolean archive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPMAILCAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

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
			query.append(SPMailCampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(archive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spMailCampaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPMailCampaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p mail campaigns where archive = &#63; from the database.
	 *
	 * @param archive the archive
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByArchive(boolean archive) throws SystemException {
		for (SPMailCampaign spMailCampaign : findByArchive(archive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spMailCampaign);
		}
	}

	/**
	 * Returns the number of s p mail campaigns where archive = &#63;.
	 *
	 * @param archive the archive
	 * @return the number of matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByArchive(boolean archive) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARCHIVE;

		Object[] finderArgs = new Object[] { archive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_ARCHIVE_ARCHIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(archive);

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

	private static final String _FINDER_COLUMN_ARCHIVE_ARCHIVE_2 = "spMailCampaign.archive = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNNAME = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCampaignName", new String[] { String.class.getName() },
			SPMailCampaignModelImpl.CAMPAIGNNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNNAME = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignName",
			new String[] { String.class.getName() });

	/**
	 * Returns the s p mail campaign where campaignName = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	 *
	 * @param campaignName the campaign name
	 * @return the matching s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByCampaignName(String campaignName)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = fetchByCampaignName(campaignName);

		if (spMailCampaign == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignName=");
			msg.append(campaignName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignException(msg.toString());
		}

		return spMailCampaign;
	}

	/**
	 * Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignName the campaign name
	 * @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByCampaignName(String campaignName)
		throws SystemException {
		return fetchByCampaignName(campaignName, true);
	}

	/**
	 * Returns the s p mail campaign where campaignName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param campaignName the campaign name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByCampaignName(String campaignName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
					finderArgs, this);
		}

		if (result instanceof SPMailCampaign) {
			SPMailCampaign spMailCampaign = (SPMailCampaign)result;

			if (!Validator.equals(campaignName, spMailCampaign.getCampaignName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILCAMPAIGN_WHERE);

			boolean bindCampaignName = false;

			if (campaignName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_1);
			}
			else if (campaignName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_3);
			}
			else {
				bindCampaignName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCampaignName) {
					qPos.add(campaignName);
				}

				List<SPMailCampaign> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailCampaignPersistenceImpl.fetchByCampaignName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailCampaign spMailCampaign = list.get(0);

					result = spMailCampaign;

					cacheResult(spMailCampaign);

					if ((spMailCampaign.getCampaignName() == null) ||
							!spMailCampaign.getCampaignName()
											   .equals(campaignName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
							finderArgs, spMailCampaign);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
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
			return (SPMailCampaign)result;
		}
	}

	/**
	 * Removes the s p mail campaign where campaignName = &#63; from the database.
	 *
	 * @param campaignName the campaign name
	 * @return the s p mail campaign that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign removeByCampaignName(String campaignName)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = findByCampaignName(campaignName);

		return remove(spMailCampaign);
	}

	/**
	 * Returns the number of s p mail campaigns where campaignName = &#63;.
	 *
	 * @param campaignName the campaign name
	 * @return the number of matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCampaignName(String campaignName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNNAME;

		Object[] finderArgs = new Object[] { campaignName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGN_WHERE);

			boolean bindCampaignName = false;

			if (campaignName == null) {
				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_1);
			}
			else if (campaignName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_3);
			}
			else {
				bindCampaignName = true;

				query.append(_FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCampaignName) {
					qPos.add(campaignName);
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

	private static final String _FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_1 = "spMailCampaign.campaignName IS NULL";
	private static final String _FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_2 = "spMailCampaign.campaignName = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNNAME_CAMPAIGNNAME_3 = "(spMailCampaign.campaignName IS NULL OR spMailCampaign.campaignName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RSVPID = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED,
			SPMailCampaignImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByrsvpId", new String[] { Long.class.getName() },
			SPMailCampaignModelImpl.RSVPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RSVPID = new FinderPath(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrsvpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the s p mail campaign where rsvpId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByrsvpId(long rsvpId)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = fetchByrsvpId(rsvpId);

		if (spMailCampaign == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rsvpId=");
			msg.append(rsvpId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignException(msg.toString());
		}

		return spMailCampaign;
	}

	/**
	 * Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByrsvpId(long rsvpId) throws SystemException {
		return fetchByrsvpId(rsvpId, true);
	}

	/**
	 * Returns the s p mail campaign where rsvpId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param rsvpId the rsvp ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail campaign, or <code>null</code> if a matching s p mail campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByrsvpId(long rsvpId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { rsvpId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RSVPID,
					finderArgs, this);
		}

		if (result instanceof SPMailCampaign) {
			SPMailCampaign spMailCampaign = (SPMailCampaign)result;

			if ((rsvpId != spMailCampaign.getRsvpId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

				List<SPMailCampaign> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RSVPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailCampaignPersistenceImpl.fetchByrsvpId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailCampaign spMailCampaign = list.get(0);

					result = spMailCampaign;

					cacheResult(spMailCampaign);

					if ((spMailCampaign.getRsvpId() != rsvpId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RSVPID,
							finderArgs, spMailCampaign);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RSVPID,
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
			return (SPMailCampaign)result;
		}
	}

	/**
	 * Removes the s p mail campaign where rsvpId = &#63; from the database.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the s p mail campaign that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign removeByrsvpId(long rsvpId)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = findByrsvpId(rsvpId);

		return remove(spMailCampaign);
	}

	/**
	 * Returns the number of s p mail campaigns where rsvpId = &#63;.
	 *
	 * @param rsvpId the rsvp ID
	 * @return the number of matching s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrsvpId(long rsvpId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RSVPID;

		Object[] finderArgs = new Object[] { rsvpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_RSVPID_RSVPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rsvpId);

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

	private static final String _FINDER_COLUMN_RSVPID_RSVPID_2 = "spMailCampaign.rsvpId = ?";

	public SPMailCampaignPersistenceImpl() {
		setModelClass(SPMailCampaign.class);
	}

	/**
	 * Caches the s p mail campaign in the entity cache if it is enabled.
	 *
	 * @param spMailCampaign the s p mail campaign
	 */
	@Override
	public void cacheResult(SPMailCampaign spMailCampaign) {
		EntityCacheUtil.putResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignImpl.class, spMailCampaign.getPrimaryKey(),
			spMailCampaign);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
			new Object[] { spMailCampaign.getCampaignName() }, spMailCampaign);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RSVPID,
			new Object[] { spMailCampaign.getRsvpId() }, spMailCampaign);

		spMailCampaign.resetOriginalValues();
	}

	/**
	 * Caches the s p mail campaigns in the entity cache if it is enabled.
	 *
	 * @param spMailCampaigns the s p mail campaigns
	 */
	@Override
	public void cacheResult(List<SPMailCampaign> spMailCampaigns) {
		for (SPMailCampaign spMailCampaign : spMailCampaigns) {
			if (EntityCacheUtil.getResult(
						SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignImpl.class, spMailCampaign.getPrimaryKey()) == null) {
				cacheResult(spMailCampaign);
			}
			else {
				spMailCampaign.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail campaigns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailCampaignImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailCampaignImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail campaign.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailCampaign spMailCampaign) {
		EntityCacheUtil.removeResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignImpl.class, spMailCampaign.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailCampaign);
	}

	@Override
	public void clearCache(List<SPMailCampaign> spMailCampaigns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailCampaign spMailCampaign : spMailCampaigns) {
			EntityCacheUtil.removeResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignImpl.class, spMailCampaign.getPrimaryKey());

			clearUniqueFindersCache(spMailCampaign);
		}
	}

	protected void cacheUniqueFindersCache(SPMailCampaign spMailCampaign) {
		if (spMailCampaign.isNew()) {
			Object[] args = new Object[] { spMailCampaign.getCampaignName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME, args,
				spMailCampaign);

			args = new Object[] { spMailCampaign.getRsvpId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RSVPID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RSVPID, args,
				spMailCampaign);
		}
		else {
			SPMailCampaignModelImpl spMailCampaignModelImpl = (SPMailCampaignModelImpl)spMailCampaign;

			if ((spMailCampaignModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailCampaign.getCampaignName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME,
					args, spMailCampaign);
			}

			if ((spMailCampaignModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RSVPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailCampaign.getRsvpId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RSVPID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RSVPID, args,
					spMailCampaign);
			}
		}
	}

	protected void clearUniqueFindersCache(SPMailCampaign spMailCampaign) {
		SPMailCampaignModelImpl spMailCampaignModelImpl = (SPMailCampaignModelImpl)spMailCampaign;

		Object[] args = new Object[] { spMailCampaign.getCampaignName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME, args);

		if ((spMailCampaignModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CAMPAIGNNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailCampaignModelImpl.getOriginalCampaignName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNNAME, args);
		}

		args = new Object[] { spMailCampaign.getRsvpId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RSVPID, args);

		if ((spMailCampaignModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RSVPID.getColumnBitmask()) != 0) {
			args = new Object[] { spMailCampaignModelImpl.getOriginalRsvpId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RSVPID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RSVPID, args);
		}
	}

	/**
	 * Creates a new s p mail campaign with the primary key. Does not add the s p mail campaign to the database.
	 *
	 * @param spMailCampaignId the primary key for the new s p mail campaign
	 * @return the new s p mail campaign
	 */
	@Override
	public SPMailCampaign create(long spMailCampaignId) {
		SPMailCampaign spMailCampaign = new SPMailCampaignImpl();

		spMailCampaign.setNew(true);
		spMailCampaign.setPrimaryKey(spMailCampaignId);

		return spMailCampaign;
	}

	/**
	 * Removes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailCampaignId the primary key of the s p mail campaign
	 * @return the s p mail campaign that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign remove(long spMailCampaignId)
		throws NoSuchCampaignException, SystemException {
		return remove((Serializable)spMailCampaignId);
	}

	/**
	 * Removes the s p mail campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail campaign
	 * @return the s p mail campaign that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign remove(Serializable primaryKey)
		throws NoSuchCampaignException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailCampaign spMailCampaign = (SPMailCampaign)session.get(SPMailCampaignImpl.class,
					primaryKey);

			if (spMailCampaign == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailCampaign);
		}
		catch (NoSuchCampaignException nsee) {
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
	protected SPMailCampaign removeImpl(SPMailCampaign spMailCampaign)
		throws SystemException {
		spMailCampaign = toUnwrappedModel(spMailCampaign);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailCampaign)) {
				spMailCampaign = (SPMailCampaign)session.get(SPMailCampaignImpl.class,
						spMailCampaign.getPrimaryKeyObj());
			}

			if (spMailCampaign != null) {
				session.delete(spMailCampaign);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailCampaign != null) {
			clearCache(spMailCampaign);
		}

		return spMailCampaign;
	}

	@Override
	public SPMailCampaign updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaign spMailCampaign)
		throws SystemException {
		spMailCampaign = toUnwrappedModel(spMailCampaign);

		boolean isNew = spMailCampaign.isNew();

		SPMailCampaignModelImpl spMailCampaignModelImpl = (SPMailCampaignModelImpl)spMailCampaign;

		Session session = null;

		try {
			session = openSession();

			if (spMailCampaign.isNew()) {
				session.save(spMailCampaign);

				spMailCampaign.setNew(false);
			}
			else {
				session.merge(spMailCampaign);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailCampaignModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spMailCampaignModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailCampaignModelImpl.getOriginalArchive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);

				args = new Object[] { spMailCampaignModelImpl.getArchive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARCHIVE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARCHIVE,
					args);
			}
		}

		EntityCacheUtil.putResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
			SPMailCampaignImpl.class, spMailCampaign.getPrimaryKey(),
			spMailCampaign);

		clearUniqueFindersCache(spMailCampaign);
		cacheUniqueFindersCache(spMailCampaign);

		return spMailCampaign;
	}

	protected SPMailCampaign toUnwrappedModel(SPMailCampaign spMailCampaign) {
		if (spMailCampaign instanceof SPMailCampaignImpl) {
			return spMailCampaign;
		}

		SPMailCampaignImpl spMailCampaignImpl = new SPMailCampaignImpl();

		spMailCampaignImpl.setNew(spMailCampaign.isNew());
		spMailCampaignImpl.setPrimaryKey(spMailCampaign.getPrimaryKey());

		spMailCampaignImpl.setSpMailCampaignId(spMailCampaign.getSpMailCampaignId());
		spMailCampaignImpl.setGroupId(spMailCampaign.getGroupId());
		spMailCampaignImpl.setCompanyId(spMailCampaign.getCompanyId());
		spMailCampaignImpl.setCampaignName(spMailCampaign.getCampaignName());
		spMailCampaignImpl.setCategoryId(spMailCampaign.getCategoryId());
		spMailCampaignImpl.setMainTempalteId(spMailCampaign.getMainTempalteId());
		spMailCampaignImpl.setRem1TempalteId(spMailCampaign.getRem1TempalteId());
		spMailCampaignImpl.setRem2TempalteId(spMailCampaign.getRem2TempalteId());
		spMailCampaignImpl.setRem3TempalteId(spMailCampaign.getRem3TempalteId());
		spMailCampaignImpl.setThankyouTempalteId(spMailCampaign.getThankyouTempalteId());
		spMailCampaignImpl.setMissedyouTempalteId(spMailCampaign.getMissedyouTempalteId());
		spMailCampaignImpl.setMainScheduledDate(spMailCampaign.getMainScheduledDate());
		spMailCampaignImpl.setRem1ScheduledDate(spMailCampaign.getRem1ScheduledDate());
		spMailCampaignImpl.setRem2ScheduledDate(spMailCampaign.getRem2ScheduledDate());
		spMailCampaignImpl.setRem3ScheduledDate(spMailCampaign.getRem3ScheduledDate());
		spMailCampaignImpl.setThankYouScheduledDate(spMailCampaign.getThankYouScheduledDate());
		spMailCampaignImpl.setMissedyouScheduledDate(spMailCampaign.getMissedyouScheduledDate());
		spMailCampaignImpl.setRsvpId(spMailCampaign.getRsvpId());
		spMailCampaignImpl.setDlFileEntryId(spMailCampaign.getDlFileEntryId());
		spMailCampaignImpl.setSentBy(spMailCampaign.getSentBy());
		spMailCampaignImpl.setSentDate(spMailCampaign.getSentDate());
		spMailCampaignImpl.setCreateBy(spMailCampaign.getCreateBy());
		spMailCampaignImpl.setCreateDate(spMailCampaign.getCreateDate());
		spMailCampaignImpl.setModifiedBy(spMailCampaign.getModifiedBy());
		spMailCampaignImpl.setModifiedDate(spMailCampaign.getModifiedDate());
		spMailCampaignImpl.setStatus(spMailCampaign.getStatus());
		spMailCampaignImpl.setArchive(spMailCampaign.isArchive());
		spMailCampaignImpl.setCampaignType(spMailCampaign.getCampaignType());

		return spMailCampaignImpl;
	}

	/**
	 * Returns the s p mail campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign
	 * @return the s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignException, SystemException {
		SPMailCampaign spMailCampaign = fetchByPrimaryKey(primaryKey);

		if (spMailCampaign == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailCampaign;
	}

	/**
	 * Returns the s p mail campaign with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignException} if it could not be found.
	 *
	 * @param spMailCampaignId the primary key of the s p mail campaign
	 * @return the s p mail campaign
	 * @throws com.sambaash.platform.srv.mail.NoSuchCampaignException if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign findByPrimaryKey(long spMailCampaignId)
		throws NoSuchCampaignException, SystemException {
		return findByPrimaryKey((Serializable)spMailCampaignId);
	}

	/**
	 * Returns the s p mail campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail campaign
	 * @return the s p mail campaign, or <code>null</code> if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailCampaign spMailCampaign = (SPMailCampaign)EntityCacheUtil.getResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
				SPMailCampaignImpl.class, primaryKey);

		if (spMailCampaign == _nullSPMailCampaign) {
			return null;
		}

		if (spMailCampaign == null) {
			Session session = null;

			try {
				session = openSession();

				spMailCampaign = (SPMailCampaign)session.get(SPMailCampaignImpl.class,
						primaryKey);

				if (spMailCampaign != null) {
					cacheResult(spMailCampaign);
				}
				else {
					EntityCacheUtil.putResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
						SPMailCampaignImpl.class, primaryKey,
						_nullSPMailCampaign);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailCampaignModelImpl.ENTITY_CACHE_ENABLED,
					SPMailCampaignImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailCampaign;
	}

	/**
	 * Returns the s p mail campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailCampaignId the primary key of the s p mail campaign
	 * @return the s p mail campaign, or <code>null</code> if a s p mail campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailCampaign fetchByPrimaryKey(long spMailCampaignId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailCampaignId);
	}

	/**
	 * Returns all the s p mail campaigns.
	 *
	 * @return the s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaigns
	 * @param end the upper bound of the range of s p mail campaigns (not inclusive)
	 * @return the range of s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail campaigns
	 * @param end the upper bound of the range of s p mail campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailCampaign> findAll(int start, int end,
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

		List<SPMailCampaign> list = (List<SPMailCampaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILCAMPAIGN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILCAMPAIGN;

				if (pagination) {
					sql = sql.concat(SPMailCampaignModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailCampaign>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailCampaign>(list);
				}
				else {
					list = (List<SPMailCampaign>)QueryUtil.list(q,
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
	 * Removes all the s p mail campaigns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailCampaign spMailCampaign : findAll()) {
			remove(spMailCampaign);
		}
	}

	/**
	 * Returns the number of s p mail campaigns.
	 *
	 * @return the number of s p mail campaigns
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILCAMPAIGN);

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
	 * Initializes the s p mail campaign persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailCampaign")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailCampaign>> listenersList = new ArrayList<ModelListener<SPMailCampaign>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailCampaign>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailCampaignImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILCAMPAIGN = "SELECT spMailCampaign FROM SPMailCampaign spMailCampaign";
	private static final String _SQL_SELECT_SPMAILCAMPAIGN_WHERE = "SELECT spMailCampaign FROM SPMailCampaign spMailCampaign WHERE ";
	private static final String _SQL_COUNT_SPMAILCAMPAIGN = "SELECT COUNT(spMailCampaign) FROM SPMailCampaign spMailCampaign";
	private static final String _SQL_COUNT_SPMAILCAMPAIGN_WHERE = "SELECT COUNT(spMailCampaign) FROM SPMailCampaign spMailCampaign WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailCampaign.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailCampaign exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailCampaign exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailCampaignPersistenceImpl.class);
	private static SPMailCampaign _nullSPMailCampaign = new SPMailCampaignImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailCampaign> toCacheModel() {
				return _nullSPMailCampaignCacheModel;
			}
		};

	private static CacheModel<SPMailCampaign> _nullSPMailCampaignCacheModel = new CacheModel<SPMailCampaign>() {
			@Override
			public SPMailCampaign toEntityModel() {
				return _nullSPMailCampaign;
			}
		};
}