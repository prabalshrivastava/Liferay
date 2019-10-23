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

package com.sambaash.platform.srv.spasset.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spasset.NoSuchEntryException;
import com.sambaash.platform.srv.spasset.model.SPAssetEntry;
import com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryImpl;
import com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p asset entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPAssetEntryPersistence
 * @see SPAssetEntryUtil
 * @generated
 */
public class SPAssetEntryPersistenceImpl extends BasePersistenceImpl<SPAssetEntry>
	implements SPAssetEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPAssetEntryUtil} to access the s p asset entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPAssetEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_URLTITLE = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByurlTitle",
			new String[] { String.class.getName(), Long.class.getName() },
			SPAssetEntryModelImpl.URLTITLE_COLUMN_BITMASK |
			SPAssetEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_URLTITLE = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByurlTitle",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spasset.NoSuchEntryException} if it could not be found.
	 *
	 * @param urlTitle the url title
	 * @param groupId the group ID
	 * @return the matching s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findByurlTitle(String urlTitle, long groupId)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchByurlTitle(urlTitle, groupId);

		if (spAssetEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("urlTitle=");
			msg.append(urlTitle);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return spAssetEntry;
	}

	/**
	 * Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param groupId the group ID
	 * @return the matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchByurlTitle(String urlTitle, long groupId)
		throws SystemException {
		return fetchByurlTitle(urlTitle, groupId, true);
	}

	/**
	 * Returns the s p asset entry where urlTitle = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param urlTitle the url title
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchByurlTitle(String urlTitle, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { urlTitle, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_URLTITLE,
					finderArgs, this);
		}

		if (result instanceof SPAssetEntry) {
			SPAssetEntry spAssetEntry = (SPAssetEntry)result;

			if (!Validator.equals(urlTitle, spAssetEntry.getUrlTitle()) ||
					(groupId != spAssetEntry.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPASSETENTRY_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			query.append(_FINDER_COLUMN_URLTITLE_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
				}

				qPos.add(groupId);

				List<SPAssetEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPAssetEntryPersistenceImpl.fetchByurlTitle(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPAssetEntry spAssetEntry = list.get(0);

					result = spAssetEntry;

					cacheResult(spAssetEntry);

					if ((spAssetEntry.getUrlTitle() == null) ||
							!spAssetEntry.getUrlTitle().equals(urlTitle) ||
							(spAssetEntry.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLE,
							finderArgs, spAssetEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLE,
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
			return (SPAssetEntry)result;
		}
	}

	/**
	 * Removes the s p asset entry where urlTitle = &#63; and groupId = &#63; from the database.
	 *
	 * @param urlTitle the url title
	 * @param groupId the group ID
	 * @return the s p asset entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry removeByurlTitle(String urlTitle, long groupId)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = findByurlTitle(urlTitle, groupId);

		return remove(spAssetEntry);
	}

	/**
	 * Returns the number of s p asset entries where urlTitle = &#63; and groupId = &#63;.
	 *
	 * @param urlTitle the url title
	 * @param groupId the group ID
	 * @return the number of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByurlTitle(String urlTitle, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_URLTITLE;

		Object[] finderArgs = new Object[] { urlTitle, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPASSETENTRY_WHERE);

			boolean bindUrlTitle = false;

			if (urlTitle == null) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_1);
			}
			else if (urlTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_3);
			}
			else {
				bindUrlTitle = true;

				query.append(_FINDER_COLUMN_URLTITLE_URLTITLE_2);
			}

			query.append(_FINDER_COLUMN_URLTITLE_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrlTitle) {
					qPos.add(urlTitle);
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

	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_1 = "spAssetEntry.urlTitle IS NULL AND ";
	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_2 = "spAssetEntry.urlTitle = ? AND ";
	private static final String _FINDER_COLUMN_URLTITLE_URLTITLE_3 = "(spAssetEntry.urlTitle IS NULL OR spAssetEntry.urlTitle = '') AND ";
	private static final String _FINDER_COLUMN_URLTITLE_GROUPID_2 = "spAssetEntry.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS =
		new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySpAssetTypeIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS =
		new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySpAssetTypeIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			SPAssetEntryModelImpl.SPASSETTYPEID_COLUMN_BITMASK |
			SPAssetEntryModelImpl.GROUPID_COLUMN_BITMASK |
			SPAssetEntryModelImpl.STATUS_COLUMN_BITMASK |
			SPAssetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPASSETTYPEIDSTATUS = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySpAssetTypeIdStatus",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status) throws SystemException {
		return findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @return the range of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status, int start, int end)
		throws SystemException {
		return findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS;
			finderArgs = new Object[] { spAssetTypeId, groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS;
			finderArgs = new Object[] {
					spAssetTypeId, groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<SPAssetEntry> list = (List<SPAssetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAssetEntry spAssetEntry : list) {
				if ((spAssetTypeId != spAssetEntry.getSpAssetTypeId()) ||
						(groupId != spAssetEntry.getGroupId()) ||
						(status != spAssetEntry.getStatus())) {
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

			query.append(_SQL_SELECT_SPASSETENTRY_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetEntry>(list);
				}
				else {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findBySpAssetTypeIdStatus_First(long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchBySpAssetTypeIdStatus_First(spAssetTypeId,
				groupId, status, orderByComparator);

		if (spAssetEntry != null) {
			return spAssetEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spAssetTypeId=");
		msg.append(spAssetTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchBySpAssetTypeIdStatus_First(long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPAssetEntry> list = findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findBySpAssetTypeIdStatus_Last(long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchBySpAssetTypeIdStatus_Last(spAssetTypeId,
				groupId, status, orderByComparator);

		if (spAssetEntry != null) {
			return spAssetEntry;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spAssetTypeId=");
		msg.append(spAssetTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchBySpAssetTypeIdStatus_Last(long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySpAssetTypeIdStatus(spAssetTypeId, groupId, status);

		if (count == 0) {
			return null;
		}

		List<SPAssetEntry> list = findBySpAssetTypeIdStatus(spAssetTypeId,
				groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p asset entries before and after the current s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetEntryId the primary key of the current s p asset entry
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry[] findBySpAssetTypeIdStatus_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = findByPrimaryKey(spAssetEntryId);

		Session session = null;

		try {
			session = openSession();

			SPAssetEntry[] array = new SPAssetEntryImpl[3];

			array[0] = getBySpAssetTypeIdStatus_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, status,
					orderByComparator, true);

			array[1] = spAssetEntry;

			array[2] = getBySpAssetTypeIdStatus_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, status,
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

	protected SPAssetEntry getBySpAssetTypeIdStatus_PrevAndNext(
		Session session, SPAssetEntry spAssetEntry, long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPASSETENTRY_WHERE);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

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
			query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spAssetTypeId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status)
		throws SystemException {
		return filterFindBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @return the range of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end)
		throws SystemException {
		return filterFindBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset entries that the user has permissions to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeIdStatus(
		long spAssetTypeId, long groupId, boolean status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBySpAssetTypeIdStatus(spAssetTypeId, groupId, status,
				start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SPAssetEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SPAssetEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SPAssetEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(spAssetTypeId);

			qPos.add(groupId);

			qPos.add(status);

			return (List<SPAssetEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the s p asset entries before and after the current s p asset entry in the ordered set of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetEntryId the primary key of the current s p asset entry
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry[] filterFindBySpAssetTypeIdStatus_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId, boolean status,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBySpAssetTypeIdStatus_PrevAndNext(spAssetEntryId,
				spAssetTypeId, groupId, status, orderByComparator);
		}

		SPAssetEntry spAssetEntry = findByPrimaryKey(spAssetEntryId);

		Session session = null;

		try {
			session = openSession();

			SPAssetEntry[] array = new SPAssetEntryImpl[3];

			array[0] = filterGetBySpAssetTypeIdStatus_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, status,
					orderByComparator, true);

			array[1] = spAssetEntry;

			array[2] = filterGetBySpAssetTypeIdStatus_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, status,
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

	protected SPAssetEntry filterGetBySpAssetTypeIdStatus_PrevAndNext(
		Session session, SPAssetEntry spAssetEntry, long spAssetTypeId,
		long groupId, boolean status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SPAssetEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SPAssetEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SPAssetEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spAssetTypeId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63; from the database.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpAssetTypeIdStatus(long spAssetTypeId, long groupId,
		boolean status) throws SystemException {
		for (SPAssetEntry spAssetEntry : findBySpAssetTypeIdStatus(
				spAssetTypeId, groupId, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(spAssetEntry);
		}
	}

	/**
	 * Returns the number of s p asset entries where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpAssetTypeIdStatus(long spAssetTypeId, long groupId,
		boolean status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPASSETTYPEIDSTATUS;

		Object[] finderArgs = new Object[] { spAssetTypeId, groupId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SPASSETENTRY_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

				qPos.add(groupId);

				qPos.add(status);

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
	 * Returns the number of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63; and status = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountBySpAssetTypeIdStatus(long spAssetTypeId,
		long groupId, boolean status) throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countBySpAssetTypeIdStatus(spAssetTypeId, groupId, status);
		}

		StringBundler query = new StringBundler(4);

		query.append(_FILTER_SQL_COUNT_SPASSETENTRY_WHERE);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(spAssetTypeId);

			qPos.add(groupId);

			qPos.add(status);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_SPASSETTYPEIDSTATUS_SPASSETTYPEID_2 =
		"spAssetEntry.spAssetTypeId = ? AND ";
	private static final String _FINDER_COLUMN_SPASSETTYPEIDSTATUS_GROUPID_2 = "spAssetEntry.groupId = ? AND ";
	private static final String _FINDER_COLUMN_SPASSETTYPEIDSTATUS_STATUS_2 = "spAssetEntry.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPASSETTYPEID =
		new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySpAssetTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEID =
		new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, SPAssetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySpAssetTypeId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPAssetEntryModelImpl.SPASSETTYPEID_COLUMN_BITMASK |
			SPAssetEntryModelImpl.GROUPID_COLUMN_BITMASK |
			SPAssetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPASSETTYPEID = new FinderPath(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySpAssetTypeId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @return the matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
		long groupId) throws SystemException {
		return findBySpAssetTypeId(spAssetTypeId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @return the range of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
		long groupId, int start, int end) throws SystemException {
		return findBySpAssetTypeId(spAssetTypeId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findBySpAssetTypeId(long spAssetTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEID;
			finderArgs = new Object[] { spAssetTypeId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPASSETTYPEID;
			finderArgs = new Object[] {
					spAssetTypeId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<SPAssetEntry> list = (List<SPAssetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAssetEntry spAssetEntry : list) {
				if ((spAssetTypeId != spAssetEntry.getSpAssetTypeId()) ||
						(groupId != spAssetEntry.getGroupId())) {
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

			query.append(_SQL_SELECT_SPASSETENTRY_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetEntry>(list);
				}
				else {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findBySpAssetTypeId_First(long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchBySpAssetTypeId_First(spAssetTypeId,
				groupId, orderByComparator);

		if (spAssetEntry != null) {
			return spAssetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spAssetTypeId=");
		msg.append(spAssetTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the first s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchBySpAssetTypeId_First(long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SPAssetEntry> list = findBySpAssetTypeId(spAssetTypeId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findBySpAssetTypeId_Last(long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchBySpAssetTypeId_Last(spAssetTypeId,
				groupId, orderByComparator);

		if (spAssetEntry != null) {
			return spAssetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("spAssetTypeId=");
		msg.append(spAssetTypeId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEntryException(msg.toString());
	}

	/**
	 * Returns the last s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p asset entry, or <code>null</code> if a matching s p asset entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchBySpAssetTypeId_Last(long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySpAssetTypeId(spAssetTypeId, groupId);

		if (count == 0) {
			return null;
		}

		List<SPAssetEntry> list = findBySpAssetTypeId(spAssetTypeId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p asset entries before and after the current s p asset entry in the ordered set where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetEntryId the primary key of the current s p asset entry
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry[] findBySpAssetTypeId_PrevAndNext(long spAssetEntryId,
		long spAssetTypeId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = findByPrimaryKey(spAssetEntryId);

		Session session = null;

		try {
			session = openSession();

			SPAssetEntry[] array = new SPAssetEntryImpl[3];

			array[0] = getBySpAssetTypeId_PrevAndNext(session, spAssetEntry,
					spAssetTypeId, groupId, orderByComparator, true);

			array[1] = spAssetEntry;

			array[2] = getBySpAssetTypeId_PrevAndNext(session, spAssetEntry,
					spAssetTypeId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPAssetEntry getBySpAssetTypeId_PrevAndNext(Session session,
		SPAssetEntry spAssetEntry, long spAssetTypeId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPASSETENTRY_WHERE);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

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
			query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spAssetTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @return the matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeId(long spAssetTypeId,
		long groupId) throws SystemException {
		return filterFindBySpAssetTypeId(spAssetTypeId, groupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @return the range of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeId(long spAssetTypeId,
		long groupId, int start, int end) throws SystemException {
		return filterFindBySpAssetTypeId(spAssetTypeId, groupId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the s p asset entries that the user has permissions to view where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> filterFindBySpAssetTypeId(long spAssetTypeId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBySpAssetTypeId(spAssetTypeId, groupId, start, end,
				orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SPAssetEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, SPAssetEntryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, SPAssetEntryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(spAssetTypeId);

			qPos.add(groupId);

			return (List<SPAssetEntry>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the s p asset entries before and after the current s p asset entry in the ordered set of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetEntryId the primary key of the current s p asset entry
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry[] filterFindBySpAssetTypeId_PrevAndNext(
		long spAssetEntryId, long spAssetTypeId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findBySpAssetTypeId_PrevAndNext(spAssetEntryId,
				spAssetTypeId, groupId, orderByComparator);
		}

		SPAssetEntry spAssetEntry = findByPrimaryKey(spAssetEntryId);

		Session session = null;

		try {
			session = openSession();

			SPAssetEntry[] array = new SPAssetEntryImpl[3];

			array[0] = filterGetBySpAssetTypeId_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, orderByComparator,
					true);

			array[1] = spAssetEntry;

			array[2] = filterGetBySpAssetTypeId_PrevAndNext(session,
					spAssetEntry, spAssetTypeId, groupId, orderByComparator,
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

	protected SPAssetEntry filterGetBySpAssetTypeId_PrevAndNext(
		Session session, SPAssetEntry spAssetEntry, long spAssetTypeId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(SPAssetEntryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(SPAssetEntryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, SPAssetEntryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, SPAssetEntryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(spAssetTypeId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAssetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAssetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p asset entries where spAssetTypeId = &#63; and groupId = &#63; from the database.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws SystemException {
		for (SPAssetEntry spAssetEntry : findBySpAssetTypeId(spAssetTypeId,
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAssetEntry);
		}
	}

	/**
	 * Returns the number of s p asset entries where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @return the number of matching s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPASSETTYPEID;

		Object[] finderArgs = new Object[] { spAssetTypeId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPASSETENTRY_WHERE);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

			query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(spAssetTypeId);

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

	/**
	 * Returns the number of s p asset entries that the user has permission to view where spAssetTypeId = &#63; and groupId = &#63;.
	 *
	 * @param spAssetTypeId the sp asset type ID
	 * @param groupId the group ID
	 * @return the number of matching s p asset entries that the user has permission to view
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int filterCountBySpAssetTypeId(long spAssetTypeId, long groupId)
		throws SystemException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countBySpAssetTypeId(spAssetTypeId, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_SPASSETENTRY_WHERE);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2);

		query.append(_FINDER_COLUMN_SPASSETTYPEID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				SPAssetEntry.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(spAssetTypeId);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_SPASSETTYPEID_SPASSETTYPEID_2 = "spAssetEntry.spAssetTypeId = ? AND ";
	private static final String _FINDER_COLUMN_SPASSETTYPEID_GROUPID_2 = "spAssetEntry.groupId = ?";

	public SPAssetEntryPersistenceImpl() {
		setModelClass(SPAssetEntry.class);
	}

	/**
	 * Caches the s p asset entry in the entity cache if it is enabled.
	 *
	 * @param spAssetEntry the s p asset entry
	 */
	@Override
	public void cacheResult(SPAssetEntry spAssetEntry) {
		EntityCacheUtil.putResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryImpl.class, spAssetEntry.getPrimaryKey(), spAssetEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLE,
			new Object[] { spAssetEntry.getUrlTitle(), spAssetEntry.getGroupId() },
			spAssetEntry);

		spAssetEntry.resetOriginalValues();
	}

	/**
	 * Caches the s p asset entries in the entity cache if it is enabled.
	 *
	 * @param spAssetEntries the s p asset entries
	 */
	@Override
	public void cacheResult(List<SPAssetEntry> spAssetEntries) {
		for (SPAssetEntry spAssetEntry : spAssetEntries) {
			if (EntityCacheUtil.getResult(
						SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
						SPAssetEntryImpl.class, spAssetEntry.getPrimaryKey()) == null) {
				cacheResult(spAssetEntry);
			}
			else {
				spAssetEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p asset entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPAssetEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPAssetEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p asset entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPAssetEntry spAssetEntry) {
		EntityCacheUtil.removeResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryImpl.class, spAssetEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spAssetEntry);
	}

	@Override
	public void clearCache(List<SPAssetEntry> spAssetEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPAssetEntry spAssetEntry : spAssetEntries) {
			EntityCacheUtil.removeResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
				SPAssetEntryImpl.class, spAssetEntry.getPrimaryKey());

			clearUniqueFindersCache(spAssetEntry);
		}
	}

	protected void cacheUniqueFindersCache(SPAssetEntry spAssetEntry) {
		if (spAssetEntry.isNew()) {
			Object[] args = new Object[] {
					spAssetEntry.getUrlTitle(), spAssetEntry.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URLTITLE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLE, args,
				spAssetEntry);
		}
		else {
			SPAssetEntryModelImpl spAssetEntryModelImpl = (SPAssetEntryModelImpl)spAssetEntry;

			if ((spAssetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_URLTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAssetEntry.getUrlTitle(), spAssetEntry.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URLTITLE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_URLTITLE, args,
					spAssetEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(SPAssetEntry spAssetEntry) {
		SPAssetEntryModelImpl spAssetEntryModelImpl = (SPAssetEntryModelImpl)spAssetEntry;

		Object[] args = new Object[] {
				spAssetEntry.getUrlTitle(), spAssetEntry.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLTITLE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLE, args);

		if ((spAssetEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_URLTITLE.getColumnBitmask()) != 0) {
			args = new Object[] {
					spAssetEntryModelImpl.getOriginalUrlTitle(),
					spAssetEntryModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_URLTITLE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_URLTITLE, args);
		}
	}

	/**
	 * Creates a new s p asset entry with the primary key. Does not add the s p asset entry to the database.
	 *
	 * @param spAssetEntryId the primary key for the new s p asset entry
	 * @return the new s p asset entry
	 */
	@Override
	public SPAssetEntry create(long spAssetEntryId) {
		SPAssetEntry spAssetEntry = new SPAssetEntryImpl();

		spAssetEntry.setNew(true);
		spAssetEntry.setPrimaryKey(spAssetEntryId);

		return spAssetEntry;
	}

	/**
	 * Removes the s p asset entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAssetEntryId the primary key of the s p asset entry
	 * @return the s p asset entry that was removed
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry remove(long spAssetEntryId)
		throws NoSuchEntryException, SystemException {
		return remove((Serializable)spAssetEntryId);
	}

	/**
	 * Removes the s p asset entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p asset entry
	 * @return the s p asset entry that was removed
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry remove(Serializable primaryKey)
		throws NoSuchEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPAssetEntry spAssetEntry = (SPAssetEntry)session.get(SPAssetEntryImpl.class,
					primaryKey);

			if (spAssetEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spAssetEntry);
		}
		catch (NoSuchEntryException nsee) {
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
	protected SPAssetEntry removeImpl(SPAssetEntry spAssetEntry)
		throws SystemException {
		spAssetEntry = toUnwrappedModel(spAssetEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spAssetEntry)) {
				spAssetEntry = (SPAssetEntry)session.get(SPAssetEntryImpl.class,
						spAssetEntry.getPrimaryKeyObj());
			}

			if (spAssetEntry != null) {
				session.delete(spAssetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spAssetEntry != null) {
			clearCache(spAssetEntry);
		}

		return spAssetEntry;
	}

	@Override
	public SPAssetEntry updateImpl(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry)
		throws SystemException {
		spAssetEntry = toUnwrappedModel(spAssetEntry);

		boolean isNew = spAssetEntry.isNew();

		SPAssetEntryModelImpl spAssetEntryModelImpl = (SPAssetEntryModelImpl)spAssetEntry;

		Session session = null;

		try {
			session = openSession();

			if (spAssetEntry.isNew()) {
				session.save(spAssetEntry);

				spAssetEntry.setNew(false);
			}
			else {
				session.merge(spAssetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPAssetEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spAssetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAssetEntryModelImpl.getOriginalSpAssetTypeId(),
						spAssetEntryModelImpl.getOriginalGroupId(),
						spAssetEntryModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS,
					args);

				args = new Object[] {
						spAssetEntryModelImpl.getSpAssetTypeId(),
						spAssetEntryModelImpl.getGroupId(),
						spAssetEntryModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEIDSTATUS,
					args);
			}

			if ((spAssetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAssetEntryModelImpl.getOriginalSpAssetTypeId(),
						spAssetEntryModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEID,
					args);

				args = new Object[] {
						spAssetEntryModelImpl.getSpAssetTypeId(),
						spAssetEntryModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SPASSETTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPASSETTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SPAssetEntryImpl.class, spAssetEntry.getPrimaryKey(), spAssetEntry);

		clearUniqueFindersCache(spAssetEntry);
		cacheUniqueFindersCache(spAssetEntry);

		return spAssetEntry;
	}

	protected SPAssetEntry toUnwrappedModel(SPAssetEntry spAssetEntry) {
		if (spAssetEntry instanceof SPAssetEntryImpl) {
			return spAssetEntry;
		}

		SPAssetEntryImpl spAssetEntryImpl = new SPAssetEntryImpl();

		spAssetEntryImpl.setNew(spAssetEntry.isNew());
		spAssetEntryImpl.setPrimaryKey(spAssetEntry.getPrimaryKey());

		spAssetEntryImpl.setUuid_(spAssetEntry.getUuid_());
		spAssetEntryImpl.setSpAssetEntryId(spAssetEntry.getSpAssetEntryId());
		spAssetEntryImpl.setGroupId(spAssetEntry.getGroupId());
		spAssetEntryImpl.setCompanyId(spAssetEntry.getCompanyId());
		spAssetEntryImpl.setUserId(spAssetEntry.getUserId());
		spAssetEntryImpl.setUserName(spAssetEntry.getUserName());
		spAssetEntryImpl.setCreateDate(spAssetEntry.getCreateDate());
		spAssetEntryImpl.setModifiedDate(spAssetEntry.getModifiedDate());
		spAssetEntryImpl.setDlFolderId(spAssetEntry.getDlFolderId());
		spAssetEntryImpl.setCoverFileEntryId(spAssetEntry.getCoverFileEntryId());
		spAssetEntryImpl.setSpAssetTypeId(spAssetEntry.getSpAssetTypeId());
		spAssetEntryImpl.setSpAssetEntrySubType(spAssetEntry.getSpAssetEntrySubType());
		spAssetEntryImpl.setCorporateProfileUserId(spAssetEntry.getCorporateProfileUserId());
		spAssetEntryImpl.setClassNameId(spAssetEntry.getClassNameId());
		spAssetEntryImpl.setTitle(spAssetEntry.getTitle());
		spAssetEntryImpl.setUrlTitle(spAssetEntry.getUrlTitle());
		spAssetEntryImpl.setDescription(spAssetEntry.getDescription());
		spAssetEntryImpl.setContent(spAssetEntry.getContent());
		spAssetEntryImpl.setLink(spAssetEntry.getLink());
		spAssetEntryImpl.setStatus(spAssetEntry.isStatus());
		spAssetEntryImpl.setStatusByUserName(spAssetEntry.getStatusByUserName());
		spAssetEntryImpl.setType(spAssetEntry.getType());
		spAssetEntryImpl.setModifiedBy(spAssetEntry.getModifiedBy());
		spAssetEntryImpl.setAllowPingbacks(spAssetEntry.isAllowPingbacks());
		spAssetEntryImpl.setAllowTrackbacks(spAssetEntry.isAllowTrackbacks());
		spAssetEntryImpl.setTrackbacks(spAssetEntry.getTrackbacks());
		spAssetEntryImpl.setPermissionType(spAssetEntry.getPermissionType());
		spAssetEntryImpl.setAgreedToTermsOfUse(spAssetEntry.isAgreedToTermsOfUse());

		return spAssetEntryImpl;
	}

	/**
	 * Returns the s p asset entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p asset entry
	 * @return the s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntryException, SystemException {
		SPAssetEntry spAssetEntry = fetchByPrimaryKey(primaryKey);

		if (spAssetEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spAssetEntry;
	}

	/**
	 * Returns the s p asset entry with the primary key or throws a {@link com.sambaash.platform.srv.spasset.NoSuchEntryException} if it could not be found.
	 *
	 * @param spAssetEntryId the primary key of the s p asset entry
	 * @return the s p asset entry
	 * @throws com.sambaash.platform.srv.spasset.NoSuchEntryException if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry findByPrimaryKey(long spAssetEntryId)
		throws NoSuchEntryException, SystemException {
		return findByPrimaryKey((Serializable)spAssetEntryId);
	}

	/**
	 * Returns the s p asset entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p asset entry
	 * @return the s p asset entry, or <code>null</code> if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPAssetEntry spAssetEntry = (SPAssetEntry)EntityCacheUtil.getResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
				SPAssetEntryImpl.class, primaryKey);

		if (spAssetEntry == _nullSPAssetEntry) {
			return null;
		}

		if (spAssetEntry == null) {
			Session session = null;

			try {
				session = openSession();

				spAssetEntry = (SPAssetEntry)session.get(SPAssetEntryImpl.class,
						primaryKey);

				if (spAssetEntry != null) {
					cacheResult(spAssetEntry);
				}
				else {
					EntityCacheUtil.putResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
						SPAssetEntryImpl.class, primaryKey, _nullSPAssetEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPAssetEntryModelImpl.ENTITY_CACHE_ENABLED,
					SPAssetEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spAssetEntry;
	}

	/**
	 * Returns the s p asset entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAssetEntryId the primary key of the s p asset entry
	 * @return the s p asset entry, or <code>null</code> if a s p asset entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAssetEntry fetchByPrimaryKey(long spAssetEntryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAssetEntryId);
	}

	/**
	 * Returns all the s p asset entries.
	 *
	 * @return the s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p asset entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @return the range of s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p asset entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spasset.model.impl.SPAssetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p asset entries
	 * @param end the upper bound of the range of s p asset entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p asset entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAssetEntry> findAll(int start, int end,
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

		List<SPAssetEntry> list = (List<SPAssetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPASSETENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPASSETENTRY;

				if (pagination) {
					sql = sql.concat(SPAssetEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAssetEntry>(list);
				}
				else {
					list = (List<SPAssetEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the s p asset entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPAssetEntry spAssetEntry : findAll()) {
			remove(spAssetEntry);
		}
	}

	/**
	 * Returns the number of s p asset entries.
	 *
	 * @return the number of s p asset entries
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

				Query q = session.createQuery(_SQL_COUNT_SPASSETENTRY);

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
	 * Initializes the s p asset entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spasset.model.SPAssetEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPAssetEntry>> listenersList = new ArrayList<ModelListener<SPAssetEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPAssetEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPAssetEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPASSETENTRY = "SELECT spAssetEntry FROM SPAssetEntry spAssetEntry";
	private static final String _SQL_SELECT_SPASSETENTRY_WHERE = "SELECT spAssetEntry FROM SPAssetEntry spAssetEntry WHERE ";
	private static final String _SQL_COUNT_SPASSETENTRY = "SELECT COUNT(spAssetEntry) FROM SPAssetEntry spAssetEntry";
	private static final String _SQL_COUNT_SPASSETENTRY_WHERE = "SELECT COUNT(spAssetEntry) FROM SPAssetEntry spAssetEntry WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "spAssetEntry.spAssetEntryId";
	private static final String _FILTER_SQL_SELECT_SPASSETENTRY_WHERE = "SELECT DISTINCT {spAssetEntry.*} FROM SPAssetEntry spAssetEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {SPAssetEntry.*} FROM (SELECT DISTINCT spAssetEntry.spAssetEntryId FROM SPAssetEntry spAssetEntry WHERE ";
	private static final String _FILTER_SQL_SELECT_SPASSETENTRY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN SPAssetEntry ON TEMP_TABLE.spAssetEntryId = SPAssetEntry.spAssetEntryId";
	private static final String _FILTER_SQL_COUNT_SPASSETENTRY_WHERE = "SELECT COUNT(DISTINCT spAssetEntry.spAssetEntryId) AS COUNT_VALUE FROM SPAssetEntry spAssetEntry WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "spAssetEntry";
	private static final String _FILTER_ENTITY_TABLE = "SPAssetEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spAssetEntry.";
	private static final String _ORDER_BY_ENTITY_TABLE = "SPAssetEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPAssetEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPAssetEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPAssetEntryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static SPAssetEntry _nullSPAssetEntry = new SPAssetEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPAssetEntry> toCacheModel() {
				return _nullSPAssetEntryCacheModel;
			}
		};

	private static CacheModel<SPAssetEntry> _nullSPAssetEntryCacheModel = new CacheModel<SPAssetEntry>() {
			@Override
			public SPAssetEntry toEntityModel() {
				return _nullSPAssetEntry;
			}
		};
}