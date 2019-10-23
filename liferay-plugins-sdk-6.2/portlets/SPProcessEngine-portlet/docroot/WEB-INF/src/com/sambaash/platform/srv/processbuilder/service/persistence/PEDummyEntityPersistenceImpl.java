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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException;
import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;
import com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityImpl;
import com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the p e dummy entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PEDummyEntityPersistence
 * @see PEDummyEntityUtil
 * @generated
 */
public class PEDummyEntityPersistenceImpl extends BasePersistenceImpl<PEDummyEntity>
	implements PEDummyEntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PEDummyEntityUtil} to access the p e dummy entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PEDummyEntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			PEDummyEntityModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the p e dummy entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e dummy entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @return the range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e dummy entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid(String uuid, int start, int end,
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

		List<PEDummyEntity> list = (List<PEDummyEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEDummyEntity peDummyEntity : list) {
				if (!Validator.equals(uuid, peDummyEntity.getUuid())) {
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

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

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
				query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEDummyEntity>(list);
				}
				else {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e dummy entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByUuid_First(uuid, orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the first p e dummy entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEDummyEntity> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByUuid_Last(uuid, orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PEDummyEntity> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e dummy entities before and after the current p e dummy entity in the ordered set where uuid = &#63;.
	 *
	 * @param spPEDummyEntityId the primary key of the current p e dummy entity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity[] findByUuid_PrevAndNext(long spPEDummyEntityId,
		String uuid, OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = findByPrimaryKey(spPEDummyEntityId);

		Session session = null;

		try {
			session = openSession();

			PEDummyEntity[] array = new PEDummyEntityImpl[3];

			array[0] = getByUuid_PrevAndNext(session, peDummyEntity, uuid,
					orderByComparator, true);

			array[1] = peDummyEntity;

			array[2] = getByUuid_PrevAndNext(session, peDummyEntity, uuid,
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

	protected PEDummyEntity getByUuid_PrevAndNext(Session session,
		PEDummyEntity peDummyEntity, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

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
			query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peDummyEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEDummyEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e dummy entities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PEDummyEntity peDummyEntity : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(peDummyEntity);
		}
	}

	/**
	 * Returns the number of p e dummy entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching p e dummy entities
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

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "peDummyEntity.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "peDummyEntity.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(peDummyEntity.uuid IS NULL OR peDummyEntity.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PEDummyEntityModelImpl.UUID_COLUMN_BITMASK |
			PEDummyEntityModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByUUID_G(String uuid, long groupId)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByUUID_G(uuid, groupId);

		if (peDummyEntity == null) {
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

			throw new NoSuchPEDummyEntityException(msg.toString());
		}

		return peDummyEntity;
	}

	/**
	 * Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the p e dummy entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PEDummyEntity) {
			PEDummyEntity peDummyEntity = (PEDummyEntity)result;

			if (!Validator.equals(uuid, peDummyEntity.getUuid()) ||
					(groupId != peDummyEntity.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

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

				List<PEDummyEntity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PEDummyEntity peDummyEntity = list.get(0);

					result = peDummyEntity;

					cacheResult(peDummyEntity);

					if ((peDummyEntity.getUuid() == null) ||
							!peDummyEntity.getUuid().equals(uuid) ||
							(peDummyEntity.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, peDummyEntity);
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
			return (PEDummyEntity)result;
		}
	}

	/**
	 * Removes the p e dummy entity where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the p e dummy entity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity removeByUUID_G(String uuid, long groupId)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = findByUUID_G(uuid, groupId);

		return remove(peDummyEntity);
	}

	/**
	 * Returns the number of p e dummy entities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching p e dummy entities
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

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "peDummyEntity.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "peDummyEntity.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(peDummyEntity.uuid IS NULL OR peDummyEntity.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "peDummyEntity.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PEDummyEntityModelImpl.UUID_COLUMN_BITMASK |
			PEDummyEntityModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @return the range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e dummy entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByUuid_C(String uuid, long companyId,
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

		List<PEDummyEntity> list = (List<PEDummyEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEDummyEntity peDummyEntity : list) {
				if (!Validator.equals(uuid, peDummyEntity.getUuid()) ||
						(companyId != peDummyEntity.getCompanyId())) {
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

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

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
				query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
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
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEDummyEntity>(list);
				}
				else {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the first p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEDummyEntity> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PEDummyEntity> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the p e dummy entities before and after the current p e dummy entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spPEDummyEntityId the primary key of the current p e dummy entity
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity[] findByUuid_C_PrevAndNext(long spPEDummyEntityId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = findByPrimaryKey(spPEDummyEntityId);

		Session session = null;

		try {
			session = openSession();

			PEDummyEntity[] array = new PEDummyEntityImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, peDummyEntity, uuid,
					companyId, orderByComparator, true);

			array[1] = peDummyEntity;

			array[2] = getByUuid_C_PrevAndNext(session, peDummyEntity, uuid,
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

	protected PEDummyEntity getByUuid_C_PrevAndNext(Session session,
		PEDummyEntity peDummyEntity, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

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
			query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(peDummyEntity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PEDummyEntity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the p e dummy entities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PEDummyEntity peDummyEntity : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peDummyEntity);
		}
	}

	/**
	 * Returns the number of p e dummy entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching p e dummy entities
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

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "peDummyEntity.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "peDummyEntity.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(peDummyEntity.uuid IS NULL OR peDummyEntity.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "peDummyEntity.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			PEDummyEntityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the p e dummy entity where name = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByName(String name)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByName(name);

		if (peDummyEntity == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPEDummyEntityException(msg.toString());
		}

		return peDummyEntity;
	}

	/**
	 * Returns the p e dummy entity where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the p e dummy entity where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof PEDummyEntity) {
			PEDummyEntity peDummyEntity = (PEDummyEntity)result;

			if (!Validator.equals(name, peDummyEntity.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
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

				List<PEDummyEntity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PEDummyEntityPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PEDummyEntity peDummyEntity = list.get(0);

					result = peDummyEntity;

					cacheResult(peDummyEntity);

					if ((peDummyEntity.getName() == null) ||
							!peDummyEntity.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, peDummyEntity);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (PEDummyEntity)result;
		}
	}

	/**
	 * Removes the p e dummy entity where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the p e dummy entity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity removeByName(String name)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = findByName(name);

		return remove(peDummyEntity);
	}

	/**
	 * Returns the number of p e dummy entities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "peDummyEntity.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "peDummyEntity.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(peDummyEntity.name IS NULL OR peDummyEntity.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYIDS =
		new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByentityIds",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYIDS =
		new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED,
			PEDummyEntityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByentityIds", new String[] { Long.class.getName() },
			PEDummyEntityModelImpl.SPPEDUMMYENTITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYIDS = new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByentityIds",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENTITYIDS =
		new FinderPath(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByentityIds",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the p e dummy entities where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @return the matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long spPEDummyEntityId)
		throws SystemException {
		return findByentityIds(spPEDummyEntityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e dummy entities where spPEDummyEntityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @return the range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long spPEDummyEntityId,
		int start, int end) throws SystemException {
		return findByentityIds(spPEDummyEntityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e dummy entities where spPEDummyEntityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long spPEDummyEntityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYIDS;
			finderArgs = new Object[] { spPEDummyEntityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYIDS;
			finderArgs = new Object[] {
					spPEDummyEntityId,
					
					start, end, orderByComparator
				};
		}

		List<PEDummyEntity> list = (List<PEDummyEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEDummyEntity peDummyEntity : list) {
				if ((spPEDummyEntityId != peDummyEntity.getSpPEDummyEntityId())) {
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

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

			query.append(_FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEDummyEntityId);

				if (!pagination) {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEDummyEntity>(list);
				}
				else {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByentityIds_First(long spPEDummyEntityId,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByentityIds_First(spPEDummyEntityId,
				orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEDummyEntityId=");
		msg.append(spPEDummyEntityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the first p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByentityIds_First(long spPEDummyEntityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PEDummyEntity> list = findByentityIds(spPEDummyEntityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByentityIds_Last(long spPEDummyEntityId,
		OrderByComparator orderByComparator)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByentityIds_Last(spPEDummyEntityId,
				orderByComparator);

		if (peDummyEntity != null) {
			return peDummyEntity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spPEDummyEntityId=");
		msg.append(spPEDummyEntityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPEDummyEntityException(msg.toString());
	}

	/**
	 * Returns the last p e dummy entity in the ordered set where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching p e dummy entity, or <code>null</code> if a matching p e dummy entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByentityIds_Last(long spPEDummyEntityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByentityIds(spPEDummyEntityId);

		if (count == 0) {
			return null;
		}

		List<PEDummyEntity> list = findByentityIds(spPEDummyEntityId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns all the p e dummy entities where spPEDummyEntityId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEDummyEntityIds the sp p e dummy entity IDs
	 * @return the matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long[] spPEDummyEntityIds)
		throws SystemException {
		return findByentityIds(spPEDummyEntityIds, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e dummy entities where spPEDummyEntityId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEDummyEntityIds the sp p e dummy entity IDs
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @return the range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long[] spPEDummyEntityIds,
		int start, int end) throws SystemException {
		return findByentityIds(spPEDummyEntityIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e dummy entities where spPEDummyEntityId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spPEDummyEntityIds the sp p e dummy entity IDs
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findByentityIds(long[] spPEDummyEntityIds,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if ((spPEDummyEntityIds != null) && (spPEDummyEntityIds.length == 1)) {
			return findByentityIds(spPEDummyEntityIds[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(spPEDummyEntityIds) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(spPEDummyEntityIds),
					
					start, end, orderByComparator
				};
		}

		List<PEDummyEntity> list = (List<PEDummyEntity>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYIDS,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PEDummyEntity peDummyEntity : list) {
				if (!ArrayUtil.contains(spPEDummyEntityIds,
							peDummyEntity.getSpPEDummyEntityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PEDUMMYENTITY_WHERE);

			boolean conjunctionable = false;

			if ((spPEDummyEntityIds == null) ||
					(spPEDummyEntityIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEDummyEntityIds.length; i++) {
					query.append(_FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_5);

					if ((i + 1) < spPEDummyEntityIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PEDummyEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEDummyEntityIds != null) {
					qPos.add(spPEDummyEntityIds);
				}

				if (!pagination) {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEDummyEntity>(list);
				}
				else {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYIDS,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_ENTITYIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the p e dummy entities where spPEDummyEntityId = &#63; from the database.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByentityIds(long spPEDummyEntityId)
		throws SystemException {
		for (PEDummyEntity peDummyEntity : findByentityIds(spPEDummyEntityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(peDummyEntity);
		}
	}

	/**
	 * Returns the number of p e dummy entities where spPEDummyEntityId = &#63;.
	 *
	 * @param spPEDummyEntityId the sp p e dummy entity ID
	 * @return the number of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByentityIds(long spPEDummyEntityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYIDS;

		Object[] finderArgs = new Object[] { spPEDummyEntityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

			query.append(_FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spPEDummyEntityId);

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

	/**
	 * Returns the number of p e dummy entities where spPEDummyEntityId = any &#63;.
	 *
	 * @param spPEDummyEntityIds the sp p e dummy entity IDs
	 * @return the number of matching p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByentityIds(long[] spPEDummyEntityIds)
		throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(spPEDummyEntityIds) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENTITYIDS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PEDUMMYENTITY_WHERE);

			boolean conjunctionable = false;

			if ((spPEDummyEntityIds == null) ||
					(spPEDummyEntityIds.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < spPEDummyEntityIds.length; i++) {
					query.append(_FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_5);

					if ((i + 1) < spPEDummyEntityIds.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (spPEDummyEntityIds != null) {
					qPos.add(spPEDummyEntityIds);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENTITYIDS,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ENTITYIDS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_2 = "peDummyEntity.spPEDummyEntityId = ?";
	private static final String _FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_5 = "(" +
		removeConjunction(_FINDER_COLUMN_ENTITYIDS_SPPEDUMMYENTITYID_2) + ")";

	public PEDummyEntityPersistenceImpl() {
		setModelClass(PEDummyEntity.class);
	}

	/**
	 * Caches the p e dummy entity in the entity cache if it is enabled.
	 *
	 * @param peDummyEntity the p e dummy entity
	 */
	@Override
	public void cacheResult(PEDummyEntity peDummyEntity) {
		EntityCacheUtil.putResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityImpl.class, peDummyEntity.getPrimaryKey(),
			peDummyEntity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { peDummyEntity.getUuid(), peDummyEntity.getGroupId() },
			peDummyEntity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { peDummyEntity.getName() }, peDummyEntity);

		peDummyEntity.resetOriginalValues();
	}

	/**
	 * Caches the p e dummy entities in the entity cache if it is enabled.
	 *
	 * @param peDummyEntities the p e dummy entities
	 */
	@Override
	public void cacheResult(List<PEDummyEntity> peDummyEntities) {
		for (PEDummyEntity peDummyEntity : peDummyEntities) {
			if (EntityCacheUtil.getResult(
						PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
						PEDummyEntityImpl.class, peDummyEntity.getPrimaryKey()) == null) {
				cacheResult(peDummyEntity);
			}
			else {
				peDummyEntity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all p e dummy entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PEDummyEntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PEDummyEntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the p e dummy entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PEDummyEntity peDummyEntity) {
		EntityCacheUtil.removeResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityImpl.class, peDummyEntity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(peDummyEntity);
	}

	@Override
	public void clearCache(List<PEDummyEntity> peDummyEntities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PEDummyEntity peDummyEntity : peDummyEntities) {
			EntityCacheUtil.removeResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
				PEDummyEntityImpl.class, peDummyEntity.getPrimaryKey());

			clearUniqueFindersCache(peDummyEntity);
		}
	}

	protected void cacheUniqueFindersCache(PEDummyEntity peDummyEntity) {
		if (peDummyEntity.isNew()) {
			Object[] args = new Object[] {
					peDummyEntity.getUuid(), peDummyEntity.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				peDummyEntity);

			args = new Object[] { peDummyEntity.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				peDummyEntity);
		}
		else {
			PEDummyEntityModelImpl peDummyEntityModelImpl = (PEDummyEntityModelImpl)peDummyEntity;

			if ((peDummyEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peDummyEntity.getUuid(), peDummyEntity.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					peDummyEntity);
			}

			if ((peDummyEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { peDummyEntity.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					peDummyEntity);
			}
		}
	}

	protected void clearUniqueFindersCache(PEDummyEntity peDummyEntity) {
		PEDummyEntityModelImpl peDummyEntityModelImpl = (PEDummyEntityModelImpl)peDummyEntity;

		Object[] args = new Object[] {
				peDummyEntity.getUuid(), peDummyEntity.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((peDummyEntityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					peDummyEntityModelImpl.getOriginalUuid(),
					peDummyEntityModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { peDummyEntity.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((peDummyEntityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { peDummyEntityModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new p e dummy entity with the primary key. Does not add the p e dummy entity to the database.
	 *
	 * @param spPEDummyEntityId the primary key for the new p e dummy entity
	 * @return the new p e dummy entity
	 */
	@Override
	public PEDummyEntity create(long spPEDummyEntityId) {
		PEDummyEntity peDummyEntity = new PEDummyEntityImpl();

		peDummyEntity.setNew(true);
		peDummyEntity.setPrimaryKey(spPEDummyEntityId);

		String uuid = PortalUUIDUtil.generate();

		peDummyEntity.setUuid(uuid);

		return peDummyEntity;
	}

	/**
	 * Removes the p e dummy entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spPEDummyEntityId the primary key of the p e dummy entity
	 * @return the p e dummy entity that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity remove(long spPEDummyEntityId)
		throws NoSuchPEDummyEntityException, SystemException {
		return remove((Serializable)spPEDummyEntityId);
	}

	/**
	 * Removes the p e dummy entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the p e dummy entity
	 * @return the p e dummy entity that was removed
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity remove(Serializable primaryKey)
		throws NoSuchPEDummyEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PEDummyEntity peDummyEntity = (PEDummyEntity)session.get(PEDummyEntityImpl.class,
					primaryKey);

			if (peDummyEntity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPEDummyEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(peDummyEntity);
		}
		catch (NoSuchPEDummyEntityException nsee) {
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
	protected PEDummyEntity removeImpl(PEDummyEntity peDummyEntity)
		throws SystemException {
		peDummyEntity = toUnwrappedModel(peDummyEntity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(peDummyEntity)) {
				peDummyEntity = (PEDummyEntity)session.get(PEDummyEntityImpl.class,
						peDummyEntity.getPrimaryKeyObj());
			}

			if (peDummyEntity != null) {
				session.delete(peDummyEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (peDummyEntity != null) {
			clearCache(peDummyEntity);
		}

		return peDummyEntity;
	}

	@Override
	public PEDummyEntity updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PEDummyEntity peDummyEntity)
		throws SystemException {
		peDummyEntity = toUnwrappedModel(peDummyEntity);

		boolean isNew = peDummyEntity.isNew();

		PEDummyEntityModelImpl peDummyEntityModelImpl = (PEDummyEntityModelImpl)peDummyEntity;

		if (Validator.isNull(peDummyEntity.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			peDummyEntity.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (peDummyEntity.isNew()) {
				session.save(peDummyEntity);

				peDummyEntity.setNew(false);
			}
			else {
				session.merge(peDummyEntity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PEDummyEntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((peDummyEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peDummyEntityModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { peDummyEntityModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((peDummyEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peDummyEntityModelImpl.getOriginalUuid(),
						peDummyEntityModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						peDummyEntityModelImpl.getUuid(),
						peDummyEntityModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((peDummyEntityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYIDS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						peDummyEntityModelImpl.getOriginalSpPEDummyEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYIDS,
					args);

				args = new Object[] {
						peDummyEntityModelImpl.getSpPEDummyEntityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYIDS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENTITYIDS,
					args);
			}
		}

		EntityCacheUtil.putResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
			PEDummyEntityImpl.class, peDummyEntity.getPrimaryKey(),
			peDummyEntity);

		clearUniqueFindersCache(peDummyEntity);
		cacheUniqueFindersCache(peDummyEntity);

		return peDummyEntity;
	}

	protected PEDummyEntity toUnwrappedModel(PEDummyEntity peDummyEntity) {
		if (peDummyEntity instanceof PEDummyEntityImpl) {
			return peDummyEntity;
		}

		PEDummyEntityImpl peDummyEntityImpl = new PEDummyEntityImpl();

		peDummyEntityImpl.setNew(peDummyEntity.isNew());
		peDummyEntityImpl.setPrimaryKey(peDummyEntity.getPrimaryKey());

		peDummyEntityImpl.setUuid(peDummyEntity.getUuid());
		peDummyEntityImpl.setSpPEDummyEntityId(peDummyEntity.getSpPEDummyEntityId());
		peDummyEntityImpl.setGroupId(peDummyEntity.getGroupId());
		peDummyEntityImpl.setCompanyId(peDummyEntity.getCompanyId());
		peDummyEntityImpl.setUserId(peDummyEntity.getUserId());
		peDummyEntityImpl.setUserName(peDummyEntity.getUserName());
		peDummyEntityImpl.setCreateDate(peDummyEntity.getCreateDate());
		peDummyEntityImpl.setModifiedDate(peDummyEntity.getModifiedDate());
		peDummyEntityImpl.setName(peDummyEntity.getName());

		return peDummyEntityImpl;
	}

	/**
	 * Returns the p e dummy entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e dummy entity
	 * @return the p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPEDummyEntityException, SystemException {
		PEDummyEntity peDummyEntity = fetchByPrimaryKey(primaryKey);

		if (peDummyEntity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPEDummyEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return peDummyEntity;
	}

	/**
	 * Returns the p e dummy entity with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException} if it could not be found.
	 *
	 * @param spPEDummyEntityId the primary key of the p e dummy entity
	 * @return the p e dummy entity
	 * @throws com.sambaash.platform.srv.processbuilder.NoSuchPEDummyEntityException if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity findByPrimaryKey(long spPEDummyEntityId)
		throws NoSuchPEDummyEntityException, SystemException {
		return findByPrimaryKey((Serializable)spPEDummyEntityId);
	}

	/**
	 * Returns the p e dummy entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the p e dummy entity
	 * @return the p e dummy entity, or <code>null</code> if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PEDummyEntity peDummyEntity = (PEDummyEntity)EntityCacheUtil.getResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
				PEDummyEntityImpl.class, primaryKey);

		if (peDummyEntity == _nullPEDummyEntity) {
			return null;
		}

		if (peDummyEntity == null) {
			Session session = null;

			try {
				session = openSession();

				peDummyEntity = (PEDummyEntity)session.get(PEDummyEntityImpl.class,
						primaryKey);

				if (peDummyEntity != null) {
					cacheResult(peDummyEntity);
				}
				else {
					EntityCacheUtil.putResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
						PEDummyEntityImpl.class, primaryKey, _nullPEDummyEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PEDummyEntityModelImpl.ENTITY_CACHE_ENABLED,
					PEDummyEntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return peDummyEntity;
	}

	/**
	 * Returns the p e dummy entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spPEDummyEntityId the primary key of the p e dummy entity
	 * @return the p e dummy entity, or <code>null</code> if a p e dummy entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PEDummyEntity fetchByPrimaryKey(long spPEDummyEntityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spPEDummyEntityId);
	}

	/**
	 * Returns all the p e dummy entities.
	 *
	 * @return the p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the p e dummy entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @return the range of p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the p e dummy entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PEDummyEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of p e dummy entities
	 * @param end the upper bound of the range of p e dummy entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of p e dummy entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PEDummyEntity> findAll(int start, int end,
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

		List<PEDummyEntity> list = (List<PEDummyEntity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PEDUMMYENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PEDUMMYENTITY;

				if (pagination) {
					sql = sql.concat(PEDummyEntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PEDummyEntity>(list);
				}
				else {
					list = (List<PEDummyEntity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the p e dummy entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PEDummyEntity peDummyEntity : findAll()) {
			remove(peDummyEntity);
		}
	}

	/**
	 * Returns the number of p e dummy entities.
	 *
	 * @return the number of p e dummy entities
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

				Query q = session.createQuery(_SQL_COUNT_PEDUMMYENTITY);

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
	 * Initializes the p e dummy entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.processbuilder.model.PEDummyEntity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PEDummyEntity>> listenersList = new ArrayList<ModelListener<PEDummyEntity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PEDummyEntity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PEDummyEntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PEDUMMYENTITY = "SELECT peDummyEntity FROM PEDummyEntity peDummyEntity";
	private static final String _SQL_SELECT_PEDUMMYENTITY_WHERE = "SELECT peDummyEntity FROM PEDummyEntity peDummyEntity WHERE ";
	private static final String _SQL_COUNT_PEDUMMYENTITY = "SELECT COUNT(peDummyEntity) FROM PEDummyEntity peDummyEntity";
	private static final String _SQL_COUNT_PEDUMMYENTITY_WHERE = "SELECT COUNT(peDummyEntity) FROM PEDummyEntity peDummyEntity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "peDummyEntity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PEDummyEntity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PEDummyEntity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PEDummyEntityPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PEDummyEntity _nullPEDummyEntity = new PEDummyEntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PEDummyEntity> toCacheModel() {
				return _nullPEDummyEntityCacheModel;
			}
		};

	private static CacheModel<PEDummyEntity> _nullPEDummyEntityCacheModel = new CacheModel<PEDummyEntity>() {
			@Override
			public PEDummyEntity toEntityModel() {
				return _nullPEDummyEntity;
			}
		};
}