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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchCourseCertificateException;
import com.sambaash.platform.srv.model.CourseCertificate;
import com.sambaash.platform.srv.model.impl.CourseCertificateImpl;
import com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCertificatePersistence
 * @see CourseCertificateUtil
 * @generated
 */
public class CourseCertificatePersistenceImpl extends BasePersistenceImpl<CourseCertificate>
	implements CourseCertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseCertificateUtil} to access the course certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseCertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CourseCertificateModelImpl.GROUPID_COLUMN_BITMASK |
			CourseCertificateModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the course certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @return the range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course certificates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CourseCertificate> list = (List<CourseCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseCertificate courseCertificate : list) {
				if ((groupId != courseCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseCertificate>(list);
				}
				else {
					list = (List<CourseCertificate>)QueryUtil.list(q,
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
	 * Returns the first course certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByGroupId_First(groupId,
				orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the first course certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CourseCertificate> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the last course certificate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CourseCertificate> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course certificates before and after the current course certificate in the ordered set where groupId = &#63;.
	 *
	 * @param spCourseCertificateId the primary key of the current course certificate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate[] findByGroupId_PrevAndNext(
		long spCourseCertificateId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = findByPrimaryKey(spCourseCertificateId);

		Session session = null;

		try {
			session = openSession();

			CourseCertificate[] array = new CourseCertificateImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, courseCertificate,
					groupId, orderByComparator, true);

			array[1] = courseCertificate;

			array[2] = getByGroupId_PrevAndNext(session, courseCertificate,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseCertificate getByGroupId_PrevAndNext(Session session,
		CourseCertificate courseCertificate, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course certificates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (CourseCertificate courseCertificate : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseCertificate);
		}
	}

	/**
	 * Returns the number of course certificates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "courseCertificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseCertificateModelImpl.SPCOURSEID_COLUMN_BITMASK |
			CourseCertificateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course certificates where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course certificates where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @return the range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course certificates where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] { spCourseId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID;
			finderArgs = new Object[] {
					spCourseId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CourseCertificate> list = (List<CourseCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseCertificate courseCertificate : list) {
				if ((spCourseId != courseCertificate.getSpCourseId()) ||
						(groupId != courseCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseCertificate>(list);
				}
				else {
					list = (List<CourseCertificate>)QueryUtil.list(q,
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
	 * Returns the first course certificate in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the first course certificate in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseCertificate> list = findByCourseIdAndGroupId(spCourseId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course certificate in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the last course certificate in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<CourseCertificate> list = findByCourseIdAndGroupId(spCourseId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course certificates before and after the current course certificate in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseCertificateId the primary key of the current course certificate
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate[] findByCourseIdAndGroupId_PrevAndNext(
		long spCourseCertificateId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = findByPrimaryKey(spCourseCertificateId);

		Session session = null;

		try {
			session = openSession();

			CourseCertificate[] array = new CourseCertificateImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseCertificate, spCourseId, groupId, orderByComparator,
					true);

			array[1] = courseCertificate;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session,
					courseCertificate, spCourseId, groupId, orderByComparator,
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

	protected CourseCertificate getByCourseIdAndGroupId_PrevAndNext(
		Session session, CourseCertificate courseCertificate, long spCourseId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

		query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

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
			query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course certificates where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (CourseCertificate courseCertificate : findByCourseIdAndGroupId(
				spCourseId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(courseCertificate);
		}
	}

	/**
	 * Returns the number of course certificates where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCourseId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "courseCertificate.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "courseCertificate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID =
		new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCertificateIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID =
		new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED,
			CourseCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCertificateIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CourseCertificateModelImpl.SPCERTIFICATETID_COLUMN_BITMASK |
			CourseCertificateModelImpl.GROUPID_COLUMN_BITMASK |
			CourseCertificateModelImpl.SPCOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID = new FinderPath(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCertificateIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the course certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @return the matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId) throws SystemException {
		return findByCertificateIdAndGroupId(spCertificatetId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @return the range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end)
		throws SystemException {
		return findByCertificateIdAndGroupId(spCertificatetId, groupId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the course certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findByCertificateIdAndGroupId(
		long spCertificatetId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID;
			finderArgs = new Object[] { spCertificatetId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID;
			finderArgs = new Object[] {
					spCertificatetId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<CourseCertificate> list = (List<CourseCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CourseCertificate courseCertificate : list) {
				if ((spCertificatetId != courseCertificate.getSpCertificatetId()) ||
						(groupId != courseCertificate.getGroupId())) {
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

			query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCertificatetId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CourseCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseCertificate>(list);
				}
				else {
					list = (List<CourseCertificate>)QueryUtil.list(q,
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
	 * Returns the first course certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByCertificateIdAndGroupId_First(spCertificatetId,
				groupId, orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCertificatetId=");
		msg.append(spCertificatetId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the first course certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByCertificateIdAndGroupId_First(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CourseCertificate> list = findByCertificateIdAndGroupId(spCertificatetId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByCertificateIdAndGroupId_Last(spCertificatetId,
				groupId, orderByComparator);

		if (courseCertificate != null) {
			return courseCertificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCertificatetId=");
		msg.append(spCertificatetId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCourseCertificateException(msg.toString());
	}

	/**
	 * Returns the last course certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course certificate, or <code>null</code> if a matching course certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByCertificateIdAndGroupId_Last(
		long spCertificatetId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCertificateIdAndGroupId(spCertificatetId, groupId);

		if (count == 0) {
			return null;
		}

		List<CourseCertificate> list = findByCertificateIdAndGroupId(spCertificatetId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course certificates before and after the current course certificate in the ordered set where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseCertificateId the primary key of the current course certificate
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate[] findByCertificateIdAndGroupId_PrevAndNext(
		long spCourseCertificateId, long spCertificatetId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = findByPrimaryKey(spCourseCertificateId);

		Session session = null;

		try {
			session = openSession();

			CourseCertificate[] array = new CourseCertificateImpl[3];

			array[0] = getByCertificateIdAndGroupId_PrevAndNext(session,
					courseCertificate, spCertificatetId, groupId,
					orderByComparator, true);

			array[1] = courseCertificate;

			array[2] = getByCertificateIdAndGroupId_PrevAndNext(session,
					courseCertificate, spCertificatetId, groupId,
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

	protected CourseCertificate getByCertificateIdAndGroupId_PrevAndNext(
		Session session, CourseCertificate courseCertificate,
		long spCertificatetId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COURSECERTIFICATE_WHERE);

		query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

		query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

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
			query.append(CourseCertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCertificatetId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(courseCertificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CourseCertificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course certificates where spCertificatetId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCertificateIdAndGroupId(long spCertificatetId,
		long groupId) throws SystemException {
		for (CourseCertificate courseCertificate : findByCertificateIdAndGroupId(
				spCertificatetId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(courseCertificate);
		}
	}

	/**
	 * Returns the number of course certificates where spCertificatetId = &#63; and groupId = &#63;.
	 *
	 * @param spCertificatetId the sp certificatet ID
	 * @param groupId the group ID
	 * @return the number of matching course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCertificateIdAndGroupId(long spCertificatetId,
		long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCertificatetId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COURSECERTIFICATE_WHERE);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2);

			query.append(_FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCertificatetId);

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

	private static final String _FINDER_COLUMN_CERTIFICATEIDANDGROUPID_SPCERTIFICATETID_2 =
		"courseCertificate.spCertificatetId = ? AND ";
	private static final String _FINDER_COLUMN_CERTIFICATEIDANDGROUPID_GROUPID_2 =
		"courseCertificate.groupId = ?";

	public CourseCertificatePersistenceImpl() {
		setModelClass(CourseCertificate.class);
	}

	/**
	 * Caches the course certificate in the entity cache if it is enabled.
	 *
	 * @param courseCertificate the course certificate
	 */
	@Override
	public void cacheResult(CourseCertificate courseCertificate) {
		EntityCacheUtil.putResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateImpl.class, courseCertificate.getPrimaryKey(),
			courseCertificate);

		courseCertificate.resetOriginalValues();
	}

	/**
	 * Caches the course certificates in the entity cache if it is enabled.
	 *
	 * @param courseCertificates the course certificates
	 */
	@Override
	public void cacheResult(List<CourseCertificate> courseCertificates) {
		for (CourseCertificate courseCertificate : courseCertificates) {
			if (EntityCacheUtil.getResult(
						CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
						CourseCertificateImpl.class,
						courseCertificate.getPrimaryKey()) == null) {
				cacheResult(courseCertificate);
			}
			else {
				courseCertificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course certificates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseCertificateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseCertificateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course certificate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseCertificate courseCertificate) {
		EntityCacheUtil.removeResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateImpl.class, courseCertificate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CourseCertificate> courseCertificates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseCertificate courseCertificate : courseCertificates) {
			EntityCacheUtil.removeResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
				CourseCertificateImpl.class, courseCertificate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new course certificate with the primary key. Does not add the course certificate to the database.
	 *
	 * @param spCourseCertificateId the primary key for the new course certificate
	 * @return the new course certificate
	 */
	@Override
	public CourseCertificate create(long spCourseCertificateId) {
		CourseCertificate courseCertificate = new CourseCertificateImpl();

		courseCertificate.setNew(true);
		courseCertificate.setPrimaryKey(spCourseCertificateId);

		return courseCertificate;
	}

	/**
	 * Removes the course certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCourseCertificateId the primary key of the course certificate
	 * @return the course certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate remove(long spCourseCertificateId)
		throws NoSuchCourseCertificateException, SystemException {
		return remove((Serializable)spCourseCertificateId);
	}

	/**
	 * Removes the course certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course certificate
	 * @return the course certificate that was removed
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate remove(Serializable primaryKey)
		throws NoSuchCourseCertificateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseCertificate courseCertificate = (CourseCertificate)session.get(CourseCertificateImpl.class,
					primaryKey);

			if (courseCertificate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseCertificate);
		}
		catch (NoSuchCourseCertificateException nsee) {
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
	protected CourseCertificate removeImpl(CourseCertificate courseCertificate)
		throws SystemException {
		courseCertificate = toUnwrappedModel(courseCertificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseCertificate)) {
				courseCertificate = (CourseCertificate)session.get(CourseCertificateImpl.class,
						courseCertificate.getPrimaryKeyObj());
			}

			if (courseCertificate != null) {
				session.delete(courseCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseCertificate != null) {
			clearCache(courseCertificate);
		}

		return courseCertificate;
	}

	@Override
	public CourseCertificate updateImpl(
		com.sambaash.platform.srv.model.CourseCertificate courseCertificate)
		throws SystemException {
		courseCertificate = toUnwrappedModel(courseCertificate);

		boolean isNew = courseCertificate.isNew();

		CourseCertificateModelImpl courseCertificateModelImpl = (CourseCertificateModelImpl)courseCertificate;

		Session session = null;

		try {
			session = openSession();

			if (courseCertificate.isNew()) {
				session.save(courseCertificate);

				courseCertificate.setNew(false);
			}
			else {
				session.merge(courseCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseCertificateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((courseCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { courseCertificateModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((courseCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseCertificateModelImpl.getOriginalSpCourseId(),
						courseCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						courseCertificateModelImpl.getSpCourseId(),
						courseCertificateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}

			if ((courseCertificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						courseCertificateModelImpl.getOriginalSpCertificatetId(),
						courseCertificateModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID,
					args);

				args = new Object[] {
						courseCertificateModelImpl.getSpCertificatetId(),
						courseCertificateModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
			CourseCertificateImpl.class, courseCertificate.getPrimaryKey(),
			courseCertificate);

		return courseCertificate;
	}

	protected CourseCertificate toUnwrappedModel(
		CourseCertificate courseCertificate) {
		if (courseCertificate instanceof CourseCertificateImpl) {
			return courseCertificate;
		}

		CourseCertificateImpl courseCertificateImpl = new CourseCertificateImpl();

		courseCertificateImpl.setNew(courseCertificate.isNew());
		courseCertificateImpl.setPrimaryKey(courseCertificate.getPrimaryKey());

		courseCertificateImpl.setSpCourseCertificateId(courseCertificate.getSpCourseCertificateId());
		courseCertificateImpl.setGroupId(courseCertificate.getGroupId());
		courseCertificateImpl.setCompanyId(courseCertificate.getCompanyId());
		courseCertificateImpl.setUserId(courseCertificate.getUserId());
		courseCertificateImpl.setUserName(courseCertificate.getUserName());
		courseCertificateImpl.setCreateDate(courseCertificate.getCreateDate());
		courseCertificateImpl.setModifiedDate(courseCertificate.getModifiedDate());
		courseCertificateImpl.setSpCourseId(courseCertificate.getSpCourseId());
		courseCertificateImpl.setSpCertificatetId(courseCertificate.getSpCertificatetId());

		return courseCertificateImpl;
	}

	/**
	 * Returns the course certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course certificate
	 * @return the course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseCertificateException, SystemException {
		CourseCertificate courseCertificate = fetchByPrimaryKey(primaryKey);

		if (courseCertificate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseCertificate;
	}

	/**
	 * Returns the course certificate with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseCertificateException} if it could not be found.
	 *
	 * @param spCourseCertificateId the primary key of the course certificate
	 * @return the course certificate
	 * @throws com.sambaash.platform.srv.NoSuchCourseCertificateException if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate findByPrimaryKey(long spCourseCertificateId)
		throws NoSuchCourseCertificateException, SystemException {
		return findByPrimaryKey((Serializable)spCourseCertificateId);
	}

	/**
	 * Returns the course certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course certificate
	 * @return the course certificate, or <code>null</code> if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseCertificate courseCertificate = (CourseCertificate)EntityCacheUtil.getResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
				CourseCertificateImpl.class, primaryKey);

		if (courseCertificate == _nullCourseCertificate) {
			return null;
		}

		if (courseCertificate == null) {
			Session session = null;

			try {
				session = openSession();

				courseCertificate = (CourseCertificate)session.get(CourseCertificateImpl.class,
						primaryKey);

				if (courseCertificate != null) {
					cacheResult(courseCertificate);
				}
				else {
					EntityCacheUtil.putResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
						CourseCertificateImpl.class, primaryKey,
						_nullCourseCertificate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseCertificateModelImpl.ENTITY_CACHE_ENABLED,
					CourseCertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseCertificate;
	}

	/**
	 * Returns the course certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCourseCertificateId the primary key of the course certificate
	 * @return the course certificate, or <code>null</code> if a course certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseCertificate fetchByPrimaryKey(long spCourseCertificateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spCourseCertificateId);
	}

	/**
	 * Returns all the course certificates.
	 *
	 * @return the course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @return the range of course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course certificates
	 * @param end the upper bound of the range of course certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseCertificate> findAll(int start, int end,
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

		List<CourseCertificate> list = (List<CourseCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSECERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSECERTIFICATE;

				if (pagination) {
					sql = sql.concat(CourseCertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CourseCertificate>(list);
				}
				else {
					list = (List<CourseCertificate>)QueryUtil.list(q,
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
	 * Removes all the course certificates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseCertificate courseCertificate : findAll()) {
			remove(courseCertificate);
		}
	}

	/**
	 * Returns the number of course certificates.
	 *
	 * @return the number of course certificates
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

				Query q = session.createQuery(_SQL_COUNT_COURSECERTIFICATE);

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
	 * Initializes the course certificate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.CourseCertificate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseCertificate>> listenersList = new ArrayList<ModelListener<CourseCertificate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseCertificate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CourseCertificateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSECERTIFICATE = "SELECT courseCertificate FROM CourseCertificate courseCertificate";
	private static final String _SQL_SELECT_COURSECERTIFICATE_WHERE = "SELECT courseCertificate FROM CourseCertificate courseCertificate WHERE ";
	private static final String _SQL_COUNT_COURSECERTIFICATE = "SELECT COUNT(courseCertificate) FROM CourseCertificate courseCertificate";
	private static final String _SQL_COUNT_COURSECERTIFICATE_WHERE = "SELECT COUNT(courseCertificate) FROM CourseCertificate courseCertificate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseCertificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseCertificate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseCertificate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseCertificatePersistenceImpl.class);
	private static CourseCertificate _nullCourseCertificate = new CourseCertificateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseCertificate> toCacheModel() {
				return _nullCourseCertificateCacheModel;
			}
		};

	private static CacheModel<CourseCertificate> _nullCourseCertificateCacheModel =
		new CacheModel<CourseCertificate>() {
			@Override
			public CourseCertificate toEntityModel() {
				return _nullCourseCertificate;
			}
		};
}