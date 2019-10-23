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

package com.sambaash.platform.srv.spservices.service.persistence;

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

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException;
import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership package addon services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServicesPersistence
 * @see MembershipPackageAddonServicesUtil
 * @generated
 */
public class MembershipPackageAddonServicesPersistenceImpl
	extends BasePersistenceImpl<MembershipPackageAddonServices>
	implements MembershipPackageAddonServicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackageAddonServicesUtil} to access the membership package addon services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackageAddonServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID =
		new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageAddonServicesScId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID =
		new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageAddonServicesScId",
			new String[] { String.class.getName() },
			MembershipPackageAddonServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipPackageAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID =
		new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageAddonServicesScId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership package addon serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		String scId) throws SystemException {
		return findByMembershipPackageAddonServicesScId(scId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package addon serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @return the range of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		String scId, int start, int end) throws SystemException {
		return findByMembershipPackageAddonServicesScId(scId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package addon serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
		String scId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID;
			finderArgs = new Object[] { scId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID;
			finderArgs = new Object[] { scId, start, end, orderByComparator };
		}

		List<MembershipPackageAddonServices> list = (List<MembershipPackageAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageAddonServices membershipPackageAddonServices : list) {
				if (!Validator.equals(scId,
							membershipPackageAddonServices.getScId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageAddonServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScId) {
					qPos.add(scId);
				}

				if (!pagination) {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageAddonServices>(list);
				}
				else {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership package addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = fetchByMembershipPackageAddonServicesScId_First(scId,
				orderByComparator);

		if (membershipPackageAddonServices != null) {
			return membershipPackageAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageAddonServices> list = findByMembershipPackageAddonServicesScId(scId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByMembershipPackageAddonServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = fetchByMembershipPackageAddonServicesScId_Last(scId,
				orderByComparator);

		if (membershipPackageAddonServices != null) {
			return membershipPackageAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByMembershipPackageAddonServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageAddonServicesScId(scId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageAddonServices> list = findByMembershipPackageAddonServicesScId(scId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package addon serviceses before and after the current membership package addon services in the ordered set where scId = &#63;.
	 *
	 * @param mpAddonId the primary key of the current membership package addon services
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices[] findByMembershipPackageAddonServicesScId_PrevAndNext(
		long mpAddonId, String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = findByPrimaryKey(mpAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageAddonServices[] array = new MembershipPackageAddonServicesImpl[3];

			array[0] = getByMembershipPackageAddonServicesScId_PrevAndNext(session,
					membershipPackageAddonServices, scId, orderByComparator,
					true);

			array[1] = membershipPackageAddonServices;

			array[2] = getByMembershipPackageAddonServicesScId_PrevAndNext(session,
					membershipPackageAddonServices, scId, orderByComparator,
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

	protected MembershipPackageAddonServices getByMembershipPackageAddonServicesScId_PrevAndNext(
		Session session,
		MembershipPackageAddonServices membershipPackageAddonServices,
		String scId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_2);
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
			query.append(MembershipPackageAddonServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScId) {
			qPos.add(scId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package addon serviceses where scId = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageAddonServicesScId(String scId)
		throws SystemException {
		for (MembershipPackageAddonServices membershipPackageAddonServices : findByMembershipPackageAddonServicesScId(
				scId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageAddonServices);
		}
	}

	/**
	 * Returns the number of membership package addon serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the number of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageAddonServicesScId(String scId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID;

		Object[] finderArgs = new Object[] { scId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScId) {
					qPos.add(scId);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_1 =
		"membershipPackageAddonServices.scId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_2 =
		"membershipPackageAddonServices.scId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEADDONSERVICESSCID_SCID_3 =
		"(membershipPackageAddonServices.scId IS NULL OR membershipPackageAddonServices.scId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceNameMpId",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceNameMpId",
			new String[] { String.class.getName(), String.class.getName() },
			MembershipPackageAddonServicesModelImpl.EXTRA1_COLUMN_BITMASK |
			MembershipPackageAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICENAMEMPID = new FinderPath(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceNameMpId",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @return the matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByServiceNameMpId(
		String extra1, String scName) throws SystemException {
		return findByServiceNameMpId(extra1, scName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @return the range of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByServiceNameMpId(
		String extra1, String scName, int start, int end)
		throws SystemException {
		return findByServiceNameMpId(extra1, scName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findByServiceNameMpId(
		String extra1, String scName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] { extra1, scName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] {
					extra1, scName,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageAddonServices> list = (List<MembershipPackageAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageAddonServices membershipPackageAddonServices : list) {
				if (!Validator.equals(extra1,
							membershipPackageAddonServices.getExtra1()) ||
						!Validator.equals(scName,
							membershipPackageAddonServices.getScName())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2);
			}

			boolean bindScName = false;

			if (scName == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_1);
			}
			else if (scName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_3);
			}
			else {
				bindScName = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageAddonServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExtra1) {
					qPos.add(extra1);
				}

				if (bindScName) {
					qPos.add(scName);
				}

				if (!pagination) {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageAddonServices>(list);
				}
				else {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByServiceNameMpId_First(
		String extra1, String scName, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = fetchByServiceNameMpId_First(extra1,
				scName, orderByComparator);

		if (membershipPackageAddonServices != null) {
			return membershipPackageAddonServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(", scName=");
		msg.append(scName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByServiceNameMpId_First(
		String extra1, String scName, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageAddonServices> list = findByServiceNameMpId(extra1,
				scName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByServiceNameMpId_Last(
		String extra1, String scName, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = fetchByServiceNameMpId_Last(extra1,
				scName, orderByComparator);

		if (membershipPackageAddonServices != null) {
			return membershipPackageAddonServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(", scName=");
		msg.append(scName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package addon services, or <code>null</code> if a matching membership package addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByServiceNameMpId_Last(
		String extra1, String scName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceNameMpId(extra1, scName);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageAddonServices> list = findByServiceNameMpId(extra1,
				scName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package addon serviceses before and after the current membership package addon services in the ordered set where extra1 = &#63; and scName = &#63;.
	 *
	 * @param mpAddonId the primary key of the current membership package addon services
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices[] findByServiceNameMpId_PrevAndNext(
		long mpAddonId, String extra1, String scName,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = findByPrimaryKey(mpAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageAddonServices[] array = new MembershipPackageAddonServicesImpl[3];

			array[0] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageAddonServices, extra1, scName,
					orderByComparator, true);

			array[1] = membershipPackageAddonServices;

			array[2] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageAddonServices, extra1, scName,
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

	protected MembershipPackageAddonServices getByServiceNameMpId_PrevAndNext(
		Session session,
		MembershipPackageAddonServices membershipPackageAddonServices,
		String extra1, String scName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

		boolean bindExtra1 = false;

		if (extra1 == null) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1);
		}
		else if (extra1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3);
		}
		else {
			bindExtra1 = true;

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2);
		}

		boolean bindScName = false;

		if (scName == null) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_1);
		}
		else if (scName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_3);
		}
		else {
			bindScName = true;

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_2);
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
			query.append(MembershipPackageAddonServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindExtra1) {
			qPos.add(extra1);
		}

		if (bindScName) {
			qPos.add(scName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package addon serviceses where extra1 = &#63; and scName = &#63; from the database.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceNameMpId(String extra1, String scName)
		throws SystemException {
		for (MembershipPackageAddonServices membershipPackageAddonServices : findByServiceNameMpId(
				extra1, scName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageAddonServices);
		}
	}

	/**
	 * Returns the number of membership package addon serviceses where extra1 = &#63; and scName = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param scName the sc name
	 * @return the number of matching membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceNameMpId(String extra1, String scName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICENAMEMPID;

		Object[] finderArgs = new Object[] { extra1, scName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2);
			}

			boolean bindScName = false;

			if (scName == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_1);
			}
			else if (scName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_3);
			}
			else {
				bindScName = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_SCNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindExtra1) {
					qPos.add(extra1);
				}

				if (bindScName) {
					qPos.add(scName);
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

	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1 = "membershipPackageAddonServices.extra1 IS NULL AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2 = "membershipPackageAddonServices.extra1 = ? AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3 = "(membershipPackageAddonServices.extra1 IS NULL OR membershipPackageAddonServices.extra1 = '') AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_SCNAME_1 = "membershipPackageAddonServices.scName IS NULL";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_SCNAME_2 = "membershipPackageAddonServices.scName = ?";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_SCNAME_3 = "(membershipPackageAddonServices.scName IS NULL OR membershipPackageAddonServices.scName = '')";

	public MembershipPackageAddonServicesPersistenceImpl() {
		setModelClass(MembershipPackageAddonServices.class);
	}

	/**
	 * Caches the membership package addon services in the entity cache if it is enabled.
	 *
	 * @param membershipPackageAddonServices the membership package addon services
	 */
	@Override
	public void cacheResult(
		MembershipPackageAddonServices membershipPackageAddonServices) {
		EntityCacheUtil.putResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			membershipPackageAddonServices.getPrimaryKey(),
			membershipPackageAddonServices);

		membershipPackageAddonServices.resetOriginalValues();
	}

	/**
	 * Caches the membership package addon serviceses in the entity cache if it is enabled.
	 *
	 * @param membershipPackageAddonServiceses the membership package addon serviceses
	 */
	@Override
	public void cacheResult(
		List<MembershipPackageAddonServices> membershipPackageAddonServiceses) {
		for (MembershipPackageAddonServices membershipPackageAddonServices : membershipPackageAddonServiceses) {
			if (EntityCacheUtil.getResult(
						MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageAddonServicesImpl.class,
						membershipPackageAddonServices.getPrimaryKey()) == null) {
				cacheResult(membershipPackageAddonServices);
			}
			else {
				membershipPackageAddonServices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership package addon serviceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackageAddonServicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackageAddonServicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package addon services.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipPackageAddonServices membershipPackageAddonServices) {
		EntityCacheUtil.removeResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			membershipPackageAddonServices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipPackageAddonServices> membershipPackageAddonServiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackageAddonServices membershipPackageAddonServices : membershipPackageAddonServiceses) {
			EntityCacheUtil.removeResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageAddonServicesImpl.class,
				membershipPackageAddonServices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package addon services with the primary key. Does not add the membership package addon services to the database.
	 *
	 * @param mpAddonId the primary key for the new membership package addon services
	 * @return the new membership package addon services
	 */
	@Override
	public MembershipPackageAddonServices create(long mpAddonId) {
		MembershipPackageAddonServices membershipPackageAddonServices = new MembershipPackageAddonServicesImpl();

		membershipPackageAddonServices.setNew(true);
		membershipPackageAddonServices.setPrimaryKey(mpAddonId);

		return membershipPackageAddonServices;
	}

	/**
	 * Removes the membership package addon services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mpAddonId the primary key of the membership package addon services
	 * @return the membership package addon services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices remove(long mpAddonId)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		return remove((Serializable)mpAddonId);
	}

	/**
	 * Removes the membership package addon services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package addon services
	 * @return the membership package addon services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices remove(Serializable primaryKey)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackageAddonServices membershipPackageAddonServices = (MembershipPackageAddonServices)session.get(MembershipPackageAddonServicesImpl.class,
					primaryKey);

			if (membershipPackageAddonServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackageAddonServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackageAddonServices);
		}
		catch (NoSuchMembershipPackageAddonServicesException nsee) {
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
	protected MembershipPackageAddonServices removeImpl(
		MembershipPackageAddonServices membershipPackageAddonServices)
		throws SystemException {
		membershipPackageAddonServices = toUnwrappedModel(membershipPackageAddonServices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackageAddonServices)) {
				membershipPackageAddonServices = (MembershipPackageAddonServices)session.get(MembershipPackageAddonServicesImpl.class,
						membershipPackageAddonServices.getPrimaryKeyObj());
			}

			if (membershipPackageAddonServices != null) {
				session.delete(membershipPackageAddonServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackageAddonServices != null) {
			clearCache(membershipPackageAddonServices);
		}

		return membershipPackageAddonServices;
	}

	@Override
	public MembershipPackageAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices membershipPackageAddonServices)
		throws SystemException {
		membershipPackageAddonServices = toUnwrappedModel(membershipPackageAddonServices);

		boolean isNew = membershipPackageAddonServices.isNew();

		MembershipPackageAddonServicesModelImpl membershipPackageAddonServicesModelImpl =
			(MembershipPackageAddonServicesModelImpl)membershipPackageAddonServices;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackageAddonServices.isNew()) {
				session.save(membershipPackageAddonServices);

				membershipPackageAddonServices.setNew(false);
			}
			else {
				session.merge(membershipPackageAddonServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!MembershipPackageAddonServicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackageAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageAddonServicesModelImpl.getOriginalScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID,
					args);

				args = new Object[] {
						membershipPackageAddonServicesModelImpl.getScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEADDONSERVICESSCID,
					args);
			}

			if ((membershipPackageAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageAddonServicesModelImpl.getOriginalExtra1(),
						membershipPackageAddonServicesModelImpl.getOriginalScName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);

				args = new Object[] {
						membershipPackageAddonServicesModelImpl.getExtra1(),
						membershipPackageAddonServicesModelImpl.getScName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageAddonServicesImpl.class,
			membershipPackageAddonServices.getPrimaryKey(),
			membershipPackageAddonServices);

		return membershipPackageAddonServices;
	}

	protected MembershipPackageAddonServices toUnwrappedModel(
		MembershipPackageAddonServices membershipPackageAddonServices) {
		if (membershipPackageAddonServices instanceof MembershipPackageAddonServicesImpl) {
			return membershipPackageAddonServices;
		}

		MembershipPackageAddonServicesImpl membershipPackageAddonServicesImpl = new MembershipPackageAddonServicesImpl();

		membershipPackageAddonServicesImpl.setNew(membershipPackageAddonServices.isNew());
		membershipPackageAddonServicesImpl.setPrimaryKey(membershipPackageAddonServices.getPrimaryKey());

		membershipPackageAddonServicesImpl.setMpAddonId(membershipPackageAddonServices.getMpAddonId());
		membershipPackageAddonServicesImpl.setScId(membershipPackageAddonServices.getScId());
		membershipPackageAddonServicesImpl.setScName(membershipPackageAddonServices.getScName());
		membershipPackageAddonServicesImpl.setParamType(membershipPackageAddonServices.getParamType());
		membershipPackageAddonServicesImpl.setParamFrom(membershipPackageAddonServices.getParamFrom());
		membershipPackageAddonServicesImpl.setParamUpto(membershipPackageAddonServices.getParamUpto());
		membershipPackageAddonServicesImpl.setDuration(membershipPackageAddonServices.getDuration());
		membershipPackageAddonServicesImpl.setDurationType(membershipPackageAddonServices.getDurationType());
		membershipPackageAddonServicesImpl.setServiceCharges(membershipPackageAddonServices.getServiceCharges());
		membershipPackageAddonServicesImpl.setServiceChargesCurrency(membershipPackageAddonServices.getServiceChargesCurrency());
		membershipPackageAddonServicesImpl.setServiceChargesPeriod(membershipPackageAddonServices.getServiceChargesPeriod());
		membershipPackageAddonServicesImpl.setServiceChargesPeriodType(membershipPackageAddonServices.getServiceChargesPeriodType());
		membershipPackageAddonServicesImpl.setStatus(membershipPackageAddonServices.getStatus());
		membershipPackageAddonServicesImpl.setDescription(membershipPackageAddonServices.getDescription());
		membershipPackageAddonServicesImpl.setDateAdded(membershipPackageAddonServices.getDateAdded());
		membershipPackageAddonServicesImpl.setDateModified(membershipPackageAddonServices.getDateModified());
		membershipPackageAddonServicesImpl.setCreatedBy(membershipPackageAddonServices.getCreatedBy());
		membershipPackageAddonServicesImpl.setModifiedBy(membershipPackageAddonServices.getModifiedBy());
		membershipPackageAddonServicesImpl.setExtra1(membershipPackageAddonServices.getExtra1());
		membershipPackageAddonServicesImpl.setExtra2(membershipPackageAddonServices.getExtra2());
		membershipPackageAddonServicesImpl.setExtra3(membershipPackageAddonServices.getExtra3());
		membershipPackageAddonServicesImpl.setExtra4(membershipPackageAddonServices.getExtra4());
		membershipPackageAddonServicesImpl.setExtra5(membershipPackageAddonServices.getExtra5());
		membershipPackageAddonServicesImpl.setExtra6(membershipPackageAddonServices.getExtra6());

		return membershipPackageAddonServicesImpl;
	}

	/**
	 * Returns the membership package addon services with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package addon services
	 * @return the membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = fetchByPrimaryKey(primaryKey);

		if (membershipPackageAddonServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackageAddonServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackageAddonServices;
	}

	/**
	 * Returns the membership package addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException} if it could not be found.
	 *
	 * @param mpAddonId the primary key of the membership package addon services
	 * @return the membership package addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageAddonServicesException if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices findByPrimaryKey(long mpAddonId)
		throws NoSuchMembershipPackageAddonServicesException, SystemException {
		return findByPrimaryKey((Serializable)mpAddonId);
	}

	/**
	 * Returns the membership package addon services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package addon services
	 * @return the membership package addon services, or <code>null</code> if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipPackageAddonServices membershipPackageAddonServices = (MembershipPackageAddonServices)EntityCacheUtil.getResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageAddonServicesImpl.class, primaryKey);

		if (membershipPackageAddonServices == _nullMembershipPackageAddonServices) {
			return null;
		}

		if (membershipPackageAddonServices == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackageAddonServices = (MembershipPackageAddonServices)session.get(MembershipPackageAddonServicesImpl.class,
						primaryKey);

				if (membershipPackageAddonServices != null) {
					cacheResult(membershipPackageAddonServices);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageAddonServicesImpl.class, primaryKey,
						_nullMembershipPackageAddonServices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackageAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackageAddonServicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackageAddonServices;
	}

	/**
	 * Returns the membership package addon services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mpAddonId the primary key of the membership package addon services
	 * @return the membership package addon services, or <code>null</code> if a membership package addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageAddonServices fetchByPrimaryKey(long mpAddonId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mpAddonId);
	}

	/**
	 * Returns all the membership package addon serviceses.
	 *
	 * @return the membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package addon serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @return the range of membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package addon serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package addon serviceses
	 * @param end the upper bound of the range of membership package addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership package addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageAddonServices> findAll(int start, int end,
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

		List<MembershipPackageAddonServices> list = (List<MembershipPackageAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES;

				if (pagination) {
					sql = sql.concat(MembershipPackageAddonServicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageAddonServices>(list);
				}
				else {
					list = (List<MembershipPackageAddonServices>)QueryUtil.list(q,
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
	 * Removes all the membership package addon serviceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackageAddonServices membershipPackageAddonServices : findAll()) {
			remove(membershipPackageAddonServices);
		}
	}

	/**
	 * Returns the number of membership package addon serviceses.
	 *
	 * @return the number of membership package addon serviceses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGEADDONSERVICES);

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
	 * Initializes the membership package addon services persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackageAddonServices>> listenersList =
					new ArrayList<ModelListener<MembershipPackageAddonServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackageAddonServices>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipPackageAddonServicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES = "SELECT membershipPackageAddonServices FROM MembershipPackageAddonServices membershipPackageAddonServices";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE =
		"SELECT membershipPackageAddonServices FROM MembershipPackageAddonServices membershipPackageAddonServices WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEADDONSERVICES = "SELECT COUNT(membershipPackageAddonServices) FROM MembershipPackageAddonServices membershipPackageAddonServices";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEADDONSERVICES_WHERE = "SELECT COUNT(membershipPackageAddonServices) FROM MembershipPackageAddonServices membershipPackageAddonServices WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackageAddonServices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackageAddonServices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackageAddonServices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackageAddonServicesPersistenceImpl.class);
	private static MembershipPackageAddonServices _nullMembershipPackageAddonServices =
		new MembershipPackageAddonServicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackageAddonServices> toCacheModel() {
				return _nullMembershipPackageAddonServicesCacheModel;
			}
		};

	private static CacheModel<MembershipPackageAddonServices> _nullMembershipPackageAddonServicesCacheModel =
		new CacheModel<MembershipPackageAddonServices>() {
			@Override
			public MembershipPackageAddonServices toEntityModel() {
				return _nullMembershipPackageAddonServices;
			}
		};
}