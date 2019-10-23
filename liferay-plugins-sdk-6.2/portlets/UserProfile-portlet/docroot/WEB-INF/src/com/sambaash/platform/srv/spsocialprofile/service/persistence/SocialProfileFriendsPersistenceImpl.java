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

package com.sambaash.platform.srv.spsocialprofile.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the social profile friends service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileFriendsPersistence
 * @see SocialProfileFriendsUtil
 * @generated
 */
public class SocialProfileFriendsPersistenceImpl extends BasePersistenceImpl<SocialProfileFriends>
	implements SocialProfileFriendsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfileFriendsUtil} to access the social profile friends persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfileFriendsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SocialProfileFriendsModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileFriendsModelImpl.BELONGSTOUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @return the matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserId(long companyId,
		long belongsToUserId) throws SystemException {
		return findByUserId(companyId, belongsToUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @return the range of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserId(long companyId,
		long belongsToUserId, int start, int end) throws SystemException {
		return findByUserId(companyId, belongsToUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserId(long companyId,
		long belongsToUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { companyId, belongsToUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] {
					companyId, belongsToUserId,
					
					start, end, orderByComparator
				};
		}

		List<SocialProfileFriends> list = (List<SocialProfileFriends>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileFriends socialProfileFriends : list) {
				if ((companyId != socialProfileFriends.getCompanyId()) ||
						(belongsToUserId != socialProfileFriends.getBelongsToUserId())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERID_BELONGSTOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileFriendsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

				if (!pagination) {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileFriends>(list);
				}
				else {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
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
	 * Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByUserId_First(long companyId,
		long belongsToUserId, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByUserId_First(companyId,
				belongsToUserId, orderByComparator);

		if (socialProfileFriends != null) {
			return socialProfileFriends;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", belongsToUserId=");
		msg.append(belongsToUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileFriendsException(msg.toString());
	}

	/**
	 * Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserId_First(long companyId,
		long belongsToUserId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SocialProfileFriends> list = findByUserId(companyId,
				belongsToUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByUserId_Last(long companyId,
		long belongsToUserId, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByUserId_Last(companyId,
				belongsToUserId, orderByComparator);

		if (socialProfileFriends != null) {
			return socialProfileFriends;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", belongsToUserId=");
		msg.append(belongsToUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileFriendsException(msg.toString());
	}

	/**
	 * Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserId_Last(long companyId,
		long belongsToUserId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserId(companyId, belongsToUserId);

		if (count == 0) {
			return null;
		}

		List<SocialProfileFriends> list = findByUserId(companyId,
				belongsToUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile friendses before and after the current social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param socialProfileFriendsId the primary key of the current social profile friends
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends[] findByUserId_PrevAndNext(
		long socialProfileFriendsId, long companyId, long belongsToUserId,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = findByPrimaryKey(socialProfileFriendsId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileFriends[] array = new SocialProfileFriendsImpl[3];

			array[0] = getByUserId_PrevAndNext(session, socialProfileFriends,
					companyId, belongsToUserId, orderByComparator, true);

			array[1] = socialProfileFriends;

			array[2] = getByUserId_PrevAndNext(session, socialProfileFriends,
					companyId, belongsToUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialProfileFriends getByUserId_PrevAndNext(Session session,
		SocialProfileFriends socialProfileFriends, long companyId,
		long belongsToUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE);

		query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_USERID_BELONGSTOUSERID_2);

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
			query.append(SocialProfileFriendsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(belongsToUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileFriends);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileFriends> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long companyId, long belongsToUserId)
		throws SystemException {
		for (SocialProfileFriends socialProfileFriends : findByUserId(
				companyId, belongsToUserId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(socialProfileFriends);
		}
	}

	/**
	 * Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @return the number of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long companyId, long belongsToUserId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { companyId, belongsToUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERID_BELONGSTOUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

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

	private static final String _FINDER_COLUMN_USERID_COMPANYID_2 = "socialProfileFriends.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_BELONGSTOUSERID_2 = "socialProfileFriends.belongsToUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE =
		new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndSocialNetworkType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE =
		new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndSocialNetworkType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SocialProfileFriendsModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileFriendsModelImpl.BELONGSTOUSERID_COLUMN_BITMASK |
			SocialProfileFriendsModelImpl.SOCIALNETWORKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKTYPE =
		new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndSocialNetworkType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @return the matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType)
		throws SystemException {
		return findByUserIdAndSocialNetworkType(companyId, belongsToUserId,
			socialNetworkType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @return the range of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end) throws SystemException {
		return findByUserIdAndSocialNetworkType(companyId, belongsToUserId,
			socialNetworkType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findByUserIdAndSocialNetworkType(
		long companyId, long belongsToUserId, int socialNetworkType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE;
			finderArgs = new Object[] {
					companyId, belongsToUserId, socialNetworkType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE;
			finderArgs = new Object[] {
					companyId, belongsToUserId, socialNetworkType,
					
					start, end, orderByComparator
				};
		}

		List<SocialProfileFriends> list = (List<SocialProfileFriends>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileFriends socialProfileFriends : list) {
				if ((companyId != socialProfileFriends.getCompanyId()) ||
						(belongsToUserId != socialProfileFriends.getBelongsToUserId()) ||
						(socialNetworkType != socialProfileFriends.getSocialNetworkType())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_BELONGSTOUSERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_SOCIALNETWORKTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileFriendsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

				qPos.add(socialNetworkType);

				if (!pagination) {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileFriends>(list);
				}
				else {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
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
	 * Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByUserIdAndSocialNetworkType_First(
		long companyId, long belongsToUserId, int socialNetworkType,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByUserIdAndSocialNetworkType_First(companyId,
				belongsToUserId, socialNetworkType, orderByComparator);

		if (socialProfileFriends != null) {
			return socialProfileFriends;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", belongsToUserId=");
		msg.append(belongsToUserId);

		msg.append(", socialNetworkType=");
		msg.append(socialNetworkType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileFriendsException(msg.toString());
	}

	/**
	 * Returns the first social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserIdAndSocialNetworkType_First(
		long companyId, long belongsToUserId, int socialNetworkType,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileFriends> list = findByUserIdAndSocialNetworkType(companyId,
				belongsToUserId, socialNetworkType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByUserIdAndSocialNetworkType_Last(
		long companyId, long belongsToUserId, int socialNetworkType,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByUserIdAndSocialNetworkType_Last(companyId,
				belongsToUserId, socialNetworkType, orderByComparator);

		if (socialProfileFriends != null) {
			return socialProfileFriends;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", belongsToUserId=");
		msg.append(belongsToUserId);

		msg.append(", socialNetworkType=");
		msg.append(socialNetworkType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileFriendsException(msg.toString());
	}

	/**
	 * Returns the last social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserIdAndSocialNetworkType_Last(
		long companyId, long belongsToUserId, int socialNetworkType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdAndSocialNetworkType(companyId,
				belongsToUserId, socialNetworkType);

		if (count == 0) {
			return null;
		}

		List<SocialProfileFriends> list = findByUserIdAndSocialNetworkType(companyId,
				belongsToUserId, socialNetworkType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile friendses before and after the current social profile friends in the ordered set where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialProfileFriendsId the primary key of the current social profile friends
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends[] findByUserIdAndSocialNetworkType_PrevAndNext(
		long socialProfileFriendsId, long companyId, long belongsToUserId,
		int socialNetworkType, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = findByPrimaryKey(socialProfileFriendsId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileFriends[] array = new SocialProfileFriendsImpl[3];

			array[0] = getByUserIdAndSocialNetworkType_PrevAndNext(session,
					socialProfileFriends, companyId, belongsToUserId,
					socialNetworkType, orderByComparator, true);

			array[1] = socialProfileFriends;

			array[2] = getByUserIdAndSocialNetworkType_PrevAndNext(session,
					socialProfileFriends, companyId, belongsToUserId,
					socialNetworkType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialProfileFriends getByUserIdAndSocialNetworkType_PrevAndNext(
		Session session, SocialProfileFriends socialProfileFriends,
		long companyId, long belongsToUserId, int socialNetworkType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_COMPANYID_2);

		query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_BELONGSTOUSERID_2);

		query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_SOCIALNETWORKTYPE_2);

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
			query.append(SocialProfileFriendsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(belongsToUserId);

		qPos.add(socialNetworkType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileFriends);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileFriends> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndSocialNetworkType(long companyId,
		long belongsToUserId, int socialNetworkType) throws SystemException {
		for (SocialProfileFriends socialProfileFriends : findByUserIdAndSocialNetworkType(
				companyId, belongsToUserId, socialNetworkType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(socialProfileFriends);
		}
	}

	/**
	 * Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkType the social network type
	 * @return the number of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndSocialNetworkType(long companyId,
		long belongsToUserId, int socialNetworkType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKTYPE;

		Object[] finderArgs = new Object[] {
				companyId, belongsToUserId, socialNetworkType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_BELONGSTOUSERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_SOCIALNETWORKTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

				qPos.add(socialNetworkType);

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

	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_COMPANYID_2 =
		"socialProfileFriends.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_BELONGSTOUSERID_2 =
		"socialProfileFriends.belongsToUserId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSOCIALNETWORKTYPE_SOCIALNETWORKTYPE_2 =
		"socialProfileFriends.socialNetworkType = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileFriendsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndSNProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			SocialProfileFriendsModelImpl.COMPANYID_COLUMN_BITMASK |
			SocialProfileFriendsModelImpl.BELONGSTOUSERID_COLUMN_BITMASK |
			SocialProfileFriendsModelImpl.SOCIALNETWORKPROFILEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID = new FinderPath(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndSNProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the matching social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByUserIdAndSNProfileId(companyId,
				belongsToUserId, socialNetworkProfileId);

		if (socialProfileFriends == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", belongsToUserId=");
			msg.append(belongsToUserId);

			msg.append(", socialNetworkProfileId=");
			msg.append(socialNetworkProfileId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileFriendsException(msg.toString());
		}

		return socialProfileFriends;
	}

	/**
	 * Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId)
		throws SystemException {
		return fetchByUserIdAndSNProfileId(companyId, belongsToUserId,
			socialNetworkProfileId, true);
	}

	/**
	 * Returns the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile friends, or <code>null</code> if a matching social profile friends could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, belongsToUserId, socialNetworkProfileId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
					finderArgs, this);
		}

		if (result instanceof SocialProfileFriends) {
			SocialProfileFriends socialProfileFriends = (SocialProfileFriends)result;

			if ((companyId != socialProfileFriends.getCompanyId()) ||
					(belongsToUserId != socialProfileFriends.getBelongsToUserId()) ||
					(socialNetworkProfileId != socialProfileFriends.getSocialNetworkProfileId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_BELONGSTOUSERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_SOCIALNETWORKPROFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

				qPos.add(socialNetworkProfileId);

				List<SocialProfileFriends> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
						finderArgs, list);
				}
				else {
					SocialProfileFriends socialProfileFriends = list.get(0);

					result = socialProfileFriends;

					cacheResult(socialProfileFriends);

					if ((socialProfileFriends.getCompanyId() != companyId) ||
							(socialProfileFriends.getBelongsToUserId() != belongsToUserId) ||
							(socialProfileFriends.getSocialNetworkProfileId() != socialNetworkProfileId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
							finderArgs, socialProfileFriends);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
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
			return (SocialProfileFriends)result;
		}
	}

	/**
	 * Removes the social profile friends where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the social profile friends that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends removeByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = findByUserIdAndSNProfileId(companyId,
				belongsToUserId, socialNetworkProfileId);

		return remove(socialProfileFriends);
	}

	/**
	 * Returns the number of social profile friendses where companyId = &#63; and belongsToUserId = &#63; and socialNetworkProfileId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param belongsToUserId the belongs to user ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @return the number of matching social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndSNProfileId(long companyId,
		long belongsToUserId, long socialNetworkProfileId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID;

		Object[] finderArgs = new Object[] {
				companyId, belongsToUserId, socialNetworkProfileId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALPROFILEFRIENDS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_COMPANYID_2);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_BELONGSTOUSERID_2);

			query.append(_FINDER_COLUMN_USERIDANDSNPROFILEID_SOCIALNETWORKPROFILEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(belongsToUserId);

				qPos.add(socialNetworkProfileId);

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

	private static final String _FINDER_COLUMN_USERIDANDSNPROFILEID_COMPANYID_2 = "socialProfileFriends.companyId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSNPROFILEID_BELONGSTOUSERID_2 =
		"socialProfileFriends.belongsToUserId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDSNPROFILEID_SOCIALNETWORKPROFILEID_2 =
		"socialProfileFriends.socialNetworkProfileId = ?";

	public SocialProfileFriendsPersistenceImpl() {
		setModelClass(SocialProfileFriends.class);
	}

	/**
	 * Caches the social profile friends in the entity cache if it is enabled.
	 *
	 * @param socialProfileFriends the social profile friends
	 */
	@Override
	public void cacheResult(SocialProfileFriends socialProfileFriends) {
		EntityCacheUtil.putResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			socialProfileFriends.getPrimaryKey(), socialProfileFriends);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
			new Object[] {
				socialProfileFriends.getCompanyId(),
				socialProfileFriends.getBelongsToUserId(),
				socialProfileFriends.getSocialNetworkProfileId()
			}, socialProfileFriends);

		socialProfileFriends.resetOriginalValues();
	}

	/**
	 * Caches the social profile friendses in the entity cache if it is enabled.
	 *
	 * @param socialProfileFriendses the social profile friendses
	 */
	@Override
	public void cacheResult(List<SocialProfileFriends> socialProfileFriendses) {
		for (SocialProfileFriends socialProfileFriends : socialProfileFriendses) {
			if (EntityCacheUtil.getResult(
						SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileFriendsImpl.class,
						socialProfileFriends.getPrimaryKey()) == null) {
				cacheResult(socialProfileFriends);
			}
			else {
				socialProfileFriends.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profile friendses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfileFriendsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfileFriendsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile friends.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfileFriends socialProfileFriends) {
		EntityCacheUtil.removeResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsImpl.class, socialProfileFriends.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfileFriends);
	}

	@Override
	public void clearCache(List<SocialProfileFriends> socialProfileFriendses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfileFriends socialProfileFriends : socialProfileFriendses) {
			EntityCacheUtil.removeResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileFriendsImpl.class,
				socialProfileFriends.getPrimaryKey());

			clearUniqueFindersCache(socialProfileFriends);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialProfileFriends socialProfileFriends) {
		if (socialProfileFriends.isNew()) {
			Object[] args = new Object[] {
					socialProfileFriends.getCompanyId(),
					socialProfileFriends.getBelongsToUserId(),
					socialProfileFriends.getSocialNetworkProfileId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
				args, socialProfileFriends);
		}
		else {
			SocialProfileFriendsModelImpl socialProfileFriendsModelImpl = (SocialProfileFriendsModelImpl)socialProfileFriends;

			if ((socialProfileFriendsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileFriends.getCompanyId(),
						socialProfileFriends.getBelongsToUserId(),
						socialProfileFriends.getSocialNetworkProfileId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
					args, socialProfileFriends);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SocialProfileFriends socialProfileFriends) {
		SocialProfileFriendsModelImpl socialProfileFriendsModelImpl = (SocialProfileFriendsModelImpl)socialProfileFriends;

		Object[] args = new Object[] {
				socialProfileFriends.getCompanyId(),
				socialProfileFriends.getBelongsToUserId(),
				socialProfileFriends.getSocialNetworkProfileId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
			args);

		if ((socialProfileFriendsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileFriendsModelImpl.getOriginalCompanyId(),
					socialProfileFriendsModelImpl.getOriginalBelongsToUserId(),
					socialProfileFriendsModelImpl.getOriginalSocialNetworkProfileId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSNPROFILEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDSNPROFILEID,
				args);
		}
	}

	/**
	 * Creates a new social profile friends with the primary key. Does not add the social profile friends to the database.
	 *
	 * @param socialProfileFriendsId the primary key for the new social profile friends
	 * @return the new social profile friends
	 */
	@Override
	public SocialProfileFriends create(long socialProfileFriendsId) {
		SocialProfileFriends socialProfileFriends = new SocialProfileFriendsImpl();

		socialProfileFriends.setNew(true);
		socialProfileFriends.setPrimaryKey(socialProfileFriendsId);

		return socialProfileFriends;
	}

	/**
	 * Removes the social profile friends with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialProfileFriendsId the primary key of the social profile friends
	 * @return the social profile friends that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends remove(long socialProfileFriendsId)
		throws NoSuchSocialProfileFriendsException, SystemException {
		return remove((Serializable)socialProfileFriendsId);
	}

	/**
	 * Removes the social profile friends with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile friends
	 * @return the social profile friends that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends remove(Serializable primaryKey)
		throws NoSuchSocialProfileFriendsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfileFriends socialProfileFriends = (SocialProfileFriends)session.get(SocialProfileFriendsImpl.class,
					primaryKey);

			if (socialProfileFriends == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfileFriendsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfileFriends);
		}
		catch (NoSuchSocialProfileFriendsException nsee) {
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
	protected SocialProfileFriends removeImpl(
		SocialProfileFriends socialProfileFriends) throws SystemException {
		socialProfileFriends = toUnwrappedModel(socialProfileFriends);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfileFriends)) {
				socialProfileFriends = (SocialProfileFriends)session.get(SocialProfileFriendsImpl.class,
						socialProfileFriends.getPrimaryKeyObj());
			}

			if (socialProfileFriends != null) {
				session.delete(socialProfileFriends);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfileFriends != null) {
			clearCache(socialProfileFriends);
		}

		return socialProfileFriends;
	}

	@Override
	public SocialProfileFriends updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends)
		throws SystemException {
		socialProfileFriends = toUnwrappedModel(socialProfileFriends);

		boolean isNew = socialProfileFriends.isNew();

		SocialProfileFriendsModelImpl socialProfileFriendsModelImpl = (SocialProfileFriendsModelImpl)socialProfileFriends;

		Session session = null;

		try {
			session = openSession();

			if (socialProfileFriends.isNew()) {
				session.save(socialProfileFriends);

				socialProfileFriends.setNew(false);
			}
			else {
				session.merge(socialProfileFriends);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfileFriendsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((socialProfileFriendsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileFriendsModelImpl.getOriginalCompanyId(),
						socialProfileFriendsModelImpl.getOriginalBelongsToUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						socialProfileFriendsModelImpl.getCompanyId(),
						socialProfileFriendsModelImpl.getBelongsToUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((socialProfileFriendsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileFriendsModelImpl.getOriginalCompanyId(),
						socialProfileFriendsModelImpl.getOriginalBelongsToUserId(),
						socialProfileFriendsModelImpl.getOriginalSocialNetworkType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE,
					args);

				args = new Object[] {
						socialProfileFriendsModelImpl.getCompanyId(),
						socialProfileFriendsModelImpl.getBelongsToUserId(),
						socialProfileFriendsModelImpl.getSocialNetworkType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDSOCIALNETWORKTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDSOCIALNETWORKTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileFriendsImpl.class,
			socialProfileFriends.getPrimaryKey(), socialProfileFriends);

		clearUniqueFindersCache(socialProfileFriends);
		cacheUniqueFindersCache(socialProfileFriends);

		return socialProfileFriends;
	}

	protected SocialProfileFriends toUnwrappedModel(
		SocialProfileFriends socialProfileFriends) {
		if (socialProfileFriends instanceof SocialProfileFriendsImpl) {
			return socialProfileFriends;
		}

		SocialProfileFriendsImpl socialProfileFriendsImpl = new SocialProfileFriendsImpl();

		socialProfileFriendsImpl.setNew(socialProfileFriends.isNew());
		socialProfileFriendsImpl.setPrimaryKey(socialProfileFriends.getPrimaryKey());

		socialProfileFriendsImpl.setSocialProfileFriendsId(socialProfileFriends.getSocialProfileFriendsId());
		socialProfileFriendsImpl.setCompanyId(socialProfileFriends.getCompanyId());
		socialProfileFriendsImpl.setBelongsToUserId(socialProfileFriends.getBelongsToUserId());
		socialProfileFriendsImpl.setSocialNetworkProfileId(socialProfileFriends.getSocialNetworkProfileId());
		socialProfileFriendsImpl.setFirstName(socialProfileFriends.getFirstName());
		socialProfileFriendsImpl.setLastName(socialProfileFriends.getLastName());
		socialProfileFriendsImpl.setBirthday(socialProfileFriends.getBirthday());
		socialProfileFriendsImpl.setLocation(socialProfileFriends.getLocation());
		socialProfileFriendsImpl.setPictureUrl(socialProfileFriends.getPictureUrl());
		socialProfileFriendsImpl.setUserName(socialProfileFriends.getUserName());
		socialProfileFriendsImpl.setGender(socialProfileFriends.getGender());
		socialProfileFriendsImpl.setSocialNetworkType(socialProfileFriends.getSocialNetworkType());
		socialProfileFriendsImpl.setCreateDate(socialProfileFriends.getCreateDate());
		socialProfileFriendsImpl.setModifiedDate(socialProfileFriends.getModifiedDate());

		return socialProfileFriendsImpl;
	}

	/**
	 * Returns the social profile friends with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile friends
	 * @return the social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfileFriendsException, SystemException {
		SocialProfileFriends socialProfileFriends = fetchByPrimaryKey(primaryKey);

		if (socialProfileFriends == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfileFriendsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfileFriends;
	}

	/**
	 * Returns the social profile friends with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException} if it could not be found.
	 *
	 * @param socialProfileFriendsId the primary key of the social profile friends
	 * @return the social profile friends
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileFriendsException if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends findByPrimaryKey(long socialProfileFriendsId)
		throws NoSuchSocialProfileFriendsException, SystemException {
		return findByPrimaryKey((Serializable)socialProfileFriendsId);
	}

	/**
	 * Returns the social profile friends with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile friends
	 * @return the social profile friends, or <code>null</code> if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfileFriends socialProfileFriends = (SocialProfileFriends)EntityCacheUtil.getResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileFriendsImpl.class, primaryKey);

		if (socialProfileFriends == _nullSocialProfileFriends) {
			return null;
		}

		if (socialProfileFriends == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfileFriends = (SocialProfileFriends)session.get(SocialProfileFriendsImpl.class,
						primaryKey);

				if (socialProfileFriends != null) {
					cacheResult(socialProfileFriends);
				}
				else {
					EntityCacheUtil.putResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileFriendsImpl.class, primaryKey,
						_nullSocialProfileFriends);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfileFriendsModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfileFriendsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfileFriends;
	}

	/**
	 * Returns the social profile friends with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialProfileFriendsId the primary key of the social profile friends
	 * @return the social profile friends, or <code>null</code> if a social profile friends with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileFriends fetchByPrimaryKey(long socialProfileFriendsId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)socialProfileFriendsId);
	}

	/**
	 * Returns all the social profile friendses.
	 *
	 * @return the social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile friendses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @return the range of social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile friendses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileFriendsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile friendses
	 * @param end the upper bound of the range of social profile friendses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profile friendses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileFriends> findAll(int start, int end,
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

		List<SocialProfileFriends> list = (List<SocialProfileFriends>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILEFRIENDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILEFRIENDS;

				if (pagination) {
					sql = sql.concat(SocialProfileFriendsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileFriends>(list);
				}
				else {
					list = (List<SocialProfileFriends>)QueryUtil.list(q,
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
	 * Removes all the social profile friendses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfileFriends socialProfileFriends : findAll()) {
			remove(socialProfileFriends);
		}
	}

	/**
	 * Returns the number of social profile friendses.
	 *
	 * @return the number of social profile friendses
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILEFRIENDS);

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
	 * Initializes the social profile friends persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfileFriends>> listenersList = new ArrayList<ModelListener<SocialProfileFriends>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfileFriends>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfileFriendsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILEFRIENDS = "SELECT socialProfileFriends FROM SocialProfileFriends socialProfileFriends";
	private static final String _SQL_SELECT_SOCIALPROFILEFRIENDS_WHERE = "SELECT socialProfileFriends FROM SocialProfileFriends socialProfileFriends WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILEFRIENDS = "SELECT COUNT(socialProfileFriends) FROM SocialProfileFriends socialProfileFriends";
	private static final String _SQL_COUNT_SOCIALPROFILEFRIENDS_WHERE = "SELECT COUNT(socialProfileFriends) FROM SocialProfileFriends socialProfileFriends WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfileFriends.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfileFriends exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfileFriends exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfileFriendsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"socialProfileFriendsId"
			});
	private static SocialProfileFriends _nullSocialProfileFriends = new SocialProfileFriendsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfileFriends> toCacheModel() {
				return _nullSocialProfileFriendsCacheModel;
			}
		};

	private static CacheModel<SocialProfileFriends> _nullSocialProfileFriendsCacheModel =
		new CacheModel<SocialProfileFriends>() {
			@Override
			public SocialProfileFriends toEntityModel() {
				return _nullSocialProfileFriends;
			}
		};
}