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

import com.sambaash.platform.srv.NoSuchAssessmentException;
import com.sambaash.platform.srv.model.Assessment;
import com.sambaash.platform.srv.model.impl.AssessmentImpl;
import com.sambaash.platform.srv.model.impl.AssessmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the assessment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see AssessmentPersistence
 * @see AssessmentUtil
 * @generated
 */
public class AssessmentPersistenceImpl extends BasePersistenceImpl<Assessment>
	implements AssessmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AssessmentUtil} to access the assessment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AssessmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AssessmentModelImpl.GROUPID_COLUMN_BITMASK |
			AssessmentModelImpl.ASSESSMENTDESC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the assessments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the assessments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @return the range of matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the assessments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Assessment> list = (List<Assessment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Assessment assessment : list) {
				if ((groupId != assessment.getGroupId())) {
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

			query.append(_SQL_SELECT_ASSESSMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssessmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assessment>(list);
				}
				else {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first assessment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = fetchByGroupId_First(groupId, orderByComparator);

		if (assessment != null) {
			return assessment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssessmentException(msg.toString());
	}

	/**
	 * Returns the first assessment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Assessment> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last assessment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = fetchByGroupId_Last(groupId, orderByComparator);

		if (assessment != null) {
			return assessment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssessmentException(msg.toString());
	}

	/**
	 * Returns the last assessment in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Assessment> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the assessments before and after the current assessment in the ordered set where groupId = &#63;.
	 *
	 * @param spAssessmentId the primary key of the current assessment
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment[] findByGroupId_PrevAndNext(long spAssessmentId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = findByPrimaryKey(spAssessmentId);

		Session session = null;

		try {
			session = openSession();

			Assessment[] array = new AssessmentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, assessment, groupId,
					orderByComparator, true);

			array[1] = assessment;

			array[2] = getByGroupId_PrevAndNext(session, assessment, groupId,
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

	protected Assessment getByGroupId_PrevAndNext(Session session,
		Assessment assessment, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSESSMENT_WHERE);

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
			query.append(AssessmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(assessment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Assessment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the assessments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Assessment assessment : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(assessment);
		}
	}

	/**
	 * Returns the number of assessments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching assessments
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

			query.append(_SQL_COUNT_ASSESSMENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "assessment.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDMODULEID =
		new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndModuleId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID =
		new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, AssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndModuleId",
			new String[] { Long.class.getName(), Long.class.getName() },
			AssessmentModelImpl.GROUPID_COLUMN_BITMASK |
			AssessmentModelImpl.SPMODULEID_COLUMN_BITMASK |
			AssessmentModelImpl.ASSESSMENTDESC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID = new FinderPath(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndModuleId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the assessments where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @return the matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupIdAndModuleId(long groupId,
		long spModuleId) throws SystemException {
		return findByGroupIdAndModuleId(groupId, spModuleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the assessments where groupId = &#63; and spModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @return the range of matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupIdAndModuleId(long groupId,
		long spModuleId, int start, int end) throws SystemException {
		return findByGroupIdAndModuleId(groupId, spModuleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the assessments where groupId = &#63; and spModuleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findByGroupIdAndModuleId(long groupId,
		long spModuleId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID;
			finderArgs = new Object[] { groupId, spModuleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDMODULEID;
			finderArgs = new Object[] {
					groupId, spModuleId,
					
					start, end, orderByComparator
				};
		}

		List<Assessment> list = (List<Assessment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Assessment assessment : list) {
				if ((groupId != assessment.getGroupId()) ||
						(spModuleId != assessment.getSpModuleId())) {
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

			query.append(_SQL_SELECT_ASSESSMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AssessmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spModuleId);

				if (!pagination) {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assessment>(list);
				}
				else {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByGroupIdAndModuleId_First(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = fetchByGroupIdAndModuleId_First(groupId,
				spModuleId, orderByComparator);

		if (assessment != null) {
			return assessment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spModuleId=");
		msg.append(spModuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssessmentException(msg.toString());
	}

	/**
	 * Returns the first assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching assessment, or <code>null</code> if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByGroupIdAndModuleId_First(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Assessment> list = findByGroupIdAndModuleId(groupId, spModuleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByGroupIdAndModuleId_Last(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = fetchByGroupIdAndModuleId_Last(groupId,
				spModuleId, orderByComparator);

		if (assessment != null) {
			return assessment;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spModuleId=");
		msg.append(spModuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAssessmentException(msg.toString());
	}

	/**
	 * Returns the last assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching assessment, or <code>null</code> if a matching assessment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByGroupIdAndModuleId_Last(long groupId,
		long spModuleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndModuleId(groupId, spModuleId);

		if (count == 0) {
			return null;
		}

		List<Assessment> list = findByGroupIdAndModuleId(groupId, spModuleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the assessments before and after the current assessment in the ordered set where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param spAssessmentId the primary key of the current assessment
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment[] findByGroupIdAndModuleId_PrevAndNext(
		long spAssessmentId, long groupId, long spModuleId,
		OrderByComparator orderByComparator)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = findByPrimaryKey(spAssessmentId);

		Session session = null;

		try {
			session = openSession();

			Assessment[] array = new AssessmentImpl[3];

			array[0] = getByGroupIdAndModuleId_PrevAndNext(session, assessment,
					groupId, spModuleId, orderByComparator, true);

			array[1] = assessment;

			array[2] = getByGroupIdAndModuleId_PrevAndNext(session, assessment,
					groupId, spModuleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Assessment getByGroupIdAndModuleId_PrevAndNext(Session session,
		Assessment assessment, long groupId, long spModuleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ASSESSMENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

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
			query.append(AssessmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(spModuleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(assessment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Assessment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the assessments where groupId = &#63; and spModuleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndModuleId(long groupId, long spModuleId)
		throws SystemException {
		for (Assessment assessment : findByGroupIdAndModuleId(groupId,
				spModuleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(assessment);
		}
	}

	/**
	 * Returns the number of assessments where groupId = &#63; and spModuleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spModuleId the sp module ID
	 * @return the number of matching assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndModuleId(long groupId, long spModuleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID;

		Object[] finderArgs = new Object[] { groupId, spModuleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ASSESSMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spModuleId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDMODULEID_GROUPID_2 = "assessment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDMODULEID_SPMODULEID_2 = "assessment.spModuleId = ?";

	public AssessmentPersistenceImpl() {
		setModelClass(Assessment.class);
	}

	/**
	 * Caches the assessment in the entity cache if it is enabled.
	 *
	 * @param assessment the assessment
	 */
	@Override
	public void cacheResult(Assessment assessment) {
		EntityCacheUtil.putResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentImpl.class, assessment.getPrimaryKey(), assessment);

		assessment.resetOriginalValues();
	}

	/**
	 * Caches the assessments in the entity cache if it is enabled.
	 *
	 * @param assessments the assessments
	 */
	@Override
	public void cacheResult(List<Assessment> assessments) {
		for (Assessment assessment : assessments) {
			if (EntityCacheUtil.getResult(
						AssessmentModelImpl.ENTITY_CACHE_ENABLED,
						AssessmentImpl.class, assessment.getPrimaryKey()) == null) {
				cacheResult(assessment);
			}
			else {
				assessment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all assessments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AssessmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AssessmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the assessment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Assessment assessment) {
		EntityCacheUtil.removeResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentImpl.class, assessment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Assessment> assessments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Assessment assessment : assessments) {
			EntityCacheUtil.removeResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
				AssessmentImpl.class, assessment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new assessment with the primary key. Does not add the assessment to the database.
	 *
	 * @param spAssessmentId the primary key for the new assessment
	 * @return the new assessment
	 */
	@Override
	public Assessment create(long spAssessmentId) {
		Assessment assessment = new AssessmentImpl();

		assessment.setNew(true);
		assessment.setPrimaryKey(spAssessmentId);

		return assessment;
	}

	/**
	 * Removes the assessment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAssessmentId the primary key of the assessment
	 * @return the assessment that was removed
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment remove(long spAssessmentId)
		throws NoSuchAssessmentException, SystemException {
		return remove((Serializable)spAssessmentId);
	}

	/**
	 * Removes the assessment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the assessment
	 * @return the assessment that was removed
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment remove(Serializable primaryKey)
		throws NoSuchAssessmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Assessment assessment = (Assessment)session.get(AssessmentImpl.class,
					primaryKey);

			if (assessment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAssessmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(assessment);
		}
		catch (NoSuchAssessmentException nsee) {
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
	protected Assessment removeImpl(Assessment assessment)
		throws SystemException {
		assessment = toUnwrappedModel(assessment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(assessment)) {
				assessment = (Assessment)session.get(AssessmentImpl.class,
						assessment.getPrimaryKeyObj());
			}

			if (assessment != null) {
				session.delete(assessment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (assessment != null) {
			clearCache(assessment);
		}

		return assessment;
	}

	@Override
	public Assessment updateImpl(
		com.sambaash.platform.srv.model.Assessment assessment)
		throws SystemException {
		assessment = toUnwrappedModel(assessment);

		boolean isNew = assessment.isNew();

		AssessmentModelImpl assessmentModelImpl = (AssessmentModelImpl)assessment;

		Session session = null;

		try {
			session = openSession();

			if (assessment.isNew()) {
				session.save(assessment);

				assessment.setNew(false);
			}
			else {
				session.merge(assessment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AssessmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((assessmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assessmentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { assessmentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((assessmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						assessmentModelImpl.getOriginalGroupId(),
						assessmentModelImpl.getOriginalSpModuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID,
					args);

				args = new Object[] {
						assessmentModelImpl.getGroupId(),
						assessmentModelImpl.getSpModuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDMODULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDMODULEID,
					args);
			}
		}

		EntityCacheUtil.putResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
			AssessmentImpl.class, assessment.getPrimaryKey(), assessment);

		return assessment;
	}

	protected Assessment toUnwrappedModel(Assessment assessment) {
		if (assessment instanceof AssessmentImpl) {
			return assessment;
		}

		AssessmentImpl assessmentImpl = new AssessmentImpl();

		assessmentImpl.setNew(assessment.isNew());
		assessmentImpl.setPrimaryKey(assessment.getPrimaryKey());

		assessmentImpl.setSpAssessmentId(assessment.getSpAssessmentId());
		assessmentImpl.setGroupId(assessment.getGroupId());
		assessmentImpl.setCompanyId(assessment.getCompanyId());
		assessmentImpl.setUserId(assessment.getUserId());
		assessmentImpl.setUserName(assessment.getUserName());
		assessmentImpl.setCreateDate(assessment.getCreateDate());
		assessmentImpl.setModifiedDate(assessment.getModifiedDate());
		assessmentImpl.setSpModuleId(assessment.getSpModuleId());
		assessmentImpl.setAssessmentDesc(assessment.getAssessmentDesc());
		assessmentImpl.setAssessmentType(assessment.getAssessmentType());
		assessmentImpl.setAssessmentMethod(assessment.getAssessmentMethod());
		assessmentImpl.setAssessmentMode(assessment.getAssessmentMode());
		assessmentImpl.setLocationType(assessment.getLocationType());
		assessmentImpl.setEligibility(assessment.getEligibility());
		assessmentImpl.setGradingType(assessment.getGradingType());
		assessmentImpl.setMaximumMarks(assessment.getMaximumMarks());
		assessmentImpl.setPassingMarks(assessment.getPassingMarks());

		return assessmentImpl;
	}

	/**
	 * Returns the assessment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the assessment
	 * @return the assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAssessmentException, SystemException {
		Assessment assessment = fetchByPrimaryKey(primaryKey);

		if (assessment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAssessmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return assessment;
	}

	/**
	 * Returns the assessment with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchAssessmentException} if it could not be found.
	 *
	 * @param spAssessmentId the primary key of the assessment
	 * @return the assessment
	 * @throws com.sambaash.platform.srv.NoSuchAssessmentException if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment findByPrimaryKey(long spAssessmentId)
		throws NoSuchAssessmentException, SystemException {
		return findByPrimaryKey((Serializable)spAssessmentId);
	}

	/**
	 * Returns the assessment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the assessment
	 * @return the assessment, or <code>null</code> if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Assessment assessment = (Assessment)EntityCacheUtil.getResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
				AssessmentImpl.class, primaryKey);

		if (assessment == _nullAssessment) {
			return null;
		}

		if (assessment == null) {
			Session session = null;

			try {
				session = openSession();

				assessment = (Assessment)session.get(AssessmentImpl.class,
						primaryKey);

				if (assessment != null) {
					cacheResult(assessment);
				}
				else {
					EntityCacheUtil.putResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
						AssessmentImpl.class, primaryKey, _nullAssessment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AssessmentModelImpl.ENTITY_CACHE_ENABLED,
					AssessmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return assessment;
	}

	/**
	 * Returns the assessment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAssessmentId the primary key of the assessment
	 * @return the assessment, or <code>null</code> if a assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Assessment fetchByPrimaryKey(long spAssessmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAssessmentId);
	}

	/**
	 * Returns all the assessments.
	 *
	 * @return the assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the assessments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @return the range of assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the assessments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of assessments
	 * @param end the upper bound of the range of assessments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Assessment> findAll(int start, int end,
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

		List<Assessment> list = (List<Assessment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ASSESSMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ASSESSMENT;

				if (pagination) {
					sql = sql.concat(AssessmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Assessment>(list);
				}
				else {
					list = (List<Assessment>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the assessments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Assessment assessment : findAll()) {
			remove(assessment);
		}
	}

	/**
	 * Returns the number of assessments.
	 *
	 * @return the number of assessments
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

				Query q = session.createQuery(_SQL_COUNT_ASSESSMENT);

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
	 * Initializes the assessment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Assessment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Assessment>> listenersList = new ArrayList<ModelListener<Assessment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Assessment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AssessmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ASSESSMENT = "SELECT assessment FROM Assessment assessment";
	private static final String _SQL_SELECT_ASSESSMENT_WHERE = "SELECT assessment FROM Assessment assessment WHERE ";
	private static final String _SQL_COUNT_ASSESSMENT = "SELECT COUNT(assessment) FROM Assessment assessment";
	private static final String _SQL_COUNT_ASSESSMENT_WHERE = "SELECT COUNT(assessment) FROM Assessment assessment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "assessment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Assessment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Assessment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AssessmentPersistenceImpl.class);
	private static Assessment _nullAssessment = new AssessmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Assessment> toCacheModel() {
				return _nullAssessmentCacheModel;
			}
		};

	private static CacheModel<Assessment> _nullAssessmentCacheModel = new CacheModel<Assessment>() {
			@Override
			public Assessment toEntityModel() {
				return _nullAssessment;
			}
		};
}