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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spjob.NoSuchApplicantsException;
import com.sambaash.platform.srv.spjob.model.SPJobApplicants;
import com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsImpl;
import com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p job applicants service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPersistence
 * @see SPJobApplicantsUtil
 * @generated
 */
public class SPJobApplicantsPersistenceImpl extends BasePersistenceImpl<SPJobApplicants>
	implements SPJobApplicantsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPJobApplicantsUtil} to access the s p job applicants persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPJobApplicantsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllAppliedJobsByJobId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllAppliedJobsByJobId",
			new String[] { Long.class.getName() },
			SPJobApplicantsModelImpl.JOBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYJOBID = new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllAppliedJobsByJobId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p job applicantses where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByJobId(long jobId)
		throws SystemException {
		return findByAllAppliedJobsByJobId(jobId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicantses where jobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobId the job ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @return the range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByJobId(long jobId,
		int start, int end) throws SystemException {
		return findByAllAppliedJobsByJobId(jobId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicantses where jobId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobId the job ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByJobId(long jobId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID;
			finderArgs = new Object[] { jobId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID;
			finderArgs = new Object[] { jobId, start, end, orderByComparator };
		}

		List<SPJobApplicants> list = (List<SPJobApplicants>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobApplicants spJobApplicants : list) {
				if ((jobId != spJobApplicants.getJobId())) {
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

			query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYJOBID_JOBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobId);

				if (!pagination) {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicants>(list);
				}
				else {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
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
	 * Returns the first s p job applicants in the ordered set where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByJobId_First(long jobId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByJobId_First(jobId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobId=");
		msg.append(jobId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the first s p job applicants in the ordered set where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByJobId_First(long jobId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJobApplicants> list = findByAllAppliedJobsByJobId(jobId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job applicants in the ordered set where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByJobId_Last(long jobId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByJobId_Last(jobId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobId=");
		msg.append(jobId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the last s p job applicants in the ordered set where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByJobId_Last(long jobId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllAppliedJobsByJobId(jobId);

		if (count == 0) {
			return null;
		}

		List<SPJobApplicants> list = findByAllAppliedJobsByJobId(jobId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job applicantses before and after the current s p job applicants in the ordered set where jobId = &#63;.
	 *
	 * @param spJobApplicantsId the primary key of the current s p job applicants
	 * @param jobId the job ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants[] findByAllAppliedJobsByJobId_PrevAndNext(
		long spJobApplicantsId, long jobId, OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = findByPrimaryKey(spJobApplicantsId);

		Session session = null;

		try {
			session = openSession();

			SPJobApplicants[] array = new SPJobApplicantsImpl[3];

			array[0] = getByAllAppliedJobsByJobId_PrevAndNext(session,
					spJobApplicants, jobId, orderByComparator, true);

			array[1] = spJobApplicants;

			array[2] = getByAllAppliedJobsByJobId_PrevAndNext(session,
					spJobApplicants, jobId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJobApplicants getByAllAppliedJobsByJobId_PrevAndNext(
		Session session, SPJobApplicants spJobApplicants, long jobId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

		query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYJOBID_JOBID_2);

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
			query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jobId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJobApplicants);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobApplicants> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job applicantses where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllAppliedJobsByJobId(long jobId)
		throws SystemException {
		for (SPJobApplicants spJobApplicants : findByAllAppliedJobsByJobId(
				jobId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobApplicants);
		}
	}

	/**
	 * Returns the number of s p job applicantses where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllAppliedJobsByJobId(long jobId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYJOBID;

		Object[] finderArgs = new Object[] { jobId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYJOBID_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobId);

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

	private static final String _FINDER_COLUMN_ALLAPPLIEDJOBSBYJOBID_JOBID_2 = "spJobApplicants.jobId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllAppliedJobsByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllAppliedJobsByUserId",
			new String[] { Long.class.getName() },
			SPJobApplicantsModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYUSERID = new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllAppliedJobsByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p job applicantses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByUserId(long userId)
		throws SystemException {
		return findByAllAppliedJobsByUserId(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicantses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @return the range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByUserId(long userId,
		int start, int end) throws SystemException {
		return findByAllAppliedJobsByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicantses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByUserId(long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SPJobApplicants> list = (List<SPJobApplicants>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobApplicants spJobApplicants : list) {
				if ((userId != spJobApplicants.getUserId())) {
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

			query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicants>(list);
				}
				else {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
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
	 * Returns the first s p job applicants in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByUserId_First(userId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the first s p job applicants in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPJobApplicants> list = findByAllAppliedJobsByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job applicants in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByUserId_Last(userId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the last s p job applicants in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllAppliedJobsByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPJobApplicants> list = findByAllAppliedJobsByUserId(userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job applicantses before and after the current s p job applicants in the ordered set where userId = &#63;.
	 *
	 * @param spJobApplicantsId the primary key of the current s p job applicants
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants[] findByAllAppliedJobsByUserId_PrevAndNext(
		long spJobApplicantsId, long userId, OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = findByPrimaryKey(spJobApplicantsId);

		Session session = null;

		try {
			session = openSession();

			SPJobApplicants[] array = new SPJobApplicantsImpl[3];

			array[0] = getByAllAppliedJobsByUserId_PrevAndNext(session,
					spJobApplicants, userId, orderByComparator, true);

			array[1] = spJobApplicants;

			array[2] = getByAllAppliedJobsByUserId_PrevAndNext(session,
					spJobApplicants, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJobApplicants getByAllAppliedJobsByUserId_PrevAndNext(
		Session session, SPJobApplicants spJobApplicants, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

		query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYUSERID_USERID_2);

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
			query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJobApplicants);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobApplicants> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job applicantses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllAppliedJobsByUserId(long userId)
		throws SystemException {
		for (SPJobApplicants spJobApplicants : findByAllAppliedJobsByUserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobApplicants);
		}
	}

	/**
	 * Returns the number of s p job applicantses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllAppliedJobsByUserId(long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYUSERID_USERID_2);

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

	private static final String _FINDER_COLUMN_ALLAPPLIEDJOBSBYUSERID_USERID_2 = "spJobApplicants.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAllAppliedJobsByCommunity",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED,
			SPJobApplicantsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAllAppliedJobsByCommunity",
			new String[] { Long.class.getName() },
			SPJobApplicantsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYCOMMUNITY =
		new FinderPath(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAllAppliedJobsByCommunity",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p job applicantses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByCommunity(long groupId)
		throws SystemException {
		return findByAllAppliedJobsByCommunity(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicantses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @return the range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByCommunity(long groupId,
		int start, int end) throws SystemException {
		return findByAllAppliedJobsByCommunity(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicantses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findByAllAppliedJobsByCommunity(long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<SPJobApplicants> list = (List<SPJobApplicants>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPJobApplicants spJobApplicants : list) {
				if ((groupId != spJobApplicants.getGroupId())) {
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

			query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYCOMMUNITY_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicants>(list);
				}
				else {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
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
	 * Returns the first s p job applicants in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByCommunity_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByCommunity_First(groupId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the first s p job applicants in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByCommunity_First(
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPJobApplicants> list = findByAllAppliedJobsByCommunity(groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p job applicants in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByAllAppliedJobsByCommunity_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByAllAppliedJobsByCommunity_Last(groupId,
				orderByComparator);

		if (spJobApplicants != null) {
			return spJobApplicants;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicantsException(msg.toString());
	}

	/**
	 * Returns the last s p job applicants in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByAllAppliedJobsByCommunity_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAllAppliedJobsByCommunity(groupId);

		if (count == 0) {
			return null;
		}

		List<SPJobApplicants> list = findByAllAppliedJobsByCommunity(groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p job applicantses before and after the current s p job applicants in the ordered set where groupId = &#63;.
	 *
	 * @param spJobApplicantsId the primary key of the current s p job applicants
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants[] findByAllAppliedJobsByCommunity_PrevAndNext(
		long spJobApplicantsId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = findByPrimaryKey(spJobApplicantsId);

		Session session = null;

		try {
			session = openSession();

			SPJobApplicants[] array = new SPJobApplicantsImpl[3];

			array[0] = getByAllAppliedJobsByCommunity_PrevAndNext(session,
					spJobApplicants, groupId, orderByComparator, true);

			array[1] = spJobApplicants;

			array[2] = getByAllAppliedJobsByCommunity_PrevAndNext(session,
					spJobApplicants, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPJobApplicants getByAllAppliedJobsByCommunity_PrevAndNext(
		Session session, SPJobApplicants spJobApplicants, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPJOBAPPLICANTS_WHERE);

		query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYCOMMUNITY_GROUPID_2);

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
			query.append(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spJobApplicants);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPJobApplicants> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p job applicantses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAllAppliedJobsByCommunity(long groupId)
		throws SystemException {
		for (SPJobApplicants spJobApplicants : findByAllAppliedJobsByCommunity(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spJobApplicants);
		}
	}

	/**
	 * Returns the number of s p job applicantses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAllAppliedJobsByCommunity(long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYCOMMUNITY;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPJOBAPPLICANTS_WHERE);

			query.append(_FINDER_COLUMN_ALLAPPLIEDJOBSBYCOMMUNITY_GROUPID_2);

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

	private static final String _FINDER_COLUMN_ALLAPPLIEDJOBSBYCOMMUNITY_GROUPID_2 =
		"spJobApplicants.groupId = ?";

	public SPJobApplicantsPersistenceImpl() {
		setModelClass(SPJobApplicants.class);
	}

	/**
	 * Caches the s p job applicants in the entity cache if it is enabled.
	 *
	 * @param spJobApplicants the s p job applicants
	 */
	@Override
	public void cacheResult(SPJobApplicants spJobApplicants) {
		EntityCacheUtil.putResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsImpl.class, spJobApplicants.getPrimaryKey(),
			spJobApplicants);

		spJobApplicants.resetOriginalValues();
	}

	/**
	 * Caches the s p job applicantses in the entity cache if it is enabled.
	 *
	 * @param spJobApplicantses the s p job applicantses
	 */
	@Override
	public void cacheResult(List<SPJobApplicants> spJobApplicantses) {
		for (SPJobApplicants spJobApplicants : spJobApplicantses) {
			if (EntityCacheUtil.getResult(
						SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
						SPJobApplicantsImpl.class,
						spJobApplicants.getPrimaryKey()) == null) {
				cacheResult(spJobApplicants);
			}
			else {
				spJobApplicants.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p job applicantses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPJobApplicantsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPJobApplicantsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p job applicants.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPJobApplicants spJobApplicants) {
		EntityCacheUtil.removeResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsImpl.class, spJobApplicants.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPJobApplicants> spJobApplicantses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPJobApplicants spJobApplicants : spJobApplicantses) {
			EntityCacheUtil.removeResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
				SPJobApplicantsImpl.class, spJobApplicants.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p job applicants with the primary key. Does not add the s p job applicants to the database.
	 *
	 * @param spJobApplicantsId the primary key for the new s p job applicants
	 * @return the new s p job applicants
	 */
	@Override
	public SPJobApplicants create(long spJobApplicantsId) {
		SPJobApplicants spJobApplicants = new SPJobApplicantsImpl();

		spJobApplicants.setNew(true);
		spJobApplicants.setPrimaryKey(spJobApplicantsId);

		return spJobApplicants;
	}

	/**
	 * Removes the s p job applicants with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spJobApplicantsId the primary key of the s p job applicants
	 * @return the s p job applicants that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants remove(long spJobApplicantsId)
		throws NoSuchApplicantsException, SystemException {
		return remove((Serializable)spJobApplicantsId);
	}

	/**
	 * Removes the s p job applicants with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p job applicants
	 * @return the s p job applicants that was removed
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants remove(Serializable primaryKey)
		throws NoSuchApplicantsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPJobApplicants spJobApplicants = (SPJobApplicants)session.get(SPJobApplicantsImpl.class,
					primaryKey);

			if (spJobApplicants == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicantsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spJobApplicants);
		}
		catch (NoSuchApplicantsException nsee) {
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
	protected SPJobApplicants removeImpl(SPJobApplicants spJobApplicants)
		throws SystemException {
		spJobApplicants = toUnwrappedModel(spJobApplicants);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spJobApplicants)) {
				spJobApplicants = (SPJobApplicants)session.get(SPJobApplicantsImpl.class,
						spJobApplicants.getPrimaryKeyObj());
			}

			if (spJobApplicants != null) {
				session.delete(spJobApplicants);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spJobApplicants != null) {
			clearCache(spJobApplicants);
		}

		return spJobApplicants;
	}

	@Override
	public SPJobApplicants updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants)
		throws SystemException {
		spJobApplicants = toUnwrappedModel(spJobApplicants);

		boolean isNew = spJobApplicants.isNew();

		SPJobApplicantsModelImpl spJobApplicantsModelImpl = (SPJobApplicantsModelImpl)spJobApplicants;

		Session session = null;

		try {
			session = openSession();

			if (spJobApplicants.isNew()) {
				session.save(spJobApplicants);

				spJobApplicants.setNew(false);
			}
			else {
				session.merge(spJobApplicants);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPJobApplicantsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spJobApplicantsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobApplicantsModelImpl.getOriginalJobId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYJOBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID,
					args);

				args = new Object[] { spJobApplicantsModelImpl.getJobId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYJOBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYJOBID,
					args);
			}

			if ((spJobApplicantsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobApplicantsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID,
					args);

				args = new Object[] { spJobApplicantsModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYUSERID,
					args);
			}

			if ((spJobApplicantsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spJobApplicantsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYCOMMUNITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY,
					args);

				args = new Object[] { spJobApplicantsModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLAPPLIEDJOBSBYCOMMUNITY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLAPPLIEDJOBSBYCOMMUNITY,
					args);
			}
		}

		EntityCacheUtil.putResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
			SPJobApplicantsImpl.class, spJobApplicants.getPrimaryKey(),
			spJobApplicants);

		return spJobApplicants;
	}

	protected SPJobApplicants toUnwrappedModel(SPJobApplicants spJobApplicants) {
		if (spJobApplicants instanceof SPJobApplicantsImpl) {
			return spJobApplicants;
		}

		SPJobApplicantsImpl spJobApplicantsImpl = new SPJobApplicantsImpl();

		spJobApplicantsImpl.setNew(spJobApplicants.isNew());
		spJobApplicantsImpl.setPrimaryKey(spJobApplicants.getPrimaryKey());

		spJobApplicantsImpl.setSpJobApplicantsId(spJobApplicants.getSpJobApplicantsId());
		spJobApplicantsImpl.setJobId(spJobApplicants.getJobId());
		spJobApplicantsImpl.setGroupId(spJobApplicants.getGroupId());
		spJobApplicantsImpl.setCompanyId(spJobApplicants.getCompanyId());
		spJobApplicantsImpl.setUserId(spJobApplicants.getUserId());
		spJobApplicantsImpl.setCreatedBy(spJobApplicants.getCreatedBy());
		spJobApplicantsImpl.setUpdatedBy(spJobApplicants.getUpdatedBy());
		spJobApplicantsImpl.setCreateDate(spJobApplicants.getCreateDate());
		spJobApplicantsImpl.setModifiedDate(spJobApplicants.getModifiedDate());
		spJobApplicantsImpl.setFirstName(spJobApplicants.getFirstName());
		spJobApplicantsImpl.setLastName(spJobApplicants.getLastName());
		spJobApplicantsImpl.setEmailAddress(spJobApplicants.getEmailAddress());
		spJobApplicantsImpl.setContactNumber(spJobApplicants.getContactNumber());
		spJobApplicantsImpl.setYearsOfExperience(spJobApplicants.getYearsOfExperience());
		spJobApplicantsImpl.setResume(spJobApplicants.getResume());
		spJobApplicantsImpl.setCoverLetter(spJobApplicants.getCoverLetter());
		spJobApplicantsImpl.setBriefInfos(spJobApplicants.getBriefInfos());
		spJobApplicantsImpl.setExtra1(spJobApplicants.getExtra1());
		spJobApplicantsImpl.setExtra2(spJobApplicants.getExtra2());
		spJobApplicantsImpl.setExtra3(spJobApplicants.getExtra3());
		spJobApplicantsImpl.setExtra4(spJobApplicants.getExtra4());
		spJobApplicantsImpl.setExtra5(spJobApplicants.getExtra5());

		return spJobApplicantsImpl;
	}

	/**
	 * Returns the s p job applicants with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job applicants
	 * @return the s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicantsException, SystemException {
		SPJobApplicants spJobApplicants = fetchByPrimaryKey(primaryKey);

		if (spJobApplicants == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicantsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spJobApplicants;
	}

	/**
	 * Returns the s p job applicants with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsException} if it could not be found.
	 *
	 * @param spJobApplicantsId the primary key of the s p job applicants
	 * @return the s p job applicants
	 * @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants findByPrimaryKey(long spJobApplicantsId)
		throws NoSuchApplicantsException, SystemException {
		return findByPrimaryKey((Serializable)spJobApplicantsId);
	}

	/**
	 * Returns the s p job applicants with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p job applicants
	 * @return the s p job applicants, or <code>null</code> if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPJobApplicants spJobApplicants = (SPJobApplicants)EntityCacheUtil.getResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
				SPJobApplicantsImpl.class, primaryKey);

		if (spJobApplicants == _nullSPJobApplicants) {
			return null;
		}

		if (spJobApplicants == null) {
			Session session = null;

			try {
				session = openSession();

				spJobApplicants = (SPJobApplicants)session.get(SPJobApplicantsImpl.class,
						primaryKey);

				if (spJobApplicants != null) {
					cacheResult(spJobApplicants);
				}
				else {
					EntityCacheUtil.putResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
						SPJobApplicantsImpl.class, primaryKey,
						_nullSPJobApplicants);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPJobApplicantsModelImpl.ENTITY_CACHE_ENABLED,
					SPJobApplicantsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spJobApplicants;
	}

	/**
	 * Returns the s p job applicants with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spJobApplicantsId the primary key of the s p job applicants
	 * @return the s p job applicants, or <code>null</code> if a s p job applicants with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPJobApplicants fetchByPrimaryKey(long spJobApplicantsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spJobApplicantsId);
	}

	/**
	 * Returns all the s p job applicantses.
	 *
	 * @return the s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p job applicantses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @return the range of s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p job applicantses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p job applicantses
	 * @param end the upper bound of the range of s p job applicantses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p job applicantses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPJobApplicants> findAll(int start, int end,
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

		List<SPJobApplicants> list = (List<SPJobApplicants>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPJOBAPPLICANTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPJOBAPPLICANTS;

				if (pagination) {
					sql = sql.concat(SPJobApplicantsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPJobApplicants>(list);
				}
				else {
					list = (List<SPJobApplicants>)QueryUtil.list(q,
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
	 * Removes all the s p job applicantses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPJobApplicants spJobApplicants : findAll()) {
			remove(spJobApplicants);
		}
	}

	/**
	 * Returns the number of s p job applicantses.
	 *
	 * @return the number of s p job applicantses
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

				Query q = session.createQuery(_SQL_COUNT_SPJOBAPPLICANTS);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the s p job applicants persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spjob.model.SPJobApplicants")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPJobApplicants>> listenersList = new ArrayList<ModelListener<SPJobApplicants>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPJobApplicants>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPJobApplicantsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPJOBAPPLICANTS = "SELECT spJobApplicants FROM SPJobApplicants spJobApplicants";
	private static final String _SQL_SELECT_SPJOBAPPLICANTS_WHERE = "SELECT spJobApplicants FROM SPJobApplicants spJobApplicants WHERE ";
	private static final String _SQL_COUNT_SPJOBAPPLICANTS = "SELECT COUNT(spJobApplicants) FROM SPJobApplicants spJobApplicants";
	private static final String _SQL_COUNT_SPJOBAPPLICANTS_WHERE = "SELECT COUNT(spJobApplicants) FROM SPJobApplicants spJobApplicants WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spJobApplicants.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPJobApplicants exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPJobApplicants exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPJobApplicantsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"yearsOfExperience"
			});
	private static SPJobApplicants _nullSPJobApplicants = new SPJobApplicantsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPJobApplicants> toCacheModel() {
				return _nullSPJobApplicantsCacheModel;
			}
		};

	private static CacheModel<SPJobApplicants> _nullSPJobApplicantsCacheModel = new CacheModel<SPJobApplicants>() {
			@Override
			public SPJobApplicants toEntityModel() {
				return _nullSPJobApplicants;
			}
		};
}