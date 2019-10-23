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

package com.sambaash.platform.srv.spdashboard.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException;
import com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig;
import com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigImpl;
import com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the s p analytics config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPAnalyticsConfigPersistence
 * @see SPAnalyticsConfigUtil
 * @generated
 */
public class SPAnalyticsConfigPersistenceImpl extends BasePersistenceImpl<SPAnalyticsConfig>
	implements SPAnalyticsConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPAnalyticsConfigUtil} to access the s p analytics config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPAnalyticsConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WARIDANDTYPE =
		new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWarIdAndType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARIDANDTYPE =
		new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWarIdAndType",
			new String[] { String.class.getName(), Integer.class.getName() },
			SPAnalyticsConfigModelImpl.WARID_COLUMN_BITMASK |
			SPAnalyticsConfigModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WARIDANDTYPE = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWarIdAndType",
			new String[] { String.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the s p analytics configs where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @return the matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarIdAndType(String warId, int type)
		throws SystemException {
		return findByWarIdAndType(warId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p analytics configs where warId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @return the range of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarIdAndType(String warId, int type,
		int start, int end) throws SystemException {
		return findByWarIdAndType(warId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p analytics configs where warId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarIdAndType(String warId, int type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARIDANDTYPE;
			finderArgs = new Object[] { warId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WARIDANDTYPE;
			finderArgs = new Object[] { warId, type, start, end, orderByComparator };
		}

		List<SPAnalyticsConfig> list = (List<SPAnalyticsConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAnalyticsConfig spAnalyticsConfig : list) {
				if (!Validator.equals(warId, spAnalyticsConfig.getWarId()) ||
						(type != spAnalyticsConfig.getType())) {
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

			query.append(_SQL_SELECT_SPANALYTICSCONFIG_WHERE);

			boolean bindWarId = false;

			if (warId == null) {
				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_1);
			}
			else if (warId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_3);
			}
			else {
				bindWarId = true;

				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_2);
			}

			query.append(_FINDER_COLUMN_WARIDANDTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAnalyticsConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWarId) {
					qPos.add(warId);
				}

				qPos.add(type);

				if (!pagination) {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAnalyticsConfig>(list);
				}
				else {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
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
	 * Returns the first s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByWarIdAndType_First(String warId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = fetchByWarIdAndType_First(warId,
				type, orderByComparator);

		if (spAnalyticsConfig != null) {
			return spAnalyticsConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("warId=");
		msg.append(warId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPAnalyticsConfigException(msg.toString());
	}

	/**
	 * Returns the first s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByWarIdAndType_First(String warId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPAnalyticsConfig> list = findByWarIdAndType(warId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByWarIdAndType_Last(String warId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = fetchByWarIdAndType_Last(warId,
				type, orderByComparator);

		if (spAnalyticsConfig != null) {
			return spAnalyticsConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("warId=");
		msg.append(warId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPAnalyticsConfigException(msg.toString());
	}

	/**
	 * Returns the last s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByWarIdAndType_Last(String warId, int type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWarIdAndType(warId, type);

		if (count == 0) {
			return null;
		}

		List<SPAnalyticsConfig> list = findByWarIdAndType(warId, type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p analytics configs before and after the current s p analytics config in the ordered set where warId = &#63; and type = &#63;.
	 *
	 * @param spAnalyticsConfigId the primary key of the current s p analytics config
	 * @param warId the war ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig[] findByWarIdAndType_PrevAndNext(
		long spAnalyticsConfigId, String warId, int type,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = findByPrimaryKey(spAnalyticsConfigId);

		Session session = null;

		try {
			session = openSession();

			SPAnalyticsConfig[] array = new SPAnalyticsConfigImpl[3];

			array[0] = getByWarIdAndType_PrevAndNext(session,
					spAnalyticsConfig, warId, type, orderByComparator, true);

			array[1] = spAnalyticsConfig;

			array[2] = getByWarIdAndType_PrevAndNext(session,
					spAnalyticsConfig, warId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPAnalyticsConfig getByWarIdAndType_PrevAndNext(Session session,
		SPAnalyticsConfig spAnalyticsConfig, String warId, int type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPANALYTICSCONFIG_WHERE);

		boolean bindWarId = false;

		if (warId == null) {
			query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_1);
		}
		else if (warId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_3);
		}
		else {
			bindWarId = true;

			query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_2);
		}

		query.append(_FINDER_COLUMN_WARIDANDTYPE_TYPE_2);

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
			query.append(SPAnalyticsConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWarId) {
			qPos.add(warId);
		}

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAnalyticsConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAnalyticsConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p analytics configs where warId = &#63; and type = &#63; from the database.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWarIdAndType(String warId, int type)
		throws SystemException {
		for (SPAnalyticsConfig spAnalyticsConfig : findByWarIdAndType(warId,
				type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAnalyticsConfig);
		}
	}

	/**
	 * Returns the number of s p analytics configs where warId = &#63; and type = &#63;.
	 *
	 * @param warId the war ID
	 * @param type the type
	 * @return the number of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWarIdAndType(String warId, int type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WARIDANDTYPE;

		Object[] finderArgs = new Object[] { warId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPANALYTICSCONFIG_WHERE);

			boolean bindWarId = false;

			if (warId == null) {
				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_1);
			}
			else if (warId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_3);
			}
			else {
				bindWarId = true;

				query.append(_FINDER_COLUMN_WARIDANDTYPE_WARID_2);
			}

			query.append(_FINDER_COLUMN_WARIDANDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWarId) {
					qPos.add(warId);
				}

				qPos.add(type);

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

	private static final String _FINDER_COLUMN_WARIDANDTYPE_WARID_1 = "spAnalyticsConfig.warId IS NULL AND ";
	private static final String _FINDER_COLUMN_WARIDANDTYPE_WARID_2 = "spAnalyticsConfig.warId = ? AND ";
	private static final String _FINDER_COLUMN_WARIDANDTYPE_WARID_3 = "(spAnalyticsConfig.warId IS NULL OR spAnalyticsConfig.warId = '') AND ";
	private static final String _FINDER_COLUMN_WARIDANDTYPE_TYPE_2 = "spAnalyticsConfig.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WARID = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWarId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARID = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWarId",
			new String[] { String.class.getName() },
			SPAnalyticsConfigModelImpl.WARID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WARID = new FinderPath(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWarId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the s p analytics configs where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @return the matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarId(String warId)
		throws SystemException {
		return findByWarId(warId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p analytics configs where warId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param warId the war ID
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @return the range of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarId(String warId, int start, int end)
		throws SystemException {
		return findByWarId(warId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p analytics configs where warId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param warId the war ID
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findByWarId(String warId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARID;
			finderArgs = new Object[] { warId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WARID;
			finderArgs = new Object[] { warId, start, end, orderByComparator };
		}

		List<SPAnalyticsConfig> list = (List<SPAnalyticsConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPAnalyticsConfig spAnalyticsConfig : list) {
				if (!Validator.equals(warId, spAnalyticsConfig.getWarId())) {
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

			query.append(_SQL_SELECT_SPANALYTICSCONFIG_WHERE);

			boolean bindWarId = false;

			if (warId == null) {
				query.append(_FINDER_COLUMN_WARID_WARID_1);
			}
			else if (warId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WARID_WARID_3);
			}
			else {
				bindWarId = true;

				query.append(_FINDER_COLUMN_WARID_WARID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPAnalyticsConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWarId) {
					qPos.add(warId);
				}

				if (!pagination) {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAnalyticsConfig>(list);
				}
				else {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
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
	 * Returns the first s p analytics config in the ordered set where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByWarId_First(String warId,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = fetchByWarId_First(warId,
				orderByComparator);

		if (spAnalyticsConfig != null) {
			return spAnalyticsConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("warId=");
		msg.append(warId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPAnalyticsConfigException(msg.toString());
	}

	/**
	 * Returns the first s p analytics config in the ordered set where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByWarId_First(String warId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPAnalyticsConfig> list = findByWarId(warId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p analytics config in the ordered set where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByWarId_Last(String warId,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = fetchByWarId_Last(warId,
				orderByComparator);

		if (spAnalyticsConfig != null) {
			return spAnalyticsConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("warId=");
		msg.append(warId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPAnalyticsConfigException(msg.toString());
	}

	/**
	 * Returns the last s p analytics config in the ordered set where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p analytics config, or <code>null</code> if a matching s p analytics config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByWarId_Last(String warId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWarId(warId);

		if (count == 0) {
			return null;
		}

		List<SPAnalyticsConfig> list = findByWarId(warId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p analytics configs before and after the current s p analytics config in the ordered set where warId = &#63;.
	 *
	 * @param spAnalyticsConfigId the primary key of the current s p analytics config
	 * @param warId the war ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig[] findByWarId_PrevAndNext(
		long spAnalyticsConfigId, String warId,
		OrderByComparator orderByComparator)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = findByPrimaryKey(spAnalyticsConfigId);

		Session session = null;

		try {
			session = openSession();

			SPAnalyticsConfig[] array = new SPAnalyticsConfigImpl[3];

			array[0] = getByWarId_PrevAndNext(session, spAnalyticsConfig,
					warId, orderByComparator, true);

			array[1] = spAnalyticsConfig;

			array[2] = getByWarId_PrevAndNext(session, spAnalyticsConfig,
					warId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPAnalyticsConfig getByWarId_PrevAndNext(Session session,
		SPAnalyticsConfig spAnalyticsConfig, String warId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPANALYTICSCONFIG_WHERE);

		boolean bindWarId = false;

		if (warId == null) {
			query.append(_FINDER_COLUMN_WARID_WARID_1);
		}
		else if (warId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_WARID_WARID_3);
		}
		else {
			bindWarId = true;

			query.append(_FINDER_COLUMN_WARID_WARID_2);
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
			query.append(SPAnalyticsConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWarId) {
			qPos.add(warId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spAnalyticsConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPAnalyticsConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p analytics configs where warId = &#63; from the database.
	 *
	 * @param warId the war ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWarId(String warId) throws SystemException {
		for (SPAnalyticsConfig spAnalyticsConfig : findByWarId(warId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spAnalyticsConfig);
		}
	}

	/**
	 * Returns the number of s p analytics configs where warId = &#63;.
	 *
	 * @param warId the war ID
	 * @return the number of matching s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWarId(String warId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WARID;

		Object[] finderArgs = new Object[] { warId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPANALYTICSCONFIG_WHERE);

			boolean bindWarId = false;

			if (warId == null) {
				query.append(_FINDER_COLUMN_WARID_WARID_1);
			}
			else if (warId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WARID_WARID_3);
			}
			else {
				bindWarId = true;

				query.append(_FINDER_COLUMN_WARID_WARID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWarId) {
					qPos.add(warId);
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

	private static final String _FINDER_COLUMN_WARID_WARID_1 = "spAnalyticsConfig.warId IS NULL";
	private static final String _FINDER_COLUMN_WARID_WARID_2 = "spAnalyticsConfig.warId = ?";
	private static final String _FINDER_COLUMN_WARID_WARID_3 = "(spAnalyticsConfig.warId IS NULL OR spAnalyticsConfig.warId = '')";

	public SPAnalyticsConfigPersistenceImpl() {
		setModelClass(SPAnalyticsConfig.class);
	}

	/**
	 * Caches the s p analytics config in the entity cache if it is enabled.
	 *
	 * @param spAnalyticsConfig the s p analytics config
	 */
	@Override
	public void cacheResult(SPAnalyticsConfig spAnalyticsConfig) {
		EntityCacheUtil.putResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class, spAnalyticsConfig.getPrimaryKey(),
			spAnalyticsConfig);

		spAnalyticsConfig.resetOriginalValues();
	}

	/**
	 * Caches the s p analytics configs in the entity cache if it is enabled.
	 *
	 * @param spAnalyticsConfigs the s p analytics configs
	 */
	@Override
	public void cacheResult(List<SPAnalyticsConfig> spAnalyticsConfigs) {
		for (SPAnalyticsConfig spAnalyticsConfig : spAnalyticsConfigs) {
			if (EntityCacheUtil.getResult(
						SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
						SPAnalyticsConfigImpl.class,
						spAnalyticsConfig.getPrimaryKey()) == null) {
				cacheResult(spAnalyticsConfig);
			}
			else {
				spAnalyticsConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p analytics configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPAnalyticsConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPAnalyticsConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p analytics config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPAnalyticsConfig spAnalyticsConfig) {
		EntityCacheUtil.removeResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class, spAnalyticsConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SPAnalyticsConfig> spAnalyticsConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPAnalyticsConfig spAnalyticsConfig : spAnalyticsConfigs) {
			EntityCacheUtil.removeResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
				SPAnalyticsConfigImpl.class, spAnalyticsConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s p analytics config with the primary key. Does not add the s p analytics config to the database.
	 *
	 * @param spAnalyticsConfigId the primary key for the new s p analytics config
	 * @return the new s p analytics config
	 */
	@Override
	public SPAnalyticsConfig create(long spAnalyticsConfigId) {
		SPAnalyticsConfig spAnalyticsConfig = new SPAnalyticsConfigImpl();

		spAnalyticsConfig.setNew(true);
		spAnalyticsConfig.setPrimaryKey(spAnalyticsConfigId);

		return spAnalyticsConfig;
	}

	/**
	 * Removes the s p analytics config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spAnalyticsConfigId the primary key of the s p analytics config
	 * @return the s p analytics config that was removed
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig remove(long spAnalyticsConfigId)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		return remove((Serializable)spAnalyticsConfigId);
	}

	/**
	 * Removes the s p analytics config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p analytics config
	 * @return the s p analytics config that was removed
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig remove(Serializable primaryKey)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPAnalyticsConfig spAnalyticsConfig = (SPAnalyticsConfig)session.get(SPAnalyticsConfigImpl.class,
					primaryKey);

			if (spAnalyticsConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPAnalyticsConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spAnalyticsConfig);
		}
		catch (NoSuchSPAnalyticsConfigException nsee) {
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
	protected SPAnalyticsConfig removeImpl(SPAnalyticsConfig spAnalyticsConfig)
		throws SystemException {
		spAnalyticsConfig = toUnwrappedModel(spAnalyticsConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spAnalyticsConfig)) {
				spAnalyticsConfig = (SPAnalyticsConfig)session.get(SPAnalyticsConfigImpl.class,
						spAnalyticsConfig.getPrimaryKeyObj());
			}

			if (spAnalyticsConfig != null) {
				session.delete(spAnalyticsConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spAnalyticsConfig != null) {
			clearCache(spAnalyticsConfig);
		}

		return spAnalyticsConfig;
	}

	@Override
	public SPAnalyticsConfig updateImpl(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig)
		throws SystemException {
		spAnalyticsConfig = toUnwrappedModel(spAnalyticsConfig);

		boolean isNew = spAnalyticsConfig.isNew();

		SPAnalyticsConfigModelImpl spAnalyticsConfigModelImpl = (SPAnalyticsConfigModelImpl)spAnalyticsConfig;

		Session session = null;

		try {
			session = openSession();

			if (spAnalyticsConfig.isNew()) {
				session.save(spAnalyticsConfig);

				spAnalyticsConfig.setNew(false);
			}
			else {
				session.merge(spAnalyticsConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPAnalyticsConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spAnalyticsConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARIDANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAnalyticsConfigModelImpl.getOriginalWarId(),
						spAnalyticsConfigModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WARIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARIDANDTYPE,
					args);

				args = new Object[] {
						spAnalyticsConfigModelImpl.getWarId(),
						spAnalyticsConfigModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WARIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARIDANDTYPE,
					args);
			}

			if ((spAnalyticsConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spAnalyticsConfigModelImpl.getOriginalWarId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WARID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARID,
					args);

				args = new Object[] { spAnalyticsConfigModelImpl.getWarId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WARID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WARID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
			SPAnalyticsConfigImpl.class, spAnalyticsConfig.getPrimaryKey(),
			spAnalyticsConfig);

		return spAnalyticsConfig;
	}

	protected SPAnalyticsConfig toUnwrappedModel(
		SPAnalyticsConfig spAnalyticsConfig) {
		if (spAnalyticsConfig instanceof SPAnalyticsConfigImpl) {
			return spAnalyticsConfig;
		}

		SPAnalyticsConfigImpl spAnalyticsConfigImpl = new SPAnalyticsConfigImpl();

		spAnalyticsConfigImpl.setNew(spAnalyticsConfig.isNew());
		spAnalyticsConfigImpl.setPrimaryKey(spAnalyticsConfig.getPrimaryKey());

		spAnalyticsConfigImpl.setSpAnalyticsConfigId(spAnalyticsConfig.getSpAnalyticsConfigId());
		spAnalyticsConfigImpl.setName(spAnalyticsConfig.getName());
		spAnalyticsConfigImpl.setConfig(spAnalyticsConfig.getConfig());
		spAnalyticsConfigImpl.setType(spAnalyticsConfig.getType());
		spAnalyticsConfigImpl.setQuery(spAnalyticsConfig.getQuery());
		spAnalyticsConfigImpl.setWarId(spAnalyticsConfig.getWarId());

		return spAnalyticsConfigImpl;
	}

	/**
	 * Returns the s p analytics config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p analytics config
	 * @return the s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		SPAnalyticsConfig spAnalyticsConfig = fetchByPrimaryKey(primaryKey);

		if (spAnalyticsConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPAnalyticsConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spAnalyticsConfig;
	}

	/**
	 * Returns the s p analytics config with the primary key or throws a {@link com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException} if it could not be found.
	 *
	 * @param spAnalyticsConfigId the primary key of the s p analytics config
	 * @return the s p analytics config
	 * @throws com.sambaash.platform.srv.spdashboard.NoSuchSPAnalyticsConfigException if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig findByPrimaryKey(long spAnalyticsConfigId)
		throws NoSuchSPAnalyticsConfigException, SystemException {
		return findByPrimaryKey((Serializable)spAnalyticsConfigId);
	}

	/**
	 * Returns the s p analytics config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p analytics config
	 * @return the s p analytics config, or <code>null</code> if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPAnalyticsConfig spAnalyticsConfig = (SPAnalyticsConfig)EntityCacheUtil.getResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
				SPAnalyticsConfigImpl.class, primaryKey);

		if (spAnalyticsConfig == _nullSPAnalyticsConfig) {
			return null;
		}

		if (spAnalyticsConfig == null) {
			Session session = null;

			try {
				session = openSession();

				spAnalyticsConfig = (SPAnalyticsConfig)session.get(SPAnalyticsConfigImpl.class,
						primaryKey);

				if (spAnalyticsConfig != null) {
					cacheResult(spAnalyticsConfig);
				}
				else {
					EntityCacheUtil.putResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
						SPAnalyticsConfigImpl.class, primaryKey,
						_nullSPAnalyticsConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPAnalyticsConfigModelImpl.ENTITY_CACHE_ENABLED,
					SPAnalyticsConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spAnalyticsConfig;
	}

	/**
	 * Returns the s p analytics config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spAnalyticsConfigId the primary key of the s p analytics config
	 * @return the s p analytics config, or <code>null</code> if a s p analytics config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPAnalyticsConfig fetchByPrimaryKey(long spAnalyticsConfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spAnalyticsConfigId);
	}

	/**
	 * Returns all the s p analytics configs.
	 *
	 * @return the s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p analytics configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @return the range of s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p analytics configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spdashboard.model.impl.SPAnalyticsConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p analytics configs
	 * @param end the upper bound of the range of s p analytics configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p analytics configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPAnalyticsConfig> findAll(int start, int end,
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

		List<SPAnalyticsConfig> list = (List<SPAnalyticsConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPANALYTICSCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPANALYTICSCONFIG;

				if (pagination) {
					sql = sql.concat(SPAnalyticsConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPAnalyticsConfig>(list);
				}
				else {
					list = (List<SPAnalyticsConfig>)QueryUtil.list(q,
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
	 * Removes all the s p analytics configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPAnalyticsConfig spAnalyticsConfig : findAll()) {
			remove(spAnalyticsConfig);
		}
	}

	/**
	 * Returns the number of s p analytics configs.
	 *
	 * @return the number of s p analytics configs
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

				Query q = session.createQuery(_SQL_COUNT_SPANALYTICSCONFIG);

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
	 * Initializes the s p analytics config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPAnalyticsConfig>> listenersList = new ArrayList<ModelListener<SPAnalyticsConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPAnalyticsConfig>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPAnalyticsConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPANALYTICSCONFIG = "SELECT spAnalyticsConfig FROM SPAnalyticsConfig spAnalyticsConfig";
	private static final String _SQL_SELECT_SPANALYTICSCONFIG_WHERE = "SELECT spAnalyticsConfig FROM SPAnalyticsConfig spAnalyticsConfig WHERE ";
	private static final String _SQL_COUNT_SPANALYTICSCONFIG = "SELECT COUNT(spAnalyticsConfig) FROM SPAnalyticsConfig spAnalyticsConfig";
	private static final String _SQL_COUNT_SPANALYTICSCONFIG_WHERE = "SELECT COUNT(spAnalyticsConfig) FROM SPAnalyticsConfig spAnalyticsConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spAnalyticsConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPAnalyticsConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPAnalyticsConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPAnalyticsConfigPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static SPAnalyticsConfig _nullSPAnalyticsConfig = new SPAnalyticsConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPAnalyticsConfig> toCacheModel() {
				return _nullSPAnalyticsConfigCacheModel;
			}
		};

	private static CacheModel<SPAnalyticsConfig> _nullSPAnalyticsConfigCacheModel =
		new CacheModel<SPAnalyticsConfig>() {
			@Override
			public SPAnalyticsConfig toEntityModel() {
				return _nullSPAnalyticsConfig;
			}
		};
}