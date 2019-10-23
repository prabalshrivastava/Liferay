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

package com.sambaash.platform.srv.startupprofile.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException;
import com.sambaash.platform.srv.startupprofile.model.EmployeeInfo;
import com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the employee info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see EmployeeInfoPersistence
 * @see EmployeeInfoUtil
 * @generated
 */
public class EmployeeInfoPersistenceImpl extends BasePersistenceImpl<EmployeeInfo>
	implements EmployeeInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeInfoUtil} to access the employee info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EmployeeInfoModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the employee infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @return the range of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EmployeeInfo> list = (List<EmployeeInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmployeeInfo employeeInfo : list) {
				if (!Validator.equals(uuid, employeeInfo.getUuid())) {
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

			query.append(_SQL_SELECT_EMPLOYEEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeInfo>(list);
				}
				else {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = fetchByUuid_First(uuid, orderByComparator);

		if (employeeInfo != null) {
			return employeeInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInfoException(msg.toString());
	}

	/**
	 * Returns the first employee info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee info, or <code>null</code> if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmployeeInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (employeeInfo != null) {
			return employeeInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInfoException(msg.toString());
	}

	/**
	 * Returns the last employee info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee info, or <code>null</code> if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeInfo> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee infos before and after the current employee info in the ordered set where uuid = &#63;.
	 *
	 * @param employeeInfoId the primary key of the current employee info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo[] findByUuid_PrevAndNext(long employeeInfoId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = findByPrimaryKey(employeeInfoId);

		Session session = null;

		try {
			session = openSession();

			EmployeeInfo[] array = new EmployeeInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(session, employeeInfo, uuid,
					orderByComparator, true);

			array[1] = employeeInfo;

			array[2] = getByUuid_PrevAndNext(session, employeeInfo, uuid,
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

	protected EmployeeInfo getByUuid_PrevAndNext(Session session,
		EmployeeInfo employeeInfo, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEEINFO_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(EmployeeInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (EmployeeInfo employeeInfo : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(employeeInfo);
		}
	}

	/**
	 * Returns the number of employee infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEEINFO_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "employeeInfo.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "employeeInfo.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(employeeInfo.uuid IS NULL OR employeeInfo.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, EmployeeInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			EmployeeInfoModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the employee infos where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee infos where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @return the range of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee infos where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findByOrganizationId(long organizationId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] { organizationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID;
			finderArgs = new Object[] {
					organizationId,
					
					start, end, orderByComparator
				};
		}

		List<EmployeeInfo> list = (List<EmployeeInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmployeeInfo employeeInfo : list) {
				if ((organizationId != employeeInfo.getOrganizationId())) {
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

			query.append(_SQL_SELECT_EMPLOYEEINFO_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeInfo>(list);
				}
				else {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first employee info in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (employeeInfo != null) {
			return employeeInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInfoException(msg.toString());
	}

	/**
	 * Returns the first employee info in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee info, or <code>null</code> if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmployeeInfo> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee info in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (employeeInfo != null) {
			return employeeInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInfoException(msg.toString());
	}

	/**
	 * Returns the last employee info in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee info, or <code>null</code> if a matching employee info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<EmployeeInfo> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee infos before and after the current employee info in the ordered set where organizationId = &#63;.
	 *
	 * @param employeeInfoId the primary key of the current employee info
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo[] findByOrganizationId_PrevAndNext(
		long employeeInfoId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = findByPrimaryKey(employeeInfoId);

		Session session = null;

		try {
			session = openSession();

			EmployeeInfo[] array = new EmployeeInfoImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, employeeInfo,
					organizationId, orderByComparator, true);

			array[1] = employeeInfo;

			array[2] = getByOrganizationId_PrevAndNext(session, employeeInfo,
					organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeInfo getByOrganizationId_PrevAndNext(Session session,
		EmployeeInfo employeeInfo, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEEINFO_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

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
			query.append(EmployeeInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee infos where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (EmployeeInfo employeeInfo : findByOrganizationId(organizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employeeInfo);
		}
	}

	/**
	 * Returns the number of employee infos where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationId(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONID;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEEINFO_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "employeeInfo.organizationId = ?";

	public EmployeeInfoPersistenceImpl() {
		setModelClass(EmployeeInfo.class);
	}

	/**
	 * Caches the employee info in the entity cache if it is enabled.
	 *
	 * @param employeeInfo the employee info
	 */
	@Override
	public void cacheResult(EmployeeInfo employeeInfo) {
		EntityCacheUtil.putResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoImpl.class, employeeInfo.getPrimaryKey(), employeeInfo);

		employeeInfo.resetOriginalValues();
	}

	/**
	 * Caches the employee infos in the entity cache if it is enabled.
	 *
	 * @param employeeInfos the employee infos
	 */
	@Override
	public void cacheResult(List<EmployeeInfo> employeeInfos) {
		for (EmployeeInfo employeeInfo : employeeInfos) {
			if (EntityCacheUtil.getResult(
						EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeInfoImpl.class, employeeInfo.getPrimaryKey()) == null) {
				cacheResult(employeeInfo);
			}
			else {
				employeeInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmployeeInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmployeeInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeInfo employeeInfo) {
		EntityCacheUtil.removeResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoImpl.class, employeeInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeInfo> employeeInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeInfo employeeInfo : employeeInfos) {
			EntityCacheUtil.removeResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeInfoImpl.class, employeeInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee info with the primary key. Does not add the employee info to the database.
	 *
	 * @param employeeInfoId the primary key for the new employee info
	 * @return the new employee info
	 */
	@Override
	public EmployeeInfo create(long employeeInfoId) {
		EmployeeInfo employeeInfo = new EmployeeInfoImpl();

		employeeInfo.setNew(true);
		employeeInfo.setPrimaryKey(employeeInfoId);

		String uuid = PortalUUIDUtil.generate();

		employeeInfo.setUuid(uuid);

		return employeeInfo;
	}

	/**
	 * Removes the employee info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeInfoId the primary key of the employee info
	 * @return the employee info that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo remove(long employeeInfoId)
		throws NoSuchEmployeeInfoException, SystemException {
		return remove((Serializable)employeeInfoId);
	}

	/**
	 * Removes the employee info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee info
	 * @return the employee info that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo remove(Serializable primaryKey)
		throws NoSuchEmployeeInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmployeeInfo employeeInfo = (EmployeeInfo)session.get(EmployeeInfoImpl.class,
					primaryKey);

			if (employeeInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeInfo);
		}
		catch (NoSuchEmployeeInfoException nsee) {
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
	protected EmployeeInfo removeImpl(EmployeeInfo employeeInfo)
		throws SystemException {
		employeeInfo = toUnwrappedModel(employeeInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeInfo)) {
				employeeInfo = (EmployeeInfo)session.get(EmployeeInfoImpl.class,
						employeeInfo.getPrimaryKeyObj());
			}

			if (employeeInfo != null) {
				session.delete(employeeInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeInfo != null) {
			clearCache(employeeInfo);
		}

		return employeeInfo;
	}

	@Override
	public EmployeeInfo updateImpl(
		com.sambaash.platform.srv.startupprofile.model.EmployeeInfo employeeInfo)
		throws SystemException {
		employeeInfo = toUnwrappedModel(employeeInfo);

		boolean isNew = employeeInfo.isNew();

		EmployeeInfoModelImpl employeeInfoModelImpl = (EmployeeInfoModelImpl)employeeInfo;

		if (Validator.isNull(employeeInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeInfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (employeeInfo.isNew()) {
				session.save(employeeInfo);

				employeeInfo.setNew(false);
			}
			else {
				session.merge(employeeInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmployeeInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((employeeInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeInfoModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { employeeInfoModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((employeeInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeInfoModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { employeeInfoModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInfoImpl.class, employeeInfo.getPrimaryKey(), employeeInfo);

		return employeeInfo;
	}

	protected EmployeeInfo toUnwrappedModel(EmployeeInfo employeeInfo) {
		if (employeeInfo instanceof EmployeeInfoImpl) {
			return employeeInfo;
		}

		EmployeeInfoImpl employeeInfoImpl = new EmployeeInfoImpl();

		employeeInfoImpl.setNew(employeeInfo.isNew());
		employeeInfoImpl.setPrimaryKey(employeeInfo.getPrimaryKey());

		employeeInfoImpl.setUuid(employeeInfo.getUuid());
		employeeInfoImpl.setEmployeeInfoId(employeeInfo.getEmployeeInfoId());
		employeeInfoImpl.setOrganizationId(employeeInfo.getOrganizationId());
		employeeInfoImpl.setEmployees(employeeInfo.getEmployees());
		employeeInfoImpl.setDirectors(employeeInfo.getDirectors());
		employeeInfoImpl.setFinanceEmployees(employeeInfo.getFinanceEmployees());
		employeeInfoImpl.setProfessionalCandidates(employeeInfo.getProfessionalCandidates());
		employeeInfoImpl.setFoundationCandidates(employeeInfo.getFoundationCandidates());
		employeeInfoImpl.setAccountancyCandidates(employeeInfo.getAccountancyCandidates());
		employeeInfoImpl.setISCAAccountants(employeeInfo.getISCAAccountants());
		employeeInfoImpl.setICASAccountants(employeeInfo.getICASAccountants());
		employeeInfoImpl.setICAEWAccountants(employeeInfo.getICAEWAccountants());
		employeeInfoImpl.setCAIAccountants(employeeInfo.getCAIAccountants());
		employeeInfoImpl.setACCAAccountants(employeeInfo.getACCAAccountants());
		employeeInfoImpl.setCPAAccountants(employeeInfo.getCPAAccountants());
		employeeInfoImpl.setCAANZAccountants(employeeInfo.getCAANZAccountants());
		employeeInfoImpl.setCPACanadaAccountants(employeeInfo.getCPACanadaAccountants());
		employeeInfoImpl.setHKCPAAccountants(employeeInfo.getHKCPAAccountants());
		employeeInfoImpl.setSAICAAccountants(employeeInfo.getSAICAAccountants());
		employeeInfoImpl.setJICPAAccountants(employeeInfo.getJICPAAccountants());
		employeeInfoImpl.setAICPAAccountants(employeeInfo.getAICPAAccountants());
		employeeInfoImpl.setCIMAAccountants(employeeInfo.getCIMAAccountants());
		employeeInfoImpl.setOthersAccountants(employeeInfo.getOthersAccountants());

		return employeeInfoImpl;
	}

	/**
	 * Returns the employee info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee info
	 * @return the employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeInfoException, SystemException {
		EmployeeInfo employeeInfo = fetchByPrimaryKey(primaryKey);

		if (employeeInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeInfo;
	}

	/**
	 * Returns the employee info with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException} if it could not be found.
	 *
	 * @param employeeInfoId the primary key of the employee info
	 * @return the employee info
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchEmployeeInfoException if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo findByPrimaryKey(long employeeInfoId)
		throws NoSuchEmployeeInfoException, SystemException {
		return findByPrimaryKey((Serializable)employeeInfoId);
	}

	/**
	 * Returns the employee info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee info
	 * @return the employee info, or <code>null</code> if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmployeeInfo employeeInfo = (EmployeeInfo)EntityCacheUtil.getResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeInfoImpl.class, primaryKey);

		if (employeeInfo == _nullEmployeeInfo) {
			return null;
		}

		if (employeeInfo == null) {
			Session session = null;

			try {
				session = openSession();

				employeeInfo = (EmployeeInfo)session.get(EmployeeInfoImpl.class,
						primaryKey);

				if (employeeInfo != null) {
					cacheResult(employeeInfo);
				}
				else {
					EntityCacheUtil.putResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeInfoImpl.class, primaryKey, _nullEmployeeInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmployeeInfoModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeInfo;
	}

	/**
	 * Returns the employee info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeInfoId the primary key of the employee info
	 * @return the employee info, or <code>null</code> if a employee info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInfo fetchByPrimaryKey(long employeeInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)employeeInfoId);
	}

	/**
	 * Returns all the employee infos.
	 *
	 * @return the employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @return the range of employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.EmployeeInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee infos
	 * @param end the upper bound of the range of employee infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInfo> findAll(int start, int end,
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

		List<EmployeeInfo> list = (List<EmployeeInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYEEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEINFO;

				if (pagination) {
					sql = sql.concat(EmployeeInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeInfo>(list);
				}
				else {
					list = (List<EmployeeInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the employee infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmployeeInfo employeeInfo : findAll()) {
			remove(employeeInfo);
		}
	}

	/**
	 * Returns the number of employee infos.
	 *
	 * @return the number of employee infos
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

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEEINFO);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the employee info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.EmployeeInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmployeeInfo>> listenersList = new ArrayList<ModelListener<EmployeeInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmployeeInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmployeeInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLOYEEINFO = "SELECT employeeInfo FROM EmployeeInfo employeeInfo";
	private static final String _SQL_SELECT_EMPLOYEEINFO_WHERE = "SELECT employeeInfo FROM EmployeeInfo employeeInfo WHERE ";
	private static final String _SQL_COUNT_EMPLOYEEINFO = "SELECT COUNT(employeeInfo) FROM EmployeeInfo employeeInfo";
	private static final String _SQL_COUNT_EMPLOYEEINFO_WHERE = "SELECT COUNT(employeeInfo) FROM EmployeeInfo employeeInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmployeeInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmployeeInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static EmployeeInfo _nullEmployeeInfo = new EmployeeInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmployeeInfo> toCacheModel() {
				return _nullEmployeeInfoCacheModel;
			}
		};

	private static CacheModel<EmployeeInfo> _nullEmployeeInfoCacheModel = new CacheModel<EmployeeInfo>() {
			@Override
			public EmployeeInfo toEntityModel() {
				return _nullEmployeeInfo;
			}
		};
}