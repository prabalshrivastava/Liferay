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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.NoSuchModuleException;
import com.sambaash.platform.srv.model.Module;
import com.sambaash.platform.srv.model.impl.ModuleImpl;
import com.sambaash.platform.srv.model.impl.ModuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModulePersistence
 * @see ModuleUtil
 * @generated
 */
public class ModulePersistenceImpl extends BasePersistenceImpl<Module>
	implements ModulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ModuleUtil} to access the module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ModuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ModuleModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleModelImpl.MODULECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the modules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the modules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @return the range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the modules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByGroupId(long groupId, int start, int end,
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

		List<Module> list = (List<Module>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Module module : list) {
				if ((groupId != module.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Module>(list);
				}
				else {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByGroupId_First(groupId, orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the first module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Module> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByGroupId_Last(groupId, orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the last module in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Module> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the modules before and after the current module in the ordered set where groupId = &#63;.
	 *
	 * @param spModuleId the primary key of the current module
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module[] findByGroupId_PrevAndNext(long spModuleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = findByPrimaryKey(spModuleId);

		Session session = null;

		try {
			session = openSession();

			Module[] array = new ModuleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, module, groupId,
					orderByComparator, true);

			array[1] = module;

			array[2] = getByGroupId_PrevAndNext(session, module, groupId,
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

	protected Module getByGroupId_PrevAndNext(Session session, Module module,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULE_WHERE);

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
			query.append(ModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(module);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Module> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the modules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Module module : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(module);
		}
	}

	/**
	 * Returns the number of modules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching modules
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

			query.append(_SQL_COUNT_MODULE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "module.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ModuleModelImpl.COUNTRYID_COLUMN_BITMASK |
			ModuleModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleModelImpl.MODULECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the modules where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the modules where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @return the range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupId(long countryId, long groupId,
		int start, int end) throws SystemException {
		return findByCountryIdAndGroupId(countryId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the modules where countryId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupId(long countryId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] { countryId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID;
			finderArgs = new Object[] {
					countryId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Module> list = (List<Module>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Module module : list) {
				if ((countryId != module.getCountryId()) ||
						(groupId != module.getGroupId())) {
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

			query.append(_SQL_SELECT_MODULE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Module>(list);
				}
				else {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first module in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByCountryIdAndGroupId_First(long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByCountryIdAndGroupId_First(countryId, groupId,
				orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the first module in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByCountryIdAndGroupId_First(long countryId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Module> list = findByCountryIdAndGroupId(countryId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByCountryIdAndGroupId_Last(long countryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByCountryIdAndGroupId_Last(countryId, groupId,
				orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the last module in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByCountryIdAndGroupId_Last(long countryId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryIdAndGroupId(countryId, groupId);

		if (count == 0) {
			return null;
		}

		List<Module> list = findByCountryIdAndGroupId(countryId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the modules before and after the current module in the ordered set where countryId = &#63; and groupId = &#63;.
	 *
	 * @param spModuleId the primary key of the current module
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module[] findByCountryIdAndGroupId_PrevAndNext(long spModuleId,
		long countryId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = findByPrimaryKey(spModuleId);

		Session session = null;

		try {
			session = openSession();

			Module[] array = new ModuleImpl[3];

			array[0] = getByCountryIdAndGroupId_PrevAndNext(session, module,
					countryId, groupId, orderByComparator, true);

			array[1] = module;

			array[2] = getByCountryIdAndGroupId_PrevAndNext(session, module,
					countryId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Module getByCountryIdAndGroupId_PrevAndNext(Session session,
		Module module, long countryId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULE_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

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
			query.append(ModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(module);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Module> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the modules where countryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		for (Module module : findByCountryIdAndGroupId(countryId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(module);
		}
	}

	/**
	 * Returns the number of modules where countryId = &#63; and groupId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @return the number of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupId(long countryId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID;

		Object[] finderArgs = new Object[] { countryId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MODULE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_COUNTRYID_2 = "module.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPID_GROUPID_2 = "module.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCountryIdAndGroupIdAndModuleCode",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCountryIdAndGroupIdAndModuleCode",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			ModuleModelImpl.COUNTRYID_COLUMN_BITMASK |
			ModuleModelImpl.GROUPID_COLUMN_BITMASK |
			ModuleModelImpl.MODULECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDMODULECODE =
		new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCountryIdAndGroupIdAndModuleCode",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @return the matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, String moduleCode) throws SystemException {
		return findByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @return the range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, String moduleCode, int start, int end)
		throws SystemException {
		return findByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
			moduleCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, String moduleCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE;
			finderArgs = new Object[] { countryId, groupId, moduleCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE;
			finderArgs = new Object[] {
					countryId, groupId, moduleCode,
					
					start, end, orderByComparator
				};
		}

		List<Module> list = (List<Module>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Module module : list) {
				if ((countryId != module.getCountryId()) ||
						(groupId != module.getGroupId()) ||
						!Validator.equals(moduleCode, module.getModuleCode())) {
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

			query.append(_SQL_SELECT_MODULE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_GROUPID_2);

			boolean bindModuleCode = false;

			if (moduleCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_1);
			}
			else if (moduleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_3);
			}
			else {
				bindModuleCode = true;

				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ModuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (bindModuleCode) {
					qPos.add(moduleCode);
				}

				if (!pagination) {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Module>(list);
				}
				else {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByCountryIdAndGroupIdAndModuleCode_First(long countryId,
		long groupId, String moduleCode, OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByCountryIdAndGroupIdAndModuleCode_First(countryId,
				groupId, moduleCode, orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", moduleCode=");
		msg.append(moduleCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the first module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByCountryIdAndGroupIdAndModuleCode_First(
		long countryId, long groupId, String moduleCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<Module> list = findByCountryIdAndGroupIdAndModuleCode(countryId,
				groupId, moduleCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByCountryIdAndGroupIdAndModuleCode_Last(long countryId,
		long groupId, String moduleCode, OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByCountryIdAndGroupIdAndModuleCode_Last(countryId,
				groupId, moduleCode, orderByComparator);

		if (module != null) {
			return module;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryId=");
		msg.append(countryId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", moduleCode=");
		msg.append(moduleCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchModuleException(msg.toString());
	}

	/**
	 * Returns the last module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByCountryIdAndGroupIdAndModuleCode_Last(long countryId,
		long groupId, String moduleCode, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCountryIdAndGroupIdAndModuleCode(countryId, groupId,
				moduleCode);

		if (count == 0) {
			return null;
		}

		List<Module> list = findByCountryIdAndGroupIdAndModuleCode(countryId,
				groupId, moduleCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the modules before and after the current module in the ordered set where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param spModuleId the primary key of the current module
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module[] findByCountryIdAndGroupIdAndModuleCode_PrevAndNext(
		long spModuleId, long countryId, long groupId, String moduleCode,
		OrderByComparator orderByComparator)
		throws NoSuchModuleException, SystemException {
		Module module = findByPrimaryKey(spModuleId);

		Session session = null;

		try {
			session = openSession();

			Module[] array = new ModuleImpl[3];

			array[0] = getByCountryIdAndGroupIdAndModuleCode_PrevAndNext(session,
					module, countryId, groupId, moduleCode, orderByComparator,
					true);

			array[1] = module;

			array[2] = getByCountryIdAndGroupIdAndModuleCode_PrevAndNext(session,
					module, countryId, groupId, moduleCode, orderByComparator,
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

	protected Module getByCountryIdAndGroupIdAndModuleCode_PrevAndNext(
		Session session, Module module, long countryId, long groupId,
		String moduleCode, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MODULE_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_COUNTRYID_2);

		query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_GROUPID_2);

		boolean bindModuleCode = false;

		if (moduleCode == null) {
			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_1);
		}
		else if (moduleCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_3);
		}
		else {
			bindModuleCode = true;

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_2);
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
			query.append(ModuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryId);

		qPos.add(groupId);

		if (bindModuleCode) {
			qPos.add(moduleCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(module);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Module> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, String moduleCode) throws SystemException {
		for (Module module : findByCountryIdAndGroupIdAndModuleCode(countryId,
				groupId, moduleCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(module);
		}
	}

	/**
	 * Returns the number of modules where countryId = &#63; and groupId = &#63; and moduleCode = &#63;.
	 *
	 * @param countryId the country ID
	 * @param groupId the group ID
	 * @param moduleCode the module code
	 * @return the number of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryIdAndGroupIdAndModuleCode(long countryId,
		long groupId, String moduleCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDMODULECODE;

		Object[] finderArgs = new Object[] { countryId, groupId, moduleCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MODULE_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_COUNTRYID_2);

			query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_GROUPID_2);

			boolean bindModuleCode = false;

			if (moduleCode == null) {
				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_1);
			}
			else if (moduleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_3);
			}
			else {
				bindModuleCode = true;

				query.append(_FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				qPos.add(groupId);

				if (bindModuleCode) {
					qPos.add(moduleCode);
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

	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_COUNTRYID_2 =
		"module.countryId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_GROUPID_2 =
		"module.groupId = ? AND ";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_1 =
		"module.moduleCode IS NULL";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_2 =
		"module.moduleCode = ?";
	private static final String _FINDER_COLUMN_COUNTRYIDANDGROUPIDANDMODULECODE_MODULECODE_3 =
		"(module.moduleCode IS NULL OR module.moduleCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MODULECODE = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, ModuleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByModuleCode",
			new String[] { String.class.getName() },
			ModuleModelImpl.MODULECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULECODE = new FinderPath(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModuleCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the module where moduleCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchModuleException} if it could not be found.
	 *
	 * @param moduleCode the module code
	 * @return the matching module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByModuleCode(String moduleCode)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByModuleCode(moduleCode);

		if (module == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("moduleCode=");
			msg.append(moduleCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchModuleException(msg.toString());
		}

		return module;
	}

	/**
	 * Returns the module where moduleCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param moduleCode the module code
	 * @return the matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByModuleCode(String moduleCode)
		throws SystemException {
		return fetchByModuleCode(moduleCode, true);
	}

	/**
	 * Returns the module where moduleCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param moduleCode the module code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching module, or <code>null</code> if a matching module could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByModuleCode(String moduleCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { moduleCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MODULECODE,
					finderArgs, this);
		}

		if (result instanceof Module) {
			Module module = (Module)result;

			if (!Validator.equals(moduleCode, module.getModuleCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_MODULE_WHERE);

			boolean bindModuleCode = false;

			if (moduleCode == null) {
				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_1);
			}
			else if (moduleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_3);
			}
			else {
				bindModuleCode = true;

				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModuleCode) {
					qPos.add(moduleCode.toLowerCase());
				}

				List<Module> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODULECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ModulePersistenceImpl.fetchByModuleCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Module module = list.get(0);

					result = module;

					cacheResult(module);

					if ((module.getModuleCode() == null) ||
							!module.getModuleCode().equals(moduleCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODULECODE,
							finderArgs, module);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODULECODE,
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
			return (Module)result;
		}
	}

	/**
	 * Removes the module where moduleCode = &#63; from the database.
	 *
	 * @param moduleCode the module code
	 * @return the module that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module removeByModuleCode(String moduleCode)
		throws NoSuchModuleException, SystemException {
		Module module = findByModuleCode(moduleCode);

		return remove(module);
	}

	/**
	 * Returns the number of modules where moduleCode = &#63;.
	 *
	 * @param moduleCode the module code
	 * @return the number of matching modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByModuleCode(String moduleCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODULECODE;

		Object[] finderArgs = new Object[] { moduleCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MODULE_WHERE);

			boolean bindModuleCode = false;

			if (moduleCode == null) {
				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_1);
			}
			else if (moduleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_3);
			}
			else {
				bindModuleCode = true;

				query.append(_FINDER_COLUMN_MODULECODE_MODULECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModuleCode) {
					qPos.add(moduleCode.toLowerCase());
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

	private static final String _FINDER_COLUMN_MODULECODE_MODULECODE_1 = "module.moduleCode IS NULL";
	private static final String _FINDER_COLUMN_MODULECODE_MODULECODE_2 = "lower(module.moduleCode) = ?";
	private static final String _FINDER_COLUMN_MODULECODE_MODULECODE_3 = "(module.moduleCode IS NULL OR module.moduleCode = '')";

	public ModulePersistenceImpl() {
		setModelClass(Module.class);
	}

	/**
	 * Caches the module in the entity cache if it is enabled.
	 *
	 * @param module the module
	 */
	@Override
	public void cacheResult(Module module) {
		EntityCacheUtil.putResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleImpl.class, module.getPrimaryKey(), module);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODULECODE,
			new Object[] { module.getModuleCode() }, module);

		module.resetOriginalValues();
	}

	/**
	 * Caches the modules in the entity cache if it is enabled.
	 *
	 * @param modules the modules
	 */
	@Override
	public void cacheResult(List<Module> modules) {
		for (Module module : modules) {
			if (EntityCacheUtil.getResult(
						ModuleModelImpl.ENTITY_CACHE_ENABLED, ModuleImpl.class,
						module.getPrimaryKey()) == null) {
				cacheResult(module);
			}
			else {
				module.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all modules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ModuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ModuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the module.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Module module) {
		EntityCacheUtil.removeResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleImpl.class, module.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(module);
	}

	@Override
	public void clearCache(List<Module> modules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Module module : modules) {
			EntityCacheUtil.removeResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
				ModuleImpl.class, module.getPrimaryKey());

			clearUniqueFindersCache(module);
		}
	}

	protected void cacheUniqueFindersCache(Module module) {
		if (module.isNew()) {
			Object[] args = new Object[] { module.getModuleCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODULECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODULECODE, args,
				module);
		}
		else {
			ModuleModelImpl moduleModelImpl = (ModuleModelImpl)module;

			if ((moduleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MODULECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { module.getModuleCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MODULECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MODULECODE,
					args, module);
			}
		}
	}

	protected void clearUniqueFindersCache(Module module) {
		ModuleModelImpl moduleModelImpl = (ModuleModelImpl)module;

		Object[] args = new Object[] { module.getModuleCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODULECODE, args);

		if ((moduleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MODULECODE.getColumnBitmask()) != 0) {
			args = new Object[] { moduleModelImpl.getOriginalModuleCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULECODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MODULECODE, args);
		}
	}

	/**
	 * Creates a new module with the primary key. Does not add the module to the database.
	 *
	 * @param spModuleId the primary key for the new module
	 * @return the new module
	 */
	@Override
	public Module create(long spModuleId) {
		Module module = new ModuleImpl();

		module.setNew(true);
		module.setPrimaryKey(spModuleId);

		return module;
	}

	/**
	 * Removes the module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spModuleId the primary key of the module
	 * @return the module that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module remove(long spModuleId)
		throws NoSuchModuleException, SystemException {
		return remove((Serializable)spModuleId);
	}

	/**
	 * Removes the module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the module
	 * @return the module that was removed
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module remove(Serializable primaryKey)
		throws NoSuchModuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Module module = (Module)session.get(ModuleImpl.class, primaryKey);

			if (module == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(module);
		}
		catch (NoSuchModuleException nsee) {
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
	protected Module removeImpl(Module module) throws SystemException {
		module = toUnwrappedModel(module);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(module)) {
				module = (Module)session.get(ModuleImpl.class,
						module.getPrimaryKeyObj());
			}

			if (module != null) {
				session.delete(module);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (module != null) {
			clearCache(module);
		}

		return module;
	}

	@Override
	public Module updateImpl(com.sambaash.platform.srv.model.Module module)
		throws SystemException {
		module = toUnwrappedModel(module);

		boolean isNew = module.isNew();

		ModuleModelImpl moduleModelImpl = (ModuleModelImpl)module;

		Session session = null;

		try {
			session = openSession();

			if (module.isNew()) {
				session.save(module);

				module.setNew(false);
			}
			else {
				session.merge(module);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ModuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((moduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { moduleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((moduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleModelImpl.getOriginalCountryId(),
						moduleModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);

				args = new Object[] {
						moduleModelImpl.getCountryId(),
						moduleModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPID,
					args);
			}

			if ((moduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moduleModelImpl.getOriginalCountryId(),
						moduleModelImpl.getOriginalGroupId(),
						moduleModelImpl.getOriginalModuleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDMODULECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE,
					args);

				args = new Object[] {
						moduleModelImpl.getCountryId(),
						moduleModelImpl.getGroupId(),
						moduleModelImpl.getModuleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYIDANDGROUPIDANDMODULECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYIDANDGROUPIDANDMODULECODE,
					args);
			}
		}

		EntityCacheUtil.putResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
			ModuleImpl.class, module.getPrimaryKey(), module);

		clearUniqueFindersCache(module);
		cacheUniqueFindersCache(module);

		return module;
	}

	protected Module toUnwrappedModel(Module module) {
		if (module instanceof ModuleImpl) {
			return module;
		}

		ModuleImpl moduleImpl = new ModuleImpl();

		moduleImpl.setNew(module.isNew());
		moduleImpl.setPrimaryKey(module.getPrimaryKey());

		moduleImpl.setSpModuleId(module.getSpModuleId());
		moduleImpl.setGroupId(module.getGroupId());
		moduleImpl.setCompanyId(module.getCompanyId());
		moduleImpl.setUserId(module.getUserId());
		moduleImpl.setUserName(module.getUserName());
		moduleImpl.setCreateDate(module.getCreateDate());
		moduleImpl.setModifiedDate(module.getModifiedDate());
		moduleImpl.setCountryId(module.getCountryId());
		moduleImpl.setModuleCode(module.getModuleCode());
		moduleImpl.setModuleName(module.getModuleName());
		moduleImpl.setModuleDesc(module.getModuleDesc());
		moduleImpl.setModuleType(module.getModuleType());
		moduleImpl.setCreditValue(module.getCreditValue());
		moduleImpl.setModuleDuration(module.getModuleDuration());
		moduleImpl.setNoOfSessions(module.getNoOfSessions());
		moduleImpl.setGeneralDesc(module.getGeneralDesc());

		return moduleImpl;
	}

	/**
	 * Returns the module with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the module
	 * @return the module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModuleException, SystemException {
		Module module = fetchByPrimaryKey(primaryKey);

		if (module == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return module;
	}

	/**
	 * Returns the module with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchModuleException} if it could not be found.
	 *
	 * @param spModuleId the primary key of the module
	 * @return the module
	 * @throws com.sambaash.platform.srv.NoSuchModuleException if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module findByPrimaryKey(long spModuleId)
		throws NoSuchModuleException, SystemException {
		return findByPrimaryKey((Serializable)spModuleId);
	}

	/**
	 * Returns the module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the module
	 * @return the module, or <code>null</code> if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Module module = (Module)EntityCacheUtil.getResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
				ModuleImpl.class, primaryKey);

		if (module == _nullModule) {
			return null;
		}

		if (module == null) {
			Session session = null;

			try {
				session = openSession();

				module = (Module)session.get(ModuleImpl.class, primaryKey);

				if (module != null) {
					cacheResult(module);
				}
				else {
					EntityCacheUtil.putResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
						ModuleImpl.class, primaryKey, _nullModule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ModuleModelImpl.ENTITY_CACHE_ENABLED,
					ModuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return module;
	}

	/**
	 * Returns the module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spModuleId the primary key of the module
	 * @return the module, or <code>null</code> if a module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Module fetchByPrimaryKey(long spModuleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)spModuleId);
	}

	/**
	 * Returns all the modules.
	 *
	 * @return the modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @return the range of modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of modules
	 * @param end the upper bound of the range of modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Module> findAll(int start, int end,
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

		List<Module> list = (List<Module>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MODULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MODULE;

				if (pagination) {
					sql = sql.concat(ModuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Module>(list);
				}
				else {
					list = (List<Module>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the modules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Module module : findAll()) {
			remove(module);
		}
	}

	/**
	 * Returns the number of modules.
	 *
	 * @return the number of modules
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

				Query q = session.createQuery(_SQL_COUNT_MODULE);

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
	 * Initializes the module persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.Module")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Module>> listenersList = new ArrayList<ModelListener<Module>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Module>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ModuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MODULE = "SELECT module FROM Module module";
	private static final String _SQL_SELECT_MODULE_WHERE = "SELECT module FROM Module module WHERE ";
	private static final String _SQL_COUNT_MODULE = "SELECT COUNT(module) FROM Module module";
	private static final String _SQL_COUNT_MODULE_WHERE = "SELECT COUNT(module) FROM Module module WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "module.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Module exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Module exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ModulePersistenceImpl.class);
	private static Module _nullModule = new ModuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Module> toCacheModel() {
				return _nullModuleCacheModel;
			}
		};

	private static CacheModel<Module> _nullModuleCacheModel = new CacheModel<Module>() {
			@Override
			public Module toEntityModel() {
				return _nullModule;
			}
		};
}