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

import com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException;
import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership subscribed services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServicesPersistence
 * @see MembershipSubscribedServicesUtil
 * @generated
 */
public class MembershipSubscribedServicesPersistenceImpl
	extends BasePersistenceImpl<MembershipSubscribedServices>
	implements MembershipSubscribedServicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipSubscribedServicesUtil} to access the membership subscribed services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipSubscribedServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscribedServicesScId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscribedServicesScId",
			new String[] { String.class.getName() },
			MembershipSubscribedServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipSubscribedServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscribedServicesScId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscribed serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		String scId) throws SystemException {
		return findByMembershipSubscribedServicesScId(scId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscribed serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @return the range of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		String scId, int start, int end) throws SystemException {
		return findByMembershipSubscribedServicesScId(scId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscribed serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScId(
		String scId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID;
			finderArgs = new Object[] { scId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID;
			finderArgs = new Object[] { scId, start, end, orderByComparator };
		}

		List<MembershipSubscribedServices> list = (List<MembershipSubscribedServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscribedServices membershipSubscribedServices : list) {
				if (!Validator.equals(scId,
							membershipSubscribedServices.getScId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscribedServicesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscribedServices>(list);
				}
				else {
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscribed services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByMembershipSubscribedServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = fetchByMembershipSubscribedServicesScId_First(scId,
				orderByComparator);

		if (membershipSubscribedServices != null) {
			return membershipSubscribedServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscribedServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscribed services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscribedServices> list = findByMembershipSubscribedServicesScId(scId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscribed services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByMembershipSubscribedServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = fetchByMembershipSubscribedServicesScId_Last(scId,
				orderByComparator);

		if (membershipSubscribedServices != null) {
			return membershipSubscribedServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscribedServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscribed services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByMembershipSubscribedServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscribedServicesScId(scId);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscribedServices> list = findByMembershipSubscribedServicesScId(scId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscribed serviceses before and after the current membership subscribed services in the ordered set where scId = &#63;.
	 *
	 * @param mssId the primary key of the current membership subscribed services
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices[] findByMembershipSubscribedServicesScId_PrevAndNext(
		long mssId, String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = findByPrimaryKey(mssId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscribedServices[] array = new MembershipSubscribedServicesImpl[3];

			array[0] = getByMembershipSubscribedServicesScId_PrevAndNext(session,
					membershipSubscribedServices, scId, orderByComparator, true);

			array[1] = membershipSubscribedServices;

			array[2] = getByMembershipSubscribedServicesScId_PrevAndNext(session,
					membershipSubscribedServices, scId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscribedServices getByMembershipSubscribedServicesScId_PrevAndNext(
		Session session,
		MembershipSubscribedServices membershipSubscribedServices, String scId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_2);
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
			query.append(MembershipSubscribedServicesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscribedServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscribedServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscribed serviceses where scId = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscribedServicesScId(String scId)
		throws SystemException {
		for (MembershipSubscribedServices membershipSubscribedServices : findByMembershipSubscribedServicesScId(
				scId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscribedServices);
		}
	}

	/**
	 * Returns the number of membership subscribed serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the number of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscribedServicesScId(String scId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID;

		Object[] finderArgs = new Object[] { scId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_1 =
		"membershipSubscribedServices.scId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_2 =
		"membershipSubscribedServices.scId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCID_SCID_3 =
		"(membershipSubscribedServices.scId IS NULL OR membershipSubscribedServices.scId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscribedServicesScIdAndCreatedBy",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscribedServicesScIdAndCreatedBy",
			new String[] { String.class.getName(), String.class.getName() },
			MembershipSubscribedServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipSubscribedServicesModelImpl.CREATEDBY_COLUMN_BITMASK |
			MembershipSubscribedServicesModelImpl.SCNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY =
		new FinderPath(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscribedServicesScIdAndCreatedBy",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @return the matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		String scId, String createdBy) throws SystemException {
		return findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @return the range of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		String scId, String createdBy, int start, int end)
		throws SystemException {
		return findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
			createdBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findByMembershipSubscribedServicesScIdAndCreatedBy(
		String scId, String createdBy, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY;
			finderArgs = new Object[] { scId, createdBy };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY;
			finderArgs = new Object[] {
					scId, createdBy,
					
					start, end, orderByComparator
				};
		}

		List<MembershipSubscribedServices> list = (List<MembershipSubscribedServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscribedServices membershipSubscribedServices : list) {
				if (!Validator.equals(scId,
							membershipSubscribedServices.getScId()) ||
						!Validator.equals(createdBy,
							membershipSubscribedServices.getCreatedBy())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_2);
			}

			boolean bindCreatedBy = false;

			if (createdBy == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_1);
			}
			else if (createdBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_3);
			}
			else {
				bindCreatedBy = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscribedServicesModelImpl.ORDER_BY_JPQL);
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

				if (bindCreatedBy) {
					qPos.add(createdBy);
				}

				if (!pagination) {
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscribedServices>(list);
				}
				else {
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
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
	 * Returns the first membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_First(
		String scId, String createdBy, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = fetchByMembershipSubscribedServicesScIdAndCreatedBy_First(scId,
				createdBy, orderByComparator);

		if (membershipSubscribedServices != null) {
			return membershipSubscribedServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscribedServicesException(msg.toString());
	}

	/**
	 * Returns the first membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_First(
		String scId, String createdBy, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscribedServices> list = findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
				createdBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		String scId, String createdBy, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = fetchByMembershipSubscribedServicesScIdAndCreatedBy_Last(scId,
				createdBy, orderByComparator);

		if (membershipSubscribedServices != null) {
			return membershipSubscribedServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(", createdBy=");
		msg.append(createdBy);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscribedServicesException(msg.toString());
	}

	/**
	 * Returns the last membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscribed services, or <code>null</code> if a matching membership subscribed services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByMembershipSubscribedServicesScIdAndCreatedBy_Last(
		String scId, String createdBy, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscribedServicesScIdAndCreatedBy(scId,
				createdBy);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscribedServices> list = findByMembershipSubscribedServicesScIdAndCreatedBy(scId,
				createdBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscribed serviceses before and after the current membership subscribed services in the ordered set where scId = &#63; and createdBy = &#63;.
	 *
	 * @param mssId the primary key of the current membership subscribed services
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices[] findByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(
		long mssId, String scId, String createdBy,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = findByPrimaryKey(mssId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscribedServices[] array = new MembershipSubscribedServicesImpl[3];

			array[0] = getByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(session,
					membershipSubscribedServices, scId, createdBy,
					orderByComparator, true);

			array[1] = membershipSubscribedServices;

			array[2] = getByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(session,
					membershipSubscribedServices, scId, createdBy,
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

	protected MembershipSubscribedServices getByMembershipSubscribedServicesScIdAndCreatedBy_PrevAndNext(
		Session session,
		MembershipSubscribedServices membershipSubscribedServices, String scId,
		String createdBy, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_2);
		}

		boolean bindCreatedBy = false;

		if (createdBy == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_1);
		}
		else if (createdBy.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_3);
		}
		else {
			bindCreatedBy = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_2);
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
			query.append(MembershipSubscribedServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScId) {
			qPos.add(scId);
		}

		if (bindCreatedBy) {
			qPos.add(createdBy);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscribedServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscribedServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscribed serviceses where scId = &#63; and createdBy = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscribedServicesScIdAndCreatedBy(
		String scId, String createdBy) throws SystemException {
		for (MembershipSubscribedServices membershipSubscribedServices : findByMembershipSubscribedServicesScIdAndCreatedBy(
				scId, createdBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscribedServices);
		}
	}

	/**
	 * Returns the number of membership subscribed serviceses where scId = &#63; and createdBy = &#63;.
	 *
	 * @param scId the sc ID
	 * @param createdBy the created by
	 * @return the number of matching membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscribedServicesScIdAndCreatedBy(
		String scId, String createdBy) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY;

		Object[] finderArgs = new Object[] { scId, createdBy };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_2);
			}

			boolean bindCreatedBy = false;

			if (createdBy == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_1);
			}
			else if (createdBy.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_3);
			}
			else {
				bindCreatedBy = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_2);
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

				if (bindCreatedBy) {
					qPos.add(createdBy);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_1 =
		"membershipSubscribedServices.scId IS NULL AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_2 =
		"membershipSubscribedServices.scId = ? AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_SCID_3 =
		"(membershipSubscribedServices.scId IS NULL OR membershipSubscribedServices.scId = '') AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_1 =
		"membershipSubscribedServices.createdBy IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_2 =
		"membershipSubscribedServices.createdBy = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY_CREATEDBY_3 =
		"(membershipSubscribedServices.createdBy IS NULL OR membershipSubscribedServices.createdBy = '')";

	public MembershipSubscribedServicesPersistenceImpl() {
		setModelClass(MembershipSubscribedServices.class);
	}

	/**
	 * Caches the membership subscribed services in the entity cache if it is enabled.
	 *
	 * @param membershipSubscribedServices the membership subscribed services
	 */
	@Override
	public void cacheResult(
		MembershipSubscribedServices membershipSubscribedServices) {
		EntityCacheUtil.putResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			membershipSubscribedServices.getPrimaryKey(),
			membershipSubscribedServices);

		membershipSubscribedServices.resetOriginalValues();
	}

	/**
	 * Caches the membership subscribed serviceses in the entity cache if it is enabled.
	 *
	 * @param membershipSubscribedServiceses the membership subscribed serviceses
	 */
	@Override
	public void cacheResult(
		List<MembershipSubscribedServices> membershipSubscribedServiceses) {
		for (MembershipSubscribedServices membershipSubscribedServices : membershipSubscribedServiceses) {
			if (EntityCacheUtil.getResult(
						MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscribedServicesImpl.class,
						membershipSubscribedServices.getPrimaryKey()) == null) {
				cacheResult(membershipSubscribedServices);
			}
			else {
				membershipSubscribedServices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership subscribed serviceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipSubscribedServicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipSubscribedServicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership subscribed services.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipSubscribedServices membershipSubscribedServices) {
		EntityCacheUtil.removeResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			membershipSubscribedServices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipSubscribedServices> membershipSubscribedServiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipSubscribedServices membershipSubscribedServices : membershipSubscribedServiceses) {
			EntityCacheUtil.removeResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscribedServicesImpl.class,
				membershipSubscribedServices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership subscribed services with the primary key. Does not add the membership subscribed services to the database.
	 *
	 * @param mssId the primary key for the new membership subscribed services
	 * @return the new membership subscribed services
	 */
	@Override
	public MembershipSubscribedServices create(long mssId) {
		MembershipSubscribedServices membershipSubscribedServices = new MembershipSubscribedServicesImpl();

		membershipSubscribedServices.setNew(true);
		membershipSubscribedServices.setPrimaryKey(mssId);

		return membershipSubscribedServices;
	}

	/**
	 * Removes the membership subscribed services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mssId the primary key of the membership subscribed services
	 * @return the membership subscribed services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices remove(long mssId)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		return remove((Serializable)mssId);
	}

	/**
	 * Removes the membership subscribed services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership subscribed services
	 * @return the membership subscribed services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices remove(Serializable primaryKey)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipSubscribedServices membershipSubscribedServices = (MembershipSubscribedServices)session.get(MembershipSubscribedServicesImpl.class,
					primaryKey);

			if (membershipSubscribedServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipSubscribedServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipSubscribedServices);
		}
		catch (NoSuchMembershipSubscribedServicesException nsee) {
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
	protected MembershipSubscribedServices removeImpl(
		MembershipSubscribedServices membershipSubscribedServices)
		throws SystemException {
		membershipSubscribedServices = toUnwrappedModel(membershipSubscribedServices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipSubscribedServices)) {
				membershipSubscribedServices = (MembershipSubscribedServices)session.get(MembershipSubscribedServicesImpl.class,
						membershipSubscribedServices.getPrimaryKeyObj());
			}

			if (membershipSubscribedServices != null) {
				session.delete(membershipSubscribedServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipSubscribedServices != null) {
			clearCache(membershipSubscribedServices);
		}

		return membershipSubscribedServices;
	}

	@Override
	public MembershipSubscribedServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices membershipSubscribedServices)
		throws SystemException {
		membershipSubscribedServices = toUnwrappedModel(membershipSubscribedServices);

		boolean isNew = membershipSubscribedServices.isNew();

		MembershipSubscribedServicesModelImpl membershipSubscribedServicesModelImpl =
			(MembershipSubscribedServicesModelImpl)membershipSubscribedServices;

		Session session = null;

		try {
			session = openSession();

			if (membershipSubscribedServices.isNew()) {
				session.save(membershipSubscribedServices);

				membershipSubscribedServices.setNew(false);
			}
			else {
				session.merge(membershipSubscribedServices);
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
				!MembershipSubscribedServicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipSubscribedServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscribedServicesModelImpl.getOriginalScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID,
					args);

				args = new Object[] {
						membershipSubscribedServicesModelImpl.getScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCID,
					args);
			}

			if ((membershipSubscribedServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscribedServicesModelImpl.getOriginalScId(),
						membershipSubscribedServicesModelImpl.getOriginalCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY,
					args);

				args = new Object[] {
						membershipSubscribedServicesModelImpl.getScId(),
						membershipSubscribedServicesModelImpl.getCreatedBy()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIBEDSERVICESSCIDANDCREATEDBY,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscribedServicesImpl.class,
			membershipSubscribedServices.getPrimaryKey(),
			membershipSubscribedServices);

		return membershipSubscribedServices;
	}

	protected MembershipSubscribedServices toUnwrappedModel(
		MembershipSubscribedServices membershipSubscribedServices) {
		if (membershipSubscribedServices instanceof MembershipSubscribedServicesImpl) {
			return membershipSubscribedServices;
		}

		MembershipSubscribedServicesImpl membershipSubscribedServicesImpl = new MembershipSubscribedServicesImpl();

		membershipSubscribedServicesImpl.setNew(membershipSubscribedServices.isNew());
		membershipSubscribedServicesImpl.setPrimaryKey(membershipSubscribedServices.getPrimaryKey());

		membershipSubscribedServicesImpl.setMssId(membershipSubscribedServices.getMssId());
		membershipSubscribedServicesImpl.setUserid(membershipSubscribedServices.getUserid());
		membershipSubscribedServicesImpl.setCompanyId(membershipSubscribedServices.getCompanyId());
		membershipSubscribedServicesImpl.setScId(membershipSubscribedServices.getScId());
		membershipSubscribedServicesImpl.setScName(membershipSubscribedServices.getScName());
		membershipSubscribedServicesImpl.setCount(membershipSubscribedServices.getCount());
		membershipSubscribedServicesImpl.setStatus(membershipSubscribedServices.getStatus());
		membershipSubscribedServicesImpl.setDescription(membershipSubscribedServices.getDescription());
		membershipSubscribedServicesImpl.setDateAdded(membershipSubscribedServices.getDateAdded());
		membershipSubscribedServicesImpl.setDateModified(membershipSubscribedServices.getDateModified());
		membershipSubscribedServicesImpl.setCreatedBy(membershipSubscribedServices.getCreatedBy());
		membershipSubscribedServicesImpl.setModifiedBy(membershipSubscribedServices.getModifiedBy());
		membershipSubscribedServicesImpl.setEffectiveFromDate(membershipSubscribedServices.getEffectiveFromDate());
		membershipSubscribedServicesImpl.setEffectiveToDate(membershipSubscribedServices.getEffectiveToDate());
		membershipSubscribedServicesImpl.setParamFrom(membershipSubscribedServices.getParamFrom());
		membershipSubscribedServicesImpl.setParamUpto(membershipSubscribedServices.getParamUpto());
		membershipSubscribedServicesImpl.setDuration(membershipSubscribedServices.getDuration());
		membershipSubscribedServicesImpl.setDurationType(membershipSubscribedServices.getDurationType());
		membershipSubscribedServicesImpl.setServiceCharges(membershipSubscribedServices.getServiceCharges());
		membershipSubscribedServicesImpl.setServiceChargesCurrency(membershipSubscribedServices.getServiceChargesCurrency());
		membershipSubscribedServicesImpl.setServiceChargesPeriod(membershipSubscribedServices.getServiceChargesPeriod());
		membershipSubscribedServicesImpl.setServiceChargesPeriodType(membershipSubscribedServices.getServiceChargesPeriodType());
		membershipSubscribedServicesImpl.setExtra1(membershipSubscribedServices.getExtra1());
		membershipSubscribedServicesImpl.setExtra2(membershipSubscribedServices.getExtra2());
		membershipSubscribedServicesImpl.setExtra3(membershipSubscribedServices.getExtra3());
		membershipSubscribedServicesImpl.setExtra4(membershipSubscribedServices.getExtra4());
		membershipSubscribedServicesImpl.setExtra5(membershipSubscribedServices.getExtra5());
		membershipSubscribedServicesImpl.setExtra6(membershipSubscribedServices.getExtra6());

		return membershipSubscribedServicesImpl;
	}

	/**
	 * Returns the membership subscribed services with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscribed services
	 * @return the membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		MembershipSubscribedServices membershipSubscribedServices = fetchByPrimaryKey(primaryKey);

		if (membershipSubscribedServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipSubscribedServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipSubscribedServices;
	}

	/**
	 * Returns the membership subscribed services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException} if it could not be found.
	 *
	 * @param mssId the primary key of the membership subscribed services
	 * @return the membership subscribed services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscribedServicesException if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices findByPrimaryKey(long mssId)
		throws NoSuchMembershipSubscribedServicesException, SystemException {
		return findByPrimaryKey((Serializable)mssId);
	}

	/**
	 * Returns the membership subscribed services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscribed services
	 * @return the membership subscribed services, or <code>null</code> if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipSubscribedServices membershipSubscribedServices = (MembershipSubscribedServices)EntityCacheUtil.getResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscribedServicesImpl.class, primaryKey);

		if (membershipSubscribedServices == _nullMembershipSubscribedServices) {
			return null;
		}

		if (membershipSubscribedServices == null) {
			Session session = null;

			try {
				session = openSession();

				membershipSubscribedServices = (MembershipSubscribedServices)session.get(MembershipSubscribedServicesImpl.class,
						primaryKey);

				if (membershipSubscribedServices != null) {
					cacheResult(membershipSubscribedServices);
				}
				else {
					EntityCacheUtil.putResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscribedServicesImpl.class, primaryKey,
						_nullMembershipSubscribedServices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipSubscribedServicesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipSubscribedServicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipSubscribedServices;
	}

	/**
	 * Returns the membership subscribed services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mssId the primary key of the membership subscribed services
	 * @return the membership subscribed services, or <code>null</code> if a membership subscribed services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscribedServices fetchByPrimaryKey(long mssId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mssId);
	}

	/**
	 * Returns all the membership subscribed serviceses.
	 *
	 * @return the membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscribed serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @return the range of membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscribed serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscribedServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscribed serviceses
	 * @param end the upper bound of the range of membership subscribed serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership subscribed serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscribedServices> findAll(int start, int end,
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

		List<MembershipSubscribedServices> list = (List<MembershipSubscribedServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES;

				if (pagination) {
					sql = sql.concat(MembershipSubscribedServicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscribedServices>(list);
				}
				else {
					list = (List<MembershipSubscribedServices>)QueryUtil.list(q,
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
	 * Removes all the membership subscribed serviceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipSubscribedServices membershipSubscribedServices : findAll()) {
			remove(membershipSubscribedServices);
		}
	}

	/**
	 * Returns the number of membership subscribed serviceses.
	 *
	 * @return the number of membership subscribed serviceses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPSUBSCRIBEDSERVICES);

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
	 * Initializes the membership subscribed services persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipSubscribedServices>> listenersList = new ArrayList<ModelListener<MembershipSubscribedServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipSubscribedServices>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipSubscribedServicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES = "SELECT membershipSubscribedServices FROM MembershipSubscribedServices membershipSubscribedServices";
	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE = "SELECT membershipSubscribedServices FROM MembershipSubscribedServices membershipSubscribedServices WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIBEDSERVICES = "SELECT COUNT(membershipSubscribedServices) FROM MembershipSubscribedServices membershipSubscribedServices";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIBEDSERVICES_WHERE = "SELECT COUNT(membershipSubscribedServices) FROM MembershipSubscribedServices membershipSubscribedServices WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipSubscribedServices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipSubscribedServices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipSubscribedServices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipSubscribedServicesPersistenceImpl.class);
	private static MembershipSubscribedServices _nullMembershipSubscribedServices =
		new MembershipSubscribedServicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipSubscribedServices> toCacheModel() {
				return _nullMembershipSubscribedServicesCacheModel;
			}
		};

	private static CacheModel<MembershipSubscribedServices> _nullMembershipSubscribedServicesCacheModel =
		new CacheModel<MembershipSubscribedServices>() {
			@Override
			public MembershipSubscribedServices toEntityModel() {
				return _nullMembershipSubscribedServices;
			}
		};
}