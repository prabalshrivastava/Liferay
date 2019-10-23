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

import com.sambaash.platform.srv.NoSuchFeeDetailsException;
import com.sambaash.platform.srv.model.FeeDetails;
import com.sambaash.platform.srv.model.impl.FeeDetailsImpl;
import com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the fee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeDetailsPersistence
 * @see FeeDetailsUtil
 * @generated
 */
public class FeeDetailsPersistenceImpl extends BasePersistenceImpl<FeeDetails>
	implements FeeDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeeDetailsUtil} to access the fee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeeDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FeeDetailsModelImpl.GROUPID_COLUMN_BITMASK |
			FeeDetailsModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fee detailses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByGroupId(long groupId, int start, int end,
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

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeDetails feeDetails : list) {
				if ((groupId != feeDetails.getGroupId())) {
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

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fee details in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByGroupId_First(groupId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first fee details in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FeeDetails> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee details in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByGroupId_Last(groupId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last fee details in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FeeDetails> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee detailses before and after the current fee details in the ordered set where groupId = &#63;.
	 *
	 * @param spFeeDetailsId the primary key of the current fee details
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails[] findByGroupId_PrevAndNext(long spFeeDetailsId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByPrimaryKey(spFeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			FeeDetails[] array = new FeeDetailsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, feeDetails, groupId,
					orderByComparator, true);

			array[1] = feeDetails;

			array[2] = getByGroupId_PrevAndNext(session, feeDetails, groupId,
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

	protected FeeDetails getByGroupId_PrevAndNext(Session session,
		FeeDetails feeDetails, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDETAILS_WHERE);

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
			query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee detailses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (FeeDetails feeDetails : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching fee detailses
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

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "feeDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFundIdAndSpCourseId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFundIdAndSpCourseId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FeeDetailsModelImpl.FUNDID_COLUMN_BITMASK |
			FeeDetailsModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FeeDetailsModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNDIDANDSPCOURSEID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFundIdAndSpCourseId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @return the matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundIdAndSpCourseId(long fundId,
		long spCourseId) throws SystemException {
		return findByFundIdAndSpCourseId(fundId, spCourseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundIdAndSpCourseId(long fundId,
		long spCourseId, int start, int end) throws SystemException {
		return findByFundIdAndSpCourseId(fundId, spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses where fundId = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundIdAndSpCourseId(long fundId,
		long spCourseId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID;
			finderArgs = new Object[] { fundId, spCourseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID;
			finderArgs = new Object[] {
					fundId, spCourseId,
					
					start, end, orderByComparator
				};
		}

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeDetails feeDetails : list) {
				if ((fundId != feeDetails.getFundId()) ||
						(spCourseId != feeDetails.getSpCourseId())) {
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

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_FUNDID_2);

			query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFundIdAndSpCourseId_First(long fundId,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFundIdAndSpCourseId_First(fundId,
				spCourseId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundId=");
		msg.append(fundId);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFundIdAndSpCourseId_First(long fundId,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FeeDetails> list = findByFundIdAndSpCourseId(fundId, spCourseId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFundIdAndSpCourseId_Last(long fundId,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFundIdAndSpCourseId_Last(fundId,
				spCourseId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundId=");
		msg.append(fundId);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFundIdAndSpCourseId_Last(long fundId,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFundIdAndSpCourseId(fundId, spCourseId);

		if (count == 0) {
			return null;
		}

		List<FeeDetails> list = findByFundIdAndSpCourseId(fundId, spCourseId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee detailses before and after the current fee details in the ordered set where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param spFeeDetailsId the primary key of the current fee details
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails[] findByFundIdAndSpCourseId_PrevAndNext(
		long spFeeDetailsId, long fundId, long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByPrimaryKey(spFeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			FeeDetails[] array = new FeeDetailsImpl[3];

			array[0] = getByFundIdAndSpCourseId_PrevAndNext(session,
					feeDetails, fundId, spCourseId, orderByComparator, true);

			array[1] = feeDetails;

			array[2] = getByFundIdAndSpCourseId_PrevAndNext(session,
					feeDetails, fundId, spCourseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FeeDetails getByFundIdAndSpCourseId_PrevAndNext(Session session,
		FeeDetails feeDetails, long fundId, long spCourseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDETAILS_WHERE);

		query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_FUNDID_2);

		query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_SPCOURSEID_2);

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
			query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fundId);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee detailses where fundId = &#63; and spCourseId = &#63; from the database.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws SystemException {
		for (FeeDetails feeDetails : findByFundIdAndSpCourseId(fundId,
				spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses where fundId = &#63; and spCourseId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param spCourseId the sp course ID
	 * @return the number of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFundIdAndSpCourseId(long fundId, long spCourseId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FUNDIDANDSPCOURSEID;

		Object[] finderArgs = new Object[] { fundId, spCourseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_FUNDID_2);

			query.append(_FINDER_COLUMN_FUNDIDANDSPCOURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_FUNDIDANDSPCOURSEID_FUNDID_2 = "feeDetails.fundId = ? AND ";
	private static final String _FINDER_COLUMN_FUNDIDANDSPCOURSEID_SPCOURSEID_2 = "feeDetails.spCourseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFundId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFundId",
			new String[] { Long.class.getName() },
			FeeDetailsModelImpl.FUNDID_COLUMN_BITMASK |
			FeeDetailsModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNDID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFundId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fee detailses where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @return the matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundId(long fundId) throws SystemException {
		return findByFundId(fundId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses where fundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundId the fund ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundId(long fundId, int start, int end)
		throws SystemException {
		return findByFundId(fundId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses where fundId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fundId the fund ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFundId(long fundId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDID;
			finderArgs = new Object[] { fundId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNDID;
			finderArgs = new Object[] { fundId, start, end, orderByComparator };
		}

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeDetails feeDetails : list) {
				if ((fundId != feeDetails.getFundId())) {
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

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDID_FUNDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

				if (!pagination) {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fee details in the ordered set where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFundId_First(long fundId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFundId_First(fundId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundId=");
		msg.append(fundId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first fee details in the ordered set where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFundId_First(long fundId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FeeDetails> list = findByFundId(fundId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee details in the ordered set where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFundId_Last(long fundId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFundId_Last(fundId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fundId=");
		msg.append(fundId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last fee details in the ordered set where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFundId_Last(long fundId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFundId(fundId);

		if (count == 0) {
			return null;
		}

		List<FeeDetails> list = findByFundId(fundId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee detailses before and after the current fee details in the ordered set where fundId = &#63;.
	 *
	 * @param spFeeDetailsId the primary key of the current fee details
	 * @param fundId the fund ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails[] findByFundId_PrevAndNext(long spFeeDetailsId,
		long fundId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByPrimaryKey(spFeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			FeeDetails[] array = new FeeDetailsImpl[3];

			array[0] = getByFundId_PrevAndNext(session, feeDetails, fundId,
					orderByComparator, true);

			array[1] = feeDetails;

			array[2] = getByFundId_PrevAndNext(session, feeDetails, fundId,
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

	protected FeeDetails getByFundId_PrevAndNext(Session session,
		FeeDetails feeDetails, long fundId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDETAILS_WHERE);

		query.append(_FINDER_COLUMN_FUNDID_FUNDID_2);

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
			query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fundId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee detailses where fundId = &#63; from the database.
	 *
	 * @param fundId the fund ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFundId(long fundId) throws SystemException {
		for (FeeDetails feeDetails : findByFundId(fundId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses where fundId = &#63;.
	 *
	 * @param fundId the fund ID
	 * @return the number of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFundId(long fundId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FUNDID;

		Object[] finderArgs = new Object[] { fundId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDID_FUNDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

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

	private static final String _FINDER_COLUMN_FUNDID_FUNDID_2 = "feeDetails.fundId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FeeDetailsModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FeeDetailsModelImpl.GROUPID_COLUMN_BITMASK |
			FeeDetailsModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCourseIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByCourseIdAndGroupId(long spCourseId,
		long groupId) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByCourseIdAndGroupId(long spCourseId,
		long groupId, int start, int end) throws SystemException {
		return findByCourseIdAndGroupId(spCourseId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByCourseIdAndGroupId(long spCourseId,
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

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeDetails feeDetails : list) {
				if ((spCourseId != feeDetails.getSpCourseId()) ||
						(groupId != feeDetails.getGroupId())) {
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

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
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
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByCourseIdAndGroupId_First(spCourseId,
				groupId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByCourseIdAndGroupId_First(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FeeDetails> list = findByCourseIdAndGroupId(spCourseId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByCourseIdAndGroupId_Last(spCourseId,
				groupId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCourseId=");
		msg.append(spCourseId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByCourseIdAndGroupId_Last(long spCourseId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCourseIdAndGroupId(spCourseId, groupId);

		if (count == 0) {
			return null;
		}

		List<FeeDetails> list = findByCourseIdAndGroupId(spCourseId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee detailses before and after the current fee details in the ordered set where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spFeeDetailsId the primary key of the current fee details
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails[] findByCourseIdAndGroupId_PrevAndNext(
		long spFeeDetailsId, long spCourseId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByPrimaryKey(spFeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			FeeDetails[] array = new FeeDetailsImpl[3];

			array[0] = getByCourseIdAndGroupId_PrevAndNext(session, feeDetails,
					spCourseId, groupId, orderByComparator, true);

			array[1] = feeDetails;

			array[2] = getByCourseIdAndGroupId_PrevAndNext(session, feeDetails,
					spCourseId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FeeDetails getByCourseIdAndGroupId_PrevAndNext(Session session,
		FeeDetails feeDetails, long spCourseId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDETAILS_WHERE);

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
			query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCourseId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee detailses where spCourseId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws SystemException {
		for (FeeDetails feeDetails : findByCourseIdAndGroupId(spCourseId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses where spCourseId = &#63; and groupId = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param groupId the group ID
	 * @return the number of matching fee detailses
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

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

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

	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_SPCOURSEID_2 = "feeDetails.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDANDGROUPID_GROUPID_2 = "feeDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FEETYPEANDCOURSEID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFeeTypeAndCourseId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEETYPEANDCOURSEID =
		new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFeeTypeAndCourseId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FeeDetailsModelImpl.FEETYPE_COLUMN_BITMASK |
			FeeDetailsModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FeeDetailsModelImpl.DISPLAYORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FEETYPEANDCOURSEID = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFeeTypeAndCourseId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @return the matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFeeTypeAndCourseId(long feeType,
		long spCourseId) throws SystemException {
		return findByFeeTypeAndCourseId(feeType, spCourseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFeeTypeAndCourseId(long feeType,
		long spCourseId, int start, int end) throws SystemException {
		return findByFeeTypeAndCourseId(feeType, spCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses where feeType = &#63; and spCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findByFeeTypeAndCourseId(long feeType,
		long spCourseId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEETYPEANDCOURSEID;
			finderArgs = new Object[] { feeType, spCourseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FEETYPEANDCOURSEID;
			finderArgs = new Object[] {
					feeType, spCourseId,
					
					start, end, orderByComparator
				};
		}

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeDetails feeDetails : list) {
				if ((feeType != feeDetails.getFeeType()) ||
						(spCourseId != feeDetails.getSpCourseId())) {
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

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_FEETYPE_2);

			query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_SPCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(feeType);

				qPos.add(spCourseId);

				if (!pagination) {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFeeTypeAndCourseId_First(long feeType,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFeeTypeAndCourseId_First(feeType,
				spCourseId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("feeType=");
		msg.append(feeType);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the first fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFeeTypeAndCourseId_First(long feeType,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FeeDetails> list = findByFeeTypeAndCourseId(feeType, spCourseId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByFeeTypeAndCourseId_Last(long feeType,
		long spCourseId, OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByFeeTypeAndCourseId_Last(feeType,
				spCourseId, orderByComparator);

		if (feeDetails != null) {
			return feeDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("feeType=");
		msg.append(feeType);

		msg.append(", spCourseId=");
		msg.append(spCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeDetailsException(msg.toString());
	}

	/**
	 * Returns the last fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByFeeTypeAndCourseId_Last(long feeType,
		long spCourseId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFeeTypeAndCourseId(feeType, spCourseId);

		if (count == 0) {
			return null;
		}

		List<FeeDetails> list = findByFeeTypeAndCourseId(feeType, spCourseId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee detailses before and after the current fee details in the ordered set where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param spFeeDetailsId the primary key of the current fee details
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails[] findByFeeTypeAndCourseId_PrevAndNext(
		long spFeeDetailsId, long feeType, long spCourseId,
		OrderByComparator orderByComparator)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByPrimaryKey(spFeeDetailsId);

		Session session = null;

		try {
			session = openSession();

			FeeDetails[] array = new FeeDetailsImpl[3];

			array[0] = getByFeeTypeAndCourseId_PrevAndNext(session, feeDetails,
					feeType, spCourseId, orderByComparator, true);

			array[1] = feeDetails;

			array[2] = getByFeeTypeAndCourseId_PrevAndNext(session, feeDetails,
					feeType, spCourseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FeeDetails getByFeeTypeAndCourseId_PrevAndNext(Session session,
		FeeDetails feeDetails, long feeType, long spCourseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDETAILS_WHERE);

		query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_FEETYPE_2);

		query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_SPCOURSEID_2);

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
			query.append(FeeDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(feeType);

		qPos.add(spCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee detailses where feeType = &#63; and spCourseId = &#63; from the database.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws SystemException {
		for (FeeDetails feeDetails : findByFeeTypeAndCourseId(feeType,
				spCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses where feeType = &#63; and spCourseId = &#63;.
	 *
	 * @param feeType the fee type
	 * @param spCourseId the sp course ID
	 * @return the number of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFeeTypeAndCourseId(long feeType, long spCourseId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FEETYPEANDCOURSEID;

		Object[] finderArgs = new Object[] { feeType, spCourseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_FEETYPE_2);

			query.append(_FINDER_COLUMN_FEETYPEANDCOURSEID_SPCOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(feeType);

				qPos.add(spCourseId);

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

	private static final String _FINDER_COLUMN_FEETYPEANDCOURSEID_FEETYPE_2 = "feeDetails.feeType = ? AND ";
	private static final String _FINDER_COLUMN_FEETYPEANDCOURSEID_SPCOURSEID_2 = "feeDetails.spCourseId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FUNDIDFEETYPE = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByfundIdFeeType",
			new String[] { Long.class.getName(), Long.class.getName() },
			FeeDetailsModelImpl.FUNDID_COLUMN_BITMASK |
			FeeDetailsModelImpl.FEETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNDIDFEETYPE = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfundIdFeeType",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the fee details where fundId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	 *
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByfundIdFeeType(long fundId, long feeType)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByfundIdFeeType(fundId, feeType);

		if (feeDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("fundId=");
			msg.append(fundId);

			msg.append(", feeType=");
			msg.append(feeType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeeDetailsException(msg.toString());
		}

		return feeDetails;
	}

	/**
	 * Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByfundIdFeeType(long fundId, long feeType)
		throws SystemException {
		return fetchByfundIdFeeType(fundId, feeType, true);
	}

	/**
	 * Returns the fee details where fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByfundIdFeeType(long fundId, long feeType,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { fundId, feeType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
					finderArgs, this);
		}

		if (result instanceof FeeDetails) {
			FeeDetails feeDetails = (FeeDetails)result;

			if ((fundId != feeDetails.getFundId()) ||
					(feeType != feeDetails.getFeeType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDIDFEETYPE_FUNDID_2);

			query.append(_FINDER_COLUMN_FUNDIDFEETYPE_FEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

				qPos.add(feeType);

				List<FeeDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FeeDetailsPersistenceImpl.fetchByfundIdFeeType(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FeeDetails feeDetails = list.get(0);

					result = feeDetails;

					cacheResult(feeDetails);

					if ((feeDetails.getFundId() != fundId) ||
							(feeDetails.getFeeType() != feeType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
							finderArgs, feeDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
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
			return (FeeDetails)result;
		}
	}

	/**
	 * Removes the fee details where fundId = &#63; and feeType = &#63; from the database.
	 *
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the fee details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails removeByfundIdFeeType(long fundId, long feeType)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findByfundIdFeeType(fundId, feeType);

		return remove(feeDetails);
	}

	/**
	 * Returns the number of fee detailses where fundId = &#63; and feeType = &#63;.
	 *
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the number of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfundIdFeeType(long fundId, long feeType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FUNDIDFEETYPE;

		Object[] finderArgs = new Object[] { fundId, feeType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_FUNDIDFEETYPE_FUNDID_2);

			query.append(_FINDER_COLUMN_FUNDIDFEETYPE_FEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fundId);

				qPos.add(feeType);

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

	private static final String _FINDER_COLUMN_FUNDIDFEETYPE_FUNDID_2 = "feeDetails.fundId = ? AND ";
	private static final String _FINDER_COLUMN_FUNDIDFEETYPE_FEETYPE_2 = "feeDetails.feeType = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, FeeDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBycourseIdFundIdFeeType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			FeeDetailsModelImpl.SPCOURSEID_COLUMN_BITMASK |
			FeeDetailsModelImpl.FUNDID_COLUMN_BITMASK |
			FeeDetailsModelImpl.FEETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE = new FinderPath(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycourseIdFundIdFeeType",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	 *
	 * @param spCourseId the sp course ID
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the matching fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findBycourseIdFundIdFeeType(long spCourseId, long fundId,
		long feeType) throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchBycourseIdFundIdFeeType(spCourseId,
				fundId, feeType);

		if (feeDetails == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spCourseId=");
			msg.append(spCourseId);

			msg.append(", fundId=");
			msg.append(fundId);

			msg.append(", feeType=");
			msg.append(feeType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeeDetailsException(msg.toString());
		}

		return feeDetails;
	}

	/**
	 * Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchBycourseIdFundIdFeeType(long spCourseId,
		long fundId, long feeType) throws SystemException {
		return fetchBycourseIdFundIdFeeType(spCourseId, fundId, feeType, true);
	}

	/**
	 * Returns the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spCourseId the sp course ID
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching fee details, or <code>null</code> if a matching fee details could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchBycourseIdFundIdFeeType(long spCourseId,
		long fundId, long feeType, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { spCourseId, fundId, feeType };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
					finderArgs, this);
		}

		if (result instanceof FeeDetails) {
			FeeDetails feeDetails = (FeeDetails)result;

			if ((spCourseId != feeDetails.getSpCourseId()) ||
					(fundId != feeDetails.getFundId()) ||
					(feeType != feeDetails.getFeeType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FUNDID_2);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(fundId);

				qPos.add(feeType);

				List<FeeDetails> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FeeDetailsPersistenceImpl.fetchBycourseIdFundIdFeeType(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FeeDetails feeDetails = list.get(0);

					result = feeDetails;

					cacheResult(feeDetails);

					if ((feeDetails.getSpCourseId() != spCourseId) ||
							(feeDetails.getFundId() != fundId) ||
							(feeDetails.getFeeType() != feeType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
							finderArgs, feeDetails);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
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
			return (FeeDetails)result;
		}
	}

	/**
	 * Removes the fee details where spCourseId = &#63; and fundId = &#63; and feeType = &#63; from the database.
	 *
	 * @param spCourseId the sp course ID
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the fee details that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails removeBycourseIdFundIdFeeType(long spCourseId,
		long fundId, long feeType)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = findBycourseIdFundIdFeeType(spCourseId, fundId,
				feeType);

		return remove(feeDetails);
	}

	/**
	 * Returns the number of fee detailses where spCourseId = &#63; and fundId = &#63; and feeType = &#63;.
	 *
	 * @param spCourseId the sp course ID
	 * @param fundId the fund ID
	 * @param feeType the fee type
	 * @return the number of matching fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycourseIdFundIdFeeType(long spCourseId, long fundId,
		long feeType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE;

		Object[] finderArgs = new Object[] { spCourseId, fundId, feeType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FEEDETAILS_WHERE);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_SPCOURSEID_2);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FUNDID_2);

			query.append(_FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FEETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCourseId);

				qPos.add(fundId);

				qPos.add(feeType);

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

	private static final String _FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_SPCOURSEID_2 =
		"feeDetails.spCourseId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FUNDID_2 = "feeDetails.fundId = ? AND ";
	private static final String _FINDER_COLUMN_COURSEIDFUNDIDFEETYPE_FEETYPE_2 = "feeDetails.feeType = ?";

	public FeeDetailsPersistenceImpl() {
		setModelClass(FeeDetails.class);
	}

	/**
	 * Caches the fee details in the entity cache if it is enabled.
	 *
	 * @param feeDetails the fee details
	 */
	@Override
	public void cacheResult(FeeDetails feeDetails) {
		EntityCacheUtil.putResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsImpl.class, feeDetails.getPrimaryKey(), feeDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
			new Object[] { feeDetails.getFundId(), feeDetails.getFeeType() },
			feeDetails);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
			new Object[] {
				feeDetails.getSpCourseId(), feeDetails.getFundId(),
				feeDetails.getFeeType()
			}, feeDetails);

		feeDetails.resetOriginalValues();
	}

	/**
	 * Caches the fee detailses in the entity cache if it is enabled.
	 *
	 * @param feeDetailses the fee detailses
	 */
	@Override
	public void cacheResult(List<FeeDetails> feeDetailses) {
		for (FeeDetails feeDetails : feeDetailses) {
			if (EntityCacheUtil.getResult(
						FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						FeeDetailsImpl.class, feeDetails.getPrimaryKey()) == null) {
				cacheResult(feeDetails);
			}
			else {
				feeDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fee detailses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeeDetailsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeeDetailsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fee details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeeDetails feeDetails) {
		EntityCacheUtil.removeResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsImpl.class, feeDetails.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(feeDetails);
	}

	@Override
	public void clearCache(List<FeeDetails> feeDetailses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FeeDetails feeDetails : feeDetailses) {
			EntityCacheUtil.removeResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				FeeDetailsImpl.class, feeDetails.getPrimaryKey());

			clearUniqueFindersCache(feeDetails);
		}
	}

	protected void cacheUniqueFindersCache(FeeDetails feeDetails) {
		if (feeDetails.isNew()) {
			Object[] args = new Object[] {
					feeDetails.getFundId(), feeDetails.getFeeType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FUNDIDFEETYPE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE, args,
				feeDetails);

			args = new Object[] {
					feeDetails.getSpCourseId(), feeDetails.getFundId(),
					feeDetails.getFeeType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
				args, feeDetails);
		}
		else {
			FeeDetailsModelImpl feeDetailsModelImpl = (FeeDetailsModelImpl)feeDetails;

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FUNDIDFEETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetails.getFundId(), feeDetails.getFeeType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FUNDIDFEETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
					args, feeDetails);
			}

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetails.getSpCourseId(), feeDetails.getFundId(),
						feeDetails.getFeeType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
					args, feeDetails);
			}
		}
	}

	protected void clearUniqueFindersCache(FeeDetails feeDetails) {
		FeeDetailsModelImpl feeDetailsModelImpl = (FeeDetailsModelImpl)feeDetails;

		Object[] args = new Object[] {
				feeDetails.getFundId(), feeDetails.getFeeType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDIDFEETYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE, args);

		if ((feeDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FUNDIDFEETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					feeDetailsModelImpl.getOriginalFundId(),
					feeDetailsModelImpl.getOriginalFeeType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDIDFEETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FUNDIDFEETYPE,
				args);
		}

		args = new Object[] {
				feeDetails.getSpCourseId(), feeDetails.getFundId(),
				feeDetails.getFeeType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
			args);

		if ((feeDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					feeDetailsModelImpl.getOriginalSpCourseId(),
					feeDetailsModelImpl.getOriginalFundId(),
					feeDetailsModelImpl.getOriginalFeeType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDFUNDIDFEETYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COURSEIDFUNDIDFEETYPE,
				args);
		}
	}

	/**
	 * Creates a new fee details with the primary key. Does not add the fee details to the database.
	 *
	 * @param spFeeDetailsId the primary key for the new fee details
	 * @return the new fee details
	 */
	@Override
	public FeeDetails create(long spFeeDetailsId) {
		FeeDetails feeDetails = new FeeDetailsImpl();

		feeDetails.setNew(true);
		feeDetails.setPrimaryKey(spFeeDetailsId);

		return feeDetails;
	}

	/**
	 * Removes the fee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeeDetailsId the primary key of the fee details
	 * @return the fee details that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails remove(long spFeeDetailsId)
		throws NoSuchFeeDetailsException, SystemException {
		return remove((Serializable)spFeeDetailsId);
	}

	/**
	 * Removes the fee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fee details
	 * @return the fee details that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails remove(Serializable primaryKey)
		throws NoSuchFeeDetailsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FeeDetails feeDetails = (FeeDetails)session.get(FeeDetailsImpl.class,
					primaryKey);

			if (feeDetails == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feeDetails);
		}
		catch (NoSuchFeeDetailsException nsee) {
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
	protected FeeDetails removeImpl(FeeDetails feeDetails)
		throws SystemException {
		feeDetails = toUnwrappedModel(feeDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feeDetails)) {
				feeDetails = (FeeDetails)session.get(FeeDetailsImpl.class,
						feeDetails.getPrimaryKeyObj());
			}

			if (feeDetails != null) {
				session.delete(feeDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feeDetails != null) {
			clearCache(feeDetails);
		}

		return feeDetails;
	}

	@Override
	public FeeDetails updateImpl(
		com.sambaash.platform.srv.model.FeeDetails feeDetails)
		throws SystemException {
		feeDetails = toUnwrappedModel(feeDetails);

		boolean isNew = feeDetails.isNew();

		FeeDetailsModelImpl feeDetailsModelImpl = (FeeDetailsModelImpl)feeDetails;

		Session session = null;

		try {
			session = openSession();

			if (feeDetails.isNew()) {
				session.save(feeDetails);

				feeDetails.setNew(false);
			}
			else {
				session.merge(feeDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FeeDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetailsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { feeDetailsModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetailsModelImpl.getOriginalFundId(),
						feeDetailsModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDIDANDSPCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID,
					args);

				args = new Object[] {
						feeDetailsModelImpl.getFundId(),
						feeDetailsModelImpl.getSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDIDANDSPCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDIDANDSPCOURSEID,
					args);
			}

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetailsModelImpl.getOriginalFundId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDID,
					args);

				args = new Object[] { feeDetailsModelImpl.getFundId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNDID,
					args);
			}

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetailsModelImpl.getOriginalSpCourseId(),
						feeDetailsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);

				args = new Object[] {
						feeDetailsModelImpl.getSpCourseId(),
						feeDetailsModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDGROUPID,
					args);
			}

			if ((feeDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEETYPEANDCOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feeDetailsModelImpl.getOriginalFeeType(),
						feeDetailsModelImpl.getOriginalSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEETYPEANDCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEETYPEANDCOURSEID,
					args);

				args = new Object[] {
						feeDetailsModelImpl.getFeeType(),
						feeDetailsModelImpl.getSpCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEETYPEANDCOURSEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEETYPEANDCOURSEID,
					args);
			}
		}

		EntityCacheUtil.putResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
			FeeDetailsImpl.class, feeDetails.getPrimaryKey(), feeDetails);

		clearUniqueFindersCache(feeDetails);
		cacheUniqueFindersCache(feeDetails);

		return feeDetails;
	}

	protected FeeDetails toUnwrappedModel(FeeDetails feeDetails) {
		if (feeDetails instanceof FeeDetailsImpl) {
			return feeDetails;
		}

		FeeDetailsImpl feeDetailsImpl = new FeeDetailsImpl();

		feeDetailsImpl.setNew(feeDetails.isNew());
		feeDetailsImpl.setPrimaryKey(feeDetails.getPrimaryKey());

		feeDetailsImpl.setSpFeeDetailsId(feeDetails.getSpFeeDetailsId());
		feeDetailsImpl.setGroupId(feeDetails.getGroupId());
		feeDetailsImpl.setCompanyId(feeDetails.getCompanyId());
		feeDetailsImpl.setUserId(feeDetails.getUserId());
		feeDetailsImpl.setUserName(feeDetails.getUserName());
		feeDetailsImpl.setCreateDate(feeDetails.getCreateDate());
		feeDetailsImpl.setModifiedDate(feeDetails.getModifiedDate());
		feeDetailsImpl.setFeeType(feeDetails.getFeeType());
		feeDetailsImpl.setFeeDesc(feeDetails.getFeeDesc());
		feeDetailsImpl.setCalculationBase(feeDetails.getCalculationBase());
		feeDetailsImpl.setAmount(feeDetails.getAmount());
		feeDetailsImpl.setDisplayOrder(feeDetails.getDisplayOrder());
		feeDetailsImpl.setFundId(feeDetails.getFundId());
		feeDetailsImpl.setSpCourseId(feeDetails.getSpCourseId());

		return feeDetailsImpl;
	}

	/**
	 * Returns the fee details with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fee details
	 * @return the fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeeDetailsException, SystemException {
		FeeDetails feeDetails = fetchByPrimaryKey(primaryKey);

		if (feeDetails == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeeDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feeDetails;
	}

	/**
	 * Returns the fee details with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFeeDetailsException} if it could not be found.
	 *
	 * @param spFeeDetailsId the primary key of the fee details
	 * @return the fee details
	 * @throws com.sambaash.platform.srv.NoSuchFeeDetailsException if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails findByPrimaryKey(long spFeeDetailsId)
		throws NoSuchFeeDetailsException, SystemException {
		return findByPrimaryKey((Serializable)spFeeDetailsId);
	}

	/**
	 * Returns the fee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fee details
	 * @return the fee details, or <code>null</code> if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FeeDetails feeDetails = (FeeDetails)EntityCacheUtil.getResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
				FeeDetailsImpl.class, primaryKey);

		if (feeDetails == _nullFeeDetails) {
			return null;
		}

		if (feeDetails == null) {
			Session session = null;

			try {
				session = openSession();

				feeDetails = (FeeDetails)session.get(FeeDetailsImpl.class,
						primaryKey);

				if (feeDetails != null) {
					cacheResult(feeDetails);
				}
				else {
					EntityCacheUtil.putResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
						FeeDetailsImpl.class, primaryKey, _nullFeeDetails);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeeDetailsModelImpl.ENTITY_CACHE_ENABLED,
					FeeDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feeDetails;
	}

	/**
	 * Returns the fee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFeeDetailsId the primary key of the fee details
	 * @return the fee details, or <code>null</code> if a fee details with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeDetails fetchByPrimaryKey(long spFeeDetailsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFeeDetailsId);
	}

	/**
	 * Returns all the fee detailses.
	 *
	 * @return the fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @return the range of fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fee detailses
	 * @param end the upper bound of the range of fee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fee detailses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeDetails> findAll(int start, int end,
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

		List<FeeDetails> list = (List<FeeDetails>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEEDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDETAILS;

				if (pagination) {
					sql = sql.concat(FeeDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeDetails>(list);
				}
				else {
					list = (List<FeeDetails>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fee detailses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FeeDetails feeDetails : findAll()) {
			remove(feeDetails);
		}
	}

	/**
	 * Returns the number of fee detailses.
	 *
	 * @return the number of fee detailses
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

				Query q = session.createQuery(_SQL_COUNT_FEEDETAILS);

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
	 * Initializes the fee details persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.FeeDetails")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FeeDetails>> listenersList = new ArrayList<ModelListener<FeeDetails>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FeeDetails>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeeDetailsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEEDETAILS = "SELECT feeDetails FROM FeeDetails feeDetails";
	private static final String _SQL_SELECT_FEEDETAILS_WHERE = "SELECT feeDetails FROM FeeDetails feeDetails WHERE ";
	private static final String _SQL_COUNT_FEEDETAILS = "SELECT COUNT(feeDetails) FROM FeeDetails feeDetails";
	private static final String _SQL_COUNT_FEEDETAILS_WHERE = "SELECT COUNT(feeDetails) FROM FeeDetails feeDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feeDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FeeDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FeeDetails exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeeDetailsPersistenceImpl.class);
	private static FeeDetails _nullFeeDetails = new FeeDetailsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FeeDetails> toCacheModel() {
				return _nullFeeDetailsCacheModel;
			}
		};

	private static CacheModel<FeeDetails> _nullFeeDetailsCacheModel = new CacheModel<FeeDetails>() {
			@Override
			public FeeDetails toEntityModel() {
				return _nullFeeDetails;
			}
		};
}