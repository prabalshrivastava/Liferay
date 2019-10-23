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

package com.sambaash.platform.srv.mail.service.persistence;

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

import com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException;
import com.sambaash.platform.srv.mail.model.SPEMailAudit;
import com.sambaash.platform.srv.mail.model.impl.SPEMailAuditImpl;
import com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p e mail audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPEMailAuditPersistence
 * @see SPEMailAuditUtil
 * @generated
 */
public class SPEMailAuditPersistenceImpl extends BasePersistenceImpl<SPEMailAudit>
	implements SPEMailAuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPEMailAuditUtil} to access the s p e mail audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPEMailAuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateIdAndNodeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateIdAndNodeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPEMailAuditModelImpl.PROCESSSTATEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.NODEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEID = new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateIdAndNodeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @return the matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId) throws SystemException {
		return findByProcessStateIdAndNodeId(processStateId, nodeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @return the range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId, int start, int end)
		throws SystemException {
		return findByProcessStateIdAndNodeId(processStateId, nodeId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeId(
		long processStateId, long nodeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID;
			finderArgs = new Object[] { processStateId, nodeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID;
			finderArgs = new Object[] {
					processStateId, nodeId,
					
					start, end, orderByComparator
				};
		}

		List<SPEMailAudit> list = (List<SPEMailAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPEMailAudit speMailAudit : list) {
				if ((processStateId != speMailAudit.getProcessStateId()) ||
						(nodeId != speMailAudit.getNodeId())) {
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

			query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_NODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				if (!pagination) {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPEMailAudit>(list);
				}
				else {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeId_First(
		long processStateId, long nodeId, OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeId_First(processStateId,
				nodeId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeId_First(
		long processStateId, long nodeId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPEMailAudit> list = findByProcessStateIdAndNodeId(processStateId,
				nodeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeId_Last(
		long processStateId, long nodeId, OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeId_Last(processStateId,
				nodeId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeId_Last(
		long processStateId, long nodeId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByProcessStateIdAndNodeId(processStateId, nodeId);

		if (count == 0) {
			return null;
		}

		List<SPEMailAudit> list = findByProcessStateIdAndNodeId(processStateId,
				nodeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spEMailAudit the primary key of the current s p e mail audit
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit[] findByProcessStateIdAndNodeId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = findByPrimaryKey(spEMailAudit);

		Session session = null;

		try {
			session = openSession();

			SPEMailAudit[] array = new SPEMailAuditImpl[3];

			array[0] = getByProcessStateIdAndNodeId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, orderByComparator,
					true);

			array[1] = speMailAudit;

			array[2] = getByProcessStateIdAndNodeId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, orderByComparator,
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

	protected SPEMailAudit getByProcessStateIdAndNodeId_PrevAndNext(
		Session session, SPEMailAudit speMailAudit, long processStateId,
		long nodeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_PROCESSSTATEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_NODEID_2);

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
			query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStateId);

		qPos.add(nodeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speMailAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPEMailAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; from the database.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateIdAndNodeId(long processStateId, long nodeId)
		throws SystemException {
		for (SPEMailAudit speMailAudit : findByProcessStateIdAndNodeId(
				processStateId, nodeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(speMailAudit);
		}
	}

	/**
	 * Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @return the number of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateIdAndNodeId(long processStateId, long nodeId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEID;

		Object[] finderArgs = new Object[] { processStateId, nodeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEID_NODEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEID_PROCESSSTATEID_2 =
		"speMailAudit.processStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEID_NODEID_2 = "speMailAudit.nodeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateIdAndNodeIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateIdAndNodeIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPEMailAuditModelImpl.PROCESSSTATEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.NODEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateIdAndNodeIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @return the matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId)
		throws SystemException {
		return findByProcessStateIdAndNodeIdAndUserId(processStateId, nodeId,
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @return the range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId, int start, int end)
		throws SystemException {
		return findByProcessStateIdAndNodeIdAndUserId(processStateId, nodeId,
			userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserId(
		long processStateId, long nodeId, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID;
			finderArgs = new Object[] { processStateId, nodeId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID;
			finderArgs = new Object[] {
					processStateId, nodeId, userId,
					
					start, end, orderByComparator
				};
		}

		List<SPEMailAudit> list = (List<SPEMailAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPEMailAudit speMailAudit : list) {
				if ((processStateId != speMailAudit.getProcessStateId()) ||
						(nodeId != speMailAudit.getNodeId()) ||
						(userId != speMailAudit.getUserId())) {
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

			query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPEMailAudit>(list);
				}
				else {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndUserId_First(
		long processStateId, long nodeId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndUserId_First(processStateId,
				nodeId, userId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserId_First(
		long processStateId, long nodeId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndUserId(processStateId,
				nodeId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndUserId_Last(
		long processStateId, long nodeId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndUserId_Last(processStateId,
				nodeId, userId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserId_Last(
		long processStateId, long nodeId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProcessStateIdAndNodeIdAndUserId(processStateId,
				nodeId, userId);

		if (count == 0) {
			return null;
		}

		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndUserId(processStateId,
				nodeId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param spEMailAudit the primary key of the current s p e mail audit
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit[] findByProcessStateIdAndNodeIdAndUserId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = findByPrimaryKey(spEMailAudit);

		Session session = null;

		try {
			session = openSession();

			SPEMailAudit[] array = new SPEMailAuditImpl[3];

			array[0] = getByProcessStateIdAndNodeIdAndUserId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, userId,
					orderByComparator, true);

			array[1] = speMailAudit;

			array[2] = getByProcessStateIdAndNodeIdAndUserId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, userId,
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

	protected SPEMailAudit getByProcessStateIdAndNodeIdAndUserId_PrevAndNext(
		Session session, SPEMailAudit speMailAudit, long processStateId,
		long nodeId, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_PROCESSSTATEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_NODEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_USERID_2);

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
			query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStateId);

		qPos.add(nodeId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speMailAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPEMailAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; from the database.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateIdAndNodeIdAndUserId(long processStateId,
		long nodeId, long userId) throws SystemException {
		for (SPEMailAudit speMailAudit : findByProcessStateIdAndNodeIdAndUserId(
				processStateId, nodeId, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(speMailAudit);
		}
	}

	/**
	 * Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @return the number of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateIdAndNodeIdAndUserId(long processStateId,
		long nodeId, long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERID;

		Object[] finderArgs = new Object[] { processStateId, nodeId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_PROCESSSTATEID_2 =
		"speMailAudit.processStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_NODEID_2 =
		"speMailAudit.nodeId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERID_USERID_2 =
		"speMailAudit.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateIdAndNodeIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateIdAndNodeIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SPEMailAuditModelImpl.PROCESSSTATEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.NODEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.ORGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateIdAndNodeIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @return the matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId) throws SystemException {
		return findByProcessStateIdAndNodeIdAndOrgId(processStateId, nodeId,
			orgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @return the range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId, int start, int end)
		throws SystemException {
		return findByProcessStateIdAndNodeIdAndOrgId(processStateId, nodeId,
			orgId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndOrgId(
		long processStateId, long nodeId, long orgId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID;
			finderArgs = new Object[] { processStateId, nodeId, orgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID;
			finderArgs = new Object[] {
					processStateId, nodeId, orgId,
					
					start, end, orderByComparator
				};
		}

		List<SPEMailAudit> list = (List<SPEMailAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPEMailAudit speMailAudit : list) {
				if ((processStateId != speMailAudit.getProcessStateId()) ||
						(nodeId != speMailAudit.getNodeId()) ||
						(orgId != speMailAudit.getOrgId())) {
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

			query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_ORGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				qPos.add(orgId);

				if (!pagination) {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPEMailAudit>(list);
				}
				else {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndOrgId_First(
		long processStateId, long nodeId, long orgId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndOrgId_First(processStateId,
				nodeId, orgId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", orgId=");
		msg.append(orgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndOrgId_First(
		long processStateId, long nodeId, long orgId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndOrgId(processStateId,
				nodeId, orgId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndOrgId_Last(
		long processStateId, long nodeId, long orgId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndOrgId_Last(processStateId,
				nodeId, orgId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", orgId=");
		msg.append(orgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndOrgId_Last(
		long processStateId, long nodeId, long orgId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProcessStateIdAndNodeIdAndOrgId(processStateId,
				nodeId, orgId);

		if (count == 0) {
			return null;
		}

		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndOrgId(processStateId,
				nodeId, orgId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param spEMailAudit the primary key of the current s p e mail audit
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit[] findByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long orgId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = findByPrimaryKey(spEMailAudit);

		Session session = null;

		try {
			session = openSession();

			SPEMailAudit[] array = new SPEMailAuditImpl[3];

			array[0] = getByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, orgId,
					orderByComparator, true);

			array[1] = speMailAudit;

			array[2] = getByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, orgId,
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

	protected SPEMailAudit getByProcessStateIdAndNodeIdAndOrgId_PrevAndNext(
		Session session, SPEMailAudit speMailAudit, long processStateId,
		long nodeId, long orgId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_PROCESSSTATEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_NODEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_ORGID_2);

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
			query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStateId);

		qPos.add(nodeId);

		qPos.add(orgId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speMailAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPEMailAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63; from the database.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateIdAndNodeIdAndOrgId(long processStateId,
		long nodeId, long orgId) throws SystemException {
		for (SPEMailAudit speMailAudit : findByProcessStateIdAndNodeIdAndOrgId(
				processStateId, nodeId, orgId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(speMailAudit);
		}
	}

	/**
	 * Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param orgId the org ID
	 * @return the number of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateIdAndNodeIdAndOrgId(long processStateId,
		long nodeId, long orgId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDORGID;

		Object[] finderArgs = new Object[] { processStateId, nodeId, orgId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_ORGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				qPos.add(orgId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_PROCESSSTATEID_2 =
		"speMailAudit.processStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_NODEID_2 =
		"speMailAudit.nodeId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDORGID_ORGID_2 =
		"speMailAudit.orgId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProcessStateIdAndNodeIdAndUserIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, SPEMailAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProcessStateIdAndNodeIdAndUserIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			SPEMailAuditModelImpl.PROCESSSTATEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.NODEID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.USERID_COLUMN_BITMASK |
			SPEMailAuditModelImpl.ORGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID =
		new FinderPath(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProcessStateIdAndNodeIdAndUserIdAndOrgId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @return the matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws SystemException {
		return findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @return the range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId, int start,
		int end) throws SystemException {
		return findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
			nodeId, userId, orgId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID;
			finderArgs = new Object[] { processStateId, nodeId, userId, orgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID;
			finderArgs = new Object[] {
					processStateId, nodeId, userId, orgId,
					
					start, end, orderByComparator
				};
		}

		List<SPEMailAudit> list = (List<SPEMailAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPEMailAudit speMailAudit : list) {
				if ((processStateId != speMailAudit.getProcessStateId()) ||
						(nodeId != speMailAudit.getNodeId()) ||
						(userId != speMailAudit.getUserId()) ||
						(orgId != speMailAudit.getOrgId())) {
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

			query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_USERID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_ORGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				qPos.add(userId);

				qPos.add(orgId);

				if (!pagination) {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPEMailAudit>(list);
				}
				else {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(
		long processStateId, long nodeId, long userId, long orgId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(processStateId,
				nodeId, userId, orgId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", orgId=");
		msg.append(orgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the first s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_First(
		long processStateId, long nodeId, long userId, long orgId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
				nodeId, userId, orgId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(
		long processStateId, long nodeId, long userId, long orgId,
		OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(processStateId,
				nodeId, userId, orgId, orderByComparator);

		if (speMailAudit != null) {
			return speMailAudit;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("processStateId=");
		msg.append(processStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", orgId=");
		msg.append(orgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPEMailAuditException(msg.toString());
	}

	/**
	 * Returns the last s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p e mail audit, or <code>null</code> if a matching s p e mail audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByProcessStateIdAndNodeIdAndUserIdAndOrgId_Last(
		long processStateId, long nodeId, long userId, long orgId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
				nodeId, userId, orgId);

		if (count == 0) {
			return null;
		}

		List<SPEMailAudit> list = findByProcessStateIdAndNodeIdAndUserIdAndOrgId(processStateId,
				nodeId, userId, orgId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p e mail audits before and after the current s p e mail audit in the ordered set where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param spEMailAudit the primary key of the current s p e mail audit
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit[] findByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(
		long spEMailAudit, long processStateId, long nodeId, long userId,
		long orgId, OrderByComparator orderByComparator)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = findByPrimaryKey(spEMailAudit);

		Session session = null;

		try {
			session = openSession();

			SPEMailAudit[] array = new SPEMailAuditImpl[3];

			array[0] = getByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, userId, orgId,
					orderByComparator, true);

			array[1] = speMailAudit;

			array[2] = getByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(session,
					speMailAudit, processStateId, nodeId, userId, orgId,
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

	protected SPEMailAudit getByProcessStateIdAndNodeIdAndUserIdAndOrgId_PrevAndNext(
		Session session, SPEMailAudit speMailAudit, long processStateId,
		long nodeId, long userId, long orgId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEMAILAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_PROCESSSTATEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_NODEID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_USERID_2);

		query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_ORGID_2);

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
			query.append(SPEMailAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(processStateId);

		qPos.add(nodeId);

		qPos.add(userId);

		qPos.add(orgId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speMailAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPEMailAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63; from the database.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws SystemException {
		for (SPEMailAudit speMailAudit : findByProcessStateIdAndNodeIdAndUserIdAndOrgId(
				processStateId, nodeId, userId, orgId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(speMailAudit);
		}
	}

	/**
	 * Returns the number of s p e mail audits where processStateId = &#63; and nodeId = &#63; and userId = &#63; and orgId = &#63;.
	 *
	 * @param processStateId the process state ID
	 * @param nodeId the node ID
	 * @param userId the user ID
	 * @param orgId the org ID
	 * @return the number of matching s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProcessStateIdAndNodeIdAndUserIdAndOrgId(
		long processStateId, long nodeId, long userId, long orgId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID;

		Object[] finderArgs = new Object[] { processStateId, nodeId, userId, orgId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SPEMAILAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_PROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_NODEID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_USERID_2);

			query.append(_FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_ORGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(processStateId);

				qPos.add(nodeId);

				qPos.add(userId);

				qPos.add(orgId);

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

	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_PROCESSSTATEID_2 =
		"speMailAudit.processStateId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_NODEID_2 =
		"speMailAudit.nodeId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_USERID_2 =
		"speMailAudit.userId = ? AND ";
	private static final String _FINDER_COLUMN_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID_ORGID_2 =
		"speMailAudit.orgId = ?";

	public SPEMailAuditPersistenceImpl() {
		setModelClass(SPEMailAudit.class);
	}

	/**
	 * Caches the s p e mail audit in the entity cache if it is enabled.
	 *
	 * @param speMailAudit the s p e mail audit
	 */
	@Override
	public void cacheResult(SPEMailAudit speMailAudit) {
		EntityCacheUtil.putResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditImpl.class, speMailAudit.getPrimaryKey(), speMailAudit);

		speMailAudit.resetOriginalValues();
	}

	/**
	 * Caches the s p e mail audits in the entity cache if it is enabled.
	 *
	 * @param speMailAudits the s p e mail audits
	 */
	@Override
	public void cacheResult(List<SPEMailAudit> speMailAudits) {
		for (SPEMailAudit speMailAudit : speMailAudits) {
			if (EntityCacheUtil.getResult(
						SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
						SPEMailAuditImpl.class, speMailAudit.getPrimaryKey()) == null) {
				cacheResult(speMailAudit);
			}
			else {
				speMailAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p e mail audits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPEMailAuditImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPEMailAuditImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p e mail audit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPEMailAudit speMailAudit) {
		EntityCacheUtil.removeResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditImpl.class, speMailAudit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPEMailAudit> speMailAudits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPEMailAudit speMailAudit : speMailAudits) {
			EntityCacheUtil.removeResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
				SPEMailAuditImpl.class, speMailAudit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p e mail audit with the primary key. Does not add the s p e mail audit to the database.
	 *
	 * @param spEMailAudit the primary key for the new s p e mail audit
	 * @return the new s p e mail audit
	 */
	@Override
	public SPEMailAudit create(long spEMailAudit) {
		SPEMailAudit speMailAudit = new SPEMailAuditImpl();

		speMailAudit.setNew(true);
		speMailAudit.setPrimaryKey(spEMailAudit);

		return speMailAudit;
	}

	/**
	 * Removes the s p e mail audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spEMailAudit the primary key of the s p e mail audit
	 * @return the s p e mail audit that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit remove(long spEMailAudit)
		throws NoSuchSPEMailAuditException, SystemException {
		return remove((Serializable)spEMailAudit);
	}

	/**
	 * Removes the s p e mail audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p e mail audit
	 * @return the s p e mail audit that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit remove(Serializable primaryKey)
		throws NoSuchSPEMailAuditException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPEMailAudit speMailAudit = (SPEMailAudit)session.get(SPEMailAuditImpl.class,
					primaryKey);

			if (speMailAudit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPEMailAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(speMailAudit);
		}
		catch (NoSuchSPEMailAuditException nsee) {
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
	protected SPEMailAudit removeImpl(SPEMailAudit speMailAudit)
		throws SystemException {
		speMailAudit = toUnwrappedModel(speMailAudit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(speMailAudit)) {
				speMailAudit = (SPEMailAudit)session.get(SPEMailAuditImpl.class,
						speMailAudit.getPrimaryKeyObj());
			}

			if (speMailAudit != null) {
				session.delete(speMailAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (speMailAudit != null) {
			clearCache(speMailAudit);
		}

		return speMailAudit;
	}

	@Override
	public SPEMailAudit updateImpl(
		com.sambaash.platform.srv.mail.model.SPEMailAudit speMailAudit)
		throws SystemException {
		speMailAudit = toUnwrappedModel(speMailAudit);

		boolean isNew = speMailAudit.isNew();

		SPEMailAuditModelImpl speMailAuditModelImpl = (SPEMailAuditModelImpl)speMailAudit;

		Session session = null;

		try {
			session = openSession();

			if (speMailAudit.isNew()) {
				session.save(speMailAudit);

				speMailAudit.setNew(false);
			}
			else {
				session.merge(speMailAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPEMailAuditModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((speMailAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speMailAuditModelImpl.getOriginalProcessStateId(),
						speMailAuditModelImpl.getOriginalNodeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID,
					args);

				args = new Object[] {
						speMailAuditModelImpl.getProcessStateId(),
						speMailAuditModelImpl.getNodeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEID,
					args);
			}

			if ((speMailAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speMailAuditModelImpl.getOriginalProcessStateId(),
						speMailAuditModelImpl.getOriginalNodeId(),
						speMailAuditModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID,
					args);

				args = new Object[] {
						speMailAuditModelImpl.getProcessStateId(),
						speMailAuditModelImpl.getNodeId(),
						speMailAuditModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERID,
					args);
			}

			if ((speMailAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speMailAuditModelImpl.getOriginalProcessStateId(),
						speMailAuditModelImpl.getOriginalNodeId(),
						speMailAuditModelImpl.getOriginalOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID,
					args);

				args = new Object[] {
						speMailAuditModelImpl.getProcessStateId(),
						speMailAuditModelImpl.getNodeId(),
						speMailAuditModelImpl.getOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDORGID,
					args);
			}

			if ((speMailAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speMailAuditModelImpl.getOriginalProcessStateId(),
						speMailAuditModelImpl.getOriginalNodeId(),
						speMailAuditModelImpl.getOriginalUserId(),
						speMailAuditModelImpl.getOriginalOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID,
					args);

				args = new Object[] {
						speMailAuditModelImpl.getProcessStateId(),
						speMailAuditModelImpl.getNodeId(),
						speMailAuditModelImpl.getUserId(),
						speMailAuditModelImpl.getOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROCESSSTATEIDANDNODEIDANDUSERIDANDORGID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
			SPEMailAuditImpl.class, speMailAudit.getPrimaryKey(), speMailAudit);

		return speMailAudit;
	}

	protected SPEMailAudit toUnwrappedModel(SPEMailAudit speMailAudit) {
		if (speMailAudit instanceof SPEMailAuditImpl) {
			return speMailAudit;
		}

		SPEMailAuditImpl speMailAuditImpl = new SPEMailAuditImpl();

		speMailAuditImpl.setNew(speMailAudit.isNew());
		speMailAuditImpl.setPrimaryKey(speMailAudit.getPrimaryKey());

		speMailAuditImpl.setSpEMailAudit(speMailAudit.getSpEMailAudit());
		speMailAuditImpl.setGroupId(speMailAudit.getGroupId());
		speMailAuditImpl.setCompanyId(speMailAudit.getCompanyId());
		speMailAuditImpl.setSentTo(speMailAudit.getSentTo());
		speMailAuditImpl.setCc(speMailAudit.getCc());
		speMailAuditImpl.setBcc(speMailAudit.getBcc());
		speMailAuditImpl.setCategory(speMailAudit.getCategory());
		speMailAuditImpl.setSubject(speMailAudit.getSubject());
		speMailAuditImpl.setContent(speMailAudit.getContent());
		speMailAuditImpl.setSentDate(speMailAudit.getSentDate());
		speMailAuditImpl.setMessasgeId(speMailAudit.getMessasgeId());
		speMailAuditImpl.setUserId(speMailAudit.getUserId());
		speMailAuditImpl.setOrgId(speMailAudit.getOrgId());
		speMailAuditImpl.setProcessStateId(speMailAudit.getProcessStateId());
		speMailAuditImpl.setNodeId(speMailAudit.getNodeId());

		return speMailAuditImpl;
	}

	/**
	 * Returns the s p e mail audit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p e mail audit
	 * @return the s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPEMailAuditException, SystemException {
		SPEMailAudit speMailAudit = fetchByPrimaryKey(primaryKey);

		if (speMailAudit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPEMailAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return speMailAudit;
	}

	/**
	 * Returns the s p e mail audit with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException} if it could not be found.
	 *
	 * @param spEMailAudit the primary key of the s p e mail audit
	 * @return the s p e mail audit
	 * @throws com.sambaash.platform.srv.mail.NoSuchSPEMailAuditException if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit findByPrimaryKey(long spEMailAudit)
		throws NoSuchSPEMailAuditException, SystemException {
		return findByPrimaryKey((Serializable)spEMailAudit);
	}

	/**
	 * Returns the s p e mail audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p e mail audit
	 * @return the s p e mail audit, or <code>null</code> if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPEMailAudit speMailAudit = (SPEMailAudit)EntityCacheUtil.getResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
				SPEMailAuditImpl.class, primaryKey);

		if (speMailAudit == _nullSPEMailAudit) {
			return null;
		}

		if (speMailAudit == null) {
			Session session = null;

			try {
				session = openSession();

				speMailAudit = (SPEMailAudit)session.get(SPEMailAuditImpl.class,
						primaryKey);

				if (speMailAudit != null) {
					cacheResult(speMailAudit);
				}
				else {
					EntityCacheUtil.putResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
						SPEMailAuditImpl.class, primaryKey, _nullSPEMailAudit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPEMailAuditModelImpl.ENTITY_CACHE_ENABLED,
					SPEMailAuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return speMailAudit;
	}

	/**
	 * Returns the s p e mail audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spEMailAudit the primary key of the s p e mail audit
	 * @return the s p e mail audit, or <code>null</code> if a s p e mail audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPEMailAudit fetchByPrimaryKey(long spEMailAudit)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spEMailAudit);
	}

	/**
	 * Returns all the s p e mail audits.
	 *
	 * @return the s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p e mail audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @return the range of s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p e mail audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPEMailAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p e mail audits
	 * @param end the upper bound of the range of s p e mail audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p e mail audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPEMailAudit> findAll(int start, int end,
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

		List<SPEMailAudit> list = (List<SPEMailAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPEMAILAUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPEMAILAUDIT;

				if (pagination) {
					sql = sql.concat(SPEMailAuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPEMailAudit>(list);
				}
				else {
					list = (List<SPEMailAudit>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p e mail audits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPEMailAudit speMailAudit : findAll()) {
			remove(speMailAudit);
		}
	}

	/**
	 * Returns the number of s p e mail audits.
	 *
	 * @return the number of s p e mail audits
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

				Query q = session.createQuery(_SQL_COUNT_SPEMAILAUDIT);

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
	 * Initializes the s p e mail audit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPEMailAudit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPEMailAudit>> listenersList = new ArrayList<ModelListener<SPEMailAudit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPEMailAudit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPEMailAuditImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPEMAILAUDIT = "SELECT speMailAudit FROM SPEMailAudit speMailAudit";
	private static final String _SQL_SELECT_SPEMAILAUDIT_WHERE = "SELECT speMailAudit FROM SPEMailAudit speMailAudit WHERE ";
	private static final String _SQL_COUNT_SPEMAILAUDIT = "SELECT COUNT(speMailAudit) FROM SPEMailAudit speMailAudit";
	private static final String _SQL_COUNT_SPEMAILAUDIT_WHERE = "SELECT COUNT(speMailAudit) FROM SPEMailAudit speMailAudit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "speMailAudit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPEMailAudit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPEMailAudit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPEMailAuditPersistenceImpl.class);
	private static SPEMailAudit _nullSPEMailAudit = new SPEMailAuditImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPEMailAudit> toCacheModel() {
				return _nullSPEMailAuditCacheModel;
			}
		};

	private static CacheModel<SPEMailAudit> _nullSPEMailAuditCacheModel = new CacheModel<SPEMailAudit>() {
			@Override
			public SPEMailAudit toEntityModel() {
				return _nullSPEMailAudit;
			}
		};
}