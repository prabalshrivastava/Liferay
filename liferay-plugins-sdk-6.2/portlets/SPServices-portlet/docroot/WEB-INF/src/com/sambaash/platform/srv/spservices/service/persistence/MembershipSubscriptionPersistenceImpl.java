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

import com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;
import com.sambaash.platform.srv.spservices.model.MembershipSubscription;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionImpl;
import com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the membership subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionPersistence
 * @see MembershipSubscriptionUtil
 * @generated
 */
public class MembershipSubscriptionPersistenceImpl extends BasePersistenceImpl<MembershipSubscription>
	implements MembershipSubscriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MembershipSubscriptionUtil} to access the membership subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MembershipSubscriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionName",
			new String[] { String.class.getName() },
			MembershipSubscriptionModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONNAME =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscriptions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionName(
		String name) throws SystemException {
		return findByMembershipSubscriptionName(name, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionName(
		String name, int start, int end) throws SystemException {
		return findByMembershipSubscriptionName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionName(
		String name, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(name, membershipSubscription.getName())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
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
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionName_First(
		String name, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionName_First(name,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionName_First(
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionName(name,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionName_Last(
		String name, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionName_Last(name,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionName_Last(
		String name, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionName(name);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionName(name,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where name = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionName_PrevAndNext(
		long msId, String name, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionName_PrevAndNext(session,
					membershipSubscription, name, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionName_PrevAndNext(session,
					membershipSubscription, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionName_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_2);
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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionName(String name)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionName(
				name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionName(String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONNAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_2);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_1 =
		"membershipSubscription.name IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_2 =
		"membershipSubscription.name = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONNAME_NAME_3 =
		"(membershipSubscription.name IS NULL OR membershipSubscription.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionGroupId",
			new String[] { Long.class.getName() },
			MembershipSubscriptionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONGROUPID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the membership subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId) throws SystemException {
		return findByMembershipSubscriptionGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end) throws SystemException {
		return findByMembershipSubscriptionGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if ((groupId != membershipSubscription.getGroupId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionGroupId_First(
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionGroupId_First(groupId,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionGroupId_First(
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionGroupId(groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionGroupId_Last(
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionGroupId_Last(groupId,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionGroupId_Last(
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionGroupId(groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where groupId = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionGroupId_PrevAndNext(
		long msId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionGroupId_PrevAndNext(session,
					membershipSubscription, groupId, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionGroupId_PrevAndNext(session,
					membershipSubscription, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionGroupId_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONGROUPID_GROUPID_2);

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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionGroupId(long groupId)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionGroupId(long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONGROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONGROUPID_GROUPID_2 =
		"membershipSubscription.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionUserId",
			new String[] { Long.class.getName() },
			MembershipSubscriptionModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONUSERID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the membership subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId) throws SystemException {
		return findByMembershipSubscriptionUserId(userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end) throws SystemException {
		return findByMembershipSubscriptionUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if ((userId != membershipSubscription.getUserId())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionUserId_First(
		long userId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionUserId_First(userId,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionUserId_First(
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionUserId(userId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionUserId_Last(
		long userId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionUserId_Last(userId,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionUserId_Last(
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionUserId(userId);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionUserId(userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where userId = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionUserId_PrevAndNext(
		long msId, long userId, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionUserId_PrevAndNext(session,
					membershipSubscription, userId, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionUserId_PrevAndNext(session,
					membershipSubscription, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionUserId_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONUSERID_USERID_2);

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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionUserId(long userId)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionUserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionUserId(long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONUSERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONUSERID_USERID_2 =
		"membershipSubscription.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1 =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionMpId_1",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1 =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionMpId_1",
			new String[] { String.class.getName() },
			MembershipSubscriptionModelImpl.MPID_1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONMPID_1 =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionMpId_1",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscriptions where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionMpId_1(
		String mpId_1) throws SystemException {
		return findByMembershipSubscriptionMpId_1(mpId_1, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where mpId_1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId_1 the mp id_1
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionMpId_1(
		String mpId_1, int start, int end) throws SystemException {
		return findByMembershipSubscriptionMpId_1(mpId_1, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where mpId_1 = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param mpId_1 the mp id_1
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionMpId_1(
		String mpId_1, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1;
			finderArgs = new Object[] { mpId_1 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1;
			finderArgs = new Object[] { mpId_1, start, end, orderByComparator };
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(mpId_1, membershipSubscription.getMpId_1())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindMpId_1 = false;

			if (mpId_1 == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_1);
			}
			else if (mpId_1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_3);
			}
			else {
				bindMpId_1 = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMpId_1) {
					qPos.add(mpId_1);
				}

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionMpId_1_First(
		String mpId_1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionMpId_1_First(mpId_1,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId_1=");
		msg.append(mpId_1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionMpId_1_First(
		String mpId_1, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionMpId_1(mpId_1,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionMpId_1_Last(
		String mpId_1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionMpId_1_Last(mpId_1,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("mpId_1=");
		msg.append(mpId_1);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionMpId_1_Last(
		String mpId_1, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionMpId_1(mpId_1);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionMpId_1(mpId_1,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where mpId_1 = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param mpId_1 the mp id_1
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionMpId_1_PrevAndNext(
		long msId, String mpId_1, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionMpId_1_PrevAndNext(session,
					membershipSubscription, mpId_1, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionMpId_1_PrevAndNext(session,
					membershipSubscription, mpId_1, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionMpId_1_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String mpId_1, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindMpId_1 = false;

		if (mpId_1 == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_1);
		}
		else if (mpId_1.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_3);
		}
		else {
			bindMpId_1 = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_2);
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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMpId_1) {
			qPos.add(mpId_1);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where mpId_1 = &#63; from the database.
	 *
	 * @param mpId_1 the mp id_1
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionMpId_1(String mpId_1)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionMpId_1(
				mpId_1, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where mpId_1 = &#63;.
	 *
	 * @param mpId_1 the mp id_1
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionMpId_1(String mpId_1)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONMPID_1;

		Object[] finderArgs = new Object[] { mpId_1 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindMpId_1 = false;

			if (mpId_1 == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_1);
			}
			else if (mpId_1.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_3);
			}
			else {
				bindMpId_1 = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMpId_1) {
					qPos.add(mpId_1);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_1 =
		"membershipSubscription.mpId_1 IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_2 =
		"membershipSubscription.mpId_1 = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONMPID_1_MPID_1_3 =
		"(membershipSubscription.mpId_1 IS NULL OR membershipSubscription.mpId_1 = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionSessionId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionSessionId",
			new String[] { String.class.getName() },
			MembershipSubscriptionModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionSessionId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscriptions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionSessionId(
		String userName) throws SystemException {
		return findByMembershipSubscriptionSessionId(userName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionSessionId(
		String userName, int start, int end) throws SystemException {
		return findByMembershipSubscriptionSessionId(userName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionSessionId(
		String userName, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID;
			finderArgs = new Object[] { userName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID;
			finderArgs = new Object[] { userName, start, end, orderByComparator };
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(userName,
							membershipSubscription.getUserName())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionSessionId_First(
		String userName, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionSessionId_First(userName,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionSessionId_First(
		String userName, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionSessionId(userName,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionSessionId_Last(
		String userName, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionSessionId_Last(userName,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionSessionId_Last(
		String userName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionSessionId(userName);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionSessionId(userName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where userName = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionSessionId_PrevAndNext(
		long msId, String userName, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionSessionId_PrevAndNext(session,
					membershipSubscription, userName, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionSessionId_PrevAndNext(session,
					membershipSubscription, userName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionSessionId_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String userName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindUserName = false;

		if (userName == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_1);
		}
		else if (userName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_2);
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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionSessionId(String userName)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionSessionId(
				userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionSessionId(String userName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID;

		Object[] finderArgs = new Object[] { userName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_1 =
		"membershipSubscription.userName IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_2 =
		"membershipSubscription.userName = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSESSIONID_USERNAME_3 =
		"(membershipSubscription.userName IS NULL OR membershipSubscription.userName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionPpPaymentStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionPpPaymentStatus",
			new String[] { String.class.getName() },
			MembershipSubscriptionModelImpl.PPPAYMENTSTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionPpPaymentStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscriptions where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		String ppPaymentStatus) throws SystemException {
		return findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where ppPaymentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		String ppPaymentStatus, int start, int end) throws SystemException {
		return findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where ppPaymentStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		String ppPaymentStatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS;
			finderArgs = new Object[] { ppPaymentStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS;
			finderArgs = new Object[] {
					ppPaymentStatus,
					
					start, end, orderByComparator
				};
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(ppPaymentStatus,
							membershipSubscription.getPpPaymentStatus())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindPpPaymentStatus = false;

			if (ppPaymentStatus == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_1);
			}
			else if (ppPaymentStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_3);
			}
			else {
				bindPpPaymentStatus = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPpPaymentStatus) {
					qPos.add(ppPaymentStatus);
				}

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_First(
		String ppPaymentStatus, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionPpPaymentStatus_First(ppPaymentStatus,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ppPaymentStatus=");
		msg.append(ppPaymentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_First(
		String ppPaymentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_Last(
		String ppPaymentStatus, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionPpPaymentStatus_Last(ppPaymentStatus,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ppPaymentStatus=");
		msg.append(ppPaymentStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_Last(
		String ppPaymentStatus, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where ppPaymentStatus = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param ppPaymentStatus the pp payment status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatus_PrevAndNext(
		long msId, String ppPaymentStatus, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionPpPaymentStatus_PrevAndNext(session,
					membershipSubscription, ppPaymentStatus, orderByComparator,
					true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionPpPaymentStatus_PrevAndNext(session,
					membershipSubscription, ppPaymentStatus, orderByComparator,
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

	protected MembershipSubscription getByMembershipSubscriptionPpPaymentStatus_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String ppPaymentStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindPpPaymentStatus = false;

		if (ppPaymentStatus == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_1);
		}
		else if (ppPaymentStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_3);
		}
		else {
			bindPpPaymentStatus = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_2);
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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPpPaymentStatus) {
			qPos.add(ppPaymentStatus);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where ppPaymentStatus = &#63; from the database.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionPpPaymentStatus(
		String ppPaymentStatus) throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionPpPaymentStatus(
				ppPaymentStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where ppPaymentStatus = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionPpPaymentStatus(
		String ppPaymentStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS;

		Object[] finderArgs = new Object[] { ppPaymentStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindPpPaymentStatus = false;

			if (ppPaymentStatus == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_1);
			}
			else if (ppPaymentStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_3);
			}
			else {
				bindPpPaymentStatus = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPpPaymentStatus) {
					qPos.add(ppPaymentStatus);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_1 =
		"membershipSubscription.ppPaymentStatus IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_2 =
		"membershipSubscription.ppPaymentStatus = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS_PPPAYMENTSTATUS_3 =
		"(membershipSubscription.ppPaymentStatus IS NULL OR membershipSubscription.ppPaymentStatus = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionShippingEmailAddressAndNettotal",
			new String[] {
				String.class.getName(), Float.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionShippingEmailAddressAndNettotal",
			new String[] { String.class.getName(), Float.class.getName() },
			MembershipSubscriptionModelImpl.SHIPPINGEMAILADDRESS_COLUMN_BITMASK |
			MembershipSubscriptionModelImpl.NETTOTAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionShippingEmailAddressAndNettotal",
			new String[] { String.class.getName(), Float.class.getName() });

	/**
	 * Returns all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		String shippingEmailAddress, float nettotal) throws SystemException {
		return findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		String shippingEmailAddress, float nettotal, int start, int end)
		throws SystemException {
		return findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		String shippingEmailAddress, float nettotal, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL;
			finderArgs = new Object[] { shippingEmailAddress, nettotal };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL;
			finderArgs = new Object[] {
					shippingEmailAddress, nettotal,
					
					start, end, orderByComparator
				};
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(shippingEmailAddress,
							membershipSubscription.getShippingEmailAddress()) ||
						(nettotal != membershipSubscription.getNettotal())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
				}

				qPos.add(nettotal);

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_First(shippingEmailAddress,
				nettotal, orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(", nettotal=");
		msg.append(nettotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
				nettotal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(shippingEmailAddress,
				nettotal, orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(", nettotal=");
		msg.append(nettotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
				nettotal);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
				nettotal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(
		long msId, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(session,
					membershipSubscription, shippingEmailAddress, nettotal,
					orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(session,
					membershipSubscription, shippingEmailAddress, nettotal,
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

	protected MembershipSubscription getByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindShippingEmailAddress = false;

		if (shippingEmailAddress == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
		}
		else if (shippingEmailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
		}
		else {
			bindShippingEmailAddress = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
		}

		query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindShippingEmailAddress) {
			qPos.add(shippingEmailAddress);
		}

		qPos.add(nettotal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionShippingEmailAddressAndNettotal(
		String shippingEmailAddress, float nettotal) throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionShippingEmailAddressAndNettotal(
				shippingEmailAddress, nettotal, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionShippingEmailAddressAndNettotal(
		String shippingEmailAddress, float nettotal) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL;

		Object[] finderArgs = new Object[] { shippingEmailAddress, nettotal };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
				}

				qPos.add(nettotal);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1 =
		"membershipSubscription.shippingEmailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2 =
		"membershipSubscription.shippingEmailAddress = ? AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3 =
		"(membershipSubscription.shippingEmailAddress IS NULL OR membershipSubscription.shippingEmailAddress = '') AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL_NETTOTAL_2 =
		"membershipSubscription.nettotal = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionShippingEmailAddress",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionShippingEmailAddress",
			new String[] { String.class.getName() },
			MembershipSubscriptionModelImpl.SHIPPINGEMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionShippingEmailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns all the membership subscriptions where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		String shippingEmailAddress) throws SystemException {
		return findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where shippingEmailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		String shippingEmailAddress, int start, int end)
		throws SystemException {
		return findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where shippingEmailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		String shippingEmailAddress, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS;
			finderArgs = new Object[] { shippingEmailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS;
			finderArgs = new Object[] {
					shippingEmailAddress,
					
					start, end, orderByComparator
				};
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(shippingEmailAddress,
							membershipSubscription.getShippingEmailAddress())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
				}

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_First(
		String shippingEmailAddress, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionShippingEmailAddress_First(shippingEmailAddress,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_First(
		String shippingEmailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_Last(
		String shippingEmailAddress, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionShippingEmailAddress_Last(shippingEmailAddress,
				orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_Last(
		String shippingEmailAddress, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where shippingEmailAddress = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param shippingEmailAddress the shipping email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddress_PrevAndNext(
		long msId, String shippingEmailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionShippingEmailAddress_PrevAndNext(session,
					membershipSubscription, shippingEmailAddress,
					orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionShippingEmailAddress_PrevAndNext(session,
					membershipSubscription, shippingEmailAddress,
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

	protected MembershipSubscription getByMembershipSubscriptionShippingEmailAddress_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String shippingEmailAddress, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindShippingEmailAddress = false;

		if (shippingEmailAddress == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_1);
		}
		else if (shippingEmailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_3);
		}
		else {
			bindShippingEmailAddress = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_2);
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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindShippingEmailAddress) {
			qPos.add(shippingEmailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where shippingEmailAddress = &#63; from the database.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionShippingEmailAddress(
		String shippingEmailAddress) throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionShippingEmailAddress(
				shippingEmailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where shippingEmailAddress = &#63;.
	 *
	 * @param shippingEmailAddress the shipping email address
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionShippingEmailAddress(
		String shippingEmailAddress) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS;

		Object[] finderArgs = new Object[] { shippingEmailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_1 =
		"membershipSubscription.shippingEmailAddress IS NULL";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_2 =
		"membershipSubscription.shippingEmailAddress = ?";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS_SHIPPINGEMAILADDRESS_3 =
		"(membershipSubscription.shippingEmailAddress IS NULL OR membershipSubscription.shippingEmailAddress = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal",
			new String[] {
				String.class.getName(), String.class.getName(),
				Float.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal",
			new String[] {
				String.class.getName(), String.class.getName(),
				Float.class.getName()
			},
			MembershipSubscriptionModelImpl.PPPAYMENTSTATUS_COLUMN_BITMASK |
			MembershipSubscriptionModelImpl.SHIPPINGEMAILADDRESS_COLUMN_BITMASK |
			MembershipSubscriptionModelImpl.NETTOTAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL =
		new FinderPath(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal",
			new String[] {
				String.class.getName(), String.class.getName(),
				Float.class.getName()
			});

	/**
	 * Returns all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @return the matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal)
		throws SystemException {
		return findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		int start, int end) throws SystemException {
		return findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL;
			finderArgs = new Object[] {
					ppPaymentStatus, shippingEmailAddress, nettotal
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL;
			finderArgs = new Object[] {
					ppPaymentStatus, shippingEmailAddress, nettotal,
					
					start, end, orderByComparator
				};
		}

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MembershipSubscription membershipSubscription : list) {
				if (!Validator.equals(ppPaymentStatus,
							membershipSubscription.getPpPaymentStatus()) ||
						!Validator.equals(shippingEmailAddress,
							membershipSubscription.getShippingEmailAddress()) ||
						(nettotal != membershipSubscription.getNettotal())) {
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

			query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindPpPaymentStatus = false;

			if (ppPaymentStatus == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_1);
			}
			else if (ppPaymentStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_3);
			}
			else {
				bindPpPaymentStatus = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_2);
			}

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPpPaymentStatus) {
					qPos.add(ppPaymentStatus);
				}

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
				}

				qPos.add(nettotal);

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(ppPaymentStatus,
				shippingEmailAddress, nettotal, orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ppPaymentStatus=");
		msg.append(ppPaymentStatus);

		msg.append(", shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(", nettotal=");
		msg.append(nettotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator) throws SystemException {
		List<MembershipSubscription> list = findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
				shippingEmailAddress, nettotal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(ppPaymentStatus,
				shippingEmailAddress, nettotal, orderByComparator);

		if (membershipSubscription != null) {
			return membershipSubscription;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ppPaymentStatus=");
		msg.append(ppPaymentStatus);

		msg.append(", shippingEmailAddress=");
		msg.append(shippingEmailAddress);

		msg.append(", nettotal=");
		msg.append(nettotal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMembershipSubscriptionException(msg.toString());
	}

	/**
	 * Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
				shippingEmailAddress, nettotal);

		if (count == 0) {
			return null;
		}

		List<MembershipSubscription> list = findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
				shippingEmailAddress, nettotal, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the membership subscriptions before and after the current membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param msId the primary key of the current membership subscription
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(
		long msId, String ppPaymentStatus, String shippingEmailAddress,
		float nettotal, OrderByComparator orderByComparator)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = findByPrimaryKey(msId);

		Session session = null;

		try {
			session = openSession();

			MembershipSubscription[] array = new MembershipSubscriptionImpl[3];

			array[0] = getByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(session,
					membershipSubscription, ppPaymentStatus,
					shippingEmailAddress, nettotal, orderByComparator, true);

			array[1] = membershipSubscription;

			array[2] = getByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(session,
					membershipSubscription, ppPaymentStatus,
					shippingEmailAddress, nettotal, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MembershipSubscription getByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(
		Session session, MembershipSubscription membershipSubscription,
		String ppPaymentStatus, String shippingEmailAddress, float nettotal,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE);

		boolean bindPpPaymentStatus = false;

		if (ppPaymentStatus == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_1);
		}
		else if (ppPaymentStatus.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_3);
		}
		else {
			bindPpPaymentStatus = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_2);
		}

		boolean bindShippingEmailAddress = false;

		if (shippingEmailAddress == null) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
		}
		else if (shippingEmailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
		}
		else {
			bindShippingEmailAddress = true;

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
		}

		query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

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
			query.append(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPpPaymentStatus) {
			qPos.add(ppPaymentStatus);
		}

		if (bindShippingEmailAddress) {
			qPos.add(shippingEmailAddress);
		}

		qPos.add(nettotal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(membershipSubscription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MembershipSubscription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal)
		throws SystemException {
		for (MembershipSubscription membershipSubscription : findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
				ppPaymentStatus, shippingEmailAddress, nettotal,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	 *
	 * @param ppPaymentStatus the pp payment status
	 * @param shippingEmailAddress the shipping email address
	 * @param nettotal the nettotal
	 * @return the number of matching membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		String ppPaymentStatus, String shippingEmailAddress, float nettotal)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL;

		Object[] finderArgs = new Object[] {
				ppPaymentStatus, shippingEmailAddress, nettotal
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE);

			boolean bindPpPaymentStatus = false;

			if (ppPaymentStatus == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_1);
			}
			else if (ppPaymentStatus.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_3);
			}
			else {
				bindPpPaymentStatus = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_2);
			}

			boolean bindShippingEmailAddress = false;

			if (shippingEmailAddress == null) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1);
			}
			else if (shippingEmailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3);
			}
			else {
				bindShippingEmailAddress = true;

				query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_NETTOTAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPpPaymentStatus) {
					qPos.add(ppPaymentStatus);
				}

				if (bindShippingEmailAddress) {
					qPos.add(shippingEmailAddress);
				}

				qPos.add(nettotal);

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

	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_1 =
		"membershipSubscription.ppPaymentStatus IS NULL AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_2 =
		"membershipSubscription.ppPaymentStatus = ? AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_PPPAYMENTSTATUS_3 =
		"(membershipSubscription.ppPaymentStatus IS NULL OR membershipSubscription.ppPaymentStatus = '') AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_1 =
		"membershipSubscription.shippingEmailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_2 =
		"membershipSubscription.shippingEmailAddress = ? AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_SHIPPINGEMAILADDRESS_3 =
		"(membershipSubscription.shippingEmailAddress IS NULL OR membershipSubscription.shippingEmailAddress = '') AND ";
	private static final String _FINDER_COLUMN_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL_NETTOTAL_2 =
		"membershipSubscription.nettotal = ?";

	public MembershipSubscriptionPersistenceImpl() {
		setModelClass(MembershipSubscription.class);
	}

	/**
	 * Caches the membership subscription in the entity cache if it is enabled.
	 *
	 * @param membershipSubscription the membership subscription
	 */
	@Override
	public void cacheResult(MembershipSubscription membershipSubscription) {
		EntityCacheUtil.putResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			membershipSubscription.getPrimaryKey(), membershipSubscription);

		membershipSubscription.resetOriginalValues();
	}

	/**
	 * Caches the membership subscriptions in the entity cache if it is enabled.
	 *
	 * @param membershipSubscriptions the membership subscriptions
	 */
	@Override
	public void cacheResult(
		List<MembershipSubscription> membershipSubscriptions) {
		for (MembershipSubscription membershipSubscription : membershipSubscriptions) {
			if (EntityCacheUtil.getResult(
						MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscriptionImpl.class,
						membershipSubscription.getPrimaryKey()) == null) {
				cacheResult(membershipSubscription);
			}
			else {
				membershipSubscription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all membership subscriptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MembershipSubscriptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MembershipSubscriptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the membership subscription.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MembershipSubscription membershipSubscription) {
		EntityCacheUtil.removeResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			membershipSubscription.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MembershipSubscription> membershipSubscriptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MembershipSubscription membershipSubscription : membershipSubscriptions) {
			EntityCacheUtil.removeResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscriptionImpl.class,
				membershipSubscription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new membership subscription with the primary key. Does not add the membership subscription to the database.
	 *
	 * @param msId the primary key for the new membership subscription
	 * @return the new membership subscription
	 */
	@Override
	public MembershipSubscription create(long msId) {
		MembershipSubscription membershipSubscription = new MembershipSubscriptionImpl();

		membershipSubscription.setNew(true);
		membershipSubscription.setPrimaryKey(msId);

		return membershipSubscription;
	}

	/**
	 * Removes the membership subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param msId the primary key of the membership subscription
	 * @return the membership subscription that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription remove(long msId)
		throws NoSuchMembershipSubscriptionException, SystemException {
		return remove((Serializable)msId);
	}

	/**
	 * Removes the membership subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the membership subscription
	 * @return the membership subscription that was removed
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription remove(Serializable primaryKey)
		throws NoSuchMembershipSubscriptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MembershipSubscription membershipSubscription = (MembershipSubscription)session.get(MembershipSubscriptionImpl.class,
					primaryKey);

			if (membershipSubscription == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMembershipSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(membershipSubscription);
		}
		catch (NoSuchMembershipSubscriptionException nsee) {
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
	protected MembershipSubscription removeImpl(
		MembershipSubscription membershipSubscription)
		throws SystemException {
		membershipSubscription = toUnwrappedModel(membershipSubscription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(membershipSubscription)) {
				membershipSubscription = (MembershipSubscription)session.get(MembershipSubscriptionImpl.class,
						membershipSubscription.getPrimaryKeyObj());
			}

			if (membershipSubscription != null) {
				session.delete(membershipSubscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (membershipSubscription != null) {
			clearCache(membershipSubscription);
		}

		return membershipSubscription;
	}

	@Override
	public MembershipSubscription updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws SystemException {
		membershipSubscription = toUnwrappedModel(membershipSubscription);

		boolean isNew = membershipSubscription.isNew();

		MembershipSubscriptionModelImpl membershipSubscriptionModelImpl = (MembershipSubscriptionModelImpl)membershipSubscription;

		Session session = null;

		try {
			session = openSession();

			if (membershipSubscription.isNew()) {
				session.save(membershipSubscription);

				membershipSubscription.setNew(false);
			}
			else {
				session.merge(membershipSubscription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MembershipSubscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME,
					args);

				args = new Object[] { membershipSubscriptionModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONNAME,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID,
					args);

				args = new Object[] { membershipSubscriptionModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONGROUPID,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID,
					args);

				args = new Object[] { membershipSubscriptionModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONUSERID,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalMpId_1()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONMPID_1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1,
					args);

				args = new Object[] { membershipSubscriptionModelImpl.getMpId_1() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONMPID_1,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONMPID_1,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalUserName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID,
					args);

				args = new Object[] {
						membershipSubscriptionModelImpl.getUserName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSESSIONID,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalPpPaymentStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS,
					args);

				args = new Object[] {
						membershipSubscriptionModelImpl.getPpPaymentStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUS,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalShippingEmailAddress(),
						membershipSubscriptionModelImpl.getOriginalNettotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL,
					args);

				args = new Object[] {
						membershipSubscriptionModelImpl.getShippingEmailAddress(),
						membershipSubscriptionModelImpl.getNettotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESSANDNETTOTAL,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalShippingEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS,
					args);

				args = new Object[] {
						membershipSubscriptionModelImpl.getShippingEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONSHIPPINGEMAILADDRESS,
					args);
			}

			if ((membershipSubscriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						membershipSubscriptionModelImpl.getOriginalPpPaymentStatus(),
						membershipSubscriptionModelImpl.getOriginalShippingEmailAddress(),
						membershipSubscriptionModelImpl.getOriginalNettotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL,
					args);

				args = new Object[] {
						membershipSubscriptionModelImpl.getPpPaymentStatus(),
						membershipSubscriptionModelImpl.getShippingEmailAddress(),
						membershipSubscriptionModelImpl.getNettotal()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEMBERSHIPSUBSCRIPTIONPPPAYMENTSTATUSEMAILADDRESSANDNETTOTAL,
					args);
			}
		}

		EntityCacheUtil.putResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
			MembershipSubscriptionImpl.class,
			membershipSubscription.getPrimaryKey(), membershipSubscription);

		return membershipSubscription;
	}

	protected MembershipSubscription toUnwrappedModel(
		MembershipSubscription membershipSubscription) {
		if (membershipSubscription instanceof MembershipSubscriptionImpl) {
			return membershipSubscription;
		}

		MembershipSubscriptionImpl membershipSubscriptionImpl = new MembershipSubscriptionImpl();

		membershipSubscriptionImpl.setNew(membershipSubscription.isNew());
		membershipSubscriptionImpl.setPrimaryKey(membershipSubscription.getPrimaryKey());

		membershipSubscriptionImpl.setMsId(membershipSubscription.getMsId());
		membershipSubscriptionImpl.setName(membershipSubscription.getName());
		membershipSubscriptionImpl.setDescription(membershipSubscription.getDescription());
		membershipSubscriptionImpl.setMporder_1(membershipSubscription.getMporder_1());
		membershipSubscriptionImpl.setMpId_1(membershipSubscription.getMpId_1());
		membershipSubscriptionImpl.setMpName_1(membershipSubscription.getMpName_1());
		membershipSubscriptionImpl.setMpQty_1(membershipSubscription.getMpQty_1());
		membershipSubscriptionImpl.setMpPrice_1(membershipSubscription.getMpPrice_1());
		membershipSubscriptionImpl.setMpPriceCurrency_1(membershipSubscription.getMpPriceCurrency_1());
		membershipSubscriptionImpl.setMporder_2(membershipSubscription.getMporder_2());
		membershipSubscriptionImpl.setMpId_2(membershipSubscription.getMpId_2());
		membershipSubscriptionImpl.setMpName_2(membershipSubscription.getMpName_2());
		membershipSubscriptionImpl.setMpQty_2(membershipSubscription.getMpQty_2());
		membershipSubscriptionImpl.setMpPrice_2(membershipSubscription.getMpPrice_2());
		membershipSubscriptionImpl.setMpPriceCurrency_2(membershipSubscription.getMpPriceCurrency_2());
		membershipSubscriptionImpl.setMporder_3(membershipSubscription.getMporder_3());
		membershipSubscriptionImpl.setMpId_3(membershipSubscription.getMpId_3());
		membershipSubscriptionImpl.setMpName_3(membershipSubscription.getMpName_3());
		membershipSubscriptionImpl.setMpQty_3(membershipSubscription.getMpQty_3());
		membershipSubscriptionImpl.setMpPrice_3(membershipSubscription.getMpPrice_3());
		membershipSubscriptionImpl.setMpPriceCurrency_3(membershipSubscription.getMpPriceCurrency_3());
		membershipSubscriptionImpl.setMporder_4(membershipSubscription.getMporder_4());
		membershipSubscriptionImpl.setMpId_4(membershipSubscription.getMpId_4());
		membershipSubscriptionImpl.setMpName_4(membershipSubscription.getMpName_4());
		membershipSubscriptionImpl.setMpQty_4(membershipSubscription.getMpQty_4());
		membershipSubscriptionImpl.setMpPrice_4(membershipSubscription.getMpPrice_4());
		membershipSubscriptionImpl.setMpPriceCurrency_4(membershipSubscription.getMpPriceCurrency_4());
		membershipSubscriptionImpl.setMpSubtotal(membershipSubscription.getMpSubtotal());
		membershipSubscriptionImpl.setMpSubtotalCurrency(membershipSubscription.getMpSubtotalCurrency());
		membershipSubscriptionImpl.setAddOnSubtotal(membershipSubscription.getAddOnSubtotal());
		membershipSubscriptionImpl.setAddOnSubtotalCurrency(membershipSubscription.getAddOnSubtotalCurrency());
		membershipSubscriptionImpl.setTax(membershipSubscription.getTax());
		membershipSubscriptionImpl.setComments(membershipSubscription.getComments());
		membershipSubscriptionImpl.setPromotionCode(membershipSubscription.getPromotionCode());
		membershipSubscriptionImpl.setPromotionFrom(membershipSubscription.getPromotionFrom());
		membershipSubscriptionImpl.setPromotionTo(membershipSubscription.getPromotionTo());
		membershipSubscriptionImpl.setDiscount(membershipSubscription.getDiscount());
		membershipSubscriptionImpl.setNettotal(membershipSubscription.getNettotal());
		membershipSubscriptionImpl.setNettotalCurrency(membershipSubscription.getNettotalCurrency());
		membershipSubscriptionImpl.setPpTxnId(membershipSubscription.getPpTxnId());
		membershipSubscriptionImpl.setPpPaymentStatus(membershipSubscription.getPpPaymentStatus());
		membershipSubscriptionImpl.setPpPaymentGross(membershipSubscription.getPpPaymentGross());
		membershipSubscriptionImpl.setPpReceiverEmail(membershipSubscription.getPpReceiverEmail());
		membershipSubscriptionImpl.setPpPayerEmail(membershipSubscription.getPpPayerEmail());
		membershipSubscriptionImpl.setSendOrderEmail(membershipSubscription.getSendOrderEmail());
		membershipSubscriptionImpl.setSendShippingEmail(membershipSubscription.getSendShippingEmail());
		membershipSubscriptionImpl.setEffectiveFromDate(membershipSubscription.getEffectiveFromDate());
		membershipSubscriptionImpl.setEffectiveToDate(membershipSubscription.getEffectiveToDate());
		membershipSubscriptionImpl.setAltShipping(membershipSubscription.getAltShipping());
		membershipSubscriptionImpl.setShipping(membershipSubscription.getShipping());
		membershipSubscriptionImpl.setRequiresShipping(membershipSubscription.isRequiresShipping());
		membershipSubscriptionImpl.setInsure(membershipSubscription.isInsure());
		membershipSubscriptionImpl.setInsurance(membershipSubscription.getInsurance());
		membershipSubscriptionImpl.setBillingFirstName(membershipSubscription.getBillingFirstName());
		membershipSubscriptionImpl.setBillingLastName(membershipSubscription.getBillingLastName());
		membershipSubscriptionImpl.setBillingEmailAddress(membershipSubscription.getBillingEmailAddress());
		membershipSubscriptionImpl.setBillingCompany(membershipSubscription.getBillingCompany());
		membershipSubscriptionImpl.setBillingStreet(membershipSubscription.getBillingStreet());
		membershipSubscriptionImpl.setBillingCity(membershipSubscription.getBillingCity());
		membershipSubscriptionImpl.setBillingState(membershipSubscription.getBillingState());
		membershipSubscriptionImpl.setBillingZip(membershipSubscription.getBillingZip());
		membershipSubscriptionImpl.setBillingCountry(membershipSubscription.getBillingCountry());
		membershipSubscriptionImpl.setBillingPhone(membershipSubscription.getBillingPhone());
		membershipSubscriptionImpl.setShipToBilling(membershipSubscription.isShipToBilling());
		membershipSubscriptionImpl.setShippingFirstName(membershipSubscription.getShippingFirstName());
		membershipSubscriptionImpl.setShippingLastName(membershipSubscription.getShippingLastName());
		membershipSubscriptionImpl.setShippingEmailAddress(membershipSubscription.getShippingEmailAddress());
		membershipSubscriptionImpl.setShippingCompany(membershipSubscription.getShippingCompany());
		membershipSubscriptionImpl.setShippingStreet(membershipSubscription.getShippingStreet());
		membershipSubscriptionImpl.setShippingCity(membershipSubscription.getShippingCity());
		membershipSubscriptionImpl.setShippingState(membershipSubscription.getShippingState());
		membershipSubscriptionImpl.setShippingZip(membershipSubscription.getShippingZip());
		membershipSubscriptionImpl.setShippingCountry(membershipSubscription.getShippingCountry());
		membershipSubscriptionImpl.setShippingPhone(membershipSubscription.getShippingPhone());
		membershipSubscriptionImpl.setCcName(membershipSubscription.getCcName());
		membershipSubscriptionImpl.setCcType(membershipSubscription.getCcType());
		membershipSubscriptionImpl.setCcNumber(membershipSubscription.getCcNumber());
		membershipSubscriptionImpl.setCcExpMonth(membershipSubscription.getCcExpMonth());
		membershipSubscriptionImpl.setCcExpYear(membershipSubscription.getCcExpYear());
		membershipSubscriptionImpl.setCcVerNumber(membershipSubscription.getCcVerNumber());
		membershipSubscriptionImpl.setGroupId(membershipSubscription.getGroupId());
		membershipSubscriptionImpl.setCompanyId(membershipSubscription.getCompanyId());
		membershipSubscriptionImpl.setUserId(membershipSubscription.getUserId());
		membershipSubscriptionImpl.setUserName(membershipSubscription.getUserName());
		membershipSubscriptionImpl.setCreateDate(membershipSubscription.getCreateDate());
		membershipSubscriptionImpl.setModifiedDate(membershipSubscription.getModifiedDate());

		return membershipSubscriptionImpl;
	}

	/**
	 * Returns the membership subscription with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscription
	 * @return the membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMembershipSubscriptionException, SystemException {
		MembershipSubscription membershipSubscription = fetchByPrimaryKey(primaryKey);

		if (membershipSubscription == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMembershipSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return membershipSubscription;
	}

	/**
	 * Returns the membership subscription with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException} if it could not be found.
	 *
	 * @param msId the primary key of the membership subscription
	 * @return the membership subscription
	 * @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription findByPrimaryKey(long msId)
		throws NoSuchMembershipSubscriptionException, SystemException {
		return findByPrimaryKey((Serializable)msId);
	}

	/**
	 * Returns the membership subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the membership subscription
	 * @return the membership subscription, or <code>null</code> if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MembershipSubscription membershipSubscription = (MembershipSubscription)EntityCacheUtil.getResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
				MembershipSubscriptionImpl.class, primaryKey);

		if (membershipSubscription == _nullMembershipSubscription) {
			return null;
		}

		if (membershipSubscription == null) {
			Session session = null;

			try {
				session = openSession();

				membershipSubscription = (MembershipSubscription)session.get(MembershipSubscriptionImpl.class,
						primaryKey);

				if (membershipSubscription != null) {
					cacheResult(membershipSubscription);
				}
				else {
					EntityCacheUtil.putResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
						MembershipSubscriptionImpl.class, primaryKey,
						_nullMembershipSubscription);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MembershipSubscriptionModelImpl.ENTITY_CACHE_ENABLED,
					MembershipSubscriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return membershipSubscription;
	}

	/**
	 * Returns the membership subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param msId the primary key of the membership subscription
	 * @return the membership subscription, or <code>null</code> if a membership subscription with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MembershipSubscription fetchByPrimaryKey(long msId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)msId);
	}

	/**
	 * Returns all the membership subscriptions.
	 *
	 * @return the membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the membership subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @return the range of membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the membership subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of membership subscriptions
	 * @param end the upper bound of the range of membership subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of membership subscriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MembershipSubscription> findAll(int start, int end,
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

		List<MembershipSubscription> list = (List<MembershipSubscription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBERSHIPSUBSCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBERSHIPSUBSCRIPTION;

				if (pagination) {
					sql = sql.concat(MembershipSubscriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MembershipSubscription>(list);
				}
				else {
					list = (List<MembershipSubscription>)QueryUtil.list(q,
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
	 * Removes all the membership subscriptions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MembershipSubscription membershipSubscription : findAll()) {
			remove(membershipSubscription);
		}
	}

	/**
	 * Returns the number of membership subscriptions.
	 *
	 * @return the number of membership subscriptions
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

				Query q = session.createQuery(_SQL_COUNT_MEMBERSHIPSUBSCRIPTION);

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
	 * Initializes the membership subscription persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spservices.model.MembershipSubscription")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MembershipSubscription>> listenersList = new ArrayList<ModelListener<MembershipSubscription>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MembershipSubscription>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MembershipSubscriptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIPTION = "SELECT membershipSubscription FROM MembershipSubscription membershipSubscription";
	private static final String _SQL_SELECT_MEMBERSHIPSUBSCRIPTION_WHERE = "SELECT membershipSubscription FROM MembershipSubscription membershipSubscription WHERE ";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIPTION = "SELECT COUNT(membershipSubscription) FROM MembershipSubscription membershipSubscription";
	private static final String _SQL_COUNT_MEMBERSHIPSUBSCRIPTION_WHERE = "SELECT COUNT(membershipSubscription) FROM MembershipSubscription membershipSubscription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "membershipSubscription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MembershipSubscription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MembershipSubscription exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MembershipSubscriptionPersistenceImpl.class);
	private static MembershipSubscription _nullMembershipSubscription = new MembershipSubscriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MembershipSubscription> toCacheModel() {
				return _nullMembershipSubscriptionCacheModel;
			}
		};

	private static CacheModel<MembershipSubscription> _nullMembershipSubscriptionCacheModel =
		new CacheModel<MembershipSubscription>() {
			@Override
			public MembershipSubscription toEntityModel() {
				return _nullMembershipSubscription;
			}
		};
}