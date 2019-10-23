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

package com.sambaash.platform.srv.spasset.service.persistence;

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

import com.sambaash.platform.srv.spasset.NoSuchTypeException;
import com.sambaash.platform.srv.spasset.model.SPAssetType;
import com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeImpl;
import com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p asset type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPAssetTypePersistence
 * @see SPAssetTypeUtil
 * @generated
 */
public class SPAssetTypePersistenceImpl extends BasePersistenceImpl<SPAssetType>
	implements SPAssetTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPAssetTypeUtil} to access the s p asset type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPAssetTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SPAssetTypeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p asset types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @return the range of matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findByGroupId(long groupId, int start, int end,
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

		List<SPAssetType> list = (List<SPAssetType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAssetType spAssetType : list) {
				if ((groupId != spAssetType.getGroupId())) {
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

			query.append(_SQL_SELECT_SPASSETTYPE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAssetTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetType>(list);
				}
				else {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p asset type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = fetchByGroupId_First(groupId,
				orderByComparator);

		if (spAssetType != null) {
			return spAssetType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first s p asset type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPAssetType> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p asset type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = fetchByGroupId_Last(groupId, orderByComparator);

		if (spAssetType != null) {
			return spAssetType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last s p asset type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SPAssetType> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p asset types before and after the current s p asset type in the ordered set where groupId = &#63;.
	 *
	 * @param spAssetTypeId the primary key of the current s p asset type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType[] findByGroupId_PrevAndNext(long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = findByPrimaryKey(spAssetTypeId);

		Session session = null;

		try {
			session = openSession();

			SPAssetType[] array = new SPAssetTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, spAssetType, groupId,
					orderByComparator, true);

			array[1] = spAssetType;

			array[2] = getByGroupId_PrevAndNext(session, spAssetType, groupId,
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

	protected SPAssetType getByGroupId_PrevAndNext(Session session,
		SPAssetType spAssetType, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPASSETTYPE_WHERE);

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
			query.append(SPAssetTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p asset types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (SPAssetType spAssetType : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAssetType);
		}
	}

	/**
	 * Returns the number of s p asset types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching s p asset types
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

			query.append(_SQL_COUNT_SPASSETTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "spAssetType.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, SPAssetTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Boolean.class.getName() },
			SPAssetTypeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the s p asset types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findBystatus(boolean status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @return the range of matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findBystatus(boolean status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findBystatus(boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SPAssetType> list = (List<SPAssetType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAssetType spAssetType : list) {
				if ((status != spAssetType.getStatus())) {
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

			query.append(_SQL_SELECT_SPASSETTYPE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAssetTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetType>(list);
				}
				else {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p asset type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findBystatus_First(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = fetchBystatus_First(status, orderByComparator);

		if (spAssetType != null) {
			return spAssetType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the first s p asset type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchBystatus_First(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPAssetType> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p asset type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findBystatus_Last(boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = fetchBystatus_Last(status, orderByComparator);

		if (spAssetType != null) {
			return spAssetType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTypeException(msg.toString());
	}

	/**
	 * Returns the last s p asset type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset type, or <code>null</code> if a matching s p asset type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchBystatus_Last(boolean status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<SPAssetType> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p asset types before and after the current s p asset type in the ordered set where status = &#63;.
	 *
	 * @param spAssetTypeId the primary key of the current s p asset type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType[] findBystatus_PrevAndNext(long spAssetTypeId,
		boolean status, OrderByComparator orderByComparator)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = findByPrimaryKey(spAssetTypeId);

		Session session = null;

		try {
			session = openSession();

			SPAssetType[] array = new SPAssetTypeImpl[3];

			array[0] = getBystatus_PrevAndNext(session, spAssetType, status,
					orderByComparator, true);

			array[1] = spAssetType;

			array[2] = getBystatus_PrevAndNext(session, spAssetType, status,
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

	protected SPAssetType getBystatus_PrevAndNext(Session session,
		SPAssetType spAssetType, boolean status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPASSETTYPE_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(SPAssetTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p asset types where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(boolean status) throws SystemException {
		for (SPAssetType spAssetType : findBystatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spAssetType);
		}
	}

	/**
	 * Returns the number of s p asset types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPASSETTYPE_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "spAssetType.status = ?";

	public SPAssetTypePersistenceImpl() {
		setModelClass(SPAssetType.class);
	}

	/**
	 * Caches the s p asset type in the entity cache if it is enabled.
	 *
	 * @param spAssetType the s p asset type
	 */
	@Override
	public void cacheResult(SPAssetType spAssetType) {
		EntityCacheUtil.putResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeImpl.class, spAssetType.getPrimaryKey(), spAssetType);

		spAssetType.resetOriginalValues();
	}

	/**
	 * Caches the s p asset types in the entity cache if it is enabled.
	 *
	 * @param spAssetTypes the s p asset types
	 */
	@Override
	public void cacheResult(List<SPAssetType> spAssetTypes) {
		for (SPAssetType spAssetType : spAssetTypes) {
			if (EntityCacheUtil.getResult(
						SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPAssetTypeImpl.class, spAssetType.getPrimaryKey()) == null) {
				cacheResult(spAssetType);
			}
			else {
				spAssetType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p asset types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPAssetTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPAssetTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p asset type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPAssetType spAssetType) {
		EntityCacheUtil.removeResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeImpl.class, spAssetType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPAssetType> spAssetTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPAssetType spAssetType : spAssetTypes) {
			EntityCacheUtil.removeResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPAssetTypeImpl.class, spAssetType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p asset type with the primary key. Does not add the s p asset type to the database.
	 *
	 * @param spAssetTypeId the primary key for the new s p asset type
	 * @return the new s p asset type
	 */
	@Override
	public SPAssetType create(long spAssetTypeId) {
		SPAssetType spAssetType = new SPAssetTypeImpl();

		spAssetType.setNew(true);
		spAssetType.setPrimaryKey(spAssetTypeId);

		return spAssetType;
	}

	/**
	 * Removes the s p asset type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAssetTypeId the primary key of the s p asset type
	 * @return the s p asset type that was removed
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType remove(long spAssetTypeId)
		throws NoSuchTypeException, SystemException {
		return remove((Serializable)spAssetTypeId);
	}

	/**
	 * Removes the s p asset type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p asset type
	 * @return the s p asset type that was removed
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType remove(Serializable primaryKey)
		throws NoSuchTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPAssetType spAssetType = (SPAssetType)session.get(SPAssetTypeImpl.class,
					primaryKey);

			if (spAssetType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spAssetType);
		}
		catch (NoSuchTypeException nsee) {
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
	protected SPAssetType removeImpl(SPAssetType spAssetType)
		throws SystemException {
		spAssetType = toUnwrappedModel(spAssetType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spAssetType)) {
				spAssetType = (SPAssetType)session.get(SPAssetTypeImpl.class,
						spAssetType.getPrimaryKeyObj());
			}

			if (spAssetType != null) {
				session.delete(spAssetType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spAssetType != null) {
			clearCache(spAssetType);
		}

		return spAssetType;
	}

	@Override
	public SPAssetType updateImpl(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType)
		throws SystemException {
		spAssetType = toUnwrappedModel(spAssetType);

		boolean isNew = spAssetType.isNew();

		SPAssetTypeModelImpl spAssetTypeModelImpl = (SPAssetTypeModelImpl)spAssetType;

		Session session = null;

		try {
			session = openSession();

			if (spAssetType.isNew()) {
				session.save(spAssetType);

				spAssetType.setNew(false);
			}
			else {
				session.merge(spAssetType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPAssetTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spAssetTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAssetTypeModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { spAssetTypeModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((spAssetTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAssetTypeModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { spAssetTypeModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetTypeImpl.class, spAssetType.getPrimaryKey(), spAssetType);

		return spAssetType;
	}

	protected SPAssetType toUnwrappedModel(SPAssetType spAssetType) {
		if (spAssetType instanceof SPAssetTypeImpl) {
			return spAssetType;
		}

		SPAssetTypeImpl spAssetTypeImpl = new SPAssetTypeImpl();

		spAssetTypeImpl.setNew(spAssetType.isNew());
		spAssetTypeImpl.setPrimaryKey(spAssetType.getPrimaryKey());

		spAssetTypeImpl.setUuid_(spAssetType.getUuid_());
		spAssetTypeImpl.setSpAssetTypeId(spAssetType.getSpAssetTypeId());
		spAssetTypeImpl.setGroupId(spAssetType.getGroupId());
		spAssetTypeImpl.setCompanyId(spAssetType.getCompanyId());
		spAssetTypeImpl.setUserId(spAssetType.getUserId());
		spAssetTypeImpl.setUserName(spAssetType.getUserName());
		spAssetTypeImpl.setCreateDate(spAssetType.getCreateDate());
		spAssetTypeImpl.setModifiedDate(spAssetType.getModifiedDate());
		spAssetTypeImpl.setSpAssetTypeName(spAssetType.getSpAssetTypeName());
		spAssetTypeImpl.setStatus(spAssetType.isStatus());
		spAssetTypeImpl.setModifiedBy(spAssetType.getModifiedBy());
		spAssetTypeImpl.setSpAssetTypeCreateUrl(spAssetType.getSpAssetTypeCreateUrl());
		spAssetTypeImpl.setSpAssetTypeDetailUrl(spAssetType.getSpAssetTypeDetailUrl());
		spAssetTypeImpl.setSpAssetTypeInnerDetailUrl(spAssetType.getSpAssetTypeInnerDetailUrl());
		spAssetTypeImpl.setRequiredTermsOfUse(spAssetType.isRequiredTermsOfUse());
		spAssetTypeImpl.setRequiredLogin(spAssetType.isRequiredLogin());
		spAssetTypeImpl.setCategoryMandatory(spAssetType.isCategoryMandatory());
		spAssetTypeImpl.setNotifyUponCreation(spAssetType.isNotifyUponCreation());
		spAssetTypeImpl.setNotificationTemplateId(spAssetType.getNotificationTemplateId());
		spAssetTypeImpl.setAllowedFileTypes(spAssetType.getAllowedFileTypes());
		spAssetTypeImpl.setMaxFileSize(spAssetType.getMaxFileSize());
		spAssetTypeImpl.setMinImageHeight(spAssetType.getMinImageHeight());
		spAssetTypeImpl.setMinImageWidth(spAssetType.getMinImageWidth());

		return spAssetTypeImpl;
	}

	/**
	 * Returns the s p asset type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p asset type
	 * @return the s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTypeException, SystemException {
		SPAssetType spAssetType = fetchByPrimaryKey(primaryKey);

		if (spAssetType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spAssetType;
	}

	/**
	 * Returns the s p asset type with the primary key or throws a {@link com.sambaash.platform.srv.spasset.NoSuchTypeException} if it could not be found.
	 *
	 * @param spAssetTypeId the primary key of the s p asset type
	 * @return the s p asset type
	 * @throws com.sambaash.platform.srv.spasset.NoSuchTypeException if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType findByPrimaryKey(long spAssetTypeId)
		throws NoSuchTypeException, SystemException {
		return findByPrimaryKey((Serializable)spAssetTypeId);
	}

	/**
	 * Returns the s p asset type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p asset type
	 * @return the s p asset type, or <code>null</code> if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPAssetType spAssetType = (SPAssetType)EntityCacheUtil.getResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
				SPAssetTypeImpl.class, primaryKey);

		if (spAssetType == _nullSPAssetType) {
			return null;
		}

		if (spAssetType == null) {
			Session session = null;

			try {
				session = openSession();

				spAssetType = (SPAssetType)session.get(SPAssetTypeImpl.class,
						primaryKey);

				if (spAssetType != null) {
					cacheResult(spAssetType);
				}
				else {
					EntityCacheUtil.putResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
						SPAssetTypeImpl.class, primaryKey, _nullSPAssetType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPAssetTypeModelImpl.ENTITY_CACHE_ENABLED,
					SPAssetTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spAssetType;
	}

	/**
	 * Returns the s p asset type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAssetTypeId the primary key of the s p asset type
	 * @return the s p asset type, or <code>null</code> if a s p asset type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetType fetchByPrimaryKey(long spAssetTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAssetTypeId);
	}

	/**
	 * Returns all the s p asset types.
	 *
	 * @return the s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @return the range of s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p asset types
	 * @param end the upper bound of the range of s p asset types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p asset types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetType> findAll(int start, int end,
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

		List<SPAssetType> list = (List<SPAssetType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPASSETTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPASSETTYPE;

				if (pagination) {
					sql = sql.concat(SPAssetTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetType>(list);
				}
				else {
					list = (List<SPAssetType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p asset types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPAssetType spAssetType : findAll()) {
			remove(spAssetType);
		}
	}

	/**
	 * Returns the number of s p asset types.
	 *
	 * @return the number of s p asset types
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

				Query q = session.createQuery(_SQL_COUNT_SPASSETTYPE);

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
	 * Initializes the s p asset type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spasset.model.SPAssetType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPAssetType>> listenersList = new ArrayList<ModelListener<SPAssetType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPAssetType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPAssetTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPASSETTYPE = "SELECT spAssetType FROM SPAssetType spAssetType";
	private static final String _SQL_SELECT_SPASSETTYPE_WHERE = "SELECT spAssetType FROM SPAssetType spAssetType WHERE ";
	private static final String _SQL_COUNT_SPASSETTYPE = "SELECT COUNT(spAssetType) FROM SPAssetType spAssetType";
	private static final String _SQL_COUNT_SPASSETTYPE_WHERE = "SELECT COUNT(spAssetType) FROM SPAssetType spAssetType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spAssetType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPAssetType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPAssetType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPAssetTypePersistenceImpl.class);
	private static SPAssetType _nullSPAssetType = new SPAssetTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPAssetType> toCacheModel() {
				return _nullSPAssetTypeCacheModel;
			}
		};

	private static CacheModel<SPAssetType> _nullSPAssetTypeCacheModel = new CacheModel<SPAssetType>() {
			@Override
			public SPAssetType toEntityModel() {
				return _nullSPAssetType;
			}
		};
}