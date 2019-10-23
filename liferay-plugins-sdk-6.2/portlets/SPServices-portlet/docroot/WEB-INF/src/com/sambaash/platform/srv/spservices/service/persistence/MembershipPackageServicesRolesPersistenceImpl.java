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

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException;
import com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership package services roles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackageServicesRolesPersistence
 * @see MembershipPackageServicesRolesUtil
 * @generated
 */
public class MembershipPackageServicesRolesPersistenceImpl
	extends BasePersistenceImpl<MembershipPackageServicesRoles>
	implements MembershipPackageServicesRolesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackageServicesRolesUtil} to access the membership package services roles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackageServicesRolesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
			new String[] { Long.class.getName(), Long.class.getName() },
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.CLASSNAMEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassName",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByClassName(long mpId,
		long classNameId) throws SystemException {
		return findByClassName(mpId, classNameId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByClassName(long mpId,
		long classNameId, int start, int end) throws SystemException {
		return findByClassName(mpId, classNameId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where mpId = &#63; and classNameId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByClassName(long mpId,
		long classNameId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { mpId, classNameId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] {
					mpId, classNameId,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((mpId != membershipPackageServicesRoles.getMpId()) ||
						(classNameId != membershipPackageServicesRoles.getClassNameId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAME_MPID_2);

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAMEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(classNameId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByClassName_First(long mpId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByClassName_First(mpId,
				classNameId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByClassName_First(long mpId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageServicesRoles> list = findByClassName(mpId,
				classNameId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByClassName_Last(long mpId,
		long classNameId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByClassName_Last(mpId,
				classNameId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByClassName_Last(long mpId,
		long classNameId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByClassName(mpId, classNameId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findByClassName(mpId,
				classNameId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findByClassName_PrevAndNext(
		long mpgsrlId, long mpId, long classNameId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getByClassName_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, classNameId,
					orderByComparator, true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getByClassName_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, classNameId,
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

	protected MembershipPackageServicesRoles getByClassName_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long mpId, long classNameId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_CLASSNAME_MPID_2);

		query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAMEID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		qPos.add(classNameId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where mpId = &#63; and classNameId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassName(long mpId, long classNameId)
		throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findByClassName(
				mpId, classNameId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where mpId = &#63; and classNameId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassName(long mpId, long classNameId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

		Object[] finderArgs = new Object[] { mpId, classNameId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAME_MPID_2);

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAMEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(classNameId);

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

	private static final String _FINDER_COLUMN_CLASSNAME_MPID_2 = "membershipPackageServicesRoles.mpId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAMEID_2 = "membershipPackageServicesRoles.classNameId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBympIdClassNameIdSvcId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBympIdClassNameIdSvcId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.SERVICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MPIDCLASSNAMEIDSVCID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBympIdClassNameIdSvcId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId) throws SystemException {
		return findBympIdClassNameIdSvcId(mpId, classNameId, serviceId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId, int start, int end)
		throws SystemException {
		return findBympIdClassNameIdSvcId(mpId, classNameId, serviceId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympIdClassNameIdSvcId(
		long mpId, long classNameId, long serviceId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID;
			finderArgs = new Object[] { mpId, classNameId, serviceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID;
			finderArgs = new Object[] {
					mpId, classNameId, serviceId,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((mpId != membershipPackageServicesRoles.getMpId()) ||
						(classNameId != membershipPackageServicesRoles.getClassNameId()) ||
						(serviceId != membershipPackageServicesRoles.getServiceId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_MPID_2);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_SERVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(classNameId);

				qPos.add(serviceId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findBympIdClassNameIdSvcId_First(
		long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchBympIdClassNameIdSvcId_First(mpId,
				classNameId, serviceId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", serviceId=");
		msg.append(serviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchBympIdClassNameIdSvcId_First(
		long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackageServicesRoles> list = findBympIdClassNameIdSvcId(mpId,
				classNameId, serviceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findBympIdClassNameIdSvcId_Last(
		long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchBympIdClassNameIdSvcId_Last(mpId,
				classNameId, serviceId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", classNameId=");
		msg.append(classNameId);

		msg.append(", serviceId=");
		msg.append(serviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchBympIdClassNameIdSvcId_Last(
		long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBympIdClassNameIdSvcId(mpId, classNameId, serviceId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findBympIdClassNameIdSvcId(mpId,
				classNameId, serviceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findBympIdClassNameIdSvcId_PrevAndNext(
		long mpgsrlId, long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getBympIdClassNameIdSvcId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, classNameId,
					serviceId, orderByComparator, true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getBympIdClassNameIdSvcId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, classNameId,
					serviceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackageServicesRoles getBympIdClassNameIdSvcId_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long mpId, long classNameId, long serviceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_MPID_2);

		query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_SERVICEID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		qPos.add(classNameId);

		qPos.add(serviceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBympIdClassNameIdSvcId(long mpId, long classNameId,
		long serviceId) throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findBympIdClassNameIdSvcId(
				mpId, classNameId, serviceId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where mpId = &#63; and classNameId = &#63; and serviceId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param classNameId the class name ID
	 * @param serviceId the service ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBympIdClassNameIdSvcId(long mpId, long classNameId,
		long serviceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MPIDCLASSNAMEIDSVCID;

		Object[] finderArgs = new Object[] { mpId, classNameId, serviceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_MPID_2);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_SERVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(classNameId);

				qPos.add(serviceId);

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

	private static final String _FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_MPID_2 = "membershipPackageServicesRoles.mpId = ? AND ";
	private static final String _FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_CLASSNAMEID_2 =
		"membershipPackageServicesRoles.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_MPIDCLASSNAMEIDSVCID_SERVICEID_2 = "membershipPackageServicesRoles.serviceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MPID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBympId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBympId",
			new String[] { Long.class.getName() },
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MPID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBympId", new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package services roleses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympId(long mpId)
		throws SystemException {
		return findBympId(mpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympId(long mpId,
		int start, int end) throws SystemException {
		return findBympId(mpId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where mpId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findBympId(long mpId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPID;
			finderArgs = new Object[] { mpId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MPID;
			finderArgs = new Object[] { mpId, start, end, orderByComparator };
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((mpId != membershipPackageServicesRoles.getMpId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MPID_MPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findBympId_First(long mpId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchBympId_First(mpId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchBympId_First(long mpId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackageServicesRoles> list = findBympId(mpId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findBympId_Last(long mpId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchBympId_Last(mpId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchBympId_Last(long mpId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBympId(mpId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findBympId(mpId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param mpId the mp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findBympId_PrevAndNext(
		long mpgsrlId, long mpId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getBympId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, orderByComparator,
					true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getBympId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, orderByComparator,
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

	protected MembershipPackageServicesRoles getBympId_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long mpId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_MPID_MPID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where mpId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBympId(long mpId) throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findBympId(
				mpId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where mpId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBympId(long mpId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MPID;

		Object[] finderArgs = new Object[] { mpId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MPID_MPID_2);

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

	private static final String _FINDER_COLUMN_MPID_MPID_2 = "membershipPackageServicesRoles.mpId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageAndRole",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageAndRole",
			new String[] { Long.class.getName(), Long.class.getName() },
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.ROLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEANDROLE =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageAndRole",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId) throws SystemException {
		return findByMembershipPackageAndRole(mpId, roleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId, int start, int end) throws SystemException {
		return findByMembershipPackageAndRole(mpId, roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where mpId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByMembershipPackageAndRole(
		long mpId, long roleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE;
			finderArgs = new Object[] { mpId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE;
			finderArgs = new Object[] {
					mpId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((mpId != membershipPackageServicesRoles.getMpId()) ||
						(roleId != membershipPackageServicesRoles.getRoleId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_MPID_2);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByMembershipPackageAndRole_First(
		long mpId, long roleId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByMembershipPackageAndRole_First(mpId,
				roleId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByMembershipPackageAndRole_First(
		long mpId, long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageServicesRoles> list = findByMembershipPackageAndRole(mpId,
				roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByMembershipPackageAndRole_Last(
		long mpId, long roleId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByMembershipPackageAndRole_Last(mpId,
				roleId, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByMembershipPackageAndRole_Last(
		long mpId, long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipPackageAndRole(mpId, roleId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findByMembershipPackageAndRole(mpId,
				roleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findByMembershipPackageAndRole_PrevAndNext(
		long mpgsrlId, long mpId, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getByMembershipPackageAndRole_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, roleId,
					orderByComparator, true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getByMembershipPackageAndRole_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, roleId,
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

	protected MembershipPackageServicesRoles getByMembershipPackageAndRole_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long mpId, long roleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_MPID_2);

		query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_ROLEID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(mpId);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where mpId = &#63; and roleId = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageAndRole(long mpId, long roleId)
		throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findByMembershipPackageAndRole(
				mpId, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where mpId = &#63; and roleId = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param roleId the role ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageAndRole(long mpId, long roleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEANDROLE;

		Object[] finderArgs = new Object[] { mpId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_MPID_2);

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(mpId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_MPID_2 = "membershipPackageServicesRoles.mpId = ? AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGEANDROLE_ROLEID_2 =
		"membershipPackageServicesRoles.roleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleId",
			new String[] { Long.class.getName() },
			MembershipPackageServicesRolesModelImpl.ROLEID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRoleId", new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package services roleses where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByRoleId(long roleId)
		throws SystemException {
		return findByRoleId(roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByRoleId(long roleId,
		int start, int end) throws SystemException {
		return findByRoleId(roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByRoleId(long roleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { roleId, start, end, orderByComparator };
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((roleId != membershipPackageServicesRoles.getRoleId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByRoleId_First(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByRoleId_First(roleId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByRoleId_First(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackageServicesRoles> list = findByRoleId(roleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByRoleId_Last(long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByRoleId_Last(roleId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByRoleId_Last(long roleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoleId(roleId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findByRoleId(roleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where roleId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findByRoleId_PrevAndNext(
		long mpgsrlId, long roleId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getByRoleId_PrevAndNext(session,
					membershipPackageServicesRoles, roleId, orderByComparator,
					true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getByRoleId_PrevAndNext(session,
					membershipPackageServicesRoles, roleId, orderByComparator,
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

	protected MembershipPackageServicesRoles getByRoleId_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long roleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleId(long roleId) throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findByRoleId(
				roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleId(long roleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEID;

		Object[] finderArgs = new Object[] { roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 = "membershipPackageServicesRoles.roleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceId",
			new String[] { Long.class.getName() },
			MembershipPackageServicesRolesModelImpl.SERVICEID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceId", new String[] { Long.class.getName() });

	/**
	 * Returns all the membership package services roleses where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceId(long serviceId)
		throws SystemException {
		return findByServiceId(serviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the membership package services roleses where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceId(
		long serviceId, int start, int end) throws SystemException {
		return findByServiceId(serviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceId(
		long serviceId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID;
			finderArgs = new Object[] { serviceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID;
			finderArgs = new Object[] { serviceId, start, end, orderByComparator };
		}

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((serviceId != membershipPackageServicesRoles.getServiceId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByServiceId_First(
		long serviceId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByServiceId_First(serviceId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceId=");
		msg.append(serviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByServiceId_First(
		long serviceId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageServicesRoles> list = findByServiceId(serviceId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByServiceId_Last(long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByServiceId_Last(serviceId,
				orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("serviceId=");
		msg.append(serviceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByServiceId_Last(
		long serviceId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceId(serviceId);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findByServiceId(serviceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where serviceId = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findByServiceId_PrevAndNext(
		long mpgsrlId, long serviceId, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getByServiceId_PrevAndNext(session,
					membershipPackageServicesRoles, serviceId,
					orderByComparator, true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getByServiceId_PrevAndNext(session,
					membershipPackageServicesRoles, serviceId,
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

	protected MembershipPackageServicesRoles getByServiceId_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long serviceId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

		query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where serviceId = &#63; from the database.
	 *
	 * @param serviceId the service ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceId(long serviceId) throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findByServiceId(
				serviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the number of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceId(long serviceId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICEID;

		Object[] finderArgs = new Object[] { serviceId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

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

	private static final String _FINDER_COLUMN_SERVICEID_SERVICEID_2 = "membershipPackageServicesRoles.serviceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceNameMpId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID =
		new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() },
			MembershipPackageServicesRolesModelImpl.MPID_COLUMN_BITMASK |
			MembershipPackageServicesRolesModelImpl.EXTRA1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICENAMEMPID = new FinderPath(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByServiceNameMpId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @return the matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, String extra1) throws SystemException {
		return findByServiceNameMpId(mpId, extra1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, String extra1, int start, int end) throws SystemException {
		return findByServiceNameMpId(mpId, extra1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses where mpId = &#63; and extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findByServiceNameMpId(
		long mpId, String extra1, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackageServicesRoles membershipPackageServicesRoles : list) {
				if ((mpId != membershipPackageServicesRoles.getMpId()) ||
						!Validator.equals(extra1,
							membershipPackageServicesRoles.getExtra1())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

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
				query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByServiceNameMpId_First(
		long mpId, String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByServiceNameMpId_First(mpId,
				extra1, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the first membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByServiceNameMpId_First(
		long mpId, String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipPackageServicesRoles> list = findByServiceNameMpId(mpId,
				extra1, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByServiceNameMpId_Last(
		long mpId, String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByServiceNameMpId_Last(mpId,
				extra1, orderByComparator);

		if (membershipPackageServicesRoles != null) {
			return membershipPackageServicesRoles;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId=");
		msg.append(mpId);

		msg.append(", extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageServicesRolesException(msg.toString());
	}

	/**
	 * Returns the last membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package services roles, or <code>null</code> if a matching membership package services roles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByServiceNameMpId_Last(
		long mpId, String extra1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByServiceNameMpId(mpId, extra1);

		if (count == 0) {
			return null;
		}

		List<MembershipPackageServicesRoles> list = findByServiceNameMpId(mpId,
				extra1, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership package services roleses before and after the current membership package services roles in the ordered set where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpgsrlId the primary key of the current membership package services roles
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles[] findByServiceNameMpId_PrevAndNext(
		long mpgsrlId, long mpId, String extra1,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = findByPrimaryKey(mpgsrlId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles[] array = new MembershipPackageServicesRolesImpl[3];

			array[0] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, extra1,
					orderByComparator, true);

			array[1] = membershipPackageServicesRoles;

			array[2] = getByServiceNameMpId_PrevAndNext(session,
					membershipPackageServicesRoles, mpId, extra1,
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

	protected MembershipPackageServicesRoles getByServiceNameMpId_PrevAndNext(
		Session session,
		MembershipPackageServicesRoles membershipPackageServicesRoles,
		long mpId, String extra1, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

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
			query.append(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackageServicesRoles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackageServicesRoles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership package services roleses where mpId = &#63; and extra1 = &#63; from the database.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceNameMpId(long mpId, String extra1)
		throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findByServiceNameMpId(
				mpId, extra1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses where mpId = &#63; and extra1 = &#63;.
	 *
	 * @param mpId the mp ID
	 * @param extra1 the extra1
	 * @return the number of matching membership package services roleses
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

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE);

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

	private static final String _FINDER_COLUMN_SERVICENAMEMPID_MPID_2 = "membershipPackageServicesRoles.mpId = ? AND ";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_1 = "membershipPackageServicesRoles.extra1 IS NULL";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_2 = "membershipPackageServicesRoles.extra1 = ?";
	private static final String _FINDER_COLUMN_SERVICENAMEMPID_EXTRA1_3 = "(membershipPackageServicesRoles.extra1 IS NULL OR membershipPackageServicesRoles.extra1 = '')";

	public MembershipPackageServicesRolesPersistenceImpl() {
		setModelClass(MembershipPackageServicesRoles.class);
	}

	/**
	 * Caches the membership package services roles in the entity cache if it is enabled.
	 *
	 * @param membershipPackageServicesRoles the membership package services roles
	 */
	@Override
	public void cacheResult(
		MembershipPackageServicesRoles membershipPackageServicesRoles) {
		EntityCacheUtil.putResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			membershipPackageServicesRoles.getPrimaryKey(),
			membershipPackageServicesRoles);

		membershipPackageServicesRoles.resetOriginalValues();
	}

	/**
	 * Caches the membership package services roleses in the entity cache if it is enabled.
	 *
	 * @param membershipPackageServicesRoleses the membership package services roleses
	 */
	@Override
	public void cacheResult(
		List<MembershipPackageServicesRoles> membershipPackageServicesRoleses) {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : membershipPackageServicesRoleses) {
			if (EntityCacheUtil.getResult(
						MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageServicesRolesImpl.class,
						membershipPackageServicesRoles.getPrimaryKey()) == null) {
				cacheResult(membershipPackageServicesRoles);
			}
			else {
				membershipPackageServicesRoles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership package services roleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackageServicesRolesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackageServicesRolesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package services roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		MembershipPackageServicesRoles membershipPackageServicesRoles) {
		EntityCacheUtil.removeResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			membershipPackageServicesRoles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<MembershipPackageServicesRoles> membershipPackageServicesRoleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackageServicesRoles membershipPackageServicesRoles : membershipPackageServicesRoleses) {
			EntityCacheUtil.removeResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageServicesRolesImpl.class,
				membershipPackageServicesRoles.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package services roles with the primary key. Does not add the membership package services roles to the database.
	 *
	 * @param mpgsrlId the primary key for the new membership package services roles
	 * @return the new membership package services roles
	 */
	@Override
	public MembershipPackageServicesRoles create(long mpgsrlId) {
		MembershipPackageServicesRoles membershipPackageServicesRoles = new MembershipPackageServicesRolesImpl();

		membershipPackageServicesRoles.setNew(true);
		membershipPackageServicesRoles.setPrimaryKey(mpgsrlId);

		return membershipPackageServicesRoles;
	}

	/**
	 * Removes the membership package services roles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mpgsrlId the primary key of the membership package services roles
	 * @return the membership package services roles that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles remove(long mpgsrlId)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		return remove((Serializable)mpgsrlId);
	}

	/**
	 * Removes the membership package services roles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package services roles
	 * @return the membership package services roles that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles remove(Serializable primaryKey)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackageServicesRoles membershipPackageServicesRoles = (MembershipPackageServicesRoles)session.get(MembershipPackageServicesRolesImpl.class,
					primaryKey);

			if (membershipPackageServicesRoles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackageServicesRolesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackageServicesRoles);
		}
		catch (NoSuchMembershipPackageServicesRolesException nsee) {
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
	protected MembershipPackageServicesRoles removeImpl(
		MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws SystemException {
		membershipPackageServicesRoles = toUnwrappedModel(membershipPackageServicesRoles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackageServicesRoles)) {
				membershipPackageServicesRoles = (MembershipPackageServicesRoles)session.get(MembershipPackageServicesRolesImpl.class,
						membershipPackageServicesRoles.getPrimaryKeyObj());
			}

			if (membershipPackageServicesRoles != null) {
				session.delete(membershipPackageServicesRoles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackageServicesRoles != null) {
			clearCache(membershipPackageServicesRoles);
		}

		return membershipPackageServicesRoles;
	}

	@Override
	public MembershipPackageServicesRoles updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles membershipPackageServicesRoles)
		throws SystemException {
		membershipPackageServicesRoles = toUnwrappedModel(membershipPackageServicesRoles);

		boolean isNew = membershipPackageServicesRoles.isNew();

		MembershipPackageServicesRolesModelImpl membershipPackageServicesRolesModelImpl =
			(MembershipPackageServicesRolesModelImpl)membershipPackageServicesRoles;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackageServicesRoles.isNew()) {
				session.save(membershipPackageServicesRoles);

				membershipPackageServicesRoles.setNew(false);
			}
			else {
				session.merge(membershipPackageServicesRoles);
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
				!MembershipPackageServicesRolesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalMpId(),
						membershipPackageServicesRolesModelImpl.getOriginalClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getMpId(),
						membershipPackageServicesRolesModelImpl.getClassNameId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalMpId(),
						membershipPackageServicesRolesModelImpl.getOriginalClassNameId(),
						membershipPackageServicesRolesModelImpl.getOriginalServiceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MPIDCLASSNAMEIDSVCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getMpId(),
						membershipPackageServicesRolesModelImpl.getClassNameId(),
						membershipPackageServicesRolesModelImpl.getServiceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MPIDCLASSNAMEIDSVCID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPIDCLASSNAMEIDSVCID,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPID,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getMpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MPID,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalMpId(),
						membershipPackageServicesRolesModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEANDROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getMpId(),
						membershipPackageServicesRolesModelImpl.getRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGEANDROLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGEANDROLE,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalServiceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getServiceId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID,
					args);
			}

			if ((membershipPackageServicesRolesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageServicesRolesModelImpl.getOriginalMpId(),
						membershipPackageServicesRolesModelImpl.getOriginalExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);

				args = new Object[] {
						membershipPackageServicesRolesModelImpl.getMpId(),
						membershipPackageServicesRolesModelImpl.getExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAMEMPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICENAMEMPID,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageServicesRolesImpl.class,
			membershipPackageServicesRoles.getPrimaryKey(),
			membershipPackageServicesRoles);

		return membershipPackageServicesRoles;
	}

	protected MembershipPackageServicesRoles toUnwrappedModel(
		MembershipPackageServicesRoles membershipPackageServicesRoles) {
		if (membershipPackageServicesRoles instanceof MembershipPackageServicesRolesImpl) {
			return membershipPackageServicesRoles;
		}

		MembershipPackageServicesRolesImpl membershipPackageServicesRolesImpl = new MembershipPackageServicesRolesImpl();

		membershipPackageServicesRolesImpl.setNew(membershipPackageServicesRoles.isNew());
		membershipPackageServicesRolesImpl.setPrimaryKey(membershipPackageServicesRoles.getPrimaryKey());

		membershipPackageServicesRolesImpl.setMpgsrlId(membershipPackageServicesRoles.getMpgsrlId());
		membershipPackageServicesRolesImpl.setMpId(membershipPackageServicesRoles.getMpId());
		membershipPackageServicesRolesImpl.setServiceId(membershipPackageServicesRoles.getServiceId());
		membershipPackageServicesRolesImpl.setClassNameId(membershipPackageServicesRoles.getClassNameId());
		membershipPackageServicesRolesImpl.setRoleId(membershipPackageServicesRoles.getRoleId());
		membershipPackageServicesRolesImpl.setExtra1(membershipPackageServicesRoles.getExtra1());
		membershipPackageServicesRolesImpl.setExtra2(membershipPackageServicesRoles.getExtra2());
		membershipPackageServicesRolesImpl.setExtra3(membershipPackageServicesRoles.getExtra3());
		membershipPackageServicesRolesImpl.setExtra4(membershipPackageServicesRoles.getExtra4());
		membershipPackageServicesRolesImpl.setExtra5(membershipPackageServicesRoles.getExtra5());
		membershipPackageServicesRolesImpl.setExtra6(membershipPackageServicesRoles.getExtra6());

		return membershipPackageServicesRolesImpl;
	}

	/**
	 * Returns the membership package services roles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package services roles
	 * @return the membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = fetchByPrimaryKey(primaryKey);

		if (membershipPackageServicesRoles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackageServicesRolesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackageServicesRoles;
	}

	/**
	 * Returns the membership package services roles with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException} if it could not be found.
	 *
	 * @param mpgsrlId the primary key of the membership package services roles
	 * @return the membership package services roles
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageServicesRolesException if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles findByPrimaryKey(long mpgsrlId)
		throws NoSuchMembershipPackageServicesRolesException, SystemException {
		return findByPrimaryKey((Serializable)mpgsrlId);
	}

	/**
	 * Returns the membership package services roles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package services roles
	 * @return the membership package services roles, or <code>null</code> if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		MembershipPackageServicesRoles membershipPackageServicesRoles = (MembershipPackageServicesRoles)EntityCacheUtil.getResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageServicesRolesImpl.class, primaryKey);

		if (membershipPackageServicesRoles == _nullMembershipPackageServicesRoles) {
			return null;
		}

		if (membershipPackageServicesRoles == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackageServicesRoles = (MembershipPackageServicesRoles)session.get(MembershipPackageServicesRolesImpl.class,
						primaryKey);

				if (membershipPackageServicesRoles != null) {
					cacheResult(membershipPackageServicesRoles);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageServicesRolesImpl.class, primaryKey,
						_nullMembershipPackageServicesRoles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackageServicesRolesModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackageServicesRolesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackageServicesRoles;
	}

	/**
	 * Returns the membership package services roles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mpgsrlId the primary key of the membership package services roles
	 * @return the membership package services roles, or <code>null</code> if a membership package services roles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackageServicesRoles fetchByPrimaryKey(long mpgsrlId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mpgsrlId);
	}

	/**
	 * Returns all the membership package services roleses.
	 *
	 * @return the membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership package services roleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @return the range of membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership package services roleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageServicesRolesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership package services roleses
	 * @param end the upper bound of the range of membership package services roleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership package services roleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackageServicesRoles> findAll(int start, int end,
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

		List<MembershipPackageServicesRoles> list = (List<MembershipPackageServicesRoles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES;

				if (pagination) {
					sql = sql.concat(MembershipPackageServicesRolesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackageServicesRoles>(list);
				}
				else {
					list = (List<MembershipPackageServicesRoles>)QueryUtil.list(q,
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
	 * Removes all the membership package services roleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackageServicesRoles membershipPackageServicesRoles : findAll()) {
			remove(membershipPackageServicesRoles);
		}
	}

	/**
	 * Returns the number of membership package services roleses.
	 *
	 * @return the number of membership package services roleses
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES);

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
	 * Initializes the membership package services roles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackageServicesRoles>> listenersList =
					new ArrayList<ModelListener<MembershipPackageServicesRoles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackageServicesRoles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipPackageServicesRolesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES = "SELECT membershipPackageServicesRoles FROM MembershipPackageServicesRoles membershipPackageServicesRoles";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGESERVICESROLES_WHERE =
		"SELECT membershipPackageServicesRoles FROM MembershipPackageServicesRoles membershipPackageServicesRoles WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES = "SELECT COUNT(membershipPackageServicesRoles) FROM MembershipPackageServicesRoles membershipPackageServicesRoles";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGESERVICESROLES_WHERE = "SELECT COUNT(membershipPackageServicesRoles) FROM MembershipPackageServicesRoles membershipPackageServicesRoles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackageServicesRoles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackageServicesRoles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackageServicesRoles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackageServicesRolesPersistenceImpl.class);
	private static MembershipPackageServicesRoles _nullMembershipPackageServicesRoles =
		new MembershipPackageServicesRolesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackageServicesRoles> toCacheModel() {
				return _nullMembershipPackageServicesRolesCacheModel;
			}
		};

	private static CacheModel<MembershipPackageServicesRoles> _nullMembershipPackageServicesRolesCacheModel =
		new CacheModel<MembershipPackageServicesRoles>() {
			@Override
			public MembershipPackageServicesRoles toEntityModel() {
				return _nullMembershipPackageServicesRoles;
			}
		};
}