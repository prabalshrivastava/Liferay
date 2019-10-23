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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException;
import com.sambaash.platform.srv.spservices.model.MembershipPackage;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the membership package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePersistence
 * @see MembershipPackageUtil
 * @generated
 */
public class MembershipPackagePersistenceImpl extends BasePersistenceImpl<MembershipPackage>
	implements MembershipPackagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipPackageUtil} to access the membership package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipPackageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME =
		new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME =
		new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageName",
			new String[] { String.class.getName() },
			MembershipPackageModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGENAME = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership packages where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageName(String name)
		throws SystemException {
		return findByMembershipPackageName(name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership packages where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @return the range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageName(String name,
		int start, int end) throws SystemException {
		return findByMembershipPackageName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership packages where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageName(String name,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<MembershipPackage> list = (List<MembershipPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackage membershipPackage : list) {
				if (!Validator.equals(name, membershipPackage.getName())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<MembershipPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackage>(list);
				}
				else {
					list = (List<MembershipPackage>)QueryUtil.list(q,
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
	 * Returns the first membership package in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByMembershipPackageName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByMembershipPackageName_First(name,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the first membership package in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByMembershipPackageName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackage> list = findByMembershipPackageName(name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByMembershipPackageName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByMembershipPackageName_Last(name,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the last membership package in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByMembershipPackageName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMembershipPackageName(name);

		if (count == 0) {
			return null;
		}

		List<MembershipPackage> list = findByMembershipPackageName(name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership packages before and after the current membership package in the ordered set where name = &#63;.
	 *
	 * @param mpId the primary key of the current membership package
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage[] findByMembershipPackageName_PrevAndNext(
		long mpId, String name, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = findByPrimaryKey(mpId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackage[] array = new MembershipPackageImpl[3];

			array[0] = getByMembershipPackageName_PrevAndNext(session,
					membershipPackage, name, orderByComparator, true);

			array[1] = membershipPackage;

			array[2] = getByMembershipPackageName_PrevAndNext(session,
					membershipPackage, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackage getByMembershipPackageName_PrevAndNext(
		Session session, MembershipPackage membershipPackage, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_2);
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
			query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership packages where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageName(String name)
		throws SystemException {
		for (MembershipPackage membershipPackage : findByMembershipPackageName(
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackage);
		}
	}

	/**
	 * Returns the number of membership packages where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageName(String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGENAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_1 = "membershipPackage.name IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_2 = "membershipPackage.name = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGENAME_NAME_3 = "(membershipPackage.name IS NULL OR membershipPackage.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID =
		new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleId",
			new String[] { String.class.getName() },
			MembershipPackageModelImpl.EXTRA1_COLUMN_BITMASK |
			MembershipPackageModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership packages where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByRoleId(String extra1)
		throws SystemException {
		return findByRoleId(extra1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership packages where extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @return the range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByRoleId(String extra1, int start,
		int end) throws SystemException {
		return findByRoleId(extra1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership packages where extra1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extra1 the extra1
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByRoleId(String extra1, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { extra1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEID;
			finderArgs = new Object[] { extra1, start, end, orderByComparator };
		}

		List<MembershipPackage> list = (List<MembershipPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackage membershipPackage : list) {
				if (!Validator.equals(extra1, membershipPackage.getExtra1())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackage>(list);
				}
				else {
					list = (List<MembershipPackage>)QueryUtil.list(q,
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
	 * Returns the first membership package in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByRoleId_First(String extra1,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByRoleId_First(extra1,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the first membership package in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByRoleId_First(String extra1,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackage> list = findByRoleId(extra1, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByRoleId_Last(String extra1,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByRoleId_Last(extra1,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extra1=");
		msg.append(extra1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the last membership package in the ordered set where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByRoleId_Last(String extra1,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRoleId(extra1);

		if (count == 0) {
			return null;
		}

		List<MembershipPackage> list = findByRoleId(extra1, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership packages before and after the current membership package in the ordered set where extra1 = &#63;.
	 *
	 * @param mpId the primary key of the current membership package
	 * @param extra1 the extra1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage[] findByRoleId_PrevAndNext(long mpId,
		String extra1, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = findByPrimaryKey(mpId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackage[] array = new MembershipPackageImpl[3];

			array[0] = getByRoleId_PrevAndNext(session, membershipPackage,
					extra1, orderByComparator, true);

			array[1] = membershipPackage;

			array[2] = getByRoleId_PrevAndNext(session, membershipPackage,
					extra1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackage getByRoleId_PrevAndNext(Session session,
		MembershipPackage membershipPackage, String extra1,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

		boolean bindExtra1 = false;

		if (extra1 == null) {
			query.append(_FINDER_COLUMN_ROLEID_EXTRA1_1);
		}
		else if (extra1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ROLEID_EXTRA1_3);
		}
		else {
			bindExtra1 = true;

			query.append(_FINDER_COLUMN_ROLEID_EXTRA1_2);
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
			query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership packages where extra1 = &#63; from the database.
	 *
	 * @param extra1 the extra1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRoleId(String extra1) throws SystemException {
		for (MembershipPackage membershipPackage : findByRoleId(extra1,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackage);
		}
	}

	/**
	 * Returns the number of membership packages where extra1 = &#63;.
	 *
	 * @param extra1 the extra1
	 * @return the number of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRoleId(String extra1) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLEID;

		Object[] finderArgs = new Object[] { extra1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindExtra1 = false;

			if (extra1 == null) {
				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_1);
			}
			else if (extra1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_3);
			}
			else {
				bindExtra1 = true;

				query.append(_FINDER_COLUMN_ROLEID_EXTRA1_2);
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

	private static final String _FINDER_COLUMN_ROLEID_EXTRA1_1 = "membershipPackage.extra1 IS NULL";
	private static final String _FINDER_COLUMN_ROLEID_EXTRA1_2 = "membershipPackage.extra1 = ?";
	private static final String _FINDER_COLUMN_ROLEID_EXTRA1_3 = "(membershipPackage.extra1 IS NULL OR membershipPackage.extra1 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE =
		new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipPackageType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE =
		new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED,
			MembershipPackageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipPackageType",
			new String[] { String.class.getName() },
			MembershipPackageModelImpl.TYPE_COLUMN_BITMASK |
			MembershipPackageModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGETYPE = new FinderPath(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipPackageType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership packages where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageType(String type)
		throws SystemException {
		return findByMembershipPackageType(type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership packages where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @return the range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageType(String type,
		int start, int end) throws SystemException {
		return findByMembershipPackageType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership packages where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findByMembershipPackageType(String type,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<MembershipPackage> list = (List<MembershipPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipPackage membershipPackage : list) {
				if (!Validator.equals(type, membershipPackage.getType())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<MembershipPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackage>(list);
				}
				else {
					list = (List<MembershipPackage>)QueryUtil.list(q,
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
	 * Returns the first membership package in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByMembershipPackageType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByMembershipPackageType_First(type,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the first membership package in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByMembershipPackageType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipPackage> list = findByMembershipPackageType(type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership package in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByMembershipPackageType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByMembershipPackageType_Last(type,
				orderByComparator);

		if (membershipPackage != null) {
			return membershipPackage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipPackageException(msg.toString());
	}

	/**
	 * Returns the last membership package in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership package, or <code>null</code> if a matching membership package could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByMembershipPackageType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMembershipPackageType(type);

		if (count == 0) {
			return null;
		}

		List<MembershipPackage> list = findByMembershipPackageType(type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership packages before and after the current membership package in the ordered set where type = &#63;.
	 *
	 * @param mpId the primary key of the current membership package
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage[] findByMembershipPackageType_PrevAndNext(
		long mpId, String type, OrderByComparator orderByComparator)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = findByPrimaryKey(mpId);

		Session session = null;

		try {
			session = openSession();

			MembershipPackage[] array = new MembershipPackageImpl[3];

			array[0] = getByMembershipPackageType_PrevAndNext(session,
					membershipPackage, type, orderByComparator, true);

			array[1] = membershipPackage;

			array[2] = getByMembershipPackageType_PrevAndNext(session,
					membershipPackage, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipPackage getByMembershipPackageType_PrevAndNext(
		Session session, MembershipPackage membershipPackage, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPPACKAGE_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_2);
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
			query.append(MembershipPackageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipPackage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipPackage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership packages where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipPackageType(String type)
		throws SystemException {
		for (MembershipPackage membershipPackage : findByMembershipPackageType(
				type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipPackage);
		}
	}

	/**
	 * Returns the number of membership packages where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipPackageType(String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGETYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPPACKAGE_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_1 = "membershipPackage.type IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_2 = "membershipPackage.type = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPPACKAGETYPE_TYPE_3 = "(membershipPackage.type IS NULL OR membershipPackage.type = '')";

	public MembershipPackagePersistenceImpl() {
		setModelClass(MembershipPackage.class);
	}

	/**
	 * Caches the membership package in the entity cache if it is enabled.
	 *
	 * @param membershipPackage the membership package
	 */
	@Override
	public void cacheResult(MembershipPackage membershipPackage) {
		EntityCacheUtil.putResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageImpl.class, membershipPackage.getPrimaryKey(),
			membershipPackage);

		membershipPackage.resetOriginalValues();
	}

	/**
	 * Caches the membership packages in the entity cache if it is enabled.
	 *
	 * @param membershipPackages the membership packages
	 */
	@Override
	public void cacheResult(List<MembershipPackage> membershipPackages) {
		for (MembershipPackage membershipPackage : membershipPackages) {
			if (EntityCacheUtil.getResult(
						MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageImpl.class,
						membershipPackage.getPrimaryKey()) == null) {
				cacheResult(membershipPackage);
			}
			else {
				membershipPackage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership packages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipPackageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipPackageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership package.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MembershipPackage membershipPackage) {
		EntityCacheUtil.removeResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageImpl.class, membershipPackage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MembershipPackage> membershipPackages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipPackage membershipPackage : membershipPackages) {
			EntityCacheUtil.removeResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageImpl.class, membershipPackage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership package with the primary key. Does not add the membership package to the database.
	 *
	 * @param mpId the primary key for the new membership package
	 * @return the new membership package
	 */
	@Override
	public MembershipPackage create(long mpId) {
		MembershipPackage membershipPackage = new MembershipPackageImpl();

		membershipPackage.setNew(true);
		membershipPackage.setPrimaryKey(mpId);

		return membershipPackage;
	}

	/**
	 * Removes the membership package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mpId the primary key of the membership package
	 * @return the membership package that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage remove(long mpId)
		throws NoSuchMembershipPackageException, SystemException {
		return remove((Serializable)mpId);
	}

	/**
	 * Removes the membership package with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership package
	 * @return the membership package that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage remove(Serializable primaryKey)
		throws NoSuchMembershipPackageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipPackage membershipPackage = (MembershipPackage)session.get(MembershipPackageImpl.class,
					primaryKey);

			if (membershipPackage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipPackage);
		}
		catch (NoSuchMembershipPackageException nsee) {
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
	protected MembershipPackage removeImpl(MembershipPackage membershipPackage)
		throws SystemException {
		membershipPackage = toUnwrappedModel(membershipPackage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipPackage)) {
				membershipPackage = (MembershipPackage)session.get(MembershipPackageImpl.class,
						membershipPackage.getPrimaryKeyObj());
			}

			if (membershipPackage != null) {
				session.delete(membershipPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipPackage != null) {
			clearCache(membershipPackage);
		}

		return membershipPackage;
	}

	@Override
	public MembershipPackage updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipPackage membershipPackage)
		throws SystemException {
		membershipPackage = toUnwrappedModel(membershipPackage);

		boolean isNew = membershipPackage.isNew();

		MembershipPackageModelImpl membershipPackageModelImpl = (MembershipPackageModelImpl)membershipPackage;

		Session session = null;

		try {
			session = openSession();

			if (membershipPackage.isNew()) {
				session.save(membershipPackage);

				membershipPackage.setNew(false);
			}
			else {
				session.merge(membershipPackage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MembershipPackageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME,
					args);

				args = new Object[] { membershipPackageModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGENAME,
					args);
			}

			if ((membershipPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageModelImpl.getOriginalExtra1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);

				args = new Object[] { membershipPackageModelImpl.getExtra1() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEID,
					args);
			}

			if ((membershipPackageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipPackageModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE,
					args);

				args = new Object[] { membershipPackageModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPPACKAGETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPPACKAGETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
			MembershipPackageImpl.class, membershipPackage.getPrimaryKey(),
			membershipPackage);

		return membershipPackage;
	}

	protected MembershipPackage toUnwrappedModel(
		MembershipPackage membershipPackage) {
		if (membershipPackage instanceof MembershipPackageImpl) {
			return membershipPackage;
		}

		MembershipPackageImpl membershipPackageImpl = new MembershipPackageImpl();

		membershipPackageImpl.setNew(membershipPackage.isNew());
		membershipPackageImpl.setPrimaryKey(membershipPackage.getPrimaryKey());

		membershipPackageImpl.setMpId(membershipPackage.getMpId());
		membershipPackageImpl.setName(membershipPackage.getName());
		membershipPackageImpl.setDescription(membershipPackage.getDescription());
		membershipPackageImpl.setStatus(membershipPackage.getStatus());
		membershipPackageImpl.setType(membershipPackage.getType());
		membershipPackageImpl.setVersion(membershipPackage.getVersion());
		membershipPackageImpl.setCost(membershipPackage.getCost());
		membershipPackageImpl.setCostCurrency(membershipPackage.getCostCurrency());
		membershipPackageImpl.setCostPeriod(membershipPackage.getCostPeriod());
		membershipPackageImpl.setCostPeriodType(membershipPackage.getCostPeriodType());
		membershipPackageImpl.setPromotionCode(membershipPackage.getPromotionCode());
		membershipPackageImpl.setPromotionFrom(membershipPackage.getPromotionFrom());
		membershipPackageImpl.setPromotionTo(membershipPackage.getPromotionTo());
		membershipPackageImpl.setDiscount(membershipPackage.getDiscount());
		membershipPackageImpl.setDateAdded(membershipPackage.getDateAdded());
		membershipPackageImpl.setDateModified(membershipPackage.getDateModified());
		membershipPackageImpl.setCreatedBy(membershipPackage.getCreatedBy());
		membershipPackageImpl.setModifiedBy(membershipPackage.getModifiedBy());
		membershipPackageImpl.setExtra1(membershipPackage.getExtra1());
		membershipPackageImpl.setExtra2(membershipPackage.getExtra2());
		membershipPackageImpl.setExtra3(membershipPackage.getExtra3());
		membershipPackageImpl.setExtra4(membershipPackage.getExtra4());
		membershipPackageImpl.setExtra5(membershipPackage.getExtra5());
		membershipPackageImpl.setExtra6(membershipPackage.getExtra6());
		membershipPackageImpl.setExtra7(membershipPackage.getExtra7());
		membershipPackageImpl.setExtra8(membershipPackage.getExtra8());
		membershipPackageImpl.setExtra9(membershipPackage.getExtra9());
		membershipPackageImpl.setExtra10(membershipPackage.getExtra10());

		return membershipPackageImpl;
	}

	/**
	 * Returns the membership package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package
	 * @return the membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMembershipPackageException, SystemException {
		MembershipPackage membershipPackage = fetchByPrimaryKey(primaryKey);

		if (membershipPackage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipPackage;
	}

	/**
	 * Returns the membership package with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException} if it could not be found.
	 *
	 * @param mpId the primary key of the membership package
	 * @return the membership package
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipPackageException if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage findByPrimaryKey(long mpId)
		throws NoSuchMembershipPackageException, SystemException {
		return findByPrimaryKey((Serializable)mpId);
	}

	/**
	 * Returns the membership package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership package
	 * @return the membership package, or <code>null</code> if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MembershipPackage membershipPackage = (MembershipPackage)EntityCacheUtil.getResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
				MembershipPackageImpl.class, primaryKey);

		if (membershipPackage == _nullMembershipPackage) {
			return null;
		}

		if (membershipPackage == null) {
			Session session = null;

			try {
				session = openSession();

				membershipPackage = (MembershipPackage)session.get(MembershipPackageImpl.class,
						primaryKey);

				if (membershipPackage != null) {
					cacheResult(membershipPackage);
				}
				else {
					EntityCacheUtil.putResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
						MembershipPackageImpl.class, primaryKey,
						_nullMembershipPackage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipPackageModelImpl.ENTITY_CACHE_ENABLED,
					MembershipPackageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipPackage;
	}

	/**
	 * Returns the membership package with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mpId the primary key of the membership package
	 * @return the membership package, or <code>null</code> if a membership package with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipPackage fetchByPrimaryKey(long mpId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)mpId);
	}

	/**
	 * Returns all the membership packages.
	 *
	 * @return the membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @return the range of membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership packages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership packages
	 * @param end the upper bound of the range of membership packages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership packages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipPackage> findAll(int start, int end,
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

		List<MembershipPackage> list = (List<MembershipPackage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPPACKAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPPACKAGE;

				if (pagination) {
					sql = sql.concat(MembershipPackageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipPackage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipPackage>(list);
				}
				else {
					list = (List<MembershipPackage>)QueryUtil.list(q,
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
	 * Removes all the membership packages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipPackage membershipPackage : findAll()) {
			remove(membershipPackage);
		}
	}

	/**
	 * Returns the number of membership packages.
	 *
	 * @return the number of membership packages
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPPACKAGE);

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
	 * Initializes the membership package persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipPackage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipPackage>> listenersList = new ArrayList<ModelListener<MembershipPackage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipPackage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipPackageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPPACKAGE = "SELECT membershipPackage FROM MembershipPackage membershipPackage";
	private static final String _SQL_SELECT_MEMBERSHIPPACKAGE_WHERE = "SELECT membershipPackage FROM MembershipPackage membershipPackage WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGE = "SELECT COUNT(membershipPackage) FROM MembershipPackage membershipPackage";
	private static final String _SQL_COUNT_MEMBERSHIPPACKAGE_WHERE = "SELECT COUNT(membershipPackage) FROM MembershipPackage membershipPackage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipPackage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipPackage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipPackage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipPackagePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static MembershipPackage _nullMembershipPackage = new MembershipPackageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipPackage> toCacheModel() {
				return _nullMembershipPackageCacheModel;
			}
		};

	private static CacheModel<MembershipPackage> _nullMembershipPackageCacheModel =
		new CacheModel<MembershipPackage>() {
			@Override
			public MembershipPackage toEntityModel() {
				return _nullMembershipPackage;
			}
		};
}