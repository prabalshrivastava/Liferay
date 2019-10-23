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

import com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException;
import com.sambaash.platform.srv.startupprofile.model.ReAccreditation;
import com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the re accreditation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see ReAccreditationPersistence
 * @see ReAccreditationUtil
 * @generated
 */
public class ReAccreditationPersistenceImpl extends BasePersistenceImpl<ReAccreditation>
	implements ReAccreditationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ReAccreditationUtil} to access the re accreditation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ReAccreditationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ReAccreditationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the re accreditations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the re accreditations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @return the range of matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the re accreditations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByUuid(String uuid, int start, int end,
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

		List<ReAccreditation> list = (List<ReAccreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReAccreditation reAccreditation : list) {
				if (!Validator.equals(uuid, reAccreditation.getUuid())) {
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

			query.append(_SQL_SELECT_REACCREDITATION_WHERE);

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
				query.append(ReAccreditationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ReAccreditation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReAccreditation>(list);
				}
				else {
					list = (List<ReAccreditation>)QueryUtil.list(q,
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
	 * Returns the first re accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = fetchByUuid_First(uuid,
				orderByComparator);

		if (reAccreditation != null) {
			return reAccreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReAccreditationException(msg.toString());
	}

	/**
	 * Returns the first re accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReAccreditation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last re accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = fetchByUuid_Last(uuid,
				orderByComparator);

		if (reAccreditation != null) {
			return reAccreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReAccreditationException(msg.toString());
	}

	/**
	 * Returns the last re accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ReAccreditation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the re accreditations before and after the current re accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param accreditationId the primary key of the current re accreditation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation[] findByUuid_PrevAndNext(long accreditationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = findByPrimaryKey(accreditationId);

		Session session = null;

		try {
			session = openSession();

			ReAccreditation[] array = new ReAccreditationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, reAccreditation, uuid,
					orderByComparator, true);

			array[1] = reAccreditation;

			array[2] = getByUuid_PrevAndNext(session, reAccreditation, uuid,
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

	protected ReAccreditation getByUuid_PrevAndNext(Session session,
		ReAccreditation reAccreditation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REACCREDITATION_WHERE);

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
			query.append(ReAccreditationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(reAccreditation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReAccreditation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the re accreditations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ReAccreditation reAccreditation : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reAccreditation);
		}
	}

	/**
	 * Returns the number of re accreditations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching re accreditations
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

			query.append(_SQL_COUNT_REACCREDITATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "reAccreditation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "reAccreditation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(reAccreditation.uuid IS NULL OR reAccreditation.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED,
			ReAccreditationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			ReAccreditationModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the re accreditations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the re accreditations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @return the range of matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the re accreditations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findByOrganizationId(long organizationId,
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

		List<ReAccreditation> list = (List<ReAccreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ReAccreditation reAccreditation : list) {
				if ((organizationId != reAccreditation.getOrganizationId())) {
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

			query.append(_SQL_SELECT_REACCREDITATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ReAccreditationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<ReAccreditation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReAccreditation>(list);
				}
				else {
					list = (List<ReAccreditation>)QueryUtil.list(q,
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
	 * Returns the first re accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (reAccreditation != null) {
			return reAccreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReAccreditationException(msg.toString());
	}

	/**
	 * Returns the first re accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ReAccreditation> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last re accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (reAccreditation != null) {
			return reAccreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchReAccreditationException(msg.toString());
	}

	/**
	 * Returns the last re accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching re accreditation, or <code>null</code> if a matching re accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<ReAccreditation> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the re accreditations before and after the current re accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param accreditationId the primary key of the current re accreditation
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation[] findByOrganizationId_PrevAndNext(
		long accreditationId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = findByPrimaryKey(accreditationId);

		Session session = null;

		try {
			session = openSession();

			ReAccreditation[] array = new ReAccreditationImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session,
					reAccreditation, organizationId, orderByComparator, true);

			array[1] = reAccreditation;

			array[2] = getByOrganizationId_PrevAndNext(session,
					reAccreditation, organizationId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ReAccreditation getByOrganizationId_PrevAndNext(Session session,
		ReAccreditation reAccreditation, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REACCREDITATION_WHERE);

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
			query.append(ReAccreditationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(reAccreditation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ReAccreditation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the re accreditations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (ReAccreditation reAccreditation : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(reAccreditation);
		}
	}

	/**
	 * Returns the number of re accreditations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching re accreditations
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

			query.append(_SQL_COUNT_REACCREDITATION_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "reAccreditation.organizationId = ?";

	public ReAccreditationPersistenceImpl() {
		setModelClass(ReAccreditation.class);
	}

	/**
	 * Caches the re accreditation in the entity cache if it is enabled.
	 *
	 * @param reAccreditation the re accreditation
	 */
	@Override
	public void cacheResult(ReAccreditation reAccreditation) {
		EntityCacheUtil.putResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationImpl.class, reAccreditation.getPrimaryKey(),
			reAccreditation);

		reAccreditation.resetOriginalValues();
	}

	/**
	 * Caches the re accreditations in the entity cache if it is enabled.
	 *
	 * @param reAccreditations the re accreditations
	 */
	@Override
	public void cacheResult(List<ReAccreditation> reAccreditations) {
		for (ReAccreditation reAccreditation : reAccreditations) {
			if (EntityCacheUtil.getResult(
						ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
						ReAccreditationImpl.class,
						reAccreditation.getPrimaryKey()) == null) {
				cacheResult(reAccreditation);
			}
			else {
				reAccreditation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all re accreditations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ReAccreditationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ReAccreditationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the re accreditation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ReAccreditation reAccreditation) {
		EntityCacheUtil.removeResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationImpl.class, reAccreditation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ReAccreditation> reAccreditations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ReAccreditation reAccreditation : reAccreditations) {
			EntityCacheUtil.removeResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
				ReAccreditationImpl.class, reAccreditation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new re accreditation with the primary key. Does not add the re accreditation to the database.
	 *
	 * @param accreditationId the primary key for the new re accreditation
	 * @return the new re accreditation
	 */
	@Override
	public ReAccreditation create(long accreditationId) {
		ReAccreditation reAccreditation = new ReAccreditationImpl();

		reAccreditation.setNew(true);
		reAccreditation.setPrimaryKey(accreditationId);

		String uuid = PortalUUIDUtil.generate();

		reAccreditation.setUuid(uuid);

		return reAccreditation;
	}

	/**
	 * Removes the re accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accreditationId the primary key of the re accreditation
	 * @return the re accreditation that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation remove(long accreditationId)
		throws NoSuchReAccreditationException, SystemException {
		return remove((Serializable)accreditationId);
	}

	/**
	 * Removes the re accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the re accreditation
	 * @return the re accreditation that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation remove(Serializable primaryKey)
		throws NoSuchReAccreditationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ReAccreditation reAccreditation = (ReAccreditation)session.get(ReAccreditationImpl.class,
					primaryKey);

			if (reAccreditation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchReAccreditationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(reAccreditation);
		}
		catch (NoSuchReAccreditationException nsee) {
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
	protected ReAccreditation removeImpl(ReAccreditation reAccreditation)
		throws SystemException {
		reAccreditation = toUnwrappedModel(reAccreditation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(reAccreditation)) {
				reAccreditation = (ReAccreditation)session.get(ReAccreditationImpl.class,
						reAccreditation.getPrimaryKeyObj());
			}

			if (reAccreditation != null) {
				session.delete(reAccreditation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (reAccreditation != null) {
			clearCache(reAccreditation);
		}

		return reAccreditation;
	}

	@Override
	public ReAccreditation updateImpl(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation)
		throws SystemException {
		reAccreditation = toUnwrappedModel(reAccreditation);

		boolean isNew = reAccreditation.isNew();

		ReAccreditationModelImpl reAccreditationModelImpl = (ReAccreditationModelImpl)reAccreditation;

		if (Validator.isNull(reAccreditation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			reAccreditation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (reAccreditation.isNew()) {
				session.save(reAccreditation);

				reAccreditation.setNew(false);
			}
			else {
				session.merge(reAccreditation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ReAccreditationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((reAccreditationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reAccreditationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { reAccreditationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((reAccreditationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						reAccreditationModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { reAccreditationModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
			ReAccreditationImpl.class, reAccreditation.getPrimaryKey(),
			reAccreditation);

		return reAccreditation;
	}

	protected ReAccreditation toUnwrappedModel(ReAccreditation reAccreditation) {
		if (reAccreditation instanceof ReAccreditationImpl) {
			return reAccreditation;
		}

		ReAccreditationImpl reAccreditationImpl = new ReAccreditationImpl();

		reAccreditationImpl.setNew(reAccreditation.isNew());
		reAccreditationImpl.setPrimaryKey(reAccreditation.getPrimaryKey());

		reAccreditationImpl.setUuid(reAccreditation.getUuid());
		reAccreditationImpl.setAccreditationId(reAccreditation.getAccreditationId());
		reAccreditationImpl.setOrganizationId(reAccreditation.getOrganizationId());
		reAccreditationImpl.setAccreditationStatus(reAccreditation.getAccreditationStatus());
		reAccreditationImpl.setDateOfAccreditation(reAccreditation.getDateOfAccreditation());
		reAccreditationImpl.setDateOfExpiry(reAccreditation.getDateOfExpiry());
		reAccreditationImpl.setLatestPaymentDate(reAccreditation.getLatestPaymentDate());
		reAccreditationImpl.setStartDateOfReaccreditation(reAccreditation.getStartDateOfReaccreditation());
		reAccreditationImpl.setDateOfReaccdtReview(reAccreditation.getDateOfReaccdtReview());
		reAccreditationImpl.setAccreditationBy(reAccreditation.getAccreditationBy());

		return reAccreditationImpl;
	}

	/**
	 * Returns the re accreditation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the re accreditation
	 * @return the re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchReAccreditationException, SystemException {
		ReAccreditation reAccreditation = fetchByPrimaryKey(primaryKey);

		if (reAccreditation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchReAccreditationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return reAccreditation;
	}

	/**
	 * Returns the re accreditation with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException} if it could not be found.
	 *
	 * @param accreditationId the primary key of the re accreditation
	 * @return the re accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchReAccreditationException if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation findByPrimaryKey(long accreditationId)
		throws NoSuchReAccreditationException, SystemException {
		return findByPrimaryKey((Serializable)accreditationId);
	}

	/**
	 * Returns the re accreditation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the re accreditation
	 * @return the re accreditation, or <code>null</code> if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ReAccreditation reAccreditation = (ReAccreditation)EntityCacheUtil.getResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
				ReAccreditationImpl.class, primaryKey);

		if (reAccreditation == _nullReAccreditation) {
			return null;
		}

		if (reAccreditation == null) {
			Session session = null;

			try {
				session = openSession();

				reAccreditation = (ReAccreditation)session.get(ReAccreditationImpl.class,
						primaryKey);

				if (reAccreditation != null) {
					cacheResult(reAccreditation);
				}
				else {
					EntityCacheUtil.putResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
						ReAccreditationImpl.class, primaryKey,
						_nullReAccreditation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ReAccreditationModelImpl.ENTITY_CACHE_ENABLED,
					ReAccreditationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return reAccreditation;
	}

	/**
	 * Returns the re accreditation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accreditationId the primary key of the re accreditation
	 * @return the re accreditation, or <code>null</code> if a re accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ReAccreditation fetchByPrimaryKey(long accreditationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)accreditationId);
	}

	/**
	 * Returns all the re accreditations.
	 *
	 * @return the re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the re accreditations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @return the range of re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the re accreditations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of re accreditations
	 * @param end the upper bound of the range of re accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of re accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ReAccreditation> findAll(int start, int end,
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

		List<ReAccreditation> list = (List<ReAccreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REACCREDITATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REACCREDITATION;

				if (pagination) {
					sql = sql.concat(ReAccreditationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ReAccreditation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ReAccreditation>(list);
				}
				else {
					list = (List<ReAccreditation>)QueryUtil.list(q,
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
	 * Removes all the re accreditations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ReAccreditation reAccreditation : findAll()) {
			remove(reAccreditation);
		}
	}

	/**
	 * Returns the number of re accreditations.
	 *
	 * @return the number of re accreditations
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

				Query q = session.createQuery(_SQL_COUNT_REACCREDITATION);

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
	 * Initializes the re accreditation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.ReAccreditation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ReAccreditation>> listenersList = new ArrayList<ModelListener<ReAccreditation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ReAccreditation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ReAccreditationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REACCREDITATION = "SELECT reAccreditation FROM ReAccreditation reAccreditation";
	private static final String _SQL_SELECT_REACCREDITATION_WHERE = "SELECT reAccreditation FROM ReAccreditation reAccreditation WHERE ";
	private static final String _SQL_COUNT_REACCREDITATION = "SELECT COUNT(reAccreditation) FROM ReAccreditation reAccreditation";
	private static final String _SQL_COUNT_REACCREDITATION_WHERE = "SELECT COUNT(reAccreditation) FROM ReAccreditation reAccreditation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "reAccreditation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ReAccreditation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ReAccreditation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ReAccreditationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ReAccreditation _nullReAccreditation = new ReAccreditationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ReAccreditation> toCacheModel() {
				return _nullReAccreditationCacheModel;
			}
		};

	private static CacheModel<ReAccreditation> _nullReAccreditationCacheModel = new CacheModel<ReAccreditation>() {
			@Override
			public ReAccreditation toEntityModel() {
				return _nullReAccreditation;
			}
		};
}