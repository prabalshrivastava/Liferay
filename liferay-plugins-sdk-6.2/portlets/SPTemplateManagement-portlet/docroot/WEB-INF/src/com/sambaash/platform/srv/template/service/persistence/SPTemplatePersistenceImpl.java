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

package com.sambaash.platform.srv.template.service.persistence;

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

import com.sambaash.platform.srv.template.NoSuchSPTemplateException;
import com.sambaash.platform.srv.template.model.SPTemplate;
import com.sambaash.platform.srv.template.model.impl.SPTemplateImpl;
import com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author WattabyteIT
 * @see SPTemplatePersistence
 * @see SPTemplateUtil
 * @generated
 */
public class SPTemplatePersistenceImpl extends BasePersistenceImpl<SPTemplate>
	implements SPTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPTemplateUtil} to access the s p template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPTemplateModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p templates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p templates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @return the range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p templates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid(String uuid, int start, int end,
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

		List<SPTemplate> list = (List<SPTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPTemplate spTemplate : list) {
				if (!Validator.equals(uuid, spTemplate.getUuid())) {
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

			query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

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
				query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPTemplate>(list);
				}
				else {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByUuid_First(uuid, orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPTemplate> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByUuid_Last(uuid, orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPTemplate> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p templates before and after the current s p template in the ordered set where uuid = &#63;.
	 *
	 * @param spTemplateId the primary key of the current s p template
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate[] findByUuid_PrevAndNext(long spTemplateId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = findByPrimaryKey(spTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPTemplate[] array = new SPTemplateImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spTemplate, uuid,
					orderByComparator, true);

			array[1] = spTemplate;

			array[2] = getByUuid_PrevAndNext(session, spTemplate, uuid,
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

	protected SPTemplate getByUuid_PrevAndNext(Session session,
		SPTemplate spTemplate, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

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
			query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p templates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPTemplate spTemplate : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spTemplate);
		}
	}

	/**
	 * Returns the number of s p templates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p templates
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

			query.append(_SQL_COUNT_SPTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spTemplate.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spTemplate.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spTemplate.uuid IS NULL OR spTemplate.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPTemplateModelImpl.UUID_COLUMN_BITMASK |
			SPTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p template where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.template.NoSuchSPTemplateException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByUUID_G(String uuid, long groupId)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByUUID_G(uuid, groupId);

		if (spTemplate == null) {
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

			throw new NoSuchSPTemplateException(msg.toString());
		}

		return spTemplate;
	}

	/**
	 * Returns the s p template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPTemplate) {
			SPTemplate spTemplate = (SPTemplate)result;

			if (!Validator.equals(uuid, spTemplate.getUuid()) ||
					(groupId != spTemplate.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

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

				List<SPTemplate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPTemplate spTemplate = list.get(0);

					result = spTemplate;

					cacheResult(spTemplate);

					if ((spTemplate.getUuid() == null) ||
							!spTemplate.getUuid().equals(uuid) ||
							(spTemplate.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spTemplate);
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
			return (SPTemplate)result;
		}
	}

	/**
	 * Removes the s p template where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = findByUUID_G(uuid, groupId);

		return remove(spTemplate);
	}

	/**
	 * Returns the number of s p templates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p templates
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

			query.append(_SQL_COUNT_SPTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spTemplate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spTemplate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spTemplate.uuid IS NULL OR spTemplate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spTemplate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPTemplateModelImpl.UUID_COLUMN_BITMASK |
			SPTemplateModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p templates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p templates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @return the range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p templates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByUuid_C(String uuid, long companyId,
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

		List<SPTemplate> list = (List<SPTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPTemplate spTemplate : list) {
				if (!Validator.equals(uuid, spTemplate.getUuid()) ||
						(companyId != spTemplate.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

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
				query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPTemplate>(list);
				}
				else {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPTemplate> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPTemplate> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p templates before and after the current s p template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spTemplateId the primary key of the current s p template
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate[] findByUuid_C_PrevAndNext(long spTemplateId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = findByPrimaryKey(spTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPTemplate[] array = new SPTemplateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spTemplate, uuid,
					companyId, orderByComparator, true);

			array[1] = spTemplate;

			array[2] = getByUuid_C_PrevAndNext(session, spTemplate, uuid,
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

	protected SPTemplate getByUuid_C_PrevAndNext(Session session,
		SPTemplate spTemplate, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

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
			query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p templates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPTemplate spTemplate : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spTemplate);
		}
	}

	/**
	 * Returns the number of s p templates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p templates
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

			query.append(_SQL_COUNT_SPTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spTemplate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spTemplate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spTemplate.uuid IS NULL OR spTemplate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spTemplate.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATENAME =
		new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME =
		new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, SPTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateName",
			new String[] { String.class.getName() },
			SPTemplateModelImpl.TEMPLATENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATENAME = new FinderPath(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p templates where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByTemplateName(String templateName)
		throws SystemException {
		return findByTemplateName(templateName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p templates where templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @return the range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByTemplateName(String templateName, int start,
		int end) throws SystemException {
		return findByTemplateName(templateName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p templates where templateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateName the template name
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findByTemplateName(String templateName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME;
			finderArgs = new Object[] { templateName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATENAME;
			finderArgs = new Object[] {
					templateName,
					
					start, end, orderByComparator
				};
		}

		List<SPTemplate> list = (List<SPTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPTemplate spTemplate : list) {
				if (!Validator.equals(templateName, spTemplate.getTemplateName())) {
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

			query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
				}

				if (!pagination) {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPTemplate>(list);
				}
				else {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByTemplateName_First(String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByTemplateName_First(templateName,
				orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByTemplateName_First(String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPTemplate> list = findByTemplateName(templateName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByTemplateName_Last(String templateName,
		OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByTemplateName_Last(templateName,
				orderByComparator);

		if (spTemplate != null) {
			return spTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateName=");
		msg.append(templateName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p template in the ordered set where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p template, or <code>null</code> if a matching s p template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByTemplateName_Last(String templateName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateName(templateName);

		if (count == 0) {
			return null;
		}

		List<SPTemplate> list = findByTemplateName(templateName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p templates before and after the current s p template in the ordered set where templateName = &#63;.
	 *
	 * @param spTemplateId the primary key of the current s p template
	 * @param templateName the template name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate[] findByTemplateName_PrevAndNext(long spTemplateId,
		String templateName, OrderByComparator orderByComparator)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = findByPrimaryKey(spTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPTemplate[] array = new SPTemplateImpl[3];

			array[0] = getByTemplateName_PrevAndNext(session, spTemplate,
					templateName, orderByComparator, true);

			array[1] = spTemplate;

			array[2] = getByTemplateName_PrevAndNext(session, spTemplate,
					templateName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPTemplate getByTemplateName_PrevAndNext(Session session,
		SPTemplate spTemplate, String templateName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPTEMPLATE_WHERE);

		boolean bindTemplateName = false;

		if (templateName == null) {
			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
		}
		else if (templateName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
		}
		else {
			bindTemplateName = true;

			query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
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
			query.append(SPTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTemplateName) {
			qPos.add(templateName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p templates where templateName = &#63; from the database.
	 *
	 * @param templateName the template name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateName(String templateName)
		throws SystemException {
		for (SPTemplate spTemplate : findByTemplateName(templateName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spTemplate);
		}
	}

	/**
	 * Returns the number of s p templates where templateName = &#63;.
	 *
	 * @param templateName the template name
	 * @return the number of matching s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateName(String templateName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATENAME;

		Object[] finderArgs = new Object[] { templateName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPTEMPLATE_WHERE);

			boolean bindTemplateName = false;

			if (templateName == null) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1);
			}
			else if (templateName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3);
			}
			else {
				bindTemplateName = true;

				query.append(_FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTemplateName) {
					qPos.add(templateName);
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

	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_1 = "spTemplate.templateName IS NULL";
	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_2 = "spTemplate.templateName = ?";
	private static final String _FINDER_COLUMN_TEMPLATENAME_TEMPLATENAME_3 = "(spTemplate.templateName IS NULL OR spTemplate.templateName = '')";

	public SPTemplatePersistenceImpl() {
		setModelClass(SPTemplate.class);
	}

	/**
	 * Caches the s p template in the entity cache if it is enabled.
	 *
	 * @param spTemplate the s p template
	 */
	@Override
	public void cacheResult(SPTemplate spTemplate) {
		EntityCacheUtil.putResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateImpl.class, spTemplate.getPrimaryKey(), spTemplate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { spTemplate.getUuid(), spTemplate.getGroupId() },
			spTemplate);

		spTemplate.resetOriginalValues();
	}

	/**
	 * Caches the s p templates in the entity cache if it is enabled.
	 *
	 * @param spTemplates the s p templates
	 */
	@Override
	public void cacheResult(List<SPTemplate> spTemplates) {
		for (SPTemplate spTemplate : spTemplates) {
			if (EntityCacheUtil.getResult(
						SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPTemplateImpl.class, spTemplate.getPrimaryKey()) == null) {
				cacheResult(spTemplate);
			}
			else {
				spTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPTemplate spTemplate) {
		EntityCacheUtil.removeResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateImpl.class, spTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spTemplate);
	}

	@Override
	public void clearCache(List<SPTemplate> spTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPTemplate spTemplate : spTemplates) {
			EntityCacheUtil.removeResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPTemplateImpl.class, spTemplate.getPrimaryKey());

			clearUniqueFindersCache(spTemplate);
		}
	}

	protected void cacheUniqueFindersCache(SPTemplate spTemplate) {
		if (spTemplate.isNew()) {
			Object[] args = new Object[] {
					spTemplate.getUuid(), spTemplate.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spTemplate);
		}
		else {
			SPTemplateModelImpl spTemplateModelImpl = (SPTemplateModelImpl)spTemplate;

			if ((spTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spTemplate.getUuid(), spTemplate.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spTemplate);
			}
		}
	}

	protected void clearUniqueFindersCache(SPTemplate spTemplate) {
		SPTemplateModelImpl spTemplateModelImpl = (SPTemplateModelImpl)spTemplate;

		Object[] args = new Object[] {
				spTemplate.getUuid(), spTemplate.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spTemplateModelImpl.getOriginalUuid(),
					spTemplateModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p template with the primary key. Does not add the s p template to the database.
	 *
	 * @param spTemplateId the primary key for the new s p template
	 * @return the new s p template
	 */
	@Override
	public SPTemplate create(long spTemplateId) {
		SPTemplate spTemplate = new SPTemplateImpl();

		spTemplate.setNew(true);
		spTemplate.setPrimaryKey(spTemplateId);

		String uuid = PortalUUIDUtil.generate();

		spTemplate.setUuid(uuid);

		return spTemplate;
	}

	/**
	 * Removes the s p template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spTemplateId the primary key of the s p template
	 * @return the s p template that was removed
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate remove(long spTemplateId)
		throws NoSuchSPTemplateException, SystemException {
		return remove((Serializable)spTemplateId);
	}

	/**
	 * Removes the s p template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p template
	 * @return the s p template that was removed
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate remove(Serializable primaryKey)
		throws NoSuchSPTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPTemplate spTemplate = (SPTemplate)session.get(SPTemplateImpl.class,
					primaryKey);

			if (spTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spTemplate);
		}
		catch (NoSuchSPTemplateException nsee) {
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
	protected SPTemplate removeImpl(SPTemplate spTemplate)
		throws SystemException {
		spTemplate = toUnwrappedModel(spTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spTemplate)) {
				spTemplate = (SPTemplate)session.get(SPTemplateImpl.class,
						spTemplate.getPrimaryKeyObj());
			}

			if (spTemplate != null) {
				session.delete(spTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spTemplate != null) {
			clearCache(spTemplate);
		}

		return spTemplate;
	}

	@Override
	public SPTemplate updateImpl(
		com.sambaash.platform.srv.template.model.SPTemplate spTemplate)
		throws SystemException {
		spTemplate = toUnwrappedModel(spTemplate);

		boolean isNew = spTemplate.isNew();

		SPTemplateModelImpl spTemplateModelImpl = (SPTemplateModelImpl)spTemplate;

		if (Validator.isNull(spTemplate.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spTemplate.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spTemplate.isNew()) {
				session.save(spTemplate);

				spTemplate.setNew(false);
			}
			else {
				session.merge(spTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spTemplateModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spTemplateModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spTemplateModelImpl.getOriginalUuid(),
						spTemplateModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spTemplateModelImpl.getUuid(),
						spTemplateModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spTemplateModelImpl.getOriginalTemplateName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME,
					args);

				args = new Object[] { spTemplateModelImpl.getTemplateName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATENAME,
					args);
			}
		}

		EntityCacheUtil.putResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPTemplateImpl.class, spTemplate.getPrimaryKey(), spTemplate);

		clearUniqueFindersCache(spTemplate);
		cacheUniqueFindersCache(spTemplate);

		return spTemplate;
	}

	protected SPTemplate toUnwrappedModel(SPTemplate spTemplate) {
		if (spTemplate instanceof SPTemplateImpl) {
			return spTemplate;
		}

		SPTemplateImpl spTemplateImpl = new SPTemplateImpl();

		spTemplateImpl.setNew(spTemplate.isNew());
		spTemplateImpl.setPrimaryKey(spTemplate.getPrimaryKey());

		spTemplateImpl.setUuid(spTemplate.getUuid());
		spTemplateImpl.setSpTemplateId(spTemplate.getSpTemplateId());
		spTemplateImpl.setGroupId(spTemplate.getGroupId());
		spTemplateImpl.setCompanyId(spTemplate.getCompanyId());
		spTemplateImpl.setUserId(spTemplate.getUserId());
		spTemplateImpl.setUserName(spTemplate.getUserName());
		spTemplateImpl.setCreateDate(spTemplate.getCreateDate());
		spTemplateImpl.setModifiedDate(spTemplate.getModifiedDate());
		spTemplateImpl.setCreateBy(spTemplate.getCreateBy());
		spTemplateImpl.setModifiedBy(spTemplate.getModifiedBy());
		spTemplateImpl.setClassNameId(spTemplate.getClassNameId());
		spTemplateImpl.setClassPK(spTemplate.getClassPK());
		spTemplateImpl.setTemplateName(spTemplate.getTemplateName());
		spTemplateImpl.setStatus(spTemplate.getStatus());

		return spTemplateImpl;
	}

	/**
	 * Returns the s p template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p template
	 * @return the s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPTemplateException, SystemException {
		SPTemplate spTemplate = fetchByPrimaryKey(primaryKey);

		if (spTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spTemplate;
	}

	/**
	 * Returns the s p template with the primary key or throws a {@link com.sambaash.platform.srv.template.NoSuchSPTemplateException} if it could not be found.
	 *
	 * @param spTemplateId the primary key of the s p template
	 * @return the s p template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPTemplateException if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate findByPrimaryKey(long spTemplateId)
		throws NoSuchSPTemplateException, SystemException {
		return findByPrimaryKey((Serializable)spTemplateId);
	}

	/**
	 * Returns the s p template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p template
	 * @return the s p template, or <code>null</code> if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPTemplate spTemplate = (SPTemplate)EntityCacheUtil.getResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPTemplateImpl.class, primaryKey);

		if (spTemplate == _nullSPTemplate) {
			return null;
		}

		if (spTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				spTemplate = (SPTemplate)session.get(SPTemplateImpl.class,
						primaryKey);

				if (spTemplate != null) {
					cacheResult(spTemplate);
				}
				else {
					EntityCacheUtil.putResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPTemplateImpl.class, primaryKey, _nullSPTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPTemplateModelImpl.ENTITY_CACHE_ENABLED,
					SPTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spTemplate;
	}

	/**
	 * Returns the s p template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spTemplateId the primary key of the s p template
	 * @return the s p template, or <code>null</code> if a s p template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPTemplate fetchByPrimaryKey(long spTemplateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spTemplateId);
	}

	/**
	 * Returns all the s p templates.
	 *
	 * @return the s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @return the range of s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p templates
	 * @param end the upper bound of the range of s p templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPTemplate> findAll(int start, int end,
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

		List<SPTemplate> list = (List<SPTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPTEMPLATE;

				if (pagination) {
					sql = sql.concat(SPTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPTemplate>(list);
				}
				else {
					list = (List<SPTemplate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPTemplate spTemplate : findAll()) {
			remove(spTemplate);
		}
	}

	/**
	 * Returns the number of s p templates.
	 *
	 * @return the number of s p templates
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

				Query q = session.createQuery(_SQL_COUNT_SPTEMPLATE);

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
	 * Initializes the s p template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.template.model.SPTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPTemplate>> listenersList = new ArrayList<ModelListener<SPTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPTEMPLATE = "SELECT spTemplate FROM SPTemplate spTemplate";
	private static final String _SQL_SELECT_SPTEMPLATE_WHERE = "SELECT spTemplate FROM SPTemplate spTemplate WHERE ";
	private static final String _SQL_COUNT_SPTEMPLATE = "SELECT COUNT(spTemplate) FROM SPTemplate spTemplate";
	private static final String _SQL_COUNT_SPTEMPLATE_WHERE = "SELECT COUNT(spTemplate) FROM SPTemplate spTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPTemplate _nullSPTemplate = new SPTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPTemplate> toCacheModel() {
				return _nullSPTemplateCacheModel;
			}
		};

	private static CacheModel<SPTemplate> _nullSPTemplateCacheModel = new CacheModel<SPTemplate>() {
			@Override
			public SPTemplate toEntityModel() {
				return _nullSPTemplate;
			}
		};
}