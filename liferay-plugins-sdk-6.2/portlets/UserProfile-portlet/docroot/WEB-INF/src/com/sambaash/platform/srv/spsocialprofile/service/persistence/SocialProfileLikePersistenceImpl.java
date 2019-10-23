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

import com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException;
import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeImpl;
import com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the social profile like service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileLikePersistence
 * @see SocialProfileLikeUtil
 * @generated
 */
public class SocialProfileLikePersistenceImpl extends BasePersistenceImpl<SocialProfileLike>
	implements SocialProfileLikePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SocialProfileLikeUtil} to access the social profile like persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SocialProfileLikeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileLikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileLikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileLikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySocialNetworkProfileId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileLikeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySocialNetworkProfileId",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SocialProfileLikeModelImpl.SOCIALNETWORKPROFILEID_COLUMN_BITMASK |
			SocialProfileLikeModelImpl.SOCIALNETWORKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SOCIALNETWORKPROFILEID = new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySocialNetworkProfileId",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the matching social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType)
		throws SystemException {
		return findBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param start the lower bound of the range of social profile likes
	 * @param end the upper bound of the range of social profile likes (not inclusive)
	 * @return the range of matching social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end)
		throws SystemException {
		return findBySocialNetworkProfileId(socialNetworkProfileId,
			socialNetworkType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param start the lower bound of the range of social profile likes
	 * @param end the upper bound of the range of social profile likes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findBySocialNetworkProfileId(
		long socialNetworkProfileId, int socialNetworkType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID;
			finderArgs = new Object[] { socialNetworkProfileId, socialNetworkType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID;
			finderArgs = new Object[] {
					socialNetworkProfileId, socialNetworkType,
					
					start, end, orderByComparator
				};
		}

		List<SocialProfileLike> list = (List<SocialProfileLike>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SocialProfileLike socialProfileLike : list) {
				if ((socialNetworkProfileId != socialProfileLike.getSocialNetworkProfileId()) ||
						(socialNetworkType != socialProfileLike.getSocialNetworkType())) {
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

			query.append(_SQL_SELECT_SOCIALPROFILELIKE_WHERE);

			query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SocialProfileLikeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialNetworkProfileId);

				qPos.add(socialNetworkType);

				if (!pagination) {
					list = (List<SocialProfileLike>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileLike>(list);
				}
				else {
					list = (List<SocialProfileLike>)QueryUtil.list(q,
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
	 * Returns the first social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike findBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = fetchBySocialNetworkProfileId_First(socialNetworkProfileId,
				socialNetworkType, orderByComparator);

		if (socialProfileLike != null) {
			return socialProfileLike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("socialNetworkProfileId=");
		msg.append(socialNetworkProfileId);

		msg.append(", socialNetworkType=");
		msg.append(socialNetworkType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileLikeException(msg.toString());
	}

	/**
	 * Returns the first social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social profile like, or <code>null</code> if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchBySocialNetworkProfileId_First(
		long socialNetworkProfileId, int socialNetworkType,
		OrderByComparator orderByComparator) throws SystemException {
		List<SocialProfileLike> list = findBySocialNetworkProfileId(socialNetworkProfileId,
				socialNetworkType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike findBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		OrderByComparator orderByComparator)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = fetchBySocialNetworkProfileId_Last(socialNetworkProfileId,
				socialNetworkType, orderByComparator);

		if (socialProfileLike != null) {
			return socialProfileLike;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("socialNetworkProfileId=");
		msg.append(socialNetworkProfileId);

		msg.append(", socialNetworkType=");
		msg.append(socialNetworkType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSocialProfileLikeException(msg.toString());
	}

	/**
	 * Returns the last social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social profile like, or <code>null</code> if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchBySocialNetworkProfileId_Last(
		long socialNetworkProfileId, int socialNetworkType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySocialNetworkProfileId(socialNetworkProfileId,
				socialNetworkType);

		if (count == 0) {
			return null;
		}

		List<SocialProfileLike> list = findBySocialNetworkProfileId(socialNetworkProfileId,
				socialNetworkType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social profile likes before and after the current social profile like in the ordered set where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialProfileLikeId the primary key of the current social profile like
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike[] findBySocialNetworkProfileId_PrevAndNext(
		long socialProfileLikeId, long socialNetworkProfileId,
		int socialNetworkType, OrderByComparator orderByComparator)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = findByPrimaryKey(socialProfileLikeId);

		Session session = null;

		try {
			session = openSession();

			SocialProfileLike[] array = new SocialProfileLikeImpl[3];

			array[0] = getBySocialNetworkProfileId_PrevAndNext(session,
					socialProfileLike, socialNetworkProfileId,
					socialNetworkType, orderByComparator, true);

			array[1] = socialProfileLike;

			array[2] = getBySocialNetworkProfileId_PrevAndNext(session,
					socialProfileLike, socialNetworkProfileId,
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

	protected SocialProfileLike getBySocialNetworkProfileId_PrevAndNext(
		Session session, SocialProfileLike socialProfileLike,
		long socialNetworkProfileId, int socialNetworkType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SOCIALPROFILELIKE_WHERE);

		query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

		query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2);

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
			query.append(SocialProfileLikeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(socialNetworkProfileId);

		qPos.add(socialNetworkType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(socialProfileLike);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SocialProfileLike> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySocialNetworkProfileId(long socialNetworkProfileId,
		int socialNetworkType) throws SystemException {
		for (SocialProfileLike socialProfileLike : findBySocialNetworkProfileId(
				socialNetworkProfileId, socialNetworkType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(socialProfileLike);
		}
	}

	/**
	 * Returns the number of social profile likes where socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the number of matching social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySocialNetworkProfileId(long socialNetworkProfileId,
		int socialNetworkType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SOCIALNETWORKPROFILEID;

		Object[] finderArgs = new Object[] {
				socialNetworkProfileId, socialNetworkType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SOCIALPROFILELIKE_WHERE);

			query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			query.append(_FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialNetworkProfileId);

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

	private static final String _FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2 =
		"socialProfileLike.socialNetworkProfileId = ? AND ";
	private static final String _FINDER_COLUMN_SOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2 =
		"socialProfileLike.socialNetworkType = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED,
			SocialProfileLikeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByLikeIdAndSocialNetworkProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SocialProfileLikeModelImpl.SOCIALNETWORKLIKEID_COLUMN_BITMASK |
			SocialProfileLikeModelImpl.SOCIALNETWORKPROFILEID_COLUMN_BITMASK |
			SocialProfileLikeModelImpl.SOCIALNETWORKTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID =
		new FinderPath(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLikeIdAndSocialNetworkProfileId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException} if it could not be found.
	 *
	 * @param socialNetworkLikeId the social network like ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the matching social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike findByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = fetchByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
				socialNetworkProfileId, socialNetworkType);

		if (socialProfileLike == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("socialNetworkLikeId=");
			msg.append(socialNetworkLikeId);

			msg.append(", socialNetworkProfileId=");
			msg.append(socialNetworkProfileId);

			msg.append(", socialNetworkType=");
			msg.append(socialNetworkType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSocialProfileLikeException(msg.toString());
		}

		return socialProfileLike;
	}

	/**
	 * Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param socialNetworkLikeId the social network like ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the matching social profile like, or <code>null</code> if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType) throws SystemException {
		return fetchByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
			socialNetworkProfileId, socialNetworkType, true);
	}

	/**
	 * Returns the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param socialNetworkLikeId the social network like ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching social profile like, or <code>null</code> if a matching social profile like could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				socialNetworkLikeId, socialNetworkProfileId, socialNetworkType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
					finderArgs, this);
		}

		if (result instanceof SocialProfileLike) {
			SocialProfileLike socialProfileLike = (SocialProfileLike)result;

			if ((socialNetworkLikeId != socialProfileLike.getSocialNetworkLikeId()) ||
					(socialNetworkProfileId != socialProfileLike.getSocialNetworkProfileId()) ||
					(socialNetworkType != socialProfileLike.getSocialNetworkType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SOCIALPROFILELIKE_WHERE);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKLIKEID_2);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialNetworkLikeId);

				qPos.add(socialNetworkProfileId);

				qPos.add(socialNetworkType);

				List<SocialProfileLike> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
						finderArgs, list);
				}
				else {
					SocialProfileLike socialProfileLike = list.get(0);

					result = socialProfileLike;

					cacheResult(socialProfileLike);

					if ((socialProfileLike.getSocialNetworkLikeId() != socialNetworkLikeId) ||
							(socialProfileLike.getSocialNetworkProfileId() != socialNetworkProfileId) ||
							(socialProfileLike.getSocialNetworkType() != socialNetworkType)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
							finderArgs, socialProfileLike);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
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
			return (SocialProfileLike)result;
		}
	}

	/**
	 * Removes the social profile like where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63; from the database.
	 *
	 * @param socialNetworkLikeId the social network like ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the social profile like that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike removeByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = findByLikeIdAndSocialNetworkProfileId(socialNetworkLikeId,
				socialNetworkProfileId, socialNetworkType);

		return remove(socialProfileLike);
	}

	/**
	 * Returns the number of social profile likes where socialNetworkLikeId = &#63; and socialNetworkProfileId = &#63; and socialNetworkType = &#63;.
	 *
	 * @param socialNetworkLikeId the social network like ID
	 * @param socialNetworkProfileId the social network profile ID
	 * @param socialNetworkType the social network type
	 * @return the number of matching social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLikeIdAndSocialNetworkProfileId(
		long socialNetworkLikeId, long socialNetworkProfileId,
		int socialNetworkType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID;

		Object[] finderArgs = new Object[] {
				socialNetworkLikeId, socialNetworkProfileId, socialNetworkType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SOCIALPROFILELIKE_WHERE);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKLIKEID_2);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2);

			query.append(_FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(socialNetworkLikeId);

				qPos.add(socialNetworkProfileId);

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

	private static final String _FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKLIKEID_2 =
		"socialProfileLike.socialNetworkLikeId = ? AND ";
	private static final String _FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKPROFILEID_2 =
		"socialProfileLike.socialNetworkProfileId = ? AND ";
	private static final String _FINDER_COLUMN_LIKEIDANDSOCIALNETWORKPROFILEID_SOCIALNETWORKTYPE_2 =
		"socialProfileLike.socialNetworkType = ?";

	public SocialProfileLikePersistenceImpl() {
		setModelClass(SocialProfileLike.class);
	}

	/**
	 * Caches the social profile like in the entity cache if it is enabled.
	 *
	 * @param socialProfileLike the social profile like
	 */
	@Override
	public void cacheResult(SocialProfileLike socialProfileLike) {
		EntityCacheUtil.putResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeImpl.class, socialProfileLike.getPrimaryKey(),
			socialProfileLike);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
			new Object[] {
				socialProfileLike.getSocialNetworkLikeId(),
				socialProfileLike.getSocialNetworkProfileId(),
				socialProfileLike.getSocialNetworkType()
			}, socialProfileLike);

		socialProfileLike.resetOriginalValues();
	}

	/**
	 * Caches the social profile likes in the entity cache if it is enabled.
	 *
	 * @param socialProfileLikes the social profile likes
	 */
	@Override
	public void cacheResult(List<SocialProfileLike> socialProfileLikes) {
		for (SocialProfileLike socialProfileLike : socialProfileLikes) {
			if (EntityCacheUtil.getResult(
						SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileLikeImpl.class,
						socialProfileLike.getPrimaryKey()) == null) {
				cacheResult(socialProfileLike);
			}
			else {
				socialProfileLike.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all social profile likes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SocialProfileLikeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SocialProfileLikeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the social profile like.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialProfileLike socialProfileLike) {
		EntityCacheUtil.removeResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeImpl.class, socialProfileLike.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(socialProfileLike);
	}

	@Override
	public void clearCache(List<SocialProfileLike> socialProfileLikes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SocialProfileLike socialProfileLike : socialProfileLikes) {
			EntityCacheUtil.removeResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileLikeImpl.class, socialProfileLike.getPrimaryKey());

			clearUniqueFindersCache(socialProfileLike);
		}
	}

	protected void cacheUniqueFindersCache(SocialProfileLike socialProfileLike) {
		if (socialProfileLike.isNew()) {
			Object[] args = new Object[] {
					socialProfileLike.getSocialNetworkLikeId(),
					socialProfileLike.getSocialNetworkProfileId(),
					socialProfileLike.getSocialNetworkType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
				args, socialProfileLike);
		}
		else {
			SocialProfileLikeModelImpl socialProfileLikeModelImpl = (SocialProfileLikeModelImpl)socialProfileLike;

			if ((socialProfileLikeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileLike.getSocialNetworkLikeId(),
						socialProfileLike.getSocialNetworkProfileId(),
						socialProfileLike.getSocialNetworkType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
					args, socialProfileLike);
			}
		}
	}

	protected void clearUniqueFindersCache(SocialProfileLike socialProfileLike) {
		SocialProfileLikeModelImpl socialProfileLikeModelImpl = (SocialProfileLikeModelImpl)socialProfileLike;

		Object[] args = new Object[] {
				socialProfileLike.getSocialNetworkLikeId(),
				socialProfileLike.getSocialNetworkProfileId(),
				socialProfileLike.getSocialNetworkType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
			args);

		if ((socialProfileLikeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					socialProfileLikeModelImpl.getOriginalSocialNetworkLikeId(),
					socialProfileLikeModelImpl.getOriginalSocialNetworkProfileId(),
					socialProfileLikeModelImpl.getOriginalSocialNetworkType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LIKEIDANDSOCIALNETWORKPROFILEID,
				args);
		}
	}

	/**
	 * Creates a new social profile like with the primary key. Does not add the social profile like to the database.
	 *
	 * @param socialProfileLikeId the primary key for the new social profile like
	 * @return the new social profile like
	 */
	@Override
	public SocialProfileLike create(long socialProfileLikeId) {
		SocialProfileLike socialProfileLike = new SocialProfileLikeImpl();

		socialProfileLike.setNew(true);
		socialProfileLike.setPrimaryKey(socialProfileLikeId);

		return socialProfileLike;
	}

	/**
	 * Removes the social profile like with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialProfileLikeId the primary key of the social profile like
	 * @return the social profile like that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike remove(long socialProfileLikeId)
		throws NoSuchSocialProfileLikeException, SystemException {
		return remove((Serializable)socialProfileLikeId);
	}

	/**
	 * Removes the social profile like with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social profile like
	 * @return the social profile like that was removed
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike remove(Serializable primaryKey)
		throws NoSuchSocialProfileLikeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SocialProfileLike socialProfileLike = (SocialProfileLike)session.get(SocialProfileLikeImpl.class,
					primaryKey);

			if (socialProfileLike == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialProfileLikeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(socialProfileLike);
		}
		catch (NoSuchSocialProfileLikeException nsee) {
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
	protected SocialProfileLike removeImpl(SocialProfileLike socialProfileLike)
		throws SystemException {
		socialProfileLike = toUnwrappedModel(socialProfileLike);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialProfileLike)) {
				socialProfileLike = (SocialProfileLike)session.get(SocialProfileLikeImpl.class,
						socialProfileLike.getPrimaryKeyObj());
			}

			if (socialProfileLike != null) {
				session.delete(socialProfileLike);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (socialProfileLike != null) {
			clearCache(socialProfileLike);
		}

		return socialProfileLike;
	}

	@Override
	public SocialProfileLike updateImpl(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike)
		throws SystemException {
		socialProfileLike = toUnwrappedModel(socialProfileLike);

		boolean isNew = socialProfileLike.isNew();

		SocialProfileLikeModelImpl socialProfileLikeModelImpl = (SocialProfileLikeModelImpl)socialProfileLike;

		Session session = null;

		try {
			session = openSession();

			if (socialProfileLike.isNew()) {
				session.save(socialProfileLike);

				socialProfileLike.setNew(false);
			}
			else {
				session.merge(socialProfileLike);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SocialProfileLikeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((socialProfileLikeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						socialProfileLikeModelImpl.getOriginalSocialNetworkProfileId(),
						socialProfileLikeModelImpl.getOriginalSocialNetworkType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALNETWORKPROFILEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID,
					args);

				args = new Object[] {
						socialProfileLikeModelImpl.getSocialNetworkProfileId(),
						socialProfileLikeModelImpl.getSocialNetworkType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SOCIALNETWORKPROFILEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SOCIALNETWORKPROFILEID,
					args);
			}
		}

		EntityCacheUtil.putResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
			SocialProfileLikeImpl.class, socialProfileLike.getPrimaryKey(),
			socialProfileLike);

		clearUniqueFindersCache(socialProfileLike);
		cacheUniqueFindersCache(socialProfileLike);

		return socialProfileLike;
	}

	protected SocialProfileLike toUnwrappedModel(
		SocialProfileLike socialProfileLike) {
		if (socialProfileLike instanceof SocialProfileLikeImpl) {
			return socialProfileLike;
		}

		SocialProfileLikeImpl socialProfileLikeImpl = new SocialProfileLikeImpl();

		socialProfileLikeImpl.setNew(socialProfileLike.isNew());
		socialProfileLikeImpl.setPrimaryKey(socialProfileLike.getPrimaryKey());

		socialProfileLikeImpl.setSocialProfileLikeId(socialProfileLike.getSocialProfileLikeId());
		socialProfileLikeImpl.setSocialNetworkProfileId(socialProfileLike.getSocialNetworkProfileId());
		socialProfileLikeImpl.setName(socialProfileLike.getName());
		socialProfileLikeImpl.setCategory(socialProfileLike.getCategory());
		socialProfileLikeImpl.setSocialNetworkLikeId(socialProfileLike.getSocialNetworkLikeId());
		socialProfileLikeImpl.setSocialNetworkType(socialProfileLike.getSocialNetworkType());
		socialProfileLikeImpl.setSocialNetworkCreateDate(socialProfileLike.getSocialNetworkCreateDate());
		socialProfileLikeImpl.setCreateDate(socialProfileLike.getCreateDate());
		socialProfileLikeImpl.setModifiedDate(socialProfileLike.getModifiedDate());

		return socialProfileLikeImpl;
	}

	/**
	 * Returns the social profile like with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile like
	 * @return the social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialProfileLikeException, SystemException {
		SocialProfileLike socialProfileLike = fetchByPrimaryKey(primaryKey);

		if (socialProfileLike == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialProfileLikeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return socialProfileLike;
	}

	/**
	 * Returns the social profile like with the primary key or throws a {@link com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException} if it could not be found.
	 *
	 * @param socialProfileLikeId the primary key of the social profile like
	 * @return the social profile like
	 * @throws com.sambaash.platform.srv.spsocialprofile.NoSuchSocialProfileLikeException if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike findByPrimaryKey(long socialProfileLikeId)
		throws NoSuchSocialProfileLikeException, SystemException {
		return findByPrimaryKey((Serializable)socialProfileLikeId);
	}

	/**
	 * Returns the social profile like with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social profile like
	 * @return the social profile like, or <code>null</code> if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SocialProfileLike socialProfileLike = (SocialProfileLike)EntityCacheUtil.getResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
				SocialProfileLikeImpl.class, primaryKey);

		if (socialProfileLike == _nullSocialProfileLike) {
			return null;
		}

		if (socialProfileLike == null) {
			Session session = null;

			try {
				session = openSession();

				socialProfileLike = (SocialProfileLike)session.get(SocialProfileLikeImpl.class,
						primaryKey);

				if (socialProfileLike != null) {
					cacheResult(socialProfileLike);
				}
				else {
					EntityCacheUtil.putResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
						SocialProfileLikeImpl.class, primaryKey,
						_nullSocialProfileLike);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SocialProfileLikeModelImpl.ENTITY_CACHE_ENABLED,
					SocialProfileLikeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return socialProfileLike;
	}

	/**
	 * Returns the social profile like with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialProfileLikeId the primary key of the social profile like
	 * @return the social profile like, or <code>null</code> if a social profile like with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SocialProfileLike fetchByPrimaryKey(long socialProfileLikeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)socialProfileLikeId);
	}

	/**
	 * Returns all the social profile likes.
	 *
	 * @return the social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social profile likes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile likes
	 * @param end the upper bound of the range of social profile likes (not inclusive)
	 * @return the range of social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social profile likes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of social profile likes
	 * @param end the upper bound of the range of social profile likes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social profile likes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SocialProfileLike> findAll(int start, int end,
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

		List<SocialProfileLike> list = (List<SocialProfileLike>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOCIALPROFILELIKE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALPROFILELIKE;

				if (pagination) {
					sql = sql.concat(SocialProfileLikeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SocialProfileLike>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SocialProfileLike>(list);
				}
				else {
					list = (List<SocialProfileLike>)QueryUtil.list(q,
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
	 * Removes all the social profile likes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SocialProfileLike socialProfileLike : findAll()) {
			remove(socialProfileLike);
		}
	}

	/**
	 * Returns the number of social profile likes.
	 *
	 * @return the number of social profile likes
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

				Query q = session.createQuery(_SQL_COUNT_SOCIALPROFILELIKE);

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
	 * Initializes the social profile like persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SocialProfileLike>> listenersList = new ArrayList<ModelListener<SocialProfileLike>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SocialProfileLike>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SocialProfileLikeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SOCIALPROFILELIKE = "SELECT socialProfileLike FROM SocialProfileLike socialProfileLike";
	private static final String _SQL_SELECT_SOCIALPROFILELIKE_WHERE = "SELECT socialProfileLike FROM SocialProfileLike socialProfileLike WHERE ";
	private static final String _SQL_COUNT_SOCIALPROFILELIKE = "SELECT COUNT(socialProfileLike) FROM SocialProfileLike socialProfileLike";
	private static final String _SQL_COUNT_SOCIALPROFILELIKE_WHERE = "SELECT COUNT(socialProfileLike) FROM SocialProfileLike socialProfileLike WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "socialProfileLike.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SocialProfileLike exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SocialProfileLike exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SocialProfileLikePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"socialProfileLikeId"
			});
	private static SocialProfileLike _nullSocialProfileLike = new SocialProfileLikeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SocialProfileLike> toCacheModel() {
				return _nullSocialProfileLikeCacheModel;
			}
		};

	private static CacheModel<SocialProfileLike> _nullSocialProfileLikeCacheModel =
		new CacheModel<SocialProfileLike>() {
			@Override
			public SocialProfileLike toEntityModel() {
				return _nullSocialProfileLike;
			}
		};
}