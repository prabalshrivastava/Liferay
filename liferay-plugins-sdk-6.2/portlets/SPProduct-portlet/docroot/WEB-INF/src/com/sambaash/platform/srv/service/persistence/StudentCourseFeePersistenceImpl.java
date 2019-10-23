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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchStudentCourseFeeException;
import com.sambaash.platform.srv.model.StudentCourseFee;
import com.sambaash.platform.srv.model.impl.StudentCourseFeeImpl;
import com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the student course fee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeePersistence
 * @see StudentCourseFeeUtil
 * @generated
 */
public class StudentCourseFeePersistenceImpl extends BasePersistenceImpl<StudentCourseFee>
	implements StudentCourseFeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentCourseFeeUtil} to access the student course fee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentCourseFeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEID =
		new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByprocessStateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID =
		new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByprocessStateId",
			new String[] { Long.class.getName() },
			StudentCourseFeeModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEID = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprocessStateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the student course fees where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findByprocessStateId(long spPEProcessStateId)
		throws SystemException {
		return findByprocessStateId(spPEProcessStateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student course fees where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of student course fees
	 * @param end the upper bound of the range of student course fees (not inclusive)
	 * @return the range of matching student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findByprocessStateId(
		long spPEProcessStateId, int start, int end) throws SystemException {
		return findByprocessStateId(spPEProcessStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student course fees where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of student course fees
	 * @param end the upper bound of the range of student course fees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findByprocessStateId(
		long spPEProcessStateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID;
			finderArgs = new Object[] { spPEProcessStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEID;
			finderArgs = new Object[] {
					spPEProcessStateId,
					
					start, end, orderByComparator
				};
		}

		List<StudentCourseFee> list = (List<StudentCourseFee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StudentCourseFee studentCourseFee : list) {
				if ((spPEProcessStateId != studentCourseFee.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_STUDENTCOURSEFEE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentCourseFeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<StudentCourseFee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudentCourseFee>(list);
				}
				else {
					list = (List<StudentCourseFee>)QueryUtil.list(q,
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
	 * Returns the first student course fee in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee findByprocessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = fetchByprocessStateId_First(spPEProcessStateId,
				orderByComparator);

		if (studentCourseFee != null) {
			return studentCourseFee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentCourseFeeException(msg.toString());
	}

	/**
	 * Returns the first student course fee in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student course fee, or <code>null</code> if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByprocessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StudentCourseFee> list = findByprocessStateId(spPEProcessStateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student course fee in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee findByprocessStateId_Last(long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = fetchByprocessStateId_Last(spPEProcessStateId,
				orderByComparator);

		if (studentCourseFee != null) {
			return studentCourseFee;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentCourseFeeException(msg.toString());
	}

	/**
	 * Returns the last student course fee in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student course fee, or <code>null</code> if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByprocessStateId_Last(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByprocessStateId(spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<StudentCourseFee> list = findByprocessStateId(spPEProcessStateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student course fees before and after the current student course fee in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spStudentCourseFeeId the primary key of the current student course fee
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee[] findByprocessStateId_PrevAndNext(
		long spStudentCourseFeeId, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = findByPrimaryKey(spStudentCourseFeeId);

		Session session = null;

		try {
			session = openSession();

			StudentCourseFee[] array = new StudentCourseFeeImpl[3];

			array[0] = getByprocessStateId_PrevAndNext(session,
					studentCourseFee, spPEProcessStateId, orderByComparator,
					true);

			array[1] = studentCourseFee;

			array[2] = getByprocessStateId_PrevAndNext(session,
					studentCourseFee, spPEProcessStateId, orderByComparator,
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

	protected StudentCourseFee getByprocessStateId_PrevAndNext(
		Session session, StudentCourseFee studentCourseFee,
		long spPEProcessStateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENTCOURSEFEE_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

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
			query.append(StudentCourseFeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentCourseFee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentCourseFee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student course fees where spPEProcessStateId = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByprocessStateId(long spPEProcessStateId)
		throws SystemException {
		for (StudentCourseFee studentCourseFee : findByprocessStateId(
				spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentCourseFee);
		}
	}

	/**
	 * Returns the number of student course fees where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprocessStateId(long spPEProcessStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEID;

		Object[] finderArgs = new Object[] { spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTCOURSEFEE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"studentCourseFee.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByprocessStateIdFeeType",
			new String[] { Long.class.getName(), String.class.getName() },
			StudentCourseFeeModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			StudentCourseFeeModelImpl.FEETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE = new FinderPath(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByprocessStateIdFeeType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the student course fee where spPEProcessStateId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeException} if it could not be found.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param feeType the fee type
	 * @return the matching student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee findByprocessStateIdFeeType(
		long spPEProcessStateId, String feeType)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = fetchByprocessStateIdFeeType(spPEProcessStateId,
				feeType);

		if (studentCourseFee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spPEProcessStateId=");
			msg.append(spPEProcessStateId);

			msg.append(", feeType=");
			msg.append(feeType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStudentCourseFeeException(msg.toString());
		}

		return studentCourseFee;
	}

	/**
	 * Returns the student course fee where spPEProcessStateId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param feeType the fee type
	 * @return the matching student course fee, or <code>null</code> if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByprocessStateIdFeeType(
		long spPEProcessStateId, String feeType) throws SystemException {
		return fetchByprocessStateIdFeeType(spPEProcessStateId, feeType, true);
	}

	/**
	 * Returns the student course fee where spPEProcessStateId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param feeType the fee type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching student course fee, or <code>null</code> if a matching student course fee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByprocessStateIdFeeType(
		long spPEProcessStateId, String feeType, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spPEProcessStateId, feeType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
					finderArgs, this);
		}

		if (result instanceof StudentCourseFee) {
			StudentCourseFee studentCourseFee = (StudentCourseFee)result;

			if ((spPEProcessStateId != studentCourseFee.getSpPEProcessStateId()) ||
					!Validator.equals(feeType, studentCourseFee.getFeeType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STUDENTCOURSEFEE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_SPPEPROCESSSTATEID_2);

			boolean bindFeeType = false;

			if (feeType == null) {
				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_1);
			}
			else if (feeType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_3);
			}
			else {
				bindFeeType = true;

				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindFeeType) {
					qPos.add(feeType);
				}

				List<StudentCourseFee> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StudentCourseFeePersistenceImpl.fetchByprocessStateIdFeeType(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StudentCourseFee studentCourseFee = list.get(0);

					result = studentCourseFee;

					cacheResult(studentCourseFee);

					if ((studentCourseFee.getSpPEProcessStateId() != spPEProcessStateId) ||
							(studentCourseFee.getFeeType() == null) ||
							!studentCourseFee.getFeeType().equals(feeType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
							finderArgs, studentCourseFee);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
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
			return (StudentCourseFee)result;
		}
	}

	/**
	 * Removes the student course fee where spPEProcessStateId = &#63; and feeType = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param feeType the fee type
	 * @return the student course fee that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee removeByprocessStateIdFeeType(
		long spPEProcessStateId, String feeType)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = findByprocessStateIdFeeType(spPEProcessStateId,
				feeType);

		return remove(studentCourseFee);
	}

	/**
	 * Returns the number of student course fees where spPEProcessStateId = &#63; and feeType = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param feeType the fee type
	 * @return the number of matching student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprocessStateIdFeeType(long spPEProcessStateId,
		String feeType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE;

		Object[] finderArgs = new Object[] { spPEProcessStateId, feeType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENTCOURSEFEE_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_SPPEPROCESSSTATEID_2);

			boolean bindFeeType = false;

			if (feeType == null) {
				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_1);
			}
			else if (feeType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_3);
			}
			else {
				bindFeeType = true;

				query.append(_FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindFeeType) {
					qPos.add(feeType);
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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDFEETYPE_SPPEPROCESSSTATEID_2 =
		"studentCourseFee.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_1 = "studentCourseFee.feeType IS NULL";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_2 = "studentCourseFee.feeType = ?";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDFEETYPE_FEETYPE_3 = "(studentCourseFee.feeType IS NULL OR studentCourseFee.feeType = '')";

	public StudentCourseFeePersistenceImpl() {
		setModelClass(StudentCourseFee.class);
	}

	/**
	 * Caches the student course fee in the entity cache if it is enabled.
	 *
	 * @param studentCourseFee the student course fee
	 */
	@Override
	public void cacheResult(StudentCourseFee studentCourseFee) {
		EntityCacheUtil.putResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeImpl.class, studentCourseFee.getPrimaryKey(),
			studentCourseFee);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
			new Object[] {
				studentCourseFee.getSpPEProcessStateId(),
				studentCourseFee.getFeeType()
			}, studentCourseFee);

		studentCourseFee.resetOriginalValues();
	}

	/**
	 * Caches the student course fees in the entity cache if it is enabled.
	 *
	 * @param studentCourseFees the student course fees
	 */
	@Override
	public void cacheResult(List<StudentCourseFee> studentCourseFees) {
		for (StudentCourseFee studentCourseFee : studentCourseFees) {
			if (EntityCacheUtil.getResult(
						StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
						StudentCourseFeeImpl.class,
						studentCourseFee.getPrimaryKey()) == null) {
				cacheResult(studentCourseFee);
			}
			else {
				studentCourseFee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student course fees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentCourseFeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentCourseFeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student course fee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentCourseFee studentCourseFee) {
		EntityCacheUtil.removeResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeImpl.class, studentCourseFee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(studentCourseFee);
	}

	@Override
	public void clearCache(List<StudentCourseFee> studentCourseFees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentCourseFee studentCourseFee : studentCourseFees) {
			EntityCacheUtil.removeResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
				StudentCourseFeeImpl.class, studentCourseFee.getPrimaryKey());

			clearUniqueFindersCache(studentCourseFee);
		}
	}

	protected void cacheUniqueFindersCache(StudentCourseFee studentCourseFee) {
		if (studentCourseFee.isNew()) {
			Object[] args = new Object[] {
					studentCourseFee.getSpPEProcessStateId(),
					studentCourseFee.getFeeType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
				args, studentCourseFee);
		}
		else {
			StudentCourseFeeModelImpl studentCourseFeeModelImpl = (StudentCourseFeeModelImpl)studentCourseFee;

			if ((studentCourseFeeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentCourseFee.getSpPEProcessStateId(),
						studentCourseFee.getFeeType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
					args, studentCourseFee);
			}
		}
	}

	protected void clearUniqueFindersCache(StudentCourseFee studentCourseFee) {
		StudentCourseFeeModelImpl studentCourseFeeModelImpl = (StudentCourseFeeModelImpl)studentCourseFee;

		Object[] args = new Object[] {
				studentCourseFee.getSpPEProcessStateId(),
				studentCourseFee.getFeeType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
			args);

		if ((studentCourseFeeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					studentCourseFeeModelImpl.getOriginalSpPEProcessStateId(),
					studentCourseFeeModelImpl.getOriginalFeeType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDFEETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDFEETYPE,
				args);
		}
	}

	/**
	 * Creates a new student course fee with the primary key. Does not add the student course fee to the database.
	 *
	 * @param spStudentCourseFeeId the primary key for the new student course fee
	 * @return the new student course fee
	 */
	@Override
	public StudentCourseFee create(long spStudentCourseFeeId) {
		StudentCourseFee studentCourseFee = new StudentCourseFeeImpl();

		studentCourseFee.setNew(true);
		studentCourseFee.setPrimaryKey(spStudentCourseFeeId);

		return studentCourseFee;
	}

	/**
	 * Removes the student course fee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spStudentCourseFeeId the primary key of the student course fee
	 * @return the student course fee that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee remove(long spStudentCourseFeeId)
		throws NoSuchStudentCourseFeeException, SystemException {
		return remove((Serializable)spStudentCourseFeeId);
	}

	/**
	 * Removes the student course fee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student course fee
	 * @return the student course fee that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee remove(Serializable primaryKey)
		throws NoSuchStudentCourseFeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudentCourseFee studentCourseFee = (StudentCourseFee)session.get(StudentCourseFeeImpl.class,
					primaryKey);

			if (studentCourseFee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentCourseFeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentCourseFee);
		}
		catch (NoSuchStudentCourseFeeException nsee) {
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
	protected StudentCourseFee removeImpl(StudentCourseFee studentCourseFee)
		throws SystemException {
		studentCourseFee = toUnwrappedModel(studentCourseFee);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentCourseFee)) {
				studentCourseFee = (StudentCourseFee)session.get(StudentCourseFeeImpl.class,
						studentCourseFee.getPrimaryKeyObj());
			}

			if (studentCourseFee != null) {
				session.delete(studentCourseFee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentCourseFee != null) {
			clearCache(studentCourseFee);
		}

		return studentCourseFee;
	}

	@Override
	public StudentCourseFee updateImpl(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws SystemException {
		studentCourseFee = toUnwrappedModel(studentCourseFee);

		boolean isNew = studentCourseFee.isNew();

		StudentCourseFeeModelImpl studentCourseFeeModelImpl = (StudentCourseFeeModelImpl)studentCourseFee;

		Session session = null;

		try {
			session = openSession();

			if (studentCourseFee.isNew()) {
				session.save(studentCourseFee);

				studentCourseFee.setNew(false);
			}
			else {
				session.merge(studentCourseFee);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentCourseFeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentCourseFeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentCourseFeeModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID,
					args);

				args = new Object[] {
						studentCourseFeeModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeImpl.class, studentCourseFee.getPrimaryKey(),
			studentCourseFee);

		clearUniqueFindersCache(studentCourseFee);
		cacheUniqueFindersCache(studentCourseFee);

		return studentCourseFee;
	}

	protected StudentCourseFee toUnwrappedModel(
		StudentCourseFee studentCourseFee) {
		if (studentCourseFee instanceof StudentCourseFeeImpl) {
			return studentCourseFee;
		}

		StudentCourseFeeImpl studentCourseFeeImpl = new StudentCourseFeeImpl();

		studentCourseFeeImpl.setNew(studentCourseFee.isNew());
		studentCourseFeeImpl.setPrimaryKey(studentCourseFee.getPrimaryKey());

		studentCourseFeeImpl.setSpStudentCourseFeeId(studentCourseFee.getSpStudentCourseFeeId());
		studentCourseFeeImpl.setGroupId(studentCourseFee.getGroupId());
		studentCourseFeeImpl.setCompanyId(studentCourseFee.getCompanyId());
		studentCourseFeeImpl.setUserId(studentCourseFee.getUserId());
		studentCourseFeeImpl.setUserName(studentCourseFee.getUserName());
		studentCourseFeeImpl.setCreateDate(studentCourseFee.getCreateDate());
		studentCourseFeeImpl.setModifiedDate(studentCourseFee.getModifiedDate());
		studentCourseFeeImpl.setSpPEProcessStateId(studentCourseFee.getSpPEProcessStateId());
		studentCourseFeeImpl.setFeeType(studentCourseFee.getFeeType());
		studentCourseFeeImpl.setAmount(studentCourseFee.getAmount());
		studentCourseFeeImpl.setOrder(studentCourseFee.getOrder());
		studentCourseFeeImpl.setFormula(studentCourseFee.getFormula());
		studentCourseFeeImpl.setLabel(studentCourseFee.getLabel());

		return studentCourseFeeImpl;
	}

	/**
	 * Returns the student course fee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student course fee
	 * @return the student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentCourseFeeException, SystemException {
		StudentCourseFee studentCourseFee = fetchByPrimaryKey(primaryKey);

		if (studentCourseFee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentCourseFeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentCourseFee;
	}

	/**
	 * Returns the student course fee with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeException} if it could not be found.
	 *
	 * @param spStudentCourseFeeId the primary key of the student course fee
	 * @return the student course fee
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeException if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee findByPrimaryKey(long spStudentCourseFeeId)
		throws NoSuchStudentCourseFeeException, SystemException {
		return findByPrimaryKey((Serializable)spStudentCourseFeeId);
	}

	/**
	 * Returns the student course fee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student course fee
	 * @return the student course fee, or <code>null</code> if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StudentCourseFee studentCourseFee = (StudentCourseFee)EntityCacheUtil.getResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
				StudentCourseFeeImpl.class, primaryKey);

		if (studentCourseFee == _nullStudentCourseFee) {
			return null;
		}

		if (studentCourseFee == null) {
			Session session = null;

			try {
				session = openSession();

				studentCourseFee = (StudentCourseFee)session.get(StudentCourseFeeImpl.class,
						primaryKey);

				if (studentCourseFee != null) {
					cacheResult(studentCourseFee);
				}
				else {
					EntityCacheUtil.putResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
						StudentCourseFeeImpl.class, primaryKey,
						_nullStudentCourseFee);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentCourseFeeModelImpl.ENTITY_CACHE_ENABLED,
					StudentCourseFeeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentCourseFee;
	}

	/**
	 * Returns the student course fee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spStudentCourseFeeId the primary key of the student course fee
	 * @return the student course fee, or <code>null</code> if a student course fee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFee fetchByPrimaryKey(long spStudentCourseFeeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spStudentCourseFeeId);
	}

	/**
	 * Returns all the student course fees.
	 *
	 * @return the student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student course fees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student course fees
	 * @param end the upper bound of the range of student course fees (not inclusive)
	 * @return the range of student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student course fees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student course fees
	 * @param end the upper bound of the range of student course fees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student course fees
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFee> findAll(int start, int end,
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

		List<StudentCourseFee> list = (List<StudentCourseFee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENTCOURSEFEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTCOURSEFEE;

				if (pagination) {
					sql = sql.concat(StudentCourseFeeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentCourseFee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudentCourseFee>(list);
				}
				else {
					list = (List<StudentCourseFee>)QueryUtil.list(q,
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
	 * Removes all the student course fees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StudentCourseFee studentCourseFee : findAll()) {
			remove(studentCourseFee);
		}
	}

	/**
	 * Returns the number of student course fees.
	 *
	 * @return the number of student course fees
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

				Query q = session.createQuery(_SQL_COUNT_STUDENTCOURSEFEE);

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
	 * Initializes the student course fee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.StudentCourseFee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudentCourseFee>> listenersList = new ArrayList<ModelListener<StudentCourseFee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudentCourseFee>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudentCourseFeeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENTCOURSEFEE = "SELECT studentCourseFee FROM StudentCourseFee studentCourseFee";
	private static final String _SQL_SELECT_STUDENTCOURSEFEE_WHERE = "SELECT studentCourseFee FROM StudentCourseFee studentCourseFee WHERE ";
	private static final String _SQL_COUNT_STUDENTCOURSEFEE = "SELECT COUNT(studentCourseFee) FROM StudentCourseFee studentCourseFee";
	private static final String _SQL_COUNT_STUDENTCOURSEFEE_WHERE = "SELECT COUNT(studentCourseFee) FROM StudentCourseFee studentCourseFee WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentCourseFee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentCourseFee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudentCourseFee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentCourseFeePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
	private static StudentCourseFee _nullStudentCourseFee = new StudentCourseFeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StudentCourseFee> toCacheModel() {
				return _nullStudentCourseFeeCacheModel;
			}
		};

	private static CacheModel<StudentCourseFee> _nullStudentCourseFeeCacheModel = new CacheModel<StudentCourseFee>() {
			@Override
			public StudentCourseFee toEntityModel() {
				return _nullStudentCourseFee;
			}
		};
}