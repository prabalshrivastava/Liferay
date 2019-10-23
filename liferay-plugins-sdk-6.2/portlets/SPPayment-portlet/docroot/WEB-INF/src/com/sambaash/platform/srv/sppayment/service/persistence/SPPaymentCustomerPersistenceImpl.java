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

package com.sambaash.platform.srv.sppayment.service.persistence;

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

import com.sambaash.platform.srv.sppayment.NoSuchCustomerException;
import com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer;
import com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerImpl;
import com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the s p payment customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPPaymentCustomerPersistence
 * @see SPPaymentCustomerUtil
 * @generated
 */
public class SPPaymentCustomerPersistenceImpl extends BasePersistenceImpl<SPPaymentCustomer>
	implements SPPaymentCustomerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SPPaymentCustomerUtil} to access the s p payment customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SPPaymentCustomerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerModelImpl.FINDER_CACHE_ENABLED,
			SPPaymentCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerModelImpl.FINDER_CACHE_ENABLED,
			SPPaymentCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS = new FinderPath(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerModelImpl.FINDER_CACHE_ENABLED,
			SPPaymentCustomerImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmailAddress",
			new String[] { Long.class.getName(), String.class.getName() },
			SPPaymentCustomerModelImpl.GROUPID_COLUMN_BITMASK |
			SPPaymentCustomerModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param emailAddress the email address
	 * @return the matching s p payment customer
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a matching s p payment customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer findByEmailAddress(long groupId,
		String emailAddress) throws NoSuchCustomerException, SystemException {
		SPPaymentCustomer spPaymentCustomer = fetchByEmailAddress(groupId,
				emailAddress);

		if (spPaymentCustomer == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCustomerException(msg.toString());
		}

		return spPaymentCustomer;
	}

	/**
	 * Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param emailAddress the email address
	 * @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer fetchByEmailAddress(long groupId,
		String emailAddress) throws SystemException {
		return fetchByEmailAddress(groupId, emailAddress, true);
	}

	/**
	 * Returns the s p payment customer where groupId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching s p payment customer, or <code>null</code> if a matching s p payment customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer fetchByEmailAddress(long groupId,
		String emailAddress, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, emailAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					finderArgs, this);
		}

		if (result instanceof SPPaymentCustomer) {
			SPPaymentCustomer spPaymentCustomer = (SPPaymentCustomer)result;

			if ((groupId != spPaymentCustomer.getGroupId()) ||
					!Validator.equals(emailAddress,
						spPaymentCustomer.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPPAYMENTCUSTOMER_WHERE);

			query.append(_FINDER_COLUMN_EMAILADDRESS_GROUPID_2);

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

				qPos.add(groupId);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				List<SPPaymentCustomer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SPPaymentCustomerPersistenceImpl.fetchByEmailAddress(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SPPaymentCustomer spPaymentCustomer = list.get(0);

					result = spPaymentCustomer;

					cacheResult(spPaymentCustomer);

					if ((spPaymentCustomer.getGroupId() != groupId) ||
							(spPaymentCustomer.getEmailAddress() == null) ||
							!spPaymentCustomer.getEmailAddress()
												  .equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
							finderArgs, spPaymentCustomer);
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
			return (SPPaymentCustomer)result;
		}
	}

	/**
	 * Removes the s p payment customer where groupId = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param emailAddress the email address
	 * @return the s p payment customer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer removeByEmailAddress(long groupId,
		String emailAddress) throws NoSuchCustomerException, SystemException {
		SPPaymentCustomer spPaymentCustomer = findByEmailAddress(groupId,
				emailAddress);

		return remove(spPaymentCustomer);
	}

	/**
	 * Returns the number of s p payment customers where groupId = &#63; and emailAddress = &#63;.
	 *
	 * @param groupId the group ID
	 * @param emailAddress the email address
	 * @return the number of matching s p payment customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddress(long groupId, String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { groupId, emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPPAYMENTCUSTOMER_WHERE);

			query.append(_FINDER_COLUMN_EMAILADDRESS_GROUPID_2);

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

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_EMAILADDRESS_GROUPID_2 = "spPaymentCustomer.groupId = ? AND ";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "spPaymentCustomer.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "spPaymentCustomer.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(spPaymentCustomer.emailAddress IS NULL OR spPaymentCustomer.emailAddress = '')";

	public SPPaymentCustomerPersistenceImpl() {
		setModelClass(SPPaymentCustomer.class);
	}

	/**
	 * Caches the s p payment customer in the entity cache if it is enabled.
	 *
	 * @param spPaymentCustomer the s p payment customer
	 */
	@Override
	public void cacheResult(SPPaymentCustomer spPaymentCustomer) {
		EntityCacheUtil.putResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerImpl.class, spPaymentCustomer.getPrimaryKey(),
			spPaymentCustomer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
			new Object[] {
				spPaymentCustomer.getGroupId(),
				spPaymentCustomer.getEmailAddress()
			}, spPaymentCustomer);

		spPaymentCustomer.resetOriginalValues();
	}

	/**
	 * Caches the s p payment customers in the entity cache if it is enabled.
	 *
	 * @param spPaymentCustomers the s p payment customers
	 */
	@Override
	public void cacheResult(List<SPPaymentCustomer> spPaymentCustomers) {
		for (SPPaymentCustomer spPaymentCustomer : spPaymentCustomers) {
			if (EntityCacheUtil.getResult(
						SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
						SPPaymentCustomerImpl.class,
						spPaymentCustomer.getPrimaryKey()) == null) {
				cacheResult(spPaymentCustomer);
			}
			else {
				spPaymentCustomer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s p payment customers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SPPaymentCustomerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SPPaymentCustomerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s p payment customer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SPPaymentCustomer spPaymentCustomer) {
		EntityCacheUtil.removeResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerImpl.class, spPaymentCustomer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(spPaymentCustomer);
	}

	@Override
	public void clearCache(List<SPPaymentCustomer> spPaymentCustomers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SPPaymentCustomer spPaymentCustomer : spPaymentCustomers) {
			EntityCacheUtil.removeResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
				SPPaymentCustomerImpl.class, spPaymentCustomer.getPrimaryKey());

			clearUniqueFindersCache(spPaymentCustomer);
		}
	}

	protected void cacheUniqueFindersCache(SPPaymentCustomer spPaymentCustomer) {
		if (spPaymentCustomer.isNew()) {
			Object[] args = new Object[] {
					spPaymentCustomer.getGroupId(),
					spPaymentCustomer.getEmailAddress()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args,
				spPaymentCustomer);
		}
		else {
			SPPaymentCustomerModelImpl spPaymentCustomerModelImpl = (SPPaymentCustomerModelImpl)spPaymentCustomer;

			if ((spPaymentCustomerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spPaymentCustomer.getGroupId(),
						spPaymentCustomer.getEmailAddress()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					args, spPaymentCustomer);
			}
		}
	}

	protected void clearUniqueFindersCache(SPPaymentCustomer spPaymentCustomer) {
		SPPaymentCustomerModelImpl spPaymentCustomerModelImpl = (SPPaymentCustomerModelImpl)spPaymentCustomer;

		Object[] args = new Object[] {
				spPaymentCustomer.getGroupId(),
				spPaymentCustomer.getEmailAddress()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);

		if ((spPaymentCustomerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] {
					spPaymentCustomerModelImpl.getOriginalGroupId(),
					spPaymentCustomerModelImpl.getOriginalEmailAddress()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);
		}
	}

	/**
	 * Creates a new s p payment customer with the primary key. Does not add the s p payment customer to the database.
	 *
	 * @param sPPaymentCustomerId the primary key for the new s p payment customer
	 * @return the new s p payment customer
	 */
	@Override
	public SPPaymentCustomer create(long sPPaymentCustomerId) {
		SPPaymentCustomer spPaymentCustomer = new SPPaymentCustomerImpl();

		spPaymentCustomer.setNew(true);
		spPaymentCustomer.setPrimaryKey(sPPaymentCustomerId);

		return spPaymentCustomer;
	}

	/**
	 * Removes the s p payment customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sPPaymentCustomerId the primary key of the s p payment customer
	 * @return the s p payment customer that was removed
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer remove(long sPPaymentCustomerId)
		throws NoSuchCustomerException, SystemException {
		return remove((Serializable)sPPaymentCustomerId);
	}

	/**
	 * Removes the s p payment customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s p payment customer
	 * @return the s p payment customer that was removed
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer remove(Serializable primaryKey)
		throws NoSuchCustomerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SPPaymentCustomer spPaymentCustomer = (SPPaymentCustomer)session.get(SPPaymentCustomerImpl.class,
					primaryKey);

			if (spPaymentCustomer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spPaymentCustomer);
		}
		catch (NoSuchCustomerException nsee) {
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
	protected SPPaymentCustomer removeImpl(SPPaymentCustomer spPaymentCustomer)
		throws SystemException {
		spPaymentCustomer = toUnwrappedModel(spPaymentCustomer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spPaymentCustomer)) {
				spPaymentCustomer = (SPPaymentCustomer)session.get(SPPaymentCustomerImpl.class,
						spPaymentCustomer.getPrimaryKeyObj());
			}

			if (spPaymentCustomer != null) {
				session.delete(spPaymentCustomer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spPaymentCustomer != null) {
			clearCache(spPaymentCustomer);
		}

		return spPaymentCustomer;
	}

	@Override
	public SPPaymentCustomer updateImpl(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws SystemException {
		spPaymentCustomer = toUnwrappedModel(spPaymentCustomer);

		boolean isNew = spPaymentCustomer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (spPaymentCustomer.isNew()) {
				session.save(spPaymentCustomer);

				spPaymentCustomer.setNew(false);
			}
			else {
				session.merge(spPaymentCustomer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SPPaymentCustomerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
			SPPaymentCustomerImpl.class, spPaymentCustomer.getPrimaryKey(),
			spPaymentCustomer);

		clearUniqueFindersCache(spPaymentCustomer);
		cacheUniqueFindersCache(spPaymentCustomer);

		return spPaymentCustomer;
	}

	protected SPPaymentCustomer toUnwrappedModel(
		SPPaymentCustomer spPaymentCustomer) {
		if (spPaymentCustomer instanceof SPPaymentCustomerImpl) {
			return spPaymentCustomer;
		}

		SPPaymentCustomerImpl spPaymentCustomerImpl = new SPPaymentCustomerImpl();

		spPaymentCustomerImpl.setNew(spPaymentCustomer.isNew());
		spPaymentCustomerImpl.setPrimaryKey(spPaymentCustomer.getPrimaryKey());

		spPaymentCustomerImpl.setSPPaymentCustomerId(spPaymentCustomer.getSPPaymentCustomerId());
		spPaymentCustomerImpl.setEmailAddress(spPaymentCustomer.getEmailAddress());
		spPaymentCustomerImpl.setProviderCustomerId(spPaymentCustomer.getProviderCustomerId());
		spPaymentCustomerImpl.setGroupId(spPaymentCustomer.getGroupId());
		spPaymentCustomerImpl.setCompanyId(spPaymentCustomer.getCompanyId());
		spPaymentCustomerImpl.setUserId(spPaymentCustomer.getUserId());
		spPaymentCustomerImpl.setUserName(spPaymentCustomer.getUserName());
		spPaymentCustomerImpl.setCreateDate(spPaymentCustomer.getCreateDate());
		spPaymentCustomerImpl.setModifiedDate(spPaymentCustomer.getModifiedDate());

		return spPaymentCustomerImpl;
	}

	/**
	 * Returns the s p payment customer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p payment customer
	 * @return the s p payment customer
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerException, SystemException {
		SPPaymentCustomer spPaymentCustomer = fetchByPrimaryKey(primaryKey);

		if (spPaymentCustomer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spPaymentCustomer;
	}

	/**
	 * Returns the s p payment customer with the primary key or throws a {@link com.sambaash.platform.srv.sppayment.NoSuchCustomerException} if it could not be found.
	 *
	 * @param sPPaymentCustomerId the primary key of the s p payment customer
	 * @return the s p payment customer
	 * @throws com.sambaash.platform.srv.sppayment.NoSuchCustomerException if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer findByPrimaryKey(long sPPaymentCustomerId)
		throws NoSuchCustomerException, SystemException {
		return findByPrimaryKey((Serializable)sPPaymentCustomerId);
	}

	/**
	 * Returns the s p payment customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s p payment customer
	 * @return the s p payment customer, or <code>null</code> if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SPPaymentCustomer spPaymentCustomer = (SPPaymentCustomer)EntityCacheUtil.getResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
				SPPaymentCustomerImpl.class, primaryKey);

		if (spPaymentCustomer == _nullSPPaymentCustomer) {
			return null;
		}

		if (spPaymentCustomer == null) {
			Session session = null;

			try {
				session = openSession();

				spPaymentCustomer = (SPPaymentCustomer)session.get(SPPaymentCustomerImpl.class,
						primaryKey);

				if (spPaymentCustomer != null) {
					cacheResult(spPaymentCustomer);
				}
				else {
					EntityCacheUtil.putResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
						SPPaymentCustomerImpl.class, primaryKey,
						_nullSPPaymentCustomer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SPPaymentCustomerModelImpl.ENTITY_CACHE_ENABLED,
					SPPaymentCustomerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spPaymentCustomer;
	}

	/**
	 * Returns the s p payment customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sPPaymentCustomerId the primary key of the s p payment customer
	 * @return the s p payment customer, or <code>null</code> if a s p payment customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SPPaymentCustomer fetchByPrimaryKey(long sPPaymentCustomerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sPPaymentCustomerId);
	}

	/**
	 * Returns all the s p payment customers.
	 *
	 * @return the s p payment customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPaymentCustomer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s p payment customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p payment customers
	 * @param end the upper bound of the range of s p payment customers (not inclusive)
	 * @return the range of s p payment customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPaymentCustomer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s p payment customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s p payment customers
	 * @param end the upper bound of the range of s p payment customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s p payment customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SPPaymentCustomer> findAll(int start, int end,
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

		List<SPPaymentCustomer> list = (List<SPPaymentCustomer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPPAYMENTCUSTOMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPPAYMENTCUSTOMER;

				if (pagination) {
					sql = sql.concat(SPPaymentCustomerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SPPaymentCustomer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SPPaymentCustomer>(list);
				}
				else {
					list = (List<SPPaymentCustomer>)QueryUtil.list(q,
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
	 * Removes all the s p payment customers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SPPaymentCustomer spPaymentCustomer : findAll()) {
			remove(spPaymentCustomer);
		}
	}

	/**
	 * Returns the number of s p payment customers.
	 *
	 * @return the number of s p payment customers
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

				Query q = session.createQuery(_SQL_COUNT_SPPAYMENTCUSTOMER);

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
	 * Initializes the s p payment customer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SPPaymentCustomer>> listenersList = new ArrayList<ModelListener<SPPaymentCustomer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SPPaymentCustomer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SPPaymentCustomerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPPAYMENTCUSTOMER = "SELECT spPaymentCustomer FROM SPPaymentCustomer spPaymentCustomer";
	private static final String _SQL_SELECT_SPPAYMENTCUSTOMER_WHERE = "SELECT spPaymentCustomer FROM SPPaymentCustomer spPaymentCustomer WHERE ";
	private static final String _SQL_COUNT_SPPAYMENTCUSTOMER = "SELECT COUNT(spPaymentCustomer) FROM SPPaymentCustomer spPaymentCustomer";
	private static final String _SQL_COUNT_SPPAYMENTCUSTOMER_WHERE = "SELECT COUNT(spPaymentCustomer) FROM SPPaymentCustomer spPaymentCustomer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spPaymentCustomer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SPPaymentCustomer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SPPaymentCustomer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SPPaymentCustomerPersistenceImpl.class);
	private static SPPaymentCustomer _nullSPPaymentCustomer = new SPPaymentCustomerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SPPaymentCustomer> toCacheModel() {
				return _nullSPPaymentCustomerCacheModel;
			}
		};

	private static CacheModel<SPPaymentCustomer> _nullSPPaymentCustomerCacheModel =
		new CacheModel<SPPaymentCustomer>() {
			@Override
			public SPPaymentCustomer toEntityModel() {
				return _nullSPPaymentCustomer;
			}
		};
}