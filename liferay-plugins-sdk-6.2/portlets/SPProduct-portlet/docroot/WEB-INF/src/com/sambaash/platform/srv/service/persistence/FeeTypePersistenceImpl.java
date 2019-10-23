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

package com.sambaash.platform.srv.service.persistence;

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

import com.sambaash.platform.srv.NoSuchFeeTypeException;
import com.sambaash.platform.srv.model.FeeType;
import com.sambaash.platform.srv.model.impl.FeeTypeImpl;
import com.sambaash.platform.srv.model.impl.FeeTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the fee type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see FeeTypePersistence
 * @see FeeTypeUtil
 * @generated
 */
public class FeeTypePersistenceImpl extends BasePersistenceImpl<FeeType>
	implements FeeTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeeTypeUtil} to access the fee type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeeTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, FeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, FeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MISC = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, FeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMisc",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MISC = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, FeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMisc",
			new String[] { Boolean.class.getName() },
			FeeTypeModelImpl.MISC_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MISC = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMisc",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the fee types where misc = &#63;.
	 *
	 * @param misc the misc
	 * @return the matching fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findByMisc(boolean misc) throws SystemException {
		return findByMisc(misc, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee types where misc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param misc the misc
	 * @param start the lower bound of the range of fee types
	 * @param end the upper bound of the range of fee types (not inclusive)
	 * @return the range of matching fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findByMisc(boolean misc, int start, int end)
		throws SystemException {
		return findByMisc(misc, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee types where misc = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param misc the misc
	 * @param start the lower bound of the range of fee types
	 * @param end the upper bound of the range of fee types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findByMisc(boolean misc, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MISC;
			finderArgs = new Object[] { misc };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MISC;
			finderArgs = new Object[] { misc, start, end, orderByComparator };
		}

		List<FeeType> list = (List<FeeType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FeeType feeType : list) {
				if ((misc != feeType.getMisc())) {
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

			query.append(_SQL_SELECT_FEETYPE_WHERE);

			query.append(_FINDER_COLUMN_MISC_MISC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeeTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(misc);

				if (!pagination) {
					list = (List<FeeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeType>(list);
				}
				else {
					list = (List<FeeType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first fee type in the ordered set where misc = &#63;.
	 *
	 * @param misc the misc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType findByMisc_First(boolean misc,
		OrderByComparator orderByComparator)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = fetchByMisc_First(misc, orderByComparator);

		if (feeType != null) {
			return feeType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("misc=");
		msg.append(misc);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeTypeException(msg.toString());
	}

	/**
	 * Returns the first fee type in the ordered set where misc = &#63;.
	 *
	 * @param misc the misc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fee type, or <code>null</code> if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByMisc_First(boolean misc,
		OrderByComparator orderByComparator) throws SystemException {
		List<FeeType> list = findByMisc(misc, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fee type in the ordered set where misc = &#63;.
	 *
	 * @param misc the misc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType findByMisc_Last(boolean misc,
		OrderByComparator orderByComparator)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = fetchByMisc_Last(misc, orderByComparator);

		if (feeType != null) {
			return feeType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("misc=");
		msg.append(misc);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFeeTypeException(msg.toString());
	}

	/**
	 * Returns the last fee type in the ordered set where misc = &#63;.
	 *
	 * @param misc the misc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fee type, or <code>null</code> if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByMisc_Last(boolean misc,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMisc(misc);

		if (count == 0) {
			return null;
		}

		List<FeeType> list = findByMisc(misc, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fee types before and after the current fee type in the ordered set where misc = &#63;.
	 *
	 * @param spFeeTypeId the primary key of the current fee type
	 * @param misc the misc
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType[] findByMisc_PrevAndNext(long spFeeTypeId, boolean misc,
		OrderByComparator orderByComparator)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = findByPrimaryKey(spFeeTypeId);

		Session session = null;

		try {
			session = openSession();

			FeeType[] array = new FeeTypeImpl[3];

			array[0] = getByMisc_PrevAndNext(session, feeType, misc,
					orderByComparator, true);

			array[1] = feeType;

			array[2] = getByMisc_PrevAndNext(session, feeType, misc,
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

	protected FeeType getByMisc_PrevAndNext(Session session, FeeType feeType,
		boolean misc, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEETYPE_WHERE);

		query.append(_FINDER_COLUMN_MISC_MISC_2);

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
			query.append(FeeTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(misc);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feeType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeeType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fee types where misc = &#63; from the database.
	 *
	 * @param misc the misc
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMisc(boolean misc) throws SystemException {
		for (FeeType feeType : findByMisc(misc, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feeType);
		}
	}

	/**
	 * Returns the number of fee types where misc = &#63;.
	 *
	 * @param misc the misc
	 * @return the number of matching fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMisc(boolean misc) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MISC;

		Object[] finderArgs = new Object[] { misc };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEETYPE_WHERE);

			query.append(_FINDER_COLUMN_MISC_MISC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(misc);

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

	private static final String _FINDER_COLUMN_MISC_MISC_2 = "feeType.misc = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FEETYPENAME = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, FeeTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByFeeTypeName",
			new String[] { String.class.getName() },
			FeeTypeModelImpl.FEETYPENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FEETYPENAME = new FinderPath(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFeeTypeName",
			new String[] { String.class.getName() });

	/**
	 * Returns the fee type where feeTypeName = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchFeeTypeException} if it could not be found.
	 *
	 * @param feeTypeName the fee type name
	 * @return the matching fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType findByFeeTypeName(String feeTypeName)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = fetchByFeeTypeName(feeTypeName);

		if (feeType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("feeTypeName=");
			msg.append(feeTypeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeeTypeException(msg.toString());
		}

		return feeType;
	}

	/**
	 * Returns the fee type where feeTypeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param feeTypeName the fee type name
	 * @return the matching fee type, or <code>null</code> if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByFeeTypeName(String feeTypeName)
		throws SystemException {
		return fetchByFeeTypeName(feeTypeName, true);
	}

	/**
	 * Returns the fee type where feeTypeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param feeTypeName the fee type name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching fee type, or <code>null</code> if a matching fee type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByFeeTypeName(String feeTypeName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { feeTypeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
					finderArgs, this);
		}

		if (result instanceof FeeType) {
			FeeType feeType = (FeeType)result;

			if (!Validator.equals(feeTypeName, feeType.getFeeTypeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FEETYPE_WHERE);

			boolean bindFeeTypeName = false;

			if (feeTypeName == null) {
				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_1);
			}
			else if (feeTypeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_3);
			}
			else {
				bindFeeTypeName = true;

				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFeeTypeName) {
					qPos.add(feeTypeName);
				}

				List<FeeType> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FeeTypePersistenceImpl.fetchByFeeTypeName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FeeType feeType = list.get(0);

					result = feeType;

					cacheResult(feeType);

					if ((feeType.getFeeTypeName() == null) ||
							!feeType.getFeeTypeName().equals(feeTypeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
							finderArgs, feeType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
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
			return (FeeType)result;
		}
	}

	/**
	 * Removes the fee type where feeTypeName = &#63; from the database.
	 *
	 * @param feeTypeName the fee type name
	 * @return the fee type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType removeByFeeTypeName(String feeTypeName)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = findByFeeTypeName(feeTypeName);

		return remove(feeType);
	}

	/**
	 * Returns the number of fee types where feeTypeName = &#63;.
	 *
	 * @param feeTypeName the fee type name
	 * @return the number of matching fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFeeTypeName(String feeTypeName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FEETYPENAME;

		Object[] finderArgs = new Object[] { feeTypeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEETYPE_WHERE);

			boolean bindFeeTypeName = false;

			if (feeTypeName == null) {
				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_1);
			}
			else if (feeTypeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_3);
			}
			else {
				bindFeeTypeName = true;

				query.append(_FINDER_COLUMN_FEETYPENAME_FEETYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFeeTypeName) {
					qPos.add(feeTypeName);
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

	private static final String _FINDER_COLUMN_FEETYPENAME_FEETYPENAME_1 = "feeType.feeTypeName IS NULL";
	private static final String _FINDER_COLUMN_FEETYPENAME_FEETYPENAME_2 = "feeType.feeTypeName = ?";
	private static final String _FINDER_COLUMN_FEETYPENAME_FEETYPENAME_3 = "(feeType.feeTypeName IS NULL OR feeType.feeTypeName = '')";

	public FeeTypePersistenceImpl() {
		setModelClass(FeeType.class);
	}

	/**
	 * Caches the fee type in the entity cache if it is enabled.
	 *
	 * @param feeType the fee type
	 */
	@Override
	public void cacheResult(FeeType feeType) {
		EntityCacheUtil.putResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeImpl.class, feeType.getPrimaryKey(), feeType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
			new Object[] { feeType.getFeeTypeName() }, feeType);

		feeType.resetOriginalValues();
	}

	/**
	 * Caches the fee types in the entity cache if it is enabled.
	 *
	 * @param feeTypes the fee types
	 */
	@Override
	public void cacheResult(List<FeeType> feeTypes) {
		for (FeeType feeType : feeTypes) {
			if (EntityCacheUtil.getResult(
						FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						FeeTypeImpl.class, feeType.getPrimaryKey()) == null) {
				cacheResult(feeType);
			}
			else {
				feeType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fee types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeeTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeeTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fee type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeeType feeType) {
		EntityCacheUtil.removeResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeImpl.class, feeType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(feeType);
	}

	@Override
	public void clearCache(List<FeeType> feeTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FeeType feeType : feeTypes) {
			EntityCacheUtil.removeResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				FeeTypeImpl.class, feeType.getPrimaryKey());

			clearUniqueFindersCache(feeType);
		}
	}

	protected void cacheUniqueFindersCache(FeeType feeType) {
		if (feeType.isNew()) {
			Object[] args = new Object[] { feeType.getFeeTypeName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FEETYPENAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FEETYPENAME, args,
				feeType);
		}
		else {
			FeeTypeModelImpl feeTypeModelImpl = (FeeTypeModelImpl)feeType;

			if ((feeTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FEETYPENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { feeType.getFeeTypeName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FEETYPENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FEETYPENAME,
					args, feeType);
			}
		}
	}

	protected void clearUniqueFindersCache(FeeType feeType) {
		FeeTypeModelImpl feeTypeModelImpl = (FeeTypeModelImpl)feeType;

		Object[] args = new Object[] { feeType.getFeeTypeName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEETYPENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FEETYPENAME, args);

		if ((feeTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FEETYPENAME.getColumnBitmask()) != 0) {
			args = new Object[] { feeTypeModelImpl.getOriginalFeeTypeName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEETYPENAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FEETYPENAME, args);
		}
	}

	/**
	 * Creates a new fee type with the primary key. Does not add the fee type to the database.
	 *
	 * @param spFeeTypeId the primary key for the new fee type
	 * @return the new fee type
	 */
	@Override
	public FeeType create(long spFeeTypeId) {
		FeeType feeType = new FeeTypeImpl();

		feeType.setNew(true);
		feeType.setPrimaryKey(spFeeTypeId);

		return feeType;
	}

	/**
	 * Removes the fee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spFeeTypeId the primary key of the fee type
	 * @return the fee type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType remove(long spFeeTypeId)
		throws NoSuchFeeTypeException, SystemException {
		return remove((Serializable)spFeeTypeId);
	}

	/**
	 * Removes the fee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fee type
	 * @return the fee type that was removed
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType remove(Serializable primaryKey)
		throws NoSuchFeeTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FeeType feeType = (FeeType)session.get(FeeTypeImpl.class, primaryKey);

			if (feeType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feeType);
		}
		catch (NoSuchFeeTypeException nsee) {
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
	protected FeeType removeImpl(FeeType feeType) throws SystemException {
		feeType = toUnwrappedModel(feeType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feeType)) {
				feeType = (FeeType)session.get(FeeTypeImpl.class,
						feeType.getPrimaryKeyObj());
			}

			if (feeType != null) {
				session.delete(feeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feeType != null) {
			clearCache(feeType);
		}

		return feeType;
	}

	@Override
	public FeeType updateImpl(com.sambaash.platform.srv.model.FeeType feeType)
		throws SystemException {
		feeType = toUnwrappedModel(feeType);

		boolean isNew = feeType.isNew();

		FeeTypeModelImpl feeTypeModelImpl = (FeeTypeModelImpl)feeType;

		Session session = null;

		try {
			session = openSession();

			if (feeType.isNew()) {
				session.save(feeType);

				feeType.setNew(false);
			}
			else {
				session.merge(feeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FeeTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((feeTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MISC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { feeTypeModelImpl.getOriginalMisc() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MISC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MISC,
					args);

				args = new Object[] { feeTypeModelImpl.getMisc() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MISC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MISC,
					args);
			}
		}

		EntityCacheUtil.putResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			FeeTypeImpl.class, feeType.getPrimaryKey(), feeType);

		clearUniqueFindersCache(feeType);
		cacheUniqueFindersCache(feeType);

		return feeType;
	}

	protected FeeType toUnwrappedModel(FeeType feeType) {
		if (feeType instanceof FeeTypeImpl) {
			return feeType;
		}

		FeeTypeImpl feeTypeImpl = new FeeTypeImpl();

		feeTypeImpl.setNew(feeType.isNew());
		feeTypeImpl.setPrimaryKey(feeType.getPrimaryKey());

		feeTypeImpl.setSpFeeTypeId(feeType.getSpFeeTypeId());
		feeTypeImpl.setGroupId(feeType.getGroupId());
		feeTypeImpl.setCompanyId(feeType.getCompanyId());
		feeTypeImpl.setUserId(feeType.getUserId());
		feeTypeImpl.setUserName(feeType.getUserName());
		feeTypeImpl.setCreateDate(feeType.getCreateDate());
		feeTypeImpl.setModifiedDate(feeType.getModifiedDate());
		feeTypeImpl.setFeeType(feeType.getFeeType());
		feeTypeImpl.setFeeTypeName(feeType.getFeeTypeName());
		feeTypeImpl.setFeeTypeDesc(feeType.getFeeTypeDesc());
		feeTypeImpl.setMisc(feeType.isMisc());

		return feeTypeImpl;
	}

	/**
	 * Returns the fee type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fee type
	 * @return the fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeeTypeException, SystemException {
		FeeType feeType = fetchByPrimaryKey(primaryKey);

		if (feeType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feeType;
	}

	/**
	 * Returns the fee type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchFeeTypeException} if it could not be found.
	 *
	 * @param spFeeTypeId the primary key of the fee type
	 * @return the fee type
	 * @throws com.sambaash.platform.srv.NoSuchFeeTypeException if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType findByPrimaryKey(long spFeeTypeId)
		throws NoSuchFeeTypeException, SystemException {
		return findByPrimaryKey((Serializable)spFeeTypeId);
	}

	/**
	 * Returns the fee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fee type
	 * @return the fee type, or <code>null</code> if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FeeType feeType = (FeeType)EntityCacheUtil.getResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				FeeTypeImpl.class, primaryKey);

		if (feeType == _nullFeeType) {
			return null;
		}

		if (feeType == null) {
			Session session = null;

			try {
				session = openSession();

				feeType = (FeeType)session.get(FeeTypeImpl.class, primaryKey);

				if (feeType != null) {
					cacheResult(feeType);
				}
				else {
					EntityCacheUtil.putResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						FeeTypeImpl.class, primaryKey, _nullFeeType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeeTypeModelImpl.ENTITY_CACHE_ENABLED,
					FeeTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feeType;
	}

	/**
	 * Returns the fee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spFeeTypeId the primary key of the fee type
	 * @return the fee type, or <code>null</code> if a fee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeeType fetchByPrimaryKey(long spFeeTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spFeeTypeId);
	}

	/**
	 * Returns all the fee types.
	 *
	 * @return the fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fee types
	 * @param end the upper bound of the range of fee types (not inclusive)
	 * @return the range of fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.FeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fee types
	 * @param end the upper bound of the range of fee types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeeType> findAll(int start, int end,
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

		List<FeeType> list = (List<FeeType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEETYPE;

				if (pagination) {
					sql = sql.concat(FeeTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FeeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeeType>(list);
				}
				else {
					list = (List<FeeType>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the fee types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FeeType feeType : findAll()) {
			remove(feeType);
		}
	}

	/**
	 * Returns the number of fee types.
	 *
	 * @return the number of fee types
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

				Query q = session.createQuery(_SQL_COUNT_FEETYPE);

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
	 * Initializes the fee type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.model.FeeType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FeeType>> listenersList = new ArrayList<ModelListener<FeeType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FeeType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeeTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEETYPE = "SELECT feeType FROM FeeType feeType";
	private static final String _SQL_SELECT_FEETYPE_WHERE = "SELECT feeType FROM FeeType feeType WHERE ";
	private static final String _SQL_COUNT_FEETYPE = "SELECT COUNT(feeType) FROM FeeType feeType";
	private static final String _SQL_COUNT_FEETYPE_WHERE = "SELECT COUNT(feeType) FROM FeeType feeType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feeType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FeeType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FeeType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeeTypePersistenceImpl.class);
	private static FeeType _nullFeeType = new FeeTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FeeType> toCacheModel() {
				return _nullFeeTypeCacheModel;
			}
		};

	private static CacheModel<FeeType> _nullFeeTypeCacheModel = new CacheModel<FeeType>() {
			@Override
			public FeeType toEntityModel() {
				return _nullFeeType;
			}
		};
}