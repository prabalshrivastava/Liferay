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

package com.sambaash.platform.srv.extendedprofile.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException;
import com.sambaash.platform.srv.extendedprofile.model.SPCertification;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationImpl;
import com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p certification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPCertificationPersistence
 * @see SPCertificationUtil
 * @generated
 */
public class SPCertificationPersistenceImpl extends BasePersistenceImpl<SPCertification>
	implements SPCertificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPCertificationUtil} to access the s p certification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPCertificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED,
			SPCertificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED,
			SPCertificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID =
		new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED,
			SPCertificationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndCertificationId",
			new String[] { Long.class.getName(), Long.class.getName() },
			SPCertificationModelImpl.USERID_COLUMN_BITMASK |
			SPCertificationModelImpl.CERTIFICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID =
		new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndCertificationId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p certification where userId = &#63; and certificationId = &#63; or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param certificationId the certification ID
	 * @return the matching s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification findByUserIdAndCertificationId(long userId,
		long certificationId)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = fetchByUserIdAndCertificationId(userId,
				certificationId);

		if (spCertification == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", certificationId=");
			msg.append(certificationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSPCertificationException(msg.toString());
		}

		return spCertification;
	}

	/**
	 * Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param certificationId the certification ID
	 * @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByUserIdAndCertificationId(long userId,
		long certificationId) throws SystemException {
		return fetchByUserIdAndCertificationId(userId, certificationId, true);
	}

	/**
	 * Returns the s p certification where userId = &#63; and certificationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param certificationId the certification ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p certification, or <code>null</code> if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByUserIdAndCertificationId(long userId,
		long certificationId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, certificationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
					finderArgs, this);
		}

		if (result instanceof SPCertification) {
			SPCertification spCertification = (SPCertification)result;

			if ((userId != spCertification.getUserId()) ||
					(certificationId != spCertification.getCertificationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPCERTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCERTIFICATIONID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDCERTIFICATIONID_CERTIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(certificationId);

				List<SPCertification> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
						finderArgs, list);
				}
				else {
					SPCertification spCertification = list.get(0);

					result = spCertification;

					cacheResult(spCertification);

					if ((spCertification.getUserId() != userId) ||
							(spCertification.getCertificationId() != certificationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
							finderArgs, spCertification);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
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
			return (SPCertification)result;
		}
	}

	/**
	 * Removes the s p certification where userId = &#63; and certificationId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param certificationId the certification ID
	 * @return the s p certification that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification removeByUserIdAndCertificationId(long userId,
		long certificationId)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = findByUserIdAndCertificationId(userId,
				certificationId);

		return remove(spCertification);
	}

	/**
	 * Returns the number of s p certifications where userId = &#63; and certificationId = &#63;.
	 *
	 * @param userId the user ID
	 * @param certificationId the certification ID
	 * @return the number of matching s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndCertificationId(long userId, long certificationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID;

		Object[] finderArgs = new Object[] { userId, certificationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPCERTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDCERTIFICATIONID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDCERTIFICATIONID_CERTIFICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(certificationId);

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

	private static final String _FINDER_COLUMN_USERIDANDCERTIFICATIONID_USERID_2 =
		"spCertification.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDCERTIFICATIONID_CERTIFICATIONID_2 =
		"spCertification.certificationId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED,
			SPCertificationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED,
			SPCertificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SPCertificationModelImpl.USERID_COLUMN_BITMASK |
			SPCertificationModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the s p certifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p certifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p certifications
	 * @param end the upper bound of the range of s p certifications (not inclusive)
	 * @return the range of matching s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p certifications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of s p certifications
	 * @param end the upper bound of the range of s p certifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SPCertification> list = (List<SPCertification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SPCertification spCertification : list) {
				if ((userId != spCertification.getUserId())) {
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

			query.append(_SQL_SELECT_SPCERTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SPCertificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SPCertification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCertification>(list);
				}
				else {
					list = (List<SPCertification>)QueryUtil.list(q,
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
	 * Returns the first s p certification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = fetchByUserId_First(userId,
				orderByComparator);

		if (spCertification != null) {
			return spCertification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCertificationException(msg.toString());
	}

	/**
	 * Returns the first s p certification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching s p certification, or <code>null</code> if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SPCertification> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last s p certification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = fetchByUserId_Last(userId,
				orderByComparator);

		if (spCertification != null) {
			return spCertification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSPCertificationException(msg.toString());
	}

	/**
	 * Returns the last s p certification in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching s p certification, or <code>null</code> if a matching s p certification could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SPCertification> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the s p certifications before and after the current s p certification in the ordered set where userId = &#63;.
	 *
	 * @param classPk the primary key of the current s p certification
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification[] findByUserId_PrevAndNext(long classPk,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = findByPrimaryKey(classPk);

		Session session = null;

		try {
			session = openSession();

			SPCertification[] array = new SPCertificationImpl[3];

			array[0] = getByUserId_PrevAndNext(session, spCertification,
					userId, orderByComparator, true);

			array[1] = spCertification;

			array[2] = getByUserId_PrevAndNext(session, spCertification,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SPCertification getByUserId_PrevAndNext(Session session,
		SPCertification spCertification, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPCERTIFICATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SPCertificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spCertification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SPCertification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the s p certifications where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SPCertification spCertification : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spCertification);
		}
	}

	/**
	 * Returns the number of s p certifications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPCERTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spCertification.userId = ?";

	public SPCertificationPersistenceImpl() {
		setModelClass(SPCertification.class);
	}

	/**
	 * Caches the s p certification in the entity cache if it is enabled.
	 *
	 * @param spCertification the s p certification
	 */
	@Override
	public void cacheResult(SPCertification spCertification) {
		EntityCacheUtil.putResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationImpl.class, spCertification.getPrimaryKey(),
			spCertification);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
			new Object[] {
				spCertification.getUserId(),
				spCertification.getCertificationId()
			}, spCertification);

		spCertification.resetOriginalValues();
	}

	/**
	 * Caches the s p certifications in the entity cache if it is enabled.
	 *
	 * @param spCertifications the s p certifications
	 */
	@Override
	public void cacheResult(List<SPCertification> spCertifications) {
		for (SPCertification spCertification : spCertifications) {
			if (EntityCacheUtil.getResult(
						SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
						SPCertificationImpl.class,
						spCertification.getPrimaryKey()) == null) {
				cacheResult(spCertification);
			}
			else {
				spCertification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p certifications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPCertificationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPCertificationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p certification.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPCertification spCertification) {
		EntityCacheUtil.removeResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationImpl.class, spCertification.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spCertification);
	}

	@Override
	public void clearCache(List<SPCertification> spCertifications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPCertification spCertification : spCertifications) {
			EntityCacheUtil.removeResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
				SPCertificationImpl.class, spCertification.getPrimaryKey());

			clearUniqueFindersCache(spCertification);
		}
	}

	protected void cacheUniqueFindersCache(SPCertification spCertification) {
		if (spCertification.isNew()) {
			Object[] args = new Object[] {
					spCertification.getUserId(),
					spCertification.getCertificationId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
				args, spCertification);
		}
		else {
			SPCertificationModelImpl spCertificationModelImpl = (SPCertificationModelImpl)spCertification;

			if ((spCertificationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCertification.getUserId(),
						spCertification.getCertificationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
					args, spCertification);
			}
		}
	}

	protected void clearUniqueFindersCache(SPCertification spCertification) {
		SPCertificationModelImpl spCertificationModelImpl = (SPCertificationModelImpl)spCertification;

		Object[] args = new Object[] {
				spCertification.getUserId(),
				spCertification.getCertificationId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
			args);

		if ((spCertificationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spCertificationModelImpl.getOriginalUserId(),
					spCertificationModelImpl.getOriginalCertificationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATIONID,
				args);
		}
	}

	/**
	 * Creates a new s p certification with the primary key. Does not add the s p certification to the database.
	 *
	 * @param classPk the primary key for the new s p certification
	 * @return the new s p certification
	 */
	@Override
	public SPCertification create(long classPk) {
		SPCertification spCertification = new SPCertificationImpl();

		spCertification.setNew(true);
		spCertification.setPrimaryKey(classPk);

		return spCertification;
	}

	/**
	 * Removes the s p certification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classPk the primary key of the s p certification
	 * @return the s p certification that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification remove(long classPk)
		throws NoSuchSPCertificationException, SystemException {
		return remove((Serializable)classPk);
	}

	/**
	 * Removes the s p certification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p certification
	 * @return the s p certification that was removed
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification remove(Serializable primaryKey)
		throws NoSuchSPCertificationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPCertification spCertification = (SPCertification)session.get(SPCertificationImpl.class,
					primaryKey);

			if (spCertification == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSPCertificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spCertification);
		}
		catch (NoSuchSPCertificationException nsee) {
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
	protected SPCertification removeImpl(SPCertification spCertification)
		throws SystemException {
		spCertification = toUnwrappedModel(spCertification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spCertification)) {
				spCertification = (SPCertification)session.get(SPCertificationImpl.class,
						spCertification.getPrimaryKeyObj());
			}

			if (spCertification != null) {
				session.delete(spCertification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spCertification != null) {
			clearCache(spCertification);
		}

		return spCertification;
	}

	@Override
	public SPCertification updateImpl(
		com.sambaash.platform.srv.extendedprofile.model.SPCertification spCertification)
		throws SystemException {
		spCertification = toUnwrappedModel(spCertification);

		boolean isNew = spCertification.isNew();

		SPCertificationModelImpl spCertificationModelImpl = (SPCertificationModelImpl)spCertification;

		Session session = null;

		try {
			session = openSession();

			if (spCertification.isNew()) {
				session.save(spCertification);

				spCertification.setNew(false);
			}
			else {
				session.merge(spCertification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPCertificationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spCertificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spCertificationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { spCertificationModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
			SPCertificationImpl.class, spCertification.getPrimaryKey(),
			spCertification);

		clearUniqueFindersCache(spCertification);
		cacheUniqueFindersCache(spCertification);

		return spCertification;
	}

	protected SPCertification toUnwrappedModel(SPCertification spCertification) {
		if (spCertification instanceof SPCertificationImpl) {
			return spCertification;
		}

		SPCertificationImpl spCertificationImpl = new SPCertificationImpl();

		spCertificationImpl.setNew(spCertification.isNew());
		spCertificationImpl.setPrimaryKey(spCertification.getPrimaryKey());

		spCertificationImpl.setClassPk(spCertification.getClassPk());
		spCertificationImpl.setGroupId(spCertification.getGroupId());
		spCertificationImpl.setCompanyId(spCertification.getCompanyId());
		spCertificationImpl.setUserId(spCertification.getUserId());
		spCertificationImpl.setUserName(spCertification.getUserName());
		spCertificationImpl.setCreateDate(spCertification.getCreateDate());
		spCertificationImpl.setModifiedDate(spCertification.getModifiedDate());
		spCertificationImpl.setCertificationId(spCertification.getCertificationId());

		return spCertificationImpl;
	}

	/**
	 * Returns the s p certification with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p certification
	 * @return the s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSPCertificationException, SystemException {
		SPCertification spCertification = fetchByPrimaryKey(primaryKey);

		if (spCertification == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSPCertificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spCertification;
	}

	/**
	 * Returns the s p certification with the primary key or throws a {@link com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException} if it could not be found.
	 *
	 * @param classPk the primary key of the s p certification
	 * @return the s p certification
	 * @throws com.sambaash.platform.srv.extendedprofile.NoSuchSPCertificationException if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification findByPrimaryKey(long classPk)
		throws NoSuchSPCertificationException, SystemException {
		return findByPrimaryKey((Serializable)classPk);
	}

	/**
	 * Returns the s p certification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p certification
	 * @return the s p certification, or <code>null</code> if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPCertification spCertification = (SPCertification)EntityCacheUtil.getResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
				SPCertificationImpl.class, primaryKey);

		if (spCertification == _nullSPCertification) {
			return null;
		}

		if (spCertification == null) {
			Session session = null;

			try {
				session = openSession();

				spCertification = (SPCertification)session.get(SPCertificationImpl.class,
						primaryKey);

				if (spCertification != null) {
					cacheResult(spCertification);
				}
				else {
					EntityCacheUtil.putResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
						SPCertificationImpl.class, primaryKey,
						_nullSPCertification);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPCertificationModelImpl.ENTITY_CACHE_ENABLED,
					SPCertificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spCertification;
	}

	/**
	 * Returns the s p certification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classPk the primary key of the s p certification
	 * @return the s p certification, or <code>null</code> if a s p certification with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPCertification fetchByPrimaryKey(long classPk)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)classPk);
	}

	/**
	 * Returns all the s p certifications.
	 *
	 * @return the s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p certifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p certifications
	 * @param end the upper bound of the range of s p certifications (not inclusive)
	 * @return the range of s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p certifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.extendedprofile.model.impl.SPCertificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p certifications
	 * @param end the upper bound of the range of s p certifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p certifications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPCertification> findAll(int start, int end,
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

		List<SPCertification> list = (List<SPCertification>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPCERTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPCERTIFICATION;

				if (pagination) {
					sql = sql.concat(SPCertificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPCertification>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPCertification>(list);
				}
				else {
					list = (List<SPCertification>)QueryUtil.list(q,
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
	 * Removes all the s p certifications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPCertification spCertification : findAll()) {
			remove(spCertification);
		}
	}

	/**
	 * Returns the number of s p certifications.
	 *
	 * @return the number of s p certifications
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

				Query q = session.createQuery(_SQL_COUNT_SPCERTIFICATION);

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
	 * Initializes the s p certification persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.extendedprofile.model.SPCertification")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPCertification>> listenersList = new ArrayList<ModelListener<SPCertification>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPCertification>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPCertificationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPCERTIFICATION = "SELECT spCertification FROM SPCertification spCertification";
	private static final String _SQL_SELECT_SPCERTIFICATION_WHERE = "SELECT spCertification FROM SPCertification spCertification WHERE ";
	private static final String _SQL_COUNT_SPCERTIFICATION = "SELECT COUNT(spCertification) FROM SPCertification spCertification";
	private static final String _SQL_COUNT_SPCERTIFICATION_WHERE = "SELECT COUNT(spCertification) FROM SPCertification spCertification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spCertification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPCertification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPCertification exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPCertificationPersistenceImpl.class);
	private static SPCertification _nullSPCertification = new SPCertificationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPCertification> toCacheModel() {
				return _nullSPCertificationCacheModel;
			}
		};

	private static CacheModel<SPCertification> _nullSPCertificationCacheModel = new CacheModel<SPCertification>() {
			@Override
			public SPCertification toEntityModel() {
				return _nullSPCertification;
			}
		};
}