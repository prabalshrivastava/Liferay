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

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException;
import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership package ind services service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageIndServicesPersistence
 * @see MembershipPackageIndServicesUtil
 * @generated
 */
public class MembershipPackageIndServicesPersistenceImpl
	extends BasePersistenceImpl<MembershipPackageIndServices>
	implements MembershipPackageIndServicesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackageIndServicesUtil} to access the membership package ind services persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackageIndServicesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageIndServicesScId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageIndServicesScId",
			new String[] { String.class.getName() },
			MembershipPackageIndServicesModelImpl.SCID_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.SCORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESSCID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageIndServicesScId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership package ind serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		String scId) throws SystemException {
		return findByMembershipPackageIndServicesScId(scId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package ind serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @return the range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		String scId, int start, int end) throws SystemException {
		return findByMembershipPackageIndServicesScId(scId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package ind serviceses where scId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scId the sc ID
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
		String scId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID;
			finderArgs = new Object[] { scId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID;
			finderArgs = new Object[] { scId, start, end, orderByComparator };
		}

		List<MembershipPackageIndServices> list = (List<MembershipPackageIndServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageIndServices membershipPackageIndServices : list) {
				if (!Validator.equals(scId,
							membershipPackageIndServices.getScId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageIndServices>(list);
				}
				else {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
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
	 * Returns the first membership package ind services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByMembershipPackageIndServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByMembershipPackageIndServicesScId_First(scId,
				orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package ind services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_First(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageIndServices> list = findByMembershipPackageIndServicesScId(scId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package ind services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByMembershipPackageIndServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByMembershipPackageIndServicesScId_Last(scId,
				orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scId=");
		msg.append(scId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package ind services in the ordered set where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByMembershipPackageIndServicesScId_Last(
		String scId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageIndServicesScId(scId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageIndServices> list = findByMembershipPackageIndServicesScId(scId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where scId = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package ind services
	 * @param scId the sc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices[] findByMembershipPackageIndServicesScId_PrevAndNext(
		long mpgsscId, String scId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageIndServices[] array = new MembershipPackageIndServicesImpl[3];

			array[0] = getByMembershipPackageIndServicesScId_PrevAndNext(session,
					membershipPackageIndServices, scId, orderByComparator, true);

			array[1] = membershipPackageIndServices;

			array[2] = getByMembershipPackageIndServicesScId_PrevAndNext(session,
					membershipPackageIndServices, scId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackageIndServices getByMembershipPackageIndServicesScId_PrevAndNext(
		Session session,
		MembershipPackageIndServices membershipPackageIndServices, String scId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

		boolean bindScId = false;

		if (scId == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_1);
		}
		else if (scId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_3);
		}
		else {
			bindScId = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_2);
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
			query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageIndServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageIndServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package ind serviceses where scId = &#63; from the database.
	 *
	 * @param scId the sc ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageIndServicesScId(String scId)
		throws SystemException {
		for (MembershipPackageIndServices membershipPackageIndServices : findByMembershipPackageIndServicesScId(
				scId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageIndServices);
		}
	}

	/**
	 * Returns the number of membership package ind serviceses where scId = &#63;.
	 *
	 * @param scId the sc ID
	 * @return the number of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageIndServicesScId(String scId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESSCID;

		Object[] finderArgs = new Object[] { scId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			boolean bindScId = false;

			if (scId == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_1);
			}
			else if (scId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_3);
			}
			else {
				bindScId = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_1 =
		"membershipPackageIndServices.scId IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_2 =
		"membershipPackageIndServices.scId = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESSCID_SCID_3 =
		"(membershipPackageIndServices.scId IS NULL OR membershipPackageIndServices.scId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageIndServicesMpId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageIndServicesMpId",
			new String[] { Long.class.getName() },
			MembershipPackageIndServicesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.SCORDER_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.SCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESMPID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageIndServicesMpId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package ind serviceses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId) throws SystemException {
		return findByMembershipPackageIndServicesMpId(mpId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package ind serviceses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @return the range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end) throws SystemException {
		return findByMembershipPackageIndServicesMpId(mpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package ind serviceses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
		long mpId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID;
			finderArgs = new Object[] { mpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID;
			finderArgs = new Object[] { mpId, start, end, orderByComparator };
		}

		List<MembershipPackageIndServices> list = (List<MembershipPackageIndServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageIndServices membershipPackageIndServices : list) {
				if ((mpId != membershipPackageIndServices.getMpId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESMPID_MPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (!pagination) {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageIndServices>(list);
				}
				else {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
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
	 * Returns the first membership package ind services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByMembershipPackageIndServicesMpId_First(
		long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByMembershipPackageIndServicesMpId_First(mpId,
				orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package ind services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_First(
		long mpId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageIndServices> list = findByMembershipPackageIndServicesMpId(mpId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package ind services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByMembershipPackageIndServicesMpId_Last(
		long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByMembershipPackageIndServicesMpId_Last(mpId,
				orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package ind services in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByMembershipPackageIndServicesMpId_Last(
		long mpId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageIndServicesMpId(mpId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageIndServices> list = findByMembershipPackageIndServicesMpId(mpId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where mpId = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package ind services
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices[] findByMembershipPackageIndServicesMpId_PrevAndNext(
		long mpgsscId, long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageIndServices[] array = new MembershipPackageIndServicesImpl[3];

			array[0] = getByMembershipPackageIndServicesMpId_PrevAndNext(session,
					membershipPackageIndServices, mpId, orderByComparator, true);

			array[1] = membershipPackageIndServices;

			array[2] = getByMembershipPackageIndServicesMpId_PrevAndNext(session,
					membershipPackageIndServices, mpId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackageIndServices getByMembershipPackageIndServicesMpId_PrevAndNext(
		Session session,
		MembershipPackageIndServices membershipPackageIndServices, long mpId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESMPID_MPID_2);

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
			query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageIndServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageIndServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package ind serviceses where mpId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageIndServicesMpId(long mpId)
		throws SystemException {
		for (MembershipPackageIndServices membershipPackageIndServices : findByMembershipPackageIndServicesMpId(
				mpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageIndServices);
		}
	}

	/**
	 * Returns the number of membership package ind serviceses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the number of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageIndServicesMpId(long mpId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESMPID;

		Object[] finderArgs = new Object[] { mpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESMPID_MPID_2);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEINDSERVICESMPID_MPID_2 =
		"membershipPackageIndServices.mpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceNameMpId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() },
			MembershipPackageIndServicesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.EXTRA1_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.SCORDER_COLUMN_BITMASK |
			MembershipPackageIndServicesModelImpl.SCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICENAMEMPID = new FinderPath(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @return the matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByServiceNameMpId(long mpId,
		String extra1) throws SystemException {
		return findByServiceNameMpId(mpId, extra1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @return the range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByServiceNameMpId(long mpId,
		String extra1, int start, int end) throws SystemException {
		return findByServiceNameMpId(mpId, extra1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findByServiceNameMpId(long mpId,
		String extra1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] { mpId, extra1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID;
			finderArgs = new Object[] {
					mpId, extra1,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageIndServices> list = (List<MembershipPackageIndServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageIndServices membershipPackageIndServices : list) {
				if ((mpId != membershipPackageIndServices.getMpId()) ||
						!Validator.equals(extra1,
							membershipPackageIndServices.getExtra1())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (bindExtra1) {
					qPos.add(extra1);
				}

				if (!pagination) {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageIndServices>(list);
				}
				else {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
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
	 * Returns the first membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByServiceNameMpId_First(long mpId,
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByServiceNameMpId_First(mpId,
				extra1, orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the first membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByServiceNameMpId_First(
		long mpId, String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageIndServices> list = findByServiceNameMpId(mpId,
				extra1, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByServiceNameMpId_Last(long mpId,
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByServiceNameMpId_Last(mpId,
				extra1, orderByComparator);

		if (membershipPackageIndServices != null) {
			return membershipPackageIndServices;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageIndServicesException(msg.toString());
	}

	/**
	 * Returns the last membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package ind services, or <code>null</code> if a matching membership package ind services could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByServiceNameMpId_Last(long mpId,
		String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceNameMpId(mpId, extra1);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageIndServices> list = findByServiceNameMpId(mpId,
				extra1, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package ind serviceses before and after the current membership package ind services in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpgsscId the primary key of the current membership package ind services
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices[] findByServiceNameMpId_PrevAndNext(
		long mpgsscId, long mpId, String extra1,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = findByPrimaryKey(mpgsscId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageIndServices[] array = new MembershipPackageIndServicesImpl[3];

			array[0] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageIndServices, mpId, extra1,
					orderByComparator, true);

			array[1] = membershipPackageIndServices;

			array[2] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageIndServices, mpId, extra1,
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

	protected MembershipPackageIndServices getByServiceNameMpId_PrevAndNext(
		Session session,
		MembershipPackageIndServices membershipPackageIndServices, long mpId,
		String extra1, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

		query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

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
			query.append(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		if (bindExtra1) {
			qPos.add(extra1);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageIndServices);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageIndServices> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package ind serviceses where mpId = &#63; and extra1 = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceNameMpId(long mpId, String extra1)
		throws SystemException {
		for (MembershipPackageIndServices membershipPackageIndServices : findByServiceNameMpId(
				mpId, extra1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageIndServices);
		}
	}

	/**
	 * Returns the number of membership package ind serviceses where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @return the number of matching membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceNameMpId(long mpId, String extra1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICENAMEMPID;

		Object[] finderArgs = new Object[] { mpId, extra1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES_WHERE);

			query.append(_FINDER_COLUMN_SERVICENAMEMPID_MPID_2);

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

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

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

	private static final String _FINDER_COLUMN_SERVICENAMEMPID_MPID_2 = "membershipPackageIndServices.mpId = ? AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1 = "membershipPackageIndServices.extra1 IS NULL";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2 = "membershipPackageIndServices.extra1 = ?";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3 = "(membershipPackageIndServices.extra1 IS NULL OR membershipPackageIndServices.extra1 = '')";

	public MembershipPackageIndServicesPersistenceImpl() {
		setModelClass(MembershipPackageIndServices.class);
	}

	/**
	 * Caches the membership package ind services in the entity cache if it is enabled.
	 *
	 * @param membershipPackageIndServices the membership package ind services
	 */
	@Override
	public void cacheResult(
		MembershipPackageIndServices membershipPackageIndServices) {
		EntityCacheUtil.putResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			membershipPackageIndServices.getPrimaryKey(),
			membershipPackageIndServices);

		membershipPackageIndServices.resetOriginalValues();
	}

	/**
	 * Caches the membership package ind serviceses in the entity cache if it is enabled.
	 *
	 * @param membershipPackageIndServiceses the membership package ind serviceses
	 */
	@Override
	public void cacheResult(
		List<MembershipPackageIndServices> membershipPackageIndServiceses) {
		for (MembershipPackageIndServices membershipPackageIndServices : membershipPackageIndServiceses) {
			if (EntityCacheUtil.getResult(
						MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageIndServicesImpl.class,
						membershipPackageIndServices.getPrimaryKey()) == null) {
				cacheResult(membershipPackageIndServices);
			}
			else {
				membershipPackageIndServices.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership package ind serviceses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackageIndServicesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackageIndServicesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package ind services.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipPackageIndServices membershipPackageIndServices) {
		EntityCacheUtil.removeResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			membershipPackageIndServices.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipPackageIndServices> membershipPackageIndServiceses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackageIndServices membershipPackageIndServices : membershipPackageIndServiceses) {
			EntityCacheUtil.removeResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageIndServicesImpl.class,
				membershipPackageIndServices.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package ind services with the primary key. Does not add the membership package ind services to the database.
	 *
	 * @param mpgsscId the primary key for the new membership package ind services
	 * @return the new membership package ind services
	 */
	@Override
	public MembershipPackageIndServices create(long mpgsscId) {
		MembershipPackageIndServices membershipPackageIndServices = new MembershipPackageIndServicesImpl();

		membershipPackageIndServices.setNew(true);
		membershipPackageIndServices.setPrimaryKey(mpgsscId);

		return membershipPackageIndServices;
	}

	/**
	 * Removes the membership package ind services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mpgsscId the primary key of the membership package ind services
	 * @return the membership package ind services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices remove(long mpgsscId)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		return remove((Serializable)mpgsscId);
	}

	/**
	 * Removes the membership package ind services with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package ind services
	 * @return the membership package ind services that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices remove(Serializable primaryKey)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackageIndServices membershipPackageIndServices = (MembershipPackageIndServices)session.get(MembershipPackageIndServicesImpl.class,
					primaryKey);

			if (membershipPackageIndServices == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackageIndServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackageIndServices);
		}
		catch (NoSuchMembershipPackageIndServicesException nsee) {
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
	protected MembershipPackageIndServices removeImpl(
		MembershipPackageIndServices membershipPackageIndServices)
		throws SystemException {
		membershipPackageIndServices = toUnwrappedModel(membershipPackageIndServices);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackageIndServices)) {
				membershipPackageIndServices = (MembershipPackageIndServices)session.get(MembershipPackageIndServicesImpl.class,
						membershipPackageIndServices.getPrimaryKeyObj());
			}

			if (membershipPackageIndServices != null) {
				session.delete(membershipPackageIndServices);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackageIndServices != null) {
			clearCache(membershipPackageIndServices);
		}

		return membershipPackageIndServices;
	}

	@Override
	public MembershipPackageIndServices updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices membershipPackageIndServices)
		throws SystemException {
		membershipPackageIndServices = toUnwrappedModel(membershipPackageIndServices);

		boolean isNew = membershipPackageIndServices.isNew();

		MembershipPackageIndServicesModelImpl membershipPackageIndServicesModelImpl =
			(MembershipPackageIndServicesModelImpl)membershipPackageIndServices;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackageIndServices.isNew()) {
				session.save(membershipPackageIndServices);

				membershipPackageIndServices.setNew(false);
			}
			else {
				session.merge(membershipPackageIndServices);
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
				!MembershipPackageIndServicesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackageIndServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageIndServicesModelImpl.getOriginalScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID,
					args);

				args = new Object[] {
						membershipPackageIndServicesModelImpl.getScId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESSCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESSCID,
					args);
			}

			if ((membershipPackageIndServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageIndServicesModelImpl.getOriginalMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID,
					args);

				args = new Object[] {
						membershipPackageIndServicesModelImpl.getMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEINDSERVICESMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEINDSERVICESMPID,
					args);
			}

			if ((membershipPackageIndServicesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageIndServicesModelImpl.getOriginalMpId(),
						membershipPackageIndServicesModelImpl.getOriginalExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);

				args = new Object[] {
						membershipPackageIndServicesModelImpl.getMpId(),
						membershipPackageIndServicesModelImpl.getExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageIndServicesImpl.class,
			membershipPackageIndServices.getPrimaryKey(),
			membershipPackageIndServices);

		return membershipPackageIndServices;
	}

	protected MembershipPackageIndServices toUnwrappedModel(
		MembershipPackageIndServices membershipPackageIndServices) {
		if (membershipPackageIndServices instanceof MembershipPackageIndServicesImpl) {
			return membershipPackageIndServices;
		}

		MembershipPackageIndServicesImpl membershipPackageIndServicesImpl = new MembershipPackageIndServicesImpl();

		membershipPackageIndServicesImpl.setNew(membershipPackageIndServices.isNew());
		membershipPackageIndServicesImpl.setPrimaryKey(membershipPackageIndServices.getPrimaryKey());

		membershipPackageIndServicesImpl.setMpgsscId(membershipPackageIndServices.getMpgsscId());
		membershipPackageIndServicesImpl.setMpId(membershipPackageIndServices.getMpId());
		membershipPackageIndServicesImpl.setScorder(membershipPackageIndServices.getScorder());
		membershipPackageIndServicesImpl.setScgId(membershipPackageIndServices.getScgId());
		membershipPackageIndServicesImpl.setScId(membershipPackageIndServices.getScId());
		membershipPackageIndServicesImpl.setParamType(membershipPackageIndServices.getParamType());
		membershipPackageIndServicesImpl.setParamFrom(membershipPackageIndServices.getParamFrom());
		membershipPackageIndServicesImpl.setParamUpto(membershipPackageIndServices.getParamUpto());
		membershipPackageIndServicesImpl.setDuration(membershipPackageIndServices.getDuration());
		membershipPackageIndServicesImpl.setDurationType(membershipPackageIndServices.getDurationType());
		membershipPackageIndServicesImpl.setStatus(membershipPackageIndServices.getStatus());
		membershipPackageIndServicesImpl.setDescription(membershipPackageIndServices.getDescription());
		membershipPackageIndServicesImpl.setDateAdded(membershipPackageIndServices.getDateAdded());
		membershipPackageIndServicesImpl.setDateModified(membershipPackageIndServices.getDateModified());
		membershipPackageIndServicesImpl.setCreatedBy(membershipPackageIndServices.getCreatedBy());
		membershipPackageIndServicesImpl.setModifiedBy(membershipPackageIndServices.getModifiedBy());
		membershipPackageIndServicesImpl.setExtra1(membershipPackageIndServices.getExtra1());
		membershipPackageIndServicesImpl.setExtra2(membershipPackageIndServices.getExtra2());
		membershipPackageIndServicesImpl.setExtra3(membershipPackageIndServices.getExtra3());
		membershipPackageIndServicesImpl.setExtra4(membershipPackageIndServices.getExtra4());
		membershipPackageIndServicesImpl.setExtra5(membershipPackageIndServices.getExtra5());
		membershipPackageIndServicesImpl.setExtra6(membershipPackageIndServices.getExtra6());
		membershipPackageIndServicesImpl.setServiceCharges(membershipPackageIndServices.getServiceCharges());
		membershipPackageIndServicesImpl.setCostCurrency(membershipPackageIndServices.getCostCurrency());
		membershipPackageIndServicesImpl.setCostPeriod(membershipPackageIndServices.getCostPeriod());
		membershipPackageIndServicesImpl.setCostPeriodType(membershipPackageIndServices.getCostPeriodType());

		return membershipPackageIndServicesImpl;
	}

	/**
	 * Returns the membership package ind services with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package ind services
	 * @return the membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		MembershipPackageIndServices membershipPackageIndServices = fetchByPrimaryKey(primaryKey);

		if (membershipPackageIndServices == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackageIndServicesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackageIndServices;
	}

	/**
	 * Returns the membership package ind services with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException} if it could not be found.
	 *
	 * @param mpgsscId the primary key of the membership package ind services
	 * @return the membership package ind services
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageIndServicesException if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices findByPrimaryKey(long mpgsscId)
		throws NoSuchMembershipPackageIndServicesException, SystemException {
		return findByPrimaryKey((Serializable)mpgsscId);
	}

	/**
	 * Returns the membership package ind services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package ind services
	 * @return the membership package ind services, or <code>null</code> if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipPackageIndServices membershipPackageIndServices = (MembershipPackageIndServices)EntityCacheUtil.getResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageIndServicesImpl.class, primaryKey);

		if (membershipPackageIndServices == _nullMembershipPackageIndServices) {
			return null;
		}

		if (membershipPackageIndServices == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackageIndServices = (MembershipPackageIndServices)session.get(MembershipPackageIndServicesImpl.class,
						primaryKey);

				if (membershipPackageIndServices != null) {
					cacheResult(membershipPackageIndServices);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageIndServicesImpl.class, primaryKey,
						_nullMembershipPackageIndServices);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackageIndServicesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackageIndServicesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackageIndServices;
	}

	/**
	 * Returns the membership package ind services with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mpgsscId the primary key of the membership package ind services
	 * @return the membership package ind services, or <code>null</code> if a membership package ind services with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageIndServices fetchByPrimaryKey(long mpgsscId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mpgsscId);
	}

	/**
	 * Returns all the membership package ind serviceses.
	 *
	 * @return the membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package ind serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @return the range of membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package ind serviceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageIndServicesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package ind serviceses
	 * @param end the upper bound of the range of membership package ind serviceses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership package ind serviceses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageIndServices> findAll(int start, int end,
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

		List<MembershipPackageIndServices> list = (List<MembershipPackageIndServices>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES;

				if (pagination) {
					sql = sql.concat(MembershipPackageIndServicesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageIndServices>(list);
				}
				else {
					list = (List<MembershipPackageIndServices>)QueryUtil.list(q,
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
	 * Removes all the membership package ind serviceses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackageIndServices membershipPackageIndServices : findAll()) {
			remove(membershipPackageIndServices);
		}
	}

	/**
	 * Returns the number of membership package ind serviceses.
	 *
	 * @return the number of membership package ind serviceses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES);

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
	 * Initializes the membership package ind services persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackageIndServices>> listenersList = new ArrayList<ModelListener<MembershipPackageIndServices>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackageIndServices>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipPackageIndServicesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES = "SELECT membershipPackageIndServices FROM MembershipPackageIndServices membershipPackageIndServices";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGEINDSERVICES_WHERE = "SELECT membershipPackageIndServices FROM MembershipPackageIndServices membershipPackageIndServices WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES = "SELECT COUNT(membershipPackageIndServices) FROM MembershipPackageIndServices membershipPackageIndServices";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGEINDSERVICES_WHERE = "SELECT COUNT(membershipPackageIndServices) FROM MembershipPackageIndServices membershipPackageIndServices WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackageIndServices.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackageIndServices exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackageIndServices exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackageIndServicesPersistenceImpl.class);
	private static MembershipPackageIndServices _nullMembershipPackageIndServices =
		new MembershipPackageIndServicesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackageIndServices> toCacheModel() {
				return _nullMembershipPackageIndServicesCacheModel;
			}
		};

	private static CacheModel<MembershipPackageIndServices> _nullMembershipPackageIndServicesCacheModel =
		new CacheModel<MembershipPackageIndServices>() {
			@Override
			public MembershipPackageIndServices toEntityModel() {
				return _nullMembershipPackageIndServices;
			}
		};
}