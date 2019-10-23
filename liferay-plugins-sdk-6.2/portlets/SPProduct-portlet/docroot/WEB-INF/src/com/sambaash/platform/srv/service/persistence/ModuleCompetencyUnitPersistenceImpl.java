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

import com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException;
import com.sambaash.platform.srv.model.ModuleCompetencyUnit;
import com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitImpl;
import com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the module competency unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnitPersistence
 * @see ModuleCompetencyUnitUtil
 * @generated
 */
public class ModuleCompetencyUnitPersistenceImpl extends BasePersistenceImpl<ModuleCompetencyUnit>
	implements ModuleCompetencyUnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ModuleCompetencyUnitUtil} to access the module competency unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ModuleCompetencyUnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ModuleCompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleCompetencyUnitModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the module competency units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module competency units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @return the range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module competency units where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByGroupId(long groupId, int start,
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

		List<ModuleCompetencyUnit> list = (List<ModuleCompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCompetencyUnit moduleCompetencyUnit : list) {
				if ((groupId != moduleCompetencyUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCompetencyUnit>(list);
				}
				else {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first module competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByGroupId_First(groupId,
				orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first module competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ModuleCompetencyUnit> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last module competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCompetencyUnit> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module competency units before and after the current module competency unit in the ordered set where groupId = &#63;.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the current module competency unit
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit[] findByGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = findByPrimaryKey(spModuleCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			ModuleCompetencyUnit[] array = new ModuleCompetencyUnitImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, moduleCompetencyUnit,
					groupId, orderByComparator, true);

			array[1] = moduleCompetencyUnit;

			array[2] = getByGroupId_PrevAndNext(session, moduleCompetencyUnit,
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

	protected ModuleCompetencyUnit getByGroupId_PrevAndNext(Session session,
		ModuleCompetencyUnit moduleCompetencyUnit, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

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
			query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCompetencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module competency units where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ModuleCompetencyUnit moduleCompetencyUnit : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleCompetencyUnit);
		}
	}

	/**
	 * Returns the number of module competency units where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching module competency units
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

			query.append(_SQL_COUNT_MODULECOMPETENCYUNIT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "moduleCompetencyUnit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModuleIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleCompetencyUnitModelImpl.SPMODULEID_COLUMN_BITMASK |
			ModuleCompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID = new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByModuleIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module competency units where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId) throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module competency units where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @return the range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws SystemException {
		return findByModuleIdAndGroupId(spModuleId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the module competency units where spModuleId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ModuleCompetencyUnit> list = (List<ModuleCompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCompetencyUnit moduleCompetencyUnit : list) {
				if ((spModuleId != moduleCompetencyUnit.getSpModuleId()) ||
						(groupId != moduleCompetencyUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2);

			query.append(_FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
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
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCompetencyUnit>(list);
				}
				else {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByModuleIdAndGroupId_First(
		long spModuleId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByModuleIdAndGroupId_First(spModuleId,
				groupId, orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ModuleCompetencyUnit> list = findByModuleIdAndGroupId(spModuleId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByModuleIdAndGroupId_Last(long spModuleId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByModuleIdAndGroupId_Last(spModuleId,
				groupId, orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spModuleId=");
		msg.append(spModuleId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByModuleIdAndGroupId(spModuleId, groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCompetencyUnit> list = findByModuleIdAndGroupId(spModuleId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module competency units before and after the current module competency unit in the ordered set where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the current module competency unit
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit[] findByModuleIdAndGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long spModuleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = findByPrimaryKey(spModuleCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			ModuleCompetencyUnit[] array = new ModuleCompetencyUnitImpl[3];

			array[0] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleCompetencyUnit, spModuleId, groupId,
					orderByComparator, true);

			array[1] = moduleCompetencyUnit;

			array[2] = getByModuleIdAndGroupId_PrevAndNext(session,
					moduleCompetencyUnit, spModuleId, groupId,
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

	protected ModuleCompetencyUnit getByModuleIdAndGroupId_PrevAndNext(
		Session session, ModuleCompetencyUnit moduleCompetencyUnit,
		long spModuleId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

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
			query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spModuleId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCompetencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module competency units where spModuleId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws SystemException {
		for (ModuleCompetencyUnit moduleCompetencyUnit : findByModuleIdAndGroupId(
				spModuleId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(moduleCompetencyUnit);
		}
	}

	/**
	 * Returns the number of module competency units where spModuleId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the sp module ID
	 * @param groupId the group ID
	 * @return the number of matching module competency units
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

			query.append(_SQL_COUNT_MODULECOMPETENCYUNIT_WHERE);

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

	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_SPMODULEID_2 = "moduleCompetencyUnit.spModuleId = ? AND ";
	private static final String _FINDER_COLUMN_MODULEIDANDGROUPID_GROUPID_2 = "moduleCompetencyUnit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompetencyUnitIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompetencyUnitIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleCompetencyUnitModelImpl.SPCOMPETENCYUNITID_COLUMN_BITMASK |
			ModuleCompetencyUnitModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleCompetencyUnitModelImpl.SPMODULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPETENCYUNITIDANDGROUPID =
		new FinderPath(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompetencyUnitIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @return the matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId) throws SystemException {
		return findByCompetencyUnitIdAndGroupId(spCompetencyUnitId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @return the range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId, int start, int end)
		throws SystemException {
		return findByCompetencyUnitIdAndGroupId(spCompetencyUnitId, groupId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findByCompetencyUnitIdAndGroupId(
		long spCompetencyUnitId, long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID;
			finderArgs = new Object[] { spCompetencyUnitId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID;
			finderArgs = new Object[] {
					spCompetencyUnitId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<ModuleCompetencyUnit> list = (List<ModuleCompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ModuleCompetencyUnit moduleCompetencyUnit : list) {
				if ((spCompetencyUnitId != moduleCompetencyUnit.getSpCompetencyUnitId()) ||
						(groupId != moduleCompetencyUnit.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_SPCOMPETENCYUNITID_2);

			query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCompetencyUnitId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCompetencyUnit>(list);
				}
				else {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
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
	 * Returns the first module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByCompetencyUnitIdAndGroupId_First(
		long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByCompetencyUnitIdAndGroupId_First(spCompetencyUnitId,
				groupId, orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the first module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByCompetencyUnitIdAndGroupId_First(
		long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ModuleCompetencyUnit> list = findByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
				groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByCompetencyUnitIdAndGroupId_Last(
		long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByCompetencyUnitIdAndGroupId_Last(spCompetencyUnitId,
				groupId, orderByComparator);

		if (moduleCompetencyUnit != null) {
			return moduleCompetencyUnit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spCompetencyUnitId=");
		msg.append(spCompetencyUnitId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleCompetencyUnitException(msg.toString());
	}

	/**
	 * Returns the last module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module competency unit, or <code>null</code> if a matching module competency unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByCompetencyUnitIdAndGroupId_Last(
		long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
				groupId);

		if (count == 0) {
			return null;
		}

		List<ModuleCompetencyUnit> list = findByCompetencyUnitIdAndGroupId(spCompetencyUnitId,
				groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the module competency units before and after the current module competency unit in the ordered set where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the current module competency unit
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit[] findByCompetencyUnitIdAndGroupId_PrevAndNext(
		long spModuleCompetencyUnitId, long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = findByPrimaryKey(spModuleCompetencyUnitId);

		Session session = null;

		try {
			session = openSession();

			ModuleCompetencyUnit[] array = new ModuleCompetencyUnitImpl[3];

			array[0] = getByCompetencyUnitIdAndGroupId_PrevAndNext(session,
					moduleCompetencyUnit, spCompetencyUnitId, groupId,
					orderByComparator, true);

			array[1] = moduleCompetencyUnit;

			array[2] = getByCompetencyUnitIdAndGroupId_PrevAndNext(session,
					moduleCompetencyUnit, spCompetencyUnitId, groupId,
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

	protected ModuleCompetencyUnit getByCompetencyUnitIdAndGroupId_PrevAndNext(
		Session session, ModuleCompetencyUnit moduleCompetencyUnit,
		long spCompetencyUnitId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULECOMPETENCYUNIT_WHERE);

		query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_SPCOMPETENCYUNITID_2);

		query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spCompetencyUnitId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(moduleCompetencyUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ModuleCompetencyUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the module competency units where spCompetencyUnitId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompetencyUnitIdAndGroupId(long spCompetencyUnitId,
		long groupId) throws SystemException {
		for (ModuleCompetencyUnit moduleCompetencyUnit : findByCompetencyUnitIdAndGroupId(
				spCompetencyUnitId, groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(moduleCompetencyUnit);
		}
	}

	/**
	 * Returns the number of module competency units where spCompetencyUnitId = &#63; and groupId = &#63;.
	 *
	 * @param spCompetencyUnitId the sp competency unit ID
	 * @param groupId the group ID
	 * @return the number of matching module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompetencyUnitIdAndGroupId(long spCompetencyUnitId,
		long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPETENCYUNITIDANDGROUPID;

		Object[] finderArgs = new Object[] { spCompetencyUnitId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULECOMPETENCYUNIT_WHERE);

			query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_SPCOMPETENCYUNITID_2);

			query.append(_FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spCompetencyUnitId);

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

	private static final String _FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_SPCOMPETENCYUNITID_2 =
		"moduleCompetencyUnit.spCompetencyUnitId = ? AND ";
	private static final String _FINDER_COLUMN_COMPETENCYUNITIDANDGROUPID_GROUPID_2 =
		"moduleCompetencyUnit.groupId = ?";

	public ModuleCompetencyUnitPersistenceImpl() {
		setModelClass(ModuleCompetencyUnit.class);
	}

	/**
	 * Caches the module competency unit in the entity cache if it is enabled.
	 *
	 * @param moduleCompetencyUnit the module competency unit
	 */
	@Override
	public void cacheResult(ModuleCompetencyUnit moduleCompetencyUnit) {
		EntityCacheUtil.putResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			moduleCompetencyUnit.getPrimaryKey(), moduleCompetencyUnit);

		moduleCompetencyUnit.resetOriginalValues();
	}

	/**
	 * Caches the module competency units in the entity cache if it is enabled.
	 *
	 * @param moduleCompetencyUnits the module competency units
	 */
	@Override
	public void cacheResult(List<ModuleCompetencyUnit> moduleCompetencyUnits) {
		for (ModuleCompetencyUnit moduleCompetencyUnit : moduleCompetencyUnits) {
			if (EntityCacheUtil.getResult(
						ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
						ModuleCompetencyUnitImpl.class,
						moduleCompetencyUnit.getPrimaryKey()) == null) {
				cacheResult(moduleCompetencyUnit);
			}
			else {
				moduleCompetencyUnit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all module competency units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ModuleCompetencyUnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ModuleCompetencyUnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the module competency unit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ModuleCompetencyUnit moduleCompetencyUnit) {
		EntityCacheUtil.removeResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class, moduleCompetencyUnit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ModuleCompetencyUnit> moduleCompetencyUnits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ModuleCompetencyUnit moduleCompetencyUnit : moduleCompetencyUnits) {
			EntityCacheUtil.removeResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
				ModuleCompetencyUnitImpl.class,
				moduleCompetencyUnit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new module competency unit with the primary key. Does not add the module competency unit to the database.
	 *
	 * @param spModuleCompetencyUnitId the primary key for the new module competency unit
	 * @return the new module competency unit
	 */
	@Override
	public ModuleCompetencyUnit create(long spModuleCompetencyUnitId) {
		ModuleCompetencyUnit moduleCompetencyUnit = new ModuleCompetencyUnitImpl();

		moduleCompetencyUnit.setNew(true);
		moduleCompetencyUnit.setPrimaryKey(spModuleCompetencyUnitId);

		return moduleCompetencyUnit;
	}

	/**
	 * Removes the module competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the module competency unit
	 * @return the module competency unit that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit remove(long spModuleCompetencyUnitId)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		return remove((Serializable)spModuleCompetencyUnitId);
	}

	/**
	 * Removes the module competency unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the module competency unit
	 * @return the module competency unit that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit remove(Serializable primaryKey)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ModuleCompetencyUnit moduleCompetencyUnit = (ModuleCompetencyUnit)session.get(ModuleCompetencyUnitImpl.class,
					primaryKey);

			if (moduleCompetencyUnit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchModuleCompetencyUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(moduleCompetencyUnit);
		}
		catch (NoSuchModuleCompetencyUnitException nsee) {
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
	protected ModuleCompetencyUnit removeImpl(
		ModuleCompetencyUnit moduleCompetencyUnit) throws SystemException {
		moduleCompetencyUnit = toUnwrappedModel(moduleCompetencyUnit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moduleCompetencyUnit)) {
				moduleCompetencyUnit = (ModuleCompetencyUnit)session.get(ModuleCompetencyUnitImpl.class,
						moduleCompetencyUnit.getPrimaryKeyObj());
			}

			if (moduleCompetencyUnit != null) {
				session.delete(moduleCompetencyUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (moduleCompetencyUnit != null) {
			clearCache(moduleCompetencyUnit);
		}

		return moduleCompetencyUnit;
	}

	@Override
	public ModuleCompetencyUnit updateImpl(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit)
		throws SystemException {
		moduleCompetencyUnit = toUnwrappedModel(moduleCompetencyUnit);

		boolean isNew = moduleCompetencyUnit.isNew();

		ModuleCompetencyUnitModelImpl moduleCompetencyUnitModelImpl = (ModuleCompetencyUnitModelImpl)moduleCompetencyUnit;

		Session session = null;

		try {
			session = openSession();

			if (moduleCompetencyUnit.isNew()) {
				session.save(moduleCompetencyUnit);

				moduleCompetencyUnit.setNew(false);
			}
			else {
				session.merge(moduleCompetencyUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ModuleCompetencyUnitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((moduleCompetencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCompetencyUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { moduleCompetencyUnitModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((moduleCompetencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCompetencyUnitModelImpl.getOriginalSpModuleId(),
						moduleCompetencyUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);

				args = new Object[] {
						moduleCompetencyUnitModelImpl.getSpModuleId(),
						moduleCompetencyUnitModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULEIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULEIDANDGROUPID,
					args);
			}

			if ((moduleCompetencyUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleCompetencyUnitModelImpl.getOriginalSpCompetencyUnitId(),
						moduleCompetencyUnitModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID,
					args);

				args = new Object[] {
						moduleCompetencyUnitModelImpl.getSpCompetencyUnitId(),
						moduleCompetencyUnitModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPETENCYUNITIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPETENCYUNITIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
			ModuleCompetencyUnitImpl.class,
			moduleCompetencyUnit.getPrimaryKey(), moduleCompetencyUnit);

		return moduleCompetencyUnit;
	}

	protected ModuleCompetencyUnit toUnwrappedModel(
		ModuleCompetencyUnit moduleCompetencyUnit) {
		if (moduleCompetencyUnit instanceof ModuleCompetencyUnitImpl) {
			return moduleCompetencyUnit;
		}

		ModuleCompetencyUnitImpl moduleCompetencyUnitImpl = new ModuleCompetencyUnitImpl();

		moduleCompetencyUnitImpl.setNew(moduleCompetencyUnit.isNew());
		moduleCompetencyUnitImpl.setPrimaryKey(moduleCompetencyUnit.getPrimaryKey());

		moduleCompetencyUnitImpl.setSpModuleCompetencyUnitId(moduleCompetencyUnit.getSpModuleCompetencyUnitId());
		moduleCompetencyUnitImpl.setGroupId(moduleCompetencyUnit.getGroupId());
		moduleCompetencyUnitImpl.setCompanyId(moduleCompetencyUnit.getCompanyId());
		moduleCompetencyUnitImpl.setUserId(moduleCompetencyUnit.getUserId());
		moduleCompetencyUnitImpl.setUserName(moduleCompetencyUnit.getUserName());
		moduleCompetencyUnitImpl.setCreateDate(moduleCompetencyUnit.getCreateDate());
		moduleCompetencyUnitImpl.setModifiedDate(moduleCompetencyUnit.getModifiedDate());
		moduleCompetencyUnitImpl.setSpModuleId(moduleCompetencyUnit.getSpModuleId());
		moduleCompetencyUnitImpl.setSpCompetencyUnitId(moduleCompetencyUnit.getSpCompetencyUnitId());

		return moduleCompetencyUnitImpl;
	}

	/**
	 * Returns the module competency unit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the module competency unit
	 * @return the module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = fetchByPrimaryKey(primaryKey);

		if (moduleCompetencyUnit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchModuleCompetencyUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return moduleCompetencyUnit;
	}

	/**
	 * Returns the module competency unit with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException} if it could not be found.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the module competency unit
	 * @return the module competency unit
	 * @throws com.sambaash.platform.srv.NoSuchModuleCompetencyUnitException if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit findByPrimaryKey(long spModuleCompetencyUnitId)
		throws NoSuchModuleCompetencyUnitException, SystemException {
		return findByPrimaryKey((Serializable)spModuleCompetencyUnitId);
	}

	/**
	 * Returns the module competency unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the module competency unit
	 * @return the module competency unit, or <code>null</code> if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ModuleCompetencyUnit moduleCompetencyUnit = (ModuleCompetencyUnit)EntityCacheUtil.getResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
				ModuleCompetencyUnitImpl.class, primaryKey);

		if (moduleCompetencyUnit == _nullModuleCompetencyUnit) {
			return null;
		}

		if (moduleCompetencyUnit == null) {
			Session session = null;

			try {
				session = openSession();

				moduleCompetencyUnit = (ModuleCompetencyUnit)session.get(ModuleCompetencyUnitImpl.class,
						primaryKey);

				if (moduleCompetencyUnit != null) {
					cacheResult(moduleCompetencyUnit);
				}
				else {
					EntityCacheUtil.putResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
						ModuleCompetencyUnitImpl.class, primaryKey,
						_nullModuleCompetencyUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ModuleCompetencyUnitModelImpl.ENTITY_CACHE_ENABLED,
					ModuleCompetencyUnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return moduleCompetencyUnit;
	}

	/**
	 * Returns the module competency unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spModuleCompetencyUnitId the primary key of the module competency unit
	 * @return the module competency unit, or <code>null</code> if a module competency unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ModuleCompetencyUnit fetchByPrimaryKey(long spModuleCompetencyUnitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spModuleCompetencyUnitId);
	}

	/**
	 * Returns all the module competency units.
	 *
	 * @return the module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the module competency units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @return the range of module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the module competency units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleCompetencyUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of module competency units
	 * @param end the upper bound of the range of module competency units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of module competency units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ModuleCompetencyUnit> findAll(int start, int end,
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

		List<ModuleCompetencyUnit> list = (List<ModuleCompetencyUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MODULECOMPETENCYUNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MODULECOMPETENCYUNIT;

				if (pagination) {
					sql = sql.concat(ModuleCompetencyUnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ModuleCompetencyUnit>(list);
				}
				else {
					list = (List<ModuleCompetencyUnit>)QueryUtil.list(q,
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
	 * Removes all the module competency units from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ModuleCompetencyUnit moduleCompetencyUnit : findAll()) {
			remove(moduleCompetencyUnit);
		}
	}

	/**
	 * Returns the number of module competency units.
	 *
	 * @return the number of module competency units
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

				Query q = session.createQuery(_SQL_COUNT_MODULECOMPETENCYUNIT);

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
	 * Initializes the module competency unit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.ModuleCompetencyUnit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ModuleCompetencyUnit>> listenersList = new ArrayList<ModelListener<ModuleCompetencyUnit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ModuleCompetencyUnit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ModuleCompetencyUnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MODULECOMPETENCYUNIT = "SELECT moduleCompetencyUnit FROM ModuleCompetencyUnit moduleCompetencyUnit";
	private static final String _SQL_SELECT_MODULECOMPETENCYUNIT_WHERE = "SELECT moduleCompetencyUnit FROM ModuleCompetencyUnit moduleCompetencyUnit WHERE ";
	private static final String _SQL_COUNT_MODULECOMPETENCYUNIT = "SELECT COUNT(moduleCompetencyUnit) FROM ModuleCompetencyUnit moduleCompetencyUnit";
	private static final String _SQL_COUNT_MODULECOMPETENCYUNIT_WHERE = "SELECT COUNT(moduleCompetencyUnit) FROM ModuleCompetencyUnit moduleCompetencyUnit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "moduleCompetencyUnit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModuleCompetencyUnit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ModuleCompetencyUnit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ModuleCompetencyUnitPersistenceImpl.class);
	private static ModuleCompetencyUnit _nullModuleCompetencyUnit = new ModuleCompetencyUnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ModuleCompetencyUnit> toCacheModel() {
				return _nullModuleCompetencyUnitCacheModel;
			}
		};

	private static CacheModel<ModuleCompetencyUnit> _nullModuleCompetencyUnitCacheModel =
		new CacheModel<ModuleCompetencyUnit>() {
			@Override
			public ModuleCompetencyUnit toEntityModel() {
				return _nullModuleCompetencyUnit;
			}
		};
}