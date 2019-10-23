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

package com.sambaash.platform.srv.legalandcontract.service.persistence;

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

import com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterImpl;
import com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the class master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see ClassMasterPersistence
 * @see ClassMasterUtil
 * @generated
 */
public class ClassMasterPersistenceImpl extends BasePersistenceImpl<ClassMaster>
	implements ClassMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ClassMasterUtil} to access the class master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ClassMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ClassMasterModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the class masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the class masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @return the range of matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the class masters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid(String uuid, int start, int end,
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

		List<ClassMaster> list = (List<ClassMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ClassMaster classMaster : list) {
				if (!Validator.equals(uuid, classMaster.getUuid())) {
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

			query.append(_SQL_SELECT_CLASSMASTER_WHERE);

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
				query.append(ClassMasterModelImpl.ORDER_BY_JPQL);
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
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClassMaster>(list);
				}
				else {
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first class master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByUuid_First(uuid, orderByComparator);

		if (classMaster != null) {
			return classMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClassMasterException(msg.toString());
	}

	/**
	 * Returns the first class master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ClassMaster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last class master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByUuid_Last(uuid, orderByComparator);

		if (classMaster != null) {
			return classMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClassMasterException(msg.toString());
	}

	/**
	 * Returns the last class master in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ClassMaster> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the class masters before and after the current class master in the ordered set where uuid = &#63;.
	 *
	 * @param spClassId the primary key of the current class master
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster[] findByUuid_PrevAndNext(long spClassId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = findByPrimaryKey(spClassId);

		Session session = null;

		try {
			session = openSession();

			ClassMaster[] array = new ClassMasterImpl[3];

			array[0] = getByUuid_PrevAndNext(session, classMaster, uuid,
					orderByComparator, true);

			array[1] = classMaster;

			array[2] = getByUuid_PrevAndNext(session, classMaster, uuid,
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

	protected ClassMaster getByUuid_PrevAndNext(Session session,
		ClassMaster classMaster, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLASSMASTER_WHERE);

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
			query.append(ClassMasterModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(classMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ClassMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the class masters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ClassMaster classMaster : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(classMaster);
		}
	}

	/**
	 * Returns the number of class masters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching class masters
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

			query.append(_SQL_COUNT_CLASSMASTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "classMaster.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "classMaster.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(classMaster.uuid IS NULL OR classMaster.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ClassMasterModelImpl.UUID_COLUMN_BITMASK |
			ClassMasterModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the class master where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByUUID_G(String uuid, long groupId)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByUUID_G(uuid, groupId);

		if (classMaster == null) {
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

			throw new NoSuchClassMasterException(msg.toString());
		}

		return classMaster;
	}

	/**
	 * Returns the class master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the class master where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ClassMaster) {
			ClassMaster classMaster = (ClassMaster)result;

			if (!Validator.equals(uuid, classMaster.getUuid()) ||
					(groupId != classMaster.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CLASSMASTER_WHERE);

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

				List<ClassMaster> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ClassMaster classMaster = list.get(0);

					result = classMaster;

					cacheResult(classMaster);

					if ((classMaster.getUuid() == null) ||
							!classMaster.getUuid().equals(uuid) ||
							(classMaster.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, classMaster);
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
			return (ClassMaster)result;
		}
	}

	/**
	 * Removes the class master where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the class master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster removeByUUID_G(String uuid, long groupId)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = findByUUID_G(uuid, groupId);

		return remove(classMaster);
	}

	/**
	 * Returns the number of class masters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching class masters
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

			query.append(_SQL_COUNT_CLASSMASTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "classMaster.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "classMaster.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(classMaster.uuid IS NULL OR classMaster.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "classMaster.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ClassMasterModelImpl.UUID_COLUMN_BITMASK |
			ClassMasterModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the class masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the class masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @return the range of matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the class masters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findByUuid_C(String uuid, long companyId,
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

		List<ClassMaster> list = (List<ClassMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ClassMaster classMaster : list) {
				if (!Validator.equals(uuid, classMaster.getUuid()) ||
						(companyId != classMaster.getCompanyId())) {
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

			query.append(_SQL_SELECT_CLASSMASTER_WHERE);

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
				query.append(ClassMasterModelImpl.ORDER_BY_JPQL);
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
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClassMaster>(list);
				}
				else {
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first class master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (classMaster != null) {
			return classMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClassMasterException(msg.toString());
	}

	/**
	 * Returns the first class master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ClassMaster> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last class master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (classMaster != null) {
			return classMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchClassMasterException(msg.toString());
	}

	/**
	 * Returns the last class master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ClassMaster> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the class masters before and after the current class master in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spClassId the primary key of the current class master
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster[] findByUuid_C_PrevAndNext(long spClassId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = findByPrimaryKey(spClassId);

		Session session = null;

		try {
			session = openSession();

			ClassMaster[] array = new ClassMasterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, classMaster, uuid,
					companyId, orderByComparator, true);

			array[1] = classMaster;

			array[2] = getByUuid_C_PrevAndNext(session, classMaster, uuid,
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

	protected ClassMaster getByUuid_C_PrevAndNext(Session session,
		ClassMaster classMaster, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLASSMASTER_WHERE);

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
			query.append(ClassMasterModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(classMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ClassMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the class masters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ClassMaster classMaster : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(classMaster);
		}
	}

	/**
	 * Returns the number of class masters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching class masters
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

			query.append(_SQL_COUNT_CLASSMASTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "classMaster.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "classMaster.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(classMaster.uuid IS NULL OR classMaster.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "classMaster.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODECOUNTRY = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, ClassMasterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeCountry",
			new String[] { String.class.getName(), String.class.getName() },
			ClassMasterModelImpl.CODE_COLUMN_BITMASK |
			ClassMasterModelImpl.COUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODECOUNTRY = new FinderPath(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeCountry",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the class master where code = &#63; and country = &#63; or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	 *
	 * @param code the code
	 * @param country the country
	 * @return the matching class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByCodeCountry(String code, String country)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByCodeCountry(code, country);

		if (classMaster == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(", country=");
			msg.append(country);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchClassMasterException(msg.toString());
		}

		return classMaster;
	}

	/**
	 * Returns the class master where code = &#63; and country = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param country the country
	 * @return the matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByCodeCountry(String code, String country)
		throws SystemException {
		return fetchByCodeCountry(code, country, true);
	}

	/**
	 * Returns the class master where code = &#63; and country = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param country the country
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching class master, or <code>null</code> if a matching class master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByCodeCountry(String code, String country,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { code, country };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
					finderArgs, this);
		}

		if (result instanceof ClassMaster) {
			ClassMaster classMaster = (ClassMaster)result;

			if (!Validator.equals(code, classMaster.getCode()) ||
					!Validator.equals(country, classMaster.getCountry())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CLASSMASTER_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (bindCountry) {
					qPos.add(country);
				}

				List<ClassMaster> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ClassMasterPersistenceImpl.fetchByCodeCountry(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ClassMaster classMaster = list.get(0);

					result = classMaster;

					cacheResult(classMaster);

					if ((classMaster.getCode() == null) ||
							!classMaster.getCode().equals(code) ||
							(classMaster.getCountry() == null) ||
							!classMaster.getCountry().equals(country)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
							finderArgs, classMaster);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
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
			return (ClassMaster)result;
		}
	}

	/**
	 * Removes the class master where code = &#63; and country = &#63; from the database.
	 *
	 * @param code the code
	 * @param country the country
	 * @return the class master that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster removeByCodeCountry(String code, String country)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = findByCodeCountry(code, country);

		return remove(classMaster);
	}

	/**
	 * Returns the number of class masters where code = &#63; and country = &#63;.
	 *
	 * @param code the code
	 * @param country the country
	 * @return the number of matching class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCodeCountry(String code, String country)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODECOUNTRY;

		Object[] finderArgs = new Object[] { code, country };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CLASSMASTER_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODECOUNTRY_CODE_2);
			}

			boolean bindCountry = false;

			if (country == null) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_1);
			}
			else if (country.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_3);
			}
			else {
				bindCountry = true;

				query.append(_FINDER_COLUMN_CODECOUNTRY_COUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				if (bindCountry) {
					qPos.add(country);
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

	private static final String _FINDER_COLUMN_CODECOUNTRY_CODE_1 = "classMaster.code IS NULL AND ";
	private static final String _FINDER_COLUMN_CODECOUNTRY_CODE_2 = "classMaster.code = ? AND ";
	private static final String _FINDER_COLUMN_CODECOUNTRY_CODE_3 = "(classMaster.code IS NULL OR classMaster.code = '') AND ";
	private static final String _FINDER_COLUMN_CODECOUNTRY_COUNTRY_1 = "classMaster.country IS NULL";
	private static final String _FINDER_COLUMN_CODECOUNTRY_COUNTRY_2 = "classMaster.country = ?";
	private static final String _FINDER_COLUMN_CODECOUNTRY_COUNTRY_3 = "(classMaster.country IS NULL OR classMaster.country = '')";

	public ClassMasterPersistenceImpl() {
		setModelClass(ClassMaster.class);
	}

	/**
	 * Caches the class master in the entity cache if it is enabled.
	 *
	 * @param classMaster the class master
	 */
	@Override
	public void cacheResult(ClassMaster classMaster) {
		EntityCacheUtil.putResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterImpl.class, classMaster.getPrimaryKey(), classMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { classMaster.getUuid(), classMaster.getGroupId() },
			classMaster);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
			new Object[] { classMaster.getCode(), classMaster.getCountry() },
			classMaster);

		classMaster.resetOriginalValues();
	}

	/**
	 * Caches the class masters in the entity cache if it is enabled.
	 *
	 * @param classMasters the class masters
	 */
	@Override
	public void cacheResult(List<ClassMaster> classMasters) {
		for (ClassMaster classMaster : classMasters) {
			if (EntityCacheUtil.getResult(
						ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
						ClassMasterImpl.class, classMaster.getPrimaryKey()) == null) {
				cacheResult(classMaster);
			}
			else {
				classMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all class masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ClassMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ClassMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the class master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClassMaster classMaster) {
		EntityCacheUtil.removeResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterImpl.class, classMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(classMaster);
	}

	@Override
	public void clearCache(List<ClassMaster> classMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ClassMaster classMaster : classMasters) {
			EntityCacheUtil.removeResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
				ClassMasterImpl.class, classMaster.getPrimaryKey());

			clearUniqueFindersCache(classMaster);
		}
	}

	protected void cacheUniqueFindersCache(ClassMaster classMaster) {
		if (classMaster.isNew()) {
			Object[] args = new Object[] {
					classMaster.getUuid(), classMaster.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				classMaster);

			args = new Object[] { classMaster.getCode(), classMaster.getCountry() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODECOUNTRY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODECOUNTRY, args,
				classMaster);
		}
		else {
			ClassMasterModelImpl classMasterModelImpl = (ClassMasterModelImpl)classMaster;

			if ((classMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						classMaster.getUuid(), classMaster.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					classMaster);
			}

			if ((classMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODECOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						classMaster.getCode(), classMaster.getCountry()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODECOUNTRY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODECOUNTRY,
					args, classMaster);
			}
		}
	}

	protected void clearUniqueFindersCache(ClassMaster classMaster) {
		ClassMasterModelImpl classMasterModelImpl = (ClassMasterModelImpl)classMaster;

		Object[] args = new Object[] {
				classMaster.getUuid(), classMaster.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((classMasterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					classMasterModelImpl.getOriginalUuid(),
					classMasterModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { classMaster.getCode(), classMaster.getCountry() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODECOUNTRY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODECOUNTRY, args);

		if ((classMasterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODECOUNTRY.getColumnBitmask()) != 0) {
			args = new Object[] {
					classMasterModelImpl.getOriginalCode(),
					classMasterModelImpl.getOriginalCountry()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODECOUNTRY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODECOUNTRY, args);
		}
	}

	/**
	 * Creates a new class master with the primary key. Does not add the class master to the database.
	 *
	 * @param spClassId the primary key for the new class master
	 * @return the new class master
	 */
	@Override
	public ClassMaster create(long spClassId) {
		ClassMaster classMaster = new ClassMasterImpl();

		classMaster.setNew(true);
		classMaster.setPrimaryKey(spClassId);

		String uuid = PortalUUIDUtil.generate();

		classMaster.setUuid(uuid);

		return classMaster;
	}

	/**
	 * Removes the class master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spClassId the primary key of the class master
	 * @return the class master that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster remove(long spClassId)
		throws NoSuchClassMasterException, SystemException {
		return remove((Serializable)spClassId);
	}

	/**
	 * Removes the class master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the class master
	 * @return the class master that was removed
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster remove(Serializable primaryKey)
		throws NoSuchClassMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ClassMaster classMaster = (ClassMaster)session.get(ClassMasterImpl.class,
					primaryKey);

			if (classMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClassMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(classMaster);
		}
		catch (NoSuchClassMasterException nsee) {
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
	protected ClassMaster removeImpl(ClassMaster classMaster)
		throws SystemException {
		classMaster = toUnwrappedModel(classMaster);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(classMaster)) {
				classMaster = (ClassMaster)session.get(ClassMasterImpl.class,
						classMaster.getPrimaryKeyObj());
			}

			if (classMaster != null) {
				session.delete(classMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (classMaster != null) {
			clearCache(classMaster);
		}

		return classMaster;
	}

	@Override
	public ClassMaster updateImpl(
		com.sambaash.platform.srv.legalandcontract.model.ClassMaster classMaster)
		throws SystemException {
		classMaster = toUnwrappedModel(classMaster);

		boolean isNew = classMaster.isNew();

		ClassMasterModelImpl classMasterModelImpl = (ClassMasterModelImpl)classMaster;

		if (Validator.isNull(classMaster.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			classMaster.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (classMaster.isNew()) {
				session.save(classMaster);

				classMaster.setNew(false);
			}
			else {
				session.merge(classMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ClassMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((classMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						classMasterModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { classMasterModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((classMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						classMasterModelImpl.getOriginalUuid(),
						classMasterModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						classMasterModelImpl.getUuid(),
						classMasterModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		EntityCacheUtil.putResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
			ClassMasterImpl.class, classMaster.getPrimaryKey(), classMaster);

		clearUniqueFindersCache(classMaster);
		cacheUniqueFindersCache(classMaster);

		return classMaster;
	}

	protected ClassMaster toUnwrappedModel(ClassMaster classMaster) {
		if (classMaster instanceof ClassMasterImpl) {
			return classMaster;
		}

		ClassMasterImpl classMasterImpl = new ClassMasterImpl();

		classMasterImpl.setNew(classMaster.isNew());
		classMasterImpl.setPrimaryKey(classMaster.getPrimaryKey());

		classMasterImpl.setUuid(classMaster.getUuid());
		classMasterImpl.setSpClassId(classMaster.getSpClassId());
		classMasterImpl.setGroupId(classMaster.getGroupId());
		classMasterImpl.setCompanyId(classMaster.getCompanyId());
		classMasterImpl.setUserId(classMaster.getUserId());
		classMasterImpl.setUserName(classMaster.getUserName());
		classMasterImpl.setCreateDate(classMaster.getCreateDate());
		classMasterImpl.setModifiedDate(classMaster.getModifiedDate());
		classMasterImpl.setCode(classMaster.getCode());
		classMasterImpl.setCountry(classMaster.getCountry());
		classMasterImpl.setFiledBy(classMaster.getFiledBy());
		classMasterImpl.setCustomField1(classMaster.getCustomField1());
		classMasterImpl.setCustomField2(classMaster.getCustomField2());
		classMasterImpl.setCustomDate1(classMaster.getCustomDate1());
		classMasterImpl.setCustomDate2(classMaster.getCustomDate2());
		classMasterImpl.setVersion(classMaster.getVersion());
		classMasterImpl.setRootSpClassId(classMaster.getRootSpClassId());

		return classMasterImpl;
	}

	/**
	 * Returns the class master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the class master
	 * @return the class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClassMasterException, SystemException {
		ClassMaster classMaster = fetchByPrimaryKey(primaryKey);

		if (classMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClassMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return classMaster;
	}

	/**
	 * Returns the class master with the primary key or throws a {@link com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException} if it could not be found.
	 *
	 * @param spClassId the primary key of the class master
	 * @return the class master
	 * @throws com.sambaash.platform.srv.legalandcontract.NoSuchClassMasterException if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster findByPrimaryKey(long spClassId)
		throws NoSuchClassMasterException, SystemException {
		return findByPrimaryKey((Serializable)spClassId);
	}

	/**
	 * Returns the class master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the class master
	 * @return the class master, or <code>null</code> if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ClassMaster classMaster = (ClassMaster)EntityCacheUtil.getResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
				ClassMasterImpl.class, primaryKey);

		if (classMaster == _nullClassMaster) {
			return null;
		}

		if (classMaster == null) {
			Session session = null;

			try {
				session = openSession();

				classMaster = (ClassMaster)session.get(ClassMasterImpl.class,
						primaryKey);

				if (classMaster != null) {
					cacheResult(classMaster);
				}
				else {
					EntityCacheUtil.putResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
						ClassMasterImpl.class, primaryKey, _nullClassMaster);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ClassMasterModelImpl.ENTITY_CACHE_ENABLED,
					ClassMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return classMaster;
	}

	/**
	 * Returns the class master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spClassId the primary key of the class master
	 * @return the class master, or <code>null</code> if a class master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ClassMaster fetchByPrimaryKey(long spClassId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spClassId);
	}

	/**
	 * Returns all the class masters.
	 *
	 * @return the class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the class masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @return the range of class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the class masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.legalandcontract.model.impl.ClassMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of class masters
	 * @param end the upper bound of the range of class masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of class masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ClassMaster> findAll(int start, int end,
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

		List<ClassMaster> list = (List<ClassMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CLASSMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLASSMASTER;

				if (pagination) {
					sql = sql.concat(ClassMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ClassMaster>(list);
				}
				else {
					list = (List<ClassMaster>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the class masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ClassMaster classMaster : findAll()) {
			remove(classMaster);
		}
	}

	/**
	 * Returns the number of class masters.
	 *
	 * @return the number of class masters
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

				Query q = session.createQuery(_SQL_COUNT_CLASSMASTER);

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
	 * Initializes the class master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.legalandcontract.model.ClassMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ClassMaster>> listenersList = new ArrayList<ModelListener<ClassMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ClassMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ClassMasterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CLASSMASTER = "SELECT classMaster FROM ClassMaster classMaster";
	private static final String _SQL_SELECT_CLASSMASTER_WHERE = "SELECT classMaster FROM ClassMaster classMaster WHERE ";
	private static final String _SQL_COUNT_CLASSMASTER = "SELECT COUNT(classMaster) FROM ClassMaster classMaster";
	private static final String _SQL_COUNT_CLASSMASTER_WHERE = "SELECT COUNT(classMaster) FROM ClassMaster classMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "classMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ClassMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ClassMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ClassMasterPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static ClassMaster _nullClassMaster = new ClassMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ClassMaster> toCacheModel() {
				return _nullClassMasterCacheModel;
			}
		};

	private static CacheModel<ClassMaster> _nullClassMasterCacheModel = new CacheModel<ClassMaster>() {
			@Override
			public ClassMaster toEntityModel() {
				return _nullClassMaster;
			}
		};
}