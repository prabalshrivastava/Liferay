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

import com.sambaash.platform.srv.NoSuchModuleFrameworkException;
import com.sambaash.platform.srv.model.ModuleFramework;
import com.sambaash.platform.srv.model.impl.ModuleFrameworkImpl;
import com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the module framework service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleFrameworkPersistence
 * @see ModuleFrameworkUtil
 * @generated
 */
public class ModuleFrameworkPersistenceImpl extends BasePersistenceImpl<ModuleFramework>
	implements ModuleFrameworkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ModuleFrameworkUtil} to access the module framework persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ModuleFrameworkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ModuleFrameworkModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleFrameworkModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the module frameworks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module frameworks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @return the range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module frameworks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByGroupId(long groupId, int start,
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

		List<ModuleFramework> list = (List<ModuleFramework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleFramework moduleFramework : list) {
				if ((groupId != moduleFramework.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleFramework>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleFramework>(list);
				}
				else {
					list = (List<ModuleFramework>)QueryUtil.list(q,
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
	 * Returns the first module framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByGroupId_First(groupId,
				orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the first module framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ModuleFramework> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the last module framework in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleFramework> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module frameworks before and after the current module framework in the ordered set where groupId = &#63;.
	 *
	 * @param spModuleFrameworkId the primary key of the current module framework
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework[] findByGroupId_PrevAndNext(
		long spModuleFrameworkId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = findByPrimaryKey(spModuleFrameworkId);

		Session session = null;

		try {
			session = openSession();

			ModuleFramework[] array = new ModuleFrameworkImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, moduleFramework,
					groupId, orderByComparator, true);

			array[1] = moduleFramework;

			array[2] = getByGroupId_PrevAndNext(session, moduleFramework,
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

	protected ModuleFramework getByGroupId_PrevAndNext(Session session,
		ModuleFramework moduleFramework, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

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
			query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleFramework);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleFramework> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module frameworks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ModuleFramework moduleFramework : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleFramework);
		}
	}

	/**
	 * Returns the number of module frameworks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching module frameworks
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

			query.append(_SQL_COUNT_MODULEFRAMEWORK_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "moduleFramework.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByModuleIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleFrameworkModelImpl.SPMODULEID_COLUMN_BITMASK |
			ModuleFrameworkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByModuleIdAndGroupId(long spModuleId,
		long groupId) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @return the range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module frameworks where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByModuleIdAndGroupId(long spModuleId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] { spModuleId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID;
			finderArgs = new Object[] {
					spModuleId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ModuleFramework> list = (List<ModuleFramework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleFramework moduleFramework : list) {
				if ((spModuleId != moduleFramework.getSpModuleId()) ||
						(groupId != moduleFramework.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleFramework>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleFramework>(list);
				}
				else {
					list = (List<ModuleFramework>)QueryUtil.list(q,
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
	 * Returns the first module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByModuleIdAndGroupId_First(spModuleId,
				groupId, orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the first module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByModuleIdAndGroupId_First(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ModuleFramework> list = findByModuleIdAndGroupId(spModuleId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByModuleIdAndGroupId_Last(spModuleId,
				groupId, orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the last module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByModuleIdAndGroupId(spModuleId, groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleFramework> list = findByModuleIdAndGroupId(spModuleId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module frameworks before and after the current module framework in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleFrameworkId the primary key of the current module framework
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spModuleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = findByPrimaryKey(spModuleFrameworkId);

		Session session = null;

		try {
			session = openSession();

			ModuleFramework[] array = new ModuleFrameworkImpl[3];

			array[0] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleFramework, spModuleId, groupId, orderByComparator,
					true);

			array[1] = moduleFramework;

			array[2] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleFramework, spModuleId, groupId, orderByComparator,
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

	protected ModuleFramework getByModuleIdAndGroupId_PrevAndNext(
		Session session, ModuleFramework moduleFramework, long spModuleId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

		query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spModuleId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleFramework);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleFramework> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module frameworks where spModuleId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		for (ModuleFramework moduleFramework : findByModuleIdAndGroupId(
				spModuleId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleFramework);
		}
	}

	/**
	 * Returns the number of module frameworks where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the number of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID;

		Object[] finderArgs = new Object[] { spModuleId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULEFRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spModuleId);

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

	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2 = "moduleFramework.spModuleId = ? AND ";
	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2 = "moduleFramework.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID =
		new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByFrameworkIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID =
		new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED,
			ModuleFrameworkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFrameworkIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleFrameworkModelImpl.SPFRAMEWORKID_COLUMN_BITMASK |
			ModuleFrameworkModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleFrameworkModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FRAMEWORKIDANDGROUPID = new FinderPath(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFrameworkIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @return the matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId) throws SystemException {
		return findByFrameworkIdAndGroupId(spFrameworkId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @return the range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end)
		throws SystemException {
		return findByFrameworkIdAndGroupId(spFrameworkId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findByFrameworkIdAndGroupId(
		long spFrameworkId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID;
			finderArgs = new Object[] { spFrameworkId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID;
			finderArgs = new Object[] {
					spFrameworkId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ModuleFramework> list = (List<ModuleFramework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleFramework moduleFramework : list) {
				if ((spFrameworkId != moduleFramework.getSpFrameworkId()) ||
						(groupId != moduleFramework.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_SPFRAMEWORKID_2);

			query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spFrameworkId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleFramework>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleFramework>(list);
				}
				else {
					list = (List<ModuleFramework>)QueryUtil.list(q,
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
	 * Returns the first module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByFrameworkIdAndGroupId_First(spFrameworkId,
				groupId, orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spFrameworkId=");
		msg.append(spFrameworkId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the first module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByFrameworkIdAndGroupId_First(
		long spFrameworkId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ModuleFramework> list = findByFrameworkIdAndGroupId(spFrameworkId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByFrameworkIdAndGroupId_Last(spFrameworkId,
				groupId, orderByComparator);

		if (moduleFramework != null) {
			return moduleFramework;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spFrameworkId=");
		msg.append(spFrameworkId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleFrameworkException(msg.toString());
	}

	/**
	 * Returns the last module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module framework, or <code>null</code> if a matching module framework could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByFrameworkIdAndGroupId_Last(
		long spFrameworkId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByFrameworkIdAndGroupId(spFrameworkId, groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleFramework> list = findByFrameworkIdAndGroupId(spFrameworkId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module frameworks before and after the current module framework in the ordered set where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleFrameworkId the primary key of the current module framework
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework[] findByFrameworkIdAndGroupId_PrevAndNext(
		long spModuleFrameworkId, long spFrameworkId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = findByPrimaryKey(spModuleFrameworkId);

		Session session = null;

		try {
			session = openSession();

			ModuleFramework[] array = new ModuleFrameworkImpl[3];

			array[0] = getByFrameworkIdAndGroupId_PrevAndNext(session,
					moduleFramework, spFrameworkId, groupId, orderByComparator,
					true);

			array[1] = moduleFramework;

			array[2] = getByFrameworkIdAndGroupId_PrevAndNext(session,
					moduleFramework, spFrameworkId, groupId, orderByComparator,
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

	protected ModuleFramework getByFrameworkIdAndGroupId_PrevAndNext(
		Session session, ModuleFramework moduleFramework, long spFrameworkId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULEFRAMEWORK_WHERE);

		query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_SPFRAMEWORKID_2);

		query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spFrameworkId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleFramework);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleFramework> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module frameworks where spFrameworkId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFrameworkIdAndGroupId(long spFrameworkId, long groupId)
		throws SystemException {
		for (ModuleFramework moduleFramework : findByFrameworkIdAndGroupId(
				spFrameworkId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(moduleFramework);
		}
	}

	/**
	 * Returns the number of module frameworks where spFrameworkId = &#63; and groupId = &#63;.
	 *
	 * @param spFrameworkId the sp framework ID
	 * @param groupId the group ID
	 * @return the number of matching module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFrameworkIdAndGroupId(long spFrameworkId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FRAMEWORKIDANDGROUPID;

		Object[] finderArgs = new Object[] { spFrameworkId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULEFRAMEWORK_WHERE);

			query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_SPFRAMEWORKID_2);

			query.append(_FINDER_COLUMN_FRAMEWORKIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spFrameworkId);

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

	private static final String _FINDER_COLUMN_FRAMEWORKIDANDGROUPID_SPFRAMEWORKID_2 =
		"moduleFramework.spFrameworkId = ? AND ";
	private static final String _FINDER_COLUMN_FRAMEWORKIDANDGROUPID_GROUPID_2 = "moduleFramework.groupId = ?";

	public ModuleFrameworkPersistenceImpl() {
		setModelClass(ModuleFramework.class);
	}

	/**
	 * Caches the module framework in the entity cache if it is enabled.
	 *
	 * @param moduleFramework the module framework
	 */
	@Override
	public void cacheResult(ModuleFramework moduleFramework) {
		EntityCacheUtil.putResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkImpl.class, moduleFramework.getPrimaryKey(),
			moduleFramework);

		moduleFramework.resetOriginalValues();
	}

	/**
	 * Caches the module frameworks in the entity cache if it is enabled.
	 *
	 * @param moduleFrameworks the module frameworks
	 */
	@Override
	public void cacheResult(List<ModuleFramework> moduleFrameworks) {
		for (ModuleFramework moduleFramework : moduleFrameworks) {
			if (EntityCacheUtil.getResult(
						ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
						ModuleFrameworkImpl.class,
						moduleFramework.getPrimaryKey()) == null) {
				cacheResult(moduleFramework);
			}
			else {
				moduleFramework.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all module frameworks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ModuleFrameworkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ModuleFrameworkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the module framework.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ModuleFramework moduleFramework) {
		EntityCacheUtil.removeResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkImpl.class, moduleFramework.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ModuleFramework> moduleFrameworks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ModuleFramework moduleFramework : moduleFrameworks) {
			EntityCacheUtil.removeResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
				ModuleFrameworkImpl.class, moduleFramework.getPrimaryKey());
		}
	}

	/**
	 * Creates a new module framework with the primary key. Does not add the module framework to the database.
	 *
	 * @param spModuleFrameworkId the primary key for the new module framework
	 * @return the new module framework
	 */
	@Override
	public ModuleFramework create(long spModuleFrameworkId) {
		ModuleFramework moduleFramework = new ModuleFrameworkImpl();

		moduleFramework.setNew(true);
		moduleFramework.setPrimaryKey(spModuleFrameworkId);

		return moduleFramework;
	}

	/**
	 * Removes the module framework with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spModuleFrameworkId the primary key of the module framework
	 * @return the module framework that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework remove(long spModuleFrameworkId)
		throws NoSuchModuleFrameworkException, SystemException {
		return remove((Serializable)spModuleFrameworkId);
	}

	/**
	 * Removes the module framework with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the module framework
	 * @return the module framework that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework remove(Serializable primaryKey)
		throws NoSuchModuleFrameworkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ModuleFramework moduleFramework = (ModuleFramework)session.get(ModuleFrameworkImpl.class,
					primaryKey);

			if (moduleFramework == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchModuleFrameworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(moduleFramework);
		}
		catch (NoSuchModuleFrameworkException nsee) {
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
	protected ModuleFramework removeImpl(ModuleFramework moduleFramework)
		throws SystemException {
		moduleFramework = toUnwrappedModel(moduleFramework);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moduleFramework)) {
				moduleFramework = (ModuleFramework)session.get(ModuleFrameworkImpl.class,
						moduleFramework.getPrimaryKeyObj());
			}

			if (moduleFramework != null) {
				session.delete(moduleFramework);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (moduleFramework != null) {
			clearCache(moduleFramework);
		}

		return moduleFramework;
	}

	@Override
	public ModuleFramework updateImpl(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework)
		throws SystemException {
		moduleFramework = toUnwrappedModel(moduleFramework);

		boolean isNew = moduleFramework.isNew();

		ModuleFrameworkModelImpl moduleFrameworkModelImpl = (ModuleFrameworkModelImpl)moduleFramework;

		Session session = null;

		try {
			session = openSession();

			if (moduleFramework.isNew()) {
				session.save(moduleFramework);

				moduleFramework.setNew(false);
			}
			else {
				session.merge(moduleFramework);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ModuleFrameworkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((moduleFrameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleFrameworkModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { moduleFrameworkModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((moduleFrameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleFrameworkModelImpl.getOriginalSpModuleId(),
						moduleFrameworkModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);

				args = new Object[] {
						moduleFrameworkModelImpl.getSpModuleId(),
						moduleFrameworkModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);
			}

			if ((moduleFrameworkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleFrameworkModelImpl.getOriginalSpFrameworkId(),
						moduleFrameworkModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FRAMEWORKIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID,
					args);

				args = new Object[] {
						moduleFrameworkModelImpl.getSpFrameworkId(),
						moduleFrameworkModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FRAMEWORKIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FRAMEWORKIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
			ModuleFrameworkImpl.class, moduleFramework.getPrimaryKey(),
			moduleFramework);

		return moduleFramework;
	}

	protected ModuleFramework toUnwrappedModel(ModuleFramework moduleFramework) {
		if (moduleFramework instanceof ModuleFrameworkImpl) {
			return moduleFramework;
		}

		ModuleFrameworkImpl moduleFrameworkImpl = new ModuleFrameworkImpl();

		moduleFrameworkImpl.setNew(moduleFramework.isNew());
		moduleFrameworkImpl.setPrimaryKey(moduleFramework.getPrimaryKey());

		moduleFrameworkImpl.setSpModuleFrameworkId(moduleFramework.getSpModuleFrameworkId());
		moduleFrameworkImpl.setGroupId(moduleFramework.getGroupId());
		moduleFrameworkImpl.setCompanyId(moduleFramework.getCompanyId());
		moduleFrameworkImpl.setUserId(moduleFramework.getUserId());
		moduleFrameworkImpl.setUserName(moduleFramework.getUserName());
		moduleFrameworkImpl.setCreateDate(moduleFramework.getCreateDate());
		moduleFrameworkImpl.setModifiedDate(moduleFramework.getModifiedDate());
		moduleFrameworkImpl.setSpModuleId(moduleFramework.getSpModuleId());
		moduleFrameworkImpl.setSpFrameworkId(moduleFramework.getSpFrameworkId());

		return moduleFrameworkImpl;
	}

	/**
	 * Returns the module framework with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the module framework
	 * @return the module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModuleFrameworkException, SystemException {
		ModuleFramework moduleFramework = fetchByPrimaryKey(primaryKey);

		if (moduleFramework == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchModuleFrameworkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return moduleFramework;
	}

	/**
	 * Returns the module framework with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleFrameworkException} if it could not be found.
	 *
	 * @param spModuleFrameworkId the primary key of the module framework
	 * @return the module framework
	 * @throws com.sambaash.platform.srv.NoSuchModuleFrameworkException if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework findByPrimaryKey(long spModuleFrameworkId)
		throws NoSuchModuleFrameworkException, SystemException {
		return findByPrimaryKey((Serializable)spModuleFrameworkId);
	}

	/**
	 * Returns the module framework with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the module framework
	 * @return the module framework, or <code>null</code> if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ModuleFramework moduleFramework = (ModuleFramework)EntityCacheUtil.getResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
				ModuleFrameworkImpl.class, primaryKey);

		if (moduleFramework == _nullModuleFramework) {
			return null;
		}

		if (moduleFramework == null) {
			Session session = null;

			try {
				session = openSession();

				moduleFramework = (ModuleFramework)session.get(ModuleFrameworkImpl.class,
						primaryKey);

				if (moduleFramework != null) {
					cacheResult(moduleFramework);
				}
				else {
					EntityCacheUtil.putResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
						ModuleFrameworkImpl.class, primaryKey,
						_nullModuleFramework);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ModuleFrameworkModelImpl.ENTITY_CACHE_ENABLED,
					ModuleFrameworkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return moduleFramework;
	}

	/**
	 * Returns the module framework with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spModuleFrameworkId the primary key of the module framework
	 * @return the module framework, or <code>null</code> if a module framework with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleFramework fetchByPrimaryKey(long spModuleFrameworkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spModuleFrameworkId);
	}

	/**
	 * Returns all the module frameworks.
	 *
	 * @return the module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module frameworks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @return the range of module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the module frameworks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleFrameworkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module frameworks
	 * @param end the upper bound of the range of module frameworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of module frameworks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleFramework> findAll(int start, int end,
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

		List<ModuleFramework> list = (List<ModuleFramework>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MODULEFRAMEWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MODULEFRAMEWORK;

				if (pagination) {
					sql = sql.concat(ModuleFrameworkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ModuleFramework>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleFramework>(list);
				}
				else {
					list = (List<ModuleFramework>)QueryUtil.list(q,
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
	 * Removes all the module frameworks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ModuleFramework moduleFramework : findAll()) {
			remove(moduleFramework);
		}
	}

	/**
	 * Returns the number of module frameworks.
	 *
	 * @return the number of module frameworks
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

				Query q = session.createQuery(_SQL_COUNT_MODULEFRAMEWORK);

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
	 * Initializes the module framework persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ModuleFramework")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ModuleFramework>> listenersList = new ArrayList<ModelListener<ModuleFramework>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ModuleFramework>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ModuleFrameworkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MODULEFRAMEWORK = "SELECT moduleFramework FROM ModuleFramework moduleFramework";
	private static final String _SQL_SELECT_MODULEFRAMEWORK_WHERE = "SELECT moduleFramework FROM ModuleFramework moduleFramework WHERE ";
	private static final String _SQL_COUNT_MODULEFRAMEWORK = "SELECT COUNT(moduleFramework) FROM ModuleFramework moduleFramework";
	private static final String _SQL_COUNT_MODULEFRAMEWORK_WHERE = "SELECT COUNT(moduleFramework) FROM ModuleFramework moduleFramework WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "moduleFramework.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModuleFramework exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ModuleFramework exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ModuleFrameworkPersistenceImpl.class);
	private static ModuleFramework _nullModuleFramework = new ModuleFrameworkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ModuleFramework> toCacheModel() {
				return _nullModuleFrameworkCacheModel;
			}
		};

	private static CacheModel<ModuleFramework> _nullModuleFrameworkCacheModel = new CacheModel<ModuleFramework>() {
			@Override
			public ModuleFramework toEntityModel() {
				return _nullModuleFramework;
			}
		};
}