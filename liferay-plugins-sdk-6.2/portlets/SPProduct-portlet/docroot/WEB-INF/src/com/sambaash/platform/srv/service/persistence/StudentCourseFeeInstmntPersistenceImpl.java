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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException;
import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;
import com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntImpl;
import com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the student course fee instmnt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmntPersistence
 * @see StudentCourseFeeInstmntUtil
 * @generated
 */
public class StudentCourseFeeInstmntPersistenceImpl extends BasePersistenceImpl<StudentCourseFeeInstmnt>
	implements StudentCourseFeeInstmntPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentCourseFeeInstmntUtil} to access the student course fee instmnt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentCourseFeeInstmntImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEID =
		new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByprocessStateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID =
		new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByprocessStateId",
			new String[] { Long.class.getName() },
			StudentCourseFeeInstmntModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEID = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprocessStateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the student course fee instmnts where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findByprocessStateId(
		long spPEProcessStateId) throws SystemException {
		return findByprocessStateId(spPEProcessStateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student course fee instmnts where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of student course fee instmnts
	 * @param end the upper bound of the range of student course fee instmnts (not inclusive)
	 * @return the range of matching student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findByprocessStateId(
		long spPEProcessStateId, int start, int end) throws SystemException {
		return findByprocessStateId(spPEProcessStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student course fee instmnts where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of student course fee instmnts
	 * @param end the upper bound of the range of student course fee instmnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findByprocessStateId(
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

		List<StudentCourseFeeInstmnt> list = (List<StudentCourseFeeInstmnt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : list) {
				if ((spPEProcessStateId != studentCourseFeeInstmnt.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_STUDENTCOURSEFEEINSTMNT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentCourseFeeInstmntModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<StudentCourseFeeInstmnt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudentCourseFeeInstmnt>(list);
				}
				else {
					list = (List<StudentCourseFeeInstmnt>)QueryUtil.list(q,
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
	 * Returns the first student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt findByprocessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = fetchByprocessStateId_First(spPEProcessStateId,
				orderByComparator);

		if (studentCourseFeeInstmnt != null) {
			return studentCourseFeeInstmnt;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentCourseFeeInstmntException(msg.toString());
	}

	/**
	 * Returns the first student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByprocessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StudentCourseFeeInstmnt> list = findByprocessStateId(spPEProcessStateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt findByprocessStateId_Last(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = fetchByprocessStateId_Last(spPEProcessStateId,
				orderByComparator);

		if (studentCourseFeeInstmnt != null) {
			return studentCourseFeeInstmnt;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentCourseFeeInstmntException(msg.toString());
	}

	/**
	 * Returns the last student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByprocessStateId_Last(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByprocessStateId(spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<StudentCourseFeeInstmnt> list = findByprocessStateId(spPEProcessStateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student course fee instmnts before and after the current student course fee instmnt in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spStudentCourseFeeInstmntId the primary key of the current student course fee instmnt
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt[] findByprocessStateId_PrevAndNext(
		long spStudentCourseFeeInstmntId, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = findByPrimaryKey(spStudentCourseFeeInstmntId);

		Session session = null;

		try {
			session = openSession();

			StudentCourseFeeInstmnt[] array = new StudentCourseFeeInstmntImpl[3];

			array[0] = getByprocessStateId_PrevAndNext(session,
					studentCourseFeeInstmnt, spPEProcessStateId,
					orderByComparator, true);

			array[1] = studentCourseFeeInstmnt;

			array[2] = getByprocessStateId_PrevAndNext(session,
					studentCourseFeeInstmnt, spPEProcessStateId,
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

	protected StudentCourseFeeInstmnt getByprocessStateId_PrevAndNext(
		Session session, StudentCourseFeeInstmnt studentCourseFeeInstmnt,
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

		query.append(_SQL_SELECT_STUDENTCOURSEFEEINSTMNT_WHERE);

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
			query.append(StudentCourseFeeInstmntModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(studentCourseFeeInstmnt);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudentCourseFeeInstmnt> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student course fee instmnts where spPEProcessStateId = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByprocessStateId(long spPEProcessStateId)
		throws SystemException {
		for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : findByprocessStateId(
				spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(studentCourseFeeInstmnt);
		}
	}

	/**
	 * Returns the number of student course fee instmnts where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching student course fee instmnts
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

			query.append(_SQL_COUNT_STUDENTCOURSEFEEINSTMNT_WHERE);

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
		"studentCourseFeeInstmnt.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByprocessStateIdInsmntNo",
			new String[] { Long.class.getName(), Integer.class.getName() },
			StudentCourseFeeInstmntModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			StudentCourseFeeInstmntModelImpl.INSMNTNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO = new FinderPath(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByprocessStateIdInsmntNo",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException} if it could not be found.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param insmntNo the insmnt no
	 * @return the matching student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt findByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = fetchByprocessStateIdInsmntNo(spPEProcessStateId,
				insmntNo);

		if (studentCourseFeeInstmnt == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spPEProcessStateId=");
			msg.append(spPEProcessStateId);

			msg.append(", insmntNo=");
			msg.append(insmntNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStudentCourseFeeInstmntException(msg.toString());
		}

		return studentCourseFeeInstmnt;
	}

	/**
	 * Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param insmntNo the insmnt no
	 * @return the matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo) throws SystemException {
		return fetchByprocessStateIdInsmntNo(spPEProcessStateId, insmntNo, true);
	}

	/**
	 * Returns the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param insmntNo the insmnt no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching student course fee instmnt, or <code>null</code> if a matching student course fee instmnt could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spPEProcessStateId, insmntNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
					finderArgs, this);
		}

		if (result instanceof StudentCourseFeeInstmnt) {
			StudentCourseFeeInstmnt studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)result;

			if ((spPEProcessStateId != studentCourseFeeInstmnt.getSpPEProcessStateId()) ||
					(insmntNo != studentCourseFeeInstmnt.getInsmntNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STUDENTCOURSEFEEINSTMNT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_INSMNTNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(insmntNo);

				List<StudentCourseFeeInstmnt> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StudentCourseFeeInstmntPersistenceImpl.fetchByprocessStateIdInsmntNo(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StudentCourseFeeInstmnt studentCourseFeeInstmnt = list.get(0);

					result = studentCourseFeeInstmnt;

					cacheResult(studentCourseFeeInstmnt);

					if ((studentCourseFeeInstmnt.getSpPEProcessStateId() != spPEProcessStateId) ||
							(studentCourseFeeInstmnt.getInsmntNo() != insmntNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
							finderArgs, studentCourseFeeInstmnt);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
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
			return (StudentCourseFeeInstmnt)result;
		}
	}

	/**
	 * Removes the student course fee instmnt where spPEProcessStateId = &#63; and insmntNo = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param insmntNo the insmnt no
	 * @return the student course fee instmnt that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt removeByprocessStateIdInsmntNo(
		long spPEProcessStateId, int insmntNo)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = findByprocessStateIdInsmntNo(spPEProcessStateId,
				insmntNo);

		return remove(studentCourseFeeInstmnt);
	}

	/**
	 * Returns the number of student course fee instmnts where spPEProcessStateId = &#63; and insmntNo = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param insmntNo the insmnt no
	 * @return the number of matching student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprocessStateIdInsmntNo(long spPEProcessStateId,
		int insmntNo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO;

		Object[] finderArgs = new Object[] { spPEProcessStateId, insmntNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENTCOURSEFEEINSTMNT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_INSMNTNO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(insmntNo);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_SPPEPROCESSSTATEID_2 =
		"studentCourseFeeInstmnt.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDINSMNTNO_INSMNTNO_2 =
		"studentCourseFeeInstmnt.insmntNo = ?";

	public StudentCourseFeeInstmntPersistenceImpl() {
		setModelClass(StudentCourseFeeInstmnt.class);
	}

	/**
	 * Caches the student course fee instmnt in the entity cache if it is enabled.
	 *
	 * @param studentCourseFeeInstmnt the student course fee instmnt
	 */
	@Override
	public void cacheResult(StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		EntityCacheUtil.putResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			studentCourseFeeInstmnt.getPrimaryKey(), studentCourseFeeInstmnt);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
			new Object[] {
				studentCourseFeeInstmnt.getSpPEProcessStateId(),
				studentCourseFeeInstmnt.getInsmntNo()
			}, studentCourseFeeInstmnt);

		studentCourseFeeInstmnt.resetOriginalValues();
	}

	/**
	 * Caches the student course fee instmnts in the entity cache if it is enabled.
	 *
	 * @param studentCourseFeeInstmnts the student course fee instmnts
	 */
	@Override
	public void cacheResult(
		List<StudentCourseFeeInstmnt> studentCourseFeeInstmnts) {
		for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : studentCourseFeeInstmnts) {
			if (EntityCacheUtil.getResult(
						StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
						StudentCourseFeeInstmntImpl.class,
						studentCourseFeeInstmnt.getPrimaryKey()) == null) {
				cacheResult(studentCourseFeeInstmnt);
			}
			else {
				studentCourseFeeInstmnt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student course fee instmnts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentCourseFeeInstmntImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentCourseFeeInstmntImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student course fee instmnt.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		EntityCacheUtil.removeResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			studentCourseFeeInstmnt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(studentCourseFeeInstmnt);
	}

	@Override
	public void clearCache(
		List<StudentCourseFeeInstmnt> studentCourseFeeInstmnts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : studentCourseFeeInstmnts) {
			EntityCacheUtil.removeResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
				StudentCourseFeeInstmntImpl.class,
				studentCourseFeeInstmnt.getPrimaryKey());

			clearUniqueFindersCache(studentCourseFeeInstmnt);
		}
	}

	protected void cacheUniqueFindersCache(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		if (studentCourseFeeInstmnt.isNew()) {
			Object[] args = new Object[] {
					studentCourseFeeInstmnt.getSpPEProcessStateId(),
					studentCourseFeeInstmnt.getInsmntNo()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
				args, studentCourseFeeInstmnt);
		}
		else {
			StudentCourseFeeInstmntModelImpl studentCourseFeeInstmntModelImpl = (StudentCourseFeeInstmntModelImpl)studentCourseFeeInstmnt;

			if ((studentCourseFeeInstmntModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentCourseFeeInstmnt.getSpPEProcessStateId(),
						studentCourseFeeInstmnt.getInsmntNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
					args, studentCourseFeeInstmnt);
			}
		}
	}

	protected void clearUniqueFindersCache(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		StudentCourseFeeInstmntModelImpl studentCourseFeeInstmntModelImpl = (StudentCourseFeeInstmntModelImpl)studentCourseFeeInstmnt;

		Object[] args = new Object[] {
				studentCourseFeeInstmnt.getSpPEProcessStateId(),
				studentCourseFeeInstmnt.getInsmntNo()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
			args);

		if ((studentCourseFeeInstmntModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO.getColumnBitmask()) != 0) {
			args = new Object[] {
					studentCourseFeeInstmntModelImpl.getOriginalSpPEProcessStateId(),
					studentCourseFeeInstmntModelImpl.getOriginalInsmntNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDINSMNTNO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSSTATEIDINSMNTNO,
				args);
		}
	}

	/**
	 * Creates a new student course fee instmnt with the primary key. Does not add the student course fee instmnt to the database.
	 *
	 * @param spStudentCourseFeeInstmntId the primary key for the new student course fee instmnt
	 * @return the new student course fee instmnt
	 */
	@Override
	public StudentCourseFeeInstmnt create(long spStudentCourseFeeInstmntId) {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = new StudentCourseFeeInstmntImpl();

		studentCourseFeeInstmnt.setNew(true);
		studentCourseFeeInstmnt.setPrimaryKey(spStudentCourseFeeInstmntId);

		return studentCourseFeeInstmnt;
	}

	/**
	 * Removes the student course fee instmnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	 * @return the student course fee instmnt that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt remove(long spStudentCourseFeeInstmntId)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		return remove((Serializable)spStudentCourseFeeInstmntId);
	}

	/**
	 * Removes the student course fee instmnt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student course fee instmnt
	 * @return the student course fee instmnt that was removed
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt remove(Serializable primaryKey)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudentCourseFeeInstmnt studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)session.get(StudentCourseFeeInstmntImpl.class,
					primaryKey);

			if (studentCourseFeeInstmnt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentCourseFeeInstmntException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentCourseFeeInstmnt);
		}
		catch (NoSuchStudentCourseFeeInstmntException nsee) {
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
	protected StudentCourseFeeInstmnt removeImpl(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws SystemException {
		studentCourseFeeInstmnt = toUnwrappedModel(studentCourseFeeInstmnt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentCourseFeeInstmnt)) {
				studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)session.get(StudentCourseFeeInstmntImpl.class,
						studentCourseFeeInstmnt.getPrimaryKeyObj());
			}

			if (studentCourseFeeInstmnt != null) {
				session.delete(studentCourseFeeInstmnt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentCourseFeeInstmnt != null) {
			clearCache(studentCourseFeeInstmnt);
		}

		return studentCourseFeeInstmnt;
	}

	@Override
	public StudentCourseFeeInstmnt updateImpl(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws SystemException {
		studentCourseFeeInstmnt = toUnwrappedModel(studentCourseFeeInstmnt);

		boolean isNew = studentCourseFeeInstmnt.isNew();

		StudentCourseFeeInstmntModelImpl studentCourseFeeInstmntModelImpl = (StudentCourseFeeInstmntModelImpl)studentCourseFeeInstmnt;

		Session session = null;

		try {
			session = openSession();

			if (studentCourseFeeInstmnt.isNew()) {
				session.save(studentCourseFeeInstmnt);

				studentCourseFeeInstmnt.setNew(false);
			}
			else {
				session.merge(studentCourseFeeInstmnt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentCourseFeeInstmntModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentCourseFeeInstmntModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentCourseFeeInstmntModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID,
					args);

				args = new Object[] {
						studentCourseFeeInstmntModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
			StudentCourseFeeInstmntImpl.class,
			studentCourseFeeInstmnt.getPrimaryKey(), studentCourseFeeInstmnt);

		clearUniqueFindersCache(studentCourseFeeInstmnt);
		cacheUniqueFindersCache(studentCourseFeeInstmnt);

		return studentCourseFeeInstmnt;
	}

	protected StudentCourseFeeInstmnt toUnwrappedModel(
		StudentCourseFeeInstmnt studentCourseFeeInstmnt) {
		if (studentCourseFeeInstmnt instanceof StudentCourseFeeInstmntImpl) {
			return studentCourseFeeInstmnt;
		}

		StudentCourseFeeInstmntImpl studentCourseFeeInstmntImpl = new StudentCourseFeeInstmntImpl();

		studentCourseFeeInstmntImpl.setNew(studentCourseFeeInstmnt.isNew());
		studentCourseFeeInstmntImpl.setPrimaryKey(studentCourseFeeInstmnt.getPrimaryKey());

		studentCourseFeeInstmntImpl.setSpStudentCourseFeeInstmntId(studentCourseFeeInstmnt.getSpStudentCourseFeeInstmntId());
		studentCourseFeeInstmntImpl.setGroupId(studentCourseFeeInstmnt.getGroupId());
		studentCourseFeeInstmntImpl.setCompanyId(studentCourseFeeInstmnt.getCompanyId());
		studentCourseFeeInstmntImpl.setUserId(studentCourseFeeInstmnt.getUserId());
		studentCourseFeeInstmntImpl.setUserName(studentCourseFeeInstmnt.getUserName());
		studentCourseFeeInstmntImpl.setCreateDate(studentCourseFeeInstmnt.getCreateDate());
		studentCourseFeeInstmntImpl.setModifiedDate(studentCourseFeeInstmnt.getModifiedDate());
		studentCourseFeeInstmntImpl.setSpPEProcessStateId(studentCourseFeeInstmnt.getSpPEProcessStateId());
		studentCourseFeeInstmntImpl.setInsmntNo(studentCourseFeeInstmnt.getInsmntNo());
		studentCourseFeeInstmntImpl.setAmount(studentCourseFeeInstmnt.getAmount());
		studentCourseFeeInstmntImpl.setDate(studentCourseFeeInstmnt.getDate());

		return studentCourseFeeInstmntImpl;
	}

	/**
	 * Returns the student course fee instmnt with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student course fee instmnt
	 * @return the student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = fetchByPrimaryKey(primaryKey);

		if (studentCourseFeeInstmnt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentCourseFeeInstmntException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentCourseFeeInstmnt;
	}

	/**
	 * Returns the student course fee instmnt with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException} if it could not be found.
	 *
	 * @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	 * @return the student course fee instmnt
	 * @throws com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt findByPrimaryKey(
		long spStudentCourseFeeInstmntId)
		throws NoSuchStudentCourseFeeInstmntException, SystemException {
		return findByPrimaryKey((Serializable)spStudentCourseFeeInstmntId);
	}

	/**
	 * Returns the student course fee instmnt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student course fee instmnt
	 * @return the student course fee instmnt, or <code>null</code> if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StudentCourseFeeInstmnt studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)EntityCacheUtil.getResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
				StudentCourseFeeInstmntImpl.class, primaryKey);

		if (studentCourseFeeInstmnt == _nullStudentCourseFeeInstmnt) {
			return null;
		}

		if (studentCourseFeeInstmnt == null) {
			Session session = null;

			try {
				session = openSession();

				studentCourseFeeInstmnt = (StudentCourseFeeInstmnt)session.get(StudentCourseFeeInstmntImpl.class,
						primaryKey);

				if (studentCourseFeeInstmnt != null) {
					cacheResult(studentCourseFeeInstmnt);
				}
				else {
					EntityCacheUtil.putResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
						StudentCourseFeeInstmntImpl.class, primaryKey,
						_nullStudentCourseFeeInstmnt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentCourseFeeInstmntModelImpl.ENTITY_CACHE_ENABLED,
					StudentCourseFeeInstmntImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentCourseFeeInstmnt;
	}

	/**
	 * Returns the student course fee instmnt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	 * @return the student course fee instmnt, or <code>null</code> if a student course fee instmnt with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StudentCourseFeeInstmnt fetchByPrimaryKey(
		long spStudentCourseFeeInstmntId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spStudentCourseFeeInstmntId);
	}

	/**
	 * Returns all the student course fee instmnts.
	 *
	 * @return the student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student course fee instmnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student course fee instmnts
	 * @param end the upper bound of the range of student course fee instmnts (not inclusive)
	 * @return the range of student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student course fee instmnts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student course fee instmnts
	 * @param end the upper bound of the range of student course fee instmnts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student course fee instmnts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StudentCourseFeeInstmnt> findAll(int start, int end,
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

		List<StudentCourseFeeInstmnt> list = (List<StudentCourseFeeInstmnt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENTCOURSEFEEINSTMNT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTCOURSEFEEINSTMNT;

				if (pagination) {
					sql = sql.concat(StudentCourseFeeInstmntModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentCourseFeeInstmnt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StudentCourseFeeInstmnt>(list);
				}
				else {
					list = (List<StudentCourseFeeInstmnt>)QueryUtil.list(q,
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
	 * Removes all the student course fee instmnts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StudentCourseFeeInstmnt studentCourseFeeInstmnt : findAll()) {
			remove(studentCourseFeeInstmnt);
		}
	}

	/**
	 * Returns the number of student course fee instmnts.
	 *
	 * @return the number of student course fee instmnts
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

				Query q = session.createQuery(_SQL_COUNT_STUDENTCOURSEFEEINSTMNT);

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
	 * Initializes the student course fee instmnt persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.StudentCourseFeeInstmnt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudentCourseFeeInstmnt>> listenersList = new ArrayList<ModelListener<StudentCourseFeeInstmnt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudentCourseFeeInstmnt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudentCourseFeeInstmntImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENTCOURSEFEEINSTMNT = "SELECT studentCourseFeeInstmnt FROM StudentCourseFeeInstmnt studentCourseFeeInstmnt";
	private static final String _SQL_SELECT_STUDENTCOURSEFEEINSTMNT_WHERE = "SELECT studentCourseFeeInstmnt FROM StudentCourseFeeInstmnt studentCourseFeeInstmnt WHERE ";
	private static final String _SQL_COUNT_STUDENTCOURSEFEEINSTMNT = "SELECT COUNT(studentCourseFeeInstmnt) FROM StudentCourseFeeInstmnt studentCourseFeeInstmnt";
	private static final String _SQL_COUNT_STUDENTCOURSEFEEINSTMNT_WHERE = "SELECT COUNT(studentCourseFeeInstmnt) FROM StudentCourseFeeInstmnt studentCourseFeeInstmnt WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentCourseFeeInstmnt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentCourseFeeInstmnt exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudentCourseFeeInstmnt exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentCourseFeeInstmntPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static StudentCourseFeeInstmnt _nullStudentCourseFeeInstmnt = new StudentCourseFeeInstmntImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StudentCourseFeeInstmnt> toCacheModel() {
				return _nullStudentCourseFeeInstmntCacheModel;
			}
		};

	private static CacheModel<StudentCourseFeeInstmnt> _nullStudentCourseFeeInstmntCacheModel =
		new CacheModel<StudentCourseFeeInstmnt>() {
			@Override
			public StudentCourseFeeInstmnt toEntityModel() {
				return _nullStudentCourseFeeInstmnt;
			}
		};
}