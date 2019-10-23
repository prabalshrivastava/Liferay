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

import com.sambaash.platform.srv.NoSuchOutlineException;
import com.sambaash.platform.srv.model.Outline;
import com.sambaash.platform.srv.model.impl.OutlineImpl;
import com.sambaash.platform.srv.model.impl.OutlineModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the outline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see OutlinePersistence
 * @see OutlineUtil
 * @generated
 */
public class OutlinePersistenceImpl extends BasePersistenceImpl<Outline>
	implements OutlinePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OutlineUtil} to access the outline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OutlineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			OutlineModelImpl.GROUPID_COLUMN_BITMASK |
			OutlineModelImpl.OUTLINETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the outlines where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outlines where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @return the range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the outlines where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupId(long groupId, int start, int end,
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

		List<Outline> list = (List<Outline>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outline outline : list) {
				if ((groupId != outline.getGroupId())) {
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

			query.append(_SQL_SELECT_OUTLINE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutlineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outline>(list);
				}
				else {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outline in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupId_First(groupId, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the first outline in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Outline> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupId_Last(groupId, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Outline> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outlines before and after the current outline in the ordered set where groupId = &#63;.
	 *
	 * @param spOutlineId the primary key of the current outline
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline[] findByGroupId_PrevAndNext(long spOutlineId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = findByPrimaryKey(spOutlineId);

		Session session = null;

		try {
			session = openSession();

			Outline[] array = new OutlineImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, outline, groupId,
					orderByComparator, true);

			array[1] = outline;

			array[2] = getByGroupId_PrevAndNext(session, outline, groupId,
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

	protected Outline getByGroupId_PrevAndNext(Session session,
		Outline outline, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTLINE_WHERE);

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
			query.append(OutlineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outline);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outline> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outlines where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Outline outline : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(outline);
		}
	}

	/**
	 * Returns the number of outlines where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching outlines
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

			query.append(_SQL_COUNT_OUTLINE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "outline.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndOutlineType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndOutlineType",
			new String[] { Long.class.getName(), Long.class.getName() },
			OutlineModelImpl.GROUPID_COLUMN_BITMASK |
			OutlineModelImpl.OUTLINETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDOUTLINETYPE = new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndOutlineType",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the outlines where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @return the matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndOutlineType(long groupId,
		long outlineType) throws SystemException {
		return findByGroupIdAndOutlineType(groupId, outlineType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outlines where groupId = &#63; and outlineType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @return the range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndOutlineType(long groupId,
		long outlineType, int start, int end) throws SystemException {
		return findByGroupIdAndOutlineType(groupId, outlineType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the outlines where groupId = &#63; and outlineType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndOutlineType(long groupId,
		long outlineType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE;
			finderArgs = new Object[] { groupId, outlineType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE;
			finderArgs = new Object[] {
					groupId, outlineType,
					
					start, end, orderByComparator
				};
		}

		List<Outline> list = (List<Outline>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outline outline : list) {
				if ((groupId != outline.getGroupId()) ||
						(outlineType != outline.getOutlineType())) {
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

			query.append(_SQL_SELECT_OUTLINE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_OUTLINETYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutlineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(outlineType);

				if (!pagination) {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outline>(list);
				}
				else {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupIdAndOutlineType_First(long groupId,
		long outlineType, OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupIdAndOutlineType_First(groupId,
				outlineType, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", outlineType=");
		msg.append(outlineType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the first outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupIdAndOutlineType_First(long groupId,
		long outlineType, OrderByComparator orderByComparator)
		throws SystemException {
		List<Outline> list = findByGroupIdAndOutlineType(groupId, outlineType,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupIdAndOutlineType_Last(long groupId,
		long outlineType, OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupIdAndOutlineType_Last(groupId,
				outlineType, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", outlineType=");
		msg.append(outlineType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupIdAndOutlineType_Last(long groupId,
		long outlineType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndOutlineType(groupId, outlineType);

		if (count == 0) {
			return null;
		}

		List<Outline> list = findByGroupIdAndOutlineType(groupId, outlineType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outlines before and after the current outline in the ordered set where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param spOutlineId the primary key of the current outline
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline[] findByGroupIdAndOutlineType_PrevAndNext(long spOutlineId,
		long groupId, long outlineType, OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = findByPrimaryKey(spOutlineId);

		Session session = null;

		try {
			session = openSession();

			Outline[] array = new OutlineImpl[3];

			array[0] = getByGroupIdAndOutlineType_PrevAndNext(session, outline,
					groupId, outlineType, orderByComparator, true);

			array[1] = outline;

			array[2] = getByGroupIdAndOutlineType_PrevAndNext(session, outline,
					groupId, outlineType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Outline getByGroupIdAndOutlineType_PrevAndNext(Session session,
		Outline outline, long groupId, long outlineType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTLINE_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_OUTLINETYPE_2);

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
			query.append(OutlineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(outlineType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outline);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outline> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outlines where groupId = &#63; and outlineType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndOutlineType(long groupId, long outlineType)
		throws SystemException {
		for (Outline outline : findByGroupIdAndOutlineType(groupId,
				outlineType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(outline);
		}
	}

	/**
	 * Returns the number of outlines where groupId = &#63; and outlineType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param outlineType the outline type
	 * @return the number of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndOutlineType(long groupId, long outlineType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDOUTLINETYPE;

		Object[] finderArgs = new Object[] { groupId, outlineType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OUTLINE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDOUTLINETYPE_OUTLINETYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(outlineType);

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

	private static final String _FINDER_COLUMN_GROUPIDANDOUTLINETYPE_GROUPID_2 = "outline.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDOUTLINETYPE_OUTLINETYPE_2 =
		"outline.outlineType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndCompetencyUnitId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, OutlineImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndCompetencyUnitId",
			new String[] { Long.class.getName(), Long.class.getName() },
			OutlineModelImpl.GROUPID_COLUMN_BITMASK |
			OutlineModelImpl.SPCOMPETENCYUNITID_COLUMN_BITMASK |
			OutlineModelImpl.OUTLINETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID =
		new FinderPath(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndCompetencyUnitId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		return findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @return the range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId, int start, int end) throws SystemException {
		return findByGroupIdAndCompetencyUnitId(groupId, spCompetencyUnitId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] { groupId, spCompetencyUnitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID;
			finderArgs = new Object[] {
					groupId, spCompetencyUnitId,
					
					start, end, orderByComparator
				};
		}

		List<Outline> list = (List<Outline>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Outline outline : list) {
				if ((groupId != outline.getGroupId()) ||
						(spCompetencyUnitId != outline.getSpCompetencyUnitId())) {
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

			query.append(_SQL_SELECT_OUTLINE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OutlineModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

				if (!pagination) {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outline>(list);
				}
				else {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupIdAndCompetencyUnitId_First(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupIdAndCompetencyUnitId_First(groupId,
				spCompetencyUnitId, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the first outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupIdAndCompetencyUnitId_First(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Outline> list = findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByGroupIdAndCompetencyUnitId_Last(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByGroupIdAndCompetencyUnitId_Last(groupId,
				spCompetencyUnitId, orderByComparator);

		if (outline != null) {
			return outline;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOutlineException(msg.toString());
	}

	/**
	 * Returns the last outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching outline, or <code>null</code> if a matching outline could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByGroupIdAndCompetencyUnitId_Last(long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId);

		if (count == 0) {
			return null;
		}

		List<Outline> list = findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the outlines before and after the current outline in the ordered set where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param spOutlineId the primary key of the current outline
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline[] findByGroupIdAndCompetencyUnitId_PrevAndNext(
		long spOutlineId, long groupId, long spCompetencyUnitId,
		OrderByComparator orderByComparator)
		throws NoSuchOutlineException, SystemException {
		Outline outline = findByPrimaryKey(spOutlineId);

		Session session = null;

		try {
			session = openSession();

			Outline[] array = new OutlineImpl[3];

			array[0] = getByGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outline, groupId, spCompetencyUnitId, orderByComparator,
					true);

			array[1] = outline;

			array[2] = getByGroupIdAndCompetencyUnitId_PrevAndNext(session,
					outline, groupId, spCompetencyUnitId, orderByComparator,
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

	protected Outline getByGroupIdAndCompetencyUnitId_PrevAndNext(
		Session session, Outline outline, long groupId,
		long spCompetencyUnitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OUTLINE_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

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
			query.append(OutlineModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(spCompetencyUnitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(outline);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Outline> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the outlines where groupId = &#63; and spCompetencyUnitId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		for (Outline outline : findByGroupIdAndCompetencyUnitId(groupId,
				spCompetencyUnitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(outline);
		}
	}

	/**
	 * Returns the number of outlines where groupId = &#63; and spCompetencyUnitId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @return the number of matching outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdAndCompetencyUnitId(long groupId,
		long spCompetencyUnitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID;

		Object[] finderArgs = new Object[] { groupId, spCompetencyUnitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OUTLINE_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(spCompetencyUnitId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_GROUPID_2 =
		"outline.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDCOMPETENCYUNITID_SPCOMPETENCYUNITID_2 =
		"outline.spCompetencyUnitId = ?";

	public OutlinePersistenceImpl() {
		setModelClass(Outline.class);
	}

	/**
	 * Caches the outline in the entity cache if it is enabled.
	 *
	 * @param outline the outline
	 */
	@Override
	public void cacheResult(Outline outline) {
		EntityCacheUtil.putResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineImpl.class, outline.getPrimaryKey(), outline);

		outline.resetOriginalValues();
	}

	/**
	 * Caches the outlines in the entity cache if it is enabled.
	 *
	 * @param outlines the outlines
	 */
	@Override
	public void cacheResult(List<Outline> outlines) {
		for (Outline outline : outlines) {
			if (EntityCacheUtil.getResult(
						OutlineModelImpl.ENTITY_CACHE_ENABLED,
						OutlineImpl.class, outline.getPrimaryKey()) == null) {
				cacheResult(outline);
			}
			else {
				outline.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all outlines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OutlineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OutlineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the outline.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Outline outline) {
		EntityCacheUtil.removeResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineImpl.class, outline.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Outline> outlines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Outline outline : outlines) {
			EntityCacheUtil.removeResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
				OutlineImpl.class, outline.getPrimaryKey());
		}
	}

	/**
	 * Creates a new outline with the primary key. Does not add the outline to the database.
	 *
	 * @param spOutlineId the primary key for the new outline
	 * @return the new outline
	 */
	@Override
	public Outline create(long spOutlineId) {
		Outline outline = new OutlineImpl();

		outline.setNew(true);
		outline.setPrimaryKey(spOutlineId);

		return outline;
	}

	/**
	 * Removes the outline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spOutlineId the primary key of the outline
	 * @return the outline that was removed
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline remove(long spOutlineId)
		throws NoSuchOutlineException, SystemException {
		return remove((Serializable)spOutlineId);
	}

	/**
	 * Removes the outline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the outline
	 * @return the outline that was removed
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline remove(Serializable primaryKey)
		throws NoSuchOutlineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Outline outline = (Outline)session.get(OutlineImpl.class, primaryKey);

			if (outline == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOutlineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(outline);
		}
		catch (NoSuchOutlineException nsee) {
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
	protected Outline removeImpl(Outline outline) throws SystemException {
		outline = toUnwrappedModel(outline);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(outline)) {
				outline = (Outline)session.get(OutlineImpl.class,
						outline.getPrimaryKeyObj());
			}

			if (outline != null) {
				session.delete(outline);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (outline != null) {
			clearCache(outline);
		}

		return outline;
	}

	@Override
	public Outline updateImpl(com.sambaash.platform.srv.model.Outline outline)
		throws SystemException {
		outline = toUnwrappedModel(outline);

		boolean isNew = outline.isNew();

		OutlineModelImpl outlineModelImpl = (OutlineModelImpl)outline;

		Session session = null;

		try {
			session = openSession();

			if (outline.isNew()) {
				session.save(outline);

				outline.setNew(false);
			}
			else {
				session.merge(outline);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OutlineModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((outlineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outlineModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { outlineModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((outlineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outlineModelImpl.getOriginalGroupId(),
						outlineModelImpl.getOriginalOutlineType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDOUTLINETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE,
					args);

				args = new Object[] {
						outlineModelImpl.getGroupId(),
						outlineModelImpl.getOutlineType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDOUTLINETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDOUTLINETYPE,
					args);
			}

			if ((outlineModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						outlineModelImpl.getOriginalGroupId(),
						outlineModelImpl.getOriginalSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID,
					args);

				args = new Object[] {
						outlineModelImpl.getGroupId(),
						outlineModelImpl.getSpCompetencyUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDCOMPETENCYUNITID,
					args);
			}
		}

		EntityCacheUtil.putResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
			OutlineImpl.class, outline.getPrimaryKey(), outline);

		return outline;
	}

	protected Outline toUnwrappedModel(Outline outline) {
		if (outline instanceof OutlineImpl) {
			return outline;
		}

		OutlineImpl outlineImpl = new OutlineImpl();

		outlineImpl.setNew(outline.isNew());
		outlineImpl.setPrimaryKey(outline.getPrimaryKey());

		outlineImpl.setSpOutlineId(outline.getSpOutlineId());
		outlineImpl.setGroupId(outline.getGroupId());
		outlineImpl.setCompanyId(outline.getCompanyId());
		outlineImpl.setUserId(outline.getUserId());
		outlineImpl.setUserName(outline.getUserName());
		outlineImpl.setCreateDate(outline.getCreateDate());
		outlineImpl.setModifiedDate(outline.getModifiedDate());
		outlineImpl.setSpCompetencyUnitId(outline.getSpCompetencyUnitId());
		outlineImpl.setOutlineType(outline.getOutlineType());
		outlineImpl.setOutlineDesc(outline.getOutlineDesc());

		return outlineImpl;
	}

	/**
	 * Returns the outline with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the outline
	 * @return the outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOutlineException, SystemException {
		Outline outline = fetchByPrimaryKey(primaryKey);

		if (outline == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOutlineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return outline;
	}

	/**
	 * Returns the outline with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchOutlineException} if it could not be found.
	 *
	 * @param spOutlineId the primary key of the outline
	 * @return the outline
	 * @throws com.sambaash.platform.srv.NoSuchOutlineException if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline findByPrimaryKey(long spOutlineId)
		throws NoSuchOutlineException, SystemException {
		return findByPrimaryKey((Serializable)spOutlineId);
	}

	/**
	 * Returns the outline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the outline
	 * @return the outline, or <code>null</code> if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Outline outline = (Outline)EntityCacheUtil.getResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
				OutlineImpl.class, primaryKey);

		if (outline == _nullOutline) {
			return null;
		}

		if (outline == null) {
			Session session = null;

			try {
				session = openSession();

				outline = (Outline)session.get(OutlineImpl.class, primaryKey);

				if (outline != null) {
					cacheResult(outline);
				}
				else {
					EntityCacheUtil.putResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
						OutlineImpl.class, primaryKey, _nullOutline);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OutlineModelImpl.ENTITY_CACHE_ENABLED,
					OutlineImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return outline;
	}

	/**
	 * Returns the outline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spOutlineId the primary key of the outline
	 * @return the outline, or <code>null</code> if a outline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Outline fetchByPrimaryKey(long spOutlineId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spOutlineId);
	}

	/**
	 * Returns all the outlines.
	 *
	 * @return the outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the outlines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @return the range of outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the outlines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.OutlineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of outlines
	 * @param end the upper bound of the range of outlines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of outlines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Outline> findAll(int start, int end,
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

		List<Outline> list = (List<Outline>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OUTLINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OUTLINE;

				if (pagination) {
					sql = sql.concat(OutlineModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Outline>(list);
				}
				else {
					list = (List<Outline>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the outlines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Outline outline : findAll()) {
			remove(outline);
		}
	}

	/**
	 * Returns the number of outlines.
	 *
	 * @return the number of outlines
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

				Query q = session.createQuery(_SQL_COUNT_OUTLINE);

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
	 * Initializes the outline persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Outline")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Outline>> listenersList = new ArrayList<ModelListener<Outline>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Outline>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OutlineImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OUTLINE = "SELECT outline FROM Outline outline";
	private static final String _SQL_SELECT_OUTLINE_WHERE = "SELECT outline FROM Outline outline WHERE ";
	private static final String _SQL_COUNT_OUTLINE = "SELECT COUNT(outline) FROM Outline outline";
	private static final String _SQL_COUNT_OUTLINE_WHERE = "SELECT COUNT(outline) FROM Outline outline WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "outline.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Outline exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Outline exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OutlinePersistenceImpl.class);
	private static Outline _nullOutline = new OutlineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Outline> toCacheModel() {
				return _nullOutlineCacheModel;
			}
		};

	private static CacheModel<Outline> _nullOutlineCacheModel = new CacheModel<Outline>() {
			@Override
			public Outline toEntityModel() {
				return _nullOutline;
			}
		};
}