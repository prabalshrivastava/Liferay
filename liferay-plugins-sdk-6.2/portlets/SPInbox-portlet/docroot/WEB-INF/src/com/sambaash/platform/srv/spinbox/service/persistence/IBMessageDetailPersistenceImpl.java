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

package com.sambaash.platform.srv.spinbox.service.persistence;

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

import com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException;
import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;
import com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailImpl;
import com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the i b message detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see IBMessageDetailPersistence
 * @see IBMessageDetailUtil
 * @generated
 */
public class IBMessageDetailPersistenceImpl extends BasePersistenceImpl<IBMessageDetail>
	implements IBMessageDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IBMessageDetailUtil} to access the i b message detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IBMessageDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMessageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMessageId",
			new String[] { Long.class.getName() },
			IBMessageDetailModelImpl.MESSAGEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the i b message details where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByMessageId(long messageId)
		throws SystemException {
		return findByMessageId(messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the i b message details where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param messageId the message ID
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByMessageId(long messageId, int start,
		int end) throws SystemException {
		return findByMessageId(messageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where messageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param messageId the message ID
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByMessageId(long messageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId, start, end, orderByComparator };
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((messageId != ibMessageDetail.getMessageId())) {
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

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByMessageId_First(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByMessageId_First(messageId,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByMessageId_First(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByMessageId(messageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByMessageId_Last(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByMessageId_Last(messageId,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByMessageId_Last(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMessageId(messageId);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByMessageId(messageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where messageId = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByMessageId_PrevAndNext(long ibMsgDetailId,
		long messageId, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByMessageId_PrevAndNext(session, ibMessageDetail,
					messageId, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByMessageId_PrevAndNext(session, ibMessageDetail,
					messageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByMessageId_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMessageId(long messageId) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByMessageId(messageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMessageId(long messageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MESSAGEID;

		Object[] finderArgs = new Object[] { messageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

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

	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "ibMessageDetail.messageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEID =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceId",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReceId",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceId(long receiverId, boolean archived)
		throws SystemException {
		return findByReceId(receiverId, archived, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceId(long receiverId,
		boolean archived, int start, int end) throws SystemException {
		return findByReceId(receiverId, archived, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceId(long receiverId,
		boolean archived, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEID;
			finderArgs = new Object[] { receiverId, archived };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEID;
			finderArgs = new Object[] {
					receiverId, archived,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived())) {
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

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEID_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEID_ARCHIVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceId_First(long receiverId,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceId_First(receiverId,
				archived, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceId_First(long receiverId,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByReceId(receiverId, archived, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceId_Last(long receiverId, boolean archived,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceId_Last(receiverId,
				archived, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceId_Last(long receiverId,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReceId(receiverId, archived);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceId(receiverId, archived,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceId_PrevAndNext(long ibMsgDetailId,
		long receiverId, boolean archived, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceId_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceId_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceId_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long receiverId, boolean archived,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEID_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEID_ARCHIVED_2);

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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceId(long receiverId, boolean archived)
		throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceId(receiverId,
				archived, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceId(long receiverId, boolean archived)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEID;

		Object[] finderArgs = new Object[] { receiverId, archived };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEID_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEID_ARCHIVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

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

	private static final String _FINDER_COLUMN_RECEID_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEID_ARCHIVED_2 = "ibMessageDetail.archived = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDANDRMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReceIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
		boolean archived, String receiverMsgStatus) throws SystemException {
		return findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
		boolean archived, String receiverMsgStatus, int start, int end)
		throws SystemException {
		return findByReceIdAndRms(receiverId, archived, receiverMsgStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndRms(long receiverId,
		boolean archived, String receiverMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDRMS;
			finderArgs = new Object[] { receiverId, archived, receiverMsgStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDRMS;
			finderArgs = new Object[] {
					receiverId, archived, receiverMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDRMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndRms_First(long receiverId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndRms_First(receiverId,
				archived, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndRms_First(long receiverId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByReceIdAndRms(receiverId, archived,
				receiverMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndRms_Last(long receiverId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndRms_Last(receiverId,
				archived, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndRms_Last(long receiverId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReceIdAndRms(receiverId, archived, receiverMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdAndRms(receiverId, archived,
				receiverMsgStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		String receiverMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdAndRms_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, receiverMsgStatus, orderByComparator,
					true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdAndRms_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, receiverMsgStatus, orderByComparator,
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

	protected IBMessageDetail getByReceIdAndRms_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long receiverId, boolean archived,
		String receiverMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDANDRMS_ARCHIVED_2);

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdAndRms(long receiverId, boolean archived,
		String receiverMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdAndRms(receiverId,
				archived, receiverMsgStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdAndRms(long receiverId, boolean archived,
		String receiverMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDANDRMS;

		Object[] finderArgs = new Object[] {
				receiverId, archived, receiverMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDRMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDANDRMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDRMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_1 = "ibMessageDetail.receiverMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_2 = "ibMessageDetail.receiverMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDANDRMS_RECEIVERMSGSTATUS_3 = "(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReceIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
		boolean archived, String senderMsgStatus) throws SystemException {
		return findByReceIdAndSms(receiverId, archived, senderMsgStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
		boolean archived, String senderMsgStatus, int start, int end)
		throws SystemException {
		return findByReceIdAndSms(receiverId, archived, senderMsgStatus, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndSms(long receiverId,
		boolean archived, String senderMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDSMS;
			finderArgs = new Object[] { receiverId, archived, senderMsgStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDSMS_ARCHIVED_2);

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndSms_First(long receiverId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndSms_First(receiverId,
				archived, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndSms_First(long receiverId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByReceIdAndSms(receiverId, archived,
				senderMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndSms_Last(long receiverId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndSms_Last(receiverId,
				archived, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndSms_Last(long receiverId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReceIdAndSms(receiverId, archived, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdAndSms(receiverId, archived,
				senderMsgStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdAndSms_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, senderMsgStatus, orderByComparator,
					true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdAndSms_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, senderMsgStatus, orderByComparator,
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

	protected IBMessageDetail getByReceIdAndSms_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long receiverId, boolean archived,
		String senderMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDANDSMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDANDSMS_ARCHIVED_2);

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdAndSms(long receiverId, boolean archived,
		String senderMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdAndSms(receiverId,
				archived, senderMsgStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdAndSms(long receiverId, boolean archived,
		String senderMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDANDSMS;

		Object[] finderArgs = new Object[] { receiverId, archived, senderMsgStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDSMS_ARCHIVED_2);

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDANDSMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_1 = "ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_2 = "ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDANDSMS_SENDERMSGSTATUS_3 = "(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDRMSANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReceIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		return findByReceIdRmsAndSms(receiverId, archived, receiverMsgStatus,
			senderMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		int start, int end) throws SystemException {
		return findByReceIdRmsAndSms(receiverId, archived, receiverMsgStatus,
			senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdRmsAndSms(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDRMSANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, receiverMsgStatus, senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDRMSANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, receiverMsgStatus, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdRmsAndSms_First(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdRmsAndSms_First(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdRmsAndSms_First(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByReceIdRmsAndSms(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdRmsAndSms_Last(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdRmsAndSms_Last(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdRmsAndSms_Last(long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReceIdRmsAndSms(receiverId, archived,
				receiverMsgStatus, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdRmsAndSms(receiverId,
				archived, receiverMsgStatus, senderMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdRmsAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, receiverMsgStatus,
					senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdRmsAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, receiverMsgStatus,
					senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceIdRmsAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long receiverId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_ARCHIVED_2);

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdRmsAndSms(long receiverId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdRmsAndSms(
				receiverId, archived, receiverMsgStatus, senderMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdRmsAndSms(long receiverId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDRMSANDSMS;

		Object[] finderArgs = new Object[] {
				receiverId, archived, receiverMsgStatus, senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '') AND ";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDRMSANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDCTY =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDCTY =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDANDCTY = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReceIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
		boolean archived, String category) throws SystemException {
		return findByReceIdAndCty(receiverId, archived, category,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
		boolean archived, String category, int start, int end)
		throws SystemException {
		return findByReceIdAndCty(receiverId, archived, category, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdAndCty(long receiverId,
		boolean archived, String category, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDCTY;
			finderArgs = new Object[] { receiverId, archived, category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDANDCTY;
			finderArgs = new Object[] {
					receiverId, archived, category,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDCTY_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDCTY_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndCty_First(long receiverId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndCty_First(receiverId,
				archived, category, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndCty_First(long receiverId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByReceIdAndCty(receiverId, archived,
				category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdAndCty_Last(long receiverId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdAndCty_Last(receiverId,
				archived, category, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdAndCty_Last(long receiverId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReceIdAndCty(receiverId, archived, category);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdAndCty(receiverId, archived,
				category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdAndCty_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived, String category,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdAndCty_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, category, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdAndCty_PrevAndNext(session, ibMessageDetail,
					receiverId, archived, category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceIdAndCty_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long receiverId, boolean archived,
		String category, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDANDCTY_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDANDCTY_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdAndCty(long receiverId, boolean archived,
		String category) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdAndCty(receiverId,
				archived, category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdAndCty(long receiverId, boolean archived,
		String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDANDCTY;

		Object[] finderArgs = new Object[] { receiverId, archived, category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDANDCTY_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDANDCTY_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDANDCTY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
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

	private static final String _FINDER_COLUMN_RECEIDANDCTY_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDCTY_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDANDCTY_CATEGORY_1 = "ibMessageDetail.category IS NULL";
	private static final String _FINDER_COLUMN_RECEIDANDCTY_CATEGORY_2 = "ibMessageDetail.category = ?";
	private static final String _FINDER_COLUMN_RECEIDANDCTY_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDCTYANDRMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReceIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
		boolean archived, String category, String receiverMsgStatus)
		throws SystemException {
		return findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
		boolean archived, String category, String receiverMsgStatus, int start,
		int end) throws SystemException {
		return findByReceIdCtyAndRms(receiverId, archived, category,
			receiverMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndRms(long receiverId,
		boolean archived, String category, String receiverMsgStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDRMS;
			finderArgs = new Object[] {
					receiverId, archived, category, receiverMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYANDRMS;
			finderArgs = new Object[] {
					receiverId, archived, category, receiverMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyAndRms_First(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyAndRms_First(receiverId,
				archived, category, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyAndRms_First(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByReceIdCtyAndRms(receiverId,
				archived, category, receiverMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyAndRms_Last(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyAndRms_Last(receiverId,
				archived, category, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyAndRms_Last(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReceIdCtyAndRms(receiverId, archived, category,
				receiverMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdCtyAndRms(receiverId,
				archived, category, receiverMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived, String category,
		String receiverMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdCtyAndRms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					receiverMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdCtyAndRms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					receiverMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceIdCtyAndRms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_2);
		}

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdCtyAndRms(long receiverId, boolean archived,
		String category, String receiverMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdCtyAndRms(
				receiverId, archived, category, receiverMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdCtyAndRms(long receiverId, boolean archived,
		String category, String receiverMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDCTYANDRMS;

		Object[] finderArgs = new Object[] {
				receiverId, archived, category, receiverMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDCTYANDRMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReceIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDCTYANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReceIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
		boolean archived, String category, String senderMsgStatus)
		throws SystemException {
		return findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
		boolean archived, String category, String senderMsgStatus, int start,
		int end) throws SystemException {
		return findByReceIdCtyAndSms(receiverId, archived, category,
			senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyAndSms(long receiverId,
		boolean archived, String category, String senderMsgStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, category, senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, category, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyAndSms_First(long receiverId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyAndSms_First(receiverId,
				archived, category, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyAndSms_First(long receiverId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByReceIdCtyAndSms(receiverId,
				archived, category, senderMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyAndSms_Last(long receiverId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyAndSms_Last(receiverId,
				archived, category, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyAndSms_Last(long receiverId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReceIdCtyAndSms(receiverId, archived, category,
				senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdCtyAndSms(receiverId,
				archived, category, senderMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived, String category,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdCtyAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdCtyAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceIdCtyAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long receiverId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdCtyAndSms(long receiverId, boolean archived,
		String category, String senderMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdCtyAndSms(
				receiverId, archived, category, senderMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdCtyAndSms(long receiverId, boolean archived,
		String category, String senderMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDCTYANDSMS;

		Object[] finderArgs = new Object[] {
				receiverId, archived, category, senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDCTYANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReceIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReceIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIDCTYRMSANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReceIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus) throws SystemException {
		return findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, int start, int end) throws SystemException {
		return findByReceIdCtyRmsAndSms(receiverId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByReceIdCtyRmsAndSms(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, category, receiverMsgStatus,
					senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS;
			finderArgs = new Object[] {
					receiverId, archived, category, receiverMsgStatus,
					senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((receiverId != ibMessageDetail.getReceiverId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyRmsAndSms_First(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyRmsAndSms_First(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyRmsAndSms_First(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByReceIdCtyRmsAndSms(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceIdCtyRmsAndSms_Last(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceIdCtyRmsAndSms_Last(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverId=");
		msg.append(receiverId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceIdCtyRmsAndSms_Last(long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByReceIdCtyRmsAndSms(receiverId, archived, category,
				receiverMsgStatus, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByReceIdCtyRmsAndSms(receiverId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByReceIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long receiverId, boolean archived, String category,
		String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByReceIdCtyRmsAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					receiverMsgStatus, senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByReceIdCtyRmsAndSms_PrevAndNext(session,
					ibMessageDetail, receiverId, archived, category,
					receiverMsgStatus, senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByReceIdCtyRmsAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long receiverId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERID_2);

		query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_2);
		}

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReceIdCtyRmsAndSms(long receiverId, boolean archived,
		String category, String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByReceIdCtyRmsAndSms(
				receiverId, archived, category, receiverMsgStatus,
				senderMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceIdCtyRmsAndSms(long receiverId, boolean archived,
		String category, String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIDCTYRMSANDSMS;

		Object[] finderArgs = new Object[] {
				receiverId, archived, category, receiverMsgStatus,
				senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ? AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '') AND ";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_RECEIDCTYRMSANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByReceiverIdmessageId",
			new String[] { Long.class.getName(), Long.class.getName() },
			IBMessageDetailModelImpl.RECEIVERID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.MESSAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReceiverIdmessageId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the i b message detail where receiverId = &#63; and messageId = &#63; or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	 *
	 * @param receiverId the receiver ID
	 * @param messageId the message ID
	 * @return the matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByReceiverIdmessageId(long receiverId,
		long messageId) throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByReceiverIdmessageId(receiverId,
				messageId);

		if (ibMessageDetail == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("receiverId=");
			msg.append(receiverId);

			msg.append(", messageId=");
			msg.append(messageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIBMessageDetailException(msg.toString());
		}

		return ibMessageDetail;
	}

	/**
	 * Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param receiverId the receiver ID
	 * @param messageId the message ID
	 * @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceiverIdmessageId(long receiverId,
		long messageId) throws SystemException {
		return fetchByReceiverIdmessageId(receiverId, messageId, true);
	}

	/**
	 * Returns the i b message detail where receiverId = &#63; and messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param receiverId the receiver ID
	 * @param messageId the message ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByReceiverIdmessageId(long receiverId,
		long messageId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { receiverId, messageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
					finderArgs, this);
		}

		if (result instanceof IBMessageDetail) {
			IBMessageDetail ibMessageDetail = (IBMessageDetail)result;

			if ((receiverId != ibMessageDetail.getReceiverId()) ||
					(messageId != ibMessageDetail.getMessageId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIVERIDMESSAGEID_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIVERIDMESSAGEID_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(messageId);

				List<IBMessageDetail> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"IBMessageDetailPersistenceImpl.fetchByReceiverIdmessageId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					IBMessageDetail ibMessageDetail = list.get(0);

					result = ibMessageDetail;

					cacheResult(ibMessageDetail);

					if ((ibMessageDetail.getReceiverId() != receiverId) ||
							(ibMessageDetail.getMessageId() != messageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
							finderArgs, ibMessageDetail);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
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
			return (IBMessageDetail)result;
		}
	}

	/**
	 * Removes the i b message detail where receiverId = &#63; and messageId = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @param messageId the message ID
	 * @return the i b message detail that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail removeByReceiverIdmessageId(long receiverId,
		long messageId) throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByReceiverIdmessageId(receiverId,
				messageId);

		return remove(ibMessageDetail);
	}

	/**
	 * Returns the number of i b message details where receiverId = &#63; and messageId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @param messageId the message ID
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReceiverIdmessageId(long receiverId, long messageId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID;

		Object[] finderArgs = new Object[] { receiverId, messageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_RECEIVERIDMESSAGEID_RECEIVERID_2);

			query.append(_FINDER_COLUMN_RECEIVERIDMESSAGEID_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				qPos.add(messageId);

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

	private static final String _FINDER_COLUMN_RECEIVERIDMESSAGEID_RECEIVERID_2 = "ibMessageDetail.receiverId = ? AND ";
	private static final String _FINDER_COLUMN_RECEIVERIDMESSAGEID_MESSAGEID_2 = "ibMessageDetail.messageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPID =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpId",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPID = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCorpId",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpId(long corpProfileId,
		boolean archived) throws SystemException {
		return findByCorpId(corpProfileId, archived, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpId(long corpProfileId,
		boolean archived, int start, int end) throws SystemException {
		return findByCorpId(corpProfileId, archived, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpId(long corpProfileId,
		boolean archived, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPID;
			finderArgs = new Object[] { corpProfileId, archived };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPID;
			finderArgs = new Object[] {
					corpProfileId, archived,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived())) {
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

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPID_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPID_ARCHIVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpId_First(long corpProfileId,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpId_First(corpProfileId,
				archived, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpId_First(long corpProfileId,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByCorpId(corpProfileId, archived, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpId_Last(long corpProfileId,
		boolean archived, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpId_Last(corpProfileId,
				archived, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpId_Last(long corpProfileId,
		boolean archived, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCorpId(corpProfileId, archived);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpId(corpProfileId, archived,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpId_PrevAndNext(long ibMsgDetailId,
		long corpProfileId, boolean archived,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpId_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpId_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpId_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long corpProfileId, boolean archived,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPID_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPID_ARCHIVED_2);

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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpId(long corpProfileId, boolean archived)
		throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpId(corpProfileId,
				archived, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpId(long corpProfileId, boolean archived)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPID;

		Object[] finderArgs = new Object[] { corpProfileId, archived };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPID_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPID_ARCHIVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

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

	private static final String _FINDER_COLUMN_CORPID_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPID_ARCHIVED_2 = "ibMessageDetail.archived = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDANDRMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCorpIdAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
		boolean archived, String receiverMsgStatus) throws SystemException {
		return findByCorpIdAndRms(corpProfileId, archived, receiverMsgStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
		boolean archived, String receiverMsgStatus, int start, int end)
		throws SystemException {
		return findByCorpIdAndRms(corpProfileId, archived, receiverMsgStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndRms(long corpProfileId,
		boolean archived, String receiverMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDRMS;
			finderArgs = new Object[] { corpProfileId, archived, receiverMsgStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDRMS;
			finderArgs = new Object[] {
					corpProfileId, archived, receiverMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDRMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDRMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndRms_First(long corpProfileId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndRms_First(corpProfileId,
				archived, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndRms_First(long corpProfileId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByCorpIdAndRms(corpProfileId,
				archived, receiverMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndRms_Last(long corpProfileId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndRms_Last(corpProfileId,
				archived, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndRms_Last(long corpProfileId,
		boolean archived, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCorpIdAndRms(corpProfileId, archived,
				receiverMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdAndRms(corpProfileId,
				archived, receiverMsgStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String receiverMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdAndRms_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, receiverMsgStatus,
					orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdAndRms_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, receiverMsgStatus,
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

	protected IBMessageDetail getByCorpIdAndRms_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long corpProfileId, boolean archived,
		String receiverMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDANDRMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDANDRMS_ARCHIVED_2);

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdAndRms(long corpProfileId, boolean archived,
		String receiverMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdAndRms(
				corpProfileId, archived, receiverMsgStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdAndRms(long corpProfileId, boolean archived,
		String receiverMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDANDRMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, receiverMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDRMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDRMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDANDRMS_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDRMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_1 = "ibMessageDetail.receiverMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_2 = "ibMessageDetail.receiverMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDANDRMS_RECEIVERMSGSTATUS_3 = "(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCorpIdAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
		boolean archived, String senderMsgStatus) throws SystemException {
		return findByCorpIdAndSms(corpProfileId, archived, senderMsgStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
		boolean archived, String senderMsgStatus, int start, int end)
		throws SystemException {
		return findByCorpIdAndSms(corpProfileId, archived, senderMsgStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndSms(long corpProfileId,
		boolean archived, String senderMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDSMS;
			finderArgs = new Object[] { corpProfileId, archived, senderMsgStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDSMS_ARCHIVED_2);

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndSms_First(long corpProfileId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndSms_First(corpProfileId,
				archived, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndSms_First(long corpProfileId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByCorpIdAndSms(corpProfileId,
				archived, senderMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndSms_Last(long corpProfileId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndSms_Last(corpProfileId,
				archived, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndSms_Last(long corpProfileId,
		boolean archived, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCorpIdAndSms(corpProfileId, archived, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdAndSms(corpProfileId,
				archived, senderMsgStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdAndSms_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, senderMsgStatus,
					orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdAndSms_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, senderMsgStatus,
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

	protected IBMessageDetail getByCorpIdAndSms_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long corpProfileId, boolean archived,
		String senderMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDANDSMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDANDSMS_ARCHIVED_2);

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdAndSms(long corpProfileId, boolean archived,
		String senderMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdAndSms(
				corpProfileId, archived, senderMsgStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdAndSms(long corpProfileId, boolean archived,
		String senderMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDANDSMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDSMS_ARCHIVED_2);

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDANDSMS_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_1 = "ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_2 = "ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDANDSMS_SENDERMSGSTATUS_3 = "(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDRMSANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCorpIdRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		return findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		int start, int end) throws SystemException {
		return findByCorpIdRmsAndSms(corpProfileId, archived,
			receiverMsgStatus, senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdRmsAndSms(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDRMSANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, receiverMsgStatus, senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDRMSANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, receiverMsgStatus, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdRmsAndSms_First(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdRmsAndSms_First(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdRmsAndSms_First(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByCorpIdRmsAndSms(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdRmsAndSms_Last(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdRmsAndSms_Last(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdRmsAndSms_Last(long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCorpIdRmsAndSms(corpProfileId, archived,
				receiverMsgStatus, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdRmsAndSms(corpProfileId,
				archived, receiverMsgStatus, senderMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdRmsAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived,
					receiverMsgStatus, senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdRmsAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived,
					receiverMsgStatus, senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpIdRmsAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long corpProfileId,
		boolean archived, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_ARCHIVED_2);

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdRmsAndSms(long corpProfileId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdRmsAndSms(
				corpProfileId, archived, receiverMsgStatus, senderMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdRmsAndSms(long corpProfileId, boolean archived,
		String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDRMSANDSMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, receiverMsgStatus, senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_ARCHIVED_2);

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '') AND ";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDRMSANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDCTY =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDCTY =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDANDCTY = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCorpIdAndCty",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
		boolean archived, String category) throws SystemException {
		return findByCorpIdAndCty(corpProfileId, archived, category,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
		boolean archived, String category, int start, int end)
		throws SystemException {
		return findByCorpIdAndCty(corpProfileId, archived, category, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdAndCty(long corpProfileId,
		boolean archived, String category, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDCTY;
			finderArgs = new Object[] { corpProfileId, archived, category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDANDCTY;
			finderArgs = new Object[] {
					corpProfileId, archived, category,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDCTY_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDCTY_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndCty_First(long corpProfileId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndCty_First(corpProfileId,
				archived, category, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndCty_First(long corpProfileId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByCorpIdAndCty(corpProfileId,
				archived, category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdAndCty_Last(long corpProfileId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdAndCty_Last(corpProfileId,
				archived, category, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdAndCty_Last(long corpProfileId,
		boolean archived, String category, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCorpIdAndCty(corpProfileId, archived, category);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdAndCty(corpProfileId,
				archived, category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdAndCty_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String category, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdAndCty_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, category, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdAndCty_PrevAndNext(session, ibMessageDetail,
					corpProfileId, archived, category, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpIdAndCty_PrevAndNext(Session session,
		IBMessageDetail ibMessageDetail, long corpProfileId, boolean archived,
		String category, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDANDCTY_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDANDCTY_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdAndCty(long corpProfileId, boolean archived,
		String category) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdAndCty(
				corpProfileId, archived, category, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdAndCty(long corpProfileId, boolean archived,
		String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDANDCTY;

		Object[] finderArgs = new Object[] { corpProfileId, archived, category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDANDCTY_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDANDCTY_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDANDCTY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
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

	private static final String _FINDER_COLUMN_CORPIDANDCTY_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDCTY_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDANDCTY_CATEGORY_1 = "ibMessageDetail.category IS NULL";
	private static final String _FINDER_COLUMN_CORPIDANDCTY_CATEGORY_2 = "ibMessageDetail.category = ?";
	private static final String _FINDER_COLUMN_CORPIDANDCTY_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDRMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDCTYANDRMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCorpIdCtyAndRms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus)
		throws SystemException {
		return findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus, int start,
		int end) throws SystemException {
		return findByCorpIdCtyAndRms(corpProfileId, archived, category,
			receiverMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndRms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDRMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, receiverMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYANDRMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, receiverMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyAndRms_First(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyAndRms_First(corpProfileId,
				archived, category, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyAndRms_First(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByCorpIdCtyAndRms(corpProfileId,
				archived, category, receiverMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyAndRms_Last(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyAndRms_Last(corpProfileId,
				archived, category, receiverMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyAndRms_Last(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCorpIdCtyAndRms(corpProfileId, archived, category,
				receiverMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdCtyAndRms(corpProfileId,
				archived, category, receiverMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdCtyAndRms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String category, String receiverMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdCtyAndRms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					receiverMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdCtyAndRms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					receiverMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpIdCtyAndRms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_2);
		}

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdCtyAndRms(long corpProfileId, boolean archived,
		String category, String receiverMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdCtyAndRms(
				corpProfileId, archived, category, receiverMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdCtyAndRms(long corpProfileId, boolean archived,
		String category, String receiverMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDCTYANDRMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, category, receiverMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDCTYANDRMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCorpIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDCTYANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCorpIdCtyAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
		boolean archived, String category, String senderMsgStatus)
		throws SystemException {
		return findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
		boolean archived, String category, String senderMsgStatus, int start,
		int end) throws SystemException {
		return findByCorpIdCtyAndSms(corpProfileId, archived, category,
			senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyAndSms(long corpProfileId,
		boolean archived, String category, String senderMsgStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyAndSms_First(long corpProfileId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyAndSms_First(corpProfileId,
				archived, category, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyAndSms_First(long corpProfileId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<IBMessageDetail> list = findByCorpIdCtyAndSms(corpProfileId,
				archived, category, senderMsgStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyAndSms_Last(long corpProfileId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyAndSms_Last(corpProfileId,
				archived, category, senderMsgStatus, orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyAndSms_Last(long corpProfileId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCorpIdCtyAndSms(corpProfileId, archived, category,
				senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdCtyAndSms(corpProfileId,
				archived, category, senderMsgStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdCtyAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String category, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdCtyAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdCtyAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpIdCtyAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long corpProfileId,
		boolean archived, String category, String senderMsgStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdCtyAndSms(long corpProfileId, boolean archived,
		String category, String senderMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdCtyAndSms(
				corpProfileId, archived, category, senderMsgStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdCtyAndSms(long corpProfileId, boolean archived,
		String category, String senderMsgStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDCTYANDSMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, category, senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_CORPPROFILEID_2 = "ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDCTYANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCorpIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS =
		new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED,
			IBMessageDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCorpIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			IBMessageDetailModelImpl.CORPPROFILEID_COLUMN_BITMASK |
			IBMessageDetailModelImpl.ARCHIVED_COLUMN_BITMASK |
			IBMessageDetailModelImpl.CATEGORY_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.SENDERMSGSTATUS_COLUMN_BITMASK |
			IBMessageDetailModelImpl.RECEIVEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CORPIDCTYRMSANDSMS = new FinderPath(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCorpIdCtyRmsAndSms",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus) throws SystemException {
		return findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, int start, int end) throws SystemException {
		return findByCorpIdCtyRmsAndSms(corpProfileId, archived, category,
			receiverMsgStatus, senderMsgStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, receiverMsgStatus,
					senderMsgStatus
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS;
			finderArgs = new Object[] {
					corpProfileId, archived, category, receiverMsgStatus,
					senderMsgStatus,
					
					start, end, orderByComparator
				};
		}

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IBMessageDetail ibMessageDetail : list) {
				if ((corpProfileId != ibMessageDetail.getCorpProfileId()) ||
						(archived != ibMessageDetail.getArchived()) ||
						!Validator.equals(category,
							ibMessageDetail.getCategory()) ||
						!Validator.equals(receiverMsgStatus,
							ibMessageDetail.getReceiverMsgStatus()) ||
						!Validator.equals(senderMsgStatus,
							ibMessageDetail.getSenderMsgStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
				}

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyRmsAndSms_First(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyRmsAndSms_First(corpProfileId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the first i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyRmsAndSms_First(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<IBMessageDetail> list = findByCorpIdCtyRmsAndSms(corpProfileId,
				archived, category, receiverMsgStatus, senderMsgStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByCorpIdCtyRmsAndSms_Last(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByCorpIdCtyRmsAndSms_Last(corpProfileId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				orderByComparator);

		if (ibMessageDetail != null) {
			return ibMessageDetail;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("corpProfileId=");
		msg.append(corpProfileId);

		msg.append(", archived=");
		msg.append(archived);

		msg.append(", category=");
		msg.append(category);

		msg.append(", receiverMsgStatus=");
		msg.append(receiverMsgStatus);

		msg.append(", senderMsgStatus=");
		msg.append(senderMsgStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIBMessageDetailException(msg.toString());
	}

	/**
	 * Returns the last i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching i b message detail, or <code>null</code> if a matching i b message detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByCorpIdCtyRmsAndSms_Last(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCorpIdCtyRmsAndSms(corpProfileId, archived,
				category, receiverMsgStatus, senderMsgStatus);

		if (count == 0) {
			return null;
		}

		List<IBMessageDetail> list = findByCorpIdCtyRmsAndSms(corpProfileId,
				archived, category, receiverMsgStatus, senderMsgStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the i b message details before and after the current i b message detail in the ordered set where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param ibMsgDetailId the primary key of the current i b message detail
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail[] findByCorpIdCtyRmsAndSms_PrevAndNext(
		long ibMsgDetailId, long corpProfileId, boolean archived,
		String category, String receiverMsgStatus, String senderMsgStatus,
		OrderByComparator orderByComparator)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = findByPrimaryKey(ibMsgDetailId);

		Session session = null;

		try {
			session = openSession();

			IBMessageDetail[] array = new IBMessageDetailImpl[3];

			array[0] = getByCorpIdCtyRmsAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					receiverMsgStatus, senderMsgStatus, orderByComparator, true);

			array[1] = ibMessageDetail;

			array[2] = getByCorpIdCtyRmsAndSms_PrevAndNext(session,
					ibMessageDetail, corpProfileId, archived, category,
					receiverMsgStatus, senderMsgStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IBMessageDetail getByCorpIdCtyRmsAndSms_PrevAndNext(
		Session session, IBMessageDetail ibMessageDetail, long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IBMESSAGEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CORPPROFILEID_2);

		query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_ARCHIVED_2);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_2);
		}

		boolean bindReceiverMsgStatus = false;

		if (receiverMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
		}
		else if (receiverMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
		}
		else {
			bindReceiverMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
		}

		boolean bindSenderMsgStatus = false;

		if (senderMsgStatus == null) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
		}
		else if (senderMsgStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
		}
		else {
			bindSenderMsgStatus = true;

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
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
			query.append(IBMessageDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(corpProfileId);

		qPos.add(archived);

		if (bindCategory) {
			qPos.add(category);
		}

		if (bindReceiverMsgStatus) {
			qPos.add(receiverMsgStatus);
		}

		if (bindSenderMsgStatus) {
			qPos.add(senderMsgStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ibMessageDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IBMessageDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63; from the database.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCorpIdCtyRmsAndSms(long corpProfileId,
		boolean archived, String category, String receiverMsgStatus,
		String senderMsgStatus) throws SystemException {
		for (IBMessageDetail ibMessageDetail : findByCorpIdCtyRmsAndSms(
				corpProfileId, archived, category, receiverMsgStatus,
				senderMsgStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details where corpProfileId = &#63; and archived = &#63; and category = &#63; and receiverMsgStatus = &#63; and senderMsgStatus = &#63;.
	 *
	 * @param corpProfileId the corp profile ID
	 * @param archived the archived
	 * @param category the category
	 * @param receiverMsgStatus the receiver msg status
	 * @param senderMsgStatus the sender msg status
	 * @return the number of matching i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCorpIdCtyRmsAndSms(long corpProfileId, boolean archived,
		String category, String receiverMsgStatus, String senderMsgStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CORPIDCTYRMSANDSMS;

		Object[] finderArgs = new Object[] {
				corpProfileId, archived, category, receiverMsgStatus,
				senderMsgStatus
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_IBMESSAGEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CORPPROFILEID_2);

			query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_ARCHIVED_2);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_2);
			}

			boolean bindReceiverMsgStatus = false;

			if (receiverMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1);
			}
			else if (receiverMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3);
			}
			else {
				bindReceiverMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2);
			}

			boolean bindSenderMsgStatus = false;

			if (senderMsgStatus == null) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_1);
			}
			else if (senderMsgStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_3);
			}
			else {
				bindSenderMsgStatus = true;

				query.append(_FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(corpProfileId);

				qPos.add(archived);

				if (bindCategory) {
					qPos.add(category);
				}

				if (bindReceiverMsgStatus) {
					qPos.add(receiverMsgStatus);
				}

				if (bindSenderMsgStatus) {
					qPos.add(senderMsgStatus);
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

	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_CORPPROFILEID_2 =
		"ibMessageDetail.corpProfileId = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_ARCHIVED_2 = "ibMessageDetail.archived = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_1 = "ibMessageDetail.category IS NULL AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_2 = "ibMessageDetail.category = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_CATEGORY_3 = "(ibMessageDetail.category IS NULL OR ibMessageDetail.category = '') AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_1 =
		"ibMessageDetail.receiverMsgStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_2 =
		"ibMessageDetail.receiverMsgStatus = ? AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_RECEIVERMSGSTATUS_3 =
		"(ibMessageDetail.receiverMsgStatus IS NULL OR ibMessageDetail.receiverMsgStatus = '') AND ";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_1 =
		"ibMessageDetail.senderMsgStatus IS NULL";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_2 =
		"ibMessageDetail.senderMsgStatus = ?";
	private static final String _FINDER_COLUMN_CORPIDCTYRMSANDSMS_SENDERMSGSTATUS_3 =
		"(ibMessageDetail.senderMsgStatus IS NULL OR ibMessageDetail.senderMsgStatus = '')";

	public IBMessageDetailPersistenceImpl() {
		setModelClass(IBMessageDetail.class);
	}

	/**
	 * Caches the i b message detail in the entity cache if it is enabled.
	 *
	 * @param ibMessageDetail the i b message detail
	 */
	@Override
	public void cacheResult(IBMessageDetail ibMessageDetail) {
		EntityCacheUtil.putResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailImpl.class, ibMessageDetail.getPrimaryKey(),
			ibMessageDetail);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
			new Object[] {
				ibMessageDetail.getReceiverId(), ibMessageDetail.getMessageId()
			}, ibMessageDetail);

		ibMessageDetail.resetOriginalValues();
	}

	/**
	 * Caches the i b message details in the entity cache if it is enabled.
	 *
	 * @param ibMessageDetails the i b message details
	 */
	@Override
	public void cacheResult(List<IBMessageDetail> ibMessageDetails) {
		for (IBMessageDetail ibMessageDetail : ibMessageDetails) {
			if (EntityCacheUtil.getResult(
						IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
						IBMessageDetailImpl.class,
						ibMessageDetail.getPrimaryKey()) == null) {
				cacheResult(ibMessageDetail);
			}
			else {
				ibMessageDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all i b message details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IBMessageDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IBMessageDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the i b message detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IBMessageDetail ibMessageDetail) {
		EntityCacheUtil.removeResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailImpl.class, ibMessageDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ibMessageDetail);
	}

	@Override
	public void clearCache(List<IBMessageDetail> ibMessageDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IBMessageDetail ibMessageDetail : ibMessageDetails) {
			EntityCacheUtil.removeResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
				IBMessageDetailImpl.class, ibMessageDetail.getPrimaryKey());

			clearUniqueFindersCache(ibMessageDetail);
		}
	}

	protected void cacheUniqueFindersCache(IBMessageDetail ibMessageDetail) {
		if (ibMessageDetail.isNew()) {
			Object[] args = new Object[] {
					ibMessageDetail.getReceiverId(),
					ibMessageDetail.getMessageId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
				args, ibMessageDetail);
		}
		else {
			IBMessageDetailModelImpl ibMessageDetailModelImpl = (IBMessageDetailModelImpl)ibMessageDetail;

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetail.getReceiverId(),
						ibMessageDetail.getMessageId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
					args, ibMessageDetail);
			}
		}
	}

	protected void clearUniqueFindersCache(IBMessageDetail ibMessageDetail) {
		IBMessageDetailModelImpl ibMessageDetailModelImpl = (IBMessageDetailModelImpl)ibMessageDetail;

		Object[] args = new Object[] {
				ibMessageDetail.getReceiverId(), ibMessageDetail.getMessageId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
			args);

		if ((ibMessageDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					ibMessageDetailModelImpl.getOriginalReceiverId(),
					ibMessageDetailModelImpl.getOriginalMessageId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERIDMESSAGEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RECEIVERIDMESSAGEID,
				args);
		}
	}

	/**
	 * Creates a new i b message detail with the primary key. Does not add the i b message detail to the database.
	 *
	 * @param ibMsgDetailId the primary key for the new i b message detail
	 * @return the new i b message detail
	 */
	@Override
	public IBMessageDetail create(long ibMsgDetailId) {
		IBMessageDetail ibMessageDetail = new IBMessageDetailImpl();

		ibMessageDetail.setNew(true);
		ibMessageDetail.setPrimaryKey(ibMsgDetailId);

		return ibMessageDetail;
	}

	/**
	 * Removes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ibMsgDetailId the primary key of the i b message detail
	 * @return the i b message detail that was removed
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail remove(long ibMsgDetailId)
		throws NoSuchIBMessageDetailException, SystemException {
		return remove((Serializable)ibMsgDetailId);
	}

	/**
	 * Removes the i b message detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the i b message detail
	 * @return the i b message detail that was removed
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail remove(Serializable primaryKey)
		throws NoSuchIBMessageDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IBMessageDetail ibMessageDetail = (IBMessageDetail)session.get(IBMessageDetailImpl.class,
					primaryKey);

			if (ibMessageDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIBMessageDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ibMessageDetail);
		}
		catch (NoSuchIBMessageDetailException nsee) {
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
	protected IBMessageDetail removeImpl(IBMessageDetail ibMessageDetail)
		throws SystemException {
		ibMessageDetail = toUnwrappedModel(ibMessageDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ibMessageDetail)) {
				ibMessageDetail = (IBMessageDetail)session.get(IBMessageDetailImpl.class,
						ibMessageDetail.getPrimaryKeyObj());
			}

			if (ibMessageDetail != null) {
				session.delete(ibMessageDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ibMessageDetail != null) {
			clearCache(ibMessageDetail);
		}

		return ibMessageDetail;
	}

	@Override
	public IBMessageDetail updateImpl(
		com.sambaash.platform.srv.spinbox.model.IBMessageDetail ibMessageDetail)
		throws SystemException {
		ibMessageDetail = toUnwrappedModel(ibMessageDetail);

		boolean isNew = ibMessageDetail.isNew();

		IBMessageDetailModelImpl ibMessageDetailModelImpl = (IBMessageDetailModelImpl)ibMessageDetail;

		Session session = null;

		try {
			session = openSession();

			if (ibMessageDetail.isNew()) {
				session.save(ibMessageDetail);

				ibMessageDetail.setNew(false);
			}
			else {
				session.merge(ibMessageDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IBMessageDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);

				args = new Object[] { ibMessageDetailModelImpl.getMessageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEID,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEID,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDRMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDRMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDRMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDRMSANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDRMSANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getReceiverMsgStatus(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDRMSANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDCTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDCTY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDCTY,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDANDCTY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDANDCTY,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDRMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDRMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDRMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalReceiverId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getReceiverId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getReceiverMsgStatus(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIDCTYRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIDCTYRMSANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPID,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPID,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDRMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDRMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDRMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDRMSANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDRMSANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getReceiverMsgStatus(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDRMSANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDCTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDCTY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDCTY,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDANDCTY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDANDCTY,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDRMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDRMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getReceiverMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYANDRMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDRMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYANDSMS,
					args);
			}

			if ((ibMessageDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ibMessageDetailModelImpl.getOriginalCorpProfileId(),
						ibMessageDetailModelImpl.getOriginalArchived(),
						ibMessageDetailModelImpl.getOriginalCategory(),
						ibMessageDetailModelImpl.getOriginalReceiverMsgStatus(),
						ibMessageDetailModelImpl.getOriginalSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS,
					args);

				args = new Object[] {
						ibMessageDetailModelImpl.getCorpProfileId(),
						ibMessageDetailModelImpl.getArchived(),
						ibMessageDetailModelImpl.getCategory(),
						ibMessageDetailModelImpl.getReceiverMsgStatus(),
						ibMessageDetailModelImpl.getSenderMsgStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CORPIDCTYRMSANDSMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CORPIDCTYRMSANDSMS,
					args);
			}
		}

		EntityCacheUtil.putResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
			IBMessageDetailImpl.class, ibMessageDetail.getPrimaryKey(),
			ibMessageDetail);

		clearUniqueFindersCache(ibMessageDetail);
		cacheUniqueFindersCache(ibMessageDetail);

		return ibMessageDetail;
	}

	protected IBMessageDetail toUnwrappedModel(IBMessageDetail ibMessageDetail) {
		if (ibMessageDetail instanceof IBMessageDetailImpl) {
			return ibMessageDetail;
		}

		IBMessageDetailImpl ibMessageDetailImpl = new IBMessageDetailImpl();

		ibMessageDetailImpl.setNew(ibMessageDetail.isNew());
		ibMessageDetailImpl.setPrimaryKey(ibMessageDetail.getPrimaryKey());

		ibMessageDetailImpl.setIbMsgDetailId(ibMessageDetail.getIbMsgDetailId());
		ibMessageDetailImpl.setReceiverId(ibMessageDetail.getReceiverId());
		ibMessageDetailImpl.setMessageId(ibMessageDetail.getMessageId());
		ibMessageDetailImpl.setReceiverMsgStatus(ibMessageDetail.getReceiverMsgStatus());
		ibMessageDetailImpl.setSenderMsgStatus(ibMessageDetail.getSenderMsgStatus());
		ibMessageDetailImpl.setStatus(ibMessageDetail.getStatus());
		ibMessageDetailImpl.setReceiveDate(ibMessageDetail.getReceiveDate());
		ibMessageDetailImpl.setReceiveBy(ibMessageDetail.getReceiveBy());
		ibMessageDetailImpl.setArchived(ibMessageDetail.isArchived());
		ibMessageDetailImpl.setUpdateDate(ibMessageDetail.getUpdateDate());
		ibMessageDetailImpl.setUpdateBy(ibMessageDetail.getUpdateBy());
		ibMessageDetailImpl.setCategory(ibMessageDetail.getCategory());
		ibMessageDetailImpl.setProcessId(ibMessageDetail.getProcessId());
		ibMessageDetailImpl.setCorpProfileId(ibMessageDetail.getCorpProfileId());

		return ibMessageDetailImpl;
	}

	/**
	 * Returns the i b message detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the i b message detail
	 * @return the i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIBMessageDetailException, SystemException {
		IBMessageDetail ibMessageDetail = fetchByPrimaryKey(primaryKey);

		if (ibMessageDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIBMessageDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ibMessageDetail;
	}

	/**
	 * Returns the i b message detail with the primary key or throws a {@link com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException} if it could not be found.
	 *
	 * @param ibMsgDetailId the primary key of the i b message detail
	 * @return the i b message detail
	 * @throws com.sambaash.platform.srv.spinbox.NoSuchIBMessageDetailException if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail findByPrimaryKey(long ibMsgDetailId)
		throws NoSuchIBMessageDetailException, SystemException {
		return findByPrimaryKey((Serializable)ibMsgDetailId);
	}

	/**
	 * Returns the i b message detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the i b message detail
	 * @return the i b message detail, or <code>null</code> if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		IBMessageDetail ibMessageDetail = (IBMessageDetail)EntityCacheUtil.getResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
				IBMessageDetailImpl.class, primaryKey);

		if (ibMessageDetail == _nullIBMessageDetail) {
			return null;
		}

		if (ibMessageDetail == null) {
			Session session = null;

			try {
				session = openSession();

				ibMessageDetail = (IBMessageDetail)session.get(IBMessageDetailImpl.class,
						primaryKey);

				if (ibMessageDetail != null) {
					cacheResult(ibMessageDetail);
				}
				else {
					EntityCacheUtil.putResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
						IBMessageDetailImpl.class, primaryKey,
						_nullIBMessageDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IBMessageDetailModelImpl.ENTITY_CACHE_ENABLED,
					IBMessageDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ibMessageDetail;
	}

	/**
	 * Returns the i b message detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ibMsgDetailId the primary key of the i b message detail
	 * @return the i b message detail, or <code>null</code> if a i b message detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IBMessageDetail fetchByPrimaryKey(long ibMsgDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ibMsgDetailId);
	}

	/**
	 * Returns all the i b message details.
	 *
	 * @return the i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the i b message details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @return the range of i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the i b message details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spinbox.model.impl.IBMessageDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of i b message details
	 * @param end the upper bound of the range of i b message details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of i b message details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IBMessageDetail> findAll(int start, int end,
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

		List<IBMessageDetail> list = (List<IBMessageDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IBMESSAGEDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IBMESSAGEDETAIL;

				if (pagination) {
					sql = sql.concat(IBMessageDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IBMessageDetail>(list);
				}
				else {
					list = (List<IBMessageDetail>)QueryUtil.list(q,
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
	 * Removes all the i b message details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (IBMessageDetail ibMessageDetail : findAll()) {
			remove(ibMessageDetail);
		}
	}

	/**
	 * Returns the number of i b message details.
	 *
	 * @return the number of i b message details
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

				Query q = session.createQuery(_SQL_COUNT_IBMESSAGEDETAIL);

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
	 * Initializes the i b message detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spinbox.model.IBMessageDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IBMessageDetail>> listenersList = new ArrayList<ModelListener<IBMessageDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IBMessageDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IBMessageDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IBMESSAGEDETAIL = "SELECT ibMessageDetail FROM IBMessageDetail ibMessageDetail";
	private static final String _SQL_SELECT_IBMESSAGEDETAIL_WHERE = "SELECT ibMessageDetail FROM IBMessageDetail ibMessageDetail WHERE ";
	private static final String _SQL_COUNT_IBMESSAGEDETAIL = "SELECT COUNT(ibMessageDetail) FROM IBMessageDetail ibMessageDetail";
	private static final String _SQL_COUNT_IBMESSAGEDETAIL_WHERE = "SELECT COUNT(ibMessageDetail) FROM IBMessageDetail ibMessageDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ibMessageDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IBMessageDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IBMessageDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IBMessageDetailPersistenceImpl.class);
	private static IBMessageDetail _nullIBMessageDetail = new IBMessageDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<IBMessageDetail> toCacheModel() {
				return _nullIBMessageDetailCacheModel;
			}
		};

	private static CacheModel<IBMessageDetail> _nullIBMessageDetailCacheModel = new CacheModel<IBMessageDetail>() {
			@Override
			public IBMessageDetail toEntityModel() {
				return _nullIBMessageDetail;
			}
		};
}