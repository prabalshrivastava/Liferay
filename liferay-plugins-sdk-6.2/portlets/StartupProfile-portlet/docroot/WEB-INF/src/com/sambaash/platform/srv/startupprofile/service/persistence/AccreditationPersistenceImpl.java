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

import com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException;
import com.sambaash.platform.srv.startupprofile.model.Accreditation;
import com.sambaash.platform.srv.startupprofile.model.impl.AccreditationImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the accreditation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see AccreditationPersistence
 * @see AccreditationUtil
 * @generated
 */
public class AccreditationPersistenceImpl extends BasePersistenceImpl<Accreditation>
	implements AccreditationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AccreditationUtil} to access the accreditation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AccreditationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			AccreditationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the accreditations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the accreditations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @return the range of matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the accreditations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByUuid(String uuid, int start, int end,
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

		List<Accreditation> list = (List<Accreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Accreditation accreditation : list) {
				if (!Validator.equals(uuid, accreditation.getUuid())) {
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

			query.append(_SQL_SELECT_ACCREDITATION_WHERE);

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
				query.append(AccreditationModelImpl.ORDER_BY_JPQL);
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
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Accreditation>(list);
				}
				else {
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = fetchByUuid_First(uuid, orderByComparator);

		if (accreditation != null) {
			return accreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccreditationException(msg.toString());
	}

	/**
	 * Returns the first accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accreditation, or <code>null</code> if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Accreditation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = fetchByUuid_Last(uuid, orderByComparator);

		if (accreditation != null) {
			return accreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccreditationException(msg.toString());
	}

	/**
	 * Returns the last accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accreditation, or <code>null</code> if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Accreditation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the accreditations before and after the current accreditation in the ordered set where uuid = &#63;.
	 *
	 * @param accreditationId the primary key of the current accreditation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation[] findByUuid_PrevAndNext(long accreditationId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = findByPrimaryKey(accreditationId);

		Session session = null;

		try {
			session = openSession();

			Accreditation[] array = new AccreditationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, accreditation, uuid,
					orderByComparator, true);

			array[1] = accreditation;

			array[2] = getByUuid_PrevAndNext(session, accreditation, uuid,
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

	protected Accreditation getByUuid_PrevAndNext(Session session,
		Accreditation accreditation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCREDITATION_WHERE);

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
			query.append(AccreditationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(accreditation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Accreditation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accreditations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Accreditation accreditation : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(accreditation);
		}
	}

	/**
	 * Returns the number of accreditations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching accreditations
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

			query.append(_SQL_COUNT_ACCREDITATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "accreditation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "accreditation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(accreditation.uuid IS NULL OR accreditation.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED,
			AccreditationImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationId", new String[] { Long.class.getName() },
			AccreditationModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the accreditations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the accreditations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @return the range of matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the accreditations where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findByOrganizationId(long organizationId,
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

		List<Accreditation> list = (List<Accreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Accreditation accreditation : list) {
				if ((organizationId != accreditation.getOrganizationId())) {
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

			query.append(_SQL_SELECT_ACCREDITATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AccreditationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Accreditation>(list);
				}
				else {
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (accreditation != null) {
			return accreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccreditationException(msg.toString());
	}

	/**
	 * Returns the first accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching accreditation, or <code>null</code> if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Accreditation> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (accreditation != null) {
			return accreditation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAccreditationException(msg.toString());
	}

	/**
	 * Returns the last accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching accreditation, or <code>null</code> if a matching accreditation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<Accreditation> list = findByOrganizationId(organizationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the accreditations before and after the current accreditation in the ordered set where organizationId = &#63;.
	 *
	 * @param accreditationId the primary key of the current accreditation
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation[] findByOrganizationId_PrevAndNext(
		long accreditationId, long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = findByPrimaryKey(accreditationId);

		Session session = null;

		try {
			session = openSession();

			Accreditation[] array = new AccreditationImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, accreditation,
					organizationId, orderByComparator, true);

			array[1] = accreditation;

			array[2] = getByOrganizationId_PrevAndNext(session, accreditation,
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

	protected Accreditation getByOrganizationId_PrevAndNext(Session session,
		Accreditation accreditation, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACCREDITATION_WHERE);

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
			query.append(AccreditationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(accreditation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Accreditation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the accreditations where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (Accreditation accreditation : findByOrganizationId(
				organizationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(accreditation);
		}
	}

	/**
	 * Returns the number of accreditations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching accreditations
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

			query.append(_SQL_COUNT_ACCREDITATION_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "accreditation.organizationId = ?";

	public AccreditationPersistenceImpl() {
		setModelClass(Accreditation.class);
	}

	/**
	 * Caches the accreditation in the entity cache if it is enabled.
	 *
	 * @param accreditation the accreditation
	 */
	@Override
	public void cacheResult(Accreditation accreditation) {
		EntityCacheUtil.putResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationImpl.class, accreditation.getPrimaryKey(),
			accreditation);

		accreditation.resetOriginalValues();
	}

	/**
	 * Caches the accreditations in the entity cache if it is enabled.
	 *
	 * @param accreditations the accreditations
	 */
	@Override
	public void cacheResult(List<Accreditation> accreditations) {
		for (Accreditation accreditation : accreditations) {
			if (EntityCacheUtil.getResult(
						AccreditationModelImpl.ENTITY_CACHE_ENABLED,
						AccreditationImpl.class, accreditation.getPrimaryKey()) == null) {
				cacheResult(accreditation);
			}
			else {
				accreditation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all accreditations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AccreditationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AccreditationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the accreditation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Accreditation accreditation) {
		EntityCacheUtil.removeResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationImpl.class, accreditation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Accreditation> accreditations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Accreditation accreditation : accreditations) {
			EntityCacheUtil.removeResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
				AccreditationImpl.class, accreditation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new accreditation with the primary key. Does not add the accreditation to the database.
	 *
	 * @param accreditationId the primary key for the new accreditation
	 * @return the new accreditation
	 */
	@Override
	public Accreditation create(long accreditationId) {
		Accreditation accreditation = new AccreditationImpl();

		accreditation.setNew(true);
		accreditation.setPrimaryKey(accreditationId);

		String uuid = PortalUUIDUtil.generate();

		accreditation.setUuid(uuid);

		return accreditation;
	}

	/**
	 * Removes the accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accreditationId the primary key of the accreditation
	 * @return the accreditation that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation remove(long accreditationId)
		throws NoSuchAccreditationException, SystemException {
		return remove((Serializable)accreditationId);
	}

	/**
	 * Removes the accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the accreditation
	 * @return the accreditation that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation remove(Serializable primaryKey)
		throws NoSuchAccreditationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Accreditation accreditation = (Accreditation)session.get(AccreditationImpl.class,
					primaryKey);

			if (accreditation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccreditationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(accreditation);
		}
		catch (NoSuchAccreditationException nsee) {
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
	protected Accreditation removeImpl(Accreditation accreditation)
		throws SystemException {
		accreditation = toUnwrappedModel(accreditation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accreditation)) {
				accreditation = (Accreditation)session.get(AccreditationImpl.class,
						accreditation.getPrimaryKeyObj());
			}

			if (accreditation != null) {
				session.delete(accreditation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (accreditation != null) {
			clearCache(accreditation);
		}

		return accreditation;
	}

	@Override
	public Accreditation updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Accreditation accreditation)
		throws SystemException {
		accreditation = toUnwrappedModel(accreditation);

		boolean isNew = accreditation.isNew();

		AccreditationModelImpl accreditationModelImpl = (AccreditationModelImpl)accreditation;

		if (Validator.isNull(accreditation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			accreditation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (accreditation.isNew()) {
				session.save(accreditation);

				accreditation.setNew(false);
			}
			else {
				session.merge(accreditation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AccreditationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((accreditationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						accreditationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { accreditationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((accreditationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						accreditationModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { accreditationModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
			AccreditationImpl.class, accreditation.getPrimaryKey(),
			accreditation);

		return accreditation;
	}

	protected Accreditation toUnwrappedModel(Accreditation accreditation) {
		if (accreditation instanceof AccreditationImpl) {
			return accreditation;
		}

		AccreditationImpl accreditationImpl = new AccreditationImpl();

		accreditationImpl.setNew(accreditation.isNew());
		accreditationImpl.setPrimaryKey(accreditation.getPrimaryKey());

		accreditationImpl.setUuid(accreditation.getUuid());
		accreditationImpl.setAccreditationId(accreditation.getAccreditationId());
		accreditationImpl.setOrganizationId(accreditation.getOrganizationId());
		accreditationImpl.setAselected(accreditation.isAselected());
		accreditationImpl.setAvalue(accreditation.getAvalue());
		accreditationImpl.setBselected(accreditation.isBselected());
		accreditationImpl.setBvalue(accreditation.getBvalue());
		accreditationImpl.setCselected(accreditation.isCselected());
		accreditationImpl.setCvalue(accreditation.getCvalue());
		accreditationImpl.setCcompanyName(accreditation.getCcompanyName());
		accreditationImpl.setCsamepolicy(accreditation.isCsamepolicy());
		accreditationImpl.setCelaborate(accreditation.getCelaborate());
		accreditationImpl.setDselected(accreditation.isDselected());
		accreditationImpl.setDvalue(accreditation.getDvalue());
		accreditationImpl.setAccreditationStatus(accreditation.getAccreditationStatus());
		accreditationImpl.setDateOfAccreditation(accreditation.getDateOfAccreditation());
		accreditationImpl.setDateOfExpiry(accreditation.getDateOfExpiry());
		accreditationImpl.setLatestPaymentDate(accreditation.getLatestPaymentDate());
		accreditationImpl.setStartDateOfReaccreditation(accreditation.getStartDateOfReaccreditation());
		accreditationImpl.setDateOfReaccdtReview(accreditation.getDateOfReaccdtReview());
		accreditationImpl.setAccreditationBy(accreditation.getAccreditationBy());

		return accreditationImpl;
	}

	/**
	 * Returns the accreditation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the accreditation
	 * @return the accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAccreditationException, SystemException {
		Accreditation accreditation = fetchByPrimaryKey(primaryKey);

		if (accreditation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccreditationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return accreditation;
	}

	/**
	 * Returns the accreditation with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException} if it could not be found.
	 *
	 * @param accreditationId the primary key of the accreditation
	 * @return the accreditation
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchAccreditationException if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation findByPrimaryKey(long accreditationId)
		throws NoSuchAccreditationException, SystemException {
		return findByPrimaryKey((Serializable)accreditationId);
	}

	/**
	 * Returns the accreditation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the accreditation
	 * @return the accreditation, or <code>null</code> if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Accreditation accreditation = (Accreditation)EntityCacheUtil.getResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
				AccreditationImpl.class, primaryKey);

		if (accreditation == _nullAccreditation) {
			return null;
		}

		if (accreditation == null) {
			Session session = null;

			try {
				session = openSession();

				accreditation = (Accreditation)session.get(AccreditationImpl.class,
						primaryKey);

				if (accreditation != null) {
					cacheResult(accreditation);
				}
				else {
					EntityCacheUtil.putResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
						AccreditationImpl.class, primaryKey, _nullAccreditation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AccreditationModelImpl.ENTITY_CACHE_ENABLED,
					AccreditationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return accreditation;
	}

	/**
	 * Returns the accreditation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accreditationId the primary key of the accreditation
	 * @return the accreditation, or <code>null</code> if a accreditation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Accreditation fetchByPrimaryKey(long accreditationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)accreditationId);
	}

	/**
	 * Returns all the accreditations.
	 *
	 * @return the accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the accreditations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @return the range of accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the accreditations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.AccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of accreditations
	 * @param end the upper bound of the range of accreditations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accreditations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Accreditation> findAll(int start, int end,
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

		List<Accreditation> list = (List<Accreditation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACCREDITATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACCREDITATION;

				if (pagination) {
					sql = sql.concat(AccreditationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Accreditation>(list);
				}
				else {
					list = (List<Accreditation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the accreditations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Accreditation accreditation : findAll()) {
			remove(accreditation);
		}
	}

	/**
	 * Returns the number of accreditations.
	 *
	 * @return the number of accreditations
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

				Query q = session.createQuery(_SQL_COUNT_ACCREDITATION);

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
	 * Initializes the accreditation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Accreditation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Accreditation>> listenersList = new ArrayList<ModelListener<Accreditation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Accreditation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AccreditationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACCREDITATION = "SELECT accreditation FROM Accreditation accreditation";
	private static final String _SQL_SELECT_ACCREDITATION_WHERE = "SELECT accreditation FROM Accreditation accreditation WHERE ";
	private static final String _SQL_COUNT_ACCREDITATION = "SELECT COUNT(accreditation) FROM Accreditation accreditation";
	private static final String _SQL_COUNT_ACCREDITATION_WHERE = "SELECT COUNT(accreditation) FROM Accreditation accreditation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "accreditation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Accreditation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Accreditation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AccreditationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "ccompanyName"
			});
	private static Accreditation _nullAccreditation = new AccreditationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Accreditation> toCacheModel() {
				return _nullAccreditationCacheModel;
			}
		};

	private static CacheModel<Accreditation> _nullAccreditationCacheModel = new CacheModel<Accreditation>() {
			@Override
			public Accreditation toEntityModel() {
				return _nullAccreditation;
			}
		};
}