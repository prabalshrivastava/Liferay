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

package com.sambaash.platform.srv.spprofile.service.persistence;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException;
import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;
import com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesImpl;
import com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the profile preferences service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see ProfilePreferencesPersistence
 * @see ProfilePreferencesUtil
 * @generated
 */
public class ProfilePreferencesPersistenceImpl extends BasePersistenceImpl<ProfilePreferences>
	implements ProfilePreferencesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProfilePreferencesUtil} to access the profile preferences persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProfilePreferencesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED,
			ProfilePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED,
			ProfilePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID =
		new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED,
			ProfilePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBylayOutIdAndPortletId",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID =
		new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED,
			ProfilePreferencesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBylayOutIdAndPortletId",
			new String[] { String.class.getName(), String.class.getName() },
			ProfilePreferencesModelImpl.LAYOUTID_COLUMN_BITMASK |
			ProfilePreferencesModelImpl.PORTLETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTIDANDPORTLETID = new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylayOutIdAndPortletId",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @return the matching profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findBylayOutIdAndPortletId(
		String layoutId, String portletId) throws SystemException {
		return findBylayOutIdAndPortletId(layoutId, portletId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of profile preferenceses
	 * @param end the upper bound of the range of profile preferenceses (not inclusive)
	 * @return the range of matching profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findBylayOutIdAndPortletId(
		String layoutId, String portletId, int start, int end)
		throws SystemException {
		return findBylayOutIdAndPortletId(layoutId, portletId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile preferenceses where layoutId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of profile preferenceses
	 * @param end the upper bound of the range of profile preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findBylayOutIdAndPortletId(
		String layoutId, String portletId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID;
			finderArgs = new Object[] { layoutId, portletId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID;
			finderArgs = new Object[] {
					layoutId, portletId,
					
					start, end, orderByComparator
				};
		}

		List<ProfilePreferences> list = (List<ProfilePreferences>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProfilePreferences profilePreferences : list) {
				if (!Validator.equals(layoutId, profilePreferences.getLayoutId()) ||
						!Validator.equals(portletId,
							profilePreferences.getPortletId())) {
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

			query.append(_SQL_SELECT_PROFILEPREFERENCES_WHERE);

			boolean bindLayoutId = false;

			if (layoutId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_1);
			}
			else if (layoutId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_3);
			}
			else {
				bindLayoutId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_2);
			}

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProfilePreferencesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayoutId) {
					qPos.add(layoutId);
				}

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (!pagination) {
					list = (List<ProfilePreferences>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProfilePreferences>(list);
				}
				else {
					list = (List<ProfilePreferences>)QueryUtil.list(q,
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
	 * Returns the first profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences findBylayOutIdAndPortletId_First(
		String layoutId, String portletId, OrderByComparator orderByComparator)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = fetchBylayOutIdAndPortletId_First(layoutId,
				portletId, orderByComparator);

		if (profilePreferences != null) {
			return profilePreferences;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layoutId=");
		msg.append(layoutId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfilePreferencesException(msg.toString());
	}

	/**
	 * Returns the first profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchBylayOutIdAndPortletId_First(
		String layoutId, String portletId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ProfilePreferences> list = findBylayOutIdAndPortletId(layoutId,
				portletId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences findBylayOutIdAndPortletId_Last(String layoutId,
		String portletId, OrderByComparator orderByComparator)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = fetchBylayOutIdAndPortletId_Last(layoutId,
				portletId, orderByComparator);

		if (profilePreferences != null) {
			return profilePreferences;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layoutId=");
		msg.append(layoutId);

		msg.append(", portletId=");
		msg.append(portletId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProfilePreferencesException(msg.toString());
	}

	/**
	 * Returns the last profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchBylayOutIdAndPortletId_Last(
		String layoutId, String portletId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBylayOutIdAndPortletId(layoutId, portletId);

		if (count == 0) {
			return null;
		}

		List<ProfilePreferences> list = findBylayOutIdAndPortletId(layoutId,
				portletId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the profile preferenceses before and after the current profile preferences in the ordered set where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param proferenceId the primary key of the current profile preferences
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences[] findBylayOutIdAndPortletId_PrevAndNext(
		long proferenceId, String layoutId, String portletId,
		OrderByComparator orderByComparator)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = findByPrimaryKey(proferenceId);

		Session session = null;

		try {
			session = openSession();

			ProfilePreferences[] array = new ProfilePreferencesImpl[3];

			array[0] = getBylayOutIdAndPortletId_PrevAndNext(session,
					profilePreferences, layoutId, portletId, orderByComparator,
					true);

			array[1] = profilePreferences;

			array[2] = getBylayOutIdAndPortletId_PrevAndNext(session,
					profilePreferences, layoutId, portletId, orderByComparator,
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

	protected ProfilePreferences getBylayOutIdAndPortletId_PrevAndNext(
		Session session, ProfilePreferences profilePreferences,
		String layoutId, String portletId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROFILEPREFERENCES_WHERE);

		boolean bindLayoutId = false;

		if (layoutId == null) {
			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_1);
		}
		else if (layoutId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_3);
		}
		else {
			bindLayoutId = true;

			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_2);
		}

		boolean bindPortletId = false;

		if (portletId == null) {
			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_1);
		}
		else if (portletId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_2);
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
			query.append(ProfilePreferencesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLayoutId) {
			qPos.add(layoutId);
		}

		if (bindPortletId) {
			qPos.add(portletId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(profilePreferences);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProfilePreferences> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the profile preferenceses where layoutId = &#63; and portletId = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylayOutIdAndPortletId(String layoutId, String portletId)
		throws SystemException {
		for (ProfilePreferences profilePreferences : findBylayOutIdAndPortletId(
				layoutId, portletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(profilePreferences);
		}
	}

	/**
	 * Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @return the number of matching profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylayOutIdAndPortletId(String layoutId, String portletId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYOUTIDANDPORTLETID;

		Object[] finderArgs = new Object[] { layoutId, portletId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROFILEPREFERENCES_WHERE);

			boolean bindLayoutId = false;

			if (layoutId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_1);
			}
			else if (layoutId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_3);
			}
			else {
				bindLayoutId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_2);
			}

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayoutId) {
					qPos.add(layoutId);
				}

				if (bindPortletId) {
					qPos.add(portletId);
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

	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_1 = "profilePreferences.layoutId IS NULL AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_2 = "profilePreferences.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_LAYOUTID_3 = "(profilePreferences.layoutId IS NULL OR profilePreferences.layoutId = '') AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_1 = "profilePreferences.portletId IS NULL";
	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_2 = "profilePreferences.portletId = ?";
	private static final String _FINDER_COLUMN_LAYOUTIDANDPORTLETID_PORTLETID_3 = "(profilePreferences.portletId IS NULL OR profilePreferences.portletId = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME =
		new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED,
			ProfilePreferencesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBylayOutIdPortletIdAndPreferenceName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ProfilePreferencesModelImpl.LAYOUTID_COLUMN_BITMASK |
			ProfilePreferencesModelImpl.PORTLETID_COLUMN_BITMASK |
			ProfilePreferencesModelImpl.PREFERENCENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME =
		new FinderPath(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylayOutIdPortletIdAndPreferenceName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or throws a {@link com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException} if it could not be found.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param preferenceName the preference name
	 * @return the matching profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences findBylayOutIdPortletIdAndPreferenceName(
		String layoutId, String portletId, String preferenceName)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = fetchBylayOutIdPortletIdAndPreferenceName(layoutId,
				portletId, preferenceName);

		if (profilePreferences == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("layoutId=");
			msg.append(layoutId);

			msg.append(", portletId=");
			msg.append(portletId);

			msg.append(", preferenceName=");
			msg.append(preferenceName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchProfilePreferencesException(msg.toString());
		}

		return profilePreferences;
	}

	/**
	 * Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param preferenceName the preference name
	 * @return the matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		String layoutId, String portletId, String preferenceName)
		throws SystemException {
		return fetchBylayOutIdPortletIdAndPreferenceName(layoutId, portletId,
			preferenceName, true);
	}

	/**
	 * Returns the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param preferenceName the preference name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching profile preferences, or <code>null</code> if a matching profile preferences could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchBylayOutIdPortletIdAndPreferenceName(
		String layoutId, String portletId, String preferenceName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { layoutId, portletId, preferenceName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
					finderArgs, this);
		}

		if (result instanceof ProfilePreferences) {
			ProfilePreferences profilePreferences = (ProfilePreferences)result;

			if (!Validator.equals(layoutId, profilePreferences.getLayoutId()) ||
					!Validator.equals(portletId,
						profilePreferences.getPortletId()) ||
					!Validator.equals(preferenceName,
						profilePreferences.getPreferenceName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_PROFILEPREFERENCES_WHERE);

			boolean bindLayoutId = false;

			if (layoutId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_1);
			}
			else if (layoutId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_3);
			}
			else {
				bindLayoutId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_2);
			}

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_2);
			}

			boolean bindPreferenceName = false;

			if (preferenceName == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_1);
			}
			else if (preferenceName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_3);
			}
			else {
				bindPreferenceName = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayoutId) {
					qPos.add(layoutId);
				}

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (bindPreferenceName) {
					qPos.add(preferenceName);
				}

				List<ProfilePreferences> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ProfilePreferencesPersistenceImpl.fetchBylayOutIdPortletIdAndPreferenceName(String, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ProfilePreferences profilePreferences = list.get(0);

					result = profilePreferences;

					cacheResult(profilePreferences);

					if ((profilePreferences.getLayoutId() == null) ||
							!profilePreferences.getLayoutId().equals(layoutId) ||
							(profilePreferences.getPortletId() == null) ||
							!profilePreferences.getPortletId().equals(portletId) ||
							(profilePreferences.getPreferenceName() == null) ||
							!profilePreferences.getPreferenceName()
												   .equals(preferenceName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
							finderArgs, profilePreferences);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
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
			return (ProfilePreferences)result;
		}
	}

	/**
	 * Removes the profile preferences where layoutId = &#63; and portletId = &#63; and preferenceName = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param preferenceName the preference name
	 * @return the profile preferences that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences removeBylayOutIdPortletIdAndPreferenceName(
		String layoutId, String portletId, String preferenceName)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = findBylayOutIdPortletIdAndPreferenceName(layoutId,
				portletId, preferenceName);

		return remove(profilePreferences);
	}

	/**
	 * Returns the number of profile preferenceses where layoutId = &#63; and portletId = &#63; and preferenceName = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param portletId the portlet ID
	 * @param preferenceName the preference name
	 * @return the number of matching profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylayOutIdPortletIdAndPreferenceName(String layoutId,
		String portletId, String preferenceName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME;

		Object[] finderArgs = new Object[] { layoutId, portletId, preferenceName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PROFILEPREFERENCES_WHERE);

			boolean bindLayoutId = false;

			if (layoutId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_1);
			}
			else if (layoutId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_3);
			}
			else {
				bindLayoutId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_2);
			}

			boolean bindPortletId = false;

			if (portletId == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_1);
			}
			else if (portletId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_2);
			}

			boolean bindPreferenceName = false;

			if (preferenceName == null) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_1);
			}
			else if (preferenceName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_3);
			}
			else {
				bindPreferenceName = true;

				query.append(_FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayoutId) {
					qPos.add(layoutId);
				}

				if (bindPortletId) {
					qPos.add(portletId);
				}

				if (bindPreferenceName) {
					qPos.add(preferenceName);
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

	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_1 =
		"profilePreferences.layoutId IS NULL AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_2 =
		"profilePreferences.layoutId = ? AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_LAYOUTID_3 =
		"(profilePreferences.layoutId IS NULL OR profilePreferences.layoutId = '') AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_1 =
		"profilePreferences.portletId IS NULL AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_2 =
		"profilePreferences.portletId = ? AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PORTLETID_3 =
		"(profilePreferences.portletId IS NULL OR profilePreferences.portletId = '') AND ";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_1 =
		"profilePreferences.preferenceName IS NULL";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_2 =
		"profilePreferences.preferenceName = ?";
	private static final String _FINDER_COLUMN_LAYOUTIDPORTLETIDANDPREFERENCENAME_PREFERENCENAME_3 =
		"(profilePreferences.preferenceName IS NULL OR profilePreferences.preferenceName = '')";

	public ProfilePreferencesPersistenceImpl() {
		setModelClass(ProfilePreferences.class);
	}

	/**
	 * Caches the profile preferences in the entity cache if it is enabled.
	 *
	 * @param profilePreferences the profile preferences
	 */
	@Override
	public void cacheResult(ProfilePreferences profilePreferences) {
		EntityCacheUtil.putResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesImpl.class, profilePreferences.getPrimaryKey(),
			profilePreferences);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
			new Object[] {
				profilePreferences.getLayoutId(),
				profilePreferences.getPortletId(),
				profilePreferences.getPreferenceName()
			}, profilePreferences);

		profilePreferences.resetOriginalValues();
	}

	/**
	 * Caches the profile preferenceses in the entity cache if it is enabled.
	 *
	 * @param profilePreferenceses the profile preferenceses
	 */
	@Override
	public void cacheResult(List<ProfilePreferences> profilePreferenceses) {
		for (ProfilePreferences profilePreferences : profilePreferenceses) {
			if (EntityCacheUtil.getResult(
						ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
						ProfilePreferencesImpl.class,
						profilePreferences.getPrimaryKey()) == null) {
				cacheResult(profilePreferences);
			}
			else {
				profilePreferences.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all profile preferenceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProfilePreferencesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProfilePreferencesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the profile preferences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProfilePreferences profilePreferences) {
		EntityCacheUtil.removeResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesImpl.class, profilePreferences.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(profilePreferences);
	}

	@Override
	public void clearCache(List<ProfilePreferences> profilePreferenceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProfilePreferences profilePreferences : profilePreferenceses) {
			EntityCacheUtil.removeResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
				ProfilePreferencesImpl.class, profilePreferences.getPrimaryKey());

			clearUniqueFindersCache(profilePreferences);
		}
	}

	protected void cacheUniqueFindersCache(
		ProfilePreferences profilePreferences) {
		if (profilePreferences.isNew()) {
			Object[] args = new Object[] {
					profilePreferences.getLayoutId(),
					profilePreferences.getPortletId(),
					profilePreferences.getPreferenceName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
				args, profilePreferences);
		}
		else {
			ProfilePreferencesModelImpl profilePreferencesModelImpl = (ProfilePreferencesModelImpl)profilePreferences;

			if ((profilePreferencesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						profilePreferences.getLayoutId(),
						profilePreferences.getPortletId(),
						profilePreferences.getPreferenceName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
					args, profilePreferences);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ProfilePreferences profilePreferences) {
		ProfilePreferencesModelImpl profilePreferencesModelImpl = (ProfilePreferencesModelImpl)profilePreferences;

		Object[] args = new Object[] {
				profilePreferences.getLayoutId(),
				profilePreferences.getPortletId(),
				profilePreferences.getPreferenceName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
			args);

		if ((profilePreferencesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					profilePreferencesModelImpl.getOriginalLayoutId(),
					profilePreferencesModelImpl.getOriginalPortletId(),
					profilePreferencesModelImpl.getOriginalPreferenceName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LAYOUTIDPORTLETIDANDPREFERENCENAME,
				args);
		}
	}

	/**
	 * Creates a new profile preferences with the primary key. Does not add the profile preferences to the database.
	 *
	 * @param proferenceId the primary key for the new profile preferences
	 * @return the new profile preferences
	 */
	@Override
	public ProfilePreferences create(long proferenceId) {
		ProfilePreferences profilePreferences = new ProfilePreferencesImpl();

		profilePreferences.setNew(true);
		profilePreferences.setPrimaryKey(proferenceId);

		return profilePreferences;
	}

	/**
	 * Removes the profile preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proferenceId the primary key of the profile preferences
	 * @return the profile preferences that was removed
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences remove(long proferenceId)
		throws NoSuchProfilePreferencesException, SystemException {
		return remove((Serializable)proferenceId);
	}

	/**
	 * Removes the profile preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the profile preferences
	 * @return the profile preferences that was removed
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences remove(Serializable primaryKey)
		throws NoSuchProfilePreferencesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProfilePreferences profilePreferences = (ProfilePreferences)session.get(ProfilePreferencesImpl.class,
					primaryKey);

			if (profilePreferences == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProfilePreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(profilePreferences);
		}
		catch (NoSuchProfilePreferencesException nsee) {
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
	protected ProfilePreferences removeImpl(
		ProfilePreferences profilePreferences) throws SystemException {
		profilePreferences = toUnwrappedModel(profilePreferences);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(profilePreferences)) {
				profilePreferences = (ProfilePreferences)session.get(ProfilePreferencesImpl.class,
						profilePreferences.getPrimaryKeyObj());
			}

			if (profilePreferences != null) {
				session.delete(profilePreferences);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (profilePreferences != null) {
			clearCache(profilePreferences);
		}

		return profilePreferences;
	}

	@Override
	public ProfilePreferences updateImpl(
		com.sambaash.platform.srv.spprofile.model.ProfilePreferences profilePreferences)
		throws SystemException {
		profilePreferences = toUnwrappedModel(profilePreferences);

		boolean isNew = profilePreferences.isNew();

		ProfilePreferencesModelImpl profilePreferencesModelImpl = (ProfilePreferencesModelImpl)profilePreferences;

		Session session = null;

		try {
			session = openSession();

			if (profilePreferences.isNew()) {
				session.save(profilePreferences);

				profilePreferences.setNew(false);
			}
			else {
				session.merge(profilePreferences);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProfilePreferencesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((profilePreferencesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						profilePreferencesModelImpl.getOriginalLayoutId(),
						profilePreferencesModelImpl.getOriginalPortletId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDANDPORTLETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID,
					args);

				args = new Object[] {
						profilePreferencesModelImpl.getLayoutId(),
						profilePreferencesModelImpl.getPortletId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYOUTIDANDPORTLETID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYOUTIDANDPORTLETID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
			ProfilePreferencesImpl.class, profilePreferences.getPrimaryKey(),
			profilePreferences);

		clearUniqueFindersCache(profilePreferences);
		cacheUniqueFindersCache(profilePreferences);

		return profilePreferences;
	}

	protected ProfilePreferences toUnwrappedModel(
		ProfilePreferences profilePreferences) {
		if (profilePreferences instanceof ProfilePreferencesImpl) {
			return profilePreferences;
		}

		ProfilePreferencesImpl profilePreferencesImpl = new ProfilePreferencesImpl();

		profilePreferencesImpl.setNew(profilePreferences.isNew());
		profilePreferencesImpl.setPrimaryKey(profilePreferences.getPrimaryKey());

		profilePreferencesImpl.setProferenceId(profilePreferences.getProferenceId());
		profilePreferencesImpl.setGroupId(profilePreferences.getGroupId());
		profilePreferencesImpl.setCompanyId(profilePreferences.getCompanyId());
		profilePreferencesImpl.setUserId(profilePreferences.getUserId());
		profilePreferencesImpl.setUserName(profilePreferences.getUserName());
		profilePreferencesImpl.setCreateDate(profilePreferences.getCreateDate());
		profilePreferencesImpl.setModifiedDate(profilePreferences.getModifiedDate());
		profilePreferencesImpl.setLayoutId(profilePreferences.getLayoutId());
		profilePreferencesImpl.setPortletId(profilePreferences.getPortletId());
		profilePreferencesImpl.setPreferenceName(profilePreferences.getPreferenceName());
		profilePreferencesImpl.setPortletPreferences(profilePreferences.getPortletPreferences());

		return profilePreferencesImpl;
	}

	/**
	 * Returns the profile preferences with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile preferences
	 * @return the profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProfilePreferencesException, SystemException {
		ProfilePreferences profilePreferences = fetchByPrimaryKey(primaryKey);

		if (profilePreferences == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProfilePreferencesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return profilePreferences;
	}

	/**
	 * Returns the profile preferences with the primary key or throws a {@link com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException} if it could not be found.
	 *
	 * @param proferenceId the primary key of the profile preferences
	 * @return the profile preferences
	 * @throws com.sambaash.platform.srv.spprofile.NoSuchProfilePreferencesException if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences findByPrimaryKey(long proferenceId)
		throws NoSuchProfilePreferencesException, SystemException {
		return findByPrimaryKey((Serializable)proferenceId);
	}

	/**
	 * Returns the profile preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the profile preferences
	 * @return the profile preferences, or <code>null</code> if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProfilePreferences profilePreferences = (ProfilePreferences)EntityCacheUtil.getResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
				ProfilePreferencesImpl.class, primaryKey);

		if (profilePreferences == _nullProfilePreferences) {
			return null;
		}

		if (profilePreferences == null) {
			Session session = null;

			try {
				session = openSession();

				profilePreferences = (ProfilePreferences)session.get(ProfilePreferencesImpl.class,
						primaryKey);

				if (profilePreferences != null) {
					cacheResult(profilePreferences);
				}
				else {
					EntityCacheUtil.putResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
						ProfilePreferencesImpl.class, primaryKey,
						_nullProfilePreferences);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProfilePreferencesModelImpl.ENTITY_CACHE_ENABLED,
					ProfilePreferencesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return profilePreferences;
	}

	/**
	 * Returns the profile preferences with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proferenceId the primary key of the profile preferences
	 * @return the profile preferences, or <code>null</code> if a profile preferences with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProfilePreferences fetchByPrimaryKey(long proferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)proferenceId);
	}

	/**
	 * Returns all the profile preferenceses.
	 *
	 * @return the profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the profile preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile preferenceses
	 * @param end the upper bound of the range of profile preferenceses (not inclusive)
	 * @return the range of profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the profile preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spprofile.model.impl.ProfilePreferencesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of profile preferenceses
	 * @param end the upper bound of the range of profile preferenceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of profile preferenceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProfilePreferences> findAll(int start, int end,
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

		List<ProfilePreferences> list = (List<ProfilePreferences>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROFILEPREFERENCES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROFILEPREFERENCES;

				if (pagination) {
					sql = sql.concat(ProfilePreferencesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProfilePreferences>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProfilePreferences>(list);
				}
				else {
					list = (List<ProfilePreferences>)QueryUtil.list(q,
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
	 * Removes all the profile preferenceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProfilePreferences profilePreferences : findAll()) {
			remove(profilePreferences);
		}
	}

	/**
	 * Returns the number of profile preferenceses.
	 *
	 * @return the number of profile preferenceses
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

				Query q = session.createQuery(_SQL_COUNT_PROFILEPREFERENCES);

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

	/**
	 * Initializes the profile preferences persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spprofile.model.ProfilePreferences")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProfilePreferences>> listenersList = new ArrayList<ModelListener<ProfilePreferences>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProfilePreferences>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProfilePreferencesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROFILEPREFERENCES = "SELECT profilePreferences FROM ProfilePreferences profilePreferences";
	private static final String _SQL_SELECT_PROFILEPREFERENCES_WHERE = "SELECT profilePreferences FROM ProfilePreferences profilePreferences WHERE ";
	private static final String _SQL_COUNT_PROFILEPREFERENCES = "SELECT COUNT(profilePreferences) FROM ProfilePreferences profilePreferences";
	private static final String _SQL_COUNT_PROFILEPREFERENCES_WHERE = "SELECT COUNT(profilePreferences) FROM ProfilePreferences profilePreferences WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "profilePreferences.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProfilePreferences exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProfilePreferences exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProfilePreferencesPersistenceImpl.class);
	private static ProfilePreferences _nullProfilePreferences = new ProfilePreferencesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProfilePreferences> toCacheModel() {
				return _nullProfilePreferencesCacheModel;
			}
		};

	private static CacheModel<ProfilePreferences> _nullProfilePreferencesCacheModel =
		new CacheModel<ProfilePreferences>() {
			@Override
			public ProfilePreferences toEntityModel() {
				return _nullProfilePreferences;
			}
		};
}