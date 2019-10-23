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

package com.sambaash.platform.srv.validation.service.persistence;

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

import com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException;
import com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult;
import com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultImpl;
import com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p student programme result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResultPersistence
 * @see SPStudentProgrammeResultUtil
 * @generated
 */
public class SPStudentProgrammeResultPersistenceImpl extends BasePersistenceImpl<SPStudentProgrammeResult>
	implements SPStudentProgrammeResultPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPStudentProgrammeResultUtil} to access the s p student programme result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPStudentProgrammeResultImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NRICANDPROGRAMME =
		new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNricAndProgramme",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME =
		new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNricAndProgramme",
			new String[] { String.class.getName(), String.class.getName() },
			SPStudentProgrammeResultModelImpl.NRIC_COLUMN_BITMASK |
			SPStudentProgrammeResultModelImpl.PROGRAMME_COLUMN_BITMASK |
			SPStudentProgrammeResultModelImpl.EXAM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NRICANDPROGRAMME = new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNricAndProgramme",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p student programme results where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @return the matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByNricAndProgramme(String nric,
		String programme) throws SystemException {
		return findByNricAndProgramme(nric, programme, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programme results where nric = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @return the range of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByNricAndProgramme(String nric,
		String programme, int start, int end) throws SystemException {
		return findByNricAndProgramme(nric, programme, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programme results where nric = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByNricAndProgramme(String nric,
		String programme, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME;
			finderArgs = new Object[] { nric, programme };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NRICANDPROGRAMME;
			finderArgs = new Object[] {
					nric, programme,
					
					start, end, orderByComparator
				};
		}

		List<SPStudentProgrammeResult> list = (List<SPStudentProgrammeResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPStudentProgrammeResult spStudentProgrammeResult : list) {
				if (!Validator.equals(nric, spStudentProgrammeResult.getNric()) ||
						!Validator.equals(programme,
							spStudentProgrammeResult.getProgramme())) {
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

			query.append(_SQL_SELECT_SPSTUDENTPROGRAMMERESULT_WHERE);

			boolean bindNric = false;

			if (nric == null) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_1);
			}
			else if (nric.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_3);
			}
			else {
				bindNric = true;

				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_2);
			}

			boolean bindProgramme = false;

			if (programme == null) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_1);
			}
			else if (programme.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_3);
			}
			else {
				bindProgramme = true;

				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPStudentProgrammeResultModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNric) {
					qPos.add(nric);
				}

				if (bindProgramme) {
					qPos.add(programme);
				}

				if (!pagination) {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgrammeResult>(list);
				}
				else {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
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
	 * Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByNricAndProgramme_First(String nric,
		String programme, OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = fetchByNricAndProgramme_First(nric,
				programme, orderByComparator);

		if (spStudentProgrammeResult != null) {
			return spStudentProgrammeResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nric=");
		msg.append(nric);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeResultException(msg.toString());
	}

	/**
	 * Returns the first s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByNricAndProgramme_First(String nric,
		String programme, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPStudentProgrammeResult> list = findByNricAndProgramme(nric,
				programme, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByNricAndProgramme_Last(String nric,
		String programme, OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = fetchByNricAndProgramme_Last(nric,
				programme, orderByComparator);

		if (spStudentProgrammeResult != null) {
			return spStudentProgrammeResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nric=");
		msg.append(nric);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeResultException(msg.toString());
	}

	/**
	 * Returns the last s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByNricAndProgramme_Last(String nric,
		String programme, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNricAndProgramme(nric, programme);

		if (count == 0) {
			return null;
		}

		List<SPStudentProgrammeResult> list = findByNricAndProgramme(nric,
				programme, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p student programme results before and after the current s p student programme result in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param spStudentProgrammeResultId the primary key of the current s p student programme result
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult[] findByNricAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, String nric, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = findByPrimaryKey(spStudentProgrammeResultId);

		Session session = null;

		try {
			session = openSession();

			SPStudentProgrammeResult[] array = new SPStudentProgrammeResultImpl[3];

			array[0] = getByNricAndProgramme_PrevAndNext(session,
					spStudentProgrammeResult, nric, programme,
					orderByComparator, true);

			array[1] = spStudentProgrammeResult;

			array[2] = getByNricAndProgramme_PrevAndNext(session,
					spStudentProgrammeResult, nric, programme,
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

	protected SPStudentProgrammeResult getByNricAndProgramme_PrevAndNext(
		Session session, SPStudentProgrammeResult spStudentProgrammeResult,
		String nric, String programme, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSTUDENTPROGRAMMERESULT_WHERE);

		boolean bindNric = false;

		if (nric == null) {
			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_1);
		}
		else if (nric.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_3);
		}
		else {
			bindNric = true;

			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_2);
		}

		boolean bindProgramme = false;

		if (programme == null) {
			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_1);
		}
		else if (programme.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_3);
		}
		else {
			bindProgramme = true;

			query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_2);
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
			query.append(SPStudentProgrammeResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindNric) {
			qPos.add(nric);
		}

		if (bindProgramme) {
			qPos.add(programme);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spStudentProgrammeResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPStudentProgrammeResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p student programme results where nric = &#63; and programme = &#63; from the database.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNricAndProgramme(String nric, String programme)
		throws SystemException {
		for (SPStudentProgrammeResult spStudentProgrammeResult : findByNricAndProgramme(
				nric, programme, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spStudentProgrammeResult);
		}
	}

	/**
	 * Returns the number of s p student programme results where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @return the number of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNricAndProgramme(String nric, String programme)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NRICANDPROGRAMME;

		Object[] finderArgs = new Object[] { nric, programme };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSTUDENTPROGRAMMERESULT_WHERE);

			boolean bindNric = false;

			if (nric == null) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_1);
			}
			else if (nric.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_3);
			}
			else {
				bindNric = true;

				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_NRIC_2);
			}

			boolean bindProgramme = false;

			if (programme == null) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_1);
			}
			else if (programme.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_3);
			}
			else {
				bindProgramme = true;

				query.append(_FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindNric) {
					qPos.add(nric);
				}

				if (bindProgramme) {
					qPos.add(programme);
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

	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_1 = "spStudentProgrammeResult.nric IS NULL AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_2 = "spStudentProgrammeResult.nric = ? AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_3 = "(spStudentProgrammeResult.nric IS NULL OR spStudentProgrammeResult.nric = '') AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_1 = "spStudentProgrammeResult.programme IS NULL";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_2 = "spStudentProgrammeResult.programme = ?";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_3 = "(spStudentProgrammeResult.programme IS NULL OR spStudentProgrammeResult.programme = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmailAddressAndProgramme",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmailAddressAndProgramme",
			new String[] { String.class.getName(), String.class.getName() },
			SPStudentProgrammeResultModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPStudentProgrammeResultModelImpl.PROGRAMME_COLUMN_BITMASK |
			SPStudentProgrammeResultModelImpl.EXAM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAddressAndProgramme",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @return the matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		String emailAddress, String programme) throws SystemException {
		return findByEmailAddressAndProgramme(emailAddress, programme,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @return the range of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		String emailAddress, String programme, int start, int end)
		throws SystemException {
		return findByEmailAddressAndProgramme(emailAddress, programme, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programme results where emailAddress = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findByEmailAddressAndProgramme(
		String emailAddress, String programme, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME;
			finderArgs = new Object[] { emailAddress, programme };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME;
			finderArgs = new Object[] {
					emailAddress, programme,
					
					start, end, orderByComparator
				};
		}

		List<SPStudentProgrammeResult> list = (List<SPStudentProgrammeResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPStudentProgrammeResult spStudentProgrammeResult : list) {
				if (!Validator.equals(emailAddress,
							spStudentProgrammeResult.getEmailAddress()) ||
						!Validator.equals(programme,
							spStudentProgrammeResult.getProgramme())) {
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

			query.append(_SQL_SELECT_SPSTUDENTPROGRAMMERESULT_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_2);
			}

			boolean bindProgramme = false;

			if (programme == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_1);
			}
			else if (programme.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_3);
			}
			else {
				bindProgramme = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPStudentProgrammeResultModelImpl.ORDER_BY_JPQL);
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

				if (bindProgramme) {
					qPos.add(programme);
				}

				if (!pagination) {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgrammeResult>(list);
				}
				else {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
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
	 * Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByEmailAddressAndProgramme_First(
		String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = fetchByEmailAddressAndProgramme_First(emailAddress,
				programme, orderByComparator);

		if (spStudentProgrammeResult != null) {
			return spStudentProgrammeResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeResultException(msg.toString());
	}

	/**
	 * Returns the first s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByEmailAddressAndProgramme_First(
		String emailAddress, String programme,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPStudentProgrammeResult> list = findByEmailAddressAndProgramme(emailAddress,
				programme, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByEmailAddressAndProgramme_Last(
		String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = fetchByEmailAddressAndProgramme_Last(emailAddress,
				programme, orderByComparator);

		if (spStudentProgrammeResult != null) {
			return spStudentProgrammeResult;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeResultException(msg.toString());
	}

	/**
	 * Returns the last s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme result, or <code>null</code> if a matching s p student programme result could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByEmailAddressAndProgramme_Last(
		String emailAddress, String programme,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmailAddressAndProgramme(emailAddress, programme);

		if (count == 0) {
			return null;
		}

		List<SPStudentProgrammeResult> list = findByEmailAddressAndProgramme(emailAddress,
				programme, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p student programme results before and after the current s p student programme result in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param spStudentProgrammeResultId the primary key of the current s p student programme result
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult[] findByEmailAddressAndProgramme_PrevAndNext(
		long spStudentProgrammeResultId, String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = findByPrimaryKey(spStudentProgrammeResultId);

		Session session = null;

		try {
			session = openSession();

			SPStudentProgrammeResult[] array = new SPStudentProgrammeResultImpl[3];

			array[0] = getByEmailAddressAndProgramme_PrevAndNext(session,
					spStudentProgrammeResult, emailAddress, programme,
					orderByComparator, true);

			array[1] = spStudentProgrammeResult;

			array[2] = getByEmailAddressAndProgramme_PrevAndNext(session,
					spStudentProgrammeResult, emailAddress, programme,
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

	protected SPStudentProgrammeResult getByEmailAddressAndProgramme_PrevAndNext(
		Session session, SPStudentProgrammeResult spStudentProgrammeResult,
		String emailAddress, String programme,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSTUDENTPROGRAMMERESULT_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_2);
		}

		boolean bindProgramme = false;

		if (programme == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_1);
		}
		else if (programme.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_3);
		}
		else {
			bindProgramme = true;

			query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_2);
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
			query.append(SPStudentProgrammeResultModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (bindProgramme) {
			qPos.add(programme);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spStudentProgrammeResult);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPStudentProgrammeResult> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p student programme results where emailAddress = &#63; and programme = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailAddressAndProgramme(String emailAddress,
		String programme) throws SystemException {
		for (SPStudentProgrammeResult spStudentProgrammeResult : findByEmailAddressAndProgramme(
				emailAddress, programme, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spStudentProgrammeResult);
		}
	}

	/**
	 * Returns the number of s p student programme results where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @return the number of matching s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddressAndProgramme(String emailAddress,
		String programme) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME;

		Object[] finderArgs = new Object[] { emailAddress, programme };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPSTUDENTPROGRAMMERESULT_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_2);
			}

			boolean bindProgramme = false;

			if (programme == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_1);
			}
			else if (programme.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_3);
			}
			else {
				bindProgramme = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_2);
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

				if (bindProgramme) {
					qPos.add(programme);
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

	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_1 =
		"spStudentProgrammeResult.emailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_2 =
		"spStudentProgrammeResult.emailAddress = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_3 =
		"(spStudentProgrammeResult.emailAddress IS NULL OR spStudentProgrammeResult.emailAddress = '') AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_1 =
		"spStudentProgrammeResult.programme IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_2 =
		"spStudentProgrammeResult.programme = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_3 =
		"(spStudentProgrammeResult.programme IS NULL OR spStudentProgrammeResult.programme = '')";

	public SPStudentProgrammeResultPersistenceImpl() {
		setModelClass(SPStudentProgrammeResult.class);
	}

	/**
	 * Caches the s p student programme result in the entity cache if it is enabled.
	 *
	 * @param spStudentProgrammeResult the s p student programme result
	 */
	@Override
	public void cacheResult(SPStudentProgrammeResult spStudentProgrammeResult) {
		EntityCacheUtil.putResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			spStudentProgrammeResult.getPrimaryKey(), spStudentProgrammeResult);

		spStudentProgrammeResult.resetOriginalValues();
	}

	/**
	 * Caches the s p student programme results in the entity cache if it is enabled.
	 *
	 * @param spStudentProgrammeResults the s p student programme results
	 */
	@Override
	public void cacheResult(
		List<SPStudentProgrammeResult> spStudentProgrammeResults) {
		for (SPStudentProgrammeResult spStudentProgrammeResult : spStudentProgrammeResults) {
			if (EntityCacheUtil.getResult(
						SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
						SPStudentProgrammeResultImpl.class,
						spStudentProgrammeResult.getPrimaryKey()) == null) {
				cacheResult(spStudentProgrammeResult);
			}
			else {
				spStudentProgrammeResult.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p student programme results.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPStudentProgrammeResultImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPStudentProgrammeResultImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p student programme result.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPStudentProgrammeResult spStudentProgrammeResult) {
		EntityCacheUtil.removeResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			spStudentProgrammeResult.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SPStudentProgrammeResult> spStudentProgrammeResults) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPStudentProgrammeResult spStudentProgrammeResult : spStudentProgrammeResults) {
			EntityCacheUtil.removeResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
				SPStudentProgrammeResultImpl.class,
				spStudentProgrammeResult.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p student programme result with the primary key. Does not add the s p student programme result to the database.
	 *
	 * @param spStudentProgrammeResultId the primary key for the new s p student programme result
	 * @return the new s p student programme result
	 */
	@Override
	public SPStudentProgrammeResult create(long spStudentProgrammeResultId) {
		SPStudentProgrammeResult spStudentProgrammeResult = new SPStudentProgrammeResultImpl();

		spStudentProgrammeResult.setNew(true);
		spStudentProgrammeResult.setPrimaryKey(spStudentProgrammeResultId);

		return spStudentProgrammeResult;
	}

	/**
	 * Removes the s p student programme result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spStudentProgrammeResultId the primary key of the s p student programme result
	 * @return the s p student programme result that was removed
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult remove(long spStudentProgrammeResultId)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		return remove((Serializable)spStudentProgrammeResultId);
	}

	/**
	 * Removes the s p student programme result with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p student programme result
	 * @return the s p student programme result that was removed
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult remove(Serializable primaryKey)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPStudentProgrammeResult spStudentProgrammeResult = (SPStudentProgrammeResult)session.get(SPStudentProgrammeResultImpl.class,
					primaryKey);

			if (spStudentProgrammeResult == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPStudentProgrammeResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spStudentProgrammeResult);
		}
		catch (NoSuchSPStudentProgrammeResultException nsee) {
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
	protected SPStudentProgrammeResult removeImpl(
		SPStudentProgrammeResult spStudentProgrammeResult)
		throws SystemException {
		spStudentProgrammeResult = toUnwrappedModel(spStudentProgrammeResult);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spStudentProgrammeResult)) {
				spStudentProgrammeResult = (SPStudentProgrammeResult)session.get(SPStudentProgrammeResultImpl.class,
						spStudentProgrammeResult.getPrimaryKeyObj());
			}

			if (spStudentProgrammeResult != null) {
				session.delete(spStudentProgrammeResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spStudentProgrammeResult != null) {
			clearCache(spStudentProgrammeResult);
		}

		return spStudentProgrammeResult;
	}

	@Override
	public SPStudentProgrammeResult updateImpl(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws SystemException {
		spStudentProgrammeResult = toUnwrappedModel(spStudentProgrammeResult);

		boolean isNew = spStudentProgrammeResult.isNew();

		SPStudentProgrammeResultModelImpl spStudentProgrammeResultModelImpl = (SPStudentProgrammeResultModelImpl)spStudentProgrammeResult;

		Session session = null;

		try {
			session = openSession();

			if (spStudentProgrammeResult.isNew()) {
				session.save(spStudentProgrammeResult);

				spStudentProgrammeResult.setNew(false);
			}
			else {
				session.merge(spStudentProgrammeResult);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPStudentProgrammeResultModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spStudentProgrammeResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spStudentProgrammeResultModelImpl.getOriginalNric(),
						spStudentProgrammeResultModelImpl.getOriginalProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NRICANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME,
					args);

				args = new Object[] {
						spStudentProgrammeResultModelImpl.getNric(),
						spStudentProgrammeResultModelImpl.getProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NRICANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME,
					args);
			}

			if ((spStudentProgrammeResultModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spStudentProgrammeResultModelImpl.getOriginalEmailAddress(),
						spStudentProgrammeResultModelImpl.getOriginalProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME,
					args);

				args = new Object[] {
						spStudentProgrammeResultModelImpl.getEmailAddress(),
						spStudentProgrammeResultModelImpl.getProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME,
					args);
			}
		}

		EntityCacheUtil.putResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeResultImpl.class,
			spStudentProgrammeResult.getPrimaryKey(), spStudentProgrammeResult);

		return spStudentProgrammeResult;
	}

	protected SPStudentProgrammeResult toUnwrappedModel(
		SPStudentProgrammeResult spStudentProgrammeResult) {
		if (spStudentProgrammeResult instanceof SPStudentProgrammeResultImpl) {
			return spStudentProgrammeResult;
		}

		SPStudentProgrammeResultImpl spStudentProgrammeResultImpl = new SPStudentProgrammeResultImpl();

		spStudentProgrammeResultImpl.setNew(spStudentProgrammeResult.isNew());
		spStudentProgrammeResultImpl.setPrimaryKey(spStudentProgrammeResult.getPrimaryKey());

		spStudentProgrammeResultImpl.setSpStudentProgrammeResultId(spStudentProgrammeResult.getSpStudentProgrammeResultId());
		spStudentProgrammeResultImpl.setCompanyId(spStudentProgrammeResult.getCompanyId());
		spStudentProgrammeResultImpl.setUserId(spStudentProgrammeResult.getUserId());
		spStudentProgrammeResultImpl.setUserName(spStudentProgrammeResult.getUserName());
		spStudentProgrammeResultImpl.setCreateDate(spStudentProgrammeResult.getCreateDate());
		spStudentProgrammeResultImpl.setModifiedDate(spStudentProgrammeResult.getModifiedDate());
		spStudentProgrammeResultImpl.setNric(spStudentProgrammeResult.getNric());
		spStudentProgrammeResultImpl.setEmailAddress(spStudentProgrammeResult.getEmailAddress());
		spStudentProgrammeResultImpl.setCourseCentre(spStudentProgrammeResult.getCourseCentre());
		spStudentProgrammeResultImpl.setCourseStartDate(spStudentProgrammeResult.getCourseStartDate());
		spStudentProgrammeResultImpl.setCourseEndDate(spStudentProgrammeResult.getCourseEndDate());
		spStudentProgrammeResultImpl.setProgramme(spStudentProgrammeResult.getProgramme());
		spStudentProgrammeResultImpl.setExam(spStudentProgrammeResult.getExam());
		spStudentProgrammeResultImpl.setExamType(spStudentProgrammeResult.getExamType());
		spStudentProgrammeResultImpl.setPaper1Result(spStudentProgrammeResult.getPaper1Result());
		spStudentProgrammeResultImpl.setPaper2Result(spStudentProgrammeResult.getPaper2Result());
		spStudentProgrammeResultImpl.setOverallResult(spStudentProgrammeResult.getOverallResult());

		return spStudentProgrammeResultImpl;
	}

	/**
	 * Returns the s p student programme result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p student programme result
	 * @return the s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = fetchByPrimaryKey(primaryKey);

		if (spStudentProgrammeResult == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPStudentProgrammeResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spStudentProgrammeResult;
	}

	/**
	 * Returns the s p student programme result with the primary key or throws a {@link com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException} if it could not be found.
	 *
	 * @param spStudentProgrammeResultId the primary key of the s p student programme result
	 * @return the s p student programme result
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeResultException if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult findByPrimaryKey(
		long spStudentProgrammeResultId)
		throws NoSuchSPStudentProgrammeResultException, SystemException {
		return findByPrimaryKey((Serializable)spStudentProgrammeResultId);
	}

	/**
	 * Returns the s p student programme result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p student programme result
	 * @return the s p student programme result, or <code>null</code> if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPStudentProgrammeResult spStudentProgrammeResult = (SPStudentProgrammeResult)EntityCacheUtil.getResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
				SPStudentProgrammeResultImpl.class, primaryKey);

		if (spStudentProgrammeResult == _nullSPStudentProgrammeResult) {
			return null;
		}

		if (spStudentProgrammeResult == null) {
			Session session = null;

			try {
				session = openSession();

				spStudentProgrammeResult = (SPStudentProgrammeResult)session.get(SPStudentProgrammeResultImpl.class,
						primaryKey);

				if (spStudentProgrammeResult != null) {
					cacheResult(spStudentProgrammeResult);
				}
				else {
					EntityCacheUtil.putResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
						SPStudentProgrammeResultImpl.class, primaryKey,
						_nullSPStudentProgrammeResult);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPStudentProgrammeResultModelImpl.ENTITY_CACHE_ENABLED,
					SPStudentProgrammeResultImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spStudentProgrammeResult;
	}

	/**
	 * Returns the s p student programme result with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spStudentProgrammeResultId the primary key of the s p student programme result
	 * @return the s p student programme result, or <code>null</code> if a s p student programme result with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgrammeResult fetchByPrimaryKey(
		long spStudentProgrammeResultId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spStudentProgrammeResultId);
	}

	/**
	 * Returns all the s p student programme results.
	 *
	 * @return the s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programme results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @return the range of s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programme results.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p student programme results
	 * @param end the upper bound of the range of s p student programme results (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p student programme results
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgrammeResult> findAll(int start, int end,
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

		List<SPStudentProgrammeResult> list = (List<SPStudentProgrammeResult>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSTUDENTPROGRAMMERESULT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSTUDENTPROGRAMMERESULT;

				if (pagination) {
					sql = sql.concat(SPStudentProgrammeResultModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgrammeResult>(list);
				}
				else {
					list = (List<SPStudentProgrammeResult>)QueryUtil.list(q,
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
	 * Removes all the s p student programme results from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPStudentProgrammeResult spStudentProgrammeResult : findAll()) {
			remove(spStudentProgrammeResult);
		}
	}

	/**
	 * Returns the number of s p student programme results.
	 *
	 * @return the number of s p student programme results
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

				Query q = session.createQuery(_SQL_COUNT_SPSTUDENTPROGRAMMERESULT);

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
	 * Initializes the s p student programme result persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPStudentProgrammeResult>> listenersList = new ArrayList<ModelListener<SPStudentProgrammeResult>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPStudentProgrammeResult>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPStudentProgrammeResultImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSTUDENTPROGRAMMERESULT = "SELECT spStudentProgrammeResult FROM SPStudentProgrammeResult spStudentProgrammeResult";
	private static final String _SQL_SELECT_SPSTUDENTPROGRAMMERESULT_WHERE = "SELECT spStudentProgrammeResult FROM SPStudentProgrammeResult spStudentProgrammeResult WHERE ";
	private static final String _SQL_COUNT_SPSTUDENTPROGRAMMERESULT = "SELECT COUNT(spStudentProgrammeResult) FROM SPStudentProgrammeResult spStudentProgrammeResult";
	private static final String _SQL_COUNT_SPSTUDENTPROGRAMMERESULT_WHERE = "SELECT COUNT(spStudentProgrammeResult) FROM SPStudentProgrammeResult spStudentProgrammeResult WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spStudentProgrammeResult.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPStudentProgrammeResult exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPStudentProgrammeResult exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPStudentProgrammeResultPersistenceImpl.class);
	private static SPStudentProgrammeResult _nullSPStudentProgrammeResult = new SPStudentProgrammeResultImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPStudentProgrammeResult> toCacheModel() {
				return _nullSPStudentProgrammeResultCacheModel;
			}
		};

	private static CacheModel<SPStudentProgrammeResult> _nullSPStudentProgrammeResultCacheModel =
		new CacheModel<SPStudentProgrammeResult>() {
			@Override
			public SPStudentProgrammeResult toEntityModel() {
				return _nullSPStudentProgrammeResult;
			}
		};
}