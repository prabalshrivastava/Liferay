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

import com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException;
import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership subscription addon services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServicesPersistence
 * @see MembershipSubscriptionAddonServicesUtil
 * @generated
 */
public class MembershipSubscriptionAddonServicesPersistenceImpl
	extends BasePersistenceImpl<MembershipSubscriptionAddonServices>
	implements MembershipSubscriptionAddonServicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipSubscriptionAddonServicesUtil} to access the membership subscription addon services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipSubscriptionAddonServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionAddonServicesScId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionAddonServicesScId",
			new String[] { String.class.getName() },
			MembershipSubscriptionAddonServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipSubscriptionAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionAddonServicesScId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscription addon serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		String scId) throws SystemException {
		return findByMembershipSubscriptionAddonServicesScId(scId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscription addon serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @return the range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		String scId, int start, int end) throws SystemException {
		return findByMembershipSubscriptionAddonServicesScId(scId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the membership subscription addon serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesScId(
		String scId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID;
			finderArgs = new Object[] { scId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID;
			finderArgs = new Object[] { scId, start, end, orderByComparator };
		}

		List<MembershipSubscriptionAddonServices> list = (List<MembershipSubscriptionAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : list) {
				if (!Validator.equals(scId,
							membershipSubscriptionAddonServices.getScId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscriptionAddonServices>(list);
				}
				else {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesScId_First(scId,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscription addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesScId(scId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesScId_Last(scId,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionAddonServicesScId(scId);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesScId(scId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where scId = &#63;.
	 *
	 * @param msAddonId the primary key of the current membership subscription addon services
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesScId_PrevAndNext(
		long msAddonId, String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = findByPrimaryKey(msAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscriptionAddonServices[] array = new MembershipSubscriptionAddonServicesImpl[3];

			array[0] = getByMembershipSubscriptionAddonServicesScId_PrevAndNext(session,
					membershipSubscriptionAddonServices, scId,
					orderByComparator, true);

			array[1] = membershipSubscriptionAddonServices;

			array[2] = getByMembershipSubscriptionAddonServicesScId_PrevAndNext(session,
					membershipSubscriptionAddonServices, scId,
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

	protected MembershipSubscriptionAddonServices getByMembershipSubscriptionAddonServicesScId_PrevAndNext(
		Session session,
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices,
		String scId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_2);
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
			query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscriptionAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscriptionAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscription addon serviceses where scId = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionAddonServicesScId(String scId)
		throws SystemException {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : findByMembershipSubscriptionAddonServicesScId(
				scId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscriptionAddonServices);
		}
	}

	/**
	 * Returns the number of membership subscription addon serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the number of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionAddonServicesScId(String scId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID;

		Object[] finderArgs = new Object[] { scId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_1 =
		"membershipSubscriptionAddonServices.scId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_2 =
		"membershipSubscriptionAddonServices.scId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID_SCID_3 =
		"(membershipSubscriptionAddonServices.scId IS NULL OR membershipSubscriptionAddonServices.scId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionAddonServicesDescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionAddonServicesDescription",
			new String[] { String.class.getName() },
			MembershipSubscriptionAddonServicesModelImpl.DESCRIPTION_COLUMN_BITMASK |
			MembershipSubscriptionAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionAddonServicesDescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscription addon serviceses where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		String description) throws SystemException {
		return findByMembershipSubscriptionAddonServicesDescription(description,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscription addon serviceses where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @return the range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		String description, int start, int end) throws SystemException {
		return findByMembershipSubscriptionAddonServicesDescription(description,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscription addon serviceses where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesDescription(
		String description, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION;
			finderArgs = new Object[] { description };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION;
			finderArgs = new Object[] { description, start, end, orderByComparator };
		}

		List<MembershipSubscriptionAddonServices> list = (List<MembershipSubscriptionAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : list) {
				if (!Validator.equals(description,
							membershipSubscriptionAddonServices.getDescription())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				if (!pagination) {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscriptionAddonServices>(list);
				}
				else {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscription addon services in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_First(
		String description, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesDescription_First(description,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscription addon services in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_First(
		String description, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesDescription(description,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesDescription_Last(
		String description, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesDescription_Last(description,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesDescription_Last(
		String description, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionAddonServicesDescription(description);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesDescription(description,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where description = &#63;.
	 *
	 * @param msAddonId the primary key of the current membership subscription addon services
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesDescription_PrevAndNext(
		long msAddonId, String description, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = findByPrimaryKey(msAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscriptionAddonServices[] array = new MembershipSubscriptionAddonServicesImpl[3];

			array[0] = getByMembershipSubscriptionAddonServicesDescription_PrevAndNext(session,
					membershipSubscriptionAddonServices, description,
					orderByComparator, true);

			array[1] = membershipSubscriptionAddonServices;

			array[2] = getByMembershipSubscriptionAddonServicesDescription_PrevAndNext(session,
					membershipSubscriptionAddonServices, description,
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

	protected MembershipSubscriptionAddonServices getByMembershipSubscriptionAddonServicesDescription_PrevAndNext(
		Session session,
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices,
		String description, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

		boolean bindDescription = false;

		if (description == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_1);
		}
		else if (description.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_2);
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
			query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescription) {
			qPos.add(description);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscriptionAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscriptionAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscription addon serviceses where description = &#63; from the database.
	 *
	 * @param description the description
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionAddonServicesDescription(
		String description) throws SystemException {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : findByMembershipSubscriptionAddonServicesDescription(
				description, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscriptionAddonServices);
		}
	}

	/**
	 * Returns the number of membership subscription addon serviceses where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionAddonServicesDescription(
		String description) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindDescription = false;

			if (description == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_1);
			}
			else if (description.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_1 =
		"membershipSubscriptionAddonServices.description IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_2 =
		"membershipSubscriptionAddonServices.description = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION_DESCRIPTION_3 =
		"(membershipSubscriptionAddonServices.description IS NULL OR membershipSubscriptionAddonServices.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionAddonServicesUserId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionAddonServicesUserId",
			new String[] { String.class.getName() },
			MembershipSubscriptionAddonServicesModelImpl.EXTRA1_COLUMN_BITMASK |
			MembershipSubscriptionAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionAddonServicesUserId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscription addon serviceses where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		String extra1) throws SystemException {
		return findByMembershipSubscriptionAddonServicesUserId(extra1,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscription addon serviceses where extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @return the range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		String extra1, int start, int end) throws SystemException {
		return findByMembershipSubscriptionAddonServicesUserId(extra1, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscription addon serviceses where extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesUserId(
		String extra1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID;
			finderArgs = new Object[] { extra1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID;
			finderArgs = new Object[] { extra1, start, end, orderByComparator };
		}

		List<MembershipSubscriptionAddonServices> list = (List<MembershipSubscriptionAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : list) {
				if (!Validator.equals(extra1,
							membershipSubscriptionAddonServices.getExtra1())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscriptionAddonServices>(list);
				}
				else {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_First(
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesUserId_First(extra1,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscription addon services in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_First(
		String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesUserId(extra1,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesUserId_Last(
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesUserId_Last(extra1,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesUserId_Last(
		String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionAddonServicesUserId(extra1);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesUserId(extra1,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where extra1 = &#63;.
	 *
	 * @param msAddonId the primary key of the current membership subscription addon services
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesUserId_PrevAndNext(
		long msAddonId, String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = findByPrimaryKey(msAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscriptionAddonServices[] array = new MembershipSubscriptionAddonServicesImpl[3];

			array[0] = getByMembershipSubscriptionAddonServicesUserId_PrevAndNext(session,
					membershipSubscriptionAddonServices, extra1,
					orderByComparator, true);

			array[1] = membershipSubscriptionAddonServices;

			array[2] = getByMembershipSubscriptionAddonServicesUserId_PrevAndNext(session,
					membershipSubscriptionAddonServices, extra1,
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

	protected MembershipSubscriptionAddonServices getByMembershipSubscriptionAddonServicesUserId_PrevAndNext(
		Session session,
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices,
		String extra1, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

		boolean bindExtra1 = false;

		if (extra1 == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_1);
		}
		else if (extra1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_3);
		}
		else {
			bindExtra1 = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_2);
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
			query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindExtra1) {
			qPos.add(extra1);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscriptionAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscriptionAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscription addon serviceses where extra1 = &#63; from the database.
	 *
	 * @param extra1 the extra1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionAddonServicesUserId(String extra1)
		throws SystemException {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : findByMembershipSubscriptionAddonServicesUserId(
				extra1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscriptionAddonServices);
		}
	}

	/**
	 * Returns the number of membership subscription addon serviceses where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the number of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionAddonServicesUserId(String extra1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID;

		Object[] finderArgs = new Object[] { extra1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_1 =
		"membershipSubscriptionAddonServices.extra1 IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_2 =
		"membershipSubscriptionAddonServices.extra1 = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID_EXTRA1_3 =
		"(membershipSubscriptionAddonServices.extra1 IS NULL OR membershipSubscriptionAddonServices.extra1 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionAddonServicesMsId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionAddonServicesMsId",
			new String[] { Long.class.getName() },
			MembershipSubscriptionAddonServicesModelImpl.MSID_COLUMN_BITMASK |
			MembershipSubscriptionAddonServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID =
		new FinderPath(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionAddonServicesMsId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the membership subscription addon serviceses where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @return the matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId) throws SystemException {
		return findByMembershipSubscriptionAddonServicesMsId(msId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscription addon serviceses where msId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param msId the ms ID
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @return the range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end) throws SystemException {
		return findByMembershipSubscriptionAddonServicesMsId(msId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the membership subscription addon serviceses where msId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param msId the ms ID
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findByMembershipSubscriptionAddonServicesMsId(
		long msId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID;
			finderArgs = new Object[] { msId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID;
			finderArgs = new Object[] { msId, start, end, orderByComparator };
		}

		List<MembershipSubscriptionAddonServices> list = (List<MembershipSubscriptionAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : list) {
				if ((msId != membershipSubscriptionAddonServices.getMsId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID_MSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(msId);

				if (!pagination) {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscriptionAddonServices>(list);
				}
				else {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_First(
		long msId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesMsId_First(msId,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("msId=");
		msg.append(msId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscription addon services in the ordered set where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_First(
		long msId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesMsId(msId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByMembershipSubscriptionAddonServicesMsId_Last(
		long msId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByMembershipSubscriptionAddonServicesMsId_Last(msId,
				orderByComparator);

		if (membershipSubscriptionAddonServices != null) {
			return membershipSubscriptionAddonServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("msId=");
		msg.append(msId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionAddonServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscription addon services in the ordered set where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription addon services, or <code>null</code> if a matching membership subscription addon services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByMembershipSubscriptionAddonServicesMsId_Last(
		long msId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionAddonServicesMsId(msId);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscriptionAddonServices> list = findByMembershipSubscriptionAddonServicesMsId(msId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscription addon serviceses before and after the current membership subscription addon services in the ordered set where msId = &#63;.
	 *
	 * @param msAddonId the primary key of the current membership subscription addon services
	 * @param msId the ms ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices[] findByMembershipSubscriptionAddonServicesMsId_PrevAndNext(
		long msAddonId, long msId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = findByPrimaryKey(msAddonId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscriptionAddonServices[] array = new MembershipSubscriptionAddonServicesImpl[3];

			array[0] = getByMembershipSubscriptionAddonServicesMsId_PrevAndNext(session,
					membershipSubscriptionAddonServices, msId,
					orderByComparator, true);

			array[1] = membershipSubscriptionAddonServices;

			array[2] = getByMembershipSubscriptionAddonServicesMsId_PrevAndNext(session,
					membershipSubscriptionAddonServices, msId,
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

	protected MembershipSubscriptionAddonServices getByMembershipSubscriptionAddonServicesMsId_PrevAndNext(
		Session session,
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices,
		long msId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID_MSID_2);

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
			query.append(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(msId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscriptionAddonServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscriptionAddonServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscription addon serviceses where msId = &#63; from the database.
	 *
	 * @param msId the ms ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionAddonServicesMsId(long msId)
		throws SystemException {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : findByMembershipSubscriptionAddonServicesMsId(
				msId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscriptionAddonServices);
		}
	}

	/**
	 * Returns the number of membership subscription addon serviceses where msId = &#63;.
	 *
	 * @param msId the ms ID
	 * @return the number of matching membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionAddonServicesMsId(long msId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID;

		Object[] finderArgs = new Object[] { msId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID_MSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(msId);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID_MSID_2 =
		"membershipSubscriptionAddonServices.msId = ?";

	public MembershipSubscriptionAddonServicesPersistenceImpl() {
		setModelClass(MembershipSubscriptionAddonServices.class);
	}

	/**
	 * Caches the membership subscription addon services in the entity cache if it is enabled.
	 *
	 * @param membershipSubscriptionAddonServices the membership subscription addon services
	 */
	@Override
	public void cacheResult(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		EntityCacheUtil.putResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			membershipSubscriptionAddonServices.getPrimaryKey(),
			membershipSubscriptionAddonServices);

		membershipSubscriptionAddonServices.resetOriginalValues();
	}

	/**
	 * Caches the membership subscription addon serviceses in the entity cache if it is enabled.
	 *
	 * @param membershipSubscriptionAddonServiceses the membership subscription addon serviceses
	 */
	@Override
	public void cacheResult(
		List<MembershipSubscriptionAddonServices> membershipSubscriptionAddonServiceses) {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : membershipSubscriptionAddonServiceses) {
			if (EntityCacheUtil.getResult(
						MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscriptionAddonServicesImpl.class,
						membershipSubscriptionAddonServices.getPrimaryKey()) == null) {
				cacheResult(membershipSubscriptionAddonServices);
			}
			else {
				membershipSubscriptionAddonServices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership subscription addon serviceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipSubscriptionAddonServicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipSubscriptionAddonServicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership subscription addon services.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		EntityCacheUtil.removeResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			membershipSubscriptionAddonServices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipSubscriptionAddonServices> membershipSubscriptionAddonServiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : membershipSubscriptionAddonServiceses) {
			EntityCacheUtil.removeResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscriptionAddonServicesImpl.class,
				membershipSubscriptionAddonServices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership subscription addon services with the primary key. Does not add the membership subscription addon services to the database.
	 *
	 * @param msAddonId the primary key for the new membership subscription addon services
	 * @return the new membership subscription addon services
	 */
	@Override
	public MembershipSubscriptionAddonServices create(long msAddonId) {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = new MembershipSubscriptionAddonServicesImpl();

		membershipSubscriptionAddonServices.setNew(true);
		membershipSubscriptionAddonServices.setPrimaryKey(msAddonId);

		return membershipSubscriptionAddonServices;
	}

	/**
	 * Removes the membership subscription addon services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param msAddonId the primary key of the membership subscription addon services
	 * @return the membership subscription addon services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices remove(long msAddonId)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		return remove((Serializable)msAddonId);
	}

	/**
	 * Removes the membership subscription addon services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership subscription addon services
	 * @return the membership subscription addon services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices remove(Serializable primaryKey)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipSubscriptionAddonServices membershipSubscriptionAddonServices =
				(MembershipSubscriptionAddonServices)session.get(MembershipSubscriptionAddonServicesImpl.class,
					primaryKey);

			if (membershipSubscriptionAddonServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipSubscriptionAddonServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipSubscriptionAddonServices);
		}
		catch (NoSuchMembershipSubscriptionAddonServicesException nsee) {
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
	protected MembershipSubscriptionAddonServices removeImpl(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws SystemException {
		membershipSubscriptionAddonServices = toUnwrappedModel(membershipSubscriptionAddonServices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipSubscriptionAddonServices)) {
				membershipSubscriptionAddonServices = (MembershipSubscriptionAddonServices)session.get(MembershipSubscriptionAddonServicesImpl.class,
						membershipSubscriptionAddonServices.getPrimaryKeyObj());
			}

			if (membershipSubscriptionAddonServices != null) {
				session.delete(membershipSubscriptionAddonServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipSubscriptionAddonServices != null) {
			clearCache(membershipSubscriptionAddonServices);
		}

		return membershipSubscriptionAddonServices;
	}

	@Override
	public MembershipSubscriptionAddonServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices membershipSubscriptionAddonServices)
		throws SystemException {
		membershipSubscriptionAddonServices = toUnwrappedModel(membershipSubscriptionAddonServices);

		boolean isNew = membershipSubscriptionAddonServices.isNew();

		MembershipSubscriptionAddonServicesModelImpl membershipSubscriptionAddonServicesModelImpl =
			(MembershipSubscriptionAddonServicesModelImpl)membershipSubscriptionAddonServices;

		Session session = null;

		try {
			session = openSession();

			if (membershipSubscriptionAddonServices.isNew()) {
				session.save(membershipSubscriptionAddonServices);

				membershipSubscriptionAddonServices.setNew(false);
			}
			else {
				session.merge(membershipSubscriptionAddonServices);
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
				!MembershipSubscriptionAddonServicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipSubscriptionAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getOriginalScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID,
					args);

				args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESSCID,
					args);
			}

			if ((membershipSubscriptionAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getOriginalDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION,
					args);

				args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getDescription()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESDESCRIPTION,
					args);
			}

			if ((membershipSubscriptionAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getOriginalExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID,
					args);

				args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESUSERID,
					args);
			}

			if ((membershipSubscriptionAddonServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getOriginalMsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID,
					args);

				args = new Object[] {
						membershipSubscriptionAddonServicesModelImpl.getMsId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONADDONSERVICESMSID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionAddonServicesImpl.class,
			membershipSubscriptionAddonServices.getPrimaryKey(),
			membershipSubscriptionAddonServices);

		return membershipSubscriptionAddonServices;
	}

	protected MembershipSubscriptionAddonServices toUnwrappedModel(
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices) {
		if (membershipSubscriptionAddonServices instanceof MembershipSubscriptionAddonServicesImpl) {
			return membershipSubscriptionAddonServices;
		}

		MembershipSubscriptionAddonServicesImpl membershipSubscriptionAddonServicesImpl =
			new MembershipSubscriptionAddonServicesImpl();

		membershipSubscriptionAddonServicesImpl.setNew(membershipSubscriptionAddonServices.isNew());
		membershipSubscriptionAddonServicesImpl.setPrimaryKey(membershipSubscriptionAddonServices.getPrimaryKey());

		membershipSubscriptionAddonServicesImpl.setMsAddonId(membershipSubscriptionAddonServices.getMsAddonId());
		membershipSubscriptionAddonServicesImpl.setMsId(membershipSubscriptionAddonServices.getMsId());
		membershipSubscriptionAddonServicesImpl.setScId(membershipSubscriptionAddonServices.getScId());
		membershipSubscriptionAddonServicesImpl.setScName(membershipSubscriptionAddonServices.getScName());
		membershipSubscriptionAddonServicesImpl.setParamType(membershipSubscriptionAddonServices.getParamType());
		membershipSubscriptionAddonServicesImpl.setParamFrom(membershipSubscriptionAddonServices.getParamFrom());
		membershipSubscriptionAddonServicesImpl.setParamUpto(membershipSubscriptionAddonServices.getParamUpto());
		membershipSubscriptionAddonServicesImpl.setDuration(membershipSubscriptionAddonServices.getDuration());
		membershipSubscriptionAddonServicesImpl.setDurationType(membershipSubscriptionAddonServices.getDurationType());
		membershipSubscriptionAddonServicesImpl.setServiceCharges(membershipSubscriptionAddonServices.getServiceCharges());
		membershipSubscriptionAddonServicesImpl.setServiceChargesCurrency(membershipSubscriptionAddonServices.getServiceChargesCurrency());
		membershipSubscriptionAddonServicesImpl.setServiceChargesPeriod(membershipSubscriptionAddonServices.getServiceChargesPeriod());
		membershipSubscriptionAddonServicesImpl.setServiceChargesPeriodType(membershipSubscriptionAddonServices.getServiceChargesPeriodType());
		membershipSubscriptionAddonServicesImpl.setStatus(membershipSubscriptionAddonServices.getStatus());
		membershipSubscriptionAddonServicesImpl.setDescription(membershipSubscriptionAddonServices.getDescription());
		membershipSubscriptionAddonServicesImpl.setEffectiveFromDate(membershipSubscriptionAddonServices.getEffectiveFromDate());
		membershipSubscriptionAddonServicesImpl.setEffectiveToDate(membershipSubscriptionAddonServices.getEffectiveToDate());
		membershipSubscriptionAddonServicesImpl.setDateAdded(membershipSubscriptionAddonServices.getDateAdded());
		membershipSubscriptionAddonServicesImpl.setDateModified(membershipSubscriptionAddonServices.getDateModified());
		membershipSubscriptionAddonServicesImpl.setCreatedBy(membershipSubscriptionAddonServices.getCreatedBy());
		membershipSubscriptionAddonServicesImpl.setModifiedBy(membershipSubscriptionAddonServices.getModifiedBy());
		membershipSubscriptionAddonServicesImpl.setExtra1(membershipSubscriptionAddonServices.getExtra1());
		membershipSubscriptionAddonServicesImpl.setExtra2(membershipSubscriptionAddonServices.getExtra2());
		membershipSubscriptionAddonServicesImpl.setExtra3(membershipSubscriptionAddonServices.getExtra3());
		membershipSubscriptionAddonServicesImpl.setExtra4(membershipSubscriptionAddonServices.getExtra4());
		membershipSubscriptionAddonServicesImpl.setExtra5(membershipSubscriptionAddonServices.getExtra5());
		membershipSubscriptionAddonServicesImpl.setExtra6(membershipSubscriptionAddonServices.getExtra6());

		return membershipSubscriptionAddonServicesImpl;
	}

	/**
	 * Returns the membership subscription addon services with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscription addon services
	 * @return the membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = fetchByPrimaryKey(primaryKey);

		if (membershipSubscriptionAddonServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipSubscriptionAddonServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipSubscriptionAddonServices;
	}

	/**
	 * Returns the membership subscription addon services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException} if it could not be found.
	 *
	 * @param msAddonId the primary key of the membership subscription addon services
	 * @return the membership subscription addon services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionAddonServicesException if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices findByPrimaryKey(long msAddonId)
		throws NoSuchMembershipSubscriptionAddonServicesException,
			SystemException {
		return findByPrimaryKey((Serializable)msAddonId);
	}

	/**
	 * Returns the membership subscription addon services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscription addon services
	 * @return the membership subscription addon services, or <code>null</code> if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipSubscriptionAddonServices membershipSubscriptionAddonServices = (MembershipSubscriptionAddonServices)EntityCacheUtil.getResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscriptionAddonServicesImpl.class, primaryKey);

		if (membershipSubscriptionAddonServices == _nullMembershipSubscriptionAddonServices) {
			return null;
		}

		if (membershipSubscriptionAddonServices == null) {
			Session session = null;

			try {
				session = openSession();

				membershipSubscriptionAddonServices = (MembershipSubscriptionAddonServices)session.get(MembershipSubscriptionAddonServicesImpl.class,
						primaryKey);

				if (membershipSubscriptionAddonServices != null) {
					cacheResult(membershipSubscriptionAddonServices);
				}
				else {
					EntityCacheUtil.putResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscriptionAddonServicesImpl.class,
						primaryKey, _nullMembershipSubscriptionAddonServices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipSubscriptionAddonServicesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipSubscriptionAddonServicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipSubscriptionAddonServices;
	}

	/**
	 * Returns the membership subscription addon services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param msAddonId the primary key of the membership subscription addon services
	 * @return the membership subscription addon services, or <code>null</code> if a membership subscription addon services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscriptionAddonServices fetchByPrimaryKey(long msAddonId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)msAddonId);
	}

	/**
	 * Returns all the membership subscription addon serviceses.
	 *
	 * @return the membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscription addon serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @return the range of membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscription addon serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionAddonServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscription addon serviceses
	 * @param end the upper bound of the range of membership subscription addon serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership subscription addon serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscriptionAddonServices> findAll(int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<MembershipSubscriptionAddonServices> list = (List<MembershipSubscriptionAddonServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES;

				if (pagination) {
					sql = sql.concat(MembershipSubscriptionAddonServicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscriptionAddonServices>(list);
				}
				else {
					list = (List<MembershipSubscriptionAddonServices>)QueryUtil.list(q,
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
	 * Removes all the membership subscription addon serviceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipSubscriptionAddonServices membershipSubscriptionAddonServices : findAll()) {
			remove(membershipSubscriptionAddonServices);
		}
	}

	/**
	 * Returns the number of membership subscription addon serviceses.
	 *
	 * @return the number of membership subscription addon serviceses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES);

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
	 * Initializes the membership subscription addon services persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipSubscriptionAddonServices>> listenersList =
					new ArrayList<ModelListener<MembershipSubscriptionAddonServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipSubscriptionAddonServices>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipSubscriptionAddonServicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES = "SELECT membershipSubscriptionAddonServices FROM MembershipSubscriptionAddonServices membershipSubscriptionAddonServices";
	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE =
		"SELECT membershipSubscriptionAddonServices FROM MembershipSubscriptionAddonServices membershipSubscriptionAddonServices WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES = "SELECT COUNT(membershipSubscriptionAddonServices) FROM MembershipSubscriptionAddonServices membershipSubscriptionAddonServices";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIPTIONADDONSERVICES_WHERE =
		"SELECT COUNT(membershipSubscriptionAddonServices) FROM MembershipSubscriptionAddonServices membershipSubscriptionAddonServices WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipSubscriptionAddonServices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipSubscriptionAddonServices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipSubscriptionAddonServices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipSubscriptionAddonServicesPersistenceImpl.class);
	private static MembershipSubscriptionAddonServices _nullMembershipSubscriptionAddonServices =
		new MembershipSubscriptionAddonServicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipSubscriptionAddonServices> toCacheModel() {
				return _nullMembershipSubscriptionAddonServicesCacheModel;
			}
		};

	private static CacheModel<MembershipSubscriptionAddonServices> _nullMembershipSubscriptionAddonServicesCacheModel =
		new CacheModel<MembershipSubscriptionAddonServices>() {
			@Override
			public MembershipSubscriptionAddonServices toEntityModel() {
				return _nullMembershipSubscriptionAddonServices;
			}
		};
}