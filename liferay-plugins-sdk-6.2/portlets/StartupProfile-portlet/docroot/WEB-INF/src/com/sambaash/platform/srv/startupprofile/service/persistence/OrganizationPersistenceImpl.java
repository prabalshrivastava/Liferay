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

import com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.model.impl.OrganizationImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see OrganizationPersistence
 * @see OrganizationUtil
 * @generated
 */
public class OrganizationPersistenceImpl extends BasePersistenceImpl<Organization>
	implements OrganizationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrganizationUtil} to access the organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrganizationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			OrganizationModelImpl.UUID_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid(String uuid, int start, int end,
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

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if (!Validator.equals(uuid, organization.getUuid())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

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
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUuid_First(uuid, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUuid_Last(uuid, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where uuid = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByUuid_PrevAndNext(long organizationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, organization, uuid,
					orderByComparator, true);

			array[1] = organization;

			array[2] = getByUuid_PrevAndNext(session, organization, uuid,
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

	protected Organization getByUuid_PrevAndNext(Session session,
		Organization organization, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Organization organization : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching organizations
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

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "organization.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "organization.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(organization.uuid IS NULL OR organization.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			OrganizationModelImpl.UUID_COLUMN_BITMASK |
			OrganizationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the organization where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUUID_G(uuid, groupId);

		if (organization == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrganizationException(msg.toString());
		}

		return organization;
	}

	/**
	 * Returns the organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the organization where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Organization) {
			Organization organization = (Organization)result;

			if (!Validator.equals(uuid, organization.getUuid()) ||
					(groupId != organization.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Organization> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Organization organization = list.get(0);

					result = organization;

					cacheResult(organization);

					if ((organization.getUuid() == null) ||
							!organization.getUuid().equals(uuid) ||
							(organization.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, organization);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (Organization)result;
		}
	}

	/**
	 * Removes the organization where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the organization that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization removeByUUID_G(String uuid, long groupId)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByUUID_G(uuid, groupId);

		return remove(organization);
	}

	/**
	 * Returns the number of organizations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "organization.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "organization.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(organization.uuid IS NULL OR organization.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "organization.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			OrganizationModelImpl.UUID_COLUMN_BITMASK |
			OrganizationModelImpl.COMPANYID_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the organizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if (!Validator.equals(uuid, organization.getUuid()) ||
						(companyId != organization.getCompanyId())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByUuid_C_PrevAndNext(long organizationId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, organization, uuid,
					companyId, orderByComparator, true);

			array[1] = organization;

			array[2] = getByUuid_C_PrevAndNext(session, organization, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organization getByUuid_C_PrevAndNext(Session session,
		Organization organization, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Organization organization : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "organization.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "organization.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(organization.uuid IS NULL OR organization.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "organization.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BASEORGANDACTIVE =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybaseOrgAndActive",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BASEORGANDACTIVE =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBybaseOrgAndActive",
			new String[] { Boolean.class.getName(), Boolean.class.getName() },
			OrganizationModelImpl.ISBASEORG_COLUMN_BITMASK |
			OrganizationModelImpl.ACTIVE_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BASEORGANDACTIVE = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybaseOrgAndActive",
			new String[] { Boolean.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the organizations where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findBybaseOrgAndActive(boolean isBaseOrg,
		boolean active) throws SystemException {
		return findBybaseOrgAndActive(isBaseOrg, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where isBaseOrg = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findBybaseOrgAndActive(boolean isBaseOrg,
		boolean active, int start, int end) throws SystemException {
		return findBybaseOrgAndActive(isBaseOrg, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where isBaseOrg = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findBybaseOrgAndActive(boolean isBaseOrg,
		boolean active, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BASEORGANDACTIVE;
			finderArgs = new Object[] { isBaseOrg, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BASEORGANDACTIVE;
			finderArgs = new Object[] {
					isBaseOrg, active,
					
					start, end, orderByComparator
				};
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if ((isBaseOrg != organization.getIsBaseOrg()) ||
						(active != organization.getActive())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ISBASEORG_2);

			query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isBaseOrg);

				qPos.add(active);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findBybaseOrgAndActive_First(boolean isBaseOrg,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchBybaseOrgAndActive_First(isBaseOrg,
				active, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isBaseOrg=");
		msg.append(isBaseOrg);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchBybaseOrgAndActive_First(boolean isBaseOrg,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		List<Organization> list = findBybaseOrgAndActive(isBaseOrg, active, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findBybaseOrgAndActive_Last(boolean isBaseOrg,
		boolean active, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchBybaseOrgAndActive_Last(isBaseOrg,
				active, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isBaseOrg=");
		msg.append(isBaseOrg);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchBybaseOrgAndActive_Last(boolean isBaseOrg,
		boolean active, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBybaseOrgAndActive(isBaseOrg, active);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findBybaseOrgAndActive(isBaseOrg, active,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findBybaseOrgAndActive_PrevAndNext(
		long organizationId, boolean isBaseOrg, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getBybaseOrgAndActive_PrevAndNext(session, organization,
					isBaseOrg, active, orderByComparator, true);

			array[1] = organization;

			array[2] = getBybaseOrgAndActive_PrevAndNext(session, organization,
					isBaseOrg, active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organization getBybaseOrgAndActive_PrevAndNext(Session session,
		Organization organization, boolean isBaseOrg, boolean active,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ISBASEORG_2);

		query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ACTIVE_2);

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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isBaseOrg);

		qPos.add(active);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where isBaseOrg = &#63; and active = &#63; from the database.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBybaseOrgAndActive(boolean isBaseOrg, boolean active)
		throws SystemException {
		for (Organization organization : findBybaseOrgAndActive(isBaseOrg,
				active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where isBaseOrg = &#63; and active = &#63;.
	 *
	 * @param isBaseOrg the is base org
	 * @param active the active
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybaseOrgAndActive(boolean isBaseOrg, boolean active)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BASEORGANDACTIVE;

		Object[] finderArgs = new Object[] { isBaseOrg, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ISBASEORG_2);

			query.append(_FINDER_COLUMN_BASEORGANDACTIVE_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isBaseOrg);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_BASEORGANDACTIVE_ISBASEORG_2 = "organization.isBaseOrg = ? AND ";
	private static final String _FINDER_COLUMN_BASEORGANDACTIVE_ACTIVE_2 = "organization.active = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTUPNAME =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStartupName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTUPNAME =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStartupName",
			new String[] { String.class.getName() },
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STARTUPNAME = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStartupName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organizations where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByStartupName(String name)
		throws SystemException {
		return findByStartupName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the organizations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByStartupName(String name, int start, int end)
		throws SystemException {
		return findByStartupName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByStartupName(String name, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTUPNAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STARTUPNAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if (!Validator.equals(name, organization.getName())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name.toLowerCase());
				}

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByStartupName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByStartupName_First(name,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByStartupName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByStartupName(name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByStartupName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByStartupName_Last(name,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByStartupName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStartupName(name);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByStartupName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where name = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByStartupName_PrevAndNext(long organizationId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByStartupName_PrevAndNext(session, organization,
					name, orderByComparator, true);

			array[1] = organization;

			array[2] = getByStartupName_PrevAndNext(session, organization,
					name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Organization getByStartupName_PrevAndNext(Session session,
		Organization organization, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_STARTUPNAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STARTUPNAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_STARTUPNAME_NAME_2);
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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStartupName(String name) throws SystemException {
		for (Organization organization : findByStartupName(name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStartupName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STARTUPNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_STARTUPNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name.toLowerCase());
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

	private static final String _FINDER_COLUMN_STARTUPNAME_NAME_1 = "organization.name IS NULL AND organization.active = 1 and organization.isBaseOrg = 1";
	private static final String _FINDER_COLUMN_STARTUPNAME_NAME_2 = "lower(organization.name) = ? AND organization.active = 1 and organization.isBaseOrg = 1";
	private static final String _FINDER_COLUMN_STARTUPNAME_NAME_3 = "(organization.name IS NULL OR organization.name = '') AND organization.active = 1 and organization.isBaseOrg = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			OrganizationModelImpl.USERID_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if ((userId != organization.getUserId())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUserId_First(userId,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUserId_Last(userId, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where userId = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByUserId_PrevAndNext(long organizationId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, organization, userId,
					orderByComparator, true);

			array[1] = organization;

			array[2] = getByUserId_PrevAndNext(session, organization, userId,
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

	protected Organization getByUserId_PrevAndNext(Session session,
		Organization organization, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (Organization organization : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "organization.userId = ? AND organization.active = 1 and organization.isBaseOrg = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UENNUMBER =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUENNumber",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UENNUMBER =
		new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUENNumber",
			new String[] { String.class.getName() },
			OrganizationModelImpl.UEN_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UENNUMBER = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUENNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns all the organizations where uen = &#63;.
	 *
	 * @param uen the uen
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUENNumber(String uen)
		throws SystemException {
		return findByUENNumber(uen, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where uen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uen the uen
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUENNumber(String uen, int start, int end)
		throws SystemException {
		return findByUENNumber(uen, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where uen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uen the uen
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByUENNumber(String uen, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UENNUMBER;
			finderArgs = new Object[] { uen };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UENNUMBER;
			finderArgs = new Object[] { uen, start, end, orderByComparator };
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if (!Validator.equals(uen, organization.getUen())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			boolean bindUen = false;

			if (uen == null) {
				query.append(_FINDER_COLUMN_UENNUMBER_UEN_1);
			}
			else if (uen.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UENNUMBER_UEN_3);
			}
			else {
				bindUen = true;

				query.append(_FINDER_COLUMN_UENNUMBER_UEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUen) {
					qPos.add(uen.toLowerCase());
				}

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where uen = &#63;.
	 *
	 * @param uen the uen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUENNumber_First(String uen,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUENNumber_First(uen,
				orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uen=");
		msg.append(uen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where uen = &#63;.
	 *
	 * @param uen the uen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUENNumber_First(String uen,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByUENNumber(uen, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where uen = &#63;.
	 *
	 * @param uen the uen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByUENNumber_Last(String uen,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByUENNumber_Last(uen, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uen=");
		msg.append(uen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where uen = &#63;.
	 *
	 * @param uen the uen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByUENNumber_Last(String uen,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUENNumber(uen);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByUENNumber(uen, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where uen = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param uen the uen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByUENNumber_PrevAndNext(long organizationId,
		String uen, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByUENNumber_PrevAndNext(session, organization, uen,
					orderByComparator, true);

			array[1] = organization;

			array[2] = getByUENNumber_PrevAndNext(session, organization, uen,
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

	protected Organization getByUENNumber_PrevAndNext(Session session,
		Organization organization, String uen,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		boolean bindUen = false;

		if (uen == null) {
			query.append(_FINDER_COLUMN_UENNUMBER_UEN_1);
		}
		else if (uen.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UENNUMBER_UEN_3);
		}
		else {
			bindUen = true;

			query.append(_FINDER_COLUMN_UENNUMBER_UEN_2);
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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUen) {
			qPos.add(uen.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where uen = &#63; from the database.
	 *
	 * @param uen the uen
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUENNumber(String uen) throws SystemException {
		for (Organization organization : findByUENNumber(uen,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where uen = &#63;.
	 *
	 * @param uen the uen
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUENNumber(String uen) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UENNUMBER;

		Object[] finderArgs = new Object[] { uen };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			boolean bindUen = false;

			if (uen == null) {
				query.append(_FINDER_COLUMN_UENNUMBER_UEN_1);
			}
			else if (uen.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UENNUMBER_UEN_3);
			}
			else {
				bindUen = true;

				query.append(_FINDER_COLUMN_UENNUMBER_UEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUen) {
					qPos.add(uen.toLowerCase());
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

	private static final String _FINDER_COLUMN_UENNUMBER_UEN_1 = "organization.uen IS NULL AND organization.active = 1 and organization.isBaseOrg = 1";
	private static final String _FINDER_COLUMN_UENNUMBER_UEN_2 = "lower(organization.uen) = ? AND organization.active = 1 and organization.isBaseOrg = 1";
	private static final String _FINDER_COLUMN_UENNUMBER_UEN_3 = "(organization.uen IS NULL OR organization.uen = '') AND organization.active = 1 and organization.isBaseOrg = 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATO = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByATO",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATO = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, OrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByATO",
			new String[] { Boolean.class.getName() },
			OrganizationModelImpl.ISATO_COLUMN_BITMASK |
			OrganizationModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATO = new FinderPath(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByATO",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the organizations where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @return the matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByATO(boolean isATO)
		throws SystemException {
		return findByATO(isATO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations where isATO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isATO the is a t o
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByATO(boolean isATO, int start, int end)
		throws SystemException {
		return findByATO(isATO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations where isATO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isATO the is a t o
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findByATO(boolean isATO, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATO;
			finderArgs = new Object[] { isATO };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATO;
			finderArgs = new Object[] { isATO, start, end, orderByComparator };
		}

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Organization organization : list) {
				if ((isATO != organization.getIsATO())) {
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

			query.append(_SQL_SELECT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ATO_ISATO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isATO);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first organization in the ordered set where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByATO_First(boolean isATO,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByATO_First(isATO, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isATO=");
		msg.append(isATO);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the first organization in the ordered set where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByATO_First(boolean isATO,
		OrderByComparator orderByComparator) throws SystemException {
		List<Organization> list = findByATO(isATO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last organization in the ordered set where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByATO_Last(boolean isATO,
		OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByATO_Last(isATO, orderByComparator);

		if (organization != null) {
			return organization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isATO=");
		msg.append(isATO);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrganizationException(msg.toString());
	}

	/**
	 * Returns the last organization in the ordered set where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching organization, or <code>null</code> if a matching organization could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByATO_Last(boolean isATO,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByATO(isATO);

		if (count == 0) {
			return null;
		}

		List<Organization> list = findByATO(isATO, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the organizations before and after the current organization in the ordered set where isATO = &#63;.
	 *
	 * @param organizationId the primary key of the current organization
	 * @param isATO the is a t o
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization[] findByATO_PrevAndNext(long organizationId,
		boolean isATO, OrderByComparator orderByComparator)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = findByPrimaryKey(organizationId);

		Session session = null;

		try {
			session = openSession();

			Organization[] array = new OrganizationImpl[3];

			array[0] = getByATO_PrevAndNext(session, organization, isATO,
					orderByComparator, true);

			array[1] = organization;

			array[2] = getByATO_PrevAndNext(session, organization, isATO,
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

	protected Organization getByATO_PrevAndNext(Session session,
		Organization organization, boolean isATO,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_ATO_ISATO_2);

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
			query.append(OrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isATO);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(organization);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Organization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the organizations where isATO = &#63; from the database.
	 *
	 * @param isATO the is a t o
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByATO(boolean isATO) throws SystemException {
		for (Organization organization : findByATO(isATO, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations where isATO = &#63;.
	 *
	 * @param isATO the is a t o
	 * @return the number of matching organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByATO(boolean isATO) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ATO;

		Object[] finderArgs = new Object[] { isATO };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ATO_ISATO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isATO);

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

	private static final String _FINDER_COLUMN_ATO_ISATO_2 = "organization.isATO = ?";

	public OrganizationPersistenceImpl() {
		setModelClass(Organization.class);
	}

	/**
	 * Caches the organization in the entity cache if it is enabled.
	 *
	 * @param organization the organization
	 */
	@Override
	public void cacheResult(Organization organization) {
		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { organization.getUuid(), organization.getGroupId() },
			organization);

		organization.resetOriginalValues();
	}

	/**
	 * Caches the organizations in the entity cache if it is enabled.
	 *
	 * @param organizations the organizations
	 */
	@Override
	public void cacheResult(List<Organization> organizations) {
		for (Organization organization : organizations) {
			if (EntityCacheUtil.getResult(
						OrganizationModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationImpl.class, organization.getPrimaryKey()) == null) {
				cacheResult(organization);
			}
			else {
				organization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all organizations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrganizationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrganizationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the organization.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Organization organization) {
		EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(organization);
	}

	@Override
	public void clearCache(List<Organization> organizations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Organization organization : organizations) {
			EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationImpl.class, organization.getPrimaryKey());

			clearUniqueFindersCache(organization);
		}
	}

	protected void cacheUniqueFindersCache(Organization organization) {
		if (organization.isNew()) {
			Object[] args = new Object[] {
					organization.getUuid(), organization.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				organization);
		}
		else {
			OrganizationModelImpl organizationModelImpl = (OrganizationModelImpl)organization;

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organization.getUuid(), organization.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					organization);
			}
		}
	}

	protected void clearUniqueFindersCache(Organization organization) {
		OrganizationModelImpl organizationModelImpl = (OrganizationModelImpl)organization;

		Object[] args = new Object[] {
				organization.getUuid(), organization.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((organizationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					organizationModelImpl.getOriginalUuid(),
					organizationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new organization with the primary key. Does not add the organization to the database.
	 *
	 * @param organizationId the primary key for the new organization
	 * @return the new organization
	 */
	@Override
	public Organization create(long organizationId) {
		Organization organization = new OrganizationImpl();

		organization.setNew(true);
		organization.setPrimaryKey(organizationId);

		String uuid = PortalUUIDUtil.generate();

		organization.setUuid(uuid);

		return organization;
	}

	/**
	 * Removes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization remove(long organizationId)
		throws NoSuchOrganizationException, SystemException {
		return remove((Serializable)organizationId);
	}

	/**
	 * Removes the organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization remove(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Organization organization = (Organization)session.get(OrganizationImpl.class,
					primaryKey);

			if (organization == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(organization);
		}
		catch (NoSuchOrganizationException nsee) {
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
	protected Organization removeImpl(Organization organization)
		throws SystemException {
		organization = toUnwrappedModel(organization);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(organization)) {
				organization = (Organization)session.get(OrganizationImpl.class,
						organization.getPrimaryKeyObj());
			}

			if (organization != null) {
				session.delete(organization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (organization != null) {
			clearCache(organization);
		}

		return organization;
	}

	@Override
	public Organization updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Organization organization)
		throws SystemException {
		organization = toUnwrappedModel(organization);

		boolean isNew = organization.isNew();

		OrganizationModelImpl organizationModelImpl = (OrganizationModelImpl)organization;

		if (Validator.isNull(organization.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			organization.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (organization.isNew()) {
				session.save(organization);

				organization.setNew(false);
			}
			else {
				session.merge(organization);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrganizationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { organizationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalUuid(),
						organizationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						organizationModelImpl.getUuid(),
						organizationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BASEORGANDACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalIsBaseOrg(),
						organizationModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASEORGANDACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BASEORGANDACTIVE,
					args);

				args = new Object[] {
						organizationModelImpl.getIsBaseOrg(),
						organizationModelImpl.getActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BASEORGANDACTIVE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BASEORGANDACTIVE,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTUPNAME,
					args);

				args = new Object[] { organizationModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STARTUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STARTUPNAME,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { organizationModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UENNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalUen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UENNUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UENNUMBER,
					args);

				args = new Object[] { organizationModelImpl.getUen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UENNUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UENNUMBER,
					args);
			}

			if ((organizationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						organizationModelImpl.getOriginalIsATO()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATO,
					args);

				args = new Object[] { organizationModelImpl.getIsATO() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATO,
					args);
			}
		}

		EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
			OrganizationImpl.class, organization.getPrimaryKey(), organization);

		clearUniqueFindersCache(organization);
		cacheUniqueFindersCache(organization);

		return organization;
	}

	protected Organization toUnwrappedModel(Organization organization) {
		if (organization instanceof OrganizationImpl) {
			return organization;
		}

		OrganizationImpl organizationImpl = new OrganizationImpl();

		organizationImpl.setNew(organization.isNew());
		organizationImpl.setPrimaryKey(organization.getPrimaryKey());

		organizationImpl.setUuid(organization.getUuid());
		organizationImpl.setOrganizationId(organization.getOrganizationId());
		organizationImpl.setName(organization.getName());
		organizationImpl.setCorporateCode(organization.getCorporateCode());
		organizationImpl.setCorporateType(organization.getCorporateType());
		organizationImpl.setCorporateCategory(organization.getCorporateCategory());
		organizationImpl.setApiPath(organization.getApiPath());
		organizationImpl.setCategories(organization.getCategories());
		organizationImpl.setFoundedOn(organization.getFoundedOn());
		organizationImpl.setNoOfEmployees(organization.getNoOfEmployees());
		organizationImpl.setEmailId(organization.getEmailId());
		organizationImpl.setWebsite(organization.getWebsite());
		organizationImpl.setFacebook(organization.getFacebook());
		organizationImpl.setTwitter(organization.getTwitter());
		organizationImpl.setLinkedIn(organization.getLinkedIn());
		organizationImpl.setCrunchbase(organization.getCrunchbase());
		organizationImpl.setMobile(organization.getMobile());
		organizationImpl.setTotalFunds(organization.getTotalFunds());
		organizationImpl.setUen(organization.getUen());
		organizationImpl.setDescription(organization.getDescription());
		organizationImpl.setShortPitch(organization.getShortPitch());
		organizationImpl.setLifecycleStage(organization.getLifecycleStage());
		organizationImpl.setCapitalRaised(organization.getCapitalRaised());
		organizationImpl.setIsIncorporated(organization.isIsIncorporated());
		organizationImpl.setStockSymbol(organization.getStockSymbol());
		organizationImpl.setImageUrl(organization.getImageUrl());
		organizationImpl.setVideos(organization.getVideos());
		organizationImpl.setProfileOutline(organization.getProfileOutline());
		organizationImpl.setRaisingFunds(organization.getRaisingFunds());
		organizationImpl.setExtras(organization.getExtras());
		organizationImpl.setUniqueDesc(organization.getUniqueDesc());
		organizationImpl.setLinks(organization.getLinks());
		organizationImpl.setIsBaseOrg(organization.isIsBaseOrg());
		organizationImpl.setCompleteness(organization.isCompleteness());
		organizationImpl.setGroupId(organization.getGroupId());
		organizationImpl.setCompanyId(organization.getCompanyId());
		organizationImpl.setUserId(organization.getUserId());
		organizationImpl.setUserName(organization.getUserName());
		organizationImpl.setCreateDate(organization.getCreateDate());
		organizationImpl.setModifiedDate(organization.getModifiedDate());
		organizationImpl.setActive(organization.isActive());
		organizationImpl.setLogoId(organization.getLogoId());
		organizationImpl.setMethodologyType(organization.getMethodologyType());
		organizationImpl.setMethodologySubType(organization.getMethodologySubType());
		organizationImpl.setStage(organization.getStage());
		organizationImpl.setFeedback(organization.getFeedback());
		organizationImpl.setVideoLinks(organization.getVideoLinks());
		organizationImpl.setProjectsWorkedOn(organization.getProjectsWorkedOn());
		organizationImpl.setShowInBlackbook(organization.isShowInBlackbook());
		organizationImpl.setFaxNumber(organization.getFaxNumber());
		organizationImpl.setContactName(organization.getContactName());
		organizationImpl.setContactDesignation(organization.getContactDesignation());
		organizationImpl.setPipelineStatus(organization.getPipelineStatus());
		organizationImpl.setBusinessDevManager(organization.getBusinessDevManager());
		organizationImpl.setPrevBusinessDevManager(organization.getPrevBusinessDevManager());
		organizationImpl.setIsATO(organization.isIsATO());
		organizationImpl.setApprovalDate(organization.getApprovalDate());
		organizationImpl.setStatus(organization.getStatus());
		organizationImpl.setListedCo(organization.getListedCo());
		organizationImpl.setNoOfPotentialCandidates(organization.getNoOfPotentialCandidates());

		return organizationImpl;
	}

	/**
	 * Returns the organization with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrganizationException, SystemException {
		Organization organization = fetchByPrimaryKey(primaryKey);

		if (organization == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrganizationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return organization;
	}

	/**
	 * Returns the organization with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException} if it could not be found.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchOrganizationException if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization findByPrimaryKey(long organizationId)
		throws NoSuchOrganizationException, SystemException {
		return findByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns the organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the organization
	 * @return the organization, or <code>null</code> if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Organization organization = (Organization)EntityCacheUtil.getResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
				OrganizationImpl.class, primaryKey);

		if (organization == _nullOrganization) {
			return null;
		}

		if (organization == null) {
			Session session = null;

			try {
				session = openSession();

				organization = (Organization)session.get(OrganizationImpl.class,
						primaryKey);

				if (organization != null) {
					cacheResult(organization);
				}
				else {
					EntityCacheUtil.putResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
						OrganizationImpl.class, primaryKey, _nullOrganization);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrganizationModelImpl.ENTITY_CACHE_ENABLED,
					OrganizationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return organization;
	}

	/**
	 * Returns the organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param organizationId the primary key of the organization
	 * @return the organization, or <code>null</code> if a organization with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organization fetchByPrimaryKey(long organizationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)organizationId);
	}

	/**
	 * Returns all the organizations.
	 *
	 * @return the organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @return the range of organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizations
	 * @param end the upper bound of the range of organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of organizations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organization> findAll(int start, int end,
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

		List<Organization> list = (List<Organization>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGANIZATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGANIZATION;

				if (pagination) {
					sql = sql.concat(OrganizationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Organization>(list);
				}
				else {
					list = (List<Organization>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the organizations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Organization organization : findAll()) {
			remove(organization);
		}
	}

	/**
	 * Returns the number of organizations.
	 *
	 * @return the number of organizations
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

				Query q = session.createQuery(_SQL_COUNT_ORGANIZATION);

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
	 * Initializes the organization persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Organization")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Organization>> listenersList = new ArrayList<ModelListener<Organization>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Organization>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrganizationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGANIZATION = "SELECT organization FROM Organization organization";
	private static final String _SQL_SELECT_ORGANIZATION_WHERE = "SELECT organization FROM Organization organization WHERE ";
	private static final String _SQL_COUNT_ORGANIZATION = "SELECT COUNT(organization) FROM Organization organization";
	private static final String _SQL_COUNT_ORGANIZATION_WHERE = "SELECT COUNT(organization) FROM Organization organization WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "organization.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Organization exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Organization exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrganizationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "active"
			});
	private static Organization _nullOrganization = new OrganizationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Organization> toCacheModel() {
				return _nullOrganizationCacheModel;
			}
		};

	private static CacheModel<Organization> _nullOrganizationCacheModel = new CacheModel<Organization>() {
			@Override
			public Organization toEntityModel() {
				return _nullOrganization;
			}
		};
}