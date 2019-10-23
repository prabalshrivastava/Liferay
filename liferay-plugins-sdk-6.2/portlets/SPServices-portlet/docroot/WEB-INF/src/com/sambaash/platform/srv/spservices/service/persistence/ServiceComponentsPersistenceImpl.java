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

import com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException;
import com.sambaash.platform.srv.spservices.model.ServiceComponents;
import com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsImpl;
import com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service components service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see ServiceComponentsPersistence
 * @see ServiceComponentsUtil
 * @generated
 */
public class ServiceComponentsPersistenceImpl extends BasePersistenceImpl<ServiceComponents>
	implements ServiceComponentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceComponentsUtil} to access the service components persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceComponentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByServiceComponentsName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByServiceComponentsName",
			new String[] { String.class.getName() },
			ServiceComponentsModelImpl.NAME_COLUMN_BITMASK |
			ServiceComponentsModelImpl.SCGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICECOMPONENTSNAME = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceComponentsName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the service componentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsName(String name)
		throws SystemException {
		return findByServiceComponentsName(name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service componentses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @return the range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsName(String name,
		int start, int end) throws SystemException {
		return findByServiceComponentsName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service componentses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsName(String name,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ServiceComponents> list = (List<ServiceComponents>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceComponents serviceComponents : list) {
				if (!Validator.equals(name, serviceComponents.getName())) {
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

			query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
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
					list = (List<ServiceComponents>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponents>(list);
				}
				else {
					list = (List<ServiceComponents>)QueryUtil.list(q,
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
	 * Returns the first service components in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByServiceComponentsName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByServiceComponentsName_First(name,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the first service components in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByServiceComponentsName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceComponents> list = findByServiceComponentsName(name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service components in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByServiceComponentsName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByServiceComponentsName_Last(name,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the last service components in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByServiceComponentsName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByServiceComponentsName(name);

		if (count == 0) {
			return null;
		}

		List<ServiceComponents> list = findByServiceComponentsName(name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service componentses before and after the current service components in the ordered set where name = &#63;.
	 *
	 * @param scId the primary key of the current service components
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents[] findByServiceComponentsName_PrevAndNext(
		long scId, String name, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = findByPrimaryKey(scId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponents[] array = new ServiceComponentsImpl[3];

			array[0] = getByServiceComponentsName_PrevAndNext(session,
					serviceComponents, name, orderByComparator, true);

			array[1] = serviceComponents;

			array[2] = getByServiceComponentsName_PrevAndNext(session,
					serviceComponents, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponents getByServiceComponentsName_PrevAndNext(
		Session session, ServiceComponents serviceComponents, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_2);
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
			query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(serviceComponents);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponents> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service componentses where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceComponentsName(String name)
		throws SystemException {
		for (ServiceComponents serviceComponents : findByServiceComponentsName(
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceComponents);
		}
	}

	/**
	 * Returns the number of service componentses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceComponentsName(String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICECOMPONENTSNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENTS_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_1 = "serviceComponents.name IS NULL";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_2 = "serviceComponents.name = ?";
	private static final String _FINDER_COLUMN_SERVICECOMPONENTSNAME_NAME_3 = "(serviceComponents.name IS NULL OR serviceComponents.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByServiceComponentsScgId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByServiceComponentsScgId",
			new String[] { Long.class.getName() },
			ServiceComponentsModelImpl.SCGID_COLUMN_BITMASK |
			ServiceComponentsModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICECOMPONENTSSCGID = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceComponentsScgId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the service componentses where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @return the matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsScgId(long scgId)
		throws SystemException {
		return findByServiceComponentsScgId(scgId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service componentses where scgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scgId the scg ID
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @return the range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsScgId(long scgId,
		int start, int end) throws SystemException {
		return findByServiceComponentsScgId(scgId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service componentses where scgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scgId the scg ID
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByServiceComponentsScgId(long scgId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID;
			finderArgs = new Object[] { scgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID;
			finderArgs = new Object[] { scgId, start, end, orderByComparator };
		}

		List<ServiceComponents> list = (List<ServiceComponents>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceComponents serviceComponents : list) {
				if ((scgId != serviceComponents.getScgId())) {
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

			query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

			query.append(_FINDER_COLUMN_SERVICECOMPONENTSSCGID_SCGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scgId);

				if (!pagination) {
					list = (List<ServiceComponents>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponents>(list);
				}
				else {
					list = (List<ServiceComponents>)QueryUtil.list(q,
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
	 * Returns the first service components in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByServiceComponentsScgId_First(long scgId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByServiceComponentsScgId_First(scgId,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scgId=");
		msg.append(scgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the first service components in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByServiceComponentsScgId_First(long scgId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ServiceComponents> list = findByServiceComponentsScgId(scgId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service components in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByServiceComponentsScgId_Last(long scgId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByServiceComponentsScgId_Last(scgId,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scgId=");
		msg.append(scgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the last service components in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByServiceComponentsScgId_Last(long scgId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByServiceComponentsScgId(scgId);

		if (count == 0) {
			return null;
		}

		List<ServiceComponents> list = findByServiceComponentsScgId(scgId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service componentses before and after the current service components in the ordered set where scgId = &#63;.
	 *
	 * @param scId the primary key of the current service components
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents[] findByServiceComponentsScgId_PrevAndNext(
		long scId, long scgId, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = findByPrimaryKey(scId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponents[] array = new ServiceComponentsImpl[3];

			array[0] = getByServiceComponentsScgId_PrevAndNext(session,
					serviceComponents, scgId, orderByComparator, true);

			array[1] = serviceComponents;

			array[2] = getByServiceComponentsScgId_PrevAndNext(session,
					serviceComponents, scgId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceComponents getByServiceComponentsScgId_PrevAndNext(
		Session session, ServiceComponents serviceComponents, long scgId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

		query.append(_FINDER_COLUMN_SERVICECOMPONENTSSCGID_SCGID_2);

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
			query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scgId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceComponents);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponents> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service componentses where scgId = &#63; from the database.
	 *
	 * @param scgId the scg ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceComponentsScgId(long scgId)
		throws SystemException {
		for (ServiceComponents serviceComponents : findByServiceComponentsScgId(
				scgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceComponents);
		}
	}

	/**
	 * Returns the number of service componentses where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @return the number of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceComponentsScgId(long scgId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICECOMPONENTSSCGID;

		Object[] finderArgs = new Object[] { scgId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENTS_WHERE);

			query.append(_FINDER_COLUMN_SERVICECOMPONENTSSCGID_SCGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scgId);

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

	private static final String _FINDER_COLUMN_SERVICECOMPONENTSSCGID_SCGID_2 = "serviceComponents.scgId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTechnologyComponent",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT =
		new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED,
			ServiceComponentsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTechnologyComponent",
			new String[] { String.class.getName() },
			ServiceComponentsModelImpl.TECHNOLOGYCOMPONENT_COLUMN_BITMASK |
			ServiceComponentsModelImpl.SCGID_COLUMN_BITMASK |
			ServiceComponentsModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TECHNOLOGYCOMPONENT = new FinderPath(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTechnologyComponent",
			new String[] { String.class.getName() });

	/**
	 * Returns all the service componentses where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @return the matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByTechnologyComponent(
		String technologyComponent) throws SystemException {
		return findByTechnologyComponent(technologyComponent,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service componentses where technologyComponent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param technologyComponent the technology component
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @return the range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByTechnologyComponent(
		String technologyComponent, int start, int end)
		throws SystemException {
		return findByTechnologyComponent(technologyComponent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service componentses where technologyComponent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param technologyComponent the technology component
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findByTechnologyComponent(
		String technologyComponent, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT;
			finderArgs = new Object[] { technologyComponent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT;
			finderArgs = new Object[] {
					technologyComponent,
					
					start, end, orderByComparator
				};
		}

		List<ServiceComponents> list = (List<ServiceComponents>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ServiceComponents serviceComponents : list) {
				if (!Validator.equals(technologyComponent,
							serviceComponents.getTechnologyComponent())) {
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

			query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

			boolean bindTechnologyComponent = false;

			if (technologyComponent == null) {
				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_1);
			}
			else if (technologyComponent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_3);
			}
			else {
				bindTechnologyComponent = true;

				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTechnologyComponent) {
					qPos.add(technologyComponent);
				}

				if (!pagination) {
					list = (List<ServiceComponents>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponents>(list);
				}
				else {
					list = (List<ServiceComponents>)QueryUtil.list(q,
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
	 * Returns the first service components in the ordered set where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByTechnologyComponent_First(
		String technologyComponent, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByTechnologyComponent_First(technologyComponent,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("technologyComponent=");
		msg.append(technologyComponent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the first service components in the ordered set where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByTechnologyComponent_First(
		String technologyComponent, OrderByComparator orderByComparator)
		throws SystemException {
		List<ServiceComponents> list = findByTechnologyComponent(technologyComponent,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service components in the ordered set where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByTechnologyComponent_Last(
		String technologyComponent, OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByTechnologyComponent_Last(technologyComponent,
				orderByComparator);

		if (serviceComponents != null) {
			return serviceComponents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("technologyComponent=");
		msg.append(technologyComponent);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServiceComponentsException(msg.toString());
	}

	/**
	 * Returns the last service components in the ordered set where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service components, or <code>null</code> if a matching service components could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByTechnologyComponent_Last(
		String technologyComponent, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTechnologyComponent(technologyComponent);

		if (count == 0) {
			return null;
		}

		List<ServiceComponents> list = findByTechnologyComponent(technologyComponent,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service componentses before and after the current service components in the ordered set where technologyComponent = &#63;.
	 *
	 * @param scId the primary key of the current service components
	 * @param technologyComponent the technology component
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents[] findByTechnologyComponent_PrevAndNext(
		long scId, String technologyComponent,
		OrderByComparator orderByComparator)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = findByPrimaryKey(scId);

		Session session = null;

		try {
			session = openSession();

			ServiceComponents[] array = new ServiceComponentsImpl[3];

			array[0] = getByTechnologyComponent_PrevAndNext(session,
					serviceComponents, technologyComponent, orderByComparator,
					true);

			array[1] = serviceComponents;

			array[2] = getByTechnologyComponent_PrevAndNext(session,
					serviceComponents, technologyComponent, orderByComparator,
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

	protected ServiceComponents getByTechnologyComponent_PrevAndNext(
		Session session, ServiceComponents serviceComponents,
		String technologyComponent, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICECOMPONENTS_WHERE);

		boolean bindTechnologyComponent = false;

		if (technologyComponent == null) {
			query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_1);
		}
		else if (technologyComponent.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_3);
		}
		else {
			bindTechnologyComponent = true;

			query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_2);
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
			query.append(ServiceComponentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTechnologyComponent) {
			qPos.add(technologyComponent);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceComponents);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceComponents> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service componentses where technologyComponent = &#63; from the database.
	 *
	 * @param technologyComponent the technology component
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTechnologyComponent(String technologyComponent)
		throws SystemException {
		for (ServiceComponents serviceComponents : findByTechnologyComponent(
				technologyComponent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(serviceComponents);
		}
	}

	/**
	 * Returns the number of service componentses where technologyComponent = &#63;.
	 *
	 * @param technologyComponent the technology component
	 * @return the number of matching service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTechnologyComponent(String technologyComponent)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TECHNOLOGYCOMPONENT;

		Object[] finderArgs = new Object[] { technologyComponent };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICECOMPONENTS_WHERE);

			boolean bindTechnologyComponent = false;

			if (technologyComponent == null) {
				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_1);
			}
			else if (technologyComponent.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_3);
			}
			else {
				bindTechnologyComponent = true;

				query.append(_FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTechnologyComponent) {
					qPos.add(technologyComponent);
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

	private static final String _FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_1 =
		"serviceComponents.technologyComponent IS NULL";
	private static final String _FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_2 =
		"serviceComponents.technologyComponent = ?";
	private static final String _FINDER_COLUMN_TECHNOLOGYCOMPONENT_TECHNOLOGYCOMPONENT_3 =
		"(serviceComponents.technologyComponent IS NULL OR serviceComponents.technologyComponent = '')";

	public ServiceComponentsPersistenceImpl() {
		setModelClass(ServiceComponents.class);
	}

	/**
	 * Caches the service components in the entity cache if it is enabled.
	 *
	 * @param serviceComponents the service components
	 */
	@Override
	public void cacheResult(ServiceComponents serviceComponents) {
		EntityCacheUtil.putResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsImpl.class, serviceComponents.getPrimaryKey(),
			serviceComponents);

		serviceComponents.resetOriginalValues();
	}

	/**
	 * Caches the service componentses in the entity cache if it is enabled.
	 *
	 * @param serviceComponentses the service componentses
	 */
	@Override
	public void cacheResult(List<ServiceComponents> serviceComponentses) {
		for (ServiceComponents serviceComponents : serviceComponentses) {
			if (EntityCacheUtil.getResult(
						ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
						ServiceComponentsImpl.class,
						serviceComponents.getPrimaryKey()) == null) {
				cacheResult(serviceComponents);
			}
			else {
				serviceComponents.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service componentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceComponentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceComponentsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service components.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceComponents serviceComponents) {
		EntityCacheUtil.removeResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsImpl.class, serviceComponents.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServiceComponents> serviceComponentses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceComponents serviceComponents : serviceComponentses) {
			EntityCacheUtil.removeResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
				ServiceComponentsImpl.class, serviceComponents.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service components with the primary key. Does not add the service components to the database.
	 *
	 * @param scId the primary key for the new service components
	 * @return the new service components
	 */
	@Override
	public ServiceComponents create(long scId) {
		ServiceComponents serviceComponents = new ServiceComponentsImpl();

		serviceComponents.setNew(true);
		serviceComponents.setPrimaryKey(scId);

		return serviceComponents;
	}

	/**
	 * Removes the service components with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scId the primary key of the service components
	 * @return the service components that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents remove(long scId)
		throws NoSuchServiceComponentsException, SystemException {
		return remove((Serializable)scId);
	}

	/**
	 * Removes the service components with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service components
	 * @return the service components that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents remove(Serializable primaryKey)
		throws NoSuchServiceComponentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceComponents serviceComponents = (ServiceComponents)session.get(ServiceComponentsImpl.class,
					primaryKey);

			if (serviceComponents == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceComponentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceComponents);
		}
		catch (NoSuchServiceComponentsException nsee) {
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
	protected ServiceComponents removeImpl(ServiceComponents serviceComponents)
		throws SystemException {
		serviceComponents = toUnwrappedModel(serviceComponents);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceComponents)) {
				serviceComponents = (ServiceComponents)session.get(ServiceComponentsImpl.class,
						serviceComponents.getPrimaryKeyObj());
			}

			if (serviceComponents != null) {
				session.delete(serviceComponents);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (serviceComponents != null) {
			clearCache(serviceComponents);
		}

		return serviceComponents;
	}

	@Override
	public ServiceComponents updateImpl(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws SystemException {
		serviceComponents = toUnwrappedModel(serviceComponents);

		boolean isNew = serviceComponents.isNew();

		ServiceComponentsModelImpl serviceComponentsModelImpl = (ServiceComponentsModelImpl)serviceComponents;

		Session session = null;

		try {
			session = openSession();

			if (serviceComponents.isNew()) {
				session.save(serviceComponents);

				serviceComponents.setNew(false);
			}
			else {
				session.merge(serviceComponents);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceComponentsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceComponentsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceComponentsModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME,
					args);

				args = new Object[] { serviceComponentsModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSNAME,
					args);
			}

			if ((serviceComponentsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceComponentsModelImpl.getOriginalScgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTSSCGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID,
					args);

				args = new Object[] { serviceComponentsModelImpl.getScgId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECOMPONENTSSCGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICECOMPONENTSSCGID,
					args);
			}

			if ((serviceComponentsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceComponentsModelImpl.getOriginalTechnologyComponent()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TECHNOLOGYCOMPONENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT,
					args);

				args = new Object[] {
						serviceComponentsModelImpl.getTechnologyComponent()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TECHNOLOGYCOMPONENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TECHNOLOGYCOMPONENT,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
			ServiceComponentsImpl.class, serviceComponents.getPrimaryKey(),
			serviceComponents);

		return serviceComponents;
	}

	protected ServiceComponents toUnwrappedModel(
		ServiceComponents serviceComponents) {
		if (serviceComponents instanceof ServiceComponentsImpl) {
			return serviceComponents;
		}

		ServiceComponentsImpl serviceComponentsImpl = new ServiceComponentsImpl();

		serviceComponentsImpl.setNew(serviceComponents.isNew());
		serviceComponentsImpl.setPrimaryKey(serviceComponents.getPrimaryKey());

		serviceComponentsImpl.setScId(serviceComponents.getScId());
		serviceComponentsImpl.setScgId(serviceComponents.getScgId());
		serviceComponentsImpl.setName(serviceComponents.getName());
		serviceComponentsImpl.setDescription(serviceComponents.getDescription());
		serviceComponentsImpl.setTechnologyComponent(serviceComponents.getTechnologyComponent());
		serviceComponentsImpl.setPhase(serviceComponents.getPhase());
		serviceComponentsImpl.setStatus(serviceComponents.getStatus());
		serviceComponentsImpl.setVersion(serviceComponents.getVersion());
		serviceComponentsImpl.setServiceType(serviceComponents.getServiceType());
		serviceComponentsImpl.setServiceExposureType(serviceComponents.getServiceExposureType());
		serviceComponentsImpl.setUserType(serviceComponents.getUserType());
		serviceComponentsImpl.setPlatformType(serviceComponents.getPlatformType());
		serviceComponentsImpl.setIslaCarteService(serviceComponents.isIslaCarteService());
		serviceComponentsImpl.setIsExternal(serviceComponents.isIsExternal());
		serviceComponentsImpl.setTag(serviceComponents.getTag());
		serviceComponentsImpl.setWebserviceURL(serviceComponents.getWebserviceURL());
		serviceComponentsImpl.setDeploymentCluster(serviceComponents.getDeploymentCluster());
		serviceComponentsImpl.setDeploymentLocation(serviceComponents.getDeploymentLocation());
		serviceComponentsImpl.setChannelID(serviceComponents.getChannelID());
		serviceComponentsImpl.setTestPlan(serviceComponents.getTestPlan());
		serviceComponentsImpl.setPerformanceProfile(serviceComponents.getPerformanceProfile());
		serviceComponentsImpl.setUsageStatistics(serviceComponents.getUsageStatistics());
		serviceComponentsImpl.setDateAdded(serviceComponents.getDateAdded());
		serviceComponentsImpl.setDateModified(serviceComponents.getDateModified());
		serviceComponentsImpl.setAuthor(serviceComponents.getAuthor());
		serviceComponentsImpl.setExtra1(serviceComponents.getExtra1());
		serviceComponentsImpl.setExtra2(serviceComponents.getExtra2());
		serviceComponentsImpl.setExtra3(serviceComponents.getExtra3());
		serviceComponentsImpl.setExtra4(serviceComponents.getExtra4());
		serviceComponentsImpl.setExtra5(serviceComponents.getExtra5());
		serviceComponentsImpl.setExtra6(serviceComponents.getExtra6());
		serviceComponentsImpl.setServiceCharges(serviceComponents.getServiceCharges());

		return serviceComponentsImpl;
	}

	/**
	 * Returns the service components with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service components
	 * @return the service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceComponentsException, SystemException {
		ServiceComponents serviceComponents = fetchByPrimaryKey(primaryKey);

		if (serviceComponents == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceComponentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return serviceComponents;
	}

	/**
	 * Returns the service components with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException} if it could not be found.
	 *
	 * @param scId the primary key of the service components
	 * @return the service components
	 * @throws com.sambaash.platform.srv.spservices.NoSuchServiceComponentsException if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents findByPrimaryKey(long scId)
		throws NoSuchServiceComponentsException, SystemException {
		return findByPrimaryKey((Serializable)scId);
	}

	/**
	 * Returns the service components with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service components
	 * @return the service components, or <code>null</code> if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ServiceComponents serviceComponents = (ServiceComponents)EntityCacheUtil.getResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
				ServiceComponentsImpl.class, primaryKey);

		if (serviceComponents == _nullServiceComponents) {
			return null;
		}

		if (serviceComponents == null) {
			Session session = null;

			try {
				session = openSession();

				serviceComponents = (ServiceComponents)session.get(ServiceComponentsImpl.class,
						primaryKey);

				if (serviceComponents != null) {
					cacheResult(serviceComponents);
				}
				else {
					EntityCacheUtil.putResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
						ServiceComponentsImpl.class, primaryKey,
						_nullServiceComponents);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ServiceComponentsModelImpl.ENTITY_CACHE_ENABLED,
					ServiceComponentsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return serviceComponents;
	}

	/**
	 * Returns the service components with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scId the primary key of the service components
	 * @return the service components, or <code>null</code> if a service components with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceComponents fetchByPrimaryKey(long scId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scId);
	}

	/**
	 * Returns all the service componentses.
	 *
	 * @return the service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service componentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @return the range of service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service componentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of service componentses
	 * @param end the upper bound of the range of service componentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service componentses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ServiceComponents> findAll(int start, int end,
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

		List<ServiceComponents> list = (List<ServiceComponents>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICECOMPONENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICECOMPONENTS;

				if (pagination) {
					sql = sql.concat(ServiceComponentsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServiceComponents>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ServiceComponents>(list);
				}
				else {
					list = (List<ServiceComponents>)QueryUtil.list(q,
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
	 * Removes all the service componentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ServiceComponents serviceComponents : findAll()) {
			remove(serviceComponents);
		}
	}

	/**
	 * Returns the number of service componentses.
	 *
	 * @return the number of service componentses
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

				Query q = session.createQuery(_SQL_COUNT_SERVICECOMPONENTS);

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
	 * Initializes the service components persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.ServiceComponents")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceComponents>> listenersList = new ArrayList<ModelListener<ServiceComponents>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceComponents>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceComponentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SERVICECOMPONENTS = "SELECT serviceComponents FROM ServiceComponents serviceComponents";
	private static final String _SQL_SELECT_SERVICECOMPONENTS_WHERE = "SELECT serviceComponents FROM ServiceComponents serviceComponents WHERE ";
	private static final String _SQL_COUNT_SERVICECOMPONENTS = "SELECT COUNT(serviceComponents) FROM ServiceComponents serviceComponents";
	private static final String _SQL_COUNT_SERVICECOMPONENTS_WHERE = "SELECT COUNT(serviceComponents) FROM ServiceComponents serviceComponents WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceComponents.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceComponents exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceComponents exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceComponentsPersistenceImpl.class);
	private static ServiceComponents _nullServiceComponents = new ServiceComponentsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceComponents> toCacheModel() {
				return _nullServiceComponentsCacheModel;
			}
		};

	private static CacheModel<ServiceComponents> _nullServiceComponentsCacheModel =
		new CacheModel<ServiceComponents>() {
			@Override
			public ServiceComponents toEntityModel() {
				return _nullServiceComponents;
			}
		};
}