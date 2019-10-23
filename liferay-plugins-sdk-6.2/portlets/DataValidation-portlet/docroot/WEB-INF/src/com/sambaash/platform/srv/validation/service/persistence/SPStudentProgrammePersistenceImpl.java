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

import com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException;
import com.sambaash.platform.srv.validation.model.SPStudentProgramme;
import com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeImpl;
import com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p student programme service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammePersistence
 * @see SPStudentProgrammeUtil
 * @generated
 */
public class SPStudentProgrammePersistenceImpl extends BasePersistenceImpl<SPStudentProgramme>
	implements SPStudentProgrammePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPStudentProgrammeUtil} to access the s p student programme persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPStudentProgrammeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NRICANDPROGRAMME =
		new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNricAndProgramme",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME =
		new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNricAndProgramme",
			new String[] { String.class.getName(), String.class.getName() },
			SPStudentProgrammeModelImpl.NRIC_COLUMN_BITMASK |
			SPStudentProgrammeModelImpl.PROGRAMME_COLUMN_BITMASK |
			SPStudentProgrammeModelImpl.COURSEENDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NRICANDPROGRAMME = new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNricAndProgramme",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p student programmes where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @return the matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByNricAndProgramme(String nric,
		String programme) throws SystemException {
		return findByNricAndProgramme(nric, programme, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programmes where nric = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @return the range of matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByNricAndProgramme(String nric,
		String programme, int start, int end) throws SystemException {
		return findByNricAndProgramme(nric, programme, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programmes where nric = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByNricAndProgramme(String nric,
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

		List<SPStudentProgramme> list = (List<SPStudentProgramme>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPStudentProgramme spStudentProgramme : list) {
				if (!Validator.equals(nric, spStudentProgramme.getNric()) ||
						!Validator.equals(programme,
							spStudentProgramme.getProgramme())) {
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

			query.append(_SQL_SELECT_SPSTUDENTPROGRAMME_WHERE);

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
				query.append(SPStudentProgrammeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgramme>(list);
				}
				else {
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
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
	 * Returns the first s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByNricAndProgramme_First(String nric,
		String programme, OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = fetchByNricAndProgramme_First(nric,
				programme, orderByComparator);

		if (spStudentProgramme != null) {
			return spStudentProgramme;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nric=");
		msg.append(nric);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeException(msg.toString());
	}

	/**
	 * Returns the first s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByNricAndProgramme_First(String nric,
		String programme, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPStudentProgramme> list = findByNricAndProgramme(nric, programme,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByNricAndProgramme_Last(String nric,
		String programme, OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = fetchByNricAndProgramme_Last(nric,
				programme, orderByComparator);

		if (spStudentProgramme != null) {
			return spStudentProgramme;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("nric=");
		msg.append(nric);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeException(msg.toString());
	}

	/**
	 * Returns the last s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByNricAndProgramme_Last(String nric,
		String programme, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNricAndProgramme(nric, programme);

		if (count == 0) {
			return null;
		}

		List<SPStudentProgramme> list = findByNricAndProgramme(nric, programme,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p student programmes before and after the current s p student programme in the ordered set where nric = &#63; and programme = &#63;.
	 *
	 * @param spStudentCourseId the primary key of the current s p student programme
	 * @param nric the nric
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme[] findByNricAndProgramme_PrevAndNext(
		long spStudentCourseId, String nric, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = findByPrimaryKey(spStudentCourseId);

		Session session = null;

		try {
			session = openSession();

			SPStudentProgramme[] array = new SPStudentProgrammeImpl[3];

			array[0] = getByNricAndProgramme_PrevAndNext(session,
					spStudentProgramme, nric, programme, orderByComparator, true);

			array[1] = spStudentProgramme;

			array[2] = getByNricAndProgramme_PrevAndNext(session,
					spStudentProgramme, nric, programme, orderByComparator,
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

	protected SPStudentProgramme getByNricAndProgramme_PrevAndNext(
		Session session, SPStudentProgramme spStudentProgramme, String nric,
		String programme, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPSTUDENTPROGRAMME_WHERE);

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
			query.append(SPStudentProgrammeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spStudentProgramme);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPStudentProgramme> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p student programmes where nric = &#63; and programme = &#63; from the database.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNricAndProgramme(String nric, String programme)
		throws SystemException {
		for (SPStudentProgramme spStudentProgramme : findByNricAndProgramme(
				nric, programme, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spStudentProgramme);
		}
	}

	/**
	 * Returns the number of s p student programmes where nric = &#63; and programme = &#63;.
	 *
	 * @param nric the nric
	 * @param programme the programme
	 * @return the number of matching s p student programmes
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

			query.append(_SQL_COUNT_SPSTUDENTPROGRAMME_WHERE);

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

	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_1 = "spStudentProgramme.nric IS NULL AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_2 = "spStudentProgramme.nric = ? AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_NRIC_3 = "(spStudentProgramme.nric IS NULL OR spStudentProgramme.nric = '') AND ";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_1 = "spStudentProgramme.programme IS NULL";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_2 = "spStudentProgramme.programme = ?";
	private static final String _FINDER_COLUMN_NRICANDPROGRAMME_PROGRAMME_3 = "(spStudentProgramme.programme IS NULL OR spStudentProgramme.programme = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmailAddressAndProgramme",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED,
			SPStudentProgrammeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmailAddressAndProgramme",
			new String[] { String.class.getName(), String.class.getName() },
			SPStudentProgrammeModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPStudentProgrammeModelImpl.PROGRAMME_COLUMN_BITMASK |
			SPStudentProgrammeModelImpl.COURSEENDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME =
		new FinderPath(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAddressAndProgramme",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @return the matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByEmailAddressAndProgramme(
		String emailAddress, String programme) throws SystemException {
		return findByEmailAddressAndProgramme(emailAddress, programme,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @return the range of matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByEmailAddressAndProgramme(
		String emailAddress, String programme, int start, int end)
		throws SystemException {
		return findByEmailAddressAndProgramme(emailAddress, programme, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programmes where emailAddress = &#63; and programme = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findByEmailAddressAndProgramme(
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

		List<SPStudentProgramme> list = (List<SPStudentProgramme>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPStudentProgramme spStudentProgramme : list) {
				if (!Validator.equals(emailAddress,
							spStudentProgramme.getEmailAddress()) ||
						!Validator.equals(programme,
							spStudentProgramme.getProgramme())) {
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

			query.append(_SQL_SELECT_SPSTUDENTPROGRAMME_WHERE);

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
				query.append(SPStudentProgrammeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgramme>(list);
				}
				else {
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
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
	 * Returns the first s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByEmailAddressAndProgramme_First(
		String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = fetchByEmailAddressAndProgramme_First(emailAddress,
				programme, orderByComparator);

		if (spStudentProgramme != null) {
			return spStudentProgramme;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeException(msg.toString());
	}

	/**
	 * Returns the first s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByEmailAddressAndProgramme_First(
		String emailAddress, String programme,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPStudentProgramme> list = findByEmailAddressAndProgramme(emailAddress,
				programme, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByEmailAddressAndProgramme_Last(
		String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = fetchByEmailAddressAndProgramme_Last(emailAddress,
				programme, orderByComparator);

		if (spStudentProgramme != null) {
			return spStudentProgramme;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(", programme=");
		msg.append(programme);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPStudentProgrammeException(msg.toString());
	}

	/**
	 * Returns the last s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p student programme, or <code>null</code> if a matching s p student programme could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByEmailAddressAndProgramme_Last(
		String emailAddress, String programme,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmailAddressAndProgramme(emailAddress, programme);

		if (count == 0) {
			return null;
		}

		List<SPStudentProgramme> list = findByEmailAddressAndProgramme(emailAddress,
				programme, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p student programmes before and after the current s p student programme in the ordered set where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param spStudentCourseId the primary key of the current s p student programme
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme[] findByEmailAddressAndProgramme_PrevAndNext(
		long spStudentCourseId, String emailAddress, String programme,
		OrderByComparator orderByComparator)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = findByPrimaryKey(spStudentCourseId);

		Session session = null;

		try {
			session = openSession();

			SPStudentProgramme[] array = new SPStudentProgrammeImpl[3];

			array[0] = getByEmailAddressAndProgramme_PrevAndNext(session,
					spStudentProgramme, emailAddress, programme,
					orderByComparator, true);

			array[1] = spStudentProgramme;

			array[2] = getByEmailAddressAndProgramme_PrevAndNext(session,
					spStudentProgramme, emailAddress, programme,
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

	protected SPStudentProgramme getByEmailAddressAndProgramme_PrevAndNext(
		Session session, SPStudentProgramme spStudentProgramme,
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

		query.append(_SQL_SELECT_SPSTUDENTPROGRAMME_WHERE);

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
			query.append(SPStudentProgrammeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spStudentProgramme);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPStudentProgramme> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p student programmes where emailAddress = &#63; and programme = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailAddressAndProgramme(String emailAddress,
		String programme) throws SystemException {
		for (SPStudentProgramme spStudentProgramme : findByEmailAddressAndProgramme(
				emailAddress, programme, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(spStudentProgramme);
		}
	}

	/**
	 * Returns the number of s p student programmes where emailAddress = &#63; and programme = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param programme the programme
	 * @return the number of matching s p student programmes
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

			query.append(_SQL_COUNT_SPSTUDENTPROGRAMME_WHERE);

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
		"spStudentProgramme.emailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_2 =
		"spStudentProgramme.emailAddress = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_EMAILADDRESS_3 =
		"(spStudentProgramme.emailAddress IS NULL OR spStudentProgramme.emailAddress = '') AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_1 =
		"spStudentProgramme.programme IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_2 =
		"spStudentProgramme.programme = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDPROGRAMME_PROGRAMME_3 =
		"(spStudentProgramme.programme IS NULL OR spStudentProgramme.programme = '')";

	public SPStudentProgrammePersistenceImpl() {
		setModelClass(SPStudentProgramme.class);
	}

	/**
	 * Caches the s p student programme in the entity cache if it is enabled.
	 *
	 * @param spStudentProgramme the s p student programme
	 */
	@Override
	public void cacheResult(SPStudentProgramme spStudentProgramme) {
		EntityCacheUtil.putResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeImpl.class, spStudentProgramme.getPrimaryKey(),
			spStudentProgramme);

		spStudentProgramme.resetOriginalValues();
	}

	/**
	 * Caches the s p student programmes in the entity cache if it is enabled.
	 *
	 * @param spStudentProgrammes the s p student programmes
	 */
	@Override
	public void cacheResult(List<SPStudentProgramme> spStudentProgrammes) {
		for (SPStudentProgramme spStudentProgramme : spStudentProgrammes) {
			if (EntityCacheUtil.getResult(
						SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
						SPStudentProgrammeImpl.class,
						spStudentProgramme.getPrimaryKey()) == null) {
				cacheResult(spStudentProgramme);
			}
			else {
				spStudentProgramme.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p student programmes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPStudentProgrammeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPStudentProgrammeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p student programme.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPStudentProgramme spStudentProgramme) {
		EntityCacheUtil.removeResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeImpl.class, spStudentProgramme.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPStudentProgramme> spStudentProgrammes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPStudentProgramme spStudentProgramme : spStudentProgrammes) {
			EntityCacheUtil.removeResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
				SPStudentProgrammeImpl.class, spStudentProgramme.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p student programme with the primary key. Does not add the s p student programme to the database.
	 *
	 * @param spStudentCourseId the primary key for the new s p student programme
	 * @return the new s p student programme
	 */
	@Override
	public SPStudentProgramme create(long spStudentCourseId) {
		SPStudentProgramme spStudentProgramme = new SPStudentProgrammeImpl();

		spStudentProgramme.setNew(true);
		spStudentProgramme.setPrimaryKey(spStudentCourseId);

		return spStudentProgramme;
	}

	/**
	 * Removes the s p student programme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spStudentCourseId the primary key of the s p student programme
	 * @return the s p student programme that was removed
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme remove(long spStudentCourseId)
		throws NoSuchSPStudentProgrammeException, SystemException {
		return remove((Serializable)spStudentCourseId);
	}

	/**
	 * Removes the s p student programme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p student programme
	 * @return the s p student programme that was removed
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme remove(Serializable primaryKey)
		throws NoSuchSPStudentProgrammeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPStudentProgramme spStudentProgramme = (SPStudentProgramme)session.get(SPStudentProgrammeImpl.class,
					primaryKey);

			if (spStudentProgramme == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPStudentProgrammeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spStudentProgramme);
		}
		catch (NoSuchSPStudentProgrammeException nsee) {
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
	protected SPStudentProgramme removeImpl(
		SPStudentProgramme spStudentProgramme) throws SystemException {
		spStudentProgramme = toUnwrappedModel(spStudentProgramme);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spStudentProgramme)) {
				spStudentProgramme = (SPStudentProgramme)session.get(SPStudentProgrammeImpl.class,
						spStudentProgramme.getPrimaryKeyObj());
			}

			if (spStudentProgramme != null) {
				session.delete(spStudentProgramme);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spStudentProgramme != null) {
			clearCache(spStudentProgramme);
		}

		return spStudentProgramme;
	}

	@Override
	public SPStudentProgramme updateImpl(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme)
		throws SystemException {
		spStudentProgramme = toUnwrappedModel(spStudentProgramme);

		boolean isNew = spStudentProgramme.isNew();

		SPStudentProgrammeModelImpl spStudentProgrammeModelImpl = (SPStudentProgrammeModelImpl)spStudentProgramme;

		Session session = null;

		try {
			session = openSession();

			if (spStudentProgramme.isNew()) {
				session.save(spStudentProgramme);

				spStudentProgramme.setNew(false);
			}
			else {
				session.merge(spStudentProgramme);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPStudentProgrammeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spStudentProgrammeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spStudentProgrammeModelImpl.getOriginalNric(),
						spStudentProgrammeModelImpl.getOriginalProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NRICANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME,
					args);

				args = new Object[] {
						spStudentProgrammeModelImpl.getNric(),
						spStudentProgrammeModelImpl.getProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NRICANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NRICANDPROGRAMME,
					args);
			}

			if ((spStudentProgrammeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spStudentProgrammeModelImpl.getOriginalEmailAddress(),
						spStudentProgrammeModelImpl.getOriginalProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME,
					args);

				args = new Object[] {
						spStudentProgrammeModelImpl.getEmailAddress(),
						spStudentProgrammeModelImpl.getProgramme()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDPROGRAMME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESSANDPROGRAMME,
					args);
			}
		}

		EntityCacheUtil.putResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
			SPStudentProgrammeImpl.class, spStudentProgramme.getPrimaryKey(),
			spStudentProgramme);

		return spStudentProgramme;
	}

	protected SPStudentProgramme toUnwrappedModel(
		SPStudentProgramme spStudentProgramme) {
		if (spStudentProgramme instanceof SPStudentProgrammeImpl) {
			return spStudentProgramme;
		}

		SPStudentProgrammeImpl spStudentProgrammeImpl = new SPStudentProgrammeImpl();

		spStudentProgrammeImpl.setNew(spStudentProgramme.isNew());
		spStudentProgrammeImpl.setPrimaryKey(spStudentProgramme.getPrimaryKey());

		spStudentProgrammeImpl.setSpStudentCourseId(spStudentProgramme.getSpStudentCourseId());
		spStudentProgrammeImpl.setCompanyId(spStudentProgramme.getCompanyId());
		spStudentProgrammeImpl.setUserId(spStudentProgramme.getUserId());
		spStudentProgrammeImpl.setUserName(spStudentProgramme.getUserName());
		spStudentProgrammeImpl.setCreateDate(spStudentProgramme.getCreateDate());
		spStudentProgrammeImpl.setModifiedDate(spStudentProgramme.getModifiedDate());
		spStudentProgrammeImpl.setNric(spStudentProgramme.getNric());
		spStudentProgrammeImpl.setEmailAddress(spStudentProgramme.getEmailAddress());
		spStudentProgrammeImpl.setProgramme(spStudentProgramme.getProgramme());
		spStudentProgrammeImpl.setCourseCentre(spStudentProgramme.getCourseCentre());
		spStudentProgrammeImpl.setCourseStartDate(spStudentProgramme.getCourseStartDate());
		spStudentProgrammeImpl.setCourseEndDate(spStudentProgramme.getCourseEndDate());

		return spStudentProgrammeImpl;
	}

	/**
	 * Returns the s p student programme with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p student programme
	 * @return the s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPStudentProgrammeException, SystemException {
		SPStudentProgramme spStudentProgramme = fetchByPrimaryKey(primaryKey);

		if (spStudentProgramme == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPStudentProgrammeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spStudentProgramme;
	}

	/**
	 * Returns the s p student programme with the primary key or throws a {@link com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException} if it could not be found.
	 *
	 * @param spStudentCourseId the primary key of the s p student programme
	 * @return the s p student programme
	 * @throws com.sambaash.platform.srv.validation.NoSuchSPStudentProgrammeException if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme findByPrimaryKey(long spStudentCourseId)
		throws NoSuchSPStudentProgrammeException, SystemException {
		return findByPrimaryKey((Serializable)spStudentCourseId);
	}

	/**
	 * Returns the s p student programme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p student programme
	 * @return the s p student programme, or <code>null</code> if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPStudentProgramme spStudentProgramme = (SPStudentProgramme)EntityCacheUtil.getResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
				SPStudentProgrammeImpl.class, primaryKey);

		if (spStudentProgramme == _nullSPStudentProgramme) {
			return null;
		}

		if (spStudentProgramme == null) {
			Session session = null;

			try {
				session = openSession();

				spStudentProgramme = (SPStudentProgramme)session.get(SPStudentProgrammeImpl.class,
						primaryKey);

				if (spStudentProgramme != null) {
					cacheResult(spStudentProgramme);
				}
				else {
					EntityCacheUtil.putResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
						SPStudentProgrammeImpl.class, primaryKey,
						_nullSPStudentProgramme);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPStudentProgrammeModelImpl.ENTITY_CACHE_ENABLED,
					SPStudentProgrammeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spStudentProgramme;
	}

	/**
	 * Returns the s p student programme with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spStudentCourseId the primary key of the s p student programme
	 * @return the s p student programme, or <code>null</code> if a s p student programme with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPStudentProgramme fetchByPrimaryKey(long spStudentCourseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spStudentCourseId);
	}

	/**
	 * Returns all the s p student programmes.
	 *
	 * @return the s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p student programmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @return the range of s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p student programmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p student programmes
	 * @param end the upper bound of the range of s p student programmes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p student programmes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPStudentProgramme> findAll(int start, int end,
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

		List<SPStudentProgramme> list = (List<SPStudentProgramme>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPSTUDENTPROGRAMME);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPSTUDENTPROGRAMME;

				if (pagination) {
					sql = sql.concat(SPStudentProgrammeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPStudentProgramme>(list);
				}
				else {
					list = (List<SPStudentProgramme>)QueryUtil.list(q,
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
	 * Removes all the s p student programmes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPStudentProgramme spStudentProgramme : findAll()) {
			remove(spStudentProgramme);
		}
	}

	/**
	 * Returns the number of s p student programmes.
	 *
	 * @return the number of s p student programmes
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

				Query q = session.createQuery(_SQL_COUNT_SPSTUDENTPROGRAMME);

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
	 * Initializes the s p student programme persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.validation.model.SPStudentProgramme")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPStudentProgramme>> listenersList = new ArrayList<ModelListener<SPStudentProgramme>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPStudentProgramme>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPStudentProgrammeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPSTUDENTPROGRAMME = "SELECT spStudentProgramme FROM SPStudentProgramme spStudentProgramme";
	private static final String _SQL_SELECT_SPSTUDENTPROGRAMME_WHERE = "SELECT spStudentProgramme FROM SPStudentProgramme spStudentProgramme WHERE ";
	private static final String _SQL_COUNT_SPSTUDENTPROGRAMME = "SELECT COUNT(spStudentProgramme) FROM SPStudentProgramme spStudentProgramme";
	private static final String _SQL_COUNT_SPSTUDENTPROGRAMME_WHERE = "SELECT COUNT(spStudentProgramme) FROM SPStudentProgramme spStudentProgramme WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spStudentProgramme.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPStudentProgramme exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPStudentProgramme exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPStudentProgrammePersistenceImpl.class);
	private static SPStudentProgramme _nullSPStudentProgramme = new SPStudentProgrammeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPStudentProgramme> toCacheModel() {
				return _nullSPStudentProgrammeCacheModel;
			}
		};

	private static CacheModel<SPStudentProgramme> _nullSPStudentProgrammeCacheModel =
		new CacheModel<SPStudentProgramme>() {
			@Override
			public SPStudentProgramme toEntityModel() {
				return _nullSPStudentProgramme;
			}
		};
}