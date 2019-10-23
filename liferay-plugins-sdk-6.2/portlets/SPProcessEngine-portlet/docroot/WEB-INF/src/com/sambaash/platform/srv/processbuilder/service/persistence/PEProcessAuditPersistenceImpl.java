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

package com.sambaash.platform.srv.processbuilder.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e process audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessAuditPersistence
 * @see PEProcessAuditUtil
 * @generated
 */
public class PEProcessAuditPersistenceImpl extends BasePersistenceImpl<PEProcessAudit>
	implements PEProcessAuditPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEProcessAuditUtil} to access the p e process audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEProcessAuditImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PEProcessAuditModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e process audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid(String uuid, int start, int end,
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

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(uuid, peProcessAudit.getUuid())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

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
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByUuid_First(uuid,
				orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByUuid_Last(uuid, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByUuid_PrevAndNext(long spPEProcessAuditId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peProcessAudit, uuid,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByUuid_PrevAndNext(session, peProcessAudit, uuid,
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

	protected PEProcessAudit getByUuid_PrevAndNext(Session session,
		PEProcessAudit peProcessAudit, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e process audits
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

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peProcessAudit.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peProcessAudit.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peProcessAudit.uuid IS NULL OR peProcessAudit.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessAuditModelImpl.UUID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e process audit where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByUUID_G(uuid, groupId);

		if (peProcessAudit == null) {
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

			throw new NoSuchPEProcessAuditException(msg.toString());
		}

		return peProcessAudit;
	}

	/**
	 * Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e process audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEProcessAudit) {
			PEProcessAudit peProcessAudit = (PEProcessAudit)result;

			if (!Validator.equals(uuid, peProcessAudit.getUuid()) ||
					(groupId != peProcessAudit.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

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

				List<PEProcessAudit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEProcessAudit peProcessAudit = list.get(0);

					result = peProcessAudit;

					cacheResult(peProcessAudit);

					if ((peProcessAudit.getUuid() == null) ||
							!peProcessAudit.getUuid().equals(uuid) ||
							(peProcessAudit.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peProcessAudit);
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
			return (PEProcessAudit)result;
		}
	}

	/**
	 * Removes the p e process audit where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e process audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByUUID_G(uuid, groupId);

		return remove(peProcessAudit);
	}

	/**
	 * Returns the number of p e process audits where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e process audits
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

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peProcessAudit.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peProcessAudit.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peProcessAudit.uuid IS NULL OR peProcessAudit.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peProcessAudit.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessAuditModelImpl.UUID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByUuid_C(String uuid, long companyId,
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

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(uuid, peProcessAudit.getUuid()) ||
						(companyId != peProcessAudit.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

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
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByUuid_C_PrevAndNext(long spPEProcessAuditId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peProcessAudit, uuid,
					companyId, orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByUuid_C_PrevAndNext(session, peProcessAudit, uuid,
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

	protected PEProcessAudit getByUuid_C_PrevAndNext(Session session,
		PEProcessAudit peProcessAudit, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEProcessAudit peProcessAudit : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e process audits
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

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peProcessAudit.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peProcessAudit.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peProcessAudit.uuid IS NULL OR peProcessAudit.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peProcessAudit.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessStateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPEProcessStateId", new String[] { Long.class.getName() },
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateId", new String[] { Long.class.getName() });

	/**
	 * Returns all the p e process audits where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateId(long spPEProcessStateId)
		throws SystemException {
		return findByPEProcessStateId(spPEProcessStateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end) throws SystemException {
		return findByPEProcessStateId(spPEProcessStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateId(
		long spPEProcessStateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEID;
			finderArgs = new Object[] { spPEProcessStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEID;
			finderArgs = new Object[] {
					spPEProcessStateId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateId_First(spPEProcessStateId,
				orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateId_First(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessAudit> list = findByPEProcessStateId(spPEProcessStateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateId_Last(long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateId_Last(spPEProcessStateId,
				orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateId_Last(
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPEProcessStateId(spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByPEProcessStateId(spPEProcessStateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByPEProcessStateId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByPEProcessStateId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PEProcessAudit getByPEProcessStateId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit,
		long spPEProcessStateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where spPEProcessStateId = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessStateId(long spPEProcessStateId)
		throws SystemException {
		for (PEProcessAudit peProcessAudit : findByPEProcessStateId(
				spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateId(long spPEProcessStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEID;

		Object[] finderArgs = new Object[] { spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessStateIdFormId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPEProcessStateIdFormId",
			new String[] { Long.class.getName(), String.class.getName() },
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.FIELD2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDFORMID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateIdFormId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, String field2) throws SystemException {
		return findByPEProcessStateIdFormId(spPEProcessStateId, field2,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, String field2, int start, int end)
		throws SystemException {
		return findByPEProcessStateIdFormId(spPEProcessStateId, field2, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdFormId(
		long spPEProcessStateId, String field2, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID;
			finderArgs = new Object[] { spPEProcessStateId, field2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID;
			finderArgs = new Object[] {
					spPEProcessStateId, field2,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId()) ||
						!Validator.equals(field2, peProcessAudit.getField2())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_SPPEPROCESSSTATEID_2);

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindField2) {
					qPos.add(field2);
				}

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdFormId_First(
		long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdFormId_First(spPEProcessStateId,
				field2, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdFormId_First(
		long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByPEProcessStateIdFormId(spPEProcessStateId,
				field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdFormId_Last(spPEProcessStateId,
				field2, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdFormId_Last(
		long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPEProcessStateIdFormId(spPEProcessStateId, field2);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByPEProcessStateIdFormId(spPEProcessStateId,
				field2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByPEProcessStateIdFormId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByPEProcessStateIdFormId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, field2,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByPEProcessStateIdFormId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, field2,
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

	protected PEProcessAudit getByPEProcessStateIdFormId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit,
		long spPEProcessStateId, String field2,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_SPPEPROCESSSTATEID_2);

		boolean bindField2 = false;

		if (field2 == null) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_1);
		}
		else if (field2.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_3);
		}
		else {
			bindField2 = true;

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_2);
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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		if (bindField2) {
			qPos.add(field2);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where spPEProcessStateId = &#63; and field2 = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessStateIdFormId(long spPEProcessStateId,
		String field2) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByPEProcessStateIdFormId(
				spPEProcessStateId, field2, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param field2 the field2
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdFormId(long spPEProcessStateId,
		String field2) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDFORMID;

		Object[] finderArgs = new Object[] { spPEProcessStateId, field2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_SPPEPROCESSSTATEID_2);

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindField2) {
					qPos.add(field2);
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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDFORMID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_1 = "peProcessAudit.field2 IS NULL";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_2 = "peProcessAudit.field2 = ?";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDFORMID_FIELD2_3 = "(peProcessAudit.field2 IS NULL OR peProcessAudit.field2 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypePEProcessStateId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypePEProcessStateId",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessAuditModelImpl.TYPE_COLUMN_BITMASK |
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEPEPROCESSSTATEID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypePEProcessStateId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypePEProcessStateId(String type,
		long spPEProcessStateId) throws SystemException {
		return findByTypePEProcessStateId(type, spPEProcessStateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypePEProcessStateId(String type,
		long spPEProcessStateId, int start, int end) throws SystemException {
		return findByTypePEProcessStateId(type, spPEProcessStateId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypePEProcessStateId(String type,
		long spPEProcessStateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID;
			finderArgs = new Object[] { type, spPEProcessStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID;
			finderArgs = new Object[] {
					type, spPEProcessStateId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(type, peProcessAudit.getType()) ||
						(spPEProcessStateId != peProcessAudit.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByTypePEProcessStateId_First(String type,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByTypePEProcessStateId_First(type,
				spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByTypePEProcessStateId_First(String type,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessAudit> list = findByTypePEProcessStateId(type,
				spPEProcessStateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByTypePEProcessStateId_Last(String type,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByTypePEProcessStateId_Last(type,
				spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByTypePEProcessStateId_Last(String type,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTypePEProcessStateId(type, spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByTypePEProcessStateId(type,
				spPEProcessStateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByTypePEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, String type, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByTypePEProcessStateId_PrevAndNext(session,
					peProcessAudit, type, spPEProcessStateId,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByTypePEProcessStateId_PrevAndNext(session,
					peProcessAudit, type, spPEProcessStateId,
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

	protected PEProcessAudit getByTypePEProcessStateId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit, String type,
		long spPEProcessStateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_2);
		}

		query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where type = &#63; and spPEProcessStateId = &#63; from the database.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypePEProcessStateId(String type,
		long spPEProcessStateId) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByTypePEProcessStateId(type,
				spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where type = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypePEProcessStateId(String type, long spPEProcessStateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEPEPROCESSSTATEID;

		Object[] finderArgs = new Object[] { type, spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_2);
			}

			query.append(_FINDER_COLUMN_TYPEPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_1 = "peProcessAudit.type IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_2 = "peProcessAudit.type = ? AND ";
	private static final String _FINDER_COLUMN_TYPEPEPROCESSSTATEID_TYPE_3 = "(peProcessAudit.type IS NULL OR peProcessAudit.type = '') AND ";
	private static final String _FINDER_COLUMN_TYPEPEPROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPECREATEDATELT =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessStateIdTypeCreateDateLT",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_PEPROCESSSTATEIDTYPECREATEDATELT =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByPEProcessStateIdTypeCreateDateLT",
			new String[] {
				String.class.getName(), Date.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		String type, Date createDate, long spPEProcessStateId)
		throws SystemException {
		return findByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		String type, Date createDate, long spPEProcessStateId, int start,
		int end) throws SystemException {
		return findByPEProcessStateIdTypeCreateDateLT(type, createDate,
			spPEProcessStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdTypeCreateDateLT(
		String type, Date createDate, long spPEProcessStateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPECREATEDATELT;
		finderArgs = new Object[] {
				type, createDate, spPEProcessStateId,
				
				start, end, orderByComparator
			};

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(type, peProcessAudit.getType()) ||
						(createDate.getTime() <= peProcessAudit.getCreateDate()
																   .getTime()) ||
						(spPEProcessStateId != peProcessAudit.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_First(
		String type, Date createDate, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdTypeCreateDateLT_First(type,
				createDate, spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_First(
		String type, Date createDate, long spPEProcessStateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByPEProcessStateIdTypeCreateDateLT(type,
				createDate, spPEProcessStateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdTypeCreateDateLT_Last(
		String type, Date createDate, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdTypeCreateDateLT_Last(type,
				createDate, spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", createDate=");
		msg.append(createDate);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdTypeCreateDateLT_Last(
		String type, Date createDate, long spPEProcessStateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPEProcessStateIdTypeCreateDateLT(type, createDate,
				spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByPEProcessStateIdTypeCreateDateLT(type,
				createDate, spPEProcessStateId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByPEProcessStateIdTypeCreateDateLT_PrevAndNext(
		long spPEProcessAuditId, String type, Date createDate,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByPEProcessStateIdTypeCreateDateLT_PrevAndNext(session,
					peProcessAudit, type, createDate, spPEProcessStateId,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByPEProcessStateIdTypeCreateDateLT_PrevAndNext(session,
					peProcessAudit, type, createDate, spPEProcessStateId,
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

	protected PEProcessAudit getByPEProcessStateIdTypeCreateDateLT_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit, String type,
		Date createDate, long spPEProcessStateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_2);
		}

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_2);
		}

		query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_SPPEPROCESSSTATEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (bindCreateDate) {
			qPos.add(CalendarUtil.getTimestamp(createDate));
		}

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63; from the database.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessStateIdTypeCreateDateLT(String type,
		Date createDate, long spPEProcessStateId) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByPEProcessStateIdTypeCreateDateLT(
				type, createDate, spPEProcessStateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where type = &#63; and createDate &lt; &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param createDate the create date
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdTypeCreateDateLT(String type,
		Date createDate, long spPEProcessStateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_PEPROCESSSTATEIDTYPECREATEDATELT;

		Object[] finderArgs = new Object[] { type, createDate, spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_2);
			}

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_2);
			}

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (bindCreateDate) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_1 =
		"peProcessAudit.type IS NULL AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_2 =
		"peProcessAudit.type = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_TYPE_3 =
		"(peProcessAudit.type IS NULL OR peProcessAudit.type = '') AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_1 =
		"peProcessAudit.createDate < NULL AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_CREATEDATE_2 =
		"peProcessAudit.createDate < ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPECREATEDATELT_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDoneByPEProcessStateId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDoneByPEProcessStateId",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessAuditModelImpl.DONEBY_COLUMN_BITMASK |
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DONEBYPEPROCESSSTATEID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDoneByPEProcessStateId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByDoneByPEProcessStateId(String doneBy,
		long spPEProcessStateId) throws SystemException {
		return findByDoneByPEProcessStateId(doneBy, spPEProcessStateId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByDoneByPEProcessStateId(String doneBy,
		long spPEProcessStateId, int start, int end) throws SystemException {
		return findByDoneByPEProcessStateId(doneBy, spPEProcessStateId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByDoneByPEProcessStateId(String doneBy,
		long spPEProcessStateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID;
			finderArgs = new Object[] { doneBy, spPEProcessStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID;
			finderArgs = new Object[] {
					doneBy, spPEProcessStateId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(doneBy, peProcessAudit.getDoneBy()) ||
						(spPEProcessStateId != peProcessAudit.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			boolean bindDoneBy = false;

			if (doneBy == null) {
				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_1);
			}
			else if (doneBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_3);
			}
			else {
				bindDoneBy = true;

				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_2);
			}

			query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDoneBy) {
					qPos.add(doneBy);
				}

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByDoneByPEProcessStateId_First(String doneBy,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByDoneByPEProcessStateId_First(doneBy,
				spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("doneBy=");
		msg.append(doneBy);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByDoneByPEProcessStateId_First(String doneBy,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessAudit> list = findByDoneByPEProcessStateId(doneBy,
				spPEProcessStateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByDoneByPEProcessStateId_Last(String doneBy,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByDoneByPEProcessStateId_Last(doneBy,
				spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("doneBy=");
		msg.append(doneBy);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByDoneByPEProcessStateId_Last(String doneBy,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDoneByPEProcessStateId(doneBy, spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByDoneByPEProcessStateId(doneBy,
				spPEProcessStateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByDoneByPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, String doneBy, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByDoneByPEProcessStateId_PrevAndNext(session,
					peProcessAudit, doneBy, spPEProcessStateId,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByDoneByPEProcessStateId_PrevAndNext(session,
					peProcessAudit, doneBy, spPEProcessStateId,
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

	protected PEProcessAudit getByDoneByPEProcessStateId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit, String doneBy,
		long spPEProcessStateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		boolean bindDoneBy = false;

		if (doneBy == null) {
			query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_1);
		}
		else if (doneBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_3);
		}
		else {
			bindDoneBy = true;

			query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_2);
		}

		query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDoneBy) {
			qPos.add(doneBy);
		}

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where doneBy = &#63; and spPEProcessStateId = &#63; from the database.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDoneByPEProcessStateId(String doneBy,
		long spPEProcessStateId) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByDoneByPEProcessStateId(
				doneBy, spPEProcessStateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where doneBy = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param doneBy the done by
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDoneByPEProcessStateId(String doneBy,
		long spPEProcessStateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DONEBYPEPROCESSSTATEID;

		Object[] finderArgs = new Object[] { doneBy, spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			boolean bindDoneBy = false;

			if (doneBy == null) {
				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_1);
			}
			else if (doneBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_3);
			}
			else {
				bindDoneBy = true;

				query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_2);
			}

			query.append(_FINDER_COLUMN_DONEBYPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDoneBy) {
					qPos.add(doneBy);
				}

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_1 = "peProcessAudit.doneBy IS NULL AND ";
	private static final String _FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_2 = "peProcessAudit.doneBy = ? AND ";
	private static final String _FINDER_COLUMN_DONEBYPEPROCESSSTATEID_DONEBY_3 = "(peProcessAudit.doneBy IS NULL OR peProcessAudit.doneBy = '') AND ";
	private static final String _FINDER_COLUMN_DONEBYPEPROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTypeActionPEProcessStateId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTypeActionPEProcessStateId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			PEProcessAuditModelImpl.TYPE_COLUMN_BITMASK |
			PEProcessAuditModelImpl.ACTION_COLUMN_BITMASK |
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPEACTIONPEPROCESSSTATEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTypeActionPEProcessStateId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypeActionPEProcessStateId(String type,
		String action, long spPEProcessStateId) throws SystemException {
		return findByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypeActionPEProcessStateId(String type,
		String action, long spPEProcessStateId, int start, int end)
		throws SystemException {
		return findByTypeActionPEProcessStateId(type, action,
			spPEProcessStateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByTypeActionPEProcessStateId(String type,
		String action, long spPEProcessStateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID;
			finderArgs = new Object[] { type, action, spPEProcessStateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID;
			finderArgs = new Object[] {
					type, action, spPEProcessStateId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(type, peProcessAudit.getType()) ||
						!Validator.equals(action, peProcessAudit.getAction()) ||
						(spPEProcessStateId != peProcessAudit.getSpPEProcessStateId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_2);
			}

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_2);
			}

			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (bindAction) {
					qPos.add(action);
				}

				qPos.add(spPEProcessStateId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByTypeActionPEProcessStateId_First(String type,
		String action, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByTypeActionPEProcessStateId_First(type,
				action, spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", action=");
		msg.append(action);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByTypeActionPEProcessStateId_First(String type,
		String action, long spPEProcessStateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByTypeActionPEProcessStateId(type,
				action, spPEProcessStateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByTypeActionPEProcessStateId_Last(String type,
		String action, long spPEProcessStateId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByTypeActionPEProcessStateId_Last(type,
				action, spPEProcessStateId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(", action=");
		msg.append(action);

		msg.append(", spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByTypeActionPEProcessStateId_Last(String type,
		String action, long spPEProcessStateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTypeActionPEProcessStateId(type, action,
				spPEProcessStateId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByTypeActionPEProcessStateId(type,
				action, spPEProcessStateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByTypeActionPEProcessStateId_PrevAndNext(
		long spPEProcessAuditId, String type, String action,
		long spPEProcessStateId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByTypeActionPEProcessStateId_PrevAndNext(session,
					peProcessAudit, type, action, spPEProcessStateId,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByTypeActionPEProcessStateId_PrevAndNext(session,
					peProcessAudit, type, action, spPEProcessStateId,
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

	protected PEProcessAudit getByTypeActionPEProcessStateId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit, String type,
		String action, long spPEProcessStateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_2);
		}

		boolean bindAction = false;

		if (action == null) {
			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_1);
		}
		else if (action.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_3);
		}
		else {
			bindAction = true;

			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_2);
		}

		query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (bindAction) {
			qPos.add(action);
		}

		qPos.add(spPEProcessStateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63; from the database.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTypeActionPEProcessStateId(String type, String action,
		long spPEProcessStateId) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByTypeActionPEProcessStateId(
				type, action, spPEProcessStateId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where type = &#63; and action = &#63; and spPEProcessStateId = &#63;.
	 *
	 * @param type the type
	 * @param action the action
	 * @param spPEProcessStateId the sp p e process state ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeActionPEProcessStateId(String type, String action,
		long spPEProcessStateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPEACTIONPEPROCESSSTATEID;

		Object[] finderArgs = new Object[] { type, action, spPEProcessStateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_2);
			}

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_2);
			}

			query.append(_FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_SPPEPROCESSSTATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (bindAction) {
					qPos.add(action);
				}

				qPos.add(spPEProcessStateId);

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

	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_1 =
		"peProcessAudit.type IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_2 =
		"peProcessAudit.type = ? AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_TYPE_3 =
		"(peProcessAudit.type IS NULL OR peProcessAudit.type = '') AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_1 =
		"peProcessAudit.action IS NULL AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_2 =
		"peProcessAudit.action = ? AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_ACTION_3 =
		"(peProcessAudit.action IS NULL OR peProcessAudit.action = '') AND ";
	private static final String _FINDER_COLUMN_TYPEACTIONPEPROCESSSTATEID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2 =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPEProcessStateIdTypeField2",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.TYPE_COLUMN_BITMASK |
			PEProcessAuditModelImpl.FIELD2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2 =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateIdTypeField2",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param field2 the field2
	 * @return the matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdTypeField2(
		long spPEProcessStateId, String type, String field2)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdTypeField2(spPEProcessStateId,
				type, field2);

		if (peProcessAudit == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spPEProcessStateId=");
			msg.append(spPEProcessStateId);

			msg.append(", type=");
			msg.append(type);

			msg.append(", field2=");
			msg.append(field2);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPEProcessAuditException(msg.toString());
		}

		return peProcessAudit;
	}

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param field2 the field2
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, String type, String field2)
		throws SystemException {
		return fetchByPEProcessStateIdTypeField2(spPEProcessStateId, type,
			field2, true);
	}

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param field2 the field2
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdTypeField2(
		long spPEProcessStateId, String type, String field2,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spPEProcessStateId, type, field2 };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
					finderArgs, this);
		}

		if (result instanceof PEProcessAudit) {
			PEProcessAudit peProcessAudit = (PEProcessAudit)result;

			if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId()) ||
					!Validator.equals(type, peProcessAudit.getType()) ||
					!Validator.equals(field2, peProcessAudit.getField2())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_SPPEPROCESSSTATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_2);
			}

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindType) {
					qPos.add(type);
				}

				if (bindField2) {
					qPos.add(field2);
				}

				List<PEProcessAudit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PEProcessAuditPersistenceImpl.fetchByPEProcessStateIdTypeField2(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PEProcessAudit peProcessAudit = list.get(0);

					result = peProcessAudit;

					cacheResult(peProcessAudit);

					if ((peProcessAudit.getSpPEProcessStateId() != spPEProcessStateId) ||
							(peProcessAudit.getType() == null) ||
							!peProcessAudit.getType().equals(type) ||
							(peProcessAudit.getField2() == null) ||
							!peProcessAudit.getField2().equals(field2)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
							finderArgs, peProcessAudit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
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
			return (PEProcessAudit)result;
		}
	}

	/**
	 * Removes the p e process audit where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param field2 the field2
	 * @return the p e process audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit removeByPEProcessStateIdTypeField2(
		long spPEProcessStateId, String type, String field2)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPEProcessStateIdTypeField2(spPEProcessStateId,
				type, field2);

		return remove(peProcessAudit);
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param field2 the field2
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdTypeField2(long spPEProcessStateId,
		String type, String field2) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2;

		Object[] finderArgs = new Object[] { spPEProcessStateId, type, field2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_SPPEPROCESSSTATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_2);
			}

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindType) {
					qPos.add(type);
				}

				if (bindField2) {
					qPos.add(field2);
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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_1 =
		"peProcessAudit.type IS NULL AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_2 =
		"peProcessAudit.type = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_TYPE_3 =
		"(peProcessAudit.type IS NULL OR peProcessAudit.type = '') AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_1 =
		"peProcessAudit.field2 IS NULL";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_2 =
		"peProcessAudit.field2 = ?";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPEFIELD2_FIELD2_3 =
		"(peProcessAudit.field2 IS NULL OR peProcessAudit.field2 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessStateIdNodeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPEProcessStateIdNodeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.NODEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEID = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateIdNodeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId) throws SystemException {
		return findByPEProcessStateIdNodeId(spPEProcessStateId, nodeId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end)
		throws SystemException {
		return findByPEProcessStateIdNodeId(spPEProcessStateId, nodeId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdNodeId(
		long spPEProcessStateId, long nodeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID;
			finderArgs = new Object[] { spPEProcessStateId, nodeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID;
			finderArgs = new Object[] {
					spPEProcessStateId, nodeId,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId()) ||
						(nodeId != peProcessAudit.getNodeId())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_NODEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(nodeId);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdNodeId_First(spPEProcessStateId,
				nodeId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdNodeId_First(
		long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByPEProcessStateIdNodeId(spPEProcessStateId,
				nodeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdNodeId_Last(spPEProcessStateId,
				nodeId, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", nodeId=");
		msg.append(nodeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdNodeId_Last(
		long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPEProcessStateIdNodeId(spPEProcessStateId, nodeId);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByPEProcessStateIdNodeId(spPEProcessStateId,
				nodeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByPEProcessStateIdNodeId_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByPEProcessStateIdNodeId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, nodeId,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByPEProcessStateIdNodeId_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, nodeId,
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

	protected PEProcessAudit getByPEProcessStateIdNodeId_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit,
		long spPEProcessStateId, long nodeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_SPPEPROCESSSTATEID_2);

		query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_NODEID_2);

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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		qPos.add(nodeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByPEProcessStateIdNodeId(
				spPEProcessStateId, nodeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdNodeId(long spPEProcessStateId,
		long nodeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEID;

		Object[] finderArgs = new Object[] { spPEProcessStateId, nodeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEID_NODEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(nodeId);

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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEID_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEID_NODEID_2 = "peProcessAudit.nodeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPEProcessStateIdType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPEProcessStateIdType",
			new String[] { Long.class.getName(), String.class.getName() },
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPE = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateIdType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, String type) throws SystemException {
		return findByPEProcessStateIdType(spPEProcessStateId, type,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, String type, int start, int end)
		throws SystemException {
		return findByPEProcessStateIdType(spPEProcessStateId, type, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByPEProcessStateIdType(
		long spPEProcessStateId, String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE;
			finderArgs = new Object[] { spPEProcessStateId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE;
			finderArgs = new Object[] {
					spPEProcessStateId, type,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId()) ||
						!Validator.equals(type, peProcessAudit.getType())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_SPPEPROCESSSTATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdType_First(
		long spPEProcessStateId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdType_First(spPEProcessStateId,
				type, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdType_First(
		long spPEProcessStateId, String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessAudit> list = findByPEProcessStateIdType(spPEProcessStateId,
				type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdType_Last(
		long spPEProcessStateId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdType_Last(spPEProcessStateId,
				type, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEProcessStateId=");
		msg.append(spPEProcessStateId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdType_Last(
		long spPEProcessStateId, String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPEProcessStateIdType(spPEProcessStateId, type);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByPEProcessStateIdType(spPEProcessStateId,
				type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByPEProcessStateIdType_PrevAndNext(
		long spPEProcessAuditId, long spPEProcessStateId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByPEProcessStateIdType_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, type,
					orderByComparator, true);

			array[1] = peProcessAudit;

			array[2] = getByPEProcessStateIdType_PrevAndNext(session,
					peProcessAudit, spPEProcessStateId, type,
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

	protected PEProcessAudit getByPEProcessStateIdType_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit,
		long spPEProcessStateId, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_SPPEPROCESSSTATEID_2);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_2);
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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spPEProcessStateId);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where spPEProcessStateId = &#63; and type = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPEProcessStateIdType(long spPEProcessStateId,
		String type) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByPEProcessStateIdType(
				spPEProcessStateId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63; and type = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param type the type
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdType(long spPEProcessStateId, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPE;

		Object[] finderArgs = new Object[] { spPEProcessStateId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_SPPEPROCESSSTATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPE_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_1 = "peProcessAudit.type IS NULL";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_2 = "peProcessAudit.type = ?";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDTYPE_TYPE_3 = "(peProcessAudit.type IS NULL OR peProcessAudit.type = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPEProcessStateIdNodeIdAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			PEProcessAuditModelImpl.SPPEPROCESSSTATEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.NODEID_COLUMN_BITMASK |
			PEProcessAuditModelImpl.ACTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPEProcessStateIdNodeIdAction",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param action the action
	 * @return the matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, String action)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPEProcessStateIdNodeIdAction(spPEProcessStateId,
				nodeId, action);

		if (peProcessAudit == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("spPEProcessStateId=");
			msg.append(spPEProcessStateId);

			msg.append(", nodeId=");
			msg.append(nodeId);

			msg.append(", action=");
			msg.append(action);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPEProcessAuditException(msg.toString());
		}

		return peProcessAudit;
	}

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param action the action
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, String action)
		throws SystemException {
		return fetchByPEProcessStateIdNodeIdAction(spPEProcessStateId, nodeId,
			action, true);
	}

	/**
	 * Returns the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param action the action
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, String action,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { spPEProcessStateId, nodeId, action };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
					finderArgs, this);
		}

		if (result instanceof PEProcessAudit) {
			PEProcessAudit peProcessAudit = (PEProcessAudit)result;

			if ((spPEProcessStateId != peProcessAudit.getSpPEProcessStateId()) ||
					(nodeId != peProcessAudit.getNodeId()) ||
					!Validator.equals(action, peProcessAudit.getAction())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_NODEID_2);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(nodeId);

				if (bindAction) {
					qPos.add(action);
				}

				List<PEProcessAudit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PEProcessAuditPersistenceImpl.fetchByPEProcessStateIdNodeIdAction(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PEProcessAudit peProcessAudit = list.get(0);

					result = peProcessAudit;

					cacheResult(peProcessAudit);

					if ((peProcessAudit.getSpPEProcessStateId() != spPEProcessStateId) ||
							(peProcessAudit.getNodeId() != nodeId) ||
							(peProcessAudit.getAction() == null) ||
							!peProcessAudit.getAction().equals(action)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
							finderArgs, peProcessAudit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
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
			return (PEProcessAudit)result;
		}
	}

	/**
	 * Removes the p e process audit where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63; from the database.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param action the action
	 * @return the p e process audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit removeByPEProcessStateIdNodeIdAction(
		long spPEProcessStateId, long nodeId, String action)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPEProcessStateIdNodeIdAction(spPEProcessStateId,
				nodeId, action);

		return remove(peProcessAudit);
	}

	/**
	 * Returns the number of p e process audits where spPEProcessStateId = &#63; and nodeId = &#63; and action = &#63;.
	 *
	 * @param spPEProcessStateId the sp p e process state ID
	 * @param nodeId the node ID
	 * @param action the action
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPEProcessStateIdNodeIdAction(long spPEProcessStateId,
		long nodeId, String action) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION;

		Object[] finderArgs = new Object[] { spPEProcessStateId, nodeId, action };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_SPPEPROCESSSTATEID_2);

			query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_NODEID_2);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEProcessStateId);

				qPos.add(nodeId);

				if (bindAction) {
					qPos.add(action);
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

	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_SPPEPROCESSSTATEID_2 =
		"peProcessAudit.spPEProcessStateId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_NODEID_2 =
		"peProcessAudit.nodeId = ? AND ";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_1 =
		"peProcessAudit.action IS NULL";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_2 =
		"peProcessAudit.action = ?";
	private static final String _FINDER_COLUMN_PEPROCESSSTATEIDNODEIDACTION_ACTION_3 =
		"(peProcessAudit.action IS NULL OR peProcessAudit.action = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIONTYPEFIELD2 =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActionTypeField2",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIONTYPEFIELD2 =
		new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED,
			PEProcessAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActionTypeField2",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PEProcessAuditModelImpl.ACTION_COLUMN_BITMASK |
			PEProcessAuditModelImpl.TYPE_COLUMN_BITMASK |
			PEProcessAuditModelImpl.FIELD2_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIONTYPEFIELD2 = new FinderPath(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActionTypeField2",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @return the matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByActionTypeField2(String action,
		String type, String field2) throws SystemException {
		return findByActionTypeField2(action, type, field2, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByActionTypeField2(String action,
		String type, String field2, int start, int end)
		throws SystemException {
		return findByActionTypeField2(action, type, field2, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findByActionTypeField2(String action,
		String type, String field2, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIONTYPEFIELD2;
			finderArgs = new Object[] { action, type, field2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIONTYPEFIELD2;
			finderArgs = new Object[] {
					action, type, field2,
					
					start, end, orderByComparator
				};
		}

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessAudit peProcessAudit : list) {
				if (!Validator.equals(action, peProcessAudit.getAction()) ||
						!Validator.equals(type, peProcessAudit.getType()) ||
						!Validator.equals(field2, peProcessAudit.getField2())) {
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

			query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_2);
			}

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAction) {
					qPos.add(action);
				}

				if (bindType) {
					qPos.add(type);
				}

				if (bindField2) {
					qPos.add(field2);
				}

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByActionTypeField2_First(String action,
		String type, String field2, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByActionTypeField2_First(action,
				type, field2, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("action=");
		msg.append(action);

		msg.append(", type=");
		msg.append(type);

		msg.append(", field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the first p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByActionTypeField2_First(String action,
		String type, String field2, OrderByComparator orderByComparator)
		throws SystemException {
		List<PEProcessAudit> list = findByActionTypeField2(action, type,
				field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByActionTypeField2_Last(String action,
		String type, String field2, OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByActionTypeField2_Last(action,
				type, field2, orderByComparator);

		if (peProcessAudit != null) {
			return peProcessAudit;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("action=");
		msg.append(action);

		msg.append(", type=");
		msg.append(type);

		msg.append(", field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessAuditException(msg.toString());
	}

	/**
	 * Returns the last p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process audit, or <code>null</code> if a matching p e process audit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByActionTypeField2_Last(String action,
		String type, String field2, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByActionTypeField2(action, type, field2);

		if (count == 0) {
			return null;
		}

		List<PEProcessAudit> list = findByActionTypeField2(action, type,
				field2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process audits before and after the current p e process audit in the ordered set where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param spPEProcessAuditId the primary key of the current p e process audit
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit[] findByActionTypeField2_PrevAndNext(
		long spPEProcessAuditId, String action, String type, String field2,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = findByPrimaryKey(spPEProcessAuditId);

		Session session = null;

		try {
			session = openSession();

			PEProcessAudit[] array = new PEProcessAuditImpl[3];

			array[0] = getByActionTypeField2_PrevAndNext(session,
					peProcessAudit, action, type, field2, orderByComparator,
					true);

			array[1] = peProcessAudit;

			array[2] = getByActionTypeField2_PrevAndNext(session,
					peProcessAudit, action, type, field2, orderByComparator,
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

	protected PEProcessAudit getByActionTypeField2_PrevAndNext(
		Session session, PEProcessAudit peProcessAudit, String action,
		String type, String field2, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSAUDIT_WHERE);

		boolean bindAction = false;

		if (action == null) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_1);
		}
		else if (action.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_3);
		}
		else {
			bindAction = true;

			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_2);
		}

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_2);
		}

		boolean bindField2 = false;

		if (field2 == null) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_1);
		}
		else if (field2.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_3);
		}
		else {
			bindField2 = true;

			query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_2);
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
			query.append(PEProcessAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAction) {
			qPos.add(action);
		}

		if (bindType) {
			qPos.add(type);
		}

		if (bindField2) {
			qPos.add(field2);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessAudit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessAudit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process audits where action = &#63; and type = &#63; and field2 = &#63; from the database.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActionTypeField2(String action, String type,
		String field2) throws SystemException {
		for (PEProcessAudit peProcessAudit : findByActionTypeField2(action,
				type, field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits where action = &#63; and type = &#63; and field2 = &#63;.
	 *
	 * @param action the action
	 * @param type the type
	 * @param field2 the field2
	 * @return the number of matching p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActionTypeField2(String action, String type, String field2)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIONTYPEFIELD2;

		Object[] finderArgs = new Object[] { action, type, field2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PEPROCESSAUDIT_WHERE);

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_2);
			}

			boolean bindField2 = false;

			if (field2 == null) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_1);
			}
			else if (field2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_3);
			}
			else {
				bindField2 = true;

				query.append(_FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAction) {
					qPos.add(action);
				}

				if (bindType) {
					qPos.add(type);
				}

				if (bindField2) {
					qPos.add(field2);
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

	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_1 = "peProcessAudit.action IS NULL AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_2 = "peProcessAudit.action = ? AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_ACTION_3 = "(peProcessAudit.action IS NULL OR peProcessAudit.action = '') AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_1 = "peProcessAudit.type IS NULL AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_2 = "peProcessAudit.type = ? AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_TYPE_3 = "(peProcessAudit.type IS NULL OR peProcessAudit.type = '') AND ";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_1 = "peProcessAudit.field2 IS NULL";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_2 = "peProcessAudit.field2 = ?";
	private static final String _FINDER_COLUMN_ACTIONTYPEFIELD2_FIELD2_3 = "(peProcessAudit.field2 IS NULL OR peProcessAudit.field2 = '')";

	public PEProcessAuditPersistenceImpl() {
		setModelClass(PEProcessAudit.class);
	}

	/**
	 * Caches the p e process audit in the entity cache if it is enabled.
	 *
	 * @param peProcessAudit the p e process audit
	 */
	@Override
	public void cacheResult(PEProcessAudit peProcessAudit) {
		EntityCacheUtil.putResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditImpl.class, peProcessAudit.getPrimaryKey(),
			peProcessAudit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peProcessAudit.getUuid(), peProcessAudit.getGroupId() },
			peProcessAudit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
			new Object[] {
				peProcessAudit.getSpPEProcessStateId(), peProcessAudit.getType(),
				peProcessAudit.getField2()
			}, peProcessAudit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
			new Object[] {
				peProcessAudit.getSpPEProcessStateId(),
				peProcessAudit.getNodeId(), peProcessAudit.getAction()
			}, peProcessAudit);

		peProcessAudit.resetOriginalValues();
	}

	/**
	 * Caches the p e process audits in the entity cache if it is enabled.
	 *
	 * @param peProcessAudits the p e process audits
	 */
	@Override
	public void cacheResult(List<PEProcessAudit> peProcessAudits) {
		for (PEProcessAudit peProcessAudit : peProcessAudits) {
			if (EntityCacheUtil.getResult(
						PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessAuditImpl.class, peProcessAudit.getPrimaryKey()) == null) {
				cacheResult(peProcessAudit);
			}
			else {
				peProcessAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e process audits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEProcessAuditImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEProcessAuditImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e process audit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEProcessAudit peProcessAudit) {
		EntityCacheUtil.removeResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditImpl.class, peProcessAudit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peProcessAudit);
	}

	@Override
	public void clearCache(List<PEProcessAudit> peProcessAudits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEProcessAudit peProcessAudit : peProcessAudits) {
			EntityCacheUtil.removeResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessAuditImpl.class, peProcessAudit.getPrimaryKey());

			clearUniqueFindersCache(peProcessAudit);
		}
	}

	protected void cacheUniqueFindersCache(PEProcessAudit peProcessAudit) {
		if (peProcessAudit.isNew()) {
			Object[] args = new Object[] {
					peProcessAudit.getUuid(), peProcessAudit.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peProcessAudit);

			args = new Object[] {
					peProcessAudit.getSpPEProcessStateId(),
					peProcessAudit.getType(), peProcessAudit.getField2()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
				args, peProcessAudit);

			args = new Object[] {
					peProcessAudit.getSpPEProcessStateId(),
					peProcessAudit.getNodeId(), peProcessAudit.getAction()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
				args, peProcessAudit);
		}
		else {
			PEProcessAuditModelImpl peProcessAuditModelImpl = (PEProcessAuditModelImpl)peProcessAudit;

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAudit.getUuid(), peProcessAudit.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peProcessAudit);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAudit.getSpPEProcessStateId(),
						peProcessAudit.getType(), peProcessAudit.getField2()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
					args, peProcessAudit);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAudit.getSpPEProcessStateId(),
						peProcessAudit.getNodeId(), peProcessAudit.getAction()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
					args, peProcessAudit);
			}
		}
	}

	protected void clearUniqueFindersCache(PEProcessAudit peProcessAudit) {
		PEProcessAuditModelImpl peProcessAuditModelImpl = (PEProcessAuditModelImpl)peProcessAudit;

		Object[] args = new Object[] {
				peProcessAudit.getUuid(), peProcessAudit.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peProcessAuditModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessAuditModelImpl.getOriginalUuid(),
					peProcessAuditModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				peProcessAudit.getSpPEProcessStateId(), peProcessAudit.getType(),
				peProcessAudit.getField2()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
			args);

		if ((peProcessAuditModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessAuditModelImpl.getOriginalSpPEProcessStateId(),
					peProcessAuditModelImpl.getOriginalType(),
					peProcessAuditModelImpl.getOriginalField2()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPEFIELD2,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDTYPEFIELD2,
				args);
		}

		args = new Object[] {
				peProcessAudit.getSpPEProcessStateId(),
				peProcessAudit.getNodeId(), peProcessAudit.getAction()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
			args);

		if ((peProcessAuditModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessAuditModelImpl.getOriginalSpPEProcessStateId(),
					peProcessAuditModelImpl.getOriginalNodeId(),
					peProcessAuditModelImpl.getOriginalAction()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEIDACTION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PEPROCESSSTATEIDNODEIDACTION,
				args);
		}
	}

	/**
	 * Creates a new p e process audit with the primary key. Does not add the p e process audit to the database.
	 *
	 * @param spPEProcessAuditId the primary key for the new p e process audit
	 * @return the new p e process audit
	 */
	@Override
	public PEProcessAudit create(long spPEProcessAuditId) {
		PEProcessAudit peProcessAudit = new PEProcessAuditImpl();

		peProcessAudit.setNew(true);
		peProcessAudit.setPrimaryKey(spPEProcessAuditId);

		String uuid = PortalUUIDUtil.generate();

		peProcessAudit.setUuid(uuid);

		return peProcessAudit;
	}

	/**
	 * Removes the p e process audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessAuditId the primary key of the p e process audit
	 * @return the p e process audit that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit remove(long spPEProcessAuditId)
		throws NoSuchPEProcessAuditException, SystemException {
		return remove((Serializable)spPEProcessAuditId);
	}

	/**
	 * Removes the p e process audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e process audit
	 * @return the p e process audit that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit remove(Serializable primaryKey)
		throws NoSuchPEProcessAuditException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEProcessAudit peProcessAudit = (PEProcessAudit)session.get(PEProcessAuditImpl.class,
					primaryKey);

			if (peProcessAudit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEProcessAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peProcessAudit);
		}
		catch (NoSuchPEProcessAuditException nsee) {
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
	protected PEProcessAudit removeImpl(PEProcessAudit peProcessAudit)
		throws SystemException {
		peProcessAudit = toUnwrappedModel(peProcessAudit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peProcessAudit)) {
				peProcessAudit = (PEProcessAudit)session.get(PEProcessAuditImpl.class,
						peProcessAudit.getPrimaryKeyObj());
			}

			if (peProcessAudit != null) {
				session.delete(peProcessAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peProcessAudit != null) {
			clearCache(peProcessAudit);
		}

		return peProcessAudit;
	}

	@Override
	public PEProcessAudit updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit)
		throws SystemException {
		peProcessAudit = toUnwrappedModel(peProcessAudit);

		boolean isNew = peProcessAudit.isNew();

		PEProcessAuditModelImpl peProcessAuditModelImpl = (PEProcessAuditModelImpl)peProcessAudit;

		if (Validator.isNull(peProcessAudit.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peProcessAudit.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peProcessAudit.isNew()) {
				session.save(peProcessAudit);

				peProcessAudit.setNew(false);
			}
			else {
				session.merge(peProcessAudit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEProcessAuditModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peProcessAuditModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalUuid(),
						peProcessAuditModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getUuid(),
						peProcessAuditModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId(),
						peProcessAuditModelImpl.getOriginalField2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDFORMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getSpPEProcessStateId(),
						peProcessAuditModelImpl.getField2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDFORMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDFORMID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalType(),
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getType(),
						peProcessAuditModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEPEPROCESSSTATEID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalDoneBy(),
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DONEBYPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getDoneBy(),
						peProcessAuditModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DONEBYPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONEBYPEPROCESSSTATEID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalType(),
						peProcessAuditModelImpl.getOriginalAction(),
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEACTIONPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getType(),
						peProcessAuditModelImpl.getAction(),
						peProcessAuditModelImpl.getSpPEProcessStateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPEACTIONPEPROCESSSTATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPEACTIONPEPROCESSSTATEID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId(),
						peProcessAuditModelImpl.getOriginalNodeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getSpPEProcessStateId(),
						peProcessAuditModelImpl.getNodeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDNODEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDNODEID,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalSpPEProcessStateId(),
						peProcessAuditModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getSpPEProcessStateId(),
						peProcessAuditModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PEPROCESSSTATEIDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PEPROCESSSTATEIDTYPE,
					args);
			}

			if ((peProcessAuditModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIONTYPEFIELD2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessAuditModelImpl.getOriginalAction(),
						peProcessAuditModelImpl.getOriginalType(),
						peProcessAuditModelImpl.getOriginalField2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIONTYPEFIELD2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIONTYPEFIELD2,
					args);

				args = new Object[] {
						peProcessAuditModelImpl.getAction(),
						peProcessAuditModelImpl.getType(),
						peProcessAuditModelImpl.getField2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIONTYPEFIELD2,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIONTYPEFIELD2,
					args);
			}
		}

		EntityCacheUtil.putResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessAuditImpl.class, peProcessAudit.getPrimaryKey(),
			peProcessAudit);

		clearUniqueFindersCache(peProcessAudit);
		cacheUniqueFindersCache(peProcessAudit);

		return peProcessAudit;
	}

	protected PEProcessAudit toUnwrappedModel(PEProcessAudit peProcessAudit) {
		if (peProcessAudit instanceof PEProcessAuditImpl) {
			return peProcessAudit;
		}

		PEProcessAuditImpl peProcessAuditImpl = new PEProcessAuditImpl();

		peProcessAuditImpl.setNew(peProcessAudit.isNew());
		peProcessAuditImpl.setPrimaryKey(peProcessAudit.getPrimaryKey());

		peProcessAuditImpl.setUuid(peProcessAudit.getUuid());
		peProcessAuditImpl.setSpPEProcessAuditId(peProcessAudit.getSpPEProcessAuditId());
		peProcessAuditImpl.setGroupId(peProcessAudit.getGroupId());
		peProcessAuditImpl.setUserId(peProcessAudit.getUserId());
		peProcessAuditImpl.setCompanyId(peProcessAudit.getCompanyId());
		peProcessAuditImpl.setUserName(peProcessAudit.getUserName());
		peProcessAuditImpl.setCreateDate(peProcessAudit.getCreateDate());
		peProcessAuditImpl.setModifiedDate(peProcessAudit.getModifiedDate());
		peProcessAuditImpl.setSpPEProcessStateId(peProcessAudit.getSpPEProcessStateId());
		peProcessAuditImpl.setSpPEProcessId(peProcessAudit.getSpPEProcessId());
		peProcessAuditImpl.setEntityClassId(peProcessAudit.getEntityClassId());
		peProcessAuditImpl.setEntityId(peProcessAudit.getEntityId());
		peProcessAuditImpl.setUserIdProcess(peProcessAudit.getUserIdProcess());
		peProcessAuditImpl.setStatusTypeId(peProcessAudit.getStatusTypeId());
		peProcessAuditImpl.setSpPEProcessStageId(peProcessAudit.getSpPEProcessStageId());
		peProcessAuditImpl.setNodeId(peProcessAudit.getNodeId());
		peProcessAuditImpl.setStatus(peProcessAudit.getStatus());
		peProcessAuditImpl.setUserIdSupervisor(peProcessAudit.getUserIdSupervisor());
		peProcessAuditImpl.setUserIdAgent(peProcessAudit.getUserIdAgent());
		peProcessAuditImpl.setSpPEClosedStageId(peProcessAudit.getSpPEClosedStageId());
		peProcessAuditImpl.setType(peProcessAudit.getType());
		peProcessAuditImpl.setDoneBy(peProcessAudit.getDoneBy());
		peProcessAuditImpl.setAction(peProcessAudit.getAction());
		peProcessAuditImpl.setField1(peProcessAudit.getField1());
		peProcessAuditImpl.setField2(peProcessAudit.getField2());
		peProcessAuditImpl.setField3(peProcessAudit.getField3());
		peProcessAuditImpl.setField4(peProcessAudit.getField4());
		peProcessAuditImpl.setField5(peProcessAudit.getField5());
		peProcessAuditImpl.setStorageId(peProcessAudit.getStorageId());
		peProcessAuditImpl.setData1(peProcessAudit.getData1());
		peProcessAuditImpl.setData2(peProcessAudit.getData2());
		peProcessAuditImpl.setSourceClassId(peProcessAudit.getSourceClassId());
		peProcessAuditImpl.setSourceEntityID(peProcessAudit.getSourceEntityID());

		return peProcessAuditImpl;
	}

	/**
	 * Returns the p e process audit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process audit
	 * @return the p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEProcessAuditException, SystemException {
		PEProcessAudit peProcessAudit = fetchByPrimaryKey(primaryKey);

		if (peProcessAudit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEProcessAuditException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peProcessAudit;
	}

	/**
	 * Returns the p e process audit with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException} if it could not be found.
	 *
	 * @param spPEProcessAuditId the primary key of the p e process audit
	 * @return the p e process audit
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit findByPrimaryKey(long spPEProcessAuditId)
		throws NoSuchPEProcessAuditException, SystemException {
		return findByPrimaryKey((Serializable)spPEProcessAuditId);
	}

	/**
	 * Returns the p e process audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process audit
	 * @return the p e process audit, or <code>null</code> if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEProcessAudit peProcessAudit = (PEProcessAudit)EntityCacheUtil.getResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessAuditImpl.class, primaryKey);

		if (peProcessAudit == _nullPEProcessAudit) {
			return null;
		}

		if (peProcessAudit == null) {
			Session session = null;

			try {
				session = openSession();

				peProcessAudit = (PEProcessAudit)session.get(PEProcessAuditImpl.class,
						primaryKey);

				if (peProcessAudit != null) {
					cacheResult(peProcessAudit);
				}
				else {
					EntityCacheUtil.putResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessAuditImpl.class, primaryKey,
						_nullPEProcessAudit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEProcessAuditModelImpl.ENTITY_CACHE_ENABLED,
					PEProcessAuditImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peProcessAudit;
	}

	/**
	 * Returns the p e process audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEProcessAuditId the primary key of the p e process audit
	 * @return the p e process audit, or <code>null</code> if a p e process audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessAudit fetchByPrimaryKey(long spPEProcessAuditId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEProcessAuditId);
	}

	/**
	 * Returns all the p e process audits.
	 *
	 * @return the p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @return the range of p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessAuditModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process audits
	 * @param end the upper bound of the range of p e process audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e process audits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessAudit> findAll(int start, int end,
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

		List<PEProcessAudit> list = (List<PEProcessAudit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEPROCESSAUDIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEPROCESSAUDIT;

				if (pagination) {
					sql = sql.concat(PEProcessAuditModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessAudit>(list);
				}
				else {
					list = (List<PEProcessAudit>)QueryUtil.list(q,
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
	 * Removes all the p e process audits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEProcessAudit peProcessAudit : findAll()) {
			remove(peProcessAudit);
		}
	}

	/**
	 * Returns the number of p e process audits.
	 *
	 * @return the number of p e process audits
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

				Query q = session.createQuery(_SQL_COUNT_PEPROCESSAUDIT);

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
	 * Initializes the p e process audit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEProcessAudit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEProcessAudit>> listenersList = new ArrayList<ModelListener<PEProcessAudit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEProcessAudit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEProcessAuditImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEPROCESSAUDIT = "SELECT peProcessAudit FROM PEProcessAudit peProcessAudit";
	private static final String _SQL_SELECT_PEPROCESSAUDIT_WHERE = "SELECT peProcessAudit FROM PEProcessAudit peProcessAudit WHERE ";
	private static final String _SQL_COUNT_PEPROCESSAUDIT = "SELECT COUNT(peProcessAudit) FROM PEProcessAudit peProcessAudit";
	private static final String _SQL_COUNT_PEPROCESSAUDIT_WHERE = "SELECT COUNT(peProcessAudit) FROM PEProcessAudit peProcessAudit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peProcessAudit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEProcessAudit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEProcessAudit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEProcessAuditPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type"
			});
	private static PEProcessAudit _nullPEProcessAudit = new PEProcessAuditImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEProcessAudit> toCacheModel() {
				return _nullPEProcessAuditCacheModel;
			}
		};

	private static CacheModel<PEProcessAudit> _nullPEProcessAuditCacheModel = new CacheModel<PEProcessAudit>() {
			@Override
			public PEProcessAudit toEntityModel() {
				return _nullPEProcessAudit;
			}
		};
}