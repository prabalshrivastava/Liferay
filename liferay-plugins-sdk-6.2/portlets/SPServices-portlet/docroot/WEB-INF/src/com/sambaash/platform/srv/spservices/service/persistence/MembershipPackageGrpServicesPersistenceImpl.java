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

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException;
import com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership package grp services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageGrpServicesPersistence
 * @see MembershipPackageGrpServicesUtil
 * @generated
 */
public class MembershipPackageGrpServicesPersistenceImpl
	extends BasePersistenceImpl<MembershipPackageGrpServices>
	implements MembershipPackageGrpServicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackageGrpServicesUtil} to access the membership package grp services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackageGrpServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageGrpServicesScgId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageGrpServicesScgId",
			new String[] { String.class.getName() },
			MembershipPackageGrpServicesModelImpl.SCGID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageGrpServicesScgId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership package grp serviceses where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @return the matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		String scgId) throws SystemException {
		return findByMembershipPackageGrpServicesScgId(scgId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package grp serviceses where scgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scgId the scg ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @return the range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		String scgId, int start, int end) throws SystemException {
		return findByMembershipPackageGrpServicesScgId(scgId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package grp serviceses where scgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scgId the scg ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
		String scgId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID;
			finderArgs = new Object[] { scgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID;
			finderArgs = new Object[] { scgId, start, end, orderByComparator };
		}

		List<MembershipPackageGrpServices> list = (List<MembershipPackageGrpServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageGrpServices membershipPackageGrpServices : list) {
				if (!Validator.equals(scgId,
							membershipPackageGrpServices.getScgId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			boolean bindScgId = false;

			if (scgId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_1);
			}
			else if (scgId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_3);
			}
			else {
				bindScgId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScgId) {
					qPos.add(scgId);
				}

				if (!pagination) {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageGrpServices>(list);
				}
				else {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
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
	 * Returns the first membership package grp services in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesScgId_First(
		String scgId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesScgId_First(scgId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scgId=");
		msg.append(scgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package grp services in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScgId_First(
		String scgId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesScgId(scgId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package grp services in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesScgId_Last(
		String scgId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesScgId_Last(scgId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scgId=");
		msg.append(scgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package grp services in the ordered set where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScgId_Last(
		String scgId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageGrpServicesScgId(scgId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesScgId(scgId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where scgId = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package grp services
	 * @param scgId the scg ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices[] findByMembershipPackageGrpServicesScgId_PrevAndNext(
		long mpgsscId, String scgId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageGrpServices[] array = new MembershipPackageGrpServicesImpl[3];

			array[0] = getByMembershipPackageGrpServicesScgId_PrevAndNext(session,
					membershipPackageGrpServices, scgId, orderByComparator, true);

			array[1] = membershipPackageGrpServices;

			array[2] = getByMembershipPackageGrpServicesScgId_PrevAndNext(session,
					membershipPackageGrpServices, scgId, orderByComparator,
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

	protected MembershipPackageGrpServices getByMembershipPackageGrpServicesScgId_PrevAndNext(
		Session session,
		MembershipPackageGrpServices membershipPackageGrpServices,
		String scgId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

		boolean bindScgId = false;

		if (scgId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_1);
		}
		else if (scgId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_3);
		}
		else {
			bindScgId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_2);
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
			query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScgId) {
			qPos.add(scgId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageGrpServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageGrpServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package grp serviceses where scgId = &#63; from the database.
	 *
	 * @param scgId the scg ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageGrpServicesScgId(String scgId)
		throws SystemException {
		for (MembershipPackageGrpServices membershipPackageGrpServices : findByMembershipPackageGrpServicesScgId(
				scgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageGrpServices);
		}
	}

	/**
	 * Returns the number of membership package grp serviceses where scgId = &#63;.
	 *
	 * @param scgId the scg ID
	 * @return the number of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageGrpServicesScgId(String scgId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID;

		Object[] finderArgs = new Object[] { scgId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			boolean bindScgId = false;

			if (scgId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_1);
			}
			else if (scgId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_3);
			}
			else {
				bindScgId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScgId) {
					qPos.add(scgId);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_1 =
		"membershipPackageGrpServices.scgId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_2 =
		"membershipPackageGrpServices.scgId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCGID_SCGID_3 =
		"(membershipPackageGrpServices.scgId IS NULL OR membershipPackageGrpServices.scgId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageGrpServicesScId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageGrpServicesScId",
			new String[] { String.class.getName() },
			MembershipPackageGrpServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCGID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageGrpServicesScId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership package grp serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		String scId) throws SystemException {
		return findByMembershipPackageGrpServicesScId(scId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package grp serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @return the range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		String scId, int start, int end) throws SystemException {
		return findByMembershipPackageGrpServicesScId(scId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package grp serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
		String scId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID;
			finderArgs = new Object[] { scId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID;
			finderArgs = new Object[] { scId, start, end, orderByComparator };
		}

		List<MembershipPackageGrpServices> list = (List<MembershipPackageGrpServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageGrpServices membershipPackageGrpServices : list) {
				if (!Validator.equals(scId,
							membershipPackageGrpServices.getScId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageGrpServices>(list);
				}
				else {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
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
	 * Returns the first membership package grp services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesScId_First(scId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package grp services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesScId(scId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package grp services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesScId_Last(scId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package grp services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageGrpServicesScId(scId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesScId(scId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where scId = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package grp services
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices[] findByMembershipPackageGrpServicesScId_PrevAndNext(
		long mpgsscId, String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageGrpServices[] array = new MembershipPackageGrpServicesImpl[3];

			array[0] = getByMembershipPackageGrpServicesScId_PrevAndNext(session,
					membershipPackageGrpServices, scId, orderByComparator, true);

			array[1] = membershipPackageGrpServices;

			array[2] = getByMembershipPackageGrpServicesScId_PrevAndNext(session,
					membershipPackageGrpServices, scId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackageGrpServices getByMembershipPackageGrpServicesScId_PrevAndNext(
		Session session,
		MembershipPackageGrpServices membershipPackageGrpServices, String scId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_2);
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
			query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageGrpServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageGrpServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package grp serviceses where scId = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageGrpServicesScId(String scId)
		throws SystemException {
		for (MembershipPackageGrpServices membershipPackageGrpServices : findByMembershipPackageGrpServicesScId(
				scId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageGrpServices);
		}
	}

	/**
	 * Returns the number of membership package grp serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the number of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageGrpServicesScId(String scId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID;

		Object[] finderArgs = new Object[] { scId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_1 =
		"membershipPackageGrpServices.scId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_2 =
		"membershipPackageGrpServices.scId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESSCID_SCID_3 =
		"(membershipPackageGrpServices.scId IS NULL OR membershipPackageGrpServices.scId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageGrpServicesMpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageGrpServicesMpId",
			new String[] { Long.class.getName() },
			MembershipPackageGrpServicesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCGID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageGrpServicesMpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package grp serviceses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId) throws SystemException {
		return findByMembershipPackageGrpServicesMpId(mpId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package grp serviceses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @return the range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end) throws SystemException {
		return findByMembershipPackageGrpServicesMpId(mpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package grp serviceses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
		long mpId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID;
			finderArgs = new Object[] { mpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID;
			finderArgs = new Object[] { mpId, start, end, orderByComparator };
		}

		List<MembershipPackageGrpServices> list = (List<MembershipPackageGrpServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageGrpServices membershipPackageGrpServices : list) {
				if ((mpId != membershipPackageGrpServices.getMpId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESMPID_MPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (!pagination) {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageGrpServices>(list);
				}
				else {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
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
	 * Returns the first membership package grp services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesMpId_First(
		long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesMpId_First(mpId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package grp services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesMpId_First(
		long mpId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesMpId(mpId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package grp services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByMembershipPackageGrpServicesMpId_Last(
		long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByMembershipPackageGrpServicesMpId_Last(mpId,
				orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package grp services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByMembershipPackageGrpServicesMpId_Last(
		long mpId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageGrpServicesMpId(mpId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageGrpServices> list = findByMembershipPackageGrpServicesMpId(mpId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where mpId = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package grp services
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices[] findByMembershipPackageGrpServicesMpId_PrevAndNext(
		long mpgsscId, long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageGrpServices[] array = new MembershipPackageGrpServicesImpl[3];

			array[0] = getByMembershipPackageGrpServicesMpId_PrevAndNext(session,
					membershipPackageGrpServices, mpId, orderByComparator, true);

			array[1] = membershipPackageGrpServices;

			array[2] = getByMembershipPackageGrpServicesMpId_PrevAndNext(session,
					membershipPackageGrpServices, mpId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackageGrpServices getByMembershipPackageGrpServicesMpId_PrevAndNext(
		Session session,
		MembershipPackageGrpServices membershipPackageGrpServices, long mpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESMPID_MPID_2);

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
			query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageGrpServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageGrpServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package grp serviceses where mpId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageGrpServicesMpId(long mpId)
		throws SystemException {
		for (MembershipPackageGrpServices membershipPackageGrpServices : findByMembershipPackageGrpServicesMpId(
				mpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageGrpServices);
		}
	}

	/**
	 * Returns the number of membership package grp serviceses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the number of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageGrpServicesMpId(long mpId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID;

		Object[] finderArgs = new Object[] { mpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESMPID_MPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEGRPSERVICESMPID_MPID_2 =
		"membershipPackageGrpServices.mpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceNameMpId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() },
			MembershipPackageGrpServicesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.EXTRA2_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCGID_COLUMN_BITMASK |
			MembershipPackageGrpServicesModelImpl.SCORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICENAMEMPID = new FinderPath(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @return the matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByServiceNameMpId(long mpId,
		String extra2) throws SystemException {
		return findByServiceNameMpId(mpId, extra2, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @return the range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByServiceNameMpId(long mpId,
		String extra2, int start, int end) throws SystemException {
		return findByServiceNameMpId(mpId, extra2, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findByServiceNameMpId(long mpId,
		String extra2, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] { mpId, extra2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] {
					mpId, extra2,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageGrpServices> list = (List<MembershipPackageGrpServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageGrpServices membershipPackageGrpServices : list) {
				if ((mpId != membershipPackageGrpServices.getMpId()) ||
						!Validator.equals(extra2,
							membershipPackageGrpServices.getExtra2())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

			boolean bindExtra2 = false;

			if (extra2 == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_1);
			}
			else if (extra2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_3);
			}
			else {
				bindExtra2 = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (bindExtra2) {
					qPos.add(extra2);
				}

				if (!pagination) {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageGrpServices>(list);
				}
				else {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
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
	 * Returns the first membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByServiceNameMpId_First(long mpId,
		String extra2, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByServiceNameMpId_First(mpId,
				extra2, orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra2=");
		msg.append(extra2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByServiceNameMpId_First(
		long mpId, String extra2, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageGrpServices> list = findByServiceNameMpId(mpId,
				extra2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByServiceNameMpId_Last(long mpId,
		String extra2, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByServiceNameMpId_Last(mpId,
				extra2, orderByComparator);

		if (membershipPackageGrpServices != null) {
			return membershipPackageGrpServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra2=");
		msg.append(extra2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageGrpServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package grp services, or <code>null</code> if a matching membership package grp services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByServiceNameMpId_Last(long mpId,
		String extra2, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceNameMpId(mpId, extra2);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageGrpServices> list = findByServiceNameMpId(mpId,
				extra2, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package grp serviceses before and after the current membership package grp services in the ordered set where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package grp services
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices[] findByServiceNameMpId_PrevAndNext(
		long mpgsscId, long mpId, String extra2,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageGrpServices[] array = new MembershipPackageGrpServicesImpl[3];

			array[0] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageGrpServices, mpId, extra2,
					orderByComparator, true);

			array[1] = membershipPackageGrpServices;

			array[2] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageGrpServices, mpId, extra2,
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

	protected MembershipPackageGrpServices getByServiceNameMpId_PrevAndNext(
		Session session,
		MembershipPackageGrpServices membershipPackageGrpServices, long mpId,
		String extra2, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

		query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

		boolean bindExtra2 = false;

		if (extra2 == null) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_1);
		}
		else if (extra2.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_3);
		}
		else {
			bindExtra2 = true;

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_2);
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
			query.append(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		if (bindExtra2) {
			qPos.add(extra2);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageGrpServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageGrpServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package grp serviceses where mpId = &#63; and extra2 = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceNameMpId(long mpId, String extra2)
		throws SystemException {
		for (MembershipPackageGrpServices membershipPackageGrpServices : findByServiceNameMpId(
				mpId, extra2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageGrpServices);
		}
	}

	/**
	 * Returns the number of membership package grp serviceses where mpId = &#63; and extra2 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra2 the extra2
	 * @return the number of matching membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceNameMpId(long mpId, String extra2)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICENAMEMPID;

		Object[] finderArgs = new Object[] { mpId, extra2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE);

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

			boolean bindExtra2 = false;

			if (extra2 == null) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_1);
			}
			else if (extra2.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_3);
			}
			else {
				bindExtra2 = true;

				query.append(_FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (bindExtra2) {
					qPos.add(extra2);
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

	private static final String _FINDER_COLUMN_SERVICENAMEMPID_MPID_2 = "membershipPackageGrpServices.mpId = ? AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_1 = "membershipPackageGrpServices.extra2 IS NULL";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_2 = "membershipPackageGrpServices.extra2 = ?";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA2_3 = "(membershipPackageGrpServices.extra2 IS NULL OR membershipPackageGrpServices.extra2 = '')";

	public MembershipPackageGrpServicesPersistenceImpl() {
		setModelClass(MembershipPackageGrpServices.class);
	}

	/**
	 * Caches the membership package grp services in the entity cache if it is enabled.
	 *
	 * @param membershipPackageGrpServices the membership package grp services
	 */
	@Override
	public void cacheResult(
		MembershipPackageGrpServices membershipPackageGrpServices) {
		EntityCacheUtil.putResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			membershipPackageGrpServices.getPrimaryKey(),
			membershipPackageGrpServices);

		membershipPackageGrpServices.resetOriginalValues();
	}

	/**
	 * Caches the membership package grp serviceses in the entity cache if it is enabled.
	 *
	 * @param membershipPackageGrpServiceses the membership package grp serviceses
	 */
	@Override
	public void cacheResult(
		List<MembershipPackageGrpServices> membershipPackageGrpServiceses) {
		for (MembershipPackageGrpServices membershipPackageGrpServices : membershipPackageGrpServiceses) {
			if (EntityCacheUtil.getResult(
						MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageGrpServicesImpl.class,
						membershipPackageGrpServices.getPrimaryKey()) == null) {
				cacheResult(membershipPackageGrpServices);
			}
			else {
				membershipPackageGrpServices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership package grp serviceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackageGrpServicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackageGrpServicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package grp services.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipPackageGrpServices membershipPackageGrpServices) {
		EntityCacheUtil.removeResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			membershipPackageGrpServices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipPackageGrpServices> membershipPackageGrpServiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackageGrpServices membershipPackageGrpServices : membershipPackageGrpServiceses) {
			EntityCacheUtil.removeResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageGrpServicesImpl.class,
				membershipPackageGrpServices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package grp services with the primary key. Does not add the membership package grp services to the database.
	 *
	 * @param mpgsscId the primary key for the new membership package grp services
	 * @return the new membership package grp services
	 */
	@Override
	public MembershipPackageGrpServices create(long mpgsscId) {
		MembershipPackageGrpServices membershipPackageGrpServices = new MembershipPackageGrpServicesImpl();

		membershipPackageGrpServices.setNew(true);
		membershipPackageGrpServices.setPrimaryKey(mpgsscId);

		return membershipPackageGrpServices;
	}

	/**
	 * Removes the membership package grp services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mpgsscId the primary key of the membership package grp services
	 * @return the membership package grp services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices remove(long mpgsscId)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		return remove((Serializable)mpgsscId);
	}

	/**
	 * Removes the membership package grp services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package grp services
	 * @return the membership package grp services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices remove(Serializable primaryKey)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackageGrpServices membershipPackageGrpServices = (MembershipPackageGrpServices)session.get(MembershipPackageGrpServicesImpl.class,
					primaryKey);

			if (membershipPackageGrpServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackageGrpServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackageGrpServices);
		}
		catch (NoSuchMembershipPackageGrpServicesException nsee) {
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
	protected MembershipPackageGrpServices removeImpl(
		MembershipPackageGrpServices membershipPackageGrpServices)
		throws SystemException {
		membershipPackageGrpServices = toUnwrappedModel(membershipPackageGrpServices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackageGrpServices)) {
				membershipPackageGrpServices = (MembershipPackageGrpServices)session.get(MembershipPackageGrpServicesImpl.class,
						membershipPackageGrpServices.getPrimaryKeyObj());
			}

			if (membershipPackageGrpServices != null) {
				session.delete(membershipPackageGrpServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackageGrpServices != null) {
			clearCache(membershipPackageGrpServices);
		}

		return membershipPackageGrpServices;
	}

	@Override
	public MembershipPackageGrpServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices membershipPackageGrpServices)
		throws SystemException {
		membershipPackageGrpServices = toUnwrappedModel(membershipPackageGrpServices);

		boolean isNew = membershipPackageGrpServices.isNew();

		MembershipPackageGrpServicesModelImpl membershipPackageGrpServicesModelImpl =
			(MembershipPackageGrpServicesModelImpl)membershipPackageGrpServices;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackageGrpServices.isNew()) {
				session.save(membershipPackageGrpServices);

				membershipPackageGrpServices.setNew(false);
			}
			else {
				session.merge(membershipPackageGrpServices);
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
				!MembershipPackageGrpServicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackageGrpServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageGrpServicesModelImpl.getOriginalScgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID,
					args);

				args = new Object[] {
						membershipPackageGrpServicesModelImpl.getScgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCGID,
					args);
			}

			if ((membershipPackageGrpServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageGrpServicesModelImpl.getOriginalScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID,
					args);

				args = new Object[] {
						membershipPackageGrpServicesModelImpl.getScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESSCID,
					args);
			}

			if ((membershipPackageGrpServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageGrpServicesModelImpl.getOriginalMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID,
					args);

				args = new Object[] {
						membershipPackageGrpServicesModelImpl.getMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEGRPSERVICESMPID,
					args);
			}

			if ((membershipPackageGrpServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageGrpServicesModelImpl.getOriginalMpId(),
						membershipPackageGrpServicesModelImpl.getOriginalExtra2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);

				args = new Object[] {
						membershipPackageGrpServicesModelImpl.getMpId(),
						membershipPackageGrpServicesModelImpl.getExtra2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageGrpServicesImpl.class,
			membershipPackageGrpServices.getPrimaryKey(),
			membershipPackageGrpServices);

		return membershipPackageGrpServices;
	}

	protected MembershipPackageGrpServices toUnwrappedModel(
		MembershipPackageGrpServices membershipPackageGrpServices) {
		if (membershipPackageGrpServices instanceof MembershipPackageGrpServicesImpl) {
			return membershipPackageGrpServices;
		}

		MembershipPackageGrpServicesImpl membershipPackageGrpServicesImpl = new MembershipPackageGrpServicesImpl();

		membershipPackageGrpServicesImpl.setNew(membershipPackageGrpServices.isNew());
		membershipPackageGrpServicesImpl.setPrimaryKey(membershipPackageGrpServices.getPrimaryKey());

		membershipPackageGrpServicesImpl.setMpgsscId(membershipPackageGrpServices.getMpgsscId());
		membershipPackageGrpServicesImpl.setMpId(membershipPackageGrpServices.getMpId());
		membershipPackageGrpServicesImpl.setScorder(membershipPackageGrpServices.getScorder());
		membershipPackageGrpServicesImpl.setScgId(membershipPackageGrpServices.getScgId());
		membershipPackageGrpServicesImpl.setScId(membershipPackageGrpServices.getScId());
		membershipPackageGrpServicesImpl.setParamType(membershipPackageGrpServices.getParamType());
		membershipPackageGrpServicesImpl.setParamFrom(membershipPackageGrpServices.getParamFrom());
		membershipPackageGrpServicesImpl.setParamUpto(membershipPackageGrpServices.getParamUpto());
		membershipPackageGrpServicesImpl.setDuration(membershipPackageGrpServices.getDuration());
		membershipPackageGrpServicesImpl.setDurationType(membershipPackageGrpServices.getDurationType());
		membershipPackageGrpServicesImpl.setStatus(membershipPackageGrpServices.getStatus());
		membershipPackageGrpServicesImpl.setDescription(membershipPackageGrpServices.getDescription());
		membershipPackageGrpServicesImpl.setDateAdded(membershipPackageGrpServices.getDateAdded());
		membershipPackageGrpServicesImpl.setDateModified(membershipPackageGrpServices.getDateModified());
		membershipPackageGrpServicesImpl.setCreatedBy(membershipPackageGrpServices.getCreatedBy());
		membershipPackageGrpServicesImpl.setModifiedBy(membershipPackageGrpServices.getModifiedBy());
		membershipPackageGrpServicesImpl.setExtra1(membershipPackageGrpServices.getExtra1());
		membershipPackageGrpServicesImpl.setExtra2(membershipPackageGrpServices.getExtra2());
		membershipPackageGrpServicesImpl.setExtra3(membershipPackageGrpServices.getExtra3());
		membershipPackageGrpServicesImpl.setExtra4(membershipPackageGrpServices.getExtra4());
		membershipPackageGrpServicesImpl.setExtra5(membershipPackageGrpServices.getExtra5());
		membershipPackageGrpServicesImpl.setExtra6(membershipPackageGrpServices.getExtra6());
		membershipPackageGrpServicesImpl.setServiceCharges(membershipPackageGrpServices.getServiceCharges());
		membershipPackageGrpServicesImpl.setCostCurrency(membershipPackageGrpServices.getCostCurrency());
		membershipPackageGrpServicesImpl.setCostPeriod(membershipPackageGrpServices.getCostPeriod());
		membershipPackageGrpServicesImpl.setCostPeriodType(membershipPackageGrpServices.getCostPeriodType());

		return membershipPackageGrpServicesImpl;
	}

	/**
	 * Returns the membership package grp services with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package grp services
	 * @return the membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = fetchByPrimaryKey(primaryKey);

		if (membershipPackageGrpServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackageGrpServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackageGrpServices;
	}

	/**
	 * Returns the membership package grp services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException} if it could not be found.
	 *
	 * @param mpgsscId the primary key of the membership package grp services
	 * @return the membership package grp services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageGrpServicesException if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices findByPrimaryKey(long mpgsscId)
		throws NoSuchMembershipPackageGrpServicesException, SystemException {
		return findByPrimaryKey((Serializable)mpgsscId);
	}

	/**
	 * Returns the membership package grp services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package grp services
	 * @return the membership package grp services, or <code>null</code> if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipPackageGrpServices membershipPackageGrpServices = (MembershipPackageGrpServices)EntityCacheUtil.getResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageGrpServicesImpl.class, primaryKey);

		if (membershipPackageGrpServices == _nullMembershipPackageGrpServices) {
			return null;
		}

		if (membershipPackageGrpServices == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackageGrpServices = (MembershipPackageGrpServices)session.get(MembershipPackageGrpServicesImpl.class,
						primaryKey);

				if (membershipPackageGrpServices != null) {
					cacheResult(membershipPackageGrpServices);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageGrpServicesImpl.class, primaryKey,
						_nullMembershipPackageGrpServices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackageGrpServicesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackageGrpServicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackageGrpServices;
	}

	/**
	 * Returns the membership package grp services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mpgsscId the primary key of the membership package grp services
	 * @return the membership package grp services, or <code>null</code> if a membership package grp services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageGrpServices fetchByPrimaryKey(long mpgsscId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mpgsscId);
	}

	/**
	 * Returns all the membership package grp serviceses.
	 *
	 * @return the membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package grp serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @return the range of membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package grp serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageGrpServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package grp serviceses
	 * @param end the upper bound of the range of membership package grp serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership package grp serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageGrpServices> findAll(int start, int end,
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

		List<MembershipPackageGrpServices> list = (List<MembershipPackageGrpServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES;

				if (pagination) {
					sql = sql.concat(MembershipPackageGrpServicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageGrpServices>(list);
				}
				else {
					list = (List<MembershipPackageGrpServices>)QueryUtil.list(q,
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
	 * Removes all the membership package grp serviceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackageGrpServices membershipPackageGrpServices : findAll()) {
			remove(membershipPackageGrpServices);
		}
	}

	/**
	 * Returns the number of membership package grp serviceses.
	 *
	 * @return the number of membership package grp serviceses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES);

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
	 * Initializes the membership package grp services persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackageGrpServices>> listenersList = new ArrayList<ModelListener<MembershipPackageGrpServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackageGrpServices>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipPackageGrpServicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES = "SELECT membershipPackageGrpServices FROM MembershipPackageGrpServices membershipPackageGrpServices";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE = "SELECT membershipPackageGrpServices FROM MembershipPackageGrpServices membershipPackageGrpServices WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES = "SELECT COUNT(membershipPackageGrpServices) FROM MembershipPackageGrpServices membershipPackageGrpServices";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEGRPSERVICES_WHERE = "SELECT COUNT(membershipPackageGrpServices) FROM MembershipPackageGrpServices membershipPackageGrpServices WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackageGrpServices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackageGrpServices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackageGrpServices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackageGrpServicesPersistenceImpl.class);
	private static MembershipPackageGrpServices _nullMembershipPackageGrpServices =
		new MembershipPackageGrpServicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackageGrpServices> toCacheModel() {
				return _nullMembershipPackageGrpServicesCacheModel;
			}
		};

	private static CacheModel<MembershipPackageGrpServices> _nullMembershipPackageGrpServicesCacheModel =
		new CacheModel<MembershipPackageGrpServices>() {
			@Override
			public MembershipPackageGrpServices toEntityModel() {
				return _nullMembershipPackageGrpServices;
			}
		};
}