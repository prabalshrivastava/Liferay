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

package com.sambaash.platform.srv.service.persistence;

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

import com.sambaash.platform.srv.NoSuchCourseEnrollContractException;
import com.sambaash.platform.srv.model.CourseEnrollContract;
import com.sambaash.platform.srv.model.impl.CourseEnrollContractImpl;
import com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course enroll contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseEnrollContractPersistence
 * @see CourseEnrollContractUtil
 * @generated
 */
public class CourseEnrollContractPersistenceImpl extends BasePersistenceImpl<CourseEnrollContract>
	implements CourseEnrollContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseEnrollContractUtil} to access the course enroll contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseEnrollContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE =
		new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycountryIdCourseType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE =
		new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycountryIdCourseType",
			new String[] { String.class.getName(), Long.class.getName() },
			CourseEnrollContractModelImpl.COUNTRYID_COLUMN_BITMASK |
			CourseEnrollContractModelImpl.COURSETYPE_COLUMN_BITMASK |
			CourseEnrollContractModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPE = new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycountryIdCourseType",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @return the matching course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findBycountryIdCourseType(
		String countryId, long courseType) throws SystemException {
		return findBycountryIdCourseType(countryId, courseType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param start the lower bound of the range of course enroll contracts
	 * @param end the upper bound of the range of course enroll contracts (not inclusive)
	 * @return the range of matching course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findBycountryIdCourseType(
		String countryId, long courseType, int start, int end)
		throws SystemException {
		return findBycountryIdCourseType(countryId, courseType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course enroll contracts where countryId = &#63; and courseType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param start the lower bound of the range of course enroll contracts
	 * @param end the upper bound of the range of course enroll contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findBycountryIdCourseType(
		String countryId, long courseType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE;
			finderArgs = new Object[] { countryId, courseType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE;
			finderArgs = new Object[] {
					countryId, courseType,
					
					start, end, orderByComparator
				};
		}

		List<CourseEnrollContract> list = (List<CourseEnrollContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseEnrollContract courseEnrollContract : list) {
				if (!Validator.equals(countryId,
							courseEnrollContract.getCountryId()) ||
						(courseType != courseEnrollContract.getCourseType())) {
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

			query.append(_SQL_SELECT_COURSEENROLLCONTRACT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_2);
			}

			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COURSETYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseEnrollContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				qPos.add(courseType);

				if (!pagination) {
					list = (List<CourseEnrollContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseEnrollContract>(list);
				}
				else {
					list = (List<CourseEnrollContract>)QueryUtil.list(q,
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
	 * Returns the first course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract findBycountryIdCourseType_First(
		String countryId, long courseType, OrderByComparator orderByComparator)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = fetchBycountryIdCourseType_First(countryId,
				courseType, orderByComparator);

		if (courseEnrollContract != null) {
			return courseEnrollContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", courseType=");
		msg.append(courseType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseEnrollContractException(msg.toString());
	}

	/**
	 * Returns the first course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchBycountryIdCourseType_First(
		String countryId, long courseType, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseEnrollContract> list = findBycountryIdCourseType(countryId,
				courseType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract findBycountryIdCourseType_Last(
		String countryId, long courseType, OrderByComparator orderByComparator)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = fetchBycountryIdCourseType_Last(countryId,
				courseType, orderByComparator);

		if (courseEnrollContract != null) {
			return courseEnrollContract;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", courseType=");
		msg.append(courseType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseEnrollContractException(msg.toString());
	}

	/**
	 * Returns the last course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchBycountryIdCourseType_Last(
		String countryId, long courseType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBycountryIdCourseType(countryId, courseType);

		if (count == 0) {
			return null;
		}

		List<CourseEnrollContract> list = findBycountryIdCourseType(countryId,
				courseType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course enroll contracts before and after the current course enroll contract in the ordered set where countryId = &#63; and courseType = &#63;.
	 *
	 * @param spCourseContractId the primary key of the current course enroll contract
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract[] findBycountryIdCourseType_PrevAndNext(
		long spCourseContractId, String countryId, long courseType,
		OrderByComparator orderByComparator)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = findByPrimaryKey(spCourseContractId);

		Session session = null;

		try {
			session = openSession();

			CourseEnrollContract[] array = new CourseEnrollContractImpl[3];

			array[0] = getBycountryIdCourseType_PrevAndNext(session,
					courseEnrollContract, countryId, courseType,
					orderByComparator, true);

			array[1] = courseEnrollContract;

			array[2] = getBycountryIdCourseType_PrevAndNext(session,
					courseEnrollContract, countryId, courseType,
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

	protected CourseEnrollContract getBycountryIdCourseType_PrevAndNext(
		Session session, CourseEnrollContract courseEnrollContract,
		String countryId, long courseType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSEENROLLCONTRACT_WHERE);

		boolean bindCountryId = false;

		if (countryId == null) {
			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_1);
		}
		else if (countryId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_3);
		}
		else {
			bindCountryId = true;

			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_2);
		}

		query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COURSETYPE_2);

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
			query.append(CourseEnrollContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCountryId) {
			qPos.add(countryId);
		}

		qPos.add(courseType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseEnrollContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseEnrollContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course enroll contracts where countryId = &#63; and courseType = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycountryIdCourseType(String countryId, long courseType)
		throws SystemException {
		for (CourseEnrollContract courseEnrollContract : findBycountryIdCourseType(
				countryId, courseType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(courseEnrollContract);
		}
	}

	/**
	 * Returns the number of course enroll contracts where countryId = &#63; and courseType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @return the number of matching course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycountryIdCourseType(String countryId, long courseType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPE;

		Object[] finderArgs = new Object[] { countryId, courseType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSEENROLLCONTRACT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_2);
			}

			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPE_COURSETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				qPos.add(courseType);

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

	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_1 = "courseEnrollContract.countryId IS NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_2 = "courseEnrollContract.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPE_COUNTRYID_3 = "(courseEnrollContract.countryId IS NULL OR courseEnrollContract.countryId = '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPE_COURSETYPE_2 = "courseEnrollContract.courseType = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE =
		new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED,
			CourseEnrollContractImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBycountryIdCourseTypeDocType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CourseEnrollContractModelImpl.COUNTRYID_COLUMN_BITMASK |
			CourseEnrollContractModelImpl.COURSETYPE_COLUMN_BITMASK |
			CourseEnrollContractModelImpl.DOCTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE =
		new FinderPath(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycountryIdCourseTypeDocType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollContractException} if it could not be found.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param docType the doc type
	 * @return the matching course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract findBycountryIdCourseTypeDocType(
		String countryId, long courseType, String docType)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = fetchBycountryIdCourseTypeDocType(countryId,
				courseType, docType);

		if (courseEnrollContract == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("countryId=");
			msg.append(countryId);

			msg.append(", courseType=");
			msg.append(courseType);

			msg.append(", docType=");
			msg.append(docType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCourseEnrollContractException(msg.toString());
		}

		return courseEnrollContract;
	}

	/**
	 * Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param docType the doc type
	 * @return the matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchBycountryIdCourseTypeDocType(
		String countryId, long courseType, String docType)
		throws SystemException {
		return fetchBycountryIdCourseTypeDocType(countryId, courseType,
			docType, true);
	}

	/**
	 * Returns the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param docType the doc type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course enroll contract, or <code>null</code> if a matching course enroll contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchBycountryIdCourseTypeDocType(
		String countryId, long courseType, String docType,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { countryId, courseType, docType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
					finderArgs, this);
		}

		if (result instanceof CourseEnrollContract) {
			CourseEnrollContract courseEnrollContract = (CourseEnrollContract)result;

			if (!Validator.equals(countryId, courseEnrollContract.getCountryId()) ||
					(courseType != courseEnrollContract.getCourseType()) ||
					!Validator.equals(docType, courseEnrollContract.getDocType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_COURSEENROLLCONTRACT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_2);
			}

			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COURSETYPE_2);

			boolean bindDocType = false;

			if (docType == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_1);
			}
			else if (docType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_3);
			}
			else {
				bindDocType = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				qPos.add(courseType);

				if (bindDocType) {
					qPos.add(docType);
				}

				List<CourseEnrollContract> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CourseEnrollContractPersistenceImpl.fetchBycountryIdCourseTypeDocType(String, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CourseEnrollContract courseEnrollContract = list.get(0);

					result = courseEnrollContract;

					cacheResult(courseEnrollContract);

					if ((courseEnrollContract.getCountryId() == null) ||
							!courseEnrollContract.getCountryId()
													 .equals(countryId) ||
							(courseEnrollContract.getCourseType() != courseType) ||
							(courseEnrollContract.getDocType() == null) ||
							!courseEnrollContract.getDocType().equals(docType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
							finderArgs, courseEnrollContract);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
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
			return (CourseEnrollContract)result;
		}
	}

	/**
	 * Removes the course enroll contract where countryId = &#63; and courseType = &#63; and docType = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param docType the doc type
	 * @return the course enroll contract that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract removeBycountryIdCourseTypeDocType(
		String countryId, long courseType, String docType)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = findBycountryIdCourseTypeDocType(countryId,
				courseType, docType);

		return remove(courseEnrollContract);
	}

	/**
	 * Returns the number of course enroll contracts where countryId = &#63; and courseType = &#63; and docType = &#63;.
	 *
	 * @param countryId the country ID
	 * @param courseType the course type
	 * @param docType the doc type
	 * @return the number of matching course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycountryIdCourseTypeDocType(String countryId,
		long courseType, String docType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE;

		Object[] finderArgs = new Object[] { countryId, courseType, docType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_COURSEENROLLCONTRACT_WHERE);

			boolean bindCountryId = false;

			if (countryId == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_1);
			}
			else if (countryId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_3);
			}
			else {
				bindCountryId = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_2);
			}

			query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COURSETYPE_2);

			boolean bindDocType = false;

			if (docType == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_1);
			}
			else if (docType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_3);
			}
			else {
				bindDocType = true;

				query.append(_FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCountryId) {
					qPos.add(countryId);
				}

				qPos.add(courseType);

				if (bindDocType) {
					qPos.add(docType);
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

	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_1 =
		"courseEnrollContract.countryId IS NULL AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_2 =
		"courseEnrollContract.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COUNTRYID_3 =
		"(courseEnrollContract.countryId IS NULL OR courseEnrollContract.countryId = '') AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_COURSETYPE_2 =
		"courseEnrollContract.courseType = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_1 =
		"courseEnrollContract.docType IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_2 =
		"courseEnrollContract.docType = ?";
	private static final String _FINDER_COLUMN_COUNTRYIDCOURSETYPEDOCTYPE_DOCTYPE_3 =
		"(courseEnrollContract.docType IS NULL OR courseEnrollContract.docType = '')";

	public CourseEnrollContractPersistenceImpl() {
		setModelClass(CourseEnrollContract.class);
	}

	/**
	 * Caches the course enroll contract in the entity cache if it is enabled.
	 *
	 * @param courseEnrollContract the course enroll contract
	 */
	@Override
	public void cacheResult(CourseEnrollContract courseEnrollContract) {
		EntityCacheUtil.putResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			courseEnrollContract.getPrimaryKey(), courseEnrollContract);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
			new Object[] {
				courseEnrollContract.getCountryId(),
				courseEnrollContract.getCourseType(),
				courseEnrollContract.getDocType()
			}, courseEnrollContract);

		courseEnrollContract.resetOriginalValues();
	}

	/**
	 * Caches the course enroll contracts in the entity cache if it is enabled.
	 *
	 * @param courseEnrollContracts the course enroll contracts
	 */
	@Override
	public void cacheResult(List<CourseEnrollContract> courseEnrollContracts) {
		for (CourseEnrollContract courseEnrollContract : courseEnrollContracts) {
			if (EntityCacheUtil.getResult(
						CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
						CourseEnrollContractImpl.class,
						courseEnrollContract.getPrimaryKey()) == null) {
				cacheResult(courseEnrollContract);
			}
			else {
				courseEnrollContract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course enroll contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseEnrollContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseEnrollContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course enroll contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseEnrollContract courseEnrollContract) {
		EntityCacheUtil.removeResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractImpl.class, courseEnrollContract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseEnrollContract);
	}

	@Override
	public void clearCache(List<CourseEnrollContract> courseEnrollContracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseEnrollContract courseEnrollContract : courseEnrollContracts) {
			EntityCacheUtil.removeResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
				CourseEnrollContractImpl.class,
				courseEnrollContract.getPrimaryKey());

			clearUniqueFindersCache(courseEnrollContract);
		}
	}

	protected void cacheUniqueFindersCache(
		CourseEnrollContract courseEnrollContract) {
		if (courseEnrollContract.isNew()) {
			Object[] args = new Object[] {
					courseEnrollContract.getCountryId(),
					courseEnrollContract.getCourseType(),
					courseEnrollContract.getDocType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
				args, courseEnrollContract);
		}
		else {
			CourseEnrollContractModelImpl courseEnrollContractModelImpl = (CourseEnrollContractModelImpl)courseEnrollContract;

			if ((courseEnrollContractModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseEnrollContract.getCountryId(),
						courseEnrollContract.getCourseType(),
						courseEnrollContract.getDocType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
					args, courseEnrollContract);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CourseEnrollContract courseEnrollContract) {
		CourseEnrollContractModelImpl courseEnrollContractModelImpl = (CourseEnrollContractModelImpl)courseEnrollContract;

		Object[] args = new Object[] {
				courseEnrollContract.getCountryId(),
				courseEnrollContract.getCourseType(),
				courseEnrollContract.getDocType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
			args);

		if ((courseEnrollContractModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					courseEnrollContractModelImpl.getOriginalCountryId(),
					courseEnrollContractModelImpl.getOriginalCourseType(),
					courseEnrollContractModelImpl.getOriginalDocType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPEDOCTYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COUNTRYIDCOURSETYPEDOCTYPE,
				args);
		}
	}

	/**
	 * Creates a new course enroll contract with the primary key. Does not add the course enroll contract to the database.
	 *
	 * @param spCourseContractId the primary key for the new course enroll contract
	 * @return the new course enroll contract
	 */
	@Override
	public CourseEnrollContract create(long spCourseContractId) {
		CourseEnrollContract courseEnrollContract = new CourseEnrollContractImpl();

		courseEnrollContract.setNew(true);
		courseEnrollContract.setPrimaryKey(spCourseContractId);

		return courseEnrollContract;
	}

	/**
	 * Removes the course enroll contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseContractId the primary key of the course enroll contract
	 * @return the course enroll contract that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract remove(long spCourseContractId)
		throws NoSuchCourseEnrollContractException, SystemException {
		return remove((Serializable)spCourseContractId);
	}

	/**
	 * Removes the course enroll contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course enroll contract
	 * @return the course enroll contract that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract remove(Serializable primaryKey)
		throws NoSuchCourseEnrollContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseEnrollContract courseEnrollContract = (CourseEnrollContract)session.get(CourseEnrollContractImpl.class,
					primaryKey);

			if (courseEnrollContract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseEnrollContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseEnrollContract);
		}
		catch (NoSuchCourseEnrollContractException nsee) {
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
	protected CourseEnrollContract removeImpl(
		CourseEnrollContract courseEnrollContract) throws SystemException {
		courseEnrollContract = toUnwrappedModel(courseEnrollContract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseEnrollContract)) {
				courseEnrollContract = (CourseEnrollContract)session.get(CourseEnrollContractImpl.class,
						courseEnrollContract.getPrimaryKeyObj());
			}

			if (courseEnrollContract != null) {
				session.delete(courseEnrollContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseEnrollContract != null) {
			clearCache(courseEnrollContract);
		}

		return courseEnrollContract;
	}

	@Override
	public CourseEnrollContract updateImpl(
		com.sambaash.platform.srv.model.CourseEnrollContract courseEnrollContract)
		throws SystemException {
		courseEnrollContract = toUnwrappedModel(courseEnrollContract);

		boolean isNew = courseEnrollContract.isNew();

		CourseEnrollContractModelImpl courseEnrollContractModelImpl = (CourseEnrollContractModelImpl)courseEnrollContract;

		Session session = null;

		try {
			session = openSession();

			if (courseEnrollContract.isNew()) {
				session.save(courseEnrollContract);

				courseEnrollContract.setNew(false);
			}
			else {
				session.merge(courseEnrollContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseEnrollContractModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseEnrollContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseEnrollContractModelImpl.getOriginalCountryId(),
						courseEnrollContractModelImpl.getOriginalCourseType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE,
					args);

				args = new Object[] {
						courseEnrollContractModelImpl.getCountryId(),
						courseEnrollContractModelImpl.getCourseType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDCOURSETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDCOURSETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
			CourseEnrollContractImpl.class,
			courseEnrollContract.getPrimaryKey(), courseEnrollContract);

		clearUniqueFindersCache(courseEnrollContract);
		cacheUniqueFindersCache(courseEnrollContract);

		return courseEnrollContract;
	}

	protected CourseEnrollContract toUnwrappedModel(
		CourseEnrollContract courseEnrollContract) {
		if (courseEnrollContract instanceof CourseEnrollContractImpl) {
			return courseEnrollContract;
		}

		CourseEnrollContractImpl courseEnrollContractImpl = new CourseEnrollContractImpl();

		courseEnrollContractImpl.setNew(courseEnrollContract.isNew());
		courseEnrollContractImpl.setPrimaryKey(courseEnrollContract.getPrimaryKey());

		courseEnrollContractImpl.setSpCourseContractId(courseEnrollContract.getSpCourseContractId());
		courseEnrollContractImpl.setGroupId(courseEnrollContract.getGroupId());
		courseEnrollContractImpl.setCompanyId(courseEnrollContract.getCompanyId());
		courseEnrollContractImpl.setUserId(courseEnrollContract.getUserId());
		courseEnrollContractImpl.setUserName(courseEnrollContract.getUserName());
		courseEnrollContractImpl.setCreateDate(courseEnrollContract.getCreateDate());
		courseEnrollContractImpl.setModifiedDate(courseEnrollContract.getModifiedDate());
		courseEnrollContractImpl.setCountryId(courseEnrollContract.getCountryId());
		courseEnrollContractImpl.setCourseType(courseEnrollContract.getCourseType());
		courseEnrollContractImpl.setDocType(courseEnrollContract.getDocType());
		courseEnrollContractImpl.setSeqNo(courseEnrollContract.getSeqNo());
		courseEnrollContractImpl.setContractTemplateFileEntryId(courseEnrollContract.getContractTemplateFileEntryId());
		courseEnrollContractImpl.setDataTemplateFileEntryId(courseEnrollContract.getDataTemplateFileEntryId());
		courseEnrollContractImpl.setExtraInfo(courseEnrollContract.getExtraInfo());

		return courseEnrollContractImpl;
	}

	/**
	 * Returns the course enroll contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course enroll contract
	 * @return the course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseEnrollContractException, SystemException {
		CourseEnrollContract courseEnrollContract = fetchByPrimaryKey(primaryKey);

		if (courseEnrollContract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseEnrollContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseEnrollContract;
	}

	/**
	 * Returns the course enroll contract with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseEnrollContractException} if it could not be found.
	 *
	 * @param spCourseContractId the primary key of the course enroll contract
	 * @return the course enroll contract
	 * @throws com.sambaash.platform.srv.NoSuchCourseEnrollContractException if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract findByPrimaryKey(long spCourseContractId)
		throws NoSuchCourseEnrollContractException, SystemException {
		return findByPrimaryKey((Serializable)spCourseContractId);
	}

	/**
	 * Returns the course enroll contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course enroll contract
	 * @return the course enroll contract, or <code>null</code> if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseEnrollContract courseEnrollContract = (CourseEnrollContract)EntityCacheUtil.getResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
				CourseEnrollContractImpl.class, primaryKey);

		if (courseEnrollContract == _nullCourseEnrollContract) {
			return null;
		}

		if (courseEnrollContract == null) {
			Session session = null;

			try {
				session = openSession();

				courseEnrollContract = (CourseEnrollContract)session.get(CourseEnrollContractImpl.class,
						primaryKey);

				if (courseEnrollContract != null) {
					cacheResult(courseEnrollContract);
				}
				else {
					EntityCacheUtil.putResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
						CourseEnrollContractImpl.class, primaryKey,
						_nullCourseEnrollContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseEnrollContractModelImpl.ENTITY_CACHE_ENABLED,
					CourseEnrollContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseEnrollContract;
	}

	/**
	 * Returns the course enroll contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseContractId the primary key of the course enroll contract
	 * @return the course enroll contract, or <code>null</code> if a course enroll contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseEnrollContract fetchByPrimaryKey(long spCourseContractId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseContractId);
	}

	/**
	 * Returns all the course enroll contracts.
	 *
	 * @return the course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course enroll contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course enroll contracts
	 * @param end the upper bound of the range of course enroll contracts (not inclusive)
	 * @return the range of course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course enroll contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course enroll contracts
	 * @param end the upper bound of the range of course enroll contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course enroll contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseEnrollContract> findAll(int start, int end,
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

		List<CourseEnrollContract> list = (List<CourseEnrollContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSEENROLLCONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSEENROLLCONTRACT;

				if (pagination) {
					sql = sql.concat(CourseEnrollContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseEnrollContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseEnrollContract>(list);
				}
				else {
					list = (List<CourseEnrollContract>)QueryUtil.list(q,
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
	 * Removes all the course enroll contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseEnrollContract courseEnrollContract : findAll()) {
			remove(courseEnrollContract);
		}
	}

	/**
	 * Returns the number of course enroll contracts.
	 *
	 * @return the number of course enroll contracts
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

				Query q = session.createQuery(_SQL_COUNT_COURSEENROLLCONTRACT);

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
	 * Initializes the course enroll contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseEnrollContract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseEnrollContract>> listenersList = new ArrayList<ModelListener<CourseEnrollContract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseEnrollContract>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseEnrollContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSEENROLLCONTRACT = "SELECT courseEnrollContract FROM CourseEnrollContract courseEnrollContract";
	private static final String _SQL_SELECT_COURSEENROLLCONTRACT_WHERE = "SELECT courseEnrollContract FROM CourseEnrollContract courseEnrollContract WHERE ";
	private static final String _SQL_COUNT_COURSEENROLLCONTRACT = "SELECT COUNT(courseEnrollContract) FROM CourseEnrollContract courseEnrollContract";
	private static final String _SQL_COUNT_COURSEENROLLCONTRACT_WHERE = "SELECT COUNT(courseEnrollContract) FROM CourseEnrollContract courseEnrollContract WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseEnrollContract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseEnrollContract exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseEnrollContract exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseEnrollContractPersistenceImpl.class);
	private static CourseEnrollContract _nullCourseEnrollContract = new CourseEnrollContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseEnrollContract> toCacheModel() {
				return _nullCourseEnrollContractCacheModel;
			}
		};

	private static CacheModel<CourseEnrollContract> _nullCourseEnrollContractCacheModel =
		new CacheModel<CourseEnrollContract>() {
			@Override
			public CourseEnrollContract toEntityModel() {
				return _nullCourseEnrollContract;
			}
		};
}