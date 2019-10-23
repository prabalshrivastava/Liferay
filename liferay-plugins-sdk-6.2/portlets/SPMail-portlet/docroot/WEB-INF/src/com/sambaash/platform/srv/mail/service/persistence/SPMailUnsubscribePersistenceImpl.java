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

package com.sambaash.platform.srv.mail.service.persistence;

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

import com.sambaash.platform.srv.mail.NoSuchUnsubscribeException;
import com.sambaash.platform.srv.mail.model.SPMailUnsubscribe;
import com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeImpl;
import com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p mail unsubscribe service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribePersistence
 * @see SPMailUnsubscribeUtil
 * @generated
 */
public class SPMailUnsubscribePersistenceImpl extends BasePersistenceImpl<SPMailUnsubscribe>
	implements SPMailUnsubscribePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPMailUnsubscribeUtil} to access the s p mail unsubscribe persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPMailUnsubscribeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID =
		new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailAddressAndCategoryId",
			new String[] { String.class.getName(), Long.class.getName() },
			SPMailUnsubscribeModelImpl.EMAILADDRESS_COLUMN_BITMASK |
			SPMailUnsubscribeModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID =
		new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailAddressAndCategoryId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @param categoryId the category ID
	 * @return the matching s p mail unsubscribe
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe findByEmailAddressAndCategoryId(
		String emailAddress, long categoryId)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = fetchByEmailAddressAndCategoryId(emailAddress,
				categoryId);

		if (spMailUnsubscribe == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(", categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnsubscribeException(msg.toString());
		}

		return spMailUnsubscribe;
	}

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param categoryId the category ID
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		String emailAddress, long categoryId) throws SystemException {
		return fetchByEmailAddressAndCategoryId(emailAddress, categoryId, true);
	}

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param categoryId the category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByEmailAddressAndCategoryId(
		String emailAddress, long categoryId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress, categoryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof SPMailUnsubscribe) {
			SPMailUnsubscribe spMailUnsubscribe = (SPMailUnsubscribe)result;

			if (!Validator.equals(emailAddress,
						spMailUnsubscribe.getEmailAddress()) ||
					(categoryId != spMailUnsubscribe.getCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPMAILUNSUBSCRIBE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				qPos.add(categoryId);

				List<SPMailUnsubscribe> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailUnsubscribePersistenceImpl.fetchByEmailAddressAndCategoryId(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailUnsubscribe spMailUnsubscribe = list.get(0);

					result = spMailUnsubscribe;

					cacheResult(spMailUnsubscribe);

					if ((spMailUnsubscribe.getEmailAddress() == null) ||
							!spMailUnsubscribe.getEmailAddress()
												  .equals(emailAddress) ||
							(spMailUnsubscribe.getCategoryId() != categoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
							finderArgs, spMailUnsubscribe);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
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
			return (SPMailUnsubscribe)result;
		}
	}

	/**
	 * Removes the s p mail unsubscribe where emailAddress = &#63; and categoryId = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @param categoryId the category ID
	 * @return the s p mail unsubscribe that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe removeByEmailAddressAndCategoryId(
		String emailAddress, long categoryId)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = findByEmailAddressAndCategoryId(emailAddress,
				categoryId);

		return remove(spMailUnsubscribe);
	}

	/**
	 * Returns the number of s p mail unsubscribes where emailAddress = &#63; and categoryId = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param categoryId the category ID
	 * @return the number of matching s p mail unsubscribes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddressAndCategoryId(String emailAddress,
		long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID;

		Object[] finderArgs = new Object[] { emailAddress, categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPMAILUNSUBSCRIBE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_2);
			}

			query.append(_FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_1 =
		"spMailUnsubscribe.emailAddress IS NULL AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_2 =
		"spMailUnsubscribe.emailAddress = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_EMAILADDRESS_3 =
		"(spMailUnsubscribe.emailAddress IS NULL OR spMailUnsubscribe.emailAddress = '') AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESSANDCATEGORYID_CATEGORYID_2 =
		"spMailUnsubscribe.categoryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailAddress", new String[] { String.class.getName() },
			SPMailUnsubscribeModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p mail unsubscribe
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe findByEmailAddress(String emailAddress)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = fetchByEmailAddress(emailAddress);

		if (spMailUnsubscribe == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnsubscribeException(msg.toString());
		}

		return spMailUnsubscribe;
	}

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByEmailAddress(String emailAddress)
		throws SystemException {
		return fetchByEmailAddress(emailAddress, true);
	}

	/**
	 * Returns the s p mail unsubscribe where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByEmailAddress(String emailAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					finderArgs, this);
		}

		if (result instanceof SPMailUnsubscribe) {
			SPMailUnsubscribe spMailUnsubscribe = (SPMailUnsubscribe)result;

			if (!Validator.equals(emailAddress,
						spMailUnsubscribe.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILUNSUBSCRIBE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				List<SPMailUnsubscribe> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailUnsubscribePersistenceImpl.fetchByEmailAddress(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailUnsubscribe spMailUnsubscribe = list.get(0);

					result = spMailUnsubscribe;

					cacheResult(spMailUnsubscribe);

					if ((spMailUnsubscribe.getEmailAddress() == null) ||
							!spMailUnsubscribe.getEmailAddress()
												  .equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
							finderArgs, spMailUnsubscribe);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
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
			return (SPMailUnsubscribe)result;
		}
	}

	/**
	 * Removes the s p mail unsubscribe where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the s p mail unsubscribe that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe removeByEmailAddress(String emailAddress)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = findByEmailAddress(emailAddress);

		return remove(spMailUnsubscribe);
	}

	/**
	 * Returns the number of s p mail unsubscribes where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching s p mail unsubscribes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPMAILUNSUBSCRIBE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "spMailUnsubscribe.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "spMailUnsubscribe.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(spMailUnsubscribe.emailAddress IS NULL OR spMailUnsubscribe.emailAddress = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId", new String[] { Long.class.getName() },
			SPMailUnsubscribeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the s p mail unsubscribe where userId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching s p mail unsubscribe
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe findByUserId(long userId)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = fetchByUserId(userId);

		if (spMailUnsubscribe == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnsubscribeException(msg.toString());
		}

		return spMailUnsubscribe;
	}

	/**
	 * Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByUserId(long userId)
		throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the s p mail unsubscribe where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p mail unsubscribe, or <code>null</code> if a matching s p mail unsubscribe could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByUserId(long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof SPMailUnsubscribe) {
			SPMailUnsubscribe spMailUnsubscribe = (SPMailUnsubscribe)result;

			if ((userId != spMailUnsubscribe.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPMAILUNSUBSCRIBE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<SPMailUnsubscribe> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPMailUnsubscribePersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPMailUnsubscribe spMailUnsubscribe = list.get(0);

					result = spMailUnsubscribe;

					cacheResult(spMailUnsubscribe);

					if ((spMailUnsubscribe.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, spMailUnsubscribe);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
			return (SPMailUnsubscribe)result;
		}
	}

	/**
	 * Removes the s p mail unsubscribe where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the s p mail unsubscribe that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe removeByUserId(long userId)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = findByUserId(userId);

		return remove(spMailUnsubscribe);
	}

	/**
	 * Returns the number of s p mail unsubscribes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching s p mail unsubscribes
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

			query.append(_SQL_COUNT_SPMAILUNSUBSCRIBE_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "spMailUnsubscribe.userId = ?";

	public SPMailUnsubscribePersistenceImpl() {
		setModelClass(SPMailUnsubscribe.class);
	}

	/**
	 * Caches the s p mail unsubscribe in the entity cache if it is enabled.
	 *
	 * @param spMailUnsubscribe the s p mail unsubscribe
	 */
	@Override
	public void cacheResult(SPMailUnsubscribe spMailUnsubscribe) {
		EntityCacheUtil.putResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, spMailUnsubscribe.getPrimaryKey(),
			spMailUnsubscribe);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
			new Object[] {
				spMailUnsubscribe.getEmailAddress(),
				spMailUnsubscribe.getCategoryId()
			}, spMailUnsubscribe);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
			new Object[] { spMailUnsubscribe.getEmailAddress() },
			spMailUnsubscribe);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { spMailUnsubscribe.getUserId() }, spMailUnsubscribe);

		spMailUnsubscribe.resetOriginalValues();
	}

	/**
	 * Caches the s p mail unsubscribes in the entity cache if it is enabled.
	 *
	 * @param spMailUnsubscribes the s p mail unsubscribes
	 */
	@Override
	public void cacheResult(List<SPMailUnsubscribe> spMailUnsubscribes) {
		for (SPMailUnsubscribe spMailUnsubscribe : spMailUnsubscribes) {
			if (EntityCacheUtil.getResult(
						SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
						SPMailUnsubscribeImpl.class,
						spMailUnsubscribe.getPrimaryKey()) == null) {
				cacheResult(spMailUnsubscribe);
			}
			else {
				spMailUnsubscribe.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p mail unsubscribes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPMailUnsubscribeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPMailUnsubscribeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p mail unsubscribe.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPMailUnsubscribe spMailUnsubscribe) {
		EntityCacheUtil.removeResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, spMailUnsubscribe.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spMailUnsubscribe);
	}

	@Override
	public void clearCache(List<SPMailUnsubscribe> spMailUnsubscribes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPMailUnsubscribe spMailUnsubscribe : spMailUnsubscribes) {
			EntityCacheUtil.removeResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
				SPMailUnsubscribeImpl.class, spMailUnsubscribe.getPrimaryKey());

			clearUniqueFindersCache(spMailUnsubscribe);
		}
	}

	protected void cacheUniqueFindersCache(SPMailUnsubscribe spMailUnsubscribe) {
		if (spMailUnsubscribe.isNew()) {
			Object[] args = new Object[] {
					spMailUnsubscribe.getEmailAddress(),
					spMailUnsubscribe.getCategoryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
				args, spMailUnsubscribe);

			args = new Object[] { spMailUnsubscribe.getEmailAddress() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args,
				spMailUnsubscribe);

			args = new Object[] { spMailUnsubscribe.getUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				spMailUnsubscribe);
		}
		else {
			SPMailUnsubscribeModelImpl spMailUnsubscribeModelImpl = (SPMailUnsubscribeModelImpl)spMailUnsubscribe;

			if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spMailUnsubscribe.getEmailAddress(),
						spMailUnsubscribe.getCategoryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
					args, spMailUnsubscribe);
			}

			if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailUnsubscribe.getEmailAddress() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					args, spMailUnsubscribe);
			}

			if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { spMailUnsubscribe.getUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					spMailUnsubscribe);
			}
		}
	}

	protected void clearUniqueFindersCache(SPMailUnsubscribe spMailUnsubscribe) {
		SPMailUnsubscribeModelImpl spMailUnsubscribeModelImpl = (SPMailUnsubscribeModelImpl)spMailUnsubscribe;

		Object[] args = new Object[] {
				spMailUnsubscribe.getEmailAddress(),
				spMailUnsubscribe.getCategoryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
			args);

		if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailUnsubscribeModelImpl.getOriginalEmailAddress(),
					spMailUnsubscribeModelImpl.getOriginalCategoryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESSANDCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESSANDCATEGORYID,
				args);
		}

		args = new Object[] { spMailUnsubscribe.getEmailAddress() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);

		if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] {
					spMailUnsubscribeModelImpl.getOriginalEmailAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);
		}

		args = new Object[] { spMailUnsubscribe.getUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((spMailUnsubscribeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { spMailUnsubscribeModelImpl.getOriginalUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new s p mail unsubscribe with the primary key. Does not add the s p mail unsubscribe to the database.
	 *
	 * @param spMailUnsubscribeId the primary key for the new s p mail unsubscribe
	 * @return the new s p mail unsubscribe
	 */
	@Override
	public SPMailUnsubscribe create(long spMailUnsubscribeId) {
		SPMailUnsubscribe spMailUnsubscribe = new SPMailUnsubscribeImpl();

		spMailUnsubscribe.setNew(true);
		spMailUnsubscribe.setPrimaryKey(spMailUnsubscribeId);

		return spMailUnsubscribe;
	}

	/**
	 * Removes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe remove(long spMailUnsubscribeId)
		throws NoSuchUnsubscribeException, SystemException {
		return remove((Serializable)spMailUnsubscribeId);
	}

	/**
	 * Removes the s p mail unsubscribe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe that was removed
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe remove(Serializable primaryKey)
		throws NoSuchUnsubscribeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPMailUnsubscribe spMailUnsubscribe = (SPMailUnsubscribe)session.get(SPMailUnsubscribeImpl.class,
					primaryKey);

			if (spMailUnsubscribe == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnsubscribeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spMailUnsubscribe);
		}
		catch (NoSuchUnsubscribeException nsee) {
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
	protected SPMailUnsubscribe removeImpl(SPMailUnsubscribe spMailUnsubscribe)
		throws SystemException {
		spMailUnsubscribe = toUnwrappedModel(spMailUnsubscribe);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spMailUnsubscribe)) {
				spMailUnsubscribe = (SPMailUnsubscribe)session.get(SPMailUnsubscribeImpl.class,
						spMailUnsubscribe.getPrimaryKeyObj());
			}

			if (spMailUnsubscribe != null) {
				session.delete(spMailUnsubscribe);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spMailUnsubscribe != null) {
			clearCache(spMailUnsubscribe);
		}

		return spMailUnsubscribe;
	}

	@Override
	public SPMailUnsubscribe updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailUnsubscribe spMailUnsubscribe)
		throws SystemException {
		spMailUnsubscribe = toUnwrappedModel(spMailUnsubscribe);

		boolean isNew = spMailUnsubscribe.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spMailUnsubscribe.isNew()) {
				session.save(spMailUnsubscribe);

				spMailUnsubscribe.setNew(false);
			}
			else {
				session.merge(spMailUnsubscribe);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPMailUnsubscribeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
			SPMailUnsubscribeImpl.class, spMailUnsubscribe.getPrimaryKey(),
			spMailUnsubscribe);

		clearUniqueFindersCache(spMailUnsubscribe);
		cacheUniqueFindersCache(spMailUnsubscribe);

		return spMailUnsubscribe;
	}

	protected SPMailUnsubscribe toUnwrappedModel(
		SPMailUnsubscribe spMailUnsubscribe) {
		if (spMailUnsubscribe instanceof SPMailUnsubscribeImpl) {
			return spMailUnsubscribe;
		}

		SPMailUnsubscribeImpl spMailUnsubscribeImpl = new SPMailUnsubscribeImpl();

		spMailUnsubscribeImpl.setNew(spMailUnsubscribe.isNew());
		spMailUnsubscribeImpl.setPrimaryKey(spMailUnsubscribe.getPrimaryKey());

		spMailUnsubscribeImpl.setSpMailUnsubscribeId(spMailUnsubscribe.getSpMailUnsubscribeId());
		spMailUnsubscribeImpl.setCategoryId(spMailUnsubscribe.getCategoryId());
		spMailUnsubscribeImpl.setUserId(spMailUnsubscribe.getUserId());
		spMailUnsubscribeImpl.setEmailAddress(spMailUnsubscribe.getEmailAddress());
		spMailUnsubscribeImpl.setUnsubscribeDate(spMailUnsubscribe.getUnsubscribeDate());

		return spMailUnsubscribeImpl;
	}

	/**
	 * Returns the s p mail unsubscribe with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnsubscribeException, SystemException {
		SPMailUnsubscribe spMailUnsubscribe = fetchByPrimaryKey(primaryKey);

		if (spMailUnsubscribe == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnsubscribeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spMailUnsubscribe;
	}

	/**
	 * Returns the s p mail unsubscribe with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchUnsubscribeException} if it could not be found.
	 *
	 * @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe
	 * @throws com.sambaash.platform.srv.mail.NoSuchUnsubscribeException if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe findByPrimaryKey(long spMailUnsubscribeId)
		throws NoSuchUnsubscribeException, SystemException {
		return findByPrimaryKey((Serializable)spMailUnsubscribeId);
	}

	/**
	 * Returns the s p mail unsubscribe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe, or <code>null</code> if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPMailUnsubscribe spMailUnsubscribe = (SPMailUnsubscribe)EntityCacheUtil.getResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
				SPMailUnsubscribeImpl.class, primaryKey);

		if (spMailUnsubscribe == _nullSPMailUnsubscribe) {
			return null;
		}

		if (spMailUnsubscribe == null) {
			Session session = null;

			try {
				session = openSession();

				spMailUnsubscribe = (SPMailUnsubscribe)session.get(SPMailUnsubscribeImpl.class,
						primaryKey);

				if (spMailUnsubscribe != null) {
					cacheResult(spMailUnsubscribe);
				}
				else {
					EntityCacheUtil.putResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
						SPMailUnsubscribeImpl.class, primaryKey,
						_nullSPMailUnsubscribe);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPMailUnsubscribeModelImpl.ENTITY_CACHE_ENABLED,
					SPMailUnsubscribeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spMailUnsubscribe;
	}

	/**
	 * Returns the s p mail unsubscribe with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spMailUnsubscribeId the primary key of the s p mail unsubscribe
	 * @return the s p mail unsubscribe, or <code>null</code> if a s p mail unsubscribe with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPMailUnsubscribe fetchByPrimaryKey(long spMailUnsubscribeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)spMailUnsubscribeId);
	}

	/**
	 * Returns all the s p mail unsubscribes.
	 *
	 * @return the s p mail unsubscribes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailUnsubscribe> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p mail unsubscribes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail unsubscribes
	 * @param end the upper bound of the range of s p mail unsubscribes (not inclusive)
	 * @return the range of s p mail unsubscribes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailUnsubscribe> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p mail unsubscribes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailUnsubscribeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p mail unsubscribes
	 * @param end the upper bound of the range of s p mail unsubscribes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p mail unsubscribes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPMailUnsubscribe> findAll(int start, int end,
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

		List<SPMailUnsubscribe> list = (List<SPMailUnsubscribe>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPMAILUNSUBSCRIBE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPMAILUNSUBSCRIBE;

				if (pagination) {
					sql = sql.concat(SPMailUnsubscribeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPMailUnsubscribe>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPMailUnsubscribe>(list);
				}
				else {
					list = (List<SPMailUnsubscribe>)QueryUtil.list(q,
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
	 * Removes all the s p mail unsubscribes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPMailUnsubscribe spMailUnsubscribe : findAll()) {
			remove(spMailUnsubscribe);
		}
	}

	/**
	 * Returns the number of s p mail unsubscribes.
	 *
	 * @return the number of s p mail unsubscribes
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

				Query q = session.createQuery(_SQL_COUNT_SPMAILUNSUBSCRIBE);

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
	 * Initializes the s p mail unsubscribe persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.mail.model.SPMailUnsubscribe")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPMailUnsubscribe>> listenersList = new ArrayList<ModelListener<SPMailUnsubscribe>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPMailUnsubscribe>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPMailUnsubscribeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPMAILUNSUBSCRIBE = "SELECT spMailUnsubscribe FROM SPMailUnsubscribe spMailUnsubscribe";
	private static final String _SQL_SELECT_SPMAILUNSUBSCRIBE_WHERE = "SELECT spMailUnsubscribe FROM SPMailUnsubscribe spMailUnsubscribe WHERE ";
	private static final String _SQL_COUNT_SPMAILUNSUBSCRIBE = "SELECT COUNT(spMailUnsubscribe) FROM SPMailUnsubscribe spMailUnsubscribe";
	private static final String _SQL_COUNT_SPMAILUNSUBSCRIBE_WHERE = "SELECT COUNT(spMailUnsubscribe) FROM SPMailUnsubscribe spMailUnsubscribe WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spMailUnsubscribe.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPMailUnsubscribe exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPMailUnsubscribe exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPMailUnsubscribePersistenceImpl.class);
	private static SPMailUnsubscribe _nullSPMailUnsubscribe = new SPMailUnsubscribeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPMailUnsubscribe> toCacheModel() {
				return _nullSPMailUnsubscribeCacheModel;
			}
		};

	private static CacheModel<SPMailUnsubscribe> _nullSPMailUnsubscribeCacheModel =
		new CacheModel<SPMailUnsubscribe>() {
			@Override
			public SPMailUnsubscribe toEntityModel() {
				return _nullSPMailUnsubscribe;
			}
		};
}