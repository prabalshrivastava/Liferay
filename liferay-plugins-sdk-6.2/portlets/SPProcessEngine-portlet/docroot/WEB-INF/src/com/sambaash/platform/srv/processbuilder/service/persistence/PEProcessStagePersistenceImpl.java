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

import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e process stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessStagePersistence
 * @see PEProcessStageUtil
 * @generated
 */
public class PEProcessStagePersistenceImpl extends BasePersistenceImpl<PEProcessStage>
	implements PEProcessStagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEProcessStageUtil} to access the p e process stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEProcessStageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PEProcessStageModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStageModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e process stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @return the range of matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid(String uuid, int start, int end,
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

		List<PEProcessStage> list = (List<PEProcessStage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStage peProcessStage : list) {
				if (!Validator.equals(uuid, peProcessStage.getUuid())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTAGE_WHERE);

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
				query.append(PEProcessStageModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessStage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStage>(list);
				}
				else {
					list = (List<PEProcessStage>)QueryUtil.list(q,
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
	 * Returns the first p e process stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByUuid_First(uuid,
				orderByComparator);

		if (peProcessStage != null) {
			return peProcessStage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStageException(msg.toString());
	}

	/**
	 * Returns the first p e process stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByUuid_Last(uuid, orderByComparator);

		if (peProcessStage != null) {
			return peProcessStage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStageException(msg.toString());
	}

	/**
	 * Returns the last p e process stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEProcessStage> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process stages before and after the current p e process stage in the ordered set where uuid = &#63;.
	 *
	 * @param spPEProcessStageId the primary key of the current p e process stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage[] findByUuid_PrevAndNext(long spPEProcessStageId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = findByPrimaryKey(spPEProcessStageId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStage[] array = new PEProcessStageImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peProcessStage, uuid,
					orderByComparator, true);

			array[1] = peProcessStage;

			array[2] = getByUuid_PrevAndNext(session, peProcessStage, uuid,
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

	protected PEProcessStage getByUuid_PrevAndNext(Session session,
		PEProcessStage peProcessStage, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTAGE_WHERE);

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
			query.append(PEProcessStageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEProcessStage peProcessStage : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStage);
		}
	}

	/**
	 * Returns the number of p e process stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e process stages
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

			query.append(_SQL_COUNT_PEPROCESSSTAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peProcessStage.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peProcessStage.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peProcessStage.uuid IS NULL OR peProcessStage.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStageModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStageModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e process stage where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByUUID_G(uuid, groupId);

		if (peProcessStage == null) {
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

			throw new NoSuchPEProcessStageException(msg.toString());
		}

		return peProcessStage;
	}

	/**
	 * Returns the p e process stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e process stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEProcessStage) {
			PEProcessStage peProcessStage = (PEProcessStage)result;

			if (!Validator.equals(uuid, peProcessStage.getUuid()) ||
					(groupId != peProcessStage.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEPROCESSSTAGE_WHERE);

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

				List<PEProcessStage> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEProcessStage peProcessStage = list.get(0);

					result = peProcessStage;

					cacheResult(peProcessStage);

					if ((peProcessStage.getUuid() == null) ||
							!peProcessStage.getUuid().equals(uuid) ||
							(peProcessStage.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peProcessStage);
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
			return (PEProcessStage)result;
		}
	}

	/**
	 * Removes the p e process stage where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e process stage that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = findByUUID_G(uuid, groupId);

		return remove(peProcessStage);
	}

	/**
	 * Returns the number of p e process stages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e process stages
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

			query.append(_SQL_COUNT_PEPROCESSSTAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peProcessStage.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peProcessStage.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peProcessStage.uuid IS NULL OR peProcessStage.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peProcessStage.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED,
			PEProcessStageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEProcessStageModelImpl.UUID_COLUMN_BITMASK |
			PEProcessStageModelImpl.COMPANYID_COLUMN_BITMASK |
			PEProcessStageModelImpl.SEQNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e process stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process stages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @return the range of matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process stages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findByUuid_C(String uuid, long companyId,
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

		List<PEProcessStage> list = (List<PEProcessStage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEProcessStage peProcessStage : list) {
				if (!Validator.equals(uuid, peProcessStage.getUuid()) ||
						(companyId != peProcessStage.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEPROCESSSTAGE_WHERE);

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
				query.append(PEProcessStageModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEProcessStage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStage>(list);
				}
				else {
					list = (List<PEProcessStage>)QueryUtil.list(q,
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
	 * Returns the first p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peProcessStage != null) {
			return peProcessStage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStageException(msg.toString());
	}

	/**
	 * Returns the first p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEProcessStage> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peProcessStage != null) {
			return peProcessStage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEProcessStageException(msg.toString());
	}

	/**
	 * Returns the last p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e process stage, or <code>null</code> if a matching p e process stage could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEProcessStage> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e process stages before and after the current p e process stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEProcessStageId the primary key of the current p e process stage
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage[] findByUuid_C_PrevAndNext(long spPEProcessStageId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = findByPrimaryKey(spPEProcessStageId);

		Session session = null;

		try {
			session = openSession();

			PEProcessStage[] array = new PEProcessStageImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peProcessStage, uuid,
					companyId, orderByComparator, true);

			array[1] = peProcessStage;

			array[2] = getByUuid_C_PrevAndNext(session, peProcessStage, uuid,
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

	protected PEProcessStage getByUuid_C_PrevAndNext(Session session,
		PEProcessStage peProcessStage, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEPROCESSSTAGE_WHERE);

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
			query.append(PEProcessStageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peProcessStage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEProcessStage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e process stages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEProcessStage peProcessStage : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peProcessStage);
		}
	}

	/**
	 * Returns the number of p e process stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e process stages
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

			query.append(_SQL_COUNT_PEPROCESSSTAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peProcessStage.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peProcessStage.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peProcessStage.uuid IS NULL OR peProcessStage.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peProcessStage.companyId = ?";

	public PEProcessStagePersistenceImpl() {
		setModelClass(PEProcessStage.class);
	}

	/**
	 * Caches the p e process stage in the entity cache if it is enabled.
	 *
	 * @param peProcessStage the p e process stage
	 */
	@Override
	public void cacheResult(PEProcessStage peProcessStage) {
		EntityCacheUtil.putResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageImpl.class, peProcessStage.getPrimaryKey(),
			peProcessStage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peProcessStage.getUuid(), peProcessStage.getGroupId() },
			peProcessStage);

		peProcessStage.resetOriginalValues();
	}

	/**
	 * Caches the p e process stages in the entity cache if it is enabled.
	 *
	 * @param peProcessStages the p e process stages
	 */
	@Override
	public void cacheResult(List<PEProcessStage> peProcessStages) {
		for (PEProcessStage peProcessStage : peProcessStages) {
			if (EntityCacheUtil.getResult(
						PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStageImpl.class, peProcessStage.getPrimaryKey()) == null) {
				cacheResult(peProcessStage);
			}
			else {
				peProcessStage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e process stages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEProcessStageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEProcessStageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e process stage.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEProcessStage peProcessStage) {
		EntityCacheUtil.removeResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageImpl.class, peProcessStage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peProcessStage);
	}

	@Override
	public void clearCache(List<PEProcessStage> peProcessStages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEProcessStage peProcessStage : peProcessStages) {
			EntityCacheUtil.removeResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStageImpl.class, peProcessStage.getPrimaryKey());

			clearUniqueFindersCache(peProcessStage);
		}
	}

	protected void cacheUniqueFindersCache(PEProcessStage peProcessStage) {
		if (peProcessStage.isNew()) {
			Object[] args = new Object[] {
					peProcessStage.getUuid(), peProcessStage.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peProcessStage);
		}
		else {
			PEProcessStageModelImpl peProcessStageModelImpl = (PEProcessStageModelImpl)peProcessStage;

			if ((peProcessStageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStage.getUuid(), peProcessStage.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peProcessStage);
			}
		}
	}

	protected void clearUniqueFindersCache(PEProcessStage peProcessStage) {
		PEProcessStageModelImpl peProcessStageModelImpl = (PEProcessStageModelImpl)peProcessStage;

		Object[] args = new Object[] {
				peProcessStage.getUuid(), peProcessStage.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peProcessStageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peProcessStageModelImpl.getOriginalUuid(),
					peProcessStageModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new p e process stage with the primary key. Does not add the p e process stage to the database.
	 *
	 * @param spPEProcessStageId the primary key for the new p e process stage
	 * @return the new p e process stage
	 */
	@Override
	public PEProcessStage create(long spPEProcessStageId) {
		PEProcessStage peProcessStage = new PEProcessStageImpl();

		peProcessStage.setNew(true);
		peProcessStage.setPrimaryKey(spPEProcessStageId);

		String uuid = PortalUUIDUtil.generate();

		peProcessStage.setUuid(uuid);

		return peProcessStage;
	}

	/**
	 * Removes the p e process stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEProcessStageId the primary key of the p e process stage
	 * @return the p e process stage that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage remove(long spPEProcessStageId)
		throws NoSuchPEProcessStageException, SystemException {
		return remove((Serializable)spPEProcessStageId);
	}

	/**
	 * Removes the p e process stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e process stage
	 * @return the p e process stage that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage remove(Serializable primaryKey)
		throws NoSuchPEProcessStageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEProcessStage peProcessStage = (PEProcessStage)session.get(PEProcessStageImpl.class,
					primaryKey);

			if (peProcessStage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEProcessStageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peProcessStage);
		}
		catch (NoSuchPEProcessStageException nsee) {
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
	protected PEProcessStage removeImpl(PEProcessStage peProcessStage)
		throws SystemException {
		peProcessStage = toUnwrappedModel(peProcessStage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peProcessStage)) {
				peProcessStage = (PEProcessStage)session.get(PEProcessStageImpl.class,
						peProcessStage.getPrimaryKeyObj());
			}

			if (peProcessStage != null) {
				session.delete(peProcessStage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peProcessStage != null) {
			clearCache(peProcessStage);
		}

		return peProcessStage;
	}

	@Override
	public PEProcessStage updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEProcessStage peProcessStage)
		throws SystemException {
		peProcessStage = toUnwrappedModel(peProcessStage);

		boolean isNew = peProcessStage.isNew();

		PEProcessStageModelImpl peProcessStageModelImpl = (PEProcessStageModelImpl)peProcessStage;

		if (Validator.isNull(peProcessStage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peProcessStage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peProcessStage.isNew()) {
				session.save(peProcessStage);

				peProcessStage.setNew(false);
			}
			else {
				session.merge(peProcessStage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEProcessStageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peProcessStageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStageModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peProcessStageModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peProcessStageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peProcessStageModelImpl.getOriginalUuid(),
						peProcessStageModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peProcessStageModelImpl.getUuid(),
						peProcessStageModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
			PEProcessStageImpl.class, peProcessStage.getPrimaryKey(),
			peProcessStage);

		clearUniqueFindersCache(peProcessStage);
		cacheUniqueFindersCache(peProcessStage);

		return peProcessStage;
	}

	protected PEProcessStage toUnwrappedModel(PEProcessStage peProcessStage) {
		if (peProcessStage instanceof PEProcessStageImpl) {
			return peProcessStage;
		}

		PEProcessStageImpl peProcessStageImpl = new PEProcessStageImpl();

		peProcessStageImpl.setNew(peProcessStage.isNew());
		peProcessStageImpl.setPrimaryKey(peProcessStage.getPrimaryKey());

		peProcessStageImpl.setUuid(peProcessStage.getUuid());
		peProcessStageImpl.setSpPEProcessStageId(peProcessStage.getSpPEProcessStageId());
		peProcessStageImpl.setGroupId(peProcessStage.getGroupId());
		peProcessStageImpl.setUserId(peProcessStage.getUserId());
		peProcessStageImpl.setCompanyId(peProcessStage.getCompanyId());
		peProcessStageImpl.setUserName(peProcessStage.getUserName());
		peProcessStageImpl.setCreateDate(peProcessStage.getCreateDate());
		peProcessStageImpl.setModifiedDate(peProcessStage.getModifiedDate());
		peProcessStageImpl.setName(peProcessStage.getName());
		peProcessStageImpl.setStyle(peProcessStage.getStyle());
		peProcessStageImpl.setSeqNo(peProcessStage.getSeqNo());

		return peProcessStageImpl;
	}

	/**
	 * Returns the p e process stage with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process stage
	 * @return the p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEProcessStageException, SystemException {
		PEProcessStage peProcessStage = fetchByPrimaryKey(primaryKey);

		if (peProcessStage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEProcessStageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peProcessStage;
	}

	/**
	 * Returns the p e process stage with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException} if it could not be found.
	 *
	 * @param spPEProcessStageId the primary key of the p e process stage
	 * @return the p e process stage
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEProcessStageException if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage findByPrimaryKey(long spPEProcessStageId)
		throws NoSuchPEProcessStageException, SystemException {
		return findByPrimaryKey((Serializable)spPEProcessStageId);
	}

	/**
	 * Returns the p e process stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e process stage
	 * @return the p e process stage, or <code>null</code> if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEProcessStage peProcessStage = (PEProcessStage)EntityCacheUtil.getResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
				PEProcessStageImpl.class, primaryKey);

		if (peProcessStage == _nullPEProcessStage) {
			return null;
		}

		if (peProcessStage == null) {
			Session session = null;

			try {
				session = openSession();

				peProcessStage = (PEProcessStage)session.get(PEProcessStageImpl.class,
						primaryKey);

				if (peProcessStage != null) {
					cacheResult(peProcessStage);
				}
				else {
					EntityCacheUtil.putResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
						PEProcessStageImpl.class, primaryKey,
						_nullPEProcessStage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEProcessStageModelImpl.ENTITY_CACHE_ENABLED,
					PEProcessStageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peProcessStage;
	}

	/**
	 * Returns the p e process stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEProcessStageId the primary key of the p e process stage
	 * @return the p e process stage, or <code>null</code> if a p e process stage with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEProcessStage fetchByPrimaryKey(long spPEProcessStageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEProcessStageId);
	}

	/**
	 * Returns all the p e process stages.
	 *
	 * @return the p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e process stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @return the range of p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e process stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEProcessStageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e process stages
	 * @param end the upper bound of the range of p e process stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e process stages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEProcessStage> findAll(int start, int end,
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

		List<PEProcessStage> list = (List<PEProcessStage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEPROCESSSTAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEPROCESSSTAGE;

				if (pagination) {
					sql = sql.concat(PEProcessStageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEProcessStage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEProcessStage>(list);
				}
				else {
					list = (List<PEProcessStage>)QueryUtil.list(q,
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
	 * Removes all the p e process stages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEProcessStage peProcessStage : findAll()) {
			remove(peProcessStage);
		}
	}

	/**
	 * Returns the number of p e process stages.
	 *
	 * @return the number of p e process stages
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

				Query q = session.createQuery(_SQL_COUNT_PEPROCESSSTAGE);

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
	 * Initializes the p e process stage persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEProcessStage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEProcessStage>> listenersList = new ArrayList<ModelListener<PEProcessStage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEProcessStage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEProcessStageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEPROCESSSTAGE = "SELECT peProcessStage FROM PEProcessStage peProcessStage";
	private static final String _SQL_SELECT_PEPROCESSSTAGE_WHERE = "SELECT peProcessStage FROM PEProcessStage peProcessStage WHERE ";
	private static final String _SQL_COUNT_PEPROCESSSTAGE = "SELECT COUNT(peProcessStage) FROM PEProcessStage peProcessStage";
	private static final String _SQL_COUNT_PEPROCESSSTAGE_WHERE = "SELECT COUNT(peProcessStage) FROM PEProcessStage peProcessStage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peProcessStage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEProcessStage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEProcessStage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEProcessStagePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PEProcessStage _nullPEProcessStage = new PEProcessStageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEProcessStage> toCacheModel() {
				return _nullPEProcessStageCacheModel;
			}
		};

	private static CacheModel<PEProcessStage> _nullPEProcessStageCacheModel = new CacheModel<PEProcessStage>() {
			@Override
			public PEProcessStage toEntityModel() {
				return _nullPEProcessStage;
			}
		};
}