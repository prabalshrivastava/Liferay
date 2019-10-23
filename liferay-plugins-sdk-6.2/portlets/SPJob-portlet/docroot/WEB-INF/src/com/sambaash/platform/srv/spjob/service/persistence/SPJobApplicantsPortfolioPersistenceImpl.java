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

package com.sambaash.platform.srv.spjob.service.persistence;

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

import com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException;
import com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio;
import com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioImpl;
import com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p job applicants portfolio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPortfolioPersistence
 * @see SPJobApplicantsPortfolioUtil
 * @generated
 */
public class SPJobApplicantsPortfolioPersistenceImpl extends BasePersistenceImpl<SPJobApplicantsPortfolio>
	implements SPJobApplicantsPortfolioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPJobApplicantsPortfolioUtil} to access the s p job applicants portfolio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPJobApplicantsPortfolioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID =
		new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllPortfolioIdsForJobApplyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID =
		new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllPortfolioIdsForJobApplyId",
			new String[] { Long.class.getName() },
			SPJobApplicantsPortfolioModelImpl.JOBAPPLYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLPORTFOLIOIDSFORJOBAPPLYID =
		new FinderPath(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllPortfolioIdsForJobApplyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p job applicants portfolios where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @return the matching s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId) throws SystemException {
		return findByAllPortfolioIdsForJobApplyId(jobApplyId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicants portfolios where jobApplyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobApplyId the job apply ID
	 * @param start the lower bound of the range of s p job applicants portfolios
	 * @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	 * @return the range of matching s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end) throws SystemException {
		return findByAllPortfolioIdsForJobApplyId(jobApplyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicants portfolios where jobApplyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobApplyId the job apply ID
	 * @param start the lower bound of the range of s p job applicants portfolios
	 * @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findByAllPortfolioIdsForJobApplyId(
		long jobApplyId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID;
			finderArgs = new Object[] { jobApplyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID;
			finderArgs = new Object[] { jobApplyId, start, end, orderByComparator };
		}

		List<SPJobApplicantsPortfolio> list = (List<SPJobApplicantsPortfolio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobApplicantsPortfolio spJobApplicantsPortfolio : list) {
				if ((jobApplyId != spJobApplicantsPortfolio.getJobApplyId())) {
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

			query.append(_SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO_WHERE);

			query.append(_FINDER_COLUMN_ALLPORTFOLIOIDSFORJOBAPPLYID_JOBAPPLYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobApplicantsPortfolioModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobApplyId);

				if (!pagination) {
					list = (List<SPJobApplicantsPortfolio>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicantsPortfolio>(list);
				}
				else {
					list = (List<SPJobApplicantsPortfolio>)QueryUtil.list(q,
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
	 * Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants portfolio
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId, OrderByComparator orderByComparator)
		throws NoSuchApplicantsPortfolioException, SystemException {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = fetchByAllPortfolioIdsForJobApplyId_First(jobApplyId,
				orderByComparator);

		if (spJobApplicantsPortfolio != null) {
			return spJobApplicantsPortfolio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobApplyId=");
		msg.append(jobApplyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsPortfolioException(msg.toString());
	}

	/**
	 * Returns the first s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_First(
		long jobApplyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPJobApplicantsPortfolio> list = findByAllPortfolioIdsForJobApplyId(jobApplyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants portfolio
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a matching s p job applicants portfolio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio findByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId, OrderByComparator orderByComparator)
		throws NoSuchApplicantsPortfolioException, SystemException {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = fetchByAllPortfolioIdsForJobApplyId_Last(jobApplyId,
				orderByComparator);

		if (spJobApplicantsPortfolio != null) {
			return spJobApplicantsPortfolio;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobApplyId=");
		msg.append(jobApplyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsPortfolioException(msg.toString());
	}

	/**
	 * Returns the last s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants portfolio, or <code>null</code> if a matching s p job applicants portfolio could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio fetchByAllPortfolioIdsForJobApplyId_Last(
		long jobApplyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAllPortfolioIdsForJobApplyId(jobApplyId);

		if (count == 0) {
			return null;
		}

		List<SPJobApplicantsPortfolio> list = findByAllPortfolioIdsForJobApplyId(jobApplyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job applicants portfolios before and after the current s p job applicants portfolio in the ordered set where jobApplyId = &#63;.
	 *
	 * @param spJobApplicantsPortfolioPK the primary key of the current s p job applicants portfolio
	 * @param jobApplyId the job apply ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job applicants portfolio
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio[] findByAllPortfolioIdsForJobApplyId_PrevAndNext(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK, long jobApplyId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsPortfolioException, SystemException {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = findByPrimaryKey(spJobApplicantsPortfolioPK);

		Session session = null;

		try {
			session = openSession();

			SPJobApplicantsPortfolio[] array = new SPJobApplicantsPortfolioImpl[3];

			array[0] = getByAllPortfolioIdsForJobApplyId_PrevAndNext(session,
					spJobApplicantsPortfolio, jobApplyId, orderByComparator,
					true);

			array[1] = spJobApplicantsPortfolio;

			array[2] = getByAllPortfolioIdsForJobApplyId_PrevAndNext(session,
					spJobApplicantsPortfolio, jobApplyId, orderByComparator,
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

	protected SPJobApplicantsPortfolio getByAllPortfolioIdsForJobApplyId_PrevAndNext(
		Session session, SPJobApplicantsPortfolio spJobApplicantsPortfolio,
		long jobApplyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO_WHERE);

		query.append(_FINDER_COLUMN_ALLPORTFOLIOIDSFORJOBAPPLYID_JOBAPPLYID_2);

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
			query.append(SPJobApplicantsPortfolioModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jobApplyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJobApplicantsPortfolio);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobApplicantsPortfolio> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job applicants portfolios where jobApplyId = &#63; from the database.
	 *
	 * @param jobApplyId the job apply ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws SystemException {
		for (SPJobApplicantsPortfolio spJobApplicantsPortfolio : findByAllPortfolioIdsForJobApplyId(
				jobApplyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobApplicantsPortfolio);
		}
	}

	/**
	 * Returns the number of s p job applicants portfolios where jobApplyId = &#63;.
	 *
	 * @param jobApplyId the job apply ID
	 * @return the number of matching s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllPortfolioIdsForJobApplyId(long jobApplyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLPORTFOLIOIDSFORJOBAPPLYID;

		Object[] finderArgs = new Object[] { jobApplyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOBAPPLICANTSPORTFOLIO_WHERE);

			query.append(_FINDER_COLUMN_ALLPORTFOLIOIDSFORJOBAPPLYID_JOBAPPLYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobApplyId);

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

	private static final String _FINDER_COLUMN_ALLPORTFOLIOIDSFORJOBAPPLYID_JOBAPPLYID_2 =
		"spJobApplicantsPortfolio.id.jobApplyId = ?";

	public SPJobApplicantsPortfolioPersistenceImpl() {
		setModelClass(SPJobApplicantsPortfolio.class);
	}

	/**
	 * Caches the s p job applicants portfolio in the entity cache if it is enabled.
	 *
	 * @param spJobApplicantsPortfolio the s p job applicants portfolio
	 */
	@Override
	public void cacheResult(SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		EntityCacheUtil.putResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			spJobApplicantsPortfolio.getPrimaryKey(), spJobApplicantsPortfolio);

		spJobApplicantsPortfolio.resetOriginalValues();
	}

	/**
	 * Caches the s p job applicants portfolios in the entity cache if it is enabled.
	 *
	 * @param spJobApplicantsPortfolios the s p job applicants portfolios
	 */
	@Override
	public void cacheResult(
		List<SPJobApplicantsPortfolio> spJobApplicantsPortfolios) {
		for (SPJobApplicantsPortfolio spJobApplicantsPortfolio : spJobApplicantsPortfolios) {
			if (EntityCacheUtil.getResult(
						SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
						SPJobApplicantsPortfolioImpl.class,
						spJobApplicantsPortfolio.getPrimaryKey()) == null) {
				cacheResult(spJobApplicantsPortfolio);
			}
			else {
				spJobApplicantsPortfolio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p job applicants portfolios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPJobApplicantsPortfolioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPJobApplicantsPortfolioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p job applicants portfolio.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		EntityCacheUtil.removeResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			spJobApplicantsPortfolio.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SPJobApplicantsPortfolio> spJobApplicantsPortfolios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPJobApplicantsPortfolio spJobApplicantsPortfolio : spJobApplicantsPortfolios) {
			EntityCacheUtil.removeResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
				SPJobApplicantsPortfolioImpl.class,
				spJobApplicantsPortfolio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p job applicants portfolio with the primary key. Does not add the s p job applicants portfolio to the database.
	 *
	 * @param spJobApplicantsPortfolioPK the primary key for the new s p job applicants portfolio
	 * @return the new s p job applicants portfolio
	 */
	@Override
	public SPJobApplicantsPortfolio create(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK) {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = new SPJobApplicantsPortfolioImpl();

		spJobApplicantsPortfolio.setNew(true);
		spJobApplicantsPortfolio.setPrimaryKey(spJobApplicantsPortfolioPK);

		return spJobApplicantsPortfolio;
	}

	/**
	 * Removes the s p job applicants portfolio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio remove(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws NoSuchApplicantsPortfolioException, SystemException {
		return remove((Serializable)spJobApplicantsPortfolioPK);
	}

	/**
	 * Removes the s p job applicants portfolio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio remove(Serializable primaryKey)
		throws NoSuchApplicantsPortfolioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPJobApplicantsPortfolio spJobApplicantsPortfolio = (SPJobApplicantsPortfolio)session.get(SPJobApplicantsPortfolioImpl.class,
					primaryKey);

			if (spJobApplicantsPortfolio == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicantsPortfolioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spJobApplicantsPortfolio);
		}
		catch (NoSuchApplicantsPortfolioException nsee) {
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
	protected SPJobApplicantsPortfolio removeImpl(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio)
		throws SystemException {
		spJobApplicantsPortfolio = toUnwrappedModel(spJobApplicantsPortfolio);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spJobApplicantsPortfolio)) {
				spJobApplicantsPortfolio = (SPJobApplicantsPortfolio)session.get(SPJobApplicantsPortfolioImpl.class,
						spJobApplicantsPortfolio.getPrimaryKeyObj());
			}

			if (spJobApplicantsPortfolio != null) {
				session.delete(spJobApplicantsPortfolio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spJobApplicantsPortfolio != null) {
			clearCache(spJobApplicantsPortfolio);
		}

		return spJobApplicantsPortfolio;
	}

	@Override
	public SPJobApplicantsPortfolio updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio spJobApplicantsPortfolio)
		throws SystemException {
		spJobApplicantsPortfolio = toUnwrappedModel(spJobApplicantsPortfolio);

		boolean isNew = spJobApplicantsPortfolio.isNew();

		SPJobApplicantsPortfolioModelImpl spJobApplicantsPortfolioModelImpl = (SPJobApplicantsPortfolioModelImpl)spJobApplicantsPortfolio;

		Session session = null;

		try {
			session = openSession();

			if (spJobApplicantsPortfolio.isNew()) {
				session.save(spJobApplicantsPortfolio);

				spJobApplicantsPortfolio.setNew(false);
			}
			else {
				session.merge(spJobApplicantsPortfolio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPJobApplicantsPortfolioModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spJobApplicantsPortfolioModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobApplicantsPortfolioModelImpl.getOriginalJobApplyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLPORTFOLIOIDSFORJOBAPPLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID,
					args);

				args = new Object[] {
						spJobApplicantsPortfolioModelImpl.getJobApplyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLPORTFOLIOIDSFORJOBAPPLYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLPORTFOLIOIDSFORJOBAPPLYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsPortfolioImpl.class,
			spJobApplicantsPortfolio.getPrimaryKey(), spJobApplicantsPortfolio);

		return spJobApplicantsPortfolio;
	}

	protected SPJobApplicantsPortfolio toUnwrappedModel(
		SPJobApplicantsPortfolio spJobApplicantsPortfolio) {
		if (spJobApplicantsPortfolio instanceof SPJobApplicantsPortfolioImpl) {
			return spJobApplicantsPortfolio;
		}

		SPJobApplicantsPortfolioImpl spJobApplicantsPortfolioImpl = new SPJobApplicantsPortfolioImpl();

		spJobApplicantsPortfolioImpl.setNew(spJobApplicantsPortfolio.isNew());
		spJobApplicantsPortfolioImpl.setPrimaryKey(spJobApplicantsPortfolio.getPrimaryKey());

		spJobApplicantsPortfolioImpl.setJobApplyId(spJobApplicantsPortfolio.getJobApplyId());
		spJobApplicantsPortfolioImpl.setPorfolioId(spJobApplicantsPortfolio.getPorfolioId());
		spJobApplicantsPortfolioImpl.setUserId(spJobApplicantsPortfolio.getUserId());
		spJobApplicantsPortfolioImpl.setCreatedBy(spJobApplicantsPortfolio.getCreatedBy());
		spJobApplicantsPortfolioImpl.setUpdatedBy(spJobApplicantsPortfolio.getUpdatedBy());
		spJobApplicantsPortfolioImpl.setCreateDate(spJobApplicantsPortfolio.getCreateDate());
		spJobApplicantsPortfolioImpl.setModifiedDate(spJobApplicantsPortfolio.getModifiedDate());
		spJobApplicantsPortfolioImpl.setExtra1(spJobApplicantsPortfolio.getExtra1());
		spJobApplicantsPortfolioImpl.setExtra2(spJobApplicantsPortfolio.getExtra2());

		return spJobApplicantsPortfolioImpl;
	}

	/**
	 * Returns the s p job applicants portfolio with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicantsPortfolioException, SystemException {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = fetchByPrimaryKey(primaryKey);

		if (spJobApplicantsPortfolio == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicantsPortfolioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spJobApplicantsPortfolio;
	}

	/**
	 * Returns the s p job applicants portfolio with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException} if it could not be found.
	 *
	 * @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsPortfolioException if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio findByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws NoSuchApplicantsPortfolioException, SystemException {
		return findByPrimaryKey((Serializable)spJobApplicantsPortfolioPK);
	}

	/**
	 * Returns the s p job applicants portfolio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio, or <code>null</code> if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPJobApplicantsPortfolio spJobApplicantsPortfolio = (SPJobApplicantsPortfolio)EntityCacheUtil.getResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
				SPJobApplicantsPortfolioImpl.class, primaryKey);

		if (spJobApplicantsPortfolio == _nullSPJobApplicantsPortfolio) {
			return null;
		}

		if (spJobApplicantsPortfolio == null) {
			Session session = null;

			try {
				session = openSession();

				spJobApplicantsPortfolio = (SPJobApplicantsPortfolio)session.get(SPJobApplicantsPortfolioImpl.class,
						primaryKey);

				if (spJobApplicantsPortfolio != null) {
					cacheResult(spJobApplicantsPortfolio);
				}
				else {
					EntityCacheUtil.putResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
						SPJobApplicantsPortfolioImpl.class, primaryKey,
						_nullSPJobApplicantsPortfolio);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPJobApplicantsPortfolioModelImpl.ENTITY_CACHE_ENABLED,
					SPJobApplicantsPortfolioImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spJobApplicantsPortfolio;
	}

	/**
	 * Returns the s p job applicants portfolio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spJobApplicantsPortfolioPK the primary key of the s p job applicants portfolio
	 * @return the s p job applicants portfolio, or <code>null</code> if a s p job applicants portfolio with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicantsPortfolio fetchByPrimaryKey(
		SPJobApplicantsPortfolioPK spJobApplicantsPortfolioPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spJobApplicantsPortfolioPK);
	}

	/**
	 * Returns all the s p job applicants portfolios.
	 *
	 * @return the s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicants portfolios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job applicants portfolios
	 * @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	 * @return the range of s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicants portfolios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsPortfolioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job applicants portfolios
	 * @param end the upper bound of the range of s p job applicants portfolios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p job applicants portfolios
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicantsPortfolio> findAll(int start, int end,
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

		List<SPJobApplicantsPortfolio> list = (List<SPJobApplicantsPortfolio>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO;

				if (pagination) {
					sql = sql.concat(SPJobApplicantsPortfolioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPJobApplicantsPortfolio>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicantsPortfolio>(list);
				}
				else {
					list = (List<SPJobApplicantsPortfolio>)QueryUtil.list(q,
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
	 * Removes all the s p job applicants portfolios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPJobApplicantsPortfolio spJobApplicantsPortfolio : findAll()) {
			remove(spJobApplicantsPortfolio);
		}
	}

	/**
	 * Returns the number of s p job applicants portfolios.
	 *
	 * @return the number of s p job applicants portfolios
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

				Query q = session.createQuery(_SQL_COUNT_SPJOBAPPLICANTSPORTFOLIO);

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
	 * Initializes the s p job applicants portfolio persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spjob.model.SPJobApplicantsPortfolio")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPJobApplicantsPortfolio>> listenersList = new ArrayList<ModelListener<SPJobApplicantsPortfolio>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPJobApplicantsPortfolio>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPJobApplicantsPortfolioImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO = "SELECT spJobApplicantsPortfolio FROM SPJobApplicantsPortfolio spJobApplicantsPortfolio";
	private static final String _SQL_SELECT_SPJOBAPPLICANTSPORTFOLIO_WHERE = "SELECT spJobApplicantsPortfolio FROM SPJobApplicantsPortfolio spJobApplicantsPortfolio WHERE ";
	private static final String _SQL_COUNT_SPJOBAPPLICANTSPORTFOLIO = "SELECT COUNT(spJobApplicantsPortfolio) FROM SPJobApplicantsPortfolio spJobApplicantsPortfolio";
	private static final String _SQL_COUNT_SPJOBAPPLICANTSPORTFOLIO_WHERE = "SELECT COUNT(spJobApplicantsPortfolio) FROM SPJobApplicantsPortfolio spJobApplicantsPortfolio WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spJobApplicantsPortfolio.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPJobApplicantsPortfolio exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPJobApplicantsPortfolio exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPJobApplicantsPortfolioPersistenceImpl.class);
	private static SPJobApplicantsPortfolio _nullSPJobApplicantsPortfolio = new SPJobApplicantsPortfolioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPJobApplicantsPortfolio> toCacheModel() {
				return _nullSPJobApplicantsPortfolioCacheModel;
			}
		};

	private static CacheModel<SPJobApplicantsPortfolio> _nullSPJobApplicantsPortfolioCacheModel =
		new CacheModel<SPJobApplicantsPortfolio>() {
			@Override
			public SPJobApplicantsPortfolio toEntityModel() {
				return _nullSPJobApplicantsPortfolio;
			}
		};
}