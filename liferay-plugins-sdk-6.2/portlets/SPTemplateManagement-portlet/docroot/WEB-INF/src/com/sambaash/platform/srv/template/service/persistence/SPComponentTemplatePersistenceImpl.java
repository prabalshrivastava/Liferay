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

import com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException;
import com.sambaash.platform.srv.template.model.SPComponentTemplate;
import com.sambaash.platform.srv.template.model.impl.SPComponentTemplateImpl;
import com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p component template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author WattabyteIT
 * @see SPComponentTemplatePersistence
 * @see SPComponentTemplateUtil
 * @generated
 */
public class SPComponentTemplatePersistenceImpl extends BasePersistenceImpl<SPComponentTemplate>
	implements SPComponentTemplatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPComponentTemplateUtil} to access the s p component template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPComponentTemplateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SPComponentTemplateModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p component templates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p component templates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @return the range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p component templates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<SPComponentTemplate> list = (List<SPComponentTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPComponentTemplate spComponentTemplate : list) {
				if (!Validator.equals(uuid, spComponentTemplate.getUuid())) {
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

			query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

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
				query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPComponentTemplate>(list);
				}
				else {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p component template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByUuid_First(uuid,
				orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p component template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPComponentTemplate> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p component template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByUuid_Last(uuid,
				orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p component template in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SPComponentTemplate> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p component templates before and after the current s p component template in the ordered set where uuid = &#63;.
	 *
	 * @param spComponentTemplateId the primary key of the current s p component template
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate[] findByUuid_PrevAndNext(
		long spComponentTemplateId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = findByPrimaryKey(spComponentTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPComponentTemplate[] array = new SPComponentTemplateImpl[3];

			array[0] = getByUuid_PrevAndNext(session, spComponentTemplate,
					uuid, orderByComparator, true);

			array[1] = spComponentTemplate;

			array[2] = getByUuid_PrevAndNext(session, spComponentTemplate,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPComponentTemplate getByUuid_PrevAndNext(Session session,
		SPComponentTemplate spComponentTemplate, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

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
			query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spComponentTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPComponentTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p component templates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SPComponentTemplate spComponentTemplate : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spComponentTemplate);
		}
	}

	/**
	 * Returns the number of s p component templates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching s p component templates
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

			query.append(_SQL_COUNT_SPCOMPONENTTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "spComponentTemplate.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "spComponentTemplate.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(spComponentTemplate.uuid IS NULL OR spComponentTemplate.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SPComponentTemplateModelImpl.UUID_COLUMN_BITMASK |
			SPComponentTemplateModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p component template where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByUUID_G(String uuid, long groupId)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByUUID_G(uuid, groupId);

		if (spComponentTemplate == null) {
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

			throw new NoSuchSPComponentTemplateException(msg.toString());
		}

		return spComponentTemplate;
	}

	/**
	 * Returns the s p component template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the s p component template where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SPComponentTemplate) {
			SPComponentTemplate spComponentTemplate = (SPComponentTemplate)result;

			if (!Validator.equals(uuid, spComponentTemplate.getUuid()) ||
					(groupId != spComponentTemplate.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

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

				List<SPComponentTemplate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SPComponentTemplate spComponentTemplate = list.get(0);

					result = spComponentTemplate;

					cacheResult(spComponentTemplate);

					if ((spComponentTemplate.getUuid() == null) ||
							!spComponentTemplate.getUuid().equals(uuid) ||
							(spComponentTemplate.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, spComponentTemplate);
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
			return (SPComponentTemplate)result;
		}
	}

	/**
	 * Removes the s p component template where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the s p component template that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate removeByUUID_G(String uuid, long groupId)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = findByUUID_G(uuid, groupId);

		return remove(spComponentTemplate);
	}

	/**
	 * Returns the number of s p component templates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching s p component templates
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

			query.append(_SQL_COUNT_SPCOMPONENTTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "spComponentTemplate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "spComponentTemplate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(spComponentTemplate.uuid IS NULL OR spComponentTemplate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "spComponentTemplate.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SPComponentTemplateModelImpl.UUID_COLUMN_BITMASK |
			SPComponentTemplateModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p component templates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p component templates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @return the range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p component templates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByUuid_C(String uuid, long companyId,
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

		List<SPComponentTemplate> list = (List<SPComponentTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPComponentTemplate spComponentTemplate : list) {
				if (!Validator.equals(uuid, spComponentTemplate.getUuid()) ||
						(companyId != spComponentTemplate.getCompanyId())) {
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

			query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

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
				query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
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
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPComponentTemplate>(list);
				}
				else {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPComponentTemplate> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SPComponentTemplate> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p component templates before and after the current s p component template in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param spComponentTemplateId the primary key of the current s p component template
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate[] findByUuid_C_PrevAndNext(
		long spComponentTemplateId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = findByPrimaryKey(spComponentTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPComponentTemplate[] array = new SPComponentTemplateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, spComponentTemplate,
					uuid, companyId, orderByComparator, true);

			array[1] = spComponentTemplate;

			array[2] = getByUuid_C_PrevAndNext(session, spComponentTemplate,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPComponentTemplate getByUuid_C_PrevAndNext(Session session,
		SPComponentTemplate spComponentTemplate, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

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
			query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(spComponentTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPComponentTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p component templates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SPComponentTemplate spComponentTemplate : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spComponentTemplate);
		}
	}

	/**
	 * Returns the number of s p component templates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching s p component templates
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

			query.append(_SQL_COUNT_SPCOMPONENTTEMPLATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "spComponentTemplate.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "spComponentTemplate.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(spComponentTemplate.uuid IS NULL OR spComponentTemplate.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "spComponentTemplate.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED,
			SPComponentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			SPComponentTemplateModelImpl.SPTEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p component templates where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @return the matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByTemplateId(long spTemplateId)
		throws SystemException {
		return findByTemplateId(spTemplateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p component templates where spTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spTemplateId the sp template ID
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @return the range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByTemplateId(long spTemplateId,
		int start, int end) throws SystemException {
		return findByTemplateId(spTemplateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p component templates where spTemplateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spTemplateId the sp template ID
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findByTemplateId(long spTemplateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { spTemplateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] {
					spTemplateId,
					
					start, end, orderByComparator
				};
		}

		List<SPComponentTemplate> list = (List<SPComponentTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPComponentTemplate spComponentTemplate : list) {
				if ((spTemplateId != spComponentTemplate.getSpTemplateId())) {
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

			query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_SPTEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spTemplateId);

				if (!pagination) {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPComponentTemplate>(list);
				}
				else {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
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
	 * Returns the first s p component template in the ordered set where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByTemplateId_First(long spTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByTemplateId_First(spTemplateId,
				orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spTemplateId=");
		msg.append(spTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the first s p component template in the ordered set where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByTemplateId_First(long spTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPComponentTemplate> list = findByTemplateId(spTemplateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p component template in the ordered set where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByTemplateId_Last(long spTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByTemplateId_Last(spTemplateId,
				orderByComparator);

		if (spComponentTemplate != null) {
			return spComponentTemplate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spTemplateId=");
		msg.append(spTemplateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPComponentTemplateException(msg.toString());
	}

	/**
	 * Returns the last s p component template in the ordered set where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p component template, or <code>null</code> if a matching s p component template could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByTemplateId_Last(long spTemplateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(spTemplateId);

		if (count == 0) {
			return null;
		}

		List<SPComponentTemplate> list = findByTemplateId(spTemplateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p component templates before and after the current s p component template in the ordered set where spTemplateId = &#63;.
	 *
	 * @param spComponentTemplateId the primary key of the current s p component template
	 * @param spTemplateId the sp template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate[] findByTemplateId_PrevAndNext(
		long spComponentTemplateId, long spTemplateId,
		OrderByComparator orderByComparator)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = findByPrimaryKey(spComponentTemplateId);

		Session session = null;

		try {
			session = openSession();

			SPComponentTemplate[] array = new SPComponentTemplateImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session,
					spComponentTemplate, spTemplateId, orderByComparator, true);

			array[1] = spComponentTemplate;

			array[2] = getByTemplateId_PrevAndNext(session,
					spComponentTemplate, spTemplateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPComponentTemplate getByTemplateId_PrevAndNext(Session session,
		SPComponentTemplate spComponentTemplate, long spTemplateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_SPTEMPLATEID_2);

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
			query.append(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spTemplateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spComponentTemplate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPComponentTemplate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p component templates where spTemplateId = &#63; from the database.
	 *
	 * @param spTemplateId the sp template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long spTemplateId) throws SystemException {
		for (SPComponentTemplate spComponentTemplate : findByTemplateId(
				spTemplateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spComponentTemplate);
		}
	}

	/**
	 * Returns the number of s p component templates where spTemplateId = &#63;.
	 *
	 * @param spTemplateId the sp template ID
	 * @return the number of matching s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateId(long spTemplateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

		Object[] finderArgs = new Object[] { spTemplateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCOMPONENTTEMPLATE_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_SPTEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spTemplateId);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_SPTEMPLATEID_2 = "spComponentTemplate.spTemplateId = ?";

	public SPComponentTemplatePersistenceImpl() {
		setModelClass(SPComponentTemplate.class);
	}

	/**
	 * Caches the s p component template in the entity cache if it is enabled.
	 *
	 * @param spComponentTemplate the s p component template
	 */
	@Override
	public void cacheResult(SPComponentTemplate spComponentTemplate) {
		EntityCacheUtil.putResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateImpl.class, spComponentTemplate.getPrimaryKey(),
			spComponentTemplate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				spComponentTemplate.getUuid(), spComponentTemplate.getGroupId()
			}, spComponentTemplate);

		spComponentTemplate.resetOriginalValues();
	}

	/**
	 * Caches the s p component templates in the entity cache if it is enabled.
	 *
	 * @param spComponentTemplates the s p component templates
	 */
	@Override
	public void cacheResult(List<SPComponentTemplate> spComponentTemplates) {
		for (SPComponentTemplate spComponentTemplate : spComponentTemplates) {
			if (EntityCacheUtil.getResult(
						SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPComponentTemplateImpl.class,
						spComponentTemplate.getPrimaryKey()) == null) {
				cacheResult(spComponentTemplate);
			}
			else {
				spComponentTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p component templates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPComponentTemplateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPComponentTemplateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p component template.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPComponentTemplate spComponentTemplate) {
		EntityCacheUtil.removeResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateImpl.class, spComponentTemplate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spComponentTemplate);
	}

	@Override
	public void clearCache(List<SPComponentTemplate> spComponentTemplates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPComponentTemplate spComponentTemplate : spComponentTemplates) {
			EntityCacheUtil.removeResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPComponentTemplateImpl.class,
				spComponentTemplate.getPrimaryKey());

			clearUniqueFindersCache(spComponentTemplate);
		}
	}

	protected void cacheUniqueFindersCache(
		SPComponentTemplate spComponentTemplate) {
		if (spComponentTemplate.isNew()) {
			Object[] args = new Object[] {
					spComponentTemplate.getUuid(),
					spComponentTemplate.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				spComponentTemplate);
		}
		else {
			SPComponentTemplateModelImpl spComponentTemplateModelImpl = (SPComponentTemplateModelImpl)spComponentTemplate;

			if ((spComponentTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spComponentTemplate.getUuid(),
						spComponentTemplate.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					spComponentTemplate);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SPComponentTemplate spComponentTemplate) {
		SPComponentTemplateModelImpl spComponentTemplateModelImpl = (SPComponentTemplateModelImpl)spComponentTemplate;

		Object[] args = new Object[] {
				spComponentTemplate.getUuid(), spComponentTemplate.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((spComponentTemplateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					spComponentTemplateModelImpl.getOriginalUuid(),
					spComponentTemplateModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new s p component template with the primary key. Does not add the s p component template to the database.
	 *
	 * @param spComponentTemplateId the primary key for the new s p component template
	 * @return the new s p component template
	 */
	@Override
	public SPComponentTemplate create(long spComponentTemplateId) {
		SPComponentTemplate spComponentTemplate = new SPComponentTemplateImpl();

		spComponentTemplate.setNew(true);
		spComponentTemplate.setPrimaryKey(spComponentTemplateId);

		String uuid = PortalUUIDUtil.generate();

		spComponentTemplate.setUuid(uuid);

		return spComponentTemplate;
	}

	/**
	 * Removes the s p component template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spComponentTemplateId the primary key of the s p component template
	 * @return the s p component template that was removed
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate remove(long spComponentTemplateId)
		throws NoSuchSPComponentTemplateException, SystemException {
		return remove((Serializable)spComponentTemplateId);
	}

	/**
	 * Removes the s p component template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p component template
	 * @return the s p component template that was removed
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate remove(Serializable primaryKey)
		throws NoSuchSPComponentTemplateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPComponentTemplate spComponentTemplate = (SPComponentTemplate)session.get(SPComponentTemplateImpl.class,
					primaryKey);

			if (spComponentTemplate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPComponentTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spComponentTemplate);
		}
		catch (NoSuchSPComponentTemplateException nsee) {
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
	protected SPComponentTemplate removeImpl(
		SPComponentTemplate spComponentTemplate) throws SystemException {
		spComponentTemplate = toUnwrappedModel(spComponentTemplate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spComponentTemplate)) {
				spComponentTemplate = (SPComponentTemplate)session.get(SPComponentTemplateImpl.class,
						spComponentTemplate.getPrimaryKeyObj());
			}

			if (spComponentTemplate != null) {
				session.delete(spComponentTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spComponentTemplate != null) {
			clearCache(spComponentTemplate);
		}

		return spComponentTemplate;
	}

	@Override
	public SPComponentTemplate updateImpl(
		com.sambaash.platform.srv.template.model.SPComponentTemplate spComponentTemplate)
		throws SystemException {
		spComponentTemplate = toUnwrappedModel(spComponentTemplate);

		boolean isNew = spComponentTemplate.isNew();

		SPComponentTemplateModelImpl spComponentTemplateModelImpl = (SPComponentTemplateModelImpl)spComponentTemplate;

		if (Validator.isNull(spComponentTemplate.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			spComponentTemplate.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (spComponentTemplate.isNew()) {
				session.save(spComponentTemplate);

				spComponentTemplate.setNew(false);
			}
			else {
				session.merge(spComponentTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPComponentTemplateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spComponentTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spComponentTemplateModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { spComponentTemplateModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((spComponentTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spComponentTemplateModelImpl.getOriginalUuid(),
						spComponentTemplateModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						spComponentTemplateModelImpl.getUuid(),
						spComponentTemplateModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((spComponentTemplateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spComponentTemplateModelImpl.getOriginalSpTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] {
						spComponentTemplateModelImpl.getSpTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
			SPComponentTemplateImpl.class, spComponentTemplate.getPrimaryKey(),
			spComponentTemplate);

		clearUniqueFindersCache(spComponentTemplate);
		cacheUniqueFindersCache(spComponentTemplate);

		return spComponentTemplate;
	}

	protected SPComponentTemplate toUnwrappedModel(
		SPComponentTemplate spComponentTemplate) {
		if (spComponentTemplate instanceof SPComponentTemplateImpl) {
			return spComponentTemplate;
		}

		SPComponentTemplateImpl spComponentTemplateImpl = new SPComponentTemplateImpl();

		spComponentTemplateImpl.setNew(spComponentTemplate.isNew());
		spComponentTemplateImpl.setPrimaryKey(spComponentTemplate.getPrimaryKey());

		spComponentTemplateImpl.setUuid(spComponentTemplate.getUuid());
		spComponentTemplateImpl.setSpComponentTemplateId(spComponentTemplate.getSpComponentTemplateId());
		spComponentTemplateImpl.setGroupId(spComponentTemplate.getGroupId());
		spComponentTemplateImpl.setCompanyId(spComponentTemplate.getCompanyId());
		spComponentTemplateImpl.setUserId(spComponentTemplate.getUserId());
		spComponentTemplateImpl.setUserName(spComponentTemplate.getUserName());
		spComponentTemplateImpl.setCreateDate(spComponentTemplate.getCreateDate());
		spComponentTemplateImpl.setModifiedDate(spComponentTemplate.getModifiedDate());
		spComponentTemplateImpl.setCreateBy(spComponentTemplate.getCreateBy());
		spComponentTemplateImpl.setModifiedBy(spComponentTemplate.getModifiedBy());
		spComponentTemplateImpl.setSpTemplateId(spComponentTemplate.getSpTemplateId());
		spComponentTemplateImpl.setLevel0ClassNameId(spComponentTemplate.getLevel0ClassNameId());
		spComponentTemplateImpl.setLevel0FormId(spComponentTemplate.getLevel0FormId());
		spComponentTemplateImpl.setLevel1ClassNameId(spComponentTemplate.getLevel1ClassNameId());
		spComponentTemplateImpl.setLevel1FormId(spComponentTemplate.getLevel1FormId());
		spComponentTemplateImpl.setLevel2ClassNameId(spComponentTemplate.getLevel2ClassNameId());
		spComponentTemplateImpl.setLevel2FormId(spComponentTemplate.getLevel2FormId());
		spComponentTemplateImpl.setLevel3ClassNameId(spComponentTemplate.getLevel3ClassNameId());
		spComponentTemplateImpl.setLevel3FormId(spComponentTemplate.getLevel3FormId());
		spComponentTemplateImpl.setLevel4ClassNameId(spComponentTemplate.getLevel4ClassNameId());
		spComponentTemplateImpl.setLevel4FormId(spComponentTemplate.getLevel4FormId());
		spComponentTemplateImpl.setLevel5ClassNameId(spComponentTemplate.getLevel5ClassNameId());
		spComponentTemplateImpl.setLevel5FormId(spComponentTemplate.getLevel5FormId());
		spComponentTemplateImpl.setLevel6ClassNameId(spComponentTemplate.getLevel6ClassNameId());
		spComponentTemplateImpl.setLevel6FormId(spComponentTemplate.getLevel6FormId());
		spComponentTemplateImpl.setLevel7ClassNameId(spComponentTemplate.getLevel7ClassNameId());
		spComponentTemplateImpl.setLevel7FormId(spComponentTemplate.getLevel7FormId());
		spComponentTemplateImpl.setLevel8ClassNameId(spComponentTemplate.getLevel8ClassNameId());
		spComponentTemplateImpl.setLevel8FormId(spComponentTemplate.getLevel8FormId());
		spComponentTemplateImpl.setLevel9ClassNameId(spComponentTemplate.getLevel9ClassNameId());
		spComponentTemplateImpl.setLevel9FormId(spComponentTemplate.getLevel9FormId());
		spComponentTemplateImpl.setLevel10ClassNameId(spComponentTemplate.getLevel10ClassNameId());
		spComponentTemplateImpl.setLevel10FormId(spComponentTemplate.getLevel10FormId());
		spComponentTemplateImpl.setStatus(spComponentTemplate.getStatus());

		return spComponentTemplateImpl;
	}

	/**
	 * Returns the s p component template with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p component template
	 * @return the s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPComponentTemplateException, SystemException {
		SPComponentTemplate spComponentTemplate = fetchByPrimaryKey(primaryKey);

		if (spComponentTemplate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPComponentTemplateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spComponentTemplate;
	}

	/**
	 * Returns the s p component template with the primary key or throws a {@link com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException} if it could not be found.
	 *
	 * @param spComponentTemplateId the primary key of the s p component template
	 * @return the s p component template
	 * @throws com.sambaash.platform.srv.template.NoSuchSPComponentTemplateException if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate findByPrimaryKey(long spComponentTemplateId)
		throws NoSuchSPComponentTemplateException, SystemException {
		return findByPrimaryKey((Serializable)spComponentTemplateId);
	}

	/**
	 * Returns the s p component template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p component template
	 * @return the s p component template, or <code>null</code> if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPComponentTemplate spComponentTemplate = (SPComponentTemplate)EntityCacheUtil.getResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
				SPComponentTemplateImpl.class, primaryKey);

		if (spComponentTemplate == _nullSPComponentTemplate) {
			return null;
		}

		if (spComponentTemplate == null) {
			Session session = null;

			try {
				session = openSession();

				spComponentTemplate = (SPComponentTemplate)session.get(SPComponentTemplateImpl.class,
						primaryKey);

				if (spComponentTemplate != null) {
					cacheResult(spComponentTemplate);
				}
				else {
					EntityCacheUtil.putResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
						SPComponentTemplateImpl.class, primaryKey,
						_nullSPComponentTemplate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPComponentTemplateModelImpl.ENTITY_CACHE_ENABLED,
					SPComponentTemplateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spComponentTemplate;
	}

	/**
	 * Returns the s p component template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spComponentTemplateId the primary key of the s p component template
	 * @return the s p component template, or <code>null</code> if a s p component template with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPComponentTemplate fetchByPrimaryKey(long spComponentTemplateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spComponentTemplateId);
	}

	/**
	 * Returns all the s p component templates.
	 *
	 * @return the s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p component templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @return the range of s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p component templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.template.model.impl.SPComponentTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p component templates
	 * @param end the upper bound of the range of s p component templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p component templates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPComponentTemplate> findAll(int start, int end,
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

		List<SPComponentTemplate> list = (List<SPComponentTemplate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCOMPONENTTEMPLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCOMPONENTTEMPLATE;

				if (pagination) {
					sql = sql.concat(SPComponentTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPComponentTemplate>(list);
				}
				else {
					list = (List<SPComponentTemplate>)QueryUtil.list(q,
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
	 * Removes all the s p component templates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPComponentTemplate spComponentTemplate : findAll()) {
			remove(spComponentTemplate);
		}
	}

	/**
	 * Returns the number of s p component templates.
	 *
	 * @return the number of s p component templates
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

				Query q = session.createQuery(_SQL_COUNT_SPCOMPONENTTEMPLATE);

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
	 * Initializes the s p component template persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.template.model.SPComponentTemplate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPComponentTemplate>> listenersList = new ArrayList<ModelListener<SPComponentTemplate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPComponentTemplate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPComponentTemplateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCOMPONENTTEMPLATE = "SELECT spComponentTemplate FROM SPComponentTemplate spComponentTemplate";
	private static final String _SQL_SELECT_SPCOMPONENTTEMPLATE_WHERE = "SELECT spComponentTemplate FROM SPComponentTemplate spComponentTemplate WHERE ";
	private static final String _SQL_COUNT_SPCOMPONENTTEMPLATE = "SELECT COUNT(spComponentTemplate) FROM SPComponentTemplate spComponentTemplate";
	private static final String _SQL_COUNT_SPCOMPONENTTEMPLATE_WHERE = "SELECT COUNT(spComponentTemplate) FROM SPComponentTemplate spComponentTemplate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spComponentTemplate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPComponentTemplate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPComponentTemplate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPComponentTemplatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SPComponentTemplate _nullSPComponentTemplate = new SPComponentTemplateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPComponentTemplate> toCacheModel() {
				return _nullSPComponentTemplateCacheModel;
			}
		};

	private static CacheModel<SPComponentTemplate> _nullSPComponentTemplateCacheModel =
		new CacheModel<SPComponentTemplate>() {
			@Override
			public SPComponentTemplate toEntityModel() {
				return _nullSPComponentTemplate;
			}
		};
}