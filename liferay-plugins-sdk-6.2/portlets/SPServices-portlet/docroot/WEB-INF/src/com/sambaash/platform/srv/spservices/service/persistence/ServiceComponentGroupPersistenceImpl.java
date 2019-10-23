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

package com.sambaash.platform.srv.spservices.service.persistence;

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
import com.liferay.portal.kernel.util.CharPool;
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

import com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException;
import com.sambaash.platform.srv.spservices.model.ServiceComponentGroup;
import com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupImpl;
import com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service component group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroupPersistence
 * @see ServiceComponentGroupUtil
 * @generated
 */
public class ServiceComponentGroupPersistenceImpl extends BasePersistenceImpl<ServiceComponentGroup>
	implements ServiceComponentGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceComponentGroupUtil} to access the service component group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceComponentGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME =
		new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByServiceComponentGroupName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME =
		new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByServiceComponentGroupName",
			new String[] { String.class.getName() },
			ServiceComponentGroupModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICECOMPONENTGROUPNAME =
		new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceComponentGroupName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the service component groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupName(
		String name) throws SystemException {
		return findByServiceComponentGroupName(name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service component groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @return the range of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupName(
		String name, int start, int end) throws SystemException {
		return findByServiceComponentGroupName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service component groups where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupName(
		String name, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ServiceComponentGroup> list = (List<ServiceComponentGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceComponentGroup serviceComponentGroup : list) {
				if (!Validator.equals(name, serviceComponentGroup.getName())) {
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

			query.append(_SQL_SELECT_SERVICECOMPONENTGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceComponentGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponentGroup>(list);
				}
				else {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
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
	 * Returns the first service component group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByServiceComponentGroupName_First(
		String name, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = fetchByServiceComponentGroupName_First(name,
				orderByComparator);

		if (serviceComponentGroup != null) {
			return serviceComponentGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentGroupException(msg.toString());
	}

	/**
	 * Returns the first service component group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service component group, or <code>null</code> if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByServiceComponentGroupName_First(
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceComponentGroup> list = findByServiceComponentGroupName(name,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service component group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByServiceComponentGroupName_Last(
		String name, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = fetchByServiceComponentGroupName_Last(name,
				orderByComparator);

		if (serviceComponentGroup != null) {
			return serviceComponentGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentGroupException(msg.toString());
	}

	/**
	 * Returns the last service component group in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service component group, or <code>null</code> if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByServiceComponentGroupName_Last(
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceComponentGroupName(name);

		if (count == 0) {
			return null;
		}

		List<ServiceComponentGroup> list = findByServiceComponentGroupName(name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service component groups before and after the current service component group in the ordered set where name = &#63;.
	 *
	 * @param scgId the primary key of the current service component group
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup[] findByServiceComponentGroupName_PrevAndNext(
		long scgId, String name, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = findByPrimaryKey(scgId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponentGroup[] array = new ServiceComponentGroupImpl[3];

			array[0] = getByServiceComponentGroupName_PrevAndNext(session,
					serviceComponentGroup, name, orderByComparator, true);

			array[1] = serviceComponentGroup;

			array[2] = getByServiceComponentGroupName_PrevAndNext(session,
					serviceComponentGroup, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponentGroup getByServiceComponentGroupName_PrevAndNext(
		Session session, ServiceComponentGroup serviceComponentGroup,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENTGROUP_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_2);
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
			query.append(ServiceComponentGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceComponentGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponentGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service component groups where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceComponentGroupName(String name)
		throws SystemException {
		for (ServiceComponentGroup serviceComponentGroup : findByServiceComponentGroupName(
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceComponentGroup);
		}
	}

	/**
	 * Returns the number of service component groups where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceComponentGroupName(String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICECOMPONENTGROUPNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENTGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_1 = "serviceComponentGroup.name IS NULL";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_2 = "serviceComponentGroup.name = ?";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPNAME_NAME_3 = "(serviceComponentGroup.name IS NULL OR serviceComponentGroup.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPEXTRA1LIKE =
		new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByServiceComponentGroupExtra1Like",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_SERVICECOMPONENTGROUPEXTRA1LIKE =
		new FinderPath(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByServiceComponentGroupExtra1Like",
			new String[] { String.class.getName() });

	/**
	 * Returns all the service component groups where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		String extra1) throws SystemException {
		return findByServiceComponentGroupExtra1Like(extra1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service component groups where extra1 LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @return the range of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		String extra1, int start, int end) throws SystemException {
		return findByServiceComponentGroupExtra1Like(extra1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service component groups where extra1 LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findByServiceComponentGroupExtra1Like(
		String extra1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPEXTRA1LIKE;
		finderArgs = new Object[] { extra1, start, end, orderByComparator };

		List<ServiceComponentGroup> list = (List<ServiceComponentGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceComponentGroup serviceComponentGroup : list) {
				if (!StringUtil.wildcardMatches(
							serviceComponentGroup.getExtra1(), extra1,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_SERVICECOMPONENTGROUP_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceComponentGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExtra1) {
					qPos.add(extra1);
				}

				if (!pagination) {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponentGroup>(list);
				}
				else {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
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
	 * Returns the first service component group in the ordered set where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByServiceComponentGroupExtra1Like_First(
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = fetchByServiceComponentGroupExtra1Like_First(extra1,
				orderByComparator);

		if (serviceComponentGroup != null) {
			return serviceComponentGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentGroupException(msg.toString());
	}

	/**
	 * Returns the first service component group in the ordered set where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service component group, or <code>null</code> if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByServiceComponentGroupExtra1Like_First(
		String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceComponentGroup> list = findByServiceComponentGroupExtra1Like(extra1,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service component group in the ordered set where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByServiceComponentGroupExtra1Like_Last(
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = fetchByServiceComponentGroupExtra1Like_Last(extra1,
				orderByComparator);

		if (serviceComponentGroup != null) {
			return serviceComponentGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentGroupException(msg.toString());
	}

	/**
	 * Returns the last service component group in the ordered set where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service component group, or <code>null</code> if a matching service component group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByServiceComponentGroupExtra1Like_Last(
		String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceComponentGroupExtra1Like(extra1);

		if (count == 0) {
			return null;
		}

		List<ServiceComponentGroup> list = findByServiceComponentGroupExtra1Like(extra1,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service component groups before and after the current service component group in the ordered set where extra1 LIKE &#63;.
	 *
	 * @param scgId the primary key of the current service component group
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup[] findByServiceComponentGroupExtra1Like_PrevAndNext(
		long scgId, String extra1, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = findByPrimaryKey(scgId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponentGroup[] array = new ServiceComponentGroupImpl[3];

			array[0] = getByServiceComponentGroupExtra1Like_PrevAndNext(session,
					serviceComponentGroup, extra1, orderByComparator, true);

			array[1] = serviceComponentGroup;

			array[2] = getByServiceComponentGroupExtra1Like_PrevAndNext(session,
					serviceComponentGroup, extra1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponentGroup getByServiceComponentGroupExtra1Like_PrevAndNext(
		Session session, ServiceComponentGroup serviceComponentGroup,
		String extra1, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENTGROUP_WHERE);

		boolean bindExtra1 = false;

		if (extra1 == null) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_1);
		}
		else if (extra1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_3);
		}
		else {
			bindExtra1 = true;

			query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_2);
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
			query.append(ServiceComponentGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindExtra1) {
			qPos.add(extra1);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceComponentGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponentGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service component groups where extra1 LIKE &#63; from the database.
	 *
	 * @param extra1 the extra1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceComponentGroupExtra1Like(String extra1)
		throws SystemException {
		for (ServiceComponentGroup serviceComponentGroup : findByServiceComponentGroupExtra1Like(
				extra1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceComponentGroup);
		}
	}

	/**
	 * Returns the number of service component groups where extra1 LIKE &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the number of matching service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceComponentGroupExtra1Like(String extra1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_SERVICECOMPONENTGROUPEXTRA1LIKE;

		Object[] finderArgs = new Object[] { extra1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENTGROUP_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExtra1) {
					qPos.add(extra1);
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

	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_1 =
		"serviceComponentGroup.extra1 LIKE NULL";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_2 =
		"serviceComponentGroup.extra1 LIKE ?";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTGROUPEXTRA1LIKE_EXTRA1_3 =
		"(serviceComponentGroup.extra1 IS NULL OR serviceComponentGroup.extra1 LIKE '')";

	public ServiceComponentGroupPersistenceImpl() {
		setModelClass(ServiceComponentGroup.class);
	}

	/**
	 * Caches the service component group in the entity cache if it is enabled.
	 *
	 * @param serviceComponentGroup the service component group
	 */
	@Override
	public void cacheResult(ServiceComponentGroup serviceComponentGroup) {
		EntityCacheUtil.putResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			serviceComponentGroup.getPrimaryKey(), serviceComponentGroup);

		serviceComponentGroup.resetOriginalValues();
	}

	/**
	 * Caches the service component groups in the entity cache if it is enabled.
	 *
	 * @param serviceComponentGroups the service component groups
	 */
	@Override
	public void cacheResult(List<ServiceComponentGroup> serviceComponentGroups) {
		for (ServiceComponentGroup serviceComponentGroup : serviceComponentGroups) {
			if (EntityCacheUtil.getResult(
						ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
						ServiceComponentGroupImpl.class,
						serviceComponentGroup.getPrimaryKey()) == null) {
				cacheResult(serviceComponentGroup);
			}
			else {
				serviceComponentGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service component groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceComponentGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceComponentGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service component group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceComponentGroup serviceComponentGroup) {
		EntityCacheUtil.removeResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			serviceComponentGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceComponentGroup> serviceComponentGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceComponentGroup serviceComponentGroup : serviceComponentGroups) {
			EntityCacheUtil.removeResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
				ServiceComponentGroupImpl.class,
				serviceComponentGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service component group with the primary key. Does not add the service component group to the database.
	 *
	 * @param scgId the primary key for the new service component group
	 * @return the new service component group
	 */
	@Override
	public ServiceComponentGroup create(long scgId) {
		ServiceComponentGroup serviceComponentGroup = new ServiceComponentGroupImpl();

		serviceComponentGroup.setNew(true);
		serviceComponentGroup.setPrimaryKey(scgId);

		return serviceComponentGroup;
	}

	/**
	 * Removes the service component group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scgId the primary key of the service component group
	 * @return the service component group that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup remove(long scgId)
		throws NoSuchServiceComponentGroupException, SystemException {
		return remove((Serializable)scgId);
	}

	/**
	 * Removes the service component group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service component group
	 * @return the service component group that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup remove(Serializable primaryKey)
		throws NoSuchServiceComponentGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceComponentGroup serviceComponentGroup = (ServiceComponentGroup)session.get(ServiceComponentGroupImpl.class,
					primaryKey);

			if (serviceComponentGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceComponentGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceComponentGroup);
		}
		catch (NoSuchServiceComponentGroupException nsee) {
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
	protected ServiceComponentGroup removeImpl(
		ServiceComponentGroup serviceComponentGroup) throws SystemException {
		serviceComponentGroup = toUnwrappedModel(serviceComponentGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceComponentGroup)) {
				serviceComponentGroup = (ServiceComponentGroup)session.get(ServiceComponentGroupImpl.class,
						serviceComponentGroup.getPrimaryKeyObj());
			}

			if (serviceComponentGroup != null) {
				session.delete(serviceComponentGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceComponentGroup != null) {
			clearCache(serviceComponentGroup);
		}

		return serviceComponentGroup;
	}

	@Override
	public ServiceComponentGroup updateImpl(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup)
		throws SystemException {
		serviceComponentGroup = toUnwrappedModel(serviceComponentGroup);

		boolean isNew = serviceComponentGroup.isNew();

		ServiceComponentGroupModelImpl serviceComponentGroupModelImpl = (ServiceComponentGroupModelImpl)serviceComponentGroup;

		Session session = null;

		try {
			session = openSession();

			if (serviceComponentGroup.isNew()) {
				session.save(serviceComponentGroup);

				serviceComponentGroup.setNew(false);
			}
			else {
				session.merge(serviceComponentGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceComponentGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceComponentGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceComponentGroupModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTGROUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME,
					args);

				args = new Object[] { serviceComponentGroupModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTGROUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTGROUPNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentGroupImpl.class,
			serviceComponentGroup.getPrimaryKey(), serviceComponentGroup);

		return serviceComponentGroup;
	}

	protected ServiceComponentGroup toUnwrappedModel(
		ServiceComponentGroup serviceComponentGroup) {
		if (serviceComponentGroup instanceof ServiceComponentGroupImpl) {
			return serviceComponentGroup;
		}

		ServiceComponentGroupImpl serviceComponentGroupImpl = new ServiceComponentGroupImpl();

		serviceComponentGroupImpl.setNew(serviceComponentGroup.isNew());
		serviceComponentGroupImpl.setPrimaryKey(serviceComponentGroup.getPrimaryKey());

		serviceComponentGroupImpl.setScgId(serviceComponentGroup.getScgId());
		serviceComponentGroupImpl.setName(serviceComponentGroup.getName());
		serviceComponentGroupImpl.setDescription(serviceComponentGroup.getDescription());
		serviceComponentGroupImpl.setPhase(serviceComponentGroup.getPhase());
		serviceComponentGroupImpl.setStatus(serviceComponentGroup.getStatus());
		serviceComponentGroupImpl.setVersion(serviceComponentGroup.getVersion());
		serviceComponentGroupImpl.setDeploymentCluster(serviceComponentGroup.getDeploymentCluster());
		serviceComponentGroupImpl.setCommunity(serviceComponentGroup.getCommunity());
		serviceComponentGroupImpl.setDateAdded(serviceComponentGroup.getDateAdded());
		serviceComponentGroupImpl.setDateModified(serviceComponentGroup.getDateModified());
		serviceComponentGroupImpl.setAuthor(serviceComponentGroup.getAuthor());
		serviceComponentGroupImpl.setExtra1(serviceComponentGroup.getExtra1());
		serviceComponentGroupImpl.setExtra2(serviceComponentGroup.getExtra2());
		serviceComponentGroupImpl.setExtra3(serviceComponentGroup.getExtra3());
		serviceComponentGroupImpl.setExtra4(serviceComponentGroup.getExtra4());
		serviceComponentGroupImpl.setExtra5(serviceComponentGroup.getExtra5());
		serviceComponentGroupImpl.setExtra6(serviceComponentGroup.getExtra6());

		return serviceComponentGroupImpl;
	}

	/**
	 * Returns the service component group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service component group
	 * @return the service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceComponentGroupException, SystemException {
		ServiceComponentGroup serviceComponentGroup = fetchByPrimaryKey(primaryKey);

		if (serviceComponentGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceComponentGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceComponentGroup;
	}

	/**
	 * Returns the service component group with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException} if it could not be found.
	 *
	 * @param scgId the primary key of the service component group
	 * @return the service component group
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentGroupException if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup findByPrimaryKey(long scgId)
		throws NoSuchServiceComponentGroupException, SystemException {
		return findByPrimaryKey((Serializable)scgId);
	}

	/**
	 * Returns the service component group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service component group
	 * @return the service component group, or <code>null</code> if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceComponentGroup serviceComponentGroup = (ServiceComponentGroup)EntityCacheUtil.getResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
				ServiceComponentGroupImpl.class, primaryKey);

		if (serviceComponentGroup == _nullServiceComponentGroup) {
			return null;
		}

		if (serviceComponentGroup == null) {
			Session session = null;

			try {
				session = openSession();

				serviceComponentGroup = (ServiceComponentGroup)session.get(ServiceComponentGroupImpl.class,
						primaryKey);

				if (serviceComponentGroup != null) {
					cacheResult(serviceComponentGroup);
				}
				else {
					EntityCacheUtil.putResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
						ServiceComponentGroupImpl.class, primaryKey,
						_nullServiceComponentGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceComponentGroupModelImpl.ENTITY_CACHE_ENABLED,
					ServiceComponentGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceComponentGroup;
	}

	/**
	 * Returns the service component group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scgId the primary key of the service component group
	 * @return the service component group, or <code>null</code> if a service component group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponentGroup fetchByPrimaryKey(long scgId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scgId);
	}

	/**
	 * Returns all the service component groups.
	 *
	 * @return the service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service component groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @return the range of service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service component groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service component groups
	 * @param end the upper bound of the range of service component groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service component groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponentGroup> findAll(int start, int end,
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

		List<ServiceComponentGroup> list = (List<ServiceComponentGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICECOMPONENTGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICECOMPONENTGROUP;

				if (pagination) {
					sql = sql.concat(ServiceComponentGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponentGroup>(list);
				}
				else {
					list = (List<ServiceComponentGroup>)QueryUtil.list(q,
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
	 * Removes all the service component groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceComponentGroup serviceComponentGroup : findAll()) {
			remove(serviceComponentGroup);
		}
	}

	/**
	 * Returns the number of service component groups.
	 *
	 * @return the number of service component groups
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

				Query q = session.createQuery(_SQL_COUNT_SERVICECOMPONENTGROUP);

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
	 * Initializes the service component group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.ServiceComponentGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceComponentGroup>> listenersList = new ArrayList<ModelListener<ServiceComponentGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceComponentGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceComponentGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICECOMPONENTGROUP = "SELECT serviceComponentGroup FROM ServiceComponentGroup serviceComponentGroup";
	private static final String _SQL_SELECT_SERVICECOMPONENTGROUP_WHERE = "SELECT serviceComponentGroup FROM ServiceComponentGroup serviceComponentGroup WHERE ";
	private static final String _SQL_COUNT_SERVICECOMPONENTGROUP = "SELECT COUNT(serviceComponentGroup) FROM ServiceComponentGroup serviceComponentGroup";
	private static final String _SQL_COUNT_SERVICECOMPONENTGROUP_WHERE = "SELECT COUNT(serviceComponentGroup) FROM ServiceComponentGroup serviceComponentGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceComponentGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceComponentGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceComponentGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceComponentGroupPersistenceImpl.class);
	private static ServiceComponentGroup _nullServiceComponentGroup = new ServiceComponentGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceComponentGroup> toCacheModel() {
				return _nullServiceComponentGroupCacheModel;
			}
		};

	private static CacheModel<ServiceComponentGroup> _nullServiceComponentGroupCacheModel =
		new CacheModel<ServiceComponentGroup>() {
			@Override
			public ServiceComponentGroup toEntityModel() {
				return _nullServiceComponentGroup;
			}
		};
}