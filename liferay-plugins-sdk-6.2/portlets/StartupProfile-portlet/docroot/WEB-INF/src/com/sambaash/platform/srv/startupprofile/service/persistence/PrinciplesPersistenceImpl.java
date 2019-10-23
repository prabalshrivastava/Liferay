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

import com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException;
import com.sambaash.platform.srv.startupprofile.model.Principles;
import com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesImpl;
import com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the principles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see PrinciplesPersistence
 * @see PrinciplesUtil
 * @generated
 */
public class PrinciplesPersistenceImpl extends BasePersistenceImpl<Principles>
	implements PrinciplesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrinciplesUtil} to access the principles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrinciplesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PrinciplesModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the principleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the principleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @return the range of matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the principleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findByUuid(String uuid, int start, int end,
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

		List<Principles> list = (List<Principles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Principles principles : list) {
				if (!Validator.equals(uuid, principles.getUuid())) {
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

			query.append(_SQL_SELECT_PRINCIPLES_WHERE);

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
				query.append(PrinciplesModelImpl.ORDER_BY_JPQL);
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
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Principles>(list);
				}
				else {
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first principles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = fetchByUuid_First(uuid, orderByComparator);

		if (principles != null) {
			return principles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrinciplesException(msg.toString());
	}

	/**
	 * Returns the first principles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching principles, or <code>null</code> if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Principles> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last principles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = fetchByUuid_Last(uuid, orderByComparator);

		if (principles != null) {
			return principles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrinciplesException(msg.toString());
	}

	/**
	 * Returns the last principles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching principles, or <code>null</code> if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Principles> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the principleses before and after the current principles in the ordered set where uuid = &#63;.
	 *
	 * @param principleId the primary key of the current principles
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles[] findByUuid_PrevAndNext(long principleId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = findByPrimaryKey(principleId);

		Session session = null;

		try {
			session = openSession();

			Principles[] array = new PrinciplesImpl[3];

			array[0] = getByUuid_PrevAndNext(session, principles, uuid,
					orderByComparator, true);

			array[1] = principles;

			array[2] = getByUuid_PrevAndNext(session, principles, uuid,
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

	protected Principles getByUuid_PrevAndNext(Session session,
		Principles principles, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRINCIPLES_WHERE);

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
			query.append(PrinciplesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(principles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Principles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the principleses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Principles principles : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(principles);
		}
	}

	/**
	 * Returns the number of principleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching principleses
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

			query.append(_SQL_COUNT_PRINCIPLES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "principles.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "principles.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(principles.uuid IS NULL OR principles.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SITEID = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySiteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID =
		new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, PrinciplesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySiteId",
			new String[] { Long.class.getName() },
			PrinciplesModelImpl.SITEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SITEID = new FinderPath(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySiteId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the principleses where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findBySiteId(long siteId) throws SystemException {
		return findBySiteId(siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the principleses where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @return the range of matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findBySiteId(long siteId, int start, int end)
		throws SystemException {
		return findBySiteId(siteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the principleses where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findBySiteId(long siteId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID;
			finderArgs = new Object[] { siteId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SITEID;
			finderArgs = new Object[] { siteId, start, end, orderByComparator };
		}

		List<Principles> list = (List<Principles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Principles principles : list) {
				if ((siteId != principles.getSiteId())) {
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

			query.append(_SQL_SELECT_PRINCIPLES_WHERE);

			query.append(_FINDER_COLUMN_SITEID_SITEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PrinciplesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteId);

				if (!pagination) {
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Principles>(list);
				}
				else {
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first principles in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findBySiteId_First(long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = fetchBySiteId_First(siteId, orderByComparator);

		if (principles != null) {
			return principles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("siteId=");
		msg.append(siteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrinciplesException(msg.toString());
	}

	/**
	 * Returns the first principles in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching principles, or <code>null</code> if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchBySiteId_First(long siteId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Principles> list = findBySiteId(siteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last principles in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findBySiteId_Last(long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = fetchBySiteId_Last(siteId, orderByComparator);

		if (principles != null) {
			return principles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("siteId=");
		msg.append(siteId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrinciplesException(msg.toString());
	}

	/**
	 * Returns the last principles in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching principles, or <code>null</code> if a matching principles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchBySiteId_Last(long siteId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySiteId(siteId);

		if (count == 0) {
			return null;
		}

		List<Principles> list = findBySiteId(siteId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the principleses before and after the current principles in the ordered set where siteId = &#63;.
	 *
	 * @param principleId the primary key of the current principles
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles[] findBySiteId_PrevAndNext(long principleId, long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = findByPrimaryKey(principleId);

		Session session = null;

		try {
			session = openSession();

			Principles[] array = new PrinciplesImpl[3];

			array[0] = getBySiteId_PrevAndNext(session, principles, siteId,
					orderByComparator, true);

			array[1] = principles;

			array[2] = getBySiteId_PrevAndNext(session, principles, siteId,
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

	protected Principles getBySiteId_PrevAndNext(Session session,
		Principles principles, long siteId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRINCIPLES_WHERE);

		query.append(_FINDER_COLUMN_SITEID_SITEID_2);

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
			query.append(PrinciplesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(siteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(principles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Principles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the principleses where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySiteId(long siteId) throws SystemException {
		for (Principles principles : findBySiteId(siteId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(principles);
		}
	}

	/**
	 * Returns the number of principleses where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySiteId(long siteId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SITEID;

		Object[] finderArgs = new Object[] { siteId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRINCIPLES_WHERE);

			query.append(_FINDER_COLUMN_SITEID_SITEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteId);

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

	private static final String _FINDER_COLUMN_SITEID_SITEID_2 = "principles.siteId = ?";

	public PrinciplesPersistenceImpl() {
		setModelClass(Principles.class);
	}

	/**
	 * Caches the principles in the entity cache if it is enabled.
	 *
	 * @param principles the principles
	 */
	@Override
	public void cacheResult(Principles principles) {
		EntityCacheUtil.putResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesImpl.class, principles.getPrimaryKey(), principles);

		principles.resetOriginalValues();
	}

	/**
	 * Caches the principleses in the entity cache if it is enabled.
	 *
	 * @param principleses the principleses
	 */
	@Override
	public void cacheResult(List<Principles> principleses) {
		for (Principles principles : principleses) {
			if (EntityCacheUtil.getResult(
						PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
						PrinciplesImpl.class, principles.getPrimaryKey()) == null) {
				cacheResult(principles);
			}
			else {
				principles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all principleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PrinciplesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PrinciplesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the principles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Principles principles) {
		EntityCacheUtil.removeResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesImpl.class, principles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Principles> principleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Principles principles : principleses) {
			EntityCacheUtil.removeResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
				PrinciplesImpl.class, principles.getPrimaryKey());
		}
	}

	/**
	 * Creates a new principles with the primary key. Does not add the principles to the database.
	 *
	 * @param principleId the primary key for the new principles
	 * @return the new principles
	 */
	@Override
	public Principles create(long principleId) {
		Principles principles = new PrinciplesImpl();

		principles.setNew(true);
		principles.setPrimaryKey(principleId);

		String uuid = PortalUUIDUtil.generate();

		principles.setUuid(uuid);

		return principles;
	}

	/**
	 * Removes the principles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param principleId the primary key of the principles
	 * @return the principles that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles remove(long principleId)
		throws NoSuchPrinciplesException, SystemException {
		return remove((Serializable)principleId);
	}

	/**
	 * Removes the principles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the principles
	 * @return the principles that was removed
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles remove(Serializable primaryKey)
		throws NoSuchPrinciplesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Principles principles = (Principles)session.get(PrinciplesImpl.class,
					primaryKey);

			if (principles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrinciplesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(principles);
		}
		catch (NoSuchPrinciplesException nsee) {
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
	protected Principles removeImpl(Principles principles)
		throws SystemException {
		principles = toUnwrappedModel(principles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(principles)) {
				principles = (Principles)session.get(PrinciplesImpl.class,
						principles.getPrimaryKeyObj());
			}

			if (principles != null) {
				session.delete(principles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (principles != null) {
			clearCache(principles);
		}

		return principles;
	}

	@Override
	public Principles updateImpl(
		com.sambaash.platform.srv.startupprofile.model.Principles principles)
		throws SystemException {
		principles = toUnwrappedModel(principles);

		boolean isNew = principles.isNew();

		PrinciplesModelImpl principlesModelImpl = (PrinciplesModelImpl)principles;

		if (Validator.isNull(principles.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			principles.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (principles.isNew()) {
				session.save(principles);

				principles.setNew(false);
			}
			else {
				session.merge(principles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PrinciplesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((principlesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						principlesModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { principlesModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((principlesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						principlesModelImpl.getOriginalSiteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID,
					args);

				args = new Object[] { principlesModelImpl.getSiteId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
			PrinciplesImpl.class, principles.getPrimaryKey(), principles);

		return principles;
	}

	protected Principles toUnwrappedModel(Principles principles) {
		if (principles instanceof PrinciplesImpl) {
			return principles;
		}

		PrinciplesImpl principlesImpl = new PrinciplesImpl();

		principlesImpl.setNew(principles.isNew());
		principlesImpl.setPrimaryKey(principles.getPrimaryKey());

		principlesImpl.setUuid(principles.getUuid());
		principlesImpl.setSiteId(principles.getSiteId());
		principlesImpl.setPrincipleId(principles.getPrincipleId());
		principlesImpl.setPrincipleText(principles.getPrincipleText());
		principlesImpl.setGuideline1(principles.getGuideline1());
		principlesImpl.setGuideline2(principles.getGuideline2());
		principlesImpl.setGuideline3(principles.getGuideline3());
		principlesImpl.setGuideline4(principles.getGuideline4());
		principlesImpl.setGuideline5(principles.getGuideline5());
		principlesImpl.setGuideline6(principles.getGuideline6());
		principlesImpl.setGuideline7(principles.getGuideline7());
		principlesImpl.setGuideline8(principles.getGuideline8());

		return principlesImpl;
	}

	/**
	 * Returns the principles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the principles
	 * @return the principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrinciplesException, SystemException {
		Principles principles = fetchByPrimaryKey(primaryKey);

		if (principles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrinciplesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return principles;
	}

	/**
	 * Returns the principles with the primary key or throws a {@link com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException} if it could not be found.
	 *
	 * @param principleId the primary key of the principles
	 * @return the principles
	 * @throws com.sambaash.platform.srv.startupprofile.NoSuchPrinciplesException if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles findByPrimaryKey(long principleId)
		throws NoSuchPrinciplesException, SystemException {
		return findByPrimaryKey((Serializable)principleId);
	}

	/**
	 * Returns the principles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the principles
	 * @return the principles, or <code>null</code> if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Principles principles = (Principles)EntityCacheUtil.getResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
				PrinciplesImpl.class, primaryKey);

		if (principles == _nullPrinciples) {
			return null;
		}

		if (principles == null) {
			Session session = null;

			try {
				session = openSession();

				principles = (Principles)session.get(PrinciplesImpl.class,
						primaryKey);

				if (principles != null) {
					cacheResult(principles);
				}
				else {
					EntityCacheUtil.putResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
						PrinciplesImpl.class, primaryKey, _nullPrinciples);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PrinciplesModelImpl.ENTITY_CACHE_ENABLED,
					PrinciplesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return principles;
	}

	/**
	 * Returns the principles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param principleId the primary key of the principles
	 * @return the principles, or <code>null</code> if a principles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Principles fetchByPrimaryKey(long principleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)principleId);
	}

	/**
	 * Returns all the principleses.
	 *
	 * @return the principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the principleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @return the range of principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the principleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.PrinciplesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of principleses
	 * @param end the upper bound of the range of principleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of principleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Principles> findAll(int start, int end,
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

		List<Principles> list = (List<Principles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRINCIPLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRINCIPLES;

				if (pagination) {
					sql = sql.concat(PrinciplesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Principles>(list);
				}
				else {
					list = (List<Principles>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the principleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Principles principles : findAll()) {
			remove(principles);
		}
	}

	/**
	 * Returns the number of principleses.
	 *
	 * @return the number of principleses
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

				Query q = session.createQuery(_SQL_COUNT_PRINCIPLES);

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
	 * Initializes the principles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.startupprofile.model.Principles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Principles>> listenersList = new ArrayList<ModelListener<Principles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Principles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PrinciplesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PRINCIPLES = "SELECT principles FROM Principles principles";
	private static final String _SQL_SELECT_PRINCIPLES_WHERE = "SELECT principles FROM Principles principles WHERE ";
	private static final String _SQL_COUNT_PRINCIPLES = "SELECT COUNT(principles) FROM Principles principles";
	private static final String _SQL_COUNT_PRINCIPLES_WHERE = "SELECT COUNT(principles) FROM Principles principles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "principles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Principles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Principles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PrinciplesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Principles _nullPrinciples = new PrinciplesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Principles> toCacheModel() {
				return _nullPrinciplesCacheModel;
			}
		};

	private static CacheModel<Principles> _nullPrinciplesCacheModel = new CacheModel<Principles>() {
			@Override
			public Principles toEntityModel() {
				return _nullPrinciples;
			}
		};
}