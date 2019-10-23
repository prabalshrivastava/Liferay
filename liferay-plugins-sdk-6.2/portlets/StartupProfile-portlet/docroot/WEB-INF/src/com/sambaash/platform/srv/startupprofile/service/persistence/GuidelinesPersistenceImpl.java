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

import com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException;
import com.sambaash.platform.srv.startupprofile.model.Guidelines;
import com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the guidelines service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see GuidelinesPersistence
 * @see GuidelinesUtil
 * @generated
 */
public class GuidelinesPersistenceImpl extends BasePersistenceImpl<Guidelines>
	implements GuidelinesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GuidelinesUtil} to access the guidelines persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GuidelinesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GuidelinesModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the guidelineses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guidelineses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @return the range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guidelineses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByUuid(String uuid, int start, int end,
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

		List<Guidelines> list = (List<Guidelines>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Guidelines guidelines : list) {
				if (!Validator.equals(uuid, guidelines.getUuid())) {
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

			query.append(_SQL_SELECT_GUIDELINES_WHERE);

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
				query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
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
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Guidelines>(list);
				}
				else {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first guidelines in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByUuid_First(uuid, orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the first guidelines in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Guidelines> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guidelines in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByUuid_Last(uuid, orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the last guidelines in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Guidelines> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guidelineses before and after the current guidelines in the ordered set where uuid = &#63;.
	 *
	 * @param guidelineId the primary key of the current guidelines
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines[] findByUuid_PrevAndNext(long guidelineId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = findByPrimaryKey(guidelineId);

		Session session = null;

		try {
			session = openSession();

			Guidelines[] array = new GuidelinesImpl[3];

			array[0] = getByUuid_PrevAndNext(session, guidelines, uuid,
					orderByComparator, true);

			array[1] = guidelines;

			array[2] = getByUuid_PrevAndNext(session, guidelines, uuid,
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

	protected Guidelines getByUuid_PrevAndNext(Session session,
		Guidelines guidelines, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GUIDELINES_WHERE);

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
			query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(guidelines);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Guidelines> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guidelineses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Guidelines guidelines : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(guidelines);
		}
	}

	/**
	 * Returns the number of guidelineses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching guidelineses
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

			query.append(_SQL_COUNT_GUIDELINES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "guidelines.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "guidelines.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(guidelines.uuid IS NULL OR guidelines.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganizationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID =
		new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganizationId",
			new String[] { Long.class.getName() },
			GuidelinesModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONID = new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganizationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the guidelineses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationId(long organizationId)
		throws SystemException {
		return findByOrganizationId(organizationId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guidelineses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @return the range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationId(long organizationId,
		int start, int end) throws SystemException {
		return findByOrganizationId(organizationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the guidelineses where organizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationId(long organizationId,
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

		List<Guidelines> list = (List<Guidelines>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Guidelines guidelines : list) {
				if ((organizationId != guidelines.getOrganizationId())) {
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

			query.append(_SQL_SELECT_GUIDELINES_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				if (!pagination) {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Guidelines>(list);
				}
				else {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first guidelines in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByOrganizationId_First(organizationId,
				orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the first guidelines in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByOrganizationId_First(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Guidelines> list = findByOrganizationId(organizationId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guidelines in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByOrganizationId_Last(organizationId,
				orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the last guidelines in the ordered set where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByOrganizationId_Last(long organizationId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationId(organizationId);

		if (count == 0) {
			return null;
		}

		List<Guidelines> list = findByOrganizationId(organizationId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guidelineses before and after the current guidelines in the ordered set where organizationId = &#63;.
	 *
	 * @param guidelineId the primary key of the current guidelines
	 * @param organizationId the organization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines[] findByOrganizationId_PrevAndNext(long guidelineId,
		long organizationId, OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = findByPrimaryKey(guidelineId);

		Session session = null;

		try {
			session = openSession();

			Guidelines[] array = new GuidelinesImpl[3];

			array[0] = getByOrganizationId_PrevAndNext(session, guidelines,
					organizationId, orderByComparator, true);

			array[1] = guidelines;

			array[2] = getByOrganizationId_PrevAndNext(session, guidelines,
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

	protected Guidelines getByOrganizationId_PrevAndNext(Session session,
		Guidelines guidelines, long organizationId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GUIDELINES_WHERE);

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
			query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(guidelines);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Guidelines> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guidelineses where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationId(long organizationId)
		throws SystemException {
		for (Guidelines guidelines : findByOrganizationId(organizationId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(guidelines);
		}
	}

	/**
	 * Returns the number of guidelineses where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching guidelineses
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

			query.append(_SQL_COUNT_GUIDELINES_WHERE);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONID_ORGANIZATIONID_2 = "guidelines.organizationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID =
		new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOrganizationAndPrincipleIdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID =
		new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, GuidelinesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOrganizationAndPrincipleIdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			GuidelinesModelImpl.ORGANIZATIONID_COLUMN_BITMASK |
			GuidelinesModelImpl.PRINCIPLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONANDPRINCIPLEIDID =
		new FinderPath(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationAndPrincipleIdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the guidelineses where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @return the matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId) throws SystemException {
		return findByOrganizationAndPrincipleIdId(organizationId, principleId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guidelineses where organizationId = &#63; and principleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @return the range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId, int start, int end)
		throws SystemException {
		return findByOrganizationAndPrincipleIdId(organizationId, principleId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the guidelineses where organizationId = &#63; and principleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findByOrganizationAndPrincipleIdId(
		long organizationId, long principleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID;
			finderArgs = new Object[] { organizationId, principleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID;
			finderArgs = new Object[] {
					organizationId, principleId,
					
					start, end, orderByComparator
				};
		}

		List<Guidelines> list = (List<Guidelines>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Guidelines guidelines : list) {
				if ((organizationId != guidelines.getOrganizationId()) ||
						(principleId != guidelines.getPrincipleId())) {
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

			query.append(_SQL_SELECT_GUIDELINES_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_PRINCIPLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(principleId);

				if (!pagination) {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Guidelines>(list);
				}
				else {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByOrganizationAndPrincipleIdId_First(
		long organizationId, long principleId,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByOrganizationAndPrincipleIdId_First(organizationId,
				principleId, orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", principleId=");
		msg.append(principleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the first guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByOrganizationAndPrincipleIdId_First(
		long organizationId, long principleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Guidelines> list = findByOrganizationAndPrincipleIdId(organizationId,
				principleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByOrganizationAndPrincipleIdId_Last(
		long organizationId, long principleId,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByOrganizationAndPrincipleIdId_Last(organizationId,
				principleId, orderByComparator);

		if (guidelines != null) {
			return guidelines;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationId=");
		msg.append(organizationId);

		msg.append(", principleId=");
		msg.append(principleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGuidelinesException(msg.toString());
	}

	/**
	 * Returns the last guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching guidelines, or <code>null</code> if a matching guidelines could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByOrganizationAndPrincipleIdId_Last(
		long organizationId, long principleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOrganizationAndPrincipleIdId(organizationId,
				principleId);

		if (count == 0) {
			return null;
		}

		List<Guidelines> list = findByOrganizationAndPrincipleIdId(organizationId,
				principleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the guidelineses before and after the current guidelines in the ordered set where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param guidelineId the primary key of the current guidelines
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines[] findByOrganizationAndPrincipleIdId_PrevAndNext(
		long guidelineId, long organizationId, long principleId,
		OrderByComparator orderByComparator)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = findByPrimaryKey(guidelineId);

		Session session = null;

		try {
			session = openSession();

			Guidelines[] array = new GuidelinesImpl[3];

			array[0] = getByOrganizationAndPrincipleIdId_PrevAndNext(session,
					guidelines, organizationId, principleId, orderByComparator,
					true);

			array[1] = guidelines;

			array[2] = getByOrganizationAndPrincipleIdId_PrevAndNext(session,
					guidelines, organizationId, principleId, orderByComparator,
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

	protected Guidelines getByOrganizationAndPrincipleIdId_PrevAndNext(
		Session session, Guidelines guidelines, long organizationId,
		long principleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GUIDELINES_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_ORGANIZATIONID_2);

		query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_PRINCIPLEID_2);

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
			query.append(GuidelinesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationId);

		qPos.add(principleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(guidelines);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Guidelines> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the guidelineses where organizationId = &#63; and principleId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOrganizationAndPrincipleIdId(long organizationId,
		long principleId) throws SystemException {
		for (Guidelines guidelines : findByOrganizationAndPrincipleIdId(
				organizationId, principleId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(guidelines);
		}
	}

	/**
	 * Returns the number of guidelineses where organizationId = &#63; and principleId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @param principleId the principle ID
	 * @return the number of matching guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationAndPrincipleIdId(long organizationId,
		long principleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONANDPRINCIPLEIDID;

		Object[] finderArgs = new Object[] { organizationId, principleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GUIDELINES_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_ORGANIZATIONID_2);

			query.append(_FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_PRINCIPLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				qPos.add(principleId);

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

	private static final String _FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_ORGANIZATIONID_2 =
		"guidelines.organizationId = ? AND ";
	private static final String _FINDER_COLUMN_ORGANIZATIONANDPRINCIPLEIDID_PRINCIPLEID_2 =
		"guidelines.principleId = ?";

	public GuidelinesPersistenceImpl() {
		setModelClass(Guidelines.class);
	}

	/**
	 * Caches the guidelines in the entity cache if it is enabled.
	 *
	 * @param guidelines the guidelines
	 */
	@Override
	public void cacheResult(Guidelines guidelines) {
		EntityCacheUtil.putResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesImpl.class, guidelines.getPrimaryKey(), guidelines);

		guidelines.resetOriginalValues();
	}

	/**
	 * Caches the guidelineses in the entity cache if it is enabled.
	 *
	 * @param guidelineses the guidelineses
	 */
	@Override
	public void cacheResult(List<Guidelines> guidelineses) {
		for (Guidelines guidelines : guidelineses) {
			if (EntityCacheUtil.getResult(
						GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
						GuidelinesImpl.class, guidelines.getPrimaryKey()) == null) {
				cacheResult(guidelines);
			}
			else {
				guidelines.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all guidelineses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GuidelinesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GuidelinesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the guidelines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Guidelines guidelines) {
		EntityCacheUtil.removeResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesImpl.class, guidelines.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Guidelines> guidelineses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Guidelines guidelines : guidelineses) {
			EntityCacheUtil.removeResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
				GuidelinesImpl.class, guidelines.getPrimaryKey());
		}
	}

	/**
	 * Creates a new guidelines with the primary key. Does not add the guidelines to the database.
	 *
	 * @param guidelineId the primary key for the new guidelines
	 * @return the new guidelines
	 */
	@Override
	public Guidelines create(long guidelineId) {
		Guidelines guidelines = new GuidelinesImpl();

		guidelines.setNew(true);
		guidelines.setPrimaryKey(guidelineId);

		String uuid = PortalUUIDUtil.generate();

		guidelines.setUuid(uuid);

		return guidelines;
	}

	/**
	 * Removes the guidelines with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param guidelineId the primary key of the guidelines
	 * @return the guidelines that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines remove(long guidelineId)
		throws NoSuchGuidelinesException, SystemException {
		return remove((Serializable)guidelineId);
	}

	/**
	 * Removes the guidelines with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the guidelines
	 * @return the guidelines that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines remove(Serializable primaryKey)
		throws NoSuchGuidelinesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Guidelines guidelines = (Guidelines)session.get(GuidelinesImpl.class,
					primaryKey);

			if (guidelines == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGuidelinesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(guidelines);
		}
		catch (NoSuchGuidelinesException nsee) {
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
	protected Guidelines removeImpl(Guidelines guidelines)
		throws SystemException {
		guidelines = toUnwrappedModel(guidelines);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(guidelines)) {
				guidelines = (Guidelines)session.get(GuidelinesImpl.class,
						guidelines.getPrimaryKeyObj());
			}

			if (guidelines != null) {
				session.delete(guidelines);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (guidelines != null) {
			clearCache(guidelines);
		}

		return guidelines;
	}

	@Override
	public Guidelines updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Guidelines guidelines)
		throws SystemException {
		guidelines = toUnwrappedModel(guidelines);

		boolean isNew = guidelines.isNew();

		GuidelinesModelImpl guidelinesModelImpl = (GuidelinesModelImpl)guidelines;

		if (Validator.isNull(guidelines.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			guidelines.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (guidelines.isNew()) {
				session.save(guidelines);

				guidelines.setNew(false);
			}
			else {
				session.merge(guidelines);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GuidelinesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((guidelinesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						guidelinesModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { guidelinesModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((guidelinesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						guidelinesModelImpl.getOriginalOrganizationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);

				args = new Object[] { guidelinesModelImpl.getOrganizationId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONID,
					args);
			}

			if ((guidelinesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						guidelinesModelImpl.getOriginalOrganizationId(),
						guidelinesModelImpl.getOriginalPrincipleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDPRINCIPLEIDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID,
					args);

				args = new Object[] {
						guidelinesModelImpl.getOrganizationId(),
						guidelinesModelImpl.getPrincipleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONANDPRINCIPLEIDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORGANIZATIONANDPRINCIPLEIDID,
					args);
			}
		}

		EntityCacheUtil.putResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
			GuidelinesImpl.class, guidelines.getPrimaryKey(), guidelines);

		return guidelines;
	}

	protected Guidelines toUnwrappedModel(Guidelines guidelines) {
		if (guidelines instanceof GuidelinesImpl) {
			return guidelines;
		}

		GuidelinesImpl guidelinesImpl = new GuidelinesImpl();

		guidelinesImpl.setNew(guidelines.isNew());
		guidelinesImpl.setPrimaryKey(guidelines.getPrimaryKey());

		guidelinesImpl.setUuid(guidelines.getUuid());
		guidelinesImpl.setGuidelineId(guidelines.getGuidelineId());
		guidelinesImpl.setOrganizationId(guidelines.getOrganizationId());
		guidelinesImpl.setPrincipleId(guidelines.getPrincipleId());
		guidelinesImpl.setGuideline1(guidelines.isGuideline1());
		guidelinesImpl.setGuideline2(guidelines.isGuideline2());
		guidelinesImpl.setGuideline3(guidelines.isGuideline3());
		guidelinesImpl.setGuideline4(guidelines.isGuideline4());
		guidelinesImpl.setGuideline5(guidelines.isGuideline5());
		guidelinesImpl.setGuideline6(guidelines.isGuideline6());
		guidelinesImpl.setGuideline7(guidelines.isGuideline7());
		guidelinesImpl.setGuideline8(guidelines.isGuideline8());
		guidelinesImpl.setMoreInfo(guidelines.getMoreInfo());

		return guidelinesImpl;
	}

	/**
	 * Returns the guidelines with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the guidelines
	 * @return the guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGuidelinesException, SystemException {
		Guidelines guidelines = fetchByPrimaryKey(primaryKey);

		if (guidelines == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGuidelinesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return guidelines;
	}

	/**
	 * Returns the guidelines with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException} if it could not be found.
	 *
	 * @param guidelineId the primary key of the guidelines
	 * @return the guidelines
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchGuidelinesException if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines findByPrimaryKey(long guidelineId)
		throws NoSuchGuidelinesException, SystemException {
		return findByPrimaryKey((Serializable)guidelineId);
	}

	/**
	 * Returns the guidelines with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the guidelines
	 * @return the guidelines, or <code>null</code> if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Guidelines guidelines = (Guidelines)EntityCacheUtil.getResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
				GuidelinesImpl.class, primaryKey);

		if (guidelines == _nullGuidelines) {
			return null;
		}

		if (guidelines == null) {
			Session session = null;

			try {
				session = openSession();

				guidelines = (Guidelines)session.get(GuidelinesImpl.class,
						primaryKey);

				if (guidelines != null) {
					cacheResult(guidelines);
				}
				else {
					EntityCacheUtil.putResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
						GuidelinesImpl.class, primaryKey, _nullGuidelines);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GuidelinesModelImpl.ENTITY_CACHE_ENABLED,
					GuidelinesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return guidelines;
	}

	/**
	 * Returns the guidelines with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param guidelineId the primary key of the guidelines
	 * @return the guidelines, or <code>null</code> if a guidelines with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Guidelines fetchByPrimaryKey(long guidelineId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)guidelineId);
	}

	/**
	 * Returns all the guidelineses.
	 *
	 * @return the guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the guidelineses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @return the range of guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the guidelineses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.GuidelinesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of guidelineses
	 * @param end the upper bound of the range of guidelineses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of guidelineses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Guidelines> findAll(int start, int end,
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

		List<Guidelines> list = (List<Guidelines>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GUIDELINES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GUIDELINES;

				if (pagination) {
					sql = sql.concat(GuidelinesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Guidelines>(list);
				}
				else {
					list = (List<Guidelines>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the guidelineses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Guidelines guidelines : findAll()) {
			remove(guidelines);
		}
	}

	/**
	 * Returns the number of guidelineses.
	 *
	 * @return the number of guidelineses
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

				Query q = session.createQuery(_SQL_COUNT_GUIDELINES);

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
	 * Initializes the guidelines persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Guidelines")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Guidelines>> listenersList = new ArrayList<ModelListener<Guidelines>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Guidelines>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GuidelinesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GUIDELINES = "SELECT guidelines FROM Guidelines guidelines";
	private static final String _SQL_SELECT_GUIDELINES_WHERE = "SELECT guidelines FROM Guidelines guidelines WHERE ";
	private static final String _SQL_COUNT_GUIDELINES = "SELECT COUNT(guidelines) FROM Guidelines guidelines";
	private static final String _SQL_COUNT_GUIDELINES_WHERE = "SELECT COUNT(guidelines) FROM Guidelines guidelines WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "guidelines.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Guidelines exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Guidelines exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GuidelinesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Guidelines _nullGuidelines = new GuidelinesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Guidelines> toCacheModel() {
				return _nullGuidelinesCacheModel;
			}
		};

	private static CacheModel<Guidelines> _nullGuidelinesCacheModel = new CacheModel<Guidelines>() {
			@Override
			public Guidelines toEntityModel() {
				return _nullGuidelines;
			}
		};
}